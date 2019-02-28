package com.tencent.mm.plugin.card.ui.view;

import android.view.View;
import com.tencent.mm.plugin.card.ui.n;

public abstract class i {
    n lcl;

    public abstract void initView();

    public final void a(n nVar) {
        this.lcl = nVar;
        initView();
    }

    public void destroy() {
        this.lcl = null;
    }

    public void update() {
    }

    public void axD() {
    }

    protected final View findViewById(int i) {
        return this.lcl.findViewById(i);
    }

    protected final String getString(int i) {
        return this.lcl.getString(i);
    }
}
