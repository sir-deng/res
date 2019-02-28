package com.tencent.mm.plugin.nfc.a;

import com.tencent.mm.plugin.nfc.d.a;
import java.io.Serializable;
import java.util.Arrays;

public final class c implements Serializable {
    public byte[] oXm;

    public c(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("apdu is null");
        }
        byte[] bArr2 = (byte[]) bArr.clone();
        if (bArr2.length < 2) {
            throw new IllegalArgumentException("apdu must be at least 2 bytes long");
        }
        this.oXm = bArr2;
    }

    public final short bfZ() {
        return (short) (this.oXm[this.oXm.length - 2] & 255);
    }

    public final short bga() {
        return (short) (this.oXm[this.oXm.length - 1] & 255);
    }

    public final String toString() {
        return a.byteArrayToHexString(this.oXm);
    }

    public final void a(c cVar) {
        int length = this.oXm.length;
        this.oXm = Arrays.copyOf(this.oXm, (this.oXm.length + cVar.oXm.length) - 2);
        int i = length - 2;
        byte[] bArr = (byte[]) cVar.oXm.clone();
        int length2 = bArr.length;
        int i2 = 0;
        while (i2 < length2) {
            int i3 = i + 1;
            this.oXm[i] = bArr[i2];
            i2++;
            i = i3;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        return Arrays.equals(this.oXm, ((c) obj).oXm);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.oXm);
    }
}
