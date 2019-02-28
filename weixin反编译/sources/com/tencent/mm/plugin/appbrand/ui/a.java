package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import com.tencent.mm.ui.base.i;

public final class a extends com.tencent.mm.ui.base.i.a {
    private boolean jPU = false;

    public a(Context context) {
        super(context);
        if (context instanceof Activity) {
            this.jPU = j.c(((Activity) context).getWindow());
        }
    }

    public final i ale() {
        i ale = super.ale();
        j.a(ale.getWindow(), this.jPU);
        return ale;
    }
}
