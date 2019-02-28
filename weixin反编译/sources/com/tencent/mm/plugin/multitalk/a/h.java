package com.tencent.mm.plugin.multitalk.a;

import android.app.Activity;
import com.tencent.mm.R;
import com.tencent.mm.at.a;

public final class h {
    private boolean oMr;
    private boolean oMs;

    public final void y(Activity activity) {
        if (!this.oMr) {
            this.oMr = true;
            a.a(activity, R.l.ewJ, null);
        }
    }

    public final void z(Activity activity) {
        if (!this.oMs) {
            this.oMs = true;
            a.a(activity, R.l.eVS, null);
        }
    }

    public final void reset() {
        this.oMs = false;
        this.oMr = false;
    }
}
