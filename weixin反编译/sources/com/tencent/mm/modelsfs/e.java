package com.tencent.mm.modelsfs;

public final class e extends SFSOutputStream {
    private a hNN;

    public e(long j, String str) {
        super(j);
        this.hNN = new a(str);
    }

    public final void write(int i) {
        super.write(i);
    }

    public final void write(byte[] bArr, int i, int i2) {
        this.hNN.w(bArr, i2);
        super.write(bArr, i, i2);
    }

    public final void close() {
        super.close();
        if (this.hNN != null) {
            this.hNN.free();
        }
    }

    protected final void finalize() {
        super.finalize();
    }
}
