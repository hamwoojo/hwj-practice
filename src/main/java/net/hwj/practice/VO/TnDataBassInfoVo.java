package net.hwj.practice.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.sql.Timestamp;

@Data
@JsonFormat
@AllArgsConstructor
@NoArgsConstructor
public class TnDataBassInfoVo {


    /**** 데이터셋_구분코드 ****/
    private String dtst_se_cd;
    /**** 데이터셋_이름 ****/
    private String dtst_nm;
    /**** 데이터셋_설명 ****/
    private String dtst_dc;
    /**** 대분류_이름	 ****/
    private String lclas_nm;
    /**** 중분류_이름	 ****/
    private String mlsfc_nm;
    /**** 행정_분야_코드 ****/
    private String administ_realm_cd;
    /**** 데이터_공개_구분_코드 ****/
    private String data_rls_se_cd;
    /**** 제공_사이트_코드 ****/
    private String pvsn_site_cd;
    /**** 공공_포털_수집_구분_코드 ****/
    private String public_portal_clct_se_cd;
    /**** 제공_기관_명칭 ****/
    private String pvsn_inst_nm;
    /**** 제공_방식_코드 ****/
    private String pvsn_mthd_cd;
    /**** 데이터마트_적재_방식_코드 ****/
    private String dtmt_ldadng_mthd_cd;
    /**** 데이터_갱신_주기_코드 ****/
    private String data_updt_cycle_cd;
    /**** 수집파일_확장자 ****/
    private String clct_file_extn;
    /**** 수집파일_구분자 ****/
    private String clct_file_sprtr;
    /**** 데이터_연계_URL ****/
    private String data_link_url;
    /**** 암호화_여부 ****/
    private String encpt_yn;
    /**** 페이징_여부 ****/
    private String pgng_yn;
    /**** 다중_파라미터_여부 ****/
    private String multi_paramtr_yn;
    /**** 데이터웨어하우스_적재_여부 ****/
    private String dw_ldadng_yn;
    /**** 데이터마트_적재_여부 ****/
    private String dtmt_ldadng_yn;
    /**** 데이터마트_테이블_물리명 ****/
    private String dtmt_tbl_physicl_nm;
    /**** 내부_수집_데이터베이스_아이디 ****/
    private String inner_clct_database_id;
    /**** 내부_수집_테이블_물리_명 ****/
    private String inner_clct_tbl_physicl_nm;
    /**** 주소_정제_여부 ****/
    private String addr_refine_yn;
    /**** 데이터마트_가공_여부 ****/
    private String dtmt_prcss_yn;
    /**** 사용_여부 ****/
    private String use_yn;
    /**** 생성_일시 ****/
    private Timestamp crt_dt;
    /**** 비고 ****/
    private String rm;

}
