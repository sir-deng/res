package com.tencent.mm.sandbox.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.c.i;
import com.tencent.mm.modelsimple.an;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sandbox.SubCoreSandBox;
import com.tencent.mm.pluginsdk.q.t;
import com.tencent.mm.protocal.c.ahi;
import com.tencent.mm.protocal.c.ahj;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;

public final class a extends k implements com.tencent.mm.network.k, t {
    public final b gLB;
    private e gLE;

    public a(int i) {
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new ahi();
        aVar.hnU = new ahj();
        aVar.uri = "/cgi-bin/micromsg-bin/getupdateinfo";
        this.gLB = aVar.Kf();
        ahi ahi = (ahi) this.gLB.hnQ.hnY;
        ahi.wvp = i;
        ahi.vKK = f.fei;
        if (10012 == r.ifN && r.ifO > 0) {
            ahi.vKK = r.ifO;
        }
        switch (i) {
            case 1:
                g.pWK.a(405, 3, 1, true);
                break;
            case 2:
                g.pWK.a(405, 4, 1, true);
                break;
            case 3:
                g.pWK.a(405, 5, 1, true);
                break;
            case 4:
                g.pWK.a(405, 6, 1, true);
                break;
        }
        x.i("MicroMsg.NetSceneGetUpdateInfo", "summerupdate dkchan NetSceneGetUpdateInfo updateType:%d channel:%d release:%d, stack[%s]", Integer.valueOf(ahi.wvp), Integer.valueOf(ahi.vKK), Integer.valueOf(f.fei), bi.chl());
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return 11;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetUpdateInfo", "summertoken GetUpdateInfo onGYNetEnd errType[%d], errCode[%d], errMsg[%s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            g.pWK.a(405, 7, 1, true);
        } else {
            g.pWK.a(405, 8, 1, true);
            if (i2 == 4) {
                g.pWK.a(405, 9, 1, true);
                if (i3 == -16) {
                    g.pWK.a(405, 10, 1, true);
                } else if (i3 == -17) {
                    g.pWK.a(405, 11, 1, true);
                } else if (i3 == -18) {
                    g.pWK.a(405, 12, 1, true);
                }
            }
        }
        this.gLE.a(i2, i3, str, this);
        String ceR = ceR();
        if (ceR != null) {
            i cj = i.cj(ceR);
            if (cj != null) {
                x.i("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchVersionCode[%d]", Integer.valueOf(cj.versionCode));
                as.CN().a(new an(ad.getPackageName(), r0), 0);
                g.pWK.a(405, 13, 1, true);
                return;
            }
            x.i("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchInfo is null patchXml[%s]", ceR);
            return;
        }
        x.w("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchXml is null!");
        g.pWK.a(405, 14, 1, true);
    }

    public final int ceP() {
        return ((ahj) this.gLB.hnR.hnY).wvs;
    }

    public final String ceQ() {
        return ((ahj) this.gLB.hnR.hnY).wvr;
    }

    public final int bYN() {
        return ((ahj) this.gLB.hnR.hnY).wvq;
    }

    public final String[] bYO() {
        ahj ahj = (ahj) this.gLB.hnR.hnY;
        String[] strArr = new String[ahj.wvv.size()];
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            strArr[i] = ((bet) ahj.wvv.get(i)).wRo;
        }
        return strArr;
    }

    public final String ceR() {
        x.d("MicroMsg.NetSceneGetUpdateInfo", "summertoken getPatchInfo[%s], stack[%s]", ((ahj) this.gLB.hnR.hnY).wvw, bi.chl());
        return ((ahj) this.gLB.hnR.hnY).wvw;
    }

    public final ahj bYP() {
        int i = 1;
        if (SubCoreSandBox.pYa) {
            ahj ahj = (ahj) this.gLB.hnR.hnY;
            ahj.wvx = 1;
            ahj.wvy = "http://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/android_exp__index";
            if (!SubCoreSandBox.pYb) {
                i = 0;
            }
            ahj.wvz = i;
        }
        return (ahj) this.gLB.hnR.hnY;
    }
}
