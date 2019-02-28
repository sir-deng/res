package com.tencent.mm.kiss.widget.textview;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class PLTextView extends StaticTextView {
    private static long gUW = 0;
    private static int gUX = 0;
    private static long gUY = -2147483648L;
    private static long gUZ = 0;
    private static int gVa = 0;
    private static long gVb = -2147483648L;
    private static long gVc = 0;
    private static int gVd = 0;
    private static long gVe = -2147483648L;
    private static boolean gVf = false;

    public PLTextView(Context context) {
        super(context);
    }

    public PLTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PLTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void setText(CharSequence charSequence) {
        long j = 0;
        if (!bi.N(charSequence)) {
            long currentTimeMillis;
            boolean z;
            if (h.DEBUG) {
                currentTimeMillis = System.currentTimeMillis();
            } else {
                currentTimeMillis = 0;
            }
            if (Ep() != null && Ep().gVw) {
                c.gUU.a(El(), Ep());
            }
            f a = c.gUU.a(El(), charSequence);
            if (a != null) {
                p(charSequence);
                b(a);
                z = true;
            } else {
                o(charSequence);
                z = false;
            }
            if (h.DEBUG) {
                j = System.currentTimeMillis();
                x.d("MicroMsg.PLTextView", "setText used %fms, hitCache: %b, hashCode: %d, text: %s hitCache %s", Double.valueOf(((double) (j - currentTimeMillis)) / 1000000.0d), Boolean.valueOf(z), Integer.valueOf(hashCode()), charSequence, Boolean.valueOf(z));
            }
            if (gVf) {
                currentTimeMillis = j - currentTimeMillis;
                gUW += currentTimeMillis;
                gUX++;
                if (currentTimeMillis > gUY) {
                    gUY = currentTimeMillis;
                }
            }
        } else if (h.DEBUG) {
            x.d("MicroMsg.PLTextView", "set null text");
        }
    }

    public void onMeasure(int i, int i2) {
        long j = 0;
        if (gVf) {
            j = System.currentTimeMillis();
        }
        super.onMeasure(i, i2);
        if (gVf) {
            j = System.currentTimeMillis() - j;
            gUZ += j;
            gVa++;
            if (j > gVb) {
                gVb = j;
            }
        }
    }

    protected void onDraw(Canvas canvas) {
        long j = 0;
        if (gVf) {
            j = System.currentTimeMillis();
        }
        super.onDraw(canvas);
        if (gVf) {
            j = System.currentTimeMillis() - j;
            gVc += j;
            gVd++;
            if (j > gVe) {
                gVe = j;
            }
        }
    }

    public void o(CharSequence charSequence) {
        super.setText(charSequence, false);
    }

    public void p(CharSequence charSequence) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (Ep() != null) {
            Ep().gVw = false;
        }
    }
}
