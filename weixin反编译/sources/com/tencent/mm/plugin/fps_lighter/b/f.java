package com.tencent.mm.plugin.fps_lighter.b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Debug;
import android.os.Looper;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import android.view.ViewTreeObserver.OnDrawListener;
import com.tencent.mm.f.a.kj;
import com.tencent.mm.plugin.fps_lighter.e.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

@TargetApi(16)
public final class f extends a implements FrameCallback, OnDrawListener, a {
    private boolean iqW;
    private Choreographer jLL = null;
    private c mFY;
    private boolean mGH = false;
    private long[] mGI = new long[9];
    private long mGJ = 0;
    private c<kj> mGK;
    private long mGL = 0;
    long mGM = 0;
    long mGN = 0;
    private long mGO = 0;
    private ArrayList<com.tencent.mm.plugin.fps_lighter.a.c> mListeners = new ArrayList();

    public final /* bridge */ /* synthetic */ void onActivityCreated(Activity activity, Bundle bundle) {
        super.onActivityCreated(activity, bundle);
    }

    public final /* bridge */ /* synthetic */ void onActivityDestroyed(Activity activity) {
        super.onActivityDestroyed(activity);
    }

    public final /* bridge */ /* synthetic */ void onActivityPaused(Activity activity) {
        super.onActivityPaused(activity);
    }

    public final /* bridge */ /* synthetic */ void onActivityResumed(Activity activity) {
        super.onActivityResumed(activity);
    }

