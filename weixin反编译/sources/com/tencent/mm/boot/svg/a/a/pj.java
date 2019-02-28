package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenWeRunSetting;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class pj extends c {
    private final int height = JsApiOpenWeRunSetting.CTRL_INDEX;
    private final int width = JsApiOpenWeRunSetting.CTRL_INDEX;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return JsApiOpenWeRunSetting.CTRL_INDEX;
            case 1:
                return JsApiOpenWeRunSetting.CTRL_INDEX;
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
                a.setColor(-1);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(228.0f, 0.0f);
                j.lineTo(228.0f, 228.0f);
                j.lineTo(0.0f, 228.0f);
                j.lineTo(0.0f, 0.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                j.moveTo(81.9f, 51.52f);
                j.cubicTo(80.59f, 54.6f, 79.27f, 57.71f, 78.65f, 61.02f);
                j.cubicTo(73.07f, 61.09f, 67.48f, 60.88f, 61.9f, 61.06f);
                j.cubicTo(57.69f, 60.97f, 53.94f, 64.73f, 54.05f, 68.94f);
                j.cubicTo(53.93f, 85.6f, 54.02f, 102.26f, 54.01f, 118.91f);
                j.cubicTo(54.04f, 135.28f, 53.99f, 151.65f, 53.99f, 168.02f);
                j.cubicTo(53.28f, 178.64f, 62.26f, 188.73f, 72.95f, 188.95f);
                j.cubicTo(86.92f, 189.09f, 100.9f, 188.94f, 114.87f, 189.01f);
                j.cubicTo(103.56f, 177.33f, 99.78f, 159.0f, 105.98f, 143.9f);
                j.cubicTo(110.23f, 132.75f, 119.51f, 124.03f, 130.47f, 119.55f);
                j.cubicTo(133.62f, 118.96f, 136.65f, 117.7f, 139.87f, 117.37f);
                j.cubicTo(152.1f, 115.63f, 164.78f, 119.78f, 174.01f, 127.9f);
                j.cubicTo(173.95f, 108.23f, 174.08f, 88.56f, 173.94f, 68.9f);
                j.cubicTo(174.04f, 64.68f, 170.26f, 60.93f, 166.04f, 61.06f);
                j.cubicTo(160.49f, 60.91f, 154.92f, 61.06f, 149.37f, 61.05f);
                j.cubicTo(148.33f, 55.47f, 145.67f, 50.36f, 142.4f, 45.78f);
                j.cubicTo(134.57f, 35.85f, 121.41f, 30.45f, 108.88f, 32.4f);
                j.cubicTo(97.44f, 33.88f, 87.25f, 41.38f, 81.9f, 51.52f);
                j.lineTo(81.9f, 51.52f);
                j.close();
                j.moveTo(156.17f, 139.12f);
                j.cubicTo(150.77f, 141.93f, 153.05f, 151.46f, 159.01f, 151.89f);
                j.cubicTo(162.92f, 152.07f, 165.04f, 147.41f, 163.99f, 144.07f);
                j.cubicTo(163.35f, 140.71f, 159.64f, 137.46f, 156.17f, 139.12f);
                j.lineTo(156.17f, 139.12f);
                j.close();
                j.moveTo(124.47f, 147.62f);
                j.cubicTo(119.22f, 150.42f, 121.29f, 159.62f, 127.06f, 160.35f);
                j.cubicTo(130.47f, 160.75f, 132.87f, 157.17f, 132.54f, 154.06f);
                j.cubicTo(132.56f, 150.13f, 128.55f, 145.76f, 124.47f, 147.62f);
                j.lineTo(124.47f, 147.62f);
                j.close();
                j.moveTo(122.58f, 174.43f);
                j.cubicTo(128.87f, 186.78f, 145.37f, 192.26f, 157.73f, 185.89f);
                j.cubicTo(167.18f, 181.52f, 173.07f, 171.29f, 172.93f, 160.99f);
                j.cubicTo(156.12f, 165.4f, 139.36f, 169.96f, 122.58f, 174.43f);
                j.lineTo(122.58f, 174.43f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(89.56f, 52.35f);
                j.cubicTo(94.15f, 45.43f, 101.6f, 40.38f, 109.89f, 39.31f);
                j.cubicTo(118.41f, 37.98f, 127.29f, 40.89f, 133.65f, 46.64f);
                j.cubicTo(137.78f, 50.5f, 140.74f, 55.53f, 142.14f, 61.01f);
                j.cubicTo(123.38f, 61.02f, 104.62f, 61.03f, 85.86f, 61.01f);
                j.cubicTo(86.67f, 57.96f, 87.89f, 55.03f, 89.56f, 52.35f);
                j.lineTo(89.56f, 52.35f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                float[] a3 = c.a(e, 1.0f, 0.0f, 53.0f, 0.0f, 1.0f, 60.0f);
                f.reset();
                f.setValues(a3);
                canvas.concat(f);
                i3 = c.a(i2, looper);
                i3.setColor(-23226);
                canvas.save();
                Paint a4 = c.a(i3, looper);
                j = c.j(looper);
                j.moveTo(1.01f, 58.91f);
                j.cubicTo(24.33f, 59.22f, 47.66f, 58.91f, 70.99f, 59.07f);
                j.cubicTo(73.15f, 59.17f, 75.3f, 59.43f, 77.47f, 59.55f);
                j.cubicTo(66.51f, 64.03f, 57.23f, 72.75f, 52.98f, 83.9f);
                j.cubicTo(46.78f, 99.0f, 50.56f, 117.33f, 61.87f, 129.01f);
                j.cubicTo(47.9f, 128.94f, 33.92f, 129.09f, 19.95f, 128.95f);
                j.cubicTo(9.26f, 128.73f, 0.28f, 118.64f, 0.99f, 108.02f);
                j.cubicTo(0.99f, 91.65f, 1.04f, 75.28f, 1.01f, 58.91f);
                j.close();
                j.moveTo(8.9f, 1.06f);
                j.cubicTo(14.48f, 0.88f, 107.49f, 0.91f, 113.04f, 1.06f);
                j.cubicTo(117.26f, 0.93f, 121.04f, 4.68f, 120.94f, 8.9f);
                j.cubicTo(121.08f, 28.56f, 120.95f, 48.23f, 121.01f, 67.9f);
                j.cubicTo(111.78f, 59.78f, 99.1f, 55.63f, 86.87f, 57.37f);
                j.cubicTo(83.65f, 57.7f, 80.62f, 58.96f, 77.47f, 59.55f);
                j.cubicTo(75.3f, 59.43f, 73.15f, 59.17f, 70.99f, 59.07f);
                j.cubicTo(47.66f, 58.91f, 24.33f, 59.22f, 1.01f, 58.91f);
                j.cubicTo(1.02f, 42.26f, 0.93f, 25.6f, 1.05f, 8.94f);
                j.cubicTo(0.94f, 4.73f, 4.69f, 0.97f, 8.9f, 1.06f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a4);
                canvas.restore();
                canvas.save();
                a2 = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(1.01f, 58.91f);
                j.cubicTo(24.33f, 59.22f, 47.66f, 58.91f, 70.99f, 59.07f);
                j.cubicTo(73.15f, 59.17f, 75.3f, 59.43f, 77.47f, 59.55f);
                j.cubicTo(66.51f, 64.03f, 57.23f, 72.75f, 52.98f, 83.9f);
                j.cubicTo(46.78f, 99.0f, 50.56f, 117.33f, 61.87f, 129.01f);
                j.cubicTo(47.9f, 128.94f, 33.92f, 129.09f, 19.95f, 128.95f);
                j.cubicTo(9.26f, 128.73f, 0.28f, 118.64f, 0.99f, 108.02f);
                j.cubicTo(0.99f, 91.65f, 1.04f, 75.28f, 1.01f, 58.91f);
                j.close();
                j.moveTo(8.9f, 1.06f);
                j.cubicTo(14.48f, 0.88f, 107.49f, 0.91f, 113.04f, 1.06f);
                j.cubicTo(117.26f, 0.93f, 121.04f, 4.68f, 120.94f, 8.9f);
                j.cubicTo(121.08f, 28.56f, 120.95f, 48.23f, 121.01f, 67.9f);
                j.cubicTo(111.78f, 59.78f, 99.1f, 55.63f, 86.87f, 57.37f);
                j.cubicTo(83.65f, 57.7f, 80.62f, 58.96f, 77.47f, 59.55f);
                j.cubicTo(75.3f, 59.43f, 73.15f, 59.17f, 70.99f, 59.07f);
                j.cubicTo(47.66f, 58.91f, 24.33f, 59.22f, 1.01f, 58.91f);
                j.cubicTo(1.02f, 42.26f, 0.93f, 25.6f, 1.05f, 8.94f);
                j.cubicTo(0.94f, 4.73f, 4.69f, 0.97f, 8.9f, 1.06f);
                j.close();
                Paint i4 = c.i(looper);
                i4.setFlags(385);
                i4.setStyle(Style.FILL);
                Paint i5 = c.i(looper);
                i5.setFlags(385);
                i5.setStyle(Style.STROKE);
                i4.setColor(WebView.NIGHT_MODE_COLOR);
                i5.setStrokeWidth(1.0f);
                i5.setStrokeCap(Cap.BUTT);
                i5.setStrokeJoin(Join.MITER);
                i5.setStrokeMiter(4.0f);
                i5.setPathEffect(null);
                float[] a5 = c.a(a3, 121.08f, 0.0f, 0.28f, 0.0f, 129.09f, 0.88f);
                f.reset();
                f.setValues(a5);
                WeChatSVGRenderC2Java.setLinearGradient(a2, 0.5f, 0.0f, 0.5f, 1.0f, new int[]{-20658, -23226}, new float[]{0.0f, 1.0f}, f, 0);
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                canvas.save();
                a4 = c.a(i2, looper);
                a4.setColor(-22969);
                a3 = c.a(a5, 1.0f, 0.0f, 153.0f, 0.0f, 1.0f, 138.0f);
                f.reset();
                f.setValues(a3);
                canvas.concat(f);
                canvas.save();
                a4 = c.a(a4, looper);
                j = c.j(looper);
                j.moveTo(3.17f, 1.12f);
                j.cubicTo(6.64f, -0.54f, 10.35f, 2.71f, 10.99f, 6.07f);
                j.cubicTo(12.04f, 9.41f, 9.92f, 14.07f, 6.01f, 13.89f);
                j.cubicTo(0.05f, 13.46f, -2.23f, 3.93f, 3.17f, 1.12f);
                j.lineTo(3.17f, 1.12f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a4);
                canvas.restore();
                canvas.restore();
                canvas.save();
                a4 = c.a(i2, looper);
                a4.setColor(-23482);
                a3 = c.a(a3, 1.0f, 0.0f, 121.0f, 0.0f, 1.0f, 147.0f);
                f.reset();
                f.setValues(a3);
                canvas.concat(f);
                canvas.save();
                a4 = c.a(a4, looper);
                j = c.j(looper);
                j.moveTo(3.47f, 0.62f);
                j.cubicTo(7.55f, -1.24f, 11.56f, 3.13f, 11.54f, 7.06f);
                j.cubicTo(11.87f, 10.17f, 9.47f, 13.75f, 6.06f, 13.35f);
                j.cubicTo(0.29f, 12.62f, -1.78f, 3.42f, 3.47f, 0.62f);
                j.lineTo(3.47f, 0.62f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a4);
                canvas.restore();
                canvas.restore();
                canvas.save();
                a4 = c.a(i2, looper);
                a4.setColor(-24252);
                a3 = c.a(a3, 1.0f, 0.0f, 122.0f, 0.0f, 1.0f, 160.0f);
                f.reset();
                f.setValues(a3);
                canvas.concat(f);
                canvas.save();
                a4 = c.a(a4, looper);
                j = c.j(looper);
                j.moveTo(0.58f, 14.43f);
                j.cubicTo(17.36f, 9.96f, 34.12f, 5.4f, 50.93f, 0.99f);
                j.cubicTo(51.07f, 11.29f, 45.18f, 21.52f, 35.73f, 25.89f);
                j.cubicTo(23.37f, 32.26f, 6.87f, 26.78f, 0.58f, 14.43f);
                j.lineTo(0.58f, 14.43f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a4);
                canvas.restore();
                canvas.restore();
                i3 = c.a(i2, looper);
                i3.setColor(-2565928);
                canvas.save();
                a4 = c.a(i3, looper);
                j = c.j(looper);
                j.moveTo(149.96889f, 66.49903f);
                j.cubicTo(149.17722f, 47.31203f, 133.37628f, 32.0f, 114.0f, 32.0f);
                j.cubicTo(94.62372f, 32.0f, 78.822784f, 47.31203f, 78.03111f, 66.49903f);
                j.lineTo(78.03111f, 66.49905f);
                j.lineTo(78.0f, 66.49905f);
                j.lineTo(78.0f, 77.49905f);
                j.cubicTo(78.0f, 79.43257f, 79.567f, 81.0f, 81.5f, 81.0f);
                j.cubicTo(83.433f, 81.0f, 85.0f, 79.43257f, 85.0f, 77.49905f);
                j.lineTo(85.0f, 68.00984f);
                j.cubicTo(85.0f, 51.989204f, 97.98374f, 39.001915f, 114.0f, 39.001915f);
                j.cubicTo(130.01625f, 39.001915f, 143.0f, 51.989204f, 143.0f, 68.00984f);
                j.lineTo(143.0f, 77.49905f);
                j.cubicTo(143.0f, 79.43257f, 144.567f, 81.0f, 146.5f, 81.0f);
                j.cubicTo(148.433f, 81.0f, 150.0f, 79.43257f, 150.0f, 77.49905f);
                j.lineTo(150.0f, 66.49905f);
                j.lineTo(149.96889f, 66.49905f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a4);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(149.96889f, 66.49903f);
                j.cubicTo(149.17722f, 47.31203f, 133.37628f, 32.0f, 114.0f, 32.0f);
                j.cubicTo(94.62372f, 32.0f, 78.822784f, 47.31203f, 78.03111f, 66.49903f);
                j.lineTo(78.03111f, 66.49905f);
                j.lineTo(78.0f, 66.49905f);
                j.lineTo(78.0f, 77.49905f);
                j.cubicTo(78.0f, 79.43257f, 79.567f, 81.0f, 81.5f, 81.0f);
                j.cubicTo(83.433f, 81.0f, 85.0f, 79.43257f, 85.0f, 77.49905f);
                j.lineTo(85.0f, 68.00984f);
                j.cubicTo(85.0f, 51.989204f, 97.98374f, 39.001915f, 114.0f, 39.001915f);
                j.cubicTo(130.01625f, 39.001915f, 143.0f, 51.989204f, 143.0f, 68.00984f);
                j.lineTo(143.0f, 77.49905f);
                j.cubicTo(143.0f, 79.43257f, 144.567f, 81.0f, 146.5f, 81.0f);
                j.cubicTo(148.433f, 81.0f, 150.0f, 79.43257f, 150.0f, 77.49905f);
                j.lineTo(150.0f, 66.49905f);
                j.lineTo(149.96889f, 66.49905f);
                j.close();
                i4 = c.i(looper);
                i4.setFlags(385);
                i4.setStyle(Style.FILL);
                i5 = c.i(looper);
                i5.setFlags(385);
                i5.setStyle(Style.STROKE);
                i4.setColor(WebView.NIGHT_MODE_COLOR);
                i5.setStrokeWidth(1.0f);
                i5.setStrokeCap(Cap.BUTT);
                i5.setStrokeJoin(Join.MITER);
                i5.setStrokeMiter(4.0f);
                i5.setPathEffect(null);
                float[] a6 = c.a(a3, 150.0f, 0.0f, 78.0f, 0.0f, 81.0f, 32.0f);
                f.reset();
                f.setValues(a6);
                WeChatSVGRenderC2Java.setLinearGradient(i2, 0.5f, 0.0f, 0.5f, 1.0f, new int[]{-285618, -2524112}, new float[]{0.0f, 1.0f}, f, 0);
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, i2);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
