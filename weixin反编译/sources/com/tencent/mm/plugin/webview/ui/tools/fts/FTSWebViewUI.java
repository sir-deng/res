package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.mm.R;
import com.tencent.mm.bb.g;

public class FTSWebViewUI extends FTSBaseWebViewUI {
    protected final String getHint() {
        return getString(R.l.dGK);
    }

    protected final void alu() {
        super.alu();
        g.ir(this.scene);
    }

    protected void onResume() {
        super.onResume();
        g.Rf();
    }

    protected void onPause() {
        super.onPause();
        g.Rg();
    }

    protected void onDestroy() {
        super.onDestroy();
        g.Rh();
        g.Ri();
    }
}
