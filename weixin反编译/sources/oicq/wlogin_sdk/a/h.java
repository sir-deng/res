package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.c;
import oicq.wlogin_sdk.tools.d;
import oicq.wlogin_sdk.tools.util;

public final class h extends a {
    int AGx;
    int AGy;
    int AGz;

    public h() {
        this.AGx = 1;
        this.AGy = 1;
        this.AGz = 69;
        this.AFz = 262;
        this.AGy = util.AHv;
        if (util.AHv <= 2) {
            this.AGx = 1;
            this.AGz = 69;
            return;
        }
        this.AGx = 2;
        this.AGz = 90;
    }

    public final byte[] a(long j, int i, long j2, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i2, byte[] bArr5) {
        Object obj;
        int length;
        Object obj2;
        byte[] b;
        if (util.AHv <= 2) {
            obj = new byte[this.AGz];
            util.A(obj, 0, this.AGx);
            util.B(obj, 2, util.cKP());
            util.B(obj, 6, this.AGy);
            util.B(obj, 10, (int) j);
            util.B(obj, 14, i);
            util.c(obj, 18, j2);
            System.arraycopy(bArr, 0, obj, 26, bArr.length);
            length = bArr.length + 26;
            System.arraycopy(bArr2, 0, obj, length, bArr2.length);
            length += bArr2.length;
            util.z(obj, length, 1);
            length++;
            System.arraycopy(bArr3, 0, obj, length, bArr3.length);
            System.arraycopy(bArr4, 0, obj, length + bArr3.length, bArr4.length);
            obj2 = new byte[24];
            System.arraycopy(bArr3, 0, obj2, 0, bArr3.length);
            util.c(obj2, 16, j2);
            b = d.b(obj, obj.length, c.cf(obj2));
            this.AGz = b.length;
            super.JF(this.AFz);
            super.V(b, this.AGz);
            super.cKJ();
            return super.cKF();
        }
        obj = new byte[this.AGz];
        util.A(obj, 0, this.AGx);
        util.B(obj, 2, util.cKP());
        util.B(obj, 6, this.AGy);
        util.B(obj, 10, (int) j);
        util.B(obj, 14, i);
        util.c(obj, 18, j2);
        System.arraycopy(bArr, 0, obj, 26, bArr.length);
        length = bArr.length + 26;
        System.arraycopy(bArr2, 0, obj, length, bArr2.length);
        length += bArr2.length;
        util.z(obj, length, 1);
        length++;
        System.arraycopy(bArr3, 0, obj, length, bArr3.length);
        length += bArr3.length;
        System.arraycopy(bArr4, 0, obj, length, bArr4.length);
        length += bArr4.length;
        util.B(obj, length, 0);
        length += 4;
        util.z(obj, length, i2);
        length++;
        if (bArr5 == null || bArr5.length <= 0) {
            byte[] bArr6 = new byte[16];
            util.B(bArr6, 0, util.cKP());
            util.B(bArr6, 4, util.cKP());
            util.B(bArr6, 8, util.cKP());
            util.B(bArr6, 12, util.cKP());
        } else {
            System.arraycopy(bArr5, 0, obj, length, bArr5.length);
        }
        obj2 = new byte[24];
        System.arraycopy(bArr3, 0, obj2, 0, bArr3.length);
        util.c(obj2, 16, j2);
        b = d.b(obj, obj.length, c.cf(obj2));
        this.AGz = b.length;
        super.JF(this.AFz);
        super.V(b, this.AGz);
        super.cKJ();
        return cKF();
    }
}
