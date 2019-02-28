package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class apr extends c {
    private final int height = 102;
    private final int width = 84;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 84;
            case 1:
                return 102;
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
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(24.0f, 83.18272f);
                j.cubicTo(24.0f, 82.52952f, 24.529522f, 82.0f, 25.18272f, 82.0f);
                j.lineTo(58.81728f, 82.0f);
                j.cubicTo(59.470478f, 82.0f, 60.0f, 82.52952f, 60.0f, 83.18272f);
                j.lineTo(60.0f, 84.81728f);
                j.cubicTo(60.0f, 85.47048f, 59.470478f, 86.0f, 58.81728f, 86.0f);
                j.lineTo(25.18272f, 86.0f);
                j.cubicTo(24.529522f, 86.0f, 24.0f, 85.47048f, 24.0f, 84.81728f);
                j.lineTo(24.0f, 83.18272f);
                j.close();
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(27.0f, 90.18272f);
                j.cubicTo(27.0f, 89.52952f, 27.529522f, 89.0f, 28.18272f, 89.0f);
                j.lineTo(55.81728f, 89.0f);
                j.cubicTo(56.470478f, 89.0f, 57.0f, 89.52952f, 57.0f, 90.18272f);
                j.lineTo(57.0f, 91.81728f);
                j.cubicTo(57.0f, 92.47048f, 56.470478f, 93.0f, 55.81728f, 93.0f);
                j.lineTo(28.18272f, 93.0f);
                j.cubicTo(27.529522f, 93.0f, 27.0f, 92.47048f, 27.0f, 91.81728f);
                j.lineTo(27.0f, 90.18272f);
                j.close();
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(33.65881f, 99.80592f);
                j.cubicTo(36.252205f, 100.09449f, 38.874313f, 100.24f, 41.51551f, 100.24f);
                j.cubicTo(44.202103f, 100.24f, 46.868923f, 100.08944f, 49.505833f, 99.790924f);
                j.cubicTo(50.738846f, 99.651344f, 51.61502f, 98.62145f, 51.462826f, 97.4906f);
                j.cubicTo(51.31063f, 96.35975f, 50.1877f, 95.55617f, 48.954685f, 95.695755f);
                j.cubicTo(46.50052f, 95.97358f, 44.017757f, 96.11375f, 41.51551f, 96.11375f);
                j.cubicTo(39.05553f, 96.11375f, 36.614365f, 95.97828f, 34.200657f, 95.70971f);
                j.cubicTo(32.967335f, 95.57248f, 31.846228f, 96.3782f, 31.6966f, 97.50934f);
                j.cubicTo(31.546974f, 98.64048f, 32.425484f, 99.66869f, 33.65881f, 99.80592f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 1);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(43.184082f, 59.838116f);
                j.cubicTo(43.89884f, 61.38677f, 46.09968f, 61.387447f, 46.8154f, 59.839237f);
                j.lineTo(51.001774f, 50.783474f);
                j.cubicTo(51.56792f, 52.0063f, 52.126087f, 53.21243f, 52.65766f, 54.361786f);
                j.cubicTo(53.72009f, 56.658962f, 54.580425f, 58.52206f, 55.18319f, 59.831715f);
                j.cubicTo(55.645f, 60.835114f, 56.832783f, 61.274155f, 57.83618f, 60.812344f);
                j.cubicTo(58.839577f, 60.350536f, 59.27862f, 59.16275f, 58.81681f, 58.15935f);
                j.cubicTo(58.212776f, 56.84694f, 57.351562f, 54.98194f, 56.299217f, 52.706562f);
                j.cubicTo(55.528305f, 51.039715f, 54.714195f, 49.280952f, 53.900093f, 47.52319f);
                j.cubicTo(53.61516f, 46.907978f, 53.438774f, 46.52722f, 53.113132f, 45.82436f);
                j.cubicTo(52.86889f, 45.297253f, 52.86889f, 45.297253f, 52.81458f, 45.180077f);
                j.cubicTo(52.09798f, 43.633926f, 49.89969f, 43.635002f, 49.1846f, 45.18185f);
                j.lineTo(45.001472f, 54.230587f);
                j.lineTo(40.815918f, 45.161884f);
                j.cubicTo(40.101242f, 43.61342f, 37.900753f, 43.6125f, 37.184784f, 45.160366f);
                j.lineTo(32.999584f, 54.208397f);
                j.lineTo(28.81507f, 45.166f);
                j.cubicTo(28.351177f, 44.163567f, 27.162483f, 43.72699f, 26.160048f, 44.190884f);
                j.cubicTo(25.157612f, 44.654778f, 24.721037f, 45.84347f, 25.18493f, 46.845905f);
                j.lineTo(31.18493f, 59.81142f);
                j.cubicTo(31.900772f, 61.3583f, 34.099644f, 61.35811f, 34.815216f, 59.811104f);
                j.lineTo(38.998005f, 50.768284f);
                j.lineTo(43.184082f, 59.838116f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 1);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(40.0f, 4.99842f);
                j.cubicTo(40.0f, 3.894723f, 40.89543f, 3.0f, 42.0f, 3.0f);
                j.cubicTo(43.10457f, 3.0f, 44.0f, 3.894723f, 44.0f, 4.99842f);
                j.lineTo(44.0f, 9.00158f);
                j.cubicTo(44.0f, 10.105277f, 43.10457f, 11.0f, 42.0f, 11.0f);
                j.cubicTo(40.89543f, 11.0f, 40.0f, 10.105277f, 40.0f, 9.00158f);
                j.lineTo(40.0f, 4.99842f);
                j.close();
                j.moveTo(77.479294f, 21.129032f);
                j.cubicTo(78.33703f, 20.434452f, 79.59587f, 20.567266f, 80.291f, 21.425678f);
                j.cubicTo(80.98613f, 22.28409f, 80.85431f, 23.543037f, 79.996574f, 24.237616f);
                j.lineTo(76.88554f, 26.756886f);
                j.cubicTo(76.0278f, 27.451466f, 74.76896f, 27.318653f, 74.07383f, 26.460241f);
                j.cubicTo(73.37871f, 25.60183f, 73.51052f, 24.34288f, 74.368256f, 23.648302f);
                j.lineTo(77.479294f, 21.129032f);
                j.close();
                j.moveTo(4.0034227f, 24.237616f);
                j.cubicTo(3.145689f, 23.543037f, 3.0138714f, 22.28409f, 3.7089994f, 21.425678f);
                j.cubicTo(4.4041276f, 20.567266f, 5.6629705f, 20.434452f, 6.5207043f, 21.129032f);
                j.lineTo(9.631744f, 23.648302f);
                j.cubicTo(10.489477f, 24.34288f, 10.621295f, 25.60183f, 9.9261675f, 26.460241f);
                j.cubicTo(9.231039f, 27.318653f, 7.972196f, 27.451466f, 7.1144624f, 26.756886f);
                j.lineTo(4.0034227f, 24.237616f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 1);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(63.002625f, 77.73915f);
                j.cubicTo(71.14804f, 71.332855f, 76.0f, 61.56439f, 76.0f, 51.0f);
                j.cubicTo(76.0f, 32.222317f, 60.777683f, 17.0f, 42.0f, 17.0f);
                j.cubicTo(23.222319f, 17.0f, 8.0f, 32.222317f, 8.0f, 51.0f);
                j.cubicTo(8.0f, 61.605255f, 12.88979f, 71.40733f, 21.088684f, 77.810715f);
                j.cubicTo(21.959215f, 78.4906f, 23.21608f, 78.33606f, 23.895967f, 77.46552f);
                j.cubicTo(24.575857f, 76.59499f, 24.421312f, 75.33813f, 23.550781f, 74.65824f);
                j.cubicTo(16.31238f, 69.00501f, 12.0f, 60.360413f, 12.0f, 51.0f);
                j.cubicTo(12.0f, 34.431458f, 25.431458f, 21.0f, 42.0f, 21.0f);
                j.cubicTo(58.568542f, 21.0f, 72.0f, 34.431458f, 72.0f, 51.0f);
                j.cubicTo(72.0f, 60.324368f, 67.721016f, 68.93926f, 60.52983f, 74.59506f);
                j.cubicTo(59.661613f, 75.27791f, 59.51134f, 76.535286f, 60.194183f, 77.4035f);
                j.cubicTo(60.877026f, 78.27172f, 62.134407f, 78.422f, 63.002625f, 77.73915f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 1);
                canvas.drawPath(j, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
