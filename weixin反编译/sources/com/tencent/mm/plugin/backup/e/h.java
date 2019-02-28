package com.tencent.mm.plugin.backup.e;

import com.tencent.mm.plugin.backup.h.u;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.protocal.c.ev;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import java.util.HashMap;
import java.util.LinkedList;

public final class h {

    public static class a {
        public String frM;
        public u ksN;
        public long ksO;
        public String ksP;
    }

    public static ev a(au auVar, boolean z, String str, PLong pLong, LinkedList<u> linkedList, HashMap<Long, a> hashMap, boolean z2, boolean z3, long j) {
        if (auVar.field_msgSvrId == 0) {
            x.e("MicroMsg.BackupMsgLogic", "packedMsg msgSvrId is 0, talker[%s], type[%d]", auVar.field_talker, Integer.valueOf(auVar.getType()));
            return null;
        }
        int i;
        ev evVar;
        ev evVar2 = new ev();
        evVar2.vNT = auVar.field_msgSvrId;
        if (auVar.field_isSend == 1) {
            evVar2.vNM = new bet().Vf(str);
            evVar2.vNN = new bet().Vf(auVar.field_talker);
            i = 2;
            evVar = evVar2;
        } else {
            evVar2.vNM = new bet().Vf(auVar.field_talker);
            evVar2.vNN = new bet().Vf(str);
            if (z2) {
                i = 3;
                evVar = evVar2;
            } else {
                i = 4;
                evVar = evVar2;
            }
        }
        evVar.vQR = i;
        evVar2.vQW = new bes();
        evVar2.vQX = 0;
        evVar2.vQY = 0;
        evVar2.vNR = "";
        evVar2.kzz = l.BY(auVar.getType());
        evVar2.vQS = (int) (auVar.field_createTime / 1000);
        evVar2.vRa = auVar.field_createTime;
        evVar2.vQZ = (int) auVar.field_msgSeq;
        evVar2.vRb = auVar.field_flag;
        bet bet = new bet();
        bet.Vf(bi.aD(auVar.field_content, ""));
        evVar2.vNO = bet;
        l mZ = c.apX().mZ(l.BY(auVar.getType()));
        if (mZ == null) {
            x.d("MicroMsg.BackupMsgLogic", "packedMsg unknow type[%d]", Integer.valueOf(auVar.getType()));
            return null;
        }
        i = mZ.a(evVar2, z, auVar, str, linkedList, hashMap, z3, j);
        if (i < 0) {
            return null;
        }
        pLong.value += (long) i;
        pLong.value += 60;
        return evVar2;
    }
}
