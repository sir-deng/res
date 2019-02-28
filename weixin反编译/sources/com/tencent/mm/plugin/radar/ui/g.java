package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import b.c.b.e;
import com.tencent.mm.protocal.c.bbo;
import com.tencent.mm.protocal.c.bbr;

public final class g {
    public static final g pFl = new g();

    private g() {
    }

    public static String b(bbr bbr) {
        e.i(bbr, "member");
        String str = bbr.kyG;
        if (str != null) {
            return str;
        }
        str = bbr.wjz;
        return str == null ? "" : str;
    }

    public static String a(bbo bbo) {
        if (bbo != null) {
            String str = bbo.wjz;
            if (str == null) {
                str = bbo.kyG;
                if (str == null) {
                    str = "";
                }
            }
            if (str != null) {
                return str;
            }
        }
        return "";
    }

    public static String c(bbr bbr) {
        if (bbr != null) {
            String str = bbr.wjz;
            if (str == null) {
                str = bbr.kyG;
                if (str == null) {
                    str = "";
                }
            }
            if (str != null) {
                return str;
            }
        }
        return "";
    }

    public static boolean dp(Context context) {
        e.i(context, "context");
        Object resources = context.getResources();
        e.h(resources, "context.resources");
        return resources.getDisplayMetrics().densityDpi <= 240;
    }
}
