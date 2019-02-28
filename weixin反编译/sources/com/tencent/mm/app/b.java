package com.tencent.mm.app;

import android.graphics.Bitmap;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.ac.n;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.sdk.platformtools.ad;

final class b implements a {
    private Bitmap feZ;
    d ffa;

    public b() {
        this.feZ = null;
        this.feZ = com.tencent.mm.compatible.g.a.decodeResource(ad.getContext().getResources(), R.k.bBC);
    }

    public final void a(j jVar) {
        if (jVar instanceof d.a) {
            n.JF().a((d.a) jVar);
        }
    }

    public final Bitmap cm(String str) {
        return com.tencent.mm.ac.b.a(str, false, -1);
    }

    public final Bitmap tK() {
        return this.feZ;
    }

    public final Bitmap cn(String str) {
        if (this.ffa == null) {
            this.ffa = n.JF();
        }
        return d.jf(str);
    }

    public final Bitmap b(String str, int i, int i2, int i3) {
        return com.tencent.mm.ac.b.c(str, i, i2, i3);
    }
}
