package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Set;

public final class f {
    private Object lock = new Object();
    private Set<String> ohQ = new HashSet();

    public final boolean Ez(String str) {
        boolean z = false;
        synchronized (this.lock) {
            if (this.ohQ.contains(str)) {
                x.i("MicroMsg.LuckyMoneyMsg", "has contains msg, %s", str);
            } else {
                z = this.ohQ.add(str);
            }
        }
        return z;
    }

    public final void EA(String str) {
        synchronized (this.lock) {
            this.ohQ.remove(str);
        }
    }
}
