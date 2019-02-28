package com.tencent.mm.plugin.base.model;

import android.os.Process;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class c {
    public static String wm(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String r = bi.r(ad.getContext(), Process.myPid());
        x.i("MicroMsg.ShortcutUtil", "process name: %s", r);
        if (!str.startsWith("shortcut_") || str.length() <= 9) {
            return str;
        }
        r = str.substring(9);
        if (r == null || r.length() <= 0) {
            return str;
        }
        return b.bP(new String(b.wl(r)), q.yL());
    }

    public static String bQ(String str, String str2) {
        return g.s((g.s(str.getBytes()) + b.bP(str2, str)).getBytes());
    }

    public static String wn(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String r = bi.r(ad.getContext(), Process.myPid());
        x.i("MicroMsg.ShortcutUtil", "process name: %s", r);
        r = b.bP(str, q.yL());
        if (bi.oN(r)) {
            return null;
        }
        return "shortcut_" + b.ac(r.getBytes());
    }
}
