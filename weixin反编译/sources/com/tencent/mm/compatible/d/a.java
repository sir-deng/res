package com.tencent.mm.compatible.d;

import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public static final int gEm = 1;
    private static volatile a gEn = new a() {
        public final void k(long j, long j2) {
            x.w("MicroMsg.ReportDelegate", "hy: dummy reportIDKey, do nothing");
        }
    };
    private static final /* synthetic */ int[] gEo = new int[]{gEm};

    public interface a {
        void k(long j, long j2);
    }

    public static synchronized void a(a aVar) {
        synchronized (a.class) {
            gEn = aVar;
        }
    }

    public static void aC(long j) {
        gEn.k(853, j);
    }
}
