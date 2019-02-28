package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.wallet.j;
import com.tencent.mm.sdk.platformtools.x;

public final class c implements k {
    public static boolean aKG() {
        boolean aKK = ((l) g.h(l.class)).aKK();
        x.i("MicroMsg.FingerPrintAuthMgr", "isSupportFP is " + aKK);
        return aKK;
    }

    public static int a(com.tencent.mm.pluginsdk.wallet.c cVar, boolean z) {
        return ((l) g.h(l.class)).a(cVar, 0, z);
    }

    public static void release() {
        ((l) g.h(l.class)).aKQ();
    }

    public static void abort() {
        ((l) g.h(l.class)).aKR();
    }

    public static void aKH() {
        ((l) g.h(l.class)).aKH();
    }

    public static boolean aKI() {
        return ((l) g.h(l.class)).aKL();
    }

    public static j aKJ() {
        return ((l) g.h(l.class)).aKJ();
    }
}
