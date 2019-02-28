package com.tencent.mm.plugin.fts.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.plugin.fts.d.j.a;
import com.tencent.mm.plugin.fts.d.j.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;

public final class e {
    public static boolean a(CharSequence charSequence, TextView textView) {
        if (charSequence == null || charSequence.length() == 0) {
            textView.setVisibility(8);
            return false;
        }
        textView.setText(charSequence, BufferType.SPANNABLE);
        textView.setVisibility(0);
        return true;
    }

    public static boolean a(String str, TextView textView) {
        if (str == null || str.length() == 0) {
            textView.setVisibility(8);
            return false;
        }
        textView.setText(str);
        textView.setVisibility(0);
        return true;
    }

    public static void a(Context context, ImageView imageView, String str, String str2, int i) {
        a(context, imageView, str, str2, i, true, 0, 0);
    }

    public static void a(Context context, ImageView imageView, String str, String str2, int i, int i2, int i3) {
        a(context, imageView, str, str2, i, false, i2, i3);
    }

    private static void a(Context context, ImageView imageView, String str, String str2, int i, boolean z, int i2, int i3) {
        h.aOe().a(imageView, str, str2, z, i2, i3);
        if (!bi.oN(str) || !bi.oN(str2)) {
            Bitmap a = h.aOe().a(str, str2, z, i2, i3);
            if (a == null || a.isRecycled()) {
                if (i > 0) {
                    imageView.setImageResource(i);
                } else {
                    imageView.setImageResource(a.transparent);
                }
                h.aOe().a(context, imageView, str, str2, z, i2, i3);
            } else {
                g.a.a(context.getResources(), a, imageView);
            }
            imageView.setVisibility(0);
        } else if (i <= 0 || (bi.oN(str) && bi.oN(str2))) {
            imageView.setVisibility(8);
        } else {
            imageView.setImageResource(i);
        }
    }

