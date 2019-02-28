package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Map;

public final class f implements a {
    private static f iRm;
    public final Map<String, AppBrandInitConfig> iRn = new android.support.v4.e.a();
    public final Map<String, String> iRo = new android.support.v4.e.a();

    private f() {
    }

    public static void init() {
        synchronized (f.class) {
            iRm = new f();
            q.acp().c(iRm);
        }
    }

    public static void release() {
        synchronized (f.class) {
            iRm = null;
        }
    }

    public static f acm() {
        f fVar;
        synchronized (f.class) {
            fVar = iRm;
        }
        return fVar;
    }

    public final void a(String str, l lVar) {
        if ("single".equals(str)) {
            if (String.class.isInstance(lVar.obj)) {
                String valueOf = String.valueOf(lVar.obj);
                if (!bi.oN(valueOf)) {
                    ra(valueOf);
                }
            }
        } else if ("batch".equals(str)) {
            synchronized (this.iRn) {
                this.iRn.clear();
            }
        }
    }

    public final String qZ(String str) {
        if (bi.oN(str)) {
            return null;
        }
        String str2;
        synchronized (this.iRo) {
            str2 = (String) this.iRo.get(str);
        }
        return str2;
    }

    private AppBrandInitConfig ra(String str) {
        if (bi.oN(str)) {
            return null;
        }
        String str2;
        synchronized (this.iRo) {
            str2 = (String) this.iRo.get(str);
        }
        if (!bi.oN(str2)) {
            return rb(str2);
        }
        AppBrandInitConfig a = a(e.Zs().f(str, "appId", "appInfo", "brandIconURL", "nickname"));
        if (a == null) {
            return a;
        }
        synchronized (this.iRo) {
            this.iRo.put(str, a.appId);
        }
        return a;
    }

    public static AppBrandInitConfig a(WxaAttributes wxaAttributes) {
        if (wxaAttributes == null) {
            return null;
        }
        AppBrandInitConfig appBrandInitConfig = new AppBrandInitConfig();
        appBrandInitConfig.username = wxaAttributes.field_username;
        appBrandInitConfig.appId = wxaAttributes.field_appId;
        appBrandInitConfig.fsi = wxaAttributes.field_nickname;
        appBrandInitConfig.iconUrl = wxaAttributes.field_brandIconURL;
        appBrandInitConfig.foo = wxaAttributes.acq().hqv;
        appBrandInitConfig.iRc = wxaAttributes.acq().iSB > 0;
        return appBrandInitConfig;
    }

    public final AppBrandInitConfig rb(String str) {
        if (bi.oN(str)) {
            return null;
        }
        AppBrandInitConfig appBrandInitConfig;
        synchronized (this.iRn) {
            appBrandInitConfig = (AppBrandInitConfig) this.iRn.remove(str);
        }
        if (appBrandInitConfig != null) {
            return appBrandInitConfig;
        }
        return a(e.Zs().g(str, "appInfo", "brandIconURL", "nickname"));
    }
}
