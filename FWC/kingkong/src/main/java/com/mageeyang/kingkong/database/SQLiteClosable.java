package com.mageeyang.kingkong.database;

import java.io.Closeable;
import java.io.IOException;

/**
 * An object created from a SQLiteDatabase that can be closed.
 * This class implements a primitive reference counting scheme for database objects.
 *
 * @author MageeYang
 * @datetime 2016/9/18
 * @description
 */
public abstract class SQLiteClosable implements Closeable {

    private int mReferenceCount = 1;

    /**
     * Called when the last reference to the object was released by
     * a call to {@link #releaseReference()} or {@link #close()}.
     */
    protected abstract void onAllReferencesReleased();


    /**
     * Called when the last reference to the object was released by
     * a call to {@link #releaseReferenceFromContainer()}.
     *
     * @deprecated Do not use.
     */
    @Deprecated
    protected void onAllReferencesReleasedFromContainer() {
        onAllReferencesReleased();
    }

    /**
     * Acquires a reference to the object.
     *
     * @throws IllegalStateException if the last reference to the object has already
     *                               been released.
     */
    public void acquireReference() {
        synchronized (this) {
            if (mReferenceCount <= 0) {
                throw new IllegalStateException(
                        "attempt to re-open an already-closed object: " + this);
            }
            mReferenceCount++;
        }
    }

    /**
     * Releases a reference to the object, closing the object if the last reference
     * was released.
     *
     * @see #onAllReferencesReleased()
     */
    public void releaseReference() {
        boolean refCountIsZero = false;
        synchronized (this) {
            refCountIsZero = --mReferenceCount == 0;
        }
        if (refCountIsZero) {
            onAllReferencesReleased();
        }
    }

    /**
     * Releases a reference to the object that was owned by the container of the object,
     * closing the object if the last reference was released.
     *
     * @see #onAllReferencesReleasedFromContainer()
     * @deprecated Do not use.
     */
    @Deprecated
    public void releaseReferenceFromContainer() {
        boolean refCountIsZero = false;
        synchronized (this) {
            refCountIsZero = --mReferenceCount == 0;
        }
        if (refCountIsZero) {
            onAllReferencesReleasedFromContainer();
        }
    }

    /**
     * Releases a reference to the object, closing the object if the last reference
     * was released.
     * <p>
     * Calling this method is equivalent to calling {@link #releaseReference}.
     *
     * @see #releaseReference()
     * @see #onAllReferencesReleased()
     */
    @Override
    public void close() {
        releaseReference();
    }
}
