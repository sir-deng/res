package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aub;
import com.tencent.mm.protocal.c.auc;
import java.util.LinkedList;

public final class s extends k implements com.tencent.mm.network.k {
    public final b gLB;
    private e gQm;
    public Object tag;

    public s(String str, int i, LinkedList<String> linkedList) {
        a aVar = new a();
        aVar.hnT = new aub();
        aVar.hnU = new auc();
        aVar.uri = "/cgi-bin/mmbiz-bin/oauth_authorize_confirm";
        this.gLB = aVar.Kf();
        aub aub = (aub) this.gLB.hnQ.hnY;
        aub.wIQ = str;
        aub.wIR = i;
        aub.wIS = linkedList;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.gQm.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1373;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gQm = eVar2;
        return a(eVar, this.gLB, this);
    }
}
