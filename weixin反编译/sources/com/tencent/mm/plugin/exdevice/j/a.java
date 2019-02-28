package com.tencent.mm.plugin.exdevice.j;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.nio.ByteBuffer;
import junit.framework.Assert;

public final class a {
    private final int meZ = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
    private ByteBuffer mfa;
    private ByteBuffer mfb;

    public a(int i) {
        boolean z;
        boolean z2 = true;
        x.d("MicroMsg.exdevice.AutoBuffer", "******AutoBuffer****** capacity = " + i);
        Assert.assertTrue(i >= 0);
        this.mfb = ByteBuffer.allocate(i);
        this.mfa = this.mfb.asReadOnlyBuffer();
        if (this.mfb != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (this.mfa == null) {
            z2 = false;
        }
        Assert.assertTrue(z2);
    }

    public final int getSize() {
        x.d("MicroMsg.exdevice.AutoBuffer", "size = " + this.mfb.position());
        return this.mfb.position();
    }

    public final short readShort() {
        if (getSize() <= 1) {
            throw new IOException("There is only one byte in array");
        }
        short s = this.mfa.getShort();
        x.d("MicroMsg.exdevice.AutoBuffer", "getShort = " + s);
        return s;
    }

    public final void J(byte[] bArr, int i) {
        boolean z;
        boolean z2 = true;
        Assert.assertTrue(true);
        Assert.assertTrue(i >= 0);
        if (bArr.length >= 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (bArr.length >= i + 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (this.mfa.remaining() < i) {
            z2 = false;
        }
        Assert.assertTrue(z2);
        x.d("MicroMsg.exdevice.AutoBuffer", "readByte dstOffset = 0" + " byteCount = " + i);
        this.mfa.get(bArr, 0, i);
    }

    public final void K(byte[] bArr, int i) {
        boolean z = true;
        Assert.assertTrue(true);
        Assert.assertTrue(i >= 0);
        if (bArr == null) {
            z = false;
        }
        Assert.assertTrue(z);
        x.d("MicroMsg.exdevice.AutoBuffer", "writeByte srcOffset = 0" + " byteCount = " + i);
        if (i > this.mfb.remaining()) {
            x.d("MicroMsg.exdevice.AutoBuffer", "byteCount > mWriteStream.remaining() Recalloc");
            x.d("MicroMsg.exdevice.AutoBuffer", "getCapacity = " + this.mfb.capacity());
            ByteBuffer allocate = ByteBuffer.allocate((this.mfb.capacity() + i) + WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            int position = this.mfa.position();
            allocate.put(this.mfb.array());
            allocate.put(bArr, 0, i);
            this.mfb = allocate;
            this.mfa = allocate.asReadOnlyBuffer();
            this.mfa.position(position);
            return;
        }
        this.mfb.put(bArr, 0, i);
    }
}
