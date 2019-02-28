package com.tencent.mm.kernel.a;

import com.tencent.mm.kernel.a.a.b;
import com.tencent.mm.kernel.j;

public final class a {
    public static long gST;
    public static long gSU;
    public b gSR;
    public b gSS;
    public volatile boolean mConfigured = false;

    public static final void a(String str, Object... objArr) {
        if (objArr.length == 0) {
            j.i("MMSkeleton.Boot", str, new Object[0]);
        } else {
            j.i("MMSkeleton.Boot", str, objArr);
        }
    }

    public static String aH(long j) {
        return (System.currentTimeMillis() - j) + "ms";
    }
}
