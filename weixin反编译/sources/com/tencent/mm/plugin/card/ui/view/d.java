package com.tencent.mm.plugin.card.ui.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.base.b;

public final class d extends i {
    private TextView kTW;
    private View lca;
    private TextView lcb;
    private TextView lcc;

    public final void initView() {
        this.lca = findViewById(R.h.bJB);
        this.lcb = (TextView) findViewById(R.h.bJC);
        this.kTW = (TextView) findViewById(R.h.cNR);
        this.lcc = (TextView) findViewById(R.h.bRM);
        this.lcb.setOnClickListener(this.lcl.awt());
        this.lca.setVisibility(8);
    }

    public final void update() {
        b awp = this.lcl.awp();
        Context aws = this.lcl.aws();
        this.lca.setVisibility(0);
        if (TextUtils.isEmpty(awp.aui().vYX)) {
            this.lcb.setVisibility(8);
        } else {
            this.lcb.setVisibility(0);
            this.lcb.setText(awp.aui().vYX);
            if (awp.atO() || (awp.atN() && awp.atQ())) {
                this.lcb.setTextColor(aws.getResources().getColor(R.e.white));
            } else if (awp.atN() && awp.atP()) {
                this.lcb.setTextColor(aws.getResources().getColor(R.e.brH));
                this.lca.setBackgroundColor(aws.getResources().getColor(R.e.brI));
            } else {
                this.lcb.setTextColor(aws.getResources().getColor(R.e.white));
            }
        }
        View findViewById = this.lca.findViewById(R.h.bRZ);
        if (this.lcl.awu().axA()) {
            findViewById.setVisibility(0);
            this.lcc.setText(aws.getString(R.l.dPt));
            this.lcc.setTextColor(aws.getResources().getColor(R.e.white));
            int dimensionPixelOffset = aws.getResources().getDimensionPixelOffset(R.f.bvK);
            Button button = (Button) this.lca.findViewById(R.h.bRK);
            Drawable d = l.d(aws, aws.getResources().getColor(R.e.white), dimensionPixelOffset);
            Drawable cm = l.cm(aws.getResources().getColor(R.e.white), dimensionPixelOffset);
            Drawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, cm);
            stateListDrawable.addState(new int[0], d);
            button.setBackgroundDrawable(stateListDrawable);
            int[] iArr = new int[]{l.xu(awp.aui().hdx), aws.getResources().getColor(R.e.white)};
            button.setTextColor(new ColorStateList(new int[][]{new int[]{16842919, 16842910}, new int[0]}, iArr));
            button.setOnClickListener(this.lcl.awt());
            findViewById = this.lca.findViewById(R.h.cwb);
            View findViewById2 = this.lca.findViewById(R.h.bQY);
            if (awp.aui().vZl == 1) {
                findViewById.setVisibility(0);
                findViewById2.setVisibility(0);
                return;
            }
            findViewById.setVisibility(8);
            findViewById2.setVisibility(8);
            return;
        }
        findViewById.setVisibility(8);
    }

    public final void axD() {
        this.lca.setVisibility(8);
    }

    public final void xk(String str) {
        this.lcc.setText(str);
    }
}
