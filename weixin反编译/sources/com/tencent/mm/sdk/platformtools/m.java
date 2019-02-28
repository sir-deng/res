package com.tencent.mm.sdk.platformtools;

import android.app.ActivityManager;
import android.app.ActivityManager.AppTask;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.PowerManager;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.Iterator;
import java.util.List;

public final class m {
    private static BroadcastReceiver mHF = null;
    private static int xmZ = 0;
    private static int xna = -1;

    public static boolean eK(Context context) {
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            return VERSION.SDK_INT >= 20 ? powerManager.isInteractive() : powerManager.isScreenOn();
        } catch (Throwable e) {
            x.e("MicroMsg.GreenManUtil", "isScreenOn ERROR use isScreenOn e:%s", bi.i(e));
            return false;
        }
    }

    public static synchronized boolean eL(Context context) {
        boolean z = false;
        synchronized (m.class) {
            if (mHF == null) {
                mHF = new BroadcastReceiver() {
                    public final void onReceive(Context context, Intent intent) {
                        if (intent != null) {
                            try {
                                m.xna = intent.getIntExtra(DownloadInfo.STATUS, -1);
                                m.xmZ = intent.getIntExtra("plugged", 0);
                            } catch (Throwable th) {
                            }
                            x.i("MicroMsg.GreenManUtil", "isCharging BroadcastReceiver thread:%d status:%d plugged:%d", Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(m.xna), Integer.valueOf(m.xmZ));
                        }
                    }
                };
                try {
                    Intent registerReceiver = context.registerReceiver(mHF, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                    xna = registerReceiver.getIntExtra(DownloadInfo.STATUS, -1);
                    xmZ = registerReceiver.getIntExtra("plugged", 0);
                } catch (Throwable th) {
                }
            }
            if (xna == 2 || xmZ == 1 || xmZ == 2 || (VERSION.SDK_INT >= 17 && xmZ == 4)) {
                z = true;
            }
        }
        return z;
    }

    public static boolean dg(Context context) {
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.processName.startsWith("com.tencent.mm")) {
                return true;
            }
        }
        return false;
    }

    public static String by(Context context) {
        if (!dg(context)) {
            return "";
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (VERSION.SDK_INT < 23) {
                return ((RunningTaskInfo) activityManager.getRunningTasks(1).get(0)).topActivity.getClassName();
            }
            List appTasks = activityManager.getAppTasks();
            if (appTasks == null || appTasks.size() <= 0) {
                return "";
            }
            Iterator it = appTasks.iterator();
            if (it.hasNext()) {
                ComponentName componentName = ((AppTask) it.next()).getTaskInfo().topActivity;
                if (componentName == null) {
                    return null;
                }
                return componentName.getClassName();
            }
            return "";
        } catch (Throwable e) {
            x.e("MicroMsg.GreenManUtil", "getTopActivityName Exception:%s stack:%s", e.getMessage(), bi.i(e));
        }
    }
}
