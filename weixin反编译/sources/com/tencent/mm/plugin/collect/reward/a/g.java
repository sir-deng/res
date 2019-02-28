package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.mc;
import com.tencent.mm.protocal.c.md;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g extends a {
    private final String TAG = "MicroMsg.NetSceneQrRewardSetCode";
    private b gLB;
    private e gLE;
    public md lpk;

    public g(LinkedList<Integer> linkedList, String str, boolean z, boolean z2) {
        a aVar = new a();
        aVar.hnT = new mc();
        aVar.hnU = new md();
        aVar.hnS = 1562;
        aVar.uri = "/cgi-bin/mmpay-bin/setrewardqrcode";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        mc mcVar = (mc) this.gLB.hnQ.hnY;
        mcVar.wbc = linkedList;
        mcVar.desc = str;
        mcVar.wbB = z;
        mcVar.wbC = z2;
        x.i("MicroMsg.NetSceneQrRewardSetCode", "desc: %s, flag: %s, default: %s", str, Boolean.valueOf(z), Boolean.valueOf(z2));
    }

    public final int getType() {
        return 1562;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneQrRewardSetCode", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.lpk = (md) ((b) qVar).hnR.hnY;
        x.i("MicroMsg.NetSceneQrRewardSetCode", "retcode: %s, retmsg: %s", Integer.valueOf(this.lpk.lot), this.lpk.lou);
        if (!(this.lpb || this.lpk.lot == 0)) {
            this.lpc = true;
        }
        if (!this.lpb && !this.lpc) {
            com.tencent.mm.kernel.g.Dq().Db().a(w.a.USERINFO_WALLET_QR_REWARD_PHOTO_WIDTH_INT_SYNC, Integer.valueOf(this.lpk.wbf));
            com.tencent.mm.kernel.g.Dq().Db().a(w.a.USERINFO_WALLET_QR_REWARD_ICON_WIDTH_INT_SYNC, Integer.valueOf(this.lpk.wbb));
            com.tencent.mm.kernel.g.Dq().Db().a(w.a.USERINFO_WALLET_QR_REWARD_DESC_STRING_SYNC, this.lpk.desc);
            com.tencent.mm.kernel.g.Dq().Db().a(w.a.USERINFO_WALLET_QR_REWARD_LAST_PHOTO_URL_STRING_SYNC, this.lpk.pPK);
            List arrayList = new ArrayList();
            Iterator it = this.lpk.wbc.iterator();
            while (it.hasNext()) {
                arrayList.add(String.valueOf(((Integer) it.next()).intValue()));
            }
            com.tencent.mm.kernel.g.Dq().Db().a(w.a.USERINFO_WALLET_QR_REWARD_AMT_LIST_STRING_SYNC, bi.d(arrayList, ","));
            com.tencent.mm.plugin.report.service.g.pWK.a(724, 5, 1, false);
        } else if (this.lpb) {
            com.tencent.mm.plugin.report.service.g.pWK.a(724, 7, 1, false);
        } else {
            com.tencent.mm.plugin.report.service.g.pWK.a(724, 6, 1, false);
        }
        if (this.gLE != null) {
            this.gLE.a(i, i2, str, this);
        }
    }
}
