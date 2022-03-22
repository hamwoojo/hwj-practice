package net.anyang.Mapper;

import javax.annotation.Generated;
import net.anyang.Model.Tn_data_clct_log;
import net.anyang.dto.Tn_data_clct_log_Dto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-22T16:49:41+0900",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_261 (Oracle Corporation)"
)
public class TnDataClctLogMapperImpl implements TnDataClctLogMapper {

    @Override
    public Tn_data_clct_log toEntity(Tn_data_clct_log_Dto dto) {
        if ( dto == null ) {
            return null;
        }

        Tn_data_clct_log tn_data_clct_log = new Tn_data_clct_log();

        tn_data_clct_log.setClctLogSn( dto.getClct_log_sn() );
        tn_data_clct_log.setDtst_sn( dto.getDtst_sn() );
        tn_data_clct_log.setClct_ymd( dto.getClct_ymd() );
        tn_data_clct_log.setClct_data_nm( dto.getClct_data_nm() );
        tn_data_clct_log.setAdminist_realm_cd( dto.getAdminist_realm_cd() );
        tn_data_clct_log.setData_crtr_pnttm( dto.getData_crtr_pnttm() );
        tn_data_clct_log.setFlpth( dto.getFlpth() );
        tn_data_clct_log.setFile_Nm( dto.getFile_Nm() );
        tn_data_clct_log.setFile_extn( dto.getFile_extn() );
        tn_data_clct_log.setFile_size( dto.getFile_size() );
        tn_data_clct_log.setFile_clct_sttus_cd( dto.getFile_clct_sttus_cd() );
        tn_data_clct_log.setFile_clct_dt( dto.getFile_clct_dt() );
        tn_data_clct_log.setInner_file_ldadng_sttus_cd( dto.getInner_file_ldadng_sttus_cd() );
        tn_data_clct_log.setInner_file_ldadng_dt( dto.getInner_file_ldadng_dt() );
        tn_data_clct_log.setInner_file_reprodc_yn( dto.getInner_file_reprodc_yn() );
        tn_data_clct_log.setDw__ldadng_sttus_cd( dto.getDw__ldadng_sttus_cd() );
        tn_data_clct_log.setDw_ldadng_dt( dto.getDw_ldadng_dt() );
        tn_data_clct_log.setDtmt_ldadng_sttus_cd( dto.getDtmt_ldadng_sttus_cd() );
        tn_data_clct_log.setDtmt_ldadng_dt( dto.getDtmt_ldadng_dt() );
        tn_data_clct_log.setDtmt_record_cnt( dto.getDtmt_record_cnt() );
        tn_data_clct_log.setDtmt_prcss_sttus_cd( dto.getDtmt_prcss_sttus_cd() );
        tn_data_clct_log.setDtmt_prcss_dt( dto.getDtmt_prcss_dt() );
        tn_data_clct_log.setCrt_dt( dto.getCrt_dt() );
        tn_data_clct_log.setTn_clct_file_info( dto.getTn_clct_file_info() );

        return tn_data_clct_log;
    }

    @Override
    public Tn_data_clct_log_Dto toDto(Tn_data_clct_log entity) {
        if ( entity == null ) {
            return null;
        }

        Tn_data_clct_log_Dto tn_data_clct_log_Dto = new Tn_data_clct_log_Dto();

        tn_data_clct_log_Dto.setClct_log_sn( entity.getClctLogSn() );
        tn_data_clct_log_Dto.setDtst_sn( entity.getDtst_sn() );
        tn_data_clct_log_Dto.setClct_ymd( entity.getClct_ymd() );
        tn_data_clct_log_Dto.setClct_data_nm( entity.getClct_data_nm() );
        tn_data_clct_log_Dto.setAdminist_realm_cd( entity.getAdminist_realm_cd() );
        tn_data_clct_log_Dto.setData_crtr_pnttm( entity.getData_crtr_pnttm() );
        tn_data_clct_log_Dto.setFlpth( entity.getFlpth() );
        tn_data_clct_log_Dto.setFile_Nm( entity.getFile_Nm() );
        tn_data_clct_log_Dto.setFile_extn( entity.getFile_extn() );
        tn_data_clct_log_Dto.setFile_size( entity.getFile_size() );
        tn_data_clct_log_Dto.setFile_clct_sttus_cd( entity.getFile_clct_sttus_cd() );
        tn_data_clct_log_Dto.setFile_clct_dt( entity.getFile_clct_dt() );
        tn_data_clct_log_Dto.setInner_file_ldadng_sttus_cd( entity.getInner_file_ldadng_sttus_cd() );
        tn_data_clct_log_Dto.setInner_file_ldadng_dt( entity.getInner_file_ldadng_dt() );
        tn_data_clct_log_Dto.setInner_file_reprodc_yn( entity.getInner_file_reprodc_yn() );
        tn_data_clct_log_Dto.setDw__ldadng_sttus_cd( entity.getDw__ldadng_sttus_cd() );
        tn_data_clct_log_Dto.setDw_ldadng_dt( entity.getDw_ldadng_dt() );
        tn_data_clct_log_Dto.setDtmt_ldadng_sttus_cd( entity.getDtmt_ldadng_sttus_cd() );
        tn_data_clct_log_Dto.setDtmt_ldadng_dt( entity.getDtmt_ldadng_dt() );
        tn_data_clct_log_Dto.setDtmt_record_cnt( entity.getDtmt_record_cnt() );
        tn_data_clct_log_Dto.setDtmt_prcss_sttus_cd( entity.getDtmt_prcss_sttus_cd() );
        tn_data_clct_log_Dto.setDtmt_prcss_dt( entity.getDtmt_prcss_dt() );
        tn_data_clct_log_Dto.setCrt_dt( entity.getCrt_dt() );
        tn_data_clct_log_Dto.setTn_clct_file_info( entity.getTn_clct_file_info() );

        return tn_data_clct_log_Dto;
    }
}
