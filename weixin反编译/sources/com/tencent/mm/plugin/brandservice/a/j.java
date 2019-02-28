package com.tencent.mm.plugin.brandservice.a;

import com.tencent.mm.ac.h;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.bgj;
import com.tencent.mm.protocal.c.bgk;
import com.tencent.mm.protocal.c.bgl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class j extends k implements com.tencent.mm.network.k {
    private int fvo = 0;
    private b gLB;
    private e gLE;
    private String kKA;
    private int kKB;
    private bes kKC = new bes().bl(new byte[0]);
    public LinkedList<bgl> kKD;

    public j(String str) {
        this.kKA = str;
        this.kKB = 0;
    }

    public final int getType() {
        return 455;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        a aVar = new a();
        aVar.hnT = new bgj();
        aVar.hnU = new bgk();
        aVar.uri = "/cgi-bin/micromsg-bin/searchorrecommendbiz";
        aVar.hnS = 455;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        bgj bgj = (bgj) this.gLB.hnQ.hnY;
        bgj.wzM = n.oK(this.kKA);
        bgj.vKI = this.fvo;
        bgj.wSa = this.kKB;
        bgj.vOw = this.kKC;
        x.d("MicroMsg.BrandService.NetSceneSearchOrRecommendBiz", "doScene:" + this.kKA + "  :" + this.fvo + "  entryFlag:" + this.kKB);
        return a(eVar, this.gLB, this);
    }

    protected final int a(q qVar) {
        return b.hoz;
    }

    protected final int Bo() {
        return 50;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.BrandService.NetSceneSearchOrRecommendBiz", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        if (i2 == 0 && i3 == 0) {
            bgk bgk = (bgk) this.gLB.hnR.hnY;
            this.kKC = bgk.wRG;
            this.kKD = bgk.wSc;
            Iterator it = this.kKD.iterator();
            while (it.hasNext()) {
                bgl bgl = (bgl) it.next();
                h hVar = new h();
                hVar.username = n.a(bgl.wfM);
                hVar.hni = bgl.wbY;
                hVar.hnh = bgl.wbZ;
                hVar.fEo = -1;
                hVar.fWZ = 3;
                hVar.bC(true);
                com.tencent.mm.ac.n.JW().a(hVar);
            }
        } else {
            this.kKD = null;
        }
        this.gLE.a(i2, i3, str, this);
    }
}
