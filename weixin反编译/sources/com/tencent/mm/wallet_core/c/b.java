package com.tencent.mm.wallet_core.c;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class b {
    public String fxH = "";
    public String title = "";
    public String zQq = "";
    public String zQr = "";
    public String zQs = "";

    public b(String str) {
        if (!bi.oN(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.title = jSONObject.optString("title");
                this.zQq = jSONObject.optString("body1");
                this.zQr = jSONObject.optString("body2");
                this.zQs = jSONObject.optString("button");
            } catch (Exception e) {
                x.e("MicroMsg.CrtRtnWoding", "crtwoding error %s", e.getMessage());
            }
        }
    }
}
