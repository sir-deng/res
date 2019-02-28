package com.tencent.mm.plugin.appbrand.media.a;

import android.os.Build.VERSION;
import com.tencent.mm.ab.d;

public final class c {
    public static d bB(String str, String str2) {
        if ((VERSION.SDK_INT <= 19 ? 1 : null) != null) {
            return new b(str, str2);
        }
        return new a(str, str2);
    }
}
