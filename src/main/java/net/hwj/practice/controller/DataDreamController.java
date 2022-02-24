package net.hwj.practice.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import net.hwj.practice.model.Api;
import net.hwj.practice.model.ApiInterface;
import net.hwj.practice.model.Tdw_gg_relif_sttus;
import net.hwj.practice.model.Tn_data_bass_info;
import net.hwj.practice.repository.ApiRepository;
import net.hwj.practice.service.ApiService;
import net.hwj.practice.service.DatadreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/datadream")
@CrossOrigin
public class DataDreamController extends CommonController {
    @Autowired
    ApiService apiService;
    @Autowired
    ApiRepository apiRepository;
    @Autowired
    ApiInterface apiInterface;
    @Autowired
    DatadreamService datadreamService;

    @GetMapping(value = "/tdw_gg_relif_sttus", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Tdw_gg_relif_sttus> tdw_gg_relif_sttus() throws IOException {
        final String tb_nm = "tdw_gg_relif_sttus";
        int pageIndex = 20;
        int perPageSize = 1000;
        List<Tdw_gg_relif_sttus> tdwGgRelifSttusList = new ArrayList<>();
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneByInnerClctTblPhysiclNm(tb_nm);
        log.info(tn_data_bass_info.getData_link_url());
        int count = 0;

        while(true) {
            JsonObject result = datadreamService.getJsonResult(tn_data_bass_info.getData_link_url(),pageIndex,perPageSize);
            log.info("URL : " + tn_data_bass_info.getData_link_url());
            int totalcount = datadreamService.getTotal(result); //24500
            int paging = totalcount / perPageSize +1; // 25
            JsonArray items = datadreamService.getItems(result);

            if(items.size() > 0){
                for (int i = 0; i < items.size(); i++) {
                    Tdw_gg_relif_sttus tdw_gg_relif_sttus = datadreamService.createObject(items.get(i).getAsJsonObject().toString(), Tdw_gg_relif_sttus.class);
                    tdwGgRelifSttusList.add(tdw_gg_relif_sttus);
                }
            }
            if(pageIndex == paging){
                break;
            }
            else{
                pageIndex ++;
            }
        }
        return tdwGgRelifSttusList;
    }


    @Override
    @GetMapping(value = "/common")
    public List<Object> common(String tb_nm) throws ClassNotFoundException, IOException {

        Class clazz = Class.forName("net.hwj.practice.model." + tb_nm.substring(0, 1).toUpperCase()+tb_nm.substring(1).toLowerCase());

        List<Object> classList = new ArrayList<>();
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneByInnerClctTblPhysiclNm(tb_nm);

        /**** json 받아와서 list로 변환하는 부분 ****/
        JsonObject result = datadreamService.getJsonResult(tn_data_bass_info.getData_link_url());
        JsonArray items = datadreamService.getItems(result);
        if (items.size() > 0) {
            for (int i = 0; i < items.size(); i++) {
                Object item = datadreamService.createObject(items.get(i).getAsJsonObject().toString(), clazz);
                classList.add(item);
            }
        }

        return classList;

    }
}
