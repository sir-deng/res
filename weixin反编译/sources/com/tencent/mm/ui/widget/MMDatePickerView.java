package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.mm.ui.v;
import com.tencent.mm.v.a.g;
import com.tencent.mm.v.a.h;

public class MMDatePickerView extends LinearLayout implements OnClickListener {
    private MMSpinnerDatePicker ltm;
    private Button zCP;
    private Button zCQ;
    private Button zCR;

    public MMDatePickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public MMDatePickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        View inflate = v.fw(context).inflate(h.gZg, this);
        this.zCP = (Button) inflate.findViewById(g.gYF);
        this.zCQ = (Button) inflate.findViewById(g.gXF);
        this.zCR = (Button) inflate.findViewById(g.gXd);
        this.ltm = (MMSpinnerDatePicker) inflate.findViewById(g.gXz);
        this.zCP.setOnClickListener(this);
        this.zCQ.setOnClickListener(this);
        this.zCR.setOnClickListener(this);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == g.gYF) {
            this.ltm.Hs(0);
        } else if (id == g.gXF) {
            this.ltm.Hs(1);
        } else {
            this.ltm.Hs(2);
        }
    }
}
