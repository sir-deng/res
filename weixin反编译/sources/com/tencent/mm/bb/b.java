package com.tencent.mm.bb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.bw.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.plugin.aj.a.h;
import com.tencent.mm.plugin.aj.d;
import com.tencent.mm.plugin.fts.d.f;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import org.json.JSONObject;

public final class b {
    public static final int hMp = Color.parseColor("#45C01A");
    public static final Pattern hMq = Pattern.compile(";");

    static class a {
        int end = -1;
        int start = -1;

        a() {
        }

        final boolean isAvailable() {
            return this.start >= 0;
        }
    }

    public static Spannable a(CharSequence charSequence, String str) {
        com.tencent.mm.plugin.fts.d.b.b a = f.a(com.tencent.mm.plugin.fts.d.b.a.d(charSequence, str));
        if (a.mVW instanceof Spannable) {
            return (Spannable) a.mVW;
        }
        return new SpannableString(a.mVW);
    }

    public static Spannable a(CharSequence charSequence, List<String> list) {
        com.tencent.mm.plugin.fts.d.b.b a = f.a(com.tencent.mm.plugin.fts.d.b.a.b(charSequence, list));
        if (a.mVW instanceof Spannable) {
            return (Spannable) a.mVW;
        }
        return new SpannableString(a.mVW);
    }

    public static String b(String str, List<String> list, String str2) {
        if (bi.oN(str)) {
            return "";
        }
        if (str2 == null) {
            str2 = bi.d(list, "");
        }
        a c = c(com.tencent.mm.plugin.fts.a.f.BK(str.toString().toLowerCase()), com.tencent.mm.plugin.fts.a.f.BK(str2.toLowerCase()));
        if (c.isAvailable()) {
            return a(str, c);
        }
        c = b((CharSequence) str, bi.d(list, ""));
        if (c.isAvailable()) {
            return a(str, c);
        }
        CharSequence BK = com.tencent.mm.plugin.fts.a.f.BK(str.toString().toLowerCase());
        ArrayList arrayList = new ArrayList();
        for (String toLowerCase : list) {
            c = c(BK, com.tencent.mm.plugin.fts.a.f.BK(toLowerCase.toLowerCase()));
            if (c.isAvailable()) {
                arrayList.add(c);
            }
        }
        if (arrayList.size() <= 0) {
            return str;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            str = a(str, (a) it.next());
        }
        return str;
    }

    private static a b(CharSequence charSequence, String str) {
        String BK = com.tencent.mm.plugin.fts.a.f.BK(str.toLowerCase());
        g.chT();
        String str2 = "";
        String fF = com.tencent.mm.bw.f.chQ().fF(charSequence.toString(), str2);
        com.tencent.mm.bw.b.chK();
        a c = c(com.tencent.mm.plugin.fts.a.f.BK(com.tencent.mm.bw.b.fE(fF, str2).replaceAll(" ", "").toLowerCase()), BK);
        if (c.isAvailable()) {
            int i = c.start;
            while (i < c.end && i < charSequence.length()) {
                if (charSequence.charAt(i) == ' ') {
                    c.end++;
                }
                i++;
            }
        }
        return c;
    }

