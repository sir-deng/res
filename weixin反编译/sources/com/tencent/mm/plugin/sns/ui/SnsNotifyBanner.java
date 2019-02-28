package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;

public class SnsNotifyBanner extends RelativeLayout {
    private LayoutInflater DF;
    private View Iv;
    private TextView rKv;
    private ImageView rKw;
    int rKx = 0;

    public SnsNotifyBanner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public SnsNotifyBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.DF = (LayoutInflater) getContext().getSystemService("layout_inflater");
        this.Iv = this.DF.inflate(g.qNI, this, true);
        this.rKv = (TextView) this.Iv.findViewById(f.qKh);
        this.rKw = (ImageView) this.Iv.findViewById(f.qKg);
        this.rKw.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                SnsNotifyBanner.this.setVisibility(8);
            }
        });
    }
}
