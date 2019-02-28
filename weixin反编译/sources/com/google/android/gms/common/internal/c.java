package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.c.b;

public final class c<T extends IInterface> extends k<T> {
    private final d<T> aNr;

    public c(Context context, Looper looper, int i, b bVar, com.google.android.gms.common.api.c.c cVar, h hVar, d dVar) {
        super(context, looper, i, hVar, bVar, cVar);
        this.aNr = dVar;
    }

    protected final T f(IBinder iBinder) {
        return this.aNr.oa();
    }

    protected final String nY() {
        return this.aNr.nY();
    }

    protected final String nZ() {
        return this.aNr.nZ();
    }
}
