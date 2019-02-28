package com.tencent.mm.sdk.e;

import android.os.Looper;

public abstract class j implements f {
    public final k<a, l> xrX = new k<a, l>() {
        protected final /* synthetic */ void p(Object obj, Object obj2) {
            l lVar = (l) obj2;
            ((a) obj).a(lVar.fpd, lVar);
        }
    };
    private final k<Object, String> xrY = new k<Object, String>() {
        protected final /* bridge */ /* synthetic */ void p(Object obj, Object obj2) {
        }
    };

    public interface a {
        void a(String str, l lVar);
    }

    public void lock() {
        this.xrX.lock();
    }

    public void unlock() {
        this.xrX.unlock();
    }

    public void c(a aVar) {
        this.xrX.a(aVar, Looper.getMainLooper());
    }

    public void a(a aVar, Looper looper) {
        this.xrX.a(aVar, looper);
    }

    public final void j(a aVar) {
        this.xrX.remove(aVar);
    }

    public final void doNotify() {
        this.xrX.cb(new l("*"));
        this.xrX.doNotify();
    }

    public final void WI(String str) {
        this.xrX.cb(new l(str));
        this.xrX.doNotify();
    }

    public void b(String str, int i, Object obj) {
        l lVar = new l();
        lVar.fpd = str;
        lVar.jcn = i;
        lVar.obj = obj;
        lVar.xsg = this;
        this.xrX.cb(lVar);
        this.xrX.doNotify();
    }
}
