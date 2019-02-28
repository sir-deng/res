package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bu.a;
import com.tencent.mm.plugin.game.c.aa;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.f;
import com.tencent.mm.plugin.game.widget.AutoResizeTextView;
import com.tencent.mm.plugin.game.widget.GameTagListView;
import com.tencent.mm.sdk.platformtools.bi;

public class GameBestSellingItemView extends LinearLayout implements OnClickListener {
    AutoResizeTextView nrr;
    ImageView nrs;
    TextView nrt;
    GameTagListView nru;
    GameDownloadView nrv;
    View nrw;
    int nrx;
    aa nry;
    f nrz;

    public GameBestSellingItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.nrr = (AutoResizeTextView) findViewById(R.h.cmZ);
        this.nrs = (ImageView) findViewById(R.h.cmn);
        this.nrt = (TextView) findViewById(R.h.cmX);
        this.nru = (GameTagListView) findViewById(R.h.cQk);
        this.nrv = (GameDownloadView) findViewById(R.h.ckK);
        this.nrw = findViewById(R.h.cPb);
        this.nrx = c.getScreenWidth(getContext()) - a.fromDPToPix(getContext(), 190);
        setOnClickListener(this);
    }

    public void onClick(View view) {
        if (this.nry != null && !bi.oN(this.nry.nkO.nkQ)) {
            ap.a(getContext(), 10, 1022, this.nrz.nhc + 1, c.ac(getContext(), this.nry.nkO.nkQ), this.nry.nkO.nkU, GameIndexListView.aSh(), ap.CD(this.nrz.nhb.nlr));
        }
    }
}
