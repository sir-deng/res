package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.wcdb.FileUtils;

public class TabIconView extends ImageView {
    private Paint jbA;
    private Bitmap xVA;
    private Bitmap xVB;
    private Rect xVC;
    private Rect xVD;
    private Rect xVE;
    private int xVF = 0;
    private Bitmap xVz;

    public TabIconView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public TabIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void g(int i, int i2, int i3, boolean z) {
        if (z) {
            this.xVz = d.Dt(i);
            this.xVA = d.Dt(i3);
            this.xVB = d.Dt(i2);
        } else {
            this.xVz = d.Ds(i);
            this.xVA = d.Ds(i3);
            this.xVB = d.Ds(i2);
        }
        this.xVC = new Rect(0, 0, this.xVz.getWidth(), this.xVz.getHeight());
        this.xVD = new Rect(0, 0, this.xVA.getWidth(), this.xVA.getHeight());
        this.xVE = new Rect(0, 0, this.xVB.getWidth(), this.xVB.getHeight());
        this.jbA = new Paint(1);
    }

    public final void Ew(int i) {
        this.xVF = i;
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.jbA != null) {
            if (this.xVF < FileUtils.S_IWUSR) {
                this.jbA.setAlpha(255 - (this.xVF * 2));
                canvas.drawBitmap(this.xVA, null, this.xVD, this.jbA);
                this.jbA.setAlpha(this.xVF * 2);
                canvas.drawBitmap(this.xVB, null, this.xVE, this.jbA);
                return;
            }
            this.jbA.setAlpha(255 - (this.xVF * 2));
            canvas.drawBitmap(this.xVB, null, this.xVE, this.jbA);
            this.jbA.setAlpha(this.xVF * 2);
            canvas.drawBitmap(this.xVz, null, this.xVC, this.jbA);
        }
    }
}
