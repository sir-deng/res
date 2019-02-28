package com.tencent.mm.plugin.backup.f;

import android.os.Looper;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.backup.e.j;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import junit.framework.Assert;

public abstract class b extends k {
    private static final Map<Integer, Set<e>> gLL = new HashMap();
    private static final ag handler = new ag(Looper.getMainLooper());
    static int kor = -1;
    private static int kuA = new Random(System.currentTimeMillis()).nextInt(1147483648);
    private static c kuB = null;
    static final LinkedHashMap<Integer, b> kuu = new LinkedHashMap();
    private static d kuv;
    static a kuw;
    private static f kux = null;
    private static i kuy = null;
    private static g kuz = null;
    PByteArray kut = new PByteArray();

    public interface a {
        void i(int i, byte[] bArr);

        int j(int i, byte[] bArr);
    }

    public interface c {
        void apM();
    }

    public interface d {
        void a(boolean z, int i, byte[] bArr, int i2);
    }

    public interface b {
        void dM(boolean z);
    }

    public abstract com.tencent.mm.bp.a aqo();

    public abstract com.tencent.mm.bp.a aqp();

    public abstract int getType();

    public abstract void nd(int i);

    public static void a(d dVar) {
        kuv = dVar;
    }

    public static void a(a aVar) {
        kuw = aVar;
    }

    public static void mS(int i) {
        kor = i;
    }

    public static int aoV() {
        return kor;
    }

    public static void a(com.tencent.mm.plugin.backup.f.f.a aVar) {
        kux = new f(aVar);
    }

    public static void aqq() {
        boolean z = true;
        if (kux != null) {
            boolean z2;
            f fVar = kux;
            String str = "HeartBeatTimeoutCallback is null";
            if (fVar.krh != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assert.assertTrue(str, z2);
            String str2 = "New BackupHeartBeatHandler EveryTime !";
            if (fVar.kuV != null) {
                z = false;
            }
            Assert.assertTrue(str2, z);
            x.i("MicroMsg.BackupHeartBeatHandler", "start backup heart beat handler.");
            fVar.aqG();
            fVar.kuV = Boolean.valueOf(false);
            com.tencent.mm.sdk.f.e.b(new Runnable() {
                public final void run() {
                    while (!f.this.kuV.booleanValue()) {
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                        }
                        if (f.this.kuV.booleanValue()) {
                            x.i("MicroMsg.BackupHeartBeatHandler", "start BackupSendBackupHeartBeat thread stopped.");
                            return;
                        }
                        long bA = bi.bA(f.this.kuS);
                        x.d("MicroMsg.BackupHeartBeatHandler", "start heartBeatState[%d], heartBeatTimeStamp[%d], timeDiff[%d], hasSendHeartBeat[%b]", Integer.valueOf(f.this.kuR), Long.valueOf(f.this.kuS), Long.valueOf(bA), Boolean.valueOf(f.this.kuU));
                        if (f.this.kuU) {
                            if (bA >= ((long) f.kuQ) && f.this.kuR != 1) {
                                x.e("MicroMsg.BackupHeartBeatHandler", "start weak connect Timeout Now! heartBeatTimeStamp[%d], timeDiff[%d]", Long.valueOf(f.this.kuS), Long.valueOf(bA));
                                f.this.kuR = 1;
                                f.this.krh.mX(1);
                            }
                        } else if (bA < ((long) f.kuP)) {
                            f.this.kuR = 0;
                            f.this.krh.mX(0);
                        } else {
                            x.e("MicroMsg.BackupHeartBeatHandler", "start send heartbeat req, heartBeatTimeStamp[%d], timeDiff[%d]", Long.valueOf(f.this.kuS), Long.valueOf(bA));
                            f.this.aqH();
                            f.this.aqG();
                            f.this.kuU = true;
                        }
                    }
                }
            }, "BackupSendBackupHeartBeat").start();
            fVar.aqH();
            return;
        }
        x.e("MicroMsg.BackupBaseScene", "startHeartBeatHandler backupHeartBeatHandler is null!");
    }

    public static void aqr() {
        if (kux != null) {
            f fVar = kux;
            if (fVar.kuV != null) {
                fVar.kuV = Boolean.valueOf(true);
            }
        }
    }

