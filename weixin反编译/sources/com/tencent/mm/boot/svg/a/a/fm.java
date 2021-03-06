package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.q;
import com.tencent.mm.plugin.appbrand.jsapi.voicejoint.JsApiDownloadSilkVoice;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class fm extends c {
    private final int height = q.CTRL_INDEX;
    private final int width = JsApiDownloadSilkVoice.CTRL_INDEX;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return JsApiDownloadSilkVoice.CTRL_INDEX;
            case 1:
                return q.CTRL_INDEX;
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
                canvas.save();
                i3 = c.a(i2, looper);
                i3.setColor(WebView.NIGHT_MODE_COLOR);
                Path j = c.j(looper);
                j.moveTo(133.0f, 120.0f);
                j.lineTo(133.0f, 45.0f);
                j.lineTo(305.0f, 45.0f);
                j.lineTo(305.0f, 318.0f);
                j.lineTo(133.0f, 318.0f);
                j.lineTo(133.0f, 225.46962f);
                j.lineTo(134.5f, 225.46962f);
                j.lineTo(134.5f, 316.5f);
                j.lineTo(303.5f, 316.5f);
                j.lineTo(303.5f, 46.5f);
                j.lineTo(134.5f, 46.5f);
                j.lineTo(134.5f, 120.0f);
                j.lineTo(133.0f, 120.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, i3);
                canvas.restore();
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                Path j2 = c.j(looper);
                j2.moveTo(120.0f, 120.0f);
                j2.lineTo(120.0f, 21.991756f);
                j2.cubicTo(120.0f, 13.170865f, 127.1606f, 6.0f, 135.99364f, 6.0f);
                j2.lineTo(302.00635f, 6.0f);
                j2.cubicTo(310.8361f, 6.0f, 318.0f, 13.159754f, 318.0f, 21.991756f);
                j2.lineTo(318.0f, 350.00824f);
                j2.cubicTo(318.0f, 358.82913f, 310.83942f, 366.0f, 302.00635f, 366.0f);
                j2.lineTo(135.99364f, 366.0f);
                j2.cubicTo(127.1639f, 366.0f, 120.0f, 358.84024f, 120.0f, 350.00824f);
                j2.lineTo(120.0f, 225.46962f);
                j2.lineTo(123.0f, 225.46962f);
                j2.lineTo(123.0f, 350.00754f);
                j2.cubicTo(123.0f, 357.18307f, 128.82472f, 363.0f, 136.00838f, 363.0f);
                j2.lineTo(301.99164f, 363.0f);
                j2.cubicTo(309.17596f, 363.0f, 315.0f, 357.18747f, 315.0f, 350.00754f);
                j2.lineTo(315.0f, 21.992458f);
                j2.cubicTo(315.0f, 14.816921f, 309.17526f, 9.0f, 301.99164f, 9.0f);
                j2.lineTo(136.00838f, 9.0f);
                j2.cubicTo(128.82405f, 9.0f, 123.0f, 14.812543f, 123.0f, 21.992458f);
                j2.lineTo(123.0f, 120.0f);
                j2.lineTo(120.0f, 120.0f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a);
                canvas.restore();
                canvas.save();
                i3 = c.a(i2, looper);
                i3.setColor(WebView.NIGHT_MODE_COLOR);
                j = c.j(looper);
                j.moveTo(206.0f, 24.0f);
                j.lineTo(232.0f, 24.0f);
                j.lineTo(232.0f, 27.0f);
                j.lineTo(206.0f, 27.0f);
                j.lineTo(206.0f, 24.0f);
                j.close();
                canvas.drawPath(j, i3);
                canvas.restore();
                canvas.save();
                a = c.a(i2, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                j2 = c.j(looper);
                j2.moveTo(60.651176f, 249.89926f);
                j2.lineTo(60.595497f, 225.46962f);
                j2.lineTo(33.888363f, 225.46962f);
                j2.cubicTo(27.33306f, 225.46962f, 22.0f, 220.17123f, 22.0f, 213.65854f);
                j2.lineTo(22.0f, 131.81108f);
                j2.cubicTo(22.0f, 125.298386f, 27.33306f, 120.0f, 33.888363f, 120.0f);
                j2.lineTo(160.11163f, 120.0f);
                j2.cubicTo(166.66695f, 120.0f, 172.0f, 125.298386f, 172.0f, 131.81108f);
                j2.lineTo(172.0f, 213.65854f);
                j2.cubicTo(172.0f, 220.17123f, 166.66695f, 225.46962f, 160.11163f, 225.46962f);
                j2.lineTo(97.138374f, 225.46962f);
                j2.lineTo(69.358574f, 253.56952f);
                j2.cubicTo(68.354385f, 254.50647f, 67.109116f, 254.99985f, 65.80787f, 255.0f);
                j2.cubicTo(62.971363f, 255.0003f, 60.6581f, 252.7121f, 60.651176f, 249.89926f);
                j2.close();
                j2.moveTo(63.58853f, 247.54555f);
                j2.lineTo(63.608063f, 222.6283f);
                j2.lineTo(36.50444f, 222.48622f);
                j2.cubicTo(28.85407f, 222.5878f, 25.13076f, 218.84735f, 25.09161f, 211.1126f);
                j2.lineTo(25.0f, 134.37363f);
                j2.cubicTo(25.132122f, 125.48259f, 30.013842f, 122.979996f, 36.41283f, 123.0f);
                j2.lineTo(157.58717f, 123.0f);
                j2.cubicTo(167.20503f, 123.0f, 169.02705f, 128.21953f, 169.0f, 134.37363f);
                j2.lineTo(169.09161f, 211.1126f);
                j2.cubicTo(169.11636f, 218.63168f, 166.0281f, 222.59373f, 157.67879f, 222.48622f);
                j2.lineTo(95.95168f, 222.58171f);
                j2.lineTo(68.555214f, 250.40294f);
                j2.cubicTo(67.59119f, 251.30519f, 66.85377f, 251.84087f, 65.63155f, 251.84087f);
                j2.cubicTo(63.608063f, 251.86566f, 63.595177f, 250.2542f, 63.58853f, 247.54555f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-15028967);
                j2 = c.j(looper);
                j2.moveTo(97.0f, 204.0f);
                j2.cubicTo(115.225395f, 204.0f, 130.0f, 189.2254f, 130.0f, 171.0f);
                j2.cubicTo(130.0f, 152.7746f, 115.225395f, 138.0f, 97.0f, 138.0f);
                j2.cubicTo(78.774605f, 138.0f, 64.0f, 152.7746f, 64.0f, 171.0f);
                j2.cubicTo(64.0f, 189.2254f, 78.774605f, 204.0f, 97.0f, 204.0f);
                j2.close();
                j2.moveTo(97.0f, 201.0f);
                j2.cubicTo(113.56854f, 201.0f, 127.0f, 187.56854f, 127.0f, 171.0f);
                j2.cubicTo(127.0f, 154.43146f, 113.56854f, 141.0f, 97.0f, 141.0f);
                j2.cubicTo(80.43146f, 141.0f, 67.0f, 154.43146f, 67.0f, 171.0f);
                j2.cubicTo(67.0f, 187.56854f, 80.43146f, 201.0f, 97.0f, 201.0f);
                j2.close();
                j2.moveTo(82.31152f, 173.40608f);
                j2.cubicTo(81.86357f, 172.9451f, 81.729256f, 172.10045f, 82.01039f, 171.52182f);
                j2.lineTo(82.17488f, 171.18329f);
                j2.cubicTo(82.54736f, 170.41664f, 83.411705f, 170.20854f, 84.10319f, 170.71681f);
                j2.lineTo(91.037735f, 175.81412f);
                j2.cubicTo(91.730225f, 176.32314f, 92.825096f, 176.2897f, 93.4827f, 175.73987f);
                j2.lineTo(112.97404f, 159.44258f);
                j2.cubicTo(113.47103f, 159.02704f, 114.234566f, 159.05884f, 114.6887f, 159.52309f);
                j2.lineTo(114.48831f, 159.31824f);
                j2.cubicTo(114.9383f, 159.77824f, 114.941635f, 160.52068f, 114.4841f, 160.98842f);
                j2.lineTo(93.37062f, 182.57329f);
                j2.cubicTo(92.77469f, 183.18251f, 91.81399f, 183.1849f, 91.20749f, 182.56076f);
                j2.lineTo(82.31152f, 173.40608f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, i2);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
