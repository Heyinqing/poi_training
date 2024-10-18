package com.cisdi.common;


import java.io.Serializable;

/**
 * @author huangdi
 * @since 2024/6/3 14:14
 */
public class ResultMsg<T> implements Serializable {
    private Integer code;
    private String message;
    private T data;

    public ResultMsg() {

    }
    public ResultMsg(Integer code) {
        this.code = code;
    }

    public ResultMsg(String message) {
        this.message = message;
    }

    public ResultMsg(T data) {
        this.data = data;
    }

    public ResultMsg(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultMsg(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public ResultMsg(String message, T data) {
        this.message = message;
        this.data = data;
    }

    public ResultMsg(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ResultMsg<Object> success(){
        ResultMsg<Object> vo = new ResultMsg<>();
        vo.setCode(200);
        vo.setMessage("操作成功");
        return vo;
    }

    public static <T> ResultMsg<T> success(T data){
        ResultMsg<T> vo = new ResultMsg<>();
        vo.setCode(200);
        vo.setMessage("操作成功");
        vo.setData(data);
        return vo;
    }
    public static <T> ResultMsg<T> success(String message,T data){
        ResultMsg<T> vo = new ResultMsg<>();
        vo.setCode(200);
        vo.setMessage(message);
        vo.setData(data);
        return vo;
    }
    public static <T> ResultMsg<T> success(Integer code,String message,T data){
        ResultMsg<T> vo = new ResultMsg<>();
        vo.setCode(code);
        vo.setMessage(message);
        vo.setData(data);
        return vo;
    }

    public static <T> ResultMsg<T> fail(String message){
        ResultMsg<T> vo = new ResultMsg<>();
        vo.setCode(-1);
        vo.setMessage(message);
        return vo;
    }
    public static <T> ResultMsg<T> fail(Integer code,String message){
        ResultMsg<T> vo = new ResultMsg<>();
        vo.setCode(code);
        vo.setMessage(message);
        return vo;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
