package com.puppet17.bfstats.utils.http;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author xyx
 * @date 2024/4/27
 */
public class HttpCurl {

    public static HttpResponse curlGet(String url) throws IOException {
        HttpClient httpClient = HttpClients.createDefault();

        HttpGet request = new HttpGet(url);
        request.addHeader("accept", "application/json");
        return httpClient.execute(request);
    }

    public static JsonObject request(String url) {

        try {
            HttpResponse httpResponse = HttpCurl.curlGet(url);
            Gson gson = new Gson();
            return gson.fromJson(EntityUtils.toString(httpResponse.getEntity()), JsonObject.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
