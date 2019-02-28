package com.google.android.gms.c;

import com.tencent.wcdb.FileUtils;

public final class aw {
    int aZP;
    int aZQ;
    private int aZR;
    int aZS;
    private int aZT;
    private int aZU = Integer.MAX_VALUE;
    private int aZV;
    private int aZW = 64;
    private int aZX = 67108864;
    final byte[] buffer;

    aw(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.aZP = 0;
        this.aZQ = i2 + 0;
        this.aZS = 0;
    }

    private void dA(int i) {
        if (i < 0) {
            throw bd.qn();
        } else if (this.aZS + i > this.aZU) {
            dA(this.aZU - this.aZS);
            throw bd.qm();
        } else if (i <= this.aZQ - this.aZS) {
            this.aZS += i;
        } else {
            throw bd.qm();
        }
    }

    private void qe() {
        this.aZQ += this.aZR;
        int i = this.aZQ;
        if (i > this.aZU) {
            this.aZR = i - this.aZU;
            this.aZQ -= this.aZR;
            return;
        }
        this.aZR = 0;
    }

    private byte qg() {
        if (this.aZS == this.aZQ) {
            throw bd.qm();
        }
        byte[] bArr = this.buffer;
        int i = this.aZS;
        this.aZS = i + 1;
        return bArr[i];
    }

    public final void a(be beVar) {
        int qb = qb();
        if (this.aZV >= this.aZW) {
            throw bd.qs();
        }
        qb = dw(qb);
        this.aZV++;
        beVar.a(this);
        du(0);
        this.aZV--;
        dx(qb);
    }

    public final void du(int i) {
        if (this.aZT != i) {
            throw bd.qq();
        }
    }

    public final boolean dv(int i) {
        switch (bh.dJ(i)) {
            case 0:
                qb();
                return true;
            case 1:
                qd();
                return true;
            case 2:
                dA(qb());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                qc();
                return true;
            default:
                throw bd.qr();
        }
        int pY;
        do {
            pY = pY();
            if (pY != 0) {
            }
            du(bh.az(bh.dK(i), 4));
            return true;
        } while (dv(pY));
        du(bh.az(bh.dK(i), 4));
        return true;
    }

    public final int dw(int i) {
        if (i < 0) {
            throw bd.qn();
        }
        int i2 = this.aZS + i;
        int i3 = this.aZU;
        if (i2 > i3) {
            throw bd.qm();
        }
        this.aZU = i2;
        qe();
        return i3;
    }

    public final void dx(int i) {
        this.aZU = i;
        qe();
    }

    public final void dy(int i) {
        if (i > this.aZS - this.aZP) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.aZS - this.aZP));
        } else if (i < 0) {
            throw new IllegalArgumentException("Bad position " + i);
        } else {
            this.aZS = this.aZP + i;
        }
    }

    public final byte[] dz(int i) {
        if (i < 0) {
            throw bd.qn();
        } else if (this.aZS + i > this.aZU) {
            dA(this.aZU - this.aZS);
            throw bd.qm();
        } else if (i <= this.aZQ - this.aZS) {
            Object obj = new byte[i];
            System.arraycopy(this.buffer, this.aZS, obj, 0, i);
            this.aZS += i;
            return obj;
        } else {
            throw bd.qm();
        }
    }

    public final int getPosition() {
        return this.aZS - this.aZP;
    }

    public final int pY() {
        if ((this.aZS == this.aZQ ? 1 : 0) != 0) {
            this.aZT = 0;
            return 0;
        }
        this.aZT = qb();
        if (this.aZT != 0) {
            return this.aZT;
        }
        throw bd.qp();
    }

    public final long pZ() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte qg = qg();
            j |= ((long) (qg & 127)) << i;
            if ((qg & FileUtils.S_IWUSR) == 0) {
                return j;
            }
        }
        throw bd.qo();
    }

    public final boolean qa() {
        return qb() != 0;
    }

    public final int qb() {
        byte qg = qg();
        if (qg >= (byte) 0) {
            return qg;
        }
        int i = qg & 127;
        byte qg2 = qg();
        if (qg2 >= (byte) 0) {
            return i | (qg2 << 7);
        }
        i |= (qg2 & 127) << 7;
        qg2 = qg();
        if (qg2 >= (byte) 0) {
            return i | (qg2 << 14);
        }
        i |= (qg2 & 127) << 14;
        qg2 = qg();
        if (qg2 >= (byte) 0) {
            return i | (qg2 << 21);
        }
        i |= (qg2 & 127) << 21;
        qg2 = qg();
        i |= qg2 << 28;
        if (qg2 >= (byte) 0) {
            return i;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (qg() >= (byte) 0) {
                return i;
            }
        }
        throw bd.qo();
    }

    public final int qc() {
        return (((qg() & 255) | ((qg() & 255) << 8)) | ((qg() & 255) << 16)) | ((qg() & 255) << 24);
    }

    public final long qd() {
        byte qg = qg();
        byte qg2 = qg();
        return ((((((((((long) qg2) & 255) << 8) | (((long) qg) & 255)) | ((((long) qg()) & 255) << 16)) | ((((long) qg()) & 255) << 24)) | ((((long) qg()) & 255) << 32)) | ((((long) qg()) & 255) << 40)) | ((((long) qg()) & 255) << 48)) | ((((long) qg()) & 255) << 56);
    }

    public final int qf() {
        if (this.aZU == Integer.MAX_VALUE) {
            return -1;
        }
        return this.aZU - this.aZS;
    }

    public final String readString() {
        int qb = qb();
        if (qb > this.aZQ - this.aZS || qb <= 0) {
            return new String(dz(qb), "UTF-8");
        }
        String str = new String(this.buffer, this.aZS, qb, "UTF-8");
        this.aZS = qb + this.aZS;
        return str;
    }
}
