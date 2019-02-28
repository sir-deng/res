package com.tencent.mm.pluginsdk;

import com.tencent.mm.sdk.platformtools.x;

public final class s {
    private static boolean vjo = false;
    public String mTag = "";
    public boolean vjn = false;

    public s(String str) {
        this.mTag = str;
    }

    public static void bYS() {
        vjo = true;
    }

    public final boolean ch(String str) {
        if (vjo) {
            x.i("MicroMsg.SplashOptimizing", "[%s], check cancel", this.mTag);
            return false;
        } else if (!this.vjn) {
            return false;
        } else {
            x.i("MicroMsg.SplashOptimizing", "[%s], recreate activity, skip this %s", this.mTag, str);
            return true;
        }
    }
}
