package com.tencent.mm.plugin.fingerprint;

import com.tencent.mm.bx.h.d;
import com.tencent.mm.plugin.fingerprint.b.b;
import com.tencent.mm.plugin.fingerprint.b.c;
import com.tencent.mm.plugin.fingerprint.b.f;
import com.tencent.mm.plugin.fingerprint.b.g;
import com.tencent.mm.plugin.fingerprint.b.i;
import com.tencent.mm.plugin.fingerprint.b.j;
import com.tencent.mm.plugin.fingerprint.b.k;
import com.tencent.mm.plugin.fingerprint.b.n;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.p;
import java.util.HashMap;

public class a implements ap {
    private n mEC = new n();
    private i mED = new i();
    private j mEE = new j();
    private b mEF = new b();
    private f mEG = new f();
    private g mEH = new g();
    private c mEI;

    static {
        com.tencent.mm.wallet_core.a.i("FingerprintAuth", com.tencent.mm.plugin.fingerprint.ui.a.class);
    }

    public static a aKz() {
        return (a) p.s(a.class);
    }

    public final HashMap<Integer, d> Bu() {
        return null;
    }

    public final void ge(int i) {
    }

    public final void bs(boolean z) {
        x.i("MicroMsg.SubCoreFingerPrint", "alvinluo SoterWrapperApi isInit: %b in SubCoreFingerprint initTA", Boolean.valueOf(com.tencent.d.b.b.a.cGQ().isInit()));
        if (com.tencent.d.b.b.a.cGQ().isInit()) {
            aKB();
        } else {
            x.i("MicroMsg.SubCoreFingerPrint", "alvinluo soter is not initialized, do init");
            com.tencent.mm.kernel.g.a(l.class, new com.tencent.mm.plugin.fingerprint.b.d());
            com.tencent.mm.kernel.g.Dt().g(new Runnable() {
                public final void run() {
                    x.i("MicroMsg.SubCoreFingerPrint", "alvinluo post 1500ms delayed");
                    a.aKB();
                }
            }, 1500);
        }
        com.tencent.mm.sdk.b.a.xmy.b(this.mEC);
        com.tencent.mm.sdk.b.a.xmy.b(this.mED);
        com.tencent.mm.sdk.b.a.xmy.b(this.mEE);
        com.tencent.mm.sdk.b.a.xmy.b(this.mEF);
        com.tencent.mm.sdk.b.a.xmy.b(this.mEG);
        com.tencent.mm.sdk.b.a.xmy.b(this.mEH);
    }

    public final void bt(boolean z) {
    }

    public final void onAccountRelease() {
        com.tencent.mm.sdk.b.a.xmy.c(this.mEC);
        this.mED.release();
        com.tencent.mm.sdk.b.a.xmy.c(this.mED);
        com.tencent.mm.sdk.b.a.xmy.c(this.mEE);
        com.tencent.mm.sdk.b.a.xmy.c(this.mEF);
        com.tencent.mm.sdk.b.a.xmy.c(this.mEG);
        if (this.mEI != null) {
            c.abort();
            c.release();
            this.mEI = null;
        }
        com.tencent.mm.sdk.b.a.xmy.c(this.mEH);
    }

    public static c aKA() {
        com.tencent.mm.kernel.g.Do().CA();
        if (aKz().mEI == null) {
            aKz().mEI = new c();
        }
        return aKz().mEI;
    }

    private static void aKB() {
        com.tencent.mm.kernel.c.a kVar;
        if (com.tencent.d.b.a.cGP()) {
            kVar = new k();
        } else {
            kVar = new com.tencent.mm.plugin.fingerprint.b.d();
        }
        kVar.aKM();
        com.tencent.mm.kernel.g.a(l.class, kVar);
    }
}
