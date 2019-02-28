package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;

public final class d implements LeadingMarginSpan, f<Boolean>, g<Boolean> {
    private static Path ubZ = null;
    private final int uca;
    public boolean ucb;

    public final /* synthetic */ f bYj() {
        return new d(this.uca, this.ucb);
    }

    public final /* bridge */ /* synthetic */ Object getValue() {
        return Boolean.TRUE;
    }

    public d(int i, boolean z, boolean z2, boolean z3) {
        this.uca = i;
        boolean z4 = z && z3 && !z2;
        this.ucb = z4;
        if (ubZ == null) {
            ubZ = new Path();
        }
    }

    private d(int i, boolean z) {
        this.uca = i;
        this.ucb = z;
    }

    public final int getLeadingMargin(boolean z) {
        return this.ucb ? 0 : this.uca;
    }

    public final void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        Spanned spanned = (Spanned) charSequence;
        if (!this.ucb && spanned.getSpanStart(this) == i6) {
            Style style = paint.getStyle();
            paint.setStyle(Style.FILL);
            ubZ.reset();
            ubZ.addCircle(0.0f, 0.0f, 6.0f, Direction.CW);
            FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            int i8 = (fontMetricsInt.ascent + ((fontMetricsInt.descent + i4) + i4)) / 2;
            canvas.save();
            canvas.translate((float) ((i2 * 6) + i), (float) i8);
            canvas.drawPath(ubZ, paint);
            canvas.restore();
            paint.setStyle(style);
        }
    }
}
