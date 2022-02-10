package net.hwj.practice.model.data;

import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Setter
@XmlRootElement
public class MappingInfos {
    private String id;
    private MappingType topNodes;

    @XmlAttribute
    public String getId() {
        return id;
    }

    @XmlElement
    public MappingType getTopNodes() {
        return topNodes;
    }


}
