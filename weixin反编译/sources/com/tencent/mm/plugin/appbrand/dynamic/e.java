package com.tencent.mm.plugin.appbrand.dynamic;

import android.view.View;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class e {
    private static volatile e iVl;
    public Map<String, WeakReference<View>> iVm = new ConcurrentHashMap();

    private e() {
    }

    public static e acW() {
        if (iVl == null) {
            synchronized (e.class) {
                if (iVl == null) {
                    iVl = new e();
                }
            }
        }
        return iVl;
    }

    public final View rJ(String str) {
        if (bi.oN(str)) {
            x.w("MicroMsg.DynamicPageViewMgr", "get view from manager failed, key is null or nil.");
            return null;
        }
        WeakReference weakReference = (WeakReference) this.iVm.get(str);
        return weakReference != null ? (View) weakReference.get() : null;
    }
}
