package com.tencent.mm.plugin.mall.b;

import android.widget.ImageView;
import com.tencent.mm.a.g;
import com.tencent.mm.ap.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.f.a.rf;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import java.text.SimpleDateFormat;

public final class a {
    private static SimpleDateFormat ldn = null;
    private static SimpleDateFormat ldo = null;
    private static final String osp = (e.bnF + "wallet/mall");

    public static void aZa() {
        b rfVar = new rf();
        rfVar.fJN.fJO = false;
        com.tencent.mm.sdk.b.a.xmy.m(rfVar);
    }

    public static void k(ImageView imageView, String str) {
        f(imageView, str, 0);
    }

    public static void f(ImageView imageView, String str, int i) {
        String str2 = null;
        if (imageView != null) {
            imageView.setImageBitmap(null);
            if (!bi.oN(str)) {
                com.tencent.mm.ap.a.a.c.a aVar = new com.tencent.mm.ap.a.a.c.a();
                if (!bi.oN(str)) {
                    str2 = String.format("%s/%s", new Object[]{osp, g.s(str.getBytes())});
                }
                aVar.hFo = str2;
                aVar.hFl = true;
                aVar.hFI = true;
                aVar.hFJ = false;
                if (i != 0) {
                    aVar.hFA = i;
                }
                o.PG().a(str, imageView, aVar.PQ());
            } else if (i != 0) {
                imageView.setImageResource(i);
            }
        }
    }
}
