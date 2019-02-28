package com.tencent.mm.y;

import com.tencent.mm.ad.d;
import com.tencent.mm.ad.d.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.au;

public class e implements d {
    private static final a hgz = new a();

    private static final class a extends com.tencent.mm.cc.a<com.tencent.mm.plugin.messenger.foundation.a.a> implements com.tencent.mm.plugin.messenger.foundation.a.a {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void a(com.tencent.mm.ad.d.a aVar, au auVar, String str, String str2, boolean z) {
            final com.tencent.mm.ad.d.a aVar2 = aVar;
            final au auVar2 = auVar;
            final String str3 = str;
            final String str4 = str2;
            final boolean z2 = z;
            a(new com.tencent.mm.cc.a.a<com.tencent.mm.plugin.messenger.foundation.a.a>() {
                public final /* synthetic */ void az(Object obj) {
                    ((com.tencent.mm.plugin.messenger.foundation.a.a) obj).a(aVar2, auVar2, str3, str4, z2);
                }
            });
        }
    }

    public static void a(com.tencent.mm.plugin.messenger.foundation.a.a aVar) {
        hgz.aE(aVar);
    }

    public b b(com.tencent.mm.ad.d.a aVar) {
        bx bxVar = aVar.hoa;
        String str = (String) g.Dq().Db().get(2, (Object) "");
        if (str.length() <= 0) {
            return null;
        }
        String a = n.a(bxVar.vNM);
        String a2 = n.a(bxVar.vNN);
        if (bi.oM(a).length() <= 0 || bi.oM(a2).length() <= 0) {
            x.e("MicroMsg.BaseMsgExtension", "neither from-user nor to-user can be empty");
            return null;
        }
        au a3 = a(bxVar, a, a2, str);
        if (a3 == null) {
            return null;
        }
        int i;
        au auVar;
        boolean z = ((h) g.h(h.class)).Fn().has(a) || str.equals(a);
        if (z) {
            a3.eS(1);
            a3.dU(a2);
            i = bxVar.kyY;
            auVar = a3;
        } else {
            a3.eS(0);
            a3.dU(a);
            if (bxVar.kyY > 3) {
                i = bxVar.kyY;
                auVar = a3;
            } else {
                i = 3;
                auVar = a3;
            }
        }
        auVar.eR(i);
        if (bxVar.nlX == 10000) {
            a3.eR(4);
        }
        a3.ea(bxVar.vNR);
        if (a3.XX(q.FY())) {
            ae XF = ((h) g.h(h.class)).Fk().XF(a3.field_talker);
            if (XF != null) {
                XF.Bb();
                ((h) g.h(h.class)).Fk().a(XF, a3.field_talker);
            }
        }
        hgz.a(aVar, a3, a, a2, z);
        if (a3.field_msgId == 0) {
            bb.a(a3, aVar);
            a3.ao(bb.i(a3));
            return new b(a3, true);
        }
        ((h) g.h(h.class)).aZO().b(bxVar.vNT, a3);
        return new b(a3, false);
    }

    public au a(bx bxVar, String str, String str2, String str3) {
        String str4 = str3.equals(str) ? str2 : str;
        au G = ((h) g.h(h.class)).aZO().G(str4, bxVar.vNT);
        x.i("MicroMsg.BaseMsgExtension", "summerbadcr dkmsgid prepareMsgInfo svrid:%d localid:%d  from:%s to:%s talker:%s", Long.valueOf(bxVar.vNT), Long.valueOf(G.field_msgId), str, str2, str4);
        if (G.field_msgId != 0 && G.field_createTime + 604800000 < bb.n(str4, (long) bxVar.pgR)) {
            x.w("MicroMsg.BaseMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", Long.valueOf(bxVar.vNT), Long.valueOf(G.field_msgId));
            bb.aL(G.field_msgId);
            G.ao(0);
        }
        if (G.field_msgId != 0) {
            return G;
        }
        G = new au();
        G.ap(bxVar.vNT);
        G.aq(bb.n(str4, (long) bxVar.pgR));
        G.setType(bxVar.nlX);
        G.setContent(bi.WE(bi.oM(n.a(bxVar.vNO))));
        return G;
    }

    public void h(au auVar) {
    }
}
