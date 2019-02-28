package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bfj;
import com.tencent.mm.protocal.c.bfk;
import java.util.LinkedList;

public final class u extends k implements com.tencent.mm.network.k {
    public final b gLB;
    private e gQm;

    public u(int i, String str, String str2, String str3, LinkedList<String> linkedList) {
        a aVar = new a();
        aVar.hnT = new bfj();
        aVar.hnU = new bfk();
        aVar.uri = "/cgi-bin/mmbiz-bin/sdk_oauth_authorize_confirm ";
        this.gLB = aVar.Kf();
        bfj bfj = (bfj) this.gLB.hnQ.hnY;
        bfj.wIR = i;
        bfj.fGh = str;
        bfj.wIS = linkedList;
        bfj.state = str2;
        bfj.wRB = str3;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.gQm.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1346;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gQm = eVar2;
        return a(eVar, this.gLB, this);
    }
}
