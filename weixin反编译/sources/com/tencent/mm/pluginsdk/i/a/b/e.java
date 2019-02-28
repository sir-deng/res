package com.tencent.mm.pluginsdk.i.a.b;

import com.tencent.mm.protocal.c.bed;
import com.tencent.mm.protocal.c.bef;
import com.tencent.mm.protocal.c.beg;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Locale;
import java.util.Map;

public final class e {
    public static void ba(String str, boolean z) {
        x.d("MicroMsg.CheckResUpdateNewXmlParser", "receive msg: \n" + str);
        if (!bi.oN(str)) {
            Map y = bj.y(str, "sysmsg");
            j.o(0, 0);
            String str2 = "MicroMsg.CheckResUpdateNewXmlParser";
            String str3 = "parsed values.size = %s";
            Object[] objArr = new Object[1];
            objArr[0] = y == null ? "null" : String.valueOf(y.size());
            x.i(str2, str3, objArr);
            if (y == null) {
                j.o(0, 30);
            } else {
                j.o(0, 31);
            }
            if (y != null && y.size() > 0 && bi.oM((String) y.get(".sysmsg.$type")).equalsIgnoreCase("resourcemgr")) {
                b(".sysmsg", "delete", y, z);
                b(".sysmsg", "cache", y, z);
                b(".sysmsg", "decrypt", y, z);
            }
        }
    }

    private static boolean r(String str, Map<String, String> map) {
        if (map.get(str) == null && map.get(str + ".resType") == null && map.get(str + ".subType") == null) {
            return true;
        }
        return false;
    }

    private static void b(String str, String str2, Map<String, String> map, boolean z) {
        if (!r(String.format("%s.%s", new Object[]{str, str2}), map)) {
            int c = c(str, str2, map, z) | 0;
            int i = 0;
            while (true) {
                i++;
                if (r(String.format(Locale.US, "%s.%s%d", new Object[]{str, str2, Integer.valueOf(i)}), map)) {
                    break;
                }
                c |= c(str, str2, map, z);
            }
            i = b.Sy(str2);
            if (b.Ce(i)) {
                j.o(0, 32);
                if (c == 0) {
                    j.o(0, 33);
                }
            } else if (b.Cf(i)) {
                j.o(0, 35);
                if (c == 0) {
                    j.o(0, 36);
                }
            } else if (b.Cg(i)) {
                j.o(0, 38);
                if (c == 0) {
                    j.o(0, 39);
                }
            }
        }
    }

    private static boolean c(String str, String str2, Map<String, String> map, boolean z) {
        String format = String.format("%s.%s.%s", new Object[]{str, str2, "Resource"});
        int Sy = b.Sy(str2);
        if (r(format, map)) {
            return true;
        }
        boolean a = a(Sy, format, map, z) | 0;
        int i = 0;
        while (true) {
            i++;
            String format2 = String.format(Locale.US, "%s.%s.%s%d", new Object[]{str, str2, "Resource", Integer.valueOf(i)});
            if (r(format2, map)) {
                return a;
            }
            a |= a(Sy, format2, map, z);
        }
    }

    private static boolean a(int i, String str, Map<String, String> map, boolean z) {
        boolean z2 = false;
        if (map.get(str + ".resType") == null && map.get(str + ".subType") == null) {
            return true;
        }
        int i2;
        int i3;
        bed bed;
        if (b.Cg(i)) {
            x.d("MicroMsg.CheckResUpdateNewXmlParser", "handleResourceDelete()");
            i2 = bi.getInt((String) map.get(str + ".resType"), -1);
            i3 = bi.getInt((String) map.get(str + ".subType"), -1);
            if (-1 == i2 || -1 == i3) {
                return false;
            }
            bed = new bed();
            bed.wMK = i3;
            bed.wQK = new beg();
            bed.wQK.wQU = bi.getInt((String) map.get(str + ".resVer"), 0);
            bed.wQN = (String) map.get(str + ".sampleID");
            bed.wQM = bi.getInt((String) map.get(str + ".reportID"), 0);
            bed.wsu = b.DoDelete.fEo;
            c.vnr.a(i2, bed, true);
            j.o((long) bed.wQM, 40);
            return true;
        } else if (b.Ce(i)) {
            x.d("MicroMsg.CheckResUpdateNewXmlParser", "handleResourceCache()");
            String str2 = (String) map.get(str + ".CDNUrl");
            int i4 = bi.getInt((String) map.get(str + ".subType"), -1);
            int i5 = bi.getInt((String) map.get(str + ".resType"), -1);
            String str3 = (String) map.get(str + ".md5");
            int i6 = bi.getInt((String) map.get(str + ".priority"), 0);
            if (bi.oN(str2) || bi.oN(str3) || -1 == i4 || -1 == i5 || i6 < 0) {
                return false;
            }
            int cac;
            bed bed2 = new bed();
            bed2.wQK = new beg();
            if (bi.getInt((String) map.get(str + ".fileEncrypt"), 0) > 0) {
                cac = a.cac();
            } else {
                cac = 0;
            }
            if (bi.getInt((String) map.get(str + ".fileCompress"), 0) > 0) {
                cac = a.Cc(cac);
            }
            bed2.wMK = i4;
            bed2.wQP = bi.getInt((String) map.get(str + ".networkType"), 2);
            bed2.vXe = bi.getInt((String) map.get(str + ".expireTime"), 1);
            bed2.wQK.nlE = str2;
            bed2.wQK.wQU = bi.getInt((String) map.get(str + ".resVer"), 0);
            bed2.wQK.wgY = str3;
            bed2.wQK.wQX = (String) map.get(str + ".originalmd5");
            bed2.wQK.wQV = cac;
            bed2.wQK.wQW = null;
            bed2.wQK.wgG = null;
            bed2.wyO = i6;
            bed2.wsu = b.DoCache.fEo;
            bed2.wQM = bi.getInt((String) map.get(str + ".reportID"), 0);
            bed2.wQN = (String) map.get(str + ".sampleID");
            bed2.wQO = bi.getInt((String) map.get(str + ".retryTime"), 3);
            bed2.wQQ = bi.getInt((String) map.get(str + ".retryInterval"), 0);
            bed2.vnv = 0;
            c.vnr.b(i5, bed2, true);
            j.o((long) bed2.wQM, 34);
            return true;
        } else if (!b.Cf(i)) {
            return false;
        } else {
            x.d("MicroMsg.CheckResUpdateNewXmlParser", "handleResourceDecrypt()");
            i2 = bi.getInt((String) map.get(str + ".resType"), -1);
            i3 = bi.getInt((String) map.get(str + ".subType"), -1);
            if (-1 == i2 || -1 == i3) {
                return false;
            }
            bed = new bed();
            bed.wQL = new bef();
            bed.wMK = i3;
            bed.wQL.wQT = (String) map.get(str + ".resKey");
            bed.wQL.wQS = bi.getInt((String) map.get(str + ".resKeyVersion"), 0);
            bed.wQN = (String) map.get(str + ".sampleID");
            bed.wQM = bi.getInt((String) map.get(str + ".reportID"), 0);
            bed.wsu = b.DoDecrypt.fEo;
            bed.wQK = new beg();
            bed.wQK.wQX = (String) map.get(str + ".originalmd5");
            b bZZ = c.vnr;
            if (!z) {
                z2 = true;
            }
            bZZ.a(i2, bed, true, z2);
            j.o((long) bed.wQM, 37);
            return true;
        }
    }
}
