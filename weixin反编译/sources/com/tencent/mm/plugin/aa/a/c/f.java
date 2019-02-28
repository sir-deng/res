package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.ad.e;
import com.tencent.mm.plugin.aa.a.c;
import com.tencent.mm.plugin.aa.a.g;
import com.tencent.mm.plugin.aa.a.j;
import com.tencent.mm.protocal.c.q;
import com.tencent.mm.protocal.c.s;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.app.a;
import com.tencent.mm.vending.g.b;

public class f extends a {
    c ijV = new c();
    g ijW = new g();
    j ijX = new j();

    /* renamed from: com.tencent.mm.plugin.aa.a.c.f$1 */
    class AnonymousClass1 implements com.tencent.mm.vending.c.a<Void, com.tencent.mm.ad.a.a<q>> {
        final /* synthetic */ b ijI;

        AnonymousClass1(b bVar) {
            this.ijI = bVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.ad.a.a aVar = (com.tencent.mm.ad.a.a) obj;
            x.i("MicroMsg.PaylistAAInteractor", "errType: %s, errCode: %s, retCode: %s, retMsg: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode), Integer.valueOf(((q) aVar.fKE).lot), ((q) aVar.fKE).lou);
            this.ijI.resume();
            return zLb;
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.a.c.f$2 */
    class AnonymousClass2 implements com.tencent.mm.vending.c.a<Void, com.tencent.mm.ad.a.a<s>> {
        final /* synthetic */ b ijI;

        AnonymousClass2(b bVar) {
            this.ijI = bVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.ad.a.a aVar = (com.tencent.mm.ad.a.a) obj;
            x.i("MicroMsg.PaylistAAInteractor", "on urgeAAPay finish, errType: %s, errCode: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
            if (aVar.errType == 0 && aVar.errCode == 0) {
                s sVar = (s) aVar.fKE;
                x.i("MicroMsg.PaylistAAInteractor", "on urgeAAPay finish, retcode: %s, retmsg: %s", Integer.valueOf(sVar.lot), sVar.lou);
                if (sVar.lot == 0) {
                    x.i("MicroMsg.PaylistAAInteractor", "on urgeAAPay success");
                    com.tencent.mm.plugin.aa.a.ihO.un();
                    this.ijI.t(Boolean.valueOf(true));
                    com.tencent.mm.plugin.report.service.g.pWK.a(407, 24, 1, false);
                } else {
                    if (sVar.lot <= 0 || bi.oN(sVar.lou)) {
                        this.ijI.cm(Boolean.valueOf(false));
                    } else {
                        this.ijI.cm(sVar.lou);
                    }
                    com.tencent.mm.plugin.report.service.g.pWK.a(407, 26, 1, false);
                }
            } else {
                this.ijI.cm(Boolean.valueOf(false));
                com.tencent.mm.plugin.report.service.g.pWK.a(407, 25, 1, false);
            }
            return zLb;
        }
    }

    protected final void onCreate() {
        super.onCreate();
        e WL = this.ijV.WL();
        x.i("MicroMsg.AAGetPaylistDetailLogic", "init");
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Dp().gRu.a(1695, WL);
        WL = this.ijW.WR();
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Dp().gRu.a(1629, WL);
        this.ijX.WU().init();
    }

    protected final void onDestroy() {
        super.onDestroy();
        e WL = this.ijV.WL();
        x.i("MicroMsg.AAGetPaylistDetailLogic", "unInit");
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Dp().gRu.b(1695, WL);
        WL = this.ijW.WR();
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Dp().gRu.b(1629, WL);
        this.ijX.WU().WT();
    }
}
