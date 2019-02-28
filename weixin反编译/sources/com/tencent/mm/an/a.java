package com.tencent.mm.an;

import android.os.HandlerThread;
import com.tencent.mm.bx.h.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ap;
import java.util.HashMap;

public class a implements ap {
    private static HandlerThread hAA = null;
    private static ag hAB = null;

    public static boolean b(Runnable runnable, long j) {
        boolean z = false;
        if (runnable == null) {
            return false;
        }
        if (hAB == null || hAA == null) {
            String str = "MicroMsg.GIF.SubCoreGIF";
            String str2 = "check decoder thread available fail, handler[%B] thread[%B] stack[%s]";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(hAB != null);
            if (hAA != null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            objArr[2] = bi.chl();
            x.w(str, str2, objArr);
            if (hAB != null) {
                hAB.removeCallbacksAndMessages(null);
            }
            if (hAA != null) {
                hAA.quit();
            }
            HandlerThread WL = e.WL("GIF-Decoder");
            hAA = WL;
            WL.start();
            hAB = new ag(hAA.getLooper());
        }
        if (j > 0) {
            hAB.postDelayed(runnable, j);
        } else {
            hAB.post(runnable);
        }
        return true;
    }

    public final HashMap<Integer, d> Bu() {
        return null;
    }

    public final void ge(int i) {
    }

    public final void bs(boolean z) {
        if (hAB != null) {
            hAB.removeCallbacksAndMessages(null);
        }
    }

    public final void bt(boolean z) {
    }

    public final void onAccountRelease() {
        if (hAB != null) {
            hAB.removeCallbacksAndMessages(null);
        }
    }
}
