package com.tencent.mm.modelappbrand;

import android.os.Bundle;
import com.tencent.mm.f.a.qr;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.c;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    public static boolean iw(String str) {
        if (bi.oN(str)) {
            return false;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("BindWxaInfo");
            if (optJSONObject == null || optJSONObject.optInt("openWxaByBizQRCode", 0) <= 0) {
                return false;
            }
            return true;
        } catch (JSONException e) {
            return false;
        }
    }

    private static void a(qr qrVar, com.tencent.mm.x.g.a aVar) {
        qrVar.fJd.appId = aVar.hfj;
        qrVar.fJd.userName = aVar.hfi;
        qrVar.fJd.fJf = aVar.hfh;
        qrVar.fJd.fJg = aVar.hfp;
        qrVar.fJd.fJi = aVar.hfl;
        qrVar.fJd.fJh = aVar.hfq;
        qrVar.fJd.fJj = aVar.hfp != 0;
    }

    public static void a(String str, String str2, boolean z, com.tencent.mm.x.g.a aVar, Bundle bundle) {
        b qrVar = new qr();
        a(qrVar, aVar);
        qrVar.fJd.scene = z ? 1008 : 1007;
        qrVar.fJd.foi = str + (z ? ":" + str2 : "") + ":" + aVar.hfn;
        qrVar.fJd.frc = bundle;
        com.tencent.mm.sdk.b.a.xmy.m(qrVar);
    }

    public static void a(String str, int i, com.tencent.mm.x.g.a aVar, Bundle bundle) {
        b qrVar = new qr();
        a(qrVar, aVar);
        qrVar.fJd.scene = i;
        if (i == 1074) {
            qrVar.fJd.foi = str;
        }
        qrVar.fJd.frc = bundle;
        com.tencent.mm.sdk.b.a.xmy.m(qrVar);
    }

    public static void b(String str, String str2, boolean z, com.tencent.mm.x.g.a aVar, Bundle bundle) {
        b qrVar = new qr();
        a(qrVar, aVar);
        qrVar.fJd.scene = 1044;
        qrVar.fJd.foi = aVar.hfn;
        qrVar.fJd.fJn = z ? 2 : 1;
        com.tencent.mm.f.a.qr.a aVar2 = qrVar.fJd;
        if (z) {
            str2 = str;
        }
        aVar2.fJo = str2;
        qrVar.fJd.fJl.hlk = aVar.hfo;
        if (bi.oN(aVar.hfo)) {
            qrVar.fJd.fJl.hlj = null;
        } else {
            qrVar.fJd.fJl.hlj = str;
        }
        qrVar.fJd.frc = bundle;
        com.tencent.mm.sdk.b.a.xmy.m(qrVar);
    }

    public static boolean IZ() {
        if (!g.Do().CF()) {
            return false;
        }
        c fp = com.tencent.mm.y.c.c.IL().fp("100360");
        if (fp.isValid() && "1".equals(fp.civ().get("isOpenFTSSearchMiniGameEntry"))) {
            return true;
        }
        return false;
    }
}
