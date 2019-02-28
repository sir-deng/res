package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

public class NewPullDownView extends View {
    private float yeA = (20.0f * getResources().getDisplayMetrics().density);
    private float yeB = ((14.0f * getResources().getDisplayMetrics().density) - (getResources().getDisplayMetrics().density * 4.0f));
    private Paint yeC = new Paint(1);
    private Paint yeD;
    private float yet = 0.0f;
    private boolean yez = false;

    public NewPullDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.yeC.setStyle(Style.FILL);
        this.yeC.setColor(-4408132);
        this.yeD = new Paint(1);
        this.yeD.setStyle(Style.STROKE);
        this.yeD.setColor(0);
        this.yeD.setStrokeWidth(getResources().getDisplayMetrics().density * 4.0f);
        this.yeD.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float measuredWidth = (float) (getMeasuredWidth() / 2);
        float measuredHeight = (float) (getMeasuredHeight() / 2);
        canvas.saveLayer(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), null, 31);
        canvas.drawCircle(measuredWidth, measuredHeight, (this.yet * this.yeA) / 2.0f, this.yeC);
        if (this.yet >= 0.4f) {
            canvas.drawCircle(measuredWidth, measuredHeight, (((this.yet - 0.4f) / 0.6f) * this.yeB) / 2.0f, this.yeD);
        }
        canvas.restore();
    }
}
