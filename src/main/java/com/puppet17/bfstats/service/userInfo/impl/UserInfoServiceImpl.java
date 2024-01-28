package com.puppet17.bfstats.service.userInfo.impl;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.puppet17.bfstats.pojo.PlayerForm;
import com.puppet17.bfstats.service.userInfo.UserInfoService;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * The type User info service.
 *
 * @author PUPPET17
 * @version 1.0
 * @date 2024 /1/5
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    private Gson gson = new Gson();

    @Override
    public PlayerForm getPlayerInfoAsEntity(String name) {
        String playerData = getPlayerInfo(name);
        return gson.fromJson(playerData, PlayerForm.class);
    }

    public String getPlayerInfo(String name) {
        HttpClient httpClient = HttpClients.createDefault();
        // 完整的urL https://api.gametools.network/bf1/player/?name=17puppet&platform=pc&skip_battlelog=false
        String url = "https://api.gametools.network/bf1/player/?name=" +
                     name + "&platform=pc&skip_battlelog=false";
        HttpGet request = new HttpGet(url);
        request.addHeader("accept", "application/json");
        try {
            HttpResponse response = httpClient.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                return EntityUtils.toString(response.getEntity());
            } else {
                return "Error occurred while fetching player information. Status Code: " + statusCode;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error occurred while fetching player information: " + e.getMessage();
        }
    }
}
