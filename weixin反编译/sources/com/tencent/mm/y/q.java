package com.tencent.mm.y;

import android.graphics.BitmapFactory.Options;
import com.tencent.mm.a.e;
import com.tencent.mm.a.o;
import com.tencent.mm.ax.m;
import com.tencent.mm.k.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.w;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

public final class q {
    public static boolean gt(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        String FY = FY();
        if (FY != null && FY.length() > 0) {
            return FY.equals(str);
        }
        x.e("MicroMsg.ConfigStorageLogic", "get userinfo fail");
        return false;
    }

    public static int FX() {
        g.Dr();
        Integer num = (Integer) g.Dq().Db().get(9, null);
        return num == null ? 0 : num.intValue();
    }

    public static String getUserBindEmail() {
        g.Dr();
        return bi.oM((String) g.Dq().Db().get(5, null));
    }

    public static String FY() {
        g.Dr();
        return (String) g.Dq().Db().get(2, null);
    }

    public static String FZ() {
        g.Dr();
        return (String) g.Dq().Db().get(42, null);
    }

    public static String Ga() {
        g.Dr();
        return (String) g.Dq().Db().get(4, null);
    }

    public static String Gb() {
        String FZ = FZ();
        return !bi.oN(FZ) ? FZ : FY();
    }

    public static int Gc() {
        g.Dr();
        Integer num = (Integer) g.Dq().Db().get(7, null);
        return num == null ? 0 : num.intValue();
    }

    public static long Gd() {
        g.Dr();
        Long l = (Long) g.Dq().Db().get(147457, null);
        return l == null ? 0 : l.longValue();
    }

    public static int Ge() {
        g.Dr();
        Integer num = (Integer) g.Dq().Db().get(40, null);
        return num == null ? 0 : num.intValue();
    }

    public static int Gf() {
        g.Dr();
        Integer num = (Integer) g.Dq().Db().get(339975, null);
        return num == null ? 0 : num.intValue();
    }

    public static boolean gM(int i) {
        return (i & 8192) != 0;
    }

    public static boolean Gg() {
        return (Ge() & 16384) != 0;
    }

