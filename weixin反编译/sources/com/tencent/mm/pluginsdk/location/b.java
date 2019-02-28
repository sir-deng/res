package com.tencent.mm.pluginsdk.location;

public final class b {
    public int fAq;
    public float hzq;
    public float hzr;
    public int scene;
    public long vjD;

    public b(long j, float f, float f2, int i, int i2) {
        this.hzq = f;
        this.hzr = f2;
        this.fAq = i;
        this.scene = i2;
        this.vjD = j;
    }

    public final String toString() {
        return String.format("%d-%d-%d", new Object[]{Integer.valueOf((int) (this.hzq * 1000000.0f)), Integer.valueOf((int) (this.hzr * 1000000.0f)), Integer.valueOf(this.fAq)});
    }
}
