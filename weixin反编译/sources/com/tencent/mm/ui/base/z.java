package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.Spannable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.ui.widget.i;

public final class z {
    public boolean fKg = true;
    TextView kO;
    Context mContext;
    int ypA;
    int ypB;
    private d ypC;
    boolean ypD;
    OnPreDrawListener ypE;
    OnScrollChangedListener ypF;
    final Runnable ypG = new Runnable() {
        public final void run() {
            if (!z.this.fKg) {
                z.this.cqS();
                if (z.this.ypr != null) {
                    z.this.a(z.this.ypr);
                }
                if (z.this.yps != null) {
                    z.this.a(z.this.yps);
                }
            }
        }
    };
    private int[] ypH = new int[2];
    public b ypr;
    public b yps;
    c ypt = new c();
    public w ypu;
    Spannable ypv;
    i ypw;
    int ypx;
    int ypy;
    private int ypz;

    public static class a {
        TextView kO;
        public int ypA = com.tencent.mm.ca.a.b.brU;
        i ypJ;
        public float ypK = 24.0f;
        public int ypz = com.tencent.mm.ca.a.b.btI;

        public a(TextView textView, i iVar) {
            this.kO = textView;
            this.ypJ = iVar;
        }
    }

    private class b extends View {
        private Paint fC;
        private int ljP = 25;
        private int mHeight = (this.uaW * 2);
        int mWidth = (this.uaW * 2);
        private int uaW = (z.this.ypB / 2);
        public PopupWindow ypL;
        boolean ypM;
        private int ypN;
        private int ypO;
        private int ypP;
        private int ypQ;
        int[] ypR = new int[2];

        public b(boolean z) {
            super(z.this.mContext);
            this.ypM = z;
            this.fC = new Paint(1);
            this.fC.setColor(z.this.mContext.getResources().getColor(z.this.ypA));
            this.ypL = new PopupWindow(this);
            this.ypL.setClippingEnabled(false);
            this.ypL.setWidth(this.mWidth + (this.ljP * 2));
            this.ypL.setHeight(this.mHeight + (this.ljP / 2));
            invalidate();
        }

        protected final void onDraw(Canvas canvas) {
            canvas.drawCircle((float) (this.uaW + this.ljP), (float) this.uaW, (float) this.uaW, this.fC);
            if (this.ypM) {
                canvas.drawRect((float) (this.uaW + this.ljP), 0.0f, (float) ((this.uaW * 2) + this.ljP), (float) this.uaW, this.fC);
                return;
            }
            canvas.drawRect((float) this.ljP, 0.0f, (float) (this.uaW + this.ljP), (float) this.uaW, this.fC);
        }

        public final boolean onTouchEvent(MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.ypP = z.this.ypt.Ww;
                    this.ypQ = z.this.ypt.wq;
                    this.ypN = (int) motionEvent.getX();
                    this.ypO = (int) motionEvent.getY();
                    break;
                case 1:
                case 3:
                    z.this.cqS();
                    break;
                case 2:
                    z.this.ypw.csc();
                    int rawX = (((int) motionEvent.getRawX()) + this.ypN) - this.mWidth;
                    int rawY = (this.ypO + ((int) motionEvent.getRawY())) - this.mHeight;
                    z.this.kO.getLocationInWindow(this.ypR);
                    int i = this.ypM ? z.this.ypt.Ww : z.this.ypt.wq;
                    int i2 = rawY - this.ypR[1];
                    TextView textView = z.this.kO;
                    Layout layout = textView.getLayout();
                    if (layout != null) {
                        int lineRight;
                        int lineBottom;
                        int i3;
                        int lineForVertical = layout.getLineForVertical(i2);
                        if (ab.a(layout, i)) {
                            lineRight = (int) layout.getLineRight(lineForVertical);
                            if (rawX > lineRight - ((lineRight - ((int) layout.getPrimaryHorizontal(i - 1))) / 2)) {
                                rawY = i - 1;
                                rawY = layout.getLineForOffset(rawY);
                                lineRight = layout.getLineTop(rawY);
                                lineBottom = layout.getLineBottom(rawY);
                                i3 = (lineBottom - lineRight) / 2;
                                if ((lineForVertical != rawY + 1 || i2 - lineBottom >= i3) && (lineForVertical != rawY - 1 || lineRight - i2 >= i3)) {
                                    rawY = lineForVertical;
                                }
                                lineForVertical = layout.getOffsetForHorizontal(rawY, (float) rawX);
                                if (lineForVertical < textView.getText().length() - 1 && ab.a(layout, lineForVertical + 1)) {
                                    rawY = (int) layout.getLineRight(rawY);
                                    if (rawX > rawY - ((rawY - ((int) layout.getPrimaryHorizontal(lineForVertical))) / 2)) {
                                        rawY = lineForVertical + 1;
                                    }
                                }
                                rawY = lineForVertical;
                            }
                        }
                        rawY = i;
                        rawY = layout.getLineForOffset(rawY);
                        lineRight = layout.getLineTop(rawY);
                        lineBottom = layout.getLineBottom(rawY);
                        i3 = (lineBottom - lineRight) / 2;
                        rawY = lineForVertical;
                        lineForVertical = layout.getOffsetForHorizontal(rawY, (float) rawX);
                        rawY = (int) layout.getLineRight(rawY);
                        if (rawX > rawY - ((rawY - ((int) layout.getPrimaryHorizontal(lineForVertical))) / 2)) {
                            rawY = lineForVertical + 1;
                        }
                        rawY = lineForVertical;
                        break;
                    }
                    rawY = -1;
                    if (rawY != i) {
                        z.this.cqR();
                        b a;
                        if (!this.ypM) {
                            if (rawY < this.ypP) {
                                a = z.a(z.this, true);
                                a.cqT();
                                cqT();
                                this.ypQ = this.ypP;
                                z.this.eX(rawY, this.ypP);
                                a.cqU();
                            } else {
                                z.this.eX(this.ypP, rawY);
                            }
                            cqU();
                            break;
                        }
                        if (rawY > this.ypQ) {
                            a = z.a(z.this, false);
                            cqT();
                            a.cqT();
                            this.ypP = this.ypQ;
                            z.this.eX(this.ypQ, rawY);
                            a.cqU();
                        } else {
                            z.this.eX(rawY, -1);
                        }
                        cqU();
                        break;
                    }
                    break;
            }
            return true;
        }

