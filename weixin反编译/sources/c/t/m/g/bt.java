package c.t.m.g;

final class bt implements Runnable {
    private /* synthetic */ bo a;

    bt(bo boVar) {
        this.a = boVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r10 = this;
        r6 = 0;
        r8 = android.os.SystemClock.elapsedRealtime();
        r1 = new c.t.m.g.bg;	 Catch:{ Throwable -> 0x0028, all -> 0x00e5 }
        r1.<init>();	 Catch:{ Throwable -> 0x0028, all -> 0x00e5 }
        r0 = r10.a;	 Catch:{ Throwable -> 0x0028, all -> 0x00e5 }
        r0 = r0.d;	 Catch:{ Throwable -> 0x0028, all -> 0x00e5 }
        r0 = r0.values();	 Catch:{ Throwable -> 0x0028, all -> 0x00e5 }
        r2 = r0.iterator();	 Catch:{ Throwable -> 0x0028, all -> 0x00e5 }
    L_0x0018:
        r0 = r2.hasNext();	 Catch:{ Throwable -> 0x0028, all -> 0x00e5 }
        if (r0 == 0) goto L_0x004b;
    L_0x001e:
        r0 = r2.next();	 Catch:{ Throwable -> 0x0028, all -> 0x00e5 }
        r0 = (c.t.m.g.bk) r0;	 Catch:{ Throwable -> 0x0028, all -> 0x00e5 }
        r0.a(r1);	 Catch:{ Throwable -> 0x0028, all -> 0x00e5 }
        goto L_0x0018;
    L_0x0028:
        r0 = move-exception;
    L_0x0029:
        r0 = r10.a;
        r1 = c.t.m.g.p.b();
        r0 = c.t.m.g.bo.a(r0, r1);
        r2 = android.os.SystemClock.elapsedRealtime();
        r0.a = r2;
        r0.b = r6;
        r0 = r10.a;
        r0 = r0.c;
        r1 = r10.a;
        r1 = r1.f;
        r0.removeCallbacks(r1);
    L_0x004a:
        return;
    L_0x004b:
        r2 = r1.a();	 Catch:{ Throwable -> 0x0028, all -> 0x00e5 }
        r0 = c.t.m.g.cg.a(r2);	 Catch:{ Throwable -> 0x0028, all -> 0x00e5 }
        if (r0 != 0) goto L_0x010f;
    L_0x0055:
        r0 = "https://yun-hl.3g.qq.com/halleycloud";
        r1 = 0;
        r3 = 15000; // 0x3a98 float:2.102E-41 double:7.411E-320;
        r4 = c.t.m.g.cg.d();	 Catch:{ Throwable -> 0x0028, all -> 0x00e5 }
        r5 = c.t.m.g.bx.c();	 Catch:{ Throwable -> 0x0028, all -> 0x00e5 }
        r5 = r5.d();	 Catch:{ Throwable -> 0x0028, all -> 0x00e5 }
        r2 = c.t.m.g.ag.a(r0, r1, r2, r3, r4, r5);	 Catch:{ Throwable -> 0x0028, all -> 0x00e5 }
        r0 = "platform";
        r2.o = r0;	 Catch:{ Throwable -> 0x0028, all -> 0x00e5 }
        r0 = r2.a();	 Catch:{ Throwable -> 0x0028, all -> 0x00e5 }
        r1 = r0.a;	 Catch:{ Throwable -> 0x0028, all -> 0x00e5 }
        r3 = r0.a;	 Catch:{ Throwable -> 0x010b, all -> 0x0108 }
        if (r3 != 0) goto L_0x00b6;
    L_0x007a:
        r3 = r0.c;	 Catch:{ Throwable -> 0x010b, all -> 0x0108 }
        r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r3 != r4) goto L_0x00b6;
    L_0x0080:
        r3 = r0.d;	 Catch:{ Throwable -> 0x010b, all -> 0x0108 }
        r3 = c.t.m.g.cg.a(r3);	 Catch:{ Throwable -> 0x010b, all -> 0x0108 }
        if (r3 != 0) goto L_0x00b6;
    L_0x0088:
        r3 = new java.lang.String;	 Catch:{ Throwable -> 0x00b5, all -> 0x0108 }
        r0 = r0.d;	 Catch:{ Throwable -> 0x00b5, all -> 0x0108 }
        r3.<init>(r0);	 Catch:{ Throwable -> 0x00b5, all -> 0x0108 }
        r4 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x00b5, all -> 0x0108 }
        r4.<init>(r3);	 Catch:{ Throwable -> 0x00b5, all -> 0x0108 }
        c.t.m.g.p.e();	 Catch:{ Throwable -> 0x00b5, all -> 0x0108 }
        r0 = r10.a;	 Catch:{ Throwable -> 0x00b5, all -> 0x0108 }
        r0 = r0.d;	 Catch:{ Throwable -> 0x00b5, all -> 0x0108 }
        r0 = r0.values();	 Catch:{ Throwable -> 0x00b5, all -> 0x0108 }
        r3 = r0.iterator();	 Catch:{ Throwable -> 0x00b5, all -> 0x0108 }
    L_0x00a5:
        r0 = r3.hasNext();	 Catch:{ Throwable -> 0x00b5, all -> 0x0108 }
        if (r0 == 0) goto L_0x00b6;
    L_0x00ab:
        r0 = r3.next();	 Catch:{ Throwable -> 0x00b5, all -> 0x0108 }
        r0 = (c.t.m.g.bk) r0;	 Catch:{ Throwable -> 0x00b5, all -> 0x0108 }
        r0.a(r4);	 Catch:{ Throwable -> 0x00b5, all -> 0x0108 }
        goto L_0x00a5;
    L_0x00b5:
        r0 = move-exception;
    L_0x00b6:
        r4 = android.os.SystemClock.elapsedRealtime();	 Catch:{ Throwable -> 0x010b, all -> 0x0108 }
        r4 = r4 - r8;
        r2.k = r4;	 Catch:{ Throwable -> 0x010b, all -> 0x0108 }
        r0 = 0;
        r2.a(r0);	 Catch:{ Throwable -> 0x010b, all -> 0x0108 }
        r0 = r1;
    L_0x00c2:
        r1 = r10.a;
        r2 = c.t.m.g.p.b();
        r1 = c.t.m.g.bo.a(r1, r2);
        r2 = android.os.SystemClock.elapsedRealtime();
        r1.a = r2;
        r1.b = r0;
        r0 = r10.a;
        r0 = r0.c;
        r1 = r10.a;
        r1 = r1.f;
        r0.removeCallbacks(r1);
        goto L_0x004a;
    L_0x00e5:
        r0 = move-exception;
    L_0x00e6:
        r1 = r10.a;
        r2 = c.t.m.g.p.b();
        r1 = c.t.m.g.bo.a(r1, r2);
        r2 = android.os.SystemClock.elapsedRealtime();
        r1.a = r2;
        r1.b = r6;
        r1 = r10.a;
        r1 = r1.c;
        r2 = r10.a;
        r2 = r2.f;
        r1.removeCallbacks(r2);
        throw r0;
    L_0x0108:
        r0 = move-exception;
        r6 = r1;
        goto L_0x00e6;
    L_0x010b:
        r0 = move-exception;
        r6 = r1;
        goto L_0x0029;
    L_0x010f:
        r0 = r6;
        goto L_0x00c2;
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.bt.run():void");
    }
}
