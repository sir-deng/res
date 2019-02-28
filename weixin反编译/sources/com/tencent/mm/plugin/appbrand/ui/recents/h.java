package com.tencent.mm.plugin.appbrand.ui.recents;

import android.view.View;

abstract class h {
    a jWy;

    interface a {
        void a(h hVar, View view, boolean z);
    }

    abstract void amb();

    abstract View amc();

    abstract void onDetached();

    abstract void onResume();

    h() {
    }

    protected final void dn(boolean z) {
        if (amc() != null) {
            if (z) {
                if (amc().getVisibility() != 0) {
                    amc().setVisibility(0);
                }
            } else if (amc().getVisibility() != 8) {
                amc().setVisibility(8);
            }
            if (this.jWy != null) {
                this.jWy.a(this, amc(), z);
            }
        }
    }

    protected final boolean amg() {
        if (amc() != null && amc().getVisibility() == 0) {
            return true;
        }
        return false;
    }
}
