package com.tencent.mm.plugin.fav.ui.a;

import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.f.a.fw;
import com.tencent.mm.plugin.fav.ui.a.c;
import com.tencent.mm.plugin.fav.ui.a.e;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.protocal.c.vp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMImageView;
import java.util.List;
import java.util.regex.Pattern;

public final class a extends com.tencent.mm.plugin.fts.d.a.b {
    private static final ag handler = new ag(Looper.getMainLooper());
    private static final String muy = ad.getContext().getString(e.ekS);
    private static final Pattern muz = Pattern.compile("['\r\n' | '\n']+");
    public j iZi;
    public String jmb;
    public CharSequence muA;
    public CharSequence muB;
    public CharSequence muC;
    public String muD;
    public int muE;
    private b muF = new b();
    a muG = new a();

    public class a extends com.tencent.mm.plugin.fts.d.a.b.a {
        public View contentView;
        public TextView ikL;
        public MMImageView muH;
        public TextView muI;
        public TextView muJ;

        public a() {
            super();
        }
    }

    public class b extends com.tencent.mm.plugin.fts.d.a.b.b {
        public b() {
            super();
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(c.muk, viewGroup, false);
            a aVar = a.this.muG;
            aVar.muH = (MMImageView) inflate.findViewById(com.tencent.mm.plugin.fav.ui.a.b.bLM);
            aVar.ikL = (TextView) inflate.findViewById(com.tencent.mm.plugin.fav.ui.a.b.cSB);
            aVar.muI = (TextView) inflate.findViewById(com.tencent.mm.plugin.fav.ui.a.b.muj);
            aVar.muJ = (TextView) inflate.findViewById(com.tencent.mm.plugin.fav.ui.a.b.cPB);
            aVar.contentView = inflate.findViewById(com.tencent.mm.plugin.fav.ui.a.b.cJR);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.plugin.fts.d.a.b.a aVar, com.tencent.mm.plugin.fts.d.a.b bVar, Object... objArr) {
            a aVar2 = (a) aVar;
            a aVar3 = (a) bVar;
            cm(aVar2.contentView);
            com.tencent.mm.plugin.fts.d.e.a(context, aVar2.muH, aVar3.jmb, aVar3.muD, aVar3.muE, aVar2.muH.getMeasuredWidth(), aVar2.muH.getMeasuredHeight());
            a.a(aVar2.ikL, aVar2.muI, a.this.muA, a.this.muB);
            com.tencent.mm.plugin.fts.d.e.a(a.this.muC, aVar2.muJ);
        }

        public final boolean a(Context context, com.tencent.mm.plugin.fts.d.a.b bVar) {
            a aVar = (a) bVar;
            com.tencent.mm.sdk.b.b fwVar = new fw();
            fwVar.fwl.type = 10;
            fwVar.fwl.frf = aVar.iZi.mRQ;
            fwVar.fwl.context = context;
            fwVar.fwl.fww = new vp();
            if (a.this.pageType == 1) {
                fwVar.fwl.fww.scene = 3;
            } else {
                fwVar.fwl.fww.scene = 4;
            }
            fwVar.fwl.fww.mtU = 3;
            fwVar.fwl.fww.index = a.this.mVl;
            com.tencent.mm.sdk.b.a.xmy.m(fwVar);
            return true;
        }
    }

    public static void a(TextView textView, TextView textView2, CharSequence charSequence, CharSequence charSequence2) {
        if (com.tencent.mm.plugin.fts.d.e.a(charSequence, textView)) {
            if (com.tencent.mm.plugin.fts.d.e.a(charSequence2, textView2)) {
                textView.setMaxLines(1);
                textView2.setMaxLines(1);
                return;
            }
            textView.setMaxLines(2);
        } else if (com.tencent.mm.plugin.fts.d.e.a(charSequence2, textView2)) {
            textView2.setMaxLines(2);
        }
    }

