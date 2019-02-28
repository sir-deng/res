package com.tencent.mm.plugin.fps_lighter.c;

import java.util.ArrayList;
import java.util.List;

public final class c {
    public int axZ;
    public int hUW;
    public long mHh;
    public long mHi;
    public List<String> mHm = new ArrayList();
    public List<String> mHn = new ArrayList();
    public long mHo;

    public c(b bVar) {
        this.mHh = bVar.mHh;
        this.mHi = bVar.mHi;
        this.mHm.add(bVar.jNF);
        this.mHo = bVar.jNF;
        this.mHn.add(bVar.beginTime);
        this.axZ = bVar.axZ;
        this.hUW = 1;
    }

    public final String getKey() {
        return this.mHi + ">" + this.axZ;
    }

    public final String aLx() {
        return this.mHh + ">" + (this.axZ - 1);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.mHi);
        stringBuilder.append(" ");
        stringBuilder.append(this.mHo);
        stringBuilder.append(" ");
        stringBuilder.append(this.axZ);
        stringBuilder.append(" ");
        stringBuilder.append(this.hUW);
        stringBuilder.append(" ");
        stringBuilder.append(this.mHh);
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
