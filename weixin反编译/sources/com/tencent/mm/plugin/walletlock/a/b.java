package com.tencent.mm.plugin.walletlock.a;

import android.app.Activity;
import android.content.Intent;

public interface b extends com.tencent.mm.kernel.c.a {

    public interface a {
    }

    public interface b {
        boolean M(Activity activity);
    }

    void L(Activity activity);

    void a(Activity activity, b bVar);

    void a(Activity activity, b bVar, a aVar);

    void b(Activity activity, int i, int i2);

    void b(Activity activity, Intent intent, int i);

    b bOm();

    boolean bOn();

    boolean bOo();

    void c(Activity activity, Intent intent);

    void init();

    void j(Activity activity, int i);

    void k(Activity activity, int i);

    void zM(int i);
}
