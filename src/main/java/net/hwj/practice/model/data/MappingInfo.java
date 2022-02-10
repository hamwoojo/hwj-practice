package net.hwj.practice.model.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MappingInfo {
    private String table;
    private String property; //dcat
    private String column;  //etc

    public String toStringForLog() {
        final StringBuilder sb = new StringBuilder("MappingInfo{");
        sb.append("table='").append(table).append('\'');
        sb.append(", property='").append(property).append('\'');
        sb.append(", column='").append(column).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
