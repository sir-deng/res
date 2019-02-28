package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.sdk.platformtools.bi;
import java.util.Map;

public final class f {
    public static String r(Map<String, Object> map, String str) {
        if (map.containsKey(str)) {
            return map.get(str) != null ? map.get(str).toString() : "";
        } else {
            return "";
        }
    }

    public static boolean t(Map<String, Object> map, String str) {
        String r = r(map, str);
        if (bi.oN(r)) {
            return false;
        }
        try {
            if ("1".equals(r)) {
                return true;
            }
            if ("0".equals(r)) {
                return false;
            }
            return Boolean.valueOf(r).booleanValue();
        } catch (Exception e) {
            return false;
        }
    }

    public static int c(Map<String, Object> map, String str, int i) {
        String r = r(map, str);
        if (bi.oN(r)) {
            return i;
        }
        try {
            return Integer.valueOf(r).intValue();
        } catch (Exception e) {
            return i;
        }
    }

    public static long a(Map<String, Object> map, String str, long j) {
        String r = r(map, str);
        if (bi.oN(r)) {
            return j;
        }
        try {
            return Long.valueOf(r).longValue();
        } catch (Exception e) {
            return j;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final org.json.JSONObject a(com.tencent.mm.plugin.fts.a.a.j r11, java.lang.String r12, java.util.List<java.lang.String> r13) {
        /*
        r5 = 0;
        r2 = 0;
        r1 = 1;
        com.tencent.mm.y.as.Hm();
        r0 = com.tencent.mm.y.c.Ff();
        r3 = r11.mRd;
        r8 = r0.Xv(r3);
        r0 = r11.mRd;
        r4 = com.tencent.mm.y.r.gw(r0);
        r0 = r11.mRc;
        switch(r0) {
            case 1: goto L_0x012f;
            case 2: goto L_0x012c;
            case 3: goto L_0x0069;
            case 4: goto L_0x0086;
            case 5: goto L_0x0136;
            case 6: goto L_0x0133;
            case 7: goto L_0x0072;
            case 8: goto L_0x001b;
            case 9: goto L_0x001b;
            case 10: goto L_0x001b;
            case 11: goto L_0x0106;
            case 12: goto L_0x001b;
            case 13: goto L_0x001b;
            case 14: goto L_0x001b;
            case 15: goto L_0x0097;
            case 16: goto L_0x00b3;
            case 17: goto L_0x00f4;
            case 18: goto L_0x00e2;
            default: goto L_0x001b;
        };
    L_0x001b:
        r3 = r2;
        r6 = r2;
        r0 = r5;
        r7 = r5;
        r5 = r2;
    L_0x0020:
        if (r6 == 0) goto L_0x0127;
    L_0x0022:
        if (r3 == 0) goto L_0x0118;
    L_0x0024:
        r1 = com.tencent.mm.bb.b.a(r4, r13, r2, r12);
    L_0x0028:
        if (r5 == 0) goto L_0x0041;
    L_0x002a:
        if (r3 == 0) goto L_0x011e;
    L_0x002c:
        r0 = com.tencent.mm.bb.b.a(r0, r13, r2, r12);
    L_0x0030:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2 = r2.append(r7);
        r0 = r2.append(r0);
        r0 = r0.toString();
    L_0x0041:
        r2 = new org.json.JSONObject;
        r2.<init>();
        r3 = "nickName";
        r4 = com.tencent.mm.y.r.c(r8);	 Catch:{ JSONException -> 0x0124 }
        r2.put(r3, r4);	 Catch:{ JSONException -> 0x0124 }
        r3 = "userName";
        r4 = r11.mRd;	 Catch:{ JSONException -> 0x0124 }
        r2.put(r3, r4);	 Catch:{ JSONException -> 0x0124 }
        if (r6 == 0) goto L_0x0060;
    L_0x005a:
        r3 = "nickNameHighlight";
        r2.put(r3, r1);	 Catch:{ JSONException -> 0x0124 }
    L_0x0060:
        if (r5 == 0) goto L_0x0068;
    L_0x0062:
        r1 = "extraHighlight";
        r2.put(r1, r0);	 Catch:{ JSONException -> 0x0124 }
    L_0x0068:
        return r2;
    L_0x0069:
        r0 = r1;
    L_0x006a:
        r3 = r1;
    L_0x006b:
        r6 = r1;
        r7 = r5;
        r10 = r0;
        r0 = r5;
        r5 = r2;
        r2 = r10;
        goto L_0x0020;
    L_0x0072:
        r0 = r1;
    L_0x0073:
        r3 = r1;
    L_0x0074:
        r5 = r8.field_nickname;
        r6 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r7 = com.tencent.mm.R.l.eIX;
        r6 = r6.getString(r7);
        r7 = r6;
        r6 = r2;
        r2 = r0;
        r0 = r5;
        r5 = r1;
        goto L_0x0020;
    L_0x0086:
        r0 = r8.fXt;
        r3 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r5 = com.tencent.mm.R.l.eIU;
        r5 = r3.getString(r5);
        r3 = r2;
        r6 = r2;
        r7 = r5;
        r5 = r1;
        goto L_0x0020;
    L_0x0097:
        r0 = r8.vU();
        r3 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r3 == 0) goto L_0x00a3;
    L_0x00a1:
        r0 = r8.field_username;
    L_0x00a3:
        r3 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r5 = com.tencent.mm.R.l.eJa;
        r5 = r3.getString(r5);
        r3 = r2;
        r6 = r2;
        r7 = r5;
        r5 = r1;
        goto L_0x0020;
    L_0x00b3:
        r3 = r11.content;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r3);
        if (r0 != 0) goto L_0x012a;
    L_0x00bb:
        r0 = "​";
        r6 = r3.split(r0);
        r7 = r6.length;
        r5 = r2;
    L_0x00c4:
        if (r5 >= r7) goto L_0x012a;
    L_0x00c6:
        r0 = r6[r5];
        r9 = r0.startsWith(r12);
        if (r9 == 0) goto L_0x00de;
    L_0x00ce:
        r3 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r5 = com.tencent.mm.R.l.eIW;
        r5 = r3.getString(r5);
        r3 = r2;
        r6 = r2;
        r7 = r5;
        r5 = r1;
        goto L_0x0020;
    L_0x00de:
        r0 = r5 + 1;
        r5 = r0;
        goto L_0x00c4;
    L_0x00e2:
        r0 = r11.content;
        r3 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r5 = com.tencent.mm.R.l.eIY;
        r5 = r3.getString(r5);
        r3 = r2;
        r6 = r2;
        r7 = r5;
        r5 = r1;
        goto L_0x0020;
    L_0x00f4:
        r0 = r11.content;
        r3 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r5 = com.tencent.mm.R.l.eIT;
        r5 = r3.getString(r5);
        r3 = r2;
        r6 = r2;
        r7 = r5;
        r5 = r1;
        goto L_0x0020;
    L_0x0106:
        r0 = r11.mRU;
        r3 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r5 = com.tencent.mm.R.l.eIZ;
        r5 = r3.getString(r5);
        r3 = r2;
        r6 = r2;
        r7 = r5;
        r5 = r1;
        goto L_0x0020;
    L_0x0118:
        r1 = com.tencent.mm.bb.b.b(r4, r13, r12);
        goto L_0x0028;
    L_0x011e:
        r0 = com.tencent.mm.bb.b.b(r0, r13, r12);
        goto L_0x0030;
    L_0x0124:
        r0 = move-exception;
        goto L_0x0068;
    L_0x0127:
        r1 = r4;
        goto L_0x0028;
    L_0x012a:
        r0 = r3;
        goto L_0x00ce;
    L_0x012c:
        r0 = r2;
        goto L_0x006a;
    L_0x012f:
        r0 = r2;
        r3 = r2;
        goto L_0x006b;
    L_0x0133:
        r0 = r2;
        goto L_0x0073;
    L_0x0136:
        r0 = r2;
        r3 = r2;
        goto L_0x0074;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.fts.f.a(com.tencent.mm.plugin.fts.a.a.j, java.lang.String, java.util.List):org.json.JSONObject");
    }
}
