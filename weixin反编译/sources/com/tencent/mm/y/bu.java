package com.tencent.mm.y;

import com.tencent.mm.ad.d;
import com.tencent.mm.ad.d.a;
import com.tencent.mm.ad.d.b;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.t;
import java.util.Map;

public final class bu implements d {
    public final b b(a aVar) {
        bx bxVar = aVar.hoa;
        if (bxVar == null) {
            x.e("MicroMsg.SysNoticeMsgExtension", "onPreAddMessage cmdAM is null");
        } else {
            try {
                Map y = bj.y("<root>" + bxVar.vNO + "</root>", "root");
                int intValue = Integer.valueOf((String) y.get(".root.newcount")).intValue();
                int intValue2 = Integer.valueOf((String) y.get(".root.version")).intValue();
                as.Hm();
                t Db = c.Db();
                if (intValue2 == bi.e((Integer) Db.get(12305, null))) {
                    x.i("MicroMsg.SysNoticeMsgExtension", "ignore new sys notice count, same version");
                } else {
                    Db.set(12304, Integer.valueOf(intValue));
                    Db.set(12305, Integer.valueOf(intValue2));
                }
            } catch (Throwable e) {
                x.e("MicroMsg.SysNoticeMsgExtension", "exception:%s", bi.i(e));
            }
        }
        return null;
    }

    public final void h(au auVar) {
    }
}
