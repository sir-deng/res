package com.tencent.mm.plugin.appbrand.menu;

import android.app.Activity;
import android.content.Context;
import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.d;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.n;

public final class g extends a {
    public g() {
        super(m.jGp - 1);
    }

    public final void a(Context context, p pVar, n nVar, String str) {
        if (b.cfx()) {
            nVar.a(this.jGz, context.getResources().getColor(d.btD), context.getString(j.iAY));
        }
    }

    public final void a(Context context, p pVar, String str, l lVar) {
        c.a(str, c.c.CLOSE);
        if (context instanceof Activity) {
            ((Activity) context).finish();
            com.tencent.mm.plugin.appbrand.report.a.a(str, pVar.getURL(), 10, "", bi.Wx(), 1, 0);
        }
    }
}
