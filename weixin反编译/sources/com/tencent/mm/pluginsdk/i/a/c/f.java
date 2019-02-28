package com.tencent.mm.pluginsdk.i.a.c;

import java.io.IOException;

public final class f extends IOException {
    public final int httpStatusCode;
    public final IOException voe;

    public f(int i, IOException iOException) {
        this.httpStatusCode = i;
        this.voe = iOException;
    }

    public final String toString() {
        return "UnknownConnectionError{httpStatusCode=" + this.httpStatusCode + ", realException=" + this.voe + '}';
    }
}