    public static boolean Gh() {
        return (Ge() & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0;
    }

    public static void Gi() {
        int Ge = Ge() | WXMediaMessage.THUMB_LENGTH_LIMIT;
        g.Dr();
        g.Dq().Db().set(40, Integer.valueOf(Ge));
    }

    public static int Gj() {
        g.Dr();
        Integer num = (Integer) g.Dq().Db().get(34, null);
        return num == null ? 0 : num.intValue();
    }

    public static boolean Gk() {
        boolean z;
        if ((Gc() & 262144) != 0) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.ConfigStorageLogic", "isGooglePay: %s  User Status: %d", Boolean.valueOf(z), Integer.valueOf(Gc()));
        return z;
    }

    public static boolean Gl() {
        g.Dr();
        g.Dq().Db().lO(true);
        if (Gf() == 1) {
            return true;
        }
        return false;
    }

    public static boolean Gm() {
        g.Dr();
        g.Dq().Db().lO(true);
        if (Gf() == 2) {
            return true;
        }
        return false;
    }

    public static boolean Gn() {
        g.Dr();
        g.Dq().Db().lO(true);
        if (Gf() == 4) {
            return true;
        }
        return false;
    }

    public static boolean Go() {
        return (Gj() & 32) == 0;
    }

    public static boolean Gp() {
        return (Gc() & Downloads.RECV_BUFFER_SIZE) != 0;
    }

    public static boolean Gq() {
        bc FE = ((h) g.h(h.class)).Fn().FE("@t.qq.com");
        return FE != null && FE.isEnable();
    }

    public static boolean Gr() {
        return (Gj() & 2) == 0;
    }

    public static boolean Gs() {
        return (Gj() & 16) == 0;
    }

    public static boolean Gt() {
        return (Gj() & FileUtils.S_IWUSR) == 0;
    }

    public static boolean Gu() {
        g.Dr();
        return bi.c((Boolean) g.Dq().Db().get(8200, null));
    }

    public static boolean Gv() {
        return (Gj() & SQLiteGlobal.journalSizeLimit) == 0;
    }

    public static boolean Gw() {
        return (Gj() & 262144) == 0;
    }

    public static boolean Gx() {
        return (Gj() & 8192) == 0;
    }

    public static boolean Gy() {
        return (Gj() & 65536) == 0;
    }

    public static boolean Gz() {
        g.Dr();
        String str = (String) g.Dq().Db().get(65825, null);
        if (bi.oN(str)) {
            return false;
        }
        if (str.equals("0")) {
            return false;
        }
        try {
            if (bi.c(Long.valueOf(bi.getLong(str, 0))) == 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean GA() {
        return (Gj() & 1) == 0;
    }

    public static boolean GB() {
        return (Gc() & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == 0;
    }

    public static int GC() {
        g.Dr();
        return bi.a((Integer) g.Dq().Db().get(8201, null), 22);
    }

    public static int GD() {
        g.Dr();
        return bi.a((Integer) g.Dq().Db().get(8208, null), 8);
    }

    public static com.tencent.mm.storage.x GE() {
        a Xv = ((h) g.h(h.class)).Ff().Xv(FY());
        if (Xv != null && ((int) Xv.gKO) > 0) {
            return Xv;
        }
        com.tencent.mm.storage.x xVar = new com.tencent.mm.storage.x();
        g.Dr();
        String str = (String) g.Dq().Db().get(2, null);
        g.Dr();
        String str2 = (String) g.Dq().Db().get(4, null);
        xVar.setUsername(str);
        xVar.dc(str2);
        ((h) g.h(h.class)).Ff().S(xVar);
        return ((h) g.h(h.class)).Ff().Xv(str);
    }

    public static b q(int i, String str) {
        b mVar;
        switch (i) {
            case 2:
                mVar = new m(str, 1);
                break;
            case 18:
                mVar = new m(str, 2);
                break;
            default:
                mVar = null;
                break;
        }
        ((h) g.h(h.class)).Fe().b(mVar);
        return mVar;
    }

    public static boolean GF() {
        g.Dr();
        return new o(bi.e((Integer) g.Dq().Db().get(9, null))).longValue() != 0;
    }

    public static boolean a(String str, String str2, boolean z) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.ConfigStorageLogic", "canSendRawImage, invalid argument");
            return false;
        } else if (str2 != null && str2.length() > 0 && (com.tencent.mm.storage.x.Xd(str2) || com.tencent.mm.storage.x.Xf(str2))) {
            return false;
        } else {
            boolean z2;
            double d;
            double d2;
            Options options = new Options();
            if (str == null || str.length() == 0) {
                x.e("MicroMsg.ConfigStorageLogic", "isSmallImg, invalid argument");
            } else {
                if (e.bN(str) < 65536) {
                    z2 = true;
                } else {
                    options.inJustDecodeBounds = true;
                    MMBitmapFactory.decodeFile(str, options, null, 0, new int[0]);
                    d = (double) options.outWidth;
                    double d3 = (double) options.outHeight;
                    if (d < 100.0d && d3 < 100.0d) {
                        x.i("MicroMsg.ConfigStorageLogic", "isSmallImg : true, width = " + d + ", height = " + d3);
                        z2 = true;
                    }
                }
                if (z2) {
                    d = (double) options.outWidth;
                    d2 = (double) options.outHeight;
                    if (d / d2 < 2.5d || d2 / d >= 2.5d) {
                        if (e.bN(str) >= 26214400) {
                            x.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : true, width height ratio > %s, imgSize:[%s]", Double.valueOf(2.5d), Integer.valueOf(e.bN(str)));
                            return true;
                        }
                        x.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : false, width height ratio > %s, imgSize:[%s]", Double.valueOf(2.5d), Integer.valueOf(e.bN(str)));
                        return false;
                    } else if (z) {
                        return false;
                    } else {
                        return true;
                    }
                }
                x.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : true. isSmallImg");
                return true;
            }
            z2 = false;
            if (z2) {
                d = (double) options.outWidth;
                d2 = (double) options.outHeight;
                if (d / d2 < 2.5d) {
                }
                if (e.bN(str) >= 26214400) {
                    x.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : false, width height ratio > %s, imgSize:[%s]", Double.valueOf(2.5d), Integer.valueOf(e.bN(str)));
                    return false;
                }
                x.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : true, width height ratio > %s, imgSize:[%s]", Double.valueOf(2.5d), Integer.valueOf(e.bN(str)));
                return true;
            }
            x.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : true. isSmallImg");
            return true;
        }
    }

    public static void a(int i, Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : map.entrySet()) {
            stringBuilder.append(String.format(Locale.US, "%s\n%s\n", new Object[]{entry.getKey(), entry.getValue()}));
        }
        g.Dr();
        if (g.Dq() != null) {
            g.Dr();
            if (g.Dq().Db() != null) {
                g.Dr();
                g.Dq().Db().set(327682, stringBuilder.toString());
            }
        }
    }

    public static void b(int i, Map<String, String> map) {
        map.clear();
        g.Dr();
        if (g.Dq() != null) {
            g.Dr();
            if (g.Dq().Db() != null) {
                g.Dr();
                String str = (String) g.Dq().Db().get(327682, null);
                if (str != null) {
                    String[] split = str.split("\n");
                    if (split.length % 2 != 0) {
                        x.e("MicroMsg.ConfigStorageLogic", "key and value not match, len: " + String.valueOf(split.length));
                        return;
                    }
                    for (int i2 = 0; i2 < split.length; i2 += 2) {
                        map.put(split[i2], split[i2 + 1]);
                    }
                    return;
                }
                return;
            }
        }
        x.d("MicroMsg.ConfigStorageLogic", "acc stg is null");
    }

    public static Boolean GG() {
        if (g.Do().CF()) {
            g.Dr();
            String str = (String) g.Dq().Db().get(6, null);
            g.Dr();
            if (!Boolean.valueOf(bi.c((Boolean) g.Dq().Db().get(340241, null))).booleanValue() || bi.oN(str)) {
                return Boolean.valueOf(false);
            }
            String str2 = "86";
            if (str.startsWith("+")) {
                str = ap.DK(str);
            } else {
                str = str2;
            }
            if (str == "86") {
                return Boolean.valueOf(false);
            }
            return Boolean.valueOf(true);
        }
        x.e("MicroMsg.ConfigStorageLogic", "mmcore has not ready");
        return Boolean.valueOf(false);
    }

    public static Map<String, String> GH() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("login_weixin_username", FY());
        g.Dr();
        hashMap.put("login_user_name", (String) g.Dq().Db().get(w.a.USERINFO_LAST_LOGIN_USERNAME_STRING, null));
        g.Dr();
        hashMap.put("last_avatar_path", (String) g.Dq().Db().get(w.a.USERINFO_LAST_LOGIN_AVATAR_PATH_STRING, null));
        g.Dr();
        hashMap.put("last_login_bind_mobile", (String) g.Dq().Db().get(6, null));
        g.Dr();
        hashMap.put("last_login_bind_email", (String) g.Dq().Db().get(5, null));
        g.Dr();
        hashMap.put("last_login_bind_qq", String.valueOf(g.Dq().Db().get(9, null)));
        g.Dr();
        hashMap.put("last_login_use_voice", String.valueOf(g.Dq().Db().get(40, null)));
        return hashMap;
    }
}
