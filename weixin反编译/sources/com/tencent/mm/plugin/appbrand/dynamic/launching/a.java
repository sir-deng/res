package com.tencent.mm.plugin.appbrand.dynamic.launching;

import android.util.Base64;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.i.d;
import com.tencent.mm.plugin.appbrand.widget.i;
import com.tencent.mm.plugin.appbrand.widget.j;
import com.tencent.mm.protocal.c.aop;
import com.tencent.mm.protocal.c.ccs;
import com.tencent.mm.protocal.c.cdt;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.Callable;

public final class a implements Callable<j> {
    final String appId;
    final int fJh;
    final int fwH;
    final int iXt;
    final String iXu;
    final int scene;

    public final /* synthetic */ Object call() {
        return adr();
    }

    public a(String str, int i, int i2, int i3, int i4, String str2) {
        this.appId = str;
        this.fwH = i;
        this.fJh = i2;
        this.scene = i3;
        this.iXt = i4;
        this.iXu = str2;
    }

    public final j adr() {
        j jVar = new j();
        jVar.field_appId = this.appId;
        i Zu = ((com.tencent.mm.plugin.appbrand.widget.a.a) g.h(com.tencent.mm.plugin.appbrand.widget.a.a.class)).Zu();
        if (Zu == null) {
            return null;
        }
        cdt cdt = new cdt();
        cdt.wAn = com.tencent.mm.plugin.appbrand.dynamic.k.a.ka(this.fwH);
        cdt.vTR = this.fJh;
        cdt.xjf = this.iXt;
        cdt.sfa = this.scene;
        cdt.xjg = 0;
        if (Zu.a(jVar, "appId", "pkgType", "widgetType")) {
            if ((jVar.field_jsApiInfo != null) && jVar.field_launchAction != null && 1 == jVar.field_launchAction.vKQ && jVar.field_versionInfo != null && jVar.field_versionInfo.vTR >= this.fJh) {
                com.tencent.mm.plugin.appbrand.dynamic.i.a.a.rX(this.appId);
                com.tencent.mm.by.a.post(new Runnable() {
                    public final void run() {
                        a.this.Kb();
                    }
                });
                return jVar;
            }
        }
        if (this.iXu != null && this.iXu.length() > 0) {
            try {
                aop aop = new aop();
                aop.aH(Base64.decode(this.iXu, 0));
                jVar = ((com.tencent.mm.plugin.appbrand.widget.a.a) g.h(com.tencent.mm.plugin.appbrand.widget.a.a.class)).Zu().a(this.appId, this.fwH, this.iXt, aop);
                if (aop.wCn != null) {
                    String ah = ((c) g.h(c.class)).Zf().ah(this.appId, this.fwH);
                    ccs ccs = new ccs();
                    ccs.xiq = ah;
                    ccs.vTR = aop.wCn.vTR;
                    if (this.fwH == 10102) {
                        ccs.xip = aop.wCn.xhN;
                        ((c) g.h(c.class)).Zf().a(this.appId, ccs, this.fwH);
                    } else if (this.fwH == 10002) {
                        ccs.xip = aop.wCn.xhM;
                        ((c) g.h(c.class)).Zf().a(this.appId, ccs, this.fwH);
                    }
                }
                return jVar;
            } catch (Exception e) {
                x.e("MicroMsg.AppBrand.PrepareStepCheckWidgetLaunchInfo", "preload launch data parse fail[%s]", this.iXu);
            }
        }
        com.tencent.mm.plugin.appbrand.dynamic.i.a.a.rW(this.appId);
        com.tencent.mm.plugin.appbrand.dynamic.i.a.a.rT(this.appId);
        com.tencent.mm.plugin.appbrand.dynamic.g.a aVar = new com.tencent.mm.plugin.appbrand.dynamic.g.a(this.appId, true, cdt);
        com.tencent.mm.ad.a.a c = d.c(aVar.gLB);
        aVar.a(c.errType, c.errCode, c.foE, (aop) c.fKE);
        com.tencent.mm.plugin.appbrand.dynamic.i.a.a.rU(this.appId);
        return aVar.iXM;
    }
}
