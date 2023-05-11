package com.manish.spring.model;

import lombok.Data;

@Data
public class Response<T> {
    private String status = "SUCCESS";
    private String errorCode;
    private String errorMessage;
    private T data;
}
