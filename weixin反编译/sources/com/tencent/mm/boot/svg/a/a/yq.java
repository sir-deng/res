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

public final class yq extends c {
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
                a.setColor(-12632257);
                e = c.a(e, 1.0f, 0.0f, 24.0f, 0.0f, 1.0f, 22.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(24.69f, 2.57f);
                j.cubicTo(26.63f, 1.61f, 28.56f, -0.09f, 30.86f, 0.24f);
                j.cubicTo(34.72f, 1.77f, 38.08f, 4.28f, 41.73f, 6.21f);
                j.cubicTo(46.53f, 9.13f, 51.66f, 11.54f, 56.18f, 14.91f);
                j.cubicTo(48.5f, 19.8f, 40.44f, 24.06f, 32.58f, 28.62f);
                j.cubicTo(30.48f, 30.19f, 27.98f, 29.12f, 26.04f, 27.89f);
                j.cubicTo(18.64f, 23.47f, 10.99f, 19.49f, 3.71f, 14.88f);
                j.cubicTo(10.38f, 10.25f, 17.76f, 6.79f, 24.69f, 2.57f);
                j.lineTo(24.69f, 2.57f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(1.0f, 29.05f);
                j.cubicTo(1.08f, 25.67f, 0.52f, 22.16f, 1.76f, 18.92f);
                j.cubicTo(9.31f, 23.12f, 16.77f, 27.47f, 24.31f, 31.67f);
                j.cubicTo(25.89f, 32.62f, 27.97f, 33.72f, 27.91f, 35.87f);
                j.cubicTo(28.18f, 45.12f, 27.86f, 54.39f, 28.05f, 63.66f);
                j.cubicTo(25.05f, 63.22f, 22.58f, 61.36f, 20.01f, 59.91f);
                j.cubicTo(14.93f, 56.99f, 9.85f, 54.07f, 4.74f, 51.2f);
                j.cubicTo(3.21f, 50.24f, 1.11f, 49.24f, 1.1f, 47.14f);
                j.cubicTo(0.81f, 41.12f, 1.1f, 35.08f, 1.0f, 29.05f);
                j.lineTo(1.0f, 29.05f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(51.1f, 23.01f);
                j.cubicTo(53.64f, 21.58f, 56.08f, 19.79f, 59.04f, 19.34f);
                j.cubicTo(58.91f, 28.27f, 59.09f, 37.21f, 58.98f, 46.14f);
                j.cubicTo(59.12f, 47.96f, 58.24f, 49.72f, 56.59f, 50.56f);
                j.cubicTo(50.29f, 54.31f, 43.77f, 57.71f, 37.45f, 61.45f);
                j.cubicTo(35.75f, 62.48f, 33.95f, 63.38f, 31.95f, 63.64f);
                j.cubicTo(32.15f, 54.4f, 31.82f, 45.15f, 32.08f, 35.92f);
                j.cubicTo(32.03f, 33.78f, 34.13f, 32.69f, 35.7f, 31.73f);
                j.cubicTo(40.87f, 28.88f, 45.97f, 25.91f, 51.1f, 23.01f);
                j.lineTo(51.1f, 23.01f);
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
