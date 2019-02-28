package com.tencent.mm.vending.h;

import android.os.Handler;
import android.os.Looper;

public final class h extends d {
    Looper mLooper;
    public String mType;
    public a zMe;

    private h(Looper looper, a aVar, String str) {
        this.mLooper = looper;
        this.zMe = aVar;
        this.mType = str;
    }

    public h(Handler handler, String str) {
        this(new b(handler), str);
    }

    public h(a aVar, String str) {
        this(aVar.getLooper(), aVar, str);
    }

    public h(Looper looper, String str) {
        this(new Handler(looper), str);
    }

    public final String getType() {
        return this.mType;
    }

    public final void cancel() {
        this.zMe.co();
    }

    public final void f(Runnable runnable) {
        this.zMe.i(runnable);
    }

    public final void f(Runnable runnable, long j) {
        if (j >= 0) {
            this.zMe.j(runnable, j);
        } else {
            this.zMe.i(runnable);
        }
    }
}
