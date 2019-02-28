package com.tencent.mm.plugin.bbom;

import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.am;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class q implements r {
    private static List<am> kBu = new ArrayList();
    private boolean kBv;
    private boolean kBw;
    private List<au> kBx;

    public static void a(am amVar) {
        synchronized (kBu) {
            if (!kBu.contains(amVar)) {
                kBu.add(amVar);
            }
        }
    }

    public static void b(am amVar) {
        synchronized (kBu) {
            kBu.remove(amVar);
        }
    }

    public q() {
        this(false);
    }

    public q(boolean z) {
        this.kBv = false;
        this.kBw = false;
        this.kBx = new LinkedList();
        this.kBv = z;
        this.kBw = false;
        this.kBx = new LinkedList();
    }

    public final void arL() {
        final List linkedList = new LinkedList();
        linkedList.addAll(this.kBx);
        this.kBx.clear();
        if (linkedList.size() != 0) {
            List<am> arrayList = new ArrayList();
            synchronized (kBu) {
                for (am add : kBu) {
                    arrayList.add(add);
                }
            }
            for (final am add2 : arrayList) {
                new ag(add2.getLooper()).post(new Runnable() {
                    public final void run() {
                        add2.y(linkedList);
                    }
                });
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(final com.tencent.mm.storage.au r5, final com.tencent.mm.protocal.c.bx r6) {
        /*
        r4 = this;
        r0 = r4.kBv;
        if (r0 == 0) goto L_0x000e;
    L_0x0004:
        r0 = "MicroMsg.SyncMessageNotifier";
        r1 = "mDummy is true, do nothing and return.";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
    L_0x000d:
        return;
    L_0x000e:
        r1 = kBu;
        monitor-enter(r1);
        r0 = kBu;	 Catch:{ all -> 0x0024 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0024 }
        if (r0 == 0) goto L_0x0027;
    L_0x0019:
        r0 = "MicroMsg.SyncMessageNotifier";
        r2 = "no notifiers, ignore";
        com.tencent.mm.sdk.platformtools.x.i(r0, r2);	 Catch:{ all -> 0x0024 }
        monitor-exit(r1);	 Catch:{ all -> 0x0024 }
        goto L_0x000d;
    L_0x0024:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0024 }
        throw r0;
    L_0x0027:
        monitor-exit(r1);	 Catch:{ all -> 0x0024 }
        r0 = r5.field_isSend;
        if (r0 != 0) goto L_0x0031;
    L_0x002c:
        r0 = r5.field_status;
        r1 = 4;
        if (r0 != r1) goto L_0x003b;
    L_0x0031:
        r0 = "MicroMsg.SyncMessageNotifier";
        r1 = "not new msg, ignore";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        goto L_0x000d;
    L_0x003b:
        r0 = r6.vNM;
        r0 = com.tencent.mm.platformtools.n.a(r0);
        com.tencent.mm.y.as.Hm();
        r1 = com.tencent.mm.y.c.Fn();
        r2 = new com.tencent.mm.storage.bc$a;
        r2.<init>(r0);
        r0 = "";
        r0 = r2.Yo(r0);
        r0 = r1.FE(r0);
        if (r0 == 0) goto L_0x006a;
    L_0x005a:
        r0 = r0.ckH();
        if (r0 != 0) goto L_0x006a;
    L_0x0060:
        r0 = "MicroMsg.SyncMessageNotifier";
        r1 = "account no notification";
        com.tencent.mm.sdk.platformtools.x.d(r0, r1);
        goto L_0x000d;
    L_0x006a:
        r0 = r4.kBw;
        if (r0 != 0) goto L_0x00b5;
    L_0x006e:
        r0 = 1;
        r4.kBw = r0;
        r1 = new java.util.ArrayList;
        r1.<init>();
        r2 = kBu;
        monitor-enter(r2);
        r0 = kBu;	 Catch:{ all -> 0x008f }
        r3 = r0.iterator();	 Catch:{ all -> 0x008f }
    L_0x007f:
        r0 = r3.hasNext();	 Catch:{ all -> 0x008f }
        if (r0 == 0) goto L_0x0092;
    L_0x0085:
        r0 = r3.next();	 Catch:{ all -> 0x008f }
        r0 = (com.tencent.mm.y.am) r0;	 Catch:{ all -> 0x008f }
        r1.add(r0);	 Catch:{ all -> 0x008f }
        goto L_0x007f;
    L_0x008f:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x008f }
        throw r0;
    L_0x0092:
        monitor-exit(r2);	 Catch:{ all -> 0x008f }
        r1 = r1.iterator();
    L_0x0097:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x000d;
    L_0x009d:
        r0 = r1.next();
        r0 = (com.tencent.mm.y.am) r0;
        r2 = new com.tencent.mm.sdk.platformtools.ag;
        r3 = r0.getLooper();
        r2.<init>(r3);
        r3 = new com.tencent.mm.plugin.bbom.q$2;
        r3.<init>(r6, r0, r5);
        r2.post(r3);
        goto L_0x0097;
    L_0x00b5:
        r0 = r4.kBx;
        r0.add(r5);
        goto L_0x000d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.bbom.q.a(com.tencent.mm.storage.au, com.tencent.mm.protocal.c.bx):void");
    }
}
