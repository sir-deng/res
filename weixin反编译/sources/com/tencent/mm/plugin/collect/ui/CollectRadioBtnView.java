package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.v;

public class CollectRadioBtnView extends LinearLayout {
    private TextView jOY;
    private ImageView lti;

    public CollectRadioBtnView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public CollectRadioBtnView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        View inflate = v.fw(context).inflate(g.uHY, this);
        this.lti = (ImageView) inflate.findViewById(f.uAW);
        this.jOY = (TextView) inflate.findViewById(f.cSB);
    }

    public final void yb(String str) {
        this.jOY.setText(str);
    }

    public final void oL(int i) {
        this.lti.setImageResource(i);
    }
}
