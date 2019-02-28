package com.tencent.mm.plugin.scanner.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.compatible.g.a;
import com.tencent.mm.compatible.util.d;

public class ScanMaskView extends View {
    private Paint fC;
    private Bitmap qcA = null;
    private Bitmap qcB = null;
    private Bitmap qcC = null;
    int qcD = 0;
    int qcE = 0;
    private boolean qcF = false;
    private Rect qcG = new Rect();
    private Rect qcH = new Rect();
    private Rect qcI = new Rect();
    private Rect qcJ = new Rect();
    private Rect qcK = new Rect();
    private Rect qcL = new Rect();
    private Rect qcM = new Rect();
    private Rect qcN = new Rect();
    private Rect qcO = new Rect();
    private Path qcP = new Path();
    Rect qcQ;
    private PorterDuffXfermode qcR;
    private int qcS = R.e.btG;
    private long qcT = 0;
    boolean qcU = false;
    Rect qcV;
    private final long qcW = 200;
    float qcX = 0.0f;
    float qcY = 0.0f;
    float qcZ = 0.0f;
    private Bitmap qcz = null;
    float qda = 0.0f;
    private Paint qdb;
    ValueAnimator qdc = null;

    public ScanMaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScanMaskView(Context context, Rect rect) {
        super(context);
        this.qcQ = rect;
        getDrawingRect(this.qcG);
        this.fC = new Paint();
        this.qcz = a.decodeResource(getResources(), R.g.bFD);
        this.qcA = a.decodeResource(getResources(), R.g.bFE);
        this.qcB = a.decodeResource(getResources(), R.g.bFF);
        this.qcC = a.decodeResource(getResources(), R.g.bFG);
        this.qcD = this.qcz.getWidth();
        this.qcE = this.qcz.getHeight();
        this.qdb = new Paint();
        this.qcR = new PorterDuffXfermode(Mode.CLEAR);
    }

    public final void bpU() {
        this.qcF = true;
        if (this.qcz != null) {
            this.qcz.recycle();
            this.qcz = null;
        }
        if (this.qcA != null) {
            this.qcA.recycle();
            this.qcA = null;
        }
        if (this.qcB != null) {
            this.qcB.recycle();
            this.qcB = null;
        }
        if (this.qcC != null) {
            this.qcC.recycle();
            this.qcC = null;
        }
    }

    protected void onDraw(Canvas canvas) {
        if (this.qcQ != null && !this.qcF) {
            System.currentTimeMillis();
            System.currentTimeMillis();
            int save = canvas.save();
            this.fC.reset();
            if (d.fO(18)) {
                this.qcL.left = 0;
                this.qcL.top = this.qcQ.top;
                this.qcL.right = this.qcQ.left;
                this.qcL.bottom = this.qcQ.bottom;
                this.qcM.left = this.qcQ.left;
                this.qcM.top = 0;
                this.qcM.right = this.qcQ.right;
                this.qcM.bottom = this.qcQ.top;
                this.qcN.left = this.qcQ.right;
                this.qcN.top = this.qcQ.top;
                this.qcN.right = getWidth();
                this.qcN.bottom = this.qcQ.bottom;
                this.qcO.left = this.qcQ.left;
                this.qcO.top = this.qcQ.bottom;
                this.qcO.right = this.qcQ.right;
                this.qcO.bottom = getHeight();
                this.qcH.left = 0;
                this.qcH.top = 0;
                this.qcH.right = this.qcQ.left;
                this.qcH.bottom = this.qcQ.top;
                this.qcI.left = this.qcQ.right;
                this.qcI.top = 0;
                this.qcI.right = getWidth();
                this.qcI.bottom = this.qcQ.top;
                this.qcJ.left = 0;
                this.qcJ.top = this.qcQ.bottom;
                this.qcJ.right = this.qcQ.left;
                this.qcJ.bottom = getHeight();
                this.qcK.left = this.qcQ.right;
                this.qcK.top = this.qcQ.bottom;
                this.qcK.right = getWidth();
                this.qcK.bottom = getHeight();
                canvas.save();
                canvas.clipRect(this.qcL, Op.REPLACE);
                canvas.drawColor(getResources().getColor(this.qcS));
                canvas.restore();
                canvas.save();
                canvas.clipRect(this.qcM, Op.REPLACE);
                canvas.drawColor(getResources().getColor(this.qcS));
                canvas.restore();
                canvas.save();
                canvas.clipRect(this.qcN, Op.REPLACE);
                canvas.drawColor(getResources().getColor(this.qcS));
                canvas.restore();
                canvas.save();
                canvas.clipRect(this.qcO, Op.REPLACE);
                canvas.drawColor(getResources().getColor(this.qcS));
                canvas.restore();
                canvas.save();
                canvas.clipRect(this.qcH, Op.REPLACE);
                canvas.drawColor(getResources().getColor(this.qcS));
                canvas.restore();
                canvas.save();
                canvas.clipRect(this.qcI, Op.REPLACE);
                canvas.drawColor(getResources().getColor(this.qcS));
                canvas.restore();
                canvas.save();
                canvas.clipRect(this.qcJ, Op.REPLACE);
                canvas.drawColor(getResources().getColor(this.qcS));
                canvas.restore();
                canvas.save();
                canvas.clipRect(this.qcK, Op.REPLACE);
                canvas.drawColor(getResources().getColor(this.qcS));
                canvas.restore();
            } else {
                canvas.clipRect(this.qcQ, Op.DIFFERENCE);
                canvas.drawColor(getResources().getColor(this.qcS));
            }
            System.currentTimeMillis();
            System.currentTimeMillis();
            canvas.restoreToCount(save);
            this.fC.reset();
            this.fC.setStyle(Style.STROKE);
            this.fC.setStrokeWidth(1.0f);
            this.fC.setColor(-3355444);
            this.fC.setAntiAlias(true);
            canvas.drawRect(this.qcQ, this.fC);
            System.currentTimeMillis();
            System.currentTimeMillis();
            canvas.drawBitmap(this.qcz, (float) this.qcQ.left, (float) this.qcQ.top, this.qdb);
            canvas.drawBitmap(this.qcA, (float) (this.qcQ.right - this.qcD), (float) this.qcQ.top, this.qdb);
            canvas.drawBitmap(this.qcB, (float) this.qcQ.left, (float) (this.qcQ.bottom - this.qcE), this.qdb);
            canvas.drawBitmap(this.qcC, (float) (this.qcQ.right - this.qcD), (float) (this.qcQ.bottom - this.qcE), this.qdb);
            System.currentTimeMillis();
            super.onDraw(canvas);
            System.currentTimeMillis();
        }
    }
}
