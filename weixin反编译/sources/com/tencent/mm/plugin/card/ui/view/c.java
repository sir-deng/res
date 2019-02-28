package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.base.b;

public final class c extends i {
    private View lbY;
    private TextView lbZ;

    public final void initView() {
    }

    public final void update() {
        if (this.lbY == null) {
            this.lbY = ((ViewStub) findViewById(R.h.bPC)).inflate();
            this.lbZ = (TextView) this.lbY.findViewById(R.h.bPD);
        }
        this.lbY.setVisibility(0);
        this.lbY.setOnClickListener(this.lcl.awt());
        b awp = this.lcl.awp();
        if (TextUtils.isEmpty(awp.aui().vZe.wgf)) {
            this.lbZ.setText(getString(R.l.dOT));
        } else {
            this.lbZ.setText(awp.aui().vZe.wgf);
        }
    }

    public final void axD() {
        if (this.lbY != null) {
            this.lbY.setVisibility(8);
        }
    }
}
