package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.ViewPager.e;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyViewPager.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMDotView;

public class AppBrandSmileyPanelBase extends LinearLayout implements e, b {
    public View Iv = null;
    private boolean kex = false;
    public a kgK;
    public MMActivity kgL;
    private AppBrandSmileyViewPager kgM = null;
    private MMDotView kgN;
    private boolean kgO = true;
    public c kgy;

    public interface a {
        void anG();

        void append(String str);
    }

    public final void a(int i, float f, int i2) {
    }

    public final void ae(int i) {
        a aog = this.kgy.aog();
        int pageCount = aog.getPageCount();
        int i2 = i - aog.kgz;
        if (pageCount <= 1) {
            this.kgN.setVisibility(4);
            return;
        }
        this.kgN.setVisibility(0);
        this.kgN.Fa(pageCount);
        this.kgN.Fb(i2);
    }

    public final void af(int i) {
    }

    public final void aod() {
        if (this.kgM != null) {
            this.kgy.kgO = j.aS(getContext());
            a aVar = (a) this.kgM.yE;
            if (aVar != null) {
                aVar.kgY.clear();
                aVar.kgy = this.kgy;
                aVar.notifyDataSetChanged();
            } else {
                u aVar2 = new a();
                aVar2.kgy = this.kgy;
                this.kgM.a(aVar2);
            }
            this.kgM.post(new Runnable() {
                public final void run() {
                    AppBrandSmileyPanelBase.this.ae(AppBrandSmileyPanelBase.this.kgM.yF);
                }
            });
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        aof();
    }

    public void onMeasure(int i, int i2) {
        if (this.kex) {
            super.onMeasure(i, MeasureSpec.makeMeasureSpec(0, Integer.MIN_VALUE));
            return;
        }
        j.aS(getContext());
        super.onMeasure(i, i2);
    }

    @SuppressLint({"WrongCall"})
    public final void ca(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public AppBrandSmileyPanelBase(Context context) {
        super(context, null);
        init();
    }

    public AppBrandSmileyPanelBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public final void aoe() {
        if (this.Iv != null) {
            this.Iv.setVisibility(4);
        }
    }

    private void init() {
        this.kgL = (MMActivity) getContext();
        this.kgy = any();
        this.kgy.kgx = getContext();
        this.kgy.kgR = this.kgK;
    }

    public c any() {
        return new c();
    }

    public void setVisibility(int i) {
        if (i == 0) {
            this.kex = false;
        } else {
            this.kex = true;
        }
        super.setVisibility(i);
        if (!this.kex) {
            this.kgL.aWY();
            initView();
        }
    }

    public final void mt(int i) {
        super.setVisibility(i);
    }

    public final void initView() {
        if (this.Iv == null || getChildCount() <= 0) {
            if (this.Iv == null) {
                this.Iv = View.inflate(ad.getContext(), h.izZ, null);
            } else if (this.Iv.getParent() != null) {
                ((ViewGroup) this.Iv.getParent()).removeView(this.Iv);
            }
            this.kgM = (AppBrandSmileyViewPager) this.Iv.findViewById(g.cOW);
            this.kgM.b((e) this);
            this.kgM.kgy = this.kgy;
            this.kgM.kgX = this;
            this.kgN = (MMDotView) this.Iv.findViewById(g.cOV);
            this.kgN.Fa(1);
            aof();
            addView(this.Iv, new LayoutParams(-1, -1));
            return;
        }
        this.Iv.setVisibility(0);
    }

    private void aof() {
        if (this.kgN != null) {
            boolean aS = j.aS(getContext());
            if (aS != this.kgO) {
                RelativeLayout.LayoutParams layoutParams;
                if (aS) {
                    this.kgN.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(q.e.bvC));
                    layoutParams = (RelativeLayout.LayoutParams) this.kgN.getLayoutParams();
                    layoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(q.e.bxi);
                    this.kgN.setLayoutParams(layoutParams);
                } else {
                    this.kgN.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(q.e.bvA));
                    layoutParams = (RelativeLayout.LayoutParams) this.kgN.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    this.kgN.setLayoutParams(layoutParams);
                }
                this.kgO = aS;
            }
        }
    }
}
