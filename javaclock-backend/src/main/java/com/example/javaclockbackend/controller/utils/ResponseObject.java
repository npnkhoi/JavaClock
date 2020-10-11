package com.example.javaclockbackend.controller.utils;

import lombok.Data;

@Data
public class ResponseObject {
    private Integer statusCode;
    private String message;
    private Object payload;
}
