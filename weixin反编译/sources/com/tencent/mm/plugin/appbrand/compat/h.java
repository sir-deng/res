package com.tencent.mm.plugin.appbrand.compat;

import android.graphics.Bitmap;
import android.view.View;
import android.view.animation.Animation;
import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.mm.plugin.appbrand.compat.a.b.i;

final class h implements i {
    final MarkerOptions iPs = new MarkerOptions();

    h() {
    }

    public final void f(double d, double d2) {
        this.iPs.position(new LatLng(d, d2));
    }

    public final void p(Bitmap bitmap) {
        this.iPs.icon(new BitmapDescriptor(bitmap));
    }

    public final void T(float f) {
        this.iPs.rotation(f);
    }

    public final void qS(String str) {
        this.iPs.title(str);
    }

    public final void qT(String str) {
        this.iPs.snippet(str);
    }

    public final void bD(View view) {
        this.iPs.markerView(view);
    }

    public final void U(float f) {
        this.iPs.alpha(f);
    }

    public final void p(float f, float f2) {
        this.iPs.anchor(f, f2);
    }

    public final void e(Animation animation) {
        this.iPs.infoWindowShowAnimation(animation);
    }

    public final void f(Animation animation) {
        this.iPs.infoWindowHideAnimation(animation);
    }
}
