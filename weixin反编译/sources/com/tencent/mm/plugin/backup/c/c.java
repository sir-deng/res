package com.tencent.mm.plugin.backup.c;

import android.content.Intent;
import android.database.Cursor;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.backup.a.b.d;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.plugin.backup.f.j;
import com.tencent.mm.plugin.backup.h.aa;
import com.tencent.mm.plugin.backup.h.af;
import com.tencent.mm.plugin.backup.h.ag;
import com.tencent.mm.plugin.backup.h.f;
import com.tencent.mm.plugin.backup.h.i;
import com.tencent.mm.plugin.backup.h.o;
import com.tencent.mm.plugin.backup.h.y;
import com.tencent.mm.plugin.backup.h.z;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.c.abk;
import com.tencent.mm.protocal.c.pd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.m;
import com.tencent.mm.storage.n;
import com.tencent.mm.y.as;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class c implements d, b.d {
    private static int hmE = 0;
    private static boolean kqL = false;
    private static boolean kqM = false;
    private static boolean kra = false;
    String ffG;
    private long fxb = 0;
    private boolean hpb = false;
    public d kpP;
    private boolean kpU = false;
    private com.tencent.mm.plugin.backup.b.d kqC;
    private LinkedList<String> kqD;
    private LinkedList<Long> kqE;
    private LinkedList<String> kqF;
    private LinkedList<Long> kqG;
    public com.tencent.mm.plugin.backup.a.b.a kqH;
    private HashSet<String> kqI = new HashSet();
    private long kqJ = 0;
    private long kqK = 0;
    private boolean kqN = true;
    private HashSet<String> kqO = new HashSet();
    private int kqP = 0;
    public boolean kqQ = false;
    private boolean kqR = true;
    private boolean kqS = true;
    private boolean kqT = false;
    private boolean kqU = false;
    private int kqV;
    public String kqW;
    String kqX;
    int kqY;
    private al kqZ;
    final e krb = new e() {
        public final void a(int i, int i2, String str, k kVar) {
            as.CN().b(595, c.this.krb);
            if (i == 0 && i2 == 0) {
                abk aqF = ((com.tencent.mm.plugin.backup.f.e) kVar).aqF();
                as.Hm();
                if (bi.oM((String) com.tencent.mm.y.c.Db().get(2, null)).equals(aqF.vQI)) {
                    String str2;
                    b.apy().kon = aqF.ID;
                    b.apy().koo = aqF.vQP;
                    b.apy().kop = aqF.vQQ;
                    b.a(c.this.krg);
                    b.apy().aoT();
                    b.a(b.apy().apB());
                    b.a(b.apy().apz());
                    b.mS(2);
                    b.a(c.this.kri);
                    b.a(c.this.krh);
                    int i3 = 0;
                    if (aqF.vQF > 0) {
                        pd pdVar = (pd) aqF.vQG.getFirst();
                        String str3 = pdVar.weK;
                        i3 = ((Integer) pdVar.weL.getFirst()).intValue();
                        str2 = str3;
                    } else {
                        x.e("MicroMsg.BackupMoveRecoverServer", "summerbak address convMsgCount is empty");
                        str2 = null;
                    }
                    c cVar = c.this;
                    cVar.kqW = aqF.vQJ;
                    cVar.kqX = str2;
                    cVar.kqY = i3;
                    x.i("MicroMsg.BackupMoveRecoverServer", "summerbak getconnetinfo, type:%d, scene:%d, wifiName:%s, ip:%s, port:%d", Integer.valueOf(aqF.kzz), Integer.valueOf(aqF.sfa), aqF.vQJ, str2, Integer.valueOf(i3));
                    com.tencent.mm.plugin.backup.a.d.mS(22);
                    b.apy().aoS().kov = 1;
                    Intent className = new Intent().setClassName(ad.getContext(), "com.tencent.mm.ui.LauncherUI");
                    className.addFlags(335544320);
                    className.putExtra("nofification_type", "backup_move_notification");
                    ad.getContext().startActivity(className);
                    g.pWK.a(485, 41, 1, false);
                    c.kra = false;
                    x.i("MicroMsg.BackupMoveRecoverServer", "summerbak try connct old phone, oldphone ip:%s, oldphone wifi:%s, newphone wifi:%s", str2, aqF.vQJ, com.tencent.mm.plugin.backup.a.g.cm(ad.getContext()));
                    c.hmE = 2;
                    c.this.aT(str2, i3);
                    return;
                }
                x.e("MicroMsg.BackupMoveRecoverServer", "summerbak getConnectinfo not the same account");
                b.apy().aoS().kov = -5;
                c.this.mR(-5);
                return;
            }
            x.i("MicroMsg.BackupMoveRecoverServer", "summerbak getConnect info other error [%d,%d,%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i == 4 && i2 == -2011) {
                x.e("MicroMsg.BackupMoveRecoverServer", "summerbak getConnect info: INVALID URL");
            }
            b.apy().aoS().kov = -5;
            c.this.mR(-5);
        }
    };
    private final e krc = new e() {
        public final void a(int i, int i2, String str, k kVar) {
            c.kra = true;
            g.pWK.a(485, 42, 1, false);
            g.pWK.h(11787, Integer.valueOf(0));
            b.b(1, c.this.krc);
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd auth success");
                com.tencent.mm.plugin.backup.f.a aVar = (com.tencent.mm.plugin.backup.f.a) kVar;
                if (aVar.kuo.kzy < com.tencent.mm.plugin.backup.a.c.kof) {
                    x.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd start old move, version:%d", Integer.valueOf(aVar.kuo.kzy));
                    g.pWK.a(485, 104, 1, false);
                    b.apy().aoS().kov = -12;
                    c.this.mR(-12);
                    return;
                }
                int i3 = aVar.kuo.kzz;
                c.this.kqR = (aVar.kuo.kzA & com.tencent.mm.plugin.backup.a.c.koj) != 0;
                x.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd start new move, version:%d, type:%d, isServerSupportKv:%b", Integer.valueOf(aVar.kuo.kzy), Integer.valueOf(i3), Boolean.valueOf(c.this.kqR));
                if (i3 == com.tencent.mm.plugin.backup.a.c.koh && c.apD()) {
                    c.this.kqT = true;
                    x.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd is Resume Move!!!.");
                } else {
                    c.this.apE();
                    c.this.kqT = false;
                    x.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd is Normal move.");
                }
                c.h(c.this);
                b.a(3, c.this.krd);
                new j(b.apy().kon).aqx();
                b.apy().aoS().kov = 22;
                c.this.mR(22);
                return;
            }
            x.e("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd auth failed");
            b.apy().aoS().kov = -5;
            c.this.mR(-5);
            c.this.mV(3);
        }
    };
    private final e krd = new e() {
        public final void a(int i, int i2, String str, k kVar) {
            b.b(3, c.this.krd);
            x.i("MicroMsg.BackupMoveRecoverServer", "backupmove receive startrequest response.[%d,%d,%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i == 0 && i2 == 0) {
                j jVar = (j) kVar;
                o oVar = jVar.kvp;
                if (b.apy().kon.equals(oVar.ID)) {
                    double d;
                    b.apy().aoS().koy = oVar.kyQ;
                    c.this.ffG = jVar.kvp.kyT.kyJ;
                    if (jVar.kvp.kyT.kyM.toLowerCase().contains("ios")) {
                        c.this.kqV = 1;
                    } else {
                        c.this.kqV = 2;
                    }
                    c.this.fxb = jVar.kvp.kyX;
                    c.this.kqP = jVar.kvp.kyZ;
                    x.i("MicroMsg.BackupMoveRecoverServer", "move recover totalCount[%d], totalSize[%d], and wait old mobile's pushData", Long.valueOf(jVar.kvp.kyW), Long.valueOf(jVar.kvp.kyX));
                    if (c.this.kqS && c.this.kqR) {
                        g gVar = g.pWK;
                        int i3 = (c.this.kqQ || c.this.kqP == 1) ? 66 : 65;
                        gVar.a(485, (long) i3, 1, false);
                    }
                    if ((jVar.kvp.kyV == 3 ? 1 : null) != null) {
                        c.this.kpU = true;
                        x.i("MicroMsg.BackupMoveRecoverServer", "isQuickBackup!!!");
                    } else {
                        c.this.kpU = false;
                    }
                    PLong pLong = new PLong();
                    PLong pLong2 = new PLong();
                    as.Hm();
                    com.tencent.mm.plugin.backup.a.g.a(pLong, pLong2, com.tencent.mm.y.c.FJ());
                    long m = c.this.fxb;
                    if (((double) c.this.fxb) * 0.1d > 5.24288E8d) {
                        d = 5.24288E8d;
                    } else {
                        d = ((double) c.this.fxb) * 0.1d;
                    }
                    long j = ((long) d) + m;
                    c.this.kre = j;
                    if (pLong2.value < j) {
                        x.e("MicroMsg.BackupMoveRecoverServer", "startRequestNotify Not Enough Space:%d < dataSize:%d, dataSize:%d", Long.valueOf(pLong2.value), Long.valueOf(j), Long.valueOf(c.this.fxb));
                        g.pWK.h(11787, Integer.valueOf(5));
                        b.apy().apz().stop();
                        b.apy().aoS().kov = -13;
                        c.this.mR(-13);
                        g.pWK.a(485, 5, 1, false);
                        return;
                    }
                    c.this.kqJ = bi.Wy();
                    return;
                }
                x.e("MicroMsg.BackupMoveRecoverServer", "start response not the same id");
                b.apy().aoS().kov = -5;
                c.this.mR(-5);
                return;
            }
            x.e("MicroMsg.BackupMoveRecoverServer", "start request failed, errMsg:" + str);
            b.apy().aoS().kov = -5;
            c.this.mR(-5);
        }
    };
    public long kre;
    private int krf;
    com.tencent.mm.plugin.backup.f.b.c krg = new com.tencent.mm.plugin.backup.f.b.c() {
        public final void apM() {
            x.i("MicroMsg.BackupMoveRecoverServer", "stopCallback ");
            b.aqr();
            b.apy().aoU();
        }
    };
    private final com.tencent.mm.plugin.backup.f.f.a krh = new com.tencent.mm.plugin.backup.f.f.a() {
        public final void mX(int i) {
            int i2 = b.apy().aoS().kov;
            x.i("MicroMsg.BackupMoveRecoverServer", "heartBeatTimeoutCallback, heartBeatState[%d], state[%d]", Integer.valueOf(i), Integer.valueOf(i2));
            switch (i) {
                case 0:
                    if (i2 == 4) {
                        b.apy().aoS().kov = 23;
                        c.this.mR(23);
                        return;
                    }
                    return;
                case 1:
                    if (i2 == 23) {
                        b.apy().aoS().kov = 4;
                        c.this.mR(4);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private final com.tencent.mm.plugin.backup.f.i.a kri = new com.tencent.mm.plugin.backup.f.i.a() {
        public final void apK() {
            c.this.mR(b.apy().aoS().kov);
        }

        public final void mW(int i) {
            if (i == 1) {
                g.pWK.h(11789, Integer.valueOf(8));
            } else if (i == 0) {
                g.pWK.h(11789, Integer.valueOf(9));
            }
        }

        public final void apL() {
            int i = b.apy().aoS().kov;
            x.e("MicroMsg.BackupMoveRecoverServer", "speedOverTime callback, state[%d]", Integer.valueOf(i));
            if (i == 23 || i == 4) {
                c.this.a(true, false, -4);
                g.pWK.a(485, 43, 1, false);
                c.this.mV(4);
                b.apy().apz().stop();
            }
        }
    };
    private Object lock = new Object();
    private long recvSize = 0;

    private class a {
        byte[] buf;
        int hQv;
        boolean jwB = false;
        int type;

        a(boolean z, int i, int i2, byte[] bArr) {
            this.hQv = i;
            this.type = i2;
            this.buf = (byte[]) bArr.clone();
        }
    }

    static /* synthetic */ void E(byte[] bArr, int i) {
        af afVar = (af) com.tencent.mm.plugin.backup.a.g.a(new af(), bArr);
        if (afVar == null) {
            x.e("MicroMsg.BackupMoveRecoverServer", "requestBigFileSvrIdNotify PacketSvrIDRequest parse failed :%d", Integer.valueOf(bi.bz(bArr)));
            return;
        }
        ag agVar = new ag();
        agVar.kzV = afVar.kzV;
        agVar.kzX = afVar.kzX;
        agVar.kzW = afVar.kzW;
        agVar.kyy = afVar.kyy;
        try {
            x.i("MicroMsg.BackupMoveRecoverServer", "send SvrID resp");
            b.o(agVar.toByteArray(), 14, i);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", e, "buf to PacketSvrIDResponse err.", new Object[0]);
        }
    }

    static /* synthetic */ void a(c cVar, byte[] bArr) {
        x.i("MicroMsg.BackupMoveRecoverServer", "finishReqNotify receive finishReq. hasReceiveFinishReq[%b]", Boolean.valueOf(kqL));
        if (kqL) {
            x.e("MicroMsg.BackupMoveRecoverServer", "finishReqNotify has receive finishReq, return.");
            return;
        }
        kqL = true;
        if (com.tencent.mm.plugin.backup.a.g.a(new com.tencent.mm.plugin.backup.h.d(), bArr) == null) {
            x.e("MicroMsg.BackupMoveRecoverServer", "finishReqNotify buf to BackupFinishRequest error, buflen[%d]", Integer.valueOf(bi.bz(bArr)));
        }
        b.apy().apz().koL = null;
        as.Hm();
        com.tencent.mm.y.c.Db().a(com.tencent.mm.storage.w.a.USERINFO_BACKUP_MOVE_RECOVERING_BOOLEAN, Boolean.valueOf(false));
        b.aqr();
        b.aqt();
        b.apy().aoS().F(24, cVar.kqI.size(), cVar.kqD.size());
        cVar.mR(24);
        long bA = bi.bA(cVar.kqJ);
        long j = bA != 0 ? ((cVar.fxb / 1024) * 1000) / bA : 0;
        g.pWK.a(485, 45, 1, false);
        g gVar = g.pWK;
        int i = (cVar.kqQ || cVar.kqP == 1) ? 68 : 67;
        gVar.a(485, (long) i, 1, false);
        g.pWK.a(485, 61, bA / 1000, false);
        g.pWK.a(485, 62, cVar.fxb / 1024, false);
        gVar = g.pWK;
        i = (cVar.kqQ || cVar.kqP == 1) ? 70 : 69;
        gVar.a(485, (long) i, j, false);
        cVar.mV(1);
        if (!kqM) {
            cVar.mV(2);
        }
        x.i("MicroMsg.BackupMoveRecoverServer", "finishReqNotify recover success. recoverCostTime[%d s], recoverTotalSize[%d kb]", Long.valueOf(bA / 1000), Long.valueOf(cVar.fxb / 1024));
    }

    static /* synthetic */ void a(c cVar, byte[] bArr, int i) {
        if (b.apy().aoS().kov == -13) {
            x.e("MicroMsg.BackupMoveRecoverServer", "receive requestSession request, but no enough space for recover, quit.");
            return;
        }
        i iVar = (i) com.tencent.mm.plugin.backup.a.g.a(new i(), bArr);
        if (iVar == null) {
            x.e("MicroMsg.BackupMoveRecoverServer", "requestSessionListNotify parseBuf failed:%d", Integer.valueOf(bi.bz(bArr)));
            b.apy().aoS().kov = -21;
            cVar.mR(-21);
            return;
        }
        x.i("MicroMsg.BackupMoveRecoverServer", "summerbak receive requestSession request, SessionName size:%d, TimeInterval size:%d", Integer.valueOf(iVar.kyC.size()), Integer.valueOf(iVar.kyD.size()));
        cVar.kqD = iVar.kyC;
        cVar.kqE = iVar.kyD;
        if (cVar.kqE.size() != cVar.kqD.size() * 2) {
            apH();
            b.apy().aoS().kov = -21;
            cVar.mR(-21);
            return;
        }
        cVar.krf = i;
        if (cVar.kqT) {
            cVar.dH(cVar.kqU);
            return;
        }
        long j;
        com.tencent.mm.storage.j FR = as.Hm().FR();
        String str = "SELECT * FROM BackupMoveTime WHERE deviceId = \"" + cVar.ffG + "\"";
        x.d("MicroMsg.BackupMoveTimeStorage", "getCountByDevice:" + str);
        Cursor rawQuery = FR.gLA.rawQuery(str, null);
        if (rawQuery == null) {
            x.e("MicroMsg.BackupMoveTimeStorage", "getCountByDevice failed, deviceid:%s", r1);
            j = 0;
        } else {
            j = (long) rawQuery.getCount();
            rawQuery.close();
        }
        if (j > 0) {
            b.apy().aoS().kov = 52;
            cVar.mR(52);
            return;
        }
        cVar.dH(true);
    }

    static /* synthetic */ void b(c cVar, byte[] bArr, int i) {
        if (cVar.kqN) {
            cVar.kqN = false;
        }
        com.tencent.mm.plugin.backup.h.x xVar = (com.tencent.mm.plugin.backup.h.x) com.tencent.mm.plugin.backup.a.g.a(new com.tencent.mm.plugin.backup.h.x(), bArr);
        if (xVar == null) {
            x.e("MicroMsg.BackupMoveRecoverServer", "dataPushNotify parseBuf failed:%d", Integer.valueOf(bi.bz(bArr)));
            b("", 0, 0, 0, 1, i);
            return;
        }
        x.i("MicroMsg.BackupMoveRecoverServer", "dataPushNotify recoverData id:%s, type:%d, start:%d, end:%d", xVar.kzD, Integer.valueOf(xVar.kzE), Integer.valueOf(xVar.kzG), Integer.valueOf(xVar.kzH));
        if (xVar.kzE == 1 && xVar.kyn != null) {
            x.i("MicroMsg.BackupMoveRecoverServer", "dataPushNotify text dataid:%s, dir:%s", xVar.kzD, com.tencent.mm.plugin.backup.a.g.vR(xVar.kzD));
            com.tencent.mm.plugin.backup.a.g.b(r2, xVar);
            cVar.recvSize += (long) xVar.kyn.oz.length;
        }
        if (xVar.kzE == 2) {
            x.i("MicroMsg.BackupMoveRecoverServer", "dataPushNotify datapush media dataid:%s, dir:%s", xVar.kzD, com.tencent.mm.plugin.backup.a.g.vS(xVar.kzD));
            com.tencent.mm.plugin.backup.a.g.a(r2, xVar);
            cVar.recvSize += (long) xVar.kyn.oz.length;
            cVar.kqO.add(xVar.kzD);
        }
        x.i("MicroMsg.BackupMoveRecoverServer", "dataPushNotify recvSize/convDataSize: %d, %d", Long.valueOf(cVar.recvSize), Long.valueOf(cVar.fxb));
        if (cVar.fxb < cVar.recvSize) {
            cVar.fxb = cVar.recvSize;
        }
        b(xVar.kzD, xVar.kzE, xVar.kzG, xVar.kzH, 0, i);
    }

    static /* synthetic */ void c(c cVar, byte[] bArr, int i) {
        z zVar = (z) com.tencent.mm.plugin.backup.a.g.a(new z(), bArr);
        if (zVar == null) {
            x.e("MicroMsg.BackupMoveRecoverServer", "SendTagNotify PacketBackupDataTag parse failed:%d", Integer.valueOf(bi.bz(bArr)));
            return;
        }
        x.i("MicroMsg.BackupMoveRecoverServer", "summerbak receive tag, MsgDataID:%s, BakChatName:%s, StartTime:%d, EndTime:%d,  NickName:%s", zVar.kzM, zVar.kyy, Long.valueOf(zVar.kzK), Long.valueOf(zVar.kzL), zVar.kzN);
        as.Hm();
        com.tencent.mm.y.c.Db().a(com.tencent.mm.storage.w.a.USERINFO_BACKUP_MOVE_RECOVERING_BOOLEAN, Boolean.valueOf(true));
        if (as.Hm().FT().WY(zVar.kzM) != null) {
            x.i("MicroMsg.BackupMoveRecoverServer", "summerbak the same tag has received, ignore. MsgDataID:%s", zVar.kzM);
        } else {
            Object obj;
            com.tencent.mm.sdk.e.c kVar = new com.tencent.mm.storage.k();
            kVar.field_msgListDataId = zVar.kzM;
            kVar.field_sessionName = zVar.kyy;
            x.i("MicroMsg.BackupMoveRecoverServer", "tagReqNotify insert BackupRecoverMsgListDataIdStorage ret[%b], systemRowid[%d]", Boolean.valueOf(as.Hm().FT().b(kVar)), Long.valueOf(kVar.xrR));
            n FS = as.Hm().FS();
            String str = zVar.kyy;
            String str2 = "SELECT * FROM BackupTempMoveTime WHERE sessionName = \"" + str + "\"  AND startTime = " + zVar.kzK + " AND endTime = " + zVar.kzL;
            x.d("MicroMsg.BackupTempMoveTimeStorage", "isTempMoveTimeExist:" + str2);
            Cursor rawQuery = FS.gLA.rawQuery(str2, null);
            if (rawQuery == null) {
                x.e("MicroMsg.BackupTempMoveTimeStorage", "isTempMoveTimeExist failed, sessionName[%s], startTime[%d], endTime[%d] ", str, Long.valueOf(r4), Long.valueOf(r6));
                obj = null;
            } else if (rawQuery.moveToNext()) {
                rawQuery.close();
                obj = 1;
            } else {
                rawQuery.close();
                obj = null;
            }
            if (obj == null) {
                kVar = new m();
                kVar.field_sessionName = zVar.kyy;
                kVar.field_startTime = zVar.kzK;
                kVar.field_endTime = zVar.kzL;
                x.i("MicroMsg.BackupMoveRecoverServer", "tagReqNotify insert BackupTempMoveTimeStorage ret[%b], systemRowid[%d]", Boolean.valueOf(as.Hm().FS().b(kVar)), Long.valueOf(kVar.xrR));
            }
        }
        cVar.kqI.add(zVar.kyy);
        b.apy().aoS().F(23, cVar.kqI.size() < cVar.kqD.size() ? cVar.kqI.size() : cVar.kqD.size(), cVar.kqD.size());
        cVar.mR(23);
        aa aaVar = new aa();
        aaVar.kyy = zVar.kyy;
        aaVar.kzK = zVar.kzK;
        aaVar.kzL = zVar.kzL;
        aaVar.kzM = zVar.kzM;
        try {
            x.i("MicroMsg.BackupMoveRecoverServer", "SendTagNotify send tag resp");
            b.o(aaVar.toByteArray(), 16, i);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", e, "summerbak buf to PacketBackupDataTagResponse err.", new Object[0]);
        }
    }

    static /* synthetic */ void h(c cVar) {
        x.i("MicroMsg.BackupMoveRecoverServer", "move recover init");
        kqL = false;
        kqM = false;
        cVar.fxb = 0;
        cVar.recvSize = 0;
        cVar.hpb = false;
        cVar.kqI.clear();
        cVar.kqN = true;
        cVar.kqO.clear();
    }

    public static boolean apD() {
        return as.Hm().FT().ciA();
    }

    public final void apE() {
        x.i("MicroMsg.BackupMoveRecoverServer", "recover clearContinueRecoverData");
        this.kqI.clear();
    }

    public final void a(boolean z, boolean z2, int i) {
        int i2 = 0;
        x.i("MicroMsg.BackupMoveRecoverServer", "cancel backupMoveRecoverServer cancel isSelf[%b], needClearContinueRecoverData[%b], updateState[%d], caller:%s", Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), aj.cgu());
        if (!z) {
            apH();
        }
        synchronized (this.lock) {
            this.hpb = true;
            if (this.kqC != null) {
                this.kqC.h(z2, i);
                this.kqC = null;
            } else {
                i2 = 1;
            }
        }
        if (!(i2 == 0 || i == 0)) {
            b.apy().aoS().kov = i;
            mR(i);
        }
        if (z2) {
            apE();
        }
        b.aqr();
        b.aqt();
        b.apy().apz().koL = null;
    }

    private void aT(String str, int i) {
        boolean z = true;
        b.apy().apz().connect(str, i);
        b.a(1, this.krc);
        try {
            if (bi.getInt(com.tencent.mm.j.g.Af().getValue("ChattingRecordsKvstatDisable"), 0) != 0) {
                z = false;
            }
            this.kqS = z;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", e, "getInt", new Object[0]);
        }
        com.tencent.mm.plugin.backup.f.a aVar = new com.tencent.mm.plugin.backup.f.a(b.apy().koo, b.apy().kop, com.tencent.mm.plugin.backup.a.d.aoW(), b.apy().kon, com.tencent.mm.plugin.backup.a.c.kof, 22);
        aVar.o(this.kqS, false);
        aVar.aqx();
        x.i("MicroMsg.BackupMoveRecoverServer", "tryConnect start connect timehandler.");
        if (this.kqZ == null) {
            this.kqZ = new al(new com.tencent.mm.sdk.platformtools.al.a() {
                public final boolean uG() {
                    if (!c.kra) {
                        x.e("MicroMsg.BackupMoveRecoverServer", "try connect overtime failed.");
                        if (c.this.kqZ != null) {
                            c.this.kqZ.TN();
                        }
                        c.this.apF();
                    }
                    return true;
                }
            }, false);
        }
        this.kqZ.K(3000, 3000);
    }

    private void apF() {
        String str = this.kqW;
        String str2 = this.kqX;
        String cm = com.tencent.mm.plugin.backup.a.g.cm(ad.getContext());
        x.e("MicroMsg.BackupMoveRecoverServer", "connect failed thisWifi:%s, oldPhoneWifiName:%s, oldPhoneIpAddress:%s, tryCount:%d", cm, str, str2, Integer.valueOf(hmE));
        if (cm == null || cm.equals("")) {
            g.pWK.a(485, 1, 1, false);
            g.pWK.h(11787, Integer.valueOf(1));
            b.apy().aoS().kov = -1;
            mR(-1);
        } else if (str == null || !str.equals(cm)) {
            g.pWK.a(485, 2, 1, false);
            g.pWK.h(11787, Integer.valueOf(2));
            b.apy().aoS().kov = -2;
            mR(-2);
        } else if (!com.tencent.mm.plugin.backup.a.g.vU(str2)) {
            g.pWK.a(485, 3, 1, false);
            g.pWK.h(11787, Integer.valueOf(3));
            b.apy().aoS().kov = -3;
            mR(-3);
        } else if (hmE <= 0) {
            b.apy().aoS().kov = -5;
            mR(-5);
            g.pWK.a(485, 4, 1, false);
            g.pWK.h(11787, Integer.valueOf(6));
        } else {
            hmE--;
            aT(this.kqX, this.kqY);
        }
    }

    public final void a(boolean z, final int i, final byte[] bArr, final int i2) {
        String str = "MicroMsg.BackupMoveRecoverServer";
        String str2 = "onNotify isLocal:%b, type:%d, seq:%d, buf.len:%d";
        Object[] objArr = new Object[4];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        x.i(str, str2, objArr);
        if (z && CdnLogic.kMediaTypeBeatificFile == i) {
            x.i("MicroMsg.BackupMoveRecoverServer", "summerbak local disconnect, backupMoveState:%d", Integer.valueOf(b.apy().aoS().kov));
            switch (b.apy().aoS().kov) {
                case DownloadResult.CODE_URL_ERROR /*-21*/:
                case -13:
                case -5:
                    b.apy().apz().stop();
                    return;
                case -4:
                    a(true, false, 0);
                    return;
                case 1:
                    b.apy().apz().stop();
                    if (kra) {
                        b.apy().aoS().kov = -4;
                        mR(-4);
                        return;
                    }
                    if (this.kqZ != null) {
                        x.i("MicroMsg.BackupMoveRecoverServer", "processNetworkNotify stop backupConnectTimerHandler.");
                        this.kqZ.TN();
                    }
                    apF();
                    return;
                case 22:
                case 23:
                    a(true, false, -4);
                    b.apy().apz().stop();
                    kqM = true;
                    g.pWK.a(485, 43, 1, false);
                    mV(4);
                    long j = 0;
                    if (this.kqJ != 0) {
                        j = bi.bA(this.kqJ);
                    }
                    x.i("MicroMsg.BackupMoveRecoverServer", "processNetworkNotify recover transfer disconnect, recoverDataSize:%d, recoverCostTime:%d", Long.valueOf(this.fxb), Long.valueOf(j));
                    return;
                default:
                    return;
            }
        } else if (i == 9) {
            com.tencent.mm.plugin.backup.h.e eVar = (com.tencent.mm.plugin.backup.h.e) com.tencent.mm.plugin.backup.a.g.a(new com.tencent.mm.plugin.backup.h.e(), bArr);
            if (eVar == null) {
                x.e("MicroMsg.BackupMoveRecoverServer", "heartBeatRequest parseBuf failed:%d", Integer.valueOf(bi.bz(bArr)));
                return;
            }
            x.i("MicroMsg.BackupMoveRecoverServer", "summerbak receive heartbeat req, req:%s ack:%d", eVar, Long.valueOf(eVar.kuT));
            f fVar = new f();
            fVar.kuT = eVar.kuT;
            try {
                x.i("MicroMsg.BackupMoveRecoverServer", "summerbak send heartbeat resp");
                b.o(fVar.toByteArray(), 10, i2);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", e, "summerbak buf to BackupHeartBeatResponse err.", new Object[0]);
            }
        } else if (i == 10) {
            f fVar2 = (f) com.tencent.mm.plugin.backup.a.g.a(new f(), bArr);
            str2 = "MicroMsg.BackupMoveRecoverServer";
            String str3 = "summerbak receive heartbeat response, resp:%s ack:%d";
            Object[] objArr2 = new Object[2];
            objArr2[0] = fVar2;
            objArr2[1] = Long.valueOf(fVar2 != null ? fVar2.kuT : -1);
            x.i(str2, str3, objArr2);
        } else {
            if (i == 5) {
                g.pWK.a(485, 51, 1, false);
                a(true, false, -100);
            }
            as.Dt().F(new Runnable() {
                public final void run() {
                    if (i == 11) {
                        c.a(c.this, bArr, i2);
                    } else if (i == 6) {
                        c.b(c.this, bArr, i2);
                    } else if (i == 13) {
                        c.E(bArr, i2);
                    } else if (i == 15) {
                        c.c(c.this, bArr, i2);
                    } else if (i == 8) {
                        c.a(c.this, bArr);
                    }
                }
            });
        }
    }

    public final void dH(boolean z) {
        this.kqU = z;
        final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        b.apy().apz().koL = new com.tencent.mm.plugin.backup.b.a.a() {
            public final void a(int i, int i2, byte[] bArr) {
                while (!c.this.hpb) {
                    try {
                        if (linkedBlockingQueue.offer(new a(false, i, i2, bArr), 500, TimeUnit.MILLISECONDS)) {
                            break;
                        }
                    } catch (Exception e) {
                        x.e("MicroMsg.BackupMoveRecoverServer", "onBackupMoveRecoverDatapushCallback e:%s", e.getMessage());
                    }
                }
                x.i("MicroMsg.BackupMoveRecoverServer", "summerbak offer datapushQueue, datapushQueue size:%d", Integer.valueOf(linkedBlockingQueue.size()));
            }
        };
        com.tencent.mm.sdk.f.e.b(new Runnable() {
            public final void run() {
                while (!c.this.hpb) {
                    a aVar;
                    try {
                        aVar = (a) linkedBlockingQueue.poll(500, TimeUnit.MILLISECONDS);
                    } catch (Exception e) {
                        aVar = null;
                    }
                    x.d("MicroMsg.BackupMoveRecoverServer", "datapushQueue size:%d, startNext receiveData:%s", Integer.valueOf(linkedBlockingQueue.size()), aVar);
                    if (aVar != null) {
                        c.this.a(aVar.jwB, aVar.type, aVar.buf, aVar.hQv);
                    }
                }
            }
        }, "onNotifyWorker").start();
        this.kqF = new LinkedList();
        this.kqG = new LinkedList();
        as.Hm().FS().a(this.kqD, this.kqE, this.kqF, this.kqG);
        if (!(this.kpU || z)) {
            LinkedList linkedList = this.kqF;
            LinkedList linkedList2 = this.kqG;
            this.kqF = new LinkedList();
            this.kqG = new LinkedList();
            as.Hm().FR().a(this.ffG, linkedList, linkedList2, this.kqF, this.kqG);
        }
        com.tencent.mm.plugin.backup.h.j jVar = new com.tencent.mm.plugin.backup.h.j();
        jVar.kyC = this.kqF;
        jVar.kyD = this.kqG;
        try {
            x.i("MicroMsg.BackupMoveRecoverServer", "summerbak send requestsession resp, SessionName size:%d, TimeInterval size:%d", Integer.valueOf(this.kqD.size()), Integer.valueOf(jVar.kyD.size()));
            b.o(jVar.toByteArray(), 12, this.krf);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", e, "buf to BackupRequestSessionResponse err.", new Object[0]);
        }
        b.aqs();
        b.apy().aoS().F(23, 1, this.kqD.size());
        mR(23);
    }

    private static void b(String str, int i, int i2, int i3, int i4, int i5) {
        y yVar = new y();
        yVar.kzD = str;
        yVar.kzE = i;
        yVar.kzG = i2;
        yVar.kzH = i3;
        yVar.kyY = i4;
        try {
            b.o(yVar.toByteArray(), 7, i5);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", e, "sendResp", new Object[0]);
        }
    }

    public final void mV(int i) {
        long j = 0;
        if (this.kqJ != 0) {
            j = bi.bA(this.kqJ);
        }
        g.pWK.h(11789, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(this.kqV), Long.valueOf(this.fxb / 1024), Long.valueOf(j / 1000));
        x.i("MicroMsg.BackupMoveRecoverServer", "backupPcServerKvStat kvNum[%d], errcode[%d], backupDataSize[%d KB], recoverCostTime[%d s]", Integer.valueOf(11789), Integer.valueOf(i), Long.valueOf(this.fxb / 1024), Long.valueOf(j / 1000));
    }

    public final void apj() {
        synchronized (this.lock) {
            if (this.hpb) {
                x.e("MicroMsg.BackupMoveRecoverServer", "startMerge isCancel true.");
            } else if (this.kqC == null || !this.kqC.kpL) {
                int ciB;
                if (this.kqC != null) {
                    this.kqC.h(false, 0);
                }
                if (this.kqI == null || this.kqI.size() <= 0) {
                    ciB = as.Hm().FT().ciB();
                } else {
                    ciB = this.kqI.size();
                }
                b.apy().aoS().F(26, 1, ciB);
                mR(26);
                this.kqK = bi.Wy();
                this.kqC = new com.tencent.mm.plugin.backup.b.d(b.apy(), 22, this, ciB, false, new LinkedList(), new LinkedList());
                this.kqC.apj();
                g.pWK.a(485, 46, 1, false);
            } else {
                x.e("MicroMsg.BackupMoveRecoverServer", "startMerge hasStartMerge, return.");
            }
        }
    }

    public static String apG() {
        return b.aqu();
    }

    private static void apH() {
        com.tencent.mm.plugin.backup.h.a aVar = new com.tencent.mm.plugin.backup.h.a();
        aVar.ID = b.apy().kon;
        try {
            x.i("MicroMsg.BackupMoveRecoverServer", "send cancel req.");
            b.G(aVar.toByteArray(), 5);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", e, "buf to BackupCancelRequest err.", new Object[0]);
        }
    }

    public final void mR(final int i) {
        if (this.kpP != null) {
            ah.y(new Runnable() {
                public final void run() {
                    if (c.this.kpP != null) {
                        c.this.kpP.mR(i);
                    }
                }
            });
        }
        if (this.kqH != null) {
            ah.y(new Runnable() {
                public final void run() {
                    if (c.this.kqH != null) {
                        c.this.kqH.mQ(i);
                    }
                }
            });
        }
    }

    public final void aoR() {
        g.pWK.a(485, 49, 1, false);
        g.pWK.a(485, 50, bi.bA(this.kqK) / 1000, false);
        as.Hm();
        com.tencent.mm.y.c.Db().a(com.tencent.mm.storage.w.a.USERINFO_BACKUP_OLD_RECORDS_BOOLEAN, Boolean.valueOf(true));
        x.i("MicroMsg.BackupMoveRecoverServer", "move recover finish, make BACKUP_MOVE_RECORDS.");
        if (!this.kpU) {
            n FS = as.Hm().FS();
            LinkedList linkedList = new LinkedList();
            Cursor Tq = FS.Tq();
            if (Tq == null) {
                x.e("MicroMsg.BackupTempMoveTimeStorage", "getAllData failed.");
            } else {
                while (Tq.moveToNext()) {
                    m mVar = new m();
                    mVar.b(Tq);
                    linkedList.add(mVar);
                }
                Tq.close();
            }
            if (linkedList.size() <= 0) {
                x.e("MicroMsg.BackupMoveRecoverServer", "merge finish and BackupTempMoveTimeStorage is empty!");
            } else {
                x.i("MicroMsg.BackupMoveRecoverServer", "merge finish and start update BackupMoveTimeStorage!");
                as.Hm().FR().d(this.ffG, linkedList);
            }
        }
        apE();
        b.aqr();
        b.aqt();
    }
}
