package com.mageeyang.kingkong.database;

/**
 * SQLiteTableLockedException
 *
 * @author MageeYang
 * @datetime 2016/9/19
 * @description
 */
public class SQLiteTableLockedException extends SQLiteException {
    public SQLiteTableLockedException() {
    }

    public SQLiteTableLockedException(String error) {
        super(error);
    }
}
