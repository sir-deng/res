package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.z;

final class l extends z {
    private final LinearLayoutManager jWZ;
    private final int jXa = 3000;
    private final int jXb;

    l(Context context, LinearLayoutManager linearLayoutManager) {
        super(context);
        this.jWZ = linearLayoutManager;
        this.jXb = Math.round(((float) context.getResources().getDisplayMetrics().heightPixels) * 0.75f);
    }

    protected final int bg(int i) {
        return super.bg(Math.max(this.jXb, Math.min(this.jXa, i)));
    }

    public final PointF bd(int i) {
        return this.jWZ.bd(i);
    }
}
