package com.tencent.mm.plugin.g.a.a;

import com.tencent.mm.plugin.exdevice.j.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class e {
    private final g kBJ = new g();
    public final h kBK = new h();

    public final boolean ad(byte[] bArr) {
        if (bi.by(bArr)) {
            x.e("MicroMsg.exdevice.IBeaconProtocal", "dataIn is null or nil");
            return false;
        }
        a aVar = new a(bArr.length);
        aVar.K(bArr, bArr.length);
        boolean a = this.kBJ.a(aVar);
        if (a) {
            a = this.kBK.a(aVar);
            if (a) {
                return a;
            }
            x.d("MicroMsg.exdevice.IBeaconProtocal", "mSectionB.ParseTLV Failed!!!");
            return a;
        }
        x.d("MicroMsg.exdevice.IBeaconProtocal", "mSectionA.ParseTLV Failed!!!");
        return a;
    }
}
