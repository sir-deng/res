package com.tencent.mm.plugin.radar.b;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends k implements com.tencent.mm.network.k {
    private static final String TAG = TAG;
    public static final a pCe = new a();
    final b gLB;
    private e gLE;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        b.c.b.e.i(eVar, "dispatcher");
        b.c.b.e.i(eVar2, "callback");
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d(TAG, "netId:%d errType:%d errCode:%d errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        e eVar = this.gLE;
        if (eVar != null) {
            eVar.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 602;
    }
}
