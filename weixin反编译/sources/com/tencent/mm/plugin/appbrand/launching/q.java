package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ak;
import com.tencent.mm.plugin.appbrand.appcache.ak.a;
import com.tencent.mm.plugin.appbrand.appcache.aq;
import com.tencent.mm.plugin.appbrand.appcache.b;
import com.tencent.mm.plugin.appbrand.appcache.d;
import com.tencent.mm.plugin.appbrand.appcache.h;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.plugin.appbrand.launching.k.c;
import com.tencent.mm.protocal.c.aiz;
import com.tencent.mm.protocal.c.aja;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Locale;

public final class q extends p {
    public final String appId;
    public final int fwH;
    public final String iHe;
    public final int jDw;
    public final boolean jDx;

    public q(String str, String str2, int i) {
        this(str, str2, i, true);
    }

    public q(String str, String str2, int i, boolean z) {
        super(new com.tencent.mm.plugin.appbrand.appcache.q(str, str2));
        this.fwH = 0;
        this.appId = str;
        this.iHe = str2;
        this.jDw = i;
        this.jDx = z;
    }

    public final String aiD() {
        return String.format(Locale.US, "pkg %s, targetVersion %d, pkgType %d", new Object[]{this.jDu.toString(), Integer.valueOf(this.jDw), Integer.valueOf(0)});
    }

    public final void prepare() {
        Pair r = ak.r(this.jDu.toString(), 0, this.jDw);
        if (r.second != null) {
            x.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "%s prepare ok", aiD());
            d((WxaPkgWrappingInfo) r.second);
        } else if (a.iIy.equals(r.first)) {
            x.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "%s getDownloadURL", aiD());
            final aiz aiz = new aiz();
            aiz.fGh = this.appId;
            aiz.vVm = this.jDw;
            aiz.wwU = 0;
            if (!bi.oN(this.iHe)) {
                aiz.wvh = this.iHe;
                aiz.wwU = 4;
            }
            aiz.wwT = e.Zz().a(this.jDu.toString(), 0, "versionMd5").field_versionMd5;
            if (j.ZR() && d.a.jy(0)) {
                WxaPkgWrappingInfo aF = f.aF(this.jDu.toString(), 1);
                if (aF != null) {
                    aiz.wwV = aF.iJb;
                }
            }
            new b(aiz).Kb().g(new com.tencent.mm.vending.c.a<Void, com.tencent.mm.ad.a.a<aja>>() {
                public final /* synthetic */ Object call(Object obj) {
                    com.tencent.mm.ad.a.a aVar = (com.tencent.mm.ad.a.a) obj;
                    k.b bVar = q.this.jDt;
                    if (bVar != null && (bVar instanceof c)) {
                        ((c) bVar).a(aVar);
                    }
                    if (aVar.errCode == 0 && aVar.errType == 0 && aVar.fKE != null) {
                        q qVar = q.this;
                        aiz aiz = aiz;
                        aja aja = (aja) aVar.fKE;
                        aq.a anonymousClass2 = new o() {
                            final String aiC() {
                                return q.this.aiD();
                            }

                            final void c(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
                                q.this.d(wxaPkgWrappingInfo);
                            }
                        };
                        x.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "%s downloadPkg, patch_url(%s), full_url(%s)", qVar.aiD(), aja.fzB, aja.url);
                        boolean b = (aiz.wwV <= 0 || bi.oN(aja.fzB)) ? aq.b(qVar.jDu.toString(), 0, qVar.jDw, aja.url, anonymousClass2) : h.a(qVar.jDu.toString(), aiz.wwV, qVar.jDw, aja.fzB, anonymousClass2);
                        if (!b) {
                            x.e("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "%s start downloadPkg failed", qVar.aiD());
                            qVar.d(null);
                        }
                    } else {
                        x.e("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "%s, getDownloadURL failed %d, %d", q.this.aiD(), Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
                        if (q.this.jDx) {
                            y.tF(y.getMMString(com.tencent.mm.plugin.appbrand.q.j.iDo, Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode)));
                        }
                        q.this.d(null);
                    }
                    return zLb;
                }
            });
        } else {
            x.e("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "%s, local check failed ret=%s", aiD(), r.first);
            d(null);
        }
    }
}
