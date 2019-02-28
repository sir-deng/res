package com.tencent.mm.app;

import android.app.Activity;
import android.app.Application;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.mm.app.o.a;
import com.tencent.mm.f.a.lt;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.a.b;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.splash.e;
import com.tencent.mm.splash.k;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.m;
import com.tencent.mm.vending.h.d;
import com.tencent.mm.y.ar;
import com.tencent.tinker.loader.app.ApplicationLifeCycle;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import junit.framework.Assert;

public class WeChatSplashStartup implements a {
    private Application app;
    private MMApplicationLike lifeCycle;
    h profile;
    private String thisProcess;

    public final void a(Application application, String str, MMApplicationLike mMApplicationLike) {
        this.app = application;
        this.thisProcess = str;
        this.lifeCycle = mMApplicationLike;
        this.profile = o.uf();
        g.b(this.profile);
        h hVar = this.profile;
        hVar.gUw.a(new com.tencent.mm.kernel.b.h.AnonymousClass6(this.app));
    }

    public final void c(k.a aVar) {
        d(aVar);
    }

    public final void ul() {
        d(null);
    }

    private void d(final k.a aVar) {
        d dVar;
        com.tencent.mm.blink.a.fi(2);
        final boolean z = aVar == null;
        h hVar = this.profile;
        hVar.gUw.a(new com.tencent.mm.cc.a.a<ApplicationLifeCycle>() {
            public final /* synthetic */ void az(Object obj) {
                ((ApplicationLifeCycle) obj).onCreate();
            }
        });
        b fVar = new f();
        com.tencent.mm.kernel.a.a aVar2 = this.profile.gRM;
        Assert.assertNotNull(fVar);
        com.tencent.mm.kernel.h.Dv().Dn().CU();
        aVar2.gSS = fVar;
        if (!z) {
            e.cic();
            new c<lt>() {
                public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            x.i("MicroMsg.WeChatSplashStartup", "Replay pending messages.");
                            aVar.cin();
                        }
                    });
                    dead();
                    return false;
                }
            }.cfB();
        }
        g Dr = g.Dr();
        if (z) {
            dVar = null;
        } else {
            if (h.ffv == null) {
                h.ffv = new h("initThread");
            }
            final h hVar2 = h.ffv;
            hVar2.tT();
            g.Dr().a(new com.tencent.mm.kernel.api.g() {
                public final void um() {
                    hVar2.ffw.quit();
                    g.Dr().b((com.tencent.mm.kernel.api.g) this);
                }

                public final void aI(boolean z) {
                }
            });
            com.tencent.mm.kernel.a.c.DA().b(hVar2.ffw.getLooper());
            dVar = hVar2.ffx;
        }
        com.tencent.mm.kernel.h hVar3 = Dr.gSp;
        com.tencent.mm.blink.a.ee("startup");
        synchronized (hVar3.gSH) {
            if (hVar3.gSI) {
                com.tencent.mm.kernel.a.a.a("warning, mmskeleton has started up already.", new Object[0]);
            } else {
                com.tencent.mm.kernel.b.g CU = hVar3.Dn().CU();
                long currentTimeMillis = System.currentTimeMillis();
                com.tencent.mm.kernel.a.a.a("mmskeleton boot startup for process [%s]...", CU.gQd);
                com.tencent.mm.kernel.a.a aVar3 = CU.gRM;
                Assert.assertNotNull("You must call whichBootStep(BootStep defaultOne, BootStep ... bootSteps) to specify your BootStep instance first!", aVar3.gSS);
                com.tencent.mm.vending.g.c nN = com.tencent.mm.vending.g.g.cAN().nN(true);
                com.tencent.mm.kernel.a.a.gSU = SystemClock.elapsedRealtime();
                com.tencent.mm.kernel.a.a.a("hello WeChat.", new Object[0]);
                aVar3.gSS.tO();
                long currentTimeMillis2 = System.currentTimeMillis();
                com.tencent.mm.kernel.a.a.a("boot install plugins...", new Object[0]);
                aVar3.gSS.tP();
                aVar3.mConfigured = true;
                com.tencent.mm.kernel.a.a.a("boot all installed plugins : %s...", com.tencent.mm.kernel.h.Dv().Dm().CT());
                com.tencent.mm.kernel.a.a.a("boot install plugins done in [%s].", com.tencent.mm.kernel.a.a.aH(currentTimeMillis2));
                com.tencent.mm.blink.a.ee("installPlugins");
                currentTimeMillis2 = System.currentTimeMillis();
                com.tencent.mm.kernel.a.a.a("boot make dependency of plugins...", new Object[0]);
                aVar3.gSS.Dy();
                com.tencent.mm.kernel.a.a.a("boot make dependency of done in [%s].", com.tencent.mm.kernel.a.a.aH(currentTimeMillis2));
                currentTimeMillis2 = System.currentTimeMillis();
                com.tencent.mm.kernel.a.a.a("boot configure plugins...", new Object[0]);
                aVar3.gSS.a(CU);
                com.tencent.mm.kernel.a.a.a("boot configure plugins done in [%s].", com.tencent.mm.kernel.a.a.aH(currentTimeMillis2));
                if (dVar != null) {
                    nN.a(dVar);
                }
                nN.b(new com.tencent.mm.kernel.h.AnonymousClass1(aVar3, CU));
                nN.b(new com.tencent.mm.kernel.h.AnonymousClass2(aVar3, CU));
                nN.a(d.zLX, new com.tencent.mm.kernel.h.AnonymousClass3(currentTimeMillis));
            }
        }
        e.a(new com.tencent.mm.splash.c() {
            m fgs = new m();

            public final boolean j(Intent intent) {
                if (intent == null || t.a(intent, "absolutely_exit_pid", 0) != Process.myPid()) {
                    return false;
                }
                x.i("MicroMsg.WeChatSplashStartup", "handle exit intent.");
                MMAppMgr.md(t.a(intent, "kill_service", true));
                return true;
            }

            public final boolean a(Activity activity, final Runnable runnable) {
                g.Do();
                boolean z = !com.tencent.mm.kernel.a.CE() && ar.hhz.H("login_user_name", "").equals("");
                if (z && f.xmV) {
                    return MMAppMgr.a(activity, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            runnable.run();
                        }
                    });
                }
                return false;
            }

            public final boolean b(Activity activity, Runnable runnable) {
                return this.fgs.c(activity, runnable);
            }

            public final boolean a(Activity activity, int i, String[] strArr, int[] iArr) {
                return this.fgs.a(activity, i, strArr, iArr);
            }
        });
        g.Dr().a(new com.tencent.mm.kernel.api.g() {
            public final void um() {
                g.Dr().b((com.tencent.mm.kernel.api.g) this);
                if (z) {
                    e.a("MicroMsg.FigLeaf", "deleteRequest ", new Object[0]);
                    String chU = com.tencent.mm.splash.a.chU();
                    if (new File(chU).exists()) {
                        File file = new File(chU + "/main-process-blocking");
                        if (file.exists()) {
                            boolean delete = file.delete();
                            e.a("MicroMsg.FigLeaf", "deleteRequest result %s.", Boolean.valueOf(delete));
                            return;
                        }
                        return;
                    }
                    e.a("MicroMsg.FigLeaf", "deleteRequest dex opt dir not exists.", new Object[0]);
                    return;
                }
                aVar.done();
            }

            public final void aI(boolean z) {
            }
        });
        g.Dr().a(new com.tencent.mm.kernel.api.g() {
            public final void um() {
                g.Dr().b((com.tencent.mm.kernel.api.g) this);
                com.tencent.mm.blink.a.wq();
                com.tencent.mm.vending.g.g.cAN().gt(500).c(new com.tencent.mm.vending.c.a<Void, Void>() {
                    public final /* synthetic */ Object call(Object obj) {
                        Iterator it = e.cil().gyU.iterator();
                        while (it.hasNext()) {
                            long[] jArr = (long[]) it.next();
                            x.i("MicroMsg.WeChatSplashStartup", "splash %s, %s, %s", Long.valueOf(jArr[0]), Long.valueOf(jArr[1]), Long.valueOf(jArr[2]));
                            com.tencent.mm.plugin.report.service.g.pWK.a(jArr[0], jArr[1], jArr[2], false);
                        }
                        ArrayList arrayList = e.cil().xuJ;
                        Map hashMap = new HashMap();
                        String str = "NewSplash";
                        hashMap.put("processName", WeChatSplashStartup.this.thisProcess);
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            x.i("MicroMsg.WeChatSplashStartup", "splash message %s", (String) it2.next());
                            com.tencent.mm.plugin.report.service.g.pWK.c(str, r0, hashMap);
                        }
                        x.i("MicroMsg.WeChatSplashStartup", "report splash info %s %s", Integer.valueOf(r9.size()), Integer.valueOf(arrayList.size()));
                        return zLb;
                    }
                });
                if (WeChatSplashStartup.this.profile.DZ()) {
                    try {
                        ad.getContext().getSharedPreferences("system_config_prefs", 0).edit().putInt("launch_last_status", 2).commit();
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.WeChatSplashStartup", e, "%s", e.getMessage());
                    }
                }
                if (WeChatSplashStartup.this.profile.DZ()) {
                    com.tencent.mm.kernel.a Do = g.Do();
                    x.i("MMKernel.CoreAccount", "summerhardcoder hasInitialized[%b] mHardCoderStartPerformance[%d] stack[%s]", Boolean.valueOf(Do.CF()), Integer.valueOf(Do.gRa), bi.chl());
                    if (Do.CF() && Do.gRa != 0) {
                        HardCoderJNI.stopPerformace(HardCoderJNI.hcBootEnable, Do.gRa);
                        x.i("MMKernel.CoreAccount", "summerhardcoder stopPerformace[%s] stack[%s]", Integer.valueOf(Do.gRa), bi.chl());
                        Do.gRa = 0;
                    }
                }
            }

            public final void aI(boolean z) {
            }
        });
    }
}
