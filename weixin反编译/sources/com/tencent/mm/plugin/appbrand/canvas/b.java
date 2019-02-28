package com.tencent.mm.plugin.appbrand.canvas;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.sdk.platformtools.d;
import junit.framework.Assert;

final class b implements f {
    private int iNA;
    private int iNz;
    private int mHeight;
    private int mWidth;

    public b(int i, int i2, int i3, int i4) {
        boolean z = true;
        Assert.assertFalse(i3 == 0);
        if (i4 != 0) {
            z = false;
        }
        Assert.assertFalse(z);
        this.iNz = i;
        this.iNA = i2;
        this.mWidth = i3;
        this.mHeight = i4;
    }

    public final Bitmap k(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = this.iNz;
        int i2 = this.iNA;
        if (this.iNz < 0) {
            i = 0;
        } else if (this.iNz > width) {
            i = width;
        }
        if (this.iNA < 0) {
            i2 = 0;
        } else if (this.iNA > height) {
            i2 = height;
        }
        int i3 = (this.mWidth + this.iNz) - i;
        int i4 = (this.mHeight + this.iNA) - i2;
        if (i + i3 > width) {
            i3 = width - i;
        }
        if (i2 + i4 > height) {
            height -= i2;
        } else {
            height = i4;
        }
        if (i3 <= 0 || height <= 0) {
            return d.createBitmap(1, 1, Config.ARGB_8888);
        }
        Bitmap createBitmap = d.createBitmap(i3, height, Config.ARGB_8888);
        new Canvas(createBitmap).drawBitmap(bitmap, new Rect(i, i2, i + i3, i2 + height), new Rect(0, 0, i3, height), null);
        return createBitmap;
    }

    public final String Ju() {
        return String.format("Transformation_x%s_y%s_w%s_h%s", new Object[]{Integer.valueOf(this.iNz), Integer.valueOf(this.iNA), Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight)});
    }
}
