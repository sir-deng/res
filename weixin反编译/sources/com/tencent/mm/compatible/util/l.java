package com.tencent.mm.compatible.util;

import android.os.Build;
import com.tencent.mm.sdk.platformtools.bi;

public final class l {
    public static boolean xn() {
        if (bi.aD(Build.MANUFACTURER, "").toLowerCase().indexOf("samsung".toLowerCase()) >= 0) {
            return true;
        }
        return false;
    }
}
