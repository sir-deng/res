package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class yp extends c {
    private final int height = 108;
    private final int width = 108;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 108;
            case 1:
                return 108;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix f = c.f(looper);
                float[] e = c.e(looper);
                Paint i2 = c.i(looper);
                i2.setFlags(385);
                i2.setStyle(Style.FILL);
                Paint i3 = c.i(looper);
                i3.setFlags(385);
                i3.setStyle(Style.STROKE);
                i2.setColor(WebView.NIGHT_MODE_COLOR);
                i3.setStrokeWidth(1.0f);
                i3.setStrokeCap(Cap.BUTT);
                i3.setStrokeJoin(Join.MITER);
                i3.setStrokeMiter(4.0f);
                i3.setPathEffect(null);
                c.a(i3, looper).setStrokeWidth(1.0f);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-10526881);
                e = c.a(e, 1.0f, 0.0f, 24.0f, 0.0f, 1.0f, 22.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(24.65f, 2.6f);
                j.cubicTo(26.6f, 1.63f, 28.53f, -0.07f, 30.83f, 0.24f);
                j.cubicTo(34.52f, 1.64f, 37.71f, 4.06f, 41.19f, 5.9f);
                j.cubicTo(46.18f, 8.92f, 51.48f, 11.45f, 56.19f, 14.91f);
                j.cubicTo(49.38f, 19.33f, 42.13f, 23.02f, 35.17f, 27.19f);
                j.cubicTo(32.84f, 28.55f, 29.97f, 30.55f, 27.35f, 28.58f);
                j.cubicTo(19.46f, 24.03f, 11.45f, 19.69f, 3.7f, 14.9f);
                j.cubicTo(10.35f, 10.26f, 17.73f, 6.81f, 24.65f, 2.6f);
                j.lineTo(24.65f, 2.6f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(0.99f, 28.06f);
                j.cubicTo(1.05f, 25.01f, 0.57f, 21.82f, 1.79f, 18.92f);
                j.cubicTo(9.33f, 23.15f, 16.81f, 27.48f, 24.35f, 31.7f);
                j.cubicTo(25.93f, 32.64f, 27.98f, 33.75f, 27.91f, 35.89f);
                j.cubicTo(28.19f, 45.13f, 27.84f, 54.39f, 28.06f, 63.64f);
                j.cubicTo(26.35f, 63.37f, 24.73f, 62.73f, 23.27f, 61.82f);
                j.cubicTo(16.94f, 58.09f, 10.53f, 54.5f, 4.16f, 50.85f);
                j.cubicTo(2.78f, 50.0f, 1.06f, 48.96f, 1.1f, 47.1f);
                j.cubicTo(0.81f, 40.76f, 1.11f, 34.4f, 0.99f, 28.06f);
                j.lineTo(0.99f, 28.06f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(35.06f, 32.12f);
                j.cubicTo(42.82f, 27.72f, 50.58f, 23.31f, 58.34f, 18.9f);
                j.cubicTo(59.57f, 22.83f, 58.82f, 26.99f, 59.0f, 31.03f);
                j.cubicTo(58.91f, 36.38f, 59.19f, 41.74f, 58.91f, 47.09f);
                j.cubicTo(58.94f, 49.23f, 56.94f, 50.4f, 55.34f, 51.35f);
                j.cubicTo(49.14f, 54.84f, 42.9f, 58.25f, 36.77f, 61.85f);
                j.cubicTo(35.28f, 62.74f, 33.65f, 63.37f, 31.94f, 63.63f);
                j.cubicTo(32.16f, 54.38f, 31.82f, 45.12f, 32.09f, 35.88f);
                j.cubicTo(32.03f, 34.04f, 33.68f, 32.96f, 35.06f, 32.12f);
                j.lineTo(35.06f, 32.12f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
