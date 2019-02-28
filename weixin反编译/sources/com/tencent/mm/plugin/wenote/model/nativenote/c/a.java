package com.tencent.mm.plugin.wenote.model.nativenote.c;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;

public final class a extends View {
    private Paint fC;
    public int ljP;
    private int mType = 2;
    private int tni;
    private RectF uaS;
    private RectF uaT;
    private RectF uaU;
    private RectF uaV;
    public int uaW;
    private int uaX;
    private int uaY;
    private a uaZ;

    public interface a {
        void a(int i, MotionEvent motionEvent);
    }

    public a(Context context, int i, int i2, int i3, int i4, a aVar) {
        super(context);
        this.mType = i;
        this.uaX = i2;
        this.tni = i3;
        this.uaW = (this.uaX * 2) / 5;
        this.ljP = this.uaW;
        this.uaY = (this.uaW * 3) / 4;
        this.fC = new Paint(1);
        this.fC.setColor(i4);
        this.uaZ = aVar;
        this.uaS = new RectF((float) this.ljP, (float) this.uaX, (float) (this.ljP + (this.uaW * 2)), (float) (this.uaX + (this.uaW * 2)));
        this.uaT = new RectF((float) (this.uaY - this.uaW), (float) this.uaX, (float) (this.uaY + this.uaW), (float) (this.uaX + (this.uaW * 2)));
        this.uaU = new RectF((float) this.ljP, (float) this.uaX, (float) (this.ljP + (this.uaW * 2)), (float) (this.uaX + (this.uaW * 2)));
        this.uaV = new RectF((float) (this.ljP + this.tni), (float) this.uaX, (float) ((this.ljP + this.tni) + (this.uaW * 2)), (float) (this.uaX + (this.uaW * 2)));
    }

    public final int bud() {
        return (this.uaX + (this.uaW * 2)) + this.ljP;
    }

    public final int bDr() {
        if (this.mType == 3 || this.mType == 4) {
            return (this.ljP + this.uaW) + this.uaY;
        }
        return this.tni + ((this.ljP + this.uaW) * 2);
    }

    protected final void onDraw(Canvas canvas) {
        switch (this.mType) {
            case 2:
                canvas.drawRect((float) (this.ljP + this.uaW), 0.0f, (float) ((this.ljP + this.uaW) + this.tni), (float) (this.uaX + (this.uaW * 2)), this.fC);
                canvas.drawArc(this.uaU, 90.0f, 180.0f, true, this.fC);
                canvas.drawArc(this.uaV, 270.0f, 180.0f, true, this.fC);
                return;
            case 3:
                canvas.drawRect((float) (((this.ljP + this.uaW) + this.uaY) - this.tni), 0.0f, (float) ((this.ljP + this.uaW) + this.uaY), (float) this.uaX, this.fC);
                canvas.drawArc(this.uaS, 90.0f, 180.0f, true, this.fC);
                canvas.drawRect((float) (this.ljP + this.uaW), (float) this.uaX, (float) ((this.ljP + this.uaW) + this.uaY), (float) (this.uaX + (this.uaW * 2)), this.fC);
                return;
            case 4:
                canvas.drawRect(0.0f, 0.0f, (float) this.tni, (float) this.uaX, this.fC);
                canvas.drawRect(0.0f, (float) this.uaX, (float) this.uaY, (float) (this.uaX + (this.uaW * 2)), this.fC);
                canvas.drawArc(this.uaT, 270.0f, 180.0f, true, this.fC);
                return;
            default:
                return;
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.uaZ != null) {
            this.uaZ.a(this.mType, motionEvent);
        }
        return true;
    }
}
