package com.tencent.neattextview.textview.layout;

import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import com.tencent.neattextview.textview.layout.b.a;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public final class c implements a {
    private static final TextPaint zUj = new TextPaint(1);
    private static Comparator<Integer> zUk = new Comparator<Integer>() {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return ((Integer) obj).intValue() - ((Integer) obj2).intValue();
        }
    };
    public int Ww;
    private float uck;
    public int wq;
    private float[] zTI;
    private b zUl;
    private char[] zUm;
    private float zUn;
    private boolean zUo;
    private float zUp;
    private float zUq = -1.0f;
    private RectF zUr = new RectF();
    private LinkedList<Integer> zUs = null;

    public c(b bVar, char[] cArr, int i, int i2, float f, float[] fArr, float f2, float f3, float f4, TextPaint textPaint, boolean z) {
        this.zUl = bVar;
        this.zUm = cArr;
        this.Ww = i;
        this.wq = i2;
        this.zTI = fArr;
        this.zUn = f4;
        this.zUo = z;
        this.zUp = f3;
        this.uck = f2;
        FontMetrics fontMetrics = textPaint.getFontMetrics();
        float f5 = fontMetrics.leading - fontMetrics.top;
        float f6 = fontMetrics.bottom - fontMetrics.leading;
        float f7 = ((((this.zUp - fontMetrics.bottom) + fontMetrics.top) / 2.0f) + f) - fontMetrics.top;
        this.zUr.set(0.0f, f7 - f5, 0.0f + f2, f7 + f6);
    }

    public final void a(Canvas canvas, TextPaint textPaint, float f) {
        float cDm = 0.0f + cDm();
        FontMetrics fontMetrics = textPaint.getFontMetrics();
        float f2 = ((((this.zUp - fontMetrics.bottom) + fontMetrics.top) / 2.0f) + f) - fontMetrics.top;
        int i;
        int i2;
        int i3;
        ImageSpan imageSpan;
        float f3;
        if (this.zUn != 0.0f || this.zUo) {
            i = this.Ww;
            i2 = this.Ww;
            while (true) {
                int i4 = i2;
                float f4 = f2;
                if (i4 < this.wq) {
                    if (i4 + 1 >= this.wq || this.zTI[i4 + 1] != 0.0f) {
                        i3 = i4 + 1;
                        imageSpan = (ImageSpan) this.zUl.zTS.fC(i, i3);
                        if (imageSpan != null) {
                            zUj.set(textPaint);
                            imageSpan.draw(canvas, "", i, i3, cDm, 0, (int) f4, (int) (this.zUp + f), zUj);
                        } else {
                            if (a(textPaint, i, i3)) {
                                f3 = ((((this.zUp - fontMetrics.bottom) + fontMetrics.top) / 2.0f) + f) - fontMetrics.top;
                            } else {
                                f3 = f4;
                            }
                            canvas.drawText(this.zUm, i, i3 - i, cDm, f3, zUj);
                            f4 = f3;
                        }
                        cDm += this.zTI[i] + this.zUn;
                        i = i3;
                    }
                    f2 = f4;
                    i2 = i4 + 1;
                } else {
                    return;
                }
            }
        }
        i = this.Ww;
        i3 = this.wq;
        if (this.zUs == null) {
            this.zUs = new LinkedList();
            for (int i22 : a.cDr()) {
                if (i22 != a.zUd) {
                    d dVar;
                    b bVar = this.zUl;
                    switch (com.tencent.neattextview.textview.layout.b.AnonymousClass1.zUb[i22 - 1]) {
                        case 1:
                            dVar = bVar.zTX;
                            break;
                        case 2:
                            dVar = bVar.zTV;
                            break;
                        case 3:
                            dVar = bVar.zTS;
                            break;
                        case 4:
                            dVar = bVar.zTT;
                            break;
                        case 5:
                            dVar = bVar.zTU;
                            break;
                        case 6:
                            dVar = bVar.zTW;
                            break;
                        default:
                            dVar = null;
                            break;
                    }
                    int i5 = 0;
                    for (boolean z : dVar.fD(i, i3)) {
                        if (z) {
                            this.zUs.add(Integer.valueOf(dVar.zUw[i5] < i ? i : dVar.zUw[i5]));
                            this.zUs.add(Integer.valueOf(dVar.zUx[i5] > i3 ? i3 : dVar.zUx[i5]));
                        }
                        i5++;
                    }
                }
            }
            Collections.sort(this.zUs, zUk);
        }
        i = this.Ww;
        Iterator it = this.zUs.iterator();
        f3 = f2;
        while (it.hasNext()) {
            i3 = ((Integer) it.next()).intValue();
            if (i3 > 0 && i != i3) {
                imageSpan = (ImageSpan) this.zUl.zTS.fE(i, i3);
                if (imageSpan != null) {
                    zUj.set(textPaint);
                    imageSpan.draw(canvas, "", i, i3, cDm, 0, (int) f3, (int) (this.zUp + f), zUj);
                } else {
                    if (a(textPaint, i, i3)) {
                        f3 = ((((this.zUp - fontMetrics.bottom) + fontMetrics.top) / 2.0f) + f) - fontMetrics.top;
                    }
                    canvas.drawText(this.zUm, i, i3 - i, cDm, f3, zUj);
                }
                while (i < i3) {
                    cDm += this.zTI[i];
                    i++;
                }
                i = i3;
            }
        }
        if (i < this.Ww + getLength()) {
            float f5;
            if (a(textPaint, i, this.Ww + getLength())) {
                f5 = ((((this.zUp - fontMetrics.bottom) + fontMetrics.top) / 2.0f) + f) - fontMetrics.top;
            } else {
                f5 = f3;
            }
            canvas.drawText(this.zUm, i, (this.Ww + getLength()) - i, cDm, f5, zUj);
        }
    }

    public final float getHeight() {
        return this.zUp;
    }

    public final float getWidth() {
        return this.uck;
    }

    public final float[] cDi() {
        return this.zTI;
    }

    private int getLength() {
        return this.wq - this.Ww;
    }

    public final RectF fB(int i, int i2) {
        RectF rectF = new RectF();
        if (i < i2) {
            float cDm = cDm();
            for (int i3 = this.Ww; i3 < i; i3++) {
                cDm += this.zTI[i3] + this.zUn;
            }
            float f = cDm;
            while (i < i2) {
                f += this.zTI[i] + this.zUn;
                i++;
            }
            rectF.set(cDm, this.zUr.top, f, this.zUr.bottom);
        }
        return rectF;
    }

    public final RectF cDj() {
        return this.zUr;
    }

    public final int getStart() {
        return this.Ww;
    }

    public final int getEnd() {
        return this.wq;
    }

    public final float cDk() {
        return this.zUn;
    }

    public final boolean cDl() {
        return this.zUo;
    }

    public final float cDm() {
        if (this.zUq != -1.0f) {
            return this.zUq;
        }
        if (this.zUl.zTS.fC(this.Ww, this.Ww + 1) == null && this.zUl.cDp().containsKey(Character.valueOf(this.zUm[this.Ww]))) {
            float f = -((Float) this.zUl.cDp().get(Character.valueOf(this.zUm[this.Ww]))).floatValue();
            this.zUq = f;
            return f;
        }
        this.zUq = 0.0f;
        return this.zUq;
    }

    private boolean a(TextPaint textPaint, int i, int i2) {
        boolean z = true;
        boolean z2 = false;
        zUj.set(textPaint);
        AbsoluteSizeSpan absoluteSizeSpan = (AbsoluteSizeSpan) this.zUl.zTT.fC(i, i2);
        if (absoluteSizeSpan != null) {
            absoluteSizeSpan.updateDrawState(zUj);
            z2 = true;
        }
        RelativeSizeSpan relativeSizeSpan = (RelativeSizeSpan) this.zUl.zTU.fC(i, i2);
        if (relativeSizeSpan != null) {
            relativeSizeSpan.updateDrawState(zUj);
        } else {
            z = z2;
        }
        ForegroundColorSpan foregroundColorSpan = (ForegroundColorSpan) this.zUl.zTW.fC(i, i2);
        if (foregroundColorSpan != null) {
            foregroundColorSpan.updateDrawState(zUj);
        }
        ClickableSpan clickableSpan = (ClickableSpan) this.zUl.zTX.fC(i, i2);
        if (clickableSpan != null) {
            clickableSpan.updateDrawState(zUj);
        }
        return z;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (aVar.getStart() != this.Ww || aVar.getEnd() != this.wq || !aVar.cDj().equals(this.zUr) || aVar.cDl() != this.zUo || aVar.cDk() != this.zUn || aVar.cDm() != this.zUq) {
            return false;
        }
        for (int i = this.Ww; i < this.wq; i++) {
            if (this.zTI[i] != aVar.cDi()[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return ((((this.Ww + this.wq) + ((int) this.zUp)) + ((int) this.uck)) + ((int) this.zUq)) + this.zUr.hashCode();
    }

    public final String toString() {
        return "MeasuredLine{mStart=" + this.Ww + ", mEnd=" + this.wq + ", mLetter=" + this.zUn + ", isSmartLetter=" + this.zUo + ", mHeight=" + this.zUp + ", mWidth=" + this.uck + ", mLeftOffset=" + this.zUq + ", mLineRect=" + this.zUr + '}';
    }
}
