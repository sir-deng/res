package com.tencent.mm.plugin.shake.c.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.protocal.c.bix;
import com.tencent.mm.protocal.c.biy;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;
    e qun;

    public c(float f, float f2, int i, String str) {
        a aVar = new a();
        aVar.hnT = new bix();
        aVar.hnU = new biy();
        aVar.uri = "/cgi-bin/mmbiz-bin/card/shakecard";
        this.gLB = aVar.Kf();
        bix bix = (bix) this.gLB.hnQ.hnY;
        bix.fAo = f2;
        bix.fBX = f;
        bix.scene = i;
        bix.wSV = str;
    }

    public final int getType() {
        return 1250;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneShakeCard", "onGYNetEnd, getType = 1250" + " errType = " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            biy biy = (biy) this.gLB.hnR.hnY;
            if (biy != null) {
                this.qun = new e();
                this.qun.kRj = biy.kRj;
                this.qun.kPy = biy.kPy;
                this.qun.fHQ = biy.fHQ;
                this.qun.title = biy.title;
                this.qun.kPB = biy.kPB;
                this.qun.kPC = biy.kPC;
                this.qun.kQL = biy.kQL;
                this.qun.kPA = biy.kPA;
                this.qun.hdx = biy.hdx;
                this.qun.quo = biy.quo;
                this.qun.qur = biy.qur;
                this.qun.qus = biy.qus;
                this.qun.qut = biy.qut;
                this.qun.quu = biy.quu;
                this.qun.quv = biy.quv;
                this.qun.ceA = biy.ceA;
                this.qun.quw = biy.quw;
                this.qun.qux = biy.qux;
                m.bss().quq = this.qun.quv;
            } else {
                this.qun = new e();
                this.qun.kRj = 3;
                this.qun.quv = m.bss().quq;
            }
        } else {
            this.qun = new e();
            this.qun.kRj = 3;
            this.qun.quv = m.bss().quq;
        }
        this.gLE.a(i2, i3, str, this);
    }
}
