package com.tencent.mm.plugin.backup.g;

import com.tencent.mm.f.b.ak;
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

public final class c {
    public static void k(HashMap<String, Integer> hashMap) {
        x.i("MicroMsg.BackupStorageLogic", "buildConversation, unReadSum size[%d]", Integer.valueOf(hashMap.size()));
        for (String str : hashMap.keySet()) {
            cg dr = d.aqL().aqM().Fh().dr(str, " and not ( type = 10000 and isSend != 2 ) ");
            if (dr != null) {
                int intValue = ((Integer) hashMap.get(str)).intValue();
                String str2 = dr.field_talker;
                x.i("MicroMsg.BackupStorageLogic", "updateConvFromLastMsg, talker:%s, addUnreadCount:%d", str2, Integer.valueOf(intValue));
                ak XF = d.aqL().aqM().Fk().XF(str2);
                if (XF == null || XF.field_conversationTime <= dr.field_createTime || XF.field_conversationTime == Long.MAX_VALUE) {
                    ae aeVar;
                    boolean z;
                    if (XF == null) {
                        aeVar = new ae(str2);
                        z = true;
                    } else {
                        ak aeVar2 = XF;
                        z = false;
                    }
                    aeVar2.eS(dr.field_isSend);
                    aeVar2.eP(intValue + aeVar2.field_unReadCount);
                    aeVar2.ac(dr);
                    aeVar2.dG(Integer.toString(dr.getType()));
                    aeVar2.ak((aeVar2.field_flag & 4611686018427387904L) | (dr.field_createTime & 72057594037927935L));
                    aeVar2.eO(0);
                    x.i("MicroMsg.BackupStorageLogic", "updateConvFromLastMsg, isNewConv[%b], talker[%s], flag[%d]", Boolean.valueOf(z), str2, Long.valueOf(aeVar2.field_flag));
                    if (z) {
                        d.aqL().aqM().Fk().d(aeVar2);
                    } else {
                        d.aqL().aqM().Fk().a(aeVar2, str2);
                    }
                } else {
                    x.e("MicroMsg.BackupStorageLogic", "updateConvFromLastMsg ignore(maybe the system time is bigger than normal)");
                }
            }
        }
        d.aqL().aqM().Fk().cjr();
    }

    public static boolean eX(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        return str.endsWith("@chatroom");
    }

    public static long i(au auVar) {
        a Xv = d.aqL().aqM().Ff().Xv(auVar.field_talker);
        if (Xv == null || ((int) Xv.gKO) == 0) {
            if (!bi.oN(auVar.field_talker)) {
                d.aqL().aqN().e(2, auVar.field_talker);
                d.aqL().aqM().Ff().S(new com.tencent.mm.storage.x(auVar.field_talker));
            } else if (auVar.field_talker.endsWith("@chatroom")) {
                b aqM = d.aqL().aqM();
                if (aqM.uin == 0) {
                    throw new b();
                } else if (aqM.kvE.hK(auVar.field_talker) == null) {
                    d.aqL().aqN().e(2, auVar.field_talker);
                }
            }
        }
        long Q = d.aqL().aqM().Fh().Q(auVar);
        if (Q < 0) {
            x.e("MicroMsg.BackupStorageLogic", "insertMsgWithContact faile: type:%d, talker:%s", Integer.valueOf(auVar.getType()), auVar.field_talker);
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
        return d.aqL().aqM().Ub().nv(str);
    }

    public static String we(String str) {
        b aqM = d.aqL().aqM();
        if (aqM.uin == 0) {
            throw new b();
        }
        String a = i.a(aqM.gRT + "voice2/", "msg_", str, ".amr", 2);
        if (bi.oN(a)) {
            return null;
        }
        if (new File(a).exists()) {
            return a;
        }
        StringBuilder stringBuilder = new StringBuilder();
        b aqM2 = d.aqL().aqM();
        if (aqM2.uin == 0) {
            throw new b();
        }
        String stringBuilder2 = stringBuilder.append(aqM2.gRT + "voice/").append(str).toString();
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
