package net.hwj.practice.controller;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import net.hwj.practice.model.Api;
import net.hwj.practice.model.ApiInterface;
import net.hwj.practice.model.airkorea.Tdw_Msrstn_Info;
import net.hwj.practice.model.data.MappingInfos;
import net.hwj.practice.repository.ApiRepository;
import net.hwj.practice.service.ApiService;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
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

    @GetMapping(value = "/tdw_msrstn_info", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Tdw_Msrstn_Info> tdw_msrstn_info() throws IOException {
        //MappingInfos mappingInfos = parseXmlToMappingInfosObject("mapper/tdw_msrstn_info.xml");
        final String tb_nm = "tdw_msrstn_info";
        int offset = 1;
        int count = 0;
        List<Tdw_Msrstn_Info> tdwMsrstnInfoList = new ArrayList<>();
        while(true) {
            Api api = apiRepository.findOneByTbnm(tb_nm);
            log.info(api.getURL());
            ResponseBody responseBody = apiInterface.getUrl(api.getURL()+"&pageNo="+offset+"&numOfRows=1").execute().body();
            String resultJson = responseBody.string();
            JsonObject result = new JsonParser().parse(resultJson).getAsJsonObject();
            log.info("result : " + result);
            JsonObject total = result.get("response").getAsJsonObject().get("body").getAsJsonObject();
            log.info("total : " + total);
            int totalcount = total.get("totalCount").getAsInt();
            log.info("totalcount : " + totalcount);

            JsonArray items = total.get("items").getAsJsonArray();
            log.info("items : " + items);

            if(items.size() > 0){
                for(int i=0; i < items.size(); i++ ){
                    Tdw_Msrstn_Info tdw_msrstn_info = createObject(items.get(i).getAsJsonObject());
                    log.info("stationName : " + tdw_msrstn_info.getStationName());
                    log.info("Addr : " + tdw_msrstn_info.getAddr());
                    //log.info("Clt_sn : " + tdw_msrstn_info.getClt_sn());
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
    public MappingInfos parseXmlToMappingInfosObject(String fileName) {
        log.info("Join parseXmlToMappingInfosObject!!");
        MappingInfos mappingInfos = new MappingInfos();
        try {
            File file = new File(fileName);
            JAXBContext jaxbContext = JAXBContext.newInstance(MappingInfos.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            mappingInfos = (MappingInfos) jaxbUnmarshaller.unmarshal(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mappingInfos;
    }
    public Tdw_Msrstn_Info createObject(JsonObject jsonitem){
        String stringItem = jsonitem.toString();
        Gson gson = new Gson();
        Tdw_Msrstn_Info tdw_msrstn_info = gson.fromJson(stringItem,Tdw_Msrstn_Info.class);
//        Long now = System.currentTimeMillis();
//        Timestamp timestamp = new Timestamp(now);
//
//        tdw_msrstn_info.setClct_dt(timestamp);

        return tdw_msrstn_info;
    }

}
