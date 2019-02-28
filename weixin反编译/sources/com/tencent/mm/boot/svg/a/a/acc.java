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

public final class acc extends c {
    private final int height = 96;
    private final int width = 96;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                a.setColor(-1);
                e = c.a(e, 1.0f, 0.0f, 20.0f, 0.0f, 1.0f, 19.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(2.253182f, 8.691923f);
                j.cubicTo(4.7252164f, 5.0494986f, 8.263815f, 2.0657039f, 12.131352f, -3.5527137E-15f);
                j.cubicTo(14.832648f, 0.5189208f, 15.699854f, 3.8819268f, 17.404362f, 5.748046f);
                j.cubicTo(19.068998f, 8.801695f, 22.458078f, 11.346403f, 22.747147f, 14.8590975f);
                j.cubicTo(20.334919f, 17.693203f, 16.547125f, 18.850796f, 13.327498f, 20.52731f);
                j.cubicTo(15.231364f, 26.904047f, 19.736847f, 32.053337f, 24.511461f, 36.50408f);
                j.cubicTo(27.77096f, 39.537773f, 31.52885f, 42.09246f, 35.805073f, 43.459618f);
                j.cubicTo(37.50958f, 40.186424f, 38.596077f, 36.27456f, 41.466827f, 33.8496f);
                j.cubicTo(44.98549f, 34.27871f, 47.477463f, 37.71157f, 50.527634f, 39.43798f);
                j.cubicTo(52.331818f, 41.124474f, 55.501606f, 41.99267f, 56.0f, 44.63717f);
                j.cubicTo(54.056263f, 48.439262f, 51.23535f, 51.89208f, 47.84627f, 54.486683f);
                j.cubicTo(45.08517f, 56.67214f, 41.31731f, 56.213093f, 38.30701f, 54.855915f);
                j.cubicTo(22.009523f, 48.020134f, 8.732305f, 34.40844f, 2.1435351f, 18.00256f);
                j.cubicTo(0.9573573f, 15.048703f, 0.26957348f, 11.486113f, 2.253182f, 8.691923f);
                j.lineTo(2.253182f, 8.691923f);
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
