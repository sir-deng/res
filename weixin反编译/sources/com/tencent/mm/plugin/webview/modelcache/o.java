package com.tencent.mm.plugin.webview.modelcache;

import android.util.SparseArray;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.bi;

public final class o {
    private final j tAj;
    public final SparseArray<Object> tAk;
    public final SparseArray<Boolean> tAl;

    private static final class a {
        private static final o tAm = new o();
    }

    /* synthetic */ o(byte b) {
        this();
    }

    private o() {
        this.tAj = new j();
        this.tAk = new SparseArray();
        this.tAl = new SparseArray();
    }

    public static boolean a(String str, d dVar, int i) {
        a.tAm;
        bi.oN(str);
        return false;
    }
}
