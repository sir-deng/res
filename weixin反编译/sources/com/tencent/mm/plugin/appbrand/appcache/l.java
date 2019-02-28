package com.tencent.mm.plugin.appbrand.appcache;

import android.util.Pair;
import com.tencent.mm.plugin.appbrand.a.a;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.a.b;
import com.tencent.mm.plugin.appbrand.task.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public enum l implements a {
    ;
    
    private int iGS;
    private String iGT;

    private l(String str) {
        this.iGS = -1;
        this.iGT = null;
    }

    final void A(int i, String str) {
        this.iGS = i;
        this.iGT = str;
    }

    public final void cp(boolean z) {
        Pair l = ak.l(z, true);
        if (l.second == null && l.first == ak.a.iIy) {
            al a = e.Zz().a("@LibraryAppId", z ? 0 : 999, "downloadURL", "version");
            if (a != null && !bi.oN(a.field_downloadURL)) {
                int i;
                if (z) {
                    i = a.field_version;
                } else {
                    i = 0;
                }
                aq.a anonymousClass1 = new aq.a() {
                    public final /* synthetic */ void a(String str, b.a.a aVar, Object obj) {
                        if (b.a.a.OK == aVar) {
                            d.lN(2);
                        }
                    }
                };
                if (z) {
                    if (this.iGS > 0 && !bi.oN(this.iGT)) {
                        x.i("MicroMsg.AppBrand.PkgDownloadService", "[incremental] lib can be patch, abtest open %b", Boolean.valueOf(j.ZS()));
                        if (j.ZS()) {
                            if (ak.r("@LibraryAppId", 0, this.iGS).first == ak.a.iIu) {
                                x.i("MicroMsg.AppBrand.PkgDownloadService", "[incremental] start incremental lib download");
                                h.a("@LibraryAppId", this.iGS, a.field_version, this.iGT, anonymousClass1);
                                return;
                            }
                            x.e("MicroMsg.AppBrand.PkgDownloadService", "[incremental] OldLibPkg[%d] or PatchUrl[%s] Invalid", Integer.valueOf(this.iGS), this.iGT);
                        }
                    }
                    aq.a(a.field_downloadURL, a.field_version, anonymousClass1);
                    return;
                }
                aq.a(a.field_downloadURL, anonymousClass1);
            }
        }
    }
}
