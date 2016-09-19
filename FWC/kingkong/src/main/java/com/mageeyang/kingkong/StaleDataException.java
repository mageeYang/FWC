package com.mageeyang.kingkong;

/**
 * This exception is thrown when a Cursor contains stale data and must be
 * requeried before being used again.
 *
 * @author MageeYang
 * @datetime 2016/9/19
 * @description
 */
public class StaleDataException extends  RuntimeException {

    public StaleDataException()
    {
        super();
    }

    public StaleDataException(String description)
    {
        super(description);
    }
}
