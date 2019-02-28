package com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bds;
import com.tencent.mm.protocal.c.bdt;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends k implements com.tencent.mm.network.k {
    private b gLB;
    private e gLE;

    public a(String str, String str2, String str3, com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b.c.a aVar, d dVar) {
        boolean z = false;
        com.tencent.mm.ad.b.a aVar2 = new com.tencent.mm.ad.b.a();
        aVar2.hnT = new bds();
        aVar2.hnU = new bdt();
        aVar2.uri = "/cgi-bin/micromsg-bin/reportproject8voiceinfo";
        this.gLB = aVar2.Kf();
        bds bds = (bds) this.gLB.hnQ.hnY;
        bds.wQj = str;
        bds.wQk = str2;
        bds.wQl = str3;
        bds.wQm = aVar != null ? aVar.name : "";
        bds.wQn = aVar != null ? aVar.fXl : "";
        if (dVar != null) {
            boolean z2;
            String str4 = "MicroMsg.NetSceneUploadVoiceCheckBlackResult";
            String str5 = "alvinluo %b, %b";
            Object[] objArr = new Object[2];
            if (dVar.jzo == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[0] = Boolean.valueOf(z2);
            if (dVar.jzp == null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            x.i(str4, str5, objArr);
            bds.wQo = dVar.jzo;
            bds.wQp = dVar.jzp;
        }
    }

    public final int getType() {
        return 533;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneUploadVoiceCheckBlackResult", "alvinluo NetSceneUploadVoiceCheckBlackResult errType: %d, errCode: %d, errMsg: %s, type: %d", Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(533));
        if (i2 == 0 && i3 == 0) {
            x.i("MicroMsg.NetSceneUploadVoiceCheckBlackResult", "alvinluo report voiceCheckBlack result success");
        } else {
            x.e("MicroMsg.NetSceneUploadVoiceCheckBlackResult", "alvinluo report voiceCheckBlack result failed");
            int i4 = f.jzB;
            f.ahW();
        }
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }
}
