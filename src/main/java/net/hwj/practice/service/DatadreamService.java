package net.hwj.practice.service;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import net.hwj.practice.model.ApiInterface;
import net.hwj.practice.repository.ApiRepository;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Slf4j
@Service
public class DatadreamService implements CommonInterface{
    @Autowired
    ApiRepository apiRepository;
    @Autowired
    ApiInterface apiInterface;

    public JsonObject getJsonResult(String url, int pageIndex, int perPageSize) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        sb.append("&").append("pIndex").append("=").append(pageIndex);
        sb.append("&").append("pSize").append("=").append(perPageSize);
        log.info(sb.toString());

        ResponseBody responseBody = apiInterface.getUrl(sb.toString()).execute().body();
        String jsonString = responseBody.string();
        JsonObject jsonResult = new JsonParser().parse(jsonString).getAsJsonObject();
        return jsonResult;

    }

    @Override
    public <T> T createObject(String jsonitem, Class<T> clazz) {
        return new Gson().fromJson(jsonitem,clazz);
    }

    @Override
    public JsonObject getJsonResult(String url, String page, String perPage, int offset) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        sb.append("&").append("pIndex").append("=").append(page);
        sb.append("&").append("pSize").append("=").append(perPage);
        log.info(sb.toString());

        ResponseBody responseBody = apiInterface.getUrl(sb.toString()).execute().body();
        String jsonString = responseBody.string();
        JsonObject jsonResult = new JsonParser().parse(jsonString).getAsJsonObject();
        return jsonResult;
    }

    @Override
    public JsonObject getJsonResult(String url) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(url);

        ResponseBody responseBody = apiInterface.getUrl(sb.toString()).execute().body();
        String jsonString = responseBody.string();
        JsonObject jsonResult = new JsonParser().parse(jsonString).getAsJsonObject();
        return jsonResult;
    }

    public int getTotal(JsonObject result) {
        return result.get("ReliefAction").getAsJsonArray().get(0).getAsJsonObject().get("head").getAsJsonArray().get(0).getAsJsonObject().get("list_total_count").getAsInt();
    }

    public String getList(JsonObject result) {
        System.out.println(result.get("ReliefAction").getAsJsonArray().get(0).getClass().getName());
        JsonObject jsonArray = result.get("ReliefAction").getAsJsonArray().get(0).getAsJsonObject();
        String jsonString = jsonArray.get("head").getAsJsonArray().get(0).getAsJsonObject().get("list_total_count").getAsString();
        return jsonString;
    }

    public JsonArray getItems(JsonObject result) {
        //System.out.println(result.get("ReliefAction").getAsJsonArray().get(0).getAsJsonArray());
        return result.get("ReliefAction").getAsJsonArray().get(1).getAsJsonObject().get("row").getAsJsonArray();
    }
}
