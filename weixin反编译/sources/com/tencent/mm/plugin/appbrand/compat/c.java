package com.tencent.mm.plugin.appbrand.compat;

import com.tencent.mapsdk.raster.model.CircleOptions;
import com.tencent.mapsdk.raster.model.LatLng;

final class c implements com.tencent.mm.plugin.appbrand.compat.a.b.c {
    final CircleOptions iPe = new CircleOptions();

    c() {
    }

    public final void d(double d, double d2) {
        this.iPe.center(new LatLng(d, d2));
    }

    public final void jL(int i) {
        this.iPe.radius((double) i);
    }

    public final void jM(int i) {
        this.iPe.strokeColor(i);
    }

    public final void jN(int i) {
        this.iPe.strokeWidth((float) i);
    }

    public final void jO(int i) {
        this.iPe.fillColor(i);
    }
}
