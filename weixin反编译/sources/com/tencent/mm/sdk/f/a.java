package com.tencent.mm.sdk.f;

import android.os.HandlerThread;
import com.tencent.mm.sdk.f.e.b;
import java.util.concurrent.atomic.AtomicInteger;
import junit.framework.Assert;

public final class a {
    private ThreadGroup hEN;
    private final AtomicInteger xsj = new AtomicInteger(1);
    private b xsk;

    static class a extends HandlerThread {
        a(String str, int i) {
            super(str, i);
        }

        public final void start() {
            super.start();
        }

        public final void run() {
            super.run();
        }
    }

    a(b bVar) {
        this.xsk = bVar;
        this.hEN = new ThreadGroup("MM_FREE_THREAD_GROUP");
    }

    static HandlerThread db(String str, int i) {
        Assert.assertNotNull("newThread arg name is null!", str);
        return new a("mmt_h" + str, i);
    }
}
