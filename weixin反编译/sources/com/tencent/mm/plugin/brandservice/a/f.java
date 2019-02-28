package com.tencent.mm.plugin.brandservice.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ah;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.xw;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.Iterator;
import java.util.LinkedList;

public final class f extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;
    LinkedList<String> kKu;

    public f() {
        a aVar = new a();
        aVar.hnT = new xv();
        aVar.hnU = new xw();
        aVar.uri = "/cgi-bin/micromsg-bin/getapplist";
        this.gLB = aVar.Kf();
        this.kKu = new LinkedList();
        xv xvVar = (xv) this.gLB.hnQ.hnY;
        as.Hm();
        Object obj = c.Db().get(196610, null);
        String str = "MicroMsg.BrandService.BrandServiceApplication";
        String str2 = "get config, key[%d], value[%s]";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(196610);
        objArr[1] = obj == null ? "null" : obj.toString();
        x.i(str, str2, objArr);
        xvVar.wpk = bi.a((Integer) obj, 0);
        x.i("MicroMsg.BrandService.NetSceneGetAppList", "info: request hash code %d", Integer.valueOf(xvVar.wpk));
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.w("MicroMsg.BrandService.NetSceneGetAppList", "on scene end code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            xw xwVar = (xw) this.gLB.hnR.hnY;
            x.i("MicroMsg.BrandService.NetSceneGetAppList", "ok, hash code is %d, count is %d", Integer.valueOf(xwVar.wpk), Integer.valueOf(xwVar.kyA));
            x.i("MicroMsg.BrandService.NetSceneGetAppList", "result list is %s", xwVar.kyB.toString());
            com.tencent.mm.plugin.brandservice.a.f(196610, Integer.valueOf(xwVar.wpk));
            Iterator it = xwVar.kyB.iterator();
            while (it.hasNext()) {
                this.kKu.add(((ah) it.next()).kyG);
            }
        }
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 387;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        x.i("MicroMsg.BrandService.NetSceneGetAppList", "do scene");
        return a(eVar, this.gLB, this);
    }
}
