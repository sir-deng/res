package com.tencent.mm.plugin.appbrand.s.d;

import java.nio.ByteBuffer;

public interface d {

    public enum a {
        CONTINUOUS,
        TEXT,
        BINARY,
        PING,
        PONG,
        CLOSING
    }

    ByteBuffer amC();

    boolean amD();

    boolean amE();

    a amF();

    void e(d dVar);
}
