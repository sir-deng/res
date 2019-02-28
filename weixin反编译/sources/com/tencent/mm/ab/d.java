package com.tencent.mm.ab;

import java.io.Closeable;

public interface d extends Closeable {
    int JE();

    long getSize();

    boolean isOpen();

    void open();

    int readAt(long j, byte[] bArr, int i, int i2);
}
