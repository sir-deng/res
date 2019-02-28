package com.tencent.mm.platformtools;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Debug;
import android.os.IBinder;
import android.os.SystemClock;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.pluginsdk.q.s;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Deprecated
public final class t {
    private static final TimeZone GMT = TimeZone.getTimeZone("GMT");
    private static final long[] igQ = new long[]{300, 200, 300, 200};

    public static class a {
        public final String toString() {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            if (stackTrace == null || stackTrace.length < 4) {
                return "";
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 3; i < stackTrace.length; i++) {
                if (stackTrace[i].getClassName().contains("com.tencent.mm")) {
                    stringBuilder.append("[");
                    stringBuilder.append(stackTrace[i].getClassName().substring(15));
                    stringBuilder.append(":");
                    stringBuilder.append(stackTrace[i].getMethodName());
                    stringBuilder.append("(" + stackTrace[i].getLineNumber() + ")]");
                }
            }
            return stringBuilder.toString();
        }
    }

    public static String oL(String str) {
        if (str != null) {
            return str.replace("\\[", "[[]").replace("%", "").replace("\\^", "").replace("'", "").replace("\\{", "").replace("\\}", "").replace("\"", "");
        }
        return str;
    }

    public static String d(List<String> list, String str) {
        if (list == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder("");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return stringBuilder.toString();
            }
            if (i2 == list.size() - 1) {
                stringBuilder.append(((String) list.get(i2)).trim());
            } else {
                stringBuilder.append(((String) list.get(i2)).trim() + str);
            }
            i = i2 + 1;
        }
    }

    public static List<String> g(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        List<String> arrayList = new ArrayList();
        for (Object add : strArr) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public static String by(long j) {
        if ((j >> 20) > 0) {
            return (((float) Math.round((((float) j) * 10.0f) / 1048576.0f)) / 10.0f) + "MB";
        } else if ((j >> 9) <= 0) {
            return j + "B";
        } else {
            return (((float) Math.round((((float) j) * 10.0f) / 1024.0f)) / 10.0f) + "KB";
        }
    }

    public static long Wx() {
        return System.currentTimeMillis() / 1000;
    }

    public static String iZ(int i) {
        return String.format("%d:%02d", new Object[]{Long.valueOf(((long) i) / 60), Long.valueOf(((long) i) % 60)});
    }

    public static long Wy() {
        return System.currentTimeMillis();
    }

    public static long bz(long j) {
        return (System.currentTimeMillis() / 1000) - j;
    }

    public static long bA(long j) {
        return System.currentTimeMillis() - j;
    }

    public static long bB(long j) {
        return SystemClock.elapsedRealtime() - j;
    }

    public static long Wz() {
        return SystemClock.elapsedRealtime();
    }

    public static boolean bF(Context context) {
        String name = context.getClass().getName();
        String by = by(context);
        x.d("MicroMsg.Util", "top activity=" + by + ", context=" + name);
        return by.equalsIgnoreCase(name);
    }

    private static String by(Context context) {
        try {
            String className = ((RunningTaskInfo) ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName();
            x.i("MicroMsg.Util", "top activity name =" + className);
            return className;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
            return "(null)";
        }
    }

    private static boolean k(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    public static boolean ja(int i) {
        long j = ((long) i) * 1000;
        long currentTimeMillis = j - System.currentTimeMillis();
        x.d("MicroMsg.Util", "time " + j + "  systime " + System.currentTimeMillis() + " diff " + currentTimeMillis);
        if (currentTimeMillis < 0) {
            return true;
        }
        return false;
    }

    public static void WA() {
        x.w("MicroMsg.Util", "memory usage: h=%s/%s, e=%s/%s, n=%s/%s", by((long) Debug.getGlobalAllocSize()), by((long) (Debug.getGlobalAllocSize() + Debug.getGlobalFreedSize())), by((long) Debug.getGlobalExternalAllocSize()), by((long) (Debug.getGlobalExternalAllocSize() + Debug.getGlobalExternalFreedSize())), by(Debug.getNativeHeapAllocatedSize()), by(Debug.getNativeHeapSize()));
    }

    public static int e(Integer num) {
        return num == null ? 0 : num.intValue();
    }

    public static long c(Long l) {
        return l == null ? 0 : l.longValue();
    }

    public static String oM(String str) {
        return str == null ? "" : str;
    }

    public static boolean b(Boolean bool) {
        return bool == null ? true : bool.booleanValue();
    }

    public static boolean c(Boolean bool) {
        return bool == null ? false : bool.booleanValue();
    }

    public static int f(Integer num) {
        return num == null ? 0 : num.intValue();
    }

    public static long d(Long l) {
        return l == null ? 0 : l.longValue();
    }

    public static boolean d(Boolean bool) {
        return bool == null ? true : bool.booleanValue();
    }

    public static String aD(String str, String str2) {
        return str == null ? str2 : str;
    }

    public static int aV(Object obj) {
        if (obj == null) {
            return 0;
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (obj instanceof Long) {
            return ((Long) obj).intValue();
        }
        return 0;
    }

    public static boolean oN(String str) {
        if (str == null || str.length() <= 0) {
            return true;
        }
        return false;
    }

    @Deprecated
    public static int getInt(String str, int i) {
        if (str == null) {
            return i;
        }
        try {
            if (str.length() <= 0) {
                return i;
            }
            return Integer.parseInt(str);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
            return i;
        }
    }

    @Deprecated
    public static long oO(String str) {
        long j = -1;
        if (str == null) {
            return j;
        }
        try {
            return Long.parseLong(str);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
            return j;
        }
    }

    public static boolean F(Context context, String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        if (k(context, intent)) {
            context.startActivity(intent);
            return true;
        }
        x.e("MicroMsg.Util", "jump to url failed, " + str);
        return false;
    }

    public static boolean bs(int i, int i2) {
        return ((double) i2) > ((double) i) * 2.0d;
    }

    public static boolean bt(int i, int i2) {
        return ((double) i) > ((double) i2) * 2.0d;
    }

    public static a WB() {
        return new a();
    }

    public static List<String> aE(String str, String str2) {
        List<String> list = null;
        if (str != null) {
            Matcher matcher = Pattern.compile(str2).matcher(str);
            int groupCount = matcher.groupCount();
            list = new ArrayList();
            if (matcher.find()) {
                for (int i = 1; i <= groupCount; i++) {
                    list.add(matcher.group(i));
                }
            }
        }
        return list;
    }

    public static boolean bG(Context context) {
        if (q.x.bYQ() != null) {
            q.x.bYQ().bpe();
        }
        if ((f.fek & 1) != 0) {
            x.e("MicroMsg.Util", "package has set external update mode");
            Uri parse = Uri.parse(f.xmS);
            Intent addFlags = new Intent("android.intent.action.VIEW", parse).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            if (parse == null || addFlags == null || !k(context, addFlags)) {
                x.e("MicroMsg.Util", "parse market uri failed, jump to weixin.qq.com");
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://weixin.qq.com")).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY));
                return true;
            }
            x.i("MicroMsg.Util", "parse market uri ok");
            context.startActivity(addFlags);
            return true;
        }
        ad.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", System.currentTimeMillis() / 1000).commit();
        if (q.x.bYQ() == null) {
            return true;
        }
        s a = q.x.bYQ().a(context, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        if (a == null) {
            return false;
        }
        a.update(3);
        return true;
    }

    public static boolean a(Context context, View view) {
        if (view == null) {
            return false;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager == null) {
            return false;
        }
        IBinder windowToken = view.getWindowToken();
        if (windowToken == null) {
            return false;
        }
        boolean hideSoftInputFromWindow;
        try {
            hideSoftInputFromWindow = inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        } catch (IllegalArgumentException e) {
            x.e("MicroMsg.Util", "hide VKB(View) exception %s", e);
            hideSoftInputFromWindow = false;
        }
        return hideSoftInputFromWindow;
    }
}
