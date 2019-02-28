package com.tencent.mm.plugin.exdevice.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.x;

public abstract class a<RequestType extends com.tencent.mm.bp.a, ResponseType extends com.tencent.mm.bp.a> extends k implements com.tencent.mm.network.k {
    private e gQm;
    protected b lPF;

    public abstract RequestType aEj();

    public abstract ResponseType aEk();

    public abstract String getUri();

    public void g(RequestType requestType) {
    }

    public final ResponseType aqo() {
        if (this.lPF == null || this.lPF.hnR.hnY == null) {
            return null;
        }
        return this.lPF.hnR.hnY;
    }

    public void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.BaseNetScene", "onGYNetEnd netId %d, errType %d, errCode %d, errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.gQm != null) {
            this.gQm.a(i2, i3, str, this);
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gQm = eVar2;
        if (this.lPF == null) {
            com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
            aVar.hnS = getType();
            aVar.uri = getUri();
            aVar.hnT = aEj();
            aVar.hnU = aEk();
            aVar.hnV = 0;
            aVar.hnW = 0;
            this.lPF = aVar.Kf();
            g(this.lPF.hnQ.hnY);
        }
        return a(eVar, this.lPF, this);
    }
}
