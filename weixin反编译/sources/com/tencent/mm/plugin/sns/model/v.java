package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiCreateAudioInstance;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.protocal.c.blz;
import com.tencent.mm.protocal.c.bmc;
import com.tencent.mm.protocal.c.bmd;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public final class v extends k implements com.tencent.mm.network.k {
    private int fvo;
    private b gLB;
    public e gLE;
    private long raE;
    private int scene = 0;

    public v(int i, long j, String str, int i2, List<String> list, int i3) {
        x.d("MicroMsg.NetSceneSnsTagMemberOption", "opCode " + i + " tagName " + str + " memberList " + list.size() + " scene " + i3);
        this.fvo = i;
        this.raE = j;
        this.scene = i3;
        a aVar = new a();
        aVar.hnT = new bmc();
        aVar.hnU = new bmd();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnstagmemberoption";
        aVar.hnS = JsApiCreateAudioInstance.CTRL_INDEX;
        aVar.hnV = 115;
        aVar.hnW = 1000000115;
        this.gLB = aVar.Kf();
        bmc bmc = (bmc) this.gLB.hnQ.hnY;
        bmc.vKI = i;
        bmc.wVU = j;
        bmc.noE = str;
        bmc.kyA = i2;
        bmc.sfa = this.scene;
        LinkedList linkedList = new LinkedList();
        for (String Vf : list) {
            linkedList.add(new bet().Vf(Vf));
        }
        bmc.kyB = linkedList;
        x.d("MicroMsg.NetSceneSnsTagMemberOption", "rr.req.rImpl " + bmc.toString());
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return JsApiCreateAudioInstance.CTRL_INDEX;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneSnsTagMemberOption", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            blz blz = ((bmd) ((b) qVar).hnR.hnY).wVW;
            x.d("MicroMsg.NetSceneSnsTagMemberOption", "Resp.rImpl " + blz.toString());
            s eU = ae.bwl().eU(blz.wVU);
            eU.field_tagId = blz.wVU;
            eU.field_tagName = bi.aD(blz.noE, "");
            switch (this.fvo) {
                case 1:
                case 2:
                case 3:
                    eU.field_count = blz.kyA;
                    eU.bU(blz.kyB);
                    break;
            }
            ae.bwl().a(eU);
            this.gLE.a(i2, i3, str, this);
            return;
        }
        this.gLE.a(i2, i3, str, this);
    }
}
