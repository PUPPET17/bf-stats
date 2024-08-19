package com.puppet17.bfstats.controller;

import com.puppet17.bfstats.po.PlayerStats;
import com.puppet17.bfstats.service.stats.StatsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author PUPPET17
 * @version 1.0
 * @date 2024/1/5
 */
@Controller
public class ApiController {

    private final StatsService statsService;

    public ApiController(StatsService statsService) {
        this.statsService = statsService;
    }

    @GetMapping("/playerStats/{version}/{name}")
    public String getPlayerStats(@PathVariable String name, @PathVariable String version, Model model) {
        PlayerStats playerStats = statsService.getPlayerStatsAsEntity(name,version);
       
        if (playerStats == null || playerStats.getSecondsPlayed() == 0 ){
            return "error";
        }
        playerStats = statsService.checkAndSavePlayerStat(playerStats,version);
        model.addAttribute("playerStats", playerStats);
        return "playerStats";
    }
    
    @GetMapping("/allStats/{version}/{name}")
    public String getAllStats(@PathVariable String name, @PathVariable String version, Model model) {
        List<PlayerStats> playerStats = statsService.getPlayerAllStats(name,version);
        if (playerStats.isEmpty()) {
            return "error";
        }
        
        model.addAttribute("playerStatsSize", playerStats.size());
        model.addAttribute("playerStats", playerStats);
        model.addAttribute("divIndexes", IntStream.range(0, playerStats.size()).boxed().collect(Collectors.toList()));
        return "allStats";
    }

}

