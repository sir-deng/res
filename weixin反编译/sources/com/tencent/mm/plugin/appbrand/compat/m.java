package com.tencent.mm.plugin.appbrand.compat;

import com.tencent.mapsdk.raster.model.Circle;
import com.tencent.mapsdk.raster.model.IOverlay;
import com.tencent.mapsdk.raster.model.Polyline;
import com.tencent.mm.plugin.appbrand.compat.a.b.d;
import com.tencent.mm.plugin.appbrand.compat.a.b.o;

abstract class m<T extends IOverlay> implements d {
    final T iPz;

    static final class b extends m<Polyline> implements o {
        b(Polyline polyline) {
            super(polyline);
        }
    }

    static final class a extends m<Circle> implements com.tencent.mm.plugin.appbrand.compat.a.b.b {
        a(Circle circle) {
            super(circle);
        }
    }

    m(T t) {
        this.iPz = t;
    }

    public final void remove() {
        if (this.iPz != null) {
            this.iPz.remove();
        }
    }

    public final String getId() {
        return this.iPz == null ? "" : this.iPz.getId();
    }
}
