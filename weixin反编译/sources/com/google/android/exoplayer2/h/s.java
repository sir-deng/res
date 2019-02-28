package com.google.android.exoplayer2.h;

import android.net.Uri;
import com.google.android.exoplayer2.h.r.c;
import com.google.android.exoplayer2.i.t;
import java.io.Closeable;
import java.io.InputStream;

public final class s<T> implements c {
    private final a<? extends T> aBS;
    private volatile boolean aBT;
    public volatile long aBU;
    private final f aiB;
    public final i asH;
    public volatile T result;
    public final int type = 4;

    public interface a<T> {
        T b(Uri uri, InputStream inputStream);
    }

    public s(f fVar, Uri uri, a<? extends T> aVar) {
        this.aiB = fVar;
        this.asH = new i(uri);
        this.aBS = aVar;
    }

    public final void kr() {
        this.aBT = true;
    }

    public final boolean ks() {
        return this.aBT;
    }

    public final void kt() {
        Closeable hVar = new h(this.aiB, this.asH);
        try {
            hVar.lq();
            this.result = this.aBS.b(this.aiB.getUri(), hVar);
        } finally {
            this.aBU = hVar.aAI;
            t.b(hVar);
        }
    }
}
