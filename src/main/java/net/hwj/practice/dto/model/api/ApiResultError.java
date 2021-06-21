package net.hwj.practice.dto.model.api;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName ="error")
public class ApiResultError extends ApiResult {
    public ApiResultError(int resultCode, String message) {
        super(resultCode, message);
    }
}
