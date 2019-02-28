package com.tencent.mm.af.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.hq;
import com.tencent.mm.protocal.c.zm;
import com.tencent.mm.protocal.c.zn;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class p extends k implements com.tencent.mm.network.k {
    public b gLB;
    private e gLE;
    Map<String, String> htf = new HashMap();

    public p(LinkedList<hq> linkedList) {
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            hq hqVar = (hq) it.next();
            String str = hqVar.vUb;
            String str2 = hqVar.vUh;
            if (!(str2 == null || str == null)) {
                this.htf.put(str, str2);
            }
        }
        a aVar = new a();
        aVar.hnT = new zm();
        aVar.hnU = new zn();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getbizchatinfolist";
        aVar.hnS = 1365;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        ((zm) this.gLB.hnQ.hnY).wqh = linkedList;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.brandservice.NetSceneGetBizChatInfoList", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1365;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        x.i("MicroMsg.brandservice.NetSceneGetBizChatInfoList", "do scene");
        return a(eVar, this.gLB, this);
    }
}
