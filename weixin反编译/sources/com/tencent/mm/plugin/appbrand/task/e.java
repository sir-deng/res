package com.tencent.mm.plugin.appbrand.task;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Process;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.wcdb.FileUtils;
import java.util.LinkedHashMap;
import java.util.List;

class e {
    final String jPN;
    final Class jPO;
    private final Class jPP;
    final LinkedHashMap<String, Integer> jPQ = new LinkedHashMap();
    final LinkedHashMap<String, AppBrandRemoteTaskController> jPR = new LinkedHashMap();

    e(Class cls, Class cls2) {
        this.jPN = cls.getName();
        this.jPO = cls;
        this.jPP = cls2;
    }

    final void EB() {
        if (this.jPP != null) {
            Intent intent = new Intent();
            intent.setClass(ad.getContext(), this.jPP);
            ad.getContext().sendBroadcast(intent);
        }
    }

    final void a(String str, int i, AppBrandRemoteTaskController appBrandRemoteTaskController) {
        this.jPQ.put(str, Integer.valueOf(i));
        this.jPR.put(str, appBrandRemoteTaskController);
    }

    void akO() {
        if (this.jPQ.isEmpty()) {
            ActivityManager activityManager = (ActivityManager) ad.getContext().getSystemService("activity");
            PackageManager packageManager = ad.getContext().getPackageManager();
            if (activityManager != null && packageManager != null) {
                try {
                    String str = packageManager.getActivityInfo(new ComponentName(ad.getContext(), this.jPO), FileUtils.S_IWUSR).processName;
                    List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                    if (runningAppProcesses != null) {
                        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                            if (runningAppProcessInfo.processName.equals(str)) {
                                Process.killProcess(runningAppProcessInfo.pid);
                                return;
                            }
                        }
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    final AppBrandRemoteTaskController uV(String str) {
        return (AppBrandRemoteTaskController) this.jPR.get(str);
    }
}
