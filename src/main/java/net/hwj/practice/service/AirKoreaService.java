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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
        log.info(sb.toString());

        ResponseBody responseBody = apiInterface.getUrl(sb.toString()).execute().body();
        String jsonString = responseBody.string();
        JsonObject jsonResult = new JsonParser().parse(jsonString).getAsJsonObject();
        return jsonResult;

    }

    public JsonObject getJsonResult(String url) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(url);

        log.info(sb.toString());

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

    public String getYesterday() {
        LocalDate now = LocalDate.now().minusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        return now.format(formatter);
    }

    public String makeDayParameter(String inqBginDt, String inqEndDt) {
        StringBuilder sb = new StringBuilder();
        sb.append("&").append("inqBginDt").append("=").append(inqBginDt);
        sb.append("&").append("inqEndDt").append("=").append(inqEndDt);
        return sb.toString();
    }

    public String makeMonthParameter(String inqBginMm, String inqEndMm) {
        StringBuilder sb = new StringBuilder();
        sb.append("&").append("inqBginMm").append("=").append(inqBginMm);
        sb.append("&").append("inqEndMm").append("=").append(inqEndMm);
        return sb.toString();
    }

    public String getBeforeMonth() {
        LocalDate now = LocalDate.now().minusMonths(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMM");

        return now.format(formatter);

    }
}
