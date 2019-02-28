package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.f.a.cg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.pluginsdk.model.f;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.a.c;
import com.tencent.mm.ui.chatting.a.d;
import com.tencent.mm.x.h;
import com.tencent.mm.y.u;
import java.net.URLEncoder;

public final class m {
    public p fhH;

    public m(p pVar) {
        this.fhH = pVar;
    }

    public final void aO(au auVar) {
        cg cgVar = new cg();
        f.a(cgVar, auVar);
        cgVar.frk.pL = this.fhH.cte();
        cgVar.frk.frr = 43;
        a.xmy.m(cgVar);
        if (cgVar.frl.ret == 0) {
            if (auVar.aNJ()) {
                b.hRo.b(auVar, h.g(auVar));
            } else {
                b.hRo.u(auVar);
            }
            if (auVar.aNJ() || auVar.cjK()) {
                String hC = u.hC(auVar.field_msgSvrId);
                u.b t = u.GQ().t(hC, true);
                t.o("prePublishId", "msg_" + auVar.field_msgSvrId);
                t.o("preUsername", com.tencent.mm.ui.chatting.viewitems.b.a(auVar, this.fhH.csS(), this.fhH.csT()));
                t.o("preChatName", this.fhH.csn());
                t.o("preMsgIndex", Integer.valueOf(0));
                t.o("sendAppMsgScene", Integer.valueOf(1));
                ((i) g.h(i.class)).a("adExtStr", t, auVar);
                cgVar.frk.frp = hC;
            }
            com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(bi.Wn(auVar.field_content));
            if (!(fV == null || fV.type != 5 || fV.url == null)) {
                long Wx = bi.Wx();
                x.d("MicroMsg.ChattingUI.FavoriteImp", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", Integer.valueOf(13378), fV.url, Long.valueOf(Wx), Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(1));
                String str = "";
                try {
                    str = URLEncoder.encode(fV.url, "UTF-8");
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.ChattingUI.FavoriteImp", e, "", new Object[0]);
                }
                com.tencent.mm.plugin.report.service.g.pWK.h(13378, str, Long.valueOf(Wx), Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(1));
            }
            this.fhH.cte().hideVKB();
            com.tencent.mm.ui.chatting.a.a(c.Fav, d.Samll, auVar, 0);
        }
    }
}
