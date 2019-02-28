package com.tencent.tinker.lib.f;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.os.Process;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.util.List;

public final class b extends ShareTinkerInternals {
    private static String Aso = null;

    public static void is(Context context) {
        String iu = iu(context);
        if (iu != null) {
            List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.processName.equals(iu)) {
                        Process.killProcess(runningAppProcessInfo.pid);
                    }
                }
            }
        }
    }

    public static boolean it(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        String iu = iu(context);
        if (iu == null) {
            return false;
        }
        try {
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.equals(iu)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            new StringBuilder("isTinkerPatchServiceRunning Exception: ").append(e.toString());
            return false;
        } catch (Error e2) {
            new StringBuilder("isTinkerPatchServiceRunning Error: ").append(e2.toString());
            return false;
        }
    }

    private static String iu(Context context) {
        if (Aso != null) {
            return Aso;
        }
        String b = b(context, TinkerPatchService.class);
        if (b == null) {
            return null;
        }
        Aso = b;
        return b;
    }

    public static boolean iv(Context context) {
        String iK = ShareTinkerInternals.iK(context);
        String iu = iu(context);
        if (iu == null || iu.length() == 0) {
            return false;
        }
        return iK.equals(iu);
    }

    private static String b(Context context, Class<? extends Service> cls) {
        try {
            return context.getPackageManager().getServiceInfo(new ComponentName(context, cls), 0).processName;
        } catch (Throwable th) {
            return null;
        }
    }
}
