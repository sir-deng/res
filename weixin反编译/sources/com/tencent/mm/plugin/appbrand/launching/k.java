package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.protocal.c.aja;

public interface k {

    public static class a {
        static k g(String str, String str2, int i, int i2) {
            if (com.tencent.mm.plugin.appbrand.appcache.d.a.jy(i)) {
                return new q(str, str2, i2);
            }
            return new r(str, str2, i);
        }
    }

    public interface b {
        void b(WxaPkgWrappingInfo wxaPkgWrappingInfo);
    }

    public interface c extends b {
        void a(com.tencent.mm.ad.a.a<aja> aVar);
    }

    void a(b bVar);

    void prepareAsync();
}
