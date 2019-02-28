package com.tencent.mm.plugin.fts.a.b;

import java.util.List;

final class a {
    public List<a> ayR;
    public int end;
    public a mSd;
    public boolean mSe;
    public int start;

    public a(int i, int i2, a aVar) {
        this.start = i;
        this.end = i2;
        this.mSd = aVar;
    }

    public final String toString() {
        if (this.mSd == null) {
            return String.format("[%d,%d]", new Object[]{Integer.valueOf(this.start), Integer.valueOf(this.end)});
        }
        return String.format("%s [%d,%d]", new Object[]{this.mSd, Integer.valueOf(this.start), Integer.valueOf(this.end)});
    }
}
