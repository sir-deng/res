package com.tencent.mm.ui.chatting;

import com.tencent.mm.ap.e;
import com.tencent.mm.ap.o;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.x.g.a;

public final class ab {
    public static String fZ(long j) {
        String f = f(o.PC().bj(j));
        return f != null ? f : null;
    }

    public static String ga(long j) {
        String f = f(o.PC().bi(j));
        return f != null ? f : null;
    }

    private static String f(e eVar) {
        if (eVar != null) {
            String str;
            if (eVar.Pk()) {
                str = eVar.hBB;
                if (str != null && com.tencent.mm.a.e.bO(str)) {
                    return str;
                }
            }
            str = o.PC().m(eVar.hBB, null, null);
            if (str != null && com.tencent.mm.a.e.bO(str)) {
                return str;
            }
            str = o.PC().m(eVar.hBD, null, null);
            if (str != null && com.tencent.mm.a.e.bO(str)) {
                return str;
            }
        }
        return null;
    }

    public static String a(au auVar, a aVar) {
        String str = "";
        if (!(aVar == null || bi.oN(aVar.for))) {
            b Se = an.aqK().Se(aVar.for);
            if (Se != null && Se.aPj() && com.tencent.mm.a.e.bO(Se.field_fileFullPath)) {
                str = Se.field_fileFullPath;
            }
        }
        if (bi.oN(str)) {
            if (auVar != null) {
                str = o.PC().B(auVar.field_imgPath, true);
            }
            x.d("MicroMsg.HistoryExportUtil", "try get thumb appmsg image path finish, %s", str);
        } else {
            x.d("MicroMsg.HistoryExportUtil", "get hd appmsg image path ok, %s", str);
        }
        return str;
    }
}
