package com.tencent.mm.plugin.backup.d;

import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.backup.a.d;
import com.tencent.mm.protocal.c.es;
import com.tencent.mm.protocal.c.eu;
import com.tencent.mm.protocal.c.pd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.q;
import java.util.LinkedList;

public final class b extends k implements com.tencent.mm.network.k {
    public com.tencent.mm.ad.b gLB;
    protected e gLE;

    public b(LinkedList<pd> linkedList, String str) {
        a aVar = new a();
        aVar.hnT = new es();
        aVar.hnU = new eu();
        aVar.uri = "/cgi-bin/micromsg-bin/bakchatcreateqrcode";
        this.gLB = aVar.Kf();
        es esVar = (es) this.gLB.hnQ.hnY;
        esVar.vQF = linkedList.size();
        esVar.vQG = linkedList;
        esVar.vQI = q.FY();
        esVar.vQH = com.tencent.mm.compatible.e.q.getDeviceID(ad.getContext());
        esVar.vQJ = str;
        esVar.kyU = 0;
        esVar.sfa = 2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.i("MicroMsg.BackupCreateQRCodeScene", "err: %d, %d, %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            x.i("MicroMsg.BackupCreateQRCodeScene", "onGYNetEnd QRCodeUrl:%s", ((eu) this.gLB.hnR.hnY).vQN);
            d.Z(r0.vQt.wRm.oz);
            this.gLE.a(i2, i3, str, this);
            return;
        }
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 704;
    }
}
