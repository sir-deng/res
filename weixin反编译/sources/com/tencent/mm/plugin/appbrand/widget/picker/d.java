package com.tencent.mm.plugin.appbrand.widget.picker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.q.k;

public class d extends RelativeLayout {
    private static final int kjf = Color.parseColor("#F9F9F9");
    private final int kiY;
    private final int kiZ;
    public e kja;
    FrameLayout kjb;
    public a kjc;
    private boolean kjd;
    public b kje;

    public interface a<T> {
        void f(boolean z, T t);
    }

    public interface b<T> {
        void be(T t);
    }

    final void aot() {
        this.kjc = null;
        this.kje = null;
    }

    private void g(boolean z, Object obj) {
        if (!this.kjd && this.kjc != null) {
            this.kjd = true;
            this.kjc.f(z, obj);
            this.kjd = false;
        }
    }

    public d(Context context) {
        super(context);
        this.kiY = com.tencent.mm.bu.a.fromDPToPix(context, 48);
        this.kiZ = com.tencent.mm.bu.a.fromDPToPix(context, 240);
        setClickable(true);
        setLongClickable(true);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.kiZ);
        layoutParams.addRule(12);
        View frameLayout = new FrameLayout(getContext());
        frameLayout.setId(g.iwW);
        frameLayout.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
            }
        });
        frameLayout.setBackgroundColor(kjf);
        this.kjb = frameLayout;
        addView(frameLayout, layoutParams);
        layoutParams = new RelativeLayout.LayoutParams(-1, this.kiY);
        layoutParams.addRule(2, g.iwW);
        frameLayout = new RelativeLayout(getContext());
        View cc = cc(j.dUn, com.tencent.mm.plugin.appbrand.q.d.bsE);
        cc.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                d.this.g(true, d.this.kja == null ? null : d.this.kja.aoq());
            }
        });
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams2.addRule(11);
        frameLayout.addView(cc, layoutParams2);
        cc = cc(j.dUl, com.tencent.mm.plugin.appbrand.q.d.brF);
        cc.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                d.this.g(false, null);
            }
        });
        layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams2.addRule(9);
        frameLayout.addView(cc, layoutParams2);
        frameLayout.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
            }
        });
        frameLayout.setBackgroundColor(kjf);
        addView(frameLayout, layoutParams);
    }

    public void show() {
        if (this.kja == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (this.kja != null) {
            this.kja.a(this);
        }
    }

    public void hide() {
        super.setVisibility(8);
        g(false, null);
        if (this.kja != null) {
            this.kja.aoo();
        }
    }

    public void setVisibility(int i) {
        if (i != 0) {
            hide();
        } else {
            super.setVisibility(i);
        }
    }

    @SuppressLint({"WrongCall"})
    protected final void ca(int i, int i2) {
        super.onMeasure(i, i2);
    }

    protected void onMeasure(int i, int i2) {
        if (isShown()) {
            super.onMeasure(i, MeasureSpec.makeMeasureSpec(this.kiY + this.kiZ, 1073741824));
        } else {
            super.onMeasure(i, MeasureSpec.makeMeasureSpec(0, Integer.MIN_VALUE));
        }
    }

    private View cc(int i, int i2) {
        View textView = new TextView(new ContextThemeWrapper(getContext(), k.iEv));
        textView.setTextColor(getResources().getColor(i2));
        textView.setText(i);
        textView.setGravity(17);
        return textView;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aot();
        removeAllViews();
    }
}
