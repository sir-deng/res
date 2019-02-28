package com.d.a.a;

import android.os.Handler;

abstract class c extends d {
    private boolean bgG;

    abstract void rT();

    abstract void rU();

    c() {
    }

    synchronized void a(Handler handler, a aVar) {
        this.bgG = false;
        super.a(handler, aVar);
    }

    final synchronized void ay(boolean z) {
        if ((this.bgG ^ z) != 0) {
            this.bgG = z;
            if (this.bgG) {
                rT();
            } else {
                rU();
            }
        }
    }
}
