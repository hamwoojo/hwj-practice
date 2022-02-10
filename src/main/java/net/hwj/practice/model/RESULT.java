package net.hwj.practice.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class RESULT {
    @JacksonXmlProperty(localName = "MESSAGE")
    private String message;
    @JacksonXmlProperty(localName = "CODE")
    private String code;
}
