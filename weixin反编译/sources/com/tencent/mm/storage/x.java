package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.k.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;

public final class x extends a implements Cloneable {
    public String xGq = null;
    public CharSequence xuN;

    public x(String str) {
        super(str);
    }

    public static boolean Xd(String str) {
        return str != null ? str.endsWith("@t.qq.com") : false;
    }

    public static boolean Xe(String str) {
        return str != null ? str.endsWith("@qr") : false;
    }

    public static boolean Xf(String str) {
        return str != null ? str.endsWith("@qqim") : false;
    }

    public static boolean Xg(String str) {
        return str != null ? str.endsWith("@openim") : false;
    }

    public static boolean Xh(String str) {
        return str != null ? str.endsWith("@fb") : false;
    }

    public static boolean gB(String str) {
        if (str != null) {
            return str.contains("@bottle:") || str.endsWith("@bottle");
        } else {
            return false;
        }
    }

    public static boolean DG(int i) {
        return (i & 8) > 0;
    }

    public static boolean fX(String str) {
        return str != null ? str.endsWith("@app") : false;
    }

    public static boolean Xi(String str) {
        if (bi.oN(str)) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Contact", "Contact invisibleUsername username == null or nil");
            return false;
        } else if (Xg(str)) {
            return true;
        } else {
            String F = ((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).Ag().F("HideWechatID", "idprefix");
            if (F == null) {
                return false;
            }
            String[] split = F.split(";");
            int i = 0;
            while (i < split.length) {
                if (split[i] != null && str.startsWith(split[i])) {
                    return true;
                }
                i++;
            }
            return false;
        }
    }

    public static boolean Xj(String str) {
        if (bi.oN(str)) {
            return true;
        }
        for (String str2 : "wx_;wxid_;gh_;a0;a1;a2;a3;a4;a5;a6;a7;a8;a9;q0;q1;q2;q3;q4;q5;q6;q7;q8;q9;qq0;qq1;qq2;qq3;qq4;qq5;qq6;qq7;qq8;qq9;f0;f1;f2;f3;f4;f5;f6;f7;f8;f9;F0;F1;F2;F3;F4;F5;F6;F7;F8;F9;".split(";")) {
            if (!bi.oN(str2) && str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean ciM() {
        return false;
    }

    public static String Xk(String str) {
        if (gB(str)) {
            String[] split = str.split(":");
            if (split == null || split.length <= 0) {
                return str;
            }
            return split[0];
        } else if (str == null || !str.contains("@")) {
            return str + "@bottle";
        } else {
            return "";
        }
    }

    public final boolean ciN() {
        return (this.field_verifyFlag & 8) > 0;
    }

    public static int ciO() {
        return 16;
    }

    public static int ciP() {
        return 8;
    }

    public final boolean ciQ() {
        return ((long) (((int) bi.Wx()) - this.fXr)) > 86400;
    }

    public static String k(Cursor cursor) {
        return cursor.getString(cursor.getColumnIndex("username"));
    }

    public final void dv(String str) {
        super.dv(str);
        ciS();
    }

    public final String getCountryCode() {
        String str = this.fXq;
        if (bi.oN(str)) {
            return "";
        }
        String[] split = str.split("_");
        if (split == null || split.length <= 0) {
            return "";
        }
        return bi.oM(split[0]);
    }

    public final String ciR() {
        String str = this.fXq;
        if (bi.oN(str)) {
            return "";
        }
        String[] split = str.split("_");
        if (split == null || split.length < 2) {
            return "";
        }
        return bi.oM(split[1]);
    }

    public final String getCityCode() {
        String str = this.fXq;
        if (bi.oN(str)) {
            return "";
        }
        String[] split = str.split("_");
        if (split == null || split.length < 3) {
            return "";
        }
        return bi.oM(split[2]);
    }

    @Deprecated
    public final void dq(String str) {
        super.dq(str);
    }

    @Deprecated
    public final void dr(String str) {
        super.dr(str);
    }

    public final String getProvince() {
        return super.getProvince();
    }

    public final String getCity() {
        return super.getCity();
    }

    public final void ciS() {
        String str = this.fXq;
        if (!bi.oN(str)) {
            String[] split = str.split("_");
            if (split.length <= 0) {
                return;
            }
            if (split.length > 2) {
                if (RegionCodeDecoder.Yl(split[0])) {
                    super.dq(RegionCodeDecoder.ckE().fK(split[0], split[1]));
                } else {
                    super.dq(RegionCodeDecoder.ckE().Ym(split[0]));
                }
                super.dr(RegionCodeDecoder.ckE().aj(split[0], split[1], split[2]));
            } else if (split.length == 2) {
                super.dq(RegionCodeDecoder.ckE().Ym(split[0]));
                super.dr(RegionCodeDecoder.ckE().fK(split[0], split[1]));
            } else {
                super.dq(RegionCodeDecoder.ckE().Ym(split[0]));
                super.dr("");
            }
        }
    }

    public final x ciT() {
        try {
            return (x) super.clone();
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.Contact", e, "", new Object[0]);
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Contact", "clone Contact error. e: " + e.toString());
            return null;
        }
    }
}
