package com.google.android.exoplayer2.a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public interface d {
    public static final ByteBuffer afA = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    public static final class a extends Exception {
        public a(int i, int i2, int i3) {
            super("Unhandled format: " + i + " Hz, " + i2 + " channels in encoding " + i3);
        }
    }

    void b(ByteBuffer byteBuffer);

    void flush();

    int iA();

    void iB();

    ByteBuffer iC();

    boolean isActive();

    boolean iu();

    int iz();

    boolean r(int i, int i2, int i3);

    void reset();
}
