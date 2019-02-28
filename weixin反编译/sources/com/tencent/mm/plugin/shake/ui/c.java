package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;

final class c {
    al fia = new al(new a() {
        public final boolean uG() {
            c.this.bsT();
            return false;
        }
    }, false);
    View view;

    public c(View view) {
        this.view = view;
    }

    public final void bsT() {
        if (this.view != null) {
            this.view.setKeepScreenOn(false);
        }
    }
}
