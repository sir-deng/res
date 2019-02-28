package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ll;
import com.tencent.mm.protocal.c.lm;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b extends a {
    private final String TAG = "MicroMsg.NetSceneQrRewardGetCode";
    private com.tencent.mm.ad.b gLB;
    private e gLE;
    public lm lpe;
    public boolean lpf;

    public b(boolean z) {
        a aVar = new a();
        aVar.hnT = new ll();
        aVar.hnU = new lm();
        aVar.hnS = 1323;
        aVar.uri = "/cgi-bin/mmpay-bin/getrewardqrcode";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        ((ll) this.gLB.hnQ.hnY).waY = z;
        this.lpf = z;
    }

    public final int getType() {
        return 1323;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    protected final boolean azy() {
        return false;
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneQrRewardGetCode", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.lpe = (lm) ((com.tencent.mm.ad.b) qVar).hnR.hnY;
        x.i("MicroMsg.NetSceneQrRewardGetCode", "retcode: %s, retmsg: %s", Integer.valueOf(this.lpe.lot), this.lpe.lou);
        if (!(this.lpb || this.lpe.lot == 0)) {
            this.lpc = true;
        }
        if (!this.lpb && !this.lpc) {
            g.Dq().Db().a(w.a.USERINFO_WALLET_QR_REWARD_PHOTO_WIDTH_INT_SYNC, Integer.valueOf(this.lpe.wbf));
            g.Dq().Db().a(w.a.USERINFO_WALLET_QR_REWARD_ICON_WIDTH_INT_SYNC, Integer.valueOf(this.lpe.wbb));
            g.Dq().Db().a(w.a.USERINFO_WALLET_QR_REWARD_DESC_STRING_SYNC, this.lpe.desc);
            g.Dq().Db().a(w.a.USERINFO_WALLET_QR_REWARD_WORD_STRING_SYNC, this.lpe.kMY);
            g.Dq().Db().a(w.a.USERINFO_WALLET_QR_REWARD_MAX_AMT_INT_SYNC, Integer.valueOf(this.lpe.wbe));
            g.Dq().Db().a(w.a.USERINFO_WALLET_QR_REWARD_BOTTOM_STR_STRING_SYNC, this.lpe.kRl);
            g.Dq().Db().a(w.a.USERINFO_WALLET_QR_REWARD_BOTTOM_URL_STRING_SYNC, this.lpe.wbd);
            g.Dq().Db().a(w.a.USERINFO_WALLET_QR_REWARD_LAST_PHOTO_URL_STRING_SYNC, this.lpe.pPK);
            List arrayList = new ArrayList();
            Iterator it = this.lpe.wbc.iterator();
            while (it.hasNext()) {
                arrayList.add(String.valueOf(((Integer) it.next()).intValue()));
            }
            g.Dq().Db().a(w.a.USERINFO_WALLET_QR_REWARD_AMT_LIST_STRING_SYNC, bi.d(arrayList, ","));
            com.tencent.mm.plugin.report.service.g.pWK.a(724, 2, 1, false);
        } else if (this.lpb) {
            com.tencent.mm.plugin.report.service.g.pWK.a(724, 4, 1, false);
        } else {
            com.tencent.mm.plugin.report.service.g.pWK.a(724, 3, 1, false);
        }
        if (this.gLE != null) {
            this.gLE.a(i, i2, str, this);
        }
    }
}
