package com.tencent.mm.bk;

import android.os.Build.VERSION;
import com.tencent.mm.v.a.f;

public final class a {
    public static int bYI() {
        if (VERSION.SDK_INT < 19) {
            return f.bEq;
        }
        return f.bEr;
    }
}
