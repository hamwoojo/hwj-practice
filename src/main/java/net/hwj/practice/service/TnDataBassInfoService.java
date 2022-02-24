package net.hwj.practice.service;

import lombok.extern.slf4j.Slf4j;
import net.hwj.practice.VO.TnDataBassInfoVo;
import net.hwj.practice.model.Tn_data_bass_info;
import net.hwj.practice.repository.TnDataBassInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Slf4j
@Service
public class TnDataBassInfoService {
    @Autowired
    TnDataBassInfoRepository tnDataBassInfoRepository;

    public Tn_data_bass_info save(TnDataBassInfoVo bassInfoVo){

        Tn_data_bass_info tnDataBassInfo = new Tn_data_bass_info(
                bassInfoVo.getDtst_se_cd(),
                bassInfoVo.getDtst_nm(),
                bassInfoVo.getDtst_dc(),
                bassInfoVo.getLclas_nm(),
                bassInfoVo.getMlsfc_nm(),
                bassInfoVo.getAdminist_realm_cd(),
                bassInfoVo.getData_rls_se_cd(),
                bassInfoVo.getPvsn_site_cd(),
                bassInfoVo.getPublic_portal_clct_se_cd(),
                bassInfoVo.getPvsn_inst_nm(),
                bassInfoVo.getPvsn_mthd_cd(),
                bassInfoVo.getDtmt_ldadng_mthd_cd(),
                bassInfoVo.getData_updt_cycle_cd(),
                bassInfoVo.getClct_file_extn(),
                bassInfoVo.getClct_file_sprtr(),
                bassInfoVo.getData_link_url(),
                bassInfoVo.getEncpt_yn(),
                bassInfoVo.getPgng_yn(),
                bassInfoVo.getMulti_paramtr_yn(),
                bassInfoVo.getDw_ldadng_yn(),
                bassInfoVo.getDtmt_ldadng_yn(),
                bassInfoVo.getDtmt_tbl_physicl_nm(),
                bassInfoVo.getInner_clct_database_id(),
                bassInfoVo.getInner_clct_tbl_physicl_nm(),
                bassInfoVo.getAddr_refine_yn(),
                bassInfoVo.getDtmt_prcss_yn(),
                bassInfoVo.getUse_yn(),
                getTimestamp(),
                bassInfoVo.getRm()

        );

        tnDataBassInfoRepository.save(tnDataBassInfo);
        return tnDataBassInfoRepository.save(tnDataBassInfo);
    }

    public Timestamp getTimestamp (){
        return new Timestamp(System.currentTimeMillis());
    }
}
