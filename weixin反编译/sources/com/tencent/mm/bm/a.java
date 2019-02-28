package com.tencent.mm.bm;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bp;
import com.tencent.mm.y.c;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class a {
    private static final Map<Integer, Integer> vGH = new HashMap();

    public static void run() {
        as.Hm();
        if ((bi.bz(bi.a((Long) c.Db().get(66819, null), 0)) * 1000 > 1800000 ? 1 : null) != null) {
            TN("");
        }
    }

    public static void CV(int i) {
        vGH.put(Integer.valueOf(i), Integer.valueOf(bi.e((Integer) vGH.get(Integer.valueOf(i))) + 1));
    }

    public static String cdK() {
        String str = "[a=" + (as.Hm() == null ? "0" : "1") + " ";
        if (as.Hm() == null) {
            return str;
        }
        StringBuilder append = new StringBuilder().append(str).append("c=");
        as.Hm();
        return append.append(c.Db() == null ? "0" : "1").append(" ").toString() + "u=" + (as.Hp() ? "1" : "0") + "]";
    }

    public static void TN(String str) {
        String str2 = str + cdK();
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : vGH.entrySet()) {
            if (!(entry == null || entry.getKey() == null || entry.getValue() == null || ((Integer) entry.getValue()).intValue() == 0)) {
                stringBuilder.append(entry.getKey());
                stringBuilder.append('=');
                stringBuilder.append(entry.getValue());
                stringBuilder.append(',');
            }
        }
        vGH.clear();
        if (stringBuilder.length() > 0) {
            x.d("MicroMsg.PostTaskFMessageCardStat", "append fmesage card click");
            bp.r(10, stringBuilder.toString());
        }
        x.d("MicroMsg.PostTaskFMessageCardStat", "dkfm :" + (str2 + cdK()));
        try {
            as.Hm();
            c.Db().set(66819, Long.valueOf(bi.Wx()));
        } catch (Exception e) {
            x.e("MicroMsg.PostTaskFMessageCardStat", "e:" + e.getMessage());
        }
    }
}
