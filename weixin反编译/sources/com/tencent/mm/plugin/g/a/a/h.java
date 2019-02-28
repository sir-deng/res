package com.tencent.mm.plugin.g.a.a;

import com.tencent.mm.plugin.exdevice.j.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Arrays;

public final class h extends j {
    private static final byte[] kCj = new byte[]{(byte) 76, (byte) 0, (byte) 2, (byte) 21};
    private byte[] kCk = null;
    public byte[] kCl = null;
    public short kCm = (short) -1;
    public short kCn = (short) -1;
    public int kCo = 0;

    final boolean ae(byte[] bArr) {
        if (bi.by(bArr)) {
            x.e("MicroMsg.exdevice.IBeaconTLVSectionB", "valueByte is null or nil");
            return false;
        } else if (26 != this.mLength) {
            x.d("MicroMsg.exdevice.IBeaconTLVSectionB", "IBEACON_TLV_SECTION_B_LENGTH != mLength(%d) ", Integer.valueOf(this.mLength));
            return false;
        } else {
            a aVar = new a(bArr.length);
            aVar.K(bArr, bArr.length);
            byte[] bArr2 = new byte[4];
            aVar.J(bArr2, 4);
            if (Arrays.equals(bArr2, kCj)) {
                this.kCk = bArr2;
                this.kCl = new byte[16];
                aVar.J(this.kCl, 16);
                try {
                    this.kCm = aVar.readShort();
                    this.kCn = aVar.readShort();
                    bArr2 = new byte[1];
                    aVar.J(bArr2, 1);
                    this.kCo = bArr2[0];
                    return true;
                } catch (Throwable e) {
                    x.d("MicroMsg.exdevice.IBeaconTLVSectionB", "Read major/minor from autobuffer failed!!!");
                    x.printErrStackTrace("MicroMsg.exdevice.IBeaconTLVSectionB", e, "", new Object[0]);
                    return false;
                }
            }
            x.d("MicroMsg.exdevice.IBeaconTLVSectionB", "Cannot find ibeacon cookies!!!");
            return false;
        }
    }
}
