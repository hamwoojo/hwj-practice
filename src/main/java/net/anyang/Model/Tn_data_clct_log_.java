package net.anyang.Model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Tn_data_clct_log.class)
public class Tn_data_clct_log_ {

    public static volatile SingularAttribute<Tn_data_clct_log, Long> clctLogSn;


    public static volatile SingularAttribute<Tn_data_clct_log, Long> dtst_sn;
    public static volatile SingularAttribute<Tn_data_clct_log, String> clct_ymd;
    public static volatile SingularAttribute<Tn_data_clct_log, String> clct_data_nm;
    public static volatile SingularAttribute<Tn_data_clct_log, String> administ_realm_cd;
    public static volatile SingularAttribute<Tn_data_clct_log, String> file_clct_sttus_cd;

}
