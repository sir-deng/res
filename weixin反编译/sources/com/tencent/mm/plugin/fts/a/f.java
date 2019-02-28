package com.tencent.mm.plugin.fts.a;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.HashMap;

public final class f {
    public static HashMap<String, String> ieX = new HashMap();
    public static final a mQA = new a(19968, 40869);
    public static final a mQB = new a(40870, 40907);
    public static final a mQC = new a(13312, 19893);
    public static final a mQD = new a(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 173782);
    public static final a mQE = new a(173824, 177972);
    public static final a mQF = new a(177984, 178205);
    public static final a mQG = new a(12032, 12245);
    public static final a mQH = new a(63744, 64217);
    public static final a mQI = new a(194560, 195101);
    public static final a mQJ = new a(59413, 59503);
    public static final a mQK = new a(58368, 58856);
    public static final a mQL = new a(58880, 59087);
    public static final a mQM = new a(12736, 12771);
    public static final a mQN = new a(12272, 12283);
    public static final a mQO = new a(12549, 12576);
    public static final a mQP = new a(12704, 12730);
    public static final a mQQ = new a(65, 90);
    public static final a mQR = new a(97, 122);
    public static final a mQS = new a(48, 57);
    public static b mQT = new b();
    public static HashMap<String, String[]> mQU = new HashMap();

    public static class a {
        int bottom;
        int up;

        public a(int i, int i2) {
            this.bottom = i;
            this.up = i2;
        }

        public final boolean l(char c) {
            return c >= this.bottom && c <= this.up;
        }
    }

    public static boolean i(char c) {
        return mQA.l(c) || mQB.l(c) || mQC.l(c) || mQD.l(c) || mQE.l(c) || mQF.l(c);
    }

    public static boolean j(char c) {
        return mQQ.l(c) || mQR.l(c);
    }

    public static boolean k(char c) {
        return mQS.l(c);
    }

    public static final String BK(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (char c : str.toCharArray()) {
            if (i(c)) {
                String str2 = (String) ieX.get(String.valueOf(c));
                if (!bi.oN(str2)) {
                    stringBuffer.append(str2);
                }
            }
            stringBuffer.append(c);
        }
        return stringBuffer.toString();
    }
}
