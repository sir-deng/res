package com.tencent.mm.plugin.mall.a;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.protocal.c.axd;
import com.tencent.mm.protocal.c.axe;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;

public final class c extends k implements com.tencent.mm.network.k {
    private b gLB;
    private e gLE;

    public c() {
        boolean booleanValue;
        a aVar = new a();
        aVar.hnT = new axd();
        aVar.hnU = new axe();
        aVar.uri = "/cgi-bin/mmpay-bin/payibggetoverseawallet";
        this.gLB = aVar.Kf();
        axd axd = (axd) this.gLB.hnQ.hnY;
        g.Dr();
        Object obj = g.Dq().Db().get(w.a.USERINFO_HAD_SHOW_WALLET_MULTI_WALLET_GUIDE_BOOLEAN, Boolean.valueOf(false));
        if (obj != null) {
            booleanValue = ((Boolean) obj).booleanValue();
        } else {
            booleanValue = false;
        }
        axd.wLa = booleanValue ? 1 : 0;
        axd.ael = com.tencent.mm.sdk.platformtools.w.cfV();
        axd.wLd = VERSION.RELEASE;
        axd.wLc = f.ag(null, d.vHl);
        axd.wLe = Build.MANUFACTURER;
        x.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "req IsShowTips %s language %s os_ver %s wxg_ver %s phone_type %s", Integer.valueOf(axd.wLa), axd.ael, axd.wLd, axd.wLc, axd.wLe);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "errCode " + i3 + ", errMsg " + str);
        if (i2 == 0 && i3 == 0) {
            axe axe = (axe) ((b) qVar).hnR.hnY;
            if (axe.wLh == null || axe.wLi == null) {
                x.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "onGYNetEnd other is null " + axe.oqv);
            } else {
                x.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "onGYNetEnd " + axe.oqv + " wallet_gray_area: " + axe.wLh.wpO.size() + " wallet_threepoint_area: " + axe.wLi.wpO.size());
            }
            g.Dr();
            g.Dq().Db().a(w.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(axe.oqv));
            o.bMi().a(axe.oqv, axe);
        }
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1577;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
