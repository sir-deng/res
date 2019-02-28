package com.tencent.mm.plugin.appbrand.game;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Debug.MemoryInfo;
import com.tencent.magicbrush.a.c.f;
import com.tencent.magicbrush.engine.d;
import com.tencent.magicbrush.handler.MBFontManagerJNI;
import com.tencent.magicbrush.handler.MBImageHandlerJNI;
import com.tencent.magicbrush.handler.MBJavaHandler;
import com.tencent.magicbrush.handler.a.a;
import com.tencent.magicbrush.handler.c;
import com.tencent.mm.bw.b;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.appcache.ao;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.j;
import com.tencent.mm.plugin.appbrand.game.b.b.AnonymousClass2;
import com.tencent.mm.plugin.appbrand.game.b.b.AnonymousClass3;
import com.tencent.mm.plugin.appbrand.game.c.i;
import com.tencent.mm.plugin.appbrand.game.e.g;
import com.tencent.mm.plugin.appbrand.page.k;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map.Entry;

public final class b implements j {
    volatile boolean gUI = false;
    e iuk;
    k jah;
    boolean jai = false;
    private boolean jaj = false;
    private d jak;
    com.tencent.mm.plugin.appbrand.game.k.b jal;
    private long jam = -1;
    private long jan = System.currentTimeMillis();
    private Context mContext;

    public b(k kVar) {
        this.jah = kVar;
        this.mContext = this.jah.getContext();
        this.iuk = this.jah.iuk;
        this.jak = new d();
        MBJavaHandler.setCallbackProxy(new c() {
            public final byte[] bz(String str) {
                return b.this.iuk == null ? null : ao.e(b.this.iuk, str);
            }

            public final String r(String str, String str2) {
                return AppBrandLocalMediaObjectManager.genMediaFilePath(str, str2);
            }

            public final void s(String str, String str2) {
                if (b.this.iuk != null) {
                    if (!(b.this.jai || b.this.iuk.isS.iRU.iJa == 0)) {
                        x.w("MicroMsg.GameRenderer", "v8_exception mFirstFrameRendered");
                        b.this.jai = true;
                        b.this.jah.aem();
                    }
                    x.e("MicroMsg.GameRenderer", "v8_exception message = [%s], stackTrace = [%s]", str, str2);
                    b.this.iuk.isW.j("onError", "{'message':'" + g.sq(str) + "', 'stack': '" + g.sq(str2) + "'}", 0);
                }
            }

            public final void onScreenCanvasContextTypeSet(boolean z) {
                i iVar = i.jcB;
                x.i("MicroMsg.WAGamePerfManager", "setGameMainCanvasType() called with: is2D = [" + z + "]");
                iVar.jcH = Boolean.valueOf(z);
            }

            public final void onShaderCompileError(String str) {
                x.e("MicroMsg.GameRenderer", "hy: onShaderCompileError: %s", str);
                com.tencent.mm.plugin.report.service.g.pWK.h(808, 0);
                com.tencent.mm.plugin.report.service.g.pWK.h(15134, Build.MANUFACTURER, Build.MODEL, VERSION.INCREMENTAL, str);
            }
        });
        MBFontManagerJNI.registerFontManager(new com.tencent.mm.plugin.appbrand.game.b.a.AnonymousClass1(this.iuk), new a() {
            public final int n(String str, int i) {
                return AnonymousClass2.a(str, i, null);
            }

            public final Drawable o(String str, int i) {
                h hVar = new h();
                AnonymousClass2.a(str, i, hVar);
                return b.chK().a((com.tencent.mm.bw.c) hVar.jXv);
            }

            private static int a(String str, int i, h<com.tencent.mm.bw.c> hVar) {
                if (str == null || i < 0 || i >= str.length()) {
                    return 0;
                }
                int codePointAt = str.codePointAt(i);
                com.tencent.mm.bw.c DD = b.chK().DD(codePointAt);
                if (DD != null) {
                    if (hVar != null) {
                        hVar.jXv = DD;
                    }
                    return Character.charCount(codePointAt);
                }
                int codePointAt2;
                int charCount = i + Character.charCount(codePointAt);
                if (charCount < str.length()) {
                    codePointAt2 = str.codePointAt(charCount);
                } else {
                    codePointAt2 = 0;
                }
                com.tencent.mm.bw.c eK = b.chK().eK(codePointAt, codePointAt2);
                if (eK == null) {
                    return 0;
                }
                if (eK.xtf != 0) {
                    codePointAt2 = Character.charCount(codePointAt2) + charCount;
                } else {
                    codePointAt2 = charCount;
                }
                if (hVar != null) {
                    hVar.jXv = eK;
                }
                return codePointAt2 - i;
            }
        });
        e eVar = this.iuk;
        com.tencent.magicbrush.handler.image.b anonymousClass3 = new AnonymousClass3(new com.tencent.mm.plugin.appbrand.game.b.b.AnonymousClass1(eVar), new AnonymousClass2());
        anonymousClass3.a(new c(), false);
        anonymousClass3.a(new b(), false);
        anonymousClass3.a(new d(eVar, (byte) 0), true);
        anonymousClass3.boK = new a();
        com.tencent.magicbrush.a.a.a(new e());
        MBImageHandlerJNI.register(anonymousClass3);
        f.a(new com.tencent.magicbrush.a.c.e() {
            public final void v(String str, String str2, Object... objArr) {
                x.v(str, str2, objArr);
            }

            public final void d(String str, String str2, Object... objArr) {
                x.d(str, str2, objArr);
            }

            public final void i(String str, String str2, Object... objArr) {
                x.i(str, str2, objArr);
            }

            public final void w(String str, String str2, Object... objArr) {
                x.w(str, str2, objArr);
            }

            public final void e(String str, String str2, Object... objArr) {
                x.e(str, str2, objArr);
            }

            public final void a(String str, Throwable th, String str2, Object... objArr) {
                x.printErrStackTrace(str, th, str2, objArr);
            }
        });
        com.tencent.magicbrush.a.c.a.a(new com.tencent.magicbrush.a.c.d() {
            public final void j(int i, String str) {
                com.tencent.mm.plugin.appbrand.game.c.d.aev().G(i, str);
            }
        });
        if (this.jah.iuk != null && this.jah.iuk.isS != null) {
            AppBrandSysConfig appBrandSysConfig = this.jah.iuk.isS;
            i iVar = i.jcB;
            x.i("MicroMsg.WAGamePerfManager", "init() called with: appId = [%s]", appBrandSysConfig.appId);
            iVar.mAppId = r2;
            if (iVar.jcC != null) {
                iVar.jcC.oFY.quit();
                iVar.jcC = null;
            }
            if (i.a(appBrandSysConfig.uin, appBrandSysConfig.iRV.iQM)) {
                i.jcB.jcI = true;
                iVar = i.jcB;
                x.i("MicroMsg.WAGamePerfManager", "WAGamePerfManager.enableReport interval = [%d]", Integer.valueOf(appBrandSysConfig.iRV.iQN));
                iVar.jcG = new com.tencent.mm.plugin.appbrand.game.c.e(iVar.mAppId, r0);
            }
        }
    }

