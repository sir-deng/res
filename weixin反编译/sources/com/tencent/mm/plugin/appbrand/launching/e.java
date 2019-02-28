package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.mm.ad.a;
import com.tencent.mm.ad.b;
import com.tencent.mm.cc.f;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.j.g;
import com.tencent.mm.plugin.appbrand.appcache.s;
import com.tencent.mm.plugin.appbrand.appcache.t;
import com.tencent.mm.protocal.c.aom;
import com.tencent.mm.protocal.c.aon;
import com.tencent.mm.protocal.c.bek;
import com.tencent.mm.protocal.c.ccc;
import com.tencent.mm.protocal.c.ccy;
import com.tencent.mm.protocal.c.cdc;
import com.tencent.mm.protocal.c.cds;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.x;

final class e extends a<aon> {
    final b gLB;
    final String iub;
    volatile u jDc;
    volatile boolean jDd;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final /* synthetic */ void a(int r11, int r12, java.lang.String r13, com.tencent.mm.protocal.c.bek r14, com.tencent.mm.ad.k r15) {
        /*
        r10 = this;
        r14 = (com.tencent.mm.protocal.c.aon) r14;
        if (r15 != 0) goto L_0x00c3;
    L_0x0004:
        r0 = 1;
        r1 = r0;
    L_0x0006:
        if (r14 != 0) goto L_0x00c7;
    L_0x0008:
        r0 = "NULL";
    L_0x000b:
        r2 = "MicroMsg.AppBrand.CgiLaunchWxaApp";
        r3 = "onCgiBack, errType %d, errCode %d, errMsg %s, req[appId %s, bg %B, sync %B, libVersion %d], resp[%s]";
        r4 = 8;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = java.lang.Integer.valueOf(r11);
        r4[r5] = r6;
        r5 = 1;
        r6 = java.lang.Integer.valueOf(r12);
        r4[r5] = r6;
        r5 = 2;
        r4[r5] = r13;
        r5 = 3;
        r6 = r10.getAppId();
        r4[r5] = r6;
        r5 = 4;
        r6 = r10.aiy();
        r6 = java.lang.Boolean.valueOf(r6);
        r4[r5] = r6;
        r5 = 5;
        r6 = r10.jDd;
        r6 = java.lang.Boolean.valueOf(r6);
        r4[r5] = r6;
        r5 = 6;
        r6 = r10.aiz();
        r6 = r6.wCb;
        r6 = r6.wDO;
        r6 = java.lang.Integer.valueOf(r6);
        r4[r5] = r6;
        r5 = 7;
        r4[r5] = r0;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
        if (r11 != 0) goto L_0x0238;
    L_0x0058:
        if (r12 != 0) goto L_0x0238;
    L_0x005a:
        if (r14 == 0) goto L_0x0238;
    L_0x005c:
        if (r1 == 0) goto L_0x01a9;
    L_0x005e:
        r0 = new com.tencent.mm.plugin.appbrand.launching.u;
        r0.<init>();
        r10.jDc = r0;
        r0 = r10.jDc;
        r1 = r10.getAppId();
        r0.field_appId = r1;
        r0 = r10.jDc;
        r0.a(r14);
    L_0x0072:
        r0 = r10.jDc;
        r1 = r10.jDd;
        r0.jDd = r1;
        r0 = r10.aiz();
        r0 = r0.wCb;
        r0 = r0.wDO;
        r1 = r14.wCj;
        com.tencent.mm.plugin.appbrand.appcache.ac.a(r0, r1);
        r0 = r14.wCg;
        if (r0 == 0) goto L_0x00c2;
    L_0x0089:
        r0 = r14.wCg;
        r0 = r0.wBX;
        if (r0 == 0) goto L_0x00ad;
    L_0x008f:
        r0 = com.tencent.mm.plugin.appbrand.app.e.Zx();
        r1 = r10.getAppId();
        r1 = com.tencent.mm.plugin.appbrand.config.q.rn(r1);
        r2 = r10.aix();
        r3 = r10.aiy();
        r4 = r10.YF();
        r5 = 1;
        r6 = r10.iub;
        r0.a(r1, r2, r3, r4, r5, r6);
    L_0x00ad:
        r0 = r10.jDd;
        if (r0 != 0) goto L_0x00c2;
    L_0x00b1:
        r0 = com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify.jDl;
        r1 = r10.getAppId();
        r2 = r10.aix();
        r3 = r10.iub;
        r4 = r10.jDc;
        r0.a(r1, r2, r3, r4);
    L_0x00c2:
        return;
    L_0x00c3:
        r0 = 0;
        r1 = r0;
        goto L_0x0006;
    L_0x00c7:
        r0 = r14.wCh;
        if (r0 != 0) goto L_0x00e8;
    L_0x00cb:
        r0 = "NULL_API_INFO";
    L_0x00ce:
        r2 = r14.wCg;
        if (r2 != 0) goto L_0x018b;
    L_0x00d2:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r0 = r2.append(r0);
        r2 = " || NULL_LAUNCH";
        r0 = r0.append(r2);
        r0 = r0.toString();
        goto L_0x000b;
    L_0x00e8:
        r2 = new java.lang.StringBuilder;
        r0 = "api_info~ fg:";
        r2.<init>(r0);
        r0 = r14.wCh;
        r0 = r0.wcZ;
        if (r0 != 0) goto L_0x017e;
    L_0x00f6:
        r0 = "NULL";
    L_0x00f9:
        r0 = r2.append(r0);
        r0 = r0.toString();
        r2 = r14.wCh;
        r2 = r2.wda;
        if (r2 == 0) goto L_0x0168;
    L_0x0107:
        r2 = r14.wCh;
        r2 = r2.wda;
        r2 = r2.size();
        if (r2 <= 0) goto L_0x0137;
    L_0x0111:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r0 = r2.append(r0);
        r2 = " | bg:";
        r2 = r0.append(r2);
        r0 = r14.wCh;
        r0 = r0.wda;
        r3 = 0;
        r0 = r0.get(r3);
        r0 = (com.tencent.mm.bp.b) r0;
        r0 = r0.oz;
        r0 = r0.length;
        r0 = r2.append(r0);
        r0 = r0.toString();
    L_0x0137:
        r2 = r14.wCh;
        r2 = r2.wda;
        r2 = r2.size();
        r3 = 1;
        if (r2 <= r3) goto L_0x0168;
    L_0x0142:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r0 = r2.append(r0);
        r2 = " | suspend:";
        r2 = r0.append(r2);
        r0 = r14.wCh;
        r0 = r0.wda;
        r3 = 1;
        r0 = r0.get(r3);
        r0 = (com.tencent.mm.bp.b) r0;
        r0 = r0.oz;
        r0 = r0.length;
        r0 = r2.append(r0);
        r0 = r0.toString();
    L_0x0168:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r0 = r2.append(r0);
        r2 = "~";
        r0 = r0.append(r2);
        r0 = r0.toString();
        goto L_0x00ce;
    L_0x017e:
        r0 = r14.wCh;
        r0 = r0.wcZ;
        r0 = r0.oz;
        r0 = r0.length;
        r0 = java.lang.Integer.valueOf(r0);
        goto L_0x00f9;
    L_0x018b:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r0 = r2.append(r0);
        r2 = " || launch ";
        r0 = r0.append(r2);
        r2 = r14.wCg;
        r2 = r2.vKQ;
        r0 = r0.append(r2);
        r0 = r0.toString();
        goto L_0x000b;
    L_0x01a9:
        r3 = com.tencent.mm.plugin.appbrand.app.e.Zt();
        r4 = r10.getAppId();
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r4);
        if (r0 != 0) goto L_0x01b9;
    L_0x01b7:
        if (r14 != 0) goto L_0x01be;
    L_0x01b9:
        r0 = 0;
    L_0x01ba:
        r10.jDc = r0;
        goto L_0x0072;
    L_0x01be:
        r5 = new com.tencent.mm.plugin.appbrand.launching.u;
        r5.<init>();
        r5.a(r14);
        r5.field_appId = r4;
        r1 = new com.tencent.mm.plugin.appbrand.launching.u;
        r1.<init>();
        r1.field_appId = r4;
        r0 = 1;
        r0 = new java.lang.String[r0];
        r2 = 0;
        r6 = "appId";
        r0[r2] = r6;
        r0 = r3.a(r1, r0);
        if (r0 != 0) goto L_0x0223;
    L_0x01de:
        r0 = 1;
        r2 = r0;
    L_0x01e0:
        if (r2 != 0) goto L_0x01e8;
    L_0x01e2:
        r0 = r1.equals(r5);
        if (r0 != 0) goto L_0x0226;
    L_0x01e8:
        r0 = 1;
    L_0x01e9:
        r6 = "MicroMsg.LaunchWxaAppCacheStorage";
        r7 = "flush resp, appId %s, apply %B, insert %B";
        r8 = 3;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r8[r9] = r4;
        r4 = 1;
        r9 = java.lang.Boolean.valueOf(r0);
        r8[r4] = r9;
        r4 = 2;
        r9 = java.lang.Boolean.valueOf(r2);
        r8[r4] = r9;
        com.tencent.mm.sdk.platformtools.x.i(r6, r7, r8);
        if (r0 == 0) goto L_0x020e;
    L_0x0208:
        if (r2 == 0) goto L_0x0228;
    L_0x020a:
        r4 = 0;
        r3.a(r5, r4);
    L_0x020e:
        if (r0 == 0) goto L_0x021f;
    L_0x0210:
        r0 = 1;
        r0 = new java.lang.String[r0];
        r4 = 0;
        r5 = "appId";
        r0[r4] = r5;
        r0 = r3.a(r1, r0);
        if (r0 != 0) goto L_0x0236;
    L_0x021f:
        if (r2 == 0) goto L_0x0236;
    L_0x0221:
        r0 = 0;
        goto L_0x01ba;
    L_0x0223:
        r0 = 0;
        r2 = r0;
        goto L_0x01e0;
    L_0x0226:
        r0 = 0;
        goto L_0x01e9;
    L_0x0228:
        r4 = 0;
        r6 = 1;
        r6 = new java.lang.String[r6];
        r7 = 0;
        r8 = "appId";
        r6[r7] = r8;
        r3.b(r5, r4, r6);
        goto L_0x020e;
    L_0x0236:
        r0 = r1;
        goto L_0x01ba;
    L_0x0238:
        r0 = r10.jDd;
        if (r0 == 0) goto L_0x00c2;
    L_0x023c:
        r0 = com.tencent.mm.plugin.appbrand.q.j.iDs;
        r1 = 1;
        r1 = new java.lang.Object[r1];
        r2 = 0;
        r3 = java.util.Locale.US;
        r4 = " (%d,%d)";
        r5 = 2;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r7 = java.lang.Integer.valueOf(r11);
        r5[r6] = r7;
        r6 = 1;
        r7 = java.lang.Integer.valueOf(r12);
        r5[r6] = r7;
        r3 = java.lang.String.format(r3, r4, r5);
        r1[r2] = r3;
        r0 = com.tencent.mm.plugin.appbrand.launching.y.getMMString(r0, r1);
        com.tencent.mm.plugin.appbrand.launching.y.tF(r0);
        goto L_0x00c2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.launching.e.a(int, int, java.lang.String, com.tencent.mm.protocal.c.bek, com.tencent.mm.ad.k):void");
    }

    e(String str, boolean z, ccc ccc, cds cds, cdc cdc, String str2, int i) {
        this.jDd = false;
        this.iub = str2;
        com.tencent.mm.bp.a aom = new aom();
        aom.nlV = str;
        aom.wBZ = ccc;
        aom.wuK = z ? 1 : 2;
        aom.wCc = cds;
        aom.wCd = cdc;
        ccy ccy = new ccy();
        ccy.wDO = i;
        if (i > 0) {
            t ZF = com.tencent.mm.plugin.appbrand.app.e.ZF();
            if (ZF != null) {
                c sVar = new s();
                sVar.field_key = "@LibraryAppId";
                sVar.field_version = i;
                if (ZF.b(sVar, "key", "version")) {
                    ccy.vND = (int) sVar.field_updateTime;
                    ccy.xiu = sVar.field_scene;
                }
            }
        }
        aom.wCb = ccy;
        try {
            if (q.gHN.gEp) {
                x.i("MicroMsg.AppBrand.CgiLaunchWxaApp", "DeviceInfo isLimit benchmarkLevel");
                aom.wCf = -2;
            } else {
                aom.wCf = g.Af().getInt("ClientBenchmarkLevel", 0);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AppBrand.CgiLaunchWxaApp", e, "read performanceLevel", new Object[0]);
        }
        b.a aVar = new b.a();
        aVar.hnS = 1122;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaattr/launchwxaapp";
        aVar.hnT = aom;
        aVar.hnU = new aon();
        b Kf = aVar.Kf();
        this.gLB = Kf;
        this.gLB = Kf;
    }

    e(String str, ccc ccc, String str2, int i) {
        this(str, false, ccc, null, null, str2, i);
    }

    private String getAppId() {
        return ((aom) this.gLB.hnQ.hnY).nlV;
    }

    private int aix() {
        return ((aom) this.gLB.hnQ.hnY).wBZ.wAn;
    }

    private boolean aiy() {
        return ((aom) this.gLB.hnQ.hnY).wBZ.wDM > 0;
    }

    private int YF() {
        return ((aom) this.gLB.hnQ.hnY).wBZ.sfa;
    }

    private aom aiz() {
        return (aom) this.gLB.hnQ.hnY;
    }

    final void aiA() {
        com.tencent.mm.plugin.appbrand.r.c.Dt().F(new Runnable() {
            public final void run() {
                e.this.jDd = false;
                e.this.Kb();
            }
        });
    }

    public final synchronized f<a.a<aon>> Kb() {
        f<a.a<aon>> c;
        final Pair ak = ((com.tencent.mm.plugin.appbrand.appcache.b.d.e) com.tencent.mm.plugin.appbrand.app.e.u(com.tencent.mm.plugin.appbrand.appcache.b.d.e.class)).ak(getAppId(), YF());
        int i;
        if (ak.first != null) {
            x.i("MicroMsg.AppBrand.CgiLaunchWxaApp", "before run, get issued data by appId(%s) scene(%d)", getAppId(), Integer.valueOf(YF()));
            i = com.tencent.mm.plugin.appbrand.appcache.b.c.a.iJQ;
            com.tencent.mm.plugin.appbrand.appcache.b.c.a.o(((Long) ak.second).longValue(), 106);
            c = com.tencent.mm.cc.g.c(new com.tencent.mm.vending.g.c.a<a.a<aon>>() {
                public final /* synthetic */ Object call() {
                    return a.a.a(0, 0, null, (bek) ak.first, null, e.this);
                }
            });
        } else {
            if (!this.jDd) {
                ak = ((com.tencent.mm.plugin.appbrand.appcache.b.d.b) com.tencent.mm.plugin.appbrand.app.e.u(com.tencent.mm.plugin.appbrand.appcache.b.d.b.class)).v(getAppId(), 2, YF());
                if (((Boolean) ak.first).booleanValue()) {
                    i = com.tencent.mm.plugin.appbrand.appcache.b.c.a.iJQ;
                    com.tencent.mm.plugin.appbrand.appcache.b.c.a.o((long) ((Integer) ak.second).intValue(), 168);
                    x.i("MicroMsg.AppBrand.CgiLaunchWxaApp", "async launch with appid(%s) scene(%d) blocked", getAppId(), Integer.valueOf(YF()));
                    c = com.tencent.mm.cc.g.c(new com.tencent.mm.vending.g.c.a<a.a<aon>>() {
                        public final /* synthetic */ Object call() {
                            return a.a.a(3, 99999999, "Async Launch Blocked", null, null, e.this);
                        }
                    });
                }
            }
            c = super.Kb();
        }
        return c;
    }
}