    public a(int i) {
        super(7, i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r10, com.tencent.mm.plugin.fts.d.a.b.a r11, java.lang.Object... r12) {
        /*
        r9 = this;
        r0 = r9.iZi;
        r0 = r0.mRQ;
        r2 = new com.tencent.mm.f.a.fw;
        r2.<init>();
        r3 = r2.fwl;
        r4 = 9;
        r3.type = r4;
        r3 = r2.fwl;
        r3.frf = r0;
        r0 = com.tencent.mm.sdk.b.a.xmy;
        r0.m(r2);
        r0 = r2.fwm;
        r5 = r0.fwy;
        r0 = r9.iZi;
        r0 = r0.mRQ;
        r2 = new com.tencent.mm.f.a.fw;
        r2.<init>();
        r3 = r2.fwl;
        r4 = 11;
        r3.type = r4;
        r3 = r2.fwl;
        r3.frf = r0;
        r0 = r2.fwl;
        r1 = handler;
        r0.handler = r1;
        r0 = com.tencent.mm.sdk.b.a.xmy;
        r0.m(r2);
        r0 = r2.fwm;
        r0 = r0.fwx;
        r1 = "";
        r0 = com.tencent.mm.sdk.platformtools.bi.aD(r0, r1);
        r9.muD = r0;
        r0 = r2.fwm;
        r0 = r0.thumbUrl;
        r1 = "";
        r0 = com.tencent.mm.sdk.platformtools.bi.aD(r0, r1);
        r9.jmb = r0;
        r1 = r9.iZi;
        r0 = com.tencent.mm.plugin.fts.d.f.a.mUz;
        r0 = r0 * 2;
        r2 = (float) r0;
        r3 = r5.fFC;
        r0 = "";
        r4 = r5.type;
        switch(r4) {
            case 1: goto L_0x00d2;
            case 2: goto L_0x00e2;
            case 3: goto L_0x0118;
            case 4: goto L_0x010c;
            case 5: goto L_0x0065;
            case 6: goto L_0x00ee;
            case 7: goto L_0x017c;
            case 8: goto L_0x0065;
            case 9: goto L_0x0065;
            case 10: goto L_0x0124;
            case 11: goto L_0x0124;
            case 12: goto L_0x0065;
            case 13: goto L_0x0065;
            case 14: goto L_0x012e;
            case 15: goto L_0x0065;
            case 16: goto L_0x01a2;
            default: goto L_0x0065;
        };
    L_0x0065:
        r0 = r5.title;
    L_0x0067:
        r1 = r1.mRc;
        switch(r1) {
            case 1: goto L_0x01ae;
            case 2: goto L_0x01ae;
            case 3: goto L_0x01ae;
            case 4: goto L_0x01ae;
            case 5: goto L_0x01ae;
            case 6: goto L_0x01ae;
            default: goto L_0x006c;
        };
    L_0x006c:
        r9.muA = r0;
        r2 = r9.iZi;
        r3 = r5.fFC;
        r0 = "";
        r1 = -1;
        r4 = r5.type;
        switch(r4) {
            case 2: goto L_0x01d0;
            case 3: goto L_0x007b;
            case 4: goto L_0x007b;
            case 5: goto L_0x01be;
            case 6: goto L_0x01d4;
            case 7: goto L_0x01be;
            case 8: goto L_0x007b;
            case 9: goto L_0x007b;
            case 10: goto L_0x01f2;
            case 11: goto L_0x01f2;
            case 12: goto L_0x01be;
            case 13: goto L_0x007b;
            case 14: goto L_0x01fc;
            case 15: goto L_0x01be;
            default: goto L_0x007b;
        };
    L_0x007b:
        r0 = "";
    L_0x007e:
        r2 = r2.mRc;
        switch(r2) {
            case 6: goto L_0x022e;
            case 7: goto L_0x0214;
            case 8: goto L_0x0214;
            case 23: goto L_0x0201;
            default: goto L_0x0083;
        };
    L_0x0083:
        r2 = "";
        r8 = r0;
        r0 = r2;
        r2 = r8;
    L_0x0089:
        r3 = -1;
        if (r1 == r3) goto L_0x00a7;
    L_0x008c:
        r2 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
        if (r2 != 0) goto L_0x00a7;
    L_0x0092:
        r2 = 2;
        r2 = new java.lang.CharSequence[r2];
        r3 = 0;
        r4 = r10.getResources();
        r1 = r4.getString(r1);
        r2[r3] = r1;
        r1 = 1;
        r2[r1] = r0;
        r0 = android.text.TextUtils.concat(r2);
    L_0x00a7:
        r9.muB = r0;
        r4 = r9.iZi;
        r0 = r5.fAJ;
        r1 = r5.wlI;
        r2 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r2 == 0) goto L_0x03e1;
    L_0x00b5:
        r0 = 0;
        r2 = r1;
        r1 = r0;
    L_0x00b8:
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
        if (r0 == 0) goto L_0x023f;
    L_0x00be:
        r0 = new android.text.SpannableString;
        r1 = "";
        r0.<init>(r1);
    L_0x00c6:
        r9.muC = r0;
        r0 = r5.type;
        switch(r0) {
            case 3: goto L_0x03c6;
            case 4: goto L_0x03ca;
            case 5: goto L_0x03c2;
            case 6: goto L_0x03ce;
            case 7: goto L_0x00cd;
            case 8: goto L_0x039f;
            default: goto L_0x00cd;
        };
    L_0x00cd:
        r0 = com.tencent.mm.plugin.fav.ui.a.d.dyQ;
    L_0x00cf:
        r9.muE = r0;
        return;
    L_0x00d2:
        r0 = muz;
        r3 = r5.desc;
        r0 = r0.matcher(r3);
        r3 = " ";
        r0 = r0.replaceAll(r3);
        goto L_0x0067;
    L_0x00e2:
        r0 = r10.getResources();
        r3 = com.tencent.mm.plugin.fav.ui.a.e.muo;
        r0 = r0.getString(r3);
        goto L_0x0067;
    L_0x00ee:
        r0 = r5.fFC;
        r0 = r0.wld;
        r3 = muy;
        r4 = r0.fEp;
        r3 = r3.equals(r4);
        if (r3 != 0) goto L_0x0104;
    L_0x00fc:
        r3 = r0.fEp;
        r3 = com.tencent.mm.sdk.platformtools.bi.oN(r3);
        if (r3 == 0) goto L_0x0108;
    L_0x0104:
        r0 = r0.label;
        goto L_0x0067;
    L_0x0108:
        r0 = r0.fEp;
        goto L_0x0067;
    L_0x010c:
        r0 = r10.getResources();
        r3 = com.tencent.mm.plugin.fav.ui.a.e.mus;
        r0 = r0.getString(r3);
        goto L_0x0067;
    L_0x0118:
        r0 = r10.getResources();
        r3 = com.tencent.mm.plugin.fav.ui.a.e.mut;
        r0 = r0.getString(r3);
        goto L_0x0067;
    L_0x0124:
        r4 = r3.wlh;
        if (r4 == 0) goto L_0x0067;
    L_0x0128:
        r0 = r3.wlh;
        r0 = r0.title;
        goto L_0x0067;
    L_0x012e:
        r4 = new java.lang.StringBuffer;
        r4.<init>();
        r0 = r3.wlY;
        r3 = r0.iterator();
    L_0x0139:
        r0 = r3.hasNext();
        if (r0 == 0) goto L_0x0159;
    L_0x013f:
        r0 = r3.next();
        r0 = (com.tencent.mm.protocal.c.uz) r0;
        r0 = com.tencent.mm.plugin.fav.a.b.a(r0);
        r6 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r6 != 0) goto L_0x0139;
    L_0x014f:
        r4.append(r0);
        r0 = " ";
        r4.append(r0);
        goto L_0x0139;
    L_0x0159:
        r0 = muz;
        r3 = r4.toString();
        r0 = r0.matcher(r3);
        r3 = " ";
        r0 = r0.replaceAll(r3);
        r3 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r3 == 0) goto L_0x0067;
    L_0x0170:
        r0 = r10.getResources();
        r3 = com.tencent.mm.plugin.fav.ui.a.e.muq;
        r0 = r0.getString(r3);
        goto L_0x0067;
    L_0x017c:
        r0 = r5.title;
        r3 = r5.desc;
        r3 = com.tencent.mm.sdk.platformtools.bi.oN(r3);
        if (r3 != 0) goto L_0x0067;
    L_0x0186:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r0 = r3.append(r0);
        r3 = "-";
        r0 = r0.append(r3);
        r3 = r5.desc;
        r0 = r0.append(r3);
        r0 = r0.toString();
        goto L_0x0067;
    L_0x01a2:
        r0 = r10.getResources();
        r3 = com.tencent.mm.plugin.fav.ui.a.e.mur;
        r0 = r0.getString(r3);
        goto L_0x0067;
    L_0x01ae:
        r1 = r9.mRM;
        r3 = com.tencent.mm.plugin.fts.d.d.b.mUv;
        r0 = com.tencent.mm.plugin.fts.d.b.a.a(r0, r1, r2, r3);
        r0 = com.tencent.mm.plugin.fts.d.f.a(r0);
        r0 = r0.mVW;
        goto L_0x006c;
    L_0x01be:
        r3 = r5.appId;
        r3 = com.tencent.mm.sdk.platformtools.bi.oN(r3);
        if (r3 != 0) goto L_0x007e;
    L_0x01c6:
        r0 = com.tencent.mm.y.ab.a.hht;
        r3 = r5.appId;
        r0 = r0.l(r10, r3);
        goto L_0x007e;
    L_0x01d0:
        r0 = r5.title;
        goto L_0x007e;
    L_0x01d4:
        r0 = r5.fFC;
        r0 = r0.wld;
        r3 = muy;
        r4 = r0.fEp;
        r3 = r3.equals(r4);
        if (r3 != 0) goto L_0x01ea;
    L_0x01e2:
        r3 = r0.fEp;
        r3 = com.tencent.mm.sdk.platformtools.bi.oN(r3);
        if (r3 == 0) goto L_0x01ee;
    L_0x01ea:
        r0 = r0.label;
        goto L_0x007e;
    L_0x01ee:
        r0 = r0.fEp;
        goto L_0x007e;
    L_0x01f2:
        r4 = r3.wlh;
        if (r4 == 0) goto L_0x007e;
    L_0x01f6:
        r0 = r3.wlh;
        r0 = r0.desc;
        goto L_0x007e;
    L_0x01fc:
        r0 = "";
        goto L_0x007e;
    L_0x0201:
        r1 = com.tencent.mm.plugin.fav.ui.a.e.mun;
        r2 = r9.mRM;
        r2 = com.tencent.mm.plugin.fts.d.b.a.a(r0, r2);
        r2 = com.tencent.mm.plugin.fts.d.f.a(r2);
        r2 = r2.mVW;
        r8 = r0;
        r0 = r2;
        r2 = r8;
        goto L_0x0089;
    L_0x0214:
        r0 = com.tencent.mm.plugin.fav.ui.a.e.mup;
        r1 = r5.wlJ;
        r1 = r9.aJ(r1);
        r2 = r9.mRM;
        r2 = com.tencent.mm.plugin.fts.d.b.a.a(r1, r2);
        r2 = com.tencent.mm.plugin.fts.d.f.a(r2);
        r2 = r2.mVW;
        r8 = r0;
        r0 = r2;
        r2 = r1;
        r1 = r8;
        goto L_0x0089;
    L_0x022e:
        r2 = r9.mRM;
        r2 = com.tencent.mm.plugin.fts.d.b.a.a(r0, r2);
        r2 = com.tencent.mm.plugin.fts.d.f.a(r2);
        r2 = r2.mVW;
        r8 = r0;
        r0 = r2;
        r2 = r8;
        goto L_0x0089;
    L_0x023f:
        r0 = com.tencent.mm.plugin.messenger.foundation.a.h.class;
        r0 = com.tencent.mm.kernel.g.h(r0);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.h) r0;
        r0 = r0.Ff();
        r6 = r0.Xv(r2);
        r6.setUsername(r2);
        r0 = 0;
        r2 = com.tencent.mm.y.s.eX(r2);
        if (r2 == 0) goto L_0x0272;
    L_0x0259:
        r2 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
        if (r2 != 0) goto L_0x0272;
    L_0x025f:
        r0 = com.tencent.mm.plugin.messenger.foundation.a.h.class;
        r0 = com.tencent.mm.kernel.g.h(r0);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.h) r0;
        r0 = r0.Ff();
        r0 = r0.Xv(r1);
        r0.setUsername(r1);
    L_0x0272:
        r3 = 0;
        r1 = 0;
        r2 = 0;
        r4 = r4.mRc;
        switch(r4) {
            case 9: goto L_0x03d5;
            case 10: goto L_0x037d;
            case 11: goto L_0x037c;
            case 12: goto L_0x03dc;
            case 13: goto L_0x02d5;
            case 14: goto L_0x02d4;
            case 15: goto L_0x027a;
            case 16: goto L_0x03d5;
            case 17: goto L_0x037d;
            case 18: goto L_0x037c;
            case 19: goto L_0x027a;
            case 20: goto L_0x03d9;
            case 21: goto L_0x030b;
            case 22: goto L_0x030a;
            default: goto L_0x027a;
        };
    L_0x027a:
        r8 = r2;
        r2 = r1;
        r1 = r8;
    L_0x027d:
        if (r0 == 0) goto L_0x0384;
    L_0x027f:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r7 = 1;
        r0 = a(r0, r7);
        r0 = r4.append(r0);
        r4 = "-";
        r0 = r0.append(r4);
        r4 = c(r10, r6);
        r0 = r0.append(r4);
        r0 = r0.toString();
        r8 = r1;
        r1 = r0;
        r0 = r8;
    L_0x02a3:
        r4 = com.tencent.mm.plugin.fav.ui.a.a.bvt;
        r4 = com.tencent.mm.bu.a.aa(r10, r4);
        r1 = com.tencent.mm.pluginsdk.ui.d.i.c(r10, r1, r4);
        if (r3 == 0) goto L_0x03d2;
    L_0x02af:
        r3 = r9.mRM;
        r0 = com.tencent.mm.plugin.fts.d.b.a.a(r1, r3, r0, r2);
        r0 = com.tencent.mm.plugin.fts.d.f.a(r0);
        r0 = r0.mVW;
    L_0x02bb:
        r1 = 2;
        r1 = new java.lang.CharSequence[r1];
        r2 = 0;
        r3 = r10.getResources();
        r4 = com.tencent.mm.plugin.fav.ui.a.e.mum;
        r3 = r3.getString(r4);
        r1[r2] = r3;
        r2 = 1;
        r1[r2] = r0;
        r0 = android.text.TextUtils.concat(r1);
        goto L_0x00c6;
    L_0x02d4:
        r1 = 1;
    L_0x02d5:
        r2 = 1;
        r8 = r2;
        r2 = r1;
        r1 = r8;
    L_0x02d9:
        r3 = 1;
        if (r0 == 0) goto L_0x0301;
    L_0x02dc:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r7 = 0;
        r0 = a(r0, r7);
        r0 = r4.append(r0);
        r4 = "-";
        r0 = r0.append(r4);
        r4 = c(r10, r6);
        r0 = r0.append(r4);
        r0 = r0.toString();
        r8 = r1;
        r1 = r0;
        r0 = r8;
        goto L_0x02a3;
    L_0x0301:
        r0 = 0;
        r0 = a(r6, r0);
        r8 = r1;
        r1 = r0;
        r0 = r8;
        goto L_0x02a3;
    L_0x030a:
        r1 = 1;
    L_0x030b:
        r2 = 1;
        r3 = r1;
    L_0x030d:
        r4 = 1;
        if (r0 == 0) goto L_0x0367;
    L_0x0310:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r7 = 1;
        r0 = a(r0, r7);
        r0 = r1.append(r0);
        r1 = "-";
        r0 = r0.append(r1);
        r1 = c(r10, r6);
        r0 = r0.append(r1);
        r0 = r0.toString();
        r1 = r0;
    L_0x0332:
        r0 = com.tencent.mm.plugin.messenger.foundation.a.h.class;
        r0 = com.tencent.mm.kernel.g.h(r0);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.h) r0;
        r0 = r0.Ff();
        r6 = r5.foe;
        r0 = r0.Xv(r6);
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r1 = r6.append(r1);
        r6 = "-";
        r1 = r1.append(r6);
        r6 = 1;
        r0 = a(r0, r6);
        r0 = r1.append(r0);
        r0 = r0.toString();
        r1 = r0;
        r0 = r2;
        r2 = r3;
        r3 = r4;
        goto L_0x02a3;
    L_0x0367:
        r0 = r6.field_username;
        r0 = com.tencent.mm.y.s.eX(r0);
        if (r0 == 0) goto L_0x0375;
    L_0x036f:
        r0 = c(r10, r6);
        r1 = r0;
        goto L_0x0332;
    L_0x0375:
        r0 = 1;
        r0 = a(r6, r0);
        r1 = r0;
        goto L_0x0332;
    L_0x037c:
        r1 = 1;
    L_0x037d:
        r2 = 1;
        r8 = r2;
        r2 = r1;
        r1 = r8;
    L_0x0381:
        r3 = 1;
        goto L_0x027d;
    L_0x0384:
        r0 = r6.field_username;
        r0 = com.tencent.mm.y.s.eX(r0);
        if (r0 == 0) goto L_0x0395;
    L_0x038c:
        r0 = c(r10, r6);
        r8 = r1;
        r1 = r0;
        r0 = r8;
        goto L_0x02a3;
    L_0x0395:
        r0 = 1;
        r0 = a(r6, r0);
        r8 = r1;
        r1 = r0;
        r0 = r8;
        goto L_0x02a3;
    L_0x039f:
        r0 = r5.fFC;
        r0 = r0.wlY;
        if (r0 == 0) goto L_0x00cd;
    L_0x03a5:
        r0 = r5.fFC;
        r0 = r0.wlY;
        r0 = r0.size();
        if (r0 <= 0) goto L_0x00cd;
    L_0x03af:
        r0 = r5.fFC;
        r0 = r0.wlY;
        r1 = 0;
        r0 = r0.get(r1);
        r0 = (com.tencent.mm.protocal.c.uz) r0;
        r0 = r0.wkc;
        r0 = com.tencent.mm.pluginsdk.c.RI(r0);
        goto L_0x00cf;
    L_0x03c2:
        r0 = com.tencent.mm.plugin.fav.ui.a.d.dvO;
        goto L_0x00cf;
    L_0x03c6:
        r0 = com.tencent.mm.plugin.fav.ui.a.d.dvN;
        goto L_0x00cf;
    L_0x03ca:
        r0 = com.tencent.mm.plugin.fav.ui.a.d.dvL;
        goto L_0x00cf;
    L_0x03ce:
        r0 = com.tencent.mm.plugin.fav.ui.a.d.dvx;
        goto L_0x00cf;
    L_0x03d2:
        r0 = r1;
        goto L_0x02bb;
    L_0x03d5:
        r8 = r2;
        r2 = r1;
        r1 = r8;
        goto L_0x0381;
    L_0x03d9:
        r3 = r1;
        goto L_0x030d;
    L_0x03dc:
        r8 = r2;
        r2 = r1;
        r1 = r8;
        goto L_0x02d9;
    L_0x03e1:
        r2 = r0;
        goto L_0x00b8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.fav.ui.a.a.a(android.content.Context, com.tencent.mm.plugin.fts.d.a.b$a, java.lang.Object[]):void");
    }

    public final com.tencent.mm.plugin.fts.d.a.b.b adG() {
        return this.muF;
    }

    protected final com.tencent.mm.plugin.fts.d.a.b.a adH() {
        return this.muG;
    }

    private static String a(x xVar, boolean z) {
        String str;
        if (!z || bi.oN(xVar.field_conRemark)) {
            str = xVar.field_nickname;
        } else {
            str = xVar.field_conRemark;
        }
        if (bi.oN(str)) {
            return xVar.field_username;
        }
        return str;
    }

    private static String c(Context context, x xVar) {
        String str = xVar.field_conRemark;
        if (bi.oN(str)) {
            str = xVar.field_nickname;
        }
        if (bi.oN(str)) {
            return context.getString(e.mul);
        }
        return str;
    }

    private String aJ(List<String> list) {
        StringBuffer stringBuffer = new StringBuffer();
        for (CharSequence charSequence : this.mRM.mRn) {
            for (String str : list) {
                if (d.BI(str).contains(charSequence)) {
                    stringBuffer.append(str);
                    stringBuffer.append(",");
                }
            }
        }
        stringBuffer.trimToSize();
        return stringBuffer.substring(0, stringBuffer.length() - 1);
    }

    public final int adJ() {
        return this.iZi.mRZ;
    }
}