    public static void a(com.tencent.mm.plugin.backup.f.i.a aVar) {
        kuy = new i(aVar);
    }

    public static void aqs() {
        int i = 0;
        if (kuy != null) {
            i iVar = kuy;
            x.i("MicroMsg.BackupSpeedCalculator", "start backupGetSpeedTimeHandler.");
            iVar.kvi = bi.Wy();
            iVar.kvh = 0;
            iVar.kvf = 0;
            iVar.kvl.clear();
            iVar.kvk = 0;
            iVar.kvj = 0;
            while (i < 10) {
                iVar.kvl.offer(Long.valueOf(0));
                i++;
            }
            iVar.kvm.K(1000, 1000);
            return;
        }
        x.e("MicroMsg.BackupBaseScene", "startSpeedCalculator backupSpeedCalculator is null!");
    }

    public static void aqt() {
        if (kuy != null) {
            i iVar = kuy;
            x.i("MicroMsg.BackupSpeedCalculator", "stop backupGetSpeedTimeHandler.");
            iVar.kvm.TN();
            iVar.kvk = 0;
        }
    }

    public static String aqu() {
        if (kuy == null) {
            return "0B";
        }
        x.i("MicroMsg.BackupSpeedCalculator", "getBackupPcSpeed[%s]", i.bK(kuy.kvg));
        return i.bK(kuy.kvg);
    }

    public static void a(com.tencent.mm.plugin.backup.f.g.a aVar) {
        if (kuz == null) {
            x.i("MicroMsg.BackupBaseScene", "startBackupReconnectHandler, no old backupReconnectHandler is stopped, new one.");
        } else if (kuz.kuZ) {
            x.i("MicroMsg.BackupBaseScene", "startBackupReconnectHandler, old backupReconnectHandler is stopped, new one.");
        } else {
            x.e("MicroMsg.BackupBaseScene", "startBackupReconnectHandler, backupReconnectHandler already running, ignore it.");
            return;
        }
        g gVar = new g(aVar);
        kuz = gVar;
        x.i("MicroMsg.BackupReconnectHandler", "start backupReconnectTimeHandler.");
        g.index = 0;
        gVar.kuZ = false;
        gVar.kuY = 1;
        if (gVar.kuX != null) {
            gVar.kva.K(0, 0);
        }
    }

    public static void aqv() {
        if (kuz != null) {
            kuz.kuY = 0;
            g gVar = kuz;
            if (!gVar.kuZ) {
                x.i("MicroMsg.BackupReconnectHandler", "stop backupReconnectTimeHandler.");
                gVar.kva.TN();
                gVar.kuZ = true;
            }
        }
    }

    public static int aqw() {
        if (kuz == null) {
            return 0;
        }
        return kuz.kuY;
    }

    public static void ne(int i) {
        if (kuz != null) {
            kuz.kuY = i;
        }
    }

    public static void clear() {
        x.i("MicroMsg.BackupBaseScene", "BackupBaseScene clear.");
        synchronized (kuu) {
            kuu.clear();
        }
        synchronized (gLL) {
            gLL.clear();
        }
    }

    public static void a(c cVar) {
        kuB = cVar;
    }

    public static void apM() {
        if (kuB != null) {
            kuB.apM();
        }
    }

    public boolean aqx() {
        try {
            byte[] toByteArray = aqp().toByteArray();
            synchronized (kuu) {
                int aqz = aqz();
                j.a(toByteArray, aqz, (short) getType(), this.kut, kor);
                if (kuw != null) {
                    kuw.i(aqz, this.kut.value);
                }
                x.i("MicroMsg.BackupBaseScene", "doScene sendSeq[%d], type[%d], buflen[%d]", Integer.valueOf(aqz), Integer.valueOf(getType()), Integer.valueOf(this.kut.value.length));
                kuu.put(Integer.valueOf(aqz), this);
            }
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupBaseScene", e, "req to buf fail: " + e.toString(), new Object[0]);
            return false;
        }
    }

