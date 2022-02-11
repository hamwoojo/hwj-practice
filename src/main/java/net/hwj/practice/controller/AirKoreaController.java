package net.hwj.practice.controller;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import net.hwj.practice.model.Api;
import net.hwj.practice.model.ApiInterface;
import net.hwj.practice.model.airkorea.Tdw_Msrstn_Info;
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
            log.info("result : " + result);
            log.info("totalcount : " + totalcount);

            if(items.size() > 0){
                for(int i=0; i < items.size(); i++ ){
                    Tdw_Msrstn_Info tdw_msrstn_info = createObject(items.get(i).getAsJsonObject().toString(),Tdw_Msrstn_Info.class);
                    //Tdw_Msrstn_Info tdw_msrstn_info = gson.fromJson(items.get(i).getAsJsonObject().toString(),Tdw_Msrstn_Info.class);
                    tdwMsrstnInfoList.add(tdw_msrstn_info);
                    count ++;
                }
/**** ITEMS 한꺼번에 가져오는 방법 ****/
//                List<Tdw_Msrstn_Info> tdw_msrstn_infos = (List<Tdw_Msrstn_Info>) getList(jsonitem,Tdw_Msrstn_Info.class);
//                tdw_msrstn_infos.forEach(tdw_msrstn_info -> {
//                    tdwMsrstnInfoList.add(tdw_msrstn_info);
//                });
//                log.info("SIZE : " + tdw_msrstn_infos.size());
//                count = count + tdw_msrstn_infos.size();
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

    public <T> T createObject(String jsonitem, Class<T> clazz){
        Gson gson = new Gson();
        return gson.fromJson(jsonitem, clazz);

    }
    public <T> T getList(String jsonArray, Class<T> clazz){

        Type typeOfT = TypeToken.getParameterized(List.class, clazz).getType();
        return new Gson().fromJson(jsonArray, typeOfT);
    }

}
