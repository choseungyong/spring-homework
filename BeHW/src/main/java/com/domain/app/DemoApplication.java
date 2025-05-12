package com.domain.app;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DemoApplication {
    public static void main(String[] args) {
        var greeting = new Greeting(1L, "jason");
        System.out.println(greeting.sayHello());

        var mapper = new ObjectMapper();
        try {
            System.out.println(mapper.writeValueAsString(greeting));
        } catch (JsonProcessingException e) {
            System.err.println("JSON 변환 실패: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
