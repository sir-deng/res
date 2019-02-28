package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bu.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.f;
import com.tencent.mm.sdk.platformtools.bi;

public class GameFeedImageTextView extends LinearLayout implements OnClickListener {
    private int kJB = 0;
    f nrz;
    GameFeedTitleDescView nvI;
    GameRoundImageView nvM;
    LinearLayout nvQ;
    GameRoundImageView nvR;
    GameRoundImageView nvS;
    GameRoundImageView nvT;
    TextView nvU;
    GameFeedSubscriptView nvV;
    private int nvW = 0;
    private int nvX;

    public GameFeedImageTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.nvI = (GameFeedTitleDescView) findViewById(R.h.cmd);
        this.nvM = (GameRoundImageView) findViewById(R.h.bMY);
        this.nvQ = (LinearLayout) findViewById(R.h.cOU);
        this.nvR = (GameRoundImageView) findViewById(R.h.cii);
        this.nvS = (GameRoundImageView) findViewById(R.h.cKp);
        this.nvT = (GameRoundImageView) findViewById(R.h.cQW);
        this.nvU = (TextView) findViewById(R.h.cxt);
        this.nvV = (GameFeedSubscriptView) findViewById(R.h.cPJ);
        setOnClickListener(this);
        this.kJB = (c.getScreenWidth(getContext()) - getPaddingLeft()) - getPaddingRight();
        this.nvW = (this.kJB - (a.fromDPToPix(getContext(), 10) * 2)) / 3;
        this.nvX = a.fromDPToPix(getContext(), 105);
        if (this.nvW < this.nvX) {
            this.nvX = this.nvW;
        }
        LayoutParams layoutParams = this.nvR.getLayoutParams();
        layoutParams.width = this.nvX;
        layoutParams.height = this.nvX;
        this.nvR.setLayoutParams(layoutParams);
        this.nvS.setLayoutParams(layoutParams);
        this.nvT.setLayoutParams(layoutParams);
    }

    public void onClick(View view) {
        if (this.nrz != null && this.nrz.nhb != null && !bi.oN(this.nrz.nhb.nkN)) {
            ap.a(getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, this.nrz.position, c.ac(getContext(), this.nrz.nhb.nkN), this.nrz.nhb.nlV, GameIndexListView.aSh(), ap.M(this.nrz.nhb.nlr, "clickType", "card"));
        }
    }
}
