package com.puppet17.bfstats.controller;

import com.puppet17.bfstats.pojo.PlayerForm;
import com.puppet17.bfstats.pojo.PlayerStats;
import com.puppet17.bfstats.service.stats.Bf1StatsService;
import com.puppet17.bfstats.service.userInfo.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author PUPPET17
 * @version 1.0
 * @date 2024/1/5
 */
@Controller
public class ApiController {

    private final UserInfoService userInfoService;
    private final Bf1StatsService bf1StatsService;

    @Autowired
    public ApiController(UserInfoService userInfoService,Bf1StatsService bf1StatsService) {
        this.userInfoService = userInfoService;
        this.bf1StatsService = bf1StatsService;
    }

    @GetMapping("/playerInfo/{name}")
    public String getPlayerInfoPage(@PathVariable String name, Model model) {
        PlayerForm playerForm = userInfoService.getPlayerInfoAsEntity(name);
        if (playerForm != null) {
            model.addAttribute("playerForm", playerForm);
        }else {
            return "error";
        }
        return "playerInfo";
    }

    @GetMapping("/playerStats/{name}")
    public String getPlayerStats(@PathVariable String name, Model model) {
        PlayerStats playerStats = bf1StatsService.getPlayerStatsAsEntity(name);
        if (null!=playerStats){
            model.addAttribute("playerStats",playerStats);
            return "playerStats";
        }else {
            return "error";
        }
    }

}

