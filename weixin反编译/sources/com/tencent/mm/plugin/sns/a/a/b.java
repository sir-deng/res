package com.tencent.mm.plugin.sns.a.a;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

public final class b implements a {
    public final int bnr() {
        return 11855;
    }

    public final void c(Object... objArr) {
        h(0, objArr);
    }

    public final void h(int i, Object... objArr) {
        switch (i) {
            case 0:
            case 1:
                g.pWK.h(11855, objArr);
                return;
            case 2:
                g.pWK.h(14646, objArr);
                return;
            default:
                x.e("Kv_11855", "unknown type %d", Integer.valueOf(i));
                return;
        }
    }
}
