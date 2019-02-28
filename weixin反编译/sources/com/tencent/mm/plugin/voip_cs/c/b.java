package com.tencent.mm.plugin.voip_cs.c;

import android.content.Context;
import com.tencent.mm.bu.a;
import com.tencent.mm.plugin.appbrand.jsapi.bs;
import com.tencent.mm.sdk.platformtools.ad;

public final class b {
    public static final int oNA = a.fromDPToPix(ad.getContext(), 4);
    public static final int oNB = a.fromDPToPix(ad.getContext(), 8);
    public static final int oNC = a.fromDPToPix(ad.getContext(), 10);
    public static final int oND = a.fromDPToPix(ad.getContext(), 14);
    public static final int oNE = a.fromDPToPix(ad.getContext(), 30);
    public static final int oNG = a.fromDPToPix(ad.getContext(), 32);
    public static final int oNH = a.fromDPToPix(ad.getContext(), 96);
    public static final int oNI = a.fromDPToPix(ad.getContext(), 76);
    public static final int oNJ = a.fromDPToPix(ad.getContext(), bs.CTRL_INDEX);
    public static final int oNz = a.fromDPToPix(ad.getContext(), 3);
    private static int sEb = 0;

    public static int dJ(Context context) {
        if (sEb == 0) {
            sEb = a.eC(context);
        }
        return sEb;
    }
}
