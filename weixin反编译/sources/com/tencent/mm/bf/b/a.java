package com.tencent.mm.bf.b;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenWeRunSetting;
import com.tencent.mm.protocal.c.bdw;
import com.tencent.mm.protocal.c.bdx;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class a extends k implements com.tencent.mm.network.k {
    private b gLB;
    private e gLE;

    public a(int i, LinkedList<bet> linkedList, bet bet, bet bet2) {
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new bdw();
        aVar.hnU = new bdx();
        aVar.uri = "/cgi-bin/micromsg-bin/reportvoiceresult";
        aVar.hnS = JsApiOpenWeRunSetting.CTRL_INDEX;
        this.gLB = aVar.Kf();
        bdw bdw = (bdw) this.gLB.hnQ.hnY;
        bdw.wQy = i;
        bdw.wQz = linkedList;
        bdw.wQA = bet;
        bdw.wQB = bet2;
    }

    public final int getType() {
        return JsApiOpenWeRunSetting.CTRL_INDEX;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneNewVoiceInputReport", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.gLE.a(i2, i3, str, this);
    }
}
