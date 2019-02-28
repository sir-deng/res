package com.tencent.mm.af;

import com.tencent.mm.ac.i;
import com.tencent.mm.ac.n;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.cby;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class h implements e {
    Object hrp = new Object();
    Set<String> hrq = new HashSet();
    public LinkedList<a> hrr = new LinkedList();

    public interface a {
        String Md();

        void c(LinkedList<cby> linkedList);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.af.h.a r7) {
        /*
        r6 = this;
        r1 = r6.hrp;
        monitor-enter(r1);
        r0 = r6.hrr;	 Catch:{ all -> 0x0053 }
        r0 = r0.contains(r7);	 Catch:{ all -> 0x0053 }
        if (r0 != 0) goto L_0x0051;
    L_0x000b:
        r0 = r6.hrr;	 Catch:{ all -> 0x0053 }
        r2 = r0.iterator();	 Catch:{ all -> 0x0053 }
    L_0x0011:
        r0 = r2.hasNext();	 Catch:{ all -> 0x0053 }
        if (r0 == 0) goto L_0x004c;
    L_0x0017:
        r0 = r2.next();	 Catch:{ all -> 0x0053 }
        r0 = (com.tencent.mm.af.h.a) r0;	 Catch:{ all -> 0x0053 }
        if (r7 == 0) goto L_0x0011;
    L_0x001f:
        if (r0 == 0) goto L_0x0011;
    L_0x0021:
        r3 = r7.Md();	 Catch:{ all -> 0x0053 }
        r3 = com.tencent.mm.sdk.platformtools.bi.oM(r3);	 Catch:{ all -> 0x0053 }
        r0 = r0.Md();	 Catch:{ all -> 0x0053 }
        r0 = com.tencent.mm.sdk.platformtools.bi.oM(r0);	 Catch:{ all -> 0x0053 }
        r0 = r3.equals(r0);	 Catch:{ all -> 0x0053 }
        if (r0 == 0) goto L_0x0011;
    L_0x0037:
        r0 = "MicroMsg.BizKFService";
        r2 = "the same callbacker %s, return";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0053 }
        r4 = 0;
        r5 = r7.Md();	 Catch:{ all -> 0x0053 }
        r3[r4] = r5;	 Catch:{ all -> 0x0053 }
        com.tencent.mm.sdk.platformtools.x.i(r0, r2, r3);	 Catch:{ all -> 0x0053 }
        monitor-exit(r1);	 Catch:{ all -> 0x0053 }
    L_0x004b:
        return;
    L_0x004c:
        r0 = r6.hrr;	 Catch:{ all -> 0x0053 }
        r0.add(r7);	 Catch:{ all -> 0x0053 }
    L_0x0051:
        monitor-exit(r1);	 Catch:{ all -> 0x0053 }
        goto L_0x004b;
    L_0x0053:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0053 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.af.h.a(com.tencent.mm.af.h$a):void");
    }

    public final void b(a aVar) {
        synchronized (this.hrp) {
            if (this.hrr.contains(aVar)) {
                this.hrr.remove(aVar);
            }
        }
    }

    public final void af(String str, String str2) {
        if (bi.oN(str) || bi.oN(str2)) {
            x.e("MicroMsg.BizKFService", "doKFGetDefaultList error args, %s, %s", str, str2);
        } else if (this.hrq.contains(str2)) {
            x.i("MicroMsg.BizKFService", "doKFGetInfoList: same is running, %s", str2);
        } else {
            this.hrq.add(str2);
            LinkedList linkedList = new LinkedList();
            linkedList.add(str2);
            k vVar = new v(str, linkedList);
            vVar.tag = str2;
            g.Dp().gRu.a(vVar, 0);
            x.i("MicroMsg.BizKFService", "doKFGetInfoList %s, %s, %d", str, str2, Integer.valueOf(this.hrr.size()));
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.BizKFService", "onSceneEnd errType = %s, errCode = %s, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (kVar == null) {
            x.e("MicroMsg.BizKFService", "scene == null");
            b(null);
        } else if (i == 0 && i2 == 0) {
            x.i("MicroMsg.BizKFService", "scene.getType() = %s", Integer.valueOf(kVar.getType()));
            i JW = n.JW();
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = null;
            long currentTimeMillis = System.currentTimeMillis();
            LinkedList linkedList3;
            Iterator it;
            cby cby;
            com.tencent.mm.ac.h hVar;
            if (kVar.getType() == 672) {
                if (((u) kVar).Mh() == null) {
                    x.e("MicroMsg.BizKFService", "resp is null, type = %s", Integer.valueOf(kVar.getType()));
                    b(null);
                    return;
                }
                linkedList3 = ((u) kVar).Mh().wBD;
                if (linkedList3 == null || linkedList3.size() <= 0) {
                    x.e("MicroMsg.BizKFService", "empty workers");
                    b(null);
                    return;
                }
                it = linkedList3.iterator();
                while (it.hasNext()) {
                    cby = (cby) it.next();
                    linkedList.add(new g(cby.xhQ, ((u) kVar).hrP, cby.nlG, cby.wDh, 1, currentTimeMillis));
                    if (JW != null) {
                        hVar = new com.tencent.mm.ac.h();
                        hVar.username = cby.xhQ;
                        hVar.hnh = cby.nlG;
                        hVar.bC(false);
                        hVar.fWZ = 3;
                        JW.a(hVar);
                        n.JY().jc(cby.xhQ);
                    }
                }
                linkedList2 = linkedList3;
            } else if (kVar.getType() == 675) {
                this.hrq.remove(((v) kVar).tag);
                if (((v) kVar).Mi() == null) {
                    x.e("MicroMsg.BizKFService", "KFGetInfoList resp is null, type = %s", Integer.valueOf(kVar.getType()));
                    b(null);
                    return;
                }
                linkedList3 = ((v) kVar).Mi().wBD;
                if (linkedList3 == null || linkedList3.size() <= 0) {
                    x.e("MicroMsg.BizKFService", "empty workers");
                    b(null);
                    return;
                }
                it = linkedList3.iterator();
                while (it.hasNext()) {
                    cby = (cby) it.next();
                    x.i("MicroMsg.BizKFService", "onScenEnd: workers=%s, tag=%s", cby.xhQ, ((v) kVar).tag);
                    linkedList.add(new g(cby.xhQ, ((v) kVar).hrP, cby.nlG, cby.wDh, ((v) kVar).hrQ, currentTimeMillis));
                    if (JW != null) {
                        hVar = new com.tencent.mm.ac.h();
                        hVar.username = cby.xhQ;
                        hVar.hnh = cby.nlG;
                        hVar.bC(false);
                        hVar.fWZ = 3;
                        JW.a(hVar);
                        n.JY().jc(cby.xhQ);
                    }
                }
                linkedList2 = linkedList3;
            } else if (kVar.getType() == 674) {
                if (((t) kVar).Mg() == null) {
                    x.e("MicroMsg.BizKFService", "resp is null, type = %s", Integer.valueOf(kVar.getType()));
                    b(null);
                    return;
                }
                linkedList3 = ((t) kVar).Mg().wBD;
                if (linkedList3 == null || linkedList3.size() <= 0) {
                    x.e("MicroMsg.BizKFService", "empty workers");
                    b(null);
                    return;
                }
                it = linkedList3.iterator();
                while (it.hasNext()) {
                    cby = (cby) it.next();
                    linkedList.add(new g(cby.xhQ, ((t) kVar).hrP, cby.nlG, cby.wDh, 2, currentTimeMillis));
                    if (JW != null) {
                        hVar = new com.tencent.mm.ac.h();
                        hVar.username = cby.xhQ;
                        hVar.hnh = cby.nlG;
                        hVar.bC(false);
                        hVar.fWZ = 3;
                        JW.a(hVar);
                        n.JY().jc(cby.xhQ);
                    }
                }
                linkedList2 = linkedList3;
            }
            x.i("MicroMsg.BizKFService", "insertOrUpdateBizKFs %d", Integer.valueOf(y.Mk().d(linkedList)));
            b(linkedList2);
        } else {
            x.e("MicroMsg.BizKFService", "scene.getType() = %s", Integer.valueOf(kVar.getType()));
            b(null);
            if (kVar.getType() == 675) {
                this.hrq.remove(((v) kVar).tag);
            }
        }
    }

    private void b(LinkedList<cby> linkedList) {
        synchronized (this.hrp) {
            ArrayList arrayList = new ArrayList(this.hrr);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    a aVar = (a) arrayList.get(i2);
                    if (aVar != null) {
                        aVar.c(linkedList);
                    }
                    i = i2 + 1;
                }
            }
        }
    }
}
