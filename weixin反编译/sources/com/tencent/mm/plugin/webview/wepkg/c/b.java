package com.tencent.mm.plugin.webview.wepkg.c;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class b extends InputStream {
    private long size;
    private a tUr;

    public b(File file, long j, long j2) {
        this.size = j2;
        this.tUr = new a(new FileInputStream(file));
        fm(j);
        this.tUr.bVZ();
    }

    public final int read() {
        if ((bWa() <= 0 ? 1 : null) != null) {
            return -1;
        }
        return this.tUr.read();
    }

    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public final int read(byte[] bArr, int i, int i2) {
        long fl = fl((long) i2);
        if (fl != 0 || i2 <= 0) {
            return this.tUr.read(bArr, i, (int) fl);
        }
        return -1;
    }

    public final long skip(long j) {
        return this.tUr.skip(fl(j));
    }

    public final int available() {
        return (int) fl((long) this.tUr.available());
    }

    private long fl(long j) {
        return Math.min(bWa(), j);
    }

    private long bWa() {
        return this.size - ((long) this.tUr.count);
    }

    private void fm(long j) {
        long j2 = 0;
        while (j2 < j) {
            long skip = this.tUr.skip(j - j2);
            if (skip <= 0) {
                break;
            }
            j2 += skip;
        }
        if (j2 < j) {
            throw new IOException("could not seek pos " + j);
        }
    }
}
