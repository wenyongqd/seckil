package com.codemaster.seckil.base.result;

public enum ResultCode {

    // 秒课错误: 500100 - 500199
    SECKILL_LINE_UP(500100, "You are lining up..."),
    SECKILL_NO_QUOTE(500101, "Your are in the waiting lists for this course, any questions please contact staff."),
    SECKILL_BOUGHT(500102, "You have bought this course, please check in orders"),
    SECKILL_PATH_ERROR(500104, "你的请求地址不正确，请联系小姐姐。"),
    SECKILL_IP_OUTMAX(500105, "Your requests are too frequent, please take a rest."),

    SUCCESS(200, "Success"),
    FAIL(500, "Error"),
    USER_LOGIN_ERROR(500201, "Incorrect user name or password, please try again.");




    private Integer code;

    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
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

}