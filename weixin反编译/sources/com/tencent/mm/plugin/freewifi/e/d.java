package com.tencent.mm.plugin.freewifi.e;

import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.x;

public final class d {
    private String fqu;
    private String fsK;
    private int mKK;

    private static class a {
        private static d mKL = new d();
    }

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
    }

    public final synchronized boolean j(int i, String str, String str2) {
        boolean z = true;
        synchronized (this) {
            boolean z2;
            x.i("MicroMsg.FreeWifi.Protocol31Locker", "threeOneStartUpType=%d, apKey=%s, ticket=%s", Integer.valueOf(i), str, str2);
            if (i == 1 || i == 2 || i == 3) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if (m.Bf(str) || m.Bf(str2)) {
                    z = false;
                } else if (str.equals(this.fqu) && str2.equals(this.fsK) && this.mKK != i) {
                    z = false;
                } else {
                    this.mKK = i;
                    this.fqu = str;
                    this.fsK = str2;
                }
            }
        }
        return z;
    }
}
