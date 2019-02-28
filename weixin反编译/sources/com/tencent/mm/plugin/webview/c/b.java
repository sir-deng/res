package com.tencent.mm.plugin.webview.c;

import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.bfu;
import com.tencent.mm.protocal.c.bfv;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends k implements com.tencent.mm.network.k {
    private final com.tencent.mm.ad.b gLB;
    private e gQm;
    private long lDA = 0;
    private byte[] lEA = null;
    private String lEC;
    private int lEp;
    int trO = -1;
    boolean trP = true;

    public b(int i, String str, byte[] bArr, int i2, long j) {
        a aVar = new a();
        aVar.hnT = new bfu();
        aVar.hnU = new bfv();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsearchemotion";
        aVar.hnS = 234;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        this.lEp = i;
        this.lEC = str;
        this.lEA = bArr;
        this.trO = i2;
        this.lDA = j;
    }

    public final int getType() {
        return 234;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gQm = eVar2;
        bfu bfu = (bfu) this.gLB.hnQ.hnY;
        if (bi.by(this.lEA)) {
            bfu.wru = new bes();
            this.trP = true;
        } else {
            bfu.wru = n.N(this.lEA);
            this.trP = false;
            bfu.wrx = this.lDA;
        }
        x.d("MicroMsg.emoji.NetSceneSearchEmotion", bfu.wru == null ? "Buf is NULL" : bfu.wru.toString());
        bfu.vRY = this.lEp;
        bfu.wrv = this.lEC;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.emoji.NetSceneSearchEmotion", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.gQm.a(i2, i3, str, this);
    }

    public final bfv bPQ() {
        return this.gLB == null ? null : (bfv) this.gLB.hnR.hnY;
    }
}
