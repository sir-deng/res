package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.h;
import com.google.android.gms.wearable.internal.bi;

public final class e extends h<d> implements g {
    public final Status bcR;

    public e(DataHolder dataHolder) {
        super(dataHolder);
        this.bcR = new Status(dataHolder.aJD);
    }

    protected final /* synthetic */ Object av(int i, int i2) {
        return new bi(this.aMc, i, i2);
    }

    protected final String oA() {
        return "path";
    }

    public final Status oh() {
        return this.bcR;
    }
}
