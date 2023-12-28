package com.exception;

/**
 * @author jiabaobao
 * @date 2023/12/23 5:32 PM
 */
public class LowLevelExcetion extends Exception{

    public LowLevelExcetion(String message) {
        super(message);
    }

    public LowLevelExcetion(String message, Throwable cause) {
        super(message, cause);
    }

    public LowLevelExcetion(Throwable cause) {
        super(cause);
    }

}
