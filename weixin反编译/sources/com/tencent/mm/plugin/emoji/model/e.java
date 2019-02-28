package com.tencent.mm.plugin.emoji.model;

import com.tencent.mm.f.a.ct;
import com.tencent.mm.sdk.b.a;
import java.util.HashMap;
import java.util.Map;

public final class e {
    private ct lDk = new ct();
    public final Map<String, Integer> lDl = new HashMap();

    public final void g(String str, int i, int i2, String str2) {
        this.lDk.frP.frQ = str;
        this.lDk.frP.status = i;
        this.lDk.frP.progress = i2;
        this.lDk.frP.frR = str2;
        a.xmy.m(this.lDk);
        if (i != 6) {
            this.lDl.remove(str);
        } else if (i2 < 0 || i2 >= 100) {
            this.lDl.remove(str);
        } else {
            this.lDl.put(str, Integer.valueOf(i2));
        }
    }
}
