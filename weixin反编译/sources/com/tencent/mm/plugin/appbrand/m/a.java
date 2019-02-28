package com.tencent.mm.plugin.appbrand.m;

import com.tencent.mm.storage.c;

public final class a {
    public static boolean akL() {
        boolean z;
        c fp = com.tencent.mm.y.c.c.IL().fp("100159");
        if (fp.isValid() && "1".equals(fp.civ().get("isCloseWeappSearch"))) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return false;
        }
        return true;
    }
}
