package com.tencent.mm.plugin.appbrand.r;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.e.h;
import com.tencent.mm.vending.h.g;
import com.tencent.wcdb.FileUtils;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public final class c {
    private static volatile ah hoG;
    private static final char[] jXA = new char[]{'<', '>', '\"', '\'', '&', ' ', '\''};
    private static final String[] jXB = new String[]{"&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "&nbsp;", "&#39;"};
    private static final Object jXz = new Object();
    private static final Set<Object> jeP = new HashSet();

    public static void amo() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(h.xMS, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
        ad.getContext().sendBroadcast(intent);
    }

    public static long amp() {
        return bi.Wx();
    }

    public static String getMMString(int i, Object... objArr) {
        return ad.getResources().getString(i, objArr);
    }

    public static <T> T bk(T t) {
        if (t != null) {
            jeP.add(t);
        }
        return t;
    }

    public static void bl(Object obj) {
        if (obj != null) {
            jeP.remove(obj);
        }
    }

    public static void amq() {
        if (hoG != null) {
            synchronized (jXz) {
                if (hoG != null) {
                    g.aaY("SubCoreAppBrand#WorkerThread");
                    hoG.oFY.quit();
                    hoG = null;
                }
            }
        }
    }

    public static ah Dt() {
        if (hoG == null) {
            synchronized (jXz) {
                if (hoG == null) {
                    hoG = new ah("SubCoreAppBrand#WorkerThread");
                    g.a("SubCoreAppBrand#WorkerThread", new com.tencent.mm.vending.h.h(hoG.oFY.getLooper(), "SubCoreAppBrand#WorkerThread"));
                }
            }
        }
        return hoG;
    }

    public static void runOnUiThread(Runnable runnable) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            ah.y(runnable);
        } else {
            runnable.run();
        }
    }

    public static void m(Map map) {
        for (Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if ((key instanceof String) && (value instanceof Map)) {
                m((Map) value);
                map.put(key, new JSONObject((Map) value));
            }
        }
    }

    public static String vk(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        int i = 0;
        while (i < length) {
            int i2 = 0;
            while (i2 < jXA.length) {
                String str2 = jXB[i2];
                int i3 = 0;
                while (i3 < str2.length() && i + i3 < length && str2.charAt(i3) == str.charAt(i + i3)) {
                    i3++;
                }
                if (i3 == str2.length()) {
                    break;
                }
                i2++;
            }
            if (i2 != jXA.length) {
                stringBuffer.append(jXA[i2]);
                i = jXB[i2].length() + i;
            } else {
                stringBuffer.append(str.charAt(i));
                i++;
            }
        }
        return stringBuffer.toString();
    }

    public static String vl(String str) {
        if (str == null) {
            return null;
        }
        return str.replace(8232, 10).replace(8233, 10);
    }

    public static String b(ComponentName componentName) {
        String str = "[UNKNOWN]";
        if (componentName == null) {
            return str;
        }
        PackageManager packageManager = ad.getContext().getPackageManager();
        if (packageManager == null) {
            return str;
        }
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, FileUtils.S_IWUSR);
            if (activityInfo != null) {
                return activityInfo.taskAffinity;
            }
            return str;
        } catch (Exception e) {
            x.e("MicroMsg.AppBrandUtil", "getActivityTaskAffinity e = %s", e);
            return str;
        }
    }

    public static int c(Context context, float f) {
        return Math.round(context.getResources().getDisplayMetrics().density * f);
    }
}
