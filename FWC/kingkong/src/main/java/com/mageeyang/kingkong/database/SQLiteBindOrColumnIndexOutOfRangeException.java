package com.mageeyang.kingkong.database;

/**
 * Thrown if the the bind or column parameter index is out of range
 *
 * @author MageeYang
 * @datetime 2016/9/18
 * @description
 */
public class SQLiteBindOrColumnIndexOutOfRangeException extends SQLiteException {

    public SQLiteBindOrColumnIndexOutOfRangeException() {
    }

    public SQLiteBindOrColumnIndexOutOfRangeException(String str) {
        super(str);
    }
}
