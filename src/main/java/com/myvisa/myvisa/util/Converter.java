package com.myvisa.myvisa.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myvisa.myvisa.exceptions.CenterServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Converter {
    public static String getString(Object dtoObject, ObjectMapper objectMapper) {

        String dto;
        try {
            dto = objectMapper.writer().withDefaultPrettyPrinter().writeValueAsString(dtoObject);

        } catch (JsonProcessingException e) {
            String eMessage = e.getMessage();
            log.error(eMessage);
            throw new CenterServiceException(eMessage);
        }

        return dto;
    }
}
