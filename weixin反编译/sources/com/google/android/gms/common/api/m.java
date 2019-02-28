package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.signin.internal.AuthAccountResult;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClientBase;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public final class m implements p {
    final o aKH;
    final Lock aKJ;
    private ConnectionResult aKK;
    private int aKL;
    private int aKM = 0;
    private boolean aKN = false;
    private int aKO;
    private final Bundle aKP = new Bundle();
    private final Set<com.google.android.gms.common.api.a.c> aKQ = new HashSet();
    com.google.android.gms.signin.d aKR;
    private int aKS;
    boolean aKT;
    boolean aKU;
    p aKV;
    boolean aKW;
    boolean aKX;
    private final com.google.android.gms.common.internal.h aKY;
    private final Map<a<?>, Integer> aKZ;
    private final com.google.android.gms.common.b aKg;
    private final com.google.android.gms.common.api.a.a<? extends com.google.android.gms.signin.d, com.google.android.gms.signin.e> aKh;
    private ArrayList<Future<?>> aLa = new ArrayList();
    final Context mContext;

    private abstract class i implements Runnable {
        private i() {
        }

        /* synthetic */ i(m mVar, byte b) {
            this();
        }

        protected abstract void ok();

        public void run() {
            m.this.aKJ.lock();
            try {
                if (!Thread.interrupted()) {
                    ok();
                    m.this.aKJ.unlock();
                }
            } catch (RuntimeException e) {
                o oVar = m.this.aKH;
                oVar.aLv.sendMessage(oVar.aLv.obtainMessage(4, e));
            } finally {
                m.this.aKJ.unlock();
            }
        }
    }

    private class h extends i {
        private final ArrayList<com.google.android.gms.common.api.a.b> aLo;

        public h(ArrayList<com.google.android.gms.common.api.a.b> arrayList) {
            super(m.this, (byte) 0);
            this.aLo = arrayList;
        }

        public final void ok() {
            Iterator it = this.aLo.iterator();
            while (it.hasNext()) {
                ((com.google.android.gms.common.api.a.b) it.next()).a(m.this.aKV);
            }
        }
    }

    private static class b extends com.google.android.gms.common.internal.t.a {
        private final WeakReference<m> aLc;

        b(m mVar) {
            this.aLc = new WeakReference(mVar);
        }

        public final void a(final ResolveAccountResponse resolveAccountResponse) {
            final m mVar = (m) this.aLc.get();
            if (mVar != null) {
                mVar.aKH.a(new b(mVar) {
                    public final void ok() {
                        m mVar = mVar;
                        ResolveAccountResponse resolveAccountResponse = resolveAccountResponse;
                        if (mVar.di(0)) {
                            ConnectionResult connectionResult = resolveAccountResponse.aMa;
                            if (connectionResult.isSuccess()) {
                                mVar.aKV = com.google.android.gms.common.internal.p.a.g(resolveAccountResponse.aMW);
                                mVar.aKU = true;
                                mVar.aKW = resolveAccountResponse.aKW;
                                mVar.aKX = resolveAccountResponse.aNl;
                                mVar.om();
                            } else if (mVar.d(connectionResult)) {
                                mVar.oq();
                                mVar.om();
                            } else {
                                mVar.e(connectionResult);
                            }
                        }
                    }
                });
            }
        }
    }

    private class c extends i {
        private c() {
            super(m.this, (byte) 0);
        }

        /* synthetic */ c(m mVar, byte b) {
            this();
        }

        public final void ok() {
            m.this.aKR.a(m.this.aKV, m.this.aKH.aLz, new a(m.this));
        }
    }

    private class e extends i {
        private final Map<com.google.android.gms.common.api.a.b, d> aLk;

        public e(Map<com.google.android.gms.common.api.a.b, d> map) {
            super(m.this, (byte) 0);
            this.aLk = map;
        }

        public final void ok() {
            int i;
            int i2 = 1;
            int i3 = 0;
            int i4 = 1;
            int i5 = 0;
            for (com.google.android.gms.common.api.a.b bVar : this.aLk.keySet()) {
                if (!bVar.nX()) {
                    i = 0;
                    i4 = i5;
                } else if (((d) this.aLk.get(bVar)).aLj == 0) {
                    i = 1;
                    break;
                } else {
                    i = i4;
                    i4 = 1;
                }
                i5 = i4;
                i4 = i;
            }
            i2 = i5;
            i = 0;
            if (i2 != 0) {
                i3 = com.google.android.gms.common.b.C(m.this.mContext);
            }
            if (i3 == 0 || (r0 == 0 && i4 == 0)) {
                if (m.this.aKT) {
                    m.this.aKR.connect();
                }
                for (com.google.android.gms.common.api.a.b bVar2 : this.aLk.keySet()) {
                    final com.google.android.gms.common.api.c.e eVar = (com.google.android.gms.common.api.c.e) this.aLk.get(bVar2);
                    if (!bVar2.nX() || i3 == 0) {
                        bVar2.a(eVar);
                    } else {
                        m.this.aKH.a(new b(m.this) {
                            public final void ok() {
                                eVar.b(new ConnectionResult(16, null));
                            }
                        });
                    }
                }
                return;
            }
            final ConnectionResult connectionResult = new ConnectionResult(i3, null);
            m.this.aKH.a(new b(m.this) {
                public final void ok() {
                    m.this.e(connectionResult);
                }
            });
        }
    }

    private class g implements com.google.android.gms.common.api.c.b, com.google.android.gms.common.api.c.c {
        private g() {
        }

        /* synthetic */ g(m mVar, byte b) {
            this();
        }

        public final void a(ConnectionResult connectionResult) {
            m.this.aKJ.lock();
            try {
                if (m.this.d(connectionResult)) {
                    m.this.oq();
                    m.this.oo();
                } else {
                    m.this.e(connectionResult);
                }
                m.this.aKJ.unlock();
            } catch (Throwable th) {
                m.this.aKJ.unlock();
            }
        }

        public final void dh(int i) {
        }

        public final void e(Bundle bundle) {
            m.this.aKR.a(new b(m.this));
        }
    }

    private static class a extends com.google.android.gms.signin.internal.b {
        private final WeakReference<m> aLc;

        a(m mVar) {
            this.aLc = new WeakReference(mVar);
        }

        public final void a(final ConnectionResult connectionResult, AuthAccountResult authAccountResult) {
            final m mVar = (m) this.aLc.get();
            if (mVar != null) {
                mVar.aKH.a(new b(mVar) {
                    public final void ok() {
                        m mVar = mVar;
                        ConnectionResult connectionResult = connectionResult;
                        if (!mVar.di(2)) {
                            return;
                        }
                        if (connectionResult.isSuccess()) {
                            mVar.oo();
                        } else if (mVar.d(connectionResult)) {
                            mVar.oq();
                            mVar.oo();
                        } else {
                            mVar.e(connectionResult);
                        }
                    }
                });
            }
        }
    }

    private static class d implements com.google.android.gms.common.api.c.e {
        private final WeakReference<m> aLc;
        private final a<?> aLi;
        final int aLj;

        public d(m mVar, a<?> aVar, int i) {
            this.aLc = new WeakReference(mVar);
            this.aLi = aVar;
            this.aLj = i;
        }

        public final void b(ConnectionResult connectionResult) {
            boolean z = false;
            m mVar = (m) this.aLc.get();
            if (mVar != null) {
                if (Looper.myLooper() == mVar.aKH.aKf) {
                    z = true;
                }
                w.d(z, "onReportServiceBinding must be called on the GoogleApiClient handler thread");
                mVar.aKJ.lock();
                try {
                    if (mVar.di(0)) {
                        if (!connectionResult.isSuccess()) {
                            mVar.b(connectionResult, this.aLi, this.aLj);
                        }
                        if (mVar.ol()) {
                            mVar.om();
                        }
                        mVar.aKJ.unlock();
                    }
                } finally {
                    mVar.aKJ.unlock();
                }
            }
        }

        public final void c(ConnectionResult connectionResult) {
            boolean z = true;
            m mVar = (m) this.aLc.get();
            if (mVar != null) {
                if (Looper.myLooper() != mVar.aKH.aKf) {
                    z = false;
                }
                w.d(z, "onReportAccountValidation must be called on the GoogleApiClient handler thread");
                mVar.aKJ.lock();
                try {
                    if (mVar.di(1)) {
                        if (!connectionResult.isSuccess()) {
                            mVar.b(connectionResult, this.aLi, this.aLj);
                        }
                        if (mVar.ol()) {
                            mVar.on();
                        }
                        mVar.aKJ.unlock();
                    }
                } finally {
                    mVar.aKJ.unlock();
                }
            }
        }
    }

    private class f extends i {
        private final ArrayList<com.google.android.gms.common.api.a.b> aLo;

        public f(ArrayList<com.google.android.gms.common.api.a.b> arrayList) {
            super(m.this, (byte) 0);
            this.aLo = arrayList;
        }

        public final void ok() {
            Set set = m.this.aKH.aLz;
            Set os = set.isEmpty() ? m.this.os() : set;
            Iterator it = this.aLo.iterator();
            while (it.hasNext()) {
                ((com.google.android.gms.common.api.a.b) it.next()).a(m.this.aKV, os);
            }
        }
    }

    public m(o oVar, com.google.android.gms.common.internal.h hVar, Map<a<?>, Integer> map, com.google.android.gms.common.b bVar, com.google.android.gms.common.api.a.a<? extends com.google.android.gms.signin.d, com.google.android.gms.signin.e> aVar, Lock lock, Context context) {
        this.aKH = oVar;
        this.aKY = hVar;
        this.aKZ = map;
        this.aKg = bVar;
        this.aKh = aVar;
        this.aKJ = lock;
        this.mContext = context;
    }

    private void as(boolean z) {
        if (this.aKR != null) {
            if (this.aKR.isConnected() && z) {
                this.aKR.qv();
            }
            this.aKR.disconnect();
            this.aKV = null;
        }
    }

    private static String dj(int i) {
        switch (i) {
            case 0:
                return "STEP_GETTING_SERVICE_BINDINGS";
            case 1:
                return "STEP_VALIDATING_ACCOUNT";
            case 2:
                return "STEP_AUTHENTICATING";
            case 3:
                return "STEP_GETTING_REMOTE_SERVICE";
            default:
                return "UNKNOWN";
        }
    }

    private void op() {
        boolean z = true;
        o oVar = this.aKH;
        oVar.aKJ.lock();
        try {
            oVar.ou();
            oVar.aLA = new l(oVar);
            oVar.aLA.begin();
            oVar.aLp.signalAll();
            q.ov().execute(new Runnable() {
                public final void run() {
                    com.google.android.gms.common.b.D(m.this.mContext);
                }
            });
            if (this.aKR != null) {
                if (this.aKW) {
                    this.aKR.a(this.aKV, this.aKX);
                }
                as(false);
            }
            for (com.google.android.gms.common.api.a.c cVar : this.aKH.aLy.keySet()) {
                ((com.google.android.gms.common.api.a.b) this.aKH.aLx.get(cVar)).disconnect();
            }
            if (this.aKN) {
                this.aKN = false;
                disconnect();
                return;
            }
            Bundle bundle = this.aKP.isEmpty() ? null : this.aKP;
            l lVar = this.aKH.aLq;
            w.d(Looper.myLooper() == lVar.mHandler.getLooper(), "onConnectionSuccess must only be called on the Handler thread");
            synchronized (lVar.aNX) {
                w.at(!lVar.aOv);
                lVar.mHandler.removeMessages(1);
                lVar.aOv = true;
                if (lVar.aOr.size() != 0) {
                    z = false;
                }
                w.at(z);
                ArrayList arrayList = new ArrayList(lVar.aOq);
                int i = lVar.aOu.get();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    com.google.android.gms.common.api.c.b bVar = (com.google.android.gms.common.api.c.b) it.next();
                    if (lVar.aOt && lVar.aOp.isConnected() && lVar.aOu.get() == i) {
                        if (!lVar.aOr.contains(bVar)) {
                            bVar.e(bundle);
                        }
                    }
                }
                lVar.aOr.clear();
                lVar.aOv = false;
            }
        } finally {
            oVar.aKJ.unlock();
        }
    }

    private void or() {
        Iterator it = this.aLa.iterator();
        while (it.hasNext()) {
            ((Future) it.next()).cancel(true);
        }
        this.aLa.clear();
    }

    public final <A extends com.google.android.gms.common.api.a.b, R extends g, T extends com.google.android.gms.common.api.k.a<R, A>> T a(T t) {
        this.aKH.aLr.add(t);
        return t;
    }

    public final void a(ConnectionResult connectionResult, a<?> aVar, int i) {
        if (di(3)) {
            b(connectionResult, aVar, i);
            if (ol()) {
                op();
            }
        }
    }

    public final <A extends com.google.android.gms.common.api.a.b, T extends com.google.android.gms.common.api.k.a<? extends g, A>> T b(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final void b(com.google.android.gms.common.ConnectionResult r5, com.google.android.gms.common.api.a<?> r6, int r7) {
        /*
        r4 = this;
        r3 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r1 = 0;
        r0 = 1;
        r2 = 2;
        if (r7 == r2) goto L_0x0024;
    L_0x0008:
        r6.nT();
        if (r7 != r0) goto L_0x0016;
    L_0x000d:
        r2 = r5.nR();
        if (r2 == 0) goto L_0x0030;
    L_0x0013:
        r2 = r0;
    L_0x0014:
        if (r2 == 0) goto L_0x003c;
    L_0x0016:
        r2 = r4.aKK;
        if (r2 == 0) goto L_0x001e;
    L_0x001a:
        r2 = r4.aKL;
        if (r3 >= r2) goto L_0x003c;
    L_0x001e:
        if (r0 == 0) goto L_0x0024;
    L_0x0020:
        r4.aKK = r5;
        r4.aKL = r3;
    L_0x0024:
        r0 = r4.aKH;
        r0 = r0.aLy;
        r1 = r6.nU();
        r0.put(r1, r5);
        return;
    L_0x0030:
        r2 = r5.aJD;
        r2 = com.google.android.gms.common.b.dd(r2);
        if (r2 == 0) goto L_0x003a;
    L_0x0038:
        r2 = r0;
        goto L_0x0014;
    L_0x003a:
        r2 = r1;
        goto L_0x0014;
    L_0x003c:
        r0 = r1;
        goto L_0x001e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.m.b(com.google.android.gms.common.ConnectionResult, com.google.android.gms.common.api.a, int):void");
    }

    public final void begin() {
        this.aKH.aLq.aOt = true;
        this.aKH.aLy.clear();
        this.aKN = false;
        this.aKT = false;
        this.aKK = null;
        this.aKM = 0;
        this.aKS = 2;
        this.aKU = false;
        this.aKW = false;
        Map hashMap = new HashMap();
        for (a aVar : this.aKZ.keySet()) {
            com.google.android.gms.common.api.a.b bVar = (com.google.android.gms.common.api.a.b) this.aKH.aLx.get(aVar.nU());
            int intValue = ((Integer) this.aKZ.get(aVar)).intValue();
            aVar.nT();
            if (bVar.nW()) {
                this.aKT = true;
                if (intValue < this.aKS) {
                    this.aKS = intValue;
                }
                if (intValue != 0) {
                    this.aKQ.add(aVar.nU());
                }
            }
            hashMap.put(bVar, new d(this, aVar, intValue));
        }
        if (this.aKT) {
            this.aKY.aNS = Integer.valueOf(System.identityHashCode(this.aKH));
            com.google.android.gms.common.api.c.b gVar = new g();
            this.aKR = (com.google.android.gms.signin.d) this.aKh.a(this.mContext, this.aKH.aKf, this.aKY, this.aKY.aNR, gVar, gVar);
        }
        this.aKO = this.aKH.aLx.size();
        this.aLa.add(q.ov().submit(new e(hashMap)));
    }

    public final void connect() {
        this.aKN = false;
    }

    final boolean d(ConnectionResult connectionResult) {
        return this.aKS != 2 ? this.aKS == 1 && !connectionResult.nR() : true;
    }

    public final void dh(int i) {
        e(new ConnectionResult(8, null));
    }

    final boolean di(int i) {
        if (this.aKM == i) {
            return true;
        }
        Log.wtf("GoogleApiClientConnecting", "GoogleApiClient connecting is in step " + dj(this.aKM) + " but received callback for step " + dj(i));
        e(new ConnectionResult(8, null));
        return false;
    }

    public final void disconnect() {
        Iterator it = this.aKH.aLr.iterator();
        while (it.hasNext()) {
            ((e) it.next()).cancel();
            it.remove();
        }
        this.aKH.ot();
        if (this.aKK != null || this.aKH.aLr.isEmpty()) {
            or();
            as(true);
            this.aKH.aLy.clear();
            this.aKH.f(null);
            this.aKH.aLq.oP();
            return;
        }
        this.aKN = true;
    }

    public final void e(Bundle bundle) {
        if (di(3)) {
            if (bundle != null) {
                this.aKP.putAll(bundle);
            }
            if (ol()) {
                op();
            }
        }
    }

    final void e(ConnectionResult connectionResult) {
        boolean z = false;
        this.aKN = false;
        or();
        as(!connectionResult.nR());
        this.aKH.aLy.clear();
        this.aKH.f(connectionResult);
        if (!this.aKH.aLs || !com.google.android.gms.common.b.l(this.mContext, connectionResult.aJD)) {
            this.aKH.ou();
            l lVar = this.aKH.aLq;
            if (Looper.myLooper() == lVar.mHandler.getLooper()) {
                z = true;
            }
            w.d(z, "onConnectionFailure must only be called on the Handler thread");
            lVar.mHandler.removeMessages(1);
            synchronized (lVar.aNX) {
                ArrayList arrayList = new ArrayList(lVar.aOs);
                int i = lVar.aOu.get();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    com.google.android.gms.common.api.c.c cVar = (com.google.android.gms.common.api.c.c) it.next();
                    if (!lVar.aOt || lVar.aOu.get() != i) {
                        break;
                    } else if (lVar.aOs.contains(cVar)) {
                        cVar.a(connectionResult);
                    }
                }
            }
        }
        this.aKH.aLq.oP();
    }

    public final String getName() {
        return TMAssistantDownloadSDKClientBase.CONNTECTSTATE_CONNECTING;
    }

    final boolean ol() {
        this.aKO--;
        if (this.aKO > 0) {
            return false;
        }
        if (this.aKO < 0) {
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.");
            e(new ConnectionResult(8, null));
            return false;
        } else if (this.aKK == null) {
            return true;
        } else {
            e(this.aKK);
            return false;
        }
    }

    final void om() {
        if (this.aKO == 0) {
            if (!this.aKT) {
                oo();
            } else if (this.aKU) {
                ArrayList arrayList = new ArrayList();
                this.aKM = 1;
                this.aKO = this.aKH.aLx.size();
                for (com.google.android.gms.common.api.a.c cVar : this.aKH.aLx.keySet()) {
                    if (!this.aKH.aLy.containsKey(cVar)) {
                        arrayList.add(this.aKH.aLx.get(cVar));
                    } else if (ol()) {
                        on();
                    }
                }
                if (!arrayList.isEmpty()) {
                    this.aLa.add(q.ov().submit(new h(arrayList)));
                }
            }
        }
    }

    final void on() {
        this.aKM = 2;
        this.aKH.aLz = os();
        this.aLa.add(q.ov().submit(new c()));
    }

    final void oo() {
        ArrayList arrayList = new ArrayList();
        this.aKM = 3;
        this.aKO = this.aKH.aLx.size();
        for (com.google.android.gms.common.api.a.c cVar : this.aKH.aLx.keySet()) {
            if (!this.aKH.aLy.containsKey(cVar)) {
                arrayList.add(this.aKH.aLx.get(cVar));
            } else if (ol()) {
                op();
            }
        }
        if (!arrayList.isEmpty()) {
            this.aLa.add(q.ov().submit(new f(arrayList)));
        }
    }

    final void oq() {
        this.aKT = false;
        this.aKH.aLz = Collections.emptySet();
        for (com.google.android.gms.common.api.a.c cVar : this.aKQ) {
            if (!this.aKH.aLy.containsKey(cVar)) {
                this.aKH.aLy.put(cVar, new ConnectionResult(17, null));
            }
        }
    }

    final Set<Scope> os() {
        Set<Scope> hashSet = new HashSet(this.aKY.aJU);
        Map map = this.aKY.aNQ;
        for (a aVar : map.keySet()) {
            if (!this.aKH.aLy.containsKey(aVar.nU())) {
                hashSet.addAll(((com.google.android.gms.common.internal.h.a) map.get(aVar)).aKo);
            }
        }
        return hashSet;
    }
}
