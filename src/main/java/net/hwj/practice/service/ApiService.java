package net.hwj.practice.service;

import lombok.extern.slf4j.Slf4j;
import net.hwj.practice.model.Api;
import net.hwj.practice.VO.ApiVo;
import net.hwj.practice.repository.ApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ApiService {
    @Autowired
    ApiRepository apiRepository;

    public Api save(ApiVo apiVo){


        Api api = new Api();

        api.setTbnm(apiVo.getTb_nm());
        api.setDtst_nm(apiVo.getDtst_nm());
        api.setMulti_parameter(apiVo.getMulti_parameter());
        api.setPaging_yn(apiVo.getPaging_yn());
        api.setURL(apiVo.getUrl());
        api.setApi_key(apiVo.getApi_key());
        api.setContent_type(apiVo.getContent_type());
        api.setMedia_type(apiVo.getMedia_type());

        apiRepository.save(api);
        return apiRepository.save(api);
    }

    public Api delete(ApiVo apiVo){
        Api api = new Api();

        api.setURL(apiVo.getUrl());

        apiRepository.delete(api);
        return api;
    }

}
