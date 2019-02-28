package com.tencent.mm.ui.widget.celltextview.c;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.celltextview.g.a;

public final class d {
    protected static Paint zGw = new Paint(1);
    protected Paint fC;
    protected int jmw;
    protected String kav;
    protected int mType;
    protected int su;
    protected float zGu;
    protected boolean zGv;

    private d(Paint paint, int i, int i2, float f, String str, boolean z) {
        this.mType = 0;
        this.su = i;
        this.jmw = i2;
        this.zGu = f;
        this.kav = str;
        this.zGv = z;
        this.fC = paint;
    }

    public d(Paint paint, String str, float f) {
        this.mType = 0;
        this.mType = 0;
        this.zGu = f;
        this.kav = str;
        this.fC = paint;
    }

    public final String toString() {
        return "type:" + this.mType + ", Text:" + (this.kav == null ? "" : this.kav) + ", Size:" + this.zGu + ", Color:" + this.su;
    }

    public final String getText() {
        return this.kav;
    }

    public final int getType() {
        return this.mType;
    }

    public static boolean cAd() {
        return true;
    }

    public final int cAe() {
        int i = 1;
        x.d("NewTextCell", "[getHashcode] mSize:%s ,mBgColor:%s,mColor:%s,mType:%s,hashCode:%s", Float.valueOf(this.zGu), Integer.valueOf(this.jmw), Integer.valueOf(this.su), Integer.valueOf(this.mType), Integer.valueOf(this.kav.hashCode()));
        float f = ((this.zGu + ((float) this.jmw)) + ((float) this.su)) + ((float) this.mType);
        if (!this.zGv) {
            i = 2;
        }
        return ((int) (((float) i) + f)) * r2;
    }

    public final int getLength() {
        if (this.kav != null) {
            return this.kav.length();
        }
        return 0;
    }

    public final void v(int i, int i2, String str) {
        if (i < 0) {
            i = 0;
        }
        if (i2 > this.kav.length() || i2 < 0) {
            i2 = this.kav.length();
        }
        this.kav = this.kav.substring(i, i2);
        if (!TextUtils.isEmpty(str)) {
            this.kav += str;
        }
    }

    public final float HA(int i) {
        cAg();
        FontMetrics fontMetrics = zGw.getFontMetrics();
        return (fontMetrics.bottom - fontMetrics.top) + ((float) i);
    }

    public final int a(int i, int i2, float[] fArr) {
        if (TextUtils.isEmpty(this.kav)) {
            return 0;
        }
        cAg();
        int i3 = i + i2;
        if (i3 > this.kav.length()) {
            i3 = this.kav.length();
        }
        if (i < i3) {
            return zGw.getTextWidths(this.kav, i, i3, fArr);
        }
        return 0;
    }

    public final float l(int i, float f) {
        if (TextUtils.isEmpty(this.kav)) {
            return 0.0f;
        }
        cAg();
        int i2 = i + 0;
        if (i2 > this.kav.length()) {
            i2 = this.kav.length();
        }
        if (i2 <= 0) {
            return 0.0f;
        }
        float[] fArr = new float[i];
        i2 = zGw.getTextWidths(this.kav, 0, i2, fArr);
        float f2 = 0.0f;
        for (int i3 = 0; i3 < i2; i3++) {
            f2 += fArr[i3];
        }
        return (((float) i2) * f) + f2;
    }

    public final d cAf() {
        return new d(this.fC, this.su, this.jmw, this.zGu, this.kav, this.zGv);
    }

    public final void a(Canvas canvas, RectF rectF, float f, float f2) {
        int i = 0;
        cAg();
        float height = rectF.top + ((float) ((int) (((rectF.height() - zGw.descent()) - zGw.ascent()) / 2.0f)));
        float f3 = rectF.left;
        String str = this.kav;
        Paint paint = zGw;
        canvas.save();
        char charAt = str.charAt(0);
        if (a.s(charAt)) {
            canvas.translate(-a.b(charAt, paint), 0.0f);
        }
        boolean isUnderlineText = paint.isUnderlineText();
        paint.setUnderlineText(false);
        char[] cArr = new char[str.length()];
        str.getChars(0, str.length(), cArr, 0);
        if (this.jmw != 0) {
            paint.setColor(this.jmw);
            paint.setStyle(Style.FILL);
            canvas.drawRect(rectF, paint);
            paint.setStyle(Style.STROKE);
            paint.setColor(this.su);
        }
        int i2 = -1;
        while (i < str.length()) {
            char c = cArr[i];
            if (Character.isHighSurrogate(c)) {
                if (-1 == i2) {
                    i2 = i;
                }
                i++;
            } else {
                if (-1 != i2) {
                    String substring = str.substring(i2, i);
                    canvas.drawText(substring, f3, height, paint);
                    f3 += paint.measureText(substring) + f;
                    i2 = -1;
                }
                String ch = Character.toString(c);
                canvas.drawText(ch, f3, height, paint);
                f3 += paint.measureText(ch) + f;
            }
            i++;
        }
        if (-1 != i2) {
            String substring2 = str.substring(i2, str.length());
            canvas.drawText(substring2, f3, height, paint);
            f3 += paint.measureText(substring2) + f;
        }
        if (isUnderlineText) {
            float strokeWidth = paint.getStrokeWidth();
            Style style = paint.getStyle();
            paint.setStrokeWidth(paint.getTextSize() / 15.0f);
            paint.setStyle(Style.FILL);
            float strokeWidth2 = (paint.getStrokeWidth() * 1.5f) + (paint.getFontMetrics().leading + height);
            canvas.drawLine(f3, strokeWidth2, f3, strokeWidth2, paint);
            paint.setStrokeWidth(strokeWidth);
            paint.setStyle(style);
        }
        paint.setUnderlineText(isUnderlineText);
        canvas.restore();
    }

    public final void cAg() {
        zGw.set(this.fC);
        zGw.setColor(this.su);
        zGw.setTextSize(this.zGu);
        zGw.setUnderlineText(this.zGv);
    }
}
