package com.tencent.mm.plugin.mmsight.segment.a;

import android.view.Surface;

public interface a {

    public interface a {
        boolean cT(int i, int i2);
    }

    public interface b {
        void bz(Object obj);
    }

    public interface c {
        void bA(Object obj);
    }

    public interface d {
        void Q(int i, int i2, int i3);
    }

    void a(a aVar);

    void a(b bVar);

    void a(c cVar);

    void a(d dVar);

    int getCurrentPosition();

    int getDuration();

    boolean isPlaying();

    void pause();

    void prepareAsync();

    void release();

    void seekTo(int i);

    void setAudioStreamType(int i);

    void setDataSource(String str);

    void setLoop(int i, int i2);

    void setLooping(boolean z);

    void setSurface(Surface surface);

    void start();

    void stop();
}
