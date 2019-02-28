package com.tencent.mm.plugin.webview.fts.topstory.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ap.a.a.c;
import com.tencent.mm.ap.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.topstory.a.a;
import com.tencent.mm.plugin.webview.fts.topstory.a.d;
import com.tencent.mm.plugin.webview.fts.topstory.a.f;
import com.tencent.mm.plugin.webview.fts.topstory.ui.a.b;
import com.tencent.mm.protocal.c.cbj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.u;

public class TopStoryVideoItemView extends LinearLayout implements h {
    public static c tuO;
    private Context context;
    private OnClickListener pMx = new OnClickListener() {
        public final void onClick(View view) {
            boolean z;
            if (((a) g.h(a.class)).bGb() != TopStoryVideoItemView.this.hashCode()) {
                TopStoryVideoItemView.this.tuJ.Av(TopStoryVideoItemView.this.position);
                com.tencent.mm.plugin.aj.a.a.a.qq(4);
                d.OH(TopStoryVideoItemView.this.tuQ.skE);
                com.tencent.mm.plugin.topstory.a.a.d c = TopStoryVideoItemView.this.tuQ;
                int a = TopStoryVideoItemView.this.position;
                if (view.getId() == TopStoryVideoItemView.this.tuP.ikn.getId()) {
                    z = true;
                } else {
                    z = false;
                }
                d.b(c, a, z);
                return;
            }
            b bVar = TopStoryVideoItemView.this.tuP;
            if (bVar.twL.getAlpha() == 0.0f || bVar.twK.getAlpha() == 0.0f) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                TopStoryVideoItemView.this.tuP.bQm();
                TopStoryVideoItemView.this.tuJ.bQm();
                TopStoryVideoItemView.this.tuP.bQl();
                TopStoryVideoItemView.this.tuJ.bQl();
            } else if (view.getId() == TopStoryVideoItemView.this.tuP.twF.getId()) {
                if (!bi.oN(TopStoryVideoItemView.this.tuQ.pka)) {
                    TopStoryVideoItemView.a(TopStoryVideoItemView.this, TopStoryVideoItemView.this.tuQ.pka);
                    TopStoryVideoItemView.d(TopStoryVideoItemView.this);
                    d.OH(TopStoryVideoItemView.this.tuQ.skE);
                    d.b(TopStoryVideoItemView.this.tuQ, TopStoryVideoItemView.this.position, false);
                }
            } else if (view.getId() == TopStoryVideoItemView.this.tuP.ikn.getId()) {
                if (TopStoryVideoItemView.this.tuQ != null && !bi.oN(TopStoryVideoItemView.this.tuQ.skM)) {
                    TopStoryVideoItemView.a(TopStoryVideoItemView.this, TopStoryVideoItemView.this.tuQ.skM);
                    TopStoryVideoItemView.d(TopStoryVideoItemView.this);
                    d.OH(TopStoryVideoItemView.this.tuQ.skE);
                    d.b(TopStoryVideoItemView.this.tuQ, TopStoryVideoItemView.this.position, true);
                }
            } else if (view.getId() == TopStoryVideoItemView.this.tuP.lTf.getId()) {
                com.tencent.mm.plugin.aj.a.a.a.qq(8);
                TopStoryVideoItemView.a(TopStoryVideoItemView.this.getContext(), TopStoryVideoItemView.this.tuP.twD, TopStoryVideoItemView.this.position);
            }
        }
    };
    public int position;
    public Point rch;
    b tuJ;
    public b tuP;
    com.tencent.mm.plugin.topstory.a.a.d tuQ;
    public int tuR;

    static /* synthetic */ void a(TopStoryVideoItemView topStoryVideoItemView, String str) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        com.tencent.mm.bl.d.b(topStoryVideoItemView.context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
    }

    static /* synthetic */ void d(TopStoryVideoItemView topStoryVideoItemView) {
        if (g.bQQ().twx) {
            topStoryVideoItemView.tuP.twD.bQH();
            g.bQQ().byf();
        }
    }

    static {
        c.a aVar = new c.a();
        aVar.hFl = true;
        aVar.hFk = true;
        aVar.hFJ = true;
        aVar.hFA = R.g.bBC;
        tuO = aVar.PQ();
    }

    public TopStoryVideoItemView(Context context) {
        super(context);
        init(context);
    }

    public TopStoryVideoItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public TopStoryVideoItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    final void av() {
        if (bi.oN(this.tuQ.title)) {
            this.tuP.ikn.setVisibility(8);
        } else {
            this.tuP.ikn.setText(this.tuQ.title);
            this.tuP.ikn.setVisibility(0);
        }
        this.tuP.ikn.setOnClickListener(this.pMx);
        this.tuP.qdW.setText(this.tuQ.bhd);
        if (bi.oN(this.tuQ.skG)) {
            this.tuP.twH.setVisibility(8);
        } else {
            this.tuP.twH.setText(this.tuQ.skG);
            this.tuP.twH.setVisibility(0);
        }
        this.tuP.twH.setOnClickListener(this.pMx);
        if (bi.oN(this.tuQ.skL)) {
            this.tuP.twI.setVisibility(8);
        } else {
            this.tuP.twI.setText(this.tuQ.skL);
            this.tuP.twI.setVisibility(0);
        }
        this.tuP.twI.setOnClickListener(this.pMx);
        if (bi.oN(this.tuQ.skP)) {
            this.tuP.twG.setVisibility(8);
        } else {
            o.PG().a(this.tuQ.skP, this.tuP.twG, tuO);
            this.tuP.twG.setVisibility(0);
        }
        this.tuP.lTf.setOnClickListener(this.pMx);
        this.tuP.twJ.setVisibility(0);
        this.tuP.twK.setVisibility(0);
        this.tuP.twL.setVisibility(0);
        this.tuP.twF.setOnClickListener(this.pMx);
        if (this.tuP.twD == null) {
            this.tuP.twD = new f(this.context);
            this.tuP.twE.removeAllViews();
            this.tuP.twE.addView(this.tuP.twD, c(this.tuQ));
        }
        this.tuP.twD.tvu = this.tuJ;
        this.tuP.twD.tvv = this;
        f fVar = this.tuP.twD;
        com.tencent.mm.plugin.topstory.a.a.d dVar = this.tuQ;
        fVar.position = this.position;
        fVar.skA = dVar;
        fVar.av();
        if (((a) g.h(a.class)).bGb() != hashCode()) {
            this.tuP.bQU();
        }
    }

    public final void km(boolean z) {
        bQr();
        ((a) g.h(a.class)).yG(hashCode());
        if (this.tuP.twD.kn(z)) {
            bQm();
            bQl();
        }
    }

    private void init(Context context) {
        Point point;
        this.context = context;
        LayoutInflater.from(context).inflate(R.i.dtm, this);
        this.tuP = new b();
        b bVar = this.tuP;
        bVar.twE = (FrameLayout) findViewById(R.h.cVK);
        bVar.twF = findViewById(R.h.cPh);
        bVar.twG = (ImageView) findViewById(R.h.cPg);
        bVar.qdW = (TextView) findViewById(R.h.cPj);
        bVar.ikn = (TextView) findViewById(R.h.cSB);
        bVar.twH = (TextView) findViewById(R.h.cNQ);
        bVar.twI = (TextView) findViewById(R.h.cCL);
        bVar.lTf = findViewById(R.h.cNT);
        bVar.twJ = findViewById(R.h.bNW);
        bVar.twK = findViewById(R.h.cou);
        bVar.twL = findViewById(R.h.cjc);
        this.rch = ae.fA(context);
        if (ae.fz(context)) {
            point = this.rch;
            point.y -= ae.fy(context);
        }
        point = this.rch;
        point.y -= u.fL(context);
        this.tuR = com.tencent.mm.bu.a.fromDPToPix(context, 24);
    }

    public final void bQl() {
        this.tuP.bQl();
        this.tuJ.bQl();
    }

    public final void bQm() {
        this.tuP.bQm();
        this.tuJ.bQm();
    }

    final LayoutParams c(com.tencent.mm.plugin.topstory.a.a.d dVar) {
        int min = Math.min(this.rch.x, this.rch.y);
        return new LayoutParams(min, (dVar.hcY * min) / dVar.hcZ);
    }

    public final void bQr() {
        x.d("MicroMsg.WebSearch.TopStoryVideoItemView", "hideDarkMask, position: %s", Integer.valueOf(this.position));
        b bVar = this.tuP;
        x.d("MicroMsg.WebSearch.TopStoryTimeLineItemViewHolder", "hideMaskView %d", Integer.valueOf(bVar.hashCode()));
        bVar.twL.animate().cancel();
        bVar.twK.animate().cancel();
        bVar.twJ.animate().cancel();
        bVar.twJ.setAlpha(0.0f);
        bVar.twL.setAlpha(0.0f);
        bVar.twK.setAlpha(0.0f);
    }

    public static boolean ahd() {
        return d.bQo().nhE;
    }

    public static void a(final Context context, final f fVar, int i) {
        f.tuE.iVa = com.tencent.mm.plugin.webview.fts.topstory.a.b.ttX.lKv;
        final com.tencent.mm.plugin.topstory.a.a.d dVar = (com.tencent.mm.plugin.topstory.a.a.d) com.tencent.mm.plugin.webview.fts.topstory.a.b.ttW.get(i);
        if (dVar != null) {
            com.tencent.mm.ui.widget.g gVar = new com.tencent.mm.ui.widget.g(context, com.tencent.mm.ui.widget.g.zCt, false);
            gVar.rQF = new p.c() {
                public final void a(n nVar) {
                    nVar.eT(0, R.l.eTI);
                    nVar.eT(1, R.l.eTH);
                }
            };
            gVar.rQG = new p.d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    f fVar;
                    Context context;
                    com.tencent.mm.plugin.topstory.a.a.d dVar;
                    com.tencent.mm.plugin.topstory.a.a.a aVar;
                    if (menuItem.getItemId() == 0) {
                        fVar.bQH();
                        fVar = f.tuE;
                        context = context;
                        dVar = dVar;
                        aVar = com.tencent.mm.plugin.webview.fts.topstory.a.b.ttY;
                        if (dVar != null && aVar != null) {
                            byte[] toByteArray;
                            fVar.tuF = dVar;
                            Intent intent = new Intent();
                            intent.putExtra("Ksnsupload_title", dVar.lUJ);
                            intent.putExtra("Ksnsupload_imgurl", dVar.skF);
                            intent.putExtra("Ksnsupload_link", dVar.lUI);
                            intent.putExtra("KContentObjDesc", bi.oN(dVar.rlx) ? context.getString(R.l.eCJ) : dVar.rlx);
                            intent.putExtra("KlinkThumb_url", dVar.skF);
                            intent.putExtra("Ksnsupload_source", 1);
                            intent.putExtra("Ksnsupload_type", 16);
                            intent.putExtra("need_result", true);
                            cbj cbj = new cbj();
                            cbj.ttO = dVar.skE;
                            cbj.ttP = dVar.skK;
                            cbj.ttQ = aVar.skq;
                            cbj.ttR = dVar.skJ;
                            cbj.ttS = dVar.skI;
                            cbj.lUI = dVar.lUI;
                            cbj.lUJ = dVar.lUJ;
                            cbj.rlx = dVar.rlx;
                            cbj.skF = dVar.skF;
                            cbj.skG = dVar.skG;
                            cbj.skH = dVar.skH;
                            cbj.bhd = dVar.bhd;
                            cbj.pka = dVar.pka;
                            cbj.skL = dVar.skL;
                            cbj.skM = dVar.skM;
                            try {
                                toByteArray = cbj.toByteArray();
                            } catch (Throwable e) {
                                x.printErrStackTrace("MicroMsg.WebSearch.TopStoryVideoShareMgr", e, "", new Object[0]);
                                toByteArray = null;
                            }
                            if (toByteArray != null) {
                                intent.putExtra("KWebSearchInfo", toByteArray);
                            }
                            com.tencent.mm.bl.d.b(context, "sns", ".ui.SnsUploadUI", intent, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                        }
                    } else if (menuItem.getItemId() == 1) {
                        fVar.bQH();
                        fVar = f.tuE;
                        context = context;
                        dVar = dVar;
                        aVar = com.tencent.mm.plugin.webview.fts.topstory.a.b.ttY;
                        fVar.tuF = dVar;
                        com.tencent.mm.x.g.a aVar2 = new com.tencent.mm.x.g.a();
                        aVar2.type = 5;
                        aVar2.title = dVar.lUJ;
                        aVar2.description = bi.oN(dVar.rlx) ? context.getString(R.l.eCJ) : dVar.rlx;
                        aVar2.url = dVar.lUI;
                        aVar2.thumburl = dVar.skF;
                        com.tencent.mm.x.d aVar3 = new com.tencent.mm.plugin.webview.fts.topstory.a.a();
                        aVar3.ttO = dVar.skE;
                        aVar3.ttP = dVar.skK;
                        aVar3.ttQ = aVar.skq;
                        aVar3.ttR = dVar.skJ;
                        aVar3.ttS = dVar.skI;
                        aVar3.lUI = dVar.lUI;
                        aVar3.lUJ = dVar.lUJ;
                        aVar3.rlx = dVar.rlx;
                        aVar3.skF = dVar.skF;
                        aVar3.skG = dVar.skG;
                        aVar3.skH = dVar.skH;
                        aVar3.bhd = dVar.bhd;
                        aVar3.pka = dVar.pka;
                        aVar3.skL = dVar.skL;
                        aVar3.skM = dVar.skM;
                        aVar2.a(aVar3);
                        String a = com.tencent.mm.x.g.a.a(aVar2, null, null);
                        Intent intent2 = new Intent();
                        intent2.putExtra("Retr_Msg_Type", 2);
                        intent2.putExtra("Retr_Msg_content", a);
                        intent2.putExtra("Multi_Retr", true);
                        intent2.putExtra("Retr_go_to_chattingUI", false);
                        intent2.putExtra("Retr_show_success_tips", true);
                        com.tencent.mm.bl.d.a(context, ".ui.transmit.MsgRetransmitUI", intent2, 2048);
                    }
                }
            };
            gVar.zCF = new com.tencent.mm.ui.widget.g.a() {
                public final void onDismiss() {
                    if (TopStoryVideoItemView.ahd()) {
                        d.bQo().bQp();
                    }
                }
            };
            gVar.bUX();
        }
    }

    public boolean hasTransientState() {
        return false;
    }

    public void setHasTransientState(boolean z) {
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.tuP.twD != null) {
            f fVar = this.tuP.twD;
            x.i("MicroMsg.WebSearch.TopStoryVideoViewContainer", "onUIDestroy %d", Integer.valueOf(fVar.position));
            fVar.tvz.onDestroy();
            fVar.bQJ();
        }
        this.tuQ = null;
        this.position = -1;
    }

    public final void bQs() {
        this.tuP.twD = null;
        ((a) g.h(a.class)).yG(0);
        av();
    }
}
