package com.tencent.mm.audio.b;

public abstract class f {
    protected int fkT = -123456789;
    protected int flG = 0;
    protected a fll;
    protected boolean mIsPause = false;

    public interface a {
        void c(int i, byte[] bArr);
    }

    public abstract void aS(boolean z);

    public abstract void uF();

    public abstract boolean vs();

    public final void a(a aVar) {
        this.fll = aVar;
    }

    public final void eu(int i) {
        this.fkT = i;
    }

    public final int vu() {
        return this.flG;
    }
}
