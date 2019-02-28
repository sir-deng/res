package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class d extends a {
    private TextView ueq;
    private View uer;
    public LinearLayout ues;

    public d(View view, k kVar) {
        super(view, kVar);
        this.ues = (LinearLayout) view.findViewById(R.h.cAW);
        this.ues.setVisibility(0);
        this.ueq = (TextView) view.findViewById(R.h.cAY);
        this.uer = view.findViewById(R.h.cAX);
    }

    public final void a(b bVar, int i, int i2) {
        if (bVar.getType() == -3) {
            if (this.ucQ.uaN == 3) {
                this.ues.setVisibility(8);
                return;
            }
            this.ues.setVisibility(0);
            com.tencent.mm.plugin.wenote.model.a.d dVar = (com.tencent.mm.plugin.wenote.model.a.d) bVar;
            if (dVar.tYc > 0) {
                Context context = this.ueq.getContext();
                long j = dVar.tYc;
                this.ueq.setText(this.ueq.getContext().getString(R.l.eyx) + " " + (j < 3600000 ? "" : DateFormat.format(context.getString(R.l.ega), j)));
            }
        }
    }

    public final int bYB() {
        return -3;
    }
}
