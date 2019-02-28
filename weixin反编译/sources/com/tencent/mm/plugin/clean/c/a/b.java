package com.tencent.mm.plugin.clean.c.a;

import android.os.Looper;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public final class b implements c {
    public HashMap<Long, ag> lly;
    private HashSet<Long> llz;

    public b() {
        this((byte) 0);
    }

    private b(byte b) {
        this.llz = new HashSet(5);
        this.lly = new HashMap(5);
        for (int i = 0; i <= 5; i++) {
            e.d(new Runnable() {
                public final void run() {
                    Looper.prepare();
                    b.this.lly.put(Long.valueOf(Thread.currentThread().getId()), new ag(Looper.myLooper()));
                    Looper.loop();
                }
            }, "ThreadController_handler", 1).start();
        }
    }

    public final synchronized boolean b(a aVar) {
        boolean z;
        aVar.llx = this;
        x.d("MicroMsg.ThreadController", "running threads %s", this.llz.toString());
        for (Entry entry : this.lly.entrySet()) {
            if (!this.llz.contains(entry.getKey())) {
                ((ag) entry.getValue()).post(aVar);
                this.llz.add(entry.getKey());
                z = true;
                break;
            }
        }
        z = false;
        return z;
    }

    private synchronized void e(Long l) {
        if (this.llz.remove(l)) {
            x.d("MicroMsg.ThreadController", "thread is idle, id=%d", l);
        }
    }

    public final void f(Long l) {
        e(l);
    }
}
