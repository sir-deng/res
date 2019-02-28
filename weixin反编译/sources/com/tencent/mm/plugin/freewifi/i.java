package com.tencent.mm.plugin.freewifi;

import com.tencent.mm.plugin.freewifi.g.b;
import com.tencent.mm.plugin.freewifi.model.j;

public final class i {
    private b mHS;

    private static class a {
        private static i mIc = new i();
    }

    /* synthetic */ i(byte b) {
        this();
    }

    private i() {
        this.mHS = j.aMw();
    }

    public final synchronized long oO(String str) {
        long j = 0;
        synchronized (this) {
            if (!m.Bf(str)) {
                try {
                    String Bu = this.mHS.Bu(str);
                    if (!m.Bf(Bu)) {
                        j = Long.valueOf(Bu).longValue();
                    }
                } catch (Exception e) {
                }
            }
        }
        return j;
    }

    public final synchronized int getInt(String str, int i) {
        if (!m.Bf(str)) {
            try {
                String Bu = this.mHS.Bu(str);
                if (!m.Bf(Bu)) {
                    i = Integer.valueOf(Bu).intValue();
                }
            } catch (Exception e) {
            }
        }
        return i;
    }

    public final synchronized void B(String str, long j) {
        this.mHS.cK(str, String.valueOf(j));
    }

    public final synchronized void bo(String str, int i) {
        this.mHS.cK(str, String.valueOf(i));
    }
}
