package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.SystemClock;
import com.tencent.mm.booter.c;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.a.a;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.b.h.AnonymousClass3;
import com.tencent.mm.kernel.b.h.AnonymousClass5;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tinker.loader.app.ApplicationLifeCycle;

public class MMApplicationWrapper implements ApplicationLifeCycle {
    private static final String TAG = "MicroMsg.MMApplicationWrapper";
    public Application app;
    private final MMApplicationLike lifeCycle;
    private h profile = null;
    private String thisProcess = "";

    public MMApplicationWrapper(MMApplicationLike mMApplicationLike, String str) {
        this.app = mMApplicationLike.getApplication();
        this.lifeCycle = mMApplicationLike;
        this.thisProcess = str;
    }

    public void onBaseContextAttached(Context context) {
        a.gST = SystemClock.elapsedRealtime();
        this.profile = new h(this.thisProcess, this.app, this.lifeCycle);
        l.tZ();
        k.b("stlport_shared", context.getClassLoader());
        k.b(com.tencent.mm.sdk.a.xmo, context.getClassLoader());
        this.profile.gAA = c.aA(this.profile.gUt);
        setupXLogDebugger(this.profile);
        com.tencent.mm.splash.a.d(this.app);
        if (l.ct(this.thisProcess)) {
            x.i(TAG, "is plain process. load nothing");
            o.a(this.profile);
            o.ug();
        } else {
            o.a(this.profile);
            o.a(this.app, this.thisProcess, "com.tencent.mm.app.WeChatSplashStartup");
        }
        m.d(com.tencent.mm.boot.a.a.class);
        m.cu("com.tencent.mm.boot");
    }

    private void setupXLogDebugger(h hVar) {
        c cVar = hVar.gAA;
        if (hVar.DZ()) {
            cVar.eg("MM");
        } else if (hVar.fT(":push")) {
            cVar.eg("PUSH");
        } else if (hVar.fT(":tools")) {
            cVar.eg("TOOL");
        } else if (hVar.fT(":sandbox")) {
            cVar.eg("SANDBOX");
        } else if (hVar.fT(":exdevice")) {
            cVar.eg("EXDEVICE");
        } else if (hVar.fT(":patch")) {
            cVar.eg("PATCH");
        } else if (hVar.fT(":appbrand")) {
            cVar.eg("APPBRAND");
        } else if (hVar.fT(":TMAssistantDownloadSDKService")) {
            cVar.eg("TMSDK");
        } else if (hVar.fT(":dexopt")) {
            cVar.eg("DEXOPT");
        }
    }

    public void onCreate() {
        o.ui();
    }

    public void onTerminate() {
        if (this.profile != null) {
            h hVar = this.profile;
            hVar.gUw.a(new com.tencent.mm.cc.a.a<ApplicationLifeCycle>() {
                public final /* synthetic */ void az(Object obj) {
                    ((ApplicationLifeCycle) obj).onTerminate();
                }
            });
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.profile != null) {
            h hVar = this.profile;
            hVar.gUw.a(new AnonymousClass5(configuration));
        }
    }

    public void onLowMemory() {
        if (this.profile != null) {
            h hVar = this.profile;
            hVar.gUw.a(new com.tencent.mm.cc.a.a<ApplicationLifeCycle>() {
                public final /* synthetic */ void az(Object obj) {
                    ((ApplicationLifeCycle) obj).onLowMemory();
                }
            });
        }
    }

    public void onTrimMemory(int i) {
        if (this.profile != null) {
            h hVar = this.profile;
            hVar.gUw.a(new AnonymousClass3(i));
        }
    }
}
