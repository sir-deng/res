package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bu.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ac;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.f;
import com.tencent.mm.plugin.game.widget.GameTagListView;
import com.tencent.mm.sdk.platformtools.bi;

public class GameFeedGameTemplateView extends LinearLayout implements OnClickListener {
    TextView lpZ;
    int nrx;
    f nrz;
    ImageView nut;
    TextView nuu;
    GameTagListView nvK;
    FrameLayout nvL;
    GameRoundImageView nvM;
    ImageView nvN;
    GameFeedSubscriptView nvO;
    GameDownloadView nvP;

    public GameFeedGameTemplateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.nut = (ImageView) findViewById(R.h.cmn);
        this.nuu = (TextView) findViewById(R.h.cmX);
        this.nvK = (GameTagListView) findViewById(R.h.cnq);
        this.lpZ = (TextView) findViewById(R.h.caR);
        this.nvL = (FrameLayout) findViewById(R.h.cVk);
        this.nvM = (GameRoundImageView) findViewById(R.h.image);
        this.nvN = (ImageView) findViewById(R.h.cVn);
        this.nvO = (GameFeedSubscriptView) findViewById(R.h.cPJ);
        this.nvP = (GameDownloadView) findViewById(R.h.cma);
        setOnClickListener(this);
        this.nrx = c.getScreenWidth(getContext()) - a.fromDPToPix(getContext(), ac.CTRL_BYTE);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void onClick(View view) {
        if (this.nrz != null && this.nrz.nhb != null) {
            if (view.getId() == R.h.cVk && !bi.oN(this.nrz.nhb.nmp.nnk)) {
                ap.a(getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, this.nrz.position, c.ac(getContext(), this.nrz.nhb.nmp.nnk), this.nrz.nhb.nlV, GameIndexListView.aSh(), ap.M(this.nrz.nhb.nlr, "clickType", "middle"));
            } else if (!bi.oN(this.nrz.nhb.nkN)) {
                ap.a(getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, this.nrz.position, c.ac(getContext(), this.nrz.nhb.nkN), this.nrz.nhb.nlV, GameIndexListView.aSh(), ap.M(this.nrz.nhb.nlr, "clickType", "card"));
            }
        }
    }

    final void b(ImageView imageView, String str) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.f.bvj);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.f.bvi);
        e.aSC().a(imageView, str, dimensionPixelSize, dimensionPixelSize2, (c.getScreenWidth(getContext()) - getPaddingLeft()) - getPaddingRight());
    }
}
