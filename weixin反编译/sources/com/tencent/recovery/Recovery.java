package com.tencent.recovery;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.recovery.handler.RecoveryMessageHandler;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.option.OptionFactory;
import com.tencent.recovery.util.Util;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

public class Recovery {
    private static RecoveryMessageHandler Aap;
    private static long Aaq;
    private static String Aar;
    private static boolean Aas = false;
    private static boolean Aat = false;
    private static int Aau = 0;
    private static ActivityLifecycleCallbacks Aav = new ActivityLifecycleCallbacks() {
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            if (!Recovery.Aat && !Recovery.Aap.hasMessages(3)) {
                Recovery.Aap.removeCallbacksAndMessages(null);
                String gn = Util.gn(Recovery.context);
                Editor edit = Recovery.context.getSharedPreferences(Recovery.Aar, 0).edit();
                edit.putInt("KeyComponentOnCreateForeground", 1);
                edit.putInt("KeyComponentOnCreateExceptionType", Downloads.RECV_BUFFER_SIZE);
                edit.apply();
                Recovery.Aap.sendEmptyMessageDelayed(3, (long) OptionFactory.dI(gn, 1).gLT);
                RecoveryLog.i("Recovery", "%s markActivityOnCreated %s", gn, Long.valueOf(System.currentTimeMillis() - Recovery.Aaq));
            }
        }

        public final void onActivityStarted(Activity activity) {
            Recovery.cEa();
        }

        public final void onActivityResumed(Activity activity) {
        }

        public final void onActivityPaused(Activity activity) {
        }

        public final void onActivityStopped(Activity activity) {
            Recovery.cEb();
            if (Recovery.Aau == 0) {
                RecoveryLog.i("Recovery", "%s onActivityStopped: activityForegroundCount is 0", Util.gn(Recovery.context));
                Recovery.Id(16);
            }
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityDestroyed(Activity activity) {
        }
    };
    private static Application application;
    private static Context context;

    static /* synthetic */ int cEa() {
        int i = Aau;
        Aau = i + 1;
        return i;
    }

    static /* synthetic */ int cEb() {
        int i = Aau;
        Aau = i - 1;
        return i;
    }

    public static void cDU() {
        if (!Aat && !Aas) {
            Aas = true;
            String gn = Util.gn(context);
            int bA = RecoveryLogic.bA(context, gn);
            RecoveryLog.i("Recovery", "%s markApplicationOnCreateNormal %d", gn, Long.valueOf(System.currentTimeMillis() - Aaq));
            Editor edit = context.getSharedPreferences(Aar, 0).edit();
            edit.remove("KeyAppOnCreateExceptionType");
            edit.putInt("KeyAppOnCreateNormalType", 256);
            if (RecoveryLogic.bA(context, gn) == 16) {
                edit.putInt("KeyComponentOnCreateForeground", bA);
                edit.putInt("KeyComponentOnCreateExceptionType", Downloads.RECV_BUFFER_SIZE);
                Aap.sendEmptyMessageDelayed(2, (long) OptionFactory.dI(gn, bA).gLT);
            }
            edit.apply();
        }
    }

    private static void destroy() {
        if (application != null) {
            application.unregisterActivityLifecycleCallbacks(Aav);
        }
    }

    public static void cDV() {
        if (context != null && !Aat) {
            cDX();
            RecoveryLog.i("Recovery", "%s Recovery.crash %d", Util.gn(context), Long.valueOf(System.currentTimeMillis() - Aaq));
            Editor edit = context.getSharedPreferences(Aar, 0).edit();
            if (Aas) {
                edit.putInt("KeyComponentOnCreateExceptionType", 65536);
            } else {
                edit.putInt("KeyAppOnCreateExceptionType", 65536);
            }
            edit.apply();
            destroy();
        }
    }

    public static void cDW() {
        if (context != null && !Aat) {
            cDX();
            RecoveryLog.i("Recovery", "%s Recovery.anr %d", Util.gn(context), Long.valueOf(System.currentTimeMillis() - Aaq));
            Editor edit = context.getSharedPreferences(Aar, 0).edit();
            if (Aas) {
                edit.putInt("KeyComponentOnCreateExceptionType", 1048576);
            } else {
                edit.putInt("KeyAppOnCreateExceptionType", 1048576);
            }
            edit.apply();
            destroy();
        }
    }

    public static void Id(int i) {
        if (context != null && !Aat) {
            cDX();
            String gn = Util.gn(context);
            SharedPreferences sharedPreferences = context.getSharedPreferences(Aar, 0);
            RecoveryLog.i("Recovery", "%s Recovery.normal %s %d", gn, Integer.toHexString(i), Long.valueOf(System.currentTimeMillis() - Aaq));
            Aap.removeCallbacksAndMessages(null);
            Editor edit = sharedPreferences.edit();
            edit.remove("KeyComponentOnCreateExceptionType");
            edit.putInt("KeyComponentOnCreateNormalType", i);
            edit.apply();
            destroy();
        }
    }

    public static Context getContext() {
        return context;
    }

    private static void cDX() {
        if (context != null && !Aat) {
            RecoveryLog.i("Recovery", "%s markFinalStatus", Util.gn(context));
            Aat = true;
        }
    }
}
