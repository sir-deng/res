package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Point;
import android.util.DisplayMetrics;
import com.tencent.mm.R;
import com.tencent.mm.plugin.scanner.ui.i.b;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.plugin.scanner.util.k;

public final class l extends c {
    public l(b bVar, Point point, DisplayMetrics displayMetrics, int i) {
        super(bVar, point, displayMetrics, i);
    }

    protected final float bpq() {
        return 1.467f;
    }

    protected final String bpr() {
        return "driving";
    }

    protected final int bps() {
        return R.l.eHG;
    }

    protected final com.tencent.mm.plugin.scanner.util.b a(a aVar) {
        return new k(aVar, 2);
    }
}
