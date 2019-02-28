package com.tencent.mm.plugin.product.b;

import android.content.Context;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.tr;
import com.tencent.mm.sdk.platformtools.bi;

public final class b {
    public static String l(int i, int i2, String str) {
        if (i == i2) {
            return c((double) i, str);
        }
        return String.format("%s~%s", new Object[]{c((double) i2, str), c((double) i, str)});
    }

    public static String c(double d, String str) {
        if ("CNY".equals(str) || "1".equals(str) || bi.oN(str)) {
            return String.format("¥%.2f", new Object[]{Double.valueOf(d / 100.0d)});
        }
        return String.format("%s%.2f", new Object[]{str, Double.valueOf(d / 100.0d)});
    }

    public static String a(Context context, tr trVar) {
        if (trVar.vWH > 0) {
            return trVar.nkW + " " + c((double) trVar.vWH, trVar.whH);
        }
        return context.getString(i.uSn);
    }
}
