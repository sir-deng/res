package com.tencent.mm.plugin.soter.d;

import android.content.SharedPreferences;
import com.tencent.d.a.c.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;

public final class d implements a<Boolean, Boolean> {
    private b iiC = null;

    public final /* synthetic */ Object call(Object obj) {
        Boolean bool = (Boolean) obj;
        this.iiC = g.cAI();
        x.v("MicroMsg.SoterSaveDeviceInfoFunc", "alvinluo isNeedSaveDeviceInfo: %b", bool);
        if (!com.tencent.d.b.a.cGP()) {
            x.w("MicroMsg.SoterSaveDeviceInfoFunc", "alvinluo not support soter");
            this.iiC.cm(g.u(Integer.valueOf(2), "not support soter"));
        } else if (bool.booleanValue()) {
            SharedPreferences cgg = ad.cgg();
            if (cgg != null) {
                x.i("MicroMsg.SoterSaveDeviceInfoFunc", "alvinluo old cpuId: %s, old uid: %s", cgg.getString("cpu_id", null), cgg.getString("uid", null));
                if (bi.oN(cgg.getString("cpu_id", null)) || bi.oN(r0)) {
                    h cGG = com.tencent.d.a.a.cGG();
                    if (cGG != null) {
                        String str = cGG.rYp;
                        String valueOf = String.valueOf(cGG.uid);
                        if (!(bi.oN(str) || bi.oN(valueOf))) {
                            com.tencent.mm.plugin.soter.c.b.ex(str, valueOf);
                        }
                    }
                }
            }
        }
        return Boolean.valueOf(true);
    }
}
