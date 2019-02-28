package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class i extends h {
    private ImageView ueR;
    private TextView ueS;

    public i(View view, k kVar) {
        super(view, kVar);
        this.ueA.setVisibility(8);
        this.fwa.setVisibility(8);
        this.ueF.setVisibility(8);
        this.ueA.setOnClickListener(null);
        this.ueR = (ImageView) view.findViewById(R.h.cBb);
        this.ueS = (TextView) view.findViewById(R.h.cBd);
    }

    public final void a(b bVar, int i, int i2) {
        super.a(bVar, i, i2);
        if (bVar.getType() == -4) {
            this.ueI.setVisibility(0);
        }
    }

    public final int bYB() {
        return -4;
    }
}
