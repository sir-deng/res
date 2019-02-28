package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.bp.a;
import com.tencent.mm.bp.b;
import com.tencent.mm.plugin.exdevice.e.c;
import com.tencent.mm.plugin.exdevice.e.h;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import junit.framework.Assert;

public final class i extends j {
    public i(byte[] bArr, int i, long j) {
        a hVar = new h();
        hVar.lUr = new c();
        hVar.kyn = new b(bArr);
        hVar.kzz = i;
        this.lPN = hVar;
        this.kGc = j;
    }

    public final byte[] aEp() {
        Assert.assertNotNull(this.lPN);
        try {
            return this.lPN.toByteArray();
        } catch (IOException e) {
            x.e("MicroMsg.exdevice.ExDevicePushManufacturerSvrSendData", "mResp.toByteArray() Failed!!! %s", e.getMessage());
            return null;
        }
    }
}
