package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class c extends b {
    private static final int CTRL_INDEX = 7;
    public static final String NAME = "removeVideoPlayer";

    protected final int j(JSONObject jSONObject) {
        return jSONObject.optInt("videoPlayerId", 0);
    }

    protected final boolean b(p pVar, int i, View view, JSONObject jSONObject) {
        x.i("MicroMsg.JsApiRemoveVideoPlayer", "onRemoveView videoPlayerId=%d", Integer.valueOf(i));
        if (view instanceof CoverViewContainer) {
            final AppBrandVideoView appBrandVideoView = (AppBrandVideoView) ((CoverViewContainer) view).w(AppBrandVideoView.class);
            if (appBrandVideoView == null) {
                x.w("MicroMsg.JsApiRemoveVideoPlayer", "onRemoveView not AppBrandVideoView");
                return false;
            }
            ah.y(new Runnable() {
                public final void run() {
                    appBrandVideoView.clean();
                }
            });
            super.b(pVar, i, view, jSONObject);
            return true;
        }
        x.w("MicroMsg.JsApiRemoveVideoPlayer", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i));
        return false;
    }
}
