package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.c.ag;
import com.tencent.mm.plugin.game.c.as;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.sdk.platformtools.bi;

public class GameFeedQipaiView extends LinearLayout implements OnClickListener {
    TextView jOY;
    TextView nwd;
    ImageView nwe;
    LinearLayout nwf;
    ag nwg;

    public GameFeedQipaiView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.jOY = (TextView) findViewById(R.h.title);
        this.nwd = (TextView) findViewById(R.h.cxq);
        this.nwe = (ImageView) findViewById(R.h.cxn);
        this.nwf = (LinearLayout) findViewById(R.h.cmv);
        this.nwd.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (this.nwg != null) {
            if (view.getId() != R.h.cxq) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue <= this.nwg.nmu.nlu.size() - 1) {
                    as asVar = (as) this.nwg.nmu.nlu.get(intValue);
                    if (!bi.oN(asVar.nkN)) {
                        ap.a(getContext(), 10, 1023, intValue + 1, c.ac(getContext(), asVar.nkN), asVar.nlV, GameIndexListView.aSh(), ap.CD(this.nwg.nlr));
                    }
                }
            } else if (!bi.oN(this.nwg.nmu.nna)) {
                ap.a(getContext(), 10, 1023, 999, c.ac(getContext(), this.nwg.nmu.nna), null, GameIndexListView.aSh(), ap.CD(this.nwg.nlr));
            }
        }
    }
}
