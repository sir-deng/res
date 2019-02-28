package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.bp.a;
import com.tencent.mm.sdk.platformtools.x;

public abstract class d extends c {
    protected a lPO = null;
    private short lPP = (short) -1;
    private short lPQ = (short) -1;

    protected abstract a ap(byte[] bArr);

    public d(long j, int i, int i2, byte[] bArr) {
        x.i("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", "onDeviceRequest deviceId = " + j + " seq = " + i + " cmdId = " + i2);
        this.kGc = j;
        this.lPP = (short) i2;
        this.lPQ = (short) i;
        ap(bArr);
    }

    public final short aEn() {
        return this.lPP;
    }

    public final short aEo() {
        return this.lPQ;
    }

    public final a aEq() {
        return this.lPO;
    }

    public final byte[] aEp() {
        try {
            return this.lPN.toByteArray();
        } catch (Throwable e) {
            x.e("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", "mResp.toByteArray() Failed!!! %s", e.getMessage());
            x.printErrStackTrace("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", e, "", new Object[0]);
            return null;
        }
    }
}
