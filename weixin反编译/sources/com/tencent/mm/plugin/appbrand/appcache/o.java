package com.tencent.mm.plugin.appbrand.appcache;

final class o {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.String a(com.tencent.mm.plugin.appbrand.appcache.ag r6, java.lang.String r7) {
        /*
        r0 = 0;
        if (r6 == 0) goto L_0x0009;
    L_0x0003:
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r7);
        if (r1 == 0) goto L_0x000a;
    L_0x0009:
        return r0;
    L_0x000a:
        r6.aai();
        r2 = r6.qa(r7);
        if (r2 == 0) goto L_0x0009;
    L_0x0013:
        r1 = r2.available();	 Catch:{ Exception -> 0x009f }
        r2.mark(r1);	 Catch:{ Exception -> 0x009f }
        r1 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r1 = com.tencent.mm.a.g.a(r2, r1);	 Catch:{ Exception -> 0x009f }
        r2.reset();	 Catch:{ Exception -> 0x009f }
        r3 = new java.io.File;	 Catch:{ Exception -> 0x009f }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x009f }
        r4.<init>();	 Catch:{ Exception -> 0x009f }
        r5 = r6.iHM;	 Catch:{ Exception -> 0x009f }
        r5 = r5.getAbsolutePath();	 Catch:{ Exception -> 0x009f }
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x009f }
        r5 = "_xdir/";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x009f }
        r4 = r4.append(r7);	 Catch:{ Exception -> 0x009f }
        r4 = r4.toString();	 Catch:{ Exception -> 0x009f }
        r3.<init>(r4);	 Catch:{ Exception -> 0x009f }
        r4 = r3.getParentFile();	 Catch:{ Exception -> 0x009f }
        r5 = r4.exists();	 Catch:{ Exception -> 0x009f }
        if (r5 == 0) goto L_0x0059;
    L_0x0050:
        r5 = r4.isFile();	 Catch:{ Exception -> 0x009f }
        if (r5 == 0) goto L_0x0059;
    L_0x0056:
        r4.delete();	 Catch:{ Exception -> 0x009f }
    L_0x0059:
        r4.mkdirs();	 Catch:{ Exception -> 0x009f }
        r4 = com.tencent.mm.a.g.i(r3);	 Catch:{ Exception -> 0x009f }
        r1 = r1.equals(r4);	 Catch:{ Exception -> 0x009f }
        if (r1 != 0) goto L_0x0092;
    L_0x0066:
        r1 = r3.isDirectory();	 Catch:{ Exception -> 0x009f }
        if (r1 == 0) goto L_0x009b;
    L_0x006c:
        r1 = java.lang.Runtime.getRuntime();	 Catch:{ Exception -> 0x009f }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x009f }
        r5 = "rm -r ";
        r4.<init>(r5);	 Catch:{ Exception -> 0x009f }
        r5 = r3.getAbsolutePath();	 Catch:{ Exception -> 0x009f }
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x009f }
        r4 = r4.toString();	 Catch:{ Exception -> 0x009f }
        r1.exec(r4);	 Catch:{ Exception -> 0x009f }
    L_0x0087:
        r1 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x009f }
        r1.<init>(r3);	 Catch:{ Exception -> 0x009f }
        com.tencent.mm.a.e.c(r2, r1);	 Catch:{ Exception -> 0x009f }
        com.tencent.mm.sdk.platformtools.bi.d(r1);	 Catch:{ Exception -> 0x009f }
    L_0x0092:
        r0 = r3.getAbsolutePath();	 Catch:{ Exception -> 0x009f }
        com.tencent.mm.sdk.platformtools.bi.d(r2);
        goto L_0x0009;
    L_0x009b:
        r3.delete();	 Catch:{ Exception -> 0x009f }
        goto L_0x0087;
    L_0x009f:
        r1 = move-exception;
        r3 = "MicroMsg.AppBrand.PkgPartialCopy";
        r4 = "copy failed";
        r5 = 0;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x00b1 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r1, r4, r5);	 Catch:{ all -> 0x00b1 }
        com.tencent.mm.sdk.platformtools.bi.d(r2);
        goto L_0x0009;
    L_0x00b1:
        r0 = move-exception;
        com.tencent.mm.sdk.platformtools.bi.d(r2);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.appcache.o.a(com.tencent.mm.plugin.appbrand.appcache.ag, java.lang.String):java.lang.String");
    }
}
