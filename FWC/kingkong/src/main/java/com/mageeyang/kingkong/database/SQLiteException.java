package com.mageeyang.kingkong.database;

import com.mageeyang.kingkong.SQLException;

/**
 * A SQLite exception that indicates there was an error with SQL parsing or execution.
 *
 * @author MageeYang
 * @datetime 2016/9/18
 * @description
 */
public class SQLiteException extends SQLException {

    public SQLiteException(String str) {
        super(str);
    }
    public SQLiteException(String str, Throwable th) {
        super(str, th);
    }

}
