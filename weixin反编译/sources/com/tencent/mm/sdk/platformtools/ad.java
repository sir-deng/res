package com.tencent.mm.sdk.platformtools;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;

public final class ad {
    private static Context context = null;
    private static String ffM = "com.tencent.mm";
    private static volatile Resources mResources = null;
    private static String processName = ffM;
    private static String xnJ = "com.tencent.mm";
    private static String xnK = "com.tencent.mm.ui.LauncherUI";
    private static boolean xnL = false;
    public static boolean xnM = false;
    private static ActivityManager xnN = null;

    public static void lH(boolean z) {
        xnL = z;
    }

    public static boolean cgc() {
        return xnL;
    }

    public static String cgd() {
        return xnK;
    }

    public static void setContext(Context context) {
        context = context;
        ffM = context.getPackageName();
        x.d("MicroMsg.MMApplicationContext", "setup application context for package: " + ffM);
    }

    public static Context getContext() {
        return context;
    }

    public static String getPackageName() {
        return ffM;
    }

    public static String cge() {
        return xnJ;
    }

    public static String cgf() {
        return ffM + "_preferences";
    }

    public static SharedPreferences cgg() {
        if (context != null) {
            return context.getSharedPreferences(cgf(), 0);
        }
        return null;
    }

    public static SharedPreferences cgh() {
        if (context != null) {
            return context.getSharedPreferences(ffM + "_preferences_tools", 0);
        }
        return null;
    }

    public static String cgi() {
        return ffM + "_tmp_preferences";
    }

    public static String By() {
        return processName;
    }

    public static void VG(String str) {
        processName = str;
    }

    public static boolean cgj() {
        Object obj = processName;
        if (obj == null || obj.length() == 0) {
            obj = ffM;
        }
        return ffM.equals(obj);
    }

    public static boolean cgk() {
        String str = processName;
        if (str == null || str.length() == 0) {
            str = ffM;
        }
        return "com.tencent.mm:push".equalsIgnoreCase(str);
    }

    public static boolean cgl() {
        String str = processName;
        if (str == null || str.length() == 0) {
            str = ffM;
        }
        return "com.tencent.mm:tools".equalsIgnoreCase(str);
    }

    public static boolean cgm() {
        String str = processName;
        if (str == null || str.length() == 0) {
            str = ffM;
        }
        return "com.tencent.mm:exdevice".equalsIgnoreCase(str);
    }

    public static boolean cgn() {
        return VH(ffM);
    }

    private static boolean VH(String str) {
        if (context == null || ffM == null) {
            return false;
        }
        if (xnN == null) {
            xnN = (ActivityManager) context.getSystemService("activity");
        }
        try {
            for (RunningAppProcessInfo runningAppProcessInfo : xnN.getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            x.e("MicroMsg.MMApplicationContext", "isMMProcessExist Exception: " + e.toString());
            return false;
        } catch (Error e2) {
            x.e("MicroMsg.MMApplicationContext", "isMMProcessExist Error: " + e2.toString());
            return false;
        }
    }

    public static Resources getResources() {
        return mResources;
    }

    public static void a(Resources resources) {
        mResources = resources;
    }
}
