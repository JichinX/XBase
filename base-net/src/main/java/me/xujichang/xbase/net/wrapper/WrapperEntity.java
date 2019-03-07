package me.xujichang.xbase.net.wrapper;

/**
 * Created by xjc on 2017/9/28.
 */

public class WrapperEntity<T> implements IWrapper<T> {
    private int code;
    private String message;
    private T data;

    public int getCode() {
        return code;
    }


    public void setCode(int code) {
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

    @Override
    public int get_Code() {
        return code;
    }

    @Override
    public String get_Msg() {
        return message;
    }

    @Override
    public T get_Data() {
        return data;
    }
}
