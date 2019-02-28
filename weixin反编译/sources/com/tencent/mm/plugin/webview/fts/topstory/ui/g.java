package com.tencent.mm.plugin.webview.fts.topstory.ui;

import com.tencent.mm.plugin.topstory.a.a.b;
import com.tencent.mm.plugin.webview.fts.topstory.ui.widget.TopStoryVideoPlayTextureView;
import com.tencent.mm.pluginsdk.ui.h.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.d;
import com.tencent.mm.y.d.a;

public final class g {
    static g twt;
    a twA = new a() {
    };
    boolean twB;
    d twu = new d();
    TopStoryVideoView twv;
    com.tencent.mm.plugin.topstory.a.a.d tww;
    public boolean twx;
    boolean twy;
    c twz = new c() {
        public final void a(long j, long j2, long j3, boolean z) {
            com.tencent.mm.plugin.report.d.pVE.a(600, j2, 1, false);
        }

        public final void k(int i, String str) {
            com.tencent.mm.plugin.report.d.pVE.k(14349, str);
        }
    };

    public static g bQQ() {
        if (twt == null) {
            twt = new g();
        }
        return twt;
    }

    private g() {
    }

    final void bQR() {
        com.tencent.mm.plugin.webview.fts.topstory.a.d.tum = this.tww;
        b bVar = new b();
        com.tencent.mm.plugin.webview.fts.topstory.a.d.tun = bVar;
        bVar.skz = (long) com.tencent.mm.plugin.webview.fts.topstory.a.d.tuo;
        com.tencent.mm.plugin.webview.fts.topstory.a.d.tun.skt = System.currentTimeMillis();
        com.tencent.mm.plugin.webview.fts.topstory.a.d.tuo = 2;
    }

    private void bQS() {
        this.twu.bz(false);
    }

    public final boolean bQT() {
        if (this.twv != null) {
            return this.twv.isPlaying();
        }
        return false;
    }

    public final void setMute(boolean z) {
        if (this.twv != null) {
            this.twv.setMute(z);
        }
    }

    public final void bFk() {
        if (this.twv != null) {
            this.twu.a(this.twA);
            this.twv.setKeepScreenOn(true);
            this.twv.play();
            this.twy = false;
        }
    }

    public final void byf() {
        if (this.twv != null) {
            bQS();
            this.twv.setKeepScreenOn(false);
            this.twv.pause();
            this.twy = true;
        }
    }

    public final void stopPlay() {
        if (this.twv != null) {
            x.i("MicroMsg.WebSearch.TopStoryVideoViewMgr", "stop play");
            bQS();
            ((TopStoryVideoPlayTextureView) this.twv.kYP).setAlpha(0.0f);
            this.twv.setKeepScreenOn(false);
            this.twv.stop();
            this.tww = null;
            this.twx = false;
            this.twy = false;
            com.tencent.mm.plugin.webview.fts.topstory.a.d.bQf();
        }
    }

    public final int ahA() {
        if (this.twv != null) {
            return this.twv.ahA();
        }
        return 0;
    }

    public final int ahy() {
        if (this.twv != null) {
            return this.twv.ahy();
        }
        return 0;
    }
}
