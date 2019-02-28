package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.sdk.platformtools.ad;

public final class s implements com.tencent.mm.plugin.appbrand.widget.d.a {
    private int kdW = 0;
    private final Rect kdX = new Rect();
    private boolean kdY = false;
    private View kdZ;
    a kea;

    interface a {
        void dA(boolean z);

        int getHeight();

        void mp(int i);
    }

    private void getWindowVisibleDisplayFrame(Rect rect) {
        if (this.kdZ != null) {
            this.kdZ.getWindowVisibleDisplayFrame(rect);
        }
    }

    private Context getContext() {
        return this.kdZ == null ? ad.getContext() : this.kdZ.getContext();
    }

    private int anw() {
        if ((this.kdZ == null ? null : this.kdZ.getRootView()) == null) {
            return 0;
        }
        Rect rect = this.kdX;
        getWindowVisibleDisplayFrame(rect);
        return getContext().getResources().getDisplayMetrics().heightPixels - rect.top;
    }

    public final void bV(View view) {
        boolean p;
        Object obj = 1;
        this.kdZ = view;
        Rect rect = this.kdX;
        getWindowVisibleDisplayFrame(rect);
        int height = rect.height();
        if (this.kdW == 0) {
            this.kdW = height;
        } else {
            int anw = anw() - height;
            if (anw > 0) {
                if (j.aQ(getContext()) != anw) {
                    p = j.p(getContext(), anw);
                } else {
                    p = false;
                }
                if (!(!p || this.kea == null || this.kea.getHeight() == anw)) {
                    this.kea.mp(anw);
                }
            }
        }
        if (anw() > height) {
            p = true;
        } else {
            p = false;
        }
        if (this.kdY == p) {
            obj = null;
        }
        if (!(obj == null || this.kea == null)) {
            this.kea.dA(p);
        }
        this.kdY = p;
        this.kdW = height;
        this.kdZ = null;
    }
}
