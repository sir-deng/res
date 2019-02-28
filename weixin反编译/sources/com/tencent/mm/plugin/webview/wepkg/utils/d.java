package com.tencent.mm.plugin.webview.wepkg.utils;

import android.content.SharedPreferences;
import android.net.Uri;
import android.webkit.URLUtil;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessTask;
import com.tencent.mm.plugin.webview.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.webview.wepkg.model.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

public final class d {
    private static volatile ah hoG;
    private static final Object jXz = new Object();
    private static final Set<Object> jeP = new HashSet();

    public static long amp() {
        return bi.Wx();
    }

    public static <T> T bk(T t) {
        jeP.add(t);
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
                    hoG = new ah("WebviewCache#WorkerThread");
                }
            }
        }
        return hoG;
    }

    public static String QU(String str) {
        if (bi.oN(str)) {
            return "";
        }
        return b.OBJECT_ROOT_DIR_PATH + str + "/";
    }

    public static String fe(String str, String str2) {
        if (bi.oN(str) || bi.oN(str2)) {
            return "";
        }
        return QU(str) + str2;
    }

    public static void a(String str, final a aVar) {
        final long currentTimeMillis = System.currentTimeMillis();
        final WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.pK = 1001;
        wepkgCrossProcessTask.tTu = str;
        if (ad.cgj()) {
            Dt().F(new Runnable() {
                public final void run() {
                    wepkgCrossProcessTask.YA();
                    if (aVar != null) {
                        aVar.a(wepkgCrossProcessTask);
                    }
                }
            });
            return;
        }
        wepkgCrossProcessTask.jfW = new Runnable() {
            public final void run() {
                x.i("MicroMsg.Wepkg.WepkgUtil", "bind service time:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                if (aVar != null) {
                    aVar.a(wepkgCrossProcessTask);
                }
                wepkgCrossProcessTask.afz();
            }
        };
        wepkgCrossProcessTask.afy();
        WepkgMainProcessService.a(wepkgCrossProcessTask);
    }

    public static String QV(String str) {
        if (bi.oN(str)) {
            return "";
        }
        try {
            return bi.oM(Uri.parse(str).getQueryParameter("wechat_pkgid"));
        } catch (UnsupportedOperationException e) {
            x.e("MicroMsg.Wepkg.WepkgUtil", e.getMessage());
            return "";
        }
    }

    public static String QW(String str) {
        if (bi.oN(str)) {
            return "";
        }
        return Uri.parse(str).getHost();
    }

    public static String QX(String str) {
        if (bi.oN(str) || !URLUtil.isNetworkUrl(str)) {
            return "";
        }
        try {
            String replaceFirst = str.replaceFirst(Uri.parse(str).getScheme() + "://", "");
            try {
                if (replaceFirst.contains("?")) {
                    return replaceFirst.substring(0, replaceFirst.indexOf("?"));
                }
                return replaceFirst;
            } catch (Exception e) {
                return replaceFirst;
            }
        } catch (Exception e2) {
            return str;
        }
    }

    public static boolean QY(String str) {
        if (bi.oN(QV(str))) {
            return false;
        }
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("we_pkg_sp", 4);
        if (sharedPreferences != null && sharedPreferences.getBoolean("disable_we_pkg", false)) {
            x.i("MicroMsg.Wepkg.WepkgUtil", "disable wepkg");
            a.b("EnterWeb", str, QV(str), null, 0, 0, a.BA(11));
            return false;
        } else if (!b.tUu) {
            return true;
        } else {
            x.i("MicroMsg.Wepkg.WepkgUtil", "config wepkg disable");
            a.b("EnterWeb", str, QV(str), null, 0, 0, a.BA(12));
            return false;
        }
    }

    public static String ff(String str, String str2) {
        return g.s((str + "_" + str2).getBytes());
    }

    public static boolean QZ(String str) {
        try {
            File file = new File(str);
            if (!(file.exists() && file.isDirectory())) {
                file.mkdirs();
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean bWb() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        int i = gregorianCalendar.get(11);
        int i2 = gregorianCalendar.get(12);
        if (i >= 12 && i < 14) {
            return true;
        }
        if (i == 14) {
            if (i2 <= 30) {
                return true;
            }
        } else if (i >= 18 && i <= 24) {
            return true;
        }
        return false;
    }
}
