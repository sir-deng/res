package com.tencent.mm.plugin.appbrand.config;

import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.config.r.b;
import com.tencent.mm.plugin.appbrand.n.c;
import com.tencent.mm.plugin.appbrand.n.c.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class o implements c {

    /* renamed from: com.tencent.mm.plugin.appbrand.config.o$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ String gKE;
        final /* synthetic */ a iSj = null;
        final /* synthetic */ ah iSl;

        AnonymousClass2(String str, a aVar, ah ahVar) {
            this.gKE = str;
            this.iSl = ahVar;
        }

        public final void run() {
            if (r.rq(this.gKE)) {
                r.a(this.gKE, false, new b<WxaAttributes>() {
                    public final /* synthetic */ void d(int i, Object obj) {
                        WxaAttributes wxaAttributes = (WxaAttributes) obj;
                        if (AnonymousClass2.this.iSj != null) {
                            AnonymousClass2.this.iSj.b(wxaAttributes);
                        }
                    }
                });
            } else if (this.iSj != null) {
                this.iSj.b(o.this.rf(this.gKE));
            }
            Looper.myQueue().addIdleHandler(new IdleHandler() {
                public final boolean queueIdle() {
                    AnonymousClass2.this.iSl.oFY.quit();
                    return false;
                }
            });
        }
    }

    public final WxaAttributes rf(String str) {
        return e.Zs().f(str, new String[0]);
    }

    public final void a(String str, final a aVar) {
        r.a(str, false, new b<WxaAttributes>() {
            public final /* synthetic */ void d(int i, Object obj) {
                WxaAttributes wxaAttributes = (WxaAttributes) obj;
                if (aVar != null) {
                    aVar.b(wxaAttributes);
                }
            }
        });
    }

    public final void rg(String str) {
        if (!bi.oN(str)) {
            ah ahVar = new ah();
            new ag(ahVar.oFY.getLooper()).post(new AnonymousClass2(str, null, ahVar));
        }
    }

    public final void ab(List<String> list) {
        if (!bi.cC(list)) {
            x.i("MicroMsg.AppBrand.WxaAttrExportService", "batchSync list %s", bi.d(list, ", "));
            r.a(list, k.a.DEFAULT);
        }
    }
}
