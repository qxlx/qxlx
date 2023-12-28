package com.exception;

/**
 * @author jiabaobao
 * @date 2023/12/23 5:38 PM
 */
public class HighLevelException extends Exception{

    public HighLevelException() {
    }

    public HighLevelException(String message) {
        super(message);
    }

    public HighLevelException(String message, Throwable cause) {
        super(message, cause);
    }

    public HighLevelException(Throwable cause) {
        super(cause);
    }
}
