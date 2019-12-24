package com.zjy.result;

/**
 * 此类用来放置输出结果的json数据，假定返回结果中，code代表状态码，msg代表错误信息，data代表返回结果
 * 当code=0时，从data中取结果，当code不为0， 根据约定好的从msg中取错误信息
 * @param <T>
 */
public class Result<T> {

    private int code;
    private String msg;
    //因为不知道data是什么类型，先定义为T泛型
    private T data;

    //为方法success而定义的一个构造方法，当返回结果是正确的时候调用此构造方法
    private Result(T data){
        this.code = 0;
        this.msg = "success";
        this.data = data;
    }
    //为方法error定义的一个构造方法，当返回结果是错误的时候调用此构造方法
    private Result(CodeMsg cm){

        this.code = cm.getCode();
        this.msg = cm.getMsg();
    }
    /**
     * 成功时候的调用
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T data){
        return new Result<T>(data);
    }
    /**
     * 失败时候的调用
     * @param <T>
     * @return
     */
    public static <T> Result<T> error(CodeMsg cm){
        return new Result<T>(cm);
    }
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }




}

