package net.hwj.practice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name="resources")
public class Resource {

    @Id
    @Column(name="index")
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long index;

    private String id;
    private String title;
    private String description;
    private String type;

}
