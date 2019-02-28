package com.tencent.mm.plugin.appbrand.c;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class c {
    public HashMap<String, a> iOK = new HashMap();

    public final void a(a aVar) {
        if (aVar == null || bi.oN(aVar.fvn)) {
            x.e("MicroMsg.AppbrandMediaCdnItemManager", "item is null or local id is null, ignore this add");
            return;
        }
        x.i("MicroMsg.AppbrandMediaCdnItemManager", "add cdn item, local id : %s, file path : %s", aVar.fvn, aVar.iOz);
        this.iOK.put(aVar.fvn, aVar);
    }

    public final a qE(String str) {
        if (!bi.oN(str)) {
            return (a) this.iOK.get(str);
        }
        x.e("MicroMsg.AppbrandMediaCdnItemManager", "get by local id error, local id is null or nil");
        return null;
    }
}
