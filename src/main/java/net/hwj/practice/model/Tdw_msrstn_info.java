package net.hwj.practice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigInteger;

@Getter
@Setter
//@Accessors(chain = true)
//@Entity
//@Table(name="tdw_msrstn_info")
//에어코리아_측정소_정보
public class Tdw_msrstn_info {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private BigInteger clt_sn;

    private String stationName;
    private String addr;
    private String year;
    private String mangName;
    private String item;
    private String dmX;
    private String dmY;
//    private String data_crtr_pnttrn;
//    private Timestamp clct_dt;

}
