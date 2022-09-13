package com.lihm.xxljobdemo;

import lombok.Data;

import java.io.Serializable;

@Data
public class RestResult<T> implements Serializable {

    private static final int SUCCESS_CODE = 0;
    private static final String SUCCESS_MESSAGE = "success";

    private T data;

    private int code;

    private String message;

    public static <T> RestResult success(T data) {
        RestResult result = new RestResult();
        result.code = SUCCESS_CODE;
        result.message = SUCCESS_MESSAGE;
        result.data = data;
        return result;
    }


    public static <T> RestResult fail(int code, String message) {
        RestResult result = new RestResult();
        result.code = code;
        result.message = message;
        return result;
    }


}
