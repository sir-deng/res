package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.p.d;
import com.tencent.mm.sdk.platformtools.x;

public final class n implements c {
    public boolean fva = false;
    public boolean isVisible = true;
    private String nWa;
    public double nWe = 1000000.0d;
    public double nWf = 1000000.0d;
    public boolean nYI = true;
    public View nYJ;
    public d nYK;
    public String nYL;
    private TextView nYd;
    private ProgressBar nYe;
    public String nYi = "";
    public ImageView obp;
    public FrameLayout obq;
    public View obr;
    private TextView obs;
    public TextView obt;

    public final void gv(boolean z) {
        if (z && this.isVisible) {
            this.obq.setVisibility(0);
        } else if ((!z || this.isVisible) && !z && this.isVisible) {
            this.obq.setVisibility(4);
        }
    }

    public final void b(LocationInfo locationInfo) {
        this.nWe = locationInfo.nWe;
        this.nWf = locationInfo.nWf;
    }

    public final void Et(String str) {
        x.d("ZItemOverlay", "popView " + this.nYJ.getWidth() + " " + this.nYJ.getHeight());
        this.nYd = (TextView) this.nYJ.findViewById(R.h.cuj);
        this.nYe = (ProgressBar) this.nYJ.findViewById(R.h.ctZ);
        this.obs = (TextView) this.nYJ.findViewById(R.h.cuc);
        this.nYJ.findViewById(R.h.cua).setVisibility(0);
        if (str == null || str.equals("")) {
            this.nYe.setVisibility(0);
        } else {
            this.nYe.setVisibility(8);
            this.nYd.setVisibility(0);
            this.nYd.setText(str);
        }
        if (this.nYL == null || this.nYL.equals("")) {
            this.obs.setText("");
            this.obs.setVisibility(8);
        } else {
            this.obs.setVisibility(0);
            this.obs.setText(this.nYL);
        }
        if (this.nYI) {
            this.nYJ.setVisibility(0);
            this.nYK.updateLocaitonPinLayout(this.nYJ, this.nWe, this.nWf);
            this.nYJ.invalidate();
        }
    }

    public n(d dVar, Context context) {
        View inflate = View.inflate(context, R.i.dne, null);
        this.obt = (TextView) inflate.findViewById(R.h.cnL);
        this.obt.setVisibility(8);
        inflate.setVisibility(8);
        this.obp = (ImageView) inflate.findViewById(R.h.ctR);
        this.obp.setImageResource(R.g.bDs);
        this.obq = (FrameLayout) inflate.findViewById(R.h.cuZ);
        this.obr = inflate.findViewById(R.h.ctK);
        this.nYK = dVar;
        this.nYJ = inflate;
    }

    public final void setText(String str) {
        this.nWa = str;
        Et(this.nWa);
    }

    public final String aWs() {
        return this.nYi;
    }
}
