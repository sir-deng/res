package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.sdk.platformtools.x;

public class GameChattingRoomWebViewUI extends WebViewUI {
    private String jumpUrl = "";
    private int tLA = 5;
    final a tLB = new a() {
        public final void a(boolean z, String str, int i) {
            GameChattingRoomWebViewUI.this.setResult(GameChattingRoomWebViewUI.this.tLz, new Intent());
            GameChattingRoomWebViewUI.this.finish();
        }
    };
    final a tLC = new a() {
        public final void a(boolean z, String str, int i) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", GameChattingRoomWebViewUI.this.jumpUrl);
            GameChattingRoomWebViewUI.this.setResult(GameChattingRoomWebViewUI.this.tLA, intent);
            GameChattingRoomWebViewUI.this.finish();
        }
    };
    private int tLz = 4;

    protected final boolean Cz(String str) {
        return true;
    }

    protected final void PR(String str) {
        x.i("MicroMsg.GameChattingRoomWebViewUI", "url = %s", str);
        this.jumpUrl = str;
        String stringExtra = getIntent().getStringExtra("action");
        if (stringExtra != null) {
            String string;
            if (getIntent().getStringExtra("app_name") == null) {
                string = getString(R.l.dDZ);
            } else {
                string = getString(R.l.dUk, new Object[]{r1});
            }
            String string2 = getString(R.l.dUr);
            if (stringExtra.equals("action_create")) {
                e.a(this.mController, getString(R.l.dXY), string, string2, this.tLB, this.tLC);
            } else if (stringExtra.equals("action_join")) {
                e.a(this.mController, getString(R.l.esD), string, string2, this.tLB, this.tLC);
            }
        }
    }
}
