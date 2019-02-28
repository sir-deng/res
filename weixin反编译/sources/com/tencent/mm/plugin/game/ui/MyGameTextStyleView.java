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
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.widget.EllipsizingTextView;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class MyGameTextStyleView extends LinearLayout implements OnClickListener {
    String appId;
    TextView jtn;
    Context mContext;
    TextView nBS;
    TextView nBT;
    EllipsizingTextView nBV;
    LinearLayout nBW;
    ImageView nBX;
    ImageView nBY;
    ImageView nBZ;
    LinearLayout nCa;
    ImageView nCb;
    RelativeLayout nCc;
    FrameLayout nCd;
    ImageView nCe;
    ImageView nCf;
    int niV;

    public MyGameTextStyleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.nBS = (TextView) findViewById(R.h.cxj);
        this.nBT = (TextView) findViewById(R.h.cxi);
        this.jtn = (TextView) findViewById(R.h.title);
        this.nBV = (EllipsizingTextView) findViewById(R.h.caR);
        this.nBV.setMaxLines(2);
        this.nBW = (LinearLayout) findViewById(R.h.cOR);
        this.nBX = (ImageView) findViewById(R.h.cag);
        this.nBY = (ImageView) findViewById(R.h.cOP);
        this.nBZ = (ImageView) findViewById(R.h.cON);
        this.nCa = (LinearLayout) findViewById(R.h.cHk);
        this.nCb = (ImageView) findViewById(R.h.cHj);
        this.nCc = (RelativeLayout) findViewById(R.h.bMV);
        this.nCd = (FrameLayout) findViewById(R.h.bMW);
        this.nCe = (ImageView) findViewById(R.h.bMT);
        this.nCf = (ImageView) findViewById(R.h.bMS);
        x.i("MicroMsg.MyGameTextStyleView", "initView finished");
    }

    static void g(ImageView imageView, String str) {
        if (bi.oN(str)) {
            imageView.setVisibility(8);
            return;
        }
        imageView.setVisibility(0);
        e.aSC().h(imageView, str);
    }

    public void onClick(View view) {
        if (view.getTag() == null || !(view.getTag() instanceof an)) {
            x.w("MicroMsg.MyGameTextStyleView", "getTag is null");
            return;
        }
        an anVar = (an) view.getTag();
        if (bi.oN(anVar.nmF.nkN)) {
            x.w("MicroMsg.MyGameTextStyleView", "jumpUrl is null");
            return;
        }
        ap.a(this.mContext, 10, 1002, anVar.nmE, c.p(this.mContext, anVar.nmF.nkN, "game_center_mygame_comm"), this.appId, this.niV, ap.CD(anVar.nlr));
    }
}
