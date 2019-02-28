package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.appcache.a.b;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.ap;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.pluginsdk.i.a.d.l;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Set;

public enum e implements b<f, l> {
    ;
    
    public final g<String, a<l>> iGk;

    private e(String str) {
        this.iGk = new g();
    }

    public final void a(f fVar, l lVar) {
        a.a aVar;
        if (lVar.status != 2) {
            x.e("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "onDownloadResult %s", lVar);
            if (!(lVar.vox instanceof com.tencent.mm.pluginsdk.i.a.c.a)) {
                switch (lVar.httpStatusCode) {
                    case ap.CTRL_INDEX /*403*/:
                    case TencentLocation.ERROR_UNKNOWN /*404*/:
                        aVar = a.a.SEVER_FILE_NOT_FOUND;
                        break;
                    default:
                        aVar = a.a.FAILED;
                        break;
                }
            }
            aVar = a.a.DISK_FULL;
        } else {
            a.a aVar2;
            x Zg = ((c) com.tencent.mm.kernel.g.h(c.class)).Zg();
            if (Zg == null) {
                x.e("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "onDownloadResult complete, null storage");
                aVar2 = a.a.ENV_ERR;
            } else {
                com.tencent.mm.sdk.e.c n = Zg.n(fVar.appId, fVar.iGm, fVar.version);
                if (n == null) {
                    x.e("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "onDownloadResult complete, null record with %s", fVar.toShortString());
                    aVar2 = a.a.ENV_ERR;
                } else {
                    n.field_pkgPath = fVar.getFilePath();
                    x.i("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "onDownloadResult complete, integrityOk %b, with %s", Boolean.valueOf(x.a(n)), fVar.toShortString());
                    if (x.a(n)) {
                        Zg.c(n, new String[0]);
                        aVar2 = a.a.OK;
                    } else {
                        aVar2 = a.a.PKG_INTEGRITY_FAILED;
                    }
                }
            }
            aVar = aVar2;
        }
        Set<a> bi = this.iGk.bi(fVar.vmK);
        if (bi != null) {
            for (a a : bi) {
                a.a(fVar.appId, aVar, lVar);
            }
        }
    }
}
