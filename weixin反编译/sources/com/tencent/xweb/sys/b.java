package com.tencent.xweb.sys;

import android.content.Context;
import android.webkit.CookieSyncManager;

public final class b implements com.tencent.xweb.c.b.b {
    CookieSyncManager AAn;

    public final void init(Context context) {
        this.AAn = CookieSyncManager.createInstance(context);
    }

    public final void sync() {
        if (this.AAn != null) {
            this.AAn.sync();
        }
    }
}
