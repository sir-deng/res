package com.tencent.mm.plugin.wallet_core.c.a;

import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.axb;
import com.tencent.mm.protocal.c.axc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.wallet_core.c.l;

public final class b extends l {
    private com.tencent.mm.ad.b gLB;
    private e gLE;
    public String jumpUrl;
    public int sPj = 0;

    public b() {
        boolean booleanValue;
        a aVar = new a();
        com.tencent.mm.bp.a axb = new axb();
        g.Dr();
        Object obj = g.Dq().Db().get(w.a.USERINFO_HAD_SHOW_WALLET_MULTI_WALLET_GUIDE_BOOLEAN, Boolean.valueOf(false));
        if (obj != null) {
            booleanValue = ((Boolean) obj).booleanValue();
        } else {
            booleanValue = false;
        }
        axb.wLa = booleanValue ? 1 : 0;
        aVar.hnT = axb;
        aVar.hnU = new axc();
        aVar.uri = "/cgi-bin/mmpay-bin/payibggetjumpurl";
        aVar.hnS = 1564;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneIbgPayGetJumpUrl", "hy: get ibg jump url raw net errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        axc axc = (axc) ((com.tencent.mm.ad.b) qVar).hnR.hnY;
        if (i == 0 && i2 == 0) {
            x.i("MicroMsg.NetSceneIbgPayGetJumpUrl", "hy: get ibg pay jump url. biz_errcode: %d, biz_errmsg: %s", Integer.valueOf(axc.lUc), axc.lUd);
            str = axc.lUd;
            i2 = axc.lUc;
            this.jumpUrl = axc.nkN;
            this.sPj = axc.wLb;
        } else {
            x.e("MicroMsg.NetSceneIbgPayGetJumpUrl", "hy: get ibg pay jump url failed");
            this.jumpUrl = null;
        }
        if (bi.oN(str)) {
            str = ad.getContext().getString(i.uXI);
        }
        this.gLE.a(i, i2, str, this);
    }

    public final int getType() {
        return 1564;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
