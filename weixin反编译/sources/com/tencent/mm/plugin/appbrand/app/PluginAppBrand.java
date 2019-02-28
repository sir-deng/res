package com.tencent.mm.plugin.appbrand.app;

import android.support.annotation.Keep;
import com.tencent.mm.bx.h;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.c.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.appcache.l;
import com.tencent.mm.plugin.appbrand.appcache.r;
import com.tencent.mm.plugin.appbrand.appusage.t;
import com.tencent.mm.plugin.appbrand.appusage.u;
import com.tencent.mm.plugin.appbrand.appusage.w;
import com.tencent.mm.plugin.appbrand.config.o;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.launching.precondition.j;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.af;
import com.tencent.mm.y.ag;
import com.tencent.mm.y.p;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

@Keep
public final class PluginAppBrand extends f implements c, b, ag {
    public static final String TAG = "MicroMsg.PluginAppBrand";

    private static final class a extends p implements com.tencent.mm.kernel.a.b.b {
        a() {
            super(e.class);
        }

        public final void onAccountInitialized(e.c cVar) {
            super.onAccountInitialized(cVar);
            com.tencent.mm.plugin.appbrand.dynamic.widget.c.initialize();
            ((com.tencent.mm.plugin.messenger.a.e) g.h(com.tencent.mm.plugin.messenger.a.e.class)).a("link_view_wxapp", new com.tencent.mm.plugin.appbrand.h.b());
            ((com.tencent.mm.plugin.messenger.a.e) g.h(com.tencent.mm.plugin.messenger.a.e.class)).a("link_view_wxapp", new com.tencent.mm.plugin.appbrand.h.a());
            g.a(com.tencent.mm.plugin.appbrand.a.a.class, new d(l.iGR));
            g.a(u.class, new d((com.tencent.mm.kernel.c.a) e.u(com.tencent.mm.plugin.appbrand.appusage.g.class)));
            g.a(com.tencent.mm.plugin.appbrand.widget.recentview.d.class, new d(new com.tencent.mm.plugin.appbrand.widget.d()));
            com.tencent.mm.plugin.appbrand.l.b akm = com.tencent.mm.plugin.appbrand.l.b.akm();
            ((n) g.k(n.class)).getSysCmdMsgExtension().a("Proj8Tags", akm.jMx);
            ((n) g.k(n.class)).getSysCmdMsgExtension().a("Proj8MiniAPPNotice", akm.jMy);
            com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b.init(cVar.gSl);
            ((n) g.k(n.class)).getSysCmdMsgExtension().a("WeAppSyncCommand", com.tencent.mm.plugin.appbrand.appcache.b.c.iJs);
        }

        public final void parallelsDependency() {
            com.tencent.mm.kernel.a.b.a.a(this, c.class).aJ(g.k(m.class));
            com.tencent.mm.kernel.a.b.a.a(this, c.class).aJ(g.k(b.class));
        }

        public final void onAccountRelease() {
            g.j(u.class);
            g.j(com.tencent.mm.plugin.appbrand.widget.recentview.d.class);
            super.onAccountRelease();
            ((com.tencent.mm.plugin.messenger.a.e) g.h(com.tencent.mm.plugin.messenger.a.e.class)).EU("link_view_wxapp");
            ((com.tencent.mm.plugin.messenger.a.e) g.h(com.tencent.mm.plugin.messenger.a.e.class)).EU("link_view_wxapp");
            com.tencent.mm.plugin.appbrand.l.b akm = com.tencent.mm.plugin.appbrand.l.b.akm();
            ((n) g.k(n.class)).getSysCmdMsgExtension().b("Proj8Tags", akm.jMx);
            ((n) g.k(n.class)).getSysCmdMsgExtension().b("Proj8MiniAPPNotice", akm.jMy);
            com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b.release();
            ((n) g.k(n.class)).getSysCmdMsgExtension().b("WeAppSyncCommand", com.tencent.mm.plugin.appbrand.appcache.b.c.iJs);
        }
    }

    static {
        k.b("appbrandcommon", PluginAppBrand.class.getClassLoader());
    }

    public final List<af> getDataTransferList() {
        List linkedList = new LinkedList();
        linkedList.add(new af() {
            public final void transfer(int i) {
                if (gO(i)) {
                    try {
                        x.d("MicroMsg.AppBrandNewContactFixVersionStateTransfer", "doFix()");
                        com.tencent.mm.plugin.appbrand.app.e Zo = com.tencent.mm.plugin.appbrand.app.e.Zo();
                        if (Zo != null) {
                            h Zp = Zo.Zp();
                            com.tencent.mm.plugin.appbrand.app.e.Zs();
                            Zp.fD("WxaAttributesTable", String.format(Locale.US, "update %s set %s='' where %s is null or %s=''", new Object[]{"WxaAttributesTable", "syncVersion", "versionInfo", "versionInfo"}));
                        }
                    } catch (Exception e) {
                        x.e("MicroMsg.AppBrandNewContactFixVersionStateTransfer", "doFix e = %s", e);
                    }
                }
            }

            public final boolean gO(int i) {
                return i >= 637863936 && i <= 637863988;
            }

            public final String getTag() {
                return "MicroMsg.AppBrandNewContactFixVersionStateTransfer";
            }
        });
        linkedList.add(new t());
        return linkedList;
    }

    public final void onAccountInitialized(e.c cVar) {
    }

    public final void onAccountRelease() {
    }

    final e getCore() {
        return (e) p.s(e.class);
    }

