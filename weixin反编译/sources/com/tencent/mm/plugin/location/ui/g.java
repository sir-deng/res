package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mm.R;
import com.tencent.mm.plugin.p.d;

public final class g extends RelativeLayout {
    private Context mContext;
    public boolean nYD = false;
    private ImageView nYV;
    public d nYW;

    public g(Context context, d dVar) {
        super(context);
        this.nYW = dVar;
        this.mContext = context;
        this.nYV = (ImageView) View.inflate(this.mContext, R.i.dpy, this).findViewById(R.h.cDj);
    }

    public final void remove() {
        this.nYW.removeView(this);
        this.nYD = false;
    }
}
