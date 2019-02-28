package com.tencent.mm.plugin.webview.wepkg.model;

import android.os.Message;
import java.lang.ref.WeakReference;

public abstract class c {
    public final WeakReference<Object> tTc;

    public abstract void r(Message message);

    public c() {
        this.tTc = null;
    }

    public c(Object obj) {
        this.tTc = new WeakReference(obj);
    }
}
