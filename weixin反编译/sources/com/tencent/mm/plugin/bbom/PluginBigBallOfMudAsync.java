package com.tencent.mm.plugin.bbom;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.bbom.a.a;
import com.tencent.mm.plugin.fav.a.m;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.plugin.webview.ui.tools.widget.b;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.d;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.pluginsdk.ui.applet.o;
import com.tencent.mm.pluginsdk.ui.applet.r;
import com.tencent.mm.pluginsdk.ui.d.c;
import com.tencent.mm.pluginsdk.ui.d.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.x.n;
import com.tencent.mm.y.af;
import com.tencent.mm.y.ag;
import java.util.ArrayList;
import java.util.List;

public class PluginBigBallOfMudAsync extends f implements a {
    public String toString() {
        return "plugin-big-ball-of-mud-async";
    }

    public void installed() {
        alias(a.class);
    }

    public void dependency() {
        dependsOn(PluginBigBallOfMud.class);
        dependsOn(com.tencent.mm.plugin.notification.b.a.class);
    }

    public void configure(g gVar) {
        if (gVar.DZ() && ((h) gVar).mProfileCompat != null) {
            ((com.tencent.mm.plugin.notification.b.a) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.notification.b.a.class)).setNotification(((WorkerProfile) ((h) gVar).mProfileCompat).getNotification());
        }
        r.a.vvh = new r() {
            public final i a(p pVar, String str, String str2, String str3, String str4, o.a aVar) {
                return e.a(pVar, str, str2, str3, null, true, str4, aVar);
            }
        };
        n.a.a(new n() {
            public final int a(com.tencent.mm.x.g.a aVar, String str, String str2, String str3, String str4, byte[] bArr) {
                return l.a(aVar, str, str2, str3, str4, bArr);
            }
        });
        c.a.vBa = new c() {
            public final void a(Context context, List<String> list, OnDismissListener onDismissListener) {
                if (!list.isEmpty() && context != null) {
                    new com.tencent.mm.ui.tools.l(context).a(null, new com.tencent.mm.pluginsdk.ui.d.k.AnonymousClass3(list), new com.tencent.mm.pluginsdk.ui.d.k.AnonymousClass4(context), onDismissListener);
                }
            }

            public final void a(Context context, String str, OnDismissListener onDismissListener, Bundle bundle) {
                k.a(context, str, onDismissListener, bundle);
            }
        };
        com.tencent.mm.plugin.webview.ui.tools.widget.c.a.tQy = new com.tencent.mm.plugin.webview.ui.tools.widget.c() {
            public final MMWebView co(Context context) {
                return MMWebViewWithJsApi.a.dT(context);
            }
        };
        com.tencent.mm.plugin.webview.ui.tools.widget.a.a.tQx = new com.tencent.mm.plugin.webview.ui.tools.widget.a() {
            public final com.tencent.xweb.p a(MMWebView mMWebView, b bVar) {
                return new com.tencent.mm.plugin.webview.ui.tools.widget.f(mMWebView, false, bVar);
            }
        };
        com.tencent.mm.kernel.g.a(q.class, new com.tencent.mm.pluginsdk.model.g());
        com.tencent.mm.kernel.g.a(m.class, new d());
        if (((h) gVar).mProfileCompat != null && gVar.DZ()) {
            WorkerProfile workerProfile = (WorkerProfile) ((h) gVar).mProfileCompat;
            com.tencent.mm.pluginsdk.n nVar = workerProfile.fgN;
            com.tencent.mm.pluginsdk.m mVar = workerProfile.fgO;
            com.tencent.mm.bl.c.vGy = nVar;
            com.tencent.mm.bl.c.vGz = mVar;
            new com.tencent.mm.plugin.h.e(workerProfile).before(this).after(com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class));
        }
        if (gVar.DZ()) {
            ((com.tencent.mm.plugin.messenger.foundation.a.n) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class)).setIDataTransferFactoryDelegate(new ag() {
                public final List<af> getDataTransferList() {
                    List<af> arrayList = new ArrayList();
                    arrayList.add(new com.tencent.mm.ah.d());
                    arrayList.add(new com.tencent.mm.ah.f());
                    arrayList.add(new com.tencent.mm.ah.e());
                    arrayList.add(new com.tencent.mm.ah.a());
                    arrayList.add(new com.tencent.mm.ah.c());
                    arrayList.add(new com.tencent.mm.ah.g());
                    arrayList.add(new com.tencent.mm.ah.b());
                    return arrayList;
                }
            });
        }
    }

    public void execute(g gVar) {
        if (((h) gVar).mProfileCompat != null && gVar.DZ()) {
            x.i("MicroMsg.PluginBigBallOfMudAsync", "before WorkerProfile oncreate.");
            ((h) gVar).mProfileCompat.onCreate();
        }
        if (gVar.DZ()) {
            ((com.tencent.mm.plugin.welab.a.a.d) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.welab.a.a.d.class)).a("labs1de6f3", new com.tencent.mm.plugin.welab.b.b());
            ((com.tencent.mm.plugin.welab.a.a.d) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.welab.a.a.d.class)).a(new com.tencent.mm.plugin.welab.d.a());
            ((com.tencent.mm.plugin.welab.a.a.d) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.welab.a.a.d.class)).a("labs_browse", new com.tencent.mm.plugin.welab.b.a());
        }
    }
}
