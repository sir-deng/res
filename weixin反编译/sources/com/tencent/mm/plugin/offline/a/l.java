package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.network.q;
import org.json.JSONObject;

public final class l extends h {
    public String pbs;

    public final int azx() {
        return 78;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.pbs = jSONObject.optString("barcode");
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        super.a(i, i2, i3, str, qVar, bArr);
    }
}