    public final boolean aqy() {
        try {
            byte[] toByteArray = aqp().toByteArray();
            synchronized (kuu) {
                int aqz = aqz();
                j.a(toByteArray, aqz, (short) getType(), this.kut, kor);
                if (kuw != null) {
                    kuw.j(aqz, this.kut.value);
                }
                x.i("MicroMsg.BackupBaseScene", "doSceneSameThread sendSeq[%d], type[%d], buflen[%d]", Integer.valueOf(aqz), Integer.valueOf(getType()), Integer.valueOf(this.kut.value.length));
                kuu.put(Integer.valueOf(aqz), this);
            }
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupBaseScene", e, "req to buf fail: " + e.toString(), new Object[0]);
            return false;
        }
    }

    public static boolean G(byte[] bArr, int i) {
        PByteArray pByteArray = new PByteArray();
        synchronized (kuu) {
            int aqz = aqz();
            j.a(bArr, aqz, (short) i, pByteArray, kor);
            if (kuw != null) {
                kuw.i(aqz, pByteArray.value);
            }
            x.i("MicroMsg.BackupBaseScene", "sendBuf sendSeq[%d], type[%d], buflen[%d]", Integer.valueOf(aqz), Integer.valueOf(i), Integer.valueOf(pByteArray.value.length));
        }
        return true;
    }

    public static boolean o(byte[] bArr, int i, int i2) {
        PByteArray pByteArray = new PByteArray();
        j.a(bArr, i2, (short) i, pByteArray, kor);
        if (kuw != null) {
            kuw.i(i2, pByteArray.value);
        }
        x.i("MicroMsg.BackupBaseScene", "sendResp sendSeq[%d], type[%d], len[%d]", Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(pByteArray.value.length));
        return true;
    }

