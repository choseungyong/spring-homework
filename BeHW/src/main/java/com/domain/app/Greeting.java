package com.domain.app;

public record Greeting(long id, String name) {
    public String sayHello() {
        return "Hello, %s!".formatted(name);
    }
}
