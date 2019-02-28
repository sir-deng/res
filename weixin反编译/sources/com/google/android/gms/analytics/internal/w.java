package com.google.android.gms.analytics.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.analytics.AnalyticsReceiver;
import com.google.android.gms.analytics.AnalyticsService;
import com.google.android.gms.analytics.CampaignTrackingReceiver;
import com.google.android.gms.analytics.CampaignTrackingService;
import com.google.android.gms.analytics.c;
import com.google.android.gms.analytics.d;
import com.google.android.gms.analytics.internal.i.a;
import com.google.android.gms.c.ae;
import com.google.android.gms.c.af;
import com.google.android.gms.c.ah;
import com.google.android.gms.c.ai;
import com.google.android.gms.c.aj;
import com.google.android.gms.c.ak;
import com.google.android.gms.c.g;
import com.google.android.gms.c.h;
import com.google.android.gms.common.internal.f;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;

final class w extends o {
    private final u aGH;
    private final h aGI;
    private final g aGJ;
    private final t aGK;
    private long aGL = Long.MIN_VALUE;
    private final ae aGM;
    private final ae aGN;
    private final j aGO;
    private long aGP;
    private boolean aGQ;
    private boolean oO;

    protected w(q qVar, r rVar) {
        super(qVar);
        com.google.android.gms.common.internal.w.ag(rVar);
        this.aGJ = new g(qVar);
        this.aGH = new u(qVar);
        this.aGI = new h(qVar);
        this.aGK = r.d(qVar);
        this.aGO = new j(this.aFo.aFD);
        this.aGM = new ae(qVar) {
            public final void run() {
                w wVar = w.this;
                wVar.b(new ah() {
                    public final void md() {
                        w.this.nm();
                    }
                });
            }
        };
        this.aGN = new ae(qVar) {
            public final void run() {
                w.a(w.this);
            }
        };
    }

    private void a(s sVar, ak akVar) {
        com.google.android.gms.common.internal.w.ag(sVar);
        com.google.android.gms.common.internal.w.ag(akVar);
        c cVar = new c(this.aFo);
        String str = sVar.aGn;
        com.google.android.gms.common.internal.w.aM(str);
        Uri aG = d.aG(str);
        ListIterator listIterator = cVar.pQ().listIterator();
        while (listIterator.hasNext()) {
            if (aG.equals(((ai) listIterator.next()).nM())) {
                listIterator.remove();
            }
        }
        cVar.pQ().add(new d(cVar.aHf, str));
        cVar.aIn = sVar.aGo;
        ae nL = cVar.nL();
        h hVar = (h) nL.b(h.class);
        hVar.aWo = SlookAirButtonFrequentContactAdapter.DATA;
        hVar.aWt = true;
        nL.b((af) akVar);
        g gVar = (g) nL.b(g.class);
        aj ajVar = (aj) nL.b(aj.class);
        for (Entry entry : sVar.aFb.entrySet()) {
            String str2 = (String) entry.getKey();
            String str3 = (String) entry.getValue();
            if ("an".equals(str2)) {
                ajVar.aEW = str3;
            } else if ("av".equals(str2)) {
                ajVar.aEX = str3;
            } else if ("aid".equals(str2)) {
                ajVar.aYv = str3;
            } else if ("aiid".equals(str2)) {
                ajVar.aYw = str3;
            } else if ("uid".equals(str2)) {
                hVar.aWp = str3;
            } else {
                gVar.aFb.put(g.aX(str2), str3);
            }
        }
        b("Sending installation campaign to", sVar.aGn, akVar);
        nL.aYc = mP().mt();
        ah ahVar = nL.aXZ.aYj;
        if (nL.aYg) {
            throw new IllegalStateException("Measurement prototype can't be submitted");
        } else if (nL.aYa) {
            throw new IllegalStateException("Measurement can only be submitted once");
        } else {
            ae pO = nL.pO();
            pO.aYd = pO.aFD.elapsedRealtime();
            if (pO.aYc != 0) {
                pO.aYb = pO.aYc;
            } else {
                pO.aYb = pO.aFD.currentTimeMillis();
            }
            pO.aYa = true;
            ahVar.aYp.execute(new com.google.android.gms.c.ah.AnonymousClass1(pO));
        }
    }

