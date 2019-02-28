package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.a;

public final class m {
    protected final a Aor;
    public int Aos;
    private int Aot;
    private int type;

    public m(a aVar, int i) {
        this.type = -1;
        this.Aor = aVar;
        this.type = i;
    }

    public m(k kVar, int i) {
        this(new a() {
            private int position = 0;

            public final byte readByte() {
                byte[] bArr = k.this.data;
                int i = this.position;
                this.position = i + 1;
                return bArr[i];
            }
        }, i);
    }

    public final int cHx() {
        if (this.type == -1) {
            int readByte = this.Aor.readByte() & 255;
            this.type = readByte & 31;
            this.Aot = (readByte & 224) >> 5;
        }
        return this.type;
    }

    public final int cHy() {
        Ix(28);
        this.type = -1;
        return o.b(this.Aor);
    }

    public final int cHz() {
        Ix(29);
        this.type = -1;
        this.Aos = o.b(this.Aor);
        return o.b(this.Aor);
    }

    public final int cHA() {
        return o.b(this.Aor);
    }

    public final byte readByte() {
        Ix(0);
        this.type = -1;
        return (byte) l.a(this.Aor, this.Aot);
    }

    public final short readShort() {
        Ix(2);
        this.type = -1;
        return (short) l.a(this.Aor, this.Aot);
    }

    public final char readChar() {
        Ix(3);
        this.type = -1;
        return (char) l.a(this.Aor, this.Aot, false);
    }

    public final int readInt() {
        Ix(4);
        this.type = -1;
        return l.a(this.Aor, this.Aot);
    }

    public final long readLong() {
        Ix(6);
        this.type = -1;
        a aVar = this.Aor;
        int i = this.Aot;
        long j = 0;
        for (int i2 = i; i2 >= 0; i2--) {
            j = (j >>> 8) | ((((long) aVar.readByte()) & 255) << 56);
        }
        return j >> ((7 - i) * 8);
    }

    public final float readFloat() {
        Ix(16);
        this.type = -1;
        return Float.intBitsToFloat(l.a(this.Aor, this.Aot, true));
    }

    public final double readDouble() {
        Ix(17);
        this.type = -1;
        a aVar = this.Aor;
        long j = 0;
        for (int i = this.Aot; i >= 0; i--) {
            j = (j >>> 8) | ((((long) aVar.readByte()) & 255) << 56);
        }
        return Double.longBitsToDouble(j);
    }

    public final int cHB() {
        Ix(23);
        this.type = -1;
        return l.a(this.Aor, this.Aot, false);
    }

    public final int cHC() {
        Ix(24);
        this.type = -1;
        return l.a(this.Aor, this.Aot, false);
    }

    public final int cHD() {
        Ix(25);
        this.type = -1;
        return l.a(this.Aor, this.Aot, false);
    }

    public final int cHE() {
        Ix(27);
        this.type = -1;
        return l.a(this.Aor, this.Aot, false);
    }

    public final int cHF() {
        Ix(26);
        this.type = -1;
        return l.a(this.Aor, this.Aot, false);
    }

    public final void cHG() {
        Ix(30);
        this.type = -1;
    }

    public final boolean readBoolean() {
        Ix(31);
        this.type = -1;
        return this.Aot != 0;
    }

    public final void skipValue() {
        int i = 0;
        int cHy;
        switch (cHx()) {
            case 0:
                readByte();
                return;
            case 2:
                readShort();
                return;
            case 3:
                readChar();
                return;
            case 4:
                readInt();
                return;
            case 6:
                readLong();
                return;
            case 16:
                readFloat();
                return;
            case 17:
                readDouble();
                return;
            case 23:
                cHB();
                return;
            case 24:
                cHC();
                return;
            case 25:
                cHD();
                return;
            case 26:
                cHF();
                return;
            case 27:
                cHE();
                return;
            case 28:
                cHy = cHy();
                while (i < cHy) {
                    skipValue();
                    i++;
                }
                return;
            case 29:
                cHy = cHz();
                while (i < cHy) {
                    o.b(this.Aor);
                    skipValue();
                    i++;
                }
                return;
            case 30:
                cHG();
                return;
            case 31:
                readBoolean();
                return;
            default:
                throw new j("Unexpected type: " + Integer.toHexString(this.type));
        }
    }

    private void Ix(int i) {
        if (cHx() != i) {
            throw new IllegalStateException(String.format("Expected %x but was %x", new Object[]{Integer.valueOf(i), Integer.valueOf(cHx())}));
        }
    }
}
