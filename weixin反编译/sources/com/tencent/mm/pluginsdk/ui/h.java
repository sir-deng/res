package com.tencent.mm.pluginsdk.ui;

public interface h {

    public interface c {
        void a(long j, long j2, long j3, boolean z);

        void k(int i, String str);
    }

    public interface a {
        void V(String str, boolean z);
    }

    public interface b {
        void bn(String str, String str2);

        void bo(String str, String str2);

        void bp(String str, String str2);

        void bq(String str, String str2);

        void br(String str, String str2);

        void bs(String str, String str2);

        void c(String str, String str2, String str3, int i, int i2);

        void e(String str, String str2, int i, int i2);
    }

    public enum d {
        DEFAULT,
        FILL,
        CONTAIN,
        COVER
    }

    void TK();

    void TL();

    int TO();

    void a(g gVar);

    void a(d dVar);

    boolean aa(float f);

    int ahA();

    void ahB();

    boolean ahf();

    void ahx();

    int ahy();

    int ahz();

    void b(boolean z, String str, int i);

    boolean isPlaying();

    boolean kL(int i);

    boolean pause();

    boolean s(int i, boolean z);

    void setMute(boolean z);

    void start();

    void stop();
}
