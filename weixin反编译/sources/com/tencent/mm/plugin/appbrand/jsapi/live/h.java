package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.os.Bundle;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import java.math.BigDecimal;
import org.json.JSONException;
import org.json.JSONObject;

public final class h extends c {
    private static final int CTRL_INDEX = 365;
    public static final String NAME = "updateLivePlayer";

    protected final int j(JSONObject jSONObject) {
        return jSONObject.optInt("livePlayerId");
    }

    protected final boolean c(p pVar, int i, View view, JSONObject jSONObject) {
        x.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView : livePlayerId=%d", Integer.valueOf(i));
        if (view instanceof CoverViewContainer) {
            View w = ((CoverViewContainer) view).w(View.class);
            if (w instanceof AppBrandLivePlayerView) {
                j jVar;
                AppBrandLivePlayerView appBrandLivePlayerView = (AppBrandLivePlayerView) w;
                Bundle r = r(jSONObject);
                appBrandLivePlayerView.joj = r.getBoolean("needEvent", appBrandLivePlayerView.joj);
                l lVar = appBrandLivePlayerView.jof;
                if (lVar.gOP) {
                    l.c(NAME, r);
                    lVar.w(r);
                    boolean isPlaying = lVar.joC.isPlaying();
                    String string = r.getString("playUrl", lVar.joE);
                    if (!(string == null || string.isEmpty() || lVar.joE == null || lVar.joE.equalsIgnoreCase(string) || !lVar.joC.isPlaying())) {
                        x.i("TXLivePlayerJSAdapter", "updateLivePlayer: stopPlay playUrl-old = " + lVar.joE + " playUrl-new = " + string);
                        lVar.joC.stopPlay(true);
                    }
                    lVar.joE = string;
                    int v = lVar.v(r);
                    if (v != lVar.joF && lVar.joC.isPlaying()) {
                        x.i("TXLivePlayerJSAdapter", "updateLivePlayer: stopPlay  playType-old = " + lVar.joF + " playType-new = " + v);
                        lVar.joC.stopPlay(true);
                    }
                    lVar.joF = v;
                    lVar.mAutoPlay = r.getBoolean("autoplay", lVar.mAutoPlay);
                    if (!((!lVar.mAutoPlay && !isPlaying) || lVar.joE == null || lVar.joE.isEmpty() || lVar.joC.isPlaying())) {
                        x.i("TXLivePlayerJSAdapter", "updateLivePlayer: startPlay");
                        lVar.joC.startPlay(lVar.joE, lVar.joF);
                    }
                    jVar = new j();
                } else {
                    jVar = new j(-3, "uninited livePlayer");
                }
                x.i("MicroMsg.AppBrandLivePlayerView", "onUpdate code:%d info:%s", Integer.valueOf(jVar.errorCode), jVar.joy);
                return true;
            }
            x.e("MicroMsg.JsApiUpdateLivePlayer", "targetView not AppBrandLivePlayerView");
            return false;
        }
        x.w("MicroMsg.JsApiUpdateLivePlayer", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i));
        return false;
    }

    private static Bundle r(JSONObject jSONObject) {
        Bundle bundle = new Bundle();
        try {
            if (jSONObject.has("playUrl")) {
                bundle.putString("playUrl", jSONObject.getString("playUrl"));
                x.i("MicroMsg.JsApiUpdateLivePlayer", "convertParams playUrl:%s", jSONObject.getString("playUrl"));
            }
        } catch (JSONException e) {
            x.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", "playUrl", e.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("mode")) {
                bundle.putInt("mode", jSONObject.getInt("mode"));
            }
        } catch (JSONException e2) {
            x.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", "mode", e2.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("autoplay")) {
                bundle.putBoolean("autoplay", jSONObject.getBoolean("autoplay"));
            }
        } catch (JSONException e22) {
            x.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", "autoplay", e22.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("muted")) {
                bundle.putBoolean("muted", jSONObject.getBoolean("muted"));
            }
        } catch (JSONException e222) {
            x.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", "muted", e222.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("orientation")) {
                bundle.putString("orientation", jSONObject.getString("orientation"));
            }
        } catch (JSONException e2222) {
            x.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", "orientation", e2222.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("objectFit")) {
                bundle.putString("objectFit", jSONObject.getString("objectFit"));
            }
        } catch (JSONException e22222) {
            x.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", "objectFit", e22222.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("backgroundMute")) {
                bundle.putBoolean("backgroundMute", jSONObject.getBoolean("backgroundMute"));
            }
        } catch (JSONException e222222) {
            x.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", "backgroundMute", e222222.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("minCache")) {
                bundle.putFloat("minCache", BigDecimal.valueOf((long) jSONObject.getInt("minCache")).floatValue());
            }
        } catch (JSONException e2222222) {
            x.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", "minCache", e2222222.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("maxCache")) {
                bundle.putFloat("maxCache", BigDecimal.valueOf((long) jSONObject.getInt("maxCache")).floatValue());
            }
        } catch (JSONException e22222222) {
            x.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", "maxCache", e22222222.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("needEvent")) {
                bundle.putBoolean("needEvent", jSONObject.getBoolean("needEvent"));
            }
        } catch (JSONException e222222222) {
            x.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", "needEvent", e222222222.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("debug")) {
                bundle.putBoolean("debug", jSONObject.getBoolean("debug"));
            }
        } catch (JSONException e2222222222) {
            x.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", "debug", e2222222222.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("soundMode")) {
                bundle.putString("soundMode", jSONObject.getString("soundMode"));
                x.i("MicroMsg.JsApiUpdateLivePlayer", "convertParams soundMode:%s", jSONObject.getString("soundMode"));
            }
        } catch (JSONException e22222222222) {
            x.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", "soundMode", e22222222222.getLocalizedMessage());
        }
        return bundle;
    }
}
