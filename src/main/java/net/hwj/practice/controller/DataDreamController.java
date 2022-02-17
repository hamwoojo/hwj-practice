package net.hwj.practice.controller;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import net.hwj.practice.model.Api;
import net.hwj.practice.model.ApiInterface;
import net.hwj.practice.model.DataDream.Tdw_gg_relif_sttus;
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

@Slf4j
@RestController
@RequestMapping("/airkorea")
@CrossOrigin
public class DataDreamController {
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
        int pageIndex = 1;
        int perPageSize = 1000;
        List<Tdw_gg_relif_sttus> tdwGgRelifSttusList = new ArrayList<>();
        Api api = apiRepository.findOneByTbnm(tb_nm);
        int count = 0;

        while(true) {
            JsonObject result = datadreamService.getJsonResult(api.getURL(),pageIndex,perPageSize);
            int totalcount = datadreamService.getTotal(result); //24500
            int paging = totalcount / perPageSize +1; // 25
            System.out.println(paging);
            JsonArray items = datadreamService.getItems(result);
            System.out.println(items.size());

            if(items.size() > 0){
                for (int i = 0; i < items.size(); i++) {
                    Tdw_gg_relif_sttus tdw_gg_relif_sttus = createObject(items.get(i).getAsJsonObject().toString(), Tdw_gg_relif_sttus.class);
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
