package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;

public class NetStatGroup extends LinearLayout {
    final TextView pGU;
    LinearLayout qnc;

    public NetStatGroup(Context context) {
        this(context, null);
    }

    public NetStatGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View.inflate(context, R.i.doW, this);
        this.qnc = (LinearLayout) findViewById(R.h.atY);
        this.pGU = (TextView) findViewById(R.h.cap);
        this.pGU.setTextSize(0, (float) context.getResources().getDimensionPixelSize(R.f.bvt));
    }
}
