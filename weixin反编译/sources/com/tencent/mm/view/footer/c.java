package com.tencent.mm.view.footer;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mm.bi.a.g;
import com.tencent.mm.bn.b;
import com.tencent.mm.sdk.platformtools.d;

public final class c extends a {
    private Bitmap zOX;
    private Bitmap zOY;

    protected final void cBq() {
        super.cBq();
        this.zOX = d.u(getResources().getDrawable(g.viu));
        this.zOY = d.u(getResources().getDrawable(g.vit));
    }

    protected final Bitmap a(com.tencent.mm.api.d dVar, boolean z) {
        if (dVar == com.tencent.mm.api.d.CROP_VIDEO) {
            return z ? this.zOY : this.zOX;
        } else {
            return null;
        }
    }

    public c(Context context, b bVar) {
        super(context, bVar);
    }

    protected final boolean HM(int i) {
        boolean HM = super.HM(i);
        switch (HL(i)) {
            case CROP_VIDEO:
                return false;
            default:
                return HM;
        }
    }
}
