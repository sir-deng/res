package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.ArrayList;
import java.util.Iterator;

final class g {
    final boolean frK;

    g(boolean z) {
        this.frK = z;
    }

    final ArrayList<k> k(ArrayList<k> arrayList) {
        if (!this.frK || bi.cC(arrayList)) {
            return arrayList;
        }
        ArrayList<k> arrayList2 = new ArrayList(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            k kVar = (k) it.next();
            if (!kVar.iMQ) {
                arrayList2.add(kVar);
            }
        }
        return arrayList2;
    }
}
