package com.tencent.mm.plugin.address.b.b;

import android.app.Dialog;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;

public final class a implements e {
    private HashSet<k> iol;
    private HashSet<k> iom;
    private Dialog ion;

    public final void a(int i, int i2, String str, k kVar) {
        if (this.iom.contains(kVar)) {
            this.iom.remove(kVar);
            x.d("MicroMsg.InvoiceNetSceneMgr", "has find scene ");
        } else if (this.iol.contains(kVar)) {
            this.iol.remove(kVar);
            x.d("MicroMsg.InvoiceNetSceneMgr", "has find forcescenes ");
        }
        if (this.iom.isEmpty() && this.iol.isEmpty() && this.ion != null) {
            this.ion.dismiss();
            this.ion = null;
        }
    }
}
