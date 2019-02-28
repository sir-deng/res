package c.t.m.g;

final class an implements Runnable {
    private /* synthetic */ ag a;
    private /* synthetic */ long b;
    private /* synthetic */ am c;

    an(am amVar, ag agVar, long j) {
        this.c = amVar;
        this.a = agVar;
        this.b = j;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r8 = this;
        r0 = 0;
        r1 = r8.a;	 Catch:{ Throwable -> 0x0029, all -> 0x0030 }
        r1 = r1.a();	 Catch:{ Throwable -> 0x0029, all -> 0x0030 }
        r2 = r8.a;	 Catch:{ Throwable -> 0x0029, all -> 0x0030 }
        r4 = android.os.SystemClock.elapsedRealtime();	 Catch:{ Throwable -> 0x0029, all -> 0x0030 }
        r6 = r8.b;	 Catch:{ Throwable -> 0x0029, all -> 0x0030 }
        r4 = r4 - r6;
        r2.k = r4;	 Catch:{ Throwable -> 0x0029, all -> 0x0030 }
        r2 = r8.a;	 Catch:{ Throwable -> 0x0029, all -> 0x0030 }
        r3 = 0;
        r2.a(r3);	 Catch:{ Throwable -> 0x0029, all -> 0x0030 }
        r2 = r1.a;	 Catch:{ Throwable -> 0x0029, all -> 0x0030 }
        if (r2 != 0) goto L_0x0023;
    L_0x001c:
        r1 = r1.c;	 Catch:{ Throwable -> 0x0029, all -> 0x0030 }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r1 != r2) goto L_0x0023;
    L_0x0022:
        r0 = 1;
    L_0x0023:
        r1 = r8.c;
        r1.b.a(r0, r1.a);
    L_0x0028:
        return;
    L_0x0029:
        r1 = move-exception;
        r1 = r8.c;
        r1.b.a(r0, r1.a);
        goto L_0x0028;
    L_0x0030:
        r1 = move-exception;
        r2 = r8.c;
        r2.b.a(r0, r2.a);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.an.run():void");
    }
}
