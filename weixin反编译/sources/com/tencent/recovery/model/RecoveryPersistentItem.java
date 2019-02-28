package com.tencent.recovery.model;

import android.os.Parcelable;

public abstract class RecoveryPersistentItem implements Parcelable {
    public abstract boolean abw(String str);

    public abstract String cEe();

    public String toString() {
        return cEe();
    }
}
