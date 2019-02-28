package com.tencent.mm.modelappbrand;

import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.f.a.hx;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.aj.a.b;
import com.tencent.mm.protocal.c.bza;
import com.tencent.mm.protocal.c.bzb;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public final class n extends b implements k {
    private e gQm;
    private com.tencent.mm.ad.b hln;
    private bzb hlq;

    public n(String str, int i, int i2) {
        this.iUY = str;
        this.itU = i;
        this.tqo = i2;
        if (bi.oN(str)) {
            x.e("MicroMsg.NetSceneWeAppSuggest", "keyword is unavailable");
            return;
        }
        x.i("MicroMsg.NetSceneWeAppSuggest", "Constructors: query = %s", str);
        a aVar = new a();
        aVar.hnS = 1173;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/weappsearchsuggestion";
        aVar.hnT = new bza();
        aVar.hnU = new bzb();
        this.hln = aVar.Kf();
        bza bza = (bza) this.hln.hnQ.hnY;
        bza.fEe = str;
        com.tencent.mm.sdk.b.b hxVar = new hx();
        com.tencent.mm.sdk.b.a.xmy.m(hxVar);
        bza.xfY = hxVar.fzj.fzk;
        as.Hm();
        Object obj = c.Db().get(w.a.USERINFO_WXA_SEARCH_INPUT_HINT_CONTENT_ID_STRING_SYNC, null);
        if (obj != null && (obj instanceof String)) {
            bza.xgj = (String) obj;
        }
        bza.xgc = b.hlh;
        bza.xgd = b.hli;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneWeAppSuggest", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.hlq = (bzb) this.hln.hnR.hnY;
            if (this.hlq != null) {
                x.v("MicroMsg.NetSceneWeAppSuggest", "return data\n%s", this.hlq.vUV);
            }
            this.gQm.a(i2, i3, str, this);
            return;
        }
        this.gQm.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1173;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gQm = eVar2;
        return a(eVar, this.hln, this);
    }

    public final String Ji() {
        return this.hlq != null ? this.hlq.vUV : "";
    }
}
