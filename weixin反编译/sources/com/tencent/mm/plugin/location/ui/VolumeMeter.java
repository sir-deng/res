package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ag;

public class VolumeMeter extends ImageView implements Runnable {
    public boolean hwv = false;
    private Paint jbA;
    private Context mContext;
    public boolean oaU = false;
    View oaV;
    private int oaW = -1;
    private int oaX = -1;
    public ag oaY = null;
    float oaZ;
    float oba;
    private float obb;
    private float obc;
    private int obd = -6751336;
    private int obe = 70;
    private float obf = 0.5f;
    private float obg = 0.001f;
    private int obh = 20;
    private float obi;
    private float obk;
    private float obl = 0.0f;
    private float obm = 40.0f;
    private float obn = 30.0f;

    public final void aWS() {
        if (this.oaY == null) {
            new ag().postDelayed(new Runnable() {
                public final void run() {
                    VolumeMeter.this.oaY = new ag();
                    VolumeMeter.this.aWS();
                }
            }, 100);
        } else {
            this.oaY.post(this);
        }
    }

    public void run() {
        if (this.hwv) {
            float f;
            float f2 = this.obb;
            if (this.oba > this.oaZ) {
                f = (this.oba - this.oaZ) / this.obn;
                if (f > this.obf) {
                    f = this.obf;
                } else if (f < this.obg) {
                    f = this.obg;
                }
                f += f2;
            } else if (this.oba <= this.oaZ) {
                f = (this.oaZ - this.oba) / this.obm;
                if (f > this.obf) {
                    f = this.obf;
                } else if (f < this.obg) {
                    f = this.obg;
                }
                f = f2 - f;
            } else {
                f = f2;
            }
            this.obb = f;
            this.obc = this.obb;
            this.obl = ((float) ((260.0d * Math.sqrt((double) this.obb)) - ((double) (130.0f * this.obb)))) / 1.5f;
            postInvalidate();
            this.oaY.postDelayed(this, (long) this.obh);
        }
    }

    public VolumeMeter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        init();
    }

    public VolumeMeter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    private void init() {
        this.jbA = new Paint();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        getWidth();
        getHeight();
        if (this.oaV != null) {
            int[] iArr = new int[2];
            this.oaV.getLocationInWindow(iArr);
            if (!(iArr[0] == 0 || iArr[1] == 0)) {
                int width = this.oaV.getWidth();
                int height = this.oaV.getHeight();
                if (!(width == 0 || height == 0)) {
                    int b = b.b(this.mContext, 50.0f);
                    this.oaW = iArr[0] + (width / 2);
                    this.oaX = (iArr[1] + (height / 2)) - (b / 2);
                    this.obk = (float) (width / 2);
                    this.obi = ((float) (width / 2)) * 2.0f;
                }
            }
        }
        if (this.oaW >= 0 && this.oaX >= 0) {
            this.jbA.setColor(this.obd);
            this.jbA.setAlpha(this.obe);
            float b2 = (float) b.b(this.mContext, this.obl);
            if (b2 > this.obi) {
                b2 = this.obi;
            }
            if (b2 < this.obk) {
                b2 = this.obk;
            }
            canvas.drawCircle((float) this.oaW, (float) this.oaX, b2, this.jbA);
        }
    }

    public final void reset() {
        this.obl = 0.0f;
        this.oaZ = 0.0f;
        this.oba = 0.0f;
        this.obb = 0.0f;
        this.obc = 0.0f;
        postInvalidate();
    }
}