    public static String qy(int i) {
        int i2 = 0;
        switch (i) {
            case -15:
                i2 = g.mUU;
                break;
            case -13:
                i2 = g.mUX;
                break;
            case -11:
                i2 = g.mUV;
                break;
            case -8:
                i2 = g.mUW;
                break;
            case -7:
                i2 = g.mUS;
                break;
            case -6:
                i2 = g.mUR;
                break;
            case -5:
                i2 = g.mUT;
                break;
            case -4:
                i2 = g.ekG;
                break;
            case -3:
                i2 = g.mul;
                break;
            case -2:
                i2 = g.ekJ;
                break;
            case -1:
                i2 = g.mUQ;
                break;
        }
        if (i2 == 0) {
            return null;
        }
        return ad.getContext().getString(i2);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.CharSequence a(android.content.Context r9, java.util.List<com.tencent.mm.plugin.fts.a.a.d> r10, java.lang.String[] r11, com.tencent.mm.plugin.fts.a.a.e r12, android.text.TextPaint r13) {
        /*
        r3 = 0;
        r8 = 1;
        r0 = com.tencent.mm.plugin.fts.a.m.class;
        r0 = com.tencent.mm.kernel.g.k(r0);
        r0 = (com.tencent.mm.plugin.fts.a.m) r0;
        r1 = new com.tencent.mm.plugin.fts.d.e$1;
        r1.<init>(r0);
        java.util.Arrays.sort(r11, r1);
        r4 = new android.text.SpannableStringBuilder;
        r4.<init>();
        r2 = r3;
    L_0x0018:
        r0 = r10.size();
        if (r2 >= r0) goto L_0x00a1;
    L_0x001e:
        r0 = r10.get(r2);
        r0 = (com.tencent.mm.plugin.fts.a.a.d) r0;
        r1 = r0.mRe;
        r5 = r11.length;
        if (r1 >= r5) goto L_0x0068;
    L_0x0029:
        r1 = r0.mRe;
        r5 = r11[r1];
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r5);
        if (r1 != 0) goto L_0x0068;
    L_0x0033:
        r1 = com.tencent.mm.plugin.messenger.foundation.a.h.class;
        r1 = com.tencent.mm.kernel.g.h(r1);
        r1 = (com.tencent.mm.plugin.messenger.foundation.a.h) r1;
        r1 = r1.Ff();
        r1 = r1.Xv(r5);
        if (r1 == 0) goto L_0x0068;
    L_0x0045:
        r5 = r1.field_username;
        r6 = com.tencent.mm.y.s.a(r1, r5);
        r7 = r0.mRc;
        switch(r7) {
            case 29: goto L_0x0090;
            case 30: goto L_0x008e;
            case 31: goto L_0x008c;
            case 32: goto L_0x009a;
            case 33: goto L_0x0093;
            case 34: goto L_0x007d;
            case 35: goto L_0x007b;
            case 36: goto L_0x0079;
            case 37: goto L_0x006c;
            default: goto L_0x0050;
        };
    L_0x0050:
        r1 = r0.mRg;
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
        if (r1 != 0) goto L_0x0068;
    L_0x0058:
        r1 = r0.mRg;
        r5 = r12.mRl;
        r1 = r1.contains(r5);
        if (r1 == 0) goto L_0x0068;
    L_0x0062:
        r1 = r0.mRi;
        r1 = r1 + 10;
        r0.mRi = r1;
    L_0x0068:
        r0 = r2 + 1;
        r2 = r0;
        goto L_0x0018;
    L_0x006c:
        r1 = r1.vU();
        r1 = com.tencent.mm.plugin.fts.a.d.cL(r5, r1);
        r0.mRg = r1;
        r0.mRh = r6;
        goto L_0x0050;
    L_0x0079:
        r0.mRk = r8;
    L_0x007b:
        r0.mRj = r8;
    L_0x007d:
        r5 = r1.field_nickname;
        r0.mRg = r5;
        r1 = r1.field_nickname;
        r1 = r1.equals(r6);
        if (r1 != 0) goto L_0x0050;
    L_0x0089:
        r0.mRh = r6;
        goto L_0x0050;
    L_0x008c:
        r0.mRk = r8;
    L_0x008e:
        r0.mRj = r8;
    L_0x0090:
        r0.mRg = r6;
        goto L_0x0050;
    L_0x0093:
        r1 = r0.content;
        r0.mRg = r1;
        r0.mRh = r6;
        goto L_0x0050;
    L_0x009a:
        r1 = r1.fXt;
        r0.mRg = r1;
        r0.mRh = r6;
        goto L_0x0050;
    L_0x00a1:
        r0 = new com.tencent.mm.plugin.fts.d.e$2;
        r0.<init>();
        java.util.Collections.sort(r10, r0);
        r0 = 0;
        r1 = r3;
    L_0x00ab:
        r2 = r10.size();
        if (r1 >= r2) goto L_0x0131;
    L_0x00b1:
        r2 = r12.mRn;
        r2 = r2.length;
        if (r1 >= r2) goto L_0x0131;
    L_0x00b6:
        r2 = com.tencent.mm.plugin.fts.d.f.a.mUz;
        r2 = r2 + -100;
        r2 = (float) r2;
        r2 = r2 - r0;
        r0 = 1120403456; // 0x42c80000 float:100.0 double:5.53552857E-315;
        r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x0131;
    L_0x00c2:
        r0 = r10.get(r1);
        r0 = (com.tencent.mm.plugin.fts.a.a.d) r0;
        r5 = r0.mRg;
        r6 = r13.getTextSize();
        r5 = com.tencent.mm.pluginsdk.ui.d.i.b(r9, r5, r6);
        r6 = r4.length();
        if (r6 <= 0) goto L_0x00de;
    L_0x00d8:
        r6 = ", ";
        r4.append(r6);
    L_0x00de:
        r6 = new com.tencent.mm.plugin.fts.d.b.a;
        r6.<init>();
        r6.mVI = r5;
        r6.mRM = r12;
        r5 = r0.mRj;
        r6.mRj = r5;
        r5 = r0.mRk;
        r6.mVJ = r5;
        r6.mVM = r2;
        r6.gVy = r13;
        r2 = r0.mRh;
        r2 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
        if (r2 != 0) goto L_0x011a;
    L_0x00fb:
        r0 = r0.mRh;
        r2 = r13.getTextSize();
        r0 = com.tencent.mm.pluginsdk.ui.d.i.b(r9, r0, r2);
        r2 = 2;
        r2 = new java.lang.CharSequence[r2];
        r2[r3] = r0;
        r0 = "(";
        r2[r8] = r0;
        r0 = android.text.TextUtils.concat(r2);
        r6.mVN = r0;
        r0 = ")";
        r6.mVO = r0;
    L_0x011a:
        r0 = com.tencent.mm.plugin.fts.d.f.a(r6);
        r0 = r0.mVW;
        r4.append(r0);
        r0 = r4.toString();
        r2 = r13.measureText(r0);
        r0 = r1 + 1;
        r1 = r0;
        r0 = r2;
        goto L_0x00ab;
    L_0x0131:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.fts.d.e.a(android.content.Context, java.util.List, java.lang.String[], com.tencent.mm.plugin.fts.a.a.e, android.text.TextPaint):java.lang.CharSequence");
    }
}
