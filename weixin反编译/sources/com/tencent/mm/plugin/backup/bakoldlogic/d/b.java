package com.tencent.mm.plugin.backup.bakoldlogic.d;

import android.os.Looper;
import com.tencent.mm.a.e;
import com.tencent.mm.bl.d;
import com.tencent.mm.bx.f;
import com.tencent.mm.bx.g.a;
import com.tencent.mm.bx.h;
import com.tencent.mm.bx.i;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.f.a.bm;
import com.tencent.mm.f.a.pg;
import com.tencent.mm.f.a.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.o;
import com.tencent.mm.storage.t;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import junit.framework.Assert;

public final class b extends com.tencent.mm.plugin.backup.a.a {
    private static b kxS;
    private static int kxV = 0;
    private c kxT;
    private a kxU;
    private c kxW;

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.d.b$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ Runnable kyb;

        public AnonymousClass2(Runnable runnable) {
            this.kyb = runnable;
        }

        public final void run() {
            x.i("MicroMsg.BakOldTempDbModel", "bakoldRecoverFromTempDb closeTempDB ok");
            x.cfX();
            as.Dt().a(new com.tencent.mm.sdk.platformtools.ah.a() {
                public final boolean JI() {
                    x.i("MicroMsg.BakOldTempDbModel", "bakoldRecoverFromTempDb onPostExecute");
                    AnonymousClass2.this.kyb.run();
                    com.tencent.mm.sdk.b.a.xmy.m(new pg());
                    return false;
                }

                public final boolean JH() {
                    x.i("MicroMsg.BakOldTempDbModel", "bakoldRecoverFromTempDb doInBackground start");
                    x.cfX();
                    b.arw();
                    e.g(new File(com.tencent.mm.plugin.backup.bakoldlogic.a.a.aqP()));
                    a ars = b.this.ars();
                    ars.handler.post(new Runnable() {
                        public final void run() {
                            Iterator it = a.this.kvt.iterator();
                            while (it.hasNext()) {
                                a aVar = (a) it.next();
                                if (aVar.type == 2 && aVar.obj != null && (aVar.obj instanceof String)) {
                                    String str = (String) aVar.obj;
                                    x.d("MicroMsg.BakOldRecoverDelayData", "getContact:" + str);
                                    com.tencent.mm.y.ak.a.hhv.Q(str, "");
                                } else if (aVar.type == 1 && aVar.obj != null && (aVar.obj instanceof String)) {
                                    an.biS().Si((String) aVar.obj);
                                }
                            }
                            a.this.kvt.clear();
                        }
                    });
                    x.i("MicroMsg.BakOldTempDbModel", "bakoldRecoverFromTempDb doInBackground end");
                    x.cfX();
                    return true;
                }

                public final String toString() {
                    return super.toString() + "|bakoldRecoverFromTempDb";
                }
            });
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.d.b$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ long gAc;
        final /* synthetic */ a kxX;
        final /* synthetic */ int kxY = -1;

        AnonymousClass1(long j, a aVar, int i) {
            this.gAc = j;
            this.kxX = aVar;
        }

        public final void run() {
            g.Do().CA();
            x.i("MicroMsg.BakOldTempDbModel", "initTempDB, initTempDBCount:%d  timediff:%d ", Integer.valueOf(b.kxV), Long.valueOf(bi.bA(this.gAc)));
            b.vD();
            as.Dt().a(new com.tencent.mm.sdk.platformtools.ah.a() {
                public final boolean JI() {
                    x.i("MicroMsg.BakOldTempDbModel", "initTempDB onPostExecute");
                    AnonymousClass1.this.kxX.run();
                    b.vE();
                    return false;
                }

                public final boolean JH() {
                    b.arv();
                    b.this.a(new PLong(), new PLong(), new PLong(), AnonymousClass1.this.kxX, AnonymousClass1.this.kxY);
                    return true;
                }

                public final String toString() {
                    return super.toString() + "|initTempDB";
                }
            });
        }
    }

    public static class a implements Runnable {
        public long dbSize = 0;
        public boolean kyf = true;
        public long kyg = 0;
        public long kyh = 0;

        public void run() {
        }
    }

