package com.tencent.tinker.a.c;

public final class a implements Cloneable {
    private static final boolean[] Aps = new boolean[0];
    private static final int[] bfR = new int[0];
    private boolean[] Apt;
    private int hX;
    private int[] wA;

    public final /* synthetic */ Object clone() {
        return cHN();
    }

    public a() {
        this((byte) 0);
    }

    private a(byte b) {
        this.wA = new int[10];
        this.Apt = new boolean[10];
        this.hX = 0;
    }

    private static int IR(int i) {
        return i <= 4 ? 8 : (i >> 1) + i;
    }

    private a cHN() {
        try {
            a aVar = (a) super.clone();
            try {
                aVar.wA = (int[]) this.wA.clone();
                aVar.Apt = (boolean[]) this.Apt.clone();
                return aVar;
            } catch (CloneNotSupportedException e) {
                return aVar;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public final void IS(int i) {
        int a = a(this.wA, this.hX, i);
        if (a >= 0) {
            this.Apt[a] = true;
            return;
        }
        int i2 = a ^ -1;
        int[] iArr = this.wA;
        int i3 = this.hX;
        if (i3 > iArr.length) {
            throw new IllegalArgumentException("Bad currentSize, originalSize: " + iArr.length + " currentSize: " + i3);
        }
        Object obj;
        Object iArr2;
        if (i3 + 1 <= iArr2.length) {
            System.arraycopy(iArr2, i2, iArr2, i2 + 1, i3 - i2);
            iArr2[i2] = i;
        } else {
            obj = new int[IR(i3)];
            System.arraycopy(iArr2, 0, obj, 0, i2);
            obj[i2] = i;
            System.arraycopy(iArr2, i2, obj, i2 + 1, iArr2.length - i2);
            iArr2 = obj;
        }
        this.wA = iArr2;
        boolean[] zArr = this.Apt;
        i3 = this.hX;
        if (i3 > zArr.length) {
            throw new IllegalArgumentException("Bad currentSize, originalSize: " + zArr.length + " currentSize: " + i3);
        }
        if (i3 + 1 <= zArr.length) {
            System.arraycopy(zArr, i2, zArr, i2 + 1, i3 - i2);
            zArr[i2] = true;
        } else {
            obj = new boolean[IR(i3)];
            System.arraycopy(zArr, 0, obj, 0, i2);
            obj[i2] = 1;
            System.arraycopy(zArr, i2, obj, i2 + 1, zArr.length - i2);
            iArr2 = obj;
        }
        this.Apt = zArr;
        this.hX++;
    }

    public final boolean IT(int i) {
        return a(this.wA, this.hX, i) >= 0;
    }

    private static int a(int[] iArr, int i, int i2) {
        int i3 = i - 1;
        int i4 = 0;
        while (i4 <= i3) {
            int i5 = (i4 + i3) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i2) {
                i4 = i5 + 1;
            } else if (i6 <= i2) {
                return i5;
            } else {
                i3 = i5 - 1;
            }
        }
        return i4 ^ -1;
    }

    public final String toString() {
        if (this.hX <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.hX * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.hX; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(this.wA[i]);
            stringBuilder.append('=');
            stringBuilder.append(this.Apt[i]);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
