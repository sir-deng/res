package com.tencent.mm.plugin.zero;

import android.app.Service;
import android.os.Build.VERSION;
import com.tencent.mm.ad.n;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.cc.i;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.zero.a.c;
import com.tencent.mm.plugin.zero.a.d;
import com.tencent.mm.plugin.zero.tasks.LoadProtocolJNITask;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.w;
import com.tencent.mm.vending.h.h;
import java.io.File;

public class PluginZero extends f implements d {
    private a vhj = new a();
    private b vhk = new b();
    private final com.tencent.mm.app.d vhl = new com.tencent.mm.app.d();
    public com.tencent.mm.plugin.zero.a.b vhm;
    public b vhn = new b();
    public a vho = new a();

    public static final class b extends com.tencent.mm.cc.a<c> implements c {
        public final void a(NotifyService notifyService, int i, byte[] bArr, byte[] bArr2, long j) {
            final NotifyService notifyService2 = notifyService;
            final int i2 = i;
            final byte[] bArr3 = bArr;
            final byte[] bArr4 = bArr2;
            final long j2 = j;
            a(new com.tencent.mm.cc.a.a<c>() {
                public final /* synthetic */ void az(Object obj) {
                    ((c) obj).a(notifyService2, i2, bArr3, bArr4, j2);
                }
            });
        }
    }

    public static final class a extends com.tencent.mm.cc.a<com.tencent.mm.plugin.zero.a.a> implements com.tencent.mm.plugin.zero.a.a {
        public final void a(final Service service) {
            a(new com.tencent.mm.cc.a.a<com.tencent.mm.plugin.zero.a.a>() {
                public final /* synthetic */ void az(Object obj) {
                    ((com.tencent.mm.plugin.zero.a.a) obj).a(service);
                }
            });
        }

        public final void b(final Service service) {
            a(new com.tencent.mm.cc.a.a<com.tencent.mm.plugin.zero.a.a>() {
                public final /* synthetic */ void az(Object obj) {
                    ((com.tencent.mm.plugin.zero.a.a) obj).b(service);
                }
            });
        }
    }

    public String toString() {
        return "plugin-zero";
    }

    public void installed() {
        alias(d.class);
    }

    public void dependency() {
        dependsOnRoot();
    }

