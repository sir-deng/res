package com.tencent.mm.plugin.remittance.b;

import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class b extends i<a> {
    public static final String[] gLy = new String[]{i.a(a.gKN, "DelayTransferRecord")};
    private static final String[] ijz = new String[]{"*", "rowid"};
    private e gLA;

    public b(e eVar) {
        super(eVar, a.gKN, "DelayTransferRecord", null);
        this.gLA = eVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.plugin.remittance.b.a IT(java.lang.String r10) {
        /*
        r9 = this;
        r6 = 0;
        r5 = 0;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r10);
        if (r0 == 0) goto L_0x0012;
    L_0x0008:
        r0 = "MicroMsg.AARecordStorage";
        r1 = "empty transferId";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
    L_0x0011:
        return r5;
    L_0x0012:
        r0 = r9.gLA;
        r1 = "DelayTransferRecord";
        r2 = ijz;
        r3 = "transferId=?";
        r4 = 1;
        r4 = new java.lang.String[r4];
        r4[r6] = r10;
        r8 = 2;
        r6 = r5;
        r7 = r5;
        r1 = r0.a(r1, r2, r3, r4, r5, r6, r7, r8);
        r0 = r1.moveToFirst();	 Catch:{ Exception -> 0x0043 }
        if (r0 == 0) goto L_0x003d;
    L_0x002e:
        r0 = new com.tencent.mm.plugin.remittance.b.a;	 Catch:{ Exception -> 0x0043 }
        r0.<init>();	 Catch:{ Exception -> 0x0043 }
        r0.b(r1);	 Catch:{ Exception -> 0x0043 }
        if (r1 == 0) goto L_0x003b;
    L_0x0038:
        r1.close();
    L_0x003b:
        r5 = r0;
        goto L_0x0011;
    L_0x003d:
        if (r1 == 0) goto L_0x0011;
    L_0x003f:
        r1.close();
        goto L_0x0011;
    L_0x0043:
        r0 = move-exception;
        r2 = "MicroMsg.AARecordStorage";
        r3 = "";
        r4 = 0;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0056 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r2, r0, r3, r4);	 Catch:{ all -> 0x0056 }
        if (r1 == 0) goto L_0x0011;
    L_0x0052:
        r1.close();
        goto L_0x0011;
    L_0x0056:
        r0 = move-exception;
        if (r1 == 0) goto L_0x005c;
    L_0x0059:
        r1.close();
    L_0x005c:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.remittance.b.b.IT(java.lang.String):com.tencent.mm.plugin.remittance.b.a");
    }
}
