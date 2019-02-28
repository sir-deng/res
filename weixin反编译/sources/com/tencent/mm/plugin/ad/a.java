package com.tencent.mm.plugin.ad;

import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.b.c;
import com.tencent.mm.kernel.g;
import java.util.List;

public final class a implements b, c {
    private static a pME;

    private a() {
    }

    public final List<String> collectStoragePaths() {
        return null;
    }

    public static synchronized a bnR() {
        a aVar;
        synchronized (a.class) {
            if (pME == null) {
                pME = new a();
            }
            aVar = pME;
        }
        return aVar;
    }

    public static String Fr() {
        return g.Dq().gRT + "remark/";
    }
}
