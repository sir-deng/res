package com.tencent.mm.sdk;

import com.tencent.mm.sdk.platformtools.ba;

public class b<T> extends ba<T> {
    private final Object mLock = new Object();

    public b() {
        super(20);
    }

    public final T bH() {
        T bH;
        synchronized (this.mLock) {
            bH = super.bH();
        }
        return bH;
    }

    public final boolean j(T t) {
        boolean j;
        synchronized (this.mLock) {
            j = super.j(t);
        }
        return j;
    }
}
