package net.anyang.service;

import net.anyang.Model.Params.LogParams;
import net.anyang.Model.Params.NifiParams;
import net.anyang.Model.Tn_data_bass_info;
import net.anyang.Model.Tn_data_clct_log;
import net.anyang.repository.TnDataClctLogRepository;
import net.anyang.result.TnDataClctLogResult;
import net.anyang.spec.TnDataClctLogSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Optional;

@Service
public class TnDataClctLogService {
    @Autowired
    TnDataClctLogRepository tnDataClctLogRepository;


    public Tn_data_clct_log findOneWithRelations(Long clct_log_sn){
        Tn_data_clct_log tn_data_clct_log = tnDataClctLogRepository.findOneByClctLogSn(clct_log_sn);

        return tn_data_clct_log;
    }
    public TnDataClctLogResult findAllWithSpecification(PageRequest pageRequest, LogParams logParam) {
        Specification specification = Specification.where(TnDataClctLogSpecification.searchByDtstsn(logParam));

        Page<Tn_data_clct_log> page = tnDataClctLogRepository.findAll(specification,pageRequest);
        TnDataClctLogResult tnDataClctLogResult = new TnDataClctLogResult(page,page.getContent());
        return tnDataClctLogResult;
    }

    public Tn_data_clct_log makeInstance(NifiParams nifiParams,Tn_data_clct_log tn_data_clct_log
                                        ,Tn_data_bass_info tn_data_bass_info, Timestamp timestamp){

        tn_data_clct_log.setDtst_sn(nifiParams.getDtst_sn());
        tn_data_clct_log.setClct_data_nm(tn_data_bass_info.getDtst_nm());
        tn_data_clct_log.setClct_ymd(getYmd(timestamp));
        tn_data_clct_log.setAdminist_realm_cd(tn_data_bass_info.getAdminist_realm_cd());
//        tn_data_clct_log.setData_crtr_pnttm();
        tn_data_clct_log.setFlpth(nifiParams.getFlpth());
        tn_data_clct_log.setFile_Nm(nifiParams.getFile_Nm());
        tn_data_clct_log.setFile_extn(nifiParams.getFile_extn());
        tn_data_clct_log.setFile_size(nifiParams.getFile_size());
        tn_data_clct_log.setFile_clct_sttus_cd(nifiParams.getFile_clct_sttus_cd());
        tn_data_clct_log.setFile_clct_dt(nifiParams.getFile_clct_dt());
        tn_data_clct_log.setInner_file_ldadng_sttus_cd(nifiParams.getInner_file_ldadng_sttus_cd());
        tn_data_clct_log.setInner_file_ldadng_dt(nifiParams.getInner_file_ldadng_dt());
        tn_data_clct_log.setInner_file_reprodc_yn(nifiParams.getInner_file_reprodc_yn());
        tn_data_clct_log.setDw__ldadng_sttus_cd(nifiParams.getDw__ldadng_sttus_cd());
        tn_data_clct_log.setDw_ldadng_dt(nifiParams.getDw_ldadng_dt());
        tn_data_clct_log.setCrt_dt(timestamp);

        return tn_data_clct_log;
    }

    public String getYmd(Timestamp timestamp){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        return simpleDateFormat.format(timestamp);
    }

    public Tn_data_clct_log updateDataLog(NifiParams nifiParams, Tn_data_bass_info tn_data_bass_info,  Timestamp timestamp,
                              Tn_data_clct_log stored_tn_data_clct_log) {

        Tn_data_clct_log data_clct_log = new Tn_data_clct_log();

        data_clct_log.setClctLogSn(stored_tn_data_clct_log.getClctLogSn());

        data_clct_log.setDtst_sn(stored_tn_data_clct_log.getDtst_sn());
        data_clct_log.setClct_data_nm(Optional.ofNullable(nifiParams.getClct_data_nm())
                                        .orElse(stored_tn_data_clct_log.getClct_data_nm()));
        data_clct_log.setClct_ymd(getYmd(timestamp));
            data_clct_log.setAdminist_realm_cd(Optional.ofNullable(tn_data_bass_info.getAdminist_realm_cd())
                                            .orElse(stored_tn_data_clct_log.getAdminist_realm_cd()));
        data_clct_log.setFlpth(Optional.ofNullable(nifiParams.getFlpth())
                                        .orElse(stored_tn_data_clct_log.getFlpth()));
        data_clct_log.setFile_Nm(Optional.ofNullable(nifiParams.getFile_Nm())
                                        .orElse(stored_tn_data_clct_log.getFile_Nm()));
        data_clct_log.setFile_extn(Optional.ofNullable(nifiParams.getFile_extn())
                                        .orElse(stored_tn_data_clct_log.getFile_extn()));
        data_clct_log.setFile_size(Optional.ofNullable(nifiParams.getFile_size())
                                        .orElse(stored_tn_data_clct_log.getFile_size()));
        data_clct_log.setFile_clct_sttus_cd(Optional.ofNullable(nifiParams.getFile_clct_sttus_cd())
                                        .orElse(stored_tn_data_clct_log.getFile_clct_sttus_cd()));
        data_clct_log.setFile_clct_dt(Optional.ofNullable(nifiParams.getFile_clct_dt())
                                        .orElse(stored_tn_data_clct_log.getFile_clct_dt()));

        data_clct_log.setInner_file_ldadng_sttus_cd(Optional.ofNullable(nifiParams.getInner_file_ldadng_sttus_cd())
                                        .orElse(stored_tn_data_clct_log.getInner_file_ldadng_sttus_cd()));
        data_clct_log.setInner_file_ldadng_dt(Optional.ofNullable(nifiParams.getInner_file_ldadng_dt())
                                        .orElse(stored_tn_data_clct_log.getInner_file_ldadng_dt()));
        data_clct_log.setInner_file_reprodc_yn(Optional.ofNullable(nifiParams.getInner_file_reprodc_yn())
                                        .orElse(stored_tn_data_clct_log.getInner_file_reprodc_yn()));

        data_clct_log.setDw__ldadng_sttus_cd(Optional.ofNullable(nifiParams.getDw__ldadng_sttus_cd())
                                        .orElse(stored_tn_data_clct_log.getDw__ldadng_sttus_cd()));
        data_clct_log.setDw_ldadng_dt(Optional.ofNullable(nifiParams.getDw_ldadng_dt())
                                        .orElse(stored_tn_data_clct_log.getDw_ldadng_dt()));
        data_clct_log.setCrt_dt(timestamp);

        return data_clct_log;



    }


}
