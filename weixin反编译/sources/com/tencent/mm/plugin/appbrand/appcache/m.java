package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.config.WxaAttributes.e;
import com.tencent.mm.sdk.platformtools.bi;
import java.io.Closeable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class m implements Closeable {
    private final WxaPkgWrappingInfo iGX;
    private final Map<String, ag> iGY = new HashMap();

    m(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        this.iGX = wxaPkgWrappingInfo;
        this.iGX.aaB();
    }

    final ag pT(String str) {
        if (bi.oN(str)) {
            return null;
        }
        String str2;
        String pQ = a.pQ(str);
        if (pQ.startsWith("__APP__")) {
            str2 = "__APP__";
        } else {
            Iterator it = this.iGX.iJe.iterator();
            while (it.hasNext()) {
                ModulePkgInfo modulePkgInfo = (ModulePkgInfo) it.next();
                if (pQ.startsWith(modulePkgInfo.name)) {
                    str2 = modulePkgInfo.name;
                    break;
                }
            }
            str2 = null;
            if (bi.oN(str2)) {
                str2 = "__APP__";
            }
        }
        return pU(str2);
    }

    final void ZV() {
        synchronized (this.iGY) {
            pU("__APP__");
            Iterator it = this.iGX.iJe.iterator();
            while (it.hasNext()) {
                pU(((e) it.next()).name);
            }
        }
    }

    final ag pU(String str) {
        ag agVar;
        synchronized (this.iGY) {
            agVar = (ag) this.iGY.get(str);
            if (agVar != null) {
            } else {
                String str2;
                if ("__APP__".equals(str)) {
                    str2 = this.iGX.iGz;
                } else {
                    Iterator it = this.iGX.iJe.iterator();
                    while (it.hasNext()) {
                        ModulePkgInfo modulePkgInfo = (ModulePkgInfo) it.next();
                        if (str.equals(modulePkgInfo.name)) {
                            str2 = modulePkgInfo.iGz;
                            break;
                        }
                    }
                    str2 = null;
                }
                if (bi.oN(str2)) {
                } else {
                    agVar = new ag(str2);
                    this.iGY.put(str, agVar);
                }
            }
        }
        if (agVar != null) {
            agVar.aai();
        }
        return agVar;
    }

    public final void close() {
        synchronized (this.iGY) {
            Collection<ag> values = this.iGY.values();
        }
        for (ag close : values) {
            close.close();
        }
    }
}
