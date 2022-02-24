package net.hwj.practice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tn_data_bass_info")
public class Tn_data_bass_info {
    /**** 데이터셋_일련번호 ****/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger dtst_sn;

    /**** 데이터셋_구분코드 ****/
    @Column(length = 50)
    private String dtst_se_cd;
    /**** 데이터셋_이름 ****/
    @Column(length = 200)
    private String dtst_nm;
    /**** 데이터셋_설명 ****/
    @Column(length = 2000)
    private String dtst_dc;
    /**** 대분류_이름	 ****/
    @Column(length = 200)
    private String lclas_nm;
    /**** 중분류_이름	 ****/
    @Column(length = 200)
    private String mlsfc_nm;
    /**** 행정_분야_코드 ****/
    @Column(length = 7)
    private String administ_realm_cd;
    /**** 데이터_공개_구분_코드 ****/
    @Column(length = 50)
    private String data_rls_se_cd;
    /**** 제공_사이트_코드 ****/
    @Column(length = 50)
    private String pvsn_site_cd;
    /**** 공공_포털_수집_구분_코드 ****/
    @Column(length = 50)
    private String public_portal_clct_se_cd;
    /**** 제공_기관_명칭 ****/
    @Column(length = 200)
    private String pvsn_inst_nm;
    /**** 제공_방식_코드 ****/
    @Column(length = 50)
    private String pvsn_mthd_cd;
    /**** 데이터마트_적재_방식_코드 ****/
    @Column(length = 50)
    private String dtmt_ldadng_mthd_cd;
    /**** 데이터_갱신_주기_코드 ****/
    @Column(length = 50)
    private String data_updt_cycle_cd;
    /**** 수집파일_확장자 ****/
    @Column(length = 5)
    private String clct_file_extn;
    /**** 수집파일_구분자 ****/
    @Column(length = 5)
    private String clct_file_sprtr;
    /**** 데이터_연계_URL ****/
    @Column(length = 2000)
    private String data_link_url;
    /**** 암호화_여부 ****/
    @Column(length = 1)
    private String encpt_yn;
    /**** 페이징_여부 ****/
    @Column(length = 1)
    private String pgng_yn;
    /**** 다중_파라미터_여부 ****/
    @Column(length = 1)
    private String multi_paramtr_yn;
    /**** 데이터웨어하우스_적재_여부 ****/
    @Column(length = 1)
    private String dw_ldadng_yn;
    /**** 데이터마트_적재_여부 ****/
    @Column(length = 1)
    private String dtmt_ldadng_yn;
    /**** 데이터마트_테이블_물리명 ****/
    @Column(length = 200, name = "dtmt_tbl_physicl_nm")
    private String dtmtTblPhysiclNm;
    /**** 내부_수집_데이터베이스_아이디 ****/
    @Column(length = 50)
    private String inner_clct_database_id;
    /**** 내부_수집_테이블_물리_명 ****/
    @Column(length = 200, name = "inner_clct_tbl_physicl_nm")
    private String innerClctTblPhysiclNm;
    /**** 주소_정제_여부 ****/
    @Column (length = 1)
    private String addr_refine_yn;
    /**** 데이터마트_가공_여부 ****/
    @Column(length = 1)
    private String dtmt_prcss_yn;
    /**** 사용_여부 ****/
    @Column(length = 1)
    private String use_yn;
    /**** 생성_일시 ****/
    @Column
    private Timestamp crt_dt;
    /**** 비고 ****/
    @Column(length = 2000)
    private String rm;

    public Tn_data_bass_info(String dtst_se_cd,
                             String dtst_nm, String dtst_dc, String lclas_nm,
                             String mlsfc_nm, String administ_realm_cd, String data_rls_se_cd,
                             String pvsn_site_cd, String public_portal_clct_se_cd, String pvsn_inst_nm,
                             String pvsn_mthd_cd, String dtmt_ldadng_mthd_cd, String data_updt_cycle_cd,
                             String clct_file_extn, String clct_file_sprtr, String data_link_url,
                             String encpt_yn, String pgng_yn, String multi_paramtr_yn,
                             String dw_ldadng_yn, String dtmt_ldadng_yn, String dtmt_tbl_physicl_nm,
                             String inner_clct_database_id, String inner_clct_tbl_physicl_nm,
                             String addr_refine_yn, String dtmt_prcss_yn,
                             String use_yn, Timestamp crt_dt, String rm) {
        this.dtst_se_cd = dtst_se_cd;
        this.dtst_nm = dtst_nm;
        this.dtst_dc = dtst_dc;
        this.lclas_nm = lclas_nm;
        this.mlsfc_nm = mlsfc_nm;
        this.administ_realm_cd = administ_realm_cd;
        this.data_rls_se_cd = data_rls_se_cd;
        this.pvsn_site_cd = pvsn_site_cd;
        this.public_portal_clct_se_cd = public_portal_clct_se_cd;
        this.pvsn_inst_nm = pvsn_inst_nm;
        this.pvsn_mthd_cd = pvsn_mthd_cd;
        this.dtmt_ldadng_mthd_cd = dtmt_ldadng_mthd_cd;
        this.data_updt_cycle_cd = data_updt_cycle_cd;
        this.clct_file_extn = clct_file_extn;
        this.clct_file_sprtr = clct_file_sprtr;
        this.data_link_url = data_link_url;
        this.encpt_yn = encpt_yn;
        this.pgng_yn = pgng_yn;
        this.multi_paramtr_yn = multi_paramtr_yn;
        this.dw_ldadng_yn = dw_ldadng_yn;
        this.dtmt_ldadng_yn = dtmt_ldadng_yn;
        this.dtmtTblPhysiclNm = dtmt_tbl_physicl_nm;
        this.inner_clct_database_id = inner_clct_database_id;
        this.innerClctTblPhysiclNm = inner_clct_tbl_physicl_nm;
        this.addr_refine_yn = addr_refine_yn;
        this.dtmt_prcss_yn = dtmt_prcss_yn;
        this.use_yn = use_yn;
        this.crt_dt = crt_dt;
        this.rm = rm;
    }
}
