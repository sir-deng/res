package com.tencent.mm.booter.notification.a;

import android.content.Context;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.tencent.mm.R;
import com.tencent.mm.bw.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.r;
import com.tencent.mm.y.s;
import java.lang.ref.WeakReference;

public final class h {
    private static WeakReference<TextPaint> gCD;
    private static int gCE = 0;
    private static int gCF = 0;
    public String gCB = "";
    public String gCC = "";
    public String mTitle = "";

    public static String a(Context context, String str, String str2, int i) {
        return i.Tm(b.chK().WP(a(0, str2, str, i, context)));
    }

    public static String g(Context context, String str, String str2) {
        String hS;
        if (s.eX(str)) {
            hS = bb.hS(str2);
            if (hS != null) {
                hS = r.gw(hS.trim());
            } else {
                hS = r.gw(str);
            }
        } else {
            hS = r.gw(str);
        }
        if (str.contains("@bottle")) {
            return context.getResources().getQuantityString(R.j.duP, 1, new Object[]{Integer.valueOf(1)});
        }
        if (bi.oN(hS) && s.eX(str)) {
            hS = context.getString(R.l.dSY);
        }
        return b.chK().WP(hS);
    }

    public static String b(x xVar) {
        Context context = ad.getContext();
        if (xVar == null) {
            return context.getString(R.l.dNk);
        }
        String city;
        if (RegionCodeDecoder.Yl(xVar.getCountryCode())) {
            city = xVar.getCity();
            if (!bi.oN(city)) {
                return city;
            }
            city = r.gy(xVar.getProvince());
            if (!bi.oN(city)) {
                return city;
            }
            RegionCodeDecoder.ckE();
            return RegionCodeDecoder.getLocName(xVar.getCountryCode());
        }
        city = r.gy(xVar.getProvince());
        return bi.oN(city) ? context.getString(R.l.dNk) : city;
    }

    public static String b(au auVar, PString pString, PString pString2, PInt pInt, boolean z) {
        return bi.oM(a(auVar.field_imgPath, auVar.field_isSend, auVar.field_talker, i.Tm(auVar.cjS() ? auVar.ckt() : auVar.field_content), auVar.getType(), ad.getContext(), pString, pString2, pInt, true, z));
    }

