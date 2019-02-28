package com.google.a.a;

import com.tencent.wcdb.FileUtils;

public final class a {
    private int bfH;
    private int bfI;
    private int bfJ;
    private int bfK;
    private int bfL = Integer.MAX_VALUE;
    private int bfM;
    private int bfN = 64;
    private int bfO = 67108864;
    private final byte[] buffer;
    private int bufferSize;

    public final int ry() {
        if ((this.bfJ == this.bufferSize ? 1 : 0) != 0) {
            this.bfK = 0;
            return 0;
        }
        this.bfK = rz();
        if (this.bfK != 0) {
            return this.bfK;
        }
        throw d.rH();
    }

    public final void dO(int i) {
        if (this.bfK != i) {
            throw d.rI();
        }
    }

    public final boolean dP(int i) {
        switch (g.ea(i)) {
            case 0:
                rz();
                return true;
            case 1:
                rD();
                rD();
                rD();
                rD();
                rD();
                rD();
                rD();
                rD();
                return true;
            case 2:
                dU(rz());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                rD();
                rD();
                rD();
                rD();
                return true;
            default:
                throw d.rJ();
        }
        int ry;
        do {
            ry = ry();
            if (ry != 0) {
            }
            dO(g.aG(g.eb(i), 4));
            return true;
        } while (dP(ry));
        dO(g.aG(g.eb(i), 4));
        return true;
    }

    public final String readString() {
        int rz = rz();
        if (rz > this.bufferSize - this.bfJ || rz <= 0) {
            return new String(dT(rz), "UTF-8");
        }
        String str = new String(this.buffer, this.bfJ, rz, "UTF-8");
        this.bfJ = rz + this.bfJ;
        return str;
    }

    public final void a(e eVar) {
        int rz = rz();
        if (this.bfM >= this.bfN) {
            throw d.rK();
        }
        rz = dQ(rz);
        this.bfM++;
        eVar.a(this);
        dO(0);
        this.bfM--;
        dR(rz);
    }

    public final byte[] readBytes() {
        int rz = rz();
        if (rz > this.bufferSize - this.bfJ || rz <= 0) {
            return dT(rz);
        }
        Object obj = new byte[rz];
        System.arraycopy(this.buffer, this.bfJ, obj, 0, rz);
        this.bfJ = rz + this.bfJ;
        return obj;
    }

    public final int rz() {
        byte rD = rD();
        if (rD >= (byte) 0) {
            return rD;
        }
        int i = rD & 127;
        byte rD2 = rD();
        if (rD2 >= (byte) 0) {
            return i | (rD2 << 7);
        }
        i |= (rD2 & 127) << 7;
        rD2 = rD();
        if (rD2 >= (byte) 0) {
            return i | (rD2 << 14);
        }
        i |= (rD2 & 127) << 14;
        rD2 = rD();
        if (rD2 >= (byte) 0) {
            return i | (rD2 << 21);
        }
        i |= (rD2 & 127) << 21;
        rD2 = rD();
        i |= rD2 << 28;
        if (rD2 >= (byte) 0) {
            return i;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (rD() >= (byte) 0) {
                return i;
            }
        }
        throw d.rG();
    }

    public final long rA() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte rD = rD();
            j |= ((long) (rD & 127)) << i;
            if ((rD & FileUtils.S_IWUSR) == 0) {
                return j;
            }
        }
        throw d.rG();
    }

    a(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.bfH = 0;
        this.bufferSize = i2 + 0;
        this.bfJ = 0;
    }

    public final int dQ(int i) {
        if (i < 0) {
            throw d.rF();
        }
        int i2 = this.bfJ + i;
        int i3 = this.bfL;
        if (i2 > i3) {
            throw d.rE();
        }
        this.bfL = i2;
        rB();
        return i3;
    }

    private void rB() {
        this.bufferSize += this.bfI;
        int i = this.bufferSize;
        if (i > this.bfL) {
            this.bfI = i - this.bfL;
            this.bufferSize -= this.bfI;
            return;
        }
        this.bfI = 0;
    }

    public final void dR(int i) {
        this.bfL = i;
        rB();
    }

    public final int rC() {
        if (this.bfL == Integer.MAX_VALUE) {
            return -1;
        }
        return this.bfL - this.bfJ;
    }

    public final int getPosition() {
        return this.bfJ - this.bfH;
    }

    public final void dS(int i) {
        if (i > this.bfJ - this.bfH) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.bfJ - this.bfH));
        } else if (i < 0) {
            throw new IllegalArgumentException("Bad position " + i);
        } else {
            this.bfJ = this.bfH + i;
        }
    }

    private byte rD() {
        if (this.bfJ == this.bufferSize) {
            throw d.rE();
        }
        byte[] bArr = this.buffer;
        int i = this.bfJ;
        this.bfJ = i + 1;
        return bArr[i];
    }

    private byte[] dT(int i) {
        if (i < 0) {
            throw d.rF();
        } else if (this.bfJ + i > this.bfL) {
            dU(this.bfL - this.bfJ);
            throw d.rE();
        } else if (i <= this.bufferSize - this.bfJ) {
            Object obj = new byte[i];
            System.arraycopy(this.buffer, this.bfJ, obj, 0, i);
            this.bfJ += i;
            return obj;
        } else {
            throw d.rE();
        }
    }

    private void dU(int i) {
        if (i < 0) {
            throw d.rF();
        } else if (this.bfJ + i > this.bfL) {
            dU(this.bfL - this.bfJ);
            throw d.rE();
        } else if (i <= this.bufferSize - this.bfJ) {
            this.bfJ += i;
        } else {
            throw d.rE();
        }
    }
}
