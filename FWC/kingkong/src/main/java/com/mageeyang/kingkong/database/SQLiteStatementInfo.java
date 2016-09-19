package com.mageeyang.kingkong.database;

/**
 * Describes a SQLite statement.
 *
 * @author MageeYang
 * @datetime 2016/9/19
 * @description
 * @hide
 */
public final class SQLiteStatementInfo {

    /**
     * The number of parameters that the statement has.
     */
    public int numParameters;

    /**
     * The names of all columns in the result set of the statement.
     */
    public String[] columnNames;

    /**
     * True if the statement is read-only.
     */
    public boolean readOnly;
}
