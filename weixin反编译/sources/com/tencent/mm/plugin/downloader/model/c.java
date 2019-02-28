package com.tencent.mm.plugin.downloader.model;

import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Vector;

public final class c {
    private static Vector<o> lxy = new Vector();
    private static o lxz;

    c() {
    }

    public static void a(o oVar) {
        if (oVar != null && !lxy.contains(oVar)) {
            lxy.add(oVar);
        }
    }

    public static void b(o oVar) {
        if (oVar != null) {
            lxy.remove(oVar);
        }
    }

    public static void c(o oVar) {
        lxz = oVar;
    }

    public static void aAH() {
        lxz = null;
    }

    public final void i(final long j, final String str) {
        x.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskStarted: %d, %s", Long.valueOf(j), str);
        ah.y(new Runnable() {
            public final void run() {
                for (o onTaskStarted : ((o[]) c.lxy.toArray(new o[c.lxy.size()]))) {
                    onTaskStarted.onTaskStarted(j, str);
                }
                if (c.lxz != null) {
                    c.lxz.onTaskStarted(j, str);
                }
            }
        });
    }

    public final void j(final long j, final String str) {
        x.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskResumed: %d, %s", Long.valueOf(j), str);
        ah.y(new Runnable() {
            public final void run() {
                for (o k : ((o[]) c.lxy.toArray(new o[c.lxy.size()]))) {
                    k.k(j, str);
                }
                if (c.lxz != null) {
                    c.lxz.k(j, str);
                }
            }
        });
    }

    public final void cc(final long j) {
        x.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskRemoved: %d", Long.valueOf(j));
        ah.y(new Runnable() {
            public final void run() {
                for (o onTaskRemoved : ((o[]) c.lxy.toArray(new o[c.lxy.size()]))) {
                    onTaskRemoved.onTaskRemoved(j);
                }
                if (c.lxz != null) {
                    c.lxz.onTaskRemoved(j);
                }
            }
        });
    }

    public final void b(long j, String str, boolean z) {
        x.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskFinished: %d", Long.valueOf(j));
        final long j2 = j;
        final String str2 = str;
        final boolean z2 = z;
        ah.y(new Runnable() {
            public final void run() {
                for (o c : ((o[]) c.lxy.toArray(new o[c.lxy.size()]))) {
                    c.c(j2, str2, z2);
                }
                if (c.lxz != null) {
                    c.lxz.c(j2, str2, z2);
                }
            }
        });
    }

    public final void b(long j, int i, boolean z) {
        x.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskFailed: %d, errCode : %d", Long.valueOf(j), Integer.valueOf(i));
        final long j2 = j;
        final int i2 = i;
        final boolean z2 = z;
        ah.y(new Runnable() {
            public final void run() {
                for (o c : ((o[]) c.lxy.toArray(new o[c.lxy.size()]))) {
                    c.c(j2, i2, z2);
                }
                if (c.lxz != null) {
                    c.lxz.c(j2, i2, z2);
                }
            }
        });
    }

    public final void cd(final long j) {
        x.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskPaused: %d", Long.valueOf(j));
        ah.y(new Runnable() {
            public final void run() {
                for (o onTaskPaused : ((o[]) c.lxy.toArray(new o[c.lxy.size()]))) {
                    onTaskPaused.onTaskPaused(j);
                }
                if (c.lxz != null) {
                    c.lxz.onTaskPaused(j);
                }
            }
        });
    }

    public final void ce(final long j) {
        ah.y(new Runnable() {
            public final void run() {
                for (o cl : ((o[]) c.lxy.toArray(new o[c.lxy.size()]))) {
                    cl.cl(j);
                }
            }
        });
    }
}
