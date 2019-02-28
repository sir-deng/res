package com.tencent.mm.ui.chatting;

import com.tencent.mm.f.a.nv;
import com.tencent.mm.f.a.nw;
import com.tencent.mm.f.a.os;
import com.tencent.mm.f.a.ou;
import com.tencent.mm.f.a.sj;
import com.tencent.mm.modelmulti.j;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;

public final class af {
    public static void aD(au auVar) {
        x.i("MicroMsg.ResendMsgLogic", "resendVoiceMsg, msgId:%d", Long.valueOf(auVar.field_msgId));
        b nwVar;
        if (s.hd(auVar.field_talker)) {
            nwVar = new nw();
            nwVar.fGI.fou = auVar;
            a.xmy.m(nwVar);
            return;
        }
        nwVar = new nv();
        nwVar.fGH.fou = auVar;
        a.xmy.m(nwVar);
    }

    public static void aE(au auVar) {
        b osVar = new os();
        long hU = bb.hU(auVar.field_talker);
        x.i("MicroMsg.ResendMsgLogic", "resendMsgImage, msgId:%d, time[%d - > %d]", Long.valueOf(auVar.field_msgId), Long.valueOf(auVar.field_createTime), Long.valueOf(hU));
        if (hU == auVar.field_createTime) {
            hU++;
        }
        auVar.aq(hU);
        as.Hm();
        c.Fh().a(auVar.field_msgId, auVar);
        osVar.fHC.fou = auVar;
        a.xmy.m(osVar);
    }

    public static void aF(au auVar) {
        x.i("MicroMsg.ResendMsgLogic", "resendEmoji, msgId:%d", Long.valueOf(auVar.field_msgId));
        b sjVar = new sj();
        sjVar.fKW.fou = auVar;
        a.xmy.m(sjVar);
    }

    public static void aG(au auVar) {
        x.i("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, msgId:%d", Long.valueOf(auVar.field_msgId));
        long hU = bb.hU(auVar.field_talker);
        if (hU == auVar.field_createTime) {
            hU++;
        }
        auVar.aq(hU);
        as.Hm();
        c.Fh().a(auVar.field_msgId, auVar);
        com.tencent.mm.sdk.e.c fp = an.aqK().fp(auVar.field_msgId);
        if (fp == null || fp.field_msgInfoId != auVar.field_msgId) {
            x.d("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, directly send app mag");
            an.bZH();
            am.a.fu(auVar.field_msgId);
            return;
        }
        x.d("MicroMsg.ResendMsgLogic", "resendAppMsgEmoji, upload app attach first");
        fp.field_status = 101;
        fp.field_offset = 0;
        fp.field_lastModifyTime = System.currentTimeMillis() / 1000;
        an.aqK().c(fp, new String[0]);
        an.bZH().run();
    }

    public static void aH(au auVar) {
        x.i("MicroMsg.ResendMsgLogic", "resendTextMsg, msgId:%d", Long.valueOf(auVar.field_msgId));
        aK(auVar);
    }

    public static void aI(au auVar) {
        x.i("MicroMsg.ResendMsgLogic", "resendLocation, msgId:%d", Long.valueOf(auVar.field_msgId));
        aK(auVar);
    }

    public static void aJ(au auVar) {
        x.i("MicroMsg.ResendMsgLogic", "resendCardMsg, msgId:%d", Long.valueOf(auVar.field_msgId));
        aK(auVar);
    }

    private static void aK(au auVar) {
        long j = auVar.field_msgId;
        if (j == -1) {
            x.e("MicroMsg.ResendMsgLogic", "sendMsgInternal failed msgId " + j);
        } else if (!auVar.field_talker.equals("medianote") || (q.Gc() & 16384) != 0) {
            x.d("MicroMsg.ResendMsgLogic", "sendMsgInternal, start send msgId: %d", Long.valueOf(j));
            if (!as.CN().a(new j(j), 0)) {
                x.e("MicroMsg.ResendMsgLogic", "sendMsgInternal, doScene return false, directly mark msg to failed");
                auVar.eR(5);
                as.Hm();
                c.Fh().a(auVar.field_msgId, auVar);
                b ouVar = new ou();
                ouVar.fHF.fou = auVar;
                a.xmy.m(ouVar);
            }
        }
    }
}
