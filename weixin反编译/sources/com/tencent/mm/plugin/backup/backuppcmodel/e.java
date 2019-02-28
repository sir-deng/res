package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.SharedPreferences.Editor;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.backup.a.b.b;
import com.tencent.mm.plugin.backup.a.b.c;
import com.tencent.mm.plugin.backup.a.f;
import com.tencent.mm.plugin.backup.f.b.d;
import com.tencent.mm.plugin.backup.f.h;
import com.tencent.mm.plugin.backup.f.j;
import com.tencent.mm.plugin.backup.h.m;
import com.tencent.mm.plugin.backup.h.o;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.y.as;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class e {
    private static boolean kpU = false;
    private static boolean krt = false;
    static boolean ktJ = false;
    private b kpa = new b() {
        public final void mR(final int i) {
            final Set hashSet = new HashSet();
            hashSet.addAll(e.this.ktB);
            ah.y(new Runnable() {
                public final void run() {
                    for (c mR : hashSet) {
                        mR.mR(i);
                    }
                }
            });
            if (e.this.ktC != null) {
                ah.y(new Runnable() {
                    public final void run() {
                        if (e.this.ktC != null) {
                            e.this.ktC.mQ(i);
                        }
                    }
                });
            }
        }

        public final void aoO() {
            g.pWK.a(400, 11, 1, false);
            g.pWK.a(400, 12, e.this.kro == null ? 0 : bi.bA(e.this.kro.kpd) / 1000, false);
            g.pWK.a(400, 13, e.this.kro == null ? 0 : e.this.kro.apf(), false);
            e.this.nb(0);
            if (!e.this.ktE) {
                e.this.nb(21);
            }
        }

        public final void aoP() {
            x.i("MicroMsg.BackupPcServer", "onBackupPackAndSendCallback onCancel, isSelf[%b]", Boolean.valueOf(false));
            e.this.an(false);
            g.pWK.a(400, 120, 1, false);
        }
    };
    final com.tencent.mm.ad.e krd = new com.tencent.mm.ad.e() {
        public final void a(int i, int i2, String str, k kVar) {
            com.tencent.mm.plugin.backup.f.b.b(3, e.this.krd);
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.BackupPcServer", "onSendStartRequestEnd receive startResp success, errMsg[%s]", str);
                o oVar = ((j) kVar).kvp;
                if (b.apZ().kon.equals(oVar.ID)) {
                    b.apZ().aoS().koy = oVar.kyQ;
                    x.i("MicroMsg.BackupPcServer", "onSendStartRequestEnd startResp BigDataSize[%d]", Long.valueOf(oVar.kyQ));
                    as.Hm();
                    com.tencent.mm.y.c.Db().a(a.USERINFO_BACKUP_OLD_RECORDS_BOOLEAN, Boolean.valueOf(false));
                    com.tencent.mm.plugin.backup.f.b.aqq();
                    e.a(e.this);
                    return;
                }
                x.e("MicroMsg.BackupPcServer", "onSendStartRequestEnd startResp not the same id");
                g.pWK.a(400, 118, 1, false);
                b.apZ().aoS().kov = -5;
                e.this.nc(-5);
                return;
            }
            x.e("MicroMsg.BackupPcServer", "onSendStartRequestEnd receive startResp failed, errType[%d], errCode[%d], errMsg[%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
            g.pWK.a(400, 117, 1, false);
            b.apZ().aoS().kov = -5;
            e.this.nc(-5);
        }
    };
    LinkedList<String> krm;
    private com.tencent.mm.plugin.backup.b.b krn;
    com.tencent.mm.plugin.backup.b.c kro;
    private long krp = 0;
    private long krq = 0;
    public Set<c> ktB = new HashSet();
    public com.tencent.mm.plugin.backup.a.b.a ktC;
    private boolean ktE = false;
    public boolean ktK = false;
    public boolean ktL = false;
    final com.tencent.mm.ad.e ktM = new com.tencent.mm.ad.e() {
        public final void a(int i, int i2, String str, k kVar) {
            com.tencent.mm.plugin.backup.f.b.b(11, e.this.ktM);
            if (i == 0 && i2 == 0) {
                h hVar = (h) kVar;
                LinkedList linkedList = hVar.kvd.kyC;
                LinkedList linkedList2 = hVar.kvd.kyD;
                LinkedList linkedList3 = new LinkedList();
                HashSet hashSet = new HashSet();
                Iterator it = linkedList2.iterator();
                long j = 0;
                long j2 = 0;
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < linkedList.size()) {
                        if (it.hasNext()) {
                            j = ((Long) it.next()).longValue();
                            if (it.hasNext()) {
                                j2 = ((Long) it.next()).longValue();
                            }
                        }
                        hashSet.add(linkedList.get(i4));
                        linkedList3.add(new f.a(hashSet.size() - 1, (String) linkedList.get(i4), j, j2));
                        i3 = i4 + 1;
                    } else {
                        x.i("MicroMsg.BackupPcServer", "requestSessionSceneEnd receive requestsessionResp, backupSessionList size[%d]", Integer.valueOf(linkedList3.size()));
                        com.tencent.mm.plugin.backup.b.c b = e.this.kro;
                        b.apZ().aqa();
                        b.a(linkedList3, b.apZ().aoS().koy, e.kpU);
                        return;
                    }
                }
            }
            x.e("MicroMsg.BackupPcServer", "requestSessionSceneEnd sessionName or timeInterval null or request session resp number error, errType[%d], errCode[%d], errMsg[%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
            g.pWK.a(400, 119, 1, false);
            e.this.an(false);
            b.apZ().aoS().kov = -5;
            e.this.nc(-5);
        }
    };
    private final d ktN = new d() {
        public final void a(boolean z, int i, byte[] bArr, int i2) {
            String str = "MicroMsg.BackupPcServer";
            String str2 = "onBackupPcServerNotify isLocal[%b], type[%d], seq[%d], buf[%d], isBackupFinish[%b]";
            Object[] objArr = new Object[5];
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            objArr[4] = Boolean.valueOf(e.ktJ);
            x.i(str, str2, objArr);
            if (!z || bArr == null) {
                if (1 != b.apZ().aqa().ktp && 3 != b.apZ().aqa().ktp) {
                    return;
                }
                if (i == 10) {
                    try {
                        new com.tencent.mm.plugin.backup.h.f().aH(bArr);
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.BackupPcServer", e, "onBackupPcServerNotify buf to BackupHeartBeatResponse error.", new Object[0]);
                    }
                    x.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive heartbeatResp, ack[%d]", Long.valueOf(r0.kuT));
                } else if (i == 5) {
                    x.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive cancelReq");
                    e.this.an(true);
                    b.apZ().aoS().kov = -100;
                    e.this.nc(-100);
                    g.pWK.a(400, 51, 1, false);
                    e.this.nb(5);
                } else if (i == 18) {
                    com.tencent.mm.plugin.backup.h.c cVar = new com.tencent.mm.plugin.backup.h.c();
                    try {
                        cVar.aH(bArr);
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.BackupPcServer", e2, "onBackupPcServerNotify buf to BackupCommandResponse error.", new Object[0]);
                    }
                    x.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive commandResp, cmd[%d]", Integer.valueOf(cVar.kym));
                    if (cVar.kym == 9) {
                        if (com.tencent.mm.plugin.backup.f.b.aqw() == 1) {
                            com.tencent.mm.plugin.backup.f.b.ne(2);
                            x.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify reconnect success, start resendSceneMap");
                            e.this.nb(20);
                            com.tencent.mm.plugin.backup.f.b.aqv();
                            b.apZ().aoS().kov = 14;
                            e.this.nc(14);
                            com.tencent.mm.plugin.backup.f.b.a(new com.tencent.mm.plugin.backup.f.b.b() {
                                public final void dM(boolean z) {
                                    if (z) {
                                        x.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify resendSceneMap finish");
                                        com.tencent.mm.plugin.backup.f.b.ne(0);
                                        return;
                                    }
                                    e.this.nc(b.apZ().aoS().kov);
                                }
                            });
                            return;
                        }
                        x.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify reconnect is started, ignore. state[%d]", Integer.valueOf(com.tencent.mm.plugin.backup.f.b.aqw()));
                    }
                } else if (i == 17) {
                    com.tencent.mm.plugin.backup.h.b bVar = new com.tencent.mm.plugin.backup.h.b();
                    try {
                        bVar.aH(bArr);
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.BackupPcServer", e22, "onBackupPcServerNotify buf to BackupCommandRequest error.", new Object[0]);
                    }
                    x.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive commandReq, cmd[%d]", Integer.valueOf(bVar.kym));
                    if (bVar.kym == 10) {
                        int i3 = b.apZ().aoS().kov;
                        x.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify pc request disconnect, backupPcState[%d]", Integer.valueOf(i3));
                        if (i3 == 12 || i3 == 14) {
                            e.this.an(true);
                            b.apZ().apz().stop();
                            b.apZ().aoS().kov = -4;
                            e.this.nc(-4);
                            g.pWK.a(400, 51, 1, false);
                            e.this.nb(5);
                            long j = 0;
                            if (e.this.kro.kpd != 0) {
                                j = bi.bA(e.this.kro.kpd);
                            }
                            g.pWK.h(13737, Integer.valueOf(3), Long.valueOf(e.this.kro.apf()), Long.valueOf(j / 1000), Integer.valueOf(1));
                            x.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify transfer disconnect, backupDataSize[%d kb], backupCostTime[%d s]", Long.valueOf(e.this.kro.apf()), Long.valueOf(j / 1000));
                        }
                    }
                }
            } else if (CdnLogic.kMediaTypeBeatificFile == i) {
                x.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify local disconnect, backupPcState[%d]", Integer.valueOf(b.apZ().aoS().kov));
                switch (b.apZ().aoS().kov) {
                    case DownloadResult.CODE_URL_ERROR /*-21*/:
                    case -5:
                        b.apZ().apz().stop();
                        return;
                    case -4:
                        e.this.an(true);
                        return;
                    case 1:
                    case 11:
                        b.apZ().apz().stop();
                        b.apZ().aoS().kov = -100;
                        e.this.nc(-100);
                        return;
                    case 4:
                    case 12:
                    case 14:
                        if (!b.apZ().aqa().ktt || e.ktJ) {
                            x.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify not support reconnect, disconnect");
                            e.this.an(true);
                            b.apZ().apz().stop();
                            b.apZ().aoS().kov = -4;
                            e.this.nc(-4);
                            g.pWK.a(400, 9, 1, false);
                            e.this.nb(3);
                            return;
                        }
                        switch (com.tencent.mm.plugin.backup.f.b.aqw()) {
                            case 0:
                            case 2:
                                x.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify startBackupReconnectHandler, reconnectState[%d]", Integer.valueOf(com.tencent.mm.plugin.backup.f.b.aqw()));
                                e.this.nb(19);
                                e.this.ktE = true;
                                com.tencent.mm.plugin.backup.f.b.a(b.apZ().aqa().kty);
                                return;
                            case 1:
                                x.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify already start reconnect, state[%d]", Integer.valueOf(com.tencent.mm.plugin.backup.f.b.aqw()));
                                return;
                            default:
                                return;
                        }
                    case 15:
                        b.apZ().apz().stop();
                        b.apZ().aoS().kov = -100;
                        e.this.nc(-100);
                        return;
                    default:
                        return;
                }
            }
        }
    };

    static /* synthetic */ void a(e eVar) {
        com.tencent.mm.plugin.backup.f.b.a(11, eVar.ktM);
        h hVar = new h(eVar.krm, eVar.krp, eVar.krq);
        x.i("MicroMsg.BackupPcServer", "backupPcSendRequestSession, chooseConvNames size[%d]", Integer.valueOf(eVar.krm.size()));
        hVar.aqx();
    }

    public static void aqj() {
        ktJ = true;
    }

    public final void init() {
        x.i("MicroMsg.BackupPcServer", "BackupPcServer init.");
        ktJ = false;
        this.ktE = false;
        com.tencent.mm.plugin.backup.f.b.a(this.ktN);
        this.kro = new com.tencent.mm.plugin.backup.b.c(b.apZ(), 1, this.kpa);
    }

    public final void an(boolean z) {
        x.i("MicroMsg.BackupPcServer", "cancel, isSelf[%b], Caller:%s", Boolean.valueOf(z), aj.cgu());
        ktJ = true;
        if (!z) {
            b.apZ().aqa();
            c.apH();
        }
        this.kro.cancel();
        if (this.krn != null) {
            this.krn.cancel();
            this.krn = null;
        }
        com.tencent.mm.plugin.backup.f.b.aqr();
        com.tencent.mm.plugin.backup.f.b.aqt();
        com.tencent.mm.plugin.backup.f.b.aqv();
    }

    public final void B(LinkedList<String> linkedList) {
        this.krm = linkedList;
        b.apZ();
        if (com.tencent.mm.plugin.backup.a.d.aoX().getInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0) == 1) {
            krt = true;
        } else {
            krt = false;
        }
        b.apZ();
        this.krp = com.tencent.mm.plugin.backup.a.d.aoX().getLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0);
        b.apZ();
        this.krq = com.tencent.mm.plugin.backup.a.d.aoX().getLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0);
        b.apZ();
        if (com.tencent.mm.plugin.backup.a.d.aoX().getInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0) == 1) {
            kpU = true;
        } else {
            kpU = false;
        }
        String str = "MicroMsg.BackupPcServer";
        String str2 = "setBackupChooseData users size[%d], isSelectTime[%b], isQuickBackup[%b], selectStartTime[%d], selectEndTime[%d]";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(linkedList == null ? -1 : linkedList.size());
        objArr[1] = Boolean.valueOf(krt);
        objArr[2] = Boolean.valueOf(kpU);
        objArr[3] = Long.valueOf(this.krp);
        objArr[4] = Long.valueOf(this.krq);
        x.i(str, str2, objArr);
        as.Hm();
        com.tencent.mm.y.c.Db().a(a.USERINFO_BACKUP_PC_BACKUPING_BOOLEAN, Boolean.valueOf(true));
        if (1 == b.apZ().aqa().ktp) {
            b.apZ();
            Editor edit = com.tencent.mm.plugin.backup.a.d.aoX().edit();
            edit.putString("BACKUP_PC_CHOOSE_SESSION", com.tencent.mm.plugin.backup.a.g.a("", ",", linkedList == null ? new String[0] : (String[]) linkedList.toArray(new String[linkedList.size()])));
            edit.commit();
        }
    }

    public static void d(int i, long j, long j2, int i2) {
        long j3 = 0;
        x.i("MicroMsg.BackupPcServer", "setBackupSelectTimeData, timeMode[%d], startTime[%d], endTime[%d], contentType[%d]", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2));
        if (i == 0) {
            j2 = 0;
        } else {
            j3 = j;
        }
        b.apZ();
        Editor edit = com.tencent.mm.plugin.backup.a.d.aoX().edit();
        if (1 == b.apZ().aqa().ktp) {
            edit.putInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", i);
            edit.putInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", i2);
            edit.putLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", j3);
            edit.putLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", j2);
        }
        edit.commit();
    }

    public final void bJ(long j) {
        int i = 3;
        x.i("MicroMsg.BackupPcServer", "backupPcSendStartRequest");
        com.tencent.mm.plugin.backup.f.b.a(3, this.krd);
        j jVar = new j(b.apZ().kon);
        PLong pLong = new PLong();
        PLong pLong2 = new PLong();
        as.Hm();
        com.tencent.mm.plugin.backup.a.g.a(pLong, pLong2, com.tencent.mm.y.c.FJ());
        if (!kpU) {
            as.Hm();
            if (((Boolean) com.tencent.mm.y.c.Db().get(a.USERINFO_BACKUP_OLD_RECORDS_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
                i = 0;
            } else {
                i = 1;
            }
        }
        m bI = com.tencent.mm.plugin.backup.a.g.bI(pLong2.value);
        jVar.kvo.kyQ = 0;
        jVar.kvo.kyR = j;
        jVar.kvo.kyS = 0;
        jVar.kvo.kyT = bI;
        jVar.kvo.kyU = 0;
        jVar.kvo.kyV = i;
        x.i("MicroMsg.BackupPcServer", "backupPcSendStartRequest sessionCount:%d, transferType:%d", Long.valueOf(j), Integer.valueOf(i));
        jVar.aqx();
    }

    public final void nb(int i) {
        long j;
        long j2 = 0;
        if (this.kro != null) {
            if (this.kro.kpd != 0) {
                j2 = bi.bA(this.kro.kpd);
            }
            j = j2;
            j2 = this.kro.apf();
        } else {
            j = 0;
            j2 = 0;
        }
        g.pWK.h(13737, Integer.valueOf(i), Long.valueOf(j2), Long.valueOf(j / 1000), Integer.valueOf(1), Integer.valueOf(b.apZ().aqa().ktv));
        x.i("MicroMsg.BackupPcServer", "backupPcServerKvStat kvNum[%d], errcode[%d], backupDataSize[%d kb], backupCostTime[%d s]", Integer.valueOf(13737), Integer.valueOf(i), Long.valueOf(j2), Long.valueOf(j / 1000));
    }

    public final void aoQ() {
        final Set hashSet = new HashSet();
        hashSet.addAll(this.ktB);
        ah.y(new Runnable() {
            public final void run() {
                for (c aoQ : hashSet) {
                    aoQ.aoQ();
                }
            }
        });
    }

    public final void nc(int i) {
        this.kpa.mR(i);
    }
}
