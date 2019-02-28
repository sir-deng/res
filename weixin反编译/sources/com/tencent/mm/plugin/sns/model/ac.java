package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.g.d;
import com.tencent.mm.plugin.sns.g.e;
import com.tencent.mm.plugin.sns.g.f;
import com.tencent.mm.protocal.c.bko;
import com.tencent.mm.protocal.c.bkp;
import com.tencent.mm.protocal.c.bku;
import com.tencent.mm.protocal.c.blf;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.q;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public final class ac {
    String gAM = "";
    private String path;
    private d rbm;
    private List<Integer> rbn = new Vector();
    private Map<String, Integer> rbo = new HashMap();
    private List<Integer> rbp = new Vector();
    private Map<Integer, Integer> rbq = new HashMap();

    public static boolean KM(String str) {
        if (str != null && str.startsWith("_AD_TAG_")) {
            return true;
        }
        return false;
    }

    public ac(String str) {
        this.path = str;
        if (!bvI()) {
            this.rbm = new d();
        }
        this.rbn.clear();
        this.rbo.clear();
    }

    public final synchronized void bvG() {
        if (!ai(this.rbm.rgN)) {
            if (!ai(this.rbm.rgO) && !ai(this.rbm.rgP) && !ai(this.rbm.rgQ)) {
                f fVar;
                long j;
                while (!this.rbm.rgR.isEmpty()) {
                    fVar = (f) this.rbm.rgR.getFirst();
                    if (bi.bz((long) fVar.rgU) <= 21600) {
                        j = fVar.rgW;
                        g.Dr();
                        g.Dp().gRu.a(new q(j, 1), 0);
                        break;
                    }
                    this.rbm.rgR.removeFirst();
                }
                while (!this.rbm.rgS.isEmpty()) {
                    fVar = (f) this.rbm.rgS.getFirst();
                    if (bi.bz((long) fVar.rgU) <= 21600) {
                        j = fVar.rgW;
                        g.Dr();
                        g.Dp().gRu.a(new q(j, 5), 0);
                        break;
                    }
                    this.rbm.rgS.removeFirst();
                }
            }
        }
    }

    private static boolean ai(LinkedList<e> linkedList) {
        while (!linkedList.isEmpty()) {
            e eVar = (e) linkedList.getFirst();
            if (bi.bz((long) eVar.rgU) > 21600) {
                linkedList.removeFirst();
            } else {
                if (KM(eVar.rgT)) {
                    g.Dr();
                    g.Dp().gRu.a(new j(eVar.qZK, eVar.rgT, eVar.rgV), 0);
                } else {
                    g.Dr();
                    g.Dp().gRu.a(new n(eVar.qZK, eVar.rgT), 0);
                }
                return true;
            }
        }
        return false;
    }

    public final synchronized boolean eD(long j) {
        boolean z;
        Iterator it = this.rbm.rgR.iterator();
        while (it.hasNext()) {
            if (((f) it.next()).rgW == j) {
                z = false;
                break;
            }
        }
        z = true;
        return z;
    }

    public final synchronized void eE(long j) {
        f fVar = new f();
        fVar.rgW = j;
        fVar.rgU = (int) bi.Wx();
        this.rbm.rgR.add(fVar);
        bvH();
    }

    final synchronized void eF(long j) {
        Object obj;
        Iterator it = this.rbm.rgR.iterator();
        while (it.hasNext()) {
            obj = (f) it.next();
            if (obj.rgW == j) {
                break;
            }
        }
        obj = null;
        if (obj != null) {
            this.rbm.rgR.remove(obj);
        }
        bvH();
    }

    private static boolean a(LinkedList<bku> linkedList, String str, int i) {
        if (bi.oN(str)) {
            return true;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            bku bku = (bku) it.next();
            if (str.equals(bku.noL) && i == bku.pgR) {
                return true;
            }
        }
        return false;
    }

    public final synchronized blf c(blf blf) {
        if (bi.oN(this.gAM)) {
            this.gAM = q.FY();
        }
        if (!(this.rbm.rgN.size() == 0 && this.rbm.rgO.size() == 0)) {
            e eVar;
            bku bku;
            long j = blf.vWS;
            Iterator it = this.rbm.rgN.iterator();
            while (it.hasNext()) {
                eVar = (e) it.next();
                bku a = a(eVar.qZK);
                if (eVar.qZK.vWS == j && !a(blf.wUR, a.noL, a.pgR)) {
                    blf.wUR.add(a);
                    blf.wUP++;
                }
            }
            Iterator it2 = blf.wUR.iterator();
            while (it2.hasNext()) {
                bku = (bku) it2.next();
                if (bku.vPp.equals(this.gAM)) {
                    Object obj = null;
                    Iterator it3 = this.rbm.rgS.iterator();
                    while (it3.hasNext()) {
                        Object obj2;
                        if (((f) it3.next()).rgW == j) {
                            blf.wUR.remove(bku);
                            blf.wUP--;
                            obj2 = 1;
                        } else {
                            obj2 = obj;
                        }
                        obj = obj2;
                    }
                    if (obj != null) {
                        break;
                    }
                }
            }
            it = this.rbm.rgO.iterator();
            while (it.hasNext()) {
                eVar = (e) it.next();
                if (eVar.qZK.vWS == j) {
                    bku = a(eVar.qZK);
                    if (!a(blf.wUU, bku.noL, bku.pgR)) {
                        blf.wUU.add(bku);
                        blf.wUS++;
                    }
                }
            }
        }
        return blf;
    }

    public static bku a(bkp bkp) {
        bko bko = bkp.wUu;
        bko bko2 = bkp.wUv;
        bku bku = new bku();
        bku.noL = bko.noL;
        bku.pgR = bko.pgR;
        bku.wDh = bko.wUk;
        bku.vON = bko.vON;
        bku.kzz = bko.kzz;
        bku.vPp = bko.wNo;
        bku.wUn = bko.wUn;
        bku.wUq = bko.wUq;
        bku.wUs = bko.wUs;
        bku.wUH = bko2.wNo;
        bku.wUp = bko2.wUp;
        bku.wUm = bko2.wUm;
        return bku;
    }

    public final boolean a(String str, bkp bkp) {
        return a(str, bkp, "");
    }

    public final synchronized boolean a(String str, bkp bkp, String str2) {
        boolean z = true;
        synchronized (this) {
            e eVar = new e();
            eVar.rgT = str;
            eVar.qZK = bkp;
            eVar.rgU = (int) bi.Wx();
            eVar.rgV = str2;
            switch (bkp.wUu.kzz) {
                case 1:
                    this.rbm.rgN.add(eVar);
                    if (eH(bkp.vWS)) {
                        z = false;
                        break;
                    }
                    break;
                case 2:
                    this.rbm.rgO.add(eVar);
                    break;
                case 3:
                    this.rbm.rgP.add(eVar);
                    break;
                case 5:
                    this.rbm.rgQ.add(eVar);
                    break;
                case 7:
                    this.rbm.rgN.add(eVar);
                    if (eH(bkp.vWS)) {
                        z = false;
                        break;
                    }
                    break;
                case 8:
                    this.rbm.rgO.add(eVar);
                    break;
            }
            if (!bvH()) {
                x.e("MicroMsg.SnsAsyncQueueMgr", "error listToFile");
            }
        }
        return z;
    }

    public final void c(long j, int i, String str) {
        ai.bwy();
        d(j, i, str);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void d(long r2, int r4, java.lang.String r5) {
        /*
        r1 = this;
        monitor-enter(r1);
        switch(r4) {
            case 1: goto L_0x0009;
            case 2: goto L_0x0014;
            case 3: goto L_0x002c;
            case 4: goto L_0x0004;
            case 5: goto L_0x0034;
            case 6: goto L_0x0004;
            case 7: goto L_0x001c;
            case 8: goto L_0x0024;
            default: goto L_0x0004;
        };
    L_0x0004:
        r1.bvH();	 Catch:{ all -> 0x0011 }
        monitor-exit(r1);
        return;
    L_0x0009:
        r0 = r1.rbm;	 Catch:{ all -> 0x0011 }
        r0 = r0.rgN;	 Catch:{ all -> 0x0011 }
        a(r2, r0, r5);	 Catch:{ all -> 0x0011 }
        goto L_0x0004;
    L_0x0011:
        r0 = move-exception;
        monitor-exit(r1);
        throw r0;
    L_0x0014:
        r0 = r1.rbm;	 Catch:{ all -> 0x0011 }
        r0 = r0.rgO;	 Catch:{ all -> 0x0011 }
        a(r2, r0, r5);	 Catch:{ all -> 0x0011 }
        goto L_0x0004;
    L_0x001c:
        r0 = r1.rbm;	 Catch:{ all -> 0x0011 }
        r0 = r0.rgN;	 Catch:{ all -> 0x0011 }
        a(r2, r0, r5);	 Catch:{ all -> 0x0011 }
        goto L_0x0004;
    L_0x0024:
        r0 = r1.rbm;	 Catch:{ all -> 0x0011 }
        r0 = r0.rgO;	 Catch:{ all -> 0x0011 }
        a(r2, r0, r5);	 Catch:{ all -> 0x0011 }
        goto L_0x0004;
    L_0x002c:
        r0 = r1.rbm;	 Catch:{ all -> 0x0011 }
        r0 = r0.rgP;	 Catch:{ all -> 0x0011 }
        a(r2, r0, r5);	 Catch:{ all -> 0x0011 }
        goto L_0x0004;
    L_0x0034:
        r0 = r1.rbm;	 Catch:{ all -> 0x0011 }
        r0 = r0.rgQ;	 Catch:{ all -> 0x0011 }
        a(r2, r0, r5);	 Catch:{ all -> 0x0011 }
        goto L_0x0004;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.model.ac.d(long, int, java.lang.String):void");
    }

    private static void a(long j, LinkedList<e> linkedList, String str) {
        a(j, linkedList, str, false);
    }

    private static boolean a(long j, LinkedList<e> linkedList, String str, boolean z) {
        Object obj;
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            obj = (e) it.next();
            if (obj.qZK.vWS == j && (z || obj.rgT.equals(str))) {
                break;
            }
        }
        obj = null;
        if (obj == null) {
            return false;
        }
        linkedList.remove(obj);
        return true;
    }

    public final synchronized boolean eG(long j) {
        boolean z = true;
        synchronized (this) {
            f fVar = new f();
            fVar.rgW = j;
            fVar.rgU = (int) bi.Wx();
            this.rbm.rgS.add(fVar);
            bvH();
            if (a(j, this.rbm.rgN, "", true)) {
                z = false;
            }
        }
        return z;
    }

    final synchronized boolean eH(long j) {
        boolean z;
        Object obj;
        Iterator it = this.rbm.rgS.iterator();
        while (it.hasNext()) {
            obj = (f) it.next();
            if (obj.rgW == j) {
                break;
            }
        }
        obj = null;
        if (obj != null) {
            this.rbm.rgS.remove(obj);
            z = true;
        } else {
            z = false;
        }
        bvH();
        return z;
    }

    private synchronized boolean bvH() {
        boolean z = false;
        synchronized (this) {
            try {
                byte[] toByteArray = this.rbm.toByteArray();
                if (FileOp.b(this.path, toByteArray, toByteArray.length) == 0) {
                    z = true;
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SnsAsyncQueueMgr", e, "listToFile failed: " + this.path, new Object[0]);
                FileOp.deleteFile(this.path);
            }
        }
        return z;
    }

    private synchronized boolean bvI() {
        boolean z;
        byte[] d = FileOp.d(this.path, 0, -1);
        if (d == null) {
            z = false;
        } else {
            try {
                this.rbm = (d) new d().aH(d);
                z = true;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SnsAsyncQueueMgr", e, "", new Object[0]);
                FileOp.deleteFile(this.path);
                z = false;
            }
        }
        return z;
    }

    public final synchronized boolean wS(int i) {
        return this.rbn.contains(Integer.valueOf(i));
    }

    public final synchronized boolean wT(int i) {
        boolean z;
        if (this.rbn.contains(Integer.valueOf(i))) {
            z = false;
        } else {
            this.rbn.add(Integer.valueOf(i));
            z = true;
        }
        return z;
    }

    public final synchronized boolean wU(int i) {
        this.rbn.remove(Integer.valueOf(i));
        return true;
    }

    public final synchronized boolean isDownloading(String str) {
        return this.rbo.containsKey(str);
    }

    public final synchronized boolean KN(String str) {
        boolean z = false;
        synchronized (this) {
            if (!this.rbo.containsKey(str)) {
                this.rbo.put(str, Integer.valueOf(0));
                z = true;
            }
        }
        return z;
    }

    public final synchronized boolean KO(String str) {
        this.rbo.remove(str);
        return true;
    }

    public final synchronized int bvJ() {
        return this.rbo.size();
    }

    public final synchronized boolean wV(int i) {
        boolean z;
        if (this.rbp.contains(Integer.valueOf(i))) {
            z = false;
        } else {
            this.rbp.add(Integer.valueOf(i));
            z = true;
        }
        return z;
    }

    public final synchronized boolean wW(int i) {
        this.rbp.remove(Integer.valueOf(i));
        this.rbq.remove(Integer.valueOf(i));
        return true;
    }

    public final synchronized boolean dy(int i, int i2) {
        this.rbq.put(Integer.valueOf(i), Integer.valueOf(i2));
        return true;
    }

    public final synchronized boolean wX(int i) {
        this.rbq.remove(Integer.valueOf(i));
        return true;
    }

    public final synchronized int wY(int i) {
        int intValue;
        if (this.rbq.containsKey(Integer.valueOf(i))) {
            intValue = ((Integer) this.rbq.get(Integer.valueOf(i))).intValue();
        } else {
            intValue = -1;
        }
        return intValue;
    }
}
