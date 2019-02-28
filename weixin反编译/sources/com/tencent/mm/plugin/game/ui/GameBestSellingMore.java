package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.f;
import com.tencent.mm.sdk.platformtools.bi;

public class GameBestSellingMore extends LinearLayout implements OnClickListener {
    TextView nrA;
    ImageView nrB;
    f nrz;

    public GameBestSellingMore(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.nrA = (TextView) findViewById(R.h.cxs);
        this.nrB = (ImageView) findViewById(R.h.cxr);
        setOnClickListener(this);
    }

    public void onClick(View view) {
        if (this.nrz != null && this.nrz.nhb != null && this.nrz.nhb.nmr != null && !bi.oN(this.nrz.nhb.nmr.nna)) {
            ap.a(getContext(), 10, 1022, 999, c.ac(getContext(), this.nrz.nhb.nmr.nna), null, GameIndexListView.aSh(), ap.CD(this.nrz.nhb.nlr));
        }
    }
}
