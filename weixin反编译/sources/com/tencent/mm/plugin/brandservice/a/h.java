package com.tencent.mm.plugin.brandservice.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bfs;
import com.tencent.mm.protocal.c.bft;
import com.tencent.mm.protocal.c.jm;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends k implements com.tencent.mm.network.k {
    private String foW;
    private e gLE;
    private String iVa;
    private b kKw;
    private bft kKx;
    private long kKy;
    private int offset;
    private int scene;

    public h(String str, long j, int i, int i2, String str2) {
        this.foW = str;
        this.kKy = j;
        this.offset = i;
        this.scene = i2;
        this.iVa = str2;
        x.i("MicroMsg.NetSceneSearchDetailPageNew", "Constructors: keyword = (%s) , LSB exist () , businessType is (%d) , offset is (%d) , scene is (%d), searchId(%s).", str, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str2);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneSearchDetailPageNew", "netId (%d) , errType (%d) , errCode (%d) , errMsg (%s)", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0 && this.kKw != null) {
            this.kKx = (bft) this.kKw.hnR.hnY;
        }
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1071;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        if (bi.oN(this.foW)) {
            x.e("MicroMsg.NetSceneSearchDetailPageNew", "keyword is unavailable.");
            return -1;
        }
        a aVar = new a();
        aVar.hnS = 1071;
        aVar.uri = "/cgi-bin/mmbiz-bin/bizsearch/detailpage";
        aVar.hnT = new bfs();
        aVar.hnU = new bft();
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.kKw = aVar.Kf();
        bfs bfs = (bfs) this.kKw.hnQ.hnY;
        bfs.wDT = c.Jk();
        bfs.wrv = this.foW;
        bfs.vWt = this.kKy;
        bfs.vUN = this.offset;
        bfs.wRL = this.scene;
        bfs.vWw = this.iVa;
        return a(eVar, this.kKw, this);
    }

    public final jm asS() {
        return this.kKx == null ? null : this.kKx.wRN;
    }
}
