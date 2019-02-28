package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import android.content.Context;
import com.tencent.mm.bu.a;

public final class b {
    public static int jxj = 18;
    public static int jxk = 10;
    private static int jxl = 3;

    public static float bY(Context context) {
        return ((float) a.fromDPToPix(context, jxj)) * 2.0f;
    }

    public static int x(Context context, int i) {
        return a.fromDPToPix(context, i);
    }

    public static int ahH() {
        return jxl;
    }
}
