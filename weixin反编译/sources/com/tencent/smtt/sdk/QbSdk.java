package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.ValueCallback;
import android.webkit.WebIconDatabase;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewDatabase;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.appbrand.jsapi.au;
import com.tencent.mm.plugin.appbrand.jsapi.bq;
import com.tencent.mm.plugin.appbrand.jsapi.contact.e;
import com.tencent.mm.plugin.appbrand.jsapi.media.f;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.d;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetOpenDeviceId;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.c;
import com.tencent.smtt.utils.o;
import com.tencent.smtt.utils.t;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.xwalk.core.XWalkUpdater;

@SuppressLint({"NewApi"})
public class QbSdk {
    private static int AeR = 0;
    private static String AeS = "";
    private static Class<?> AeT = null;
    private static Object AeU = null;
    static boolean AeV = false;
    static boolean AeW = false;
    static boolean AeX = true;
    private static boolean AeY = false;
    private static String[] AeZ = null;
    private static String Afa = "NULL";
    private static String Afb = "UNKNOWN";
    static String Afc = null;
    static boolean Afd = false;
    static long Afe = 0;
    static Object Aff = new Object();
    static boolean Afg = true;
    private static int Afh = 0;
    private static int Afi = 170;
    private static String Afj = null;
    private static String Afk = null;
    static volatile boolean Afl = AeV;
    private static boolean Afm = true;
    private static u Afn = null;
    private static u Afo = null;
    private static boolean Afp = false;
    private static boolean Afq = false;
    static u Afr = new u() {
        public final void lQ(int i) {
            if (p.cFj()) {
                TbsLog.i("QbSdk", "onDownloadFinish needDownloadDecoupleCore is true", true);
                p.AgG = true;
                return;
            }
            TbsLog.i("QbSdk", "onDownloadFinish needDownloadDecoupleCore is false", true);
            p.AgG = false;
            if (QbSdk.Afn != null) {
                QbSdk.Afn.lQ(i);
            }
            if (QbSdk.Afo != null) {
                QbSdk.Afo.lQ(i);
            }
        }

        public final void lR(int i) {
            QbSdk.setTBSInstallingStatus(false);
            p.AgG = false;
            if (p.cFk()) {
                p.AgG = true;
            } else {
                p.AgG = false;
            }
            if (QbSdk.Afn != null) {
                QbSdk.Afn.lR(i);
            }
            if (QbSdk.Afo != null) {
                QbSdk.Afo.lR(i);
            }
        }

        public final void lg(int i) {
            if (QbSdk.Afo != null) {
                QbSdk.Afo.lg(i);
            }
            if (QbSdk.Afn != null) {
                QbSdk.Afn.lg(i);
            }
        }
    };
    static Map<String, Object> Afs = null;
    public static final int EXTENSION_INIT_FAILURE = -99999;
    public static final String LOGIN_TYPE_KEY_PARTNER_CALL_POS = "PosID";
    public static final String LOGIN_TYPE_KEY_PARTNER_ID = "ChannelID";
    public static final String PARAM_KEY_FEATUREID = "param_key_featureid";
    public static final String PARAM_KEY_FUNCTIONID = "param_key_functionid";
    public static final String PARAM_KEY_POSITIONID = "param_key_positionid";
    public static final int QBMODE = 2;
    public static final String SVNVERSION = "jnizz";
    public static final int TBSMODE = 1;
    public static final String TID_QQNumber_Prefix = "QQ:";
    public static final int VERSION = 1;
    public static boolean sIsVersionPrinted = false;
    static long sWifiConnectedTime = 0;

    public interface a {
        void kX(boolean z);

        void tI();
    }

