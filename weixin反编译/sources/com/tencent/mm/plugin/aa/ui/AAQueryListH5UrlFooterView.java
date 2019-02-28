package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.v;

public class AAQueryListH5UrlFooterView extends LinearLayout {
    TextView iks;

    public AAQueryListH5UrlFooterView(Context context) {
        super(context);
        init(context);
    }

    public AAQueryListH5UrlFooterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public AAQueryListH5UrlFooterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.iks = (TextView) v.fw(context).inflate(g.uHu, this, true).findViewById(f.ukJ);
    }
}
