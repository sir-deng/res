package com.tencent.mm.plugin.sns.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.SystemClock;
import com.tencent.mm.memory.a.a;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.sns.data.i;
import java.util.HashMap;
import java.util.Map;

public final class ah extends a {
    int alpha = 255;
    long naG;
    boolean naH = false;
    private Map<String, Boolean> rda = new HashMap();

    public ah(String str, n nVar, long j) {
        super(str, nVar);
        if (j != 0) {
            this.naG = j;
            this.rda.put(str, Boolean.valueOf(true));
            this.naH = true;
        } else if (!this.rda.containsKey(str)) {
            this.naG = SystemClock.uptimeMillis();
            this.rda.put(str, Boolean.valueOf(true));
            this.naH = true;
        }
    }

    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        Bitmap EK = this.hcc.EK();
        if (i.m(EK)) {
            if (this.naH) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.naG)) / 150.0f;
                if (this.naG == 0) {
                    uptimeMillis = 0.0f;
                }
                if (uptimeMillis >= 1.0f) {
                    this.naH = false;
                } else {
                    hca.setAlpha((int) (uptimeMillis * ((float) this.alpha)));
                    canvas.drawBitmap(EK, null, bounds, hca);
                    invalidateSelf();
                    return;
                }
            }
            hca.setAlpha(this.alpha);
            canvas.drawBitmap(EK, null, bounds, hca);
            return;
        }
        canvas.drawColor(-1118482);
        this.naG = 0;
    }
}
