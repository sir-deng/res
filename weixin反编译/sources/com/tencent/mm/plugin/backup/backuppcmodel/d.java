package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.plugin.backup.a.b.a;
import com.tencent.mm.plugin.backup.a.b.c;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.plugin.backup.h.aa;
import com.tencent.mm.plugin.backup.h.af;
import com.tencent.mm.plugin.backup.h.ag;
import com.tencent.mm.plugin.backup.h.f;
import com.tencent.mm.plugin.backup.h.i;
import com.tencent.mm.plugin.backup.h.j;
import com.tencent.mm.plugin.backup.h.n;
import com.tencent.mm.plugin.backup.h.o;
import com.tencent.mm.plugin.backup.h.y;
import com.tencent.mm.plugin.backup.h.z;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.k;
import com.tencent.mm.storage.m;
import com.tencent.mm.storage.w;
import com.tencent.mm.y.as;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public final class d implements com.tencent.mm.plugin.backup.a.b.d {
    private static boolean kqL = false;
    private static boolean ktA = false;
    private long fxb = 0;
    private boolean hpb = false;
    private boolean kpU = false;
    private com.tencent.mm.plugin.backup.b.d kqC;
    LinkedList<String> kqD;
    LinkedList<Long> kqE;
    private HashSet<String> kqI = new HashSet();
    private long kqJ = 0;
    private long kqK = 0;
    public Set<c> ktB = new HashSet();
    public a ktC;
    private long ktD = 0;
    private boolean ktE = false;
    private final com.tencent.mm.plugin.backup.f.b.d ktF = new com.tencent.mm.plugin.backup.f.b.d() {
        public final void a(boolean z, final int i, final byte[] bArr, final int i2) {
            String str = "MicroMsg.BackupPcRecoverServer";
            String str2 = "onBackupPcRecoverServerNotify isLocal[%b], type[%d], seq[%d], buflen[%d]";
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = Integer.valueOf(bArr == null ? 0 : bArr.length);
            x.i(str, str2, objArr);
            if (z && CdnLogic.kMediaTypeBeatificFile == i) {
                d.a(d.this);
            } else if (i == 5) {
                x.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive cancelReq.");
                d.this.a(true, false, -100);
                g.pWK.a(400, 52, 1, false);
                d.this.nb(5);
            } else {
                int i3 = b.apZ().aqa().ktp;
                if (2 != i3 && 4 != i3) {
                    x.e("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify cmdmode error[%d]", Integer.valueOf(b.apZ().aqa().ktp));
                } else if (i == 10) {
                    f fVar = (f) com.tencent.mm.plugin.backup.a.g.a(new f(), bArr);
                    str2 = "MicroMsg.BackupPcRecoverServer";
                    String str3 = "onBackupPcRecoverServerNotify receive heartbeatResp, ack[%d]";
                    Object[] objArr2 = new Object[1];
                    objArr2[0] = Long.valueOf(fVar != null ? fVar.kuT : -1);
                    x.i(str2, str3, objArr2);
                } else if (i == 18) {
                    com.tencent.mm.plugin.backup.h.c cVar = new com.tencent.mm.plugin.backup.h.c();
                    try {
                        cVar.aH(bArr);
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.BackupPcRecoverServer", e, "onBackupPcRecoverServerNotify buf to BackupCommandResponse error.", new Object[0]);
                    }
                    x.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive commandResp, cmd[%d]", Integer.valueOf(cVar.kym));
                    if (cVar.kym == 9) {
                        if (b.aqw() == 1) {
                            b.ne(2);
                            x.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify reconnect success");
                            d.this.nb(20);
                            b.aqv();
                            b.apZ().aoS().kov = 23;
                            d.this.mR(23);
                            b.ne(0);
                            return;
                        }
                        x.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify reconnect is started, ignore. state[%d]", Integer.valueOf(b.aqw()));
                    }
                } else if (i == 17) {
                    com.tencent.mm.plugin.backup.h.b bVar = new com.tencent.mm.plugin.backup.h.b();
                    try {
                        bVar.aH(bArr);
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.BackupPcRecoverServer", e2, "onBackupPcRecoverServerNotify buf to BackupCommandRequest error.", new Object[0]);
                    }
                    x.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive commandReq, cmd[%d]", Integer.valueOf(bVar.kym));
                    if (bVar.kym == 10) {
                        i3 = b.apZ().aoS().kov;
                        x.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify pc request disconnect, backupPcState[%d]", Integer.valueOf(i3));
                        if (i3 == 22 || i3 == 23) {
                            d.this.a(true, false, -4);
                            b.apZ().apz().stop();
                            g.pWK.a(400, 52, 1, false);
                            d.this.nb(5);
                            long j = 0;
                            if (d.this.kqJ != 0) {
                                j = bi.bA(d.this.kqJ);
                            }
                            g.pWK.h(13737, Integer.valueOf(3), Long.valueOf(d.this.fxb), Long.valueOf(j), Integer.valueOf(2));
                            x.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify recover transfer disconnect, recoverDataSize:%d, recoverCostTime:%d", Long.valueOf(d.this.fxb), Long.valueOf(j));
                        }
                    }
                } else {
                    as.Dt().F(new Runnable() {
                        public final void run() {
                            if (i == 3) {
                                d.a(d.this, bArr, i2);
                            } else if (i == 11) {
                                d.b(d.this, bArr, i2);
                            } else if (i == 6) {
                                d.c(d.this, bArr, i2);
                            } else if (i == 13) {
                                d.F(bArr, i2);
                            } else if (i == 15) {
                                d.d(d.this, bArr, i2);
                            } else if (i == 8) {
                                d.a(d.this, bArr);
                            }
                        }
                    });
                }
            }
        }
    };
    private Object lock = new Object();
    private long recvSize = 0;

    /* renamed from: com.tencent.mm.plugin.backup.backuppcmodel.d$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ Set ktI;

        AnonymousClass2(Set set) {
            this.ktI = set;
        }

        public final void run() {
            for (c aoQ : this.ktI) {
                aoQ.aoQ();
            }
        }
    }

    static /* synthetic */ void F(byte[] bArr, int i) {
        af afVar = (af) com.tencent.mm.plugin.backup.a.g.a(new af(), bArr);
        if (afVar == null) {
            x.e("MicroMsg.BackupPcRecoverServer", "requestBigFileSvrIdNotify PacketSvrIDRequest parse failed :%d", Integer.valueOf(bi.bz(bArr)));
            return;
        }
        ag agVar = new ag();
        agVar.kzV = afVar.kzV;
        agVar.kzX = afVar.kzX;
        agVar.kzW = afVar.kzW;
        agVar.kyy = afVar.kyy;
        try {
            x.i("MicroMsg.BackupPcRecoverServer", "requestBigFileSvrIdNotify send SvrID resp");
            b.o(agVar.toByteArray(), 14, i);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupPcRecoverServer", e, "PacketSvrIDResponse to buf err.", new Object[0]);
        }
    }

    static /* synthetic */ void a(d dVar) {
        x.i("MicroMsg.BackupPcRecoverServer", "networkDisconnectNotify local disconnect, backupPcState[%d], isRecoverFinish[%b]", Integer.valueOf(b.apZ().aoS().kov), Boolean.valueOf(ktA));
        switch (b.apZ().aoS().kov) {
            case DownloadResult.CODE_URL_ERROR /*-21*/:
            case -13:
            case -5:
                b.apZ().apz().stop();
                return;
            case -4:
                dVar.a(true, false, 0);
                return;
            case 1:
            case 21:
                b.apZ().apz().stop();
                b.apZ().aoS().kov = -100;
                dVar.mR(-100);
                return;
            case 4:
            case 22:
            case 23:
                if (!b.apZ().aqa().ktt || ktA) {
                    x.i("MicroMsg.BackupPcRecoverServer", "networkDisconnectNotify not support reconnect, disconnect");
                    dVar.a(true, false, -4);
                    b.apZ().apz().stop();
                    g.pWK.a(400, 17, 1, false);
                    dVar.nb(3);
                    return;
                }
                switch (b.aqw()) {
                    case 0:
                    case 2:
                        x.i("MicroMsg.BackupPcRecoverServer", "networkDisconnectNotify startBackupReconnectHandler, reconnectState[%d]", Integer.valueOf(b.aqw()));
                        dVar.nb(19);
                        dVar.ktE = true;
                        b.a(b.apZ().aqa().kty);
                        return;
                    case 1:
                        x.i("MicroMsg.BackupPcRecoverServer", "networkDisconnectNotify already start reconnect, state[%d]", Integer.valueOf(b.aqw()));
                        return;
                    default:
                        return;
                }
            case 27:
                b.apZ().apz().stop();
                b.apZ().aoS().kov = -100;
                dVar.mR(-100);
                return;
            default:
                return;
        }
    }

    static /* synthetic */ void a(d dVar, byte[] bArr) {
        x.i("MicroMsg.BackupPcRecoverServer", "finishReqNotify receive finishReq. hasReceiveFinishReq[%b]", Boolean.valueOf(kqL));
        if (kqL) {
            x.e("MicroMsg.BackupPcRecoverServer", "finishReqNotify has receive finishReq, return.");
            return;
        }
        kqL = true;
        if (com.tencent.mm.plugin.backup.a.g.a(new com.tencent.mm.plugin.backup.h.d(), bArr) == null) {
            x.e("MicroMsg.BackupPcRecoverServer", "finishReqNotify buf to BackupFinishRequest error, buflen[%d]", Integer.valueOf(bi.bz(bArr)));
        }
        as.Hm();
        com.tencent.mm.y.c.Db().a(w.a.USERINFO_BACKUP_PC_RECOVERING_BOOLEAN, Boolean.valueOf(false));
        b.aqr();
        b.aqt();
        ktA = true;
        b.apZ().aoS().F(24, dVar.kqI.size(), dVar.kqD.size());
        dVar.mR(24);
        g.pWK.a(400, 19, 1, false);
        dVar.ktD = bi.Wy();
        g.pWK.a(400, 20, (dVar.ktD - dVar.kqJ) / 1000, false);
        g.pWK.a(400, 21, dVar.fxb / 1024, false);
        dVar.nb(0);
        if (!dVar.ktE) {
            dVar.nb(21);
        }
        x.i("MicroMsg.BackupPcRecoverServer", "finishReqNotify recover success. hasEnterReconnect[%b], recoverCostTime[%d s], recoverStartTime[%d], recoverEndTime[%d], recoverTotalSize[%d kb]", Boolean.valueOf(dVar.ktE), Long.valueOf(r10 / 1000), Long.valueOf(dVar.kqJ), Long.valueOf(dVar.ktD), Long.valueOf(dVar.fxb / 1024));
    }

    static /* synthetic */ void a(d dVar, byte[] bArr, int i) {
        n nVar = (n) com.tencent.mm.plugin.backup.a.g.a(new n(), bArr);
        if (nVar == null || !b.apZ().kon.equals(nVar.ID)) {
            String str = "MicroMsg.BackupPcRecoverServer";
            String str2 = "startRequestNotify BackupStartRequest parseBuf:%d failed or wrong id[%s,%s]";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(bi.bz(bArr));
            objArr[1] = nVar != null ? nVar.ID : "buf is null";
            objArr[2] = b.apZ().kon;
            x.e(str, str2, objArr);
            c(1, i, 0);
            dVar.a(false, false, -5);
            g.pWK.a(400, 121, 1, false);
            return;
        }
        b.apZ().aoS().koy = nVar.kyQ;
        if (nVar.kyV == 3) {
            dVar.kpU = true;
            g.pWK.a(400, 36, 1, false);
            x.i("MicroMsg.BackupPcRecoverServer", "isQuickBackup!!!");
        }
        long j = nVar.kyU;
        PLong pLong = new PLong();
        PLong pLong2 = new PLong();
        as.Hm();
        com.tencent.mm.plugin.backup.a.g.a(pLong, pLong2, com.tencent.mm.y.c.FJ());
        long j2 = (pLong2.value - ((long) (((double) j) * 0.1d > 5.24288E8d ? 5.24288E8d : ((double) j) * 0.1d))) / 1048576;
        dVar.kqJ = bi.Wy();
        x.i("MicroMsg.BackupPcRecoverServer", "startRequestNotify time:%d SessionCount:%d, MsgCount:%d, DataSize:%d validSize:%d", Long.valueOf(dVar.kqJ), Long.valueOf(nVar.kyR), Long.valueOf(nVar.kyS), Long.valueOf(j), Long.valueOf(j2));
        if (j2 >= j) {
            c(0, i, j2);
            b.aqq();
            return;
        }
        x.e("MicroMsg.BackupPcRecoverServer", "startRequestNotify Not Enough Space:%d < dataSize:%d", Long.valueOf(j2), Long.valueOf(j));
        c(2, i, j2);
        com.tencent.mm.plugin.backup.b.a apz = b.apZ().apz();
        if (apz.koK == null) {
            apz.stop();
        } else {
            apz.koK.postDelayed(new Runnable() {
                public final void run() {
                    a.this.stop();
                }
            }, 10);
        }
        b.apZ().aoS().kov = -13;
        dVar.mR(-13);
        g.pWK.a(400, 6, 1, false);
        g.pWK.h(13736, Integer.valueOf(5), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(b.apZ().aqa().ktv));
    }

    static /* synthetic */ void b(d dVar, byte[] bArr, int i) {
        i iVar = (i) com.tencent.mm.plugin.backup.a.g.a(new i(), bArr);
        if (iVar == null) {
            x.e("MicroMsg.BackupPcRecoverServer", "requestSessionListNotify parseBuf failed:%d", Integer.valueOf(bi.bz(bArr)));
            b.apZ().aoS().kov = -21;
            dVar.mR(-21);
            return;
        }
        dVar.kqD = iVar.kyC;
        dVar.kqE = iVar.kyD;
        if (dVar.kqE.size() != dVar.kqD.size() * 2) {
            dVar.a(false, false, -21);
            g.pWK.a(400, 119, 1, false);
            return;
        }
        b.apZ().aoS().F(23, 1, dVar.kqD.size());
        dVar.mR(23);
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        as.Hm().FS().a(dVar.kqD, dVar.kqE, linkedList, linkedList2);
        j jVar = new j();
        jVar.kyC = linkedList;
        jVar.kyD = linkedList2;
        b.aqs();
        try {
            x.i("MicroMsg.BackupPcRecoverServer", "requestSessionListNotify send requestsession resp, SessionName size:%d, TimeInterval size:%d", Integer.valueOf(dVar.kqD.size()), Integer.valueOf(linkedList2.size()));
            b.o(jVar.toByteArray(), 12, i);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupPcRecoverServer", e, "BackupRequestSessionResponse to buf err.", new Object[0]);
        }
    }

    static /* synthetic */ void c(d dVar, byte[] bArr, int i) {
        com.tencent.mm.plugin.backup.h.x xVar = (com.tencent.mm.plugin.backup.h.x) com.tencent.mm.plugin.backup.a.g.a(new com.tencent.mm.plugin.backup.h.x(), bArr);
        if (xVar == null) {
            x.e("MicroMsg.BackupPcRecoverServer", "dataPushNotify parseBuf failed:%d", Integer.valueOf(bi.bz(bArr)));
            b("", 0, 0, 0, 1, i);
            return;
        }
        x.i("MicroMsg.BackupPcRecoverServer", "dataPushNotify receive recoverData id:%s, type:%d, start:%d, end:%d, isCancel:%b", xVar.kzD, Integer.valueOf(xVar.kzE), Integer.valueOf(xVar.kzG), Integer.valueOf(xVar.kzH), Boolean.valueOf(dVar.hpb));
        if (!dVar.hpb) {
            if (!(b.apZ().kot == null || xVar.kyn == null)) {
                xVar.kyn = new com.tencent.mm.bp.b(AesEcb.aesCryptEcb(xVar.kyn.oz, b.apZ().kot, false, xVar.kzH == xVar.kzF));
            }
            if (xVar.kzE == 1 && xVar.kyn != null) {
                x.i("MicroMsg.BackupPcRecoverServer", "dataPushNotify receive datapush text dataid:%s, dir:%s", xVar.kzD, com.tencent.mm.plugin.backup.a.g.vR(xVar.kzD));
                com.tencent.mm.plugin.backup.a.g.b(r2, xVar);
                dVar.recvSize += (long) xVar.kyn.oz.length;
            }
            if (xVar.kzE == 2) {
                x.i("MicroMsg.BackupPcRecoverServer", "dataPushNotify receive datapush media dataid:%s, dir:%s", xVar.kzD, com.tencent.mm.plugin.backup.a.g.vS(xVar.kzD));
                com.tencent.mm.plugin.backup.a.g.a(r2, xVar);
                dVar.recvSize += (long) xVar.kyn.oz.length;
            }
            x.i("MicroMsg.BackupPcRecoverServer", "dataPushNotify recvSize/convDataSize: %d, %d", Long.valueOf(dVar.recvSize), Long.valueOf(dVar.fxb));
            if (dVar.fxb < dVar.recvSize) {
                dVar.fxb = dVar.recvSize;
            }
            b(xVar.kzD, xVar.kzE, xVar.kzG, xVar.kzH, 0, i);
        }
    }

    static /* synthetic */ void d(d dVar, byte[] bArr, int i) {
        z zVar = (z) com.tencent.mm.plugin.backup.a.g.a(new z(), bArr);
        if (zVar == null) {
            x.e("MicroMsg.BackupPcRecoverServer", "SendTagNotify PacketBackupDataTag parse failed:%d", Integer.valueOf(bi.bz(bArr)));
            return;
        }
        x.i("MicroMsg.BackupPcRecoverServer", "SendTagNotify receive tagReq, MsgDataID:%s, BakChatName:%s, StartTime:%d, EndTime:%d,  NickName:%s, isCancel:%b", zVar.kzM, zVar.kyy, Long.valueOf(zVar.kzK), Long.valueOf(zVar.kzL), zVar.kzN, Boolean.valueOf(dVar.hpb));
        if (!dVar.hpb) {
            as.Hm();
            com.tencent.mm.y.c.Db().a(w.a.USERINFO_BACKUP_PC_RECOVERING_BOOLEAN, Boolean.valueOf(true));
            if (as.Hm().FT().WY(zVar.kzM) != null) {
                x.i("MicroMsg.BackupPcRecoverServer", "SendTagNotify the same tag has received, ignore. MsgDataID:%s", zVar.kzM);
            } else {
                com.tencent.mm.sdk.e.c kVar = new k();
                kVar.field_msgListDataId = zVar.kzM;
                kVar.field_sessionName = zVar.kyy;
                x.i("MicroMsg.BackupPcRecoverServer", "SendTagNotify insert BackupRecoverMsgListDataIdStorage ret[%b], systemRowid[%d]", Boolean.valueOf(as.Hm().FT().b(kVar)), Long.valueOf(kVar.xrR));
                kVar = new m();
                kVar.field_sessionName = zVar.kyy;
                kVar.field_startTime = zVar.kzK;
                kVar.field_endTime = zVar.kzL;
                x.i("MicroMsg.BackupPcRecoverServer", "SendTagNotify insert BackupTempMoveTimeStorage ret[%b], systemRowid[%d]", Boolean.valueOf(as.Hm().FS().b(kVar)), Long.valueOf(kVar.xrR));
            }
            dVar.kqI.add(zVar.kyy);
            b.apZ().aoS().F(23, dVar.kqI.size() < dVar.kqD.size() ? dVar.kqI.size() : dVar.kqD.size(), dVar.kqD.size());
            dVar.mR(23);
            aa aaVar = new aa();
            aaVar.kyy = zVar.kyy;
            aaVar.kzK = zVar.kzK;
            aaVar.kzL = zVar.kzL;
            aaVar.kzM = zVar.kzM;
            try {
                x.i("MicroMsg.BackupPcRecoverServer", "SendTagNotify send tag resp");
                b.o(aaVar.toByteArray(), 16, i);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.BackupPcRecoverServer", e, "SendTagNotify buf to PacketBackupDataTagResponse err.", new Object[0]);
            }
        }
    }

    public static void aqi() {
        ktA = true;
    }

    public final void init() {
        x.i("MicroMsg.BackupPcRecoverServer", "init");
        this.ktE = false;
        ktA = false;
        kqL = false;
        b.a(this.ktF);
        this.fxb = 0;
        this.recvSize = 0;
        this.hpb = false;
        this.kpU = false;
        this.kqI.clear();
    }

    public static boolean apD() {
        return as.Hm().FT().ciA();
    }

    public final void apE() {
        x.i("MicroMsg.BackupPcRecoverServer", "clearContinueRecoverData");
        this.kqI.clear();
    }

    public final void a(boolean z, boolean z2, int i) {
        int i2 = 0;
        x.i("MicroMsg.BackupPcRecoverServer", "cancel isSelf[%b], needClearContinueRecoverData[%b], caller:%s", Boolean.valueOf(z), Boolean.valueOf(z2), aj.cgu());
        ktA = true;
        if (!z) {
            b.apZ().aqa();
            c.apH();
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
            b.apZ().aoS().kov = i;
            mR(i);
        }
        if (z2) {
            apE();
        }
        b.aqr();
        b.aqt();
        b.aqv();
    }

    public final void nb(int i) {
        long j = 0;
        if (this.kqJ != 0) {
            j = bi.bA(this.kqJ);
        }
        g.pWK.h(13737, Integer.valueOf(i), Long.valueOf(this.fxb / 1024), Long.valueOf(j / 1000), Integer.valueOf(2), Integer.valueOf(b.apZ().aqa().ktv));
        x.i("MicroMsg.BackupPcRecoverServer", "backupPcServerKvStat kvNum[%d], errcode[%d], backupDataSize[%d kb], recoverCostTime[%d s]", Integer.valueOf(13737), Integer.valueOf(i), Long.valueOf(this.fxb / 1024), Long.valueOf(j / 1000));
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
            x.printErrStackTrace("MicroMsg.BackupPcRecoverServer", e, "sendResp", new Object[0]);
        }
    }

    private static void c(int i, int i2, long j) {
        o oVar = new o();
        oVar.ID = b.apZ().kon;
        oVar.kyY = i;
        oVar.kyT = com.tencent.mm.plugin.backup.a.g.bI(j);
        try {
            x.i("MicroMsg.BackupPcRecoverServer", "send start resp, status[%d]", Integer.valueOf(i));
            b.o(oVar.toByteArray(), 4, i2);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupPcRecoverServer", e, "buf to BackupStartRequest err.", new Object[0]);
        }
    }

    public final void apj() {
        synchronized (this.lock) {
            if (this.hpb) {
                x.e("MicroMsg.BackupPcRecoverServer", "startMerge isCancel true.");
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
                b.apZ().aoS().F(26, 1, ciB);
                mR(26);
                if (this.kqD == null) {
                    this.kqD = new LinkedList();
                }
                if (this.kqE == null) {
                    this.kqE = new LinkedList();
                }
                this.kqK = bi.Wy();
                this.kqC = new com.tencent.mm.plugin.backup.b.d(b.apZ(), 1, this, ciB, this.kpU, this.kqD, this.kqE);
                this.kqC.apj();
                g.pWK.a(400, 24, 1, false);
            } else {
                x.e("MicroMsg.BackupPcRecoverServer", "startMerge hasStartMerge, return.");
            }
        }
    }

    public final void mR(final int i) {
        final Set hashSet = new HashSet();
        hashSet.addAll(this.ktB);
        ah.y(new Runnable() {
            public final void run() {
                for (c mR : hashSet) {
                    mR.mR(i);
                }
            }
        });
        if (this.ktC != null) {
            ah.y(new Runnable() {
                public final void run() {
                    if (d.this.ktC != null) {
                        d.this.ktC.mQ(i);
                    }
                }
            });
        }
    }

    public final void aoR() {
        apE();
        g.pWK.a(400, 27, 1, false);
        g.pWK.a(400, 28, bi.bA(this.kqK) / 1000, false);
        b.aqr();
        b.aqt();
    }
}
