package com.tencent.mm.plugin.appbrand.appcache.b;

import com.tencent.mm.ad.d.a;
import com.tencent.mm.ad.d.b;
import com.tencent.mm.cc.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public enum c implements l {
    ;

    private c(String str) {
    }

    public final b a(String str, Map<String, String> map, a aVar) {
        String str2 = (String) map.get(".sysmsg.WeAppSyncCommand.Base64JsonContent");
        if (!bi.oN(str2)) {
            g.cv(str2).j(new com.tencent.mm.vending.c.a<Void, String>() {
                public final /* synthetic */ Object call(Object obj) {
                    return qj((String) obj);
                }

                private Void qj(String str) {
                    try {
                        c.qi(str);
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.AppBrand.PredownloadXmlProcessor", e, "process pbBase64", new Object[0]);
                    }
                    return null;
                }
            });
        }
        return null;
    }
}
