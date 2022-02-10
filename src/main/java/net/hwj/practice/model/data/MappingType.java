package net.hwj.practice.model.data;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MappingType {
    private String type;
    private List<MappingInfo> values;
    private List<MappingType> nodes;
}
