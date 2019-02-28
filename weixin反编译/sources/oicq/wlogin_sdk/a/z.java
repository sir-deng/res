package oicq.wlogin_sdk.a;

import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetAudioState;
import oicq.wlogin_sdk.tools.util;

public final class z extends a {
    public int AGH;
    public int AGI;

    public z() {
        this.AGH = 0;
        this.AGI = 0;
        this.AFz = JsApiGetAudioState.CTRL_INDEX;
    }

    public final Boolean cKK() {
        if (this.AGj < 2) {
            return Boolean.valueOf(false);
        }
        this.AGH = util.Y(this.AFt, this.AGi);
        if (this.AGj < (this.AGH + 2) + 2) {
            return Boolean.valueOf(false);
        }
        this.AGI = util.Y(this.AFt, (this.AGi + 2) + this.AGH);
        return Boolean.valueOf(true);
    }
}
