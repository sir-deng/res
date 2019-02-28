package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.bu.a;
import com.tencent.mm.v.a.e;
import com.tencent.mm.v.a.g;

public final class b {
    public TextView ikL;
    private View tKM;
    private ImageView xLY;
    public TextView xLZ;
    public ImageView xMa;
    public ImageView xMb;
    private ImageView xMc;
    public ImageView xMd;
    private View xMe;

    public b(View view) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(-2, -1);
        } else {
            layoutParams.width = -2;
            layoutParams.height = -1;
        }
        view.setLayoutParams(layoutParams);
        this.ikL = (TextView) view.findViewById(g.cSp);
        this.xLZ = (TextView) view.findViewById(g.cPI);
        this.xMa = (ImageView) view.findViewById(g.gXG);
        this.xMb = (ImageView) view.findViewById(g.gXI);
        this.xMc = (ImageView) view.findViewById(g.gXO);
        this.tKM = view.findViewById(g.gWW);
        this.xLY = (ImageView) view.findViewById(g.bLj);
        this.xMd = (ImageView) view.findViewById(g.gXQ);
        this.xMe = view;
    }

    public final void setTitle(CharSequence charSequence) {
        this.ikL.setText(charSequence);
        if (a.ez(this.ikL.getContext())) {
            this.ikL.setTextSize(0, ((float) a.ab(this.ikL.getContext(), e.bun)) * a.ex(this.ikL.getContext()));
        }
    }

    public final void lS(boolean z) {
        this.xMc.setVisibility(z ? 0 : 8);
    }

    public final void o(OnClickListener onClickListener) {
        this.tKM.setOnClickListener(onClickListener);
    }
}
