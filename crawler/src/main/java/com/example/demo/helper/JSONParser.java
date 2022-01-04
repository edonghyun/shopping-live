package com.example.demo.helper;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JSONParser extends org.json.simple.parser.JSONParser {
    @Override
    public Object parse(String s) {
        try {
            return super.parse(s);
        } catch (Exception exc) {
            log.error("{}", exc);
        }
        return null; 
    }
}