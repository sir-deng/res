package com.tencent.mm.plugin.normsg.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RecentTaskInfo;
import android.os.Build.VERSION;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;
import java.util.List;

public final class f {
    public static boolean oZm;

    static {
        oZm = false;
        long nanoTime = System.nanoTime();
        try {
            oZm = false;
            if (VERSION.SDK_INT < 21) {
                oZm = false;
            } else {
                Field declaredField = RecentTaskInfo.class.getDeclaredField("instanceId");
                declaredField.setAccessible(true);
                List recentTasks = ((ActivityManager) ad.getContext().getApplicationContext().getSystemService("activity")).getRecentTasks(1, 2);
                if (recentTasks == null || recentTasks.size() == 0) {
                    oZm = false;
                } else if (declaredField.getInt((RecentTaskInfo) recentTasks.get(0)) > 0) {
                    oZm = true;
                }
            }
            x.i("MicroMsg.NormalMsgSource.QSDTH", "QSDT, result: %b, time: %d ns", Boolean.valueOf(oZm), Long.valueOf(System.nanoTime() - nanoTime));
        } catch (Throwable th) {
            x.i("MicroMsg.NormalMsgSource.QSDTH", "QSDT, result: %b, time: %d ns", Boolean.valueOf(oZm), Long.valueOf(System.nanoTime() - nanoTime));
        }
    }
}
