package com.tencent.mm.plugin.appbrand.appcache.b.a;

import com.tencent.mm.plugin.appbrand.appcache.aq;
import com.tencent.mm.plugin.appbrand.appcache.b.d.c;
import com.tencent.mm.plugin.appbrand.appcache.e;
import com.tencent.mm.plugin.appbrand.appcache.f;
import com.tencent.mm.plugin.appbrand.appcache.q;
import com.tencent.mm.pluginsdk.i.a.d.k;
import com.tencent.mm.pluginsdk.i.a.d.l;
import com.tencent.mm.protocal.c.aiz;
import com.tencent.mm.protocal.c.aja;
import com.tencent.mm.protocal.c.awl;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;

public final class a implements com.tencent.mm.vending.c.a<Boolean, c> {

    static class a implements com.tencent.mm.vending.c.a<Boolean, com.tencent.mm.vending.j.c<aiz, aja>> {
        a() {
        }

        public final /* synthetic */ Object call(Object obj) {
            return a((com.tencent.mm.vending.j.c) obj);
        }

        private Boolean a(com.tencent.mm.vending.j.c<aiz, aja> cVar) {
            q qVar;
            aiz aiz = (aiz) cVar.get(0);
            aja aja = (aja) cVar.get(1);
            if (aiz.type == 0) {
                qVar = new q(aiz.fGh);
            } else if (aiz.type == 4) {
                qVar = new q(aiz.fGh, aiz.wvh);
            } else {
                throw new IllegalArgumentException(String.format("not support request.type %d", new Object[]{Integer.valueOf(aiz.type)}));
            }
            final b cAI = g.cAI();
            cAI.cAH();
            com.tencent.mm.plugin.appbrand.appcache.a.b.a anonymousClass1 = new com.tencent.mm.plugin.appbrand.appcache.a.b.a<l>() {
                public final /* synthetic */ void a(String str, com.tencent.mm.plugin.appbrand.appcache.a.b.a.a aVar, Object obj) {
                    b bVar = cAI;
                    Object[] objArr = new Object[1];
                    objArr[0] = Boolean.valueOf(aVar == com.tencent.mm.plugin.appbrand.appcache.a.b.a.a.OK);
                    bVar.t(objArr);
                    x.i("MicroMsg.AppBrand.Predownload.ActionGetEncryptPkg.PlainActionDownloadPkg", "%s onPkgUpdateResult, ret %s", str, aVar.name());
                }
            };
            x.i("MicroMsg.AppBrand.Predownload.ActionGetEncryptPkg.PlainActionDownloadPkg", "%s downloadPkg, patch_url(%s), full_url(%s)", qVar.toString(), aja.fzB, aja.url);
            k fVar = new f(qVar.toString(), aiz.wwW.wKA, aiz.vVm, aja.url);
            e eVar = e.iGj;
            aq aaA = aq.aaA();
            if (aaA != null) {
                x.i("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "startDownload, addRequest(%s) ret = %d", fVar.toShortString(), Integer.valueOf(aaA.iIY.b(fVar)));
                switch (aaA.iIY.b(fVar)) {
                    case 4:
                        anonymousClass1.a(fVar.appId, com.tencent.mm.plugin.appbrand.appcache.a.b.a.a.ENV_ERR, null);
                        break;
                    default:
                        eVar.iGk.n(fVar.vmK, anonymousClass1);
                        break;
                }
            }
            x.e("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "startDownload, null updater");
            anonymousClass1.a(fVar.appId, com.tencent.mm.plugin.appbrand.appcache.a.b.a.a.ENV_ERR, null);
            return Boolean.FALSE;
        }
    }

    public final /* synthetic */ Object call(Object obj) {
        c cVar = (c) obj;
        String str = cVar.field_appId;
        int i = cVar.field_version;
        String str2 = cVar.field_pkgMd5;
        int i2 = cVar.field_type;
        q qVar = new q(str, "");
        final boolean z = cVar.field_retriedCount > 0;
        final int i3 = cVar.field_reportId;
        final b cAI = g.cAI();
        cAI.cAH();
        aiz aiz = new aiz();
        aiz.fGh = str;
        aiz.vVm = i;
        aiz.wwU = 0;
        aiz.wwT = str2;
        if (bi.oN("")) {
            aiz.wwU = 0;
        } else {
            aiz.wvh = "";
            aiz.wwU = 4;
        }
        aiz.wwW = new awl();
        aiz.wwW.wKz = 0;
        aiz.wwW.wKA = 1;
        int i4 = z ? 51 : 46;
        int i5 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.iJQ;
        com.tencent.mm.plugin.appbrand.appcache.b.c.a.o((long) i3, (long) i4);
        new com.tencent.mm.plugin.appbrand.appcache.b(aiz).Kb().j(new com.tencent.mm.vending.c.a<com.tencent.mm.vending.j.c<aiz, aja>, com.tencent.mm.ad.a.a<aja>>() {
            public final /* synthetic */ Object call(Object obj) {
                com.tencent.mm.ad.a.a aVar = (com.tencent.mm.ad.a.a) obj;
                if (com.tencent.mm.plugin.appbrand.i.a.b(aVar)) {
                    com.tencent.mm.ad.b bVar = (com.tencent.mm.ad.b) aVar.frW.hoq;
                    return com.tencent.mm.vending.j.a.v((aiz) bVar.hnQ.hnY, (aja) bVar.hnR.hnY);
                }
                cAI.t(Boolean.valueOf(false));
                g.cAI().cm(Boolean.valueOf(false));
                int i = z ? 50 : 49;
                int i2 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.iJQ;
                com.tencent.mm.plugin.appbrand.appcache.b.c.a.o((long) i3, (long) i);
                return null;
            }
        }).f(new a()).f(new com.tencent.mm.vending.c.a<Void, Boolean>() {
            public final /* synthetic */ Object call(Object obj) {
                int i = ((Boolean) obj).booleanValue() ? z ? 52 : 47 : z ? 53 : 48;
                int i2 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.iJQ;
                com.tencent.mm.plugin.appbrand.appcache.b.c.a.o((long) i3, (long) i);
                cAI.t(r5);
                return zLb;
            }
        });
        return Boolean.TRUE;
    }
}
