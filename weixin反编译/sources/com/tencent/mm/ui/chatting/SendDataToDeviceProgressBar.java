package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ag;

class SendDataToDeviceProgressBar extends ImageView {
    private int bottom;
    private Paint fC;
    private ag hbP;
    private int lZQ;
    private int lZR;
    private Runnable lZS;
    private int left;
    private Context mContext;
    private int nxK;
    private int right;
    private int top;

    public SendDataToDeviceProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SendDataToDeviceProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lZQ = 2;
        this.left = -1;
        this.top = -1;
        this.right = -1;
        this.bottom = -1;
        this.lZR = -1;
        this.nxK = 10;
        this.lZS = new Runnable() {
            public final void run() {
                SendDataToDeviceProgressBar.this.invalidate();
            }
        };
        setImageResource(R.g.bEQ);
        this.mContext = context;
        this.fC = new Paint();
        this.fC.setAntiAlias(true);
        this.fC.setStyle(Style.STROKE);
        this.left = this.mContext.getResources().getDimensionPixelSize(R.f.bxU);
        this.top = this.left;
        this.lZR = this.mContext.getResources().getDimensionPixelSize(R.f.bxV);
        this.hbP = new ag(Looper.getMainLooper());
    }

    public final void setProgress(int i) {
        if (i >= 100) {
            i = 100;
        }
        this.lZQ = (int) ((((float) i) / 100.0f) * 360.0f);
        this.hbP.removeCallbacks(this.lZS);
        this.hbP.postDelayed(this.lZS, 0);
    }

    public final int getProgress() {
        return (int) ((((float) this.lZQ) / 360.0f) * 100.0f);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth() / 2;
        this.fC.setColor(this.mContext.getResources().getColor(R.e.btB));
        this.fC.setStrokeWidth((float) this.lZR);
        if (this.right == -1) {
            this.right = (width * 2) - this.left;
        }
        if (this.bottom == -1) {
            this.bottom = this.right;
        }
        RectF rectF = new RectF((float) this.left, (float) this.top, (float) this.right, (float) this.bottom);
        canvas.drawArc(rectF, 270.0f, (float) this.lZQ, false, this.fC);
        width = this.lZQ + 270;
        if (width > 360) {
            width -= 360;
        }
        this.fC.setColor(this.mContext.getResources().getColor(R.e.btA));
        canvas.drawArc(rectF, (float) width, (float) (360 - this.lZQ), false, this.fC);
    }
}
