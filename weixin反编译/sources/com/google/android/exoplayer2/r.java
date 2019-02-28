package com.google.android.exoplayer2;

import com.google.android.exoplayer2.f.b;
import com.google.android.exoplayer2.i.f;
import com.google.android.exoplayer2.source.i;

public interface r extends b {
    void a(t tVar, Format[] formatArr, i iVar, long j, boolean z, long j2);

    void a(Format[] formatArr, i iVar, long j);

    void c(long j, long j2);

    void disable();

    int getState();

    int getTrackType();

    s hO();

    f hP();

    i hQ();

    boolean hR();

    void hS();

    boolean hT();

    void hU();

    void i(long j);

    boolean it();

    boolean iu();

    void setIndex(int i);

    void start();

    void stop();
}
