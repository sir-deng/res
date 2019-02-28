package com.tencent.mm.plugin.mmsight.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.plugin.u.a.b;

public class MMSightCircularProgressBar extends View {
    int duration = 0;
    boolean fBn = false;
    private Paint jbA;
    float oGr = 0.0f;
    int oGs = 0;
    int oGt = 0;
    private RectF oGu;
    b oGv;
    a oGw;
    private int oGx = Color.parseColor("#1AAD19");
    private float strokeWidth = 0.0f;
    private float zA = 0.0f;

    public interface a {
        void bbY();
    }

    public MMSightCircularProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MMSightCircularProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        float dimensionPixelSize = (float) getResources().getDimensionPixelSize(b.oJS);
        this.strokeWidth = (float) getResources().getDimensionPixelSize(b.oJU);
        this.zA = this.strokeWidth / 2.0f;
        this.oGu = new RectF(this.zA, this.zA, dimensionPixelSize - this.zA, dimensionPixelSize - this.zA);
        this.jbA = new Paint();
        this.jbA.setStyle(Style.STROKE);
        this.jbA.setStrokeWidth(this.strokeWidth);
        this.jbA.setColor(this.oGx);
        this.jbA.setAlpha(153);
        this.jbA.setAntiAlias(true);
    }

    protected void onDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.zA, this.zA);
        canvas.rotate(180.0f, this.oGu.right / 2.0f, this.oGu.bottom / 2.0f);
        canvas.drawArc(this.oGu, 90.0f, 360.0f * (this.oGr / ((float) this.oGt)), false, this.jbA);
        canvas.restore();
    }
}
