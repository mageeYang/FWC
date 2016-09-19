package com.mageeyang.kingkong;

/**
 * This is used for {@link Cursor#copyStringToBuffer}
 *
 * @author MageeYang
 * @datetime 2016/9/19
 * @description
 */
public class CharArrayBuffer {

    public char[] data; // In and out parameter
    public int sizeCopied; // Out parameter


    public CharArrayBuffer(int size) {
        data = new char[size];
    }

    public CharArrayBuffer(char[] buf) {
        data = buf;
    }



}
