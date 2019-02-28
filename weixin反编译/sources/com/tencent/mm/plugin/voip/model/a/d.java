package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.bvv;
import com.tencent.mm.protocal.c.bvw;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends n<bvv, bvw> {
    public d(int i, long j, int i2, int i3, int i4, int i5, int i6, byte[] bArr, int i7) {
        a aVar = new a();
        aVar.hnT = new bvv();
        aVar.hnU = new bvw();
        aVar.uri = "/cgi-bin/micromsg-bin/voipDoubleLinkSwitch";
        aVar.hnS = az.CTRL_INDEX;
        aVar.hnV = az.CTRL_INDEX;
        this.gLB = aVar.Kf();
        bvv bvv = (bvv) this.gLB.hnQ.hnY;
        bvv.wil = i;
        bvv.wim = j;
        bvv.wNd = i2;
        bvv.xdj = i3;
        bvv.xdk = i4;
        bvv.xdl = i5;
        bvv.xdm = i6;
        bvv.xdn = 1;
        bvv.vQW = new bes().O(bArr, i7);
    }

    public final int getType() {
        return az.CTRL_INDEX;
    }

    public final void dT(int i, int i2) {
        if (i == 0 && i2 == 0) {
            if (((bvw) bIx()) != null) {
                x.i("MicroMsg.Voip.DoubleLinkSwitch", "roomId:%d, roomKey:%s, member:%d", Integer.valueOf(((bvw) bIx()).wil), Long.valueOf(((bvw) bIx()).wim), Integer.valueOf(((bvw) bIx()).wNd));
                return;
            }
            return;
        }
        x.i("MicroMsg.Voip.DoubleLinkSwitch", "double link switch error");
    }

    public final e bIt() {
        return new e() {
            public final void a(int i, int i2, String str, k kVar) {
                com.tencent.mm.plugin.voip.b.a.eA("MicroMsg.Voip.DoubleLinkSwitch", "double link switch response:" + i + " errCode:" + i2 + " status:" + d.this.sqC.mStatus);
                if (i2 != 0) {
                    com.tencent.mm.plugin.voip.b.a.ez("MicroMsg.Voip.DoubleLinkSwitch", " double link switch  response with error code:" + i2);
                    return;
                }
                bvw bvw = (bvw) d.this.bIx();
                d.this.sqC.spW = bvw.wIA;
                if (d.this.sqC.spW != 0) {
                    if (d.this.sqC.sqj.doubleLinkSwitch(bvw.xdo) == 0) {
                        v2protocal v2protocal;
                        if (1 == bvw.xdo) {
                            v2protocal = d.this.sqC.sqj;
                            v2protocal.sve++;
                        } else if (2 == bvw.xdo) {
                            v2protocal = d.this.sqC.sqj;
                            v2protocal.svf++;
                        }
                    }
                    com.tencent.mm.plugin.voip.b.a.eA("MicroMsg.Voip.DoubleLinkSwitch", "zhengxue[DOUBLELINK]room " + bvw.wil + " member " + bvw.wNd + " key " + bvw.wim + "report flag " + bvw.wIA + "switch to link type " + bvw.xdo + "doubleLinkSwitchReportStatus " + d.this.sqC.spW + "mDoubleLinkSwitchSucToDirectCnt" + d.this.sqC.sqj.sve + "mDoubleLinkSwitchSucToRelayCnt" + d.this.sqC.sqj.svf);
                }
            }
        };
    }
}
