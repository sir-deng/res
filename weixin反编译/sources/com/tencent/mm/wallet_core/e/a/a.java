package com.tencent.mm.wallet_core.e.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.network.e;
import com.tencent.mm.protocal.c.axx;
import com.tencent.mm.protocal.c.axy;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h;
import com.tencent.mm.wallet_core.c.m;
import com.tencent.mm.y.q;
import com.tenpay.android.wechat.TenpayUtil;
import java.net.URLEncoder;

public abstract class a extends h {
    public abstract int bLx();

    public final int bLf() {
        return bLx();
    }

    public final void F(boolean z, boolean z2) {
        b bVar = this.gLB;
        if (bVar == null) {
            com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
            aVar.hnT = new axx();
            aVar.hnU = new axy();
            aVar.uri = "/cgi-bin/mmpay-bin/payu";
            aVar.hnS = 1518;
            aVar.hnV = 0;
            aVar.hnW = 0;
            bVar = aVar.Kf();
            bVar.hoh = true;
        }
        b bVar2 = bVar;
        axx axx = (axx) bVar2.hnQ.hnY;
        if (z) {
            axx.wyF = bLx();
        }
        if (z2) {
            axx.wyG = 1;
        }
        this.gLB = bVar2;
    }

    public final int getType() {
        return 1518;
    }

    public final String Nu(String str) {
        return TenpayUtil.signWith3Des(str);
    }

    public final void a(b bVar, bes bes) {
        ((axx) bVar.hnQ.hnY).wyH = bes;
    }

    public final void b(b bVar, bes bes) {
        ((axx) bVar.hnQ.hnY).wLK = bes;
    }

    public final m d(b bVar) {
        axy axy = (axy) bVar.hnR.hnY;
        m mVar = new m();
        mVar.wyL = axy.wyL;
        mVar.wyK = axy.wyK;
        mVar.wyJ = axy.wyJ;
        mVar.wyI = axy.wyI;
        mVar.lUd = axy.wLM;
        mVar.zQJ = axy.wLL;
        return mVar;
    }

    public int a(e eVar, com.tencent.mm.ad.e eVar2) {
        this.gLE = eVar2;
        if (q.Gl()) {
            return a(eVar, this.gLB, this);
        }
        x.e("MicroMsg.NetScenePayUBase", "hy: serious error: not payupay");
        eVar2.a(1000, -100868, "Pay Method Err", this);
        return 1;
    }

    public final void b(StringBuilder stringBuilder, String str) {
        stringBuilder.append(URLEncoder.encode(str));
    }
}
