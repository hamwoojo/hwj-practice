package net.hwj.practice.controller;


import com.google.gson.*;
import lombok.extern.slf4j.Slf4j;
import net.hwj.practice.model.*;
import net.hwj.practice.repository.ApiRepository;
import net.hwj.practice.repository.TnDataBassInfoRepository;
import net.hwj.practice.service.AirKoreaService;
import net.hwj.practice.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/airkorea")
@CrossOrigin
public class AirKoreaController extends CommonController{
    @Autowired
    TnDataBassInfoRepository tnDataBassInfoRepository;

    @Autowired
    ApiInterface apiInterface;
    @Autowired
    AirKoreaService airKoreaService;

    @GetMapping(value = "/tdw_msrstn_info", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Tdw_msrstn_info> tdw_msrstn_info() throws IOException {
        final String tb_nm = "tdw_msrstn_info";
        int offset = 1;
        int count = 0;
        String page = "pageNo";
        String perPage = "numofRows";
        List<Tdw_msrstn_info> tdwMsrstnInfoList = new ArrayList<>();
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneByInnerClctTblPhysiclNm(tb_nm);
        log.info(tn_data_bass_info.getData_link_url());
        while(true) {
            JsonObject result = airKoreaService.getJsonResult(tn_data_bass_info.getData_link_url(),page,perPage,offset);
            int totalcount = airKoreaService.getTotal(result);
            JsonArray items = airKoreaService.getItems(result);

            if(items.size() > 0){
                for(int i=0; i < items.size(); i++ ){
                    Tdw_msrstn_info tdw_msrstn_info = createObject(items.get(i).getAsJsonObject().toString(), Tdw_msrstn_info.class);
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
        List<Tn_data_bass_info> Tn_data_bass_infolist = tnDataBassInfoRepository.findAllByInnerClctTblPhysiclNm(tb_nm);

        if(Tn_data_bass_infolist.size() > 0 ){
            for(int i=0; i<Tn_data_bass_infolist.size(); i++){
                offset = 1;
                count = 0;
                while(true) {
                    JsonObject result = airKoreaService.getJsonResult(Tn_data_bass_infolist.get(i).getData_link_url(),page,perPage,offset);
                    int totalcount = airKoreaService.getTotal(result);
                    JsonArray items = airKoreaService.getItems(result);

                    if(items.size() > 0){
                        for(int j=0; j < items.size(); j++ ){
                            Tdw_arpltn_msrstn_rltm_mesure_info tdw_arpltn_msrstn_rltm_mesure_info = createObject(items.get(j).getAsJsonObject().toString(), Tdw_arpltn_msrstn_rltm_mesure_info.class);
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

        List<Tn_data_bass_info> tn_data_bass_infolist = tnDataBassInfoRepository.findAllByInnerClctTblPhysiclNm(tb_nm);

        if(tn_data_bass_infolist.size() > 0 ){
            for(int i=0; i<tn_data_bass_infolist.size(); i++){
                offset = 1;
                count = 0;
                while(true) {
                    JsonObject result = airKoreaService.getJsonResult(tn_data_bass_infolist.get(i).getData_link_url()+todayParameter,page,perPage,offset);
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

        List<Tn_data_bass_info> tn_data_bass_infoList = tnDataBassInfoRepository.findAllByInnerClctTblPhysiclNm(tb_nm);

        if(tn_data_bass_infoList.size() > 0 ){
            for(int i=0; i<tn_data_bass_infoList.size(); i++){
                offset = 1;
                count = 0;
                while(true) {
                    JsonObject result = airKoreaService.getJsonResult(tn_data_bass_infoList.get(i).getData_link_url()+monthParameter,page,perPage,offset);
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


    @GetMapping(value = "/common", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> common(@RequestParam(value = "tb_nm") String tb_nm) throws IOException, ClassNotFoundException {

        Class clazz = Class.forName("net.hwj.practice.model." + tb_nm.substring(0, 1).toUpperCase()+tb_nm.substring(1).toLowerCase());
        log.info(clazz.getCanonicalName());
        List<Object> classList = new ArrayList<>();
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneByInnerClctTblPhysiclNm(tb_nm);
        log.info(tn_data_bass_info.getData_link_url());
        JsonObject result = airKoreaService.getJsonResult(tn_data_bass_info.getData_link_url());
        JsonArray items = airKoreaService.getItems(result);
        if (items.size() > 0) {
            for (int i = 0; i < items.size(); i++) {
                Object clazzz = createObject(items.get(i).getAsJsonObject().toString(), clazz);
                classList.add(clazzz);
            }
        }
        return classList;
    }


}
