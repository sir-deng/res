package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.f;
import com.tencent.mm.sdk.platformtools.bi;

public class GameFeedAddTopicView extends LinearLayout implements OnClickListener {
    f nrz;
    GameFeedTitleDescView nvI;
    TextView nvJ;

    public GameFeedAddTopicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.nvI = (GameFeedTitleDescView) findViewById(R.h.cmd);
        this.nvJ = (TextView) findViewById(R.h.bJd);
        setOnClickListener(this);
    }

    public void onClick(View view) {
        if (this.nrz != null && this.nrz.nhb != null && !bi.oN(this.nrz.nhb.nkN)) {
            ap.a(getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, this.nrz.position, c.ac(getContext(), this.nrz.nhb.nkN), this.nrz.nhb.nlV, GameIndexListView.aSh(), ap.M(this.nrz.nhb.nlr, "clickType", "card"));
        }
    }
}
