package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.c;
import com.tencent.smtt.utils.f;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public final class x {
    private static boolean AhT;
    private static String AhU = null;
    public static boolean AhV = false;
    private static String AhW = null;
    private static int AhX = 0;
    private static String AhY = null;
    private static boolean AhZ = false;
    private static boolean Aia = false;
    private static String Aib = null;
    private static boolean Aic = false;
    private static boolean Aid = false;
    private static Context bks;

    private static void a(Context context, TbsLinuxToolsJni tbsLinuxToolsJni, File file) {
        if (file != null && file.exists() && file.isDirectory()) {
            tbsLinuxToolsJni.gd(file.getAbsolutePath(), "755");
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    if (file2.getAbsolutePath().indexOf(".so") > 0) {
                        tbsLinuxToolsJni.gd(file2.getAbsolutePath(), "755");
                    } else {
                        tbsLinuxToolsJni.gd(file2.getAbsolutePath(), "644");
                    }
                } else if (file2.isDirectory()) {
                    a(context, tbsLinuxToolsJni, file2);
                } else {
                    TbsLog.e("TbsShareManager", "unknown file type.", true);
                }
            }
        }
    }

    private static void b(Context context, String str, String str2, String str3, String str4) {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        Throwable th;
        int i = 0;
        BufferedOutputStream bufferedOutputStream2 = null;
        BufferedInputStream bufferedInputStream2 = null;
        BufferedOutputStream bufferedOutputStream3 = null;
        try {
            File bM = bM(context, "core_info");
            if (bM == null) {
                o.gI(bks).Im(-405);
                if (null != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (Exception e) {
                    }
                }
                if (null != null) {
                    try {
                        bufferedOutputStream3.close();
                        return;
                    } catch (Exception e2) {
                        return;
                    }
                }
                return;
            }
            Properties properties;
            bufferedInputStream2 = new BufferedInputStream(new FileInputStream(bM));
            try {
                properties = new Properties();
                properties.load(bufferedInputStream2);
                try {
                    i = Integer.parseInt(str);
                } catch (Exception e3) {
                }
                if (i != 0) {
                    properties.setProperty("core_version", str);
                    properties.setProperty("core_disabled", "false");
                    properties.setProperty("core_packagename", str2);
                    properties.setProperty("core_path", str3);
                    properties.setProperty("app_version", str4);
                } else {
                    properties.setProperty("core_disabled", "true");
                }
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(bM));
            } catch (Throwable th2) {
                Throwable th3 = th2;
                bufferedOutputStream = null;
                th = th3;
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (Exception e4) {
                    }
                }
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception e5) {
                    }
                }
                throw th;
            }
            try {
                properties.store(bufferedOutputStream, null);
                Aid = false;
                o.gI(bks).Im(-406);
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (Exception e6) {
                    }
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
            } catch (Throwable th4) {
                th = th4;
                if (bufferedInputStream2 != null) {
                    bufferedInputStream2.close();
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th22) {
            bufferedInputStream2 = null;
            th = th22;
            bufferedOutputStream = null;
            if (bufferedInputStream2 != null) {
                bufferedInputStream2.close();
            }
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            throw th;
        }
    }

    private static File bM(Context context, String str) {
        t.cFy();
        File hj = t.hj(context);
        if (hj == null) {
            return null;
        }
        File file = new File(hj, str);
        if (file.exists()) {
            return file;
        }
        try {
            file.createNewFile();
            return file;
        } catch (IOException e) {
            return null;
        }
    }

    private static Context bN(Context context, String str) {
        Context context2 = null;
        try {
            return context.createPackageContext(str, 2);
        } catch (NameNotFoundException e) {
            return context2;
        } catch (Exception e2) {
            return context2;
        }
    }

    public static synchronized void c(Context context, int i, boolean z) {
        BufferedOutputStream bufferedOutputStream;
        Throwable th;
        BufferedOutputStream bufferedOutputStream2 = null;
        synchronized (x.class) {
            if (i == 0) {
                ht(context);
                o.gI(bks).Im(-401);
            } else {
                int hv = hv(context);
                String absolutePath;
                String packageName;
                int appVersionCode;
                if (hv < 0) {
                    o.gI(bks).Im(-402);
                } else if (i == hv) {
                    BufferedInputStream bufferedInputStream = null;
                    BufferedOutputStream bufferedOutputStream3 = null;
                    BufferedInputStream bufferedInputStream2;
                    try {
                        File bM = bM(context, "core_info");
                        if (bM == null) {
                            if (null != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (Exception e) {
                                }
                            }
                            if (null != null) {
                                try {
                                    bufferedOutputStream3.close();
                                } catch (Exception e2) {
                                }
                            }
                            o.gI(bks).Im(-403);
                        } else {
                            Properties properties;
                            bufferedInputStream2 = new BufferedInputStream(new FileInputStream(bM));
                            try {
                                properties = new Properties();
                                properties.load(bufferedInputStream2);
                                properties.setProperty("core_disabled", "false");
                                if (z) {
                                    t.cFy();
                                    absolutePath = t.hi(context).getAbsolutePath();
                                    packageName = context.getApplicationContext().getPackageName();
                                    appVersionCode = c.getAppVersionCode(context);
                                    properties.setProperty("core_packagename", packageName);
                                    properties.setProperty("core_path", absolutePath);
                                    properties.setProperty("app_version", String.valueOf(appVersionCode));
                                }
                                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(bM));
                            } catch (Throwable th2) {
                                Throwable th3 = th2;
                                bufferedOutputStream = null;
                                th = th3;
                                if (bufferedInputStream2 != null) {
                                    try {
                                        bufferedInputStream2.close();
                                    } catch (Exception e3) {
                                    }
                                }
                                if (bufferedOutputStream != null) {
                                    try {
                                        bufferedOutputStream.close();
                                    } catch (Exception e4) {
                                    }
                                }
                                throw th;
                            }
                            try {
                                properties.store(bufferedOutputStream, null);
                                if (bufferedInputStream2 != null) {
                                    try {
                                        bufferedInputStream2.close();
                                    } catch (Exception e5) {
                                    }
                                }
                                if (bufferedOutputStream != null) {
                                    bufferedOutputStream.close();
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                if (bufferedInputStream2 != null) {
                                    bufferedInputStream2.close();
                                }
                                if (bufferedOutputStream != null) {
                                    bufferedOutputStream.close();
                                }
                                throw th;
                            }
                            o.gI(bks).Im(-403);
                        }
                    } catch (Throwable th22) {
                        bufferedInputStream2 = null;
                        th = th22;
                        bufferedOutputStream = null;
                        if (bufferedInputStream2 != null) {
                            bufferedInputStream2.close();
                        }
                        if (bufferedOutputStream != null) {
                            bufferedOutputStream.close();
                        }
                        throw th;
                    }
                } else if (i >= hv || i >= 43300) {
                    File bM2;
                    TbsLinuxToolsJni tbsLinuxToolsJni;
                    Context bN;
                    String[] cFK = cFK();
                    String[] strArr;
                    if (z) {
                        strArr = new String[]{context.getApplicationContext().getPackageName()};
                    } else {
                        strArr = cFK;
                    }
                    if (AhU != null) {
                        t.cFy();
                        if (i == t.abS(AhU)) {
                            b(context, Integer.toString(i), "AppDefined", AhU, Integer.toString(1));
                            try {
                                bM2 = bM(context, "core_info");
                                if (!(Aia || bM2 == null)) {
                                    tbsLinuxToolsJni = new TbsLinuxToolsJni(bks);
                                    tbsLinuxToolsJni.gd(bM2.getAbsolutePath(), "644");
                                    t.cFy();
                                    tbsLinuxToolsJni.gd(t.hj(context).getAbsolutePath(), "755");
                                    Aia = true;
                                }
                            } catch (Throwable th5) {
                            }
                        } else {
                            t.cFy();
                            if (i > t.abS(AhU)) {
                                for (String str : strArr) {
                                    if (i == 0) {
                                        bN = bN(context, str);
                                        t.cFy();
                                        packageName = t.hi(bN).getAbsolutePath();
                                        c.getAppVersionCode(context);
                                        t.cFy();
                                        if (t.gU(bN)) {
                                            try {
                                                f.a(new File(packageName), new File(AhU), new FileFilter() {
                                                    public final boolean accept(File file) {
                                                        return !file.getName().endsWith(".dex");
                                                    }
                                                });
                                                b(context, Integer.toString(i), "AppDefined", AhU, Integer.toString(1));
                                                bM2 = bM(context, "core_info");
                                                if (!(Aia || bM2 == null)) {
                                                    tbsLinuxToolsJni = new TbsLinuxToolsJni(bks);
                                                    tbsLinuxToolsJni.gd(bM2.getAbsolutePath(), "644");
                                                    t.cFy();
                                                    tbsLinuxToolsJni.gd(t.hj(context).getAbsolutePath(), "755");
                                                    Aia = true;
                                                }
                                            } catch (Throwable th6) {
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    for (String absolutePath2 : strArr) {
                        if (i == 0) {
                            bN = bN(context, absolutePath2);
                            t.cFy();
                            packageName = t.hi(bN).getAbsolutePath();
                            appVersionCode = c.getAppVersionCode(context);
                            t.cFy();
                            if (t.gU(bN)) {
                                if (!absolutePath2.equals(context.getApplicationContext().getPackageName())) {
                                    TbsLog.i("TbsShareManager", "thirdAPP pre--> delete old core_share Directory:" + i);
                                    t.cFy();
                                    try {
                                        f.T(t.hi(context));
                                        TbsLog.i("TbsShareManager", "thirdAPP success--> delete old core_share Directory");
                                    } catch (Throwable th7) {
                                    }
                                }
                                b(context, Integer.toString(i), absolutePath2, packageName, Integer.toString(appVersionCode));
                                try {
                                    bM2 = bM(context, "core_info");
                                    if (!(Aia || bM2 == null)) {
                                        tbsLinuxToolsJni = new TbsLinuxToolsJni(bks);
                                        tbsLinuxToolsJni.gd(bM2.getAbsolutePath(), "644");
                                        t.cFy();
                                        tbsLinuxToolsJni.gd(t.hj(context).getAbsolutePath(), "755");
                                        Aia = true;
                                    }
                                } catch (Throwable th8) {
                                }
                            }
                        } else if (i == 0) {
                            bN = bN(context, absolutePath2);
                            t.cFy();
                            packageName = t.hh(bN).getAbsolutePath();
                            appVersionCode = c.getAppVersionCode(context);
                            t.cFy();
                            if (t.gU(bN)) {
                                if (!absolutePath2.equals(context.getApplicationContext().getPackageName())) {
                                    TbsLog.i("TbsShareManager", "thirdAPP pre--> delete old core_share Directory:" + i);
                                    t.cFy();
                                    try {
                                        f.T(t.hi(context));
                                        TbsLog.i("TbsShareManager", "thirdAPP success--> delete old core_share Directory");
                                    } catch (Throwable th9) {
                                    }
                                }
                                b(context, Integer.toString(i), absolutePath2, packageName, Integer.toString(appVersionCode));
                                try {
                                    bM2 = bM(context, "core_info");
                                    if (!(Aia || bM2 == null)) {
                                        tbsLinuxToolsJni = new TbsLinuxToolsJni(bks);
                                        tbsLinuxToolsJni.gd(bM2.getAbsolutePath(), "644");
                                        t.cFy();
                                        tbsLinuxToolsJni.gd(t.hj(context).getAbsolutePath(), "755");
                                        Aia = true;
                                    }
                                } catch (Throwable th10) {
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                } else {
                    ht(context);
                    o.gI(bks).Im(-404);
                }
            }
        }
    }

    public static String cFJ() {
        return AhU;
    }

    public static String[] cFK() {
        return new String[]{"com.tencent.tbs", "com.tencent.mm", "com.tencent.mobileqq", "com.qzone"};
    }

    public static long cFL() {
        String[] cFK = cFK();
        for (int i = 0; i < 4; i++) {
            String str = cFK[i];
            if (!(str.equalsIgnoreCase("com.tencent.mm") || str.equalsIgnoreCase("com.tencent.mobileqq"))) {
                str.equalsIgnoreCase("com.qzone");
            }
        }
        return 0;
    }

    public static boolean cFM() {
        return AhZ;
    }

    static String cFN() {
        return AhW;
    }

    static int cFO() {
        return AhX;
    }

    static int cFP() {
        return AhX;
    }

    public static int cFQ() {
        return AhX;
    }

    public static boolean cFR() {
        return Aic;
    }

    static boolean cFS() {
        TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_UNAVAIL_X5CORE, null, new Object[0]);
        return false;
    }

    static String getTbsResourcesPath(Context context) {
        try {
            hw(context);
            if (AhW == null || TextUtils.isEmpty(AhW)) {
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder(AhW);
            stringBuilder.append(File.separator);
            stringBuilder.append("res.apk");
            return stringBuilder.toString();
        } catch (Throwable th) {
            new StringBuilder("getTbsResourcesPath exception: ").append(Log.getStackTraceString(th));
            return null;
        }
    }

    static void hq(Context context) {
        try {
            TbsLinuxToolsJni tbsLinuxToolsJni = new TbsLinuxToolsJni(context);
            t.cFy();
            a(context, tbsLinuxToolsJni, t.hi(context));
            t.cFy();
            tbsLinuxToolsJni.gd(t.hj(context).getAbsolutePath(), "755");
        } catch (Throwable th) {
        }
    }

    static void hr(Context context) {
        try {
            TbsLinuxToolsJni tbsLinuxToolsJni = new TbsLinuxToolsJni(context);
            t.cFy();
            a(context, tbsLinuxToolsJni, t.hh(context));
        } catch (Throwable th) {
        }
    }

    public static boolean hs(Context context) {
        try {
            if (bks != null && bks.equals(context.getApplicationContext())) {
                return AhT;
            }
            Context applicationContext = context.getApplicationContext();
            bks = applicationContext;
            String packageName = applicationContext.getPackageName();
            String[] cFK = cFK();
            for (int i = 0; i < 4; i++) {
                if (packageName.equals(cFK[i])) {
                    AhT = false;
                    return false;
                }
            }
            AhT = true;
            return true;
        } catch (Throwable th) {
        }
    }

    private static boolean ht(Context context) {
        if (context == null) {
            return false;
        }
        b(context, Integer.toString(0), "", "", Integer.toString(0));
        return true;
    }

    static synchronized String hu(Context context) {
        BufferedInputStream bufferedInputStream;
        String str;
        Throwable th;
        synchronized (x.class) {
            bufferedInputStream = null;
            BufferedInputStream bufferedInputStream2;
            try {
                File bM = bM(context, "core_info");
                if (bM == null) {
                    if (null != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception e) {
                        }
                    }
                    str = null;
                } else {
                    bufferedInputStream2 = new BufferedInputStream(new FileInputStream(bM));
                    try {
                        Properties properties = new Properties();
                        properties.load(bufferedInputStream2);
                        str = properties.getProperty("core_packagename", "");
                        if ("".equals(str)) {
                            if (bufferedInputStream2 != null) {
                                try {
                                    bufferedInputStream2.close();
                                } catch (Exception e2) {
                                }
                            }
                            str = null;
                        } else if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (Exception e3) {
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (Exception e4) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream2 = null;
                if (bufferedInputStream2 != null) {
                    bufferedInputStream2.close();
                }
                throw th;
            }
        }
        return str;
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (Exception e5) {
            }
        }
        str = null;
        return str;
        str = null;
        return str;
    }

    private static synchronized int hv(Context context) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        int i = 0;
        synchronized (x.class) {
            BufferedInputStream bufferedInputStream2 = null;
            BufferedInputStream bufferedInputStream3;
            try {
                File bM = bM(context, "core_info");
                if (bM == null) {
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (Exception e) {
                        }
                    }
                } else {
                    bufferedInputStream3 = new BufferedInputStream(new FileInputStream(bM));
                    try {
                        Properties properties = new Properties();
                        properties.load(bufferedInputStream3);
                        String property = properties.getProperty("core_version", "");
                        if ("".equals(property)) {
                            if (bufferedInputStream3 != null) {
                                bufferedInputStream3.close();
                            }
                        } else {
                            i = Math.max(Integer.parseInt(property), 0);
                            if (bufferedInputStream3 != null) {
                                bufferedInputStream3.close();
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedInputStream3 != null) {
                            try {
                                bufferedInputStream3.close();
                            } catch (Exception e2) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream3 = bufferedInputStream2;
                if (bufferedInputStream3 != null) {
                    bufferedInputStream3.close();
                }
                throw th;
            }
        }
        return i;
    }

    private static synchronized void hw(Context context) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        synchronized (x.class) {
            if (!Aid) {
                BufferedInputStream bufferedInputStream2 = null;
                try {
                    File bM = bM(context, "core_info");
                    if (bM != null) {
                        bufferedInputStream = new BufferedInputStream(new FileInputStream(bM));
                        try {
                            Properties properties = new Properties();
                            properties.load(bufferedInputStream);
                            String property = properties.getProperty("core_version", "");
                            if (!"".equals(property)) {
                                AhX = Math.max(Integer.parseInt(property), 0);
                            }
                            property = properties.getProperty("core_packagename", "");
                            if (!"".equals(property)) {
                                AhY = property;
                            }
                            if (!(AhY == null || bks == null)) {
                                if (AhY.equals(bks.getPackageName())) {
                                    Aic = true;
                                } else {
                                    Aic = false;
                                }
                            }
                            property = properties.getProperty("core_path", "");
                            if (!"".equals(property)) {
                                AhW = property;
                            }
                            property = properties.getProperty("app_version", "");
                            if (!"".equals(property)) {
                                Aib = property;
                            }
                            AhZ = Boolean.parseBoolean(properties.getProperty("core_disabled", "false"));
                            Aid = true;
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                        } catch (Throwable th2) {
                            Throwable th3 = th2;
                            bufferedInputStream2 = bufferedInputStream;
                            th = th3;
                            if (bufferedInputStream2 != null) {
                                try {
                                    bufferedInputStream2.close();
                                } catch (Exception e) {
                                }
                            }
                            throw th;
                        }
                    } else if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (Exception e2) {
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    if (bufferedInputStream2 != null) {
                        bufferedInputStream2.close();
                    }
                    throw th;
                }
            }
        }
        return;
        if (bufferedInputStream != null) {
            bufferedInputStream.close();
        }
        return;
    }

    public static void z(Context context, boolean z) {
        try {
            if (hs(context)) {
                t.cFy();
                File hj = t.hj(context);
                if (hj == null) {
                    return;
                }
                if (!z || !new File(hj, "core_info").exists()) {
                    if (AhU != null) {
                        t.cFy();
                        int abS = t.abS(AhU);
                        if (abS > 0) {
                            AhW = AhU;
                            AhY = "AppDefined";
                            AhX = abS;
                            b(context, Integer.toString(AhX), AhY, AhW, Integer.toString(1));
                            return;
                        }
                    }
                    cFK();
                }
            }
        } catch (Exception e) {
        }
    }
}
