package com.tencent.xweb.util;

import com.tencent.xweb.WebView.c;
import com.tencent.xweb.g;
import com.tencent.xweb.q;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import org.xwalk.core.XWalkEnvironment;

public final class e {
    static q AAO = null;
    public static String frp = "";

    public static void b(c cVar) {
        if (AAO != null) {
            String str;
            if ((cVar == c.WV_KIND_CW ? 1 : null) != null) {
                str = "REPORT_APK_VER_TIME";
            } else {
                str = "REPORT_APK_VER_TIME_" + cVar;
            }
            String format = new SimpleDateFormat("yyyyMMdd").format(new Date());
            Object string = XWalkEnvironment.getSharedPreferences().getString(str, "");
            if (string == null) {
                string = "";
            }
            if (!format.equals(string)) {
                int i;
                if (cVar == c.WV_KIND_CW) {
                    int availableVersion = XWalkEnvironment.getAvailableVersion();
                    if (availableVersion > 0) {
                        i = 99;
                        AAO.h((long) ((availableVersion % 50) + 100), 1);
                    } else {
                        return;
                    }
                } else if (cVar == c.WV_KIND_SYS) {
                    i = 97;
                } else if (cVar == c.WV_KIND_X5) {
                    i = 98;
                } else {
                    return;
                }
                AAO.h((long) i, 1);
                XWalkEnvironment.getSharedPreferences().edit().putString(str, format).apply();
            }
        }
    }

    public static void a(q qVar) {
        AAO = qVar;
    }

    public static void bk(int i, String str) {
        if (AAO != null) {
            AAO.k(i, str);
        }
    }

    public static void gC(long j) {
        if (AAO != null) {
            AAO.h(j, 1);
        }
    }

    public static void cJv() {
        if (AAO != null) {
            AAO.h(0, 1);
        }
    }

    public static void cJw() {
        if (AAO != null) {
            AAO.h(1, 1);
        }
    }

    public static void gD(long j) {
        if (AAO != null && j > 0 && j < 300000) {
            AAO.w(2, 3, (int) j);
        }
    }

    public static void cJx() {
        if (AAO != null) {
            AAO.h(46, 1);
        }
    }

    public static void cJy() {
        if (AAO != null) {
            AAO.h(47, 1);
        }
    }

    public static void gE(long j) {
        if (AAO != null && j > 0 && j < 300000) {
            AAO.w(48, 49, (int) j);
        }
    }

    public static void cJz() {
        if (AAO != null) {
            AAO.h(42, 1);
        }
    }

    public static void cJA() {
        if (AAO != null) {
            AAO.h(43, 1);
        }
    }

    public static void gF(long j) {
        if (AAO != null && j > 0 && j < 300000) {
            AAO.w(44, 45, (int) j);
        }
    }

    public static void dP(String str, int i) {
        if (AAO != null) {
            cJv();
            frp = UUID.randomUUID().toString().replace("-", "");
            AAO.h(4, 1);
            AAO.a(XWalkEnvironment.getAvailableVersion(), adb(str), frp, g.cJf() == null ? 100 : g.cJf().ordinal(), 0, 0, 0, i);
        }
    }

    public static void c(String str, int i, long j, int i2) {
        if (AAO != null) {
            cJw();
            AAO.h(5, 1);
            AAO.k(15003, "");
            AAO.a(XWalkEnvironment.getAvailableVersion(), adb(str), frp, g.cJf() == null ? 100 : g.cJf().ordinal(), 1, i, (int) j, i2);
        }
    }

    public static void j(String str, long j, int i) {
        gD(j);
        if (AAO != null && j > 0 && j < 300000) {
            AAO.w(6, 7, (int) j);
            AAO.a(XWalkEnvironment.getAvailableVersion(), adb(str), frp, g.cJf() == null ? 100 : g.cJf().ordinal(), 1, 0, (int) j, i);
        }
    }

    public static int adb(String str) {
        if (str.startsWith("https://servicewechat.com/")) {
            return 0;
        }
        if (str.startsWith("http://mp.weixin.qq.com/") || str.startsWith("https://mp.weixin.qq.com/") || str.startsWith("https://servicewechat.com/preload/") || str.startsWith("http://mp.weixinbridge.com/")) {
            return 1;
        }
        return 2;
    }

    public static void cJB() {
        if (AAO != null) {
            AAO.h(9, 1);
        }
    }

    public static void gG(long j) {
        if (AAO != null && AAO != null && j > 0 && j < 600000) {
            AAO.w(11, 12, (int) j);
        }
    }

    public static void cJC() {
        if (AAO != null) {
            AAO.h(10, 1);
        }
    }

    public static void cJD() {
        if (AAO != null) {
            AAO.h(20, 1);
        }
    }

    public static void gH(long j) {
        if (AAO != null && AAO != null && j > 0 && j < 600000) {
            AAO.w(22, 23, (int) j);
        }
    }

    public static void cJE() {
        if (AAO != null) {
            AAO.h(21, 1);
        }
    }

    public static void cJF() {
        if (AAO != null) {
            AAO.h(25, 1);
        }
    }

    public static void gI(long j) {
        if (AAO != null && AAO != null && j > 0 && j < 600000) {
            AAO.w(27, 28, (int) j);
        }
    }

    public static void cJG() {
        if (AAO != null) {
            AAO.h(26, 1);
        }
    }

    public static void cJH() {
        if (AAO != null) {
            AAO.h(14, 1);
        }
    }

    public static void cJI() {
        if (AAO != null) {
            AAO.h(15, 1);
        }
    }

    public static void gJ(long j) {
        if (AAO != null && AAO != null && j > 0 && j < 120000) {
            AAO.w(16, 17, (int) j);
        }
    }

    public static void cJJ() {
        if (AAO != null) {
            AAO.h(83, 1);
        }
    }

    public static void c(c cVar) {
        if (AAO != null) {
            int i;
            switch (cVar) {
                case WV_KIND_CW:
                    i = 82;
                    break;
                case WV_KIND_X5:
                    i = 81;
                    break;
                case WV_KIND_SYS:
                    i = 80;
                    break;
                default:
                    return;
            }
            AAO.h((long) i, 1);
        }
    }

    public static void cJK() {
        if (AAO != null) {
            AAO.h(87, 1);
        }
    }

    public static void d(c cVar) {
        if (AAO != null) {
            int i;
            switch (cVar) {
                case WV_KIND_CW:
                    i = 86;
                    break;
                case WV_KIND_X5:
                    i = 85;
                    break;
                case WV_KIND_SYS:
                    i = 84;
                    break;
                default:
                    return;
            }
            AAO.h((long) i, 1);
        }
    }

    public static void cJL() {
        if (AAO != null) {
            AAO.h(88, 1);
        }
    }
}
