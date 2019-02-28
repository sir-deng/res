package com.tencent.mm.plugin.webview.ui.tools.widget.input;

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
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMDotView;

public class WebViewSmileyPanel extends LinearLayout implements e, com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyViewPager.a {
    View Iv = null;
    private boolean kex = false;
    MMActivity kgL;
    private MMDotView kgN;
    private boolean kgO = true;
    c tRD;
    a tRG;
    private WebViewSmileyViewPager tRH = null;

    public interface a {
        void anG();

        void append(String str);
    }

    public final void a(int i, float f, int i2) {
    }

    public final void ae(int i) {
        a bVJ = this.tRD.bVJ();
        int pageCount = bVJ.getPageCount();
        int i2 = i - bVJ.kgz;
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
        if (this.tRH != null) {
            this.tRD.kgO = j.aS(getContext());
            b bVar = (b) this.tRH.yE;
            if (bVar != null) {
                bVar.kgY.clear();
                bVar.tRD = this.tRD;
                bVar.notifyDataSetChanged();
            } else {
                u bVar2 = new b();
                bVar2.tRD = this.tRD;
                this.tRH.a(bVar2);
            }
            this.tRH.post(new Runnable() {
                public final void run() {
                    WebViewSmileyPanel.this.ae(WebViewSmileyPanel.this.tRH.yF);
                }
            });
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        aof();
    }

    protected void onMeasure(int i, int i2) {
        if (this.kex) {
            super.onMeasure(i, MeasureSpec.makeMeasureSpec(0, Integer.MIN_VALUE));
            return;
        }
        j.aS(getContext());
        super.onMeasure(i, i2);
    }

    public WebViewSmileyPanel(Context context) {
        super(context, null);
        init();
    }

    public WebViewSmileyPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.kgL = (MMActivity) getContext();
        this.tRD = new c();
        this.tRD.kgx = getContext();
        this.tRD.tRK = this.tRG;
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
            if (this.Iv == null || getChildCount() <= 0) {
                if (this.Iv == null) {
                    this.Iv = View.inflate(ad.getContext(), R.i.dur, null);
                } else if (this.Iv.getParent() != null) {
                    ((ViewGroup) this.Iv.getParent()).removeView(this.Iv);
                }
                this.tRH = (WebViewSmileyViewPager) this.Iv.findViewById(R.h.cOW);
                this.tRH.b((e) this);
                this.tRH.tRD = this.tRD;
                this.tRH.tRM = this;
                this.kgN = (MMDotView) this.Iv.findViewById(R.h.cOV);
                this.kgN.Fa(1);
                aof();
                addView(this.Iv, new LayoutParams(-1, -1));
                return;
            }
            this.Iv.setVisibility(0);
        }
    }

    private void aof() {
        if (this.kgN != null) {
            boolean aS = j.aS(getContext());
            if (aS != this.kgO) {
                RelativeLayout.LayoutParams layoutParams;
                if (aS) {
                    this.kgN.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(R.f.bvC));
                    layoutParams = (RelativeLayout.LayoutParams) this.kgN.getLayoutParams();
                    layoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(R.f.bxi);
                    this.kgN.setLayoutParams(layoutParams);
                } else {
                    this.kgN.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(R.f.bvA));
                    layoutParams = (RelativeLayout.LayoutParams) this.kgN.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    this.kgN.setLayoutParams(layoutParams);
                }
                this.kgO = aS;
            }
        }
    }
}
