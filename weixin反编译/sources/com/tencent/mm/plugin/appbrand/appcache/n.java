package com.tencent.mm.plugin.appbrand.appcache;

import android.net.Uri;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class n {
    public static void ZW() {
        e.post(new Runnable() {
            public final void run() {
                try {
                    String str;
                    String str2 = AppBrandGlobalSystemConfig.aci().iQz;
                    if (bi.oN(str2)) {
                        str = "res.servicewechat.com";
                    } else {
                        str2 = Uri.parse(str2).getHost();
                        str = bi.oN(str2) ? "res.servicewechat.com" : str2;
                    }
                    Object arrayList = new ArrayList();
                    g.Dp().gRu.hoF.getHostByName(str, arrayList);
                    CdnLogic.triggerPreConnect(str, (String[]) arrayList.toArray(new String[0]), true);
                    x.i("MicroMsg.PkgNetworkOpt", "triggerPreConnect, host %s", str);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.PkgNetworkOpt", e, "triggerPreConnect", new Object[0]);
                }
            }
        }, "PkgNetworkOpt.triggerPreConnect");
    }
}
