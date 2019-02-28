package com.tencent.mm.plugin.label.ui;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.widget.MMTextView;

public final class c {
    MMTextView nVL;
    TextView nVM;
    LinearLayout nVN;

    public c(View view) {
        this.nVL = (MMTextView) view.findViewById(R.h.csn);
        this.nVM = (TextView) view.findViewById(R.h.csm);
        this.nVN = (LinearLayout) view.findViewById(R.h.csl);
    }
}
