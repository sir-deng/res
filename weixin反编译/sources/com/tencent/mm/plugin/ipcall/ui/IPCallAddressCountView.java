package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.R;

public class IPCallAddressCountView extends FrameLayout {
    private View mcj;
    private TextView nOb;

    public IPCallAddressCountView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private IPCallAddressCountView(Context context) {
        super(context);
        init();
    }

    public IPCallAddressCountView(Context context, int i) {
        this(context);
        rP(i);
    }

    private void init() {
        inflate(getContext(), R.i.dlZ, this);
        this.mcj = findViewById(R.h.bXk);
        this.nOb = (TextView) findViewById(R.h.bXj);
    }

    public final void rP(int i) {
        this.nOb.setText(getContext().getResources().getQuantityString(R.j.duy, i, new Object[]{Integer.valueOf(i)}));
    }
}
