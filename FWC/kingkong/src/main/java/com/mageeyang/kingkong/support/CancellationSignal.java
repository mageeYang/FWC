package com.mageeyang.kingkong.support;

import android.os.RemoteException;

/**
 * Provides the ability to cancel an operation in progress.
 *
 * @author MageeYang
 * @datetime 2016/9/18
 * @description
 */
public class CancellationSignal {

    private boolean mIsCanceled;
    private OnCancelListener mOnCancelListener;
    private ICancellationSignal mRemote;
    private boolean mCancelInProgress;

    /**
     * Creates a cancellation signal, initially not canceled.
     */
    public CancellationSignal() {
    }
    /**
     * Returns true if the operation has been canceled.
     *
     * @return True if the operation has been canceled.
     */
    public boolean isCanceled() {
        synchronized (this) {
            return mIsCanceled;
        }
    }
    /**
     * Throws {@link OperationCanceledException} if the operation has been canceled.
     *
     * @throws OperationCanceledException if the operation has been canceled.
     */
    public void throwIfCanceled() {
        if (isCanceled()) {
            throw new OperationCanceledException();
        }
    }

    /**
     * Cancels the operation and signals the cancellation listener.
     * If the operation has not yet started, then it will be canceled as soon as it does.
     */
    public void cancel() {
        final OnCancelListener listener;
        final ICancellationSignal remote;
        synchronized (this) {
            if (mIsCanceled) {
                return;
            }
            mIsCanceled = true;
            mCancelInProgress = true;
            listener = mOnCancelListener;
            remote = mRemote;
        }
        try {
            if (listener != null) {
                listener.onCancel();
            }
            if (remote != null) {
                try {
                    remote.cancel();
                } catch (RemoteException ex) {
                }
            }
        } finally {
            synchronized (this) {
                mCancelInProgress = false;
                notifyAll();
            }
        }
    }


    /**
     * Listens for cancellation.
     */
    public interface OnCancelListener {
        /**
         * Called when {@link CancellationSignal#cancel} is invoked.
         */
        void onCancel();
    }

    private static final class Transport extends ICancellationSignal.Stub {
        final CancellationSignal mCancellationSignal = new CancellationSignal();
        @Override
        public void cancel() throws RemoteException {
            mCancellationSignal.cancel();
        }
    }




}
