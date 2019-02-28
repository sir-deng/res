package oicq.wlogin_sdk.a;

import com.tencent.wcdb.FileUtils;
import oicq.wlogin_sdk.tools.d;
import oicq.wlogin_sdk.tools.util;

public class a {
    public int AFn = FileUtils.S_IWUSR;
    public int AFo = 0;
    public byte[] AFt = new byte[this.AFn];
    public int AFz = 0;
    int AGh = 0;
    public int AGi = 4;
    public int AGj = 0;

    public final byte[] cKF() {
        Object obj = new byte[this.AFo];
        System.arraycopy(this.AFt, 0, obj, 0, this.AFo);
        return obj;
    }

    public final byte[] cKI() {
        Object obj = new byte[this.AGj];
        System.arraycopy(this.AFt, this.AGi, obj, 0, this.AGj);
        return obj;
    }

    public final void JF(int i) {
        util.A(this.AFt, this.AFo, i);
        this.AFo += 2;
        util.A(this.AFt, this.AFo, 0);
        this.AFo += 2;
    }

    public final void cKJ() {
        util.A(this.AFt, 2, this.AFo - this.AGi);
    }

    public final void V(byte[] bArr, int i) {
        if (i > this.AFn - this.AGi) {
            this.AFn = (this.AGi + i) + 64;
            Object obj = new byte[this.AFn];
            System.arraycopy(this.AFt, 0, obj, 0, this.AFo);
            this.AFt = obj;
        }
        this.AGj = i;
        System.arraycopy(bArr, 0, this.AFt, this.AFo, i);
        this.AFo += i;
    }

    private static int x(byte[] bArr, int i, int i2) {
        int length = bArr.length;
        int i3 = i;
        while (i3 < length && i3 + 2 <= length) {
            if (util.Y(bArr, i3) != i2) {
                i3 += 2;
                if (i3 + 2 > length) {
                    break;
                }
                i3 += util.Y(bArr, i3) + 2;
            } else {
                return i3;
            }
        }
        return -1;
    }

    public final int y(byte[] bArr, int i, int i2) {
        int x = x(bArr, i, this.AFz);
        if (x < 0) {
            return -1;
        }
        int i3 = i2 - (x - i);
        if (this.AGi >= i3) {
            return -1;
        }
        this.AGj = util.Y(bArr, x + 2);
        if (this.AGi + this.AGj > i3) {
            return -1;
        }
        int i4 = this.AGi + this.AGj;
        if (i4 > this.AFn) {
            this.AFn = i4 + FileUtils.S_IWUSR;
            this.AFt = new byte[this.AFn];
        }
        this.AFo = i4;
        System.arraycopy(bArr, x, this.AFt, 0, i4);
        this.AFz = util.Y(bArr, x);
        this.AGj = i4 - this.AGi;
        if (cKK().booleanValue()) {
            return (this.AGi + x) + this.AGj;
        }
        return -1005;
    }

    public final int b(byte[] bArr, int i, int i2, byte[] bArr2) {
        int x = x(bArr, i, this.AFz);
        if (x < 0) {
            return -1;
        }
        int i3 = i2 - (x - i);
        Object obj = new byte[i3];
        System.arraycopy(bArr, x, obj, 0, i3);
        if (this.AGi >= i3) {
            return -1;
        }
        this.AGj = util.Y(obj, 2);
        if (this.AGi + this.AGj > i3) {
            return -1;
        }
        Object decrypt = d.decrypt(obj, this.AGi, this.AGj, bArr2);
        if (decrypt == null) {
            return -1015;
        }
        if (this.AGi + decrypt.length > this.AFn) {
            this.AFn = this.AGi + decrypt.length;
            this.AFt = new byte[this.AFn];
        }
        this.AFo = 0;
        System.arraycopy(obj, 0, this.AFt, 0, this.AGi);
        this.AFo += this.AGi;
        System.arraycopy(decrypt, 0, this.AFt, this.AFo, decrypt.length);
        this.AFo += decrypt.length;
        this.AGj = decrypt.length;
        return !cKK().booleanValue() ? -1005 : 0;
    }

    public Boolean cKK() {
        return Boolean.valueOf(true);
    }
}
