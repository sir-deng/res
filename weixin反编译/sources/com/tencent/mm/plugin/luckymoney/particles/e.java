package com.tencent.mm.plugin.luckymoney.particles;

import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.animation.Interpolator;

public final class e {
    private static final Paint okp;
    private static Interpolator okq;

    static {
        Paint paint = new Paint();
        okp = paint;
        paint.setStyle(Style.FILL);
    }

    public static Interpolator aXU() {
        if (okq == null) {
            okq = new Interpolator() {
                public final float getInterpolation(float f) {
                    return f >= 0.9f ? 1.0f - ((f - 0.9f) * 10.0f) : 1.0f;
                }
            };
        }
        return okq;
    }
}
