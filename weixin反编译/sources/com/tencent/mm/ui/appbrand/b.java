package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.si;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.n.c;
import com.tencent.mm.protocal.c.boh;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.y.as;
import java.util.LinkedList;

public final class b {
    public static void i(final Context context, final String str, final boolean z) {
        int i = 1;
        com.tencent.mm.sdk.b.b siVar = new si();
        siVar.fKS.foe = str;
        siVar.fKS.action = z ? 2 : 1;
        siVar.fKS.fKU = 2;
        a.xmy.m(siVar);
        LinkedList linkedList = new LinkedList();
        boh boh = new boh();
        boh.wXP = str;
        if (!z) {
            i = 0;
        }
        boh.wXO = i;
        boh.kzz = 3;
        linkedList.add(boh);
        as.CN().a(1176, new e() {
            public final void a(int i, int i2, String str, k kVar) {
                int i3 = 1;
                as.CN().b(1176, (e) this);
                x.d("MicroMsg.AppBrandServiceHelper", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(true));
                if (i != 0 || i2 != 0) {
                    u.makeText(context, R.l.ezL, 0).show();
                    com.tencent.mm.sdk.b.b siVar = new si();
                    siVar.fKS.foe = str;
                    si.a aVar = siVar.fKS;
                    if (!z) {
                        i3 = 2;
                    }
                    aVar.action = i3;
                    siVar.fKS.fKU = 2;
                    a.xmy.m(siVar);
                }
            }
        });
        as.CN().a(new com.tencent.mm.modelappbrand.k(linkedList), 0);
    }

    public static String Zi(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        WxaAttributes rf = ((c) g.h(c.class)).rf(str);
        if (rf != null && rf.acq() != null) {
            return rf.acq().iSH;
        }
        x.e("MicroMsg.AppBrandServiceHelper", "attr is null or getAppInfo return null");
        return null;
    }

    public static String Zj(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        WxaAttributes rf = ((c) g.h(c.class)).rf(str);
        if (rf != null) {
            return rf.field_nickname;
        }
        x.e("MicroMsg.AppBrandServiceHelper", "attr is null or getAppInfo return null");
        return null;
    }
}
