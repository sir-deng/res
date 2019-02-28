package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.permission.c;
import com.tencent.mm.plugin.appbrand.report.a.f;
import java.util.HashMap;

public final class h {
    final HashMap<Integer, a> jfr = new HashMap();

    private static class a {
        String data;
        c jfs;
        b jft;
        String path;
        long startTime;

        a(c cVar, b bVar, String str, long j, String str2) {
            this.jfs = cVar;
            this.jft = bVar;
            this.data = str;
            this.startTime = j;
            this.path = str2;
        }
    }

    h() {
    }

    public final void H(int i, String str) {
        a aVar = (a) this.jfr.remove(Integer.valueOf(i));
        if (aVar != null) {
            f.a(aVar.jfs.getAppId(), aVar.path, aVar.jft.getName(), aVar.data, c.a(aVar.jfs, aVar.jft), System.currentTimeMillis() - aVar.startTime, str);
            this.jfr.remove(Integer.valueOf(i));
        }
    }
}
