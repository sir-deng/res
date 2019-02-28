package com.tencent.mm.plugin.mmsight.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class CameraFrontSightView extends View {
    Paint fC = new Paint();
    int kaG;
    public int mHeight;
    public int mWidth;
    boolean oGi = false;
    boolean oGj = false;
    boolean oGk = false;
    boolean oGl = false;
    long oGm = 0;
    int oGn;
    int oGo;
    LayoutParams oGp;

    public CameraFrontSightView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public CameraFrontSightView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void draw(Canvas canvas) {
        canvas.translate((float) (this.oGn / 2), (float) (this.oGo / 2));
        long currentTimeMillis = System.currentTimeMillis() - this.oGm;
        if (currentTimeMillis > 200) {
            this.oGi = false;
            this.oGj = true;
        }
        if (currentTimeMillis > 800) {
            this.oGj = false;
            this.oGk = true;
        }
        if (currentTimeMillis > 1100) {
            this.oGk = false;
            this.oGl = true;
        }
        if (currentTimeMillis > 1300) {
            this.oGl = false;
            setVisibility(8);
            return;
        }
        float f;
        if (this.oGi) {
            f = (((float) (200 - currentTimeMillis)) / 200.0f) + 1.0f;
            canvas.scale(f, f, (float) (this.oGn / 2), (float) (this.oGo / 2));
            this.fC.setAlpha((int) ((2.0f - f) * 255.0f));
        } else {
            canvas.scale(1.0f, 1.0f);
        }
        if (this.oGj) {
            f = (((float) ((currentTimeMillis - 200) % 200)) / 200.0f) * 2.0f;
            this.fC.setAlpha((int) (((f > 1.0f ? f - 1.0f : 1.0f - f) * 128.0f) + 127.0f));
        } else {
            this.fC.setAlpha(255);
        }
        if (this.oGl) {
            this.fC.setAlpha((int) ((1.0f - (((float) (currentTimeMillis - 1100)) / 200.0f)) * 255.0f));
        }
        canvas.drawLine(0.0f, 0.0f, (float) this.oGn, 0.0f, this.fC);
        canvas.drawLine(0.0f, 0.0f, 0.0f, (float) this.oGo, this.fC);
        canvas.drawLine((float) this.oGn, 0.0f, (float) this.oGn, (float) this.oGo, this.fC);
        canvas.drawLine(0.0f, (float) this.oGo, (float) this.oGn, (float) this.oGo, this.fC);
        canvas.drawLine(0.0f, (float) (this.oGo / 2), (float) (this.oGn / 10), (float) (this.oGo / 2), this.fC);
        canvas.drawLine((float) this.oGn, (float) (this.oGo / 2), (float) ((this.oGn * 9) / 10), (float) (this.oGo / 2), this.fC);
        canvas.drawLine((float) (this.oGn / 2), 0.0f, (float) (this.oGn / 2), (float) (this.oGo / 10), this.fC);
        canvas.drawLine((float) (this.oGn / 2), (float) this.oGo, (float) (this.oGn / 2), (float) ((this.oGo * 9) / 10), this.fC);
        invalidate();
    }
}
