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

public final class wr extends c {
    private final int height = 180;
    private final int width = 180;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 180;
            case 1:
                return 180;
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
                Paint a = c.a(i2, looper);
                a.setColor(-1250068);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(179.88945f, 0.0f);
                j.cubicTo(179.96985f, 60.0f, 179.73871f, 120.0f, 180.0f, 180.0f);
                j.lineTo(0.0f, 180.0f);
                j.lineTo(0.0f, 0.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(88.3f, 70.37f);
                j.cubicTo(90.79f, 69.1f, 94.13f, 71.17f, 93.98f, 73.99f);
                j.cubicTo(94.2f, 77.11f, 90.14f, 79.2f, 87.71f, 77.26f);
                j.cubicTo(85.19f, 75.7f, 85.6f, 71.51f, 88.3f, 70.37f);
                j.lineTo(88.3f, 70.37f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(65.02f, 97.05f);
                j.cubicTo(68.67f, 96.95f, 72.31f, 96.94f, 75.96f, 97.03f);
                j.cubicTo(76.05f, 100.01f, 76.05f, 102.99f, 75.95f, 105.97f);
                j.cubicTo(72.32f, 106.05f, 68.68f, 106.05f, 65.04f, 105.96f);
                j.cubicTo(64.95f, 102.99f, 64.95f, 100.02f, 65.02f, 97.05f);
                j.lineTo(65.02f, 97.05f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(85.03f, 97.04f);
                j.cubicTo(88.67f, 96.95f, 92.32f, 96.95f, 95.96f, 97.04f);
                j.cubicTo(96.05f, 100.01f, 96.05f, 102.98f, 95.97f, 105.96f);
                j.cubicTo(92.32f, 106.05f, 88.68f, 106.05f, 85.04f, 105.97f);
                j.cubicTo(84.95f, 102.99f, 84.95f, 100.02f, 85.03f, 97.04f);
                j.lineTo(85.03f, 97.04f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(105.05f, 97.03f);
                j.cubicTo(108.69f, 96.94f, 112.33f, 96.95f, 115.98f, 97.05f);
                j.cubicTo(116.05f, 100.02f, 116.05f, 102.99f, 115.96f, 105.96f);
                j.cubicTo(112.32f, 106.05f, 108.68f, 106.05f, 105.03f, 105.96f);
                j.cubicTo(104.95f, 102.98f, 104.95f, 100.01f, 105.05f, 97.03f);
                j.lineTo(105.05f, 97.03f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(65.04f, 112.04f);
                j.cubicTo(68.68f, 111.95f, 72.32f, 111.95f, 75.96f, 112.03f);
                j.cubicTo(76.04f, 115.0f, 76.05f, 117.98f, 75.98f, 120.95f);
                j.cubicTo(72.33f, 121.05f, 68.68f, 121.05f, 65.03f, 120.95f);
                j.cubicTo(64.95f, 117.98f, 64.95f, 115.01f, 65.04f, 112.04f);
                j.lineTo(65.04f, 112.04f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(85.02f, 112.05f);
                j.cubicTo(88.66f, 111.95f, 92.31f, 111.94f, 95.95f, 112.03f);
                j.cubicTo(96.05f, 115.01f, 96.05f, 117.99f, 95.96f, 120.96f);
                j.cubicTo(92.32f, 121.05f, 88.67f, 121.05f, 85.03f, 120.95f);
                j.cubicTo(84.95f, 117.98f, 84.95f, 115.02f, 85.02f, 112.05f);
                j.lineTo(85.02f, 112.05f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(105.02f, 112.05f);
                j.cubicTo(108.67f, 111.95f, 112.31f, 111.94f, 115.96f, 112.03f);
                j.cubicTo(116.05f, 115.01f, 116.04f, 118.0f, 115.94f, 120.98f);
                j.cubicTo(112.31f, 121.05f, 108.68f, 121.05f, 105.05f, 120.98f);
                j.cubicTo(104.96f, 118.0f, 104.94f, 115.03f, 105.02f, 112.05f);
                j.lineTo(105.02f, 112.05f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-3355444);
                float[] a3 = c.a(e, 1.0f, 0.0f, 47.0f, 0.0f, 1.0f, 49.0f);
                f.reset();
                f.setValues(a3);
                canvas.concat(f);
                canvas.save();
                Paint a4 = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(24.15f, 5.27f);
                j.cubicTo(26.54f, 3.4f, 29.02f, 1.65f, 31.64f, 0.12f);
                j.cubicTo(36.17f, 6.37f, 40.34f, 12.87f, 45.04f, 18.99f);
                j.cubicTo(58.34f, 19.05f, 71.65f, 18.93f, 84.96f, 19.03f);
                j.cubicTo(85.05f, 23.01f, 85.05f, 27.0f, 84.95f, 30.98f);
                j.cubicTo(56.98f, 31.01f, 29.01f, 31.02f, 1.04f, 30.98f);
                j.cubicTo(0.95f, 27.0f, 0.95f, 23.02f, 1.03f, 19.04f);
                j.cubicTo(11.83f, 18.9f, 22.64f, 19.11f, 33.44f, 18.95f);
                j.cubicTo(30.57f, 14.24f, 26.98f, 10.01f, 24.15f, 5.27f);
                j.lineTo(24.15f, 5.27f);
                j.close();
                j.moveTo(41.3f, 21.37f);
                j.cubicTo(38.6f, 22.51f, 38.19f, 26.7f, 40.71f, 28.26f);
                j.cubicTo(43.14f, 30.2f, 47.2f, 28.11f, 46.98f, 24.99f);
                j.cubicTo(47.13f, 22.17f, 43.79f, 20.1f, 41.3f, 21.37f);
                j.lineTo(41.3f, 21.37f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a4);
                canvas.restore();
                canvas.save();
                a4 = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(5.71f, 37.04f);
                j.cubicTo(30.57f, 36.97f, 55.44f, 36.97f, 80.3f, 37.04f);
                j.cubicTo(79.26f, 50.35f, 77.78f, 63.63f, 76.62f, 76.93f);
                j.cubicTo(76.54f, 79.1f, 75.8f, 82.1f, 73.04f, 81.91f);
                j.cubicTo(54.04f, 82.15f, 35.02f, 81.89f, 16.01f, 82.04f);
                j.cubicTo(14.1f, 81.85f, 11.64f, 82.42f, 10.3f, 80.68f);
                j.cubicTo(9.4f, 78.97f, 9.45f, 76.97f, 9.2f, 75.11f);
                j.cubicTo(8.13f, 62.41f, 6.65f, 49.74f, 5.71f, 37.04f);
                j.lineTo(5.71f, 37.04f);
                j.close();
                j.moveTo(18.02f, 48.05f);
                j.cubicTo(17.95f, 51.02f, 17.95f, 53.99f, 18.04f, 56.96f);
                j.cubicTo(21.68f, 57.05f, 25.32f, 57.05f, 28.95f, 56.97f);
                j.cubicTo(29.05f, 53.99f, 29.05f, 51.01f, 28.96f, 48.03f);
                j.cubicTo(25.31f, 47.94f, 21.67f, 47.95f, 18.02f, 48.05f);
                j.lineTo(18.02f, 48.05f);
                j.close();
                j.moveTo(38.03f, 48.04f);
                j.cubicTo(37.95f, 51.02f, 37.95f, 53.99f, 38.04f, 56.97f);
                j.cubicTo(41.68f, 57.05f, 45.32f, 57.05f, 48.97f, 56.96f);
                j.cubicTo(49.05f, 53.98f, 49.05f, 51.01f, 48.96f, 48.04f);
                j.cubicTo(45.32f, 47.95f, 41.67f, 47.95f, 38.03f, 48.04f);
                j.lineTo(38.03f, 48.04f);
                j.close();
                j.moveTo(58.05f, 48.03f);
                j.cubicTo(57.95f, 51.01f, 57.95f, 53.98f, 58.03f, 56.96f);
                j.cubicTo(61.68f, 57.05f, 65.32f, 57.05f, 68.96f, 56.96f);
                j.cubicTo(69.05f, 53.99f, 69.05f, 51.02f, 68.98f, 48.05f);
                j.cubicTo(65.33f, 47.95f, 61.69f, 47.94f, 58.05f, 48.03f);
                j.lineTo(58.05f, 48.03f);
                j.close();
                j.moveTo(18.04f, 63.04f);
                j.cubicTo(17.95f, 66.01f, 17.95f, 68.98f, 18.03f, 71.95f);
                j.cubicTo(21.68f, 72.05f, 25.33f, 72.05f, 28.98f, 71.95f);
                j.cubicTo(29.05f, 68.98f, 29.04f, 66.0f, 28.96f, 63.03f);
                j.cubicTo(25.32f, 62.95f, 21.68f, 62.95f, 18.04f, 63.04f);
                j.lineTo(18.04f, 63.04f);
                j.close();
                j.moveTo(38.02f, 63.05f);
                j.cubicTo(37.95f, 66.02f, 37.95f, 68.98f, 38.03f, 71.95f);
                j.cubicTo(41.67f, 72.05f, 45.32f, 72.05f, 48.96f, 71.96f);
                j.cubicTo(49.05f, 68.99f, 49.05f, 66.01f, 48.95f, 63.03f);
                j.cubicTo(45.31f, 62.94f, 41.66f, 62.95f, 38.02f, 63.05f);
                j.lineTo(38.02f, 63.05f);
                j.close();
                j.moveTo(58.02f, 63.05f);
                j.cubicTo(57.94f, 66.03f, 57.96f, 69.0f, 58.05f, 71.98f);
                j.cubicTo(61.68f, 72.05f, 65.31f, 72.05f, 68.94f, 71.98f);
                j.cubicTo(69.04f, 69.0f, 69.05f, 66.01f, 68.96f, 63.03f);
                j.cubicTo(65.31f, 62.94f, 61.67f, 62.95f, 58.02f, 63.05f);
                j.lineTo(58.02f, 63.05f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a4);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
