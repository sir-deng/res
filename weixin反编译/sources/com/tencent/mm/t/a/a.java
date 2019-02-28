package com.tencent.mm.t.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.amv;
import com.tencent.mm.protocal.c.amw;
import com.tencent.mm.protocal.c.cda;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class a extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gQm;
    private a<a> gQn;

    public interface a<T extends k> {
        void b(int i, int i2, String str, T t);
    }

    public a(String str, LinkedList<String> linkedList, a<a> aVar) {
        this(str, linkedList, 0, -1, aVar);
    }

    public a(String str, LinkedList<String> linkedList, int i, int i2, a<a> aVar) {
        this(str, linkedList, i, i2);
        this.gQn = aVar;
    }

    private a(String str, LinkedList<String> linkedList, int i, int i2) {
        x.i("MicroMsg.webview.NetSceneJSAuthorize", "NetSceneJSLogin doScene appId [%s], versionType [%d], extScene[%d]", str, Integer.valueOf(i), Integer.valueOf(i2));
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new amv();
        aVar.hnU = new amw();
        aVar.uri = "/cgi-bin/mmbiz-bin/js-authorize";
        aVar.hnS = 1157;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        amv amv = (amv) this.gLB.hnQ.hnY;
        if (i2 > 0) {
            amv.wAo = new cda();
            amv.wAo.scene = i2;
        }
        amv.nlV = str;
        amv.wAl = linkedList;
        amv.wAn = i;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.webview.NetSceneJSAuthorize", "errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.gQm != null) {
            this.gQm.a(i2, i3, str, this);
        }
        if (this.gQn != null) {
            this.gQn.b(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1157;
    }

    public final amw Cc() {
        return (amw) this.gLB.hnR.hnY;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.webview.NetSceneJSAuthorize", "doScene");
        this.gQm = eVar2;
        return a(eVar, this.gLB, this);
    }
}
