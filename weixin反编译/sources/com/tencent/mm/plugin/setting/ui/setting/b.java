package com.tencent.mm.plugin.setting.ui.setting;

import android.widget.LinearLayout;

final class b {
    LinearLayout qsH;
    LinearLayout qsI;
    LinearLayout qsJ;
    LinearLayout qsK;
    LinearLayout qsL;

    b() {
    }

    public final void JI(String str) {
        if (str.equals("downloading")) {
            this.qsH.setVisibility(0);
            this.qsI.setVisibility(8);
            this.qsJ.setVisibility(8);
            this.qsK.setVisibility(8);
            this.qsL.setVisibility(8);
        } else if (str.equals("downloaded")) {
            this.qsH.setVisibility(8);
            this.qsI.setVisibility(0);
            this.qsJ.setVisibility(8);
            this.qsK.setVisibility(8);
            this.qsL.setVisibility(8);
        } else if (str.equals("undownloaded")) {
            this.qsH.setVisibility(8);
            this.qsI.setVisibility(8);
            this.qsJ.setVisibility(0);
            this.qsK.setVisibility(8);
            this.qsL.setVisibility(8);
        } else if (str.equals("using")) {
            this.qsH.setVisibility(8);
            this.qsI.setVisibility(8);
            this.qsJ.setVisibility(8);
            this.qsK.setVisibility(0);
            this.qsL.setVisibility(8);
        } else if (str.equals("canceling")) {
            this.qsH.setVisibility(8);
            this.qsI.setVisibility(8);
            this.qsJ.setVisibility(8);
            this.qsK.setVisibility(8);
            this.qsL.setVisibility(0);
        }
    }
}
