package com.tencent.mm.plugin.g.a.b.a;

import com.tencent.mm.plugin.g.a.b.h;

public class e extends a {
    static final String TAG = e.class.getName();
    public static final String kEU = h.kDM;
    public static final String kEV = h.kDN;
    public static final String kEW = h.kDO;
    public static final String kEX = h.kDP;
    public byte kEY;
    public byte kEZ;
    public byte kFa;
    public byte kFb;
    public byte[] kFc;
    public int kFd;
    public byte kFe;
    public byte kFf;
    public byte[] kFg;

    public e() {
        this.kEc = null;
        this.kEd = 8;
        this.kDv = 16;
        this.kEY = (byte) 0;
        this.kEZ = (byte) 0;
        this.kFa = (byte) 0;
        this.kFb = (byte) 0;
        this.kFc = new byte[]{(byte) 0, (byte) 0};
        this.kFd = -1;
        this.kFe = (byte) 0;
        this.kFf = (byte) 0;
        this.kFg = null;
    }

    public final byte[] arZ() {
        byte[] bArr;
        if (this.kEc.equalsIgnoreCase(kEU)) {
            Object obj = new byte[3];
            System.arraycopy(Byte.valueOf(this.kEY), 0, obj, 0, 1);
            System.arraycopy(Byte.valueOf(this.kEZ), 0, obj, 1, 1);
            System.arraycopy(Byte.valueOf(this.kFa), 0, obj, 2, 1);
            return obj;
        } else if (this.kEc.equalsIgnoreCase(kEV)) {
            bArr = new byte[1];
            System.arraycopy(Byte.valueOf(this.kFb), 0, bArr, 0, 1);
            return bArr;
        } else if (!this.kEc.equalsIgnoreCase(kEX)) {
            return null;
        } else {
            bArr = new byte[this.kFd];
            byte b = (byte) ((this.kFd >> 8) & 255);
            System.arraycopy(Byte.valueOf((byte) (this.kFd & 255)), 0, bArr, 0, 1);
            System.arraycopy(Byte.valueOf(b), 0, bArr, 1, 1);
            System.arraycopy(Byte.valueOf(this.kFe), 0, bArr, 2, 1);
            if (this.kFd <= 3) {
                return bArr;
            }
            System.arraycopy(this.kFg, 0, bArr, 3, this.kFd - 3);
            return bArr;
        }
    }
}