    static boolean am(Context context, int i) {
        if (gA(context)) {
            Object b = o.b(AeU, "isX5Disabled", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE}, Integer.valueOf(i), Integer.valueOf(43603), Integer.valueOf(HardCoderJNI.sHCENCODEVIDEOTIMEOUT));
            if (b != null) {
                return ((Boolean) b).booleanValue();
            }
            b = o.b(AeU, "isX5Disabled", new Class[]{Integer.TYPE, Integer.TYPE}, Integer.valueOf(i), Integer.valueOf(43603));
            if (b != null) {
                return ((Boolean) b).booleanValue();
            }
        }
        return true;
    }

    static Object b(Context context, String str, Bundle bundle) {
        if (!gz(context)) {
            return Integer.valueOf(EXTENSION_INIT_FAILURE);
        }
        Object b = o.b(AeU, "miscCall", new Class[]{String.class, Bundle.class}, str, bundle);
        return b == null ? null : b;
    }

    static synchronized void bG(Context context, String str) {
        synchronized (QbSdk.class) {
            if (!AeV) {
                AeV = true;
                Afb = "forceSysWebViewInner: " + str;
                TbsLog.e("QbSdk", "QbSdk.SysWebViewForcedInner..." + Afb);
                m.cEY().a(context, 401, new Throwable(Afb));
            }
        }
    }

    static String cEK() {
        return AeS;
    }

    protected static String cEL() {
        af cFZ = af.cFZ();
        if (cFZ != null && cFZ.cGa()) {
            Object invokeStaticMethod = cFZ.cGb().Ain.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getGUID", new Class[0], new Object[0]);
            if (invokeStaticMethod != null && (invokeStaticMethod instanceof String)) {
                return (String) invokeStaticMethod;
            }
        }
        return null;
    }

    public static boolean canLoadVideo(Context context) {
        Object b = o.b(AeU, "canLoadVideo", new Class[]{Integer.TYPE}, Integer.valueOf(0));
        if (b == null) {
            m.cEY().ao(context, d.CTRL_INDEX);
        } else if (!((Boolean) b).booleanValue()) {
            m.cEY().ao(context, bq.CTRL_INDEX);
        }
        return b == null ? false : ((Boolean) b).booleanValue();
    }

    public static boolean canLoadX5(Context context) {
        return r(context, false);
    }

    public static boolean canLoadX5FirstTimeThirdApp(Context context) {
        try {
            if (AeT == null) {
                t.cFy();
                File hi = t.hi(context);
                if (hi == null) {
                    TbsLog.e("QbSdk", "QbSdk canLoadX5FirstTimeThirdApp (false) optDir == null");
                    return false;
                }
                File file = new File(x.cFN(), "tbs_sdk_extension_dex.jar");
                if (file.exists()) {
                    String cFJ = x.cFJ() != null ? x.cFJ() : hi.getAbsolutePath();
                    TbsLog.i("QbSdk", "QbSdk init optDirExtension #2 is " + cFJ);
                    AeT = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, cFJ, null).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                } else {
                    TbsLog.e("QbSdk", "QbSdk canLoadX5FirstTimeThirdApp (false) dexFile.exists()=false", true);
                    return false;
                }
            }
            if (AeU == null) {
                if (x.cFJ() == null) {
                    v.hp(context.getApplicationContext()).bj(GameJsApiGetOpenDeviceId.CTRL_BYTE, "host context is null!");
                    return false;
                }
                AeT.getConstructor(new Class[]{Context.class, Context.class});
                AeU = AeT.getConstructor(new Class[]{Context.class, Context.class, String.class}).newInstance(new Object[]{context, null, x.cFJ()});
            }
            Object b = o.b(AeU, "canLoadX5CoreForThirdApp", new Class[0], new Object[0]);
            return (b == null || !(b instanceof Boolean)) ? false : ((Boolean) b).booleanValue();
        } catch (Throwable th) {
            TbsLog.e("QbSdk", "canLoadX5FirstTimeThirdApp sys WebView: " + Log.getStackTraceString(th));
            return false;
        }
    }

    public static void canOpenFile(final Context context, final String str, final ab<Boolean> abVar) {
        new Thread() {
            public final void run() {
                boolean booleanValue;
                af cFZ = af.cFZ();
                cFZ.b(context, null);
                if (cFZ.cGa()) {
                    ag cGb = cFZ.cGb();
                    Context context = context;
                    String str = str;
                    Object invokeStaticMethod = cGb.Ain.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "canOpenFile", new Class[]{Context.class, String.class}, context, str);
                    booleanValue = invokeStaticMethod instanceof Boolean ? ((Boolean) invokeStaticMethod).booleanValue() : false;
                } else {
                    booleanValue = false;
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        abVar.onReceiveValue(Boolean.valueOf(booleanValue));
                    }
                });
            }
        }.start();
    }

    public static boolean canOpenMimeFileType(Context context, String str) {
        return !q(context, false) ? false : false;
    }

    public static boolean canOpenWebPlus(Context context) {
        boolean z;
        Throwable th;
        BufferedInputStream bufferedInputStream;
        InputStream inputStream = null;
        if (Afh == 0) {
            Afh = a.cEH();
        }
        TbsLog.i("QbSdk", "canOpenWebPlus - totalRAM: " + Afh);
        if (VERSION.SDK_INT < 7 || Afh < Afi || context == null) {
            return false;
        }
        BufferedInputStream bufferedInputStream2;
        try {
            t.cFy();
            bufferedInputStream2 = new BufferedInputStream(new FileInputStream(new File(t.hi(context), "tbs.conf")));
            try {
                Properties properties = new Properties();
                properties.load(bufferedInputStream2);
                String property = properties.getProperty("android_sdk_max_supported");
                String property2 = properties.getProperty("android_sdk_min_supported");
                int parseInt = Integer.parseInt(property);
                int parseInt2 = Integer.parseInt(property2);
                int parseInt3 = Integer.parseInt(VERSION.SDK);
                if (parseInt3 > parseInt || parseInt3 < parseInt2) {
                    TbsLog.i("QbSdk", "canOpenWebPlus - sdkVersion: " + parseInt3);
                    try {
                        bufferedInputStream2.close();
                        return false;
                    } catch (Exception e) {
                        return false;
                    }
                }
                parseInt = Integer.parseInt(properties.getProperty("tbs_core_version"));
                try {
                    bufferedInputStream2.close();
                } catch (Exception e2) {
                }
                InputStream fileInputStream;
                try {
                    fileInputStream = new FileInputStream(new File(t.hk(context), "tbs_extension.conf"));
                    try {
                        Properties properties2 = new Properties();
                        properties2.load(fileInputStream);
                        int parseInt4 = Integer.parseInt(properties2.getProperty("tbs_local_version"));
                        parseInt2 = Integer.parseInt(properties2.getProperty("app_versioncode_for_switch"));
                        if (parseInt == 88888888 || parseInt4 == 88888888) {
                            z = false;
                        } else if (parseInt > parseInt4) {
                            z = false;
                        } else if (parseInt == parseInt4) {
                            if (parseInt2 > 0) {
                                if (parseInt2 != c.getAppVersionCode(context)) {
                                    z = false;
                                }
                            }
                            z = Boolean.parseBoolean(properties2.getProperty("x5_disabled")) && !o.gI(context.getApplicationContext()).Agy.getBoolean("switch_backupcore_enable", false);
                        } else {
                            z = false;
                        }
                        try {
                            fileInputStream.close();
                        } catch (Exception e3) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e4) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = null;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
                if (z) {
                }
            } catch (Throwable th4) {
            }
        } catch (Throwable th5) {
            th = th5;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            throw th;
        }
    }

    public static boolean canUseVideoFeatrue(Context context, int i) {
        Object b = o.b(AeU, "canUseVideoFeatrue", new Class[]{Integer.TYPE}, Integer.valueOf(i));
        return (b == null || !(b instanceof Boolean)) ? false : ((Boolean) b).booleanValue();
    }

    public static void clear(Context context) {
    }

    public static void clearAllWebViewCache(Context context, boolean z) {
        try {
            WebView webView = new WebView(context);
            if (VERSION.SDK_INT >= 11) {
                webView.removeJavascriptInterface("searchBoxJavaBridge_");
                webView.removeJavascriptInterface("accessibility");
                webView.removeJavascriptInterface("accessibilityTraversal");
            }
            webView.clearCache(true);
            if (z) {
                CookieSyncManager.createInstance(context);
                CookieManager.getInstance().removeAllCookie();
            }
            WebViewDatabase.getInstance(context).clearUsernamePassword();
            WebViewDatabase.getInstance(context).clearHttpAuthUsernamePassword();
            WebViewDatabase.getInstance(context).clearFormData();
            WebStorage.getInstance().deleteAllData();
            WebIconDatabase.getInstance().removeAllIcons();
        } catch (Throwable th) {
            TbsLog.e("QbSdk", "clearAllWebViewCache exception 1 -- " + Log.getStackTraceString(th));
        }
        ag cGb;
        try {
            if (new WebView(context).getWebViewClientExtension() != null) {
                af cFZ = af.cFZ();
                if (cFZ != null && cFZ.cGa()) {
                    cGb = cFZ.cGb();
                    TbsLog.w("desktop", " tbsWizard clearAllX5Cache");
                    if (z) {
                        cGb.Ain.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "clearAllCache", new Class[]{Context.class}, context);
                        return;
                    }
                    cGb.Ain.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "clearAllCache", new Class[]{Context.class, Boolean.TYPE}, context, Boolean.valueOf(z));
                }
            }
        } catch (Exception e) {
            cGb.Ain.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearUsernamePassword", new Class[]{Context.class}, context);
            cGb.Ain.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearHttpAuthUsernamePassword", new Class[]{Context.class}, context);
            cGb.Ain.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearFormData", new Class[]{Context.class}, context);
            cGb.Ain.invokeStaticMethod("com.tencent.smtt.webkit.CacheManager", "removeAllCacheFiles", null, new Object[0]);
            cGb.Ain.invokeStaticMethod("com.tencent.smtt.webkit.CacheManager", "clearLocalStorage", null, new Object[0]);
            Object invokeStaticMethod = cGb.Ain.invokeStaticMethod("com.tencent.smtt.net.http.DnsManager", "getInstance", null, new Object[0]);
            if (invokeStaticMethod != null) {
                cGb.Ain.invokeMethod(invokeStaticMethod, "com.tencent.smtt.net.http.DnsManager", "removeAllDns", null, new Object[0]);
            }
            invokeStaticMethod = cGb.Ain.invokeStaticMethod("com.tencent.smtt.webkit.SmttPermanentPermissions", "getInstance", null, new Object[0]);
            if (invokeStaticMethod != null) {
                cGb.Ain.invokeMethod(invokeStaticMethod, "com.tencent.smtt.webkit.SmttPermanentPermissions", "clearAllPermanentPermission", null, new Object[0]);
            }
            cGb.Ain.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "removeAllIcons", null, new Object[0]);
        } catch (Throwable th2) {
        }
    }

    public static void closeFileReader(Context context) {
        af cFZ = af.cFZ();
        cFZ.b(context, null);
        if (cFZ.cGa()) {
            cFZ.cGb().Ain.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "closeFileReader", new Class[0], new Object[0]);
        }
    }

    public static boolean createMiniQBShortCut(Context context, String str, String str2, Drawable drawable) {
        if (context == null) {
            return false;
        }
        if (p.gM(context)) {
            return false;
        }
        if (isMiniQBShortCutExist(context, str, str2)) {
            return false;
        }
        af cFZ = af.cFZ();
        if (cFZ == null || !cFZ.cGa()) {
            return false;
        }
        Bitmap bitmap = null;
        if (drawable instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) drawable).getBitmap();
        }
        DexLoader dexLoader = cFZ.cGb().Ain;
        TbsLog.e("QbSdk", "qbsdk createMiniQBShortCut");
        Object invokeStaticMethod = dexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createMiniQBShortCut", new Class[]{Context.class, String.class, String.class, Bitmap.class}, context, str, str2, bitmap);
        TbsLog.e("QbSdk", "qbsdk after createMiniQBShortCut ret: " + invokeStaticMethod);
        return invokeStaticMethod != null;
    }

    public static boolean deleteMiniQBShortCut(Context context, String str, String str2) {
        if (context == null || p.gM(context)) {
            return false;
        }
        af cFZ = af.cFZ();
        if (cFZ == null || !cFZ.cGa()) {
            return false;
        }
        return cFZ.cGb().Ain.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "deleteMiniQBShortCut", new Class[]{Context.class, String.class, String.class}, context, str, str2) != null;
    }

    public static void disAllowThirdAppDownload() {
        AeX = false;
    }

    static Bundle e(Context context, Bundle bundle) {
        if (gz(context)) {
            Object b = o.b(AeU, "incrUpdate", new Class[]{Context.class, Bundle.class}, context, bundle);
            if (b != null) {
                return (Bundle) b;
            }
            v.hp(context).bi(f.CTRL_INDEX, "incrUpdate return null!");
            return null;
        }
        v.hp(context).bi(f.CTRL_INDEX, "initForPatch return false!");
        return null;
    }

    public static void fileInfoDetect(Context context, String str, ValueCallback<String> valueCallback) {
        af cFZ = af.cFZ();
        if (cFZ != null && cFZ.cGa()) {
            try {
                cFZ.cGb().Ain.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "fileInfoDetect", new Class[]{Context.class, String.class, ValueCallback.class}, context, str, valueCallback);
            } catch (Throwable th) {
            }
        }
    }

    public static void forceSysWebView() {
        AeW = true;
        Afa = "SysWebViewForcedByOuter: " + Log.getStackTraceString(new Throwable());
        TbsLog.e("QbSdk", "sys WebView: SysWebViewForcedByOuter");
    }

    private static boolean gA(Context context) {
        try {
            if (AeT != null) {
                return true;
            }
            t.cFy();
            File hi = t.hi(context);
            if (hi == null) {
                TbsLog.e("QbSdk", "QbSdk initForX5DisableConfig (false) optDir == null");
                return false;
            } else if (x.hs(context)) {
                m.cEY().ao(context, 304);
                return false;
            } else {
                t.cFy();
                File file = new File(t.hi(context), "tbs_sdk_extension_dex.jar");
                if (file.exists()) {
                    String cFJ = x.cFJ() != null ? x.cFJ() : hi.getAbsolutePath();
                    TbsLog.i("QbSdk", "QbSdk init optDirExtension #3 is " + cFJ);
                    Class loadClass = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, cFJ, null).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                    AeT = loadClass;
                    Constructor constructor = loadClass.getConstructor(new Class[]{Context.class, Context.class});
                    if (!x.hs(context)) {
                        AeU = constructor.newInstance(new Object[]{context, context});
                    } else if (x.cFJ() == null) {
                        v.hp(context.getApplicationContext()).bj(GameJsApiGetOpenDeviceId.CTRL_BYTE, "host context is null!");
                        return false;
                    } else {
                        AeU = AeT.getConstructor(new Class[]{Context.class, Context.class, String.class}).newInstance(new Object[]{context, null, x.cFJ()});
                    }
                    o.b(AeU, "putInfo", new Class[]{String.class, String.class, String.class, String.class}, c.bjM, c.Aju, c.Ajv, c.bpq);
                    o.b(AeU, "setClientVersion", new Class[]{Integer.TYPE}, Integer.valueOf(1));
                    return true;
                }
                m.cEY().a(context, au.CTRL_INDEX, new Exception("initForX5DisableConfig failure -- tbs_sdk_extension_dex.jar is not exist!"));
                return false;
            }
        } catch (Throwable th) {
            TbsLog.e("QbSdk", "initForX5DisableConfig sys WebView: " + Log.getStackTraceString(th));
            return false;
        }
    }

    public static long getApkFileSize(Context context) {
        return context != null ? o.gI(context.getApplicationContext()).Agy.getLong("tbs_apkfilesize", 0) : 0;
    }

    public static String[] getDexLoaderFileList(Context context, Context context2, String str) {
        int i = 0;
        if (AeZ instanceof String[]) {
            int length = AeZ.length;
            String[] strArr = new String[length];
            while (i < length) {
                strArr[i] = str + AeZ[i];
                i++;
            }
            return strArr;
        }
        Object b = o.b(AeU, "getJarFiles", new Class[]{Context.class, Context.class, String.class}, context, context2, str);
        if (!(b instanceof String[])) {
            b = new String[]{""};
        }
        return (String[]) b;
    }

    public static boolean getDownloadWithoutWifi() {
        return Afp;
    }

    public static boolean getIsSysWebViewForcedByOuter() {
        return AeW;
    }

    public static String getMiniQBVersion(Context context) {
        af cFZ = af.cFZ();
        cFZ.b(context, null);
        if (cFZ == null || !cFZ.cGa()) {
            return null;
        }
        Object invokeStaticMethod = cFZ.cGb().Ain.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getMiniQBVersion", new Class[0], new Object[0]);
        return invokeStaticMethod == null ? null : (String) invokeStaticMethod;
    }

    public static String getQQBuildNumber() {
        return Afk;
    }

    public static boolean getTBSInstalling() {
        return Afq;
    }

    public static String getTID() {
        return Afj;
    }

    public static String getTbsResourcesPath(Context context) {
        return x.getTbsResourcesPath(context);
    }

    public static int getTbsVersion(Context context) {
        if (x.hs(context)) {
            return x.cFP();
        }
        int ha = t.cFy().ha(context);
        if (ha != 0 || n.gH(context).abP("install_status") != 3) {
            return ha;
        }
        reset(context);
        return ha;
    }

    private static boolean gz(Context context) {
        try {
            if (AeT != null) {
                return true;
            }
            t.cFy();
            File hi = t.hi(context);
            if (hi == null) {
                TbsLog.e("QbSdk", "QbSdk initExtension (false) optDir == null");
                return false;
            }
            File file = new File(hi, "tbs_sdk_extension_dex.jar");
            if (file.exists()) {
                Class loadClass = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, hi.getAbsolutePath(), null).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                AeT = loadClass;
                AeU = loadClass.getConstructor(new Class[]{Context.class, Context.class}).newInstance(new Object[]{context, context});
                return true;
            }
            TbsLog.e("QbSdk", "QbSdk initExtension (false) dexFile.exists()=false", true);
            return false;
        } catch (Throwable th) {
            TbsLog.e("QbSdk", "initExtension sys WebView: " + Log.getStackTraceString(th));
            return false;
        }
    }

    public static void initBuglyAsync(boolean z) {
        Afg = z;
    }

    public static void initTbsSettings(Map<String, Object> map) {
        if (Afs == null) {
            Afs = map;
            return;
        }
        try {
            Afs.putAll(map);
        } catch (Exception e) {
        }
    }

    public static void initX5Environment(final Context context, final a aVar) {
        if (context != null) {
            Afo = new u() {
                public final void lQ(int i) {
                }

                public final void lR(int i) {
                    QbSdk.preInit(context, aVar);
                }

                public final void lg(int i) {
                }
            };
            if (x.hs(context)) {
                t.cFy().x(context, true);
            }
            p.a(context, false, false, new com.tencent.smtt.sdk.p.a() {
                public final void g(boolean z, int i) {
                    if (x.cFQ() != 0 || x.cFM()) {
                        if (QbSdk.Afg && x.hs(context)) {
                            q.cFw().gO(context);
                        }
                        QbSdk.preInit(context, aVar);
                        return;
                    }
                    x.z(context, false);
                    if (QbSdk.Afg && x.hs(context)) {
                        q.cFw().gO(context);
                    }
                }
            });
        }
    }

    public static boolean installLocalQbApk(Context context, String str, String str2, Bundle bundle) {
        h nW = h.nW(true);
        nW.a(context, null);
        if (nW == null || !nW.Afz) {
            return false;
        }
        Object invokeStaticMethod = nW.cEO().Ain.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "installLocalQbApk", new Class[]{Context.class, String.class, String.class, Bundle.class}, context, str, str2, bundle);
        return invokeStaticMethod == null ? false : ((Boolean) invokeStaticMethod).booleanValue();
    }

    public static boolean intentDispatch(WebView webView, Intent intent, String str, String str2) {
        if (webView == null) {
            return false;
        }
        if (str.startsWith("mttbrowser://miniqb/ch=icon?")) {
            Context context = webView.getContext();
            int indexOf = str.indexOf("url=");
            String substring = indexOf > 0 ? str.substring(indexOf + 4) : null;
            HashMap hashMap = new HashMap();
            Object obj = "unknown";
            try {
                obj = context.getApplicationInfo().packageName;
            } catch (Exception e) {
            }
            hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, obj);
            hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, "14004");
            if (com.tencent.smtt.sdk.a.c.a(context, "miniqb://home".equals(substring) ? "qb://navicard/addCard?cardId=168&cardName=168" : substring, hashMap, "QbSdk.startMiniQBToLoadUrl", null) != 0) {
                af cFZ = af.cFZ();
                if (cFZ != null && cFZ.cGa() && cFZ.cGb().a(context, substring, null, str2, null) == 0) {
                    return true;
                }
                webView.loadUrl(substring);
            }
        } else {
            webView.loadUrl(str);
        }
        return false;
    }

    public static boolean isMiniQBShortCutExist(Context context, String str, String str2) {
        if (context == null) {
            return false;
        }
        if (p.gM(context)) {
            return false;
        }
        af cFZ = af.cFZ();
        if (cFZ == null || !cFZ.cGa()) {
            return false;
        }
        Object invokeStaticMethod = cFZ.cGb().Ain.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "isMiniQBShortCutExist", new Class[]{Context.class, String.class}, context, str);
        if (invokeStaticMethod == null) {
            return false;
        }
        return (invokeStaticMethod instanceof Boolean ? (Boolean) invokeStaticMethod : Boolean.valueOf(false)).booleanValue();
    }

    public static boolean isTbsCoreInited() {
        h nW = h.nW(false);
        return nW != null && nW.AfA;
    }

    public static boolean isX5DisabledSync(Context context) {
        int i;
        if (n.gH(context).abP("install_status") == 2) {
            i = 1;
        } else {
            boolean i2 = false;
        }
        if (i2 != 0) {
            return false;
        }
        if (!gA(context)) {
            return true;
        }
        i2 = t.cFy().ha(context);
        Object b = o.b(AeU, "isX5DisabledSync", new Class[]{Integer.TYPE, Integer.TYPE}, Integer.valueOf(i2), Integer.valueOf(43603));
        return b != null ? ((Boolean) b).booleanValue() : true;
    }

    public static synchronized void preInit(Context context) {
        synchronized (QbSdk.class) {
            preInit(context, null);
        }
    }

    public static synchronized void preInit(final Context context, final a aVar) {
        synchronized (QbSdk.class) {
            TbsLog.initIfNeed(context);
            Afl = AeV;
            if (!AeY) {
                final Handler anonymousClass2 = new Handler(Looper.getMainLooper()) {
                    public final void handleMessage(Message message) {
                        switch (message.what) {
                            case 1:
                                ag cGb = af.cFZ().cGb();
                                if (cGb != null) {
                                    cGb.hF(context);
                                }
                                if (aVar != null) {
                                    aVar.kX(true);
                                }
                                TbsLog.writeLogToDisk();
                                return;
                            case 2:
                                if (aVar != null) {
                                    aVar.kX(false);
                                }
                                TbsLog.writeLogToDisk();
                                return;
                            case 3:
                                if (aVar != null) {
                                    aVar.tI();
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                };
                Thread anonymousClass3 = new Thread() {
                    public final void run() {
                        if (t.cFy().b(true, context) == 0) {
                            t.cFy().x(context, true);
                        }
                        h.nW(true).a(context, null);
                        af cFZ = af.cFZ();
                        cFZ.b(context, null);
                        boolean cGa = cFZ.cGa();
                        anonymousClass2.sendEmptyMessage(3);
                        if (cGa) {
                            anonymousClass2.sendEmptyMessage(1);
                        } else {
                            anonymousClass2.sendEmptyMessage(2);
                        }
                    }
                };
                anonymousClass3.setName("tbs_preinit");
                anonymousClass3.setPriority(10);
                anonymousClass3.start();
                AeY = true;
            }
        }
    }

    @SuppressLint({"NewApi"})
    private static boolean q(Context context, boolean z) {
        Throwable th;
        Editor edit;
        File cEZ;
        File hi;
        String absolutePath;
        Class loadClass;
        Constructor constructor;
        int i = -1;
        TbsLog.initIfNeed(context);
        if (!sIsVersionPrinted) {
            TbsLog.i("QbSdk", "svn revision: jnizz; SDK_VERSION_CODE: 43603; SDK_VERSION_NAME: 3.6.0.1140");
            sIsVersionPrinted = true;
        }
        if (AeV && !z) {
            TbsLog.e("QbSdk", "QbSdk init: " + Afb, false);
            m.cEY().a(context, e.CTRL_INDEX, new Throwable(Afb));
            return false;
        } else if (AeW) {
            TbsLog.e("QbSdk", "QbSdk init mIsSysWebViewForcedByOuter = true", true);
            m.cEY().a(context, com.tencent.mm.plugin.appbrand.jsapi.a.e.CTRL_INDEX, new Throwable(Afa));
            return false;
        } else {
            int i2;
            if (!Afm) {
                Afm = true;
                SharedPreferences sharedPreferences;
                int i3;
                int ha;
                try {
                    sharedPreferences = VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0);
                    try {
                        i3 = sharedPreferences.getInt("tbs_preload_x5_recorder", -1);
                        if (i3 >= 0) {
                            i3++;
                            if (i3 <= 4) {
                                i2 = i3;
                            }
                        } else {
                            i2 = i3;
                            i3 = -1;
                        }
                        try {
                            ha = t.cFy().ha(context);
                            if (ha > 0) {
                                if (i2 <= 4) {
                                    try {
                                        sharedPreferences.edit().putInt("tbs_preload_x5_recorder", i2).commit();
                                    } catch (Throwable th2) {
                                        th = th2;
                                        TbsLog.e("QbSdk", "tbs_preload_x5_counter Inc exception:" + Log.getStackTraceString(th));
                                        i2 = -1;
                                        if (i2 > 3) {
                                            try {
                                                i2 = sharedPreferences.getInt("tbs_preload_x5_version", -1);
                                                edit = sharedPreferences.edit();
                                                if (i2 == ha) {
                                                    t.cFy();
                                                    com.tencent.smtt.utils.f.e(t.hi(context), false);
                                                    n.gH(context);
                                                    cEZ = n.cEZ();
                                                    if (cEZ != null) {
                                                        com.tencent.smtt.utils.f.e(cEZ, false);
                                                    }
                                                    TbsLog.e("QbSdk", "QbSdk - preload_x5_check: tbs core " + ha + " is deleted!");
                                                } else {
                                                    TbsLog.e("QbSdk", "QbSdk - preload_x5_check -- reset exception core_ver:" + ha + "; value:" + i2);
                                                }
                                                edit.putInt("tbs_precheck_disable_version", i2);
                                                edit.commit();
                                            } catch (Throwable th3) {
                                                TbsLog.e("QbSdk", "tbs_preload_x5_counter disable version exception:" + Log.getStackTraceString(th3));
                                            }
                                        } else {
                                            TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
                                            af.cFZ().b(context, null);
                                            TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
                                            i = 0;
                                            try {
                                                i2 = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                                                if (i2 > 0) {
                                                    sharedPreferences.edit().putInt("tbs_preload_x5_counter", i2 - 1).commit();
                                                }
                                            } catch (Throwable th32) {
                                                TbsLog.e("QbSdk", "tbs_preload_x5_counter Dec exception:" + Log.getStackTraceString(th32));
                                            }
                                            TbsLog.i("QbSdk", "QbSdk -- preload_x5_check result:" + i);
                                        }
                                        t.cFy();
                                        hi = t.hi(context);
                                        if (hi != null) {
                                            if (!x.hs(context)) {
                                                if (AeR == 0) {
                                                    i2 = 0;
                                                } else {
                                                    i2 = t.cFy().b(true, context);
                                                    if (AeR != i2) {
                                                        AeT = null;
                                                        AeU = null;
                                                        TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp tbsCoreInstalledVer=" + i2, true);
                                                        TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp sTbsVersion=" + AeR, true);
                                                        m.cEY().a(context, 303, new Throwable("sTbsVersion: " + AeR + "; tbsCoreInstalledVer: " + i2));
                                                        return false;
                                                    }
                                                }
                                                AeR = i2;
                                            }
                                            if (AeT != null) {
                                                return true;
                                            }
                                            if (x.hs(context)) {
                                                m.cEY().a(context, 304, new Throwable("isShareTbsCoreAvailable false!"));
                                                return false;
                                            }
                                            t.cFy();
                                            cEZ = new File(t.hi(context), "tbs_sdk_extension_dex.jar");
                                            if (cEZ.exists()) {
                                                absolutePath = x.cFJ() == null ? hi.getAbsolutePath() : x.cFJ();
                                                TbsLog.i("QbSdk", "QbSdk init optDirExtension #1 is " + absolutePath);
                                                loadClass = new DexLoader(cEZ.getParent(), context, new String[]{cEZ.getAbsolutePath()}, absolutePath, null).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                                                AeT = loadClass;
                                                constructor = loadClass.getConstructor(new Class[]{Context.class, Context.class});
                                                if (x.hs(context)) {
                                                    AeU = constructor.newInstance(new Object[]{context, context});
                                                } else if (x.cFJ() != null) {
                                                    AeU = AeT.getConstructor(new Class[]{Context.class, Context.class, String.class}).newInstance(new Object[]{context, null, x.cFJ()});
                                                } else {
                                                    v.hp(context.getApplicationContext()).bj(GameJsApiGetOpenDeviceId.CTRL_BYTE, "host context is null!");
                                                    return false;
                                                }
                                                o.b(AeU, "putInfo", new Class[]{String.class, String.class, String.class, String.class}, c.bjM, c.Aju, c.Ajv, c.bpq);
                                                o.b(AeU, "setClientVersion", new Class[]{Integer.TYPE}, Integer.valueOf(1));
                                                return true;
                                            }
                                            try {
                                                TbsLog.e("QbSdk", "QbSdk init (false) tbs_sdk_extension_dex.jar is not exist!");
                                                i2 = t.cFy().ha(context);
                                                if (new File(cEZ.getParentFile(), "tbs_jars_fusion_dex.jar").exists()) {
                                                    if (i2 <= 0) {
                                                        m.cEY().a(context, 4132, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i2));
                                                    } else {
                                                        m.cEY().a(context, 4131, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i2));
                                                    }
                                                } else if (i2 <= 0) {
                                                    m.cEY().a(context, 4122, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i2));
                                                } else {
                                                    m.cEY().a(context, 4121, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i2));
                                                }
                                            } catch (Throwable th4) {
                                            }
                                            return false;
                                        }
                                        TbsLog.e("QbSdk", "QbSdk init (false) optDir == null");
                                        m.cEY().a(context, 312, new Throwable("QbSdk.init (false) TbsCoreShareDir is null"));
                                        return false;
                                    }
                                }
                                i2 = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                                if (i2 >= 0) {
                                    i2++;
                                    sharedPreferences.edit().putInt("tbs_preload_x5_counter", i2).commit();
                                    if (i2 > 3) {
                                        i2 = sharedPreferences.getInt("tbs_preload_x5_version", -1);
                                        edit = sharedPreferences.edit();
                                        if (i2 == ha) {
                                            t.cFy();
                                            com.tencent.smtt.utils.f.e(t.hi(context), false);
                                            n.gH(context);
                                            cEZ = n.cEZ();
                                            if (cEZ != null) {
                                                com.tencent.smtt.utils.f.e(cEZ, false);
                                            }
                                            TbsLog.e("QbSdk", "QbSdk - preload_x5_check: tbs core " + ha + " is deleted!");
                                        } else {
                                            TbsLog.e("QbSdk", "QbSdk - preload_x5_check -- reset exception core_ver:" + ha + "; value:" + i2);
                                        }
                                        edit.putInt("tbs_precheck_disable_version", i2);
                                        edit.commit();
                                    } else {
                                        if (i3 > 0 && i3 <= 3) {
                                            TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
                                            af.cFZ().b(context, null);
                                            TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
                                            i = 0;
                                        }
                                        i2 = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                                        if (i2 > 0) {
                                            sharedPreferences.edit().putInt("tbs_preload_x5_counter", i2 - 1).commit();
                                        }
                                        TbsLog.i("QbSdk", "QbSdk -- preload_x5_check result:" + i);
                                    }
                                }
                                i2 = -1;
                                if (i2 > 3) {
                                    TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
                                    af.cFZ().b(context, null);
                                    TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
                                    i = 0;
                                    i2 = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                                    if (i2 > 0) {
                                        sharedPreferences.edit().putInt("tbs_preload_x5_counter", i2 - 1).commit();
                                    }
                                    TbsLog.i("QbSdk", "QbSdk -- preload_x5_check result:" + i);
                                } else {
                                    i2 = sharedPreferences.getInt("tbs_preload_x5_version", -1);
                                    edit = sharedPreferences.edit();
                                    if (i2 == ha) {
                                        TbsLog.e("QbSdk", "QbSdk - preload_x5_check -- reset exception core_ver:" + ha + "; value:" + i2);
                                    } else {
                                        t.cFy();
                                        com.tencent.smtt.utils.f.e(t.hi(context), false);
                                        n.gH(context);
                                        cEZ = n.cEZ();
                                        if (cEZ != null) {
                                            com.tencent.smtt.utils.f.e(cEZ, false);
                                        }
                                        TbsLog.e("QbSdk", "QbSdk - preload_x5_check: tbs core " + ha + " is deleted!");
                                    }
                                    edit.putInt("tbs_precheck_disable_version", i2);
                                    edit.commit();
                                }
                            }
                        } catch (Throwable th5) {
                            th32 = th5;
                            ha = -1;
                        }
                    } catch (Throwable th6) {
                        th32 = th6;
                        i3 = -1;
                        ha = -1;
                    }
                } catch (Throwable th7) {
                    th32 = th7;
                    sharedPreferences = null;
                    ha = -1;
                    i3 = -1;
                }
            }
            try {
                t.cFy();
                hi = t.hi(context);
                if (hi != null) {
                    TbsLog.e("QbSdk", "QbSdk init (false) optDir == null");
                    m.cEY().a(context, 312, new Throwable("QbSdk.init (false) TbsCoreShareDir is null"));
                    return false;
                }
                if (x.hs(context)) {
                    if (AeR == 0) {
                        i2 = t.cFy().b(true, context);
                        if (AeR != i2) {
                            AeT = null;
                            AeU = null;
                            TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp tbsCoreInstalledVer=" + i2, true);
                            TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp sTbsVersion=" + AeR, true);
                            m.cEY().a(context, 303, new Throwable("sTbsVersion: " + AeR + "; tbsCoreInstalledVer: " + i2));
                            return false;
                        }
                    }
                    i2 = 0;
                    AeR = i2;
                }
                if (AeT != null) {
                    return true;
                }
                if (x.hs(context)) {
                    m.cEY().a(context, 304, new Throwable("isShareTbsCoreAvailable false!"));
                    return false;
                }
                t.cFy();
                cEZ = new File(t.hi(context), "tbs_sdk_extension_dex.jar");
                if (cEZ.exists()) {
                    TbsLog.e("QbSdk", "QbSdk init (false) tbs_sdk_extension_dex.jar is not exist!");
                    i2 = t.cFy().ha(context);
                    if (new File(cEZ.getParentFile(), "tbs_jars_fusion_dex.jar").exists()) {
                        if (i2 <= 0) {
                            m.cEY().a(context, 4131, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i2));
                        } else {
                            m.cEY().a(context, 4132, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i2));
                        }
                    } else if (i2 <= 0) {
                        m.cEY().a(context, 4121, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i2));
                    } else {
                        m.cEY().a(context, 4122, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i2));
                    }
                    return false;
                }
                if (x.cFJ() == null) {
                }
                TbsLog.i("QbSdk", "QbSdk init optDirExtension #1 is " + absolutePath);
                loadClass = new DexLoader(cEZ.getParent(), context, new String[]{cEZ.getAbsolutePath()}, absolutePath, null).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                AeT = loadClass;
                constructor = loadClass.getConstructor(new Class[]{Context.class, Context.class});
                if (x.hs(context)) {
                    AeU = constructor.newInstance(new Object[]{context, context});
                } else if (x.cFJ() != null) {
                    v.hp(context.getApplicationContext()).bj(GameJsApiGetOpenDeviceId.CTRL_BYTE, "host context is null!");
                    return false;
                } else {
                    AeU = AeT.getConstructor(new Class[]{Context.class, Context.class, String.class}).newInstance(new Object[]{context, null, x.cFJ()});
                }
                o.b(AeU, "putInfo", new Class[]{String.class, String.class, String.class, String.class}, c.bjM, c.Aju, c.Ajv, c.bpq);
                o.b(AeU, "setClientVersion", new Class[]{Integer.TYPE}, Integer.valueOf(1));
                return true;
            } catch (Throwable th322) {
                TbsLog.e("QbSdk", "QbSdk init Throwable: " + Log.getStackTraceString(th322));
                m.cEY().a(context, 306, th322);
                return false;
            }
        }
    }

    static boolean r(Context context, boolean z) {
        int i = 1;
        boolean z2 = false;
        if (x.hs(context)) {
            x.cFS();
            m.cEY().ao(context, HardCoderJNI.SCENE_QUIT_CHATTING);
        } else if (q(context, false)) {
            Object b = o.b(AeU, "canLoadX5Core", new Class[]{Integer.TYPE}, Integer.valueOf(43603));
            boolean am;
            if (b == null) {
                b = o.b(AeU, "canLoadX5", new Class[]{Integer.TYPE}, Integer.valueOf(a.cEH()));
                if (b == null) {
                    m.cEY().ao(context, 308);
                } else if (!((b instanceof String) && ((String) b).equalsIgnoreCase("AuthenticationFail"))) {
                    if (b instanceof Boolean) {
                        AeR = h.cEP();
                        am = am(context, h.cEP());
                        if (((Boolean) b).booleanValue() && !am) {
                            z2 = true;
                        }
                        if (!z2) {
                            TbsLog.e("loaderror", "318");
                            TbsLog.w("loaderror", "isX5Disable:" + am);
                            TbsLog.w("loaderror", "(Boolean) ret:" + ((Boolean) b));
                        }
                    }
                }
            } else if (!((b instanceof String) && ((String) b).equalsIgnoreCase("AuthenticationFail"))) {
                if (b instanceof Bundle) {
                    Bundle bundle = (Bundle) b;
                    if (bundle.isEmpty()) {
                        m.cEY().a(context, 331, new Throwable(String.valueOf(b)));
                        TbsLog.e("loaderror", "empty bundle");
                    } else {
                        int i2;
                        try {
                            i2 = bundle.getInt("result_code", -1);
                        } catch (Exception e) {
                            TbsLog.e("QbSdk", "bundle.getInt(KEY_RESULT_CODE) error : " + e.toString());
                            i2 = -1;
                        }
                        am = i2 == 0;
                        String valueOf;
                        if (x.hs(context)) {
                            h.Ij(x.cFO());
                            valueOf = String.valueOf(x.cFO());
                            AeS = valueOf;
                            if (valueOf.length() == 5) {
                                AeS = "0" + AeS;
                            }
                            if (AeS.length() != 6) {
                                AeS = "";
                            }
                        } else {
                            if (VERSION.SDK_INT >= 12) {
                                AeS = bundle.getString("tbs_core_version", "0");
                            } else {
                                valueOf = bundle.getString("tbs_core_version");
                                AeS = valueOf;
                                if (valueOf == null) {
                                    AeS = "0";
                                }
                            }
                            try {
                                AeR = Integer.parseInt(AeS);
                            } catch (NumberFormatException e2) {
                                AeR = 0;
                            }
                            h.Ij(AeR);
                            if (AeR == 0) {
                                m.cEY().a(context, 307, new Throwable("sTbsVersion is 0"));
                            } else {
                                if ((AeR <= 0 || AeR > 25442) && AeR != 25472) {
                                    i = 0;
                                }
                                if (i != 0) {
                                    TbsLog.e("TbsDownload", "is_obsolete --> delete old core:" + AeR);
                                    t.cFy();
                                    com.tencent.smtt.utils.f.T(t.hi(context));
                                    m.cEY().a(context, 307, new Throwable("is_obsolete --> delete old core:" + AeR));
                                }
                            }
                        }
                        try {
                            AeZ = bundle.getStringArray("tbs_jarfiles");
                            if (AeZ instanceof String[]) {
                                Afc = bundle.getString("tbs_librarypath");
                                b = null;
                                if (i2 != 0) {
                                    try {
                                        b = o.b(AeU, "getErrorCodeForLogReport", new Class[0], new Object[0]);
                                    } catch (Exception e3) {
                                    }
                                }
                                switch (i2) {
                                    case -2:
                                        if (!(b instanceof Integer)) {
                                            m.cEY().a(context, TencentLocation.ERROR_UNKNOWN, new Throwable("detail: " + b));
                                            z2 = am;
                                            break;
                                        }
                                        m.cEY().a(context, ((Integer) b).intValue(), new Throwable("detail: " + b));
                                        z2 = am;
                                        break;
                                    case -1:
                                        if (!(b instanceof Integer)) {
                                            m.cEY().a(context, 307, new Throwable("detail: " + b));
                                            z2 = am;
                                            break;
                                        }
                                        m.cEY().a(context, ((Integer) b).intValue(), new Throwable("detail: " + b));
                                        z2 = am;
                                        break;
                                    case 0:
                                        z2 = am;
                                        break;
                                    default:
                                        m.cEY().a(context, 415, new Throwable("detail: " + b + "errcode" + i2));
                                        z2 = am;
                                        break;
                                }
                            }
                            m.cEY().a(context, 307, new Throwable("sJarFiles not instanceof String[]: " + AeZ));
                        } catch (Throwable th) {
                            m.cEY().a(context, 329, th);
                        }
                    }
                } else {
                    m.cEY().a(context, 330, new Throwable(String.valueOf(b)));
                    TbsLog.e("loaderror", "ret not instance of bundle");
                }
            }
            if (!z2) {
                TbsLog.e("loaderror", "319");
            }
        } else {
            TbsLog.e("QbSdk", "QbSdk.init failure!");
        }
        return z2;
    }

    public static void reset(Context context) {
        reset(context, false);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void reset(android.content.Context r5, boolean r6) {
        /*
        r1 = 0;
        r0 = 1;
        r2 = "QbSdk";
        r3 = "QbSdk reset!";
        com.tencent.smtt.utils.TbsLog.e(r2, r3, r0);
        com.tencent.smtt.sdk.p.stopDownload();	 Catch:{ Throwable -> 0x008d }
        if (r6 == 0) goto L_0x00a9;
    L_0x0010:
        r2 = com.tencent.smtt.sdk.x.hs(r5);	 Catch:{ Throwable -> 0x008d }
        if (r2 != 0) goto L_0x00a9;
    L_0x0016:
        com.tencent.smtt.sdk.t.cFy();	 Catch:{ Throwable -> 0x008d }
        r2 = com.tencent.smtt.sdk.t.gZ(r5);	 Catch:{ Throwable -> 0x008d }
        r3 = com.tencent.smtt.sdk.t.cFy();	 Catch:{ Throwable -> 0x008d }
        r3 = r3.ha(r5);	 Catch:{ Throwable -> 0x008d }
        r4 = 43300; // 0xa924 float:6.0676E-41 double:2.1393E-319;
        if (r2 <= r4) goto L_0x00a9;
    L_0x002a:
        if (r2 == r3) goto L_0x00a9;
    L_0x002c:
        com.tencent.smtt.sdk.p.gN(r5);	 Catch:{ Throwable -> 0x008d }
        r1 = "tbs";
        r2 = 0;
        r1 = r5.getDir(r1, r2);	 Catch:{ Throwable -> 0x008d }
        r2 = "core_share_decouple";
        com.tencent.smtt.utils.f.e(r1, r2);	 Catch:{ Throwable -> 0x008d }
        r1 = "QbSdk";
        r2 = "delete downloaded apk success";
        r3 = 1;
        com.tencent.smtt.utils.TbsLog.i(r1, r2, r3);	 Catch:{ Throwable -> 0x008d }
        r1 = com.tencent.smtt.sdk.t.Ahc;	 Catch:{ Throwable -> 0x008d }
        r2 = 0;
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ Throwable -> 0x008d }
        r1.set(r2);	 Catch:{ Throwable -> 0x008d }
        r1 = new java.io.File;	 Catch:{ Throwable -> 0x008d }
        r2 = r5.getFilesDir();	 Catch:{ Throwable -> 0x008d }
        r3 = "bugly_switch.txt";
        r1.<init>(r2, r3);	 Catch:{ Throwable -> 0x008d }
        r2 = r1.exists();	 Catch:{ Throwable -> 0x008d }
        if (r2 == 0) goto L_0x0066;
    L_0x0063:
        r1.delete();	 Catch:{ Throwable -> 0x008d }
    L_0x0066:
        if (r0 == 0) goto L_0x008c;
    L_0x0068:
        com.tencent.smtt.sdk.t.cFy();	 Catch:{ Throwable -> 0x008d }
        r0 = com.tencent.smtt.sdk.t.hh(r5);	 Catch:{ Throwable -> 0x008d }
        com.tencent.smtt.sdk.t.cFy();	 Catch:{ Throwable -> 0x008d }
        r1 = com.tencent.smtt.sdk.t.hl(r5);	 Catch:{ Throwable -> 0x008d }
        com.tencent.smtt.utils.f.j(r0, r1);	 Catch:{ Throwable -> 0x008d }
        com.tencent.smtt.sdk.t.cFy();	 Catch:{ Throwable -> 0x008d }
        r0 = 1;
        com.tencent.smtt.sdk.t.y(r5, r0);	 Catch:{ Throwable -> 0x008d }
        r0 = com.tencent.smtt.sdk.n.gH(r5);	 Catch:{ Throwable -> 0x008d }
        r1 = com.tencent.smtt.sdk.t.gZ(r5);	 Catch:{ Throwable -> 0x008d }
        r2 = 2;
        r0.fI(r1, r2);	 Catch:{ Throwable -> 0x008d }
    L_0x008c:
        return;
    L_0x008d:
        r0 = move-exception;
        r1 = "QbSdk";
        r2 = new java.lang.StringBuilder;
        r3 = "QbSdk reset exception:";
        r2.<init>(r3);
        r0 = android.util.Log.getStackTraceString(r0);
        r0 = r2.append(r0);
        r0 = r0.toString();
        com.tencent.smtt.utils.TbsLog.e(r1, r0);
        goto L_0x008c;
    L_0x00a9:
        r0 = r1;
        goto L_0x002c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.QbSdk.reset(android.content.Context, boolean):void");
    }

    public static void resetDecoupleCore(Context context) {
        TbsLog.e("QbSdk", "QbSdk resetDecoupleCore!", true);
        try {
            t.cFy();
            com.tencent.smtt.utils.f.T(t.hh(context));
        } catch (Throwable th) {
            TbsLog.e("QbSdk", "QbSdk resetDecoupleCore exception:" + Log.getStackTraceString(th));
        }
    }

    public static void setCurrentID(String str) {
        if (str != null && str.startsWith(TID_QQNumber_Prefix)) {
            String substring = str.substring(3);
            Afj = "0000000000000000".substring(substring.length()) + substring;
        }
    }

    public static void setDeviceInfo(String str, String str2, String str3, String str4) {
        c.bjM = str;
        c.Aju = str2;
        c.Ajv = str3;
        c.bpq = str4;
    }

    public static void setDownloadWithoutWifi(boolean z) {
        Afp = z;
    }

    public static void setQQBuildNumber(String str) {
        Afk = str;
    }

    public static void setTBSInstallingStatus(boolean z) {
        Afq = z;
    }

    public static void setTbsListener(u uVar) {
        Afn = uVar;
    }

    public static void setTbsLogClient(t tVar) {
        TbsLog.setTbsLogClient(tVar);
    }

    public static int startMiniQBToLoadUrl(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback) {
        m.cEY().ao(context, HardCoderJNI.SCENE_DB);
        if (context == null) {
            return -100;
        }
        af cFZ = af.cFZ();
        cFZ.b(context, null);
        if (!cFZ.cGa()) {
            m.cEY().ao(context, 502);
            return -102;
        } else if (context != null && context.getApplicationInfo().packageName.equals("com.nd.android.pandahome2") && getTbsVersion(context) < 25487) {
            return XWalkUpdater.ERROR_SET_VERNUM;
        } else {
            int a = cFZ.cGb().a(context, str, hashMap, null, valueCallback);
            if (a == 0) {
                m.cEY().ao(context, 503);
                return a;
            }
            v.hp(context).bj(504, String.valueOf(a));
            return a;
        }
    }

    public static boolean startQBForDoc(Context context, String str, int i, int i2, String str2, Bundle bundle) {
        HashMap hashMap = new HashMap();
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationContext().getApplicationInfo().processName);
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, Integer.toString(i));
        return com.tencent.smtt.sdk.a.c.a(context, str, i2, str2, hashMap, bundle);
    }

    public static boolean startQBForVideo(Context context, String str, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationInfo().processName);
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, Integer.toString(i));
        return com.tencent.smtt.sdk.a.c.a(context, str, hashMap);
    }

    public static boolean startQBToLoadurl(Context context, String str, int i, WebView webView) {
        HashMap hashMap = new HashMap();
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationInfo().processName);
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, Integer.toString(i));
        if (webView == null) {
            try {
                String str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
                if (str2 == "com.tencent.mm" || str2 == "com.tencent.mobileqq") {
                    af cFZ = af.cFZ();
                    if (cFZ != null && cFZ.cGa()) {
                        Object invokeStaticMethod = cFZ.cGb().Ain.invokeStaticMethod("com.tencent.smtt.webkit.WebViewList", "getCurrentMainWebviewJustForQQandWechat", new Class[0], new Object[0]);
                        if (invokeStaticMethod != null) {
                            IX5WebViewBase iX5WebViewBase = (IX5WebViewBase) invokeStaticMethod;
                            if (iX5WebViewBase != null) {
                                webView = (WebView) iX5WebViewBase.getView().getParent();
                            }
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        return com.tencent.smtt.sdk.a.c.a(context, str, hashMap, "QbSdk.startQBToLoadurl", webView) == 0;
    }

    public static boolean startQbOrMiniQBToLoadUrl(Context context, String str, HashMap<String, String> hashMap, ab<String> abVar) {
        if (context == null) {
            return false;
        }
        af cFZ = af.cFZ();
        cFZ.b(context, null);
        String str2 = "QbSdk.startMiniQBToLoadUrl";
        if (hashMap != null && "5".equals(hashMap.get(LOGIN_TYPE_KEY_PARTNER_CALL_POS)) && cFZ.cGa()) {
            cFZ.cGb().Ain.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getAdWebViewInfoFromX5Core", new Class[0], new Object[0]);
        }
        if (com.tencent.smtt.sdk.a.c.a(context, str, hashMap, str2, null) == 0) {
            return true;
        }
        if (cFZ.cGa()) {
            if (context != null && context.getApplicationInfo().packageName.equals("com.nd.android.pandahome2") && getTbsVersion(context) < 25487) {
                return false;
            }
            if (cFZ.cGb().a(context, str, hashMap, null, abVar) == 0) {
                return true;
            }
        }
        return false;
    }

    public static void unForceSysWebView() {
        AeW = false;
        TbsLog.e("QbSdk", "sys WebView: unForceSysWebView called");
    }

    public static boolean useSoftWare() {
        if (AeU == null) {
            return false;
        }
        Object b = o.b(AeU, "useSoftWare", new Class[0], new Object[0]);
        if (b == null) {
            b = o.b(AeU, "useSoftWare", new Class[]{Integer.TYPE}, Integer.valueOf(a.cEH()));
        }
        return b == null ? false : ((Boolean) b).booleanValue();
    }
}
