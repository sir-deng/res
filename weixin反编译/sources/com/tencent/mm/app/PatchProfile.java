package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.mm.booter.c;
import com.tencent.mm.booter.s;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.e.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class PatchProfile extends e {
    public static final String ffs = (ad.getPackageName() + ":patch");

    public final void onCreate() {
        int intValue;
        long currentTimeMillis = System.currentTimeMillis();
        s sVar = new s(c.aA(this.app.getBaseContext()));
        sVar.eg("PATCH");
        try {
            intValue = Integer.decode(sVar.getString(".com.tencent.mm.debug.log.setversion")).intValue();
            d.CX(intValue);
            new StringBuilder("set up test protocal version = ").append(Integer.toHexString(intValue));
        } catch (Exception e) {
            x.i("MicroMsg.PatchDebugger", "no debugger was got");
        }
        try {
            String string = sVar.getString(".com.tencent.mm.debug.log.setapilevel");
            if (!bi.oN(string)) {
                d.DEVICE_TYPE = "android-" + string;
                d.vHg = "android-" + string;
                d.vHi = string;
                b.Vn(string);
                new StringBuilder("set up test protocal apilevel = ").append(d.DEVICE_TYPE).append(" ").append(b.cfy());
            }
        } catch (Exception e2) {
            x.i("MicroMsg.PatchDebugger", "no debugger was got");
        }
        try {
            intValue = Integer.decode(sVar.getString(".com.tencent.mm.debug.log.setuin")).intValue();
            new StringBuilder("set up test protocal uin old: ").append(d.vHk).append(" new: ").append(intValue);
            d.vHk = (long) intValue;
        } catch (Exception e3) {
            x.i("MicroMsg.PatchDebugger", "no debugger was got");
        }
        try {
            boolean a = bi.a(sVar.eh(".com.tencent.mm.debug.report.debugmodel"), false);
            boolean a2 = bi.a(sVar.eh(".com.tencent.mm.debug.report.kvstat"), false);
            boolean a3 = bi.a(sVar.eh(".com.tencent.mm.debug.report.clientpref"), false);
            boolean a4 = bi.a(sVar.eh(".com.tencent.mm.debug.report.useraction"), false);
            com.tencent.mm.plugin.report.a.c.a(a, a2, a3, a4);
            new StringBuilder("try control report : debugModel[").append(a).append("],kv[").append(a2).append("], clientPref[").append(a3).append("], useraction[").append(a4).append("]");
        } catch (Exception e4) {
            x.i("MicroMsg.PatchDebugger", "no debugger was got");
        }
        a.ay(ad.getContext());
        i.cq(ffs);
        k.setupBrokenLibraryHandler();
        k.b(com.tencent.mm.sdk.a.xmo, PatchProfile.class.getClassLoader());
        m.ua();
        x.i("MicroMsg.PatchProfile", "patchsprofile try to init hotpatch plugin");
        com.tencent.mm.bl.d.a("hp", null, null);
        com.tencent.mm.bl.d.TI("hp");
        x.i("MicroMsg.PatchProfile", "start time check patchsprofile use time = " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final String toString() {
        return ffs;
    }
}
