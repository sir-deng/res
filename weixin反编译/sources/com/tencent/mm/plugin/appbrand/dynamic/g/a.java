package com.tencent.mm.plugin.appbrand.dynamic.g;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.appbrand.widget.j;
import com.tencent.mm.protocal.c.aoo;
import com.tencent.mm.protocal.c.aop;
import com.tencent.mm.protocal.c.bek;
import com.tencent.mm.protocal.c.cdt;

public final class a extends com.tencent.mm.ad.a<aop> {
    private int fwH;
    public final b gLB;
    public j iXM;
    private int iXt;

    protected final /* bridge */ /* synthetic */ void a(int i, int i2, String str, bek bek, k kVar) {
        a(i, i2, str, (aop) bek);
    }

    public a(String str, boolean z, cdt cdt) {
        com.tencent.mm.bp.a aoo = new aoo();
        aoo.nlV = str;
        aoo.wCl = cdt;
        aoo.wuK = z ? 1 : 2;
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnS = 1181;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaattr/launchwxawidget";
        aVar.hnT = aoo;
        aVar.hnU = new aop();
        b Kf = aVar.Kf();
        this.gLB = Kf;
        this.gLB = Kf;
        this.iXt = cdt.xjf;
        this.fwH = com.tencent.mm.plugin.appbrand.dynamic.k.a.bD(this.iXt, cdt.wAn);
    }

    private String getAppId() {
        return ((aoo) this.gLB.hnQ.hnY).nlV;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r11, int r12, java.lang.String r13, com.tencent.mm.protocal.c.aop r14) {
        /*
        r10 = this;
        r9 = 3;
        r8 = 2;
        r7 = 1;
        r6 = 0;
        r0 = "MicroMsg.CgiLaunchWxaWidget";
        r1 = "onCgiBack, errType %d, errCode %d, errMsg %s, req appId %s";
        r2 = 4;
        r2 = new java.lang.Object[r2];
        r3 = java.lang.Integer.valueOf(r11);
        r2[r6] = r3;
        r3 = java.lang.Integer.valueOf(r12);
        r2[r7] = r3;
        r2[r8] = r13;
        r3 = r10.getAppId();
        r2[r9] = r3;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
        if (r11 != 0) goto L_0x00a3;
    L_0x0026:
        if (r12 != 0) goto L_0x00a3;
    L_0x0028:
        if (r14 == 0) goto L_0x00a3;
    L_0x002a:
        r1 = r10.getAppId();
        r0 = com.tencent.mm.plugin.appbrand.widget.a.a.class;
        r0 = com.tencent.mm.kernel.g.h(r0);
        r0 = (com.tencent.mm.plugin.appbrand.widget.a.a) r0;
        r0 = r0.Zu();
        r2 = r10.fwH;
        r3 = r10.iXt;
        r0 = r0.a(r1, r2, r3, r14);
        r10.iXM = r0;
        r0 = r14.wCn;
        if (r0 == 0) goto L_0x0084;
    L_0x0048:
        r0 = com.tencent.mm.plugin.appbrand.a.c.class;
        r0 = com.tencent.mm.kernel.g.h(r0);
        r0 = (com.tencent.mm.plugin.appbrand.a.c) r0;
        r0 = r0.Zf();
        r2 = r10.fwH;
        r0 = r0.ah(r1, r2);
        r2 = new com.tencent.mm.protocal.c.ccs;
        r2.<init>();
        r2.xiq = r0;
        r0 = r14.wCn;
        r0 = r0.vTR;
        r2.vTR = r0;
        r0 = r10.fwH;
        r3 = 10102; // 0x2776 float:1.4156E-41 double:4.991E-320;
        if (r0 != r3) goto L_0x0085;
    L_0x006d:
        r0 = r14.wCn;
        r0 = r0.xhN;
        r2.xip = r0;
        r0 = com.tencent.mm.plugin.appbrand.a.c.class;
        r0 = com.tencent.mm.kernel.g.h(r0);
        r0 = (com.tencent.mm.plugin.appbrand.a.c) r0;
        r0 = r0.Zf();
        r3 = r10.fwH;
        r0.a(r1, r2, r3);
    L_0x0084:
        return;
    L_0x0085:
        r0 = r10.fwH;
        r3 = 10002; // 0x2712 float:1.4016E-41 double:4.9416E-320;
        if (r0 != r3) goto L_0x0084;
    L_0x008b:
        r0 = r14.wCn;
        r0 = r0.xhM;
        r2.xip = r0;
        r0 = com.tencent.mm.plugin.appbrand.a.c.class;
        r0 = com.tencent.mm.kernel.g.h(r0);
        r0 = (com.tencent.mm.plugin.appbrand.a.c) r0;
        r0 = r0.Zf();
        r3 = r10.fwH;
        r0.a(r1, r2, r3);
        goto L_0x0084;
    L_0x00a3:
        r0 = com.tencent.mm.plugin.appbrand.widget.a.a.class;
        r0 = com.tencent.mm.kernel.g.h(r0);
        r0 = (com.tencent.mm.plugin.appbrand.widget.a.a) r0;
        r1 = r0.Zu();
        r2 = r10.getAppId();
        r3 = r10.fwH;
        r4 = r10.iXt;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
        if (r0 != 0) goto L_0x00e8;
    L_0x00bd:
        r0 = new com.tencent.mm.plugin.appbrand.widget.j;
        r0.<init>();
        r5 = r2.hashCode();
        r0.field_appIdHash = r5;
        r0.field_appId = r2;
        r0.field_pkgType = r3;
        r0.field_widgetType = r4;
        r2 = new java.lang.String[r9];
        r3 = "appId";
        r2[r6] = r3;
        r3 = "pkgType";
        r2[r7] = r3;
        r3 = "widgetType";
        r2[r8] = r3;
        r1 = r1.a(r0, r2);
        if (r1 == 0) goto L_0x00e8;
    L_0x00e5:
        r10.iXM = r0;
        goto L_0x0084;
    L_0x00e8:
        r0 = 0;
        goto L_0x00e5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.dynamic.g.a.a(int, int, java.lang.String, com.tencent.mm.protocal.c.aop):void");
    }
}
