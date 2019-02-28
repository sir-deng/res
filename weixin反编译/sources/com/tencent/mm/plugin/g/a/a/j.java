package com.tencent.mm.plugin.g.a.a;

import com.tencent.mm.plugin.exdevice.j.a;
import com.tencent.mm.sdk.platformtools.x;

public abstract class j {
    protected byte kCp = (byte) 0;
    protected byte[] kCq = null;
    protected int mLength = -1;

    abstract boolean ae(byte[] bArr);

    public final boolean a(a aVar) {
        if (aVar.getSize() == 0) {
            x.w("MicroMsg.exdevice.TLVBase", "autoBuffer is null or nil");
            return false;
        }
        byte[] bArr = new byte[1];
        aVar.J(bArr, 1);
        byte b = bArr[0];
        if (b + 1 > aVar.getSize()) {
            x.w("MicroMsg.exdevice.TLVBase", "lengthInt(%d) + 1 > autoBuffer.getSize()(%d)", Integer.valueOf(b), Integer.valueOf(aVar.getSize()));
            return false;
        } else if (b <= (byte) 1) {
            x.w("MicroMsg.exdevice.TLVBase", "length(%d) <= 1", Integer.valueOf(b));
            return false;
        } else {
            this.mLength = b;
            aVar.J(bArr, 1);
            this.kCp = bArr[0];
            this.kCq = new byte[(this.mLength - 1)];
            aVar.J(this.kCq, this.kCq.length);
            return ae(this.kCq);
        }
    }
}
