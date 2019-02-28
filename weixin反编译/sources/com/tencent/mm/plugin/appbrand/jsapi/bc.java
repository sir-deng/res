package com.tencent.mm.plugin.appbrand.jsapi;

import android.animation.ArgbEvaluator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class bc extends a {
    public static final int CTRL_INDEX = 198;
    public static final String NAME = "setNavigationBarColor";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        try {
            long uW = com.tencent.mm.plugin.appbrand.ui.j.uW(jSONObject.getString("frontColor"));
            if (uW == -1) {
                throw new Exception();
            }
            int i2 = (int) uW;
            uW = com.tencent.mm.plugin.appbrand.ui.j.uW(jSONObject.getString("backgroundColor"));
            if (uW == -1) {
                throw new Exception();
            }
            int i3 = (int) uW;
            double optDouble = jSONObject.optDouble("alpha", 1.0d);
            int i4 = 0;
            Object obj = "";
            JSONObject optJSONObject = jSONObject.optJSONObject("animation");
            if (optJSONObject != null) {
                i4 = optJSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION);
                obj = optJSONObject.optString("timingFunc");
            }
            final p b = e.b(jVar);
            if (b == null) {
                jVar.E(i, e("fail:no page for now", null));
                return;
            }
            int backgroundColor = b.jJr.getBackgroundColor();
            int foregroundColor = b.jJr.getForegroundColor();
            double amS = b.jJr.amS();
            TimeInterpolator linearInterpolator = "linear".equals(obj) ? new LinearInterpolator() : "easeIn".equals(obj) ? new AccelerateInterpolator() : "easeOut".equals(obj) ? new DecelerateInterpolator() : "easeInOut".equals(obj) ? new AccelerateDecelerateInterpolator() : null;
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setIntValues(new int[]{backgroundColor, i3});
            valueAnimator.setEvaluator(new ArgbEvaluator());
            valueAnimator.setDuration((long) i4);
            valueAnimator.setInterpolator(linearInterpolator);
            valueAnimator.addUpdateListener(new AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    b.kl(((Integer) valueAnimator.getAnimatedValue()).intValue());
                    b.kj(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
            ValueAnimator valueAnimator2 = new ValueAnimator();
            valueAnimator2.setIntValues(new int[]{foregroundColor, i2});
            valueAnimator2.setEvaluator(new ArgbEvaluator());
            valueAnimator2.setDuration((long) i4);
            valueAnimator2.setInterpolator(linearInterpolator);
            valueAnimator2.addUpdateListener(new AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    b.kk(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
            ValueAnimator valueAnimator3 = new ValueAnimator();
            valueAnimator3.setFloatValues(new float[]{(float) amS, (float) optDouble});
            valueAnimator3.setDuration((long) i4);
            valueAnimator3.setInterpolator(linearInterpolator);
            valueAnimator3.addUpdateListener(new AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    b.i((double) ((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
            valueAnimator.start();
            valueAnimator2.start();
            jVar.E(i, e("ok", null));
        } catch (Exception e) {
            x.e("MicroMsg.JsApiSetNavigationBarColor", "Color parse error");
            jVar.E(i, e("fail", null));
        }
    }
}
