package com.yhjp.bean;

public class ReasultBean<T> {
    private Boolean isSuccess;
    private String message;
    private T Data;

    public ReasultBean(Boolean isSuccess, String message, T data) {
        this.isSuccess = isSuccess;
        this.message = message;
        Data = data;
    }



    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }

    @Override
    public String toString() {
        return "ReasultBean{" +
                "isSuccess=" + isSuccess +
                ", message='" + message + '\'' +
                ", Data=" + Data +
                '}';
    }
}