    public final /* bridge */ /* synthetic */ void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        super.onActivitySaveInstanceState(activity, bundle);
    }

    public final /* bridge */ /* synthetic */ void onActivityStarted(Activity activity) {
        super.onActivityStarted(activity);
    }

    public final /* bridge */ /* synthetic */ void onActivityStopped(Activity activity) {
        super.onActivityStopped(activity);
    }

    f(c cVar) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            throw new IllegalThreadStateException("not in main thread");
        }
        this.mFY = cVar;
        this.jLL = Choreographer.getInstance();
    }

    public final void b(Application application) {
        super.b(application);
        x.i("MicroMsg.FrameBeatCore", "[setUp]");
        if (!this.mListeners.contains(this)) {
            this.mListeners.add(this);
        }
        if (this.mGK == null) {
            this.mGK = new c<kj>() {
                {
                    this.xmG = kj.class.getName().hashCode();
                }

                public final /* synthetic */ boolean a(b bVar) {
                    if (((kj) bVar).fCA.visible) {
                        x.i("MicroMsg.FrameBeatCore", "[NotifyFragmentChangeEvent] fragment:%s onCreate!", ((kj) bVar).fCA.name);
                        f.this.mGH = true;
                    }
                    return true;
                }
            };
        }
        this.mGK.cfB();
    }

    public final void c(Application application) {
        super.c(application);
        x.i("MicroMsg.FrameBeatCore", "[setOff]");
        this.mListeners.remove(this);
        if (this.mGK != null) {
            this.mGK.dead();
            this.mGK = null;
        }
        this.mListeners.clear();
        this.mFY.mGx = false;
        this.jLL.removeFrameCallback(this);
    }

    public final void q(Activity activity) {
        boolean z;
        Iterator it;
        x.i("MicroMsg.FrameBeatCore", "[onBecameForeground]:%s", activity.getClass().getSimpleName());
        c cVar = this.mFY;
        if (cVar.mGC != 0) {
            if (cVar.mGC == 100) {
                cVar.mGx = true;
            } else if (1 == new Random().nextInt(100 / cVar.mGC)) {
                cVar.mGx = true;
            }
            if (cVar.mGx) {
                x.i("MicroMsg.FPSConfig", "you are so lucky! rand:%s", Integer.valueOf(cVar.mGC));
            }
            z = cVar.mGx;
            if (this.mFY.mGx) {
                it = this.mListeners.iterator();
                while (it.hasNext()) {
                    ((com.tencent.mm.plugin.fps_lighter.a.c) it.next()).E(Integer.MAX_VALUE, true);
                }
                this.jLL.removeFrameCallback(this);
                this.jLL.postFrameCallback(this);
            }
        }
        cVar.mGx = false;
        if (cVar.mGx) {
            x.i("MicroMsg.FPSConfig", "you are so lucky! rand:%s", Integer.valueOf(cVar.mGC));
        }
        z = cVar.mGx;
        if (this.mFY.mGx) {
            it = this.mListeners.iterator();
            while (it.hasNext()) {
                ((com.tencent.mm.plugin.fps_lighter.a.c) it.next()).E(Integer.MAX_VALUE, true);
            }
            this.jLL.removeFrameCallback(this);
            this.jLL.postFrameCallback(this);
        }
    }

    public final void r(Activity activity) {
        x.i("MicroMsg.FrameBeatCore", "[onBecameBackground]:%s", activity.getClass().getSimpleName());
        this.mFY.mGx = false;
        Iterator it = this.mListeners.iterator();
        while (it.hasNext()) {
            ((com.tencent.mm.plugin.fps_lighter.a.c) it.next()).E(Integer.MAX_VALUE, false);
        }
    }

    public final void s(Activity activity) {
        x.i("MicroMsg.FrameBeatCore", "[onBegin]:%s", activity.getClass().getSimpleName());
        this.mFY.u(activity);
        this.mGH = true;
    }

    public final void t(final Activity activity) {
        x.i("MicroMsg.FrameBeatCore", "[onChangeActivity] now Activity:%s", activity.getClass().getSimpleName());
        this.mFY.u(activity);
        activity.getWindow().getDecorView().post(new Runnable() {
            public final void run() {
                activity.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(f.this);
                activity.getWindow().getDecorView().getViewTreeObserver().addOnDrawListener(f.this);
            }
        });
    }

    public final void doFrame(long j) {
        Object obj;
        long threadCpuTimeNanos = Debug.threadCpuTimeNanos();
        Object obj2 = 1;
        if (!this.mFY.mGx) {
            x.e("MicroMsg.FrameBeatCore", "[doFrame] unEnable!");
            obj2 = null;
        }
        if (this.mListeners.size() <= 0) {
            x.e("MicroMsg.FrameBeatCore", "has not any listener!");
            obj = null;
        } else {
            obj = obj2;
        }
        if (obj == null) {
            this.mGJ = 0;
            Iterator it = this.mListeners.iterator();
            while (it.hasNext()) {
                ((com.tencent.mm.plugin.fps_lighter.a.c) it.next()).E(Integer.MAX_VALUE, false);
            }
            Choreographer.getInstance().removeFrameCallback(this);
        }
        if (obj != null) {
            int intValue;
            long threadCpuTimeNanos2;
            long nanoTime;
            long j2;
            long j3;
            Iterator it2;
            c cVar = this.mFY;
            String str = this.mFY.mGB;
            if (bi.oN(str)) {
                x.i("MicroMsg.FPSConfig", "null == activityName");
            } else {
                Integer num;
                if (c.mGz.containsKey(str)) {
                    num = (Integer) c.mGz.get(str);
                    intValue = num != null ? num.intValue() : -1;
                } else if (c.mGz.containsKey(cVar.mGA) && cVar.mGB.equalsIgnoreCase("LauncherUI")) {
                    num = (Integer) c.mGz.get(cVar.mGA);
                    intValue = num != null ? num.intValue() : -1;
                }
                threadCpuTimeNanos2 = Debug.threadCpuTimeNanos();
                nanoTime = System.nanoTime();
                if (this.mGN != 0 || this.mGM == 0) {
                    j2 = 0;
                } else {
                    j2 = (long) Math.round(((((float) (threadCpuTimeNanos2 - this.mGN)) * 1.0f) / ((float) (nanoTime - this.mGM))) * 100.0f);
                }
                this.mGN = threadCpuTimeNanos2;
                this.mGM = nanoTime;
                j3 = j - this.mGJ;
                if (0 == this.mGJ && intValue != -1 && this.iqW) {
                    int b = a.b(j3, this.mFY.mGs);
                    Iterator it3 = this.mListeners.iterator();
                    while (it3.hasNext()) {
                        ((com.tencent.mm.plugin.fps_lighter.a.c) it3.next()).a(intValue, this.mGJ / 1000000, j / 1000000, b, (int) j2, this.mGH, this.mGL / 1000000, this.iqW);
                    }
                } else {
                    it2 = this.mListeners.iterator();
                    while (it2.hasNext()) {
                        ((com.tencent.mm.plugin.fps_lighter.a.c) it2.next()).E(-1, false);
                    }
                }
                this.mGH = false;
                this.iqW = false;
                this.mGJ = j;
                this.jLL.postFrameCallback(this);
                this.mGL = Debug.threadCpuTimeNanos() - threadCpuTimeNanos;
            }
            intValue = -1;
            threadCpuTimeNanos2 = Debug.threadCpuTimeNanos();
            nanoTime = System.nanoTime();
            if (this.mGN != 0) {
            }
            j2 = 0;
            this.mGN = threadCpuTimeNanos2;
            this.mGM = nanoTime;
            j3 = j - this.mGJ;
            if (0 == this.mGJ) {
            }
            it2 = this.mListeners.iterator();
            while (it2.hasNext()) {
                ((com.tencent.mm.plugin.fps_lighter.a.c) it2.next()).E(-1, false);
            }
            this.mGH = false;
            this.iqW = false;
            this.mGJ = j;
            this.jLL.postFrameCallback(this);
            this.mGL = Debug.threadCpuTimeNanos() - threadCpuTimeNanos;
        }
    }

    public final void a(com.tencent.mm.plugin.fps_lighter.a.c cVar) {
        if (!this.mListeners.contains(cVar)) {
            this.mListeners.add(cVar);
        }
    }

    public final void onDraw() {
        this.iqW = true;
    }
}
