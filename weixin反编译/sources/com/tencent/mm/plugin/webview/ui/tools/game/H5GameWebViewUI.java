package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.webview.ui.tools.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;

@a(19)
public class H5GameWebViewUI extends GameWebViewUI {
    private int oxp;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.H5GameWebViewUI", "onCreate");
        this.neY = false;
        this.oxp = this.screenOrientation;
    }

    protected void onNewIntent(Intent intent) {
        x.i("MicroMsg.H5GameWebViewUI", "onNewIntent");
        super.onNewIntent(intent);
        boolean booleanExtra = getIntent().getBooleanExtra("show_full_screen", false);
        setIntent(intent);
        String stringExtra = intent.getStringExtra("rawUrl");
        x.d("MicroMsg.H5GameWebViewUI", "url = " + stringExtra);
        if (!this.tFb.equals(stringExtra)) {
            if (stringExtra.startsWith("http://game.weixin.qq.com/cgi-bin/h5/static/gameloading/index.html")) {
                this.tFb = stringExtra;
            }
            if (this.fJB.equals(stringExtra)) {
                this.screenOrientation = this.oxp;
                getIntent().putExtra("show_full_screen", booleanExtra);
                bTv();
                return;
            }
            this.fJB = stringExtra;
            this.screenOrientation = getIntent().getIntExtra("screen_orientation", -1);
            this.tFB.ndB = this.fJB;
            if (this.jAn == null) {
                this.jAn = new e(this, this.pzt);
            } else {
                this.jAn.b(stringExtra, null, null);
            }
            this.pzt.loadUrl("about:blank");
            super.j(this.fJB, false, -1);
        }
    }

    public void onResume() {
        afw();
        super.onResume();
    }

    protected final boolean bTo() {
        return false;
    }
}
