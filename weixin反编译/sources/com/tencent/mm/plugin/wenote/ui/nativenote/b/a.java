package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public abstract class a extends t {
    protected k ucQ;

    public abstract void a(b bVar, int i, int i2);

    public abstract int bYB();

    public a(View view, k kVar) {
        super(view);
        this.ucQ = kVar;
    }
}
