package com.tencent.mm.plugin.webview.fts.c;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.webview.fts.c.b.a;
import com.tencent.mm.plugin.webview.fts.c.b.b;
import com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class d implements a {
    public al jwI;
    public int jwJ;
    private com.tencent.mm.plugin.webview.ui.tools.jsapi.d tsa;
    private b txY;
    FtsWebVideoView tyi;

    public d(FtsWebVideoView ftsWebVideoView, b bVar, com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar) {
        this.tyi = ftsWebVideoView;
        this.txY = bVar;
        this.txY.a(this);
        this.tsa = dVar;
    }

    public final void clean() {
        x.i("MicroMsg.JsApiVideoCallback", "clean %s", toString());
        ahD();
    }

    public final void ag(JSONObject jSONObject) {
        this.tsa.a("onVideoPlayerCallback", null, jSONObject);
    }

    public final void bRl() {
        try {
            JSONObject ahC = ahC();
            ahC.put("currentTime", this.tyi.txp.ahA());
            ag(a(6, ahC));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.JsApiVideoCallback", e, null, new Object[0]);
        }
    }

    public final JSONObject ahC() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(SlookAirButtonFrequentContactAdapter.DATA, this.tyi.jvM);
        return jSONObject;
    }

    public final void ahD() {
        if (this.jwI != null) {
            this.jwI.TN();
        }
    }

    public final void agq() {
    }

    public final void afQ() {
    }

    public final void onDestroy() {
        x.d("MicroMsg.JsApiVideoCallback", "onDestroy clean");
        clean();
        this.tyi.txA = null;
    }

    public final void agJ() {
    }

    public final boolean aeX() {
        return false;
    }

    public final void bQK() {
    }

    public final void bRj() {
    }

    public final JSONObject a(int i, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("playerId", this.tyi.jvN);
        jSONObject2.put("event", i);
        if (jSONObject != null) {
            jSONObject2.put("detail", jSONObject);
        }
        return jSONObject2;
    }
}
