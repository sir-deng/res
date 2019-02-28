package com.tencent.mm.plugin.fps_lighter.c;

public final class a {
    public long mGZ;
    public long mHa;
    public boolean mHb;
    public int mHc;
    public int mHd;
    public int mHe = 1;
    public long mHf;
    public boolean mHg;
    public int scene;

    public final long aLw() {
        return this.mGZ - this.mHa;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(16);
        stringBuilder.append("\t");
        stringBuilder.append(this.scene);
        stringBuilder.append(" ");
        stringBuilder.append(this.mHa);
        stringBuilder.append(" ");
        stringBuilder.append(this.mGZ);
        stringBuilder.append(" ");
        stringBuilder.append(this.mHb);
        stringBuilder.append(" ");
        stringBuilder.append(this.mHc);
        stringBuilder.append(" ");
        stringBuilder.append(this.mHd);
        stringBuilder.append(" ");
        stringBuilder.append(this.mHe);
        stringBuilder.append(" ");
        stringBuilder.append(this.mHf);
        stringBuilder.append(" ");
        stringBuilder.append(this.mHg);
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
