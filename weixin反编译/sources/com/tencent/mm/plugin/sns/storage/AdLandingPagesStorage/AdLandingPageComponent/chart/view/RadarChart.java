package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view;

import android.content.Context;
import android.text.Spannable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.baseview.Chart;
import java.util.ArrayList;

public class RadarChart extends Chart {
    private Context context;
    public ArrayList<a> rof;
    public c rog = new c();
    public TextView roh;
    public RadarGrid roi;
    private RadarDataLayer[] roj;
    private a rok;
    private boolean rol = true;
    private boolean rom = true;
    public int ron = 3;
    public int roo = 0;
    public int rop = 4;
    public Spannable[] roq;
    private float ror = 1.0f;

    public RadarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }

    public RadarChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
    }

    public final void a(a... aVarArr) {
        int i;
        int i2 = 0;
        removeAllViews();
        for (a size : aVarArr) {
            if (size.size() <= 0) {
                throw new Exception("Not enough elements.");
            }
        }
        for (a size2 : aVarArr) {
            i = 0;
            while (i < aVarArr.length) {
                if (size2.a(aVarArr[i])) {
                    i++;
                } else {
                    throw new Error("Layer not compatible.");
                }
            }
        }
        this.roq = aVarArr[0].bxz();
        this.roo = aVarArr[0].size();
        if (this.rof == null) {
            this.rof = new ArrayList();
        }
        for (Object add : aVarArr) {
            this.rof.add(add);
        }
        this.roi = new RadarGrid(this.context, this.roo, this.rop, this.ror, this.roq, this.rog);
        addView(this.roi);
        this.roj = new RadarDataLayer[this.ron];
        while (i2 < this.roj.length && this.rof.size() > i2) {
            this.roj[i2] = new RadarDataLayer(this.context, this.ror, (a) this.rof.get(i2));
            addView(this.roj[i2]);
            i2++;
        }
        if (this.rok == null) {
            this.rok = new a(this.context, this.rog);
        }
        addView(this.rok);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            getChildAt(i5).layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
        }
    }
}
