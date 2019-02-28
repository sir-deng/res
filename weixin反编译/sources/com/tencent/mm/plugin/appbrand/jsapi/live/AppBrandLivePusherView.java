package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.smtt.sdk.WebView;

public class AppBrandLivePusherView extends TXCloudVideoView {
    m jok;
    ITXLivePushListener jol;

    public AppBrandLivePusherView(Context context) {
        super(context);
        init(context);
    }

    public AppBrandLivePusherView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public final void u(Bundle bundle) {
        j jVar;
        m mVar = this.jok;
        if (bundle == null) {
            jVar = new j(-1, "invalid params");
        } else {
            m.c(i.NAME, bundle);
            if (mVar.gOP) {
                mVar.c(bundle, false);
                String string = bundle.getString("pushUrl", mVar.joR);
                if (!(string == null || string.isEmpty() || mVar.joR == null || mVar.joR.equalsIgnoreCase(string) || !mVar.joP.isPushing())) {
                    x.i("TXLivePusherJSAdapter", "updateLivePusher: stopPusher");
                    mVar.joP.stopCameraPreview(true);
                    mVar.joP.stopPusher();
                }
                mVar.joR = string;
                if (!(!bundle.getBoolean("autopush", false) || mVar.joR == null || mVar.joR.isEmpty() || mVar.joP.isPushing())) {
                    x.i("TXLivePusherJSAdapter", "updateLivePusher: startPusher");
                    mVar.joA.setVisibility(0);
                    if (mVar.joZ) {
                        mVar.joP.startCameraPreview(mVar.joA);
                    }
                    mVar.joP.startPusher(mVar.joR);
                }
                jVar = new j();
            } else {
                jVar = new j(-3, "uninited livePusher");
            }
        }
        x.i("MicroMsg.AppBrandLivePusherView", "onUpdate code:%d info:%s", Integer.valueOf(jVar.errorCode), jVar.joy);
    }

    public final boolean sM(String str) {
        x.i("MicroMsg.AppBrandLivePusherView", "onOperate code:%d info:%s", Integer.valueOf(r2.errorCode), this.jok.sO(str).joy);
        if (this.jok.sO(str).errorCode == 0) {
            return true;
        }
        return false;
    }

    public final void sX() {
        j jVar;
        m mVar = this.jok;
        if (mVar.gOP) {
            mVar.joP.stopCameraPreview(true);
            mVar.joP.stopPusher();
            mVar.joP.setPushListener(null);
            jVar = new j();
        } else {
            jVar = new j(-3, "uninited livePusher");
        }
        x.i("MicroMsg.AppBrandLivePusherView", "onDestroy code:%d info:%s", Integer.valueOf(jVar.errorCode), jVar.joy);
    }

    private void init(Context context) {
        this.jok = new m(context);
        setBackgroundColor(WebView.NIGHT_MODE_COLOR);
    }
}
