package com.tencent.mm.plugin.location.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.location.ui.impl.f;
import com.tencent.mm.protocal.c.ael;
import com.tencent.mm.protocal.c.aem;
import com.tencent.mm.protocal.c.awg;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class h extends k implements com.tencent.mm.network.k {
    public int errCode;
    public int errType;
    public String foE;
    public int fvo;
    public final b gLB;
    private e gLE;
    private Runnable hPS;
    public String iVa;
    public boolean kRY = false;
    public List<f> list = new ArrayList();
    public byte[] nWt;
    public byte[] nWu = null;
    public String nWv = "";
    public int nWw;

    public h(byte[] bArr, double d, double d2, int i, int i2, double d3, double d4, String str, String str2) {
        a aVar = new a();
        aVar.hnT = new ael();
        aVar.hnU = new aem();
        aVar.hnU = new aem();
        aVar.uri = "/cgi-bin/micromsg-bin/getpoilist";
        aVar.hnS = 457;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        ael ael = (ael) this.gLB.hnQ.hnY;
        ael.wsT = bArr == null ? new bes() : new bes().bl(bArr);
        ael.wnX = str2;
        ael.vUG = d;
        ael.vUF = d2;
        ael.sfa = i;
        ael.vKI = i2;
        ael.wtE = d4;
        ael.wtD = d3;
        ael.wsV = 1;
        this.fvo = ael.vKI;
        this.nWv = str;
        this.nWt = bArr;
        x.i("MicroMsg.NetSceneGetPoiList", "lat %f lng %f scene %d opcode %d oriLat %f oriLng %f" + bArr, Double.valueOf(d), Double.valueOf(d2), Integer.valueOf(i), Integer.valueOf(i2), Double.valueOf(d4), Double.valueOf(d3));
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.NetSceneGetPoiList", "scene done");
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return 457;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetPoiList", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + "errMsg:" + str);
        this.errType = i2;
        this.errCode = i3;
        this.foE = str;
        aem aem = (aem) this.gLB.hnR.hnY;
        this.list.clear();
        x.d("MicroMsg.NetSceneGetPoiList", "url " + aem.wtc + " " + aem.wmc + " " + aem.nlE + " " + aem.vWw);
        x.d("MicroMsg.NetSceneGetPoiList", "autoInterval: %d", Integer.valueOf(aem.wtd));
        this.iVa = aem.vWw;
        this.nWw = aem.wtd;
        if (aem.wtG != null) {
            x.d("MicroMsg.NetSceneGetPoiList", "poi result %d ", Integer.valueOf(aem.wtG.size()));
            if (aem.wtG.size() > 0) {
                x.d("MicroMsg.NetSceneGetPoiList", "addr %s, province %s, street %s, city %s", ((awg) aem.wtG.get(0)).wKq, ((awg) aem.wtG.get(0)).hxf, ((awg) aem.wtG.get(0)).wfD, ((awg) aem.wtG.get(0)).hxg);
            }
            Iterator it = aem.wtG.iterator();
            while (it.hasNext()) {
                this.list.add(new f((awg) it.next(), this.iVa));
            }
        }
        if (aem.wsT != null) {
            this.nWu = n.a(aem.wsT);
        }
        this.kRY = aem.wtH == 1;
        this.gLE.a(i2, i3, str, this);
        if (this.hPS != null) {
            this.hPS.run();
        }
    }

    public final boolean isFirst() {
        return this.nWt == null;
    }
}
