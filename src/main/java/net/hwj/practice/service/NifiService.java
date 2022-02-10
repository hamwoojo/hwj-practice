package net.hwj.practice.service;

import lombok.extern.slf4j.Slf4j;
import net.hwj.practice.model.Api;
import net.hwj.practice.model.ApiVo;
import net.hwj.practice.model.Nifi;
import net.hwj.practice.repository.ApiRepository;
import net.hwj.practice.repository.NifiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NifiService {
    @Autowired
    NifiRepository nifiRepository;

    public String findNifiUrl(String ip){
        Nifi nifi = nifiRepository.findNifiByIp(ip);

        String nifiIp = nifi.getIp();
        String port = nifi.getPort();

        String nifiUrl = "http://"+ nifiIp + ":" + port;
        return nifiUrl;
    }
}
