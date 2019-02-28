package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;

public final class c {
    public e ptL;

    public c(String str) {
        this.ptL = new e(str, 10);
    }

    public final d bV(String str, int i) {
        byte[] readFromFile = e.readFromFile(this.ptL.ptV + bW(str, i));
        if (readFromFile == null || readFromFile.length == 0) {
            return null;
        }
        try {
            return (d) new d().aH(readFromFile);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.DraftBoxMgr", e, "", new Object[0]);
            return null;
        }
    }

    public static String bW(String str, int i) {
        if (str != null && str.length() != 0) {
            return str + "_" + i;
        }
        StringBuilder stringBuilder = new StringBuilder();
        as.Hm();
        return stringBuilder.append(com.tencent.mm.y.c.Db().get(9, null)).toString();
    }
}
