package com.tencent.mm.plugin.appbrand.page;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;

public class AppBrandActionHeaderLayout extends LinearLayout {
    public LinearLayout jHX;
    public HorizontalScrollView jHY;
    public AppBrandActionSingleHeaderView jHZ;
    public AppBrandActionMultipleHeaderView jIa;
    public AppBrandActionMultipleHeaderView jIb;
    public AppBrandActionMultipleHeaderView jIc;
    public AppBrandActionMultipleHeaderView jId;
    public TextView jIe;
    private int jIf = 1;
    private int jIg = 2;
    public String mAppId;
    public Context mContext;

    public AppBrandActionHeaderLayout(Context context) {
        super(context);
        ce(context);
    }

    public AppBrandActionHeaderLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ce(context);
    }

    @TargetApi(11)
    public AppBrandActionHeaderLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ce(context);
    }

    private void ce(Context context) {
        this.mContext = context;
        ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(h.izT, this);
        this.jHX = (LinearLayout) findViewById(g.ixs);
        this.jHY = (HorizontalScrollView) findViewById(g.ixr);
        this.jHZ = (AppBrandActionSingleHeaderView) findViewById(g.ixC);
        this.jIa = (AppBrandActionMultipleHeaderView) findViewById(g.ixw);
        this.jIb = (AppBrandActionMultipleHeaderView) findViewById(g.ixx);
        this.jIc = (AppBrandActionMultipleHeaderView) findViewById(g.ixy);
        this.jId = (AppBrandActionMultipleHeaderView) findViewById(g.ixz);
        this.jIe = (TextView) findViewById(g.ixt);
        this.jIa.setVisibility(8);
        this.jIb.setVisibility(8);
        this.jIc.setVisibility(8);
        this.jId.setVisibility(8);
        this.jIe.setVisibility(8);
    }

    public final void lt(int i) {
        this.jIe.setText(i);
        this.jIe.setVisibility(0);
        this.jHX.setVisibility(8);
        this.jHY.setVisibility(8);
    }
}
