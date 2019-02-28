package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.plugin.game.ui.s.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public class GameRankFooter extends LinearLayout {
    private Context mContext;
    private boolean mHasInit = false;
    TextView nzR;
    private View nzS;
    private TextView nzT;
    private ImageView nzU;
    private TextView nzV;
    private TextView nzW;

    public GameRankFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        if (!this.mHasInit) {
            init();
            this.mHasInit = true;
        }
    }

    public final void aSr() {
        this.nzR.setVisibility(0);
    }

    public final void aSs() {
        this.nzR.setVisibility(8);
    }

    public final void a(a aVar) {
        if (this.mHasInit && this.nzS.getVisibility() != 0) {
            this.nzS.setVisibility(0);
            as.Hm();
            ag Xv = c.Ff().Xv(aVar.fEx);
            if (Xv != null) {
                b.a(this.nzU, Xv.field_username);
                this.nzV.setText(i.b(this.mContext, Xv.AX(), this.nzV.getTextSize()));
            }
            this.nzT.setText(aVar.njg);
            this.nzW.setText(bi.formatNumber(aVar.mRP));
        }
    }

    public final void aSt() {
        if (this.nzS != null && this.nzS.getVisibility() != 8) {
            this.nzS.setVisibility(8);
        }
    }

    private void init() {
        this.nzR = (TextView) findViewById(R.h.cts);
        this.nzS = findViewById(R.h.cyD);
        this.nzT = (TextView) findViewById(R.h.cFt);
        this.nzU = (ImageView) findViewById(R.h.cUo);
        this.nzV = (TextView) findViewById(R.h.cUq);
        this.nzW = (TextView) findViewById(R.h.cUu);
    }
}
