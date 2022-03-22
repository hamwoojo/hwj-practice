package net.anyang.Model.Params;

import com.sun.istack.Nullable;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
public class NifiParams {
    private Long clct_log_sn;
    private Long dtst_sn;
    private String tb_nm;

    private String clct_data_nm;
    private String administ_realm_cd;
    private String data_crtr_pnttm;
    private String flpth;
    private String file_Nm;
    private String file_extn;
    private Long file_size;
    private String file_clct_sttus_cd;
    private Timestamp file_clct_dt;
    private String inner_file_ldadng_sttus_cd;
    private Timestamp inner_file_ldadng_dt;
    private String inner_file_reprodc_yn;
    private String dw__ldadng_sttus_cd;
    private Timestamp dw_ldadng_dt;
//    private String dtmt_ldadng_sttus_cd;
//    private Timestamp dtmt_ldadng_dt;
//    private Long dtmt_record_cnt;
//    private String dtmt_prcss_sttus_cd;
//    private Timestamp dtmt_prcss_dt;
//    private Timestamp crt_dt;
}
