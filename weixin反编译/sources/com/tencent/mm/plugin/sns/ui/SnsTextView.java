package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.text.SpannableStringBuilder;
import android.text.style.MetricAffectingSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class SnsTextView extends TextView {
    public String nZW = "";
    private char rNq = 0;

    public SnsTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onTextContextMenuItem(int i) {
        return super.onTextContextMenuItem(i);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    protected void onMeasure(int i, int i2) {
        if (q.gHP.gGN == 1 || q.gHP.gGN == -1) {
            try {
                super.onMeasure(i, i2);
                this.rNq = 0;
                return;
            } catch (IndexOutOfBoundsException e) {
                if (this.rNq < 3) {
                    try {
                        CharSequence spannableStringBuilder = new SpannableStringBuilder(getText());
                        MetricAffectingSpan[] metricAffectingSpanArr = (MetricAffectingSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), MetricAffectingSpan.class);
                        if (metricAffectingSpanArr == null || metricAffectingSpanArr.length <= 0) {
                            this.rNq = 'd';
                        } else {
                            spannableStringBuilder.insert(spannableStringBuilder.getSpanStart(metricAffectingSpanArr[0]) - 1, " ");
                            this.rNq = (char) (this.rNq + 1);
                        }
                        setText(spannableStringBuilder);
                        onMeasure(i, i2);
                        return;
                    } catch (IndexOutOfBoundsException e2) {
                        x.i("MicroMsg.SnsTextView", "tryToFix error set origintext " + bi.oN(this.nZW));
                        setText(this.nZW);
                        onMeasure(i, i2);
                        this.rNq = (char) (this.rNq + 1);
                        return;
                    }
                } else if (this.rNq == 3) {
                    x.i("MicroMsg.SnsTextView", "fix error set origintext " + bi.oN(this.nZW));
                    setText(this.nZW);
                    onMeasure(i, i2);
                    this.rNq = (char) (this.rNq + 1);
                    return;
                } else {
                    throw e;
                }
            }
        }
        super.onMeasure(i, i2);
    }

    protected void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.SnsTextView", th, "", new Object[0]);
        }
    }

    public int getBaseline() {
        try {
            return super.getBaseline();
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.SnsTextView", th, "", new Object[0]);
            return -1;
        }
    }

    public boolean onPreDraw() {
        try {
            return super.onPreDraw();
        } catch (Throwable th) {
            return true;
        }
    }
}
