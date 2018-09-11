package org.seckill.entity;


import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
@ApiModel
public class ResultBean<T> implements Serializable {

    public static final ResultBean<?> SUCCESS = new ResultBean<>();

    private int status = HttpStatus.OK.value();

    private T data = null;

    private String msg = null;

    public ResultBean() {
    }

    public ResultBean(String msg) {
        this.msg = msg;
    }

    public ResultBean(T data) {
        this.data = data;
    }

    public ResultBean(int statusCode) {
        this.status = statusCode;

    }

    public ResultBean(int statusCode, String msg) {
        this.status = statusCode;
        this.msg = msg;
    }

    public ResultBean(int statusCode, T data) {

        this.status = statusCode;
        this.data = data;
    }

    public ResultBean(int statusCode, T data, String msg) {
        this.status = statusCode;
        this.data = data;
        this.msg = msg;
    }

    public ResultBean(T data, String msg) {
        this.data = data;

        this.msg = msg;
    }

    @Override
    public String toString() {
        JSONObject json = new JSONObject();
        json.put("data", data);
        json.put("status", status);
        json.put("msg", msg);
        return json.toString();
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
