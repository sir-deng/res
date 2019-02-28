package com.tencent.mm.plugin.welab;

import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

public final class e {

    public static class a {
        public int action;
        public String fGh;
        public long hQu;
        public String tVY;
        public boolean tVZ;
    }

    public static void a(a aVar) {
        int i;
        d dVar = new d();
        dVar.q("expid", aVar.tVY + ",");
        dVar.q("appid", aVar.fGh + ",");
        dVar.q("action", aVar.action + ",");
        dVar.q("timestamp", aVar.hQu + ",");
        String str = "hasRedPoint";
        StringBuilder stringBuilder = new StringBuilder();
        if (aVar.tVZ) {
            i = 1;
        } else {
            i = 0;
        }
        dVar.q(str, stringBuilder.append(i).append(",").toString());
        x.i("WelabReporter", "report " + dVar.SG());
        g.pWK.h(14206, dVar);
    }

    public static void o(String str, int i, boolean z) {
        a aVar = new a();
        aVar.fGh = str;
        aVar.action = i;
        aVar.hQu = System.currentTimeMillis();
        aVar.tVY = b.bWh().Rb(str).field_expId;
        aVar.tVZ = z;
        a(aVar);
    }
}
