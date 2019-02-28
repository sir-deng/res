package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;

public interface d extends com.tencent.mm.kernel.c.a {

    public interface a {
        LocalUsageInfo ajJ();
    }

    public enum b {
        ;

        static {
            klt = 1;
            klu = 2;
            klv = new int[]{klt, klu};
        }
    }

    AppBrandRecentView a(Context context, int i, a aVar);

    void amP();

    b amQ();

    void ck(Context context);

    AppBrandRecentView y(Context context, int i);
}
