package com.tencent.mm.booter;

import com.tencent.mm.ad.e;
import com.tencent.mm.ay.k;
import com.tencent.mm.bd.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public final class n {
    private static long gAs = 86400000;

    public static void run() {
        boolean z;
        as.Hm();
        if (t.bz(Long.valueOf(t.c((Long) c.Db().get(81944, null))).longValue()) * 1000 > gAs) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            e SK = d.SK();
            d.SL();
            if (!SK.hlc) {
                g.Dr();
                if (g.Dq().isSDCardAvailable()) {
                    SK.release();
                    SK.hlc = true;
                    g.CN().a((int) JsApiGetBackgroundAudioState.CTRL_INDEX, SK);
                    g.CN().a(new k(9), 0);
                }
            }
        }
    }
}
