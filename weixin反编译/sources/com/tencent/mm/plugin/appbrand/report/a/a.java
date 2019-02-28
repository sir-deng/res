package com.tencent.mm.plugin.appbrand.report.a;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class a implements d {
    private final e iuk;
    public boolean jII = false;
    public Intent jMX;
    public boolean jMY = false;
    g jMZ = null;
    private i jNa = null;
    public n jNb = null;
    public volatile e jNc = null;
    private final String mAppId;

    public a(e eVar) {
        this.mAppId = eVar.mAppId;
        this.iuk = eVar;
        acj();
    }

    public final void acj() {
        if (!bi.oN(this.mAppId)) {
            h e = h.e(this.iuk);
            if (e != null) {
                String str = e.iub;
                AppBrandLaunchReferrer YU = e.YU();
                String str2 = "";
                if (1 == YU.iRp || 3 == YU.iRp) {
                    str2 = YU.appId;
                } else if (2 == YU.iRp) {
                    str2 = YU.url;
                }
                this.jNc = new c(str2);
                this.jMZ = g.a(this.iuk, str, this.jNc);
                LinkedList linkedList = new LinkedList();
                linkedList.push(bi.oM(str2));
                this.jNb = n.a(this.iuk, str, linkedList);
                this.jNa = i.b(this.iuk, str, this.jNc);
                return;
            }
        }
        x.e("MicroMsg.AppBrandPageContainerReporter", "resetSession with dummy model, stack %s", bi.i(new Throwable()));
        this.jNc = e.jNt;
        this.jNa = i.akI();
        this.jMZ = g.akH();
        this.jNb = n.akK();
    }

    public final void a(final p pVar, final p pVar2, aa aaVar) {
        p pVar3;
        if (aa.AUTO_RE_LAUNCH == aaVar) {
            acj();
        }
        Object obj = (aa.AUTO_RE_LAUNCH == aaVar || pVar2 == null || bi.oN(pVar2.afe()) || pVar2 == pVar) ? 1 : null;
        e eVar = this.jNc;
        if (obj != null) {
            pVar3 = null;
        } else {
            pVar3 = pVar2;
        }
        eVar.a(pVar, pVar3, aaVar);
        if (obj == null) {
            pVar2.jJG.r(new Runnable() {
                public final void run() {
                    a.this.a(pVar, pVar2);
                }
            });
        } else {
            a(pVar, null);
        }
    }

    final void a(p pVar, p pVar2) {
        if (pVar2 != null) {
            g gVar = this.jMZ;
            pVar.afe();
            gVar.i(pVar2);
            gVar.xd();
            n nVar = this.jNb;
            String afe = pVar.afe();
            nVar.jNN = (String) nVar.jOG.peekFirst();
            nVar.jNO = 2;
            nVar.jNP = afe;
            nVar.jOG.push(pVar2.getURL());
            nVar.jOF = pVar2.getURL();
            nVar.k(pVar2);
        }
        this.jNa.j(pVar);
    }

    public final void d(final p pVar) {
        this.jII = true;
        this.jNc.d(pVar);
        pVar.jJG.r(new Runnable() {
            public final void run() {
                g gVar = a.this.jMZ;
                p pVar = pVar;
                Activity ch = j.ch(pVar.mContext);
                if (ch != null && ch.isFinishing()) {
                    gVar.jNK = true;
                }
                gVar.i(pVar);
                gVar.xd();
                n nVar = a.this.jNb;
                p pVar2 = pVar;
                nVar.jNN = (String) nVar.jOG.peekFirst();
                nVar.jNP = null;
                switch (com.tencent.mm.plugin.appbrand.report.a.n.AnonymousClass2.iKC[c.px(nVar.appId).ordinal()]) {
                    case 1:
                        nVar.jNO = 3;
                        break;
                    case 2:
                        nVar.jNO = 6;
                        break;
                    case 3:
                        break;
                    default:
                        Intent intent = nVar.iuk.isX.jIP.jMX;
                        if (intent == null) {
                            nVar.jNO = 7;
                            break;
                        }
                        String str;
                        if (intent.getComponent() == null) {
                            str = "";
                            x.e("MicroMsg.AppBrand.Report.kv_14992", "onBackground, intent %s, get null cmp name", intent);
                        } else {
                            str = intent.getComponent().getClassName();
                        }
                        nVar.jNO = 8;
                        nVar.jNP = bi.aD(intent.getStringExtra("appbrand_report_key_target_activity"), str);
                        str = nVar.jNP;
                        nVar.jOG.pollFirst();
                        nVar.jOG.push(bi.oM(str));
                        break;
                }
                Activity ch2 = j.ch(pVar2.mContext);
                if (ch2 != null && ch2.isFinishing()) {
                    nVar.jNK = true;
                }
                nVar.k(pVar2);
            }
        });
    }

    public final void e(p pVar) {
        this.jMX = null;
        if (this.jMY) {
            this.jMY = false;
            return;
        }
        this.jNc.e(pVar);
        this.jNa.j(pVar);
    }

    public final void h(long j, int i) {
        AppBrandSysConfig pk = com.tencent.mm.plugin.appbrand.a.pk(this.mAppId);
        int i2 = pk == null ? 0 : pk.iRU.iJb;
        g.pWK.h(13543, this.mAppId, Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i));
    }
}
