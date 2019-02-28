package com.tencent.mm.plugin.ipcall.a.g;

import android.database.Cursor;
import com.tencent.mm.bx.h;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;

public final class d extends i<c> {
    public static final String[] gLy = new String[]{i.a(c.gKN, "IPCallAddressItem")};
    public static final String[] nMp = new String[]{"*", "rowid"};
    public e gLA;

    public d(e eVar) {
        super(eVar, c.gKN, "IPCallAddressItem", null);
        this.gLA = eVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.plugin.ipcall.a.g.c Di(java.lang.String r10) {
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
        r1 = "IPCallAddressItem";
        r2 = nMp;
        r3 = "contactId=?";
        r4 = new java.lang.String[r4];
        r4[r6] = r10;
        r8 = 2;
        r6 = r5;
        r7 = r5;
        r1 = r0.a(r1, r2, r3, r4, r5, r6, r7, r8);
        r0 = r1.moveToFirst();	 Catch:{ Exception -> 0x003a }
        if (r0 == 0) goto L_0x0034;
    L_0x0025:
        r0 = new com.tencent.mm.plugin.ipcall.a.g.c;	 Catch:{ Exception -> 0x003a }
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
        r2 = "MicroMsg.IPCallAddressStorage";
        r3 = "getByContactId error: %s";
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ipcall.a.g.d.Di(java.lang.String):com.tencent.mm.plugin.ipcall.a.g.c");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.plugin.ipcall.a.g.c Dj(java.lang.String r10) {
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
        r1 = "IPCallAddressItem";
        r2 = nMp;
        r3 = "systemAddressBookUsername=?";
        r4 = new java.lang.String[r4];
        r4[r6] = r10;
        r8 = 2;
        r6 = r5;
        r7 = r5;
        r1 = r0.a(r1, r2, r3, r4, r5, r6, r7, r8);
        r0 = r1.moveToFirst();	 Catch:{ Exception -> 0x003a }
        if (r0 == 0) goto L_0x0034;
    L_0x0025:
        r0 = new com.tencent.mm.plugin.ipcall.a.g.c;	 Catch:{ Exception -> 0x003a }
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
        r2 = "MicroMsg.IPCallAddressStorage";
        r3 = "getByContactName error: %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0054 }
        r6 = 0;
        r0 = r0.getMessage();	 Catch:{ all -> 0x0054 }
        r4[r6] = r0;	 Catch:{ all -> 0x0054 }
        com.tencent.mm.sdk.platformtools.x.d(r2, r3, r4);	 Catch:{ all -> 0x0054 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ipcall.a.g.d.Dj(java.lang.String):com.tencent.mm.plugin.ipcall.a.g.c");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.plugin.ipcall.a.g.c dz(long r10) {
        /*
        r9 = this;
        r4 = 1;
        r7 = 0;
        r5 = 0;
        r0 = r9.gLA;
        r1 = "IPCallAddressItem";
        r2 = nMp;
        r3 = "rowid=?";
        r4 = new java.lang.String[r4];
        r6 = java.lang.String.valueOf(r10);
        r4[r7] = r6;
        r8 = 2;
        r6 = r5;
        r7 = r5;
        r1 = r0.a(r1, r2, r3, r4, r5, r6, r7, r8);
        r0 = r1.moveToFirst();	 Catch:{ Exception -> 0x0037 }
        if (r0 == 0) goto L_0x0031;
    L_0x0022:
        r0 = new com.tencent.mm.plugin.ipcall.a.g.c;	 Catch:{ Exception -> 0x0037 }
        r0.<init>();	 Catch:{ Exception -> 0x0037 }
        r0.b(r1);	 Catch:{ Exception -> 0x0037 }
        if (r1 == 0) goto L_0x002f;
    L_0x002c:
        r1.close();
    L_0x002f:
        r5 = r0;
    L_0x0030:
        return r5;
    L_0x0031:
        if (r1 == 0) goto L_0x0030;
    L_0x0033:
        r1.close();
        goto L_0x0030;
    L_0x0037:
        r0 = move-exception;
        r2 = "MicroMsg.IPCallAddressStorage";
        r3 = "getByLocalId error: %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0051 }
        r6 = 0;
        r0 = r0.getMessage();	 Catch:{ all -> 0x0051 }
        r4[r6] = r0;	 Catch:{ all -> 0x0051 }
        com.tencent.mm.sdk.platformtools.x.d(r2, r3, r4);	 Catch:{ all -> 0x0051 }
        if (r1 == 0) goto L_0x0030;
    L_0x004d:
        r1.close();
        goto L_0x0030;
    L_0x0051:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0057;
    L_0x0054:
        r1.close();
    L_0x0057:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ipcall.a.g.d.dz(long):com.tencent.mm.plugin.ipcall.a.g.c");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.ArrayList<com.tencent.mm.plugin.ipcall.a.g.c> aUN() {
        /*
        r9 = this;
        r3 = 0;
        r0 = r9.gLA;
        r1 = "IPCallAddressItem";
        r2 = nMp;
        r8 = 2;
        r4 = r3;
        r5 = r3;
        r6 = r3;
        r7 = r3;
        r1 = r0.a(r1, r2, r3, r4, r5, r6, r7, r8);
        if (r1 == 0) goto L_0x0036;
    L_0x0013:
        r0 = r1.moveToFirst();	 Catch:{ Exception -> 0x003c }
        if (r0 == 0) goto L_0x0036;
    L_0x0019:
        r0 = new java.util.ArrayList;	 Catch:{ Exception -> 0x003c }
        r0.<init>();	 Catch:{ Exception -> 0x003c }
    L_0x001e:
        r2 = new com.tencent.mm.plugin.ipcall.a.g.c;	 Catch:{ Exception -> 0x003c }
        r2.<init>();	 Catch:{ Exception -> 0x003c }
        r2.b(r1);	 Catch:{ Exception -> 0x003c }
        r0.add(r2);	 Catch:{ Exception -> 0x003c }
        r2 = r1.moveToNext();	 Catch:{ Exception -> 0x003c }
        if (r2 != 0) goto L_0x001e;
    L_0x002f:
        if (r1 == 0) goto L_0x0034;
    L_0x0031:
        r1.close();
    L_0x0034:
        r3 = r0;
    L_0x0035:
        return r3;
    L_0x0036:
        if (r1 == 0) goto L_0x0035;
    L_0x0038:
        r1.close();
        goto L_0x0035;
    L_0x003c:
        r0 = move-exception;
        r2 = "MicroMsg.IPCallAddressStorage";
        r4 = "getAllAddress, error: %s";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0056 }
        r6 = 0;
        r0 = r0.getMessage();	 Catch:{ all -> 0x0056 }
        r5[r6] = r0;	 Catch:{ all -> 0x0056 }
        com.tencent.mm.sdk.platformtools.x.e(r2, r4, r5);	 Catch:{ all -> 0x0056 }
        if (r1 == 0) goto L_0x0035;
    L_0x0052:
        r1.close();
        goto L_0x0035;
    L_0x0056:
        r0 = move-exception;
        if (r1 == 0) goto L_0x005c;
    L_0x0059:
        r1.close();
    L_0x005c:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ipcall.a.g.d.aUN():java.util.ArrayList<com.tencent.mm.plugin.ipcall.a.g.c>");
    }

    public final Cursor Dk(String str) {
        int i;
        Cursor Dl;
        String str2;
        Iterator it;
        String str3;
        String str4;
        String str5;
        System.currentTimeMillis();
        for (i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                i = 0;
                break;
            }
        }
        i = 1;
        if (i == 0) {
            Dl = Dl(str);
        } else {
            ArrayList DQ = a.DQ(str);
            Cursor Dl2 = Dl(str);
            try {
                if (Dl2.moveToFirst()) {
                    while (!Dl2.isAfterLast()) {
                        DQ.add(Dl2.getString(Dl2.getColumnIndex("contactId")));
                        Dl2.moveToNext();
                    }
                }
                if (Dl2 != null) {
                    Dl2.close();
                }
            } catch (Exception e) {
                x.e("MicroMsg.IPCallAddressStorage", "getContactIdList error: %s", e.getMessage());
                str2 = "";
                it = DQ.iterator();
                while (true) {
                    str3 = str2;
                    if (it.hasNext()) {
                        break;
                    }
                    str2 = str3 + ((String) it.next()) + ",";
                }
                if (str3.lastIndexOf(",") >= 0) {
                    str3 = str3.substring(0, str3.lastIndexOf(","));
                }
                str4 = null;
                str5 = null;
                Dl = this.gLA.query("IPCallAddressItem", nMp, "contactId IN " + ("(" + str3 + ")"), null, str4, str5, "upper(sortKey) asc");
            } finally {
                if (Dl2 != null) {
                    Dl2.close();
                }
            }
            str2 = "";
            it = DQ.iterator();
            while (true) {
                str3 = str2;
                if (it.hasNext()) {
                    break;
                }
                str2 = str3 + ((String) it.next()) + ",";
            }
            if (str3.lastIndexOf(",") >= 0) {
                str3 = str3.substring(0, str3.lastIndexOf(","));
            }
            str4 = null;
            str5 = null;
            Dl = this.gLA.query("IPCallAddressItem", nMp, "contactId IN " + ("(" + str3 + ")"), null, str4, str5, "upper(sortKey) asc");
        }
        System.currentTimeMillis();
        return Dl;
    }

    private Cursor Dl(String str) {
        return this.gLA.query("IPCallAddressItem", nMp, "systemAddressBookUsername LIKE ? or sortKey LIKE ?", new String[]{"%" + str + "%", "%" + str + "%"}, null, null, "upper(sortKey) asc");
    }

    public final long dA(long j) {
        if (this.gLA instanceof h) {
            return ((h) this.gLA).dA(j);
        }
        return -1;
    }

    public final void dB(long j) {
        if ((this.gLA instanceof h) && j != -1) {
            ((h) this.gLA).fT(j);
        }
    }
}
