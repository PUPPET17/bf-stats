package com.puppet17.bfstats.service.stats.impl;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.puppet17.bfstats.service.stats.Bf1StatsService;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author PUPPET17
 * @version 1.0
 * @date 2024/1/6
 */
@Service
public class Bf1StatsServiceImpl implements Bf1StatsService {

    @Override
    public String getPlayerStats(String name, String playerId) {
        HttpClient httpClient = HttpClients.createDefault();

        // 完整的url: https://api.gametools.network/bf1/stats/?format_values=true&name=iiTzArcur&playerid=794397421&oid=2800753812&platform=pc&skip_battlelog=false&lang=en-us
        // 根据传入的 name 和 playerId 构建 API 调用的 URL
        String url = "https://api.gametools.network/bf1/stats/?format_values=true"
                + "&name=" + name
                + "&playerid=" + playerId
                + "&oid=2800753812&platform=pc&skip_battlelog=false&lang=zh-tw";

        HttpGet request = new HttpGet(url);
        request.addHeader("accept", "application/json");

        try {
            HttpResponse response = httpClient.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();

            if (statusCode == 200) {
                Gson gson = new Gson();
                JsonObject json = gson.fromJson(EntityUtils.toString(response.getEntity()), JsonObject.class);
                return json.toString();
            } else {
                return "Error occurred while fetching player stats. Status Code: " + statusCode;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error occurred while fetching player stats: " + e.getMessage();
        }
    }

}
