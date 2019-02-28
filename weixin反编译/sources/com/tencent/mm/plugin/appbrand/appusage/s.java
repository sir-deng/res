package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.ad.a;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.k;
import com.tencent.mm.ad.u;
import com.tencent.mm.protocal.c.bek;
import com.tencent.mm.protocal.c.brg;
import com.tencent.mm.protocal.c.brh;
import com.tencent.mm.sdk.platformtools.x;

public final class s extends a<brh> {
    private final brg iNo;
    private final b iNp;
    public volatile u.a iNq;
    private final String iub;

    protected final /* synthetic */ void a(int i, int i2, String str, bek bek, k kVar) {
        brh brh = (brh) bek;
        x.i("MicroMsg.AppBrand.CgiUpdateWxaUsageRecord", "onCgiBack, req [scene %d, background %b, versionType %d, recordType %d, op %d, username %s]resp [errType %d, errCode %d, errMsg %s, resp %s]", Integer.valueOf(this.iNo.scene), Integer.valueOf(this.iNo.wZu), Integer.valueOf(this.iNo.vVl), Integer.valueOf(this.iNo.wZv), Integer.valueOf(this.iNo.wZw), this.iNo.username, Integer.valueOf(i), Integer.valueOf(i2), str, brh);
        if (this.iNq != null) {
            this.iNq.a(i, i2, str, this.iNp, kVar);
        }
    }

    public s(int i, boolean z, int i2, int i3, int i4, String str, int i5, String str2) {
        this.iub = str2;
        b.a aVar = new b.a();
        com.tencent.mm.bp.a brg = new brg();
        if (i == 0) {
            i = 1000;
        }
        brg.scene = i;
        brg.wZu = z ? 1 : 0;
        brg.vVl = i2;
        brg.wZv = i3;
        brg.wZw = i4;
        brg.username = str;
        brg.aAk = i5;
        brg.wZx = str2;
        this.iNo = brg;
        aVar.hnT = brg;
        aVar.hnU = new brh();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/updatewxausagerecord";
        aVar.hnS = 1149;
        b Kf = aVar.Kf();
        this.iNp = Kf;
        this.gLB = Kf;
    }
}
