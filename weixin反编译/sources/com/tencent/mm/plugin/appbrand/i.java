package com.tencent.mm.plugin.appbrand;

import android.support.v4.e.a;
import com.tencent.mm.protocal.c.acw;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class i {
    private static final Map<String, i> gOD = new a();
    private static final i iuc = new i();
    public volatile String iud;
    public final AtomicInteger iue = new AtomicInteger();
    public final AtomicBoolean iuf = new AtomicBoolean(false);
    public int iug = 0;
    public volatile acw iuh;
    public volatile String iui;
    public volatile String iuj;

    private i() {
    }

    static i pB(String str) {
        return pC(str);
    }

    private static i pC(String str) {
        if (bi.oN(str)) {
            return null;
        }
        i iVar;
        synchronized (gOD) {
            iVar = (i) gOD.get(str);
            if (iVar == null) {
                iVar = new i();
                gOD.put(str, iVar);
            }
        }
        return iVar;
    }

    private static i pD(String str) {
        if (bi.oN(str)) {
            return null;
        }
        i iVar;
        synchronized (gOD) {
            iVar = (i) gOD.get(str);
        }
        return iVar;
    }

    static void remove(String str) {
        if (!bi.oN(str)) {
            synchronized (gOD) {
                gOD.remove(str);
            }
        }
    }

    public static i pE(String str) {
        i pD = pD(str);
        return pD == null ? iuc : pD;
    }

    public static i pF(String str) {
        return pC(str);
    }
}
