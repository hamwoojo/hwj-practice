package net.hwj.practice.model;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.security.Timestamp;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name="public_restroom_info")
public class Public_restroom_info {

    /**번호**/
    @Id
    @Column(name="no")
    private Long no;

    /**구분**/
    @Column(name = "div")
    private String div;

    /**화장실명**/
    @Column(name = "restroom_name")
    private String name;

    /**소재지도로명주소**/
    @Column(name = "new_address")
    private String newAddress;

    /**소재지지번주소**/
    @Column(name = "old_address")
    private String oldAddress;

    /**남녀공용화장실여부**/
    @Column(name = "unisex_flag")
    private String unisexFlag;

    /**남성용-대변기수**/
    @Column(name = "man_closet_count")
    private Integer manClosetCount;
    /**남성용-소변기수**/
    @Column(name = "man_urinal_count")
    private Integer manUrinalCount;
    /**남성용-장애인용대변기수**/
    @Column(name = "man_disabled_closet_count")
    private Integer manDisabledClosetCount;
    /**남성용-장애인용소변기수**/
    @Column(name = "man_disabled_urinal_count")
    private Integer manDisabledUrinalCount;
    /**남성용-어린이용대변기수**/
    @Column(name = "man_child_closet_count")
    private Integer manChildClosetCount;
    /**남성용-어린이용소변기수**/
    @Column(name = "man_child_urinal_count")
    private Integer manChildUrinalCount;
    /**여성용-대변기수**/
    @Column(name = "woman_closet_count")
    private Integer womanClosetCount;
    /**여성용-장애인용대변기수**/
    @Column(name = "woman_disabled_closet_count")
    private Integer womanDisabledClosetCount;
    /**여성용-어린이용대변기수**/
    @Column(name = "woman_child_closet_count")
    private Integer womanChildClosetCount;
    /**관리기관명**/
    @Column(name = "management_agency_name")
    private String managementAgencyName;
    /**전화번호**/
    @Column(name = "phone_number")
    private String phoneNumber;
    /**개방시간**/
    @Column(name = "open_time")
    private String openTime;
    /**설치연월**/
    @Column(name = "install_date")
    private String installDate;
    /**WGS84위도**/
    @Column(name = "wgs84_latitude")
    private Double wgs84Latitude;
    /**WGS84경도**/
    @Column(name = "wgs84_longitude")
    private Double wgs84Longitude;
    /**화장실소유구분**/
    @Column(name = "restroom_own_div")
    private String restroomOwnDiv;
    /**화장실설치장소유형**/
    @Column(name = "restroom_address_type")
    private String restroomAddressType;
    /**오물처리방식**/
    @Column(name = "trash_process_system")
    private String trashProcessSystem;
    /**비상벨설치유형**/
    @Column(name = "emergency_install_type")
    private String emergencyInstallType;
    /**화장실입구CCTV설치유무**/
    @Column(name = "enter_cctv_install_flag")
    private String enterCctvInstallFlag;
    /**기저귀교환대장소**/
    @Column(name = "diaper_trade_position")
    private String diaperTradePostion;
    /**리모델링연월**/
    @Column(name = "remodel_date")
    private String remodelDate;
    /**데이터기준일자**/
    @Column(name = "data_standard_date")
    private String dataStandardDate;

}
