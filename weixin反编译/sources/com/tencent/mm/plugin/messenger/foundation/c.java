package com.tencent.mm.plugin.messenger.foundation;

import android.database.Cursor;
import com.tencent.mm.ad.d;
import com.tencent.mm.ad.d.a;
import com.tencent.mm.ad.d.b;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.protocal.c.ot;
import com.tencent.mm.protocal.c.qi;
import com.tencent.mm.protocal.c.qo;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.bc;
import com.tencent.mm.y.q;
import java.util.List;

public final class c implements p {
    public final void a(ot otVar, byte[] bArr, boolean z, r rVar) {
        boolean z2 = false;
        switch (otVar.wet) {
            case 5:
                bx bxVar = (bx) new bx().aH(bArr);
                if (bxVar != null) {
                    a aVar = new a(bxVar, false, false, false);
                    a(aVar, rVar);
                    if (!aVar.hob) {
                        bc.a(n.a(bxVar.vNM), bxVar.vNT, ((long) bxVar.pgR) * 1000, bxVar.nlX);
                        return;
                    }
                    return;
                }
                return;
            case 8:
                qi qiVar = (qi) new qi().aH(bArr);
                String a = n.a(qiVar.wfM);
                int i = qiVar.wfQ;
                Cursor bD = ((h) g.h(h.class)).aZO().bD(a, i);
                if (bD.moveToFirst()) {
                    while (!bD.isAfterLast()) {
                        au auVar = new au();
                        auVar.b(bD);
                        bb.j(auVar);
                        bD.moveToNext();
                    }
                }
                bD.close();
                ((h) g.h(h.class)).aZO().bC(a, i);
                return;
            case 9:
                qo qoVar = (qo) new qo().aH(bArr);
                List list = qoVar.wfT;
                while (true) {
                    boolean z3 = z2;
                    if (z3 < list.size()) {
                        bb.o(n.a(qoVar.wfM), (long) ((Integer) list.get(z3)).intValue());
                        z2 = z3 + 1;
                    } else {
                        return;
                    }
                }
            default:
                return;
        }
    }

