package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.protocal.c.oy;

public final class c extends a {
    protected TextView ldS;
    protected TextView ldT;

    public c(Context context) {
        super(context);
    }

    protected final void axU() {
        this.ldT = (TextView) axT().findViewById(R.h.bPH);
        this.ldS = (TextView) axT().findViewById(R.h.bSg);
    }

    protected final void axV() {
        if (this.kOv.aui().vYM != null && this.kOv.aui().vYM.size() > 0) {
            oy oyVar = (oy) this.kOv.aui().vYM.get(0);
            if (this.ldJ != null) {
                this.ldJ.setText(oyVar.title);
            }
            if (this.ldS != null) {
                if (TextUtils.isEmpty(oyVar.kPB)) {
                    this.ldS.setVisibility(8);
                } else {
                    this.ldS.setText(oyVar.kPB);
                }
            }
            if (this.ldT == null) {
                return;
            }
            if (TextUtils.isEmpty(oyVar.kPC)) {
                this.ldT.setVisibility(8);
            } else {
                this.ldT.setText(oyVar.kPC);
            }
        }
    }

    public final void r(boolean z, boolean z2) {
    }
}
