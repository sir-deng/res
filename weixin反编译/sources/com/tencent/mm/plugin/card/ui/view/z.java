package com.tencent.mm.plugin.card.ui.view;

import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.protocal.c.oy;

public final class z extends i {
    private View lcV;

    public final void initView() {
    }

    public final void update() {
        if (this.lcV == null) {
            this.lcV = ((ViewStub) findViewById(R.h.bSj)).inflate();
        }
        oy oyVar = this.lcl.awp().auj().vYn;
        if (this.lcV != null) {
            ((TextView) this.lcV.findViewById(R.h.cQT)).setText(oyVar.title);
            ((TextView) this.lcV.findViewById(R.h.cQS)).setText(oyVar.kPB);
            int i = (this.lcl.awu().awW() && this.lcl.awu().awX()) ? 0 : 1;
            if (i != 0) {
                ((LayoutParams) ((LinearLayout) this.lcV).getLayoutParams()).bottomMargin = 0;
            } else {
                ((LayoutParams) ((LinearLayout) this.lcV).getLayoutParams()).bottomMargin = this.lcl.aws().getResources().getDimensionPixelSize(R.f.bvQ);
            }
        }
    }

    public final void axD() {
        if (this.lcV != null) {
            this.lcV.setVisibility(8);
        }
    }
}
