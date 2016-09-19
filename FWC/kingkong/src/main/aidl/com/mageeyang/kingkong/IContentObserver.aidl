// IContentObserver.aidl
package com.mageeyang.kingkong;

import android.net.Uri;
// Declare any non-default types here with import statements

interface IContentObserver {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void onChange(boolean z,in Uri uri);
}
