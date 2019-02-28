package com.tencent.mm.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class d {
    private static a xMF;
    private static HashMap<Integer, Long> xMG = new HashMap();
    private static int xMH = 1100;
    private static int xMI = MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN;
    private static long xMJ = 0;

    public interface a {
        void b(long j, String str, String str2);
    }

    public static synchronized boolean a(Context context, boolean z, Intent[] intentArr, Object... objArr) {
        boolean z2;
        synchronized (d.class) {
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.toString()).append(",");
            for (Object append : intentArr) {
                stringBuilder.append(append);
                stringBuilder.append(",");
            }
            for (Object append2 : objArr) {
                stringBuilder.append(append2);
                stringBuilder.append(",");
            }
            Integer valueOf = Integer.valueOf(stringBuilder.toString().hashCode());
            Long l = (Long) xMG.get(valueOf);
            Long valueOf2 = Long.valueOf(System.currentTimeMillis());
            if (z && l != null) {
                if (valueOf2.longValue() - l.longValue() <= ((long) xMI)) {
                    xMF.b(valueOf2.longValue() - l.longValue(), YT(context.getClass().toString()), intentArr[0].getComponent() != null ? YT(intentArr[0].getComponent().getClassName()) : "None");
                }
                if (valueOf2.longValue() - l.longValue() <= ((long) xMH)) {
                    xMG.put(valueOf, valueOf2);
                    x.e("MicroMsg.CheckReduplicatedAcitiv", "starting the same activity in %sms, [k:%s, v:%s], curr: %s", Integer.valueOf(xMH), r5, l, valueOf2);
                    z2 = true;
                }
            }
            if (xMG.size() > 100 && xMJ != 0 && System.currentTimeMillis() - xMJ > ((long) xMH)) {
                xMG.clear();
            }
            xMG.put(valueOf, valueOf2);
            xMJ = System.currentTimeMillis();
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            x.i("MicroMsg.CheckReduplicatedAcitiv", "check reduplicated cost %sms", Long.valueOf(currentTimeMillis2));
            z2 = false;
        }
        return z2;
    }

    public static void a(a aVar) {
        xMF = aVar;
    }

    private static String YT(String str) {
        String[] split = str.split("\\.");
        if (split.length > 0) {
            return split[split.length - 1];
        }
        return "";
    }

    public static int cmH() {
        return xMH;
    }
}
