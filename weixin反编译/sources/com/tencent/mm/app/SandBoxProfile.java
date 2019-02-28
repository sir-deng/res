package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.mm.booter.c;
import com.tencent.mm.booter.u;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class SandBoxProfile extends e {
    public static final String ffs = (ad.getPackageName() + ":sandbox");

    public final void onCreate() {
        c aA = c.aA(ad.getContext());
        k.setupBrokenLibraryHandler();
        k.b(a.xmo, SandBoxProfile.class.getClassLoader());
        k.b("MMProtocalJni", SandBoxProfile.class.getClassLoader());
        k.b(a.xmq, SandBoxProfile.class.getClassLoader());
        MMProtocalJni.setClientPackVersion(d.vHl);
        u uVar = new u(aA);
        try {
            uVar.eg("SANDBOX");
            r.ifC = bi.a(uVar.eh(".com.tencent.mm.debug.test.network.simulate_down_fault"), false);
            x.i("MicroMsg.SandboxDebugger", "Test.simulateDownFault = " + r.ifC);
        } catch (Error e) {
        }
        m.ua();
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final String toString() {
        return ffs;
    }
}
