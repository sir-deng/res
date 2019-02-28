package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.view.View;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class b extends h {
    public b(View view, k kVar) {
        super(view, kVar);
        this.ueA.setVisibility(8);
        this.fwa.setVisibility(8);
        this.ueF.setVisibility(8);
        this.ueA.setOnClickListener(null);
    }

    public final void a(com.tencent.mm.plugin.wenote.model.a.b bVar, int i, int i2) {
        super.a(bVar, i, i2);
        if (bVar.getType() == -2 && this.ucQ.uaN == 3) {
            this.ueJ.setVisibility(0);
        }
    }

    public final int bYB() {
        return -2;
    }
}