    public final void adV() {
        x.i("MicroMsg.GameRenderer", "onSurfaceCreated mInitialized:%s", Boolean.valueOf(this.gUI));
        if (!this.gUI) {
            f fVar = j.jaE.jaF;
            if (fVar == null) {
                throw new IllegalStateException("There is no mainJsContext here.");
            }
            this.jak.a(fVar.jax, this.mContext, this.iuk.mAppId);
            x.i("MicroMsg.GameRenderer", "hy: created.");
            this.jam = bi.Wz();
            this.gUI = true;
        }
        if (this.jal != null) {
            this.jal.aec();
        }
        i iVar = i.jcB;
        x.i("MicroMsg.WAGamePerfManager", "WAGamePerfManager.gameStart");
        synchronized (i.jcB) {
            long j;
            iVar.jcJ = true;
            if (iVar.jcI) {
                com.tencent.mm.plugin.appbrand.game.c.f fVar2 = iVar.jcD;
                fVar2.jcp = new al(iVar.aeB().oFY.getLooper(), new a(fVar2, (byte) 0), true);
                j = (long) fVar2.jcs;
                fVar2.jcp.K(j, j);
            }
            iVar.jcF.jcA = com.tencent.mm.plugin.appbrand.game.c.h.b(com.tencent.mm.plugin.appbrand.game.c.h.aex());
            if (iVar.jcG != null) {
                com.tencent.mm.plugin.appbrand.game.c.e eVar = iVar.jcG;
                eVar.ind = new al(iVar.aeB().oFY.getLooper(), new al.a() {
                    public final boolean uG() {
                        e eVar = e.this;
                        int i = i.jcB.jcH == null ? 0 : i.jcB.jcH.booleanValue() ? 1 : 2;
                        eVar.jca = i;
                        com.tencent.mm.plugin.appbrand.e pi = com.tencent.mm.plugin.appbrand.a.pi(i.jcB.mAppId);
                        i = (pi == null || pi.isP == null) ? 0 : pi.isP.YS();
                        eVar.jcb = i;
                        i iVar = i.jcB;
                        int currentTimeMillis = (int) (iVar.jcK <= 0 ? 0 : System.currentTimeMillis() - iVar.jcK);
                        f aez = i.jcB.aez();
                        if (aez != null) {
                            i = aez.jcr;
                            com.tencent.mm.plugin.report.service.g.pWK.h(14959, eVar.appId, Integer.valueOf(eVar.fJh), Integer.valueOf(eVar.foh), Integer.valueOf(eVar.jca), Integer.valueOf(a.CPU.jcn), Integer.valueOf(i), Integer.valueOf(currentTimeMillis), Integer.valueOf(eVar.jcb));
                            x.i("MicroMsg.Kv_14959", "Kv_14959.reportCpu cpu = [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", Integer.valueOf(i), Integer.valueOf(currentTimeMillis), Integer.valueOf(eVar.jcb), Integer.valueOf(eVar.jca));
                        }
                        h aey = i.jcB.aey();
                        if (aey != null) {
                            MemoryInfo aex = h.aex();
                            int b = h.b(aex);
                            int i2 = aex == null ? 0 : aex.nativePss / WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                            int i3 = aex == null ? 0 : aex.dalvikPss / WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                            i = aex == null ? 0 : aex.otherPss / WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                            int a = aey.a(aex);
                            com.tencent.mm.plugin.report.service.g.pWK.h(14959, eVar.appId, Integer.valueOf(eVar.fJh), Integer.valueOf(eVar.foh), Integer.valueOf(eVar.jca), Integer.valueOf(a.MEM.jcn), Integer.valueOf(b), Integer.valueOf(currentTimeMillis), Integer.valueOf(eVar.jcb));
                            com.tencent.mm.plugin.report.service.g.pWK.h(14959, eVar.appId, Integer.valueOf(eVar.fJh), Integer.valueOf(eVar.foh), Integer.valueOf(eVar.jca), Integer.valueOf(a.NATIVE_MEM.jcn), Integer.valueOf(i2), Integer.valueOf(currentTimeMillis), Integer.valueOf(eVar.jcb));
                            com.tencent.mm.plugin.report.service.g.pWK.h(14959, eVar.appId, Integer.valueOf(eVar.fJh), Integer.valueOf(eVar.foh), Integer.valueOf(eVar.jca), Integer.valueOf(a.DALVIK_MEM.jcn), Integer.valueOf(i3), Integer.valueOf(currentTimeMillis), Integer.valueOf(eVar.jcb));
                            com.tencent.mm.plugin.report.service.g.pWK.h(14959, eVar.appId, Integer.valueOf(eVar.fJh), Integer.valueOf(eVar.foh), Integer.valueOf(eVar.jca), Integer.valueOf(a.OTHER_MEM.jcn), Integer.valueOf(i), Integer.valueOf(currentTimeMillis), Integer.valueOf(eVar.jcb));
                            com.tencent.mm.plugin.report.service.g.pWK.h(14959, eVar.appId, Integer.valueOf(eVar.fJh), Integer.valueOf(eVar.foh), Integer.valueOf(eVar.jca), Integer.valueOf(a.MEM_DELTA.jcn), Integer.valueOf(a), Integer.valueOf(currentTimeMillis), Integer.valueOf(eVar.jcb));
                            x.i("MicroMsg.Kv_14959", "Kv_14959.reportMemory pid = [%d] native = [%d] dalvik = [%d] other = [%d] delta = [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", Integer.valueOf(b), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(a), Integer.valueOf(currentTimeMillis), Integer.valueOf(eVar.jcb), Integer.valueOf(eVar.jca));
                        }
                        g aeA = i.jcB.aeA();
                        if (aeA != null) {
                            i = (int) Math.round(aeA.jcx);
                            com.tencent.mm.plugin.report.service.g.pWK.h(14959, eVar.appId, Integer.valueOf(eVar.fJh), Integer.valueOf(eVar.foh), Integer.valueOf(eVar.jca), Integer.valueOf(a.FPS.jcn), Integer.valueOf(i), Integer.valueOf(currentTimeMillis), Integer.valueOf(eVar.jcb));
                            x.i("MicroMsg.Kv_14959", "Kv_14959.reportFps fps = [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", Integer.valueOf(i), Integer.valueOf(currentTimeMillis), Integer.valueOf(eVar.jcb), Integer.valueOf(eVar.jca));
                        }
                        return true;
                    }
                }, true);
                j = (long) (eVar.jbZ * 1000);
                eVar.ind.K(j, j);
            }
            iVar.jcK = System.currentTimeMillis();
        }
    }

