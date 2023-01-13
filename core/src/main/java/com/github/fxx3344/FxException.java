package com.github.fxx3344;

/**
 * <p>Title: FxException</p>
 * <p>Description: 异常基类</p>
 *
 * @author xi.feng
 * @version V1.0
 * @date 2021/7/29
 */
public class FxException extends RuntimeException{
    public FxException() {}

    public FxException(String message) {
        super(message);
    }

    public FxException(String message, Throwable cause) {
        super(message, cause);
    }

    public FxException(Throwable cause) {
        super(cause);
    }
}
