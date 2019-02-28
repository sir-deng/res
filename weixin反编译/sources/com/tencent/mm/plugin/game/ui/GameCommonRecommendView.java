package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.c.dr;
import com.tencent.mm.plugin.game.c.w;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.widget.CircleImageView;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

public class GameCommonRecommendView extends LinearLayout implements OnClickListener {
    private LayoutInflater DF;
    private Context mContext;
    int niV;
    int nth;
    private View nti;
    private TextView ntj;
    private TextView ntk;
    private LinearLayout ntl;
    private FrameLayout ntm;
    private TextView ntn;
    private ImageView nto;
    private View ntp;
    private ImageView ntq;
    private ImageView ntr;
    private TextView nts;
    private TextView ntt;
    private View ntu;
    private ImageView ntv;
    private ImageView ntw;
    private TextView ntx;
    private TextView nty;

    private static class a {
        String jumpUrl;
        String ngQ;
        int position;

        public a(int i, String str, String str2) {
            this.position = i;
            this.jumpUrl = str;
            this.ngQ = str2;
        }
    }

    public GameCommonRecommendView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.DF = LayoutInflater.from(context);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.nti = findViewById(R.h.cGW);
        this.ntj = (TextView) findViewById(R.h.cGZ);
        this.ntk = (TextView) findViewById(R.h.cGY);
        this.ntl = (LinearLayout) findViewById(R.h.cGU);
        this.ntm = (FrameLayout) findViewById(R.h.cGV);
        this.ntn = (TextView) findViewById(R.h.cGT);
        this.nto = (ImageView) findViewById(R.h.cGX);
        this.ntp = findViewById(R.h.cGM);
        this.ntq = (ImageView) findViewById(R.h.cGJ);
        this.ntr = (ImageView) findViewById(R.h.cGL);
        this.nts = (TextView) findViewById(R.h.cGN);
        this.ntt = (TextView) findViewById(R.h.cGK);
        this.ntu = findViewById(R.h.cGR);
        this.ntv = (ImageView) findViewById(R.h.cGO);
        this.ntw = (ImageView) findViewById(R.h.cGQ);
        this.ntx = (TextView) findViewById(R.h.cGS);
        this.nty = (TextView) findViewById(R.h.cGP);
        if (c.getScreenWidth(this.mContext) < 720) {
            this.nts.setTextSize((float) com.tencent.mm.bu.a.fromDPToPix(this.mContext, 12));
            this.ntt.setTextSize((float) com.tencent.mm.bu.a.fromDPToPix(this.mContext, 12));
            this.ntx.setTextSize((float) com.tencent.mm.bu.a.fromDPToPix(this.mContext, 12));
            this.nty.setTextSize((float) com.tencent.mm.bu.a.fromDPToPix(this.mContext, 12));
        }
        x.i("MicroMsg.GameCommonRecommendView", "initView finished");
    }

    final void a(dr drVar) {
        this.ntj.setText(drVar.npJ.fpg);
        if (!bi.oN(drVar.npJ.nls)) {
            this.ntk.setText(drVar.npJ.nls);
        }
        if (bi.cC(drVar.npJ.nlt)) {
            this.ntn.setText(drVar.npJ.nkL);
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            this.ntm.removeAllViews();
            this.ntm.setVisibility(8);
            Iterator it = drVar.npJ.nlt.iterator();
            while (it.hasNext()) {
                w wVar = (w) it.next();
                if (wVar != null) {
                    if (!(bi.oN(wVar.nlG) || bi.oN(wVar.kzN))) {
                        LinearLayout linearLayout = (LinearLayout) this.DF.inflate(R.i.dtG, this.ntm, false);
                        ImageView imageView = (CircleImageView) linearLayout.findViewById(R.h.cII);
                        LayoutParams layoutParams = (LayoutParams) linearLayout.getLayoutParams();
                        layoutParams.leftMargin = this.ntm.getChildCount() * com.tencent.mm.bu.a.fromDPToPix(this.mContext, 15);
                        linearLayout.setLayoutParams(layoutParams);
                        com.tencent.mm.plugin.game.d.e.a.a aVar = new com.tencent.mm.plugin.game.d.e.a.a();
                        aVar.nDd = R.g.bCD;
                        e.aSC().a(imageView, wVar.nlG, aVar.aSD());
                        this.ntm.addView(linearLayout, 0);
                        stringBuffer.append(wVar.kzN);
                        stringBuffer.append("、");
                    }
                    if (this.ntm.getChildCount() >= 3) {
                        break;
                    }
                }
            }
            if (this.ntm.getChildCount() > 0) {
                this.ntm.setVisibility(0);
            }
            this.ntn.setText(i.b(this.mContext, stringBuffer.length() > 0 ? stringBuffer.substring(0, stringBuffer.length() - 1) : "", this.ntn.getTextSize()));
        }
        if (!bi.oN(drVar.npJ.nkM)) {
            e.aSC().h(this.nto, drVar.npJ.nkM);
        }
        this.nti.setTag(new a(1, drVar.npJ.nkN, drVar.npJ.nlr));
        this.nti.setOnClickListener(this);
        if (this.nth == 2) {
            ap.a(this.mContext, 10, 1018, 1, null, this.niV, ap.CD(drVar.npJ.nlr));
        }
        if (!bi.oN(drVar.npK.npI)) {
            this.ntq.setVisibility(0);
            e.aSC().h(this.ntq, drVar.npK.npI);
        }
        if (!bi.oN(drVar.npK.nlA)) {
            e.aSC().h(this.ntr, drVar.npK.nlA);
        }
        this.nts.setText(drVar.npK.fpg);
        this.ntt.setText(drVar.npK.nkL);
        this.ntp.setTag(new a(2, drVar.npK.nkN, drVar.npK.nlr));
        this.ntp.setOnClickListener(this);
        if (this.nth == 2) {
            ap.a(this.mContext, 10, 1018, 2, null, this.niV, ap.CD(drVar.npK.nlr));
        }
        if (!bi.oN(drVar.npL.npI)) {
            this.ntv.setVisibility(0);
            e.aSC().h(this.ntv, drVar.npL.npI);
        }
        if (!bi.oN(drVar.npL.nlA)) {
            e.aSC().h(this.ntw, drVar.npL.nlA);
        }
        this.ntx.setText(drVar.npL.fpg);
        this.nty.setText(drVar.npL.nkL);
        this.ntu.setTag(new a(3, drVar.npL.nkN, drVar.npL.nlr));
        this.ntu.setOnClickListener(this);
        if (this.nth == 2) {
            ap.a(this.mContext, 10, 1018, 3, null, this.niV, ap.CD(drVar.npL.nlr));
        }
    }

    public void onClick(View view) {
        if (view.getTag() != null && (view.getTag() instanceof a)) {
            a aVar = (a) view.getTag();
            ap.a(this.mContext, 10, 1018, aVar.position, c.ac(this.mContext, aVar.jumpUrl), this.niV, ap.CD(aVar.ngQ));
        }
    }
}
