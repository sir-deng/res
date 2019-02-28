package com.tencent.mm.plugin.card.ui.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.c.oy;

public final class u extends i {
    private View lcG;

    public final void initView() {
    }

    public final void update() {
        if (this.lcG == null) {
            this.lcG = ((ViewStub) findViewById(R.h.bRC)).inflate();
        }
        b awp = this.lcl.awp();
        Context aws = this.lcl.aws();
        oy oyVar = awp.auj().vYq;
        if (this.lcG != null) {
            TextView textView = (TextView) this.lcG.findViewById(R.h.bRD);
            textView.setText(oyVar.title);
            textView.setTextColor(l.xu(awp.aui().hdx));
            TextView textView2 = (TextView) this.lcG.findViewById(R.h.bRB);
            LinearLayout linearLayout = (LinearLayout) this.lcG.findViewById(R.h.bSv);
            LayoutParams layoutParams = (LayoutParams) linearLayout.getLayoutParams();
            if (awp.atP()) {
                LayoutParams layoutParams2 = (LayoutParams) textView.getLayoutParams();
                if (TextUtils.isEmpty(oyVar.kPC)) {
                    textView2.setVisibility(8);
                    layoutParams.height = aws.getResources().getDimensionPixelOffset(R.f.bww);
                } else {
                    textView2.setText(oyVar.kPC);
                    textView2.setVisibility(0);
                    layoutParams.height = aws.getResources().getDimensionPixelOffset(R.f.bwv);
                    layoutParams2.bottomMargin = aws.getResources().getDimensionPixelSize(R.f.bup);
                    LayoutParams layoutParams3 = (LayoutParams) textView2.getLayoutParams();
                    layoutParams3.topMargin = aws.getResources().getDimensionPixelSize(R.f.bup);
                    textView2.setLayoutParams(layoutParams3);
                    textView2.invalidate();
                }
                layoutParams2.height = aws.getResources().getDimensionPixelSize(R.f.bwx);
                textView.setLayoutParams(layoutParams2);
                textView.invalidate();
                textView.setBackgroundDrawable(l.f(aws, awp.aui().hdx, aws.getResources().getDimensionPixelSize(R.f.bwz)));
                textView.setTextColor(l.U(aws, awp.aui().hdx));
                linearLayout.setBackgroundDrawable(null);
                textView.setOnClickListener(this.lcl.awt());
            } else {
                if (TextUtils.isEmpty(oyVar.kPC)) {
                    textView2.setVisibility(8);
                    layoutParams.height = aws.getResources().getDimensionPixelOffset(R.f.bwF);
                } else {
                    textView2.setText(oyVar.kPC);
                    textView2.setVisibility(0);
                    layoutParams.height = aws.getResources().getDimensionPixelOffset(R.f.bwE);
                }
                linearLayout.setOnClickListener(this.lcl.awt());
            }
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.invalidate();
            this.lcG.invalidate();
            if (awp.atP()) {
                linearLayout.getLayoutParams();
            }
        }
    }

    public final void axD() {
        if (this.lcG != null) {
            this.lcG.setVisibility(8);
        }
    }
}
