package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.lj;
import com.tencent.mm.protocal.c.lk;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends k implements com.tencent.mm.network.k {
    public String fqL;
    private e gLE;
    private b hPx;
    public lk lop;

    public i(int i, com.tencent.mm.bp.b bVar, String str) {
        a aVar = new a();
        aVar.hnT = new lj();
        aVar.hnU = new lk();
        aVar.uri = "/cgi-bin/mmpay-bin/getf2frcvvoice";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.hPx = aVar.Kf();
        lj ljVar = (lj) this.hPx.hnQ.hnY;
        ljVar.oeK = i;
        ljVar.waW = 1;
        ljVar.loT = str;
        ljVar.waU = null;
        ljVar.waV = bVar;
        this.fqL = str;
        x.i("MicroMsg.NetSceneF2FRcvVoice", "amount: %d, outtradeno: %s", Integer.valueOf(i), str);
    }

    public final int getType() {
        return 1384;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.hPx, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneF2FRcvVoice", "errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.lop = (lk) ((b) qVar).hnR.hnY;
        x.i("MicroMsg.NetSceneF2FRcvVoice", "ret_code: %d, ret_msg: %s，voice_type: %d", Integer.valueOf(this.lop.lot), this.lop.lou, Integer.valueOf(this.lop.waW));
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }
}
