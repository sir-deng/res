package com.tencent.mm.plugin.clean.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class PieView extends View {
    public int fCn = 0;
    private int jhF = 6;
    private Paint llG;
    private Paint llH;
    private Paint llI;
    private Paint llJ;
    private Paint llK;
    private Paint llL;
    private Paint llM;
    private int llN;
    private int llO;
    private int llP;
    private int llQ;
    public int llR;
    private int llS;
    public int llT = 0;
    private int llU = -90;

    public PieView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    public PieView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    private void initView() {
        this.llG = oB(-1);
        this.llH = oB(-657931);
        this.llI = oB(-2565928);
        this.llJ = oB(-15223279);
        this.llK = oB(-7876878);
        this.llL = oB(-7876878);
        this.llM = oB(-1644567);
    }

    private static Paint oB(int i) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Style.FILL);
        paint.setColor(i);
        return paint;
    }

    public void draw(Canvas canvas) {
        float measuredWidth = (float) (getMeasuredWidth() / 2);
        float measuredHeight = (float) ((getMeasuredHeight() / 2) + getTop());
        float measuredHeight2 = (float) ((getMeasuredHeight() / 3) + 15);
        float f = measuredHeight2 - 15.0f;
        RectF rectF = new RectF(measuredWidth - measuredHeight2, measuredHeight - measuredHeight2, measuredWidth + measuredHeight2, measuredHeight + measuredHeight2);
        if (this.fCn == 0) {
            canvas.drawCircle(measuredWidth, measuredHeight, measuredHeight2, this.llH);
            canvas.drawArc(rectF, (float) this.llU, 45.0f, true, this.llI);
            canvas.drawCircle(measuredWidth, measuredHeight, f, this.llG);
            this.llU += 4;
            this.llU %= 360;
        }
        if (this.fCn == 1) {
            float f2 = 10.0f + measuredHeight2;
            RectF rectF2 = new RectF(measuredWidth - f2, measuredHeight - f2, measuredWidth + f2, f2 + measuredHeight);
            this.llN = H(this.llN, this.llR, this.jhF);
            canvas.drawArc(rectF2, -90.0f, (float) this.llN, true, this.llJ);
            if (this.llT <= 0) {
                if (this.llN == this.llR) {
                    this.llP = H(this.llP, this.llS, this.jhF);
                    canvas.drawArc(rectF, (float) (this.llR - 90), (float) this.llP, true, this.llK);
                }
                if (this.llP == this.llS) {
                    this.llO = H(this.llO, (360 - this.llR) - this.llS, this.jhF);
                    canvas.drawArc(rectF, (float) ((this.llR - 90) + this.llS), (float) this.llO, true, this.llL);
                }
            } else {
                if (this.llN == this.llR) {
                    this.llQ = H(this.llQ, this.llT, this.jhF);
                    canvas.drawArc(rectF2, (float) (this.llR - 90), (float) this.llQ, true, this.llM);
                }
                if (this.llQ == this.llT) {
                    this.llP = H(this.llP, this.llS, this.jhF);
                    canvas.drawArc(rectF, (float) ((this.llT - 90) + this.llR), (float) this.llP, true, this.llK);
                }
                if (this.llP == this.llS) {
                    this.llO = H(this.llO, ((360 - this.llR) - this.llS) - this.llT, this.jhF);
                    canvas.drawArc(rectF, (float) (((this.llR - 90) + this.llS) + this.llT), (float) this.llO, true, this.llL);
                }
            }
        }
        invalidate();
    }

    private static int H(int i, int i2, int i3) {
        if (i2 - i >= i3) {
            return i + i3;
        }
        if (i - i2 > i3) {
            return i - i3;
        }
        return i2;
    }
}
