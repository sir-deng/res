package com.tencent.mm.modelvoice;

import com.tencent.mm.ad.d;
import com.tencent.mm.ad.d.a;
import com.tencent.mm.ad.d.b;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class r implements d {
    private static Set<c> hZx = new HashSet();

    public static void c(c cVar) {
        if (!hZx.contains(cVar)) {
            hZx.add(cVar);
        }
    }

    public static void b(c cVar) {
        hZx.remove(cVar);
    }

    public final b b(a aVar) {
        bx bxVar = aVar.hoa;
        if (bxVar == null) {
            x.e("MicroMsg.VoiceMsgExtension", "onPreAddMessage cmdAM is null , give up.");
            return null;
        }
        String a;
        p bx;
        x.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg srvId:" + bxVar.vNT);
        String a2 = n.a(bxVar.vNM);
        if (a2.equals(q.FY())) {
            a = n.a(bxVar.vNN);
        } else {
            a = a2;
        }
        cg G = ((h) g.h(h.class)).aZO().G(a, bxVar.vNT);
        if (G.field_msgId != 0 && G.field_createTime + 604800000 < bb.n(a, (long) bxVar.pgR)) {
            x.w("MicroMsg.VoiceMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d", Long.valueOf(bxVar.vNT));
            bb.o(a, bxVar.vNT);
            bx = m.UK().bx(bxVar.vNT);
            if (!(bx == null || bi.oN(bx.fileName))) {
                q.od(bx.fileName);
            }
        }
        bx = new p();
        bx.fEx = a;
        bx.hXs = (long) bxVar.pgR;
        bx.fGj = bxVar.vNT;
        bx.gkD = bxVar.vNR;
        x.d("MicroMsg.VoiceMsgExtension", "voiceMsgExtension, onPreAddMessage.(MsgSource : %s)", bxVar.vNR);
        String a3 = n.a(bxVar.vNO);
        if (s.eX(a2)) {
            a2 = bb.hT(a3);
            x.i("MicroMsg.VoiceMsgExtension", "chatroom voicemsg, new content=" + a2);
        } else {
            a2 = a3;
        }
        Map y = bj.y(a2, "msg");
        if (y == null) {
            com.tencent.mm.plugin.report.service.g.pWK.a(111, 227, 1, false);
            return null;
        }
        try {
            bx.hWd = Integer.valueOf((String) y.get(".msg.voicemsg.$length")).intValue();
            bx.clientId = (String) y.get(".msg.voicemsg.$clientmsgid");
            int intValue = Integer.valueOf((String) y.get(".msg.voicemsg.$endflag")).intValue();
            int intValue2 = Integer.valueOf((String) y.get(".msg.voicemsg.$cancelflag")).intValue();
            bx.hZq = Integer.valueOf((String) y.get(".msg.voicemsg.$voicelength")).intValue();
            bx.hXn = (String) y.get(".msg.voicemsg.$fromusername");
            String str = (String) y.get(".msg.commenturl");
            bx.hYq = Integer.valueOf(bi.aD((String) y.get(".msg.voicemsg.$forwardflag"), "0")).intValue();
            bx.hYj = (String) y.get(".msg.voicemsg.$voiceformat");
            bx.hZr = bi.getLong((String) y.get(".msg.voicemsg.$bufid"), 0);
            if (intValue2 == 1) {
                x.v("MicroMsg.VoiceMsgExtension", "cancelFlag = 1 srvId:" + bxVar.vNT);
                bx = m.UK().bx(bx.fGj);
                if (bx != null) {
                    q.ob(bx.fileName);
                }
                return null;
            }
            cg G2;
            if (intValue == 1) {
                x.v("MicroMsg.VoiceMsgExtension", "endFlag = 1 srvId:" + bxVar.vNT);
                bx.hmZ = bx.hWd;
            }
            bx.fEo = 284334;
            byte[] a4 = n.a(bxVar.vNQ);
            if (a4 != null) {
                x.d("MicroMsg.VoiceMsgExtension", "Voice Buf Len:" + a4.length + " srvId:" + bxVar.vNT);
            }
            if (q.a(bx, a4, bxVar.kyY, str, bxVar.vNR, aVar) > 0) {
                x.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg setRecvSync[%d], svrId[%d], msgseq[%d]", Integer.valueOf(q.a(bx, a4, bxVar.kyY, str, bxVar.vNR, aVar)), Long.valueOf(bxVar.vNT), Integer.valueOf(bxVar.vNU));
                com.tencent.mm.plugin.report.service.g.pWK.a(111, 228, 1, false);
                G2 = ((h) g.h(h.class)).aZO().G(bx.fEx, bx.fGj);
                G2.DJ(0);
                for (final c cVar : hZx) {
                    ah.y(new Runnable() {
                        public final void run() {
                            cVar.A(((h) g.h(h.class)).aZO().G(bx.fEx, bx.fGj));
                        }
                    });
                }
            } else {
                x.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg setRecvSync[%d], svrId[%d], msgseq[%d], stack[%s]", Integer.valueOf(q.a(bx, a4, bxVar.kyY, str, bxVar.vNR, aVar)), Long.valueOf(bxVar.vNT), Integer.valueOf(bxVar.vNU), bi.chl());
                G2 = null;
            }
            if (G2 != null) {
                ae XF = ((h) g.h(h.class)).Fk().XF(a);
                if (XF != null) {
                    XF.Bb();
                    ((h) g.h(h.class)).Fk().a(XF, a);
                }
            }
            boolean z = G2 != null && G2.field_msgId > 0;
            return new b(G2, z);
        } catch (Throwable e) {
            com.tencent.mm.plugin.report.service.g.pWK.a(111, 227, 1, false);
            x.e("MicroMsg.VoiceMsgExtension", "parsing voice msg xml failed");
            x.e("MicroMsg.VoiceMsgExtension", "exception:%s", bi.i(e));
            return null;
        }
    }

    public final void h(au auVar) {
        x.d("MicroMsg.VoiceMsgExtension", "onPreDelMessage " + auVar.field_imgPath + " " + auVar.field_talker);
        if (!s.hd(auVar.field_talker)) {
            q.od(auVar.field_imgPath);
        }
    }
}
