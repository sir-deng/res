package com.tencent.mm.plugin.appbrand.report.a;

import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.report.f;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.LinkedList;

public final class b {
    final f jNh;
    volatile String jNi;
    volatile long jNj = 0;
    volatile long jNk = 0;
    private final LinkedList<Runnable> jNl = new LinkedList();
    volatile String mAppId;

    public b(int i) {
        this.jNh = new f("MicroMsg.AppBrandPageViewStatistics[" + i + "]");
    }

    public final boolean id() {
        return this.jNj > 0 && this.jNk <= 0;
    }

    public final void f(e eVar) {
        this.mAppId = eVar.mAppId;
    }

    public final void uG(String str) {
        this.jNj = bi.Wy();
        this.jNh.akv();
        this.jNi = str;
    }

    public final void akx() {
        this.jNk = bi.Wy() - this.jNj;
    }

    public final void afQ() {
        this.jNh.akw();
        if (this.jNh.aku()) {
            aky();
        } else {
            ah.y(new Runnable() {
                public final void run() {
                    b.this.aky();
                }
            });
        }
    }

    public final void agq() {
        if (this.jNj > 0) {
            this.jNh.akv();
            this.jNl.clear();
        }
    }

    public final void onDestroy() {
        this.jNh.akw();
        f fVar = this.jNh;
        fVar.quit();
        fVar.mStopped = true;
    }

    public final void r(Runnable runnable) {
        if (this.jNh.aku()) {
            runnable.run();
        } else {
            this.jNl.addLast(runnable);
        }
    }

    final void aky() {
        while (!this.jNl.isEmpty()) {
            ((Runnable) this.jNl.pollFirst()).run();
        }
    }
}
