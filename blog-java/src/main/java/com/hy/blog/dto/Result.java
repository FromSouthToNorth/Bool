package com.hy.blog.dto;

import com.hy.blog.enums.ResultEnum;

public class Result<T> {

    private ResultEnum resultEnum;
    private T data;

    public Result() {
    }

    public Result(ResultEnum resultEnum, T data) {
        this.resultEnum = resultEnum;
        this.data = data;
    }


    public ResultEnum getResultEnum() {
        return resultEnum;
    }

    public void setResultEnum(ResultEnum resultEnum) {
        this.resultEnum = resultEnum;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
