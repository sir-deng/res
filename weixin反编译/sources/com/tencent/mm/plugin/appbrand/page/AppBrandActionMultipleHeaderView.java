package com.tencent.mm.plugin.appbrand.page;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;

public class AppBrandActionMultipleHeaderView extends LinearLayout {
    private ImageView fwa;
    private TextView ioR;

    public AppBrandActionMultipleHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    @TargetApi(11)
    public AppBrandActionMultipleHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(h.izV, this);
        this.fwa = (ImageView) findViewById(g.ixu);
        this.ioR = (TextView) findViewById(g.ixv);
    }

    public final void lu(int i) {
        this.ioR.setTextColor(i);
    }
}
