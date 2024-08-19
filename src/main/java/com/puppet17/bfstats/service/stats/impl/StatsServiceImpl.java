package com.puppet17.bfstats.service.stats.impl;

import com.google.gson.Gson;
import com.puppet17.bfstats.commons.BattlefieldVersion;
import com.puppet17.bfstats.po.PlayerStats;
import com.puppet17.bfstats.service.stats.StatsService;
import com.puppet17.bfstats.utils.http.HttpCurl;
import com.puppet17.bfstats.utils.redis.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import static java.util.Locale.ENGLISH;

/**
 * @author PUPPET17
 * @version 1.0
 * @date 2024/1/6
 */
@Service
public class StatsServiceImpl implements StatsService {

    @Resource
    private RedisUtil redisUtil;

    private final Logger logger = LoggerFactory.getLogger(StatsServiceImpl.class);

    private final Gson gson = new Gson();

    /**
     * Gets player stats.
     *
     * @param name the name
     * @return the player stats
     */
    @Override
    public PlayerStats getPlayerStatsAsEntity(String name, String versionName) {
        BattlefieldVersion version = BattlefieldVersion.fromString(versionName);
        String url = version.getUrl() + name;
        logger.info("Request URL: '{}'" , url);

        String statData = Objects.requireNonNull(HttpCurl.request(url)).toString();
        logger.info("Stat Data: '{}'" , statData);
        return gson.fromJson(statData, PlayerStats.class);
    }
    
    @Override
    public PlayerStats checkAndSavePlayerStat(PlayerStats newStat, String version) {
        
        String userName = StringUtils.toLowerCase(newStat.getUserName(), ENGLISH);
        String redisKey = userName + ":" + version;
        
        long size = redisUtil.lGetListSize(redisKey);
        if (size > 0) {
            List<Object> playerStats = redisUtil.rangeList(redisKey, 0, -1);
            for (Object stat : playerStats) {
                PlayerStats realStat = (PlayerStats) stat;
                if (Objects.equals(realStat.getTimePlayed(), newStat.getTimePlayed())) {
                    return realStat;
                }
            }
        }
        
        redisUtil.lSet(redisKey, newStat);
        
        while (redisUtil.lGetListSize(redisKey) > 10) {
            redisUtil.lRemove(redisKey, 1, redisUtil.rangeList(redisKey, 0, 0).get(0));
        }
        
        return newStat;
    }
    
    @Override
    public List<PlayerStats> getPlayerAllStats(String userName ,String version) {
        
        List<?> objects = redisUtil.lGet(userName + ":" + version, 0, -1);
        return objects.stream()
                .map(o -> (PlayerStats) o)
                .collect(Collectors.toList());
    }
}
