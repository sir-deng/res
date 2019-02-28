package com.tencent.mm.compatible.util;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.platformtools.bi;

public final class n {
    public static String eP(String str) {
        if (str == null || q.gHP.gGC == 2 || q.gHP.gGN == 1) {
            return str;
        }
        if (q.gHP.gGC == 1) {
            if (str.toString().contains("\n")) {
                return str.toString().replace("\n", " ");
            }
            return str;
        } else if (VERSION.SDK_INT == 16 && str.toString().contains("\n") && bi.aD(Build.MANUFACTURER, "").toLowerCase().indexOf("meizu".toLowerCase()) < 0) {
            return str.toString().replace("\n", " ");
        } else {
            return str;
        }
    }
}
