package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.k;

public abstract class b extends k {
    private int ueo;

    public abstract void bYA();

    public abstract void bYy();

    public abstract void bYz();

    public final void c(RecyclerView recyclerView, int i, int i2) {
        if ((Math.abs(i2) > this.ueo ? 1 : 0) != 0 && recyclerView.canScrollVertically(-1)) {
            if (!recyclerView.canScrollVertically(1)) {
                bYA();
            } else if (i2 < 0) {
                bYy();
            } else if (i2 > 0) {
                bYz();
            }
        }
    }
}
