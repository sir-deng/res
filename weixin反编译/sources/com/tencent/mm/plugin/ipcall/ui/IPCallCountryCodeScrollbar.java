package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.ui.base.q;
import com.tencent.rtmp.sharp.jni.QLog;

public class IPCallCountryCodeScrollbar extends View {
    public static final String[] nOM = new String[]{"A", "B", "C", QLog.TAG_REPORTLEVEL_DEVELOPER, QLog.TAG_REPORTLEVEL_USER, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", QLog.TAG_REPORTLEVEL_COLORUSER, "X", "Y", "Z"};
    private int atq;
    private float gVS;
    private Paint jbA;
    protected float nON = 1.3f;
    protected int nOO = 79;
    protected String[] nOP = new String[]{"↑"};
    private float nOQ = 0.0f;
    private float nOR;
    private q nOS;
    private TextView nOT;
    private int nOU;
    a nOV;

    public interface a {
        void xN(String str);
    }

    public final void Dw(String str) {
        Object str2;
        int i = 0;
        int i2 = 0;
        for (String equals : nOM) {
            if (equals.equals(str2)) {
                i2 = 1;
            }
        }
        if (i2 == 0) {
            str2 = "#";
        }
        int length = this.nOP.length + 1;
        String[] strArr = new String[length];
        String[] strArr2 = this.nOP;
        int length2 = strArr2.length;
        i2 = 0;
        while (i2 < length2) {
            String str3 = strArr2[i2];
            if (!str3.equals(str2)) {
                strArr[i] = str3;
                i++;
                i2++;
            } else {
                return;
            }
        }
        strArr[length - 1] = str2;
        this.nOP = strArr;
    }

    public IPCallCountryCodeScrollbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.nOU = b.b(context, 3.0f);
        View inflate = inflate(context, R.i.dsM, null);
        int b = b.b(context, (float) this.nOO);
        this.nOS = new q(inflate, b, b);
        this.nOT = (TextView) inflate.findViewById(R.h.cOo);
        this.jbA = new Paint();
        this.jbA.setAntiAlias(true);
        this.jbA.setColor(-11119018);
        this.jbA.setTextAlign(Align.CENTER);
    }

    protected void onDraw(Canvas canvas) {
        int i = 0;
        super.onDraw(canvas);
        final int measuredHeight = getMeasuredHeight();
        final int measuredWidth = getMeasuredWidth();
        this.gVS = ((float) measuredHeight) / (((float) this.nOP.length) * this.nON);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.f.bvL);
        if (this.gVS > ((float) dimensionPixelSize)) {
            this.gVS = (float) dimensionPixelSize;
        }
        this.jbA.setTextSize(this.gVS);
        if (this.nOQ != this.gVS) {
            this.nOQ = this.gVS;
            post(new Runnable() {
                public final void run() {
                    if (IPCallCountryCodeScrollbar.this.nOP.length > 0) {
                        int measureText = ((int) IPCallCountryCodeScrollbar.this.jbA.measureText(IPCallCountryCodeScrollbar.this.nOP[IPCallCountryCodeScrollbar.this.nOP.length - 1])) + com.tencent.mm.bu.a.fromDPToPix(IPCallCountryCodeScrollbar.this.getContext(), 8);
                        if (measureText > measuredWidth) {
                            LayoutParams layoutParams = IPCallCountryCodeScrollbar.this.getLayoutParams();
                            layoutParams.width = measureText;
                            layoutParams.height = measuredHeight;
                            IPCallCountryCodeScrollbar.this.setLayoutParams(layoutParams);
                        }
                    }
                }
            });
        }
        if (this.gVS == ((float) dimensionPixelSize)) {
            float length = (((float) measuredHeight) - ((((float) this.nOP.length) * this.gVS) * this.nON)) / 2.0f;
            while (i < this.nOP.length) {
                canvas.drawText(this.nOP[i], ((float) measuredWidth) / 2.0f, (this.gVS + length) + ((((float) i) * this.gVS) * this.nON), this.jbA);
                i++;
            }
            return;
        }
        while (i < this.nOP.length) {
            canvas.drawText(this.nOP[i], ((float) measuredWidth) / 2.0f, this.gVS + ((((float) i) * this.gVS) * this.nON), this.jbA);
            i++;
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
            setBackgroundDrawable(com.tencent.mm.bu.a.b(getContext(), R.g.bFH));
            float f = this.gVS * this.nON;
            int measuredHeight = (int) ((this.nOR - ((((float) getMeasuredHeight()) - (((float) this.nOP.length) * f)) / 2.0f)) / f);
            if (measuredHeight < 0) {
                measuredHeight = 0;
            }
            if (measuredHeight >= this.nOP.length) {
                measuredHeight = this.nOP.length - 1;
            }
            this.atq = measuredHeight;
            if (this.atq == -1) {
                this.nOT.setText(R.l.eID);
            } else {
                this.nOT.setText(this.nOP[this.atq]);
            }
            this.nOS.showAtLocation(this, 17, 0, 0);
            if (this.nOV != null) {
                if (this.atq == -1) {
                    this.nOV.xN(com.tencent.mm.bu.a.ac(getContext(), R.l.eID));
                } else {
                    this.nOV.xN(this.nOP[this.atq]);
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
