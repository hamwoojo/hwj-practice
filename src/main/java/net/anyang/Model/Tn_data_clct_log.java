package net.anyang.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.Nullable;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@SequenceGenerator(
        name="tn_data_clct_log_seq",
        sequenceName="tn_data_clct_log_clct_log_sn_seq",
        allocationSize=1
)
@Table(name = "tn_data_clct_log")
@Accessors(chain = true)
public class Tn_data_clct_log{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "tn_data_clct_log_seq")
    @Column(name = "clct_log_sn")
    private Long clctLogSn;

    private Long dtst_sn;
    @Column(length = 8, columnDefinition = "bpchar")
    private String clct_ymd;
    private String clct_data_nm;
    @Column (length = 7, columnDefinition = "bpchar")
    private String administ_realm_cd;
    @Column (length = 8, columnDefinition = "bpchar")
    private String data_crtr_pnttm;
    private String flpth;
    private String file_Nm;
    private String file_extn;
    private Long file_size;
    private String file_clct_sttus_cd;
    private Timestamp file_clct_dt;
    private String inner_file_ldadng_sttus_cd;
    private Timestamp inner_file_ldadng_dt;
    @Column (length = 1, columnDefinition = "bpchar")
    private String inner_file_reprodc_yn;
    private String dw__ldadng_sttus_cd;
    private Timestamp dw_ldadng_dt;
    @Nullable
    private String dtmt_ldadng_sttus_cd;
    @Nullable
    private Timestamp dtmt_ldadng_dt;
    @Nullable
    private Long dtmt_record_cnt;
    @Nullable
    private String dtmt_prcss_sttus_cd;
    @Nullable
    private Timestamp dtmt_prcss_dt;
    private Timestamp crt_dt;

    @OneToOne(mappedBy = "tn_data_clct_log",cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @JsonManagedReference
    private Tn_clct_file_info tn_clct_file_info;


}
