package com.tencent.mm.platformtools;

import android.graphics.Bitmap;

public interface i {

    public enum a {
        NET,
        DISK
    }

    public interface b {
        Bitmap oG(String str);
    }

    void N(String str, boolean z);

    b Wn();

    String Wo();

    String Wp();

    String Wq();

    String Wr();

    boolean Ws();

    boolean Wt();

    Bitmap Wu();

    void Wv();

    Bitmap a(Bitmap bitmap, a aVar, String str);

    void a(a aVar, String str);
}
