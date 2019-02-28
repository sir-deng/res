package com.tencent.mm.plugin.multitalk.ui.widget;

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
    public static final int oNF = a.fromDPToPix(ad.getContext(), 26);
    public static final int oNG = a.fromDPToPix(ad.getContext(), 32);
    public static final int oNH = a.fromDPToPix(ad.getContext(), 96);
    public static final int oNI = a.fromDPToPix(ad.getContext(), 76);
    public static final int oNJ = a.fromDPToPix(ad.getContext(), bs.CTRL_INDEX);
    private static int oNK = 0;
    public static final int oNz = a.fromDPToPix(ad.getContext(), 3);

    public static int dh(Context context) {
        if (oNK == 0) {
            oNK = a.eC(context) - oNJ;
        }
        return oNK;
    }
}
