package com.secretescapes.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class JsonFileReader {

    public static Map<String, Object> jsonToMap(String jsonName)  {
        try(InputStream inputStream = JsonFileReader.class.getResourceAsStream("/%s.json".formatted(jsonName))) {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(inputStream, Map.class);
        } catch (IOException e) {
           throw new RuntimeException("Json file with name %s from resources folder couldn't be transformed to Map");
        }
    }
}