package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.ad.n;
import com.tencent.mm.f.a.sv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import java.util.Date;

public final class u extends c<sv> implements e {
    private sv sVC;
    private String sVD;

    public u() {
        this.sVD = null;
        this.xmG = sv.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        long longValue;
        this.sVC = (sv) bVar;
        this.sVD = this.sVC.fLv.fLx;
        g.Dr();
        Object obj = g.Dq().Db().get(a.USERINFO_WALLET_BULLETIN_GET_TIME_LONG, Long.valueOf(0));
        long longValue2 = obj != null ? ((Long) obj).longValue() : 0;
        long time = new Date().getTime();
        g.Dr();
        obj = g.Dq().Db().get(a.USERINFO_WALLET_BULLETIN_UPDATE_INTERVAL_LONG, Long.valueOf(600000));
        if (obj != null) {
            longValue = ((Long) obj).longValue();
            if (longValue <= 0) {
                longValue = 600000;
            }
        } else {
            longValue = 600000;
        }
        if (time - longValue2 > longValue || bi.oN(this.sVD)) {
            x.i("MicroMsg.WalletGetBulletinEventListener", "data is out of date,do NetSceneGetBannerInfo for update");
            k dVar = new d();
            g.Dr();
            n nVar = g.Dp().gRu;
            nVar.a(385, (e) this);
            nVar.a(dVar, 0);
        } else if (bi.oN(this.sVD)) {
            x.e("MicroMsg.WalletGetBulletinEventListener", "mScene is null");
            this.sVC.frD.run();
            this.sVC = null;
        } else {
            x.i("MicroMsg.WalletGetBulletinEventListener", "get bulletin data from db");
            bMl();
        }
        return true;
    }

    private void bMl() {
        com.tencent.mm.plugin.wallet_core.d.d bMg = o.bMg();
        com.tencent.mm.sdk.e.c rVar = new r();
        rVar.field_bulletin_scene = this.sVD;
        if (bMg.b(rVar, new String[0])) {
            this.sVC.fLw.fLy = rVar.field_bulletin_scene;
            this.sVC.fLw.content = rVar.field_bulletin_content;
            this.sVC.fLw.url = rVar.field_bulletin_url;
        } else {
            x.i("MicroMsg.WalletGetBulletinEventListener", "not bulletin data ");
        }
        this.sVC.frD.run();
        this.sVC = null;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.WalletGetBulletinEventListener", "NetSceneGetBannerInfo resp,errType = " + i + ";errCode=" + i2);
        g.Dr();
        g.Dp().gRu.b(385, (e) this);
        g.Dr();
        g.Dq().Db().a(a.USERINFO_WALLET_BULLETIN_GET_TIME_LONG, Long.valueOf(new Date().getTime()));
        bMl();
    }
}
