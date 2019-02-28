package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.mm.a.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.protocal.c.ako;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.blb;
import com.tencent.mm.protocal.c.blf;
import com.tencent.mm.protocal.c.blu;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.q;
import java.util.HashMap;
import java.util.List;

public final class m {
    private static final ThreadLocal<HashMap<String, Long>> qYe = new ThreadLocal();

    public static boolean Kz(String str) {
        com.tencent.mm.plugin.sns.storage.m LR = ae.bwf().LR(str);
        return a(LR, ai.n(LR));
    }

    public static boolean h(com.tencent.mm.plugin.sns.storage.m mVar) {
        return a(mVar, ai.n(mVar));
    }

    public static boolean a(com.tencent.mm.plugin.sns.storage.m mVar, blf blf) {
        arf byS = mVar.byS();
        if (mVar.field_type != 21) {
            return true;
        }
        if (byS.fMy == 1) {
            return true;
        }
        if (q.FY().equals(mVar.field_userName)) {
            return true;
        }
        if (blf.wVf != null) {
            List<blb> list = blf.wVf.wVI;
            if (list == null || list.size() == 0) {
                return false;
            }
            String FY = q.FY();
            for (blb blb : list) {
                if (FY.equals(blb.vPp)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int i(com.tencent.mm.plugin.sns.storage.m mVar) {
        if (mVar == null) {
            return 0;
        }
        blf n = ai.n(mVar);
        if (n == null) {
            return 0;
        }
        blu blu = n.wVf;
        return (blu == null || blu.wVI.size() == 0) ? 0 : blu.wVI.size();
    }

    public static long j(com.tencent.mm.plugin.sns.storage.m mVar) {
        return b(mVar, null);
    }

    public static long b(com.tencent.mm.plugin.sns.storage.m mVar, blf blf) {
        long j = 0;
        if (mVar == null) {
            return 0;
        }
        if (blf == null) {
            blf = ai.n(mVar);
        }
        if (blf == null) {
            return 0;
        }
        blu blu = blf.wVf;
        if (blu == null) {
            return 0;
        }
        List<blb> list = blu.wVI;
        if (list == null) {
            return 0;
        }
        Object obj;
        String str = mVar.ruL;
        if (bi.oN(str)) {
            obj = g.s(mVar.field_content) + g.s(mVar.field_attrBuf);
        } else {
            String obj2 = str;
        }
        HashMap hashMap = (HashMap) qYe.get();
        if (hashMap != null && hashMap.containsKey(obj2)) {
            return ((Long) hashMap.get(obj2)).longValue();
        }
        for (blb blb : list) {
            ako ako = new ako();
            try {
                ako.aH(n.a(blb.wUr));
            } catch (Exception e) {
                x.e("MicrMsg.SnsLuckyUtil", e.getMessage() + "hbBuffer is error");
            }
            j += ako.fMM;
        }
        if (hashMap == null) {
            hashMap = new HashMap();
        }
        hashMap.put(obj2, Long.valueOf(j));
        qYe.set(hashMap);
        return j;
    }
}
