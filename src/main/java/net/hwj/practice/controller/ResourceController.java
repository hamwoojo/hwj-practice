package net.hwj.practice.controller;


import lombok.extern.slf4j.Slf4j;
import net.hwj.practice.model.Resource;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
@RestController
@RequestMapping("/resource")
@CrossOrigin
public class ResourceController {
//    @Autowired
//    private RequestedAddressService requestedAddressService;
//    @Autowired
//    private RequestOptionsService requestOptionsService;
//    @Autowired
//    private OptionsMapper optionsMapper;
//    @Autowired
//    private PostTypePriceMapper postTypePriceMapper;
//    @Autowired
//    RequestOptionsRepository requestOptionsRepository;


    @CrossOrigin
    @GetMapping(value = "/list")
    public Map<String, Object> list(@RequestParam(value = "perPage", defaultValue = "5") Integer perPage,
                                    @RequestParam(value = "page", defaultValue = "1") Integer currentPage){
        Map<String,Object> result = new HashMap<>();
        List<Resource> resourceList = new ArrayList<>();
//        resourceList
        return result;
    }



}
