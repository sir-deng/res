package com.tencent.mm.plugin.appbrand.i;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.anb;
import com.tencent.mm.protocal.c.anc;
import com.tencent.mm.protocal.c.cda;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends k implements com.tencent.mm.network.k {
    public final b gLB;
    private e gQm;
    private a<c> jGF;

    public interface a<T extends k> {
        void b(int i, int i2, String str, T t);
    }

    public c(String str, String str2, String str3, int i, int i2, int i3, a<c> aVar) {
        this(str, str2, str3, i, i2, i3);
        this.jGF = aVar;
    }

    private c(String str, String str2, String str3, int i, int i2, int i3) {
        x.i("MicroMsg.webview.NetSceneJSOperateWxData", "NetSceneJSLogin doScene appId [%s], data [%s], grantScope [%s], versionType [%d], opt [%d], extScene [%d]", str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new anb();
        aVar.hnU = new anc();
        aVar.uri = "/cgi-bin/mmbiz-bin/js-operatewxdata";
        aVar.hnS = 1133;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        anb anb = (anb) this.gLB.hnQ.hnY;
        anb.nlV = str;
        anb.kyn = new com.tencent.mm.bp.b(str2.getBytes() == null ? new byte[0] : str2.getBytes());
        anb.wAv = str3;
        anb.wAn = i;
        anb.wAm = i2;
        if (i3 > 0) {
            anb.wAo = new cda();
            anb.wAo.scene = i3;
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.webview.NetSceneJSOperateWxData", "errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.gQm != null) {
            this.gQm.a(i2, i3, str, this);
        }
        if (this.jGF != null) {
            this.jGF.b(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1133;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.webview.NetSceneJSOperateWxData", "doScene");
        this.gQm = eVar2;
        return a(eVar, this.gLB, this);
    }
}
