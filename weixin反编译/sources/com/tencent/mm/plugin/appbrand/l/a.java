package com.tencent.mm.plugin.appbrand.l;

import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.t;
import java.util.Map;

public final class a implements m {
    public final void b(String str, Map<String, String> map, com.tencent.mm.ad.d.a aVar) {
        x.i("MicroMsg.P8TemplateMsgHandler", "hy: received flag msg!");
        if (map == null || map.size() == 0) {
            x.e("MicroMsg.P8TemplateMsgHandler", "hy: null values");
            g.pWK.h(836, 1);
            g.pWK.h(15240, Integer.valueOf(0), Integer.valueOf(1));
            return;
        }
        int i = bi.getInt((String) map.get(".sysmsg.Proj8Tags.Attended"), -1);
        x.d("MicroMsg.P8TemplateMsgHandler", "hy: got from svr: %d", Integer.valueOf(i));
        if (i >= 0) {
            synchronized (b.akm().jMz) {
                boolean z;
                t Db = com.tencent.mm.kernel.g.Dq().Db();
                com.tencent.mm.storage.w.a aVar2 = com.tencent.mm.storage.w.a.USERINFO_V8_ATTENDED_FLAG_BOOLEAN_SYNC;
                if (i > 0) {
                    z = true;
                } else {
                    z = false;
                }
                Db.a(aVar2, Boolean.valueOf(z));
            }
            g.pWK.h(836, 0);
            g.pWK.h(15240, Integer.valueOf(0), Integer.valueOf(0));
            return;
        }
        x.e("MicroMsg.P8TemplateMsgHandler", "hy: error new xml! %s", map.toString());
        g.pWK.h(836, 1);
        g.pWK.h(15240, Integer.valueOf(0), Integer.valueOf(1));
    }
}
