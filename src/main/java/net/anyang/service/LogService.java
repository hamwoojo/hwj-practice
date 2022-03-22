package net.anyang.service;

import lombok.extern.slf4j.Slf4j;
import net.anyang.Model.Params.NifiParams;
import net.anyang.Model.Tn_clct_file_info;
import net.anyang.Model.Tn_data_bass_info;
import net.anyang.Model.Tn_data_clct_log;
import net.anyang.repository.TnClctFileInfoRepository;
import net.anyang.repository.TnDataBassInfoRepository;
import net.anyang.repository.TnDataClctLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Slf4j
@Service
public class LogService {
    @Autowired
    private TnClctFileInfoRepository tnClctFileInfoRepository;
    @Autowired
    private TnDataClctLogRepository tnDataClctLogRepository;
    @Autowired
    private TnDataBassInfoRepository tnDataBassInfoRepository;
    @Autowired
    private TnDataClctLogService tnDataClctLogService;
    @Autowired
    private TnClctFileInfoService tnClctFileInfoService;

    public void saveLog(NifiParams nifiParams){
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneByDtstsn(nifiParams.getDtst_sn());

        Tn_data_clct_log tn_data_clct_log = new Tn_data_clct_log();
        Tn_clct_file_info tn_clct_file_info = new Tn_clct_file_info();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());


        tn_data_clct_log = tnDataClctLogService.makeInstance(nifiParams,tn_data_clct_log,tn_data_bass_info,timestamp);
        tn_clct_file_info = tnClctFileInfoService.makeInstance(nifiParams,tn_data_bass_info,tn_data_clct_log,tn_clct_file_info,timestamp);

        tn_data_clct_log.setTn_clct_file_info(tn_clct_file_info);
        tn_clct_file_info.setTn_data_clct_log(tn_data_clct_log);

        tnDataClctLogRepository.save(tn_data_clct_log);

    }

    public void updateLog(NifiParams nifiParams){
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneByDtstsn(nifiParams.getDtst_sn());
        Tn_data_clct_log stored_tn_data_clct_log = tnDataClctLogRepository.findByClctLogSn(nifiParams.getClct_log_sn());
        Tn_clct_file_info stored_tn_clct_file_info = tnClctFileInfoRepository.findByClctFileSn(stored_tn_data_clct_log.getClctLogSn());

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Tn_data_clct_log tn_data_clct_log = tnDataClctLogService.updateDataLog(nifiParams,tn_data_bass_info,timestamp,stored_tn_data_clct_log);
        Tn_clct_file_info tn_clct_file_info = tnClctFileInfoService.updateFileLog(nifiParams,tn_data_bass_info,timestamp,stored_tn_data_clct_log,stored_tn_clct_file_info);

        tn_data_clct_log.setTn_clct_file_info(tn_clct_file_info);
        tn_clct_file_info.setTn_data_clct_log(tn_data_clct_log);

        tnDataClctLogRepository.save(tn_data_clct_log);

    }
}
