package com.puppet17.bfstats.service.userInfo.impl;

import com.google.gson.Gson;
import com.puppet17.bfstats.po.PlayerForm;
import com.puppet17.bfstats.service.userInfo.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.puppet17.bfstats.utils.http.HttpCurl.getJsonObject;

/**
 * The type User info service.
 *
 * @author PUPPET17
 * @version 1.0
 * @date 2024 /1/5
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    private Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    private Gson gson = new Gson();

    @Override
    public PlayerForm getPlayerInfoAsEntity(String name) {
        String url = "https://api.gametools.network/bf1/player/?name=" +
                name + "&platform=pc&skip_battlelog=false";
        logger.info("Request URL: '{}'" , url);

        String playerInfo =  Objects.requireNonNull(getJsonObject(url)).toString();
        logger.info("Player Info: '{}'" , playerInfo);

        return gson.fromJson(playerInfo, PlayerForm.class);
    }

}
