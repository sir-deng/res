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

public final class pk extends c {
    private final int height = 36;
    private final int width = 75;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 75;
            case 1:
                return 36;
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
                float[] a = c.a(e, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f);
                f.reset();
                f.setValues(a);
                canvas.concat(f);
                Paint a2 = c.a(i2, looper);
                a2.setColor(-45235);
                canvas.save();
                Paint a3 = c.a(a2, looper);
                Path j = c.j(looper);
                j.moveTo(17.77f, 1.0f);
                j.lineTo(57.09f, 1.0f);
                j.cubicTo(66.55f, 0.93f, 74.9f, 9.15f, 75.0f, 18.61f);
                j.lineTo(75.0f, 19.27f);
                j.cubicTo(74.97f, 28.72f, 66.67f, 37.0f, 57.21f, 37.0f);
                j.lineTo(17.88f, 37.0f);
                j.cubicTo(8.43f, 37.06f, 0.1f, 28.83f, 0.0f, 19.39f);
                j.lineTo(0.0f, 18.71f);
                j.cubicTo(0.04f, 9.26f, 8.33f, 1.01f, 17.77f, 1.0f);
                j.lineTo(17.77f, 1.0f);
                j.close();
                j.moveTo(14.96f, 11.01f);
                j.cubicTo(14.95f, 16.0f, 14.95f, 21.0f, 14.96f, 26.0f);
                j.lineTo(18.03f, 26.0f);
                j.cubicTo(18.04f, 22.64f, 18.03f, 19.29f, 18.04f, 15.93f);
                j.cubicTo(20.16f, 19.27f, 22.22f, 22.65f, 24.32f, 26.0f);
                j.cubicTo(25.42f, 26.0f, 26.51f, 25.99f, 27.61f, 25.99f);
                j.cubicTo(27.6f, 20.99f, 27.61f, 16.0f, 27.6f, 11.01f);
                j.cubicTo(26.84f, 11.01f, 25.3f, 11.0f, 24.54f, 11.0f);
                j.cubicTo(24.52f, 14.37f, 24.53f, 17.74f, 24.52f, 21.11f);
                j.cubicTo(22.4f, 17.75f, 20.33f, 14.36f, 18.21f, 11.0f);
                j.cubicTo(17.4f, 11.0f, 15.77f, 11.01f, 14.96f, 11.01f);
                j.lineTo(14.96f, 11.01f);
                j.close();
                j.moveTo(30.45f, 11.02f);
                j.cubicTo(30.44f, 16.0f, 30.46f, 20.99f, 30.44f, 25.98f);
                j.cubicTo(34.24f, 26.02f, 38.04f, 26.01f, 41.84f, 25.98f);
                j.cubicTo(41.84f, 25.29f, 41.83f, 23.92f, 41.83f, 23.24f);
                j.cubicTo(39.14f, 23.24f, 36.44f, 23.23f, 33.75f, 23.22f);
                j.lineTo(33.75f, 19.56f);
                j.cubicTo(36.16f, 19.55f, 38.58f, 19.55f, 40.99f, 19.55f);
                j.cubicTo(41.0f, 18.91f, 41.01f, 17.64f, 41.02f, 17.01f);
                j.cubicTo(38.59f, 17.0f, 36.17f, 16.99f, 33.74f, 16.98f);
                j.cubicTo(33.74f, 16.18f, 33.75f, 14.59f, 33.75f, 13.79f);
                j.cubicTo(36.38f, 13.78f, 39.01f, 13.77f, 41.63f, 13.78f);
                j.cubicTo(41.65f, 13.1f, 41.68f, 11.72f, 41.7f, 11.04f);
                j.cubicTo(37.95f, 10.99f, 34.2f, 11.0f, 30.45f, 11.02f);
                j.lineTo(30.45f, 11.02f);
                j.close();
                j.moveTo(42.58f, 11.01f);
                j.cubicTo(43.89f, 16.01f, 45.2f, 21.02f, 46.55f, 26.01f);
                j.cubicTo(47.65f, 26.01f, 48.75f, 26.0f, 49.86f, 26.0f);
                j.cubicTo(50.72f, 22.58f, 51.53f, 19.16f, 52.39f, 15.74f);
                j.cubicTo(53.27f, 19.16f, 54.09f, 22.58f, 54.96f, 26.0f);
                j.lineTo(58.22f, 26.0f);
                j.cubicTo(59.58f, 21.01f, 60.92f, 16.01f, 62.25f, 11.01f);
                j.lineTo(59.04f, 11.01f);
                j.cubicTo(58.2f, 14.46f, 57.39f, 17.93f, 56.55f, 21.39f);
                j.cubicTo(55.66f, 17.93f, 54.84f, 14.46f, 53.95f, 11.01f);
                j.lineTo(50.89f, 11.01f);
                j.cubicTo(50.0f, 14.43f, 49.14f, 17.86f, 48.26f, 21.28f);
                j.cubicTo(47.44f, 17.86f, 46.67f, 14.42f, 45.84f, 11.0f);
                j.cubicTo(45.02f, 11.0f, 43.39f, 11.0f, 42.58f, 11.01f);
                j.lineTo(42.58f, 11.01f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-1);
                e = c.a(a, 1.0f, 0.0f, 14.0f, 0.0f, 1.0f, 11.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a4 = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(0.96f, 0.01f);
                j.cubicTo(1.77f, 0.01f, 3.4f, 0.0f, 4.21f, 0.0f);
                j.cubicTo(6.33f, 3.36f, 8.4f, 6.75f, 10.52f, 10.11f);
                j.cubicTo(10.53f, 6.74f, 10.52f, 3.37f, 10.54f, 0.0f);
                j.cubicTo(11.3f, 0.0f, 12.84f, 0.01f, 13.6f, 0.01f);
                j.cubicTo(13.61f, 5.0f, 13.6f, 9.99f, 13.61f, 14.99f);
                j.cubicTo(12.51f, 14.99f, 11.42f, 15.0f, 10.32f, 15.0f);
                j.cubicTo(8.22f, 11.65f, 6.16f, 8.27f, 4.04f, 4.93f);
                j.cubicTo(4.03f, 8.29f, 4.04f, 11.64f, 4.03f, 15.0f);
                j.lineTo(0.96f, 15.0f);
                j.cubicTo(0.95f, 10.0f, 0.95f, 5.0f, 0.96f, 0.01f);
                j.lineTo(0.96f, 0.01f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a4);
                canvas.restore();
                canvas.save();
                a4 = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(16.45f, 0.02f);
                j.cubicTo(20.2f, 1.0130785E-15f, 23.95f, -0.01f, 27.7f, 0.04f);
                j.cubicTo(27.68f, 0.72f, 27.65f, 2.1f, 27.63f, 2.78f);
                j.cubicTo(25.01f, 2.77f, 22.38f, 2.78f, 19.75f, 2.79f);
                j.cubicTo(19.75f, 3.59f, 19.74f, 5.18f, 19.74f, 5.98f);
                j.cubicTo(22.17f, 5.99f, 24.59f, 6.0f, 27.02f, 6.01f);
                j.cubicTo(27.01f, 6.64f, 27.0f, 7.91f, 26.99f, 8.55f);
                j.cubicTo(24.58f, 8.55f, 22.16f, 8.55f, 19.75f, 8.56f);
                j.lineTo(19.75f, 12.22f);
                j.cubicTo(22.44f, 12.23f, 25.14f, 12.24f, 27.83f, 12.24f);
                j.cubicTo(27.83f, 12.92f, 27.84f, 14.29f, 27.84f, 14.98f);
                j.cubicTo(24.04f, 15.01f, 20.24f, 15.02f, 16.44f, 14.98f);
                j.cubicTo(16.46f, 9.99f, 16.44f, 5.0f, 16.45f, 0.02f);
                j.lineTo(16.45f, 0.02f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a4);
                canvas.restore();
                canvas.save();
                a4 = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(28.58f, 0.01f);
                j.cubicTo(29.39f, 1.7763568E-15f, 31.02f, 1.7763568E-15f, 31.84f, 1.7763568E-15f);
                j.cubicTo(32.67f, 3.42f, 33.44f, 6.86f, 34.26f, 10.28f);
                j.cubicTo(35.14f, 6.86f, 36.0f, 3.43f, 36.89f, 0.01f);
                j.lineTo(39.95f, 0.01f);
                j.cubicTo(40.84f, 3.46f, 41.66f, 6.93f, 42.55f, 10.39f);
                j.cubicTo(43.39f, 6.93f, 44.2f, 3.46f, 45.04f, 0.01f);
                j.lineTo(48.25f, 0.01f);
                j.cubicTo(46.92f, 5.01f, 45.58f, 10.01f, 44.22f, 15.0f);
                j.lineTo(40.96f, 15.0f);
                j.cubicTo(40.09f, 11.58f, 39.27f, 8.16f, 38.39f, 4.74f);
                j.cubicTo(37.53f, 8.16f, 36.72f, 11.58f, 35.86f, 15.0f);
                j.cubicTo(34.75f, 15.0f, 33.65f, 15.01f, 32.55f, 15.01f);
                j.cubicTo(31.2f, 10.02f, 29.89f, 5.01f, 28.58f, 0.01f);
                j.lineTo(28.58f, 0.01f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