    public void configure(final g gVar) {
        try {
            initSDRoot();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.PluginZero", e, "what happened?", new Object[0]);
        }
        ad.VG(gVar.gQd);
        com.tencent.mm.kernel.a.a.a("configure [%s], setup broken library handler...", this);
        k.setupBrokenLibraryHandler();
        setupVendingLog();
        if (gVar.DZ()) {
            com.tencent.mm.kernel.a.a.a("configure [%s], for process[%s]...", this, gVar.gQd);
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.zero.b.a.class, new com.tencent.mm.kernel.c.d(this.vhj));
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.zero.b.b.class, new com.tencent.mm.kernel.c.d(this.vhk));
            com.tencent.mm.kernel.a.a.a("configure [%s], make worker core...", this);
            com.tencent.mm.kernel.g Dr = com.tencent.mm.kernel.g.Dr();
            if (!Dr.gSy) {
                Dr.gSy = true;
                Dr.gSs = new e(com.tencent.mm.kernel.a.c.DA());
                Dr.gSt = new com.tencent.mm.kernel.a(com.tencent.mm.kernel.a.c.DA());
                Dr.gSu = new com.tencent.mm.kernel.b(Dr.gSv, Dr.gRt);
            }
            com.tencent.mm.kernel.g.Dr().a(new com.tencent.mm.kernel.api.g() {
                public final void um() {
                    com.tencent.mm.kernel.a.a.a("onStartupDone", new Object[0]);
                }

                public final void aI(boolean z) {
                    if (z) {
                        com.tencent.mm.kernel.k.e(gVar.gUt, true);
                        com.tencent.mm.kernel.k.f(gVar.gUt, true);
                    }
                    x.cfX();
                }
            });
            com.tencent.mm.kernel.g.Dr();
            i.zTg = new h(com.tencent.mm.cc.d.c(com.tencent.mm.kernel.g.Dt().cgs()), "WeChat.WORKER");
            com.tencent.mm.vending.h.g.a("WeChat.WORKER", i.zTg);
            new com.tencent.mm.plugin.zero.tasks.a().before(this);
        }
        if (gVar.DZ() || gVar.fT(":push")) {
            new LoadProtocolJNITask().before(this);
        }
        com.tencent.mm.kernel.b.h hVar = (com.tencent.mm.kernel.b.h) gVar;
        x.i("MicroMsg.PluginZero", "oldversion:%s, newversion:%s, gettime:%d, settime:%d", hVar.gUv.mOldVersionCode, hVar.gUv.mNewVersionCode, Long.valueOf(hVar.gUv.mGetRevTime), Long.valueOf(hVar.gUv.mSetRevTime));
    }

    private void initSDRoot() {
        if (new File(w.hbv + "SdcardInfo.cfg").exists()) {
            String str;
            String str2 = com.tencent.mm.compatible.util.e.bnD;
            s sVar = new s(w.hbv + "SdcardInfo.cfg");
            String str3 = (String) sVar.get(1, "");
            int intValue = ((Integer) sVar.get(2, Integer.valueOf(0))).intValue();
            int i = VERSION.SDK_INT;
            if (bi.oN(str3)) {
                sVar.set(1, str2);
                sVar.set(2, Integer.valueOf(i));
                str = str2;
            } else {
                str = str3;
            }
            x.i("MicroMsg.PluginZero", "initSdCardPath cfgSdcardRoot[%s], initSdcardRoot[%s], primarySD[%s], ver[%d], sdk[%d]", str3, str, str2, Integer.valueOf(intValue), Integer.valueOf(i));
            com.tencent.mm.compatible.util.e.eM(str);
            if (intValue != i && !com.tencent.mm.compatible.util.f.zl()) {
                if (com.tencent.mm.compatible.util.h.getExternalStorageState().equals("mounted") && new File(com.tencent.mm.compatible.util.h.getExternalStorageDirectory().getAbsolutePath()).canWrite()) {
                    sVar.set(1, str2);
                    sVar.set(2, Integer.valueOf(i));
                    com.tencent.mm.compatible.util.e.eM(str2);
                    x.i("MicroMsg.PluginZero", "summermount initSdCardPath ver change and old not avail reset SDCARD_ROOT[%s][%b]", com.tencent.mm.compatible.util.e.bnD, Boolean.valueOf(com.tencent.mm.compatible.util.f.zl()));
                    return;
                }
                x.i("MicroMsg.PluginZero", "summermount initSdCardPath ver change but neither primarySD nor old avail keep do nothing[%s][%b][%s]", com.tencent.mm.compatible.util.e.bnD, Boolean.valueOf(com.tencent.mm.compatible.util.f.zl()), str2);
                return;
            }
            return;
        }
        com.tencent.mm.compatible.util.e.eM(com.tencent.mm.compatible.util.e.bnD);
        x.i("MicroMsg.PluginZero", "summermount initSdCardPath sdcard info file not existed use[%s]", com.tencent.mm.compatible.util.e.bnD);
    }

    public void execute(final g gVar) {
        if (gVar.DZ()) {
            com.tencent.mm.kernel.g.Dr().gSv.aE(new com.tencent.mm.ad.n.a() {
                public final void a(n nVar, boolean z) {
                }

                public final void a(n nVar) {
                    PluginZero.this.vhl.am(gVar.gUt);
                }
            });
            NotifyReceiver.wN();
        }
    }

    private void setupVendingLog() {
        com.tencent.mm.vending.f.a.a(new com.tencent.mm.vending.f.a.a() {
            public final void e(String str, String str2, Object... objArr) {
                x.e(str, str2, objArr);
            }

            public final void w(String str, String str2, Object... objArr) {
                x.w(str, str2, objArr);
            }

            public final void i(String str, String str2, Object... objArr) {
                x.i(str, str2, objArr);
            }

            public final void d(String str, String str2, Object... objArr) {
                x.d(str, str2, objArr);
            }

            public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
                x.printErrStackTrace(str, th, str2, objArr);
            }
        });
    }

    public void setILightPushDelegate(com.tencent.mm.plugin.zero.a.b bVar) {
        this.vhm = bVar;
    }

    public com.tencent.mm.vending.b.b addNotifyReceiverCallback(c cVar) {
        x.i("MicroMsg.PluginZero", "addNotifyReceiverCallback this %s delegate %s ", this, cVar);
        return this.vhn.aE(cVar);
    }

    public com.tencent.mm.vending.b.b addICoreServiceLifecycleCallback(com.tencent.mm.plugin.zero.a.a aVar) {
        return this.vho.aE(aVar);
    }
}
