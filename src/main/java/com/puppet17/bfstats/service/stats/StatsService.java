package com.puppet17.bfstats.service.stats;

import com.puppet17.bfstats.commons.BattlefieldVersion;
import com.puppet17.bfstats.po.PlayerStats;

import java.util.List;

/**
 * The interface Bf 1 stats service.
 *
 * @author PUPPET17
 * @version 1.0
 * @date 2024 /1/5
 */
public interface StatsService {

    /**
     * Gets player stats.
     *
     * @param name     the name
     * @param playerId the player id
     * @return the player stats
     */
    PlayerStats getPlayerStatsAsEntity(String name, String versionName);

    /**
     * 查看redis中是否已经有玩家的stats
     * 如果有，则拿出然后与前查出的stats对比,如果游玩时间相同则直接返回数据
     * 如果游玩时间不同，则新增一条数据，并一直保证redis中最多有10条同一个玩家的数据
     *
     * @param newStat the new stat
     * @return the player stats
     */
    PlayerStats checkAndSavePlayerStat(PlayerStats newStat,String version);
    
    List<PlayerStats> getPlayerAllStats(String userName,String version);
    
}
