package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends LinearLayout implements OnClickListener {
    private LayoutInflater DF = ((LayoutInflater) this.mContext.getSystemService("layout_inflater"));
    private String mAppId;
    private Context mContext;
    private int niV;

    private static class a {
        public String jumpUrl;
        public String ngQ;
        public int njZ;

        public a(int i, String str, String str2) {
            this.njZ = i;
            this.jumpUrl = str;
            this.ngQ = str2;
        }
    }

    public f(Context context) {
        super(context);
        this.mContext = context;
        setOrientation(1);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.plugin.game.c.ai r12, java.lang.String r13, int r14, int r15) {
        /*
        r11 = this;
        if (r12 == 0) goto L_0x000a;
    L_0x0002:
        r0 = r12.nmz;
        r0 = com.tencent.mm.sdk.platformtools.bi.cC(r0);
        if (r0 == 0) goto L_0x0010;
    L_0x000a:
        r0 = 8;
        r11.setVisibility(r0);
    L_0x000f:
        return;
    L_0x0010:
        r11.mAppId = r13;
        r11.niV = r15;
        r0 = r12.nmz;
        r7 = r0.iterator();
    L_0x001a:
        r0 = r7.hasNext();
        if (r0 == 0) goto L_0x000f;
    L_0x0020:
        r0 = r7.next();
        r4 = r0;
        r4 = (com.tencent.mm.plugin.game.c.k) r4;
        if (r4 == 0) goto L_0x001a;
    L_0x0029:
        r5 = new com.tencent.mm.plugin.game.d.e$a$a;
        r5.<init>();
        r0 = r4.nlz;
        switch(r0) {
            case 1: goto L_0x004a;
            case 2: goto L_0x00e3;
            default: goto L_0x0033;
        };
    L_0x0033:
        r0 = 2;
        if (r14 != r0) goto L_0x001a;
    L_0x0036:
        r0 = r11.mContext;
        r1 = 10;
        r2 = 1002; // 0x3ea float:1.404E-42 double:4.95E-321;
        r3 = r4.nlw;
        r4 = r4.nlr;
        r6 = com.tencent.mm.plugin.game.model.ap.CD(r4);
        r4 = r13;
        r5 = r15;
        com.tencent.mm.plugin.game.model.ap.a(r0, r1, r2, r3, r4, r5, r6);
        goto L_0x001a;
    L_0x004a:
        r0 = r4.nlx;
        if (r0 == 0) goto L_0x001a;
    L_0x004e:
        r11.e(r11);
        r0 = r11.DF;
        r1 = com.tencent.mm.R.i.djD;
        r2 = 1;
        r6 = r0.inflate(r1, r11, r2);
        r0 = com.tencent.mm.R.h.cxP;
        r0 = r6.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r1 = com.tencent.mm.R.h.cxR;
        r1 = r6.findViewById(r1);
        r1 = (android.widget.TextView) r1;
        r2 = com.tencent.mm.R.h.cxO;
        r2 = r6.findViewById(r2);
        r2 = (com.tencent.mm.plugin.game.widget.EllipsizingTextView) r2;
        r3 = 2;
        r2.setMaxLines(r3);
        r3 = com.tencent.mm.R.h.cxQ;
        r3 = r6.findViewById(r3);
        r3 = (android.widget.ImageView) r3;
        r8 = r11.mContext;
        r9 = r4.nlv;
        r10 = r0.getTextSize();
        r8 = com.tencent.mm.pluginsdk.ui.d.i.b(r8, r9, r10);
        r0.setText(r8);
        r0 = r11.mContext;
        r8 = r4.nlx;
        r8 = r8.fpg;
        r9 = r1.getTextSize();
        r0 = com.tencent.mm.pluginsdk.ui.d.i.b(r0, r8, r9);
        r1.setText(r0);
        r0 = r11.mContext;
        r1 = r4.nlx;
        r1 = r1.nkL;
        r8 = r2.getTextSize();
        r0 = com.tencent.mm.pluginsdk.ui.d.i.b(r0, r1, r8);
        r2.setText(r0);
        r0 = r4.nlx;
        r0 = r0.nkM;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r0 != 0) goto L_0x00dd;
    L_0x00b9:
        r0 = com.tencent.mm.plugin.game.d.e.aSC();
        r1 = r4.nlx;
        r1 = r1.nkM;
        r2 = r5.aSD();
        r0.a(r3, r1, r2);
    L_0x00c8:
        r0 = new com.tencent.mm.plugin.game.ui.f$a;
        r1 = r4.nlw;
        r2 = r4.nlx;
        r2 = r2.nkN;
        r3 = r4.nlr;
        r0.<init>(r1, r2, r3);
        r6.setTag(r0);
        r6.setOnClickListener(r11);
        goto L_0x0033;
    L_0x00dd:
        r0 = 8;
        r3.setVisibility(r0);
        goto L_0x00c8;
    L_0x00e3:
        r0 = r4.nly;
        if (r0 == 0) goto L_0x001a;
    L_0x00e7:
        r11.e(r11);
        r0 = r11.DF;
        r1 = com.tencent.mm.R.i.djE;
        r2 = 1;
        r3 = r0.inflate(r1, r11, r2);
        r0 = com.tencent.mm.R.h.cOG;
        r0 = r3.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r1 = com.tencent.mm.R.h.cOI;
        r1 = r3.findViewById(r1);
        r1 = (android.widget.TextView) r1;
        r2 = com.tencent.mm.R.h.cOH;
        r2 = r3.findViewById(r2);
        r2 = (android.widget.ImageView) r2;
        r6 = r11.mContext;
        r8 = r4.nlv;
        r9 = r0.getTextSize();
        r6 = com.tencent.mm.pluginsdk.ui.d.i.b(r6, r8, r9);
        r0.setText(r6);
        r0 = r11.mContext;
        r6 = r4.nly;
        r6 = r6.fpg;
        r8 = r1.getTextSize();
        r0 = com.tencent.mm.pluginsdk.ui.d.i.b(r0, r6, r8);
        r1.setText(r0);
        r0 = r4.nly;
        r0 = r0.nkM;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r0 != 0) goto L_0x016f;
    L_0x0135:
        r0 = r4.nly;
        r0 = r0.npS;
        r1 = 1;
        if (r0 != r1) goto L_0x0167;
    L_0x013c:
        r0 = 1;
        r5.nDa = r0;
        r0 = com.tencent.mm.R.g.bCF;
        r5.nDd = r0;
    L_0x0143:
        r0 = com.tencent.mm.plugin.game.d.e.aSC();
        r1 = r4.nly;
        r1 = r1.nkM;
        r5 = r5.aSD();
        r0.a(r2, r1, r5);
    L_0x0152:
        r0 = new com.tencent.mm.plugin.game.ui.f$a;
        r1 = r4.nlw;
        r2 = r4.nly;
        r2 = r2.nkN;
        r5 = r4.nlr;
        r0.<init>(r1, r2, r5);
        r3.setTag(r0);
        r3.setOnClickListener(r11);
        goto L_0x0033;
    L_0x0167:
        r0 = 1;
        r5.hFJ = r0;
        r0 = com.tencent.mm.R.g.bCE;
        r5.nDd = r0;
        goto L_0x0143;
    L_0x016f:
        r0 = 8;
        r2.setVisibility(r0);
        goto L_0x0152;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.ui.f.a(com.tencent.mm.plugin.game.c.ai, java.lang.String, int, int):void");
    }

    public final void onClick(View view) {
        if (view.getTag() == null || !(view.getTag() instanceof a)) {
            x.w("MicroMsg.GameBlockContentView", "getTag is null");
            return;
        }
        a aVar = (a) view.getTag();
        if (bi.oN(aVar.jumpUrl)) {
            x.w("MicroMsg.GameBlockContentView", "jumpUrl is null");
            return;
        }
        ap.a(this.mContext, 10, 1002, aVar.njZ, c.p(this.mContext, aVar.jumpUrl, "game_center_mygame_comm"), this.mAppId, this.niV, ap.CD(aVar.ngQ));
    }

    private void e(ViewGroup viewGroup) {
        ImageView imageView = (ImageView) this.DF.inflate(R.i.dkl, viewGroup, false);
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) imageView.getLayoutParams();
        marginLayoutParams.leftMargin = com.tencent.mm.bu.a.fromDPToPix(this.mContext, 20);
        imageView.setLayoutParams(marginLayoutParams);
        viewGroup.addView(imageView);
    }
}
