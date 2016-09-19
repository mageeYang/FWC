package com.mageeyang.kingkong.database;

/**
 * A listener for transaction events.
 *
 * @author MageeYang
 * @datetime 2016/9/19
 * @description
 */
public interface SQLiteTransactionListener {
    /**
     * Called immediately after the transaction begins.
     */
    void onBegin();

    /**
     * Called immediately before commiting the transaction.
     */
    void onCommit();

    /**
     * Called if the transaction is about to be rolled back.
     */
    void onRollback();
}
