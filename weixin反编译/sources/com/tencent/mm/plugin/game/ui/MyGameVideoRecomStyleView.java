package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.c.an;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class MyGameVideoRecomStyleView extends LinearLayout implements OnClickListener {
    ImageView jQi;
    String mAppId;
    Context mContext;
    TextView maU;
    TextView nCg;
    TextView nCh;
    TextView nCi;
    TextView nCj;
    TextView nCk;
    RelativeLayout nCl;
    private FrameLayout nCm;
    ImageView nCn;
    int niV;

    public MyGameVideoRecomStyleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.nCg = (TextView) findViewById(R.h.cxj);
        this.nCh = (TextView) findViewById(R.h.cxi);
        this.maU = (TextView) findViewById(R.h.title);
        this.nCi = (TextView) findViewById(R.h.bKi);
        this.nCj = (TextView) findViewById(R.h.bKh);
        this.nCk = (TextView) findViewById(R.h.cbo);
        this.nCl = (RelativeLayout) findViewById(R.h.coO);
        this.nCm = (FrameLayout) findViewById(R.h.coP);
        this.jQi = (ImageView) findViewById(R.h.icon);
        this.nCn = (ImageView) findViewById(R.h.bZs);
        x.i("MicroMsg.MyGameVideoRecomStyleView", "initView finished");
    }

    public void onClick(View view) {
        if (view.getTag() == null || !(view.getTag() instanceof an)) {
            x.w("MicroMsg.MyGameVideoRecomStyleView", "getTag is null");
            return;
        }
        an anVar = (an) view.getTag();
        if (bi.oN(anVar.nmI.nkN)) {
            x.w("MicroMsg.MyGameVideoRecomStyleView", "jumpUrl is null");
            return;
        }
        ap.a(this.mContext, 10, 1002, anVar.nmE, c.p(this.mContext, anVar.nmI.nkN, "game_center_mygame_comm"), this.mAppId, this.niV, ap.CD(anVar.nlr));
    }
}
