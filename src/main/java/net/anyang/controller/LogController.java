package net.anyang.controller;

import lombok.extern.slf4j.Slf4j;
import net.anyang.Mapper.TnDataClctLogMapper;
import net.anyang.Model.Params.LogParams;
import net.anyang.Model.Params.NifiParams;
import net.anyang.Model.Tn_data_clct_log;
import net.anyang.dto.Tn_data_clct_log_Dto;
import net.anyang.dto.Tn_data_clct_log_list_dto;
import net.anyang.result.TnDataClctLogResult;
import net.anyang.service.LogService;
import net.anyang.service.TnDataClctLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@Slf4j
@RestController
@RequestMapping("/log")
@CrossOrigin
public class LogController {
    @Autowired
    LogService logService;
    @Autowired
    TnDataClctLogService  tnDataClctLogService;

    @PostMapping(value = "save")
    public Map<String,String> save(@RequestBody NifiParams nifiParams){
        HashMap<String,String> map = new HashMap<>();
        if  ((Objects.nonNull(nifiParams.getClct_log_sn()) && nifiParams.getClct_log_sn() > 0)
            && (Objects.nonNull(nifiParams.getDtst_sn()) && nifiParams.getDtst_sn() > 0 )){
            /*** Update 로직 ***/
            log.info("file log Update");
            logService.updateLog(nifiParams);
            map.put("message", "업데이트 성공");
            return map;
        }
        else if(Objects.isNull(nifiParams.getClct_log_sn()) && (Objects.nonNull(nifiParams.getDtst_sn())  && nifiParams.getDtst_sn() > 0 ))
        {
            /*** Save 로직 ***/
            log.info("New File log Save");
            logService.saveLog(nifiParams);
            map.put("message", "세이브 성공");
            return map;
        }
        else{
            map.put("message","해당하는 로그 번호 또는 데이터셋 번호가 존재하지 않습니다");
            return map;
        }

    }

    @CrossOrigin
    @GetMapping(value = "list")
    public ResponseEntity<?> list(@RequestParam(value = "perPage", defaultValue = "10") Integer perPage,
                                  @RequestParam(value = "page", defaultValue = "1") Integer currentPage,
                                  @RequestParam(value = "clct_data_nm", required = false) String clct_data_nm,
                                  @RequestParam(value = "dtst_sn", required = false) Long dtst_sn,
                                  @RequestParam(value = "clct_ymd", required = false) String clct_ymd,
                                  @RequestParam(value = "administ_realm_cd", required = false) String administ_realm_cd,
                                  @RequestParam(value = "file_clct_sttus_cd", required = false) String file_clct_sttus_cd){
        log.info("clct_data_nm : " + clct_data_nm);
        log.info("dtst_sn : " + dtst_sn);
        log.info("clct_ymd : " + clct_ymd);
        log.info("administ_realm_cd : " + administ_realm_cd);
        log.info("file_clct_sttus_cd : " + file_clct_sttus_cd);
        LogParams logParam = new LogParams();

        logParam.setClct_data_nm(clct_data_nm);
        logParam.setDtst_sn(dtst_sn);
        logParam.setClct_ymd(clct_ymd);
        logParam.setAdminist_realm_cd(administ_realm_cd);
        logParam.setFile_clct_sttus_cd(file_clct_sttus_cd);

        Tn_data_clct_log_list_dto tn_data_clct_log_list_dto = new Tn_data_clct_log_list_dto();
        List<Tn_data_clct_log_Dto> tnDataClctLogDtos = new ArrayList<>();

        TnDataClctLogResult tnDataClctLogResult = tnDataClctLogService.findAllWithSpecification(PageRequest.of(currentPage-1,perPage), logParam);

        tnDataClctLogResult.getTn_data_clct_logs().forEach(tn_data_clct_log -> {
                    tnDataClctLogDtos.add(TnDataClctLogMapper.Mapper.toDto(tn_data_clct_log));
        });

        tn_data_clct_log_list_dto.setTotalPages(tnDataClctLogResult.getPage().getTotalPages());
        tn_data_clct_log_list_dto.setData(tnDataClctLogDtos);


        return new ResponseEntity<>(tn_data_clct_log_list_dto, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "{clctLogSn}/detail")
    public ResponseEntity<?> detail(@PathVariable("clctLogSn") Long clctLogSn){
        Tn_data_clct_log tn_data_clct_log = tnDataClctLogService.findOneWithRelations(clctLogSn);
        Tn_data_clct_log_Dto tn_data_clct_log_dto = TnDataClctLogMapper.Mapper.toDto(tn_data_clct_log);

        return new ResponseEntity<>(tn_data_clct_log_dto,HttpStatus.OK);
    }

}
