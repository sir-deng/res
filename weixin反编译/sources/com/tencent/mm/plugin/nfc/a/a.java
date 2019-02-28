package com.tencent.mm.plugin.nfc.a;

import java.io.Serializable;
import java.util.Arrays;

public final class a implements Serializable {
    private byte[] oXm;
    private transient int oXn;
    private transient int oXo;
    private transient int oXp;

    public a(byte[] bArr) {
        this.oXm = (byte[]) bArr.clone();
        bfY();
    }

    public a(String str) {
        this.oXm = com.tencent.mm.plugin.nfc.d.a.hexStringToByteArray(str);
        bfY();
    }

    private void bfY() {
        int i = 65536;
        int i2 = 256;
        if (this.oXm.length < 4) {
            throw new IllegalArgumentException("apdu must be at least 4 bytes long");
        } else if (this.oXm.length != 4) {
            int i3 = this.oXm[4] & 255;
            if (this.oXm.length == 5) {
                if (i3 != 0) {
                    i2 = i3;
                }
                this.oXo = i2;
            } else if (i3 != 0) {
                if (this.oXm.length == i3 + 5) {
                    this.oXn = i3;
                    this.oXp = 5;
                } else if (this.oXm.length == i3 + 6) {
                    this.oXn = i3;
                    this.oXp = 5;
                    i3 = this.oXm[this.oXm.length - 1] & 255;
                    if (i3 != 0) {
                        i2 = i3;
                    }
                    this.oXo = i2;
                } else {
                    throw new IllegalArgumentException("Invalid APDU: length=" + this.oXm.length + ", b1=" + i3);
                }
            } else if (this.oXm.length < 7) {
                throw new IllegalArgumentException("Invalid APDU: length=" + this.oXm.length + ", b1=" + i3);
            } else {
                i2 = ((this.oXm[5] & 255) << 8) | (this.oXm[6] & 255);
                if (this.oXm.length == 7) {
                    if (i2 == 0) {
                        i2 = 65536;
                    }
                    this.oXo = i2;
                } else if (i2 == 0) {
                    throw new IllegalArgumentException("Invalid APDU: length=" + this.oXm.length + ", b1=" + i3 + ", b2||b3=" + i2);
                } else if (this.oXm.length == i2 + 7) {
                    this.oXn = i2;
                    this.oXp = 7;
                } else if (this.oXm.length == i2 + 9) {
                    this.oXn = i2;
                    this.oXp = 7;
                    i2 = this.oXm.length - 2;
                    i2 = (this.oXm[i2 + 1] & 255) | ((this.oXm[i2] & 255) << 8);
                    if (i2 != 0) {
                        i = i2;
                    }
                    this.oXo = i;
                } else {
                    throw new IllegalArgumentException("Invalid APDU: length=" + this.oXm.length + ", b1=" + i3 + ", b2||b3=" + i2);
                }
            }
        }
    }

    public final void un(int i) {
        this.oXo = i;
        this.oXm[this.oXm.length - 1] = (byte) i;
    }

    public final byte[] getBytes() {
        return (byte[]) this.oXm.clone();
    }

    public final String toString() {
        return com.tencent.mm.plugin.nfc.d.a.byteArrayToHexString(this.oXm);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        return Arrays.equals(this.oXm, ((a) obj).oXm);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.oXm);
    }
}