    public final void installed() {
        alias(b.class);
    }

    public final void dependency() {
        dependsOn(com.tencent.mm.plugin.comm.a.a.class);
        dependsOn(com.tencent.mm.plugin.appbrand.compat.a.e.class);
    }

    public final void configure(com.tencent.mm.kernel.b.g gVar) {
    }

    public final void execute(com.tencent.mm.kernel.b.g gVar) {
        x.d(TAG, "current process name = %s, isMainThread %b", ((com.tencent.mm.kernel.b.h) g.Dn().CU()).gQd, Boolean.valueOf(ah.isMainThread()));
        g.a(com.tencent.mm.plugin.appbrand.n.d.class, new d(new com.tencent.mm.plugin.appbrand.launching.af()));
        g.a(com.tencent.mm.modelappbrand.e.class, new d(new com.tencent.mm.plugin.appbrand.dynamic.a.c()));
        g.a(com.tencent.mm.plugin.appbrand.n.e.class, new d(new com.tencent.mm.plugin.appbrand.launching.a.f()));
        g.a(com.tencent.mm.plugin.appbrand.appstorage.a.a.class, (com.tencent.mm.kernel.c.a) gVar.DZ() ? com.tencent.mm.plugin.appbrand.appstorage.n.b.iLM : com.tencent.mm.plugin.appbrand.appstorage.n.a.iLK);
        com.tencent.mm.plugin.appbrand.game.b.c.abp();
        if (gVar.DZ()) {
            com.tencent.mm.plugin.ae.c.qyU.a(new com.tencent.mm.plugin.appbrand.t());
            g.a(a.class, new d(new a()));
            g.a(com.tencent.mm.modelappbrand.g.class, new d(new com.tencent.mm.plugin.appbrand.share.a.a()));
            g.a(com.tencent.mm.plugin.appbrand.ui.banner.e.class, new d(new com.tencent.mm.plugin.appbrand.ui.banner.a()));
            g.a(com.tencent.mm.plugin.appbrand.n.a.class, new d(new d()));
            g.a(com.tencent.mm.plugin.appbrand.n.c.class, new d(new o()));
            g.a(com.tencent.mm.plugin.appbrand.n.f.class, new d(new c()));
            g.a(com.tencent.mm.plugin.appbrand.a.c.class, new d(new f()));
            g.a(com.tencent.mm.plugin.appbrand.widget.a.a.class, new d(new g()));
            g.a(com.tencent.mm.plugin.appbrand.n.g.class, new d(new w()));
            g.a(com.tencent.mm.plugin.appbrand.n.b.class, new d(new com.tencent.mm.plugin.appbrand.game.e()));
            com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.plugin.appbrand.b(), "//callsearchshowoutwxaapp", "//getsearchshowoutwxaapp", "//appbrandtest", "//wxafts", "//wxatest", "//localwxalibrary");
            com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.plugin.appbrand.dynamic.c.a(), "//widget");
            g.Dr().a(new com.tencent.mm.kernel.api.g() {
                public final void um() {
                    ((com.tencent.mm.modelappbrand.e) g.h(com.tencent.mm.modelappbrand.e.class)).initialize();
                }

                public final void aI(boolean z) {
                    ((com.tencent.mm.modelappbrand.e) g.h(com.tencent.mm.modelappbrand.e.class)).shutdown();
                    ((com.tencent.mm.modelappbrand.e) g.h(com.tencent.mm.modelappbrand.e.class)).Jc().exit();
                }
            });
            if (DebuggerShell.acy()) {
                g.a(DebuggerShell.class, new DebuggerShell());
            }
            r.a(new com.tencent.mm.plugin.appbrand.appcache.k());
            return;
        }
        if (ad.cgl() || isAppBrandProcess()) {
            b.Zi();
            com.tencent.mm.plugin.appbrand.report.a.f.akC();
            g.a(u.class, new d(new com.tencent.mm.plugin.appbrand.appusage.h()));
            g.a(com.tencent.mm.plugin.appbrand.widget.recentview.d.class, new d(new com.tencent.mm.plugin.appbrand.widget.d()));
            j.cc(ad.getContext());
        }
        if (ad.cgl()) {
            com.tencent.mm.plugin.appbrand.dynamic.widget.c.initialize();
            ak.a(new ak.c() {
                public final void a(String str, Throwable th) {
                    if (bi.oM(str).contains(".plugin.appbrand")) {
                        com.tencent.mm.plugin.report.service.g.pWK.a(365, 3, 1, false);
                        KVCommCrossProcessReceiver.boQ();
                    }
                }
            });
        } else if (isSupportProcess(gVar.gQd)) {
            com.tencent.mm.plugin.appbrand.dynamic.e.c.initialize();
            com.tencent.mm.plugin.appbrand.dynamic.e.c.a(new com.tencent.mm.plugin.appbrand.dynamic.e.c.a() {
                public final void Zk() {
                    com.tencent.mm.plugin.appbrand.dynamic.h.e.bS(ad.getContext());
                }
            });
            com.tencent.mm.u.g.initialize();
        }
    }

    public final String name() {
        return "plugin-appbrand";
    }

    private static boolean isAppBrandProcess() {
        try {
            return ((com.tencent.mm.kernel.b.h) g.Dn().CU()).gQd.startsWith(ad.getPackageName() + ":appbrand");
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean isSupportProcess(String str) {
        try {
            return "com.tencent.mm:support".equals(str);
        } catch (Exception e) {
            return false;
        }
    }
}
