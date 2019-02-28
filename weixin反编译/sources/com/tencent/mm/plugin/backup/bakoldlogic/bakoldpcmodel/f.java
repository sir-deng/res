package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.plugin.backup.bakoldlogic.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.c;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.d;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.h.ab;
import com.tencent.mm.plugin.backup.h.t;
import com.tencent.mm.protocal.c.ev;
import com.tencent.mm.protocal.c.ew;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.w;
import com.tencent.mm.y.as;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class f implements com.tencent.mm.ad.f {
    boolean fwD = false;
    boolean hpb = false;
    boolean kpL = false;
    int kwC = 0;
    List<t> kwW;
    List<t> kwX;
    int kwY = 0;
    public boolean kwZ = false;
    HashSet<String> kwv = new HashSet();
    d kww;
    private e kwx;
    boolean kwy = false;
    long kxa;
    long kxb;
    int kxc;
    Object lock = new Object();

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.f$5 */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ int kxf;

        AnonymousClass5(int i) {
            this.kxf = i;
        }

        public final void run() {
            Throwable e;
            com.tencent.mm.plugin.backup.b.e.reset();
            com.tencent.mm.plugin.backup.b.e.aps();
            c cVar = new c();
            cVar.begin();
            HashMap hashMap = new HashMap();
            HashSet hashSet = new HashSet();
            int i = 0;
            for (t tVar : f.this.kwW) {
                int a;
                try {
                    a = f.this.a(a.aqP() + "backupItem/" + a.vT(tVar.ID) + tVar.ID, hashMap, cVar, hashSet);
                    if (a < 0) {
                        cVar.end();
                        x.w("MicroMsg.RecoverPCServer", "Thread has been canceled");
                        return;
                    }
                    a += i;
                    try {
                        f.this.ch(a, this.kxf);
                        x.i("MicroMsg.RecoverPCServer", "recover has done: %d", Integer.valueOf(a));
                        i = a;
                    } catch (Exception e2) {
                        e = e2;
                        x.e("MicroMsg.RecoverPCServer", "Thread.run err:" + e.toString());
                        x.printErrStackTrace("MicroMsg.RecoverPCServer", e, "", new Object[0]);
                        x.f("MicroMsg.RecoverPCServer", "recoverFromSdcard MMThread.run() " + e.toString());
                        i = a;
                    }
                } catch (Throwable e3) {
                    Throwable th = e3;
                    a = i;
                    e = th;
                    x.e("MicroMsg.RecoverPCServer", "Thread.run err:" + e.toString());
                    x.printErrStackTrace("MicroMsg.RecoverPCServer", e, "", new Object[0]);
                    x.f("MicroMsg.RecoverPCServer", "recoverFromSdcard MMThread.run() " + e.toString());
                    i = a;
                }
            }
            com.tencent.mm.plugin.backup.bakoldlogic.d.d.k(hashMap);
            cVar.end();
            f.this.ch(100, 100);
            x.i("MicroMsg.RecoverPCServer", "build temDB finish!");
            x.cfX();
            b arq = b.arq();
            arq.a(new com.tencent.mm.plugin.backup.bakoldlogic.d.b.AnonymousClass2(new Runnable() {
                public final void run() {
                    x.i("MicroMsg.RecoverPCServer", "readFromSdcard end");
                    x.cfX();
                    a.aqS().aqT().kwP = 7;
                    f.this.kwY = 0;
                    if (f.this.kww != null) {
                        f.this.kww.aoR();
                    } else {
                        x.i("MicroMsg.RecoverPCServer", "operatorCallback is null");
                    }
                    e.are();
                    new com.tencent.mm.plugin.backup.bakoldlogic.c.b(8).aqx();
                    x.i("MicroMsg.RecoverPCServer", "recover ok");
                    as.Hm();
                    com.tencent.mm.y.c.Db().a(w.a.USERINFO_BACKUP_OLD_RECORDS_BOOLEAN, Boolean.valueOf(true));
                    c aqU = a.aqS().aqU();
                    aqU.kws++;
                    a.aqS().aqT().kwO = 7;
                    f.this.cancel();
                    com.tencent.mm.plugin.backup.bakoldlogic.d.a ars = b.arq().ars();
                    StringBuffer stringBuffer = new StringBuffer();
                    Iterator it = ars.kvt.iterator();
                    while (it.hasNext()) {
                        a aVar = (a) it.next();
                        if (aVar.type == 2 && aVar.obj != null && (aVar.obj instanceof String)) {
                            stringBuffer.append(aVar.type + " : " + ((String) aVar.obj) + " ,");
                        } else if (aVar.type == 1 && aVar.obj != null && (aVar.obj instanceof String)) {
                            stringBuffer.append(aVar.type + " : " + ((String) aVar.obj) + " ,");
                        }
                    }
                    x.d("MicroMsg.BakOldRecoverDelayData", "dump delay " + stringBuffer.toString());
                }
            }), 10);
        }
    }

    static /* synthetic */ void a(f fVar) {
        com.tencent.mm.plugin.backup.bakoldlogic.c.d dVar;
        com.tencent.mm.a.e.g(new File(a.aqP()));
        fVar.kwx = new e() {
            public final void a(int i, int i2, String str, k kVar) {
                x.i("MicroMsg.RecoverPCServer", "onSceneEnd %s, %d, %d", ((com.tencent.mm.plugin.backup.bakoldlogic.c.d) kVar).id, Integer.valueOf(i), Integer.valueOf(i2));
                synchronized (f.this.lock) {
                    f.this.kwv.remove(r10.id);
                    x.i("MicroMsg.RecoverPCServer", "onSceneEnd left: size:%d", Integer.valueOf(f.this.kwv.size()));
                    if (f.this.kwv.size() <= 10) {
                        f.this.lock.notifyAll();
                    }
                }
                f fVar = f.this;
                fVar.kwC++;
                if (f.this.kwC % 300 == 0) {
                    f.this.ark();
                }
                f.this.arj();
            }
        };
        com.tencent.mm.plugin.backup.f.b.a(7, fVar.kwx);
        for (t tVar : fVar.kwX) {
            if (fVar.fwD && !fVar.hpb) {
                x.i("MicroMsg.RecoverPCServer", "hit pause");
                synchronized (fVar.lock) {
                    try {
                        fVar.lock.wait();
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.RecoverPCServer", e, "", new Object[0]);
                    }
                }
            }
            if (fVar.hpb) {
                x.i("MicroMsg.RecoverPCServer", "backupImp canceled");
                return;
            }
            dVar = new com.tencent.mm.plugin.backup.bakoldlogic.c.d(a.aqP(), tVar.ID, 2, tVar.kzt, fVar, a.aqS().kot);
            synchronized (fVar.lock) {
                dVar.aqx();
                fVar.kwv.add(tVar.ID);
                x.i("MicroMsg.RecoverPCServer", "media recoverImp now: size:%d", Integer.valueOf(fVar.kwv.size()));
                if (fVar.kwv.size() > 10) {
                    try {
                        fVar.lock.wait();
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.RecoverPCServer", e2, "", new Object[0]);
                    }
                }
            }
        }
        for (t tVar2 : fVar.kwW) {
            if (fVar.fwD && !fVar.hpb) {
                x.i("MicroMsg.RecoverPCServer", "hit pause");
                synchronized (fVar.lock) {
                    try {
                        fVar.lock.wait();
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.RecoverPCServer", e22, "", new Object[0]);
                    }
                }
            }
            if (fVar.hpb) {
                x.i("MicroMsg.RecoverPCServer", "backupImp canceled");
                return;
            }
            dVar = new com.tencent.mm.plugin.backup.bakoldlogic.c.d(a.aqP(), tVar2.ID, 1, tVar2.kzt, fVar, a.aqS().kot);
            synchronized (fVar.lock) {
                dVar.aqx();
                fVar.kwv.add(tVar2.ID);
                x.i("MicroMsg.RecoverPCServer", "digest recoverImp now: size:%d", Integer.valueOf(fVar.kwv.size()));
                if (fVar.kwv.size() > 10) {
                    try {
                        fVar.lock.wait();
                    } catch (Throwable e222) {
                        x.printErrStackTrace("MicroMsg.RecoverPCServer", e222, "", new Object[0]);
                    }
                }
            }
        }
        fVar.kwy = true;
        x.i("MicroMsg.RecoverPCServer", "send RestoreData req finish");
        fVar.arj();
    }

    public final void pause() {
        x.i("MicroMsg.RecoverPCServer", "pause");
        this.fwD = true;
    }

    public final void resume() {
        x.i("MicroMsg.RecoverPCServer", "resume");
        this.fwD = false;
        synchronized (this.lock) {
            this.lock.notifyAll();
        }
    }

    public final void cancel() {
        x.i("MicroMsg.RecoverPCServer", "cancel");
        this.hpb = true;
        synchronized (this.lock) {
            this.lock.notifyAll();
        }
        com.tencent.mm.plugin.backup.f.b.b(7, this.kwx);
        this.kww = null;
        this.kwZ = false;
        this.kpL = false;
        this.kwY = 0;
        this.kxc = 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final void arj() {
        /*
        r3 = this;
        r0 = r3.kwy;
        if (r0 == 0) goto L_0x0008;
    L_0x0004:
        r0 = r3.hpb;
        if (r0 == 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r1 = r3.lock;
        monitor-enter(r1);
        r0 = r3.kwv;	 Catch:{ all -> 0x001a }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x001a }
        if (r0 == 0) goto L_0x0059;
    L_0x0014:
        r0 = r3.hpb;	 Catch:{ all -> 0x001a }
        if (r0 == 0) goto L_0x001d;
    L_0x0018:
        monitor-exit(r1);	 Catch:{ all -> 0x001a }
        goto L_0x0008;
    L_0x001a:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001a }
        throw r0;
    L_0x001d:
        r0 = 1;
        r3.kwZ = r0;	 Catch:{ all -> 0x001a }
        r0 = 0;
        r3.kxc = r0;	 Catch:{ all -> 0x001a }
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aqS();	 Catch:{ all -> 0x001a }
        r0 = r0.aqT();	 Catch:{ all -> 0x001a }
        r2 = 6;
        r0.kwO = r2;	 Catch:{ all -> 0x001a }
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aqS();	 Catch:{ all -> 0x001a }
        r0 = r0.aqT();	 Catch:{ all -> 0x001a }
        r2 = 5;
        r0.kwP = r2;	 Catch:{ all -> 0x001a }
        r0 = r3.kww;	 Catch:{ all -> 0x001a }
        if (r0 == 0) goto L_0x005b;
    L_0x003d:
        r0 = r3.kww;	 Catch:{ all -> 0x001a }
        r0.arg();	 Catch:{ all -> 0x001a }
    L_0x0042:
        r0 = 7;
        r2 = r3.kwx;	 Catch:{ all -> 0x001a }
        com.tencent.mm.plugin.backup.f.b.b(r0, r2);	 Catch:{ all -> 0x001a }
        r0 = 0;
        r2 = 0;
        r3.ch(r0, r2);	 Catch:{ all -> 0x001a }
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.are();	 Catch:{ all -> 0x001a }
        r0 = "MicroMsg.RecoverPCServer";
        r2 = "checkRecover publicRestAccUinEven";
        com.tencent.mm.sdk.platformtools.x.i(r0, r2);	 Catch:{ all -> 0x001a }
    L_0x0059:
        monitor-exit(r1);	 Catch:{ all -> 0x001a }
        goto L_0x0008;
    L_0x005b:
        r0 = "MicroMsg.RecoverPCServer";
        r2 = "operatorCallback is null";
        com.tencent.mm.sdk.platformtools.x.i(r0, r2);	 Catch:{ all -> 0x001a }
        goto L_0x0042;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.f.arj():void");
    }

    public static int aj(List<t> list) {
        int i = 0;
        for (t tVar : list) {
            try {
                i = ((ew) new ew().aH(com.tencent.mm.a.e.e(a.aqP() + "backupItem/" + a.vT(tVar.ID) + tVar.ID, 0, -1))).kyB.size() + i;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.RecoverPCServer", e, "", new Object[0]);
            }
        }
        return i;
    }

    final void ch(int i, int i2) {
        int i3 = (int) (i == 0 ? 0 : (((long) i) * 100) / ((long) i2));
        if ((i == 0 && i2 == 0) || i3 > this.kwY) {
            this.kwY = i3;
            if (!(this.fwD || this.hpb || this.kww == null || this.kwY < 0 || this.kwY > 100)) {
                this.kww.np(this.kwY);
            }
            ab abVar = new ab();
            abVar.kym = 13;
            abVar.kzO = 0;
            abVar.kzP = this.kwY;
            try {
                x.i("MicroMsg.RecoverPCServer", "send progress cmd, progress :%d", Integer.valueOf(i3));
                com.tencent.mm.plugin.backup.f.b.G(abVar.toByteArray(), 3);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.RecoverPCServer", e, "", new Object[0]);
                x.e("MicroMsg.RecoverPCServer", "buf to PacketCommandRequest err");
            }
        }
    }

    final int a(String str, HashMap<String, Integer> hashMap, c cVar, HashSet<String> hashSet) {
        Throwable e;
        long currentTimeMillis = System.currentTimeMillis();
        byte[] e2 = com.tencent.mm.a.e.e(str, 0, -1);
        String str2;
        try {
            ew ewVar = (ew) new ew().aH(e2);
            Iterator it = ewVar.kyB.iterator();
            while (it.hasNext()) {
                ev evVar = (ev) it.next();
                if (this.fwD && !this.hpb) {
                    synchronized (this.lock) {
                        try {
                            this.lock.wait();
                        } catch (Throwable e3) {
                            x.printErrStackTrace("MicroMsg.RecoverPCServer", e3, "", new Object[0]);
                        }
                    }
                }
                if (this.hpb) {
                    x.i("MicroMsg.RecoverPCServer", "backupImp canceled");
                    return -1;
                }
                try {
                    String str3 = (String) b.arq().arr().Db().get(2, null);
                    com.tencent.mm.plugin.messenger.foundation.a.a.c Fh = b.arq().arr().Fh();
                    str2 = evVar.vNM.wRo;
                    String str4 = evVar.vNN.wRo;
                    String str5;
                    if (bi.oN(str2) || bi.oN(str4)) {
                        str3 = "MicroMsg.BackupPackMsgLogic";
                        str5 = "recoverMsg fromUserName or toUserName is null, fromUserName[%s], toUserName[%s]";
                        Object[] objArr = new Object[2];
                        if (str2 == null) {
                            str2 = "null";
                        }
                        objArr[0] = str2;
                        if (str4 == null) {
                            str4 = "null";
                        }
                        objArr[1] = str4;
                        x.w(str3, str5, objArr);
                    } else {
                        x.i("MicroMsg.BackupPackMsgLogic", "recoverMsg, type[%d], from[%s], to[%s]", Integer.valueOf(evVar.kzz), str2, str4);
                        com.tencent.mm.plugin.backup.bakoldlogic.d.c arr = b.arq().arr();
                        if (arr.uin == 0) {
                            throw new com.tencent.mm.y.b();
                        }
                        com.tencent.mm.plugin.messenger.foundation.a.a.f fVar = arr.kvC;
                        ar Ff = b.arq().arr().Ff();
                        Object obj = (fVar.has(str2) || str3.equals(str2)) ? 1 : null;
                        str5 = obj != null ? str4 : str2;
                        long j = evVar.vRa != 0 ? evVar.vRa : ((long) evVar.vQS) * 1000;
                        hashSet.add(str5);
                        List ape = a.ape();
                        if (ape.contains(str2) || ape.contains(str4)) {
                            x.w("MicroMsg.BackupPackMsgLogic", "recoverMsg hit the blockList: " + str2 + " " + str4);
                        } else {
                            if (evVar.vNT == 0 && evVar.vNL != 0) {
                                evVar.vNT = (long) evVar.vNL;
                            }
                            if (evVar.vNT != 0) {
                                if (!str3.equals(str2)) {
                                    str4 = str2;
                                }
                                cg G = Fh.G(str4, evVar.vNT);
                                if (G.field_msgId != 0) {
                                    x.i("MicroMsg.BackupPackMsgLogic", "recoverMsg msg exist");
                                } else {
                                    if (evVar.vNT != 0) {
                                        G.ap(evVar.vNT);
                                    }
                                    G.as((long) evVar.vQZ);
                                    G.aq(j);
                                    G.fb(evVar.vRb);
                                    G.setType(evVar.kzz);
                                    ag Xv = Ff.Xv(str5);
                                    if (Xv == null || bi.oN(Xv.field_username) || !Xv.ciN()) {
                                        G.eS(obj != null ? 1 : 0);
                                        G.dU(str5);
                                        G.eR(obj != null ? evVar.vQR : 4);
                                        if (hashMap.get(str5) == null) {
                                            hashMap.put(str5, Integer.valueOf(0));
                                        }
                                        if (obj == null && evVar.vQR == 3) {
                                            hashMap.put(str5, Integer.valueOf(bi.a((Integer) hashMap.get(str5), 0) + 1));
                                        }
                                        com.tencent.mm.plugin.backup.bakoldlogic.b.k ni = com.tencent.mm.plugin.backup.bakoldlogic.b.d.aqR().ni(evVar.kzz);
                                        if (ni == null) {
                                            x.i("MicroMsg.BackupPackMsgLogic", "recoverMsg unknown type");
                                        } else {
                                            ni.a(str3, evVar, G);
                                        }
                                    } else {
                                        x.w("MicroMsg.BackupPackMsgLogic", "recoverMsg hit the blockList: " + str5);
                                    }
                                }
                            } else {
                                x.w("MicroMsg.BackupPackMsgLogic", "recoverMsg drop the item server id < 0");
                            }
                        }
                    }
                    this.kwC++;
                    if (this.kwC % 100 == 0) {
                        ark();
                    }
                } catch (Throwable e32) {
                    x.e("MicroMsg.RecoverPCServer", "readFromSdcard err:" + e32.toString());
                    x.printErrStackTrace("MicroMsg.RecoverPCServer", e32, "", new Object[0]);
                }
                com.tencent.mm.plugin.backup.b.e.mU(evVar.kzz);
                long Wy = bi.Wy();
                if (Wy - cVar.hjl > 10000) {
                    cVar.end();
                    cVar.begin();
                    cVar.hjl = Wy;
                }
            }
            com.tencent.mm.plugin.backup.b.e.apr();
            x.d("MicroMsg.RecoverPCServer", "read item time " + (System.currentTimeMillis() - currentTimeMillis));
            return ewVar.kyB.size();
        } catch (Throwable e4) {
            e32 = e4;
            String str6 = "MicroMsg.RecoverPCServer";
            str2 = "read mmPath errr %s, %s, len:%d";
            Object[] objArr2 = new Object[3];
            objArr2[0] = str;
            objArr2[1] = e32;
            objArr2[2] = Integer.valueOf(e2 == null ? 0 : e2.length);
            x.e(str6, str2, objArr2);
            x.printErrStackTrace("MicroMsg.RecoverPCServer", e32, "", new Object[0]);
            return 0;
        }
    }

    public final void ark() {
        System.gc();
        long freeMemory = Runtime.getRuntime().freeMemory() / 1000;
        long totalMemory = Runtime.getRuntime().totalMemory() / 1000;
        x.i("MicroMsg.RecoverPCServer", "memoryInfo avail/total, dalvik[%dk, %dk, user:%dk], recoverCnt:%d", Long.valueOf(freeMemory), Long.valueOf(totalMemory), Long.valueOf(totalMemory - freeMemory), Integer.valueOf(this.kwC));
    }

    public final void a(int i, int i2, k kVar) {
        this.kxb += (long) i;
        int i3 = this.kxa == 0 ? 0 : (int) ((this.kxb * 100) / this.kxa);
        if (i3 > this.kxc) {
            this.kxc = i3;
            com.tencent.mm.plugin.backup.bakoldlogic.c.d.setProgress(this.kxc);
        }
        if (this.fwD || this.hpb || this.kww == null || this.kxc < 0 || this.kxc > 100) {
            x.d("MicroMsg.RecoverPCServer", "failed to call operatorCallback.onNetProgress:%d", Integer.valueOf(this.kxc));
        } else {
            this.kww.no(this.kxc);
        }
    }
}
