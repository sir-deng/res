package com.tencent.mm.plugin.appbrand.b;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.plugin.appbrand.g.a.f;
import com.tencent.mm.plugin.appbrand.g.a.h;
import com.tencent.mm.plugin.appbrand.g.g;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public abstract class c extends h {
    final String TAG;
    final d iKg;
    final a iKh;
    final e iKi;
    final c iKj;
    final b iKk;
    public final AtomicBoolean iKl;
    private final AtomicBoolean iKm;
    private final AtomicReference<com.tencent.mm.sdk.d.c> iKn;
    private final AtomicReference<com.tencent.mm.sdk.d.c> iKo;
    final com.tencent.mm.plugin.appbrand.e iuk;

    private final class b extends g {
        b(h hVar) {
            super(hVar);
        }

        public final String getName() {
            return c.this.mName + "|BackgroundKeepNoChange";
        }

        public final boolean j(Message message) {
            switch (message.what) {
                case 3:
                    c.a(c.this, c.this.iKg);
                    return true;
                default:
                    return super.j(message);
            }
        }
    }

    private final class d extends g {
        d(h hVar) {
            super(hVar);
        }

        public final String getName() {
            return c.this.mName + "|Foreground";
        }

        public final boolean j(Message message) {
            switch (message.what) {
                case 1:
                    c.a(c.this, c.this.iKh);
                    return true;
                default:
                    return super.j(message);
            }
        }

        public final void enter() {
            super.enter();
        }

        public final void exit() {
            super.exit();
        }
    }

    private final class e extends g {
        e(h hVar) {
            super(hVar);
        }

        public final String getName() {
            return c.this.mName + "|Suspend";
        }

        public final void enter() {
            super.enter();
            c.this.xrk.sendEmptyMessageDelayed(11, ((long) c.this.iuk.isS.iRS) * 1000);
            g aaL = aaL();
            if (aaL != null) {
                aaL.pause();
                for (f fVar : c.this.iuk.isW.iun.iux.jBY.values()) {
                    fVar.jBK.itm = true;
                }
            }
        }

        public final void exit() {
            super.exit();
            c.this.xrk.removeMessages(11);
            g aaL = aaL();
            if (aaL != null) {
                aaL.resume();
                for (f fVar : c.this.iuk.isW.iun.iux.jBY.values()) {
                    h hVar = fVar.jBK;
                    hVar.itm = false;
                    hVar.jBT.interrupt();
                }
            }
        }

        public final boolean j(Message message) {
            switch (message.what) {
                case 3:
                    c.a(c.this, c.this.iKg);
                    return true;
                case 11:
                    x.i(c.this.TAG, "suspend timeout");
                    c.this.aaH();
                    return true;
                default:
                    return super.j(message);
            }
        }

        private g aaL() {
            return (g) c.this.iuk.isW.ium.v(g.class);
        }
    }

    private final class a extends f {
        a(h hVar, com.tencent.mm.plugin.appbrand.e eVar) {
            super(hVar, eVar);
        }

        public final String getName() {
            return c.this.mName + "|Background";
        }

        public final boolean j(Message message) {
            switch (message.what) {
                case 3:
                    c.a(c.this, c.this.iKg);
                    return true;
                case 12:
                    super.jD(16);
                    return true;
                default:
                    return super.j(message);
            }
        }

        public final void enter() {
            super.enter();
        }

        public final void exit() {
            super.exit();
        }

        final void aaK() {
            if (c.this.chu() == this) {
                c.a(c.this, c.this.iKj);
                c.this.jC(1000);
            }
        }
    }

    private final class c extends g {
        c(h hVar) {
            super(hVar);
        }

        public final String getName() {
            return c.this.mName + "|BackgroundTemporary";
        }

        public final boolean j(Message message) {
            switch (message.what) {
                case 3:
                    c.a(c.this, c.this.iKg);
                    return true;
                case 4:
                    RunningAppProcessInfo runningAppProcessInfo = new RunningAppProcessInfo();
                    ActivityManager.getMyMemoryState(runningAppProcessInfo);
                    x.i(c.this.TAG, "BackgroundTemporary process TO_SUSPEND_FROM_BACKGROUND, current process importance %d", Integer.valueOf(runningAppProcessInfo.importance));
                    if (runningAppProcessInfo.importance == 100) {
                        c.a(c.this, c.this.iKk);
                        return true;
                    }
                    c.a(c.this, c.this.iKi);
                    return true;
                case 10:
                    x.i(c.this.TAG, "BackgroundTemporary process ON_SYSTEM_SCREEN_OFF");
                    c.a(c.this, c.this.iKk);
                    return true;
                default:
                    return super.j(message);
            }
        }

        public final void enter() {
            super.enter();
            c.this.xrk.sendEmptyMessageDelayed(4, ((long) c.this.iuk.isS.iRR) * 1000);
        }

        public final void exit() {
            super.exit();
            c.this.xrk.removeMessages(4);
        }
    }

    abstract void aaH();

    public abstract void b(a aVar);

    static /* synthetic */ void a(c cVar, g gVar) {
        cVar.iKm.set(false);
        cVar.iKn.set(gVar);
        cVar.iKo.set(null);
        super.b((com.tencent.mm.sdk.d.a) gVar);
    }

    c(com.tencent.mm.plugin.appbrand.e eVar) {
        super("MicroMsg.AppBrand.AppRunningStateMachine[" + eVar.mAppId + "]", eVar.YI() ? new ah("AppRunningStateMachineForGameRuntime").oFY.getLooper() : Looper.getMainLooper());
        this.iKl = new AtomicBoolean(false);
        this.iKm = new AtomicBoolean(false);
        this.iKn = new AtomicReference(null);
        this.iKo = new AtomicReference(null);
        this.TAG = this.mName;
        this.iuk = eVar;
        this.iKj = new c(this);
        this.iKk = new b(this);
        this.iKh = new a(this, eVar);
        this.iKg = new d(this);
        this.iKi = new e(this);
        Runnable anonymousClass1 = new Runnable() {
            public final void run() {
                c.this.a(c.this.iKj);
                c.this.a(c.this.iKk);
                c.this.a(c.this.iKh);
                c.this.a(c.this.iKg);
                c.this.a(c.this.iKi);
                c.this.b(c.this.iKg);
            }
        };
        if (Looper.myLooper() == this.xrk.getLooper()) {
            anonymousClass1.run();
            return;
        }
        this.iKm.set(true);
        this.xrk.post(anonymousClass1);
    }

    public final void start() {
        if (!this.iKl.get()) {
            if (Looper.myLooper() == this.xrk.getLooper()) {
                super.start();
            } else {
                this.xrk.post(new Runnable() {
                    public final void run() {
                        super.start();
                    }
                });
            }
        }
    }

    final void a(g gVar) {
        this.iKn.set(null);
        this.iKo.set(gVar);
        Message cht = cht();
        if (cht == null || cht.what != -2) {
            b(a((com.tencent.mm.sdk.d.a) gVar));
        }
    }

    public final a aaI() {
        if (!this.iKm.get() || Thread.currentThread().getId() == this.xrk.getLooper().getThread().getId()) {
            return aaJ();
        }
        if (!ah.isMainThread()) {
            return (a) new bd<a>() {
                protected final /* synthetic */ Object run() {
                    return c.this.aaJ();
                }
            }.b(new ag(this.xrk.getLooper()));
        }
        com.tencent.mm.sdk.d.a aVar = (com.tencent.mm.sdk.d.c) this.iKo.get();
        x.i(this.TAG, "getRunningStateExport, pending change in sm-looper(%d) but query from main-looper, cached-state=%s, stopped=%b", Long.valueOf(this.xrk.getLooper().getThread().getId()), aVar, Boolean.valueOf(this.iKl.get()));
        if (aVar != null) {
            return a(aVar);
        }
        return r1 ? a.DESTROYED : a.FOREGROUND;
    }

    private a aaJ() {
        if (this.iKl.get()) {
            return a.DESTROYED;
        }
        com.tencent.mm.sdk.d.a aVar = (com.tencent.mm.sdk.d.c) this.iKn.get();
        if (aVar != null) {
            return a(aVar);
        }
        aVar = (com.tencent.mm.sdk.d.c) this.iKo.get();
        if (aVar != null) {
            return a(aVar);
        }
        if (Thread.currentThread().getId() != this.xrk.getLooper().getThread().getId()) {
            aVar = (com.tencent.mm.sdk.d.a) new bd<com.tencent.mm.sdk.d.a>() {
                protected final /* synthetic */ Object run() {
                    return super.chu();
                }
            }.b(new ag(this.xrk.getLooper()));
        } else {
            aVar = super.chu();
        }
        return a(aVar);
    }

    private a a(com.tencent.mm.sdk.d.a aVar) {
        if (aVar == this.iKh || aVar == this.iKj || aVar == this.iKk) {
            return a.BACKGROUND;
        }
        if (aVar == this.iKi) {
            return a.SUSPEND;
        }
        if (aVar == this.iKg) {
            return a.FOREGROUND;
        }
        return a.FOREGROUND;
    }

    public final void jC(int i) {
        this.iKm.set(true);
        if (cht() == null) {
            super.DA(i);
        } else {
            super.DB(i);
        }
    }

    protected final boolean h(Message message) {
        return message.what != 1000;
    }

    protected final void i(Message message) {
        super.i(message);
        this.iKm.set(false);
    }

    protected final void ZQ() {
        super.ZQ();
        if (this.xrk.getLooper().getThread().getId() != Looper.getMainLooper().getThread().getId()) {
            this.xrk.post(new Runnable() {
                public final void run() {
                    Looper.myQueue().addIdleHandler(new IdleHandler() {
                        public final boolean queueIdle() {
                            Looper.myLooper().quit();
                            return false;
                        }
                    });
                }
            });
        }
    }
}
