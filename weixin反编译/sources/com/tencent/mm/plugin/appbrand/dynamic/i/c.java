package com.tencent.mm.plugin.appbrand.dynamic.i;

import android.text.TextUtils;
import com.tencent.mm.plugin.report.service.g;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class c implements a {
    private String appId;
    private String iVa;
    private String iYb;
    private Map<String, Integer> iYc = new HashMap();

    public c(String str, String str2) {
        this.appId = str;
        this.iVa = str2;
        this.iYb = this.iVa + "-" + this.appId;
    }

    public final void rS(String str) {
        if (!TextUtils.isEmpty(str)) {
            Integer num = (Integer) this.iYc.get(str);
            if (num == null) {
                num = Integer.valueOf(0);
            }
            this.iYc.put(str, Integer.valueOf(num.intValue() + 1));
        }
    }

    public final void xd() {
        for (Entry entry : this.iYc.entrySet()) {
            g.pWK.h(14705, entry.getKey(), entry.getValue(), this.iYb, this.iVa, this.appId);
        }
        this.iYc.clear();
    }
}
