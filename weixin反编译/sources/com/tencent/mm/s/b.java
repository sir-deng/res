package com.tencent.mm.s;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import com.tencent.mm.cb.a;

public final class b implements Cloneable {
    private static Paint gPm;
    private float gr = 1.0f;
    private float mA = ((float) a.aJ(5.0f));
    private Path mY;
    public int su;

    static {
        Paint paint = new Paint();
        gPm = paint;
        paint.setAntiAlias(true);
        gPm.setStyle(Style.STROKE);
        gPm.setStrokeCap(Cap.ROUND);
    }

    public b(Path path, float f, int i) {
        this.mY = path;
        this.gr = f;
        this.su = i;
    }

    public final void draw(Canvas canvas) {
        gPm.setColor(this.su);
        gPm.setStrokeWidth(this.mA * this.gr);
        if (!this.mY.isEmpty()) {
            canvas.drawPath(this.mY, gPm);
        }
    }
}