    static /* synthetic */ void arw() {
        long Wy = bi.Wy();
        as.Hm();
        c.EZ();
        StringBuilder stringBuilder = new StringBuilder();
        as.Hm();
        String stringBuilder2 = stringBuilder.append(c.CY()).append(".tem").toString();
        as.Hm();
        k.r(stringBuilder2, c.CY(), false);
        stringBuilder = new StringBuilder();
        as.Hm();
        stringBuilder2 = stringBuilder.append(c.CZ()).append(".tem").toString();
        as.Hm();
        k.r(stringBuilder2, c.CZ(), false);
        stringBuilder = new StringBuilder();
        as.Hm();
        stringBuilder2 = stringBuilder.append(c.CZ()).append(".tem-journal").toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        as.Hm();
        k.r(stringBuilder2, stringBuilder3.append(c.CZ()).append("-journal").toString(), false);
        stringBuilder = new StringBuilder();
        as.Hm();
        stringBuilder2 = stringBuilder.append(c.CZ()).append(".tem-wal").toString();
        stringBuilder3 = new StringBuilder();
        as.Hm();
        k.r(stringBuilder2, stringBuilder3.append(c.CZ()).append("-wal").toString(), false);
        com.tencent.mm.sdk.b.a.xmy.m(new bm());
        g.Do().release();
        g.Do().initialize();
        arv();
        art();
        x.i("MicroMsg.BakOldTempDbModel", "bakoldRecoverFromTempDbImp finish cost time[%d]", Long.valueOf(bi.bA(Wy)));
    }

    static /* synthetic */ int vD() {
        int i = kxV;
        kxV = i + 1;
        return i;
    }

    static /* synthetic */ int vE() {
        int i = kxV;
        kxV = i - 1;
        return i;
    }

    public static b arq() {
        if (kxS == null) {
            com.tencent.mm.plugin.backup.a.a bVar = new b();
            kxS = bVar;
            com.tencent.mm.plugin.backup.a.a.a(bVar);
        }
        return kxS;
    }

    public final void aoN() {
        kxS = null;
    }

    public final c arr() {
        if (this.kxT == null) {
            this.kxT = new c();
        }
        return this.kxT;
    }

    public final a ars() {
        if (this.kxU == null) {
            this.kxU = new a();
        }
        return this.kxU;
    }

    private static void art() {
        com.tencent.mm.sdk.b.a.xmy.m(new z());
    }

    private c aru() {
        if (this.kxW == null) {
            this.kxW = new c();
        }
        return this.kxW;
    }

    public final void a(a aVar) {
        long Wy = bi.Wy();
        x.i("MicroMsg.BakOldTempDbModel", "initTempDB needSyncPauser:%b %s", Boolean.valueOf(false), bi.chl());
        ah.h(new AnonymousClass1(Wy, aVar, -1), 1000);
    }

