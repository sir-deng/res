package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.avz;
import com.tencent.mm.protocal.c.bdm;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class ah extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;

    public ah(LinkedList<avz> linkedList) {
        a aVar = new a();
        aVar.hnT = new bdm();
        aVar.hnU = new bdn();
        aVar.uri = "/cgi-bin/micromsg-bin/reportdynamiccardcodeaction";
        this.gLB = aVar.Kf();
        ((bdm) this.gLB.hnQ.hnY).wQd = linkedList;
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                avz avz = (avz) it.next();
                x.d("MicroMsg.NetSceneReportDynamicCardCodeAction", "ReportDynamicCardCodeActionReq operate card_id=%s,code_id=%s,operate_timestamp=%d,operate_type=%d", avz.fHP, avz.kRn, Integer.valueOf(avz.wKj), Integer.valueOf(avz.wKk));
            }
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneReportDynamicCardCodeAction", "onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1275;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
