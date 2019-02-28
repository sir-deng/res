package com.tencent.mm.plugin.aa.a.b;

import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import java.util.HashMap;
import java.util.Map;

public final class d extends i<c> {
    public static final String[] gLy = new String[]{i.a(c.gKN, "AARecord")};
    public static Map<String, c> ijA = new HashMap();
    private static final String[] ijz = new String[]{"*", "rowid"};
    private e gLA;

    public final /* synthetic */ boolean a(c cVar) {
        return b((c) cVar);
    }

    public final /* synthetic */ boolean b(c cVar) {
        return a((c) cVar);
    }

    public d(e eVar) {
        super(eVar, c.gKN, "AARecord", null);
        this.gLA = eVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.plugin.aa.a.b.c oV(java.lang.String r10) {
        /*
        r9 = this;
        r4 = 1;
        r6 = 0;
        r5 = 0;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r10);
        if (r0 == 0) goto L_0x000a;
    L_0x0009:
        return r5;
    L_0x000a:
        r0 = r9.gLA;
        r1 = "AARecord";
        r2 = ijz;
        r3 = "billNo=?";
        r4 = new java.lang.String[r4];
        r4[r6] = r10;
        r8 = 2;
        r6 = r5;
        r7 = r5;
        r1 = r0.a(r1, r2, r3, r4, r5, r6, r7, r8);
        r0 = r1.moveToFirst();	 Catch:{ Exception -> 0x003a }
        if (r0 == 0) goto L_0x0034;
    L_0x0025:
        r0 = new com.tencent.mm.plugin.aa.a.b.c;	 Catch:{ Exception -> 0x003a }
        r0.<init>();	 Catch:{ Exception -> 0x003a }
        r0.b(r1);	 Catch:{ Exception -> 0x003a }
        if (r1 == 0) goto L_0x0032;
    L_0x002f:
        r1.close();
    L_0x0032:
        r5 = r0;
        goto L_0x0009;
    L_0x0034:
        if (r1 == 0) goto L_0x0009;
    L_0x0036:
        r1.close();
        goto L_0x0009;
    L_0x003a:
        r0 = move-exception;
        r2 = "MicroMsg.AARecordStorage";
        r3 = "getRecordByBillno error: %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0054 }
        r6 = 0;
        r0 = r0.getMessage();	 Catch:{ all -> 0x0054 }
        r4[r6] = r0;	 Catch:{ all -> 0x0054 }
        com.tencent.mm.sdk.platformtools.x.e(r2, r3, r4);	 Catch:{ all -> 0x0054 }
        if (r1 == 0) goto L_0x0009;
    L_0x0050:
        r1.close();
        goto L_0x0009;
    L_0x0054:
        r0 = move-exception;
        if (r1 == 0) goto L_0x005a;
    L_0x0057:
        r1.close();
    L_0x005a:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.aa.a.b.d.oV(java.lang.String):com.tencent.mm.plugin.aa.a.b.c");
    }

    public final boolean a(c cVar) {
        if (cVar != null && ijA.containsKey(cVar.field_billNo)) {
            ijA.put(cVar.field_billNo, cVar);
        }
        return super.b((c) cVar);
    }

    public final boolean a(c cVar, String... strArr) {
        if (cVar != null && ijA.containsKey(cVar.field_billNo)) {
            ijA.remove(cVar.field_billNo);
        }
        return super.a((c) cVar, strArr);
    }

    public final boolean b(c cVar) {
        if (cVar != null && ijA.containsKey(cVar.field_billNo)) {
            ijA.put(cVar.field_billNo, cVar);
        }
        return super.a(cVar);
    }
}
