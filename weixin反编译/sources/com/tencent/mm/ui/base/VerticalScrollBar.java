package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.v.a.f;
import com.tencent.mm.v.a.g;
import com.tencent.mm.v.a.k;

public abstract class VerticalScrollBar extends View {
    private int atq;
    private float gVS;
    private Paint jbA;
    public float nON;
    public int nOO;
    public String[] nOP;
    private float nOQ = 0.0f;
    private float nOR;
    private q nOS;
    private TextView nOT;
    private int nOU;
    public a yqj;

    public interface a {
        void xN(String str);
    }

    public abstract int aUX();

    public abstract void ayE();

    public VerticalScrollBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ayE();
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.nOU = b.b(context, 3.0f);
        View inflate = inflate(context, aUX(), null);
        int b = b.b(context, (float) this.nOO);
        this.nOS = new q(inflate, b, b);
        this.nOT = (TextView) inflate.findViewById(g.cOo);
        this.jbA = new Paint();
        this.jbA.setAntiAlias(true);
        this.jbA.setColor(-11119018);
        this.jbA.setTextAlign(Align.CENTER);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        final int measuredHeight = getMeasuredHeight();
        final int measuredWidth = getMeasuredWidth();
        this.gVS = ((float) measuredHeight) / (((float) this.nOP.length) * this.nON);
        this.jbA.setTextSize(this.gVS);
        if (this.nOQ != this.gVS) {
            this.nOQ = this.gVS;
            post(new Runnable() {
                public final void run() {
                    if (VerticalScrollBar.this.nOP.length > 0) {
                        int measureText = ((int) VerticalScrollBar.this.jbA.measureText(VerticalScrollBar.this.nOP[VerticalScrollBar.this.nOP.length - 1])) + com.tencent.mm.bu.a.fromDPToPix(VerticalScrollBar.this.getContext(), 8);
                        if (measureText > measuredWidth) {
                            LayoutParams layoutParams = VerticalScrollBar.this.getLayoutParams();
                            layoutParams.width = measureText;
                            layoutParams.height = measuredHeight;
                            VerticalScrollBar.this.setLayoutParams(layoutParams);
                        }
                    }
                }
            });
        }
        for (measuredHeight = 0; measuredHeight < this.nOP.length; measuredHeight++) {
            canvas.drawText(this.nOP[measuredHeight], ((float) measuredWidth) / 2.0f, this.gVS + ((((float) measuredHeight) * this.gVS) * this.nON), this.jbA);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
            this.nOR = motionEvent.getY();
            if (this.nOR < 0.0f) {
                this.nOR = 0.0f;
            }
            if (this.nOR > ((float) getMeasuredHeight())) {
                this.nOR = (float) getMeasuredHeight();
            }
            setBackgroundDrawable(com.tencent.mm.bu.a.b(getContext(), f.bFH));
            int i = (int) (this.nOR / (this.gVS * this.nON));
            if (i >= this.nOP.length) {
                i = this.nOP.length - 1;
            }
            this.atq = i;
            if (this.atq == -1) {
                this.nOT.setText(k.eID);
            } else {
                this.nOT.setText(this.nOP[this.atq]);
            }
            this.nOS.showAtLocation(this, 17, 0, 0);
            if (this.yqj != null) {
                if (this.atq == -1) {
                    this.yqj.xN(com.tencent.mm.bu.a.ac(getContext(), k.eID));
                } else {
                    this.yqj.xN(this.nOP[this.atq]);
                }
            }
            invalidate();
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            setBackgroundResource(0);
            this.nOS.dismiss();
        }
        return true;
    }
}
