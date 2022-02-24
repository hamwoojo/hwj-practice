package net.hwj.practice.util;

import com.google.gson.FieldNamingStrategy;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;

@Slf4j
public class JsonNamingStrategy implements FieldNamingStrategy {
    @Override
    public String translateName(Field f) {
        return f.getName().toUpperCase();
    }
}
