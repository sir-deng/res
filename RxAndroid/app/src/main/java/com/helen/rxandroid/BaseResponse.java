package com.helen.rxandroid;

public class BaseResponse<T> {
    public String code;
    public String msg;
    private T data;
}
