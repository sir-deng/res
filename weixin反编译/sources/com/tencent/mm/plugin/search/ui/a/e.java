package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.d.a.c;
import com.tencent.mm.sdk.platformtools.bi;

public class e extends c {
    public String mRD;
    protected CharSequence qjQ;
    protected String qjR;
    protected CharSequence qjS;
    protected String qjT;
    public j qjU;
    private a qjV = new a();
    b qjW = new b();
    public int showType;

    public class a extends com.tencent.mm.plugin.fts.d.a.b.b {
        public a() {
            super();
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(R.i.diW, viewGroup, false);
            b bVar = e.this.qjW;
            bVar.qjY = (TextView) inflate.findViewById(R.h.con);
            bVar.qjZ = (ImageView) inflate.findViewById(R.h.bLG);
            bVar.qka = (TextView) inflate.findViewById(R.h.coo);
            bVar.qkb = (ImageView) inflate.findViewById(R.h.bLH);
            bVar.mVB = (TextView) inflate.findViewById(R.h.cpQ);
            bVar.contentView = inflate.findViewById(R.h.cJR);
            bVar.mVw = inflate.findViewById(R.h.cCr);
            inflate.setTag(bVar);
            return inflate;
        }

        public void a(Context context, com.tencent.mm.plugin.fts.d.a.b.a aVar, com.tencent.mm.plugin.fts.d.a.b bVar, Object... objArr) {
            b bVar2 = (b) aVar;
            com.tencent.mm.plugin.fts.d.e.a(e.this.qjQ, bVar2.qjY);
            com.tencent.mm.pluginsdk.ui.a.b.a(bVar2.qjZ, e.this.qjR);
            com.tencent.mm.plugin.fts.d.e.a(e.this.qjS, bVar2.qka);
            if (bi.oN(e.this.qjT)) {
                bVar2.qkb.setVisibility(8);
            } else {
                bVar2.qkb.setVisibility(0);
                com.tencent.mm.pluginsdk.ui.a.b.a(bVar2.qkb, e.this.qjT);
            }
            cn(bVar2.contentView);
            if (e.this.position == 0) {
                bVar2.mVw.setVisibility(8);
            } else {
                bVar2.mVw.setVisibility(0);
            }
            bVar2.mVB.setVisibility(0);
        }

        public final boolean a(Context context, com.tencent.mm.plugin.fts.d.a.b bVar) {
            return false;
        }
    }

    public class b extends com.tencent.mm.plugin.fts.d.a.b.a {
        public View contentView;
        public TextView mVB;
        public View mVw;
        public TextView qjY;
        public ImageView qjZ;
        public TextView qka;
        public ImageView qkb;

        public b() {
            super();
        }
    }

