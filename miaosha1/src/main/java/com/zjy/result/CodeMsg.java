package com.zjy.result;

/**
 * 此类用于Result的error方法调用，传入 的参数为CodeMsg的对象
 * 两个参数，一个code，一个msg
 */
public class CodeMsg {

    private int code;
    private String msg;

    private CodeMsg(int code, String msg){
        this.code = code;
        this.msg = msg;
    }
    //定义错误码信息
    public static CodeMsg SUCCESS = new CodeMsg(0, "success");
    public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "服务端异常");

    public static CodeMsg MOBILE_NOT_EXIST = new CodeMsg(500201, "手机号不存在");
    public static CodeMsg PASSWORD_ERROR = new CodeMsg(500202, "密码错误");
    public static CodeMsg PASSWORD_EMPTY = new CodeMsg(500203, "密码为空");
    public static CodeMsg MOBILE_ERROR = new CodeMsg(500204, "手机号错误");

    public static CodeMsg BIND_ERROR = new CodeMsg(500301, "参数校验异常");

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public CodeMsg fillArgs(Object... args){
        int code = this.code;
        String message = String.format(this.msg, args);
        return new CodeMsg(code, message);
    }


}
