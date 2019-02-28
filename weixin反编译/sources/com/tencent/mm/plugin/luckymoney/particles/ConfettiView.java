package com.tencent.mm.plugin.luckymoney.particles;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.tencent.mm.plugin.luckymoney.particles.a.b;
import com.tencent.mm.plugin.wxpay.a.d;
import java.util.List;

public class ConfettiView extends View implements OnLayoutChangeListener {
    List<b> ojE;
    private boolean okn;
    private b oko;
    boolean terminated;

    public static ConfettiView db(Context context) {
        ConfettiView confettiView = new ConfettiView(context, null);
        confettiView.setLayoutParams(new LayoutParams(-1, -1));
        if (VERSION.SDK_INT >= 21) {
            confettiView.setElevation((float) context.getResources().getDimensionPixelOffset(d.uiq));
        }
        return confettiView;
    }

    public ConfettiView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void aXT() {
        if (!this.terminated) {
            this.terminated = true;
            getParent().requestLayout();
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewGroup viewGroup = (ViewGroup) getParent();
        viewGroup.removeOnLayoutChangeListener(this);
        viewGroup.addOnLayoutChangeListener(this);
        if (this.ojE == null) {
            aXT();
        }
    }

    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (this.terminated) {
            ViewParent parent = getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ViewGroup viewGroup = (ViewGroup) parent;
                viewGroup.removeViewInLayout(this);
                viewGroup.removeOnLayoutChangeListener(this);
                viewGroup.invalidate();
            }
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.terminated) {
            canvas.save();
            for (b bVar : this.ojE) {
                if (bVar.okL) {
                    bVar.a(canvas, bVar.okN + bVar.okP, bVar.okO + bVar.okQ, bVar.okJ);
                } else if (bVar.okK && !bVar.terminated) {
                    bVar.a(canvas, bVar.okH, bVar.okI, bVar.okJ);
                }
            }
            canvas.restore();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r9) {
        /*
        r8 = this;
        r1 = 0;
        r2 = 1;
        r0 = r8.okn;
        if (r0 == 0) goto L_0x000d;
    L_0x0006:
        r0 = r9.getAction();
        switch(r0) {
            case 0: goto L_0x0018;
            case 1: goto L_0x009b;
            case 2: goto L_0x0081;
            case 3: goto L_0x009b;
            default: goto L_0x000d;
        };
    L_0x000d:
        r0 = r1;
    L_0x000e:
        if (r0 != 0) goto L_0x0016;
    L_0x0010:
        r0 = super.onTouchEvent(r9);
        if (r0 == 0) goto L_0x00e7;
    L_0x0016:
        r0 = r2;
    L_0x0017:
        return r0;
    L_0x0018:
        r0 = r8.ojE;
        r4 = r0.iterator();
    L_0x001e:
        r0 = r4.hasNext();
        if (r0 == 0) goto L_0x007f;
    L_0x0024:
        r0 = r4.next();
        r0 = (com.tencent.mm.plugin.luckymoney.particles.a.b) r0;
        r5 = r9.getX();
        r6 = r9.getY();
        r3 = r0.okH;
        r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r3 > 0) goto L_0x007b;
    L_0x0038:
        r3 = r0.okH;
        r7 = r0.getWidth();
        r7 = (float) r7;
        r3 = r3 + r7;
        r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1));
        if (r3 > 0) goto L_0x007b;
    L_0x0044:
        r3 = r0.okI;
        r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1));
        if (r3 > 0) goto L_0x007b;
    L_0x004a:
        r3 = r0.okI;
        r7 = r0.getHeight();
        r7 = (float) r7;
        r3 = r3 + r7;
        r3 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1));
        if (r3 > 0) goto L_0x007b;
    L_0x0056:
        r3 = r2;
    L_0x0057:
        if (r3 == 0) goto L_0x007d;
    L_0x0059:
        r0.okL = r2;
        r0.okN = r5;
        r0.okO = r6;
        r3 = r0.okH;
        r3 = r3 - r5;
        r0.okP = r3;
        r3 = r0.okI;
        r3 = r3 - r6;
        r0.okQ = r3;
        r3 = android.view.VelocityTracker.obtain();
        r0.okM = r3;
        r3 = r0.okM;
        r3.addMovement(r9);
        r3 = r2;
    L_0x0075:
        if (r3 == 0) goto L_0x001e;
    L_0x0077:
        r8.oko = r0;
        r0 = r2;
        goto L_0x000e;
    L_0x007b:
        r3 = r1;
        goto L_0x0057;
    L_0x007d:
        r3 = r1;
        goto L_0x0075;
    L_0x007f:
        r0 = r1;
        goto L_0x000e;
    L_0x0081:
        r0 = r8.oko;
        if (r0 == 0) goto L_0x000d;
    L_0x0085:
        r0 = r8.oko;
        r3 = r9.getX();
        r0.okN = r3;
        r3 = r9.getY();
        r0.okO = r3;
        r0 = r0.okM;
        r0.addMovement(r9);
        r0 = r2;
        goto L_0x000e;
    L_0x009b:
        r0 = r8.oko;
        if (r0 == 0) goto L_0x000d;
    L_0x009f:
        r0 = r8.oko;
        r3 = r0.okM;
        r3.addMovement(r9);
        r3 = r0.okM;
        r3.computeCurrentVelocity(r2);
        r4 = -1;
        r0.okv = r4;
        r3 = r9.getX();
        r4 = r0.okP;
        r3 = r3 + r4;
        r0.okw = r3;
        r3 = r9.getY();
        r4 = r0.okQ;
        r3 = r3 + r4;
        r0.okx = r3;
        r3 = r0.okM;
        r3 = r3.getXVelocity();
        r0.oky = r3;
        r3 = r0.okM;
        r3 = r3.getYVelocity();
        r0.okz = r3;
        r3 = r0.okJ;
        r0.okC = r3;
        r3 = r0.okM;
        r3.recycle();
        r3 = r0.ojL;
        r0.g(r3);
        r0.okL = r1;
        r0 = 0;
        r8.oko = r0;
        r0 = r2;
        goto L_0x000e;
    L_0x00e7:
        r0 = r1;
        goto L_0x0017;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.luckymoney.particles.ConfettiView.onTouchEvent(android.view.MotionEvent):boolean");
    }
}
