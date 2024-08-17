package com.puppet17.bfstats.service.stats.impl;

import com.google.gson.Gson;
import com.puppet17.bfstats.po.PlayerStats;
import com.puppet17.bfstats.service.stats.StatsService;
import com.puppet17.bfstats.utils.redis.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.puppet17.bfstats.utils.http.HttpCurl.getJsonObject;
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
    public PlayerStats getPlayerStatsAsEntity(String name) {
        String url = "https://api.gametools.network/bf1/all/?format_values=true"
                + "&name=" + name
                + "&platform=pc&skip_battlelog=false&lang=en-us";
        logger.info("Request URL: '{}'" , url);

        String statData = Objects.requireNonNull(getJsonObject(url)).toString();
        logger.info("Stat Data: '{}'" , statData);
        return gson.fromJson(statData, PlayerStats.class);
    }

    @Override
    public PlayerStats checkAndSavePlayerStat(PlayerStats newStat) {
        String userName = newStat.getUserName();
        userName = StringUtils.toLowerCase(userName, ENGLISH);
        long size = redisUtil.lGetListSize(userName);
        if (size > 0) {
            List<Object> playerStats = redisUtil.rangeList(userName, 0, -1);
            
            for (Object stat : playerStats) {
                PlayerStats realStat = (PlayerStats) stat;
                if (Objects.equals(realStat.getTimePlayed(), newStat.getTimePlayed())) {
                    return realStat;
                }
            }
        }
        
        redisUtil.lSet(userName, newStat);
        
        while (redisUtil.lGetListSize(userName) > 10) {
            redisUtil.lRemove("userName", 1,userName);
        }
        
        return newStat;
    }
    
    @Override
    public List<PlayerStats> getPlayerAllStats(String userName) {
        
        List<?> objects = redisUtil.lGet(userName, 0, -1);
        return objects.stream()
                .map(o -> (PlayerStats) o)
                .collect(Collectors.toList());
    }
}
