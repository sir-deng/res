package com.tencent.mm.plugin.appbrand.compat;

import android.graphics.Bitmap;
import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.PolylineOptions;
import com.tencent.mm.plugin.appbrand.compat.a.b.f;
import com.tencent.mm.plugin.appbrand.compat.a.b.p;
import java.util.LinkedList;

final class i implements p {
    final PolylineOptions iPt = new PolylineOptions();

    i() {
    }

    public final void a(Iterable<f> iterable) {
        Iterable linkedList = new LinkedList();
        for (f fVar : iterable) {
            if (fVar instanceof f) {
                linkedList.add(((f) fVar).iPp);
            } else {
                linkedList.add(new LatLng(fVar.abS(), fVar.abT()));
            }
        }
        this.iPt.addAll(linkedList);
    }

    public final void jQ(int i) {
        this.iPt.color(i);
    }

    public final void jR(int i) {
        this.iPt.width((float) i);
    }

    public final void setDottedLine(boolean z) {
        this.iPt.setDottedLine(z);
    }

    public final void jS(int i) {
        this.iPt.edgeColor(i);
    }

    public final void jT(int i) {
        this.iPt.edgeWidth((float) i);
    }

    public final void q(Bitmap bitmap) {
        this.iPt.arrowTexture(new BitmapDescriptor(bitmap));
    }
}
