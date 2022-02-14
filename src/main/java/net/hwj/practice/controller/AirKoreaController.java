package net.hwj.practice.controller;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import net.hwj.practice.model.Api;
import net.hwj.practice.model.ApiInterface;
import net.hwj.practice.model.airkorea.Tdw_Msrstn_Info;
import net.hwj.practice.model.airkorea.Tdw_arpltn_msrstn_rltm_mesure_info;
import net.hwj.practice.model.airkorea.Tdw_arpltn_stats_msrstn_rltm_daly_avrg_info;
import net.hwj.practice.model.airkorea.Tdw_arpltn_stats_msrstn_rltm_mnby_avrg_info;
import net.hwj.practice.repository.ApiRepository;
import net.hwj.practice.service.AirKoreaService;
import net.hwj.practice.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/airkorea")
@CrossOrigin
public class AirKoreaController {
    @Autowired
    ApiService apiService;
    @Autowired
    ApiRepository apiRepository;
    @Autowired
    ApiInterface apiInterface;
    @Autowired
    AirKoreaService airKoreaService;

    @GetMapping(value = "/tdw_msrstn_info", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Tdw_Msrstn_Info> tdw_msrstn_info() throws IOException {
        final String tb_nm = "tdw_msrstn_info";
        int offset = 1;
        int count = 0;
        String page = "pageNo";
        String perPage = "numofRows";
        List<Tdw_Msrstn_Info> tdwMsrstnInfoList = new ArrayList<>();
        Api api = apiRepository.findOneByTbnm(tb_nm);
        log.info(api.getURL());
        while(true) {
            JsonObject result = airKoreaService.getJsonResult(api.getURL(),page,perPage,offset);
            int totalcount = airKoreaService.getTotal(result);
            JsonArray items = airKoreaService.getItems(result);

            if(items.size() > 0){
                for(int i=0; i < items.size(); i++ ){
                    Tdw_Msrstn_Info tdw_msrstn_info = createObject(items.get(i).getAsJsonObject().toString(),Tdw_Msrstn_Info.class);
                    //Tdw_Msrstn_Info tdw_msrstn_info = gson.fromJson(items.get(i).getAsJsonObject().toString(),Tdw_Msrstn_Info.class);
                    tdwMsrstnInfoList.add(tdw_msrstn_info);
                    count ++;
                }
            }
            if(count == totalcount){
                break;
            }
            else {
                offset ++;
            }
        }
        return tdwMsrstnInfoList;
    }

    @GetMapping(value = "/tdw_arpltn_msrstn_rltm_mesure_info", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Tdw_arpltn_msrstn_rltm_mesure_info> tdw_arpltn_msrstn_rltm_mesure_info() throws IOException {
        final String tb_nm = "tdw_arpltn_msrstn_rltm_mesure_info";
        int offset = 1;
        int count = 0;
        String page = "pageNo";
        String perPage = "numofRows";
        List<Tdw_arpltn_msrstn_rltm_mesure_info> tdw_arpltn_msrstn_rltm_mesure_info_list =  new ArrayList<>();
        //Api api = apiRepository.findOneByTbnm(tb_nm);
        List<Api> apiList = apiRepository.findAllByTbnm(tb_nm);

        if(apiList.size() > 0 ){
            for(int i=0; i<apiList.size(); i++){
                offset = 1;
                count = 0;
                while(true) {
                    JsonObject result = airKoreaService.getJsonResult(apiList.get(i).getURL(),page,perPage,offset);
                    int totalcount = airKoreaService.getTotal(result);
                    JsonArray items = airKoreaService.getItems(result);

                    if(items.size() > 0){
                        for(int j=0; j < items.size(); j++ ){
                            Tdw_arpltn_msrstn_rltm_mesure_info tdw_arpltn_msrstn_rltm_mesure_info = createObject(items.get(j).getAsJsonObject().toString(),Tdw_arpltn_msrstn_rltm_mesure_info.class);
                            tdw_arpltn_msrstn_rltm_mesure_info_list.add(tdw_arpltn_msrstn_rltm_mesure_info);
                            count ++;
                        }
                    }
                    if(count == totalcount){
                        log.info("total : " + totalcount);
                        break;
                    }
                    else {
                        offset ++;
                    }
                }
            }

        }

        return tdw_arpltn_msrstn_rltm_mesure_info_list;
    }


    @GetMapping(value = "/tdw_arpltn_stats_msrstn_rltm_daly_avrg_info", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Tdw_arpltn_stats_msrstn_rltm_daly_avrg_info> tdw_arpltn_stats_msrstn_rltm_daly_avrg_info() throws IOException{
        final String tb_nm = "tdw_arpltn_stats_msrstn_rltm_daly_avrg_info";
        int offset = 1;
        int count = 0;
        String page = "pageNo";
        String perPage = "numofRows";
        String inqBginDt = airKoreaService.getYesterday();
        String inqEndDt = inqBginDt;
        String todayParameter = airKoreaService.makeDayParameter(inqBginDt,inqEndDt);
        List<Tdw_arpltn_stats_msrstn_rltm_daly_avrg_info> tdw_arpltn_stats_msrstn_rltm_daly_avrg_info_list =  new ArrayList<>();

        List<Api> apiList = apiRepository.findAllByTbnm(tb_nm);

        if(apiList.size() > 0 ){
            for(int i=0; i<apiList.size(); i++){
                offset = 1;
                count = 0;
                while(true) {
                    JsonObject result = airKoreaService.getJsonResult(apiList.get(i).getURL()+todayParameter,page,perPage,offset);
                    int totalcount = airKoreaService.getTotal(result);
                    JsonArray items = airKoreaService.getItems(result);

                    if(items.size() > 0){
                        for(int j=0; j < items.size(); j++ ){
                            Tdw_arpltn_stats_msrstn_rltm_daly_avrg_info tdw_arpltn_stats_msrstn_rltm_daly_avrg_info
                                    = createObject(items.get(j).getAsJsonObject().toString(),
                                      Tdw_arpltn_stats_msrstn_rltm_daly_avrg_info.class);
                            tdw_arpltn_stats_msrstn_rltm_daly_avrg_info_list.add(tdw_arpltn_stats_msrstn_rltm_daly_avrg_info);
                            count ++;
                        }
                    }
                    if(count == totalcount){
                        log.info("total : " + totalcount);
                        break;
                    }
                    else {
                        offset ++;
                    }
                }
            }
        }
        return tdw_arpltn_stats_msrstn_rltm_daly_avrg_info_list;
    }

    @GetMapping(value = "/tdw_arpltn_stats_msrstn_rltm_mnby_avrg_info", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Tdw_arpltn_stats_msrstn_rltm_mnby_avrg_info> tdw_arpltn_stats_msrstn_rltm_mnby_avrg_info() throws IOException{
        final String tb_nm = "tdw_arpltn_stats_msrstn_rltm_mnby_avrg_info";
        int offset = 1;
        int count = 0;
        String page = "pageNo";
        String perPage = "numofRows";
        String inqBginMm = airKoreaService.getBeforeMonth();
        String inqEndMm = inqBginMm;
        String monthParameter = airKoreaService.makeMonthParameter(inqBginMm,inqEndMm);
        List<Tdw_arpltn_stats_msrstn_rltm_mnby_avrg_info> tdw_arpltn_stats_msrstn_rltm_mnby_avrg_info_list =  new ArrayList<>();

        List<Api> apiList = apiRepository.findAllByTbnm(tb_nm);

        if(apiList.size() > 0 ){
            for(int i=0; i<apiList.size(); i++){
                offset = 1;
                count = 0;
                while(true) {
                    JsonObject result = airKoreaService.getJsonResult(apiList.get(i).getURL()+monthParameter,page,perPage,offset);
                    int totalcount = airKoreaService.getTotal(result);
                    JsonArray items = airKoreaService.getItems(result);

                    if(items.size() > 0){
                        for(int j=0; j < items.size(); j++ ){
                            Tdw_arpltn_stats_msrstn_rltm_mnby_avrg_info tdw_arpltn_stats_msrstn_rltm_mnby_avrg_info
                                    = createObject(items.get(j).getAsJsonObject().toString(),
                                    Tdw_arpltn_stats_msrstn_rltm_mnby_avrg_info.class);
                            tdw_arpltn_stats_msrstn_rltm_mnby_avrg_info_list.add(tdw_arpltn_stats_msrstn_rltm_mnby_avrg_info);
                            count ++;
                        }
                    }
                    if(count == totalcount){
                        log.info("total : " + totalcount);
                        break;
                    }
                    else {
                        offset ++;
                    }
                }
            }
        }
        return tdw_arpltn_stats_msrstn_rltm_mnby_avrg_info_list;
    }


    public <T> T createObject(String jsonitem, Class<T> clazz){
        Gson gson = new Gson();
        return gson.fromJson(jsonitem, clazz);

    }

//    public <T> T getList(String jsonArray, Class<T> clazz){
//
//        Type typeOfT = TypeToken.getParameterized(List.class, clazz).getType();
//        return new Gson().fromJson(jsonArray, typeOfT);
//    }

}
