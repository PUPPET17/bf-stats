package com.puppet17.bfstats.controller;

import com.puppet17.bfstats.po.PlayerForm;
import com.puppet17.bfstats.po.PlayerStats;
import com.puppet17.bfstats.service.stats.StatsService;
import com.puppet17.bfstats.service.userInfo.UserInfoService;
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

    private UserInfoService userInfoService;
    private StatsService statsService;

    public ApiController(UserInfoService userInfoService, StatsService statsService) {
        this.userInfoService = userInfoService;
        this.statsService = statsService;
    }

    @GetMapping("/playerInfo/{name}")
    public String getPlayerInfoPage(@PathVariable String name, Model model) {
        PlayerForm playerForm = userInfoService.getPlayerInfoAsEntity(name);
        if (playerForm != null) {
            model.addAttribute("playerForm", playerForm);
            return "playerInfo";
        }else {
            return "error";
        }
    }

    @GetMapping("/playerStats/{name}")
    public String getPlayerStats(@PathVariable String name, Model model) {
        PlayerStats playerStats = statsService.getPlayerStatsAsEntity(name);
        if (playerStats == null) {
            return "error";
        }
        if (playerStats.getSecondsPlayed() != 0){
            playerStats = statsService.checkAndSavePlayerStat(playerStats);
        }

        model.addAttribute("playerStats", playerStats);
        return "playerStats";
    }
    
    @GetMapping("/allStats/{name}")
    public String getAllStats(@PathVariable String name, Model model) {
        List<PlayerStats> playerStats = statsService.getPlayerAllStats(name);
        if (playerStats.isEmpty()) {
            return "error";
        }
        
        model.addAttribute("playerStatsSize", playerStats.size());
        model.addAttribute("playerStats", playerStats);
        model.addAttribute("divIndexes", IntStream.range(0, playerStats.size()).boxed().collect(Collectors.toList()));
        return "allStats";
    }

}

