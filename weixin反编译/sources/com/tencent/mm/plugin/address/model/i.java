package com.tencent.mm.plugin.address.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ajx;
import com.tencent.mm.protocal.c.bey;
import com.tencent.mm.protocal.c.bez;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public final class i extends k implements com.tencent.mm.network.k {
    private b gLB;
    private e gLE;
    public bez ioq;

    public i(com.tencent.mm.plugin.o.a.b bVar) {
        a aVar = new a();
        aVar.hnT = new bey();
        aVar.hnU = new bez();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/saveinfo";
        this.gLB = aVar.Kf();
        bey bey = (bey) this.gLB.hnQ.hnY;
        bey.cPf = 2;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder("{\"user_uin\":");
        as.Hm();
        stringBuilder.append(stringBuilder2.append(c.Cn()).append(" ,\"user_data_list\": [").toString());
        if (bVar.type.equals("0")) {
            stringBuilder.append("{\"group_key\": \"invoice_info\",\"group_info\": {\"group_id\": " + bVar.nHp + ",\"field_list\": [{\"key\": \"type\",\"value\": \"" + bVar.type + "\"},{\"key\": \"title\",\"value\": \"" + bVar.title + "\"},{\"key\": \"tax_number\",\"value\": \"" + bVar.nHr + "\"},{\"key\": \"bank_number\",\"value\": \"" + bVar.nHs + "\"},{\"key\": \"phone\",\"value\": \"" + bVar.nHv + "\"},{\"key\": \"company_address_detail\",\"value\": \"" + bVar.nHx + "\"},{\"key\": \"bank_name\",\"value\": \"" + bVar.nHt + "\"}]}}");
        } else {
            stringBuilder.append("{\"group_key\": \"invoice_info\",\"group_info\": {\"group_id\": " + bVar.nHp + ",\"field_list\": [{\"key\": \"type\",\"value\": \"" + bVar.type + "\"},{\"key\": \"title\",\"value\": \"" + bVar.nHq + "\"},{\"key\": \"phone\",\"value\": \"" + bVar.nHw + "\"},{\"key\": \"email\",\"value\": \"" + bVar.fXd + "\"}]}}");
        }
        stringBuilder.append("]}");
        bey.wvG = stringBuilder.toString();
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneSaveUserAutoFillInfo", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            this.ioq = (bez) ((b) qVar).hnR.hnY;
            if (!(this.ioq == null || this.ioq.wRs == null || this.ioq.wRs.size() <= 0 || this.ioq.wRs.get(0) == null)) {
                x.i("MicroMsg.NetSceneSaveUserAutoFillInfo", "resp groupId is.." + ((ajx) this.ioq.wRs.get(0)).wgd);
            }
        }
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1180;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
