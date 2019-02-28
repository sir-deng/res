package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.content.Context;
import android.support.v4.view.z;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.appbrand.q.d;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.plugin.appbrand.widget.a;
import com.tencent.mm.ui.v;
import com.tencent.smtt.sdk.WebView;

public final class b extends LinearLayout implements c {
    private int Df;
    private AppBrandCapsuleOptionButton kbC;
    public boolean kbD;
    private AppBrandCapsuleHomeButton kbq;
    private LinearLayout kbt;
    private ImageView kbu;
    private int kbv;
    private double kbw;
    private OnClickListener kbx = null;
    private OnClickListener kby = null;

    public b(Context context, boolean z) {
        super(context);
        this.kbD = z;
        setLayoutParams(new MarginLayoutParams(-1, a.cj(getContext())));
        setGravity(19);
        addView(v.fw(getContext()).inflate(h.izi, this, false));
        this.kbv = -1;
        this.Df = getResources().getColor(d.bre);
        this.kbw = 1.0d;
        this.kbC = (AppBrandCapsuleOptionButton) findViewById(g.ixI);
        this.kbq = (AppBrandCapsuleHomeButton) findViewById(g.ixH);
        this.kbu = (ImageView) findViewById(g.ixG);
        this.kbt = (LinearLayout) findViewById(g.ixF);
        this.kbq.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (b.this.kby != null) {
                    b.this.kby.onClick(b.this.kbq);
                } else if (b.this.kbx != null) {
                    b.this.kbx.onClick(b.this.kbq);
                }
            }
        });
        this.kbC.setVisibility(0);
        this.kbq.setVisibility(0);
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        amX();
    }

    public final void amX() {
        if (!this.kbD && getPaddingTop() == 0) {
            return;
        }
        if (z.ai(this)) {
            setPadding(0, Math.max(com.tencent.mm.ui.statusbar.a.ab(j.ch(getContext())), 0), 0, 0);
            requestLayout();
            return;
        }
        post(new Runnable() {
            public final void run() {
                b.this.amX();
            }
        });
    }

    public final void a(OnClickListener onClickListener) {
        this.kbx = onClickListener;
    }

    public final void b(OnClickListener onClickListener) {
        this.kby = onClickListener;
    }

    public final void a(OnLongClickListener onLongClickListener) {
        this.kbq.setOnLongClickListener(onLongClickListener);
    }

    public final void vz(String str) {
    }

    public final CharSequence amR() {
        return null;
    }

    public final void c(OnClickListener onClickListener) {
    }

    public final double amS() {
        return this.kbw;
    }

    public final void k(double d) {
    }

    public final void vA(String str) {
    }

    public final void setBackgroundColor(int i) {
    }

    public final int getBackgroundColor() {
        return this.Df;
    }

    public final void d(OnClickListener onClickListener) {
        this.kbC.setOnClickListener(onClickListener);
    }

    public final void ds(boolean z) {
        if (z) {
            this.kbt.setVisibility(0);
        } else {
            this.kbt.setVisibility(8);
        }
        if (z) {
            this.kbC.setVisibility(0);
        } else {
            this.kbC.setVisibility(8);
        }
        if (z) {
            this.kbq.setVisibility(0);
        } else {
            this.kbq.setVisibility(8);
        }
    }

    public final void amT() {
        this.kbC.reset();
        this.kbq.reset();
        amV();
    }

    public final void vB(String str) {
        if ("white".equals(str)) {
            this.kbv = -1;
        } else if ("black".equals(str)) {
            this.kbv = WebView.NIGHT_MODE_COLOR;
        }
        amU();
    }

    public final void mk(int i) {
        this.kbv = i;
        amU();
    }

    public final int getForegroundColor() {
        return this.kbv;
    }

    private void amU() {
        amV();
        if (this.kbv == -1) {
            this.kbu.setImageResource(d.iuS);
            this.kbt.setBackgroundResource(f.ivv);
            return;
        }
        this.kbu.setImageResource(d.iuT);
        this.kbt.setBackgroundResource(f.ivw);
    }

    private void amV() {
        if (this.kbv == -1) {
            this.kbC.setColor(-1);
            this.kbq.setColor(-1);
            return;
        }
        this.kbC.setColor(WebView.NIGHT_MODE_COLOR);
        this.kbq.setColor(WebView.NIGHT_MODE_COLOR);
    }

    public final void amW() {
    }

    public final void dt(boolean z) {
    }

    public final void du(boolean z) {
    }

    public final void b(com.tencent.mm.plugin.appbrand.page.a.a aVar) {
        this.kbC.a(aVar, this.kbv);
    }

    public final View getActionView() {
        return this;
    }
}
