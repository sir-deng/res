package com.tencent.mm.plugin.appbrand.jsapi.l;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.animation.DecelerateInterpolator;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.math.BigDecimal;
import org.json.JSONObject;

public final class b extends a {
    private static final int CTRL_INDEX = 413;
    public static final String NAME = "scrollWebviewTo";

    public final void a(p pVar, JSONObject jSONObject, int i) {
        final long optLong = jSONObject.optLong(FFmpegMetadataRetriever.METADATA_KEY_DURATION, 300);
        if (jSONObject.has("scrollTop")) {
            try {
                final int round = Math.round(f.ac(new BigDecimal(jSONObject.getString("scrollTop")).floatValue()));
                final p pVar2 = pVar;
                final int i2 = i;
                ah.y(new Runnable() {
                    public final void run() {
                        t tVar = pVar2.jJw;
                        int i = round;
                        long j = optLong;
                        if (tVar.jKB != null) {
                            tVar.jKB.cancel();
                            tVar.jKB = null;
                        }
                        Animator ofInt = ValueAnimator.ofInt(new int[]{tVar.getView().getScrollY(), i});
                        ofInt.addUpdateListener(new AnimatorUpdateListener() {
                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                t.this.getView().setScrollY(((Integer) valueAnimator.getAnimatedValue()).intValue());
                            }
                        });
                        ofInt.setInterpolator(new DecelerateInterpolator());
                        ofInt.setDuration(j);
                        ofInt.start();
                        tVar.jKB = ofInt;
                        pVar2.E(i2, b.this.e("ok", null));
                    }
                });
                return;
            } catch (Exception e) {
                x.e("MicroMsg.AppBrand.Jsapi_scrollWebviewTo", "opt scrollTop, e = %s", e);
                pVar.E(i, e("fail:invalid data " + bi.oM(e.getMessage()), null));
                return;
            }
        }
        pVar.E(i, e("fail:invalid data", null));
    }
}
