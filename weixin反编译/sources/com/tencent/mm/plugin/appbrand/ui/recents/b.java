package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

final class b {
    View VU;
    ThreeDotsLoadingView jVr = ((ThreeDotsLoadingView) this.VU.findViewById(g.ctI));
    View jVs = this.VU.findViewById(g.iyi);
    View jVt = this.VU.findViewById(g.iyh);

    final void setLoading(boolean z) {
        if (z) {
            if (this.jVr != null) {
                this.jVr.setVisibility(0);
                this.jVr.czW();
            }
            if (this.jVt != null) {
                this.jVt.setVisibility(8);
                return;
            }
            return;
        }
        if (this.jVr != null) {
            this.jVr.ajR();
            this.jVr.setVisibility(8);
        }
        if (this.jVt != null) {
            this.jVt.setVisibility(0);
        }
    }

    b(Context context, ViewGroup viewGroup) {
        this.VU = LayoutInflater.from(context).inflate(h.izC, viewGroup, false);
    }
}
