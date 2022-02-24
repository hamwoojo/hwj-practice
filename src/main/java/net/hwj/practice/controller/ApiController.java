package net.hwj.practice.controller;//package net.hwj.practice.controller;


import lombok.extern.slf4j.Slf4j;

import net.hwj.practice.model.Api;
import net.hwj.practice.VO.ApiVo;
import net.hwj.practice.repository.ApiRepository;
import net.hwj.practice.repository.NifiRepository;

import net.hwj.practice.service.ApiService;
import net.hwj.practice.service.NifiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@Slf4j
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiController {
    @Autowired
    NifiService nifiService;
    @Autowired
    ApiService apiService;
    @Autowired
    ApiRepository apiRepository;
    @Autowired
    NifiRepository nifiRepository;


    @CrossOrigin
    @GetMapping(value = "/list")
    public Map<String, Object> list(@RequestParam(value = "perPage", defaultValue = "5") Integer perPage,
                                    @RequestParam(value = "page", defaultValue = "1") Integer currentPage){
        Map<String,Object> result = new HashMap<>();
//        List<Resource> resourceList = new ArrayList<>();
//        resourceList
        return result;
    }

    @PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody ApiVo apiVo){

        System.out.println(apiVo);
        Api api = apiService.save(apiVo);
        return new ResponseEntity<>(api,HttpStatus.OK);
        }

    @PutMapping(value = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@RequestBody ApiVo apiVo){

        Api api = apiService.delete(apiVo);

        return new ResponseEntity<>(api,HttpStatus.OK);
    }

    @GetMapping(value = "/call", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> call(
            @RequestParam(value = "apiKey") String api_key,
            @RequestParam(value = "url") String url ){

        //HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        //httpRequestFactory.setConnectTimeout(5000);
        //httpRequestFactory.setReadTimeout(5000);
        HttpHeaders httpHeaders = new HttpHeaders();
        //httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        String ip = "localhost";
        String nifiUrl = nifiService.findNifiUrl(ip);

        MultiValueMap<String, String> params= new LinkedMultiValueMap<>();
        params.add("api_key",api_key);
        params.add("url",url);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params , httpHeaders);

        RestTemplate restTemplate = new RestTemplate();
        //ResponseEntity<String> response = restTemplate.postForEntity(nifiUrl,params,String.class);
       ResponseEntity<String> response = restTemplate.postForEntity(nifiUrl, request, String.class);

        return response;

    }




}