    public e(int i) {
        super(i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r13, com.tencent.mm.plugin.fts.d.a.b.a r14, java.lang.Object... r15) {
        /*
        r12 = this;
        r0 = r12.qjU;
        r4 = r0.mRd;
        r0 = 0;
        r1 = 0;
        r3 = 0;
        r2 = 0;
        r5 = r12.qjU;
        r5 = r5.mRc;
        switch(r5) {
            case 1: goto L_0x0164;
            case 2: goto L_0x0095;
            case 3: goto L_0x0094;
            case 4: goto L_0x000f;
            case 5: goto L_0x00a5;
            case 6: goto L_0x00a4;
            case 7: goto L_0x00a3;
            default: goto L_0x000f;
        };
    L_0x000f:
        r5 = r2;
        r2 = r1;
        r11 = r3;
        r3 = r0;
        r0 = r11;
    L_0x0014:
        r1 = r12.showType;
        r6 = 2;
        if (r1 != r6) goto L_0x00d3;
    L_0x0019:
        r12.qjR = r4;
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r5);
        if (r1 != 0) goto L_0x00bd;
    L_0x0021:
        r1 = r12.qjU;
        r1 = r1.mRM;
        r4 = com.tencent.mm.plugin.fts.d.d.b.mUr;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r5 = r6.append(r5);
        r6 = "(";
        r5 = r5.append(r6);
        r5 = r5.toString();
        r6 = ")";
        r0 = com.tencent.mm.plugin.fts.d.b.a.a(r0, r1, r2, r3, r4, r5, r6);
        r0 = com.tencent.mm.plugin.fts.d.f.a(r0);
        r0 = r0.mVW;
        r12.qjQ = r0;
    L_0x004a:
        r0 = 3;
        r0 = new java.lang.CharSequence[r0];
        r1 = 0;
        r2 = "\"";
        r0[r1] = r2;
        r1 = 1;
        r2 = r12.qjQ;
        r0[r1] = r2;
        r1 = 2;
        r2 = "\"";
        r0[r1] = r2;
        r0 = android.text.TextUtils.concat(r0);
        r12.qjQ = r0;
        r0 = 3;
        r0 = new java.lang.CharSequence[r0];
        r1 = 0;
        r2 = "\"";
        r0[r1] = r2;
        r1 = 1;
        r2 = r12.mRD;
        r2 = com.tencent.mm.y.r.gw(r2);
        r3 = com.tencent.mm.plugin.fts.d.d.b.mUt;
        r4 = 1133903872; // 0x43960000 float:300.0 double:5.60222949E-315;
        r5 = android.text.TextUtils.TruncateAt.END;
        r2 = android.text.TextUtils.ellipsize(r2, r3, r4, r5);
        r0[r1] = r2;
        r1 = 2;
        r2 = com.tencent.mm.R.l.eJp;
        r2 = r13.getString(r2);
        r0[r1] = r2;
        r0 = android.text.TextUtils.concat(r0);
        r12.qjS = r0;
        r0 = r12.mRD;
        r12.qjT = r0;
    L_0x0093:
        return;
    L_0x0094:
        r0 = 1;
    L_0x0095:
        r1 = 1;
        r11 = r1;
        r1 = r0;
        r0 = r11;
    L_0x0099:
        r3 = com.tencent.mm.y.r.gw(r4);
        r5 = r2;
        r2 = r0;
        r0 = r3;
        r3 = r1;
        goto L_0x0014;
    L_0x00a3:
        r0 = 1;
    L_0x00a4:
        r1 = 1;
    L_0x00a5:
        com.tencent.mm.y.as.Hm();
        r2 = com.tencent.mm.y.c.Ff();
        r2 = r2.Xv(r4);
        r3 = r2.field_nickname;
        r2 = com.tencent.mm.y.r.gw(r4);
        r5 = r2;
        r2 = r1;
        r11 = r3;
        r3 = r0;
        r0 = r11;
        goto L_0x0014;
    L_0x00bd:
        r1 = r12.qjU;
        r1 = r1.mRM;
        r4 = 1137180672; // 0x43c80000 float:400.0 double:5.61841903E-315;
        r5 = com.tencent.mm.plugin.fts.d.d.b.mUr;
        r0 = com.tencent.mm.plugin.fts.d.b.a.a(r0, r1, r2, r3, r4, r5);
        r0 = com.tencent.mm.plugin.fts.d.f.a(r0);
        r0 = r0.mVW;
        r12.qjQ = r0;
        goto L_0x004a;
    L_0x00d3:
        r1 = 3;
        r1 = new java.lang.CharSequence[r1];
        r6 = 0;
        r7 = "\"";
        r1[r6] = r7;
        r6 = 1;
        r7 = r12.mRD;
        r7 = com.tencent.mm.y.r.gw(r7);
        r8 = com.tencent.mm.plugin.fts.d.d.b.mUt;
        r9 = 1133903872; // 0x43960000 float:300.0 double:5.60222949E-315;
        r10 = android.text.TextUtils.TruncateAt.END;
        r7 = android.text.TextUtils.ellipsize(r7, r8, r9, r10);
        r1[r6] = r7;
        r6 = 2;
        r7 = "\"";
        r1[r6] = r7;
        r1 = android.text.TextUtils.concat(r1);
        r12.qjQ = r1;
        r1 = r12.mRD;
        r12.qjR = r1;
        r12.qjT = r4;
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r5);
        if (r1 != 0) goto L_0x014f;
    L_0x0107:
        r1 = r12.qjU;
        r1 = r1.mRM;
        r4 = com.tencent.mm.plugin.fts.d.d.b.mUr;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r5 = r6.append(r5);
        r6 = "(";
        r5 = r5.append(r6);
        r5 = r5.toString();
        r6 = ")";
        r0 = com.tencent.mm.plugin.fts.d.b.a.a(r0, r1, r2, r3, r4, r5, r6);
        r0 = com.tencent.mm.plugin.fts.d.f.a(r0);
        r0 = r0.mVW;
        r12.qjS = r0;
    L_0x0130:
        r0 = 3;
        r0 = new java.lang.CharSequence[r0];
        r1 = 0;
        r2 = "\"";
        r0[r1] = r2;
        r1 = 1;
        r2 = r12.qjS;
        r0[r1] = r2;
        r1 = 2;
        r2 = com.tencent.mm.R.l.eJp;
        r2 = r13.getString(r2);
        r0[r1] = r2;
        r0 = android.text.TextUtils.concat(r0);
        r12.qjS = r0;
        goto L_0x0093;
    L_0x014f:
        r1 = r12.qjU;
        r1 = r1.mRM;
        r4 = 1137180672; // 0x43c80000 float:400.0 double:5.61841903E-315;
        r5 = com.tencent.mm.plugin.fts.d.d.b.mUr;
        r0 = com.tencent.mm.plugin.fts.d.b.a.a(r0, r1, r2, r3, r4, r5);
        r0 = com.tencent.mm.plugin.fts.d.f.a(r0);
        r0 = r0.mVW;
        r12.qjS = r0;
        goto L_0x0130;
    L_0x0164:
        r11 = r1;
        r1 = r0;
        r0 = r11;
        goto L_0x0099;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.search.ui.a.e.a(android.content.Context, com.tencent.mm.plugin.fts.d.a.b$a, java.lang.Object[]):void");
    }

    public com.tencent.mm.plugin.fts.d.a.b.b adG() {
        return this.qjV;
    }

    protected final com.tencent.mm.plugin.fts.d.a.b.a adH() {
        return this.qjW;
    }
}
