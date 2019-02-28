package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.support.v4.b.b;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.page.a.a;
import com.tencent.mm.plugin.appbrand.q.e;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.q.i;
import com.tencent.mm.sdk.platformtools.x;

public class AppBrandOptionButton extends FrameLayout {
    private int kbF = i.iAq;
    private ObjectAnimator kbG;
    public boolean kbH = true;
    private View kbI;
    private View kbJ;
    private TextView kbK;
    ImageButton kbL;

    public AppBrandOptionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public AppBrandOptionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.kbI = LayoutInflater.from(context).inflate(h.gYG, this, false);
        this.kbJ = this.kbI.findViewById(g.divider);
        this.kbK = (TextView) this.kbI.findViewById(g.bIL);
        this.kbK.setMaxLines(1);
        this.kbK.setClickable(false);
        this.kbK.setBackground(null);
        View findViewById = this.kbI.findViewById(g.gWU);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        addView(this.kbI, new LayoutParams(-2, -1, 17));
        this.kbI.setVisibility(8);
        this.kbL = new ImageButton(context);
        this.kbL.setClickable(false);
        this.kbL.setBackground(null);
        addView(this.kbL, new LayoutParams(getResources().getDimensionPixelSize(e.byt), -1, 17));
        this.kbG = ObjectAnimator.ofFloat(this.kbL, "alpha", new float[]{1.0f, 0.0f, 1.0f});
        this.kbG.setDuration(2000);
        this.kbG.setInterpolator(new AccelerateInterpolator());
        this.kbG.setRepeatCount(-1);
        this.kbG.setRepeatMode(1);
    }

    public final void setColor(int i) {
        this.kbK.setTextColor(i);
        this.kbJ.setBackgroundColor(b.m(i, 77));
        if (this.kbL.getDrawable() == null || (this.kbL.getDrawable() instanceof com.tencent.mm.svg.a.b)) {
            this.kbL.setImageResource(amY());
            this.kbL.setColorFilter(i, Mode.SRC_ATOP);
        }
    }

    public final void reset() {
        this.kbH = true;
        this.kbI.setVisibility(8);
        this.kbL.setVisibility(0);
        if (!(this.kbL.getDrawable() instanceof com.tencent.mm.svg.a.b)) {
            this.kbL.setImageResource(amY());
        }
    }

    protected int amY() {
        return this.kbF;
    }

    protected final void a(a aVar, int i) {
        x.i("MicroMsg.AppBrandOptionButton", "setImageButtonStatus status %s", aVar);
        switch (aVar) {
            case LBS:
                this.kbF = i.iAm;
                break;
            case VIDEO:
                this.kbF = i.iAn;
                break;
            case VOICE:
                this.kbF = i.iAo;
                break;
            case NORMAL:
                this.kbF = i.iAp;
                break;
        }
        this.kbH = true;
        this.kbI.setVisibility(8);
        this.kbL.setVisibility(0);
        this.kbL.setImageResource(amY());
        this.kbL.setColorFilter(i, Mode.SRC_ATOP);
        if (this.kbF == i.iAp) {
            post(new Runnable() {
                public final void run() {
                    AppBrandOptionButton.this.kbG.end();
                }
            });
        } else {
            post(new Runnable() {
                public final void run() {
                    AppBrandOptionButton.this.kbL.setVisibility(0);
                    AppBrandOptionButton.this.kbG.end();
                    AppBrandOptionButton.this.kbG.start();
                }
            });
        }
    }
}