    static /* synthetic */ void a(w wVar) {
        try {
            wVar.aGH.nd();
            wVar.nm();
        } catch (SQLiteException e) {
            wVar.e("Failed to delete stale hits", e);
        }
        wVar.aGN.Z(86400000);
    }

    private boolean aC(String str) {
        return this.aFo.mContext.checkCallingOrSelfPermission(str) == 0;
    }

    private long ne() {
        ah.mZ();
        mR();
        try {
            return this.aGH.ne();
        } catch (SQLiteException e) {
            f("Failed to get min/max hit times from local store", e);
            return 0;
        }
    }

    private void nk() {
        if (!this.aGQ && ac.nw() && !this.aGK.isConnected()) {
            if (this.aGO.V(((Long) aj.aIg.get()).longValue())) {
                this.aGO.start();
                au("Connecting to service");
                if (this.aGK.connect()) {
                    au("Connected to service");
                    this.aGO.aFE = 0;
                    onServiceConnected();
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean nl() {
        /*
        r12 = this;
        r1 = 1;
        r2 = 0;
        com.google.android.gms.c.ah.mZ();
        r12.mR();
        r0 = "Dispatching a batch of local hits";
        r12.au(r0);
        r0 = r12.aGK;
        r0 = r0.isConnected();
        if (r0 != 0) goto L_0x002e;
    L_0x0016:
        r0 = com.google.android.gms.common.internal.f.aNs;
        if (r0 != 0) goto L_0x002e;
    L_0x001a:
        r0 = r1;
    L_0x001b:
        r3 = r12.aGI;
        r3 = r3.mq();
        if (r3 != 0) goto L_0x0030;
    L_0x0023:
        if (r0 == 0) goto L_0x0032;
    L_0x0025:
        if (r1 == 0) goto L_0x0032;
    L_0x0027:
        r0 = "No network or service available. Will retry later";
        r12.au(r0);
    L_0x002d:
        return r2;
    L_0x002e:
        r0 = r2;
        goto L_0x001b;
    L_0x0030:
        r1 = r2;
        goto L_0x0023;
    L_0x0032:
        r0 = com.google.android.gms.analytics.internal.ac.nA();
        r1 = com.google.android.gms.analytics.internal.ac.nB();
        r0 = java.lang.Math.max(r0, r1);
        r6 = (long) r0;
        r3 = new java.util.ArrayList;
        r3.<init>();
        r0 = 0;
        r4 = r0;
    L_0x0047:
        r0 = r12.aGH;	 Catch:{ all -> 0x01e4 }
        r0.beginTransaction();	 Catch:{ all -> 0x01e4 }
        r3.clear();	 Catch:{ all -> 0x01e4 }
        r0 = r12.aGH;	 Catch:{ SQLiteException -> 0x00cb }
        r8 = r0.X(r6);	 Catch:{ SQLiteException -> 0x00cb }
        r0 = r8.isEmpty();	 Catch:{ SQLiteException -> 0x00cb }
        if (r0 == 0) goto L_0x007a;
    L_0x005b:
        r0 = "Store is empty, nothing to dispatch";
        r12.au(r0);	 Catch:{ SQLiteException -> 0x00cb }
        r12.no();	 Catch:{ SQLiteException -> 0x00cb }
        r0 = r12.aGH;	 Catch:{ SQLiteException -> 0x006f }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x006f }
        r0 = r12.aGH;	 Catch:{ SQLiteException -> 0x006f }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x006f }
        goto L_0x002d;
    L_0x006f:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.f(r1, r0);
        r12.no();
        goto L_0x002d;
    L_0x007a:
        r0 = "Hits loaded from store. count";
        r1 = r8.size();	 Catch:{ SQLiteException -> 0x00cb }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ SQLiteException -> 0x00cb }
        r12.c(r0, r1);	 Catch:{ SQLiteException -> 0x00cb }
        r1 = r8.iterator();	 Catch:{ all -> 0x01e4 }
    L_0x008c:
        r0 = r1.hasNext();	 Catch:{ all -> 0x01e4 }
        if (r0 == 0) goto L_0x00ed;
    L_0x0092:
        r0 = r1.next();	 Catch:{ all -> 0x01e4 }
        r0 = (com.google.android.gms.analytics.internal.c) r0;	 Catch:{ all -> 0x01e4 }
        r10 = r0.aFd;	 Catch:{ all -> 0x01e4 }
        r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1));
        if (r0 != 0) goto L_0x008c;
    L_0x009e:
        r0 = "Database contains successfully uploaded hit";
        r1 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x01e4 }
        r3 = r8.size();	 Catch:{ all -> 0x01e4 }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ all -> 0x01e4 }
        r12.d(r0, r1, r3);	 Catch:{ all -> 0x01e4 }
        r12.no();	 Catch:{ all -> 0x01e4 }
        r0 = r12.aGH;	 Catch:{ SQLiteException -> 0x00bf }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x00bf }
        r0 = r12.aGH;	 Catch:{ SQLiteException -> 0x00bf }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x00bf }
        goto L_0x002d;
    L_0x00bf:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.f(r1, r0);
        r12.no();
        goto L_0x002d;
    L_0x00cb:
        r0 = move-exception;
        r1 = "Failed to read hits from persisted store";
        r12.e(r1, r0);	 Catch:{ all -> 0x01e4 }
        r12.no();	 Catch:{ all -> 0x01e4 }
        r0 = r12.aGH;	 Catch:{ SQLiteException -> 0x00e1 }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x00e1 }
        r0 = r12.aGH;	 Catch:{ SQLiteException -> 0x00e1 }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x00e1 }
        goto L_0x002d;
    L_0x00e1:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.f(r1, r0);
        r12.no();
        goto L_0x002d;
    L_0x00ed:
        r0 = r12.aGK;	 Catch:{ all -> 0x01e4 }
        r0 = r0.isConnected();	 Catch:{ all -> 0x01e4 }
        if (r0 == 0) goto L_0x0156;
    L_0x00f5:
        r0 = com.google.android.gms.common.internal.f.aNs;	 Catch:{ all -> 0x01e4 }
        if (r0 != 0) goto L_0x0156;
    L_0x00f9:
        r0 = "Service connected, sending hits to the service";
        r12.au(r0);	 Catch:{ all -> 0x01e4 }
    L_0x00ff:
        r0 = r8.isEmpty();	 Catch:{ all -> 0x01e4 }
        if (r0 != 0) goto L_0x0156;
    L_0x0105:
        r0 = 0;
        r0 = r8.get(r0);	 Catch:{ all -> 0x01e4 }
        r0 = (com.google.android.gms.analytics.internal.c) r0;	 Catch:{ all -> 0x01e4 }
        r1 = r12.aGK;	 Catch:{ all -> 0x01e4 }
        r1 = r1.d(r0);	 Catch:{ all -> 0x01e4 }
        if (r1 == 0) goto L_0x0156;
    L_0x0114:
        r10 = r0.aFd;	 Catch:{ all -> 0x01e4 }
        r4 = java.lang.Math.max(r4, r10);	 Catch:{ all -> 0x01e4 }
        r8.remove(r0);	 Catch:{ all -> 0x01e4 }
        r1 = "Hit sent do device AnalyticsService for delivery";
        r12.d(r1, r0);	 Catch:{ all -> 0x01e4 }
        r1 = r12.aGH;	 Catch:{ SQLiteException -> 0x0134 }
        r10 = r0.aFd;	 Catch:{ SQLiteException -> 0x0134 }
        r1.Y(r10);	 Catch:{ SQLiteException -> 0x0134 }
        r0 = r0.aFd;	 Catch:{ SQLiteException -> 0x0134 }
        r0 = java.lang.Long.valueOf(r0);	 Catch:{ SQLiteException -> 0x0134 }
        r3.add(r0);	 Catch:{ SQLiteException -> 0x0134 }
        goto L_0x00ff;
    L_0x0134:
        r0 = move-exception;
        r1 = "Failed to remove hit that was send for delivery";
        r12.f(r1, r0);	 Catch:{ all -> 0x01e4 }
        r12.no();	 Catch:{ all -> 0x01e4 }
        r0 = r12.aGH;	 Catch:{ SQLiteException -> 0x014a }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x014a }
        r0 = r12.aGH;	 Catch:{ SQLiteException -> 0x014a }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x014a }
        goto L_0x002d;
    L_0x014a:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.f(r1, r0);
        r12.no();
        goto L_0x002d;
    L_0x0156:
        r0 = r4;
        r4 = r12.aGI;	 Catch:{ all -> 0x01e4 }
        r4 = r4.mq();	 Catch:{ all -> 0x01e4 }
        if (r4 == 0) goto L_0x018b;
    L_0x015f:
        r4 = r12.aGI;	 Catch:{ all -> 0x01e4 }
        r9 = r4.q(r8);	 Catch:{ all -> 0x01e4 }
        r10 = r9.iterator();	 Catch:{ all -> 0x01e4 }
        r4 = r0;
    L_0x016a:
        r0 = r10.hasNext();	 Catch:{ all -> 0x01e4 }
        if (r0 == 0) goto L_0x017f;
    L_0x0170:
        r0 = r10.next();	 Catch:{ all -> 0x01e4 }
        r0 = (java.lang.Long) r0;	 Catch:{ all -> 0x01e4 }
        r0 = r0.longValue();	 Catch:{ all -> 0x01e4 }
        r4 = java.lang.Math.max(r4, r0);	 Catch:{ all -> 0x01e4 }
        goto L_0x016a;
    L_0x017f:
        r8.removeAll(r9);	 Catch:{ all -> 0x01e4 }
        r0 = r12.aGH;	 Catch:{ SQLiteException -> 0x01a9 }
        r0.s(r9);	 Catch:{ SQLiteException -> 0x01a9 }
        r3.addAll(r9);	 Catch:{ SQLiteException -> 0x01a9 }
        r0 = r4;
    L_0x018b:
        r4 = r3.isEmpty();	 Catch:{ all -> 0x01e4 }
        if (r4 == 0) goto L_0x01cb;
    L_0x0191:
        r0 = r12.aGH;	 Catch:{ SQLiteException -> 0x019d }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x019d }
        r0 = r12.aGH;	 Catch:{ SQLiteException -> 0x019d }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x019d }
        goto L_0x002d;
    L_0x019d:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.f(r1, r0);
        r12.no();
        goto L_0x002d;
    L_0x01a9:
        r0 = move-exception;
        r1 = "Failed to remove successfully uploaded hits";
        r12.f(r1, r0);	 Catch:{ all -> 0x01e4 }
        r12.no();	 Catch:{ all -> 0x01e4 }
        r0 = r12.aGH;	 Catch:{ SQLiteException -> 0x01bf }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x01bf }
        r0 = r12.aGH;	 Catch:{ SQLiteException -> 0x01bf }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x01bf }
        goto L_0x002d;
    L_0x01bf:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.f(r1, r0);
        r12.no();
        goto L_0x002d;
    L_0x01cb:
        r4 = r12.aGH;	 Catch:{ SQLiteException -> 0x01d8 }
        r4.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x01d8 }
        r4 = r12.aGH;	 Catch:{ SQLiteException -> 0x01d8 }
        r4.endTransaction();	 Catch:{ SQLiteException -> 0x01d8 }
        r4 = r0;
        goto L_0x0047;
    L_0x01d8:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.f(r1, r0);
        r12.no();
        goto L_0x002d;
    L_0x01e4:
        r0 = move-exception;
        r1 = r12.aGH;	 Catch:{ SQLiteException -> 0x01f0 }
        r1.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x01f0 }
        r1 = r12.aGH;	 Catch:{ SQLiteException -> 0x01f0 }
        r1.endTransaction();	 Catch:{ SQLiteException -> 0x01f0 }
        throw r0;
    L_0x01f0:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.f(r1, r0);
        r12.no();
        goto L_0x002d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.w.nl():boolean");
    }

    private void nn() {
        ag mO = mO();
        if (mO.aHp && !mO.aHq) {
            long ne = ne();
            if (ne != 0 && Math.abs(this.aFo.aFD.currentTimeMillis() - ne) <= ((Long) aj.aHF.get()).longValue()) {
                c("Dispatch alarm scheduled (ms)", Long.valueOf(ac.nz()));
                mO.nJ();
            }
        }
    }

    private void no() {
        if (this.aGM.nH()) {
            au("All hits dispatched or no network/service. Going to power save mode");
        }
        this.aGM.cancel();
        ag mO = mO();
        if (mO.aHq) {
            mO.cancel();
        }
    }

    private long np() {
        if (this.aGL != Long.MIN_VALUE) {
            return this.aGL;
        }
        return this.aFo.mX().mG() ? ((long) this.aFo.mX().mH()) * 1000 : ((Long) aj.aHA.get()).longValue();
    }

    private void nq() {
        mR();
        q.mZ();
        this.aGQ = true;
        this.aGK.disconnect();
        nm();
    }

    public final void aD(String str) {
        com.google.android.gms.common.internal.w.aM(str);
        q.mZ();
        n.mN();
        ak a = k.a(this.aFo.mT(), str);
        if (a == null) {
            e("Parsing failed. Ignoring invalid campaign data", str);
            return;
        }
        CharSequence mx = mP().mx();
        if (str.equals(mx)) {
            ax("Ignoring duplicate install campaign");
        } else if (TextUtils.isEmpty(mx)) {
            mP().aq(str);
            if (mP().mu().V(ac.nG())) {
                e("Campaign received too late, ignoring", a);
                return;
            }
            d("Received installation campaign", a);
            for (s a2 : this.aGH.nf()) {
                a(a2, a);
            }
        } else {
            d("Ignoring multiple install campaigns. original, new", mx, str);
        }
    }

    public final void b(ah ahVar) {
        long j = this.aGP;
        ah.mZ();
        mR();
        long j2 = -1;
        long mv = mP().mv();
        if (mv != 0) {
            j2 = Math.abs(this.aFo.aFD.currentTimeMillis() - mv);
        }
        d("Dispatching local hits. Elapsed time since last dispatch (ms)", Long.valueOf(j2));
        if (!f.aNs) {
            nk();
        }
        try {
            nl();
            mP().mw();
            nm();
            if (ahVar != null) {
                ahVar.md();
            }
            if (this.aGP != j) {
                g gVar = this.aGJ;
                if (VERSION.SDK_INT > 10) {
                    Context context = gVar.aFo.mContext;
                    Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
                    intent.addCategory(context.getPackageName());
                    intent.putExtra(g.aFn, true);
                    context.sendOrderedBroadcast(intent, null);
                }
            }
        } catch (Throwable th) {
            f("Local dispatch failed", th);
            mP().mw();
            nm();
            if (ahVar != null) {
                ahVar.md();
            }
        }
    }

    public final void c(c cVar) {
        com.google.android.gms.common.internal.w.ag(cVar);
        ah.mZ();
        mR();
        if (this.aGQ) {
            av("Hit delivery not possible. Missing network permissions. See http://goo.gl/8Rd3yj for instructions");
        } else {
            c("Delivering hit", cVar);
        }
        if (TextUtils.isEmpty(cVar.k("_m", ""))) {
            Pair pair;
            a aVar = mP().aFA;
            long mz = aVar.mz();
            mz = mz == 0 ? 0 : Math.abs(mz - aVar.aFC.aFo.aFD.currentTimeMillis());
            if (mz < aVar.aFB) {
                pair = null;
            } else if (mz > aVar.aFB * 2) {
                aVar.my();
                pair = null;
            } else {
                String string = aVar.aFC.aFx.getString(aVar.mC(), null);
                long j = aVar.aFC.aFx.getLong(aVar.mB(), 0);
                aVar.my();
                pair = (string == null || j <= 0) ? null : new Pair(string, Long.valueOf(j));
            }
            if (pair != null) {
                String str = ((Long) pair.second) + ":" + ((String) pair.first);
                Map hashMap = new HashMap(cVar.aFb);
                hashMap.put("_m", str);
                cVar = new c(this, hashMap, cVar.aFe, cVar.aFg, cVar.aFd, cVar.aFf, cVar.aFc);
            }
        }
        nk();
        if (this.aGK.d(cVar)) {
            av("Hit sent to the device AnalyticsService for delivery");
        } else if (f.aNs) {
            this.aFo.mT().a(cVar, "Service unavailable on package side");
        } else {
            try {
                this.aGH.e(cVar);
                nm();
            } catch (SQLiteException e) {
                f("Delivery failed to save hit to a database", e);
                this.aFo.mT().a(cVar, "deliver: failed to insert hit to database");
            }
        }
    }

    protected final void c(s sVar) {
        q.mZ();
        d("Sending first hit to property", sVar.aGn);
        if (!mP().mu().V(ac.nG())) {
            String mx = mP().mx();
            if (!TextUtils.isEmpty(mx)) {
                ak a = k.a(this.aFo.mT(), mx);
                d("Found relevant installation campaign", a);
                a(sVar, a);
            }
        }
    }

    public final long d(s sVar) {
        com.google.android.gms.common.internal.w.ag(sVar);
        mR();
        q.mZ();
        try {
            this.aGH.beginTransaction();
            this.aGH.b(sVar.aGl, sVar.aGm);
            long a = this.aGH.a(sVar.aGl, sVar.aGm, sVar.aGn);
            sVar.aGp = 1 + a;
            this.aGH.b(sVar);
            this.aGH.setTransactionSuccessful();
            try {
                this.aGH.endTransaction();
                return a;
            } catch (SQLiteException e) {
                f("Failed to end transaction", e);
                return a;
            }
        } catch (SQLiteException e2) {
            f("Failed to update Analytics property", e2);
            try {
                this.aGH.endTransaction();
            } catch (SQLiteException e22) {
                f("Failed to end transaction", e22);
            }
            return -1;
        } catch (Throwable th) {
            try {
                this.aGH.endTransaction();
            } catch (SQLiteException e3) {
                f("Failed to end transaction", e3);
            }
            throw th;
        }
    }

    public final void mL() {
        ah.mZ();
        mR();
        au("Service disconnected");
    }

    final void mM() {
        q.mZ();
        this.aGP = this.aFo.aFD.currentTimeMillis();
    }

    protected final void mg() {
        this.aGH.mS();
        this.aGI.mS();
        this.aGK.mS();
    }

    protected final void nj() {
        mR();
        mP().mt();
        if (!aC("android.permission.ACCESS_NETWORK_STATE")) {
            ay("Missing required android.permission.ACCESS_NETWORK_STATE. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            nq();
        }
        if (!aC("android.permission.INTERNET")) {
            ay("Missing required android.permission.INTERNET. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            nq();
        }
        if (AnalyticsService.z(this.aFo.mContext)) {
            au("AnalyticsService registered in the app manifest and enabled");
        } else if (f.aNs) {
            ay("Device AnalyticsService not registered! Hits will not be delivered reliably.");
        } else {
            ax("AnalyticsService not registered in the app manifest. Hits might not be delivered reliably. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!(this.aGQ || f.aNs || this.aGH.isEmpty())) {
            nk();
        }
        nm();
    }

    public final void nm() {
        long j = 0;
        q.mZ();
        mR();
        boolean z = !this.aGQ && ((!f.aNs || this.aFo.aFW.nv()) && np() > 0);
        if (!z) {
            this.aGJ.unregister();
            no();
        } else if (this.aGH.isEmpty()) {
            this.aGJ.unregister();
            no();
        } else {
            if (((Boolean) aj.aIb.get()).booleanValue()) {
                z = true;
            } else {
                BroadcastReceiver broadcastReceiver = this.aGJ;
                broadcastReceiver.mp();
                if (!broadcastReceiver.aFp) {
                    Context context = broadcastReceiver.aFo.mContext;
                    context.registerReceiver(broadcastReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    IntentFilter intentFilter = new IntentFilter("com.google.analytics.RADIO_POWERED");
                    intentFilter.addCategory(context.getPackageName());
                    context.registerReceiver(broadcastReceiver, intentFilter);
                    broadcastReceiver.aFq = broadcastReceiver.mq();
                    broadcastReceiver.aFo.mT().c("Registering connectivity change receiver. Network connected", Boolean.valueOf(broadcastReceiver.aFq));
                    broadcastReceiver.aFp = true;
                }
                g gVar = this.aGJ;
                if (!gVar.aFp) {
                    gVar.aFo.mT().ax("Connectivity unknown. Receiver not registered");
                }
                z = gVar.aFq;
            }
            if (z) {
                nn();
                long np = np();
                long mv = mP().mv();
                if (mv != 0) {
                    mv = np - Math.abs(this.aFo.aFD.currentTimeMillis() - mv);
                    if (mv <= 0) {
                        mv = Math.min(ac.ny(), np);
                    }
                } else {
                    mv = Math.min(ac.ny(), np);
                }
                c("Dispatch scheduled (ms)", Long.valueOf(mv));
                if (this.aGM.nH()) {
                    ae aeVar = this.aGM;
                    mv = Math.max(1, mv + (aeVar.aHm == 0 ? 0 : Math.abs(aeVar.aFo.aFD.currentTimeMillis() - aeVar.aHm)));
                    aeVar = this.aGM;
                    if (!aeVar.nH()) {
                        return;
                    }
                    if (mv < 0) {
                        aeVar.cancel();
                        return;
                    }
                    mv -= Math.abs(aeVar.aFo.aFD.currentTimeMillis() - aeVar.aHm);
                    if (mv >= 0) {
                        j = mv;
                    }
                    aeVar.getHandler().removeCallbacks(aeVar.aHl);
                    if (!aeVar.getHandler().postDelayed(aeVar.aHl, j)) {
                        aeVar.aFo.mT().f("Failed to adjust delayed post. time", Long.valueOf(j));
                        return;
                    }
                    return;
                }
                this.aGM.Z(mv);
                return;
            }
            no();
            nn();
        }
    }

    protected final void onServiceConnected() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:29)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:32)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
*/
        /*
        r6 = this;
        com.google.android.gms.analytics.internal.q.mZ();
        r0 = com.google.android.gms.common.internal.f.aNs;
        if (r0 != 0) goto L_0x002a;
    L_0x0007:
        com.google.android.gms.c.ah.mZ();
        r6.mR();
        com.google.android.gms.analytics.internal.n.mN();
        r0 = com.google.android.gms.analytics.internal.ac.nw();
        if (r0 != 0) goto L_0x001c;
    L_0x0016:
        r0 = "Service client disabled. Can't dispatch local hits to device AnalyticsService";
        r6.ax(r0);
    L_0x001c:
        r0 = r6.aGK;
        r0 = r0.isConnected();
        if (r0 != 0) goto L_0x002b;
    L_0x0024:
        r0 = "Service not connected";
        r6.au(r0);
    L_0x002a:
        return;
    L_0x002b:
        r0 = r6.aGH;
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x002a;
    L_0x0033:
        r0 = "Dispatching local hits to device AnalyticsService";
        r6.au(r0);
    L_0x0039:
        r0 = r6.aGH;	 Catch:{ SQLiteException -> 0x004e }
        r1 = com.google.android.gms.analytics.internal.ac.nA();	 Catch:{ SQLiteException -> 0x004e }
        r2 = (long) r1;	 Catch:{ SQLiteException -> 0x004e }
        r1 = r0.X(r2);	 Catch:{ SQLiteException -> 0x004e }
        r0 = r1.isEmpty();	 Catch:{ SQLiteException -> 0x004e }
        if (r0 == 0) goto L_0x0063;	 Catch:{ SQLiteException -> 0x004e }
    L_0x004a:
        r6.nm();	 Catch:{ SQLiteException -> 0x004e }
        goto L_0x002a;
    L_0x004e:
        r0 = move-exception;
        r1 = "Failed to read hits from store";
        r6.f(r1, r0);
        r6.no();
        goto L_0x002a;
    L_0x0059:
        r1.remove(r0);
        r2 = r6.aGH;	 Catch:{ SQLiteException -> 0x007c }
        r4 = r0.aFd;	 Catch:{ SQLiteException -> 0x007c }
        r2.Y(r4);	 Catch:{ SQLiteException -> 0x007c }
    L_0x0063:
        r0 = r1.isEmpty();
        if (r0 != 0) goto L_0x0039;
    L_0x0069:
        r0 = 0;
        r0 = r1.get(r0);
        r0 = (com.google.android.gms.analytics.internal.c) r0;
        r2 = r6.aGK;
        r2 = r2.d(r0);
        if (r2 != 0) goto L_0x0059;
    L_0x0078:
        r6.nm();
        goto L_0x002a;
    L_0x007c:
        r0 = move-exception;
        r1 = "Failed to remove hit that was send for delivery";
        r6.f(r1, r0);
        r6.no();
        goto L_0x002a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.w.onServiceConnected():void");
    }

    final void start() {
        mR();
        com.google.android.gms.common.internal.w.d(!this.oO, "Analytics backend already started");
        this.oO = true;
        if (!f.aNs) {
            Context context = this.aFo.mContext;
            if (!AnalyticsReceiver.y(context)) {
                ax("AnalyticsReceiver is not registered or is disabled. Register the receiver for reliable dispatching on non-Google Play devices. See http://goo.gl/8Rd3yj for instructions.");
            } else if (!AnalyticsService.z(context)) {
                ay("AnalyticsService is not registered or is disabled. Analytics service at risk of not starting. See http://goo.gl/8Rd3yj for instructions.");
            }
            if (!CampaignTrackingReceiver.y(context)) {
                ax("CampaignTrackingReceiver is not registered, not exported or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
            } else if (!CampaignTrackingService.z(context)) {
                ax("CampaignTrackingService is not registered or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
            }
        }
        this.aFo.mU().d(new Runnable() {
            public final void run() {
                w.this.nj();
            }
        });
    }
}
