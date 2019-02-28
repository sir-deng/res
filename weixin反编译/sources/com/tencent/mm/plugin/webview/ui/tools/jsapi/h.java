package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.x;

public final class h {
    private static final SparseArray<g> tQc = new SparseArray();
    private static volatile g tQd = null;

    private h() {
    }

    @Deprecated
    public static g bVz() {
        if (tQd == null) {
            tQd = new g(0);
        }
        return tQd;
    }

    public static g Bw(int i) {
        g gVar;
        synchronized (h.class) {
            if (tQc.get(i) == null) {
                tQc.put(i, new g(i));
            }
            gVar = (g) tQc.get(i);
            tQd = gVar;
        }
        return gVar;
    }

    public static void detach() {
        x.i("MicroMsg.MsgHandlerHolder", "detach");
        synchronized (h.class) {
            for (int i = 0; i < tQc.size(); i++) {
                g gVar = (g) tQc.valueAt(i);
                int keyAt = tQc.keyAt(i);
                if (gVar != null) {
                    a.tAC.AI(keyAt);
                }
            }
            tQc.clear();
        }
        if (tQd != null) {
            a.tAC.AI(0);
            tQd = null;
        }
    }
}
