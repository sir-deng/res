package com.tencent.mm.plugin.chatroom.e;

import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.c;

public final class a implements com.tencent.mm.y.bt.a {
    public final void a(com.tencent.mm.ad.d.a aVar) {
        int i = 1;
        bx bxVar = aVar.hoa;
        if (bxVar.nlX == 10002) {
            String a = n.a(bxVar.vNO);
            if (bi.oN(a)) {
                x.w("MicroMsg.ChatroomAccessVerifySysCmdMsgListener", "msg content is null");
                return;
            }
            String a2 = n.a(bxVar.vNM);
            as.Hm();
            au G = c.Fh().G(a2, bxVar.vNT);
            if (G.field_msgId <= 0) {
                i = 0;
            }
            G.ap(bxVar.vNT);
            G.aq(bb.n(a2, (long) bxVar.pgR));
            G.setType(10002);
            G.setContent(a);
            G.eS(0);
            G.dU(a2);
            G.ea(bxVar.vNR);
            G.fc(G.gkC & -769);
            bb.a(G, aVar);
            if (i == 0) {
                bb.i(G);
                return;
            }
            as.Hm();
            c.Fh().b(bxVar.vNT, G);
            return;
        }
        x.i("MicroMsg.ChatroomAccessVerifySysCmdMsgListener", "not new xml type:%d ", Integer.valueOf(bxVar.nlX));
    }
}
