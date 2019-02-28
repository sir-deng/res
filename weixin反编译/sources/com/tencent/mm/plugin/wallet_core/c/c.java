package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.oh;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.c.ze;
import com.tencent.mm.protocal.c.zf;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import java.util.LinkedList;

public final class c extends k implements com.tencent.mm.network.k {
    private b gLB;
    private e gLE;

    public c(LinkedList<String> linkedList) {
        x.i("MicroMsg.NetSceneGetBankcardLogo", "NetSceneGetBankcardLogo call");
        a aVar = new a();
        aVar.hnT = new ze();
        aVar.hnU = new zf();
        aVar.uri = "/cgi-bin/mmpay-bin/bankresource";
        this.gLB = aVar.Kf();
        this.gLB.hoh = true;
        ze zeVar = (ze) this.gLB.hnQ.hnY;
        zeVar.wpS = linkedList;
        zeVar.vXW = i.bLR();
        if (!f.cdG()) {
            zeVar.wbD = f.cdH();
        }
        com.tencent.mm.wallet_core.ui.e.HX(42);
    }

    public final int getType() {
        return 1650;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetBankcardLogo", "NetSceneGetBankcardLogo onGYNetEnd,errType=" + i2 + "errCode=" + i3);
        if (i2 == 0 && i3 == 0) {
            zf zfVar = (zf) ((b) qVar).hnR.hnY;
            x.i("MicroMsg.NetSceneGetBankcardLogo", "respone %s", zfVar.wpU);
            LinkedList linkedList = zfVar.wpT;
            if (linkedList == null || linkedList.size() == 0) {
                x.d("MicroMsg.NetSceneGetBankcardLogo", "empty bank logo list");
            } else {
                com.tencent.mm.sdk.b.b ohVar = new oh();
                ohVar.fGX.fGZ = linkedList;
                com.tencent.mm.sdk.b.a.xmy.m(ohVar);
            }
            g.Dr();
            g.Dq().Db().a(w.a.USERINFO_WALLET_BANKCARD_DETAIL_URL_STRING_SYNC, bi.aD(zfVar.wpU, ""));
            g.Dr();
            g.Dq().Db().a(w.a.USERINFO_WALLET_BANKCARD_DETAIL_URL_TIMESTAMP_LONG_SYNC, Long.valueOf(System.currentTimeMillis() / 1000));
        } else {
            com.tencent.mm.wallet_core.ui.e.HX(43);
        }
        this.gLE.a(i2, i3, str, this);
    }
}
