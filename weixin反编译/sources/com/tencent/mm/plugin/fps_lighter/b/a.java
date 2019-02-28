package com.tencent.mm.plugin.fps_lighter.b;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;

class a implements ActivityLifecycleCallbacks {
    private boolean lFv;
    private Activity mGl;
    private Runnable mGm;
    private boolean mIsPaused;
    ArrayList<a> mListeners = new ArrayList();
    private Handler mMainHandler = new Handler(Looper.getMainLooper());

    protected interface a {
        void q(Activity activity);

        void r(Activity activity);

        void s(Activity activity);

        void t(Activity activity);
    }

    a() {
    }

    public void b(Application application) {
        application.registerActivityLifecycleCallbacks(this);
    }

    public void c(Application application) {
        application.unregisterActivityLifecycleCallbacks(this);
        this.mListeners.clear();
    }

    public void onActivityResumed(final Activity activity) {
        this.mIsPaused = false;
        x.i("MicroMsg.BaseFrameBeatCore", "[onActivityResumed] foreground:%s", Boolean.valueOf(this.lFv));
        final boolean z = !this.lFv;
        this.lFv = true;
        if (activity != this.mGl) {
            Iterator it = this.mListeners.iterator();
            while (it.hasNext()) {
                try {
                    ((a) it.next()).t(activity);
                } catch (Exception e) {
                    x.e("MicroMsg.BaseFrameBeatCore", "Listener threw exception!", e);
                }
            }
            this.mGl = activity;
        }
        Handler handler = this.mMainHandler;
        Runnable anonymousClass1 = new Runnable() {
            public final void run() {
                if (z) {
                    x.i("MicroMsg.BaseFrameBeatCore", "went foreground");
                    Iterator it = a.this.mListeners.iterator();
                    while (it.hasNext()) {
                        try {
                            ((a) it.next()).q(activity);
                        } catch (Exception e) {
                            x.e("MicroMsg.BaseFrameBeatCore", "Listener threw exception!", e);
                        }
                    }
                    return;
                }
                x.i("MicroMsg.BaseFrameBeatCore", "still foreground");
            }
        };
        this.mGm = anonymousClass1;
        handler.postDelayed(anonymousClass1, 600);
    }

    public void onActivityPaused(final Activity activity) {
        x.i("MicroMsg.BaseFrameBeatCore", "[onActivityPaused] foreground:%s", Boolean.valueOf(this.lFv));
        this.mIsPaused = true;
        if (this.mGm != null) {
            this.mMainHandler.removeCallbacks(this.mGm);
        }
        Handler handler = this.mMainHandler;
        Runnable anonymousClass2 = new Runnable() {
            public final void run() {
                if (a.this.lFv && a.this.mIsPaused) {
                    a.this.lFv = false;
                    x.i("MicroMsg.BaseFrameBeatCore", "went background");
                    Iterator it = a.this.mListeners.iterator();
                    while (it.hasNext()) {
                        try {
                            ((a) it.next()).r(activity);
                        } catch (Exception e) {
                            x.e("MicroMsg.BaseFrameBeatCore", "Listener threw exception!", e);
                        }
                    }
                    return;
                }
                x.i("MicroMsg.BaseFrameBeatCore", "still foreground");
            }
        };
        this.mGm = anonymousClass2;
        handler.postDelayed(anonymousClass2, 600);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        x.i("MicroMsg.BaseFrameBeatCore", "Activity:%s", activity.getClass().getSimpleName());
        this.mGl = activity;
        Iterator it = this.mListeners.iterator();
        while (it.hasNext()) {
            try {
                ((a) it.next()).s(activity);
            } catch (Exception e) {
                x.e("MicroMsg.BaseFrameBeatCore", "Listener threw exception!", e);
            }
        }
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }
}
