package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;

public class GyroView extends View {
    private float Wo = (20.0f * getResources().getDisplayMetrics().density);
    private Paint fC = new Paint(1);
    private float yet = 0.0f;
    private float yeu = 0.0f;
    private float yev = (100.0f * getResources().getDisplayMetrics().density);
    private float yew = (40.0f * getResources().getDisplayMetrics().density);
    private float yex = (10.0f * getResources().getDisplayMetrics().density);
    private float yey = (6.0f * getResources().getDisplayMetrics().density);
    private boolean yez = false;

    public GyroView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fC.setStyle(Style.FILL);
        this.fC.setColor(-4737097);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float measuredWidth = ((float) getMeasuredWidth()) / 2.0f;
        float measuredHeight = ((float) getMeasuredHeight()) / 2.0f;
        if (this.yeu > 0.0f) {
            canvas.drawCircle(measuredWidth, measuredHeight, (this.yex / 2.0f) - ((this.yeu * (this.yex - this.yey)) / 2.0f), this.fC);
            canvas.drawCircle(measuredWidth - (this.yeu * this.Wo), measuredHeight, this.yey / 2.0f, this.fC);
            canvas.drawCircle(measuredWidth + (this.yeu * this.Wo), measuredHeight, this.yey / 2.0f, this.fC);
            return;
        }
        canvas.drawCircle(measuredWidth, measuredHeight, (this.yet * this.yex) / 2.0f, this.fC);
    }

    public final void aC(float f) {
        float f2 = (f - this.yew) / (this.yev - this.yew);
        if (this.yez) {
            f2 = 1.0f - f2;
        }
        this.yeu = Math.max(0.0f, Math.min(f2, 1.0f));
        f2 = f / this.yew;
        if (this.yez) {
            f2 = 1.0f - f2;
        }
        this.yet = Math.max(0.0f, Math.min(f2, 1.0f));
        postInvalidate();
    }
}
