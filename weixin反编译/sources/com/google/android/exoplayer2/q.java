package com.google.android.exoplayer2;

public interface q {

    public interface a {
        void a(e eVar);

        void a(p pVar);

        void a(boolean z, int i);

        void ai(boolean z);

        void is();
    }

    void a(a aVar);

    void af(boolean z);

    void b(a aVar);

    int getBufferedPercentage();

    long getBufferedPosition();

    long getCurrentPosition();

    long getDuration();

    int ib();

    boolean ic();

    boolean id();

    void release();

    void seekTo(long j);

    void stop();
}
