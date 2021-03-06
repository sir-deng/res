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

public final class be extends c {
    private final int height = 90;
    private final int width = 90;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                e = c.a(e, 1.0f, 0.0f, 11.0f, 0.0f, 1.0f, 0.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-14824411);
                Path j = c.j(looper);
                j.moveTo(46.0f, 0.0f);
                j.lineTo(68.0f, 22.0f);
                j.lineTo(68.0f, 87.0f);
                j.cubicTo(68.0f, 88.65685f, 66.65685f, 90.0f, 65.0f, 90.0f);
                j.lineTo(3.0f, 90.0f);
                j.cubicTo(1.3431457f, 90.0f, 2.0290612E-16f, 88.65685f, 0.0f, 87.0f);
                j.lineTo(0.0f, 3.0f);
                j.cubicTo(-2.0290612E-16f, 1.3431457f, 1.3431457f, 3.043592E-16f, 3.0f, 0.0f);
                j.lineTo(46.0f, 0.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                a = c.a(i2, looper);
                a.setColor(-15228131);
                j = c.j(looper);
                j.moveTo(68.0f, 22.0f);
                j.lineTo(49.0f, 22.0f);
                j.cubicTo(47.343147f, 22.0f, 46.0f, 20.656855f, 46.0f, 19.0f);
                j.lineTo(46.0f, 0.0f);
                j.lineTo(68.0f, 22.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                a = c.a(i2, looper);
                a.setColor(-1);
                j = c.j(looper);
                j.moveTo(19.75f, 62.0f);
                j.lineTo(24.25f, 62.0f);
                j.cubicTo(24.664213f, 62.0f, 25.0f, 62.335785f, 25.0f, 62.75f);
                j.lineTo(25.0f, 65.25f);
                j.cubicTo(25.0f, 65.664215f, 24.664213f, 66.0f, 24.25f, 66.0f);
                j.lineTo(19.75f, 66.0f);
                j.cubicTo(19.335787f, 66.0f, 19.0f, 65.664215f, 19.0f, 65.25f);
                j.lineTo(19.0f, 62.75f);
                j.cubicTo(19.0f, 62.335785f, 19.335787f, 62.0f, 19.75f, 62.0f);
                j.close();
                j.moveTo(27.75f, 55.0f);
                j.lineTo(32.25f, 55.0f);
                j.cubicTo(32.664215f, 55.0f, 33.0f, 55.335785f, 33.0f, 55.75f);
                j.lineTo(33.0f, 65.25f);
                j.cubicTo(33.0f, 65.664215f, 32.664215f, 66.0f, 32.25f, 66.0f);
                j.lineTo(27.75f, 66.0f);
                j.cubicTo(27.335787f, 66.0f, 27.0f, 65.664215f, 27.0f, 65.25f);
                j.lineTo(27.0f, 55.75f);
                j.cubicTo(27.0f, 55.335785f, 27.335787f, 55.0f, 27.75f, 55.0f);
                j.close();
                j.moveTo(35.75f, 44.0f);
                j.lineTo(40.25f, 44.0f);
                j.cubicTo(40.664215f, 44.0f, 41.0f, 44.335785f, 41.0f, 44.75f);
                j.lineTo(41.0f, 65.25f);
                j.cubicTo(41.0f, 65.664215f, 40.664215f, 66.0f, 40.25f, 66.0f);
                j.lineTo(35.75f, 66.0f);
                j.cubicTo(35.335785f, 66.0f, 35.0f, 65.664215f, 35.0f, 65.25f);
                j.lineTo(35.0f, 44.75f);
                j.cubicTo(35.0f, 44.335785f, 35.335785f, 44.0f, 35.75f, 44.0f);
                j.close();
                j.moveTo(19.0f, 68.0f);
                j.lineTo(49.0f, 68.0f);
                j.cubicTo(49.552284f, 68.0f, 50.0f, 68.447716f, 50.0f, 69.0f);
                j.cubicTo(50.0f, 69.552284f, 49.552284f, 70.0f, 49.0f, 70.0f);
                j.lineTo(19.0f, 70.0f);
                j.cubicTo(18.447716f, 70.0f, 18.0f, 69.552284f, 18.0f, 69.0f);
                j.cubicTo(18.0f, 68.447716f, 18.447716f, 68.0f, 19.0f, 68.0f);
                j.close();
                j.moveTo(43.75f, 50.0f);
                j.lineTo(48.25f, 50.0f);
                j.cubicTo(48.664215f, 50.0f, 49.0f, 50.335785f, 49.0f, 50.75f);
                j.lineTo(49.0f, 65.25f);
                j.cubicTo(49.0f, 65.664215f, 48.664215f, 66.0f, 48.25f, 66.0f);
                j.lineTo(43.75f, 66.0f);
                j.cubicTo(43.335785f, 66.0f, 43.0f, 65.664215f, 43.0f, 65.25f);
                j.lineTo(43.0f, 50.75f);
                j.cubicTo(43.0f, 50.335785f, 43.335785f, 50.0f, 43.75f, 50.0f);
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
