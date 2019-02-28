package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI;
import com.tencent.mm.ui.base.a;

@a(3)
public class TransparentWebViewUI extends GameWebViewUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.screenOrientation == 1001) {
            this.screenOrientation = 0;
            if (this.tEW != null) {
                this.tEW.enable();
            }
        } else if (this.screenOrientation == 1002) {
            this.screenOrientation = 1;
            if (this.tEW != null) {
                this.tEW.enable();
            }
        }
    }

    protected final void initView() {
        boolean z = true;
        super.initView();
        this.tGC.tEE = true;
        this.tGC.iQf = false;
        this.tGC.ky(true);
        this.tGC.AX(0);
        if (!(getIntent() != null && getIntent().hasExtra("show_full_screen") && getIntent().getBooleanExtra("show_full_screen", false))) {
            z = false;
        }
        if (z && this.tET != null) {
            this.tET.tRd = false;
        }
    }

    protected final void bTe() {
        setBackGroundColorResource(0);
        this.mController.contentView.setBackgroundResource(0);
        this.pzt.setBackgroundResource(17170445);
        this.pzt.setBackgroundColor(0);
        findViewById(R.h.cYX).setBackgroundResource(17170445);
    }
}
