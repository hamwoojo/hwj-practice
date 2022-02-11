package net.hwj.practice.service;

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

@Slf4j
@Service
public class AirKoreaService {
    @Autowired
    ApiRepository apiRepository;
    @Autowired
    ApiInterface apiInterface;

    public JsonObject getJsonResult(String url,String page,String perPage,int offset) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        sb.append("&").append(page).append("=").append(offset);
        sb.append("&").append(perPage).append("=10");

        ResponseBody responseBody = apiInterface.getUrl(sb.toString()).execute().body();
        String jsonString = responseBody.string();
        JsonObject jsonResult = new JsonParser().parse(jsonString).getAsJsonObject();
        return jsonResult;

    }

    public int getTotal(JsonObject result) {
        return result.get("response").getAsJsonObject().get("body").getAsJsonObject().get("totalCount").getAsInt();
    }

    public JsonArray getItems(JsonObject result) {
        return result.get("response").getAsJsonObject().get("body").getAsJsonObject().get("items").getAsJsonArray();
    }

}
