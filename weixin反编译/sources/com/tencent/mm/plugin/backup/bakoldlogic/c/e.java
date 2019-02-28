package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.yw;
import com.tencent.mm.protocal.c.yx;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private com.tencent.mm.ad.e gLE;
    private final String id;
    public byte[] kxr;

    public e(String str) {
        a aVar = new a();
        aVar.hnT = new yw();
        aVar.hnU = new yx();
        aVar.uri = "/cgi-bin/micromsg-bin/getbakchatkey";
        this.gLB = aVar.Kf();
        yw ywVar = (yw) this.gLB.hnQ.hnY;
        ywVar.ID = str;
        ywVar.wpN = ac.ceA().ver;
        this.id = str;
        x.i("MicroMsg.NetSceneGetBakchatkey", "init id:%s, ver:0x%x", ywVar.ID, Integer.valueOf(ywVar.wpN));
    }

    public final void cancel() {
        super.cancel();
    }

    public final int getType() {
        return 596;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ad.e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetBakchatkey", "errType %d,  errCode %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            this.kxr = ((yx) this.gLB.hnR.hnY).vQt.wRm.oz;
            String str2 = "MicroMsg.NetSceneGetBakchatkey";
            String str3 = "id:%s,  key len:%d";
            Object[] objArr = new Object[2];
            objArr[0] = this.id;
            objArr[1] = Integer.valueOf(this.kxr == null ? 0 : this.kxr.length);
            x.i(str2, str3, objArr);
            if (this.kxr != null) {
                str2 = "";
                for (byte b : this.kxr) {
                    str2 = str2 + Integer.toHexString(b & 255) + " ";
                }
                x.i("MicroMsg.NetSceneGetBakchatkey", "dump bakchat: %s", str2);
            }
        }
        this.gLE.a(i2, i3, str, this);
    }
}
