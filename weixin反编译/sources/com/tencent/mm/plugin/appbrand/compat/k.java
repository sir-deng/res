package com.tencent.mm.plugin.appbrand.compat;

import android.content.Context;
import android.view.View;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.compat.a.b;
import com.tencent.mm.plugin.appbrand.compat.a.b.a;
import com.tencent.mm.plugin.appbrand.compat.a.b.f;
import com.tencent.mm.plugin.appbrand.compat.a.c;

final class k implements c {
    k() {
    }

    static f d(final LatLng latLng) {
        return new f() {
            public final double abS() {
                return latLng.getLatitude();
            }

            public final double abT() {
                return latLng.getLongitude();
            }

            public final String toString() {
                return "lat/lng: (" + latLng.getLatitude() + "," + latLng.getLongitude() + ")";
            }
        };
    }

    static a d(final CameraPosition cameraPosition) {
        return new a() {
        };
    }

    public final b bP(Context context) {
        return new d(context);
    }

    public final b bQ(Context context) {
        return new d(context, (byte) 0);
    }

    public final b bE(View view) {
        return view == null ? null : (b) view.getTag(R.h.bKs);
    }

    public final f e(double d, double d2) {
        return new f(d, d2);
    }
}
