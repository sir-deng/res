package com.tencent.mm.plugin.wenote.b;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.y.c.c;

public final class a {
    public static boolean bYq() {
        int i;
        String str = (String) c.IL().fp("100352").civ().get("Close");
        if (bi.oN(str)) {
            i = 0;
        } else {
            i = bi.getInt(str, 0);
        }
        return i == 0;
    }
}
