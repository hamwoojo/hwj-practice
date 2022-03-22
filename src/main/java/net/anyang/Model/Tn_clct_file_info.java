package net.anyang.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Accessors(chain = true)
public class Tn_clct_file_info{

    /*** 수집_로그_일련번호  ***/
    @Id
    @Column(name = "clct_file_sn")
    private Long clctFileSn;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "clct_file_sn")
    @JsonBackReference
    private Tn_data_clct_log tn_data_clct_log;

    /*** 데이터셋_일련번호  ***/
    private Long dtst_sn;
    /*** 수집_일자  ***/
    @Column(length = 8, columnDefinition = "bpchar")
    private String clct_ymd;
    /*** 수집_데이터_명  ***/
    private String clct_data_nm;
    /*** 행정_분야_코드  ***/
    @Column(length = 7, columnDefinition = "bpchar")
    private String administ_realm_cd;
    /*** 데이터_기준_시점  ***/
    @Column(length = 8, columnDefinition = "bpchar")
    private String data_crtr_pnttm;
    /*** 내부_파일경로  ***/
    private String inner_flpth;
    /*** 내부_파일_명  ***/
    private String inner_file_nm;
    /*** 내부_파일_확장자  ***/
    private String inner_file_extn;
    /*** 내부_파일_사이즈  ***/
    private Long inner_file_size;
    /*** 내려받기_건수  ***/
    private Long dwld_nocs;
    /*** 조회_건수  ***/
    private Long inq_nocs;
    /*** 사용_여부  ***/
    @Column(length = 1, columnDefinition = "bpchar")
    private String use_yn;
    /*** 생성_일시  ***/
    private Timestamp crt_dt;

}