    public static void a(a aVar, r rVar) {
        com.tencent.mm.bp.a aVar2 = aVar.hoa;
        if (10008 == com.tencent.mm.platformtools.r.ifN && com.tencent.mm.platformtools.r.ifO != 0) {
            x.i("MicroMsg.MessageSyncExtension", "dkmsgid  set svrmsgid %d -> %d", Long.valueOf(aVar2.vNT), Integer.valueOf(com.tencent.mm.platformtools.r.ifO));
            aVar2.vNT = Long.valueOf((long) com.tencent.mm.platformtools.r.ifO).longValue();
            com.tencent.mm.platformtools.r.ifO = 0;
        }
        if (((h) g.h(h.class)).aZO().dK(aVar2.vNT)) {
            x.i("MicroMsg.MessageSyncExtension", "ignore, because reSync the deleted msg perhaps the IDC has change has swtiched");
            return;
        }
        String a = n.a(aVar2.vNM);
        String a2 = n.a(aVar2.vNN);
        if (a.equals(q.FY()) && a2.equals("newsapp") && aVar2.nlX != 51) {
            x.w("MicroMsg.MessageSyncExtension", "msgid:%d type:%d this fucking msg from mac weixin ,someone send msg to newsapp at mac weixin ,givp up.", Long.valueOf(aVar2.vNT), Integer.valueOf(aVar2.nlX));
            return;
        }
        int i;
        String str = "MicroMsg.MessageSyncExtension";
        String str2 = "dkAddMsg from:%s to:%s id:[%d,%d,%d] status:%d type:%d time:[%d %s] diff:%d imgstatus:%d imgbuf:%d src:%d push:%d content:%s";
        Object[] objArr = new Object[15];
        objArr[0] = a;
        objArr[1] = a2;
        objArr[2] = Long.valueOf(aVar2.vNT);
        objArr[3] = Integer.valueOf(aVar2.vNL);
        objArr[4] = Integer.valueOf(aVar2.vNU);
        objArr[5] = Integer.valueOf(aVar2.kyY);
        objArr[6] = Integer.valueOf(aVar2.nlX);
        objArr[7] = Integer.valueOf(aVar2.pgR);
        objArr[8] = bi.fK((long) aVar2.pgR);
        objArr[9] = Long.valueOf(bi.Wx() - ((long) aVar2.pgR));
        objArr[10] = Integer.valueOf(aVar2.vNP);
        objArr[11] = Integer.valueOf(n.a(aVar2.vNQ, new byte[0]).length);
        objArr[12] = Integer.valueOf(bi.oM(aVar2.vNR).length());
        objArr[13] = Integer.valueOf(bi.oM(aVar2.vNS).length());
        bet bet = aVar2.vNO;
        a2 = "";
        if (bet != null) {
            a2 = bet.wRo;
        }
        objArr[14] = bi.Wz(a2);
        x.i(str, str2, objArr);
        x.i("MicroMsg.MessageSyncExtension", "parseMsgSource  has been Deprecated  by dk. at 20151218 [%s] %s ", aVar2.vNR, "");
        s.h(aVar2);
        if (a.equals("readerapp")) {
            aVar2.vNM = n.oK("newsapp");
            aVar2.nlX = 12399999;
        }
        if ((a.equals("blogapp") || a.equals("newsapp")) && aVar2.nlX != 10002) {
            aVar2.nlX = 12399999;
        }
        if (aVar2.nlX == 52) {
            aVar2.nlX = 1000052;
        }
        if (aVar2.nlX == 53) {
            aVar2.nlX = 1000053;
        }
        if (!(aVar == null || aVar.hoa == null)) {
            bx bxVar = aVar.hoa;
            au G = ((h) g.h(h.class)).aZO().G(n.a(bxVar.vNM), bxVar.vNT);
            if (G.field_msgId != 0 && (G.field_isSend == 0 || bxVar.vNU != 0)) {
                i = G.field_flag;
                i = aVar.hob ? i | 2 : i & -3;
                i = aVar.hoc ? i | 1 : i & -2;
                i = aVar.hod ? i | 4 : i & -5;
                if (i != G.field_flag) {
                    x.i("MicroMsg.MsgInfoStorageLogic", "summerbadcr updateMsgFlagByAddMsgInfo msgType[%d], flag new[%d], old[%d]", Integer.valueOf(bxVar.nlX), Integer.valueOf(i), Integer.valueOf(G.field_flag));
                    G.fb(i);
                    ((h) g.h(h.class)).aZO().b(G.field_msgSvrId, G);
                }
            }
        }
        Object obj = null;
        d aU = com.tencent.mm.ad.d.c.aU(Integer.valueOf(aVar2.nlX));
        if (aU == null) {
            aU = com.tencent.mm.ad.d.c.aU(a);
        }
        if (aU != null) {
            b b = aU.b(aVar);
            cg cgVar = b == null ? null : b.fou;
            if (cgVar == null) {
                x.w("MicroMsg.MessageSyncExtension", "summerbadcr extension declared but skipped msg, type=%d, svrId=%d, MsgSeq=%d, createTime=%d, addMsgInfo=%s", Integer.valueOf(aVar2.nlX), Long.valueOf(aVar2.vNT), Integer.valueOf(aVar2.vNU), Integer.valueOf(aVar2.pgR), aVar);
                if (aVar.hob && aVar.hoc) {
                    au H = ((h) g.h(h.class)).aZO().H(a, (long) aVar2.vNU);
                    if (H.field_msgId != 0) {
                        i = H.field_flag;
                        x.i("MicroMsg.MessageSyncExtension", "summerbadcr extension declared but skipped msg and must revised fault[%d], flag[%d], svrId[%d], msgseq[%d], createtime[%d], type[%d]", Long.valueOf(H.field_msgId), Integer.valueOf(H.field_flag), Long.valueOf(H.field_msgSvrId), Long.valueOf(H.field_msgSeq), Long.valueOf(H.field_createTime), Integer.valueOf(H.getType()));
                        if ((i & 1) == 0) {
                            H.fb((i | 2) | 1);
                            ((h) g.h(h.class)).aZO().a(H.field_msgId, H);
                        }
                    } else {
                        x.i("MicroMsg.MessageSyncExtension", "summerbadcr extension declared but skipped msg and must revised fault failed[%d]", Long.valueOf(H.field_msgId));
                    }
                }
                obj = 1;
            } else {
                obj = (!com.tencent.mm.y.s.gM(a) || com.tencent.mm.aq.b.PZ()) ? null : 1;
                if (obj == null) {
                    x.d("MicroMsg.MessageSyncExtension", " msg , id =" + cgVar.field_msgId + "  " + rVar);
                    if (cgVar.field_msgId > 0 && rVar != null && b.hoe) {
                        rVar.a(cgVar, aVar2);
                    }
                }
                obj = 1;
            }
        }
        s.b(5, aVar2);
        if (obj == null) {
            x.f("MicroMsg.MessageSyncExtension", "unknown add msg request, type=%d. drop now !!!", Integer.valueOf(aVar2.nlX));
        }
    }
}