    private boolean a(PLong pLong, PLong pLong2, PLong pLong3, a aVar, int i) {
        as.Hm();
        c.EZ();
        x.d("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp after close db");
        as.Hm();
        int bN = e.bN(c.CY());
        as.Hm();
        pLong3.value = (long) (bN + e.bN(c.CZ()));
        long j = pLong3.value;
        as.Hm();
        if (com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(j, pLong, pLong2, c.FJ())) {
            as.Hm();
            String CY = c.CY();
            StringBuilder stringBuilder = new StringBuilder();
            as.Hm();
            k.r(CY, stringBuilder.append(c.CY()).append(".tem").toString(), false);
            as.Hm();
            CY = c.CZ();
            stringBuilder = new StringBuilder();
            as.Hm();
            k.r(CY, stringBuilder.append(c.CZ()).append(".tem").toString(), false);
            StringBuilder stringBuilder2 = new StringBuilder();
            as.Hm();
            CY = stringBuilder2.append(c.CZ()).append("-journal").toString();
            stringBuilder = new StringBuilder();
            as.Hm();
            k.r(CY, stringBuilder.append(c.CZ()).append(".tem-journal").toString(), false);
            stringBuilder2 = new StringBuilder();
            as.Hm();
            CY = stringBuilder2.append(c.CZ()).append("-wal").toString();
            stringBuilder = new StringBuilder();
            as.Hm();
            k.r(CY, stringBuilder.append(c.CZ()).append(".tem-wal").toString(), false);
            x.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp before reset account");
            g.Do().release();
            g.Do().initialize();
            x.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp before TemAccStg setAccInfo");
            c aru = aru();
            as.Hm();
            String FJ = c.FJ();
            as.Hm();
            x.i("MicroMsg.BakOldTempStorage", "accPath:%s, accUin:%d", FJ, Integer.valueOf(c.Cn()));
            aru.uin = r2;
            aru.gRT = FJ;
            x.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp before TemAccStg initDB");
            c aru2 = aru();
            stringBuilder2 = new StringBuilder();
            as.Hm();
            FJ = stringBuilder2.append(c.CY()).append(".tem").toString();
            as.Hm();
            int Cn = c.Cn();
            stringBuilder2 = new StringBuilder();
            as.Hm();
            x.i("MicroMsg.BakOldTempStorage", "bakoldInitDB isTempDB:%s  cache:%s uin:%s db:%s %s", aru2.kyk, FJ, Integer.valueOf(Cn), stringBuilder2.append(c.CZ()).append(".tem").toString(), bi.chl());
            if (aru2.gRU != null) {
                x.e("MicroMsg.BakOldTempStorage", "bakoldInitDB dataDB is already init!!!");
            }
            if (i > 0) {
                if (!(aru2.kyk == null || aru2.kyk.booleanValue())) {
                    x.e("MicroMsg.BakOldTempStorage", "bakoldInitDB isTempDB is false!!!");
                    aru2.arx();
                }
                Assert.assertTrue("bakoldInitDB here  isTempDb should null :" + aru2.kyk, aru2.kyk == null);
            }
            aru2.kyk = Boolean.valueOf(true);
            aru2.gRU = new h(new com.tencent.mm.bx.h.a() {
                public final void Di() {
                    if (c.this.kyj != null) {
                        com.tencent.mm.bx.g gVar = c.this.kyj;
                        for (Object obj : gVar.xJN.keySet()) {
                            ((i) gVar.xJN.get(obj)).clL();
                        }
                    }
                }

                public final void Dj() {
                }

                public final void Dk() {
                    if (c.this.kyj != null) {
                        com.tencent.mm.bx.g gVar = c.this.kyj;
                        if (gVar.xJO.size() != 0) {
                            x.i("MicroMsg.MemoryStorage", "attachTable begin stg:%s size:%d", "stg_null", Integer.valueOf(gVar.xJO.size()));
                            if (gVar.xJn == null) {
                                x.e("MicroMsg.MemoryStorage", "attachTable db is null");
                            } else if (gVar.xJL.inTransaction()) {
                                x.w("MicroMsg.MemoryStorage", "attachTable is in transcation ,give up attach table size:%d", Integer.valueOf(gVar.xJO.size()));
                            } else {
                                while (gVar.xJO.size() > 0) {
                                    if (gVar.xJL.inTransaction()) {
                                        x.w("MicroMsg.MemoryStorage", "attachTable is in transcation , break attach table size:%d", Integer.valueOf(gVar.xJO.size()));
                                        return;
                                    }
                                    a aVar = (a) gVar.xJO.peek();
                                    if (aVar == null) {
                                        gVar.xJO.poll();
                                    } else {
                                        String tableName = aVar.getTableName();
                                        if (bi.oN(tableName)) {
                                            x.e("MicroMsg.MemoryStorage", "attachTable Error table Name :%s", tableName);
                                            gVar.xJO.poll();
                                        } else if (f.a(gVar.xJn, tableName)) {
                                            x.e("MicroMsg.MemoryStorage", "attachTable Error Attach table twice :%s", tableName);
                                            gVar.xJO.poll();
                                        } else {
                                            if (gVar.YN(tableName) != 0) {
                                                try {
                                                    if (gVar.vlG) {
                                                        gVar.xJn.execSQL("DETACH DATABASE old");
                                                        x.i("MicroMsg.MemoryStorage", "DETACH DATABASE ");
                                                        gVar.vlG = false;
                                                    }
                                                    if (bi.oN(gVar.xJL.getKey())) {
                                                        gVar.xJn.execSQL("ATTACH DATABASE '" + gVar.xJL.getPath() + "' AS old ");
                                                    } else {
                                                        gVar.xJn.execSQL("ATTACH DATABASE '" + gVar.xJL.getPath() + "' AS old KEY '" + gVar.xJL.getKey() + "'");
                                                    }
                                                    x.i("MicroMsg.MemoryStorage", "ATTACH DATABASE ");
                                                    gVar.vlG = true;
                                                } catch (Throwable e) {
                                                    gVar.vlG = false;
                                                    x.e("MicroMsg.MemoryStorage", "ERROR : attach disk db [%s] , will do again !", e.getMessage());
                                                    x.e("MicroMsg.MemoryStorage", "exception:%s", bi.i(e));
                                                }
                                                if (gVar.YN(tableName) != 0) {
                                                    x.e("MicroMsg.MemoryStorage", "copy table failed :" + tableName);
                                                    return;
                                                }
                                            }
                                            x.i("MicroMsg.MemoryStorage", "attachTable %s succ , waitsize:%d finsize:%d", tableName, Integer.valueOf(gVar.xJO.size()), Integer.valueOf(gVar.xJN.size()));
                                            gVar.xJN.put(tableName, new i(gVar.xJL, tableName));
                                            aVar.a(gVar);
                                            gVar.xJO.poll();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            });
            if (aru2.gRU.a(FJ, r2, "", (long) Cn, q.yL(), new HashMap(), false)) {
                aru2.kvw = new t(aru2.gRU);
                com.tencent.mm.plugin.messenger.foundation.a.i iVar = (com.tencent.mm.plugin.messenger.foundation.a.i) g.h(com.tencent.mm.plugin.messenger.foundation.a.i.class);
                aru2.kvx = iVar.d(aru2.gRU);
                aru2.kvz = iVar.e(aru2.gRU);
                aru2.kvy = iVar.a(aru2.gRU, aru2.kvx, aru2.kvz);
                aru2.kvy.a(new am(aru2.kvy));
                aru2.kvy.a(new o(aru2.kvy));
                aru2.kvC = iVar.f(aru2.gRU);
                aru2.kvA = new com.tencent.mm.ap.g(aru2.gRU);
                if (d.Pu("emoji")) {
                    aru2.kvB = new com.tencent.mm.storage.emotion.d(aru2.gRU);
                }
                aru2.kvE = ((com.tencent.mm.plugin.chatroom.b.b) g.h(com.tencent.mm.plugin.chatroom.b.b.class)).c(aru2.gRU);
                aru2.kvD = new s(aru2.gRU);
                aru2.kvF = new com.tencent.mm.pluginsdk.model.app.k(aru2.gRU);
                aru2.kvG = new com.tencent.mm.pluginsdk.model.app.i(aru2.gRU);
                aru2.kvH = new com.tencent.mm.pluginsdk.model.app.c(aru2.gRU);
                aru2.kyi = new be(aru2.kvw);
                aru2.kyi.c(new com.tencent.mm.sdk.e.j.a() {
                    public final void a(String str, l lVar) {
                        q.eK(str);
                    }
                });
                aru2.kyi.ckI();
                x.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp after TemAccStg initDB");
                art();
                aVar.kyf = true;
                aVar.kyg = pLong.value;
                aVar.kyh = pLong2.value;
                aVar.dbSize = pLong3.value;
                com.tencent.mm.plugin.backup.bakoldlogic.a.a.wf(com.tencent.mm.plugin.backup.bakoldlogic.a.a.aqP());
                return true;
            }
            throw new com.tencent.mm.y.b((byte) 0);
        }
        x.e("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp data free error, len %d", Long.valueOf(pLong3.value));
        aVar.kyf = false;
        aVar.kyg = pLong.value;
        aVar.kyh = pLong2.value;
        aVar.dbSize = pLong3.value;
        return false;
    }

    public static void arv() {
        StringBuilder stringBuilder = new StringBuilder();
        as.Hm();
        com.tencent.mm.loader.stub.b.deleteFile(stringBuilder.append(c.CY()).append(".tem").toString());
        stringBuilder = new StringBuilder();
        as.Hm();
        com.tencent.mm.loader.stub.b.deleteFile(stringBuilder.append(c.CY()).append(".ini.tem").toString());
        stringBuilder = new StringBuilder();
        as.Hm();
        com.tencent.mm.loader.stub.b.deleteFile(stringBuilder.append(c.CZ()).append(".tem").toString());
        stringBuilder = new StringBuilder();
        as.Hm();
        com.tencent.mm.loader.stub.b.deleteFile(stringBuilder.append(c.CZ()).append(".ini.tem").toString());
    }

    public final void a(final Runnable runnable, final int i) {
        if (i < 0 || kxV == 0) {
            if (i < 0) {
                x.e("MicroMsg.BakOldTempDbModel", "closeTempDB no left tryCount!!");
            }
            x.i("MicroMsg.BakOldTempDbModel", "closeDB before");
            aru().arx();
            x.i("MicroMsg.BakOldTempDbModel", "closeDB after");
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        new ag(Looper.getMainLooper()).postDelayed(new Runnable() {
            public final void run() {
                b.this.a(runnable, i - 1);
            }
        }, 500);
    }
}
