package net.anyang.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import net.anyang.Model.Tn_clct_file_info;

import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tn_data_clct_log_Dto{

    private Long clct_log_sn;
    private Long dtst_sn;
    private String clct_ymd;
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
    private String dtmt_ldadng_sttus_cd;
    private Timestamp dtmt_ldadng_dt;
    private Long dtmt_record_cnt;
    private String dtmt_prcss_sttus_cd;
    private Timestamp dtmt_prcss_dt;
    private Timestamp crt_dt;

    @JsonIgnoreProperties
    private Tn_clct_file_info tn_clct_file_info;

}
