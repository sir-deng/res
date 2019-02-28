package com.tencent.mm.plugin.qmessage.a;

import com.tencent.mm.ad.d;
import com.tencent.mm.ad.d.b;
import com.tencent.mm.ap.e;
import com.tencent.mm.ap.g;
import com.tencent.mm.ap.o;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.c;
import java.util.Map;
import junit.framework.Assert;

public final class f implements d {

    public static final class a {
        String content;
        String gDt;

        /* synthetic */ a(byte b) {
            this();
        }

        private a() {
            this.gDt = "";
            this.content = "";
        }
    }

    public final b b(com.tencent.mm.ad.d.a aVar) {
        bx bxVar = aVar.hoa;
        if (bxVar == null) {
            x.e("MicroMsg.QMsgExtension", "onPreAddMessage cmdAM is null");
            return null;
        } else if (bxVar.nlX == 36 || bxVar.nlX == 39) {
            au auVar;
            int i;
            au auVar2;
            String a = n.a(bxVar.vNO);
            String a2 = n.a(bxVar.vNM);
            String a3 = n.a(bxVar.vNN);
            x.d("MicroMsg.QMsgExtension", "parseQMsg content:" + a);
            as.Hm();
            String str = (String) c.Db().get(2, null);
            String str2 = str.equals(a2) ? a3 : a2;
            as.Hm();
            cg G = c.Fh().G(str2, bxVar.vNT);
            x.d("MicroMsg.QMsgExtension", "dkmsgid parseQMsg svrid:%d localid:%d", Long.valueOf(bxVar.vNT), Long.valueOf(G.field_msgId));
            if (G.field_msgId != 0 && G.field_createTime + 604800000 < bb.n(a2, (long) bxVar.pgR)) {
                x.w("MicroMsg.QMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", Long.valueOf(bxVar.vNT), Long.valueOf(G.field_msgId));
                bb.aL(G.field_msgId);
                G.ao(0);
            }
            if (G.field_msgId == 0) {
                G = new au();
                G.ap(bxVar.vNT);
                G.aq(bb.n(a2, (long) bxVar.pgR));
                auVar = G;
            } else {
                cg auVar3 = G;
            }
            auVar3.setType(bxVar.nlX);
            auVar3.dU(str2);
            d Ii = g.bkF().Ii(str2);
            if (Ii == null || bi.oM(Ii.getUsername()).length() <= 0) {
                Ii = new d();
                Ii.username = str2;
                Ii.ptd = 1;
                Ii.fEo = 9;
                if (!g.bkF().a(Ii)) {
                    x.e("MicroMsg.QMsgExtension", "parseQMsg : insert QContact failed : username = " + Ii.getUsername());
                }
            }
            long j = -1;
            if (bxVar.vNP == 2 && auVar3.field_msgId == 0) {
                byte[] a4 = n.a(bxVar.vNQ);
                PString pString = new PString();
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                g PC = o.PC();
                int i2 = bxVar.vNP;
                j = PC.a(a4, bxVar.vNT, false, "", pString, pInt, pInt2);
                if (j > 0) {
                    auVar3.dV(pString.value);
                    auVar3.fd(pInt.value);
                    auVar3.fe(pInt2.value);
                }
            }
            long j2 = j;
            if (bxVar.nlX == 36) {
                Object obj;
                ag xVar;
                Assert.assertTrue(true);
                Assert.assertTrue(bi.oM(a).length() > 0);
                Assert.assertTrue(bi.oM(auVar3.field_talker).length() > 0);
                as.Hm();
                ag Xv = c.Ff().Xv(auVar3.field_talker);
                if (Xv == null || bi.oM(Xv.field_username).length() <= 0) {
                    obj = 1;
                    xVar = new com.tencent.mm.storage.x(auVar3.field_talker);
                } else {
                    obj = null;
                    xVar = Xv;
                }
                a aVar2 = new a();
                Map y = bj.y(a, "msg");
                if (y != null) {
                    aVar2.gDt = (String) y.get(".msg.from.displayname");
                    aVar2.content = (String) y.get(".msg.content.t");
                }
                xVar.da(aVar2.gDt == null ? "" : aVar2.gDt);
                auVar3.setContent(aVar2.content == null ? "" : aVar2.content);
                if (obj != null) {
                    as.Hm();
                    c.Ff().S(xVar);
                } else {
                    as.Hm();
                    c.Ff().a(xVar.field_username, xVar);
                }
            }
            as.Hm();
            Object obj2 = (c.Fn().has(a2) || str.equals(a2)) ? 1 : null;
            if (obj2 != null) {
                auVar3.eS(1);
                i = bxVar.kyY;
                auVar2 = auVar3;
            } else {
                auVar3.eS(0);
                if (bxVar.kyY > 3) {
                    i = bxVar.kyY;
                    auVar2 = auVar3;
                } else {
                    i = 3;
                    auVar2 = auVar3;
                }
            }
            auVar2.eR(i);
            auVar3.ea(bxVar.vNR);
            bb.a(auVar3, aVar);
            if (auVar3.field_msgId == 0) {
                auVar3.ao(bb.i(auVar3));
                if (bxVar.vNP == 2) {
                    e b = o.PC().b(Long.valueOf(j2));
                    b.bg((long) ((int) auVar3.field_msgId));
                    o.PC().a(Long.valueOf(j2), b);
                }
                return new b(auVar3, true);
            }
            as.Hm();
            c.Fh().b(bxVar.vNT, auVar3);
            return new b(auVar3, false);
        } else {
            x.e("MicroMsg.QMsgExtension", "onPreAddMessage cmdAM.type:%d", Integer.valueOf(bxVar.nlX));
            return null;
        }
    }

    public final void h(au auVar) {
        o.PC().o(auVar);
    }
}
