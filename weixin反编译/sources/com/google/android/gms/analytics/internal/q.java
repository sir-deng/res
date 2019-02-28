package com.google.android.gms.analytics.internal;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.analytics.a;
import com.google.android.gms.analytics.b;
import com.google.android.gms.analytics.c;
import com.google.android.gms.c.ah;
import com.google.android.gms.c.v;
import com.google.android.gms.c.w;
import com.google.android.gms.common.internal.f;
import java.lang.Thread.UncaughtExceptionHandler;

public class q {
    private static q aFU;
    public final v aFD = w.pI();
    final Context aFV;
    final ac aFW = r.b(this);
    final f aFX;
    private final ah aFY;
    private final m aFZ;
    final ag aGa;
    private final l aGb;
    final i aGc;
    private final a aGd;
    private final y aGe;
    public final a aGf;
    public final v aGg;
    public final af aGh;
    final Context mContext;

    private q(r rVar) {
        Context context = rVar.aGj;
        com.google.android.gms.common.internal.w.i(context, "Application context can't be null");
        com.google.android.gms.common.internal.w.e(context instanceof Application, "getApplicationContext didn't return the application");
        Context context2 = rVar.aGk;
        com.google.android.gms.common.internal.w.ag(context2);
        this.mContext = context;
        this.aFV = context2;
        f fVar = new f(this);
        fVar.mS();
        this.aFX = fVar;
        if (f.aNs) {
            mT().aw("Google Analytics " + p.VERSION + " is starting up.");
        } else {
            mT().aw("Google Analytics " + p.VERSION + " is starting up. To enable debug logging on a device run:\n  adb shell setprop log.tag.GAv4 DEBUG\n  adb logcat -s GAv4");
        }
        i f = r.f(this);
        f.mS();
        this.aGc = f;
        l lVar = new l(this);
        lVar.mS();
        this.aGb = lVar;
        m mVar = new m(this, rVar);
        y a = r.a(this);
        a aVar = new a(this);
        v vVar = new v(this);
        af afVar = new af(this);
        ah S = ah.S(context);
        S.aYq = new UncaughtExceptionHandler() {
            public final void uncaughtException(Thread thread, Throwable th) {
                f fVar = q.this.aFX;
                if (fVar != null) {
                    fVar.f("Job execution failed", th);
                }
            }
        };
        this.aFY = S;
        c aVar2 = new a(this);
        a.mS();
        this.aGe = a;
        aVar.mS();
        this.aGf = aVar;
        vVar.mS();
        this.aGg = vVar;
        afVar.mS();
        this.aGh = afVar;
        ag e = r.e(this);
        e.mS();
        this.aGa = e;
        mVar.mS();
        this.aFZ = mVar;
        if (f.aNs) {
            mT().d("Device AnalyticsService version", p.VERSION);
        }
        l mX = aVar2.aHf.mX();
        if (mX.mF()) {
            e.mn().setLogLevel(mX.getLogLevel());
        }
        if (mX.mI()) {
            aVar2.aEL = mX.mJ();
        }
        if (mX.mF()) {
            b mn = e.mn();
            if (mn != null) {
                mn.setLogLevel(mX.getLogLevel());
            }
        }
        aVar2.aEI = true;
        this.aGd = aVar2;
        mVar.aFK.start();
    }

    public static q A(Context context) {
        com.google.android.gms.common.internal.w.ag(context);
        if (aFU == null) {
            synchronized (q.class) {
                if (aFU == null) {
                    v pI = w.pI();
                    long elapsedRealtime = pI.elapsedRealtime();
                    q qVar = new q(new r(context.getApplicationContext()));
                    aFU = qVar;
                    a.mf();
                    elapsedRealtime = pI.elapsedRealtime() - elapsedRealtime;
                    long longValue = ((Long) aj.aIi.get()).longValue();
                    if (elapsedRealtime > longValue) {
                        qVar.mT().c("Slow initialization (ms)", Long.valueOf(elapsedRealtime), Long.valueOf(longValue));
                    }
                }
            }
        }
        return aFU;
    }

    public static void a(o oVar) {
        com.google.android.gms.common.internal.w.i(oVar, "Analytics service not created/initialized");
        com.google.android.gms.common.internal.w.e(oVar.isInitialized(), "Analytics service not initialized");
    }

    public static void mZ() {
        ah.mZ();
    }

    public final f mT() {
        a(this.aFX);
        return this.aFX;
    }

    public final ah mU() {
        com.google.android.gms.common.internal.w.ag(this.aFY);
        return this.aFY;
    }

    public final m mV() {
        a(this.aFZ);
        return this.aFZ;
    }

    public final a mW() {
        com.google.android.gms.common.internal.w.ag(this.aGd);
        a aVar = this.aGd;
        boolean z = aVar.aEI && !aVar.aEJ;
        com.google.android.gms.common.internal.w.e(z, "Analytics instance not initialized");
        return this.aGd;
    }

    public final l mX() {
        a(this.aGb);
        return this.aGb;
    }

    public final y mY() {
        a(this.aGe);
        return this.aGe;
    }
}
