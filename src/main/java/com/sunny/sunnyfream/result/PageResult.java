package com.sunny.sunnyfream.result;

import lombok.Data;

@Data
public class PageResult<T> {
    private String code;
    private String msg;
    private Integer count;
    private T data;

    public static <T> PageResult<T> success(T data) {
        return new PageResult<>(data);
    }

    public static <T> PageResult<T> error(CodeMsg codeMsg) {
        return new PageResult<>(codeMsg);
    }

    private PageResult(T data) {
        this.code = "0";
        this.msg = "success";
        this.count = 2;
        this.data = data;
    }

    private PageResult(CodeMsg codeMsg) {
        if (codeMsg == null) {
            return;
        }
        this.code = codeMsg.getCode();
        this.msg = codeMsg.getMsg();
    }
}
