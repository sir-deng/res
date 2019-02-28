package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.a.d;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class apo extends c {
    private final int height = 70;
    private final int width = 80;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 80;
            case 1:
                return 70;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.f(looper);
                c.e(looper);
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
                i2 = c.a(i2, looper);
                i2.setColor(-1);
                canvas.saveLayerAlpha(null, d.CTRL_INDEX, 4);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(37.23f, 0.0f);
                j.lineTo(41.05f, 0.0f);
                j.cubicTo(52.9f, 0.29f, 64.78f, 5.01f, 72.74f, 13.96f);
                j.cubicTo(59.87f, 19.69f, 46.95f, 25.31f, 34.09f, 31.06f);
                j.cubicTo(32.6f, 31.58f, 30.87f, 32.65f, 29.33f, 31.68f);
                j.cubicTo(25.68f, 29.77f, 22.78f, 26.7f, 19.05f, 24.94f);
                j.cubicTo(18.77f, 25.22f, 18.22f, 25.77f, 17.95f, 26.05f);
                j.cubicTo(20.11f, 31.91f, 22.96f, 37.53f, 25.64f, 43.17f);
                j.cubicTo(26.77f, 45.57f, 29.46f, 44.2f, 31.07f, 43.18f);
                j.cubicTo(45.87f, 34.65f, 60.7f, 26.18f, 75.53f, 17.7f);
                j.cubicTo(77.88f, 21.83f, 79.57f, 26.35f, 80.0f, 31.1f);
                j.lineTo(80.0f, 34.4f);
                j.cubicTo(79.53f, 43.48f, 74.44f, 51.87f, 67.24f, 57.24f);
                j.cubicTo(56.19f, 65.76f, 41.1f, 68.0f, 27.75f, 64.53f);
                j.cubicTo(22.08f, 62.87f, 18.26f, 70.19f, 12.88f, 69.67f);
                j.cubicTo(12.94f, 66.33f, 14.52f, 63.28f, 14.9f, 60.0f);
                j.cubicTo(14.76f, 58.48f, 13.17f, 57.74f, 12.22f, 56.75f);
                j.cubicTo(5.34f, 51.41f, 0.51f, 43.26f, 0.0f, 34.47f);
                j.lineTo(0.0f, 31.4f);
                j.cubicTo(0.54f, 23.87f, 4.14f, 16.76f, 9.59f, 11.6f);
                j.cubicTo(16.98f, 4.47f, 27.11f, 0.76f, 37.23f, 0.0f);
                j.lineTo(37.23f, 0.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
