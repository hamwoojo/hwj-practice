package net.hwj.practice.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonFormat
@AllArgsConstructor
@NoArgsConstructor
public class ApiVo {

    private String url;
    private String api_key;
    private String media_type;
    private String content_type;
    private Boolean multi_parameter;
    private Boolean paging_yn;
    private String dtst_nm;
    private String tb_nm;

}
