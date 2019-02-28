package com.google.android.gms.analytics;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.google.android.gms.analytics.internal.ah;
import com.google.android.gms.analytics.internal.f;
import com.google.android.gms.analytics.internal.k;
import com.google.android.gms.analytics.internal.q;
import com.google.android.gms.c.as;
import com.google.android.gms.common.internal.w;

public final class AnalyticsService extends Service {
    private static Boolean aEz;
    private final Handler mHandler = new Handler();

    public static boolean z(Context context) {
        w.ag(context);
        if (aEz != null) {
            return aEz.booleanValue();
        }
        boolean a = k.a(context, AnalyticsService.class);
        aEz = Boolean.valueOf(a);
        return a;
    }

    public final IBinder onBind(Intent intent) {
        return null;
    }

    public final void onCreate() {
        super.onCreate();
        f mT = q.A(this).mT();
        if (com.google.android.gms.common.internal.f.aNs) {
            mT.au("Device AnalyticsService is starting up");
        } else {
            mT.au("Local AnalyticsService is starting up");
        }
    }

    public final void onDestroy() {
        f mT = q.A(this).mT();
        if (com.google.android.gms.common.internal.f.aNs) {
            mT.au("Device AnalyticsService is shutting down");
        } else {
            mT.au("Local AnalyticsService is shutting down");
        }
        super.onDestroy();
    }

    public final int onStartCommand(Intent intent, int i, final int i2) {
        try {
            synchronized (AnalyticsReceiver.aEw) {
                as asVar = AnalyticsReceiver.aEx;
                if (asVar != null && asVar.aZf.isHeld()) {
                    asVar.release();
                }
            }
        } catch (SecurityException e) {
        }
        final q A = q.A(this);
        final f mT = A.mT();
        String action = intent.getAction();
        if (com.google.android.gms.common.internal.f.aNs) {
            mT.a("Device AnalyticsService called. startId, action", Integer.valueOf(i2), action);
        } else {
            mT.a("Local AnalyticsService called. startId, action", Integer.valueOf(i2), action);
        }
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            A.mV().a(new ah() {
                public final void md() {
                    AnalyticsService.this.mHandler.post(new Runnable() {
                        public final void run() {
                            if (!AnalyticsService.this.stopSelfResult(i2)) {
                                return;
                            }
                            if (com.google.android.gms.common.internal.f.aNs) {
                                mT.au("Device AnalyticsService processed last dispatch request");
                            } else {
                                mT.au("Local AnalyticsService processed last dispatch request");
                            }
                        }
                    });
                }
            });
        }
        return 2;
    }
}
