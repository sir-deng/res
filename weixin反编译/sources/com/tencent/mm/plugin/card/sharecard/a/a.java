package com.tencent.mm.plugin.card.sharecard.a;

import android.os.Looper;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.card.base.d;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.h;
import com.tencent.mm.plugin.card.sharecard.model.n;
import com.tencent.mm.plugin.card.sharecard.model.o;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class a implements e {
    public byte[] gUq = new byte[0];
    public List<n> kOd = am.avq().ave();
    public List<n> kOe = new ArrayList();
    private List<WeakReference<d>> kOg = new ArrayList();
    public com.tencent.mm.plugin.card.sharecard.model.e kSE;
    private int kSF = 0;
    public int kSG = 5;
    public ag mHandler = new ag(Looper.getMainLooper());
    private Runnable mRunnable = new Runnable() {
        public final void run() {
            x.i("MicroMsg.ShareCardBatchGetCardMgr", "doShareCardSyncNetScene after 5s");
            as.CN().a(new h(), 0);
        }
    };

    public a() {
        x.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr <init>, init pending list size = %d", Integer.valueOf(this.kOd.size()));
        as.CN().a(903, (e) this);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void auv() {
        /*
        r5 = this;
        r4 = 10;
        r2 = 0;
        r0 = new java.util.LinkedList;
        r0.<init>();
        r1 = r5.gUq;
        monitor-enter(r1);
        r3 = r5.kOd;	 Catch:{ all -> 0x0032 }
        r3 = r3.size();	 Catch:{ all -> 0x0032 }
        if (r3 != 0) goto L_0x001e;
    L_0x0013:
        r0 = "MicroMsg.ShareCardBatchGetCardMgr";
        r2 = "scsmgr getNow, no pending cardinfo ,no need to get";
        com.tencent.mm.sdk.platformtools.x.i(r0, r2);	 Catch:{ all -> 0x0032 }
        monitor-exit(r1);	 Catch:{ all -> 0x0032 }
    L_0x001d:
        return;
    L_0x001e:
        r3 = r5.kOd;	 Catch:{ all -> 0x0032 }
        r0.addAll(r3);	 Catch:{ all -> 0x0032 }
        monitor-exit(r1);	 Catch:{ all -> 0x0032 }
        r1 = r5.kSE;
        if (r1 == 0) goto L_0x0035;
    L_0x0028:
        r0 = "MicroMsg.ShareCardBatchGetCardMgr";
        r1 = "scsmgr getNow, already doing scene, not trigger now";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        goto L_0x001d;
    L_0x0032:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0032 }
        throw r0;
    L_0x0035:
        r3 = new java.util.LinkedList;
        r3.<init>();
        r1 = r0.size();
        if (r1 > r4) goto L_0x005e;
    L_0x0040:
        r3.addAll(r0);
    L_0x0043:
        r4 = new java.util.LinkedList;
        r4.<init>();
        r1 = r2;
    L_0x0049:
        r0 = r3.size();
        if (r1 >= r0) goto L_0x0066;
    L_0x004f:
        r0 = r3.get(r1);
        r0 = (com.tencent.mm.plugin.card.sharecard.model.n) r0;
        r0 = r0.field_card_id;
        r4.add(r0);
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0049;
    L_0x005e:
        r0 = r0.subList(r2, r4);
        r3.addAll(r0);
        goto L_0x0043;
    L_0x0066:
        r0 = new com.tencent.mm.plugin.card.sharecard.model.e;
        r0.<init>(r4);
        r5.kSE = r0;
        r0 = com.tencent.mm.y.as.CN();
        r1 = r5.kSE;
        r0.a(r1, r2);
        goto L_0x001d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.card.sharecard.a.a.auv():void");
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr onSceneEnd, errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
        this.kSE = null;
        List<n> F;
        o avq;
        if (i == 0 && i2 == 0) {
            F = F(((com.tencent.mm.plugin.card.sharecard.model.e) kVar).kRE);
            x.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr onSceneEnd, batch get succ, remove succ id list, size = %d", Integer.valueOf(F.size()));
            synchronized (this.gUq) {
                this.kOd.removeAll(F);
            }
            long currentTimeMillis = System.currentTimeMillis();
            as.Hm();
            long dA = c.Fc().dA(Thread.currentThread().getId());
            avq = am.avq();
            if (F.size() == 0) {
                x.e("MicroMsg.ShareCardSyncItemInfoStorage", "deleteList fail, share card list is empty");
            } else {
                for (n nVar : F) {
                    if (nVar != null) {
                        avq.a((com.tencent.mm.sdk.e.c) nVar, new String[0]);
                    }
                }
            }
            as.Hm();
            c.Fc().fT(dA);
            x.i("MicroMsg.ShareCardBatchGetCardMgr", "onSceneEnd do transaction use time %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            auv();
            asP();
            return;
        }
        x.e("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr onSceneEnd fail, stop batch get, errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
        F = F(((com.tencent.mm.plugin.card.sharecard.model.e) kVar).kRD);
        synchronized (this.gUq) {
            if (F.size() > 0) {
                this.kOd.removeAll(F);
                this.kOe.addAll(F);
            }
        }
        avq = am.avq();
        if (F.size() == 0) {
            x.e("MicroMsg.ShareCardSyncItemInfoStorage", "increaseRetryCount fail, share card list is empty");
            return;
        }
        for (n nVar2 : F) {
            if (nVar2 != null) {
                nVar2.field_retryCount++;
                avq.c(nVar2, new String[0]);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.ArrayList<com.tencent.mm.plugin.card.sharecard.model.n> F(java.util.LinkedList<java.lang.String> r8) {
        /*
        r7 = this;
        r3 = 0;
        r5 = new java.util.ArrayList;
        r5.<init>();
        r6 = new java.util.LinkedList;
        r6.<init>();
        r1 = r7.gUq;
        monitor-enter(r1);
        r0 = r7.kOd;	 Catch:{ all -> 0x005d }
        r0 = r0.size();	 Catch:{ all -> 0x005d }
        if (r0 != 0) goto L_0x0022;
    L_0x0016:
        r0 = "MicroMsg.ShareCardBatchGetCardMgr";
        r2 = "getSuccessShareCardSyncItem pendingList size is 0";
        com.tencent.mm.sdk.platformtools.x.e(r0, r2);	 Catch:{ all -> 0x005d }
        monitor-exit(r1);	 Catch:{ all -> 0x005d }
        r0 = r5;
    L_0x0021:
        return r0;
    L_0x0022:
        r0 = r7.kOd;	 Catch:{ all -> 0x005d }
        r6.addAll(r0);	 Catch:{ all -> 0x005d }
        monitor-exit(r1);	 Catch:{ all -> 0x005d }
        r2 = r3;
    L_0x0029:
        r0 = r8.size();
        if (r2 >= r0) goto L_0x0064;
    L_0x002f:
        r0 = r8.get(r2);
        r0 = (java.lang.String) r0;
        r4 = r3;
    L_0x0036:
        r1 = r6.size();
        if (r4 >= r1) goto L_0x0060;
    L_0x003c:
        if (r0 == 0) goto L_0x0059;
    L_0x003e:
        r1 = r6.get(r4);
        if (r1 == 0) goto L_0x0059;
    L_0x0044:
        r1 = r6.get(r4);
        r1 = (com.tencent.mm.plugin.card.sharecard.model.n) r1;
        r1 = r1.field_card_id;
        r1 = r0.equals(r1);
        if (r1 == 0) goto L_0x0059;
    L_0x0052:
        r1 = r6.get(r4);
        r5.add(r1);
    L_0x0059:
        r1 = r4 + 1;
        r4 = r1;
        goto L_0x0036;
    L_0x005d:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x005d }
        throw r0;
    L_0x0060:
        r0 = r2 + 1;
        r2 = r0;
        goto L_0x0029;
    L_0x0064:
        r0 = r5;
        goto L_0x0021;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.card.sharecard.a.a.F(java.util.LinkedList):java.util.ArrayList<com.tencent.mm.plugin.card.sharecard.model.n>");
    }

    public final void avy() {
        int i;
        x.i("MicroMsg.ShareCardBatchGetCardMgr", "doShareCardSyncNetScene");
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int i2 = currentTimeMillis - this.kSF;
        if (this.kSG <= 0) {
            i = 5;
        } else {
            i = this.kSG;
        }
        if (i2 >= i) {
            as.CN().a(new h(), 0);
        } else {
            x.i("MicroMsg.ShareCardBatchGetCardMgr", "sync interval is " + i2);
            this.mHandler.removeCallbacks(this.mRunnable);
            this.mHandler.postDelayed(this.mRunnable, (long) (i * 1000));
        }
        this.kSF = currentTimeMillis;
    }

    public final void asP() {
        if (this.kOg != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.kOg.size()) {
                    WeakReference weakReference = (WeakReference) this.kOg.get(i2);
                    if (weakReference != null) {
                        d dVar = (d) weakReference.get();
                        if (dVar != null) {
                            dVar.aut();
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public final void a(d dVar) {
        if (this.kOg == null) {
            this.kOg = new ArrayList();
        }
        if (dVar != null) {
            this.kOg.add(new WeakReference(dVar));
        }
    }

    public final void b(d dVar) {
        if (this.kOg != null && dVar != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.kOg.size()) {
                    WeakReference weakReference = (WeakReference) this.kOg.get(i2);
                    if (weakReference != null) {
                        d dVar2 = (d) weakReference.get();
                        if (dVar2 != null && dVar2.equals(dVar)) {
                            this.kOg.remove(weakReference);
                            return;
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
