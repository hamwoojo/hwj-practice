package net.anyang.Model.Params;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class LogParams {
    private String clct_data_nm;
    private Long dtst_sn;
    private String clct_ymd;
    private String administ_realm_cd;
    private String file_clct_sttus_cd;

}
