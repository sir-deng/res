package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.v.a.g;
import com.tencent.mm.v.a.h;

public class MMProgressBar extends LinearLayout {
    private int max = 100;
    private al pbx = new al(new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean uG() {
            int a = MMProgressBar.this.ykQ - MMProgressBar.this.ykP;
            if (a > 0) {
                int i = (int) (((double) a) * 0.6d);
                MMProgressBar mMProgressBar = MMProgressBar.this;
                int b = MMProgressBar.this.ykP;
                if (i <= 0) {
                    i = 1;
                }
                mMProgressBar.ykP = i + b;
                MMProgressBar.b(MMProgressBar.this, MMProgressBar.this.ykP);
                long c = (long) (((MMProgressBar.this.max - a) * 40) / MMProgressBar.this.max);
                MMProgressBar.this.pbx.K(c, c);
            }
            return false;
        }
    }, false);
    private TextView qAV;
    private int ykP = 0;
    private int ykQ = 0;
    private TextView ykR;
    public a ykS;

    public interface a {
        void yH(int i);
    }

    static /* synthetic */ void b(MMProgressBar mMProgressBar, int i) {
        TextView textView = mMProgressBar.ykR;
        int width = (mMProgressBar.getWidth() * mMProgressBar.ykP) / mMProgressBar.max;
        if (width < b.b(mMProgressBar.getContext(), 20.0f)) {
            width = b.b(mMProgressBar.getContext(), 20.0f);
        }
        textView.setWidth(width);
        if (mMProgressBar.ykS != null) {
            mMProgressBar.ykS.yH(i);
        }
    }

    public MMProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        inflate(getContext(), h.gZF, this);
        this.ykR = (TextView) findViewById(g.gXA);
        this.qAV = (TextView) findViewById(g.gXB);
    }

    public final void setProgress(int i) {
        if (i > this.max) {
            i = this.max;
        }
        this.ykQ = i;
        if (this.pbx.cgx()) {
            ms(true);
        }
    }

    public final void ms(boolean z) {
        if (z) {
            this.pbx.K(40, 40);
        } else {
            this.pbx.TN();
        }
    }
}
