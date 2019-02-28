package com.tencent.mm.view;

import android.content.Context;
import com.tencent.mm.api.d;
import com.tencent.mm.api.m.a;

public final class b extends a {
    public b(Context context, a aVar) {
        super(context, aVar);
    }

    protected final com.tencent.mm.view.b.a cAT() {
        return new com.tencent.mm.view.b.b(getContext(), cBc());
    }

    protected final com.tencent.mm.view.footer.a cAU() {
        return new com.tencent.mm.view.footer.b(getContext(), cBc());
    }

    public final d[] cdR() {
        if (this.zMk == null) {
            this.zMk = new d[]{d.DOODLE, d.EMOJI, d.TEXT, d.MOSAIC, d.CROP_PHOTO};
        }
        return this.zMk;
    }
}
