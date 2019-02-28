package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.mm.bu.a;

public class LineLinearLayout extends LinearLayout {
    private Paint fC;
    private Rect fD;
    private int leu;

    public LineLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LineLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setWillNotDraw(false);
        this.fD = new Rect();
        this.fC = new Paint();
        this.fC.setStyle(Style.STROKE);
        this.fC.setColor(-571543826);
        this.fC.setStrokeWidth((float) Math.round(a.getDensity(getContext()) * 0.5f));
        this.leu = a.fromDPToPix(context, 44);
    }

    protected void onDraw(Canvas canvas) {
        int measuredHeight = getMeasuredHeight();
        Paint paint = this.fC;
        int i = 1;
        while (true) {
            int i2 = i;
            if (this.leu * i2 < measuredHeight) {
                canvas.drawLine(0.0f, (float) (this.leu * i2), (float) getMeasuredWidth(), (float) (this.leu * i2), paint);
                i = i2 + 1;
            } else {
                super.onDraw(canvas);
                return;
            }
        }
    }
}
