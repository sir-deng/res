package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.p.d;
import com.tencent.mm.plugin.appbrand.page.p.e;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;

final class j implements d, e {
    final WeakReference<p> kcw;

    j(p pVar) {
        this.kcw = new WeakReference(pVar);
        pVar.a((d) this);
        pVar.a((e) this);
    }

    public final void afQ() {
        p pVar = (p) this.kcw.get();
        if (pVar != null) {
            m.n(pVar);
        }
    }

    public final void onDestroy() {
        p pVar = (p) this.kcw.get();
        if (pVar != null) {
            if (pVar.mContext instanceof MMActivity) {
                ((MMActivity) pVar.mContext).aWY();
            }
            m.n(pVar);
            m.p(pVar);
            pVar.b((d) this);
            pVar.b((e) this);
            if (pVar.jJw != null) {
                g.anh().n(pVar.jJw);
            }
        }
    }
}
