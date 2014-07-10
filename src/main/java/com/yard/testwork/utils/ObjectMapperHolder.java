package com.yard.testwork.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperHolder {
    private static final ThreadLocal<ObjectMapper> objectMapper = new ThreadLocal<ObjectMapper>();
    public static ObjectMapper get(){
        return objectMapper.get();
    }

    public static void set(ObjectMapper mapper){
        objectMapper.set(mapper);
    }
}
