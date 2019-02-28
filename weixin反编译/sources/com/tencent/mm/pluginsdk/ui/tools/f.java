package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;

public interface f {

    public interface a {
        int ck(int i, int i2);

        void cl(int i, int i2);

        void hY();

        void onError(int i, int i2);

        void vi();
    }

    public interface b {
        void eC(int i, int i2);
    }

    public interface c {
        void bY(boolean z);
    }

    public interface d {
        void TP();
    }

    public interface e {
        void bcn();
    }

    String Uy();

    void a(a aVar);

    void a(b bVar);

    void a(c cVar);

    void a(d dVar);

    void a(e eVar);

    double btQ();

    long btR();

    void c(double d, boolean z);

    void cR(boolean z);

    int getCurrentPosition();

    int getDuration();

    void ii(boolean z);

    boolean isPlaying();

    boolean k(Context context, boolean z);

    void onDetach();

    void pause();

    void q(double d);

    void setMute(boolean z);

    void setVideoPath(String str);

    boolean start();

    void stop();
}
