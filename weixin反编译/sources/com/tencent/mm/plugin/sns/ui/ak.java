package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.sight.decode.a.a;
import com.tencent.mm.protocal.c.bpb;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public final class ak {
    public String fsC;
    public int position;
    public a qBQ;
    public boolean qWK = false;
    public bpb rDi;
    public View rDj;
    public View rDk;
    public MMPinProgressBtn rDl;
    public TextView rDm;
    public boolean rDn = false;
    public int rDo = 0;
    public ImageView rqV;
    public TextView rqY;

    public final void a(bpb bpb, int i, String str, boolean z) {
        this.rDi = bpb;
        this.position = i;
        this.fsC = str;
        this.qWK = z;
    }
}
