package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;

public final class m implements LeadingMarginSpan, f<Boolean>, g<Boolean> {
    public static float ucl = 0.0f;
    private float nDj = 10.0f;
    private final int uca;
    public boolean ucb;
    private final int ucj;
    private float uck;

    public final /* synthetic */ f bYj() {
        return new m(this.ucj, this.uca, this.ucb);
    }

    public final /* bridge */ /* synthetic */ Object getValue() {
        return Boolean.TRUE;
    }

    public m(int i, int i2, boolean z, boolean z2, boolean z3) {
        this.ucj = i;
        this.uca = i2;
        boolean z4 = z && z3 && !z2;
        this.ucb = z4;
    }

    private m(int i, int i2, boolean z) {
        this.ucj = i;
        this.uca = i2;
        this.ucb = z;
    }

    public final int getLeadingMargin(boolean z) {
        ucl = (float) Math.max(Math.round(this.uck + 2.0f > ucl ? this.uck + 2.0f : ucl), this.uca);
        return this.ucb ? 0 : (int) ucl;
    }

    public final void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        Spanned spanned = (Spanned) charSequence;
        if (!this.ucb && spanned.getSpanStart(this) == i6) {
            Style style = paint.getStyle();
            float textSize = paint.getTextSize();
            paint.setStyle(Style.FILL);
            this.nDj = (float) (i4 - i3);
            this.uck = paint.measureText(this.ucj + ".");
            canvas.drawText(this.ucj + ".", (float) i, (float) i4, paint);
            paint.setStyle(style);
            paint.setTextSize(textSize);
        }
    }
}