    public final void bE(int i, int i2) {
        x.i("MicroMsg.GameRenderer", "[alex] WindowSize onSurfaceChanged width = [%d], height = [%d]", Integer.valueOf(i), Integer.valueOf(i2));
        if (this.jak != null) {
            this.jak.bnG.Changed(i, i2);
        }
        m.jaX.bF(i, i2);
        if (this.iuk != null) {
            e eVar = this.iuk;
            k kVar = eVar.iti;
            x.i("MicroMsg.AppBrandOnWindowSizeChangedEvent", "hy: on resizeWindow");
            kVar.a(eVar.isW).afI();
        }
    }

    public final void cA(boolean z) {
        if (this.jak != null) {
            boolean Render = this.jak.bnG.Render();
            if (!z) {
                if (Render) {
                    if (!this.jai) {
                        x.w("MicroMsg.GameRenderer", "hy: onDrawFrame mFirstFrameRendered. using %d ms", Long.valueOf(bi.bB(this.jam)));
                        this.jai = true;
                        this.jah.aem();
                    }
                } else if (!this.jaj) {
                    this.jaj = true;
                    if (this.iuk != null) {
                        this.iuk.ith.o(9, System.currentTimeMillis() - this.jan);
                    }
                }
                this.jah.iZA = Render;
            }
            com.tencent.mm.plugin.appbrand.game.c.g gVar = i.jcB.jcE;
            if (!gVar.jcz) {
                long currentTimeMillis;
                if (gVar.jcw <= 0) {
                    currentTimeMillis = System.currentTimeMillis();
                    gVar.jcw = currentTimeMillis;
                    gVar.jcu = currentTimeMillis;
                    return;
                }
                gVar.jcv++;
                if (gVar.jcv % 20 <= 0) {
                    currentTimeMillis = System.currentTimeMillis();
                    gVar.jcx = 20000.0d / ((double) (currentTimeMillis - gVar.jcu));
                    if (gVar.jcy <= 0.0d) {
                        gVar.jcy = gVar.jcx;
                    } else if (gVar.jcx < gVar.jcy) {
                        gVar.jcy = gVar.jcx;
                    }
                    gVar.jcu = currentTimeMillis;
                }
            }
        }
    }

