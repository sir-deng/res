package com.tencent.mm.modelcontrol;

public final class f implements Comparable {
    public int hvT;
    public int hvU;
    public int hvV;
    public int hvW;
    public int hvX;
    public int hvY;
    public int hvZ;

    public f(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.hvT = i;
        this.hvU = i2;
        this.hvV = i3;
        this.hvW = i4;
        this.hvX = i5;
        this.hvY = i6;
        this.hvZ = i7;
    }

    public final int compareTo(Object obj) {
        if (obj == null || !(obj instanceof f)) {
            return 0;
        }
        return this.hvT - ((f) obj).hvT;
    }
}
