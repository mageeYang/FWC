package com.mageeyang.kingkong;

/**
 * DataSetObserver
 *
 * @author MageeYang
 * @datetime 2016/9/19
 * @description
 */
public class DataSetObserver extends android.database.DataSetObserver {

    /**
     * This method is called when the entire data set has changed,
     * most likely through a call to {@link Cursor#requery()} on a {@link Cursor}.
     */
    public void onChanged() {
        // Do nothing
    }

    /**
     * This method is called when the entire data becomes invalid,
     * most likely through a call to {@link Cursor#deactivate()} or {@link Cursor#close()} on a
     * {@link Cursor}.
     */
    public void onInvalidated() {
        // Do nothing
    }
}
