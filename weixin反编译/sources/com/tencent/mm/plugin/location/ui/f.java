package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.p.d;
import com.tencent.mm.sdk.platformtools.x;

public final class f implements c {
    public boolean fva = false;
    private boolean isVisible = true;
    private String nWa;
    private double nWe = 1000000.0d;
    private double nWf = 1000000.0d;
    private boolean nYI = true;
    private View nYJ;
    private d nYK;
    public String nYL;
    private TextView nYM;
    private TextView nYN;
    public ImageButton nYO;
    private String nYi = "";

    public f(d dVar, Context context) {
        View findViewById = ((Activity) context).findViewById(R.h.ctV);
        this.nYM = (TextView) findViewById.findViewById(R.h.ctT);
        this.nYN = (TextView) findViewById.findViewById(R.h.ctU);
        this.nYO = (ImageButton) findViewById.findViewById(R.h.cub);
        this.nYK = dVar;
        this.nYJ = findViewById;
    }

    public final void setText(String str) {
        this.nWa = str;
        CharSequence charSequence = this.nWa;
        x.d("NewItemOverlay", "popView " + this.nYJ.getWidth() + " " + this.nYJ.getHeight());
        if (!(charSequence == null || charSequence.equals(""))) {
            this.nYN.setText(charSequence);
        }
        if (this.nYL == null || this.nYL.equals("")) {
            this.nYM.setText(R.l.etl);
        } else {
            this.nYM.setText(this.nYL);
        }
        if (this.nYI) {
            this.nYJ.setVisibility(0);
            this.nYJ.invalidate();
        }
    }

    public final String aWs() {
        return this.nYi;
    }
}
