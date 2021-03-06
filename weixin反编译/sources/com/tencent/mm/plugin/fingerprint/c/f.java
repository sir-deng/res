package com.tencent.mm.plugin.fingerprint.c;

import android.os.Build;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.fingerprint.b.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f extends i implements k {
    public f(String str, String str2, String str3, int i) {
        Map hashMap = new HashMap();
        hashMap.put("encrypted_open_info", URLEncoder.encode(str));
        hashMap.put("encrypted_rsa_sign", URLEncoder.encode(str2));
        hashMap.put("passwd", str3);
        D(hashMap);
        hashMap = new HashMap();
        hashMap.put("device_type", Build.MODEL);
        hashMap.put("open_scene", String.valueOf(i));
        aB(hashMap);
    }

    public final int azx() {
        return 119;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        super.a(i, i2, i3, str, qVar, bArr);
        if (i2 == 0 && i3 == 0) {
            x.i("MicroMsg.NetSceneTenpayOpenTouch", "open fingerprintpay success");
            e.fn(true);
            return;
        }
        x.e("MicroMsg.NetSceneTenpayOpenTouch", "open fingerprintpay failed");
    }

    public final int Hx() {
        return 1599;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/androidopentouch";
    }
}
