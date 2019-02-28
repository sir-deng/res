package com.tencent.mm.modelsfs;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.FileInputStream;

public final class b extends FileInputStream {
    private boolean hNJ = false;
    private a hNN;
    private long hNO = 0;

    public b(String str, long j) {
        super(str);
        this.hNN = new a(j);
    }

    public final int read(byte[] bArr, int i, int i2) {
        if (this.hNJ) {
            x.i("MicroMsg.EncInputStream", "read buffer  hashcode " + hashCode() + " " + bi.chl().toString());
        }
        int read = super.read(bArr, i, i2);
        if (read >= 0) {
            this.hNN.w(bArr, i2);
        }
        return read;
    }

    public final long skip(long j) {
        long skip = super.skip(j);
        this.hNN.seek(j);
        return skip;
    }

    public final void close() {
        super.close();
        if (this.hNN != null) {
            this.hNN.free();
        }
        x.i("MicroMsg.EncInputStream", "close  hashcode " + hashCode());
    }

    public final void mark(int i) {
        this.hNO = this.hNN.RB();
    }

    public final void reset() {
        getChannel().position(this.hNO);
        this.hNN.reset();
    }

    public final boolean markSupported() {
        return true;
    }
}
