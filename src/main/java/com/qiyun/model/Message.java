package com.qiyun.model;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by Yenole on 2017/1/9.
 */
public class Message {
    boolean result;
    int code;
    String msg;

    public Message(boolean result) {
        this.result = result;
    }

    public Message(boolean result, String msg) {
        this.result = result;
        this.msg = msg;
    }

    public Message(boolean result, int code, String msg) {
        this.result = result;
        this.code = code;
        this.msg = msg;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
