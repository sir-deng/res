package com.tencent.mm.y;

import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class be extends k implements com.tencent.mm.network.k {
    private e gLE;
    private final a hiJ;
    private final String hiK;
    private long hiL;

    public interface a {
        void a(com.tencent.mm.network.e eVar);
    }

    public be(a aVar) {
        this(aVar, null);
    }

    public be(a aVar, String str) {
        x.i("MicroMsg.NetSceneLocalProxy", "init LocalProxy task:%s [%s] ", str, bi.chl());
        this.hiJ = aVar;
        this.hiK = str;
    }

    public final int getType() {
        return 0;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        c(eVar);
        this.gLE = eVar2;
        this.hiL = bi.Wz();
        g.Dt().F(new Runnable() {
            public final void run() {
                be.this.a(0, 0, 0, null, null, null);
            }

            public final String toString() {
                return super.toString() + "|doScene";
            }
        });
        return 0;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (this.hiJ != null) {
            x.d("MicroMsg.NetSceneLocalProxy", "local proxy [%s] end, cost=%d", this.hiK, Long.valueOf(bi.bB(this.hiL)));
            this.hiJ.a(this.hok);
        }
        this.gLE.a(0, 0, null, this);
    }
}
