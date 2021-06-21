package net.hwj.practice.dto.model.api;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName ="success")
public class ApiResultSuccess extends ApiResult {
    public ApiResultSuccess(int resultCode, String message) {
        super(resultCode, message);
    }
}
