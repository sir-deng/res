package com.tencent.mm.af;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.anv;
import com.tencent.mm.protocal.c.anw;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class v extends k implements com.tencent.mm.network.k {
    public b gLB;
    private e gLE;
    public String hrP;
    public int hrQ;
    public String tag;

    public v(String str, LinkedList<String> linkedList) {
        this(str, linkedList, (byte) 0);
    }

    private v(String str, LinkedList<String> linkedList, byte b) {
        this.hrQ = 1;
        a aVar = new a();
        aVar.hnT = new anv();
        aVar.hnU = new anw();
        aVar.uri = "/cgi-bin/mmkf-bin/kfgetinfolist";
        aVar.hnS = 675;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        anv anv = (anv) this.gLB.hnQ.hnY;
        anv.wBB = str;
        anv.wBE = linkedList;
        this.hrP = str;
        this.hrQ = 1;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneKFGetInfoList", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 675;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        x.i("MicroMsg.NetSceneKFGetInfoList", "do scene");
        return a(eVar, this.gLB, this);
    }

    public final anw Mi() {
        if (this.gLB == null || this.gLB.hnR.hnY == null) {
            return null;
        }
        return (anw) this.gLB.hnR.hnY;
    }
}
