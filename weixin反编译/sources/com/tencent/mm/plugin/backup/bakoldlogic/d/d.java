package com.tencent.mm.plugin.backup.bakoldlogic.d;

import com.tencent.mm.f.b.cg;
import com.tencent.mm.k.a;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.b;
import java.io.File;
import java.util.HashMap;

public final class d {
    public static void k(HashMap<String, Integer> hashMap) {
        for (String str : hashMap.keySet()) {
            cg dr = b.arq().arr().Fh().dr(str, " and not ( type = 10000 and isSend != 2 ) ");
            if (dr != null) {
                int intValue = ((Integer) hashMap.get(str)).intValue();
                String str2 = dr.field_talker;
                x.i("MicroMsg.BakOldTempStorageLogic", "talker:%s, addUnreadCount:%d", str2, Integer.valueOf(intValue));
                ae XF = b.arq().arr().Fk().XF(str2);
                if (XF == null || XF.field_conversationTime <= dr.field_createTime || XF.field_conversationTime == Long.MAX_VALUE) {
                    int i;
                    if (XF == null) {
                        x.i("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg conversation is null.");
                        x.d("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg cvs:%s", str2);
                        XF = new ae(str2);
                        i = 1;
                    } else {
                        i = 0;
                    }
                    XF.eS(dr.field_isSend);
                    XF.eP(intValue + XF.field_unReadCount);
                    XF.ac(dr);
                    XF.dG(Integer.toString(dr.getType()));
                    XF.ak((XF.field_flag & 4611686018427387904L) | (dr.field_createTime & 72057594037927935L));
                    XF.eO(0);
                    if (i != 0) {
                        x.d("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg cvs:%s, cvs.flag:%d", str2, Long.valueOf(XF.field_flag));
                        b.arq().arr().Fk().d(XF);
                    } else {
                        b.arq().arr().Fk().a(XF, str2);
                    }
                } else {
                    x.i("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg ignore(maybe the system time is bigger than normal)");
                }
            }
        }
        b.arq().arr().Fk().cjr();
    }

    public static boolean eX(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        return str.endsWith("@chatroom");
    }

    public static long i(au auVar) {
        a Xv = b.arq().arr().Ff().Xv(auVar.field_talker);
        if (Xv == null || ((int) Xv.gKO) == 0) {
            if (!bi.oN(auVar.field_talker)) {
                b.arq().ars().e(2, auVar.field_talker);
                b.arq().arr().Ff().S(new com.tencent.mm.storage.x(auVar.field_talker));
            } else if (auVar.field_talker.endsWith("@chatroom")) {
                c arr = b.arq().arr();
                if (arr.uin == 0) {
                    throw new b();
                } else if (arr.kvE.hK(auVar.field_talker) == null) {
                    b.arq().ars().e(2, auVar.field_talker);
                }
            }
        }
        long Q = b.arq().arr().Fh().Q(auVar);
        if (Q < 0) {
            x.e("MicroMsg.BakOldTempStorageLogic", "insertMsgWithContact faile: type:%d, talker:%s", Integer.valueOf(auVar.getType()), auVar.field_talker);
        }
        return Q;
    }

    public static int hR(String str) {
        if (str == null || str.length() <= 0) {
            return -1;
        }
        int indexOf = str.indexOf(58);
        if (indexOf == -1 || !str.substring(0, indexOf).contains("<")) {
            return indexOf;
        }
        return -1;
    }

    public static r wd(String str) {
        if (bi.oN(str)) {
            return null;
        }
        return b.arq().arr().Ub().nv(str);
    }

    public static String we(String str) {
        c arr = b.arq().arr();
        if (arr.uin == 0) {
            throw new b();
        }
        String a = i.a(arr.gRT + "voice2/", "msg_", str, ".amr", 2);
        if (bi.oN(a)) {
            return null;
        }
        if (new File(a).exists()) {
            return a;
        }
        StringBuilder stringBuilder = new StringBuilder();
        c arr2 = b.arq().arr();
        if (arr2.uin == 0) {
            throw new b();
        }
        String stringBuilder2 = stringBuilder.append(arr2.gRT + "voice/").append(str).toString();
        if (new File(stringBuilder2 + ".amr").exists()) {
            k.r(stringBuilder2 + ".amr", a, true);
            return a;
        } else if (!new File(stringBuilder2).exists()) {
            return a;
        } else {
            k.r(stringBuilder2, a, true);
            return a;
        }
    }
}
