package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.vj;
import com.tencent.mm.protocal.c.vk;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends k implements com.tencent.mm.network.k {
    private com.tencent.mm.ad.b gLB;
    private e gLE;
    public String rtx = "";

    public b(String str) {
        this.rtx = str;
        a aVar = new a();
        aVar.hnT = new vj();
        aVar.hnU = new vk();
        aVar.uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_favofficialitem";
        aVar.hnS = 2874;
        this.gLB = aVar.Kf();
        ((vj) this.gLB.hnQ.hnY).wlR = str;
        x.i("MicroMsg.NetSceneFavOfficialItem", "Req: item_buff[%s]", str);
    }

    public final int getType() {
        return 2874;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneFavOfficialItem", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        this.gLE.a(i2, i3, str, this);
    }
}
