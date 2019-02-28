package com.tencent.mm.plugin.nearby.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;

public class CleanLocationHeaderView extends LinearLayout {
    private ImageView jTd;
    private TextView oTL;

    public CleanLocationHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ce(context);
    }

    public CleanLocationHeaderView(Context context) {
        super(context);
        ce(context);
    }

    private void ce(Context context) {
        View inflate = View.inflate(context, R.i.doO, this);
        this.oTL = (TextView) inflate.findViewById(R.h.czk);
        this.oTL.setSingleLine(false);
        this.jTd = (ImageView) inflate.findViewById(R.h.cyS);
        this.oTL.setText(R.l.dTR);
        this.jTd.setImageResource(R.k.dAu);
    }
}
