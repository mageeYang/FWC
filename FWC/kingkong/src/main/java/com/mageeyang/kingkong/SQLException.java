package com.mageeyang.kingkong;

/**
 * An exception that indicates there was an error with SQL parsing or execution.
 *
 * @author MageeYang
 * @datetime 2016/9/18
 * @description
 */
public class SQLException extends RuntimeException {

    public SQLException(String str){
        super(str);
    }

    public SQLException(String str,Throwable throwable){
        super(str,throwable);
    }
}