    public static String a(String str, List<String> list, boolean z, String str2) {
        if (bi.oN(str)) {
            return "";
        }
        a b = b((CharSequence) str, str2);
        if (b.isAvailable()) {
            return a(str, b);
        }
        List arrayList = new ArrayList();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (com.tencent.mm.plugin.fts.a.f.i(charAt)) {
                String g = SpellMap.g(charAt);
                if (g == null || g.length() <= 1) {
                    arrayList.add("");
                } else if (z) {
                    arrayList.add(g.substring(0, 1).toLowerCase());
                } else {
                    arrayList.add(g);
                }
            } else {
                arrayList.add("");
            }
        }
        Iterator it = c(arrayList, (List) list).iterator();
        while (it.hasNext()) {
            str = a(str, (a) it.next());
        }
        return str;
    }

    private static String a(String str, a aVar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str.substring(0, aVar.start));
        stringBuffer.append("<em class=\"highlight\">");
        stringBuffer.append(str.substring(aVar.start, aVar.end));
        stringBuffer.append("</em>");
        if (aVar.end < str.length()) {
            stringBuffer.append(str.substring(aVar.end, str.length()));
        }
        return stringBuffer.toString();
    }

    private static ArrayList<a> c(List<String> list, List<String> list2) {
        ArrayList<a> arrayList = new ArrayList();
        for (String toLowerCase : list2) {
            a c = c((List) list, toLowerCase.toLowerCase());
            if (c.isAvailable()) {
                arrayList.add(c);
            }
        }
        return arrayList;
    }

    private static a c(List<String> list, String str) {
        a aVar = new a();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                break;
            }
            String str2 = (String) list.get(i2);
            if (!bi.oN(str2)) {
                if (str2.startsWith(str)) {
                    if (aVar.start < 0) {
                        aVar.start = i2;
                    }
                    aVar.end = i2 + 1;
                } else if (str.startsWith(str2)) {
                    int i3 = i2 + 1;
                    String str3 = str2;
                    while (i3 < list.size() && !bi.oN((String) list.get(i3))) {
                        str3 = str3 + ((String) list.get(i3));
                        if (str.length() > str3.length() && str.startsWith(str3)) {
                            i3++;
                        } else if (str.length() <= str3.length() && str3.startsWith(str)) {
                            aVar.start = i2;
                            aVar.end = i3 + 1;
                        }
                    }
                }
            }
            i = i2 + 1;
        }
        return aVar;
    }

    private static a c(CharSequence charSequence, String str) {
        int indexOf = charSequence.toString().indexOf(str);
        a aVar = new a();
        if (indexOf >= 0) {
            aVar.start = indexOf;
            aVar.end = aVar.start + str.length();
        }
        return aVar;
    }

    public static Map<String, String> bj(int i, int i2) {
        switch (i) {
            case 201:
                return m.b(i, false, i2);
            default:
                return b(i, false, i2);
        }
    }

    public static Map<String, String> b(int i, boolean z, int i2) {
        return a(i, z, i2, "");
    }

    public static Map<String, String> a(int i, boolean z, int i2, String str) {
        return a(i, z, i2, str, "", "", "", "", "", "", "");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.Map<java.lang.String, java.lang.String> a(int r11, boolean r12, int r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21) {
        /*
        r4 = new java.util.HashMap;
        r4.<init>();
        r1 = android.text.TextUtils.isEmpty(r15);
        if (r1 != 0) goto L_0x0011;
    L_0x000b:
        r1 = "searchId";
        r4.put(r1, r15);
    L_0x0011:
        r1 = android.text.TextUtils.isEmpty(r16);
        if (r1 != 0) goto L_0x001f;
    L_0x0017:
        r1 = "sessionId";
        r0 = r16;
        r4.put(r1, r0);
    L_0x001f:
        r1 = android.text.TextUtils.isEmpty(r19);
        if (r1 != 0) goto L_0x002d;
    L_0x0025:
        r1 = "subSessionId";
        r0 = r19;
        r4.put(r1, r0);
    L_0x002d:
        r1 = android.text.TextUtils.isEmpty(r17);
        if (r1 != 0) goto L_0x0042;
    L_0x0033:
        r1 = "query";
        r2 = "UTF-8";
        r0 = r17;
        r2 = com.tencent.mm.compatible.util.p.encode(r0, r2);	 Catch:{ Exception -> 0x0185 }
        r4.put(r1, r2);	 Catch:{ Exception -> 0x0185 }
    L_0x0042:
        r1 = android.text.TextUtils.isEmpty(r18);
        if (r1 != 0) goto L_0x0050;
    L_0x0048:
        r1 = "sceneActionType";
        r0 = r18;
        r4.put(r1, r0);
    L_0x0050:
        r1 = android.text.TextUtils.isEmpty(r21);
        if (r1 != 0) goto L_0x005e;
    L_0x0056:
        r1 = "pRequestId";
        r0 = r21;
        r4.put(r1, r0);
    L_0x005e:
        r1 = "scene";
        r2 = java.lang.String.valueOf(r11);
        r4.put(r1, r2);
        r1 = "type";
        r2 = java.lang.String.valueOf(r13);
        r4.put(r1, r2);
        r1 = "lang";
        r2 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r2 = com.tencent.mm.sdk.platformtools.w.eM(r2);
        r4.put(r1, r2);
        r1 = "platform";
        r2 = "android";
        r4.put(r1, r2);
        r1 = android.text.TextUtils.isEmpty(r20);
        if (r1 != 0) goto L_0x0097;
    L_0x008f:
        r1 = "poiInfo";
        r0 = r20;
        r4.put(r1, r0);
    L_0x0097:
        r1 = android.text.TextUtils.isEmpty(r14);
        if (r1 != 0) goto L_0x00a3;
    L_0x009d:
        r1 = "extParams";
        r4.put(r1, r14);
    L_0x00a3:
        switch(r11) {
            case 21: goto L_0x0190;
            default: goto L_0x00a6;
        };
    L_0x00a6:
        r1 = 0;
        r1 = com.tencent.mm.plugin.aj.a.g.Af(r1);
        r1 = java.lang.String.valueOf(r1);
    L_0x00af:
        r2 = "version";
        r4.put(r2, r1);
        r1 = 0;
        r3 = 0;
        r2 = 0;
        switch(r11) {
            case 3: goto L_0x020d;
            case 6: goto L_0x02ec;
            case 9: goto L_0x02ec;
            case 11: goto L_0x02ff;
            case 14: goto L_0x020d;
            case 20: goto L_0x020d;
            case 22: goto L_0x020d;
            case 24: goto L_0x0312;
            case 33: goto L_0x01af;
            case 300: goto L_0x019b;
            default: goto L_0x00bb;
        };
    L_0x00bb:
        r10 = r2;
        r2 = r3;
        r3 = r1;
        r1 = r10;
    L_0x00bf:
        r5 = "MicroMsg.FTS.FTSExportLogic";
        r6 = "genFTSParams scene=%d isHomePage=%b type=%d %b %b %b";
        r7 = 6;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r9 = java.lang.Integer.valueOf(r11);
        r7[r8] = r9;
        r8 = 1;
        r9 = java.lang.Boolean.valueOf(r12);
        r7[r8] = r9;
        r8 = 2;
        r9 = java.lang.Integer.valueOf(r13);
        r7[r8] = r9;
        r8 = 3;
        r9 = java.lang.Boolean.valueOf(r3);
        r7[r8] = r9;
        r8 = 4;
        r9 = java.lang.Boolean.valueOf(r2);
        r7[r8] = r9;
        r8 = 5;
        r9 = java.lang.Boolean.valueOf(r1);
        r7[r8] = r9;
        com.tencent.mm.sdk.platformtools.x.i(r5, r6, r7);
        if (r3 == 0) goto L_0x0100;
    L_0x00f7:
        r3 = "isSug";
        r5 = "1";
        r4.put(r3, r5);
    L_0x0100:
        if (r2 == 0) goto L_0x010b;
    L_0x0102:
        r2 = "isLocalSug";
        r3 = "1";
        r4.put(r2, r3);
    L_0x010b:
        if (r1 == 0) goto L_0x0116;
    L_0x010d:
        r1 = "isMostSearchBiz";
        r2 = "1";
        r4.put(r1, r2);
    L_0x0116:
        if (r12 != 0) goto L_0x0121;
    L_0x0118:
        r1 = "isHomePage";
        r2 = "0";
        r4.put(r1, r2);
    L_0x0121:
        r1 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r1 = com.tencent.mm.bu.a.ev(r1);
        r2 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1));
        if (r2 == 0) goto L_0x015c;
    L_0x012f:
        r2 = 1063256064; // 0x3f600000 float:0.875 double:5.25318294E-315;
        r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1));
        if (r2 == 0) goto L_0x015c;
    L_0x0135:
        r2 = 1066401792; // 0x3f900000 float:1.125 double:5.2687249E-315;
        r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1));
        if (r2 == 0) goto L_0x015c;
    L_0x013b:
        r2 = 1067450368; // 0x3fa00000 float:1.25 double:5.273905555E-315;
        r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1));
        if (r2 == 0) goto L_0x015c;
    L_0x0141:
        r2 = 1068498944; // 0x3fb00000 float:1.375 double:5.27908621E-315;
        r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1));
        if (r2 == 0) goto L_0x015c;
    L_0x0147:
        r2 = 1070596096; // 0x3fd00000 float:1.625 double:5.289447516E-315;
        r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1));
        if (r2 == 0) goto L_0x015c;
    L_0x014d:
        r2 = 1072693248; // 0x3ff00000 float:1.875 double:5.299808824E-315;
        r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1));
        if (r2 == 0) goto L_0x015c;
    L_0x0153:
        r2 = 1073846682; // 0x4001999a float:2.025 double:5.305507545E-315;
        r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1));
        if (r2 == 0) goto L_0x015c;
    L_0x015a:
        r1 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
    L_0x015c:
        r2 = "fontRatio";
        r1 = java.lang.String.valueOf(r1);
        r4.put(r2, r1);
        r1 = "netType";
        r2 = com.tencent.mm.plugin.aj.a.g.bgl();
        r4.put(r1, r2);
        r1 = com.tencent.mm.au.b.Qx();
        if (r1 == 0) goto L_0x0184;
    L_0x0176:
        r1 = com.tencent.mm.au.b.Qz();
        if (r1 == 0) goto L_0x0184;
    L_0x017c:
        r2 = "musicSnsId";
        r1 = r1.wdd;
        r4.put(r2, r1);
    L_0x0184:
        return r4;
    L_0x0185:
        r1 = move-exception;
        r1 = "query";
        r0 = r17;
        r4.put(r1, r0);
        goto L_0x0042;
    L_0x0190:
        r1 = 1;
        r1 = com.tencent.mm.plugin.aj.a.g.Af(r1);
        r1 = java.lang.String.valueOf(r1);
        goto L_0x00af;
    L_0x019b:
        r5 = "mixGlobal";
        r5 = com.tencent.mm.plugin.aj.a.h.Oy(r5);
        if (r12 == 0) goto L_0x01b6;
    L_0x01a4:
        r6 = "mixSugSwitch";
        r7 = 0;
        r5 = r5.optInt(r6, r7);
        r6 = 1;
        if (r5 != r6) goto L_0x00bb;
    L_0x01af:
        r1 = 1;
        r10 = r2;
        r2 = r3;
        r3 = r1;
        r1 = r10;
        goto L_0x00bf;
    L_0x01b6:
        r6 = 1;
        if (r13 != r6) goto L_0x01c5;
    L_0x01b9:
        r6 = "bizSugSwitch";
        r7 = 0;
        r5 = r5.optInt(r6, r7);
        r6 = 1;
        if (r5 != r6) goto L_0x00bb;
    L_0x01c4:
        goto L_0x01af;
    L_0x01c5:
        r6 = 8;
        if (r13 != r6) goto L_0x01d5;
    L_0x01c9:
        r6 = "snsSugSwitch";
        r7 = 0;
        r5 = r5.optInt(r6, r7);
        r6 = 1;
        if (r5 != r6) goto L_0x00bb;
    L_0x01d4:
        goto L_0x01af;
    L_0x01d5:
        r6 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        if (r13 != r6) goto L_0x01e5;
    L_0x01d9:
        r6 = "novelSugSwitch";
        r7 = 0;
        r5 = r5.optInt(r6, r7);
        r6 = 1;
        if (r5 != r6) goto L_0x00bb;
    L_0x01e4:
        goto L_0x01af;
    L_0x01e5:
        r6 = 512; // 0x200 float:7.175E-43 double:2.53E-321;
        if (r13 != r6) goto L_0x01f5;
    L_0x01e9:
        r6 = "musicSugSwitch";
        r7 = 0;
        r5 = r5.optInt(r6, r7);
        r6 = 1;
        if (r5 != r6) goto L_0x00bb;
    L_0x01f4:
        goto L_0x01af;
    L_0x01f5:
        r6 = 384; // 0x180 float:5.38E-43 double:1.897E-321;
        if (r13 == r6) goto L_0x0201;
    L_0x01f9:
        r6 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        if (r13 == r6) goto L_0x0201;
    L_0x01fd:
        r6 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        if (r13 != r6) goto L_0x00bb;
    L_0x0201:
        r6 = "emotionSugSwitch";
        r7 = 0;
        r5 = r5.optInt(r6, r7);
        r6 = 1;
        if (r5 != r6) goto L_0x00bb;
    L_0x020c:
        goto L_0x01af;
    L_0x020d:
        r5 = 1;
        if (r13 != r5) goto L_0x0223;
    L_0x0210:
        r5 = "bizTab";
        r5 = com.tencent.mm.plugin.aj.a.h.Oy(r5);
        r6 = "bizSugSwitch";
        r7 = 0;
        r5 = r5.optInt(r6, r7);
        r6 = 1;
        if (r5 != r6) goto L_0x0223;
    L_0x0222:
        r1 = 1;
    L_0x0223:
        r5 = 2;
        if (r13 != r5) goto L_0x0239;
    L_0x0226:
        r5 = "articleTab";
        r5 = com.tencent.mm.plugin.aj.a.h.Oy(r5);
        r6 = "sugSwitch";
        r7 = 0;
        r5 = r5.optInt(r6, r7);
        r6 = 1;
        if (r5 != r6) goto L_0x0239;
    L_0x0238:
        r1 = 1;
    L_0x0239:
        r5 = 8;
        if (r13 != r5) goto L_0x025c;
    L_0x023d:
        r5 = "snsTab";
        r5 = com.tencent.mm.plugin.aj.a.h.Oy(r5);
        r6 = "sugSwitch";
        r7 = 0;
        r6 = r5.optInt(r6, r7);
        r7 = 1;
        if (r6 != r7) goto L_0x0250;
    L_0x024f:
        r1 = 1;
    L_0x0250:
        r6 = "localSugSwitch";
        r7 = 0;
        r5 = r5.optInt(r6, r7);
        r6 = 1;
        if (r5 != r6) goto L_0x025c;
    L_0x025b:
        r3 = 1;
    L_0x025c:
        if (r12 != 0) goto L_0x0274;
    L_0x025e:
        r5 = 4;
        if (r13 != r5) goto L_0x0274;
    L_0x0261:
        r5 = "bizTab";
        r5 = com.tencent.mm.plugin.aj.a.h.Oy(r5);
        r6 = "bizServiceSugSwitch";
        r7 = 0;
        r5 = r5.optInt(r6, r7);
        r6 = 1;
        if (r5 != r6) goto L_0x0274;
    L_0x0273:
        r1 = 1;
    L_0x0274:
        r5 = 1;
        if (r13 != r5) goto L_0x028a;
    L_0x0277:
        r5 = "bizTab";
        r5 = com.tencent.mm.plugin.aj.a.h.Oy(r5);
        r6 = "mfsBizSwitch";
        r7 = 0;
        r5 = r5.optInt(r6, r7);
        r6 = 1;
        if (r5 != r6) goto L_0x028a;
    L_0x0289:
        r2 = 1;
    L_0x028a:
        r5 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        if (r13 != r5) goto L_0x02a1;
    L_0x028e:
        r5 = "novelTab";
        r5 = com.tencent.mm.plugin.aj.a.h.Oy(r5);
        r6 = "sugSwitch";
        r7 = 0;
        r5 = r5.optInt(r6, r7);
        r6 = 1;
        if (r5 != r6) goto L_0x02a1;
    L_0x02a0:
        r1 = 1;
    L_0x02a1:
        r5 = 512; // 0x200 float:7.175E-43 double:2.53E-321;
        if (r13 != r5) goto L_0x02b8;
    L_0x02a5:
        r5 = "musicTab";
        r5 = com.tencent.mm.plugin.aj.a.h.Oy(r5);
        r6 = "sugSwitch";
        r7 = 0;
        r5 = r5.optInt(r6, r7);
        r6 = 1;
        if (r5 != r6) goto L_0x02b8;
    L_0x02b7:
        r1 = 1;
    L_0x02b8:
        r5 = 384; // 0x180 float:5.38E-43 double:1.897E-321;
        if (r13 != r5) goto L_0x02cf;
    L_0x02bc:
        r5 = "emotionTab";
        r5 = com.tencent.mm.plugin.aj.a.h.Oy(r5);
        r6 = "sugSwitch";
        r7 = 0;
        r5 = r5.optInt(r6, r7);
        r6 = 1;
        if (r5 != r6) goto L_0x02cf;
    L_0x02ce:
        r1 = 1;
    L_0x02cf:
        if (r13 != 0) goto L_0x00bb;
    L_0x02d1:
        if (r12 == 0) goto L_0x00bb;
    L_0x02d3:
        r5 = "mixGlobal";
        r5 = com.tencent.mm.plugin.aj.a.h.Oy(r5);
        r6 = "mixSugSwitch";
        r7 = 0;
        r5 = r5.optInt(r6, r7);
        r6 = 1;
        if (r5 != r6) goto L_0x02e6;
    L_0x02e5:
        r1 = 1;
    L_0x02e6:
        r10 = r2;
        r2 = r3;
        r3 = r1;
        r1 = r10;
        goto L_0x00bf;
    L_0x02ec:
        r5 = "bizEntry";
        r5 = com.tencent.mm.plugin.aj.a.h.Oy(r5);
        r6 = "sugSwitch";
        r5 = r5.optInt(r6);
        r6 = 1;
        if (r5 != r6) goto L_0x00bb;
    L_0x02fd:
        goto L_0x01af;
    L_0x02ff:
        r5 = "bizUnionTopEntry";
        r5 = com.tencent.mm.plugin.aj.a.h.Oy(r5);
        r6 = "sugSwitch";
        r5 = r5.optInt(r6);
        r6 = 1;
        if (r5 != r6) goto L_0x00bb;
    L_0x0310:
        goto L_0x01af;
    L_0x0312:
        r5 = 384; // 0x180 float:5.38E-43 double:1.897E-321;
        if (r13 != r5) goto L_0x00bb;
    L_0x0316:
        r5 = "emoticonMall";
        r5 = com.tencent.mm.plugin.aj.a.h.Oy(r5);
        r6 = "sugSwitch";
        r7 = 0;
        r5 = r5.optInt(r6, r7);
        r6 = 1;
        if (r5 != r6) goto L_0x0329;
    L_0x0328:
        r1 = 1;
    L_0x0329:
        r10 = r2;
        r2 = r3;
        r3 = r1;
        r1 = r10;
        goto L_0x00bf;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.bb.b.a(int, boolean, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):java.util.Map<java.lang.String, java.lang.String>");
    }

    public static String c(int i, Map<String, String> map) {
        switch (i) {
            case 21:
                return a((Map) map, 1);
            case 201:
                return m.r(map);
            default:
                return a((Map) map, 0);
        }
    }

    public static String r(Map<String, String> map) {
        return a((Map) map, 0);
    }

    public static String a(Map<String, String> map, int i) {
        int i2 = 1;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("file://");
        String Ro = com.tencent.mm.plugin.aj.a.g.Aa(i).Ro();
        String str = "isOpenPreload";
        StringBuilder stringBuilder = new StringBuilder();
        d bPz = d.bPz();
        int i3 = i == 1 ? 2 : 1;
        if (ad.cgj()) {
            boolean bPA;
            switch (i3) {
                case 1:
                    bPA = bPz.bPA();
                    break;
                default:
                    bPA = bPz.bPB();
                    break;
            }
            if (!bPA) {
                i2 = 0;
            }
            map.put(str, stringBuilder.append(i2).toString());
            stringBuffer.append(Ro);
            StringBuffer append;
            if (map.size() > 0) {
                append = stringBuffer.append("/");
                com.tencent.mm.plugin.aj.a.g.Aa(i);
                append.append("app.html?");
                for (Entry entry : map.entrySet()) {
                    stringBuffer.append((String) entry.getKey());
                    stringBuffer.append("=");
                    stringBuffer.append((String) entry.getValue());
                    stringBuffer.append("&");
                }
                String str2 = (String) map.get("sessionId");
                if (!map.containsKey("sessionId")) {
                    str2 = com.tencent.mm.plugin.aj.a.g.zZ(bi.Wo((String) map.get("scene")));
                    stringBuffer.append("sessionId");
                    stringBuffer.append("=");
                    stringBuffer.append(str2);
                    stringBuffer.append("&");
                }
                if (!map.containsKey("subSessionId")) {
                    stringBuffer.append("subSessionId");
                    stringBuffer.append("=");
                    stringBuffer.append(str2);
                    stringBuffer.append("&");
                }
                return stringBuffer.substring(0, stringBuffer.length() - 1);
            }
            append = stringBuffer.append("/");
            com.tencent.mm.plugin.aj.a.g.Aa(i);
            append.append("app.html");
            return stringBuffer.toString();
        }
        throw new IllegalStateException("please call from main process");
    }

    private static Intent o(Intent intent) {
        if (intent == null) {
            return null;
        }
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vHy);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vHv);
        intent.putExtra("neverGetA8Key", true);
        return intent;
    }

    public static Intent QT() {
        return o(new Intent());
    }

    public static void p(Intent intent) {
        intent.putExtra("ftsbizscene", 24);
        Map b = b(24, false, 384);
        String zZ = com.tencent.mm.plugin.aj.a.g.zZ(bi.Wo((String) b.get("scene")));
        b.put("sessionId", zZ);
        intent.putExtra("sessionId", zZ);
        intent.putExtra("rawUrl", a(b, 0));
        intent.putExtra("ftsType", 384);
    }

    public static String s(Map<String, ? extends Object> map) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Entry entry : map.entrySet()) {
            stringBuffer.append((String) entry.getKey());
            stringBuffer.append("=");
            if (entry.getValue() != null) {
                stringBuffer.append(entry.getValue().toString());
            }
            stringBuffer.append("&");
        }
        return stringBuffer.substring(0, stringBuffer.length() - 1).toString();
    }

    public static int a(JSONObject jSONObject, String str, Context context) {
        int optInt = jSONObject == null ? 0 : jSONObject.optInt("businessType");
        if (optInt != 0) {
            return optInt;
        }
        if (str.equals(context.getString(R.l.eJd))) {
            return 2;
        }
        if (str.equals(context.getString(R.l.eJf))) {
            return 8;
        }
        if (str.equals(context.getString(R.l.eJe))) {
            return 1;
        }
        x.i("MicroMsg.FTS.FTSExportLogic", "option " + str + " no type");
        return optInt;
    }

    public static Drawable b(int i, Context context) {
        int i2 = R.k.dBh;
        switch (i) {
            case 1:
                i2 = R.k.dBf;
                break;
            case 2:
                i2 = R.k.dAY;
                break;
            case 8:
                i2 = R.k.dBc;
                break;
            case 64:
                i2 = R.k.dBb;
                break;
            case 256:
            case 384:
                i2 = R.k.dAZ;
                break;
            case WXMediaMessage.TITLE_LENGTH_LIMIT /*512*/:
                i2 = R.k.dBd;
                break;
            case WXMediaMessage.DESCRIPTION_LENGTH_LIMIT /*1024*/:
                i2 = R.k.dBe;
                break;
            case 12582912:
                i2 = R.k.dBi;
                break;
            case 16777248:
                i2 = R.k.dBg;
                break;
            case 16777728:
                i2 = R.k.dBj;
                break;
        }
        return context.getResources().getDrawable(i2);
    }

    public static int io(int i) {
        if (i == 201) {
            return 1006;
        }
        if (i == 3) {
            return 1005;
        }
        if (i == 16) {
            return 1042;
        }
        if (i == 20) {
            return 1053;
        }
        return 1000;
    }

    public static boolean aq(String str, String str2) {
        int i = 0;
        if (str == str2) {
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith(str2)) {
            return true;
        }
        String str3;
        if (TextUtils.isEmpty(str)) {
            str3 = "";
        } else {
            StringBuilder stringBuilder = new StringBuilder(str.length());
            while (i < str.length()) {
                stringBuilder.append(SpellMap.g(str.charAt(i)));
                i++;
            }
            str3 = stringBuilder.toString();
        }
        return str3.startsWith(str2);
    }

    public static boolean QU() {
        JSONObject Oy = h.Oy("snsContactMatch");
        if (Oy == null) {
            return false;
        }
        if (Oy.optInt("matchSwitch") == 1) {
            return true;
        }
        return false;
    }

    public static int QV() {
        JSONObject Oy = h.Oy("snsContactMatch");
        if (Oy != null) {
            return Oy.optInt("queryUtfLenLimit");
        }
        return 0;
    }

    public static void a(Context context, String str, Intent intent, String str2, String str3, String str4, String str5) {
        a(context, str, intent, str2, null, null, str4, str5, str3);
    }

    public static boolean c(Activity activity, int i) {
        try {
            if (android.support.v4.content.a.b((Context) activity, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                com.tencent.mm.plugin.report.service.g.pWK.h(15104, Integer.valueOf(i), Integer.valueOf(2));
                return true;
            }
            com.tencent.mm.plugin.report.service.g.pWK.h(15104, Integer.valueOf(i), Integer.valueOf(1));
            if (android.support.v4.app.a.a(activity, "android.permission.ACCESS_COARSE_LOCATION")) {
                x.w("MicroMsg.FTS.FTSExportLogic", "has shown request permission and user denied, do not show agagin");
                return true;
            }
            x.w("MicroMsg.FTS.FTSExportLogic", "showing request permission dialog");
            android.support.v4.app.a.a(activity, new String[]{"android.permission.ACCESS_COARSE_LOCATION"}, 73);
            return false;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FTS.FTSExportLogic", e, "", new Object[0]);
            return true;
        }
    }

    public static void a(Context context, String str, Intent intent, String str2, String str3, String str4, String str5, String str6) {
        a(context, str, intent, str2, str3, str4, str5, str6, "");
    }

    private static void a(Context context, String str, Intent intent, String str2, String str3, String str4, String str5, String str6, String str7) {
        if (intent == null || context == null) {
            x.e("MicroMsg.FTS.FTSExportLogic", "openNews intent is null, or context is null");
            return;
        }
        String zZ;
        String zZ2;
        Intent o = o(intent);
        o.putExtra("ftsbizscene", 21);
        o.putExtra("ftsQuery", str);
        if (str2 != null) {
            o.putExtra("title", str2);
        }
        o.putExtra("isWebwx", str);
        o.putExtra("ftscaneditable", false);
        o.putExtra("key_load_js_without_delay", true);
        if (TextUtils.isEmpty(str5)) {
            zZ = com.tencent.mm.plugin.aj.a.g.zZ(21);
        } else {
            zZ = str5;
        }
        if (TextUtils.isEmpty(str6)) {
            zZ2 = com.tencent.mm.plugin.aj.a.g.zZ(21);
        } else {
            zZ2 = str6;
        }
        o.putExtra("rawUrl", a(str3, str4, zZ, str, "2", false, zZ2, str7));
        o.putExtra("sessionId", zZ);
        o.putExtra("customize_status_bar_color", context.getResources().getColor(R.e.buh));
        o.putExtra("status_bar_style", "black");
        com.tencent.mm.bl.d.b(context, "webview", ".ui.tools.fts.FTSWebViewUI", o);
    }

    public static String QW() {
        return h.Oy("discoverRecommendEntry").optString("wording");
    }

    private static String a(String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7) {
        Map a = a(21, false, 2, str, str2, str3, str4, str5, str6, "", str7);
        if (z) {
            a.put("isPreload", "1");
        }
        return a(a, 1);
    }

    public static void QX() {
        Object obj;
        String QW = QW();
        if (bi.oN(QW)) {
            x.e("MicroMsg.FTS.FTSExportLogic", "empty query");
            obj = "";
        } else {
            obj = a(null, null, com.tencent.mm.plugin.aj.a.g.zZ(21), QW, null, true, com.tencent.mm.plugin.aj.a.g.zZ(21), "");
        }
        if (!TextUtils.isEmpty(obj)) {
            d.bPz().cx(obj, 2);
        }
    }

    public static void QY() {
        Object a = a(3, com.tencent.mm.plugin.aj.a.g.zZ(3), true, "");
        if (!TextUtils.isEmpty(a)) {
            d.bPz().cx(a, 3);
        }
    }

    public static void QZ() {
        Object a = a(20, com.tencent.mm.plugin.aj.a.g.zZ(20), true, "");
        if (!TextUtils.isEmpty(a)) {
            d.bPz().cx(a, 1);
        }
    }

    public static String ar(String str, String str2) {
        return a(20, str, false, str2);
    }

    private static String a(int i, String str, boolean z, String str2) {
        Map b = b(i, true, 0);
        b.put("sessionId", str);
        b.put("inputMarginTop", "32");
        b.put("inputMarginLeftRight", "24");
        b.put("inputHeight", "48");
        if (z) {
            b.put("isPreload", "1");
        } else if (!(str2 == null || str2.isEmpty())) {
            b.put("educationTab", Uri.encode(str2));
        }
        return a(b, 0);
    }

    public static boolean bo(long j) {
        x.i("MicroMsg.FTS.FTSExportLogic", "rec updateRedDotTimestamp %d", Long.valueOf(j));
        com.tencent.mm.kernel.g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_RECOMMEND_REDDOT_LONG, Long.valueOf(j));
        return false;
    }

    public static long Ra() {
        Object obj = com.tencent.mm.kernel.g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_RECOMMEND_REDDOT_LONG, null);
        return obj == null ? 0 : ((Long) obj).longValue();
    }

    public static long lV(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        x.i("MicroMsg.FTS.FTSExportLogic", "seq %s to snsId %d ", str, Long.valueOf(new BigInteger(str).longValue()));
        return new BigInteger(str).longValue();
    }
}
