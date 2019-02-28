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
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.f;
import com.tencent.mm.sdk.platformtools.bi;

public class GameFeedNoGamePlayTemplate extends LinearLayout implements OnClickListener {
    ImageView kbb;
    GameDownloadView nrv;
    f nrz;
    GameRoundImageView nvM;
    ImageView nvN;
    GameFeedTitleDescView nvZ;
    FrameLayout nwa;
    RelativeLayout nwb;
    TextView nwc;

    public GameFeedNoGamePlayTemplate(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.nvZ = (GameFeedTitleDescView) findViewById(R.h.cmd);
        this.nwa = (FrameLayout) findViewById(R.h.cps);
        this.nvM = (GameRoundImageView) findViewById(R.h.bZt);
        this.nvN = (ImageView) findViewById(R.h.cVn);
        this.nwb = (RelativeLayout) findViewById(R.h.ckW);
        this.kbb = (ImageView) findViewById(R.h.cmn);
        this.nwc = (TextView) findViewById(R.h.cmX);
        this.nrv = (GameDownloadView) findViewById(R.h.cma);
        setOnClickListener(this);
        this.nwa.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (this.nrz != null && this.nrz.nhb != null && this.nrz.nhb.nmq != null) {
            if (view.getId() == R.h.cps && !bi.oN(this.nrz.nhb.nmq.nnl)) {
                ap.a(getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, this.nrz.position, c.ac(getContext(), this.nrz.nhb.nmq.nnl), this.nrz.nhb.nlV, GameIndexListView.aSh(), ap.M(this.nrz.nhb.nlr, "clickType", "middle"));
            } else if (!bi.oN(this.nrz.nhb.nkN)) {
                ap.a(getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, this.nrz.position, c.ac(getContext(), this.nrz.nhb.nkN), this.nrz.nhb.nlV, GameIndexListView.aSh(), ap.M(this.nrz.nhb.nlr, "clickType", "card"));
            }
        }
    }
}