    public static String a(int i, String str, String str2, int i2, Context context) {
        return bi.oM(a(null, i, str, str2, i2, context, new PString(), new PString(), new PInt(), false, false));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(java.lang.String r18, int r19, java.lang.String r20, java.lang.String r21, int r22, android.content.Context r23, com.tencent.mm.pointers.PString r24, com.tencent.mm.pointers.PString r25, com.tencent.mm.pointers.PInt r26, boolean r27, boolean r28) {
        /*
        r5 = "context is null";
        if (r23 == 0) goto L_0x0032;
    L_0x0005:
        r4 = 1;
    L_0x0006:
        junit.framework.Assert.assertTrue(r5, r4);
        r5 = "username is null";
        if (r20 == 0) goto L_0x0034;
    L_0x000e:
        r4 = r20.length();
        if (r4 <= 0) goto L_0x0034;
    L_0x0014:
        r4 = 1;
    L_0x0015:
        junit.framework.Assert.assertTrue(r5, r4);
        if (r27 != 0) goto L_0x005b;
    L_0x001a:
        r4 = com.tencent.mm.y.s.gN(r20);
        if (r4 == 0) goto L_0x0036;
    L_0x0020:
        r4 = com.tencent.mm.y.q.Gq();
        if (r4 != 0) goto L_0x0036;
    L_0x0026:
        r4 = 1;
    L_0x0027:
        if (r4 == 0) goto L_0x005b;
    L_0x0029:
        r4 = com.tencent.mm.R.l.eMI;
        r0 = r23;
        r4 = r0.getString(r4);
    L_0x0031:
        return r4;
    L_0x0032:
        r4 = 0;
        goto L_0x0006;
    L_0x0034:
        r4 = 0;
        goto L_0x0015;
    L_0x0036:
        r4 = com.tencent.mm.y.s.gP(r20);
        if (r4 == 0) goto L_0x004b;
    L_0x003c:
        r4 = com.tencent.mm.y.q.Gc();
        r4 = r4 & 64;
        if (r4 == 0) goto L_0x0049;
    L_0x0044:
        r4 = 1;
    L_0x0045:
        if (r4 != 0) goto L_0x004b;
    L_0x0047:
        r4 = 1;
        goto L_0x0027;
    L_0x0049:
        r4 = 0;
        goto L_0x0045;
    L_0x004b:
        r4 = com.tencent.mm.y.s.gT(r20);
        if (r4 == 0) goto L_0x0059;
    L_0x0051:
        r4 = com.tencent.mm.y.q.Gt();
        if (r4 != 0) goto L_0x0059;
    L_0x0057:
        r4 = 1;
        goto L_0x0027;
    L_0x0059:
        r4 = 0;
        goto L_0x0027;
    L_0x005b:
        r16 = 0;
        r15 = 0;
        r4 = com.tencent.mm.y.s.gT(r20);
        if (r4 == 0) goto L_0x00d1;
    L_0x0064:
        if (r27 == 0) goto L_0x006a;
    L_0x0066:
        r4 = "";
        goto L_0x0031;
    L_0x006a:
        r5 = com.tencent.mm.y.q.Gt();
        com.tencent.mm.y.as.Hm();
        r4 = com.tencent.mm.y.c.Db();
        r6 = 65793; // 0x10101 float:9.2196E-41 double:3.2506E-319;
        r7 = 0;
        r4 = r4.get(r6, r7);
        r4 = (java.lang.Long) r4;
        r6 = 0;
        r6 = com.tencent.mm.sdk.platformtools.bi.a(r4, r6);
        if (r5 != 0) goto L_0x0090;
    L_0x0087:
        r4 = com.tencent.mm.R.l.eMI;
        r0 = r23;
        r4 = r0.getString(r4);
        goto L_0x0031;
    L_0x0090:
        r4 = 0;
        r4 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1));
        if (r4 != 0) goto L_0x009f;
    L_0x0096:
        r4 = com.tencent.mm.R.l.ejl;
        r0 = r23;
        r4 = r0.getString(r4);
        goto L_0x0031;
    L_0x009f:
        r4 = com.tencent.mm.sdk.platformtools.bi.bz(r6);
        r8 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r4 = r4 * r8;
        r8 = 1209600000; // 0x48190800 float:156704.0 double:5.97621805E-315;
        r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
        if (r4 <= 0) goto L_0x00cc;
    L_0x00ad:
        r4 = com.tencent.mm.R.l.ejk;
        r5 = 1;
        r5 = new java.lang.Object[r5];
        r8 = 0;
        r6 = com.tencent.mm.sdk.platformtools.bi.bz(r6);
        r10 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r6 = r6 * r10;
        r10 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
        r6 = r6 / r10;
        r6 = java.lang.Long.valueOf(r6);
        r5[r8] = r6;
        r0 = r23;
        r4 = r0.getString(r4, r5);
        goto L_0x0031;
    L_0x00cc:
        r4 = "";
        goto L_0x0031;
    L_0x00d1:
        r14 = "";
        r6 = "";
        r5 = "";
        r4 = 0;
        if (r21 == 0) goto L_0x13a6;
    L_0x00dd:
        if (r27 == 0) goto L_0x13a6;
    L_0x00df:
        r4 = 1;
        r21 = ez(r21);
        r11 = r4;
    L_0x00e5:
        r0 = r21;
        r1 = r24;
        r1.value = r0;
        if (r19 != 0) goto L_0x13a0;
    L_0x00ed:
        r4 = com.tencent.mm.y.s.eX(r20);
        if (r4 == 0) goto L_0x13a0;
    L_0x00f3:
        r4 = com.tencent.mm.y.bb.hR(r21);
        if (r4 <= 0) goto L_0x13a0;
    L_0x00f9:
        r5 = 0;
        r0 = r21;
        r5 = r0.substring(r5, r4);
        r6 = r5.trim();
        r0 = r20;
        r5 = com.tencent.mm.y.r.L(r6, r0);
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r0 = r21;
        r7 = r7.append(r0);
        r8 = " ";
        r7 = r7.append(r8);
        r7 = r7.toString();
        r4 = r4 + 1;
        r4 = r7.substring(r4);
        r12 = r5;
        r13 = r6;
    L_0x0128:
        r5 = 0;
        r6 = com.tencent.mm.y.s.hg(r20);
        if (r6 != 0) goto L_0x0135;
    L_0x012f:
        r6 = com.tencent.mm.y.s.hp(r20);
        if (r6 == 0) goto L_0x0176;
    L_0x0135:
        r6 = ":";
        r0 = r21;
        r6 = r0.indexOf(r6);
        r7 = -1;
        if (r6 == r7) goto L_0x0154;
    L_0x0141:
        r7 = 0;
        r0 = r21;
        r7 = r0.substring(r7, r6);
        r0 = r25;
        r0.value = r7;
        r6 = r6 + 1;
        r0 = r21;
        r21 = r0.substring(r6);
    L_0x0154:
        r17 = r5;
        r7 = r21;
    L_0x0158:
        switch(r22) {
            case -1879048191: goto L_0x037c;
            case -1879048190: goto L_0x037c;
            case -1879048189: goto L_0x037c;
            case -1879048188: goto L_0x03cc;
            case -1879048186: goto L_0x09ac;
            case -1879048185: goto L_0x0a1d;
            case -1879048183: goto L_0x0a1d;
            case -1879048176: goto L_0x0a1d;
            case 3: goto L_0x01b4;
            case 11: goto L_0x0252;
            case 13: goto L_0x0235;
            case 23: goto L_0x01b4;
            case 33: goto L_0x01b4;
            case 34: goto L_0x0268;
            case 35: goto L_0x0498;
            case 36: goto L_0x0252;
            case 37: goto L_0x03dc;
            case 39: goto L_0x0235;
            case 40: goto L_0x0464;
            case 42: goto L_0x04cd;
            case 43: goto L_0x02ea;
            case 47: goto L_0x01f3;
            case 48: goto L_0x058c;
            case 49: goto L_0x0a68;
            case 50: goto L_0x038c;
            case 52: goto L_0x03bc;
            case 53: goto L_0x038c;
            case 55: goto L_0x1082;
            case 57: goto L_0x1082;
            case 62: goto L_0x02ea;
            case 66: goto L_0x04cd;
            case 1048625: goto L_0x01f3;
            case 12299999: goto L_0x036c;
            case 16777265: goto L_0x0a68;
            case 268435505: goto L_0x0a68;
            case 285212721: goto L_0x1048;
            case 318767153: goto L_0x1069;
            case 335544369: goto L_0x05e7;
            case 369098801: goto L_0x0810;
            case 402653233: goto L_0x0638;
            case 419430449: goto L_0x067b;
            case 436207665: goto L_0x0706;
            case 452984881: goto L_0x086e;
            case 469762097: goto L_0x0706;
            case 503316529: goto L_0x1095;
            case 520093745: goto L_0x0911;
            case 536870961: goto L_0x07b5;
            case 553648177: goto L_0x0a68;
            case 570425393: goto L_0x10cc;
            default: goto L_0x015b;
        };
    L_0x015b:
        r4 = r14;
        r5 = r15;
        r6 = r16;
    L_0x015f:
        r8 = com.tencent.mm.y.s.gO(r20);
        if (r8 == 0) goto L_0x11db;
    L_0x0165:
        r5 = 1;
        r0 = r19;
        if (r5 != r0) goto L_0x110e;
    L_0x016a:
        r5 = com.tencent.mm.sdk.platformtools.bi.oN(r4);
        if (r5 != 0) goto L_0x10ed;
    L_0x0170:
        r0 = r24;
        r0.value = r4;
        goto L_0x0031;
    L_0x0176:
        com.tencent.mm.y.as.Hm();
        r6 = com.tencent.mm.y.c.Fk();
        r0 = r20;
        r6 = r6.XF(r0);
        if (r6 == 0) goto L_0x018d;
    L_0x0185:
        r7 = 2097152; // 0x200000 float:2.938736E-39 double:1.0361308E-317;
        r6 = r6.gd(r7);
        if (r6 != 0) goto L_0x018f;
    L_0x018d:
        if (r28 == 0) goto L_0x139a;
    L_0x018f:
        r5 = 1;
        r6 = ":";
        r0 = r21;
        r6 = r0.indexOf(r6);
        r7 = -1;
        if (r6 == r7) goto L_0x139a;
    L_0x019c:
        r7 = 0;
        r0 = r21;
        r7 = r0.substring(r7, r6);
        r0 = r25;
        r0.value = r7;
        r6 = r6 + 1;
        r0 = r21;
        r21 = r0.substring(r6);
        r17 = r5;
        r7 = r21;
        goto L_0x0158;
    L_0x01b4:
        r4 = com.tencent.mm.R.l.dGu;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x01eb;
    L_0x01c2:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x01d6:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x01ef;
    L_0x01dc:
        r5 = "%s: ";
    L_0x01df:
        r0 = r24;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015f;
    L_0x01eb:
        r4 = "";
        goto L_0x01d6;
    L_0x01ef:
        r5 = "";
        goto L_0x01df;
    L_0x01f3:
        r5 = com.tencent.mm.storage.aj.XW(r7);
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r6 = r5.hXn;
        r4 = r4.append(r6);
        r6 = ": ";
        r4 = r4.append(r6);
        r4 = r4.toString();
        if (r18 == 0) goto L_0x022c;
    L_0x020f:
        r6 = r18.length();
        r7 = 32;
        if (r6 != r7) goto L_0x022c;
    L_0x0217:
        r6 = "";
        r0 = r24;
        r0.value = r6;
        r5 = r5.hXn;
        r0 = r25;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015f;
    L_0x022c:
        r6 = com.tencent.mm.R.l.dER;
        r0 = r23;
        r18 = r0.getString(r6);
        goto L_0x0217;
    L_0x0235:
        r4 = com.tencent.mm.R.l.dGu;
        r0 = r23;
        r8 = r0.getString(r4);
        r4 = r23;
        r5 = r19;
        r6 = r20;
        r9 = r24;
        r10 = r25;
        r4 = a(r4, r5, r6, r7, r8, r9, r10);
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r14;
        goto L_0x015f;
    L_0x0252:
        r8 = 0;
        r4 = r23;
        r5 = r19;
        r6 = r20;
        r9 = r24;
        r10 = r25;
        r4 = a(r4, r5, r6, r7, r8, r9, r10);
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r14;
        goto L_0x015f;
    L_0x0268:
        r4 = com.tencent.mm.storage.x.Xd(r20);
        if (r4 != 0) goto L_0x0280;
    L_0x026e:
        r4 = com.tencent.mm.storage.x.Xf(r20);
        if (r4 != 0) goto L_0x0280;
    L_0x0274:
        r4 = com.tencent.mm.y.s.gN(r20);
        if (r4 != 0) goto L_0x0280;
    L_0x027a:
        r4 = com.tencent.mm.y.s.gP(r20);
        if (r4 == 0) goto L_0x029d;
    L_0x0280:
        r4 = com.tencent.mm.R.l.dHj;
        r0 = r23;
        r8 = r0.getString(r4);
        r4 = r23;
        r5 = r19;
        r6 = r20;
        r9 = r24;
        r10 = r25;
        r4 = a(r4, r5, r6, r7, r8, r9, r10);
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r14;
        goto L_0x015f;
    L_0x029d:
        if (r7 == 0) goto L_0x02d9;
    L_0x029f:
        r4 = r7.length();
        if (r4 <= 0) goto L_0x02d9;
    L_0x02a5:
        r4 = com.tencent.mm.y.s.gO(r20);
        if (r4 != 0) goto L_0x02d9;
    L_0x02ab:
        r4 = com.tencent.mm.y.s.eX(r20);
        if (r4 == 0) goto L_0x02e6;
    L_0x02b1:
        r4 = new com.tencent.mm.modelvoice.n;
        r4.<init>(r7);
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = r4.hXn;
        r5 = r5.append(r6);
        r6 = ": ";
        r5 = r5.append(r6);
        r7 = r5.toString();
        r5 = "%s:";
        r0 = r24;
        r0.value = r5;
        r4 = r4.hXn;
        r0 = r25;
        r0.value = r4;
    L_0x02d9:
        r4 = com.tencent.mm.R.l.dHj;
        r0 = r23;
        r4 = r0.getString(r4);
        r5 = r15;
        r6 = r16;
        goto L_0x015f;
    L_0x02e6:
        r7 = "";
        goto L_0x02d9;
    L_0x02ea:
        r4 = com.tencent.mm.storage.x.Xd(r20);
        if (r4 != 0) goto L_0x0302;
    L_0x02f0:
        r4 = com.tencent.mm.storage.x.Xf(r20);
        if (r4 != 0) goto L_0x0302;
    L_0x02f6:
        r4 = com.tencent.mm.y.s.gN(r20);
        if (r4 != 0) goto L_0x0302;
    L_0x02fc:
        r4 = com.tencent.mm.y.s.gP(r20);
        if (r4 == 0) goto L_0x031f;
    L_0x0302:
        r4 = com.tencent.mm.R.l.dHi;
        r0 = r23;
        r8 = r0.getString(r4);
        r4 = r23;
        r5 = r19;
        r6 = r20;
        r9 = r24;
        r10 = r25;
        r4 = a(r4, r5, r6, r7, r8, r9, r10);
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r14;
        goto L_0x015f;
    L_0x031f:
        if (r7 == 0) goto L_0x035b;
    L_0x0321:
        r4 = r7.length();
        if (r4 <= 0) goto L_0x035b;
    L_0x0327:
        r4 = com.tencent.mm.y.s.gO(r20);
        if (r4 != 0) goto L_0x035b;
    L_0x032d:
        r4 = com.tencent.mm.y.s.eX(r20);
        if (r4 == 0) goto L_0x0368;
    L_0x0333:
        r4 = new com.tencent.mm.modelvideo.p;
        r4.<init>(r7);
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = r4.hXn;
        r5 = r5.append(r6);
        r6 = ": ";
        r5 = r5.append(r6);
        r7 = r5.toString();
        r5 = "%s:";
        r0 = r24;
        r0.value = r5;
        r4 = r4.hXn;
        r0 = r25;
        r0.value = r4;
    L_0x035b:
        r4 = com.tencent.mm.R.l.dHi;
        r0 = r23;
        r4 = r0.getString(r4);
        r5 = r15;
        r6 = r16;
        goto L_0x015f;
    L_0x0368:
        r7 = "";
        goto L_0x035b;
    L_0x036c:
        r7 = "";
        r4 = com.tencent.mm.R.l.dHl;
        r0 = r23;
        r4 = r0.getString(r4);
        r5 = r15;
        r6 = r16;
        goto L_0x015f;
    L_0x037c:
        r7 = "";
        r4 = com.tencent.mm.R.l.dHk;
        r0 = r23;
        r4 = r0.getString(r4);
        r5 = r15;
        r6 = r16;
        goto L_0x015f;
    L_0x038c:
        r4 = com.tencent.mm.storage.au.xHC;
        r4 = r7.equals(r4);
        if (r4 == 0) goto L_0x03a4;
    L_0x0394:
        r7 = "";
        r4 = com.tencent.mm.R.l.dHl;
        r0 = r23;
        r4 = r0.getString(r4);
        r5 = r15;
        r6 = r16;
        goto L_0x015f;
    L_0x03a4:
        r4 = com.tencent.mm.storage.au.xHB;
        r4 = r7.equals(r4);
        if (r4 == 0) goto L_0x015b;
    L_0x03ac:
        r7 = "";
        r4 = com.tencent.mm.R.l.dHm;
        r0 = r23;
        r4 = r0.getString(r4);
        r5 = r15;
        r6 = r16;
        goto L_0x015f;
    L_0x03bc:
        r7 = "";
        r4 = com.tencent.mm.R.l.dHl;
        r0 = r23;
        r4 = r0.getString(r4);
        r5 = r15;
        r6 = r16;
        goto L_0x015f;
    L_0x03cc:
        r7 = "";
        r4 = com.tencent.mm.R.l.dHm;
        r0 = r23;
        r4 = r0.getString(r4);
        r5 = r15;
        r6 = r16;
        goto L_0x015f;
    L_0x03dc:
        if (r7 == 0) goto L_0x015b;
    L_0x03de:
        r4 = r7.length();
        if (r4 <= 0) goto L_0x015b;
    L_0x03e4:
        r4 = com.tencent.mm.storage.au.d.Yb(r7);
        r5 = r4.sfb;
        if (r5 == 0) goto L_0x040f;
    L_0x03ec:
        r5 = r4.sfb;
        r5 = r5.length();
        if (r5 <= 0) goto L_0x040f;
    L_0x03f4:
        r5 = r4.scene;
        switch(r5) {
            case 18: goto L_0x0415;
            case 19: goto L_0x03f9;
            case 20: goto L_0x03f9;
            case 21: goto L_0x03f9;
            case 22: goto L_0x042e;
            case 23: goto L_0x042e;
            case 24: goto L_0x042e;
            case 25: goto L_0x0447;
            case 26: goto L_0x042e;
            case 27: goto L_0x042e;
            case 28: goto L_0x042e;
            case 29: goto L_0x042e;
            default: goto L_0x03f9;
        };
    L_0x03f9:
        r5 = com.tencent.mm.R.l.ejG;
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r4 = r4.getDisplayName();
        r6[r7] = r4;
        r0 = r23;
        r7 = r0.getString(r5, r6);
        r0 = r24;
        r0.value = r7;
    L_0x040f:
        r4 = r14;
        r5 = r15;
        r6 = r16;
        goto L_0x015f;
    L_0x0415:
        r5 = com.tencent.mm.R.l.ejq;
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r4 = r4.getDisplayName();
        r6[r7] = r4;
        r0 = r23;
        r4 = r0.getString(r5, r6);
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r14;
        goto L_0x015f;
    L_0x042e:
        r5 = com.tencent.mm.R.l.ejA;
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r4 = r4.getDisplayName();
        r6[r7] = r4;
        r0 = r23;
        r4 = r0.getString(r5, r6);
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r14;
        goto L_0x015f;
    L_0x0447:
        r5 = com.tencent.mm.R.l.eiC;
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r4 = r4.getDisplayName();
        r6[r7] = r4;
        r0 = r23;
        r4 = r0.getString(r5, r6);
        r0 = r24;
        r0.value = r4;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r14;
        goto L_0x015f;
    L_0x0464:
        if (r7 == 0) goto L_0x015b;
    L_0x0466:
        r4 = r7.length();
        if (r4 <= 0) goto L_0x015b;
    L_0x046c:
        r4 = com.tencent.mm.storage.au.a.XY(r7);
        r5 = r4.sfb;
        if (r5 == 0) goto L_0x0492;
    L_0x0474:
        r5 = r4.sfb;
        r5 = r5.length();
        if (r5 <= 0) goto L_0x0492;
    L_0x047c:
        r5 = com.tencent.mm.R.l.eiW;
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r4 = r4.getDisplayName();
        r6[r7] = r4;
        r0 = r23;
        r7 = r0.getString(r5, r6);
        r0 = r24;
        r0.value = r7;
    L_0x0492:
        r4 = r14;
        r5 = r15;
        r6 = r16;
        goto L_0x015f;
    L_0x0498:
        r4 = com.tencent.mm.sdk.platformtools.bi.oM(r7);
        r4 = r4.length();
        if (r4 <= 0) goto L_0x015b;
    L_0x04a2:
        com.tencent.mm.y.as.Hm();
        r4 = com.tencent.mm.y.c.Fh();
        r4 = r4.Fo(r7);
        r5 = com.tencent.mm.R.l.ejj;
        r6 = 2;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r8 = r4.hOy;
        r6[r7] = r8;
        r7 = 1;
        r4 = r4.title;
        r6[r7] = r4;
        r0 = r23;
        r4 = r0.getString(r5, r6);
        r0 = r24;
        r0.value = r4;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r14;
        goto L_0x015f;
    L_0x04cd:
        r4 = com.tencent.mm.sdk.platformtools.bi.oM(r7);
        r4 = r4.length();
        if (r4 <= 0) goto L_0x015b;
    L_0x04d7:
        r4 = com.tencent.mm.y.s.eX(r20);
        if (r4 == 0) goto L_0x04e7;
    L_0x04dd:
        r4 = com.tencent.mm.y.bb.hS(r7);
        r5 = android.text.TextUtils.isEmpty(r4);
        if (r5 == 0) goto L_0x04e9;
    L_0x04e7:
        r4 = r20;
    L_0x04e9:
        com.tencent.mm.y.as.Hm();
        r5 = com.tencent.mm.y.c.Fh();
        r6 = r5.Fq(r7);
        com.tencent.mm.y.as.Hm();
        r5 = com.tencent.mm.y.c.Ff();
        r5 = r5.Xv(r4);
        r5 = r5.AX();
        r7 = com.tencent.mm.y.s.eX(r5);
        if (r7 == 0) goto L_0x0511;
    L_0x0509:
        r5 = com.tencent.mm.y.m.go(r5);
        r5 = com.tencent.mm.y.m.B(r5);
    L_0x0511:
        r7 = 1;
        r0 = r19;
        if (r0 != r7) goto L_0x0551;
    L_0x0516:
        r7 = com.tencent.mm.R.l.eiD;
        r8 = 2;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r8[r9] = r5;
        r5 = 1;
        r9 = r6.getDisplayName();
        r8[r5] = r9;
        r0 = r23;
        r7 = r0.getString(r7, r8);
        r5 = com.tencent.mm.R.l.eiD;
        r8 = 2;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r10 = "%s";
        r8[r9] = r10;
        r9 = 1;
        r6 = r6.getDisplayName();
        r8[r9] = r6;
        r0 = r23;
        r5 = r0.getString(r5, r8);
        r0 = r24;
        r0.value = r5;
        r0 = r25;
        r0.value = r4;
        r4 = r14;
        r5 = r15;
        r6 = r16;
        goto L_0x015f;
    L_0x0551:
        r7 = com.tencent.mm.R.l.eiE;
        r8 = 2;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r8[r9] = r5;
        r5 = 1;
        r9 = r6.getDisplayName();
        r8[r5] = r9;
        r0 = r23;
        r7 = r0.getString(r7, r8);
        r5 = com.tencent.mm.R.l.eiE;
        r8 = 2;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r10 = "%s";
        r8[r9] = r10;
        r9 = 1;
        r6 = r6.getDisplayName();
        r8[r9] = r6;
        r0 = r23;
        r5 = r0.getString(r5, r8);
        r0 = r24;
        r0.value = r5;
        r0 = r25;
        r0.value = r4;
        r4 = r14;
        r5 = r15;
        r6 = r16;
        goto L_0x015f;
    L_0x058c:
        r4 = com.tencent.mm.sdk.platformtools.bi.oM(r7);
        r4 = r4.length();
        if (r4 <= 0) goto L_0x015b;
    L_0x0596:
        r4 = com.tencent.mm.y.s.eX(r20);
        if (r4 == 0) goto L_0x1396;
    L_0x059c:
        r4 = com.tencent.mm.y.bb.hR(r7);
        r5 = -1;
        if (r4 == r5) goto L_0x1392;
    L_0x05a3:
        r5 = 0;
        r4 = r7.substring(r5, r4);
        r4 = r4.trim();
    L_0x05ac:
        com.tencent.mm.y.bb.hT(r7);
        r5 = r4;
    L_0x05b0:
        r4 = 1;
        r0 = r19;
        if (r0 != r4) goto L_0x05c8;
    L_0x05b5:
        r4 = com.tencent.mm.R.l.etl;
        r0 = r23;
        r4 = r0.getString(r4);
        r0 = r24;
        r0.value = r4;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r14;
        goto L_0x015f;
    L_0x05c8:
        r4 = com.tencent.mm.R.l.etl;
        r0 = r23;
        r4 = r0.getString(r4);
        r6 = com.tencent.mm.R.l.etl;
        r0 = r23;
        r6 = r0.getString(r6);
        r0 = r24;
        r0.value = r6;
        r0 = r25;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r14;
        goto L_0x015f;
    L_0x05e7:
        r4 = com.tencent.mm.sdk.platformtools.bi.Wn(r4);
        r4 = com.tencent.mm.x.g.a.fV(r4);
        r5 = r4.hdh;
        if (r5 == 0) goto L_0x062f;
    L_0x05f3:
        r5 = r4.hdh;
        r6 = 1;
        if (r5 != r6) goto L_0x0613;
    L_0x05f8:
        r4 = com.tencent.mm.R.l.eIp;
        r0 = r23;
        r4 = r0.getString(r4);
    L_0x0600:
        r7 = "";
        r0 = r25;
        r0.value = r13;
        r5 = "";
        r0 = r24;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        goto L_0x015f;
    L_0x0613:
        r5 = r4.hdh;
        r6 = 2;
        if (r5 != r6) goto L_0x0621;
    L_0x0618:
        r4 = com.tencent.mm.R.l.eIr;
        r0 = r23;
        r4 = r0.getString(r4);
        goto L_0x0600;
    L_0x0621:
        r4 = r4.hdh;
        r5 = 3;
        if (r4 != r5) goto L_0x062f;
    L_0x0626:
        r4 = com.tencent.mm.R.l.eIq;
        r0 = r23;
        r4 = r0.getString(r4);
        goto L_0x0600;
    L_0x062f:
        r4 = com.tencent.mm.R.l.eIs;
        r0 = r23;
        r4 = r0.getString(r4);
        goto L_0x0600;
    L_0x0638:
        r5 = com.tencent.mm.sdk.platformtools.bi.Wn(r4);
        r18 = "";
        r4 = "";
        r5 = com.tencent.mm.x.g.a.fV(r5);
        if (r5 == 0) goto L_0x066f;
    L_0x0648:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r6 = com.tencent.mm.R.l.eIA;
        r0 = r23;
        r6 = r0.getString(r6);
        r4 = r4.append(r6);
        r5 = r5.title;
        r5 = com.tencent.mm.sdk.platformtools.bi.oM(r5);
        r4 = r4.append(r5);
        r4 = r4.toString();
        r0 = r24;
        r0.value = r4;
        r0 = r24;
        r4 = r0.value;
    L_0x066f:
        r0 = r25;
        r0.value = r13;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015f;
    L_0x067b:
        r5 = com.tencent.mm.sdk.platformtools.bi.Wn(r4);
        r18 = "";
        r4 = "";
        r5 = com.tencent.mm.x.g.a.fV(r5);
        if (r5 == 0) goto L_0x06a4;
    L_0x068b:
        r4 = 1;
        r0 = r19;
        if (r0 != r4) goto L_0x06b0;
    L_0x0690:
        r4 = 1;
    L_0x0691:
        r6 = r5.hdO;
        switch(r6) {
            case 1: goto L_0x06b2;
            case 2: goto L_0x0696;
            case 3: goto L_0x06ce;
            case 4: goto L_0x06ea;
            default: goto L_0x0696;
        };
    L_0x0696:
        r4 = r5.title;
        r4 = com.tencent.mm.sdk.platformtools.bi.oM(r4);
        r0 = r24;
        r0.value = r4;
    L_0x06a0:
        r0 = r24;
        r4 = r0.value;
    L_0x06a4:
        r0 = r25;
        r0.value = r13;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015f;
    L_0x06b0:
        r4 = 0;
        goto L_0x0691;
    L_0x06b2:
        if (r4 == 0) goto L_0x06c1;
    L_0x06b4:
        r4 = com.tencent.mm.R.l.dHr;
        r0 = r23;
        r4 = r0.getString(r4);
        r0 = r24;
        r0.value = r4;
        goto L_0x06a0;
    L_0x06c1:
        r4 = com.tencent.mm.R.l.dHu;
        r0 = r23;
        r4 = r0.getString(r4);
        r0 = r24;
        r0.value = r4;
        goto L_0x06a0;
    L_0x06ce:
        if (r4 == 0) goto L_0x06dd;
    L_0x06d0:
        r4 = com.tencent.mm.R.l.dHs;
        r0 = r23;
        r4 = r0.getString(r4);
        r0 = r24;
        r0.value = r4;
        goto L_0x06a0;
    L_0x06dd:
        r4 = com.tencent.mm.R.l.dHp;
        r0 = r23;
        r4 = r0.getString(r4);
        r0 = r24;
        r0.value = r4;
        goto L_0x06a0;
    L_0x06ea:
        if (r4 == 0) goto L_0x06f9;
    L_0x06ec:
        r4 = com.tencent.mm.R.l.dHt;
        r0 = r23;
        r4 = r0.getString(r4);
        r0 = r24;
        r0.value = r4;
        goto L_0x06a0;
    L_0x06f9:
        r4 = com.tencent.mm.R.l.dHq;
        r0 = r23;
        r4 = r0.getString(r4);
        r0 = r24;
        r0.value = r4;
        goto L_0x06a0;
    L_0x0706:
        r5 = com.tencent.mm.sdk.platformtools.bi.Wn(r4);
        r18 = "";
        r4 = "";
        r5 = com.tencent.mm.x.g.a.fV(r5);
        if (r5 == 0) goto L_0x0745;
    L_0x0716:
        r4 = 1;
        r0 = r19;
        if (r0 != r4) goto L_0x0759;
    L_0x071b:
        r4 = 1;
    L_0x071c:
        if (r4 == 0) goto L_0x075b;
    L_0x071e:
        r4 = new java.lang.StringBuilder;
        r6 = "[";
        r4.<init>(r6);
        r6 = r5.hep;
        r4 = r4.append(r6);
        r6 = "]";
        r4 = r4.append(r6);
        r5 = r5.hem;
        r4 = r4.append(r5);
        r4 = r4.toString();
        r0 = r24;
        r0.value = r4;
    L_0x0741:
        r0 = r24;
        r4 = r0.value;
    L_0x0745:
        r5 = com.tencent.mm.y.s.hg(r20);
        if (r5 != 0) goto L_0x138a;
    L_0x074b:
        if (r17 != 0) goto L_0x138a;
    L_0x074d:
        r0 = r25;
        r0.value = r13;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015f;
    L_0x0759:
        r4 = 0;
        goto L_0x071c;
    L_0x075b:
        r4 = com.tencent.mm.sdk.platformtools.bi.oN(r12);
        if (r4 != 0) goto L_0x0791;
    L_0x0761:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r6 = com.tencent.mm.sdk.platformtools.bi.oM(r12);
        r4 = r4.append(r6);
        r6 = ": [";
        r4 = r4.append(r6);
        r6 = r5.hep;
        r4 = r4.append(r6);
        r6 = "]";
        r4 = r4.append(r6);
        r5 = r5.hel;
        r4 = r4.append(r5);
        r4 = r4.toString();
        r0 = r24;
        r0.value = r4;
        goto L_0x0741;
    L_0x0791:
        r4 = new java.lang.StringBuilder;
        r6 = "[";
        r4.<init>(r6);
        r6 = r5.hep;
        r4 = r4.append(r6);
        r6 = "]";
        r4 = r4.append(r6);
        r5 = r5.hel;
        r4 = r4.append(r5);
        r4 = r4.toString();
        r0 = r24;
        r0.value = r4;
        goto L_0x0741;
    L_0x07b5:
        r5 = com.tencent.mm.sdk.platformtools.bi.Wn(r4);
        r18 = "";
        r4 = "";
        r5 = com.tencent.mm.x.g.a.fV(r5);
        if (r5 == 0) goto L_0x138a;
    L_0x07c5:
        r4 = com.tencent.mm.x.b.class;
        r4 = r5.r(r4);
        r4 = (com.tencent.mm.x.b) r4;
        r5 = 1;
        r0 = r19;
        if (r0 != r5) goto L_0x07f9;
    L_0x07d2:
        r5 = 1;
    L_0x07d3:
        if (r5 == 0) goto L_0x07fb;
    L_0x07d5:
        r5 = com.tencent.mm.R.l.epw;
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r4 = r4.hcC;
        r6[r7] = r4;
        r0 = r23;
        r4 = r0.getString(r5, r6);
        r0 = r24;
        r0.value = r4;
    L_0x07e9:
        r0 = r24;
        r4 = r0.value;
        r0 = r25;
        r0.value = r13;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015f;
    L_0x07f9:
        r5 = 0;
        goto L_0x07d3;
    L_0x07fb:
        r5 = com.tencent.mm.R.l.epw;
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r4 = r4.hcD;
        r6[r7] = r4;
        r0 = r23;
        r4 = r0.getString(r5, r6);
        r0 = r24;
        r0.value = r4;
        goto L_0x07e9;
    L_0x0810:
        r4 = com.tencent.mm.sdk.platformtools.bi.Wn(r4);
        r4 = com.tencent.mm.x.g.a.fV(r4);
        r4 = r4.hdh;
        switch(r4) {
            case 10000: goto L_0x0858;
            case 20000: goto L_0x0861;
            default: goto L_0x081d;
        };
    L_0x081d:
        r4 = com.tencent.mm.R.l.dGw;
        r0 = r23;
        r4 = r0.getString(r4);
    L_0x0825:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x086a;
    L_0x082b:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r5 = r5.append(r13);
        r6 = ": ";
        r5 = r5.append(r6);
        r5 = r5.toString();
    L_0x083f:
        r6 = com.tencent.mm.y.s.hg(r20);
        if (r6 != 0) goto L_0x084b;
    L_0x0845:
        if (r17 != 0) goto L_0x084b;
    L_0x0847:
        r0 = r25;
        r0.value = r13;
    L_0x084b:
        r6 = "";
        r0 = r24;
        r0.value = r6;
        r6 = r16;
        r7 = r5;
        r5 = r15;
        goto L_0x015f;
    L_0x0858:
        r4 = com.tencent.mm.R.l.dGx;
        r0 = r23;
        r4 = r0.getString(r4);
        goto L_0x0825;
    L_0x0861:
        r4 = com.tencent.mm.R.l.dGz;
        r0 = r23;
        r4 = r0.getString(r4);
        goto L_0x0825;
    L_0x086a:
        r5 = "";
        goto L_0x083f;
    L_0x086e:
        r4 = com.tencent.mm.sdk.platformtools.bi.Wn(r4);
        r5 = com.tencent.mm.x.g.a.fV(r4);
        if (r5 != 0) goto L_0x0886;
    L_0x0878:
        r4 = "MicroMsg.Notification.Wording";
        r5 = "decode msg content failed";
        com.tencent.mm.sdk.platformtools.x.e(r4, r5);
        r4 = "";
        goto L_0x0031;
    L_0x0886:
        r18 = "";
        r4 = com.tencent.mm.R.l.dPa;
        r0 = r23;
        r6 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x08e9;
    L_0x0897:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r7 = ": ";
        r4 = r4.append(r7);
        r4 = r4.append(r6);
        r7 = r5.title;
        r4 = r4.append(r7);
        r4 = r4.toString();
    L_0x08b5:
        r7 = com.tencent.mm.y.s.hg(r20);
        if (r7 != 0) goto L_0x08c1;
    L_0x08bb:
        if (r17 != 0) goto L_0x08c1;
    L_0x08bd:
        r0 = r25;
        r0.value = r13;
    L_0x08c1:
        r7 = r13.length();
        if (r7 <= 0) goto L_0x08fd;
    L_0x08c7:
        r7 = new java.lang.StringBuilder;
        r8 = "%s: ";
        r7.<init>(r8);
        r6 = r7.append(r6);
        r5 = r5.title;
        r5 = r6.append(r5);
        r5 = r5.toString();
    L_0x08dd:
        r0 = r24;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015f;
    L_0x08e9:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r6);
        r7 = r5.title;
        r4 = r4.append(r7);
        r4 = r4.toString();
        goto L_0x08b5;
    L_0x08fd:
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r6 = r7.append(r6);
        r5 = r5.title;
        r5 = r6.append(r5);
        r5 = r5.toString();
        goto L_0x08dd;
    L_0x0911:
        r4 = com.tencent.mm.sdk.platformtools.bi.Wn(r4);
        r4 = com.tencent.mm.x.g.a.fV(r4);
        if (r4 != 0) goto L_0x0929;
    L_0x091b:
        r4 = "MicroMsg.Notification.Wording";
        r5 = "decode msg content failed";
        com.tencent.mm.sdk.platformtools.x.e(r4, r5);
        r4 = "";
        goto L_0x0031;
    L_0x0929:
        r18 = "";
        r5 = com.tencent.mm.R.l.dPa;
        r0 = r23;
        r5 = r0.getString(r5);
        r6 = 1;
        r0 = r19;
        if (r0 != r6) goto L_0x097c;
    L_0x0939:
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r5 = r6.append(r5);
        r4 = r4.hec;
        r4 = r5.append(r4);
        r5 = r4.toString();
        r4 = r13.length();
        if (r4 <= 0) goto L_0x097a;
    L_0x0952:
        r4 = new java.lang.StringBuilder;
        r6 = "%s: ";
        r4.<init>(r6);
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0962:
        r0 = r24;
        r0.value = r4;
    L_0x0966:
        r4 = com.tencent.mm.y.s.hg(r20);
        if (r4 != 0) goto L_0x1382;
    L_0x096c:
        if (r17 != 0) goto L_0x1382;
    L_0x096e:
        r0 = r25;
        r0.value = r13;
        r4 = r18;
        r6 = r16;
        r7 = r5;
        r5 = r15;
        goto L_0x015f;
    L_0x097a:
        r4 = r5;
        goto L_0x0962;
    L_0x097c:
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r5 = r6.append(r5);
        r4 = r4.heb;
        r4 = r5.append(r4);
        r5 = r4.toString();
        r4 = r13.length();
        if (r4 <= 0) goto L_0x09aa;
    L_0x0995:
        r4 = new java.lang.StringBuilder;
        r6 = "%s: ";
        r4.<init>(r6);
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x09a5:
        r0 = r24;
        r0.value = r4;
        goto L_0x0966;
    L_0x09aa:
        r4 = r5;
        goto L_0x09a5;
    L_0x09ac:
        r4 = com.tencent.mm.sdk.platformtools.bi.Wn(r4);
        r5 = com.tencent.mm.x.g.a.fV(r4);
        if (r5 != 0) goto L_0x09c4;
    L_0x09b6:
        r4 = "MicroMsg.Notification.Wording";
        r5 = "decode msg content failed";
        com.tencent.mm.sdk.platformtools.x.e(r4, r5);
        r4 = "";
        goto L_0x0031;
    L_0x09c4:
        r18 = "";
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0a17;
    L_0x09cd:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r6 = ": ";
        r4 = r4.append(r6);
        r6 = r5.title;
        r4 = r4.append(r6);
        r4 = r4.toString();
    L_0x09e7:
        r6 = com.tencent.mm.y.s.hg(r20);
        if (r6 != 0) goto L_0x09f3;
    L_0x09ed:
        if (r17 != 0) goto L_0x09f3;
    L_0x09ef:
        r0 = r25;
        r0.value = r13;
    L_0x09f3:
        r6 = r13.length();
        if (r6 <= 0) goto L_0x0a1a;
    L_0x09f9:
        r6 = new java.lang.StringBuilder;
        r7 = "%s: ";
        r6.<init>(r7);
        r5 = r5.title;
        r5 = r6.append(r5);
        r5 = r5.toString();
    L_0x0a0b:
        r0 = r24;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015f;
    L_0x0a17:
        r4 = r5.title;
        goto L_0x09e7;
    L_0x0a1a:
        r5 = r5.title;
        goto L_0x0a0b;
    L_0x0a1d:
        r4 = com.tencent.mm.R.l.dDY;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0a60;
    L_0x0a2b:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0a3f:
        r5 = com.tencent.mm.y.s.hg(r20);
        if (r5 != 0) goto L_0x0a4b;
    L_0x0a45:
        if (r17 != 0) goto L_0x0a4b;
    L_0x0a47:
        r0 = r25;
        r0.value = r13;
    L_0x0a4b:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x0a64;
    L_0x0a51:
        r5 = "%s: ";
    L_0x0a54:
        r0 = r24;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015f;
    L_0x0a60:
        r4 = "";
        goto L_0x0a3f;
    L_0x0a64:
        r5 = "";
        goto L_0x0a54;
    L_0x0a68:
        r4 = com.tencent.mm.sdk.platformtools.bi.Wn(r4);
        r8 = com.tencent.mm.x.g.a.fV(r4);
        if (r8 != 0) goto L_0x0a80;
    L_0x0a72:
        r4 = "MicroMsg.Notification.Wording";
        r5 = "decode msg content failed";
        com.tencent.mm.sdk.platformtools.x.e(r4, r5);
        r4 = "";
        goto L_0x0031;
    L_0x0a80:
        r5 = r8.type;
        switch(r5) {
            case 1: goto L_0x0a95;
            case 2: goto L_0x0aee;
            case 3: goto L_0x0b39;
            case 4: goto L_0x0b84;
            case 5: goto L_0x0c65;
            case 6: goto L_0x0bcf;
            case 7: goto L_0x0c1a;
            case 8: goto L_0x0d49;
            case 9: goto L_0x0a85;
            case 10: goto L_0x0a85;
            case 11: goto L_0x0a85;
            case 12: goto L_0x0a85;
            case 13: goto L_0x0a85;
            case 14: goto L_0x0a85;
            case 15: goto L_0x0d8a;
            case 16: goto L_0x0f30;
            case 17: goto L_0x0e0c;
            case 18: goto L_0x0a85;
            case 19: goto L_0x0e65;
            case 20: goto L_0x0a85;
            case 21: goto L_0x0a85;
            case 22: goto L_0x0a85;
            case 23: goto L_0x0a85;
            case 24: goto L_0x0eb0;
            case 25: goto L_0x0dcb;
            case 26: goto L_0x0d8a;
            case 27: goto L_0x0d8a;
            case 28: goto L_0x0a85;
            case 29: goto L_0x0a85;
            case 30: goto L_0x0a85;
            case 31: goto L_0x0a85;
            case 32: goto L_0x0a85;
            case 33: goto L_0x0cb8;
            case 34: goto L_0x0fa1;
            case 35: goto L_0x0a85;
            case 36: goto L_0x0cb8;
            case 37: goto L_0x0a85;
            case 38: goto L_0x0a85;
            case 39: goto L_0x0a85;
            case 40: goto L_0x1024;
            default: goto L_0x0a85;
        };
    L_0x0a85:
        r4 = com.tencent.mm.R.l.dDY;
        r0 = r23;
        r4 = r0.getString(r4);
        r7 = "";
        r5 = r15;
        r6 = r16;
        goto L_0x015f;
    L_0x0a95:
        r18 = "";
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0ae8;
    L_0x0a9e:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r5 = r8.title;
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0ab8:
        r5 = com.tencent.mm.y.s.hg(r20);
        if (r5 != 0) goto L_0x0ac4;
    L_0x0abe:
        if (r17 != 0) goto L_0x0ac4;
    L_0x0ac0:
        r0 = r25;
        r0.value = r13;
    L_0x0ac4:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x0aeb;
    L_0x0aca:
        r5 = new java.lang.StringBuilder;
        r6 = "%s: ";
        r5.<init>(r6);
        r6 = r8.title;
        r5 = r5.append(r6);
        r5 = r5.toString();
    L_0x0adc:
        r0 = r24;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015f;
    L_0x0ae8:
        r4 = r8.title;
        goto L_0x0ab8;
    L_0x0aeb:
        r5 = r8.title;
        goto L_0x0adc;
    L_0x0aee:
        r4 = com.tencent.mm.R.l.dGu;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0b31;
    L_0x0afc:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0b10:
        r5 = com.tencent.mm.y.s.hg(r20);
        if (r5 != 0) goto L_0x0b1c;
    L_0x0b16:
        if (r17 != 0) goto L_0x0b1c;
    L_0x0b18:
        r0 = r25;
        r0.value = r13;
    L_0x0b1c:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x0b35;
    L_0x0b22:
        r5 = "%s: ";
    L_0x0b25:
        r0 = r24;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015f;
    L_0x0b31:
        r4 = "";
        goto L_0x0b10;
    L_0x0b35:
        r5 = "";
        goto L_0x0b25;
    L_0x0b39:
        r4 = com.tencent.mm.R.l.dFU;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0b7c;
    L_0x0b47:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0b5b:
        r5 = com.tencent.mm.y.s.hg(r20);
        if (r5 != 0) goto L_0x0b67;
    L_0x0b61:
        if (r17 != 0) goto L_0x0b67;
    L_0x0b63:
        r0 = r25;
        r0.value = r13;
    L_0x0b67:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x0b80;
    L_0x0b6d:
        r5 = "%s: ";
    L_0x0b70:
        r0 = r24;
        r0.value = r5;
        r6 = 1;
        r5 = r8.title;
        r7 = r4;
        r4 = r18;
        goto L_0x015f;
    L_0x0b7c:
        r4 = "";
        goto L_0x0b5b;
    L_0x0b80:
        r5 = "";
        goto L_0x0b70;
    L_0x0b84:
        r4 = com.tencent.mm.R.l.dHi;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0bc7;
    L_0x0b92:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0ba6:
        r5 = com.tencent.mm.y.s.hg(r20);
        if (r5 != 0) goto L_0x0bb2;
    L_0x0bac:
        if (r17 != 0) goto L_0x0bb2;
    L_0x0bae:
        r0 = r25;
        r0.value = r13;
    L_0x0bb2:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x0bcb;
    L_0x0bb8:
        r5 = "%s: ";
    L_0x0bbb:
        r0 = r24;
        r0.value = r5;
        r6 = 1;
        r5 = r8.title;
        r7 = r4;
        r4 = r18;
        goto L_0x015f;
    L_0x0bc7:
        r4 = "";
        goto L_0x0ba6;
    L_0x0bcb:
        r5 = "";
        goto L_0x0bbb;
    L_0x0bcf:
        r4 = com.tencent.mm.R.l.dFu;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0c12;
    L_0x0bdd:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0bf1:
        r5 = com.tencent.mm.y.s.hg(r20);
        if (r5 != 0) goto L_0x0bfd;
    L_0x0bf7:
        if (r17 != 0) goto L_0x0bfd;
    L_0x0bf9:
        r0 = r25;
        r0.value = r13;
    L_0x0bfd:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x0c16;
    L_0x0c03:
        r5 = "%s: ";
    L_0x0c06:
        r0 = r24;
        r0.value = r5;
        r6 = 1;
        r5 = r8.title;
        r7 = r4;
        r4 = r18;
        goto L_0x015f;
    L_0x0c12:
        r4 = "";
        goto L_0x0bf1;
    L_0x0c16:
        r5 = "";
        goto L_0x0c06;
    L_0x0c1a:
        r4 = com.tencent.mm.R.l.dDY;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0c5d;
    L_0x0c28:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0c3c:
        r5 = com.tencent.mm.y.s.hg(r20);
        if (r5 != 0) goto L_0x0c48;
    L_0x0c42:
        if (r17 != 0) goto L_0x0c48;
    L_0x0c44:
        r0 = r25;
        r0.value = r13;
    L_0x0c48:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x0c61;
    L_0x0c4e:
        r5 = "%s: ";
    L_0x0c51:
        r0 = r24;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015f;
    L_0x0c5d:
        r4 = "";
        goto L_0x0c3c;
    L_0x0c61:
        r5 = "";
        goto L_0x0c51;
    L_0x0c65:
        r4 = com.tencent.mm.R.l.dHf;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0cb0;
    L_0x0c73:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0c87:
        r5 = com.tencent.mm.y.s.hg(r20);
        if (r5 != 0) goto L_0x0c99;
    L_0x0c8d:
        if (r17 != 0) goto L_0x0c99;
    L_0x0c8f:
        r5 = com.tencent.mm.y.s.hp(r20);
        if (r5 != 0) goto L_0x0c99;
    L_0x0c95:
        r0 = r25;
        r0.value = r13;
    L_0x0c99:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x0cb4;
    L_0x0c9f:
        r5 = "%s: ";
    L_0x0ca2:
        r0 = r24;
        r0.value = r5;
        r6 = 1;
        r5 = r8.getTitle();
        r7 = r4;
        r4 = r18;
        goto L_0x015f;
    L_0x0cb0:
        r4 = "";
        goto L_0x0c87;
    L_0x0cb4:
        r5 = "";
        goto L_0x0ca2;
    L_0x0cb8:
        r18 = "";
        r4 = com.tencent.mm.R.l.dEc;
        r0 = r23;
        r5 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0d21;
    L_0x0cc9:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r6 = ": ";
        r4 = r4.append(r6);
        r4 = r4.append(r5);
        r6 = r8.title;
        r4 = r4.append(r6);
        r4 = r4.toString();
    L_0x0ce7:
        r6 = com.tencent.mm.y.s.hg(r20);
        if (r6 != 0) goto L_0x0cf9;
    L_0x0ced:
        if (r17 != 0) goto L_0x0cf9;
    L_0x0cef:
        r6 = com.tencent.mm.y.s.hp(r20);
        if (r6 != 0) goto L_0x0cf9;
    L_0x0cf5:
        r0 = r25;
        r0.value = r13;
    L_0x0cf9:
        r6 = r13.length();
        if (r6 <= 0) goto L_0x0d35;
    L_0x0cff:
        r6 = new java.lang.StringBuilder;
        r7 = "%s: ";
        r6.<init>(r7);
        r5 = r6.append(r5);
        r6 = r8.title;
        r5 = r5.append(r6);
        r5 = r5.toString();
    L_0x0d15:
        r0 = r24;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015f;
    L_0x0d21:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r5);
        r6 = r8.title;
        r4 = r4.append(r6);
        r4 = r4.toString();
        goto L_0x0ce7;
    L_0x0d35:
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r5 = r6.append(r5);
        r6 = r8.title;
        r5 = r5.append(r6);
        r5 = r5.toString();
        goto L_0x0d15;
    L_0x0d49:
        r4 = com.tencent.mm.R.l.dES;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0d86;
    L_0x0d57:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0d6b:
        r5 = com.tencent.mm.y.s.hg(r20);
        if (r5 != 0) goto L_0x0d77;
    L_0x0d71:
        if (r17 != 0) goto L_0x0d77;
    L_0x0d73:
        r0 = r25;
        r0.value = r13;
    L_0x0d77:
        r5 = "";
        r0 = r24;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015f;
    L_0x0d86:
        r4 = "";
        goto L_0x0d6b;
    L_0x0d8a:
        r4 = com.tencent.mm.R.l.dET;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0dc7;
    L_0x0d98:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0dac:
        r5 = com.tencent.mm.y.s.hg(r20);
        if (r5 != 0) goto L_0x0db8;
    L_0x0db2:
        if (r17 != 0) goto L_0x0db8;
    L_0x0db4:
        r0 = r25;
        r0.value = r13;
    L_0x0db8:
        r5 = "";
        r0 = r24;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015f;
    L_0x0dc7:
        r4 = "";
        goto L_0x0dac;
    L_0x0dcb:
        r4 = com.tencent.mm.R.l.dEJ;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0e08;
    L_0x0dd9:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0ded:
        r5 = com.tencent.mm.y.s.hg(r20);
        if (r5 != 0) goto L_0x0df9;
    L_0x0df3:
        if (r17 != 0) goto L_0x0df9;
    L_0x0df5:
        r0 = r25;
        r0.value = r13;
    L_0x0df9:
        r5 = "";
        r0 = r24;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015f;
    L_0x0e08:
        r4 = "";
        goto L_0x0ded;
    L_0x0e0c:
        r18 = "";
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0e5f;
    L_0x0e15:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r5 = r8.title;
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0e2f:
        r5 = com.tencent.mm.y.s.hg(r20);
        if (r5 != 0) goto L_0x0e3b;
    L_0x0e35:
        if (r17 != 0) goto L_0x0e3b;
    L_0x0e37:
        r0 = r25;
        r0.value = r13;
    L_0x0e3b:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x0e62;
    L_0x0e41:
        r5 = new java.lang.StringBuilder;
        r6 = "%s: ";
        r5.<init>(r6);
        r6 = r8.title;
        r5 = r5.append(r6);
        r5 = r5.toString();
    L_0x0e53:
        r0 = r24;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015f;
    L_0x0e5f:
        r4 = r8.title;
        goto L_0x0e2f;
    L_0x0e62:
        r5 = r8.title;
        goto L_0x0e53;
    L_0x0e65:
        r4 = com.tencent.mm.R.l.dGD;
        r0 = r23;
        r18 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0ea8;
    L_0x0e73:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0e87:
        r5 = com.tencent.mm.y.s.hg(r20);
        if (r5 != 0) goto L_0x0e93;
    L_0x0e8d:
        if (r17 != 0) goto L_0x0e93;
    L_0x0e8f:
        r0 = r25;
        r0.value = r13;
    L_0x0e93:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x0eac;
    L_0x0e99:
        r5 = "%s: ";
    L_0x0e9c:
        r0 = r24;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015f;
    L_0x0ea8:
        r4 = "";
        goto L_0x0e87;
    L_0x0eac:
        r5 = "";
        goto L_0x0e9c;
    L_0x0eb0:
        r4 = "";
        r5 = r8.description;
        r5 = com.tencent.mm.sdk.platformtools.bi.oN(r5);
        if (r5 != 0) goto L_0x0ecd;
    L_0x0ebb:
        r4 = r8.description;
        r5 = "\n";
        r4 = r4.indexOf(r5);
        r5 = r8.description;
        r6 = 0;
        if (r4 <= 0) goto L_0x0f21;
    L_0x0ec9:
        r4 = r5.substring(r6, r4);
    L_0x0ecd:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = com.tencent.mm.R.l.ehl;
        r0 = r23;
        r6 = r0.getString(r6);
        r5 = r5.append(r6);
        r4 = r5.append(r4);
        r18 = r4.toString();
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0f28;
    L_0x0eec:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r5 = ": ";
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0f00:
        r5 = com.tencent.mm.y.s.hg(r20);
        if (r5 != 0) goto L_0x0f0c;
    L_0x0f06:
        if (r17 != 0) goto L_0x0f0c;
    L_0x0f08:
        r0 = r25;
        r0.value = r13;
    L_0x0f0c:
        r5 = r13.length();
        if (r5 <= 0) goto L_0x0f2c;
    L_0x0f12:
        r5 = "%s: ";
    L_0x0f15:
        r0 = r24;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015f;
    L_0x0f21:
        r4 = r8.description;
        r4 = r4.length();
        goto L_0x0ec9;
    L_0x0f28:
        r4 = "";
        goto L_0x0f00;
    L_0x0f2c:
        r5 = "";
        goto L_0x0f15;
    L_0x0f30:
        r18 = "";
        r4 = com.tencent.mm.R.l.dPa;
        r0 = r23;
        r5 = r0.getString(r4);
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0f8d;
    L_0x0f41:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r13);
        r6 = ": ";
        r4 = r4.append(r6);
        r4 = r4.append(r5);
        r6 = r8.title;
        r4 = r4.append(r6);
        r4 = r4.toString();
    L_0x0f5f:
        r6 = com.tencent.mm.y.s.hg(r20);
        if (r6 != 0) goto L_0x0f6b;
    L_0x0f65:
        if (r17 != 0) goto L_0x0f6b;
    L_0x0f67:
        r0 = r25;
        r0.value = r13;
    L_0x0f6b:
        r6 = r13.length();
        if (r6 <= 0) goto L_0x0f81;
    L_0x0f71:
        r6 = new java.lang.StringBuilder;
        r7 = "%s: ";
        r6.<init>(r7);
        r5 = r6.append(r5);
        r5 = r5.toString();
    L_0x0f81:
        r0 = r24;
        r0.value = r5;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015f;
    L_0x0f8d:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r5);
        r6 = r8.title;
        r4 = r4.append(r6);
        r4 = r4.toString();
        goto L_0x0f5f;
    L_0x0fa1:
        r18 = "";
        r4 = com.tencent.mm.R.l.dPa;
        r0 = r23;
        r4 = r0.getString(r4);
        r5 = 1;
        r0 = r19;
        if (r0 != r5) goto L_0x0ff4;
    L_0x0fb1:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r4 = r5.append(r4);
        r5 = r8.hec;
        r4 = r4.append(r5);
        r5 = r4.toString();
        r4 = r13.length();
        if (r4 <= 0) goto L_0x0ff2;
    L_0x0fca:
        r4 = new java.lang.StringBuilder;
        r6 = "%s: ";
        r4.<init>(r6);
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x0fda:
        r0 = r24;
        r0.value = r4;
    L_0x0fde:
        r4 = com.tencent.mm.y.s.hg(r20);
        if (r4 != 0) goto L_0x1382;
    L_0x0fe4:
        if (r17 != 0) goto L_0x1382;
    L_0x0fe6:
        r0 = r25;
        r0.value = r13;
        r4 = r18;
        r6 = r16;
        r7 = r5;
        r5 = r15;
        goto L_0x015f;
    L_0x0ff2:
        r4 = r5;
        goto L_0x0fda;
    L_0x0ff4:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r4 = r5.append(r4);
        r5 = r8.heb;
        r4 = r4.append(r5);
        r5 = r4.toString();
        r4 = r13.length();
        if (r4 <= 0) goto L_0x1022;
    L_0x100d:
        r4 = new java.lang.StringBuilder;
        r6 = "%s: ";
        r4.<init>(r6);
        r4 = r4.append(r5);
        r4 = r4.toString();
    L_0x101d:
        r0 = r24;
        r0.value = r4;
        goto L_0x0fde;
    L_0x1022:
        r4 = r5;
        goto L_0x101d;
    L_0x1024:
        r4 = com.tencent.mm.x.k.fZ(r4);
        r4 = r4.hfL;
        r5 = 19;
        if (r4 != r5) goto L_0x103b;
    L_0x102e:
        r4 = com.tencent.mm.R.l.dGD;
        r0 = r23;
        r4 = r0.getString(r4);
        r5 = r15;
        r6 = r16;
        goto L_0x015f;
    L_0x103b:
        r4 = com.tencent.mm.R.l.dDY;
        r0 = r23;
        r4 = r0.getString(r4);
        r5 = r15;
        r6 = r16;
        goto L_0x015f;
    L_0x1048:
        if (r11 == 0) goto L_0x104e;
    L_0x104a:
        r7 = eA(r7);
    L_0x104e:
        r4 = com.tencent.mm.plugin.biz.a.a.class;
        r4 = com.tencent.mm.kernel.g.h(r4);
        r4 = (com.tencent.mm.plugin.biz.a.a) r4;
        r4 = r4.wq(r7);
        r4 = ez(r4);
        r0 = r24;
        r0.value = r4;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r14;
        goto L_0x015f;
    L_0x1069:
        r4 = com.tencent.mm.plugin.biz.a.a.class;
        r4 = com.tencent.mm.kernel.g.h(r4);
        r4 = (com.tencent.mm.plugin.biz.a.a) r4;
        r4 = r4.wp(r7);
        r0 = r24;
        r0.value = r4;
        r0 = r24;
        r4 = r0.value;
        r5 = r15;
        r6 = r16;
        goto L_0x015f;
    L_0x1082:
        r4 = com.tencent.mm.ag.a.a.kB(r7);
        r4 = com.tencent.mm.ag.a.b(r4);
        r0 = r24;
        r0.value = r4;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r14;
        goto L_0x015f;
    L_0x1095:
        r7 = "";
        r4 = com.tencent.mm.x.g.a.fV(r4);
        if (r4 == 0) goto L_0x015b;
    L_0x109e:
        r4 = r4.content;	 Catch:{ Exception -> 0x10b6 }
        r5 = "UTF-8";
        r7 = java.net.URLDecoder.decode(r4, r5);	 Catch:{ Exception -> 0x10b6 }
        r4 = com.tencent.mm.pluginsdk.ui.d.i.Tm(r7);	 Catch:{ Exception -> 0x10b6 }
        r0 = r24;
        r0.value = r4;	 Catch:{ Exception -> 0x137a }
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r14;
        goto L_0x015f;
    L_0x10b6:
        r4 = move-exception;
        r5 = r4;
        r4 = r7;
    L_0x10b9:
        r6 = "MicroMsg.Notification.Wording";
        r7 = "";
        r8 = 0;
        r8 = new java.lang.Object[r8];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r6, r5, r7, r8);
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r14;
        goto L_0x015f;
    L_0x10cc:
        r4 = com.tencent.mm.plugin.messenger.a.e.class;
        r4 = com.tencent.mm.kernel.g.h(r4);
        r4 = (com.tencent.mm.plugin.messenger.a.e) r4;
        r4 = r4.EW(r7);
        if (r4 == 0) goto L_0x10e9;
    L_0x10da:
        r4 = r4.toString();
    L_0x10de:
        r0 = r24;
        r0.value = r4;
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r14;
        goto L_0x015f;
    L_0x10e9:
        r4 = "";
        goto L_0x10de;
    L_0x10ed:
        r4 = "@bottle:";
        r4 = r7.split(r4);
        r5 = r4.length;
        r6 = 1;
        if (r5 <= r6) goto L_0x1104;
    L_0x10f8:
        r5 = 1;
        r5 = r4[r5];
        r0 = r24;
        r0.value = r5;
        r5 = 1;
        r4 = r4[r5];
        goto L_0x0031;
    L_0x1104:
        r4 = "";
        r0 = r24;
        r0.value = r4;
        r4 = 0;
        goto L_0x0031;
    L_0x110e:
        r5 = 0;
        r6 = ":";
        r6 = r7.split(r6);
        if (r6 == 0) goto L_0x111b;
    L_0x1118:
        r8 = r6.length;
        if (r8 > 0) goto L_0x1125;
    L_0x111b:
        r4 = "";
        r0 = r24;
        r0.value = r4;
        r4 = 0;
        goto L_0x0031;
    L_0x1125:
        r8 = 0;
        r6 = r6[r8];
        r8 = com.tencent.mm.sdk.platformtools.bi.oN(r6);
        if (r8 != 0) goto L_0x1151;
    L_0x112e:
        com.tencent.mm.y.as.Hm();
        r8 = com.tencent.mm.y.c.Ff();
        r6 = r8.Xv(r6);
        if (r6 == 0) goto L_0x1145;
    L_0x113b:
        r8 = r6.getCity();
        if (r8 == 0) goto L_0x1145;
    L_0x1141:
        r5 = r6.getCity();
    L_0x1145:
        if (r5 == 0) goto L_0x114d;
    L_0x1147:
        r8 = r5.length();
        if (r8 > 0) goto L_0x1151;
    L_0x114d:
        r5 = r6.getProvince();
    L_0x1151:
        r6 = com.tencent.mm.sdk.platformtools.bi.oN(r4);
        if (r6 != 0) goto L_0x118d;
    L_0x1157:
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r6 = r6.append(r5);
        r7 = ": ";
        r6 = r6.append(r7);
        r6 = r6.append(r4);
        r6 = r6.toString();
        r0 = r24;
        r0.value = r6;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r5 = r6.append(r5);
        r6 = ": ";
        r5 = r5.append(r6);
        r4 = r5.append(r4);
        r4 = r4.toString();
        goto L_0x0031;
    L_0x118d:
        r4 = "@bottle:";
        r4 = r7.split(r4);
        r6 = r4.length;
        r7 = 1;
        if (r6 <= r7) goto L_0x11d4;
    L_0x1198:
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r6 = r6.append(r5);
        r7 = ": ";
        r6 = r6.append(r7);
        r7 = 1;
        r7 = r4[r7];
        r6 = r6.append(r7);
        r6 = r6.toString();
        r0 = r24;
        r0.value = r6;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r5 = r6.append(r5);
        r6 = ": ";
        r5 = r5.append(r6);
        r6 = 1;
        r4 = r4[r6];
        r4 = r5.append(r4);
        r4 = r4.toString();
        goto L_0x0031;
    L_0x11d4:
        r0 = r24;
        r0.value = r5;
        r4 = r5;
        goto L_0x0031;
    L_0x11db:
        r8 = com.tencent.mm.sdk.platformtools.bi.oN(r7);
        if (r8 == 0) goto L_0x11e8;
    L_0x11e1:
        r8 = "";
        r0 = r24;
        r0.value = r8;
    L_0x11e8:
        r8 = com.tencent.mm.sdk.platformtools.bi.oN(r13);
        if (r8 != 0) goto L_0x12a0;
    L_0x11ee:
        if (r12 == 0) goto L_0x11fa;
    L_0x11f0:
        r8 = r12.length();
        if (r8 <= 0) goto L_0x11fa;
    L_0x11f6:
        r7 = h(r7, r13, r12);
    L_0x11fa:
        r0 = r25;
        r8 = r0.value;
        r8 = com.tencent.mm.sdk.platformtools.bi.oN(r8);
        if (r8 == 0) goto L_0x1217;
    L_0x1204:
        r0 = r24;
        r8 = r0.value;
        r9 = "%s";
        r8 = h(r8, r13, r9);
        r0 = r24;
        r0.value = r8;
        r0 = r25;
        r0.value = r13;
    L_0x1217:
        r7 = com.tencent.mm.compatible.util.n.eP(r7);
        r0 = r24;
        r8 = r0.value;
        r8 = com.tencent.mm.compatible.util.n.eP(r8);
        r0 = r24;
        r0.value = r8;
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r7 = r8.append(r7);
        r7 = r7.append(r4);
        r7 = r7.toString();
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r0 = r24;
        r9 = r0.value;
        r8 = r8.append(r9);
        r4 = r8.append(r4);
        r4 = r4.toString();
        r0 = r24;
        r0.value = r4;
        if (r27 == 0) goto L_0x127e;
    L_0x1253:
        r0 = r24;
        r4 = r0.value;
        r4 = r4.length();
        r8 = 32;
        if (r4 != r8) goto L_0x129e;
    L_0x125f:
        r4 = 47;
        r0 = r22;
        if (r0 == r4) goto L_0x126c;
    L_0x1265:
        r4 = 1048625; // 0x100031 float:1.469437E-39 double:5.180896E-318;
        r0 = r22;
        if (r0 != r4) goto L_0x129e;
    L_0x126c:
        r0 = r24;
        r0.value = r7;
        r4 = 1;
    L_0x1271:
        if (r4 != 0) goto L_0x127e;
    L_0x1273:
        r0 = r22;
        r1 = r24;
        r2 = r25;
        r3 = r26;
        a(r0, r1, r2, r3);
    L_0x127e:
        if (r6 == 0) goto L_0x137f;
    L_0x1280:
        r4 = new java.lang.StringBuilder;
        r6 = " ";
        r4.<init>(r6);
        r5 = com.tencent.mm.sdk.platformtools.bi.oM(r5);
        r4 = r4.append(r5);
        r4 = r4.toString();
        r4 = r7.concat(r4);
    L_0x1298:
        r4 = com.tencent.mm.sdk.platformtools.bi.oM(r4);
        goto L_0x0031;
    L_0x129e:
        r4 = 0;
        goto L_0x1271;
    L_0x12a0:
        r8 = com.tencent.mm.y.s.hg(r20);
        if (r8 != 0) goto L_0x12ae;
    L_0x12a6:
        if (r17 != 0) goto L_0x12ae;
    L_0x12a8:
        r8 = com.tencent.mm.y.s.hp(r20);
        if (r8 == 0) goto L_0x135f;
    L_0x12ae:
        if (r4 == 0) goto L_0x12b7;
    L_0x12b0:
        r8 = r4.length();
        if (r8 <= 0) goto L_0x12b7;
    L_0x12b6:
        r7 = r4;
    L_0x12b7:
        r4 = com.tencent.mm.sdk.platformtools.bi.oN(r7);
        if (r4 == 0) goto L_0x12d0;
    L_0x12bd:
        r4 = "";
        r0 = r24;
        r0.value = r4;
        r4 = "";
        r0 = r25;
        r0.value = r4;
        r4 = "";
        goto L_0x0031;
    L_0x12d0:
        if (r19 != 0) goto L_0x1318;
    L_0x12d2:
        r4 = new java.lang.StringBuilder;
        r8 = "%s:";
        r4.<init>(r8);
        r4 = r4.append(r7);
        r4 = r4.toString();
        r0 = r24;
        r0.value = r4;
    L_0x12e6:
        if (r27 == 0) goto L_0x133d;
    L_0x12e8:
        r0 = r22;
        r1 = r24;
        r2 = r25;
        r3 = r26;
        a(r0, r1, r2, r3);
        r4 = r7;
    L_0x12f4:
        if (r6 == 0) goto L_0x130c;
    L_0x12f6:
        if (r5 == 0) goto L_0x130c;
    L_0x12f8:
        r6 = new java.lang.StringBuilder;
        r7 = " ";
        r6.<init>(r7);
        r5 = r6.append(r5);
        r5 = r5.toString();
        r4 = r4.concat(r5);
    L_0x130c:
        if (r11 == 0) goto L_0x1312;
    L_0x130e:
        r4 = eA(r4);
    L_0x1312:
        r4 = com.tencent.mm.sdk.platformtools.bi.oM(r4);
        goto L_0x0031;
    L_0x1318:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r8 = com.tencent.mm.R.l.dFM;
        r0 = r23;
        r8 = r0.getString(r8);
        r4 = r4.append(r8);
        r8 = ":";
        r4 = r4.append(r8);
        r4 = r4.append(r7);
        r4 = r4.toString();
        r0 = r24;
        r0.value = r4;
        goto L_0x12e6;
    L_0x133d:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r0 = r25;
        r5 = r0.value;
        r5 = com.tencent.mm.y.r.gw(r5);
        r4 = r4.append(r5);
        r5 = ":";
        r4 = r4.append(r5);
        r4 = r4.append(r7);
        r4 = r4.toString();
        goto L_0x0031;
    L_0x135f:
        if (r4 == 0) goto L_0x137d;
    L_0x1361:
        r8 = r4.length();
        if (r8 <= 0) goto L_0x137d;
    L_0x1367:
        r0 = r24;
        r0.value = r4;
    L_0x136b:
        if (r27 == 0) goto L_0x12f4;
    L_0x136d:
        r0 = r22;
        r1 = r24;
        r2 = r25;
        r3 = r26;
        a(r0, r1, r2, r3);
        goto L_0x12f4;
    L_0x137a:
        r5 = move-exception;
        goto L_0x10b9;
    L_0x137d:
        r4 = r7;
        goto L_0x136b;
    L_0x137f:
        r4 = r7;
        goto L_0x1298;
    L_0x1382:
        r4 = r18;
        r6 = r16;
        r7 = r5;
        r5 = r15;
        goto L_0x015f;
    L_0x138a:
        r5 = r15;
        r6 = r16;
        r7 = r4;
        r4 = r18;
        goto L_0x015f;
    L_0x1392:
        r4 = r20;
        goto L_0x05ac;
    L_0x1396:
        r5 = r20;
        goto L_0x05b0;
    L_0x139a:
        r17 = r5;
        r7 = r21;
        goto L_0x0158;
    L_0x13a0:
        r4 = r21;
        r12 = r5;
        r13 = r6;
        goto L_0x0128;
    L_0x13a6:
        r11 = r4;
        goto L_0x00e5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.booter.notification.a.h.a(java.lang.String, int, java.lang.String, java.lang.String, int, android.content.Context, com.tencent.mm.pointers.PString, com.tencent.mm.pointers.PString, com.tencent.mm.pointers.PInt, boolean, boolean):java.lang.String");
    }

    private static String a(Context context, int i, String str, String str2, String str3, PString pString, PString pString2) {
        StringBuilder append;
        String str4 = "";
        if (s.gN(str) || s.gP(str)) {
            if (str2 != null) {
                int indexOf = str2.indexOf(":");
                if (indexOf >= 0 && indexOf < str2.length()) {
                    String substring = str2.substring(0, indexOf);
                    if (x.Xd(substring) || x.Xf(substring)) {
                        str4 = r.gw(substring);
                        pString2.value = substring;
                        str2 = str2.substring(indexOf + 1);
                    }
                }
            }
        } else if (x.Xd(str) || x.Xf(str)) {
            r.gw(str);
            pString2.value = str;
            if (i == 1) {
                append = new StringBuilder().append(context.getString(R.l.ejn, new Object[]{""}));
                if (str3 != null) {
                    str2 = str3;
                }
                pString.value = append.append(str2).toString();
                pString2.value = "";
                return pString.value;
            }
            if (str3 != null) {
                str2 = str3;
            }
            pString.value = str2;
            pString2.value = "";
            return pString.value;
        }
        if (bi.oM(str4).length() <= 0) {
            if (str3 != null) {
                str2 = str3;
            }
            pString.value = str2;
            return pString.value;
        }
        pString.value = context.getString(i == 1 ? R.l.ejn : R.l.ejx) + (str3 == null ? str2 : str3);
        append = new StringBuilder().append(context.getString(i == 1 ? R.l.ejn : R.l.ejx, new Object[]{str4}));
        if (str3 != null) {
            str2 = str3;
        }
        return append.append(str2).toString();
    }

    private static String ez(String str) {
        if (str != null) {
            return str.replaceAll("%", "%%");
        }
        return str;
    }

    private static String h(String str, String str2, String str3) {
        if (bi.oN(str) || bi.oN(str2) || bi.oN(str3)) {
            return str;
        }
        int indexOf = str.indexOf(str2);
        return indexOf >= 0 ? str.substring(0, indexOf) + str3 + str.substring(indexOf + str2.length()) : str;
    }

    private static String eA(String str) {
        if (str != null) {
            return str.replaceAll("%%", "%");
        }
        return str;
    }

    public static String eB(String str) {
        if (str == null) {
            return "";
        }
        return str.length() >= 150 ? str.substring(0, 150) + "..." : str;
    }

    private static void a(int i, PString pString, PString pString2, PInt pInt) {
        int i2 = 150;
        if (pString.value.length() != 32 || (i != 47 && i != 1048625)) {
            if (pString.value.length() >= 150) {
                String str = pString.value;
                String str2 = pString.value;
                while (i2 < str2.length()) {
                    if (str2.charAt(i2) != '%') {
                        break;
                    }
                    i2++;
                }
                i2 = str2.length();
                pString.value = str.substring(0, i2);
            }
            TextPaint textPaint = gCD == null ? null : (TextPaint) gCD.get();
            if (pString.value.replace("%%", "").contains("%s") || textPaint == null) {
                pInt.value = 0;
                return;
            }
            CharSequence format;
            try {
                format = String.format(pString.value, new Object[]{pString2.value});
            } catch (Exception e) {
                format = pString.value;
            }
            pString.value = TextUtils.ellipsize(format, textPaint, (float) (gCE > 0 ? gCE : BackwardSupportUtil.b.b(ad.getContext(), 200.0f)), TruncateAt.END).toString();
            pInt.value = 1;
        }
    }

    public static void fv(int i) {
        gCE = i;
    }

    public static void fw(int i) {
        gCF = i;
    }

    public static void a(TextPaint textPaint) {
        if (gCD == null || gCD.get() == null) {
            gCD = new WeakReference(textPaint);
        }
    }

    public static String c(Context context, String str, boolean z) {
        return z ? b.chK().WP(str) : context.getString(R.l.epO);
    }

    public static String a(Context context, String str, int i, int i2, int i3, boolean z) {
        if (z) {
            String WP = b.chK().WP(str);
            if (i3 <= 1) {
                return WP;
            }
            return context.getResources().getQuantityString(R.j.duQ, i3, new Object[]{Integer.valueOf(i3)}) + WP;
        }
        return context.getResources().getQuantityString(R.j.duR, i, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public static String d(Context context, String str, boolean z) {
        if (z) {
            return b.chK().WP(str);
        }
        return context.getString(R.l.ezs);
    }
}
