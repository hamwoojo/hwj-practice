package net.hwj.practice.model;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.security.Timestamp;
import java.util.Date;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name="sensor_info")
public class Sensor_Info {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(name = "sensor_id")
    private int sensor_id;

    @Column(name = "sensor_name")
    private String sensor_name;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "fine_dust")
    private int fine_dust;

    @Column(name = "ultra_fine_dust")
    private int ultrafind_dust;

    @Column(name = "temperature")
    private float temperature;

    @Column(name = "humidity")
    private float humidity;

    @Column(name = "issued")
    private Timestamp issued;

}
