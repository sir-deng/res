package com.tencent.mm.bb;

import android.content.SharedPreferences;
import android.util.Base64;
import com.tencent.mm.protocal.c.atc;
import com.tencent.mm.protocal.c.atd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;

public final class d {
    public static atd hMs;

    public static atd Re() {
        if (hMs == null) {
            String Rc = Rc();
            hMs = new atd();
            Rc = ad.getContext().getSharedPreferences("fts_recent_biz_sp", 0).getString(Rc, "");
            if (!bi.oN(Rc)) {
                try {
                    hMs.aH(Base64.decode(Rc.getBytes(), 0));
                } catch (IOException e) {
                }
            }
        }
        return hMs;
    }

    private static String Rc() {
        return "key_pb_most_search_biz_list" + q.FY();
    }

    public static void lW(String str) {
        if (s.gI(str)) {
            atc atc;
            SharedPreferences sharedPreferences;
            if (hMs == null) {
                Re();
            }
            long currentTimeMillis = System.currentTimeMillis();
            atc atc2 = null;
            int i = 0;
            while (i < hMs.kyB.size()) {
                atc = (atc) hMs.kyB.get(i);
                long j = (currentTimeMillis - atc.wHs) / 86400000;
                atc.wHr *= Math.pow(0.98d, (double) j);
                atc.wHs = (j * 86400000) + atc.wHs;
                x.d("MicroMsg.FTS.FTSMostSearchBizLogic", "after update: %.2f %d %s", Double.valueOf(atc.wHr), Long.valueOf(atc.wHs), atc.vPp);
                if (!atc.vPp.equals(str)) {
                    atc = atc2;
                }
                i++;
                atc2 = atc;
            }
            if (atc2 == null) {
                atc = new atc();
                atc.wHr = 1.0d;
                atc.wHs = currentTimeMillis;
                atc.vPp = str;
                hMs.kyB.add(atc);
                x.i("MicroMsg.FTS.FTSMostSearchBizLogic", "add new use %s", str);
            } else {
                atc2.wHr += 1.0d;
                x.i("MicroMsg.FTS.FTSMostSearchBizLogic", "update use %s %.2f", str, Double.valueOf(atc2.wHr));
            }
            Collections.sort(hMs.kyB, new Comparator<atc>() {
                public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                    atc atc = (atc) obj;
                    atc atc2 = (atc) obj2;
                    if (atc.wHr > atc2.wHr) {
                        return 1;
                    }
                    return atc.wHr < atc2.wHr ? -1 : 0;
                }
            });
            int size = hMs.kyB.size() - 1;
            while (true) {
                int i2 = size;
                if (i2 >= hMs.kyB.size() || hMs.kyB.size() <= 8) {
                    sharedPreferences = ad.getContext().getSharedPreferences("fts_recent_biz_sp", 0);
                } else {
                    if (((atc) hMs.kyB.get(i2)).wHr < 0.5d) {
                        hMs.kyB.remove(i2);
                    }
                    size = i2 + 1;
                }
            }
            sharedPreferences = ad.getContext().getSharedPreferences("fts_recent_biz_sp", 0);
            try {
                sharedPreferences.edit().putString(Rc(), Base64.encodeToString(hMs.toByteArray(), 0)).commit();
                x.i("MicroMsg.FTS.FTSMostSearchBizLogic", "useBiz pbListString %s", r2);
            } catch (IOException e) {
            }
        }
    }
}
