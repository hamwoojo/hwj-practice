package net.hwj.practice.util;//package net.hwj.practice.util;
//import javax.persistence.AttributeConverter;
//import javax.persistence.Converter;
//import java.io.IOException;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@Converter
//public class OptionVoConverter implements AttributeConverter<OptionVo, String> {
//    private static final ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
//
//    @Override
//    public String convertToDatabaseColumn(OptionVo attribute) {
//        try{
//            return objectMapper.writeValueAsString(attribute);
//        }catch (JsonProcessingException e){
//            throw new IllegalArgumentException("error log ");
//        }
//    }
//
//    @Override
//    public OptionVo convertToEntityAttribute(String dbData) {
//        try{
//            return objectMapper.readValue(dbData,OptionVo.class);
//
//        }catch (IOException e) {
//            throw new IllegalArgumentException("error log");
//        }
//    }
//}