        private void cqT() {
            this.ypM = !this.ypM;
            invalidate();
        }

        private void cqU() {
            z.this.kO.getLocationInWindow(this.ypR);
            Layout layout = z.this.kO.getLayout();
            if (this.ypM) {
                this.ypL.update((((int) layout.getPrimaryHorizontal(z.this.ypt.Ww)) - this.mWidth) + cqV(), layout.getLineBottom(layout.getLineForOffset(z.this.ypt.Ww)) + cqW(), -1, -1);
                return;
            }
            int[] eY = eY((int) layout.getPrimaryHorizontal(z.this.ypt.wq), layout.getLineBottom(layout.getLineForOffset(z.this.ypt.wq)));
            this.ypL.update(eY[0] + cqV(), eY[1] + cqW(), -1, -1);
        }

        public final int cqV() {
            return (this.ypR[0] - this.ljP) + z.this.kO.getPaddingLeft();
        }

        public final int cqW() {
            return this.ypR[1] + z.this.kO.getPaddingTop();
        }

        final int[] eY(int i, int i2) {
            int[] iArr = new int[2];
            if (i == 0 && z.this.ypt.wq > 1) {
                z.this.kO.getLocationInWindow(this.ypR);
                Layout layout = z.this.kO.getLayout();
                if (layout != null) {
                    i = (int) layout.getLineWidth(layout.getLineForOffset(z.this.ypt.wq - 1));
                    i2 = layout.getLineBottom(layout.getLineForOffset(z.this.ypt.wq - 1));
                }
            }
            iArr[0] = i;
            iArr[1] = i2;
            return iArr;
        }
    }

    public class c {
        public int Ww;
        public int wq;
        public String ypS;
    }

    static /* synthetic */ b a(z zVar, boolean z) {
        return zVar.ypr.ypM == z ? zVar.ypr : zVar.yps;
    }

    public z(a aVar) {
        this.kO = aVar.kO;
        this.ypw = aVar.ypJ;
        this.mContext = this.kO.getContext();
        this.ypz = aVar.ypz;
        this.ypA = aVar.ypA;
        this.ypB = com.tencent.mm.bu.a.fromDPToPix(this.mContext, 24);
        this.kO.setText(this.kO.getText(), BufferType.SPANNABLE);
        this.kO.setOnLongClickListener(new OnLongClickListener() {
            public final boolean onLongClick(View view) {
                z zVar = z.this;
                int i = z.this.ypx;
                int i2 = z.this.ypy;
                zVar.cqQ();
                zVar.cqR();
                zVar.fKg = false;
                if (zVar.ypr == null) {
                    zVar.ypr = new b(true);
                }
                if (zVar.yps == null) {
                    zVar.yps = new b(false);
                }
                Layout layout = zVar.kO.getLayout();
                if (layout != null) {
                    i2 = layout.getOffsetForHorizontal(layout.getLineForVertical(i2), (float) i);
                    i = ((int) layout.getPrimaryHorizontal(i2)) > i ? layout.getOffsetToLeftOf(i2) : i2;
                } else {
                    i = -1;
                }
                int i3 = i + 1;
                if (zVar.kO.getText() instanceof Spannable) {
                    zVar.ypv = (Spannable) zVar.kO.getText();
                }
                if (zVar.ypv != null && i < zVar.kO.getText().length()) {
                    zVar.eX(i, i3);
                    zVar.a(zVar.ypr);
                    zVar.a(zVar.yps);
                    zVar.cqS();
                }
                return true;
            }
        });
        this.kO.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                z.this.ypx = (int) motionEvent.getX();
                z.this.ypy = (int) motionEvent.getY();
                return false;
            }
        });
        this.kO.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                z.this.cqR();
                z.this.cqQ();
            }
        });
        this.kO.addOnAttachStateChangeListener(new OnAttachStateChangeListener() {
            public final void onViewAttachedToWindow(View view) {
            }

            public final void onViewDetachedFromWindow(View view) {
                z zVar = z.this;
                zVar.kO.getViewTreeObserver().removeOnScrollChangedListener(zVar.ypF);
                zVar.kO.getViewTreeObserver().removeOnPreDrawListener(zVar.ypE);
                zVar.cqR();
                zVar.cqQ();
                zVar.ypr = null;
                zVar.yps = null;
                zVar.ypw = null;
            }
        });
        this.ypE = new OnPreDrawListener() {
            public final boolean onPreDraw() {
                if (z.this.ypD) {
                    z.this.ypD = false;
                    z zVar = z.this;
                    zVar.kO.removeCallbacks(zVar.ypG);
                    zVar.kO.postDelayed(zVar.ypG, 100);
                }
                return true;
            }
        };
        this.kO.getViewTreeObserver().addOnPreDrawListener(this.ypE);
        this.ypF = new OnScrollChangedListener() {
            public final void onScrollChanged() {
                if (!z.this.ypD && !z.this.fKg) {
                    z.this.ypD = true;
                    if (z.this.ypw != null) {
                        z.this.ypw.csc();
                    }
                    if (z.this.ypr != null) {
                        z.this.ypr.ypL.dismiss();
                    }
                    if (z.this.yps != null) {
                        z.this.yps.ypL.dismiss();
                    }
                }
            }
        };
        this.kO.getViewTreeObserver().addOnScrollChangedListener(this.ypF);
    }

    public final void cqQ() {
        this.fKg = true;
        if (this.ypr != null) {
            this.ypr.ypL.dismiss();
        }
        if (this.yps != null) {
            this.yps.ypL.dismiss();
        }
        if (this.ypw != null) {
            this.ypw.csc();
        }
    }

    public final void cqR() {
        this.ypt.ypS = null;
        if (this.ypv != null && this.ypC != null) {
            this.ypv.removeSpan(this.ypC);
            this.ypC = null;
        }
    }

    public final void a(b bVar) {
        Layout layout = this.kO.getLayout();
        int i = bVar.ypM ? this.ypt.Ww : this.ypt.wq;
        int primaryHorizontal = (int) layout.getPrimaryHorizontal(i);
        int lineBottom = layout.getLineBottom(layout.getLineForOffset(i));
        bVar.ypI.kO.getLocationInWindow(bVar.ypR);
        if (bVar.ypM) {
            i = bVar.mWidth;
        } else {
            i = 0;
        }
        if (!bVar.ypM) {
            int[] eY = bVar.eY(primaryHorizontal, lineBottom);
            primaryHorizontal = eY[0];
            lineBottom = eY[1];
        }
        bVar.ypL.showAtLocation(bVar.ypI.kO, 0, (primaryHorizontal - i) + bVar.cqV(), lineBottom + bVar.cqW());
    }

    public final void cqS() {
        int i = 16;
        if (this.ypw != null) {
            this.kO.getLocationInWindow(this.ypH);
            Layout layout = this.kO.getLayout();
            int primaryHorizontal = ((int) layout.getPrimaryHorizontal(this.ypt.Ww)) + this.ypH[0];
            int lineTop = (layout.getLineTop(layout.getLineForOffset(this.ypt.Ww)) + this.ypH[1]) - 16;
            if (primaryHorizontal <= 0) {
                primaryHorizontal = 16;
            }
            if (lineTop >= 0) {
                i = lineTop;
            }
            if (primaryHorizontal > ab.getScreenWidth(this.mContext)) {
                lineTop = ab.getScreenWidth(this.mContext) - 16;
            } else {
                lineTop = primaryHorizontal;
            }
            this.ypw.bV(lineTop, i);
        }
    }

    public final void eX(int i, int i2) {
        if (i != -1) {
            this.ypt.Ww = i;
        }
        if (i2 != -1) {
            this.ypt.wq = i2;
        }
        if (this.ypt.Ww > this.ypt.wq) {
            int i3 = this.ypt.Ww;
            this.ypt.Ww = this.ypt.wq;
            this.ypt.wq = i3;
        }
        if (this.ypv != null) {
            this.ypt.ypS = this.ypv.subSequence(this.ypt.Ww, this.ypt.wq).toString();
            if (this.ypC == null) {
                this.ypC = new d(this.kO, this.mContext.getResources().getColor(this.ypz), this.ypt.Ww, this.ypt.wq);
            }
            if (this.ypC != null) {
                d dVar = this.ypC;
                int i4 = this.ypt.Ww;
                int i5 = this.ypt.wq;
                dVar.start = i4;
                dVar.end = i5;
            }
            Layout layout = this.kO.getLayout();
            this.ypv.setSpan(this.ypC, layout.getLineStart(layout.getLineForOffset(this.ypt.Ww)), this.ypt.wq, 17);
            if (this.ypu != null) {
                this.ypu.S(this.ypt.ypS);
            }
        }
    }
}
