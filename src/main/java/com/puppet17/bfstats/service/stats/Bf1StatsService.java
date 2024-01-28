package com.puppet17.bfstats.service.stats;

import com.google.gson.JsonObject;
import com.puppet17.bfstats.pojo.PlayerStats;
import org.springframework.http.ResponseEntity;

/**
 * The interface Bf 1 stats service.
 *
 * @author PUPPET17
 * @version 1.0
 * @date 2024 /1/5
 */
public interface Bf1StatsService {

    /**
     * Gets player stats.
     *
     * @param name     the name
     * @param playerId the player id
     * @return the player stats
     */
    PlayerStats getPlayerStatsAsEntity(String name);

}
