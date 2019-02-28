package com.tencent.mm.plugin.readerapp.b;

import com.tencent.mm.R;
import com.tencent.mm.f.a.cg;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.pluginsdk.model.t;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.protocal.c.wc;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.bg;
import com.tencent.mm.y.q;

public final class b {
    public static boolean a(cg cgVar, bg bgVar, int i) {
        if (cgVar == null || bgVar == null) {
            x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or readerAppInfo is null");
            if (cgVar != null) {
                cgVar.frk.frq = R.l.efu;
            }
            return false;
        }
        String x;
        vn vnVar = new vn();
        vt vtVar = new vt();
        uz uzVar = new uz();
        vtVar.UN("newsapp");
        vtVar.UO(q.FY());
        vtVar.UO(q.FY());
        vtVar.Dl(1);
        vtVar.fD(bgVar.hiR);
        vtVar.UR(bgVar.hiW);
        vtVar.UU(bgVar.getUrl());
        vtVar.UV("newsapp");
        uzVar.Un(String.valueOf(bgVar.hiW));
        if (i == 0) {
            x = t.x(bgVar.HR(), bgVar.type, "@T");
        } else {
            x = t.x(bgVar.HR(), bgVar.type, "@S");
        }
        if (FileOp.bO(x)) {
            uzVar.Uk(x);
        } else {
            uzVar.lA(true);
            uzVar.Ue(bgVar.HR());
            wc wcVar = new wc();
            wcVar.Vd(bgVar.HR());
            vnVar.b(wcVar);
        }
        uzVar.Dc(5);
        uzVar.TV(bgVar.getTitle());
        uzVar.TW(bgVar.HS());
        uzVar.lz(true);
        vnVar.a(vtVar);
        vnVar.wlY.add(uzVar);
        cgVar.frk.desc = bgVar.getTitle();
        cgVar.frk.frm = vnVar;
        cgVar.frk.type = 5;
        return true;
    }
}
