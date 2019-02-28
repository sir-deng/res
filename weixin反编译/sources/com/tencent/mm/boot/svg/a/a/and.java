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

public final class and extends c {
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
                e = c.a(e, 1.0f, 0.0f, 16.0f, 0.0f, 1.0f, 16.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-16731650);
                Path j = c.j(looper);
                j.moveTo(34.912872f, 17.558449f);
                j.cubicTo(34.91382f, 17.558449f, 34.915707f, 17.558449f, 34.916653f, 17.559427f);
                j.cubicTo(35.271107f, 17.633741f, 35.624615f, 17.723701f, 35.97434f, 17.826374f);
                j.cubicTo(35.975285f, 17.826374f, 35.975285f, 17.826374f, 35.97623f, 17.82735f);
                j.cubicTo(36.27397f, 17.914377f, 36.566982f, 18.02096f, 36.859997f, 18.1295f);
                j.cubicTo(36.96397f, 18.168612f, 37.06983f, 18.201859f, 37.17286f, 18.242928f);
                j.cubicTo(37.471546f, 18.361244f, 37.76456f, 18.495205f, 38.05663f, 18.634056f);
                j.cubicTo(38.13697f, 18.67317f, 38.21731f, 18.709349f, 38.29671f, 18.74944f);
                j.cubicTo(38.611465f, 18.907846f, 38.9196f, 19.078966f, 39.224903f, 19.26182f);
                j.cubicTo(39.26555f, 19.286264f, 39.30619f, 19.31071f, 39.34589f, 19.336134f);
                j.cubicTo(39.737206f, 19.5757f, 40.11718f, 19.83678f, 40.48959f, 20.118393f);
                j.cubicTo(40.62381f, 20.217154f, 40.758026f, 20.314936f, 40.888466f, 20.421518f);
                j.cubicTo(40.889412f, 20.422497f, 40.8913f, 20.423475f, 40.892246f, 20.424452f);
                j.cubicTo(40.99433f, 20.508545f, 41.09736f, 20.590683f, 41.198494f, 20.67771f);
                j.cubicTo(41.53215f, 20.964212f, 41.857304f, 21.263426f, 42.16922f, 21.586107f);
                j.cubicTo(42.444275f, 21.870655f, 42.69759f, 22.167913f, 42.941456f, 22.47006f);
                j.cubicTo(43.061497f, 22.614779f, 43.179646f, 22.761452f, 43.29307f, 22.910082f);
                j.cubicTo(43.29307f, 22.910082f, 43.294018f, 22.91106f, 43.29496f, 22.912037f);
                j.cubicTo(43.347893f, 22.981462f, 43.394207f, 23.0548f, 43.446194f, 23.125204f);
                j.cubicTo(43.44714f, 23.12618f, 43.448086f, 23.12716f, 43.448086f, 23.128138f);
                j.cubicTo(43.76284f, 23.556423f, 44.050182f, 23.9984f, 44.31295f, 24.45211f);
                j.cubicTo(44.313892f, 24.454067f, 44.31484f, 24.455044f, 44.315784f, 24.457f);
                j.cubicTo(44.44244f, 24.674076f, 44.57477f, 24.88822f, 44.690086f, 25.111164f);
                j.cubicTo(44.690086f, 25.111164f, 44.690086f, 25.112143f, 44.691032f, 25.112143f);
                j.cubicTo(44.74302f, 25.213837f, 44.785553f, 25.318462f, 44.8347f, 25.421135f);
                j.lineTo(44.835648f, 25.422112f);
                j.cubicTo(44.96892f, 25.697859f, 45.094635f, 25.97654f, 45.210896f, 26.258152f);
                j.lineTo(45.21373f, 26.264997f);
                j.cubicTo(45.31959f, 26.52412f, 45.411278f, 26.787155f, 45.502964f, 27.051168f);
                j.cubicTo(45.536045f, 27.150906f, 45.57102f, 27.249666f, 45.603153f, 27.349403f);
                j.cubicTo(45.739265f, 27.771824f, 45.855526f, 28.198156f, 45.95288f, 28.629375f);
                j.cubicTo(45.987854f, 28.774094f, 46.027554f, 28.918812f, 46.05591f, 29.065485f);
                j.cubicTo(46.056854f, 29.07233f, 46.058743f, 29.078197f, 46.060635f, 29.085043f);
                j.cubicTo(46.060635f, 29.08602f, 46.060635f, 29.087976f, 46.06158f, 29.089931f);
                j.lineTo(46.06158f, 29.09091f);
                j.lineTo(60.1943f, 29.09091f);
                j.cubicTo(61.306812f, 29.09091f, 62.360718f, 28.410343f, 62.81347f, 27.280956f);
                j.cubicTo(63.266224f, 26.15157f, 62.985497f, 24.897999f, 62.199085f, 24.084448f);
                j.lineTo(39.748547f, 0.8591668f);
                j.cubicTo(38.962135f, 0.04561703f, 37.751328f, -0.24381895f, 36.659615f, 0.22455887f);
                j.cubicTo(35.5679f, 0.69195884f, 34.908146f, 1.7832108f, 34.909092f, 2.93411f);
                j.lineTo(34.909092f, 17.554539f);
                j.lineTo(34.910038f, 17.554539f);
                j.cubicTo(34.911926f, 17.558449f, 34.912872f, 17.558449f, 34.912872f, 17.558449f);
                j.lineTo(34.912872f, 17.558449f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                a = c.a(i2, looper);
                a.setColor(-499359);
                j = c.j(looper);
                j.moveTo(27.98998f, 46.179195f);
                j.cubicTo(27.8091f, 46.12835f, 27.63213f, 46.067726f, 27.454182f, 46.010036f);
                j.cubicTo(27.223438f, 45.934746f, 26.992693f, 45.855545f, 26.764881f, 45.76852f);
                j.cubicTo(26.593777f, 45.703007f, 26.422674f, 45.637497f, 26.253525f, 45.56514f);
                j.cubicTo(25.971937f, 45.445847f, 25.694262f, 45.314823f, 25.418541f, 45.17793f);
                j.cubicTo(25.314901f, 45.126106f, 25.208328f, 45.081127f, 25.105665f, 45.02637f);
                j.cubicTo(24.739016f, 44.83179f, 24.381165f, 44.616673f, 24.028204f, 44.389824f);
                j.cubicTo(23.90892f, 44.31258f, 23.79257f, 44.229465f, 23.674263f, 44.148308f);
                j.cubicTo(23.413208f, 43.96937f, 23.15802f, 43.781635f, 22.906742f, 43.584118f);
                j.cubicTo(22.798214f, 43.49905f, 22.689686f, 43.41496f, 22.583113f, 43.32598f);
                j.cubicTo(22.23895f, 43.039486f, 21.90261f, 42.741257f, 21.579958f, 42.418583f);
                j.cubicTo(21.257305f, 42.09591f, 20.958118f, 41.758568f, 20.671642f, 41.414383f);
                j.cubicTo(20.583647f, 41.30878f, 20.50054f, 41.201225f, 20.416454f, 41.093666f);
                j.cubicTo(20.216997f, 40.840416f, 20.028294f, 40.58228f, 19.847414f, 40.31925f);
                j.cubicTo(19.768217f, 40.20387f, 19.687065f, 40.089466f, 19.610802f, 39.97311f);
                j.cubicTo(19.38299f, 39.619144f, 19.16691f, 39.259315f, 18.972342f, 38.891663f);
                j.cubicTo(18.919544f, 38.791927f, 18.875546f, 38.688282f, 18.825682f, 38.58757f);
                j.cubicTo(18.685865f, 38.308895f, 18.553871f, 38.02729f, 18.43361f, 37.74177f);
                j.cubicTo(18.363213f, 37.57457f, 18.297705f, 37.406387f, 18.233175f, 37.23723f);
                j.cubicTo(18.145178f, 37.00549f, 18.065004f, 36.772774f, 17.98874f, 36.5381f);
                j.cubicTo(17.932034f, 36.36308f, 17.87239f, 36.18903f, 17.822527f, 36.01107f);
                j.cubicTo(17.719864f, 35.64635f, 17.627958f, 35.278698f, 17.55365f, 34.909092f);
                j.lineTo(2.9335957f, 34.909092f);
                j.cubicTo(1.7837806f, 34.909092f, 0.6926297f, 35.589638f, 0.22429515f, 36.72095f);
                j.cubicTo(-0.24403936f, 37.848354f, 0.046347596f, 39.10189f, 0.85982215f, 39.91542f);
                j.lineTo(24.083935f, 63.141064f);
                j.cubicTo(24.896431f, 63.953617f, 26.149885f, 64.24402f, 27.27917f, 63.775658f);
                j.cubicTo(28.408451f, 63.30827f, 29.09091f, 62.218025f, 29.09091f, 61.066177f);
                j.lineTo(29.09091f, 46.447113f);
                j.cubicTo(29.0782f, 46.445156f, 29.066465f, 46.441246f, 29.054733f, 46.438313f);
                j.cubicTo(28.694927f, 46.365955f, 28.340986f, 46.27893f, 27.98998f, 46.179195f);
                j.lineTo(27.98998f, 46.179195f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                a = c.a(i2, looper);
                a.setColor(-16074232);
                j = c.j(looper);
                j.moveTo(61.062687f, 34.909092f);
                j.lineTo(46.443386f, 34.909092f);
                j.cubicTo(46.431652f, 34.967766f, 46.41405f, 35.024483f, 46.40134f, 35.082176f);
                j.cubicTo(46.33387f, 35.392166f, 46.260536f, 35.702156f, 46.175465f, 36.00921f);
                j.cubicTo(46.175465f, 36.01019f, 46.174488f, 36.011166f, 46.174488f, 36.012142f);
                j.cubicTo(46.086483f, 36.322132f, 45.978924f, 36.62821f, 45.86941f, 36.933308f);
                j.cubicTo(45.83421f, 37.03403f, 45.80194f, 37.134754f, 45.764782f, 37.234497f);
                j.cubicTo(45.763805f, 37.23645f, 45.76283f, 37.238407f, 45.76283f, 37.240364f);
                j.cubicTo(45.699272f, 37.408558f, 45.63376f, 37.5748f, 45.563354f, 37.74104f);
                j.cubicTo(45.563354f, 37.74104f, 45.563354f, 37.74104f, 45.563354f, 37.742016f);
                j.cubicTo(45.443085f, 38.025604f, 45.312057f, 38.3043f, 45.174183f, 38.58104f);
                j.cubicTo(45.174183f, 38.58104f, 45.173206f, 38.58202f, 45.173206f, 38.582996f);
                j.cubicTo(45.12236f, 38.684696f, 45.078358f, 38.788353f, 45.025555f, 38.889072f);
                j.cubicTo(45.025555f, 38.890053f, 45.02458f, 38.890053f, 45.02458f, 38.89103f);
                j.cubicTo(44.90626f, 39.113987f, 44.76839f, 39.328144f, 44.637363f, 39.54523f);
                j.cubicTo(44.363575f, 40.001904f, 44.064365f, 40.44586f, 43.737774f, 40.87711f);
                j.cubicTo(43.683994f, 40.947517f, 43.63608f, 41.01988f, 43.581326f, 41.090286f);
                j.cubicTo(43.580345f, 41.091263f, 43.57937f, 41.092243f, 43.57937f, 41.092243f);
                j.cubicTo(43.219532f, 41.549892f, 42.838184f, 41.994827f, 42.416748f, 42.416294f);
                j.cubicTo(41.129944f, 43.70319f, 39.659313f, 44.68694f, 38.09481f, 45.399815f);
                j.cubicTo(37.97747f, 45.454575f, 37.86111f, 45.51325f, 37.742798f, 45.56312f);
                j.lineTo(37.742798f, 45.56312f);
                j.cubicTo(37.573635f, 45.634506f, 37.403496f, 45.701004f, 37.233356f, 45.76554f);
                j.cubicTo(37.233356f, 45.76554f, 37.232376f, 45.76554f, 37.2314f, 45.76652f);
                j.cubicTo(37.165886f, 45.790966f, 37.099396f, 45.811504f, 37.033882f, 45.834972f);
                j.cubicTo(36.69458f, 45.958187f, 36.3543f, 46.078465f, 36.008156f, 46.176254f);
                j.lineTo(36.008156f, 46.176254f);
                j.cubicTo(35.644405f, 46.27893f, 35.277725f, 46.369873f, 34.909092f, 46.44419f);
                j.lineTo(34.909092f, 61.06549f);
                j.cubicTo(34.909092f, 62.217438f, 35.58965f, 63.307774f, 36.72f, 63.775204f);
                j.cubicTo(37.8484f, 64.24458f, 39.102936f, 63.95318f, 39.9155f, 63.140556f);
                j.lineTo(63.14054f, 39.913895f);
                j.cubicTo(63.954082f, 39.09932f, 64.243515f, 37.84763f, 63.77612f, 36.718174f);
                j.cubicTo(63.304813f, 35.5897f, 62.213573f, 34.908115f, 61.062687f, 34.909092f);
                j.lineTo(61.062687f, 34.909092f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                a = c.a(i2, looper);
                a.setColor(-212971);
                j = c.j(looper);
                j.moveTo(2.9339895f, 29.09091f);
                j.lineTo(17.554485f, 29.09091f);
                j.cubicTo(18.108913f, 26.34041f, 19.44854f, 23.715067f, 21.581184f, 21.581549f);
                j.cubicTo(23.714806f, 19.44803f, 26.339298f, 18.108469f, 29.09091f, 17.554068f);
                j.lineTo(29.09091f, 2.9342813f);
                j.cubicTo(29.09091f, 1.7834328f, 28.41034f, 0.6922289f, 27.280949f, 0.22387168f);
                j.cubicTo(26.152534f, -0.24350779f, 24.89798f, 0.04591548f, 24.084425f, 0.85942954f);
                j.lineTo(0.85903686f, 24.08369f);
                j.cubicTo(0.045483325f, 24.897205f, -0.24297616f, 26.15072f, 0.22344816f, 27.27908f);
                j.cubicTo(0.69182813f, 28.410374f, 1.7830851f, 29.09091f, 2.9339895f, 29.09091f);
                j.lineTo(2.9339895f, 29.09091f);
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
