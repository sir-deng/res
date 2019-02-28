package com.tencent.mm.view;

import android.content.Context;
import com.tencent.mm.api.d;
import com.tencent.mm.api.m.a;

public final class c extends a {
    public c(Context context, a aVar) {
        super(context, aVar);
    }

    protected final com.tencent.mm.view.b.a cAT() {
        return new com.tencent.mm.view.b.c(getContext(), cBc());
    }

    protected final com.tencent.mm.view.footer.a cAU() {
        return new com.tencent.mm.view.footer.c(getContext(), cBc());
    }

    public final d[] cdR() {
        if (this.zMk == null) {
            this.zMk = new d[]{d.DOODLE, d.EMOJI, d.TEXT, d.CROP_VIDEO};
        }
        return this.zMk;
    }
}
