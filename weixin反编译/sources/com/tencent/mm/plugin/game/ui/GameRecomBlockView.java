package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.c.ak;
import com.tencent.mm.plugin.game.c.do;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class GameRecomBlockView extends LinearLayout implements OnClickListener {
    private LayoutInflater DF = ((LayoutInflater) getContext().getSystemService("layout_inflater"));
    private ViewGroup mContainer = this;
    private Context mContext;
    int niV;

    private static class a {
        public String appId;
        public String fHA;
        public String jumpUrl;
        public String ngQ;
        public int njZ;

        public a(String str, int i, String str2, String str3, String str4) {
            this.appId = str;
            this.njZ = i;
            this.jumpUrl = str2;
            this.ngQ = str3;
            this.fHA = str4;
        }
    }

    public GameRecomBlockView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        x.i("MicroMsg.GameRecomBlockView", "initView finished");
    }

    final void a(ak akVar, int i, int i2) {
        this.mContainer.removeAllViews();
        if (bi.cC(akVar.nmz)) {
            setVisibility(8);
            return;
        }
        if (i == 2) {
            ap.a(this.mContext, 10, 1021, 0, null, i2, ap.CD(akVar.nlr));
        }
        this.DF.inflate(R.i.djI, this, true);
        TextView textView = (TextView) findViewById(R.h.cGG);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.h.cGD);
        View findViewById = findViewById(R.h.cGH);
        TextView textView2 = (TextView) findViewById(R.h.cGI);
        if (bi.oN(akVar.nlv)) {
            textView.setVisibility(8);
        } else {
            textView.setText(akVar.nlv);
        }
        if (bi.oN(akVar.nmA)) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(akVar.nmA);
        }
        findViewById.setTag(new a(null, 999, akVar.nmB, akVar.nlr, "game_center_mygame_more"));
        findViewById.setOnClickListener(this);
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 < akVar.nmz.size()) {
                do doVar = (do) akVar.nmz.get(i5);
                if (doVar != null) {
                    if (linearLayout.getChildCount() < 3) {
                        i3++;
                        LinearLayout linearLayout2 = (LinearLayout) this.DF.inflate(R.i.djJ, this, false);
                        linearLayout2.setTag(new a(doVar.nlV, i3, doVar.nkN, doVar.nlr, "game_center_mygame_rank"));
                        linearLayout2.setOnClickListener(this);
                        linearLayout.addView(linearLayout2, new LayoutParams(-1, -2, 1.0f));
                        textView = (TextView) linearLayout2.findViewById(R.h.cGF);
                        ImageView imageView = (ImageView) linearLayout2.findViewById(R.h.cGC);
                        TextView textView3 = (TextView) linearLayout2.findViewById(R.h.cGE);
                        TextView textView4 = (TextView) linearLayout2.findViewById(R.h.cGB);
                        switch (i5) {
                            case 0:
                                textView.setTextColor(this.mContext.getResources().getColor(R.e.bsu));
                                break;
                            case 1:
                                textView.setTextColor(this.mContext.getResources().getColor(R.e.bsv));
                                break;
                            case 2:
                                textView.setTextColor(this.mContext.getResources().getColor(R.e.bsw));
                                break;
                        }
                        textView.setText(doVar.fpg);
                        e.aSC().h(imageView, doVar.nkM);
                        textView3.setText(doVar.noG);
                        if (bi.oN(doVar.nkL)) {
                            textView4.setVisibility(8);
                        } else {
                            textView4.setText(doVar.nkL);
                        }
                        if (i == 2) {
                            ap.a(this.mContext, 10, 1021, i3, doVar.nlV, i2, ap.CD(doVar.nlr));
                        }
                    }
                }
                i4 = i5 + 1;
            }
        }
        View view = new View(getContext());
        view.setBackgroundColor(getContext().getResources().getColor(R.e.bsr));
        addView(view, new LayoutParams(-1, com.tencent.mm.bu.a.fromDPToPix(getContext(), 5)));
    }

    public void onClick(View view) {
        if (view.getTag() == null || !(view.getTag() instanceof a)) {
            x.w("MicroMsg.GameRecomBlockView", "getTag is null");
            return;
        }
        a aVar = (a) view.getTag();
        if (bi.oN(aVar.jumpUrl)) {
            x.w("MicroMsg.GameRecomBlockView", "jumpUrl is null");
            return;
        }
        ap.a(this.mContext, 10, 1021, aVar.njZ, c.p(this.mContext, aVar.jumpUrl, aVar.fHA), aVar.appId, this.niV, ap.CD(aVar.ngQ));
    }
}
