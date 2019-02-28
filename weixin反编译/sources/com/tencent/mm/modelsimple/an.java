package com.tencent.mm.modelsimple;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.cdx;
import com.tencent.mm.protocal.c.cdy;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

public final class an extends k implements com.tencent.mm.network.k {
    private e gLE;
    private final b hOJ;
    private int retryCount = 3;

    public an(String str, int i) {
        a aVar = new a();
        aVar.hnT = new cdx();
        aVar.hnU = new cdy();
        aVar.uri = "/cgi-bin/micromsg-bin/yybgetpkgsig";
        aVar.hnS = 729;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.hOJ = aVar.Kf();
        cdx cdx = (cdx) this.hOJ.hnQ.hnY;
        cdx.lTZ = w.cfV();
        cdx.vQo = d.oXY.up(0);
        cdx.xjm = str;
        cdx.nkZ = i;
        x.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig Language[%s], PkgName[%s], versionCode[%d], stack[%s]", cdx.lTZ, str, Integer.valueOf(i), bi.chl());
    }

    public final int getType() {
        return 729;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.hOJ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        cdx cdx = (cdx) this.hOJ.hnQ.hnY;
        cdy cdy = (cdy) this.hOJ.hnR.hnY;
        x.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s], ret[%d], sig[%s]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(cdy.xjn), cdy.xjo);
        g gVar;
        Object[] objArr;
        if (i2 == 0 && i3 == 0) {
            if (cdy.xjn == 2 || cdy.xjn == 3) {
                this.retryCount--;
                if (this.retryCount <= 0) {
                    x.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken err and return with no try!");
                    g.pWK.a(322, 2, 1, false);
                    gVar = g.pWK;
                    objArr = new Object[2];
                    objArr[0] = Integer.valueOf(4002);
                    objArr[1] = String.format("%s,%d", new Object[]{cdx.xjm, Integer.valueOf(cdx.nkZ)});
                    gVar.h(11098, objArr);
                    this.gLE.a(3, -1, "", this);
                    return;
                }
                x.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken do scene again retryCount:%d", Integer.valueOf(this.retryCount));
                a(this.hok, this.gLE);
            } else if (cdy.xjn == 1) {
                MultiProcessSharedPreferences.getSharedPreferences(ad.getContext(), "yyb_pkg_sig_prefs", 4).edit().remove(cdx.xjm).commit();
                g.pWK.a(322, 5, 1, false);
                gVar = g.pWK;
                objArr = new Object[2];
                objArr[0] = Integer.valueOf(4005);
                objArr[1] = String.format("%s,%d", new Object[]{cdx.xjm, Integer.valueOf(cdx.nkZ)});
                gVar.h(11098, objArr);
                x.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret no sig[%s] and remove", cdy.xjo);
            } else if (cdy.xjn == 4) {
                x.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret no need try and revise");
                g.pWK.a(322, 4, 1, false);
                gVar = g.pWK;
                objArr = new Object[2];
                objArr[0] = Integer.valueOf(4004);
                objArr[1] = String.format("%s,%d", new Object[]{cdx.xjm, Integer.valueOf(cdx.nkZ)});
                gVar.h(11098, objArr);
            } else {
                x.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret sig[%s]", cdy.xjo);
                MultiProcessSharedPreferences.getSharedPreferences(ad.getContext(), "yyb_pkg_sig_prefs", 4).edit().putString(cdx.xjm, cdy.xjo).commit();
                g.pWK.a(322, 3, 1, false);
                gVar = g.pWK;
                objArr = new Object[2];
                objArr[0] = Integer.valueOf(4003);
                objArr[1] = String.format("%s,%d,%s", new Object[]{cdx.xjm, Integer.valueOf(cdx.nkZ), cdy.xjo});
                gVar.h(11098, objArr);
            }
            this.gLE.a(i2, i3, str, this);
            return;
        }
        x.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig err and return!");
        g.pWK.a(322, 1, 1, false);
        gVar = g.pWK;
        objArr = new Object[2];
        objArr[0] = Integer.valueOf(4001);
        objArr[1] = String.format("%s,%d,%d,%d", new Object[]{cdx.xjm, Integer.valueOf(cdx.nkZ), Integer.valueOf(i2), Integer.valueOf(i3)});
        gVar.h(11098, objArr);
        this.gLE.a(i2, i3, str, this);
    }
}
