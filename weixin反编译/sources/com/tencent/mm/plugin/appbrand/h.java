package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.WeakHashMap;

public class h {
    private static final WeakHashMap<e, h> itY = new WeakHashMap();
    private static final h itZ = new h() {
        public final AppBrandLaunchReferrer YU() {
            return null;
        }
    };
    private final e iua;
    public volatile String iub;

    /* synthetic */ h(e eVar, byte b) {
        this(null);
    }

    public static h e(e eVar) {
        if (eVar == null || bi.oN(eVar.mAppId)) {
            return itZ;
        }
        h hVar;
        synchronized (itY) {
            hVar = (h) itY.get(eVar);
            if (hVar == null) {
                hVar = new h(eVar);
                itY.put(eVar, hVar);
            }
        }
        return hVar;
    }

    public static h pA(String str) {
        if (bi.oN(str)) {
            return itZ;
        }
        return e(a.pi(str));
    }

    private h(e eVar) {
        this.iub = "";
        this.iua = eVar;
    }

    public AppBrandLaunchReferrer YU() {
        return this.iua.isR.iRl;
    }
}
