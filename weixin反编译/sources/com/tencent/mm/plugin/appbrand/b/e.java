package com.tencent.mm.plugin.appbrand.b;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.FileUtils;
import java.lang.ref.WeakReference;

public abstract class e {
    final WeakReference<Activity> iKr;
    public final BroadcastReceiver iKv = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            if (intent != null && "android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                c.Dt().F(new Runnable() {
                    public final void run() {
                        e eVar = e.this;
                        Activity activity = (Activity) eVar.iKr.get();
                        if (activity != null) {
                            PackageManager packageManager = activity.getPackageManager();
                            ActivityManager activityManager = (ActivityManager) activity.getSystemService("activity");
                            RunningTaskInfo ah = bi.ah(activity, activity.getTaskId());
                            if (ah != null) {
                                try {
                                    ComponentName componentName = ah.topActivity;
                                    if (componentName != null && activityManager != null && packageManager != null) {
                                        ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, FileUtils.S_IWUSR);
                                        if (activityInfo != null) {
                                            for (RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                                                if ((runningAppProcessInfo.importance == 100 || runningAppProcessInfo.importance == 150) && ((componentName.equals(runningAppProcessInfo.importanceReasonComponent) || runningAppProcessInfo.importanceReasonCode == 0) && runningAppProcessInfo.processName.equals(activityInfo.processName))) {
                                                    eVar.aaN();
                                                    return;
                                                }
                                            }
                                        }
                                    }
                                } catch (Exception e) {
                                    x.e("MicroMsg.BaseAppBrandUIScreenOffReceiver", "ScreenOff try confirm task top ui status, e = " + e);
                                }
                            }
                        }
                    }
                });
            }
        }
    };

    public abstract void aaN();

    public e(Activity activity) {
        this.iKr = new WeakReference(activity);
    }
}
