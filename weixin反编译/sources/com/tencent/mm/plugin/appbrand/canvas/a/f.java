package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.canvas.g.a;
import org.json.JSONArray;

public final class f implements d {
    public final String getMethod() {
        return "drawImage";
    }

    public final boolean a(final com.tencent.mm.plugin.appbrand.canvas.f fVar, Canvas canvas, JSONArray jSONArray) {
        int length = jSONArray.length();
        if (length < 3) {
            return false;
        }
        String optString = jSONArray.optString(0);
        float d = com.tencent.mm.plugin.appbrand.q.f.d(jSONArray, 1);
        float d2 = com.tencent.mm.plugin.appbrand.q.f.d(jSONArray, 2);
        if (TextUtils.isEmpty(optString)) {
            return false;
        }
        float f;
        float f2;
        int optInt;
        int optInt2;
        int optInt3;
        Bitmap a;
        final com.tencent.mm.plugin.appbrand.canvas.f fVar2;
        float f3 = 0.0f;
        float f4 = 0.0f;
        if (length >= 5) {
            f3 = com.tencent.mm.plugin.appbrand.q.f.d(jSONArray, 3);
            f4 = com.tencent.mm.plugin.appbrand.q.f.d(jSONArray, 4);
            if (f3 == 0.0f || f4 == 0.0f) {
                return true;
            }
            if (f3 < 0.0f) {
                d += f3;
                f3 = -f3;
            }
            if (f4 < 0.0f) {
                d2 += f4;
                f = -f4;
                f2 = f3;
                f3 = d + f2;
                f4 = d2 + f;
                if (length < 9) {
                    optInt = jSONArray.optInt(5);
                    optInt2 = jSONArray.optInt(6);
                    length = jSONArray.optInt(7);
                    optInt3 = jSONArray.optInt(8);
                    if (length != 0 || optInt3 == 0) {
                        return true;
                    }
                    int i;
                    int i2;
                    if (length < 0) {
                        optInt += length;
                        i = -length;
                    } else {
                        i = length;
                    }
                    if (optInt3 < 0) {
                        optInt2 += optInt3;
                        i2 = -optInt3;
                    } else {
                        i2 = optInt3;
                    }
                    if (optInt + i <= 0 || optInt2 + i2 <= 0) {
                        return true;
                    }
                    int i3 = optInt > 0 ? optInt : 0;
                    optInt3 = optInt2 > 0 ? optInt2 : 0;
                    a = fVar.iNZ.a(fVar.gQA, optString, new Rect(i3, optInt3, optInt + i, optInt2 + i2), new a() {
                        public final void abC() {
                            fVar.invalidate();
                        }
                    });
                    if (a == null || a.isRecycled()) {
                        return false;
                    }
                    optInt = com.tencent.mm.plugin.appbrand.q.f.ma(optInt);
                    optInt2 = com.tencent.mm.plugin.appbrand.q.f.ma(optInt2);
                    i = com.tencent.mm.plugin.appbrand.q.f.ma(i);
                    i2 = com.tencent.mm.plugin.appbrand.q.f.ma(i2);
                    float f5 = f2 / ((float) i);
                    float f6 = f / ((float) i2);
                    d += ((float) (com.tencent.mm.plugin.appbrand.q.f.ma(i3) - optInt)) * f5;
                    d2 += ((float) (com.tencent.mm.plugin.appbrand.q.f.ma(optInt3) - optInt2)) * f6;
                    f3 = d + (((float) com.tencent.mm.plugin.appbrand.q.f.ma(a.getWidth())) * f5);
                    f4 = (((float) com.tencent.mm.plugin.appbrand.q.f.ma(a.getHeight())) * f6) + d2;
                } else {
                    fVar2 = fVar;
                    a = fVar.iNZ.a(fVar.gQA, optString, new a() {
                        public final void abC() {
                            fVar2.invalidate();
                        }
                    });
                    if (a != null || a.isRecycled()) {
                        return false;
                    }
                    if (f2 == 0.0f) {
                        f3 = ((float) com.tencent.mm.plugin.appbrand.q.f.ma(a.getWidth())) + d;
                    }
                    if (f == 0.0f) {
                        f4 = ((float) com.tencent.mm.plugin.appbrand.q.f.ma(a.getHeight())) + d2;
                    }
                }
                canvas.drawBitmap(a, new Rect(0, 0, a.getWidth(), a.getHeight()), new RectF(d, d2, f3, f4), fVar.iNU);
                return true;
            }
        }
        f = f4;
        f2 = f3;
        f3 = d + f2;
        f4 = d2 + f;
        if (length < 9) {
            fVar2 = fVar;
            a = fVar.iNZ.a(fVar.gQA, optString, /* anonymous class already generated */);
            if (a != null) {
            }
            return false;
        }
        optInt = jSONArray.optInt(5);
        optInt2 = jSONArray.optInt(6);
        length = jSONArray.optInt(7);
        optInt3 = jSONArray.optInt(8);
        if (length != 0) {
        }
        return true;
        canvas.drawBitmap(a, new Rect(0, 0, a.getWidth(), a.getHeight()), new RectF(d, d2, f3, f4), fVar.iNU);
        return true;
    }
}
