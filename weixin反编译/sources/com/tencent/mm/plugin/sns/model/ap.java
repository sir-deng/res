package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.a.e;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class ap {
    public static String aL(int i, String str) {
        String a = d.a("snsvideo", (long) i, "sns", str);
        if (bi.oN(a)) {
            return null;
        }
        return a;
    }

    public static String nw(String str) {
        if (bi.oN(str)) {
            return "";
        }
        x.d("MicroMsg.SnsVideoLogic", "gen sns[%s] video file name [%s]", str, "SNS_" + str);
        return "SNS_" + str;
    }

    public static String KX(String str) {
        if (bi.oN(str)) {
            return "";
        }
        int indexOf = str.indexOf("SNS_");
        if (indexOf < 0) {
            return "";
        }
        String str2 = "";
        try {
            return str.substring(indexOf + 4);
        } catch (Exception e) {
            return str2;
        }
    }

    public static String KY(String str) {
        if (bi.oN(str)) {
            return null;
        }
        x.i("MicroMsg.SnsVideoLogic", "get sns video dir %s mediaId %s", am.r(ae.getAccSnsPath(), str), str);
        return am.r(ae.getAccSnsPath(), str);
    }

    public static String D(are are) {
        if (are == null) {
            return null;
        }
        x.i("MicroMsg.SnsVideoLogic", "get sns video path %s", am.r(ae.getAccSnsPath(), are.nMq) + i.j(are));
        return am.r(ae.getAccSnsPath(), are.nMq) + i.j(are);
    }

    public static String a(String str, are are) {
        String str2;
        if (are == null) {
            str2 = null;
        } else {
            str2 = am.r(ae.getAccSnsPath(), are.nMq) + i.p(are);
            x.i("MicroMsg.SnsVideoLogic", "get sns video tmp path %s", str2);
        }
        if (e.bO(str2)) {
            x.i("MicroMsg.SnsVideoLogic", "it needn't download video[%s] because of the video is self. %s", str, str2);
            return str2;
        }
        str2 = D(are);
        boolean bO = e.bO(str2);
        r KZ = KZ(str);
        if (KZ == null) {
            if (bO) {
                x.i("MicroMsg.SnsVideoLogic", "it old version already download video[%s]. path :%s", str, str2);
                return str2;
            }
            x.i("MicroMsg.SnsVideoLogic", "video info is null and file is no exists, return null.[%s]", str);
            return null;
        } else if (bO && KZ.Uq()) {
            x.i("MicroMsg.SnsVideoLogic", "it had download sns video[%s] finish. %s", str, str2);
            return str2;
        } else {
            x.i("MicroMsg.SnsVideoLogic", "it don't download video[%s] finish. file[%b] status[%d], return null.", str, Boolean.valueOf(bO), Integer.valueOf(KZ.status));
            return null;
        }
    }

    public static boolean ch(String str, int i) {
        if (bi.oN(str)) {
            x.w("MicroMsg.SnsVideoLogic", "init sns record, but snsLocalId is null");
            return false;
        }
        String nw = nw(str);
        r rVar = new r();
        rVar.fileName = nw;
        rVar.hXs = bi.Wx();
        rVar.status = 130;
        rVar.hvw = i;
        x.i("MicroMsg.SnsVideoLogic", "init sns Record filename %s, insert %b", nw, Boolean.valueOf(o.Ub().a(rVar)));
        return o.Ub().a(rVar);
    }

    public static boolean c(r rVar, int i) {
        rVar.status = 130;
        rVar.hvw = i;
        rVar.fEo = 268435712;
        x.i("MicroMsg.SnsVideoLogic", "update sns Record filename %s, update %b", rVar.getFileName(), Boolean.valueOf(o.Ub().b(rVar)));
        return o.Ub().b(rVar);
    }

    public static boolean ej(String str, String str2) {
        int i;
        boolean a;
        r KZ = KZ(str);
        if (KZ == null) {
            KZ = new r();
            KZ.fileName = nw(str);
            i = 1;
        } else {
            i = 0;
        }
        KZ.hXs = bi.Wx();
        KZ.fIf = str2;
        KZ.status = 199;
        if (i != 0) {
            a = o.Ub().a(KZ);
        } else {
            KZ.fEo = 33555200;
            a = o.Ub().b(KZ);
        }
        x.i("MicroMsg.SnsVideoLogic", "post sns video snsLocalId %s, md5 %s ret %b", str, str2, Boolean.valueOf(a));
        return a;
    }

    public static r KZ(String str) {
        if (bi.oN(str)) {
            return null;
        }
        return t.nJ(nw(str));
    }
}
