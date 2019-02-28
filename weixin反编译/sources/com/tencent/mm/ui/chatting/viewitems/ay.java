package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.viewitems.b.a;

final class ay extends a {
    TextView ikM;

    ay() {
    }

    public final a dI(View view) {
        super.ds(view);
        this.ljv = (TextView) view.findViewById(R.h.bVh);
        this.qng = (TextView) view.findViewById(R.h.bVm);
        this.ikM = (TextView) view.findViewById(R.h.bTJ);
        this.mXO = (CheckBox) view.findViewById(R.h.bTE);
        this.kbO = view.findViewById(R.h.bUE);
        return this;
    }
}
