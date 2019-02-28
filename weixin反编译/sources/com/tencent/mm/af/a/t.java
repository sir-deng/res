package com.tencent.mm.af.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.alt;
import com.tencent.mm.protocal.c.alu;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class t extends k implements com.tencent.mm.network.k {
    Object data;
    public b gLB;
    private e gLE;
    public String htd;

    public t(String str, String str2, LinkedList<String> linkedList, Object obj) {
        a aVar = new a();
        aVar.hnT = new alt();
        aVar.hnU = new alu();
        aVar.uri = "/cgi-bin/mmocbiz-bin/initiatebizchat";
        this.gLB = aVar.Kf();
        alt alt = (alt) this.gLB.hnQ.hnY;
        alt.wfm = str;
        if (str2 == null) {
            str2 = "";
        }
        alt.wzG = str2;
        alt.wzH = linkedList;
        this.data = obj;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneInitiateBizChat", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1389;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        x.i("MicroMsg.NetSceneInitiateBizChat", "do scene");
        return a(eVar, this.gLB, this);
    }

    public final alu MH() {
        if (this.gLB == null || this.gLB.hnR.hnY == null) {
            return null;
        }
        return (alu) this.gLB.hnR.hnY;
    }
}
