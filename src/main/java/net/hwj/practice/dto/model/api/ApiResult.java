package net.hwj.practice.dto.model.api;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ApiResult {
    @JacksonXmlProperty(localName = "statusCode")
    private int resultCode;
    @JacksonXmlProperty(localName = "message")
    private String message;
}
