package com.tencent.mm.plugin.mmsight.ui.progressbar;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;

public final class b {
    ValueAnimator kco;
    public a oJA;
    PointF oJB;
    PointF oJC;
    PointF oJD;
    PointF oJE;
    PointF oJF;
    PointF oJG;
    float oJH = 0.0f;
    float oJI = 0.0f;
    float oJJ = 0.0f;
    float oJK = 0.0f;
    Path oJL;
    private Paint oJM = null;
    float oJw = 0.0f;
    a oJx;
    a oJy;
    boolean oJz = false;

    public interface a {
        void a(a aVar);

        void bcq();
    }

    public b(a aVar, a aVar2, a aVar3) {
        this.oJx = aVar;
        this.oJy = aVar2;
        this.oJA = aVar3;
        this.oJI = ((float) MMSightProgressBar.mdI) * 2.0f;
        this.oJJ = ((float) (-MMSightProgressBar.mdI)) * 0.5f;
        this.oJL = new Path();
        this.oJM = new Paint();
        this.oJM.setAntiAlias(true);
        this.oJM.setStyle(Style.FILL);
    }
}
