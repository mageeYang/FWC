package com.mageeyang.kingkong.support;

/**
 * An exception type that is thrown when an operation in progress is canceled
 *
 * @author MageeYang
 * @datetime 2016/9/19
 * @description
 */
public class OperationCanceledException extends RuntimeException {

    public OperationCanceledException() {
        this(null);
    }

    public OperationCanceledException(String message) {
        super(message != null ? message : "The operation has been canceled.");
    }
}
