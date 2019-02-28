package e.a.a.b.a;

import com.tencent.wcdb.FileUtils;
import java.io.InputStream;
import java.util.LinkedList;

public final class a {
    private InputStream AEU;
    private int AEV = 0;
    private int bfI = 0;
    public int bfJ;
    public int bfK = 0;
    private int bfL = Integer.MAX_VALUE;
    private int bfO = 67108864;
    public byte[] buffer;
    public int bufferSize;

    public final double readDouble() {
        byte rD = rD();
        byte rD2 = rD();
        return Double.longBitsToDouble(((((((((((long) rD2) & 255) << 8) | (((long) rD) & 255)) | ((((long) rD()) & 255) << 16)) | ((((long) rD()) & 255) << 24)) | ((((long) rD()) & 255) << 32)) | ((((long) rD()) & 255) << 40)) | ((((long) rD()) & 255) << 48)) | ((((long) rD()) & 255) << 56));
    }

    public final float readFloat() {
        return Float.intBitsToFloat((((rD() & 255) | ((rD() & 255) << 8)) | ((rD() & 255) << 16)) | ((rD() & 255) << 24));
    }

    public final LinkedList<byte[]> JD(int i) {
        LinkedList<byte[]> linkedList = new LinkedList();
        int rz = rz();
        try {
            Object obj = new byte[rz];
            System.arraycopy(this.buffer, this.bfJ, obj, 0, rz);
            linkedList.add(obj);
            this.bfJ = rz + this.bfJ;
            rz = this.bfJ;
            if (this.bfJ == this.bufferSize) {
                return linkedList;
            }
            int[] JE = JE(rz);
            rz = JE[0];
            while (e.a.a.b.a.eb(rz) == i) {
                this.bfJ = JE[1];
                rz = rz();
                obj = new byte[rz];
                System.arraycopy(this.buffer, this.bfJ, obj, 0, rz);
                linkedList.add(obj);
                this.bfJ = rz + this.bfJ;
                if (this.bfJ == this.bufferSize) {
                    break;
                }
                JE = JE(this.bfJ);
                rz = JE[0];
            }
            return linkedList;
        } catch (OutOfMemoryError e) {
            throw new OutOfMemoryError("alloc bytes:" + rz);
        }
    }

    public final String readString() {
        int rz = rz();
        if (rz >= this.bufferSize - this.bfJ || rz <= 0) {
            return new String(dT(rz), "UTF-8");
        }
        String str = new String(this.buffer, this.bfJ, rz, "UTF-8");
        this.bfJ = rz + this.bfJ;
        return str;
    }

    private int[] JE(int i) {
        byte b = this.buffer[i];
        int i2 = i + 1;
        if (b >= (byte) 0) {
            return new int[]{b, i2};
        }
        int i3;
        int i4 = b & 127;
        byte b2 = this.buffer[i2];
        if (b2 >= (byte) 0) {
            i3 = i2 + 1;
            i4 |= b2 << 7;
        } else {
            i4 |= (b2 & 127) << 7;
            b2 = this.buffer[i2];
            if (b2 >= (byte) 0) {
                i3 = i2 + 1;
                i4 |= b2 << 14;
            } else {
                i4 |= (b2 & 127) << 14;
                b2 = this.buffer[i2];
                if (b2 >= (byte) 0) {
                    i3 = i2 + 1;
                    i4 |= b2 << 21;
                } else {
                    i4 |= (b2 & 127) << 21;
                    b2 = this.buffer[i2];
                    i4 |= b2 << 28;
                    i3 = i2 + 1;
                    if (b2 < (byte) 0) {
                        for (i4 = 0; i4 < 5; i4++) {
                            if (this.buffer[i3] >= (byte) 0) {
                                i3++;
                                return new int[]{b2, i3};
                            }
                        }
                        throw b.cKA();
                    }
                }
            }
        }
        return new int[]{i4, i3};
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
        throw b.cKA();
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
        throw b.cKA();
    }

    public a(byte[] bArr, int i) {
        this.buffer = bArr;
        this.bufferSize = i + 0;
        this.bfJ = 0;
        this.AEU = null;
    }

