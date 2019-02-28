package com.tencent.mm.plugin.appbrand.widget.e;

import com.tencent.mm.plugin.appbrand.compat.a.b.f;

public final class g {
    public static double kiz = 6378137.0d;
    final double kiA = (6.283185307179586d * kiz);

    public final f c(f fVar) {
        double abT = (fVar.abT() / 360.0d) + 0.5d;
        double sin = Math.sin(Math.toRadians(fVar.abS()));
        return new f(abT * this.kiA, (((Math.log((1.0d + sin) / (1.0d - sin)) * 0.5d) / -6.283185307179586d) + 0.5d) * this.kiA);
    }
}
