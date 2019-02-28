package com.tencent.mm.plugin.mmsight.model.a;

import android.graphics.Point;
import com.tencent.mm.plugin.mmsight.model.f;

public interface d {

    public interface b {
    }

    public enum c {
        WaitStart,
        Start,
        PrepareStop,
        WaitStop,
        Stop,
        WaitSend,
        Sent,
        Error,
        Initialized,
        Pause
    }

    public interface a {
        void Yw();
    }

    void C(Runnable runnable);

    void FO(String str);

    void FP(String str);

    String Nx();

    void P(int i, int i2, int i3);

    void a(a aVar);

    String aOC();

    boolean baC();

    String bbb();

    float bbc();

    long bbd();

    f bbe();

    c bbf();

    int bbg();

    Point bbh();

    int bbi();

    boolean bbj();

    void bbk();

    com.tencent.mm.audio.b.c.a bbl();

    void bbm();

    int c(int i, boolean z, int i2);

    void cancel();

    String getFileName();

    String getFilePath();

    void m(int i, int i2, int i3, int i4);

    void pause();

    void reset();

    void setFilePath(String str);

    boolean tf(int i);
}