    public final void onCreateEglSurface() {
        x.i("MicroMsg.GameRenderer", "onCreateEglSurface ");
        if (this.jak != null) {
            this.jak.bnG.onCreateEglSurface();
        }
    }

    public final void onResume() {
        x.i("MicroMsg.GameRenderer", "onResume ");
        if (this.jak != null) {
            this.jak.bnG.Resume();
        }
    }

    public final void onPause() {
        x.i("MicroMsg.GameRenderer", "onPause ");
        if (this.jak != null) {
            this.jak.bnG.Pause();
        }
    }

    public final void adW() {
        x.i("MicroMsg.GameRenderer", "onFinalize ");
        if (this.jak != null) {
            this.jak.bnG.Finalize();
        }
        i iVar = i.jcB;
        x.i("MicroMsg.WAGamePerfManager", "WAGamePerfManager.gameDestroy");
        synchronized (i.jcB) {
            iVar.jcJ = false;
        }
        x.i("MicroMsg.WAGamePerfManager", "release() called");
        if (iVar.jcC != null) {
            iVar.jcC.oFY.quit();
            iVar.jcC = null;
        }
        if (iVar.jcG != null) {
            com.tencent.mm.plugin.appbrand.game.c.e eVar = iVar.jcG;
            if (eVar.ind != null) {
                eVar.ind.TN();
            }
            iVar.jcG = null;
        }
        iVar.jcE.jcz = true;
        if (iVar.jcI) {
            com.tencent.mm.plugin.appbrand.game.c.f fVar = iVar.jcD;
            synchronized (fVar) {
                if (fVar.jcp != null) {
                    fVar.jcp.TN();
                }
            }
            iVar.jcI = false;
        }
        iVar.jcF.jcA = Integer.MAX_VALUE;
        j jVar = j.jaE;
        x.i("MicroMsg.V8JsVmManager", "GameRenderer.disposeJsVm start");
        for (Entry entry : jVar.jaH.entrySet()) {
            if (jVar.jaF != entry.getValue()) {
                com.tencent.mm.plugin.appbrand.g.a aVar = (com.tencent.mm.plugin.appbrand.g.a) entry.getValue();
                if (aVar != null) {
                    aVar.destroy();
                }
            }
        }
        jVar.jaH.clear();
        if (jVar.jaF != null) {
            jVar.jaF.destroy();
            jVar.jaF = null;
        }
        x.i("MicroMsg.V8JsVmManager", "GameRenderer.disposeJsVm finished");
    }
}
