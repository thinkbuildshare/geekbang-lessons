package org.geektimes.exception;

/**
 * @Author hxchen
 * @Date 2021/3/10
 */
public class BizException extends RuntimeException {
    public BizException(String message) {
        super(message);
    }
}
