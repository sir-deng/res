package com.tencent.mm.af;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.zy;
import com.tencent.mm.protocal.c.zz;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class s extends k implements com.tencent.mm.network.k {
    private Object data;
    public b gLB;
    private e gLE;

    public static void a(e eVar) {
        g.Dp().gRu.b(1285, eVar);
    }

    public static boolean k(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("brand_user_name", str2);
            jSONObject.put("bizchat_id", str3);
            return g.Dp().gRu.a(new s(str, jSONObject.toString()), 0);
        } catch (Exception e) {
            return false;
        }
    }

    private s(String str, String str2) {
        a aVar = new a();
        aVar.hnT = new zy();
        aVar.hnU = new zz();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getbizjsapiresult";
        this.gLB = aVar.Kf();
        zy zyVar = (zy) this.gLB.hnQ.hnY;
        zyVar.wfm = str;
        zyVar.pK = 1;
        zyVar.data = str2;
        this.data = null;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetBizJsApiResult", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1285;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        x.i("MicroMsg.NetSceneGetBizJsApiResult", "do scene");
        return a(eVar, this.gLB, this);
    }
}
