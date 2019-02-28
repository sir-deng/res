package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.aa;
import com.tencent.mm.plugin.appbrand.appcache.al;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.i.d;
import com.tencent.mm.protocal.c.ccc;
import com.tencent.mm.protocal.c.cdc;
import com.tencent.mm.protocal.c.cds;
import com.tencent.mm.sdk.platformtools.bi;

final class ab extends x<u> {
    final String appId;
    final int fJh;
    final int fJn;
    final int iNi;
    final String iRi;
    final AppBrandLaunchReferrer iRl;
    final int jCV;
    final String jCW;
    final int jkI;

    public final /* synthetic */ Object call() {
        return aiH();
    }

    ab(String str, int i, int i2, int i3, String str2, AppBrandLaunchReferrer appBrandLaunchReferrer, String str3, int i4) {
        int i5 = 0;
        this.appId = str;
        this.iNi = i;
        this.fJn = i2;
        this.jCV = i3;
        this.iRi = str2;
        this.iRl = appBrandLaunchReferrer;
        this.jCW = str3;
        al a = e.Zz().a(str, i, "version");
        if (a != null) {
            i5 = a.field_version;
        }
        this.fJh = i5;
        if (i4 < 0) {
            i4 = aa.ZX();
        }
        this.jkI = i4;
    }

    public final u aiH() {
        int i = 0;
        u uVar = new u();
        uVar.field_appId = this.appId;
        t Zt = e.Zt();
        if (Zt == null) {
            return null;
        }
        boolean z;
        cdc cdc;
        cds cds;
        ccc ccc = new ccc();
        ccc.wAn = this.iNi;
        ccc.vTR = this.fJh;
        ccc.sfa = this.jCV;
        ccc.wDN = this.iRi;
        ccc.wDM = 0;
        ccc.wDL = this.fJn;
        if (1055 == this.jCV) {
            z = true;
        } else if (1037 == this.jCV) {
            z = true;
        } else {
            int[] iArr = AppBrandGlobalSystemConfig.aci().iQB;
            z = iArr != null && a.b(iArr, this.jCV);
        }
        if (!z) {
            if (Zt.a(uVar, "appId")) {
                if (uVar.field_jsapiInfo != null) {
                    i = 1;
                }
                if (!(i == 0 || uVar.field_launchAction == null || 1 != uVar.field_launchAction.vKQ)) {
                    new e(this.appId, ccc, this.jCW, this.jkI).aiA();
                    return uVar;
                }
            }
        }
        if (this.iRl == null || 1 != this.iRl.iRp) {
            cdc = null;
        } else {
            cdc = new cdc();
            cdc.wAh = this.iRl.appId;
            cdc.wAb = this.iRl.fqY;
        }
        if (this.iRl == null || 2 != this.iRl.iRp) {
            cds = null;
        } else {
            cds cds2 = new cds();
            cds2.nqc = this.iRl.appId;
            cds2.nlE = this.iRl.url;
            cds = cds2;
        }
        long Wy = bi.Wy();
        com.tencent.mm.ad.a eVar = new e(this.appId, true, ccc, cds, cdc, this.jCW, this.jkI);
        eVar.jDd = true;
        d.a(eVar);
        s.a(s.a.SYNC_LAUNCH, this.appId, this.fJh, this.iNi, this.jCV, bi.Wy() - Wy);
        return eVar.jDc;
    }

    final String getTag() {
        return "MicroMsg.AppBrand.PrepareStepCheckLaunchInfo";
    }
}
