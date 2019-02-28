package com.tencent.mm.y;

import com.tencent.mm.a.e;
import com.tencent.mm.bp.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.asw;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.wcdb.FileUtils;

public final class bj {
    public String countryCode = "";
    public int fXa = 0;
    public int fXj = 0;
    public String fXo = "";
    private String hje = "";
    private String hjf = "";
    public String hjg = "";
    public String hjh = "";
    public String signature = "";

    private static class a {
        public static boolean U(String str, String str2) {
            if (bi.oN(str)) {
                return true;
            }
            String decode = decode(encode(str));
            if (bi.oN(decode) || !decode.equals(str2)) {
                return true;
            }
            return false;
        }

        private static String encode(String str) {
            char[] toCharArray = str.toCharArray();
            String str2 = "";
            try {
                int length = toCharArray.length;
                String str3 = str2;
                int i = 0;
                while (i < length) {
                    char c = toCharArray[i];
                    i++;
                    str3 = str3 + String.format("%02x", new Object[]{Integer.valueOf(c)});
                }
                return str3;
            } catch (Exception e) {
                return "";
            }
        }

        private static String decode(String str) {
            String str2 = "";
            if (bi.oN(str) || str.length() % 2 != 0) {
                return "";
            }
            String str3 = str2;
            int i = 0;
            while (i < str.length()) {
                try {
                    String str4 = str3 + ((char) Integer.parseInt(str.substring(i, i + 2), 16));
                    i += 2;
                    str3 = str4;
                } catch (Exception e) {
                    return "";
                }
            }
            return str3;
        }
    }

    public static bj HW() {
        bj bjVar = new bj();
        bjVar.fXj = 1;
        bjVar.fXa = bi.a((Integer) g.Dq().Db().get(12290, null), 0);
        bjVar.hje = (String) g.Dq().Db().get(12293, null);
        bjVar.hjf = (String) g.Dq().Db().get(12292, null);
        bjVar.signature = (String) g.Dq().Db().get(12291, null);
        bjVar.fXo = (String) g.Dq().Db().get(12307, null);
        bjVar.countryCode = (String) g.Dq().Db().get(12324, null);
        bjVar.hjh = (String) g.Dq().Db().get(12325, null);
        bjVar.hjg = (String) g.Dq().Db().get(12326, null);
        return bjVar;
    }

    public static bj HX() {
        if (bi.a((Integer) g.Dq().Db().get(12289, null), 0) == 0) {
            return null;
        }
        return HW();
    }

    public static asw a(bj bjVar) {
        g.Dq().Db().set(12289, Integer.valueOf(bjVar.fXj));
        g.Dq().Db().set(12290, Integer.valueOf(bjVar.fXa));
        if (a.U((String) g.Dq().Db().get(12293, null), bjVar.getProvince())) {
            g.Dq().Db().set(12293, bjVar.getProvince());
        }
        if (a.U((String) g.Dq().Db().get(12292, null), bjVar.getCity())) {
            g.Dq().Db().set(12292, bjVar.getCity());
        }
        if (a.U((String) g.Dq().Db().get(12291, null), bjVar.signature)) {
            g.Dq().Db().set(12291, bjVar.signature);
        }
        if (a.U((String) g.Dq().Db().get(12307, null), bjVar.fXo)) {
            g.Dq().Db().set(12307, bjVar.fXo);
        }
        if (a.U((String) g.Dq().Db().get(12324, null), bjVar.countryCode)) {
            g.Dq().Db().set(12324, bjVar.countryCode);
        }
        if (a.U((String) g.Dq().Db().get(12325, null), bjVar.hjh)) {
            g.Dq().Db().set(12325, bjVar.hjh);
        }
        if (a.U((String) g.Dq().Db().get(12326, null), bjVar.hjg)) {
            g.Dq().Db().set(12326, bjVar.hjg);
        }
        asw asw = new asw();
        asw.wHd = FileUtils.S_IWUSR;
        asw.wfM = new bet().Vf("");
        asw.wzM = new bet().Vf("");
        asw.vMd = 0;
        asw.wHe = new bet().Vf("");
        asw.wHf = new bet().Vf("");
        asw.kyY = 0;
        byte[] d = e.d("", 0, -1);
        asw.wHb = new b(d == null ? new byte[0] : d);
        asw.wHa = d == null ? 0 : d.length;
        asw.hxe = bjVar.fXa;
        asw.hxi = bjVar.fXj;
        asw.hxh = bi.oM(bjVar.signature);
        asw.hxg = bi.oM(bjVar.hjg);
        asw.hxf = bi.oM(bjVar.hjh);
        asw.vMg = 0;
        asw.wCs = bi.oM(bjVar.fXo);
        asw.wHk = 0;
        asw.hxj = "";
        asw.wCu = 0;
        asw.wCt = "";
        asw.hxn = bi.oM(bjVar.countryCode);
        return asw;
    }

    public final String getCity() {
        if (!bi.oN(this.countryCode)) {
            if (bi.oN(this.hjh)) {
                this.hjf = "";
            } else if (bi.oN(this.hjg)) {
                this.hjf = RegionCodeDecoder.ckE().fK(this.countryCode, this.hjh);
            } else {
                this.hjf = RegionCodeDecoder.ckE().aj(this.countryCode, this.hjh, this.hjg);
            }
        }
        if (bi.oN(this.hjf)) {
            return bi.oM(this.hjg);
        }
        return this.hjf;
    }

    public final String getProvince() {
        if (!bi.oN(this.countryCode)) {
            if (bi.oN(this.hjh) || bi.oN(this.hjg) || !RegionCodeDecoder.Yl(this.countryCode)) {
                this.hje = RegionCodeDecoder.ckE().Ym(this.countryCode);
            } else {
                this.hje = RegionCodeDecoder.ckE().fK(this.countryCode, this.hjh);
            }
        }
        return bi.oN(this.hje) ? bi.oM(this.hjh) : this.hje;
    }
}
