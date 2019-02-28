package com.tencent.mm.az;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiSetClipboardData;
import com.tencent.mm.protocal.c.afp;
import com.tencent.mm.protocal.c.afq;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.q;

public final class a extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;
    public String hLI;
    public String hLJ;
    public byte[] hLK;

    public a() {
        this(q.FY(), bi.e((Integer) g.Dq().Db().get(66561, null)), 0);
    }

    public a(String str, int i) {
        this(str, i, 0);
    }

    public a(String str, int i, int i2) {
        this.gLE = null;
        this.hLI = null;
        this.hLJ = null;
        this.hLK = null;
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new afp();
        aVar.hnU = new afq();
        aVar.uri = "/cgi-bin/micromsg-bin/getqrcode";
        aVar.hnS = JsApiSetClipboardData.CTRL_INDEX;
        aVar.hnV = 67;
        aVar.hnW = 1000000067;
        this.gLB = aVar.Kf();
        afp afp = (afp) this.gLB.hnQ.hnY;
        afp.wfM = n.oK(str);
        afp.wui = i;
        afp.vKI = i2;
        x.i("MicroMsg.NetSceneGetQRCode", "username:%s, style:%d, opcode:%d", str, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return JsApiSetClipboardData.CTRL_INDEX;
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetQRCode", "onGYNetEnd errType:" + i2 + " errCode" + i3);
        if (i2 == 0 && i3 == 0) {
            afq afq = (afq) this.gLB.hnR.hnY;
            String a = n.a(((afp) this.gLB.hnQ.hnY).wfM);
            this.hLK = n.a(afq.wuj, new byte[0]);
            this.hLI = afq.wuk;
            x.i("MicroMsg.NetSceneGetQRCode", "expiredWording:%s, revokeId:%s, revokeWording:%s", this.hLI, afq.wul, afq.wum);
            if (q.FY().equals(a)) {
                String str2 = afq.wul;
                a = (String) g.Dq().Db().get(66563, (Object) "");
                if (!(str2 == null || a.equals(str2))) {
                    g.Dq().Db().set(66563, str2);
                    this.hLJ = afq.wum;
                }
                g.Dq().Db().set(66561, Integer.valueOf(afq.wui));
            }
        }
        this.gLE.a(i2, i3, str, this);
    }
}
