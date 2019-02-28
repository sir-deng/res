package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.plugin.game.model.n.b;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.widget.TextProgressBar;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class MyGameInfoView extends LinearLayout {
    static Map<String, View> nBP = new HashMap();
    private LinearLayout mAt;
    private Context mContext;
    Map<String, o> nBO;
    private int niV;
    private com.tencent.mm.plugin.game.model.ai.a njp;
    private l nrD;
    private LayoutInflater ntf;
    private int nth;
    b nuo = new b() {
        public final void h(int i, String str, boolean z) {
            if (z && !bi.oN(str)) {
                String[] strArr = new String[MyGameInfoView.this.nBO.keySet().size()];
                MyGameInfoView.this.nBO.keySet().toArray(strArr);
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 < strArr.length) {
                        o oVar = (o) MyGameInfoView.this.nBO.get(strArr[i3]);
                        if (!(oVar == null || oVar.nhC == null || (!oVar.nhC.field_appId.equals(str) && !oVar.nhC.field_packageName.equals(str)))) {
                            oVar.cQ(MyGameInfoView.this.mContext);
                            oVar.aQQ();
                            View view = (View) MyGameInfoView.nBP.get(oVar.nhC.field_appId);
                            if (view != null) {
                                a aVar = (a) view.getTag();
                                MyGameInfoView.this.nup.a(aVar.nyw, aVar.nyv, oVar.nhC, (o) MyGameInfoView.this.nBO.get(oVar.nhC.field_appId));
                            }
                        }
                        i2 = i3 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    };
    e nup;
    private OnClickListener nva = new OnClickListener() {
        public final void onClick(View view) {
            if (view.getTag() instanceof d) {
                d dVar = (d) view.getTag();
                if (MyGameInfoView.this.nBO.containsKey(dVar.field_appId)) {
                    o oVar = (o) MyGameInfoView.this.nBO.get(dVar.field_appId);
                    oVar.cQ(MyGameInfoView.this.mContext);
                    MyGameInfoView.this.nup.a(dVar, oVar);
                    return;
                }
                x.e("MicroMsg.MyGameInfoView", "No DownloadInfo found");
                return;
            }
            x.e("MicroMsg.MyGameInfoView", "No button tag retrived, ignore click");
        }
    };

    private static class a {
        public TextView nBR;
        public ViewGroup nrG;
        public TextView nrH;
        public ImageView nrs;
        public TextView nrt;
        public Button nyv;
        public TextProgressBar nyw;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    static /* synthetic */ void a(MyGameInfoView myGameInfoView, d dVar) {
        if (dVar != null) {
            o oVar = (o) myGameInfoView.nBO.get(dVar.field_appId);
            if (oVar == null) {
                oVar = new o(dVar);
                myGameInfoView.nBO.put(dVar.field_appId, oVar);
            }
            oVar.cQ(myGameInfoView.mContext);
            oVar.aQQ();
        }
    }

    public MyGameInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.ntf = (LayoutInflater) getContext().getSystemService("layout_inflater");
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mAt = (LinearLayout) findViewById(R.h.ckU);
        this.nrD = new l();
        this.nup = new e(this.mContext);
        this.nBO = new HashMap();
        n.a(this.nuo);
        x.i("MicroMsg.MyGameInfoView", "initView finished");
    }

    public final void a(com.tencent.mm.plugin.game.model.ai.a aVar, int i, int i2) {
        if (aVar == null) {
            setVisibility(8);
            return;
        }
        this.niV = i;
        this.nth = i2;
        this.nrD.rg(this.niV);
        setVisibility(0);
        if (this.nth == 2) {
            ap.a(this.mContext, 10, 1002, 0, null, this.niV, null);
        }
        this.njp = aVar;
        final LinkedList linkedList = new LinkedList();
        Iterator it = this.njp.njq.iterator();
        while (it.hasNext()) {
            linkedList.add(((com.tencent.mm.plugin.game.model.ai.a.a) it.next()).njs);
        }
        as.Dt().F(new Runnable() {
            public final void run() {
                try {
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        d dVar = (d) it.next();
                        if (!MyGameInfoView.this.nBO.containsKey(dVar.field_appId)) {
                            MyGameInfoView.a(MyGameInfoView.this, dVar);
                        }
                    }
                } catch (Exception e) {
                    x.i("MicroMsg.MyGameInfoView", e.getMessage());
                }
            }
        });
        a(aVar);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.tencent.mm.plugin.game.model.ai.a r13) {
        /*
        r12 = this;
        r0 = r12.mAt;
        r0.removeAllViews();
        r0 = 0;
        r1 = r13.njq;
        r1 = com.tencent.mm.sdk.platformtools.bi.cC(r1);
        if (r1 != 0) goto L_0x05ff;
    L_0x000e:
        r1 = r13.njq;
        r9 = r1.iterator();
        r1 = r0;
    L_0x0015:
        r0 = r9.hasNext();
        if (r0 == 0) goto L_0x0600;
    L_0x001b:
        r0 = r9.next();
        r7 = r0;
        r7 = (com.tencent.mm.plugin.game.model.ai.a.a) r7;
        r0 = r7.njs;
        if (r0 == 0) goto L_0x0015;
    L_0x0026:
        r0 = r7.njs;
        r0 = r0.field_appId;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r0 != 0) goto L_0x0015;
    L_0x0030:
        r0 = r7.njs;
        r0 = r0.field_appName;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r0 != 0) goto L_0x0015;
    L_0x003a:
        r1 = r7.njs;
        r0 = r12.mAt;
        r12.g(r0);
        r2 = new com.tencent.mm.plugin.game.ui.MyGameInfoView$a;
        r0 = 0;
        r2.<init>(r0);
        r0 = r12.ntf;
        r3 = com.tencent.mm.R.i.dkG;
        r4 = r12.mAt;
        r5 = 0;
        r3 = r0.inflate(r3, r4, r5);
        r0 = com.tencent.mm.R.h.cuW;
        r0 = r3.findViewById(r0);
        r0 = (android.view.ViewGroup) r0;
        r2.nrG = r0;
        r0 = com.tencent.mm.R.h.cmn;
        r0 = r3.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r2.nrs = r0;
        r0 = com.tencent.mm.R.h.cmX;
        r0 = r3.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r2.nrt = r0;
        r0 = com.tencent.mm.R.h.ckV;
        r0 = r3.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r2.nrH = r0;
        r0 = com.tencent.mm.R.h.clZ;
        r0 = r3.findViewById(r0);
        r0 = (android.widget.Button) r0;
        r2.nyv = r0;
        r0 = com.tencent.mm.R.h.cmb;
        r0 = r3.findViewById(r0);
        r0 = (com.tencent.mm.plugin.game.widget.TextProgressBar) r0;
        r2.nyw = r0;
        r0 = r2.nyw;
        r4 = 14;
        r0.rv(r4);
        r0 = r2.nyv;
        r4 = r12.nva;
        r0.setOnClickListener(r4);
        r0 = r2.nyw;
        r4 = r12.nva;
        r0.setOnClickListener(r4);
        r0 = com.tencent.mm.R.h.cmC;
        r0 = r3.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r2.nBR = r0;
        r0 = r1.aQA();
        if (r0 == 0) goto L_0x01df;
    L_0x00b3:
        r0 = r12.mContext;
        r0 = com.tencent.mm.pluginsdk.model.app.g.a(r0, r1);
        if (r0 != 0) goto L_0x01df;
    L_0x00bb:
        r0 = r1.ngU;
        r0 = r0.noH;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r0 != 0) goto L_0x01af;
    L_0x00c5:
        r0 = com.tencent.mm.plugin.game.d.e.aSC();
        r4 = r2.nrs;
        r5 = r1.ngU;
        r5 = r5.noH;
        r0.h(r4, r5);
    L_0x00d2:
        r0 = r1.ngU;
        r0 = r0.noG;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r0 != 0) goto L_0x01c2;
    L_0x00dc:
        r0 = r2.nrt;
        r4 = r1.ngU;
        r4 = r4.noG;
        r0.setText(r4);
    L_0x00e5:
        r0 = r1.ngU;
        r0 = r0.nli;
        if (r0 == 0) goto L_0x011d;
    L_0x00eb:
        r0 = r2.nBR;
        r4 = 0;
        r0.setVisibility(r4);
        r0 = r2.nBR;
        r4 = r1.ngU;
        r4 = r4.nli;
        r4 = r4.nkW;
        r0.setText(r4);
        r0 = r1.ngU;	 Catch:{ Exception -> 0x01cb }
        r0 = r0.nli;	 Catch:{ Exception -> 0x01cb }
        r0 = r0.npa;	 Catch:{ Exception -> 0x01cb }
        r4 = android.graphics.Color.parseColor(r0);	 Catch:{ Exception -> 0x01cb }
        r0 = r2.nBR;	 Catch:{ Exception -> 0x01cb }
        r0.setTextColor(r4);	 Catch:{ Exception -> 0x01cb }
        r0 = r2.nBR;	 Catch:{ Exception -> 0x01cb }
        r0 = r0.getBackground();	 Catch:{ Exception -> 0x01cb }
        if (r0 == 0) goto L_0x011d;
    L_0x0113:
        r5 = r0 instanceof android.graphics.drawable.GradientDrawable;	 Catch:{ Exception -> 0x01cb }
        if (r5 == 0) goto L_0x011d;
    L_0x0117:
        r0 = (android.graphics.drawable.GradientDrawable) r0;	 Catch:{ Exception -> 0x01cb }
        r5 = 1;
        r0.setStroke(r5, r4);	 Catch:{ Exception -> 0x01cb }
    L_0x011d:
        r0 = r1.ngz;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r0 != 0) goto L_0x01f9;
    L_0x0125:
        r0 = r2.nrH;
        r4 = r1.ngO;
        r0.setText(r4);
        r0 = r2.nrH;
        r4 = 0;
        r0.setVisibility(r4);
    L_0x0132:
        r0 = r2.nyv;
        r0.setTag(r1);
        r0 = r2.nyw;
        r0.setTag(r1);
        r0 = r12.nBO;
        r4 = r1.field_appId;
        r0 = r0.get(r4);
        r0 = (com.tencent.mm.plugin.game.model.o) r0;
        if (r0 != 0) goto L_0x014d;
    L_0x0148:
        r0 = new com.tencent.mm.plugin.game.model.o;
        r0.<init>(r1);
    L_0x014d:
        r4 = r12.nup;
        r5 = r2.nyw;
        r6 = r2.nyv;
        r4.a(r5, r6, r1, r0);
        r0 = r2.nrG;
        r4 = r12.nrD;
        r0.setOnClickListener(r4);
        r0 = r2.nrG;
        r0.setTag(r1);
        r3.setTag(r2);
        r0 = nBP;
        r1 = r1.field_appId;
        r0.put(r1, r3);
        r0 = r12.mAt;
        r0.addView(r3);
        r8 = 1;
        r0 = r7.njt;
        r1 = com.tencent.mm.sdk.platformtools.bi.cC(r0);
        if (r1 != 0) goto L_0x05fc;
    L_0x017a:
        r10 = r0.iterator();
    L_0x017e:
        r0 = r10.hasNext();
        if (r0 == 0) goto L_0x05fc;
    L_0x0184:
        r0 = r10.next();
        r6 = r0;
        r6 = (com.tencent.mm.plugin.game.c.an) r6;
        if (r6 == 0) goto L_0x017e;
    L_0x018d:
        r0 = r6.nlz;
        switch(r0) {
            case 1: goto L_0x0202;
            case 2: goto L_0x03a3;
            case 3: goto L_0x0192;
            case 4: goto L_0x0192;
            case 5: goto L_0x0192;
            case 6: goto L_0x0192;
            case 7: goto L_0x0487;
            default: goto L_0x0192;
        };
    L_0x0192:
        r0 = r12.nth;
        r1 = 2;
        if (r0 != r1) goto L_0x017e;
    L_0x0197:
        r0 = r12.mContext;
        r1 = 10;
        r2 = 1002; // 0x3ea float:1.404E-42 double:4.95E-321;
        r3 = r6.nmE;
        r4 = r7.njs;
        r4 = r4.field_appId;
        r5 = r12.niV;
        r6 = r6.nlr;
        r6 = com.tencent.mm.plugin.game.model.ap.CD(r6);
        com.tencent.mm.plugin.game.model.ap.a(r0, r1, r2, r3, r4, r5, r6);
        goto L_0x017e;
    L_0x01af:
        r0 = com.tencent.mm.plugin.game.d.e.aSC();
        r4 = r2.nrs;
        r5 = r1.field_appId;
        r6 = r12.mContext;
        r6 = com.tencent.mm.bu.a.getDensity(r6);
        r0.a(r4, r5, r6);
        goto L_0x00d2;
    L_0x01c2:
        r0 = r2.nrt;
        r4 = r1.field_appName;
        r0.setText(r4);
        goto L_0x00e5;
    L_0x01cb:
        r0 = move-exception;
        r4 = "MicroMsg.MyGameInfoView";
        r0 = r0.getMessage();
        com.tencent.mm.sdk.platformtools.x.e(r4, r0);
        r0 = r2.nBR;
        r4 = 8;
        r0.setVisibility(r4);
        goto L_0x011d;
    L_0x01df:
        r0 = com.tencent.mm.plugin.game.d.e.aSC();
        r4 = r2.nrs;
        r5 = r1.field_appId;
        r6 = r12.mContext;
        r6 = com.tencent.mm.bu.a.getDensity(r6);
        r0.a(r4, r5, r6);
        r0 = r2.nrt;
        r4 = r1.field_appName;
        r0.setText(r4);
        goto L_0x011d;
    L_0x01f9:
        r0 = r2.nrH;
        r4 = 8;
        r0.setVisibility(r4);
        goto L_0x0132;
    L_0x0202:
        r0 = r6.nlv;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r0 != 0) goto L_0x017e;
    L_0x020a:
        r0 = r6.nmF;
        if (r0 == 0) goto L_0x017e;
    L_0x020e:
        r0 = r6.nmF;
        r0 = r0.fpg;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r0 != 0) goto L_0x017e;
    L_0x0218:
        r0 = r12.ntf;
        r1 = com.tencent.mm.R.i.dld;
        r2 = 0;
        r2 = r0.inflate(r1, r2);
        r0 = com.tencent.mm.R.h.cnr;
        r0 = r2.findViewById(r0);
        r0 = (com.tencent.mm.plugin.game.ui.MyGameTextStyleView) r0;
        r1 = r12.niV;
        r0.niV = r1;
        r1 = r7.njs;
        r1 = r1.field_appId;
        r0.appId = r1;
        if (r6 == 0) goto L_0x024b;
    L_0x0235:
        r1 = r6.nlv;
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
        if (r1 != 0) goto L_0x024b;
    L_0x023d:
        r1 = r6.nmF;
        if (r1 == 0) goto L_0x024b;
    L_0x0241:
        r1 = r6.nmF;
        r1 = r1.fpg;
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
        if (r1 == 0) goto L_0x0262;
    L_0x024b:
        r1 = 8;
        r0.setVisibility(r1);
    L_0x0250:
        r0 = r0.getVisibility();
        if (r0 != 0) goto L_0x0192;
    L_0x0256:
        r0 = r12.mAt;
        r12.e(r0);
        r0 = r12.mAt;
        r0.addView(r2);
        goto L_0x0192;
    L_0x0262:
        r1 = 0;
        r0.setVisibility(r1);
        r1 = r6.nlv;
        r1 = r1.length();
        r3 = 4;
        if (r1 <= r3) goto L_0x02ed;
    L_0x026f:
        r1 = r0.nBS;
        r3 = r6.nlv;
        r4 = 0;
        r5 = 4;
        r3 = r3.substring(r4, r5);
        r1.setText(r3);
    L_0x027c:
        r1 = r6.nmD;
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
        if (r1 != 0) goto L_0x0291;
    L_0x0284:
        r1 = r0.nBT;
        r3 = r6.nmD;
        r1.setText(r3);
        r1 = r0.nBT;
        r3 = 0;
        r1.setVisibility(r3);
    L_0x0291:
        r1 = r0.jtn;
        r3 = r0.mContext;
        r4 = r6.nmF;
        r4 = r4.fpg;
        r5 = r0.jtn;
        r5 = r5.getTextSize();
        r3 = com.tencent.mm.pluginsdk.ui.d.i.b(r3, r4, r5);
        r1.setText(r3);
        r1 = r6.nmF;
        r1 = r1.noQ;
        r3 = r6.nmF;
        r3 = r3.nkL;
        r3 = com.tencent.mm.sdk.platformtools.bi.oN(r3);
        if (r3 != 0) goto L_0x02cf;
    L_0x02b4:
        r3 = r0.nBV;
        r4 = r0.mContext;
        r5 = r6.nmF;
        r5 = r5.nkL;
        r11 = r0.nBV;
        r11 = r11.getTextSize();
        r4 = com.tencent.mm.pluginsdk.ui.d.i.b(r4, r5, r11);
        r3.setText(r4);
        r3 = r0.nBV;
        r4 = 0;
        r3.setVisibility(r4);
    L_0x02cf:
        r3 = r6.nmF;
        r3 = r3.nkM;
        r3 = com.tencent.mm.sdk.platformtools.bi.oN(r3);
        if (r3 != 0) goto L_0x02e5;
    L_0x02d9:
        r3 = new com.tencent.mm.plugin.game.d.e$a$a;
        r3.<init>();
        r4 = r6.nmF;
        r4 = r4.noO;
        switch(r4) {
            case 0: goto L_0x0332;
            case 1: goto L_0x0313;
            case 2: goto L_0x030d;
            case 3: goto L_0x0332;
            case 4: goto L_0x02f5;
            default: goto L_0x02e5;
        };
    L_0x02e5:
        r0.setTag(r6);
        r0.setOnClickListener(r0);
        goto L_0x0250;
    L_0x02ed:
        r1 = r0.nBS;
        r3 = r6.nlv;
        r1.setText(r3);
        goto L_0x027c;
    L_0x02f5:
        r1 = r0.nCa;
        r4 = 0;
        r1.setVisibility(r4);
        r1 = com.tencent.mm.plugin.game.d.e.aSC();
        r4 = r0.nCb;
        r5 = r6.nmF;
        r5 = r5.nkM;
        r3 = r3.aSD();
        r1.a(r4, r5, r3);
        goto L_0x02e5;
    L_0x030d:
        r1 = r0.nBX;
        r4 = 0;
        r1.setVisibility(r4);
    L_0x0313:
        r1 = r0.nBW;
        r4 = 0;
        r1.setVisibility(r4);
        r1 = 1;
        r3.hFJ = r1;
        r1 = com.tencent.mm.R.g.bCE;
        r3.nDd = r1;
        r1 = com.tencent.mm.plugin.game.d.e.aSC();
        r4 = r0.nBY;
        r5 = r6.nmF;
        r5 = r5.nkM;
        r3 = r3.aSD();
        r1.a(r4, r5, r3);
        goto L_0x02e5;
    L_0x0332:
        if (r1 == 0) goto L_0x037a;
    L_0x0334:
        r1 = r0.nCc;
        r4 = 0;
        r1.setVisibility(r4);
        r1 = r0.nCd;
        r1 = r1.getLayoutParams();
        r1 = (android.widget.RelativeLayout.LayoutParams) r1;
        r4 = r0.nBV;
        r4 = r4.getLineCount();
        r5 = 2;
        if (r4 >= r5) goto L_0x0374;
    L_0x034b:
        r4 = 15;
        r1.addRule(r4);
    L_0x0350:
        r4 = r0.nCd;
        r4.setLayoutParams(r1);
        r1 = 1;
        r3.nDa = r1;
        r1 = com.tencent.mm.plugin.game.d.e.aSC();
        r4 = r0.nCe;
        r5 = r6.nmF;
        r5 = r5.nkM;
        r3 = r3.aSD();
        r1.a(r4, r5, r3);
        r1 = r0.nCf;
        r3 = r6.nmF;
        r3 = r3.noP;
        com.tencent.mm.plugin.game.ui.MyGameTextStyleView.g(r1, r3);
        goto L_0x02e5;
    L_0x0374:
        r4 = 12;
        r1.addRule(r4);
        goto L_0x0350;
    L_0x037a:
        r1 = r0.nBW;
        r4 = 0;
        r1.setVisibility(r4);
        r1 = 1;
        r3.nDa = r1;
        r1 = com.tencent.mm.R.g.bCF;
        r3.nDd = r1;
        r1 = com.tencent.mm.plugin.game.d.e.aSC();
        r4 = r0.nBY;
        r5 = r6.nmF;
        r5 = r5.nkM;
        r3 = r3.aSD();
        r1.a(r4, r5, r3);
        r1 = r0.nBZ;
        r3 = r6.nmF;
        r3 = r3.noP;
        com.tencent.mm.plugin.game.ui.MyGameTextStyleView.g(r1, r3);
        goto L_0x02e5;
    L_0x03a3:
        r0 = r6.nlv;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r0 != 0) goto L_0x017e;
    L_0x03ab:
        r0 = r6.nmG;
        if (r0 == 0) goto L_0x017e;
    L_0x03af:
        r0 = r6.nmG;
        r0 = r0.nkM;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r0 != 0) goto L_0x017e;
    L_0x03b9:
        r0 = r12.ntf;
        r1 = com.tencent.mm.R.i.dlc;
        r2 = 0;
        r2 = r0.inflate(r1, r2);
        r0 = com.tencent.mm.R.h.cna;
        r0 = r2.findViewById(r0);
        r0 = (com.tencent.mm.plugin.game.ui.MyGamePicStyleView) r0;
        r1 = r12.niV;
        r0.niV = r1;
        r1 = r7.njs;
        r1 = r1.field_appId;
        r0.appId = r1;
        if (r6 == 0) goto L_0x03ec;
    L_0x03d6:
        r1 = r6.nlv;
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
        if (r1 != 0) goto L_0x03ec;
    L_0x03de:
        r1 = r6.nmG;
        if (r1 == 0) goto L_0x03ec;
    L_0x03e2:
        r1 = r6.nmG;
        r1 = r1.nkM;
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
        if (r1 == 0) goto L_0x0403;
    L_0x03ec:
        r1 = 8;
        r0.setVisibility(r1);
    L_0x03f1:
        r0 = r0.getVisibility();
        if (r0 != 0) goto L_0x0192;
    L_0x03f7:
        r0 = r12.mAt;
        r12.e(r0);
        r0 = r12.mAt;
        r0.addView(r2);
        goto L_0x0192;
    L_0x0403:
        r1 = 0;
        r0.setVisibility(r1);
        r1 = r6.nlv;
        r1 = r1.length();
        r3 = 4;
        if (r1 <= r3) goto L_0x047f;
    L_0x0410:
        r1 = r0.nBS;
        r3 = r6.nlv;
        r4 = 0;
        r5 = 4;
        r3 = r3.substring(r4, r5);
        r1.setText(r3);
    L_0x041d:
        r1 = r6.nmD;
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
        if (r1 != 0) goto L_0x0432;
    L_0x0425:
        r1 = r0.nBT;
        r3 = r6.nmD;
        r1.setText(r3);
        r1 = r0.nBT;
        r3 = 0;
        r1.setVisibility(r3);
    L_0x0432:
        r1 = new com.tencent.mm.plugin.game.d.e$a$a;
        r1.<init>();
        r3 = com.tencent.mm.R.g.bCC;
        r1.nDd = r3;
        r3 = com.tencent.mm.plugin.game.d.e.aSC();
        r4 = r0.nBU;
        r5 = r6.nmG;
        r5 = r5.nkM;
        r1 = r1.aSD();
        r3.a(r4, r5, r1);
        r1 = r0.mContext;
        r1 = com.tencent.mm.plugin.game.d.c.getScreenWidth(r1);
        r3 = r0.getPaddingLeft();
        r1 = r1 - r3;
        r3 = r0.getPaddingRight();
        r1 = r1 - r3;
        r3 = 1117782016; // 0x42a00000 float:80.0 double:5.522576936E-315;
        r1 = (float) r1;
        r4 = 1143767040; // 0x442c8000 float:690.0 double:5.650960013E-315;
        r1 = r1 / r4;
        r1 = r1 * r3;
        r3 = java.lang.Math.round(r1);
        r1 = r0.nBU;
        r1 = r1.getLayoutParams();
        r1 = (android.widget.RelativeLayout.LayoutParams) r1;
        r1.height = r3;
        r3 = r0.nBU;
        r3.setLayoutParams(r1);
        r0.setTag(r6);
        r0.setOnClickListener(r0);
        goto L_0x03f1;
    L_0x047f:
        r1 = r0.nBS;
        r3 = r6.nlv;
        r1.setText(r3);
        goto L_0x041d;
    L_0x0487:
        r0 = r6.nlv;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r0 != 0) goto L_0x017e;
    L_0x048f:
        r0 = r6.nmI;
        if (r0 == 0) goto L_0x017e;
    L_0x0493:
        r0 = r6.nmI;
        r0 = r0.fpg;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r0 != 0) goto L_0x017e;
    L_0x049d:
        r0 = r12.ntf;
        r1 = com.tencent.mm.R.i.dle;
        r2 = 0;
        r1 = r0.inflate(r1, r2);
        r0 = com.tencent.mm.R.h.cyB;
        r0 = r1.findViewById(r0);
        r0 = (com.tencent.mm.plugin.game.ui.MyGameVideoRecomStyleView) r0;
        r2 = r12.niV;
        r0.niV = r2;
        r2 = r7.njs;
        r2 = r2.field_appId;
        r0.mAppId = r2;
        if (r6 == 0) goto L_0x04d0;
    L_0x04ba:
        r2 = r6.nlv;
        r2 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
        if (r2 != 0) goto L_0x04d0;
    L_0x04c2:
        r2 = r6.nmI;
        if (r2 == 0) goto L_0x04d0;
    L_0x04c6:
        r2 = r6.nmI;
        r2 = r2.fpg;
        r2 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
        if (r2 == 0) goto L_0x04e7;
    L_0x04d0:
        r2 = 8;
        r0.setVisibility(r2);
    L_0x04d5:
        r0 = r0.getVisibility();
        if (r0 != 0) goto L_0x0192;
    L_0x04db:
        r0 = r12.mAt;
        r12.e(r0);
        r0 = r12.mAt;
        r0.addView(r1);
        goto L_0x0192;
    L_0x04e7:
        r2 = 0;
        r0.setVisibility(r2);
        r2 = r6.nlv;
        r2 = r2.length();
        r3 = 4;
        if (r2 <= r3) goto L_0x058f;
    L_0x04f4:
        r2 = r0.nCg;
        r3 = r6.nlv;
        r4 = 0;
        r5 = 4;
        r3 = r3.substring(r4, r5);
        r2.setText(r3);
    L_0x0501:
        r2 = r6.nmD;
        r2 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
        if (r2 != 0) goto L_0x0598;
    L_0x0509:
        r2 = r0.nCh;
        r3 = r6.nmD;
        r2.setText(r3);
        r2 = r0.nCh;
        r3 = 0;
        r2.setVisibility(r3);
    L_0x0516:
        r2 = r0.maU;
        r3 = r0.mContext;
        r4 = r6.nmI;
        r4 = r4.fpg;
        r5 = r0.maU;
        r5 = r5.getTextSize();
        r3 = com.tencent.mm.pluginsdk.ui.d.i.b(r3, r4, r5);
        r2.setText(r3);
        r2 = r6.nmI;
        r2 = r2.npZ;
        r2 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
        if (r2 != 0) goto L_0x059f;
    L_0x0535:
        r2 = r0.nCi;
        r3 = r6.nmI;
        r3 = r3.npZ;
        r2.setText(r3);
        r2 = r0.nCi;
        r3 = 0;
        r2.setVisibility(r3);
    L_0x0544:
        r2 = r6.nmI;
        r2 = r2.nqd;
        r2 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
        if (r2 != 0) goto L_0x05a7;
    L_0x054e:
        r2 = r0.nCj;
        r3 = r6.nmI;
        r3 = r3.nqd;
        r2.setText(r3);
        r2 = r0.nCj;
        r3 = 0;
        r2.setVisibility(r3);
    L_0x055d:
        r2 = r6.nmI;
        r2 = r2.noS;
        r2 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
        if (r2 != 0) goto L_0x05af;
    L_0x0567:
        r2 = r0.nCk;
        r3 = r6.nmI;
        r3 = r3.noS;
        r2.setText(r3);
        r2 = r0.nCk;
        r3 = 0;
        r2.setVisibility(r3);
    L_0x0576:
        r2 = r6.nmI;
        r2 = r2.nkM;
        r2 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
        if (r2 == 0) goto L_0x05b7;
    L_0x0580:
        r2 = r0.nCl;
        r3 = 8;
        r2.setVisibility(r3);
    L_0x0587:
        r0.setTag(r6);
        r0.setOnClickListener(r0);
        goto L_0x04d5;
    L_0x058f:
        r2 = r0.nCg;
        r3 = r6.nlv;
        r2.setText(r3);
        goto L_0x0501;
    L_0x0598:
        r2 = 8;
        r0.setVisibility(r2);
        goto L_0x0516;
    L_0x059f:
        r2 = r0.nCi;
        r3 = 8;
        r2.setVisibility(r3);
        goto L_0x0544;
    L_0x05a7:
        r2 = r0.nCj;
        r3 = 8;
        r2.setVisibility(r3);
        goto L_0x055d;
    L_0x05af:
        r2 = r0.nCk;
        r3 = 8;
        r2.setVisibility(r3);
        goto L_0x0576;
    L_0x05b7:
        r2 = r0.nCl;
        r3 = 0;
        r2.setVisibility(r3);
        r2 = new com.tencent.mm.plugin.game.d.e$a$a;
        r2.<init>();
        r3 = 1;
        r2.nDa = r3;
        r3 = com.tencent.mm.plugin.game.d.e.aSC();
        r4 = r0.jQi;
        r5 = r6.nmI;
        r5 = r5.nkM;
        r2 = r2.aSD();
        r3.a(r4, r5, r2);
        r2 = r6.nmI;
        r2 = r2.noP;
        r2 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
        if (r2 == 0) goto L_0x05e8;
    L_0x05e0:
        r2 = r0.nCn;
        r3 = 8;
        r2.setVisibility(r3);
        goto L_0x0587;
    L_0x05e8:
        r2 = com.tencent.mm.plugin.game.d.e.aSC();
        r3 = r0.nCn;
        r4 = r6.nmI;
        r4 = r4.noP;
        r2.h(r3, r4);
        r2 = r0.nCn;
        r3 = 0;
        r2.setVisibility(r3);
        goto L_0x0587;
    L_0x05fc:
        r1 = r8;
        goto L_0x0015;
    L_0x05ff:
        r1 = r0;
    L_0x0600:
        if (r1 == 0) goto L_0x0607;
    L_0x0602:
        r0 = r12.mAt;
        r12.g(r0);
    L_0x0607:
        r0 = r13.njr;
        if (r0 == 0) goto L_0x0650;
    L_0x060b:
        r0 = r13.njr;
        r0 = r0.nkL;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r0 != 0) goto L_0x0650;
    L_0x0615:
        r0 = r13.njr;
        r0 = r0.nkN;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r0 != 0) goto L_0x0650;
    L_0x061f:
        r0 = r12.ntf;
        r2 = com.tencent.mm.R.i.dla;
        r3 = 0;
        r2 = r0.inflate(r2, r12, r3);
        r0 = com.tencent.mm.R.h.text;
        r0 = r2.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r3 = r13.njr;
        r3 = r3.nkL;
        r0.setText(r3);
        r0 = r13.njr;
        r0 = r0.nkN;
        r2.setTag(r0);
        r0 = new com.tencent.mm.plugin.game.ui.MyGameInfoView$1;
        r0.<init>();
        r2.setOnClickListener(r0);
        r0 = r12.mAt;
        r0.addView(r2);
        r0 = r12.mAt;
        r12.g(r0);
    L_0x0650:
        if (r1 == 0) goto L_0x0657;
    L_0x0652:
        r0 = 0;
        r12.setVisibility(r0);
    L_0x0656:
        return;
    L_0x0657:
        r0 = 8;
        r12.setVisibility(r0);
        goto L_0x0656;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.ui.MyGameInfoView.a(com.tencent.mm.plugin.game.model.ai$a):void");
    }

    private void g(ViewGroup viewGroup) {
        viewGroup.addView((ImageView) this.ntf.inflate(R.i.dkl, viewGroup, false));
    }

    private void e(ViewGroup viewGroup) {
        ImageView imageView = (ImageView) this.ntf.inflate(R.i.dkl, viewGroup, false);
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) imageView.getLayoutParams();
        marginLayoutParams.leftMargin = com.tencent.mm.bu.a.fromDPToPix(this.mContext, 15);
        imageView.setLayoutParams(marginLayoutParams);
        viewGroup.addView(imageView);
    }
}
