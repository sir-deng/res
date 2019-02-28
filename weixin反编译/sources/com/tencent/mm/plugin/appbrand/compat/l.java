package com.tencent.mm.plugin.appbrand.compat;

import com.tencent.mapsdk.raster.model.VisibleRegion;
import com.tencent.mm.plugin.appbrand.compat.a.b.g;
import com.tencent.mm.plugin.appbrand.compat.a.b.r;

final class l implements r {
    final VisibleRegion iPy;

    l(VisibleRegion visibleRegion) {
        this.iPy = visibleRegion;
    }

    public final g abW() {
        return new e(this.iPy.getLatLngBounds());
    }
}
