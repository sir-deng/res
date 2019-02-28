package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.kiss.widget.textview.PLTextView;
import com.tencent.mm.kiss.widget.textview.a.a;
import com.tencent.mm.kiss.widget.textview.c;
import com.tencent.mm.kiss.widget.textview.d;
import com.tencent.mm.kiss.widget.textview.f;

public class SnsPostDescPreloadTextView extends PLTextView {
    private static int hitCount = 0;
    private static int missCount = 0;
    private boolean rXO = false;
    public int rXP = 0;

    public SnsPostDescPreloadTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SnsPostDescPreloadTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected final a Em() {
        this.rXO = true;
        return d.bDp().bDo();
    }

    public final void setMaxLines(int i) {
        boolean z = true;
        if (getText() == null) {
            super.setMaxLines(i);
        }
        if (i <= 6) {
            if (this.rXO) {
                b(d.bDp().bDq());
                this.rXO = false;
            }
            z = false;
        } else {
            if (!this.rXO) {
                b(d.bDp().bDo());
                this.rXO = true;
            }
            z = false;
        }
        if (z) {
            f a = c.gUU.a(El(), getText());
            if (a == null) {
                int bDr = this.rXP > 0 ? this.rXP : d.bDp().bDr();
                if (bDr > 0) {
                    a = d.a(getText(), bDr, El()).Ej();
                }
            }
            if (a != null) {
                b(a);
            }
        }
    }

    protected final void p(CharSequence charSequence) {
        super.p(charSequence);
        hitCount++;
    }

    protected final void o(CharSequence charSequence) {
        if (charSequence != null) {
            setText(e.a(getContext(), charSequence.toString(), El().gVS), true);
        }
        missCount++;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }
}
