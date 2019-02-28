package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.protocal.c.li;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public final class f implements e {
    private final String TAG = "MicroMsg.F2fGetPayUrlManager";
    public Map<l, a> gLL = new HashMap();

    public interface a {
        void a(boolean z, li liVar);

        void ch(String str, String str2);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof l) {
            l lVar = (l) kVar;
            a aVar = (a) this.gLL.get(kVar);
            if (aVar == null) {
                x.w("MicroMsg.F2fGetPayUrlManager", "no match callback");
                return;
            }
            if (i == 0 && i2 == 0) {
                aVar.a(true, lVar.los);
            } else {
                x.e("MicroMsg.F2fGetPayUrlManager", "net error: %s", lVar);
                aVar.a(false, null);
            }
            this.gLL.remove(kVar);
        }
    }
}
