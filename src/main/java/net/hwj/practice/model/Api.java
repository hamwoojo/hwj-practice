package net.hwj.practice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Accessors(chain = true)
@Entity
public class Api {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long seq_id;
    
    @NotNull
    @Column(name = "url")
    private String URL;

    @Column(name = "api_key")
    private String api_key;

    @Column(name = "content_type")
    private String content_type;

    @Column(name = "mediatype")
    private String media_type;

    @Column(name = "multi_parameter")
    private Boolean multi_parameter;

    @Column(name = "paging_yn")
    private Boolean paging_yn;

    @Column(name = "dataset_nm")
    private String dtst_nm;

    @Column(name = "tb_nm")
    private String tbnm;


}
