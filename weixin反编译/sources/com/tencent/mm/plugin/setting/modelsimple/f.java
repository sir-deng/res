package com.tencent.mm.plugin.setting.modelsimple;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aho;
import com.tencent.mm.protocal.c.ahp;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class f extends k implements com.tencent.mm.network.k {
    private b gLB;
    private e gLE;

    public f() {
        a aVar = new a();
        aVar.hnT = new aho();
        aVar.hnU = new ahp();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/getinfo";
        this.gLB = aVar.Kf();
        aho aho = (aho) this.gLB.hnQ.hnY;
        aho.cPf = 2;
        LinkedList linkedList = new LinkedList();
        linkedList.add("invoice_info.title");
        linkedList.add("invoice_info.tax_number");
        linkedList.add("invoice_info.bank_number");
        linkedList.add("invoice_info.bank_name");
        linkedList.add("invoice_info.type");
        linkedList.add("invoice_info.email");
        linkedList.add("invoice_info.company_address");
        linkedList.add("invoice_info.company_address_detail");
        linkedList.add("invoice_info.company_address_postcode");
        linkedList.add("invoice_info.phone");
        aho.wvF = linkedList;
        aho.wvE = false;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetUserAutoFillInfo", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            x.i("MicroMsg.NetSceneGetUserAutoFillInfo", "return is 0.now we parse the json and resetList..");
            ahp ahp = (ahp) ((b) qVar).hnR.hnY;
            if (ahp.wvG != null) {
                try {
                    boolean z = new JSONObject(ahp.wvG).getBoolean("has_invoice_info");
                    x.i("MicroMsg.NetSceneGetUserAutoFillInfo", "has_invoice_info is .." + z);
                    as.Hm();
                    c.Db().a(w.a.USERINFO_ABOUT_INVOICE_ENTRANCE_BOOLEAN, Boolean.valueOf(z));
                } catch (JSONException e) {
                    x.e("MicroMsg.NetSceneGetUserAutoFillInfo", "error parse this json");
                }
            }
        }
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1191;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