    public static void b(boolean z, int i, int i2, byte[] bArr) {
        String str = "MicroMsg.BackupBaseScene";
        String str2 = "callback receive isLocal[%b], receiveSeq[%d], type[%d], bufLen[%d]";
        Object[] objArr = new Object[4];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        x.i(str, str2, objArr);
        if (z) {
            try {
                x.w("MicroMsg.BackupBaseScene", "callback error buf content : " + (bArr == null ? "null" : new String(bArr)));
            } catch (Exception e) {
            }
            b(z, i2, bArr, i);
            return;
        }
        b bVar;
        if (kux != null) {
            kux.aqG();
            x.d("MicroMsg.BackupBaseScene", "updateHeartBeatTimeStamp type:%d, current time stamp:%d", Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis()));
        }
        synchronized (kuu) {
            bVar = (b) kuu.remove(Integer.valueOf(i));
        }
        if (bVar == null) {
            x.i("MicroMsg.BackupBaseScene", "notify scene null type:%d", Integer.valueOf(i2));
            if (bVar == null && i2 == 16) {
                synchronized (kuu) {
                    Iterator it = new HashSet(kuu.keySet()).iterator();
                    while (it.hasNext()) {
                        Integer num = (Integer) it.next();
                        bVar = (b) kuu.get(num);
                        String str3 = "MicroMsg.BackupBaseScene";
                        String str4 = "callback sceneMap seq:%d scene:%s type:%s";
                        Object[] objArr2 = new Object[3];
                        objArr2[0] = num;
                        objArr2[1] = bVar;
                        if (bVar == null) {
                            str = "null";
                        } else {
                            str = Integer.valueOf(bVar.getType());
                        }
                        objArr2[2] = str;
                        x.d(str3, str4, objArr2);
                        if (bVar != null && bVar.getType() == 15) {
                            kuu.remove(num);
                            try {
                                bVar.aqo().aH(bArr);
                                bVar.nd(i);
                            } catch (Throwable e2) {
                                bVar.f(3, -1, "buf to tagResp fail");
                                x.printErrStackTrace("MicroMsg.BackupBaseScene", e2, "buf to tagResp error, type[%d], errMsg:%s ", Integer.valueOf(bVar.getType()), e2.toString());
                            }
                        }
                    }
                }
                return;
            }
            x.i("MicroMsg.BackupBaseScene", "notify seq:%d, type:%d", Integer.valueOf(i), Integer.valueOf(i2));
            b(z, i2, bArr, i);
        } else if (bArr == null) {
            try {
                throw new Exception("buf is null");
            } catch (Throwable e3) {
                bVar.f(3, -1, "buf to resq fail");
                x.printErrStackTrace("MicroMsg.BackupBaseScene", e3, "%s ", e3.toString());
            }
        } else {
            bVar.aqo().aH(bArr);
            bVar.nd(i);
        }
    }

    public static int aqz() {
        int i = kuA;
        kuA++;
        return i;
    }

    public static void nf(int i) {
        if (kuy != null) {
            i iVar = kuy;
            iVar.kvh = ((long) i) + iVar.kvh;
        }
    }

    private static void b(final boolean z, final int i, final byte[] bArr, final int i2) {
        handler.post(new Runnable() {
            public final void run() {
                if (b.kuv != null) {
                    b.kuv.a(z, i, bArr, i2);
                } else {
                    x.w("MicroMsg.BackupBaseScene", "callbackToNotify, onNotify is null");
                }
            }
        });
    }

    public final void f(final int i, final int i2, final String str) {
        handler.post(new Runnable() {
            public final void run() {
                Set set;
                synchronized (b.gLL) {
                    set = (Set) b.gLL.get(Integer.valueOf(b.this.getType()));
                }
                if (set != null && set.size() > 0) {
                    Set<e> hashSet = new HashSet();
                    hashSet.addAll(set);
                    for (e eVar : hashSet) {
                        if (eVar != null && set.contains(eVar)) {
                            eVar.a(i, i2, str, b.this);
                        }
                    }
                }
            }
        });
    }

    public static void a(int i, e eVar) {
        synchronized (gLL) {
            if (!gLL.containsKey(Integer.valueOf(i))) {
                gLL.put(Integer.valueOf(i), new HashSet());
            }
            if (!((Set) gLL.get(Integer.valueOf(i))).contains(eVar)) {
                ((Set) gLL.get(Integer.valueOf(i))).add(eVar);
            }
        }
    }

    public static void b(int i, e eVar) {
        synchronized (gLL) {
            try {
                if (gLL.get(Integer.valueOf(i)) != null) {
                    ((Set) gLL.get(Integer.valueOf(i))).remove(eVar);
                }
            } catch (Exception e) {
                x.e("MicroMsg.BackupBaseScene", "removeSceneEndListener failed:%s", e);
            }
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        return 0;
    }

    public static void a(final b bVar) {
        handler.postAtFrontOfQueueV2(new Runnable() {
            public final void run() {
                int i = 0;
                synchronized (b.kuu) {
                    long currentTimeMillis = System.currentTimeMillis();
                    for (Entry entry : b.kuu.entrySet()) {
                        int i2;
                        if (entry != null) {
                            try {
                                PByteArray a = ((b) entry.getValue()).kut;
                                if (a != null) {
                                    if (b.kuw != null) {
                                        b.kuw.j(((Integer) entry.getKey()).intValue(), a.value);
                                        x.i("MicroMsg.BackupBaseScene", "resendSceneMap sceneSeq[%d], type[%d], sceneBuf[%d]", entry.getKey(), Integer.valueOf(((b) entry.getValue()).getType()), Integer.valueOf(a.value.length));
                                    } else {
                                        x.e("MicroMsg.BackupBaseScene", "resendSceneMap engineSender null, sceneSeq[%d], type[%d], sceneBuf[%d]", entry.getKey(), Integer.valueOf(((b) entry.getValue()).getType()), Integer.valueOf(a.value.length));
                                    }
                                    i2 = i + 1;
                                } else {
                                    x.e("MicroMsg.BackupBaseScene", "resendSceneMap sceneBuf null, sceneSeq[%d]", entry.getKey());
                                    i2 = i + 1;
                                }
                            } catch (Throwable e) {
                                x.printErrStackTrace("MicroMsg.BackupBaseScene", e, "req to buf fail: " + e.toString(), new Object[0]);
                            }
                        } else {
                            i2 = i;
                        }
                        if (i2 > 0) {
                            if (i2 % 5 == 0) {
                                bVar.dM(false);
                            }
                        }
                        i = i2;
                    }
                    bVar.dM(true);
                    x.i("MicroMsg.BackupBaseScene", "resendSceneMap finish, sceneMap[%d], time[%d]", Integer.valueOf(b.kuu.size()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                }
            }
        });
    }
}