    public final boolean on(boolean z) {
        if (this.bfJ < this.bufferSize) {
            throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
        } else if (this.AEV + this.bufferSize != this.bfL) {
            this.AEV += this.bufferSize;
            this.bfJ = 0;
            this.bufferSize = this.AEU == null ? -1 : this.AEU.read(this.buffer);
            if (this.bufferSize == -1) {
                this.bufferSize = 0;
                if (!z) {
                    return false;
                }
                throw b.cKy();
            }
            this.bufferSize += this.bfI;
            int i = this.AEV + this.bufferSize;
            if (i > this.bfL) {
                this.bfI = i - this.bfL;
                this.bufferSize -= this.bfI;
            } else {
                this.bfI = 0;
            }
            i = (this.AEV + this.bufferSize) + this.bfI;
            if (i <= this.bfO && i >= 0) {
                return true;
            }
            throw b.cKC();
        } else if (!z) {
            return false;
        } else {
            throw b.cKy();
        }
    }

    private byte rD() {
        if (this.bfJ == this.bufferSize) {
            on(true);
        }
        byte[] bArr = this.buffer;
        int i = this.bfJ;
        this.bfJ = i + 1;
        return bArr[i];
    }

    public final byte[] dT(int i) {
        int i2;
        if (i < 0) {
            throw b.cKz();
        } else if ((this.AEV + this.bfJ) + i > this.bfL) {
            dU((this.bfL - this.AEV) - this.bfJ);
            throw b.cKy();
        } else if (i <= this.bufferSize - this.bfJ) {
            Object obj = new byte[i];
            System.arraycopy(this.buffer, this.bfJ, obj, 0, i);
            this.bfJ += i;
            return obj;
        } else if (i < 2048) {
            Object obj2 = new byte[i];
            i2 = this.bufferSize - this.bfJ;
            System.arraycopy(this.buffer, this.bfJ, obj2, 0, i2);
            this.bfJ = this.bufferSize;
            on(true);
            while (i - i2 > this.bufferSize) {
                System.arraycopy(this.buffer, 0, obj2, i2, this.bufferSize);
                i2 += this.bufferSize;
                this.bfJ = this.bufferSize;
                on(true);
            }
            System.arraycopy(this.buffer, 0, obj2, i2, i - i2);
            this.bfJ = i - i2;
            return obj2;
        } else {
            int read;
            int i3 = this.bfJ;
            int i4 = this.bufferSize;
            this.AEV += this.bufferSize;
            this.bfJ = 0;
            this.bufferSize = 0;
            i2 = i - (i4 - i3);
            LinkedList linkedList = new LinkedList();
            int i5 = i2;
            while (i5 > 0) {
                Object obj3 = new byte[Math.min(i5, 2048)];
                i2 = 0;
                while (i2 < obj3.length) {
                    read = this.AEU == null ? -1 : this.AEU.read(obj3, i2, obj3.length - i2);
                    if (read == -1) {
                        throw b.cKy();
                    }
                    this.AEV += read;
                    i2 += read;
                }
                i2 = i5 - obj3.length;
                linkedList.add(obj3);
                i5 = i2;
            }
            Object obj4 = new byte[i];
            i2 = i4 - i3;
            System.arraycopy(this.buffer, i3, obj4, 0, i2);
            read = 0;
            while (true) {
                int i6 = i2;
                if (read >= linkedList.size()) {
                    return obj4;
                }
                byte[] bArr = (byte[]) linkedList.get(read);
                System.arraycopy(bArr, 0, obj4, i6, bArr.length);
                i6 += bArr.length;
                i2 = read + 1;
            }
        }
    }

    private void dU(int i) {
        if (i < 0) {
            throw b.cKz();
        } else if ((this.AEV + this.bfJ) + i > this.bfL) {
            dU((this.bfL - this.AEV) - this.bfJ);
            throw b.cKy();
        } else if (i < this.bufferSize - this.bfJ) {
            this.bfJ += i;
        } else {
            int i2 = this.bufferSize - this.bfJ;
            this.AEV += i2;
            this.bfJ = 0;
            this.bufferSize = 0;
            int i3 = i2;
            while (i3 < i) {
                i2 = this.AEU == null ? -1 : (int) this.AEU.skip((long) (i - i3));
                if (i2 <= 0) {
                    throw b.cKy();
                }
                i3 += i2;
                this.AEV = i2 + this.AEV;
            }
        }
    }
}
