package com.tencent.mm.plugin.webview.fts.topstory.ui.widget;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import com.tencent.mm.plugin.s.i;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class TopStoryVideoPlayTextureView extends VideoPlayerTextureView {
    private Object lock = new Object();

    public TopStoryVideoPlayTextureView(Context context) {
        super(context);
    }

    public TopStoryVideoPlayTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TopStoryVideoPlayTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void setVideoPath(String str) {
        super.setVideoPath(str);
    }

    protected final void aKo() {
        x.i("MicroMsg.WebSearch.TopStoryVideoPlayTextureView", "%d open video [%s]", Integer.valueOf(hashCode()), this.path);
        synchronized (this.lock) {
            if (this.vES != null) {
                this.vES.ovC = null;
                this.vES.ovB.stop();
                this.vES.release();
                this.vES = null;
            }
            if (bi.oN(this.path)) {
                x.w("MicroMsg.WebSearch.TopStoryVideoPlayTextureView", "%d open video but path is null.", Integer.valueOf(hashCode()));
                return;
            }
            try {
                this.HE = false;
                this.vES = new i(Looper.getMainLooper());
                this.vES.setPath(this.path);
                this.vES.a(this.ovm);
                this.vES.gD(this.ove);
                this.vES.gE(this.ovf);
                this.vES.ovC = this.vFe;
                this.vES.setSurface(this.mSurface);
                this.vES.gC(this.vFb);
                if (this.mSurface != null) {
                    this.vES.bap();
                } else if (this.vEX) {
                    this.vES.bap();
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WebSearch.TopStoryVideoPlayTextureView", e, "prepare async error %s", e.getMessage());
                if (this.qAJ != null) {
                    this.qAJ.onError(-1, -1);
                }
            }
        }
    }

    public final void stop() {
        e.post(new Runnable() {
            public final void run() {
                synchronized (TopStoryVideoPlayTextureView.this.lock) {
                    super.stop();
                }
            }
        }, "player-stop");
    }

    public final boolean start() {
        boolean start;
        synchronized (this.lock) {
            start = super.start();
        }
        return start;
    }

    public final void pause() {
        synchronized (this.lock) {
            super.pause();
        }
    }

    public final void q(double d) {
        synchronized (this.lock) {
            super.q(d);
        }
    }

    public final void setMute(boolean z) {
        synchronized (this.lock) {
            super.setMute(z);
        }
    }
}
