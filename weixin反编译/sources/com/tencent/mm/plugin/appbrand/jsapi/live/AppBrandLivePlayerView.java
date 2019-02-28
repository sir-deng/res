package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.smtt.sdk.WebView;

public class AppBrandLivePlayerView extends TXCloudVideoView {
    l jof;
    a jog;
    b joh;
    int joi;
    boolean joj;

    public interface b {
        void e(boolean z, int i);
    }

    public interface a {
        void agI();

        boolean isFullScreen();

        void kC(int i);
    }

    public AppBrandLivePlayerView(Context context) {
        super(context);
        init(context);
    }

    public AppBrandLivePlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public final void sX() {
        j jVar;
        l lVar = this.jof;
        if (lVar.gOP) {
            lVar.joC.stopPlay(true);
            lVar.joC.setPlayListener(null);
            jVar = new j();
        } else {
            jVar = new j(-3, "uninited livePlayer");
        }
        x.i("MicroMsg.AppBrandLivePlayerView", "onDestroy code:%d info:%s", Integer.valueOf(jVar.errorCode), jVar.joy);
    }

    final void cO(boolean z) {
        if (this.joj && this.joh != null) {
            this.joh.e(z, this.joi);
        }
    }

    private void init(Context context) {
        this.jof = new l(context);
        setBackgroundColor(WebView.NIGHT_MODE_COLOR);
    }
}
