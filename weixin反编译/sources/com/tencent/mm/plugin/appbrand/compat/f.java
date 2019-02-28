package com.tencent.mm.plugin.appbrand.compat;

import com.tencent.mapsdk.raster.model.LatLng;

final class f implements com.tencent.mm.plugin.appbrand.compat.a.b.f {
    final LatLng iPp;

    public final double abS() {
        return this.iPp.getLatitude();
    }

    public final double abT() {
        return this.iPp.getLongitude();
    }

    f(double d, double d2) {
        this.iPp = new LatLng(d, d2);
    }

    f(LatLng latLng) {
        if (latLng != null) {
            this.iPp = latLng;
        } else {
            this.iPp = new LatLng(0.0d, 0.0d);
        }
    }

    static LatLng a(com.tencent.mm.plugin.appbrand.compat.a.b.f fVar) {
        if (fVar instanceof f) {
            return ((f) fVar).iPp;
        }
        return new LatLng(fVar.abS(), fVar.abT());
    }
}
