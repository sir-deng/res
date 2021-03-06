package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.view.View;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d extends c {
    private static final int CTRL_INDEX = 367;
    public static final String NAME = "operateLivePlayer";

    protected final int j(JSONObject jSONObject) {
        return jSONObject.optInt("livePlayerId");
    }

    protected final boolean c(p pVar, int i, View view, JSONObject jSONObject) {
        x.i("MicroMsg.JsApiOperateLivePlayer", "onUpdateView : livePlayerId=%d", Integer.valueOf(i));
        if (view instanceof CoverViewContainer) {
            View w = ((CoverViewContainer) view).w(View.class);
            if (w instanceof AppBrandLivePlayerView) {
                AppBrandLivePlayerView appBrandLivePlayerView = (AppBrandLivePlayerView) w;
                String optString = jSONObject.optString(Columns.TYPE);
                x.i("MicroMsg.JsApiOperateLivePlayer", "onUpdateView operateType=%s", optString);
                boolean z = true;
                switch (optString.hashCode()) {
                    case -802181223:
                        if (optString.equals("exitFullScreen")) {
                            z = true;
                            break;
                        }
                        break;
                    case 458133450:
                        if (optString.equals("requestFullScreen")) {
                            z = false;
                            break;
                        }
                        break;
                }
                switch (z) {
                    case false:
                        int i2;
                        JSONArray optJSONArray = jSONObject.optJSONArray(SlookAirButtonFrequentContactAdapter.DATA);
                        if (optJSONArray == null || optJSONArray.length() == 0) {
                            x.w("MicroMsg.JsApiOperateLivePlayer", "onUpdateView directionArr nil");
                            i2 = 0;
                        } else {
                            i2 = optJSONArray.optInt(0, 0);
                        }
                        x.i("MicroMsg.AppBrandLivePlayerView", "enterFullScreen direction:%s", Integer.valueOf(i2));
                        if (appBrandLivePlayerView.jog == null) {
                            x.w("MicroMsg.AppBrandLivePlayerView", "enterFullScreen mFullScreenDelegate null");
                            return false;
                        } else if (appBrandLivePlayerView.jog.isFullScreen()) {
                            x.i("MicroMsg.AppBrandLivePlayerView", "enterFullScreen already full screen");
                            return true;
                        } else {
                            appBrandLivePlayerView.jog.kC(i2);
                            appBrandLivePlayerView.joi = i2;
                            appBrandLivePlayerView.cO(true);
                            return true;
                        }
                    case true:
                        x.i("MicroMsg.AppBrandLivePlayerView", "quitFullScreen");
                        if (appBrandLivePlayerView.jog == null) {
                            x.w("MicroMsg.AppBrandLivePlayerView", "quitFullScreen mFullScreenDelegate null");
                            return false;
                        } else if (appBrandLivePlayerView.jog.isFullScreen()) {
                            appBrandLivePlayerView.jog.agI();
                            return true;
                        } else {
                            x.i("MicroMsg.AppBrandLivePlayerView", "quitFullScreen already quit full screen");
                            return true;
                        }
                    default:
                        j sN = appBrandLivePlayerView.jof.sN(optString);
                        x.i("MicroMsg.AppBrandLivePlayerView", "onOperate code:%d info:%s", Integer.valueOf(sN.errorCode), sN.joy);
                        if (optString.equalsIgnoreCase("stop") && sN.errorCode == 0 && appBrandLivePlayerView.jog != null && appBrandLivePlayerView.jog.isFullScreen()) {
                            appBrandLivePlayerView.setVisibility(0);
                        }
                        if (sN.errorCode == 0) {
                            return true;
                        }
                        return false;
                }
            }
            x.e("MicroMsg.JsApiOperateLivePlayer", "targetView not AppBrandLivePlayerView");
            return false;
        }
        x.w("MicroMsg.JsApiOperateLivePlayer", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i));
        return false;
    }
}
