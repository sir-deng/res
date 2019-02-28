package com.tencent.mm.plugin.sns.a.b;

import android.util.Base64;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.bnd;
import com.tencent.mm.protocal.c.bne;
import com.tencent.mm.protocal.c.bpb;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

public final class f {
    public static void a(String str, d dVar) {
        m LQ = ae.bwf().LQ(str);
        if (LQ != null) {
            bpb byF = LQ.byF();
            if (byF != null) {
                p.a(byF.rzD, dVar);
                return;
            }
            x.v("SnsAdExtUtil", "timeLineObject null, snsId %s", str);
            return;
        }
        x.v("SnsAdExtUtil", "snsInfo null, snsId %s", str);
    }

    public static String a(long j, Object... objArr) {
        ae.bvZ();
        StringBuilder stringBuilder = new StringBuilder(i.l(objArr));
        a(j, stringBuilder);
        return stringBuilder.toString();
    }

    public static void a(long j, StringBuilder stringBuilder) {
        e eL = ae.bwi().eL(j);
        if (eL != null) {
            bpb byF = eL.byF();
            if (byF != null) {
                bne mR = p.mR(byF.rzD);
                stringBuilder.append(",").append(mR == null ? -1 : mR.cPf);
                stringBuilder.append(",").append(p.a(mR));
                return;
            }
            x.v("SnsAdExtUtil", "l timeLineObject null, snsId %d", Long.valueOf(j));
            stringBuilder.append(",,");
            return;
        }
        x.v("SnsAdExtUtil", "l snsInfo null, snsId %d", Long.valueOf(j));
        stringBuilder.append(",,");
    }

    public static String a(bpb bpb) {
        if (bpb != null) {
            return Kd(bpb.rzD);
        }
        x.v("SnsAdExtUtil", "getSnsStatExt timeLineObject null");
        return null;
    }

    private static String Kd(String str) {
        if (bi.oN(str)) {
            return "";
        }
        byte[] decode = Base64.decode(str, 0);
        bnd bnd = new bnd();
        try {
            bnd.aH(decode);
            return p.a(bnd.wXc);
        } catch (IOException e) {
            x.e("SnsAdExtUtil", "", e);
            return "";
        }
    }
}
