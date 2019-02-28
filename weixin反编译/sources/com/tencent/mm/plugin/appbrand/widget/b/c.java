package com.tencent.mm.plugin.appbrand.widget.b;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;

public final class c implements Iterator<View> {
    private int jRZ = 0;
    private final ViewGroup kbR;

    public final /* synthetic */ Object next() {
        ViewGroup viewGroup = this.kbR;
        int i = this.jRZ;
        this.jRZ = i + 1;
        return viewGroup.getChildAt(i);
    }

    public c(ViewGroup viewGroup) {
        this.kbR = viewGroup;
    }

    public final boolean hasNext() {
        return this.jRZ < this.kbR.getChildCount();
    }

    public final void remove() {
        this.kbR.removeViewAt(this.jRZ - 1);
    }
}
