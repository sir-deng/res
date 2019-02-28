package com.tencent.mm.plugin.welab;

import android.text.TextUtils;
import com.tencent.mm.ap.a.a.c;
import com.tencent.mm.plugin.welab.c.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b {
    private static final b tVU = new b();
    public a tVV;
    public Map<String, com.tencent.mm.plugin.welab.a.a.b> tVW = new HashMap();
    public com.tencent.mm.plugin.welab.a.a.b tVX;
    public c trR;

    public b() {
        c.a aVar = new c.a();
        aVar.hFl = true;
        aVar.hFk = true;
        this.trR = aVar.PQ();
    }

    public static b bWh() {
        return tVU;
    }

    public static String a(com.tencent.mm.plugin.welab.c.a.a aVar) {
        String str = "";
        com.tencent.mm.plugin.welab.a.a.b Ra = tVU.Ra(aVar.field_LabsAppId);
        if (Ra != null) {
            str = aVar.field_LabsAppId;
            str = Ra.bWq();
            x.i("WelabMgr", "get appName from opener , appid %s, appName %s", aVar.field_LabsAppId, str);
        }
        if (TextUtils.isEmpty(str)) {
            return aVar.Ri("field_Title");
        }
        return str;
    }

    public static String b(com.tencent.mm.plugin.welab.c.a.a aVar) {
        String str = "";
        com.tencent.mm.plugin.welab.a.a.b Ra = tVU.Ra(aVar.field_LabsAppId);
        if (Ra != null) {
            str = aVar.field_LabsAppId;
            str = Ra.bWp();
            x.i("WelabMgr", "get icon url from opener , appid %s, url %s", aVar.field_LabsAppId, str);
        }
        if (TextUtils.isEmpty(str)) {
            return aVar.field_Icon;
        }
        return str;
    }

    private com.tencent.mm.plugin.welab.a.a.b Ra(String str) {
        return (com.tencent.mm.plugin.welab.a.a.b) this.tVW.get(str);
    }

    public static void L(boolean z, boolean z2) {
        f.M(z, z2);
    }

    public final List<com.tencent.mm.plugin.welab.c.a.a> bWi() {
        List<com.tencent.mm.plugin.welab.c.a.a> bWr = this.tVV.bWr();
        Iterator it = bWr.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.welab.c.a.a aVar = (com.tencent.mm.plugin.welab.c.a.a) it.next();
            if (!aVar.isRunning() || (!(aVar.field_Switch == 2 || aVar.field_Switch == 1) || "labs1de6f3".equals(aVar.field_LabsAppId))) {
                it.remove();
            }
        }
        return bWr;
    }

    public final com.tencent.mm.plugin.welab.c.a.a Rb(String str) {
        a aVar = this.tVV;
        com.tencent.mm.sdk.e.c aVar2 = new com.tencent.mm.plugin.welab.c.a.a();
        aVar2.field_LabsAppId = str;
        aVar.b(aVar2, new String[0]);
        return aVar2;
    }
}
