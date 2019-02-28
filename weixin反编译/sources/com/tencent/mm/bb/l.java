package com.tencent.mm.bb;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public final class l {
    private static Map<String, Long> hMY = new HashMap();
    private static Map<String, Long> hMZ = new HashMap();
    private static Map<String, Long> hNa = new HashMap();
    private static Map<String, Long> hNb = new HashMap();

    public static void lY(String str) {
        x.i("SearchWidgetStartTrace", "recv rsp widget %s", str);
        hMY.put(str, Long.valueOf(System.currentTimeMillis()));
        g.pWK.h(717, 1);
    }

    public static void lZ(String str) {
        x.i("SearchWidgetStartTrace", "jsapiInsertWidget %s", str);
        g.pWK.h(717, 19);
    }

    public static void ma(String str) {
        x.i("SearchWidgetStartTrace", "realInsert %s", str);
        g.pWK.h(717, 3);
    }

    public static void E(String str, boolean z) {
        x.i("SearchWidgetStartTrace", "drawEnd %s,succ %s", str, Boolean.valueOf(z));
        if (z) {
            g.pWK.h(717, 0);
            long longValue = hMY.containsKey(str) ? ((Long) hMY.get(str)).longValue() : 0;
            if (longValue > 0) {
                int floor = (int) Math.floor((((double) (System.currentTimeMillis() - longValue)) * 1.0d) / 500.0d);
                if (floor > 16) {
                    floor = 16;
                }
                x.i("SearchWidgetStartTrace", "report time cost id %d, key %d", Long.valueOf(718), Integer.valueOf(floor));
                g.pWK.h(718, (long) floor);
                return;
            }
            x.e("SearchWidgetStartTrace", "can't find widget Recv timestamp for appid %s", str);
            return;
        }
        g.pWK.h(717, 22);
    }

    public static void Rn() {
        x.i("SearchWidgetStartTrace", "hasInitData %s", Boolean.valueOf(true));
        g.pWK.h(717, 20);
    }
}
