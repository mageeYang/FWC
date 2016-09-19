package com.mageeyang.kingkong.database;


/**
 * An exception that indicates that the SQLite program was aborted.
 * This can happen either through a call to ABORT in a trigger,
 * or as the result of using the ABORT conflict clause.
 *
 * @author MageeYang
 * @datetime 2016/9/18
 * @description
 */
public class SQLiteAbortException extends SQLiteException {

    public SQLiteAbortException() {
    }

    public SQLiteAbortException(String str) {
        super(str);
    }
}
