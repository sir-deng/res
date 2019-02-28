package com.tencent.mm.compatible.loader;

import android.app.Application;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class f {
    public static e a(Application application, String str) {
        try {
            e eVar = (e) ad.getContext().getClassLoader().loadClass(ad.cge() + str).newInstance();
            eVar.app = application;
            return eVar;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ProfileFactoryImpl", e, "", new Object[0]);
            return null;
        }
    }
}
