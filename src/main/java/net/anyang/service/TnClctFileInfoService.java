package net.anyang.service;

import net.anyang.Model.Params.NifiParams;
import net.anyang.Model.Tn_clct_file_info;
import net.anyang.Model.Tn_data_bass_info;
import net.anyang.Model.Tn_data_clct_log;
import net.anyang.repository.TnClctFileInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Optional;

@Service
public class TnClctFileInfoService {
    @Autowired
    TnClctFileInfoRepository tnClctFileInfoRepository;

    public Tn_clct_file_info makeInstance(NifiParams nifiParams, Tn_data_bass_info tn_data_bass_info,
                                          Tn_data_clct_log tn_data_clct_log,Tn_clct_file_info tn_clct_file_info,
                                          Timestamp timestamp
    ){

        tn_clct_file_info.setDtst_sn(nifiParams.getDtst_sn());
        tn_clct_file_info.setClct_ymd(getYmd(timestamp));
        tn_clct_file_info.setClct_data_nm(tn_data_bass_info.getDtst_nm());
        tn_clct_file_info.setAdminist_realm_cd(tn_data_bass_info.getAdminist_realm_cd());
        tn_clct_file_info.setData_crtr_pnttm(nifiParams.getData_crtr_pnttm());
        tn_clct_file_info.setInner_flpth(nifiParams.getFlpth());
        tn_clct_file_info.setInner_file_nm(nifiParams.getFile_Nm());
        tn_clct_file_info.setInner_file_extn(nifiParams.getFile_extn());
        if(nifiParams.getFile_size() == null){
            tn_clct_file_info.setInner_file_size(0L);
        }
        else{
            tn_clct_file_info.setInner_file_size(nifiParams.getFile_size().longValue());
        }
        tn_clct_file_info.setUse_yn(tn_data_bass_info.getUse_yn());
        tn_clct_file_info.setCrt_dt(timestamp);


        return tn_clct_file_info;

    }
    public String getYmd(Timestamp timestamp){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        return simpleDateFormat.format(timestamp);
    }

    public Tn_clct_file_info updateFileLog(NifiParams nifiParams, Tn_data_bass_info tn_data_bass_info, Timestamp timestamp,
                                           Tn_data_clct_log stored_tn_data_clct_log, Tn_clct_file_info stored_tn_clct_file_info) {
        Tn_clct_file_info tn_clct_file_info = new Tn_clct_file_info();

        tn_clct_file_info.setClctFileSn(stored_tn_clct_file_info.getClctFileSn());
        tn_clct_file_info.setDtst_sn(stored_tn_clct_file_info.getDtst_sn());
        tn_clct_file_info.setClct_ymd(getYmd(timestamp));
        tn_clct_file_info.setClct_data_nm(stored_tn_data_clct_log.getClct_data_nm());
        tn_clct_file_info.setAdminist_realm_cd(Optional.ofNullable(tn_data_bass_info.getAdminist_realm_cd())
                .orElse(stored_tn_data_clct_log.getAdminist_realm_cd()));

        tn_clct_file_info.setData_crtr_pnttm(Optional.ofNullable(tn_clct_file_info.getData_crtr_pnttm())
                .orElse(stored_tn_clct_file_info.getData_crtr_pnttm()));
        tn_clct_file_info.setInner_flpth(Optional.ofNullable(nifiParams.getFlpth())
                .orElse(stored_tn_clct_file_info.getInner_flpth()));
        tn_clct_file_info.setInner_file_nm(Optional.ofNullable(nifiParams.getFile_Nm())
                .orElse(stored_tn_clct_file_info.getInner_file_nm()));
        tn_clct_file_info.setInner_file_extn(Optional.ofNullable(nifiParams.getFile_extn())
                .orElse(stored_tn_clct_file_info.getInner_file_extn()));
        tn_clct_file_info.setInner_file_size(Optional.ofNullable(nifiParams.getFile_size())
                .orElse(stored_tn_clct_file_info.getInner_file_size()));
        tn_clct_file_info.setUse_yn(Optional.ofNullable(tn_data_bass_info.getUse_yn()).orElse("N"));
        tn_clct_file_info.setCrt_dt(timestamp);


        return tn_clct_file_info;
    }
}
