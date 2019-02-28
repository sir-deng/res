package com.tencent.mm.plugin.backup.c;

import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.a.k;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.backup.a.b.b;
import com.tencent.mm.plugin.backup.f.b.c;
import com.tencent.mm.plugin.backup.f.f.a;
import com.tencent.mm.plugin.backup.f.i;
import com.tencent.mm.plugin.backup.h.e;
import com.tencent.mm.plugin.backup.h.f;
import com.tencent.mm.plugin.backup.h.j;
import com.tencent.mm.plugin.backup.h.m;
import com.tencent.mm.plugin.backup.h.o;
import com.tencent.mm.plugin.backup.h.v;
import com.tencent.mm.plugin.backup.h.w;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.Iterator;
import java.util.LinkedList;

public final class d implements b, com.tencent.mm.plugin.backup.f.b.d {
    public static boolean kpU = false;
    public static boolean krt = false;
    public byte[] bitmapData;
    public com.tencent.mm.plugin.backup.a.b.d kpP;
    public boolean kqQ = false;
    public c krg = new c() {
        public final void apM() {
            x.i("MicroMsg.BackupMoveServer", "stopCallback ");
            com.tencent.mm.plugin.backup.f.b.aqr();
            b.apy().aoU();
        }
    };
    private final a krh = new a() {
        public final void mX(int i) {
            int i2 = b.apy().aoS().kov;
            x.i("MicroMsg.BackupMoveServer", "heartBeatTimeoutCallback, heartBeatState[%d], state[%d]", Integer.valueOf(i), Integer.valueOf(i2));
            switch (i) {
                case 0:
                    if (i2 == 4) {
                        b.apy().aoS().kov = 14;
                        d.this.mR(14);
                        return;
                    }
                    return;
                case 1:
                    if (i2 == 14) {
                        b.apy().aoS().kov = 4;
                        d.this.mR(4);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    public final i.a kri = new i.a() {
        public final void apK() {
            d.this.mR(b.apy().aoS().kov);
        }

        public final void mW(int i) {
        }

        public final void apL() {
            int i = b.apy().aoS().kov;
            x.e("MicroMsg.BackupMoveServer", "speedOverTime callback, state[%d]", Integer.valueOf(i));
            if (i == 14 || i == 4) {
                d.this.an(true);
                b.apy().apz().stop();
                b.apy().aoS().kov = -4;
                d.this.mR(-4);
            }
        }
    };
    public LinkedList<String> krm;
    private com.tencent.mm.plugin.backup.b.b krn;
    private com.tencent.mm.plugin.backup.b.c kro;
    public long krp = 0;
    public long krq = 0;
    public boolean krr = false;
    public int krs = 0;
    private int kru;
    private int krv;
    private int krw = 0;
    public e krx = new e(new e.a() {
        public final void k(int i, byte[] bArr) {
            if (bArr != null) {
                d.this.bitmapData = bArr;
            }
            d.this.mR(i);
        }
    }, b.apy().aoS());

    public final void an(boolean z) {
        x.e("MicroMsg.BackupMoveServer", "summerbak BackupMoveServer CANCEL, Caller:%s", aj.cgu());
        if (!z) {
            apH();
        }
        if (this.kro != null) {
            this.kro.cancel();
        }
        if (this.krn != null) {
            this.krn.cancel();
            this.krn = null;
        }
        x.i("MicroMsg.BackupMoveServer", "cancel , notifyall.");
        com.tencent.mm.plugin.backup.f.b.aqr();
        com.tencent.mm.plugin.backup.f.b.aqt();
    }

    public static void c(int i, long j, long j2, int i2) {
        long j3 = 0;
        x.i("MicroMsg.BackupMoveServer", "setBakupSelectTimeData, timeMode[%d], startTime[%d], endTime[%d], contentType[%d]", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2));
        if (i == 0) {
            j2 = 0;
        } else {
            j3 = j;
        }
        b.apy();
        Editor edit = com.tencent.mm.plugin.backup.a.d.aoX().edit();
        edit.putInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", i);
        edit.putLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", j3);
        edit.putLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", j2);
        edit.putInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", i2);
        edit.commit();
    }

    public final void a(boolean z, int i, byte[] bArr, int i2) {
        String str = "MicroMsg.BackupMoveServer";
        String str2 = "summerbak onNotify isLocal:%b type:%d seq:%d buf:%d";
        Object[] objArr = new Object[4];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        x.i(str, str2, objArr);
        if (z && bArr != null && CdnLogic.kMediaTypeBeatificFile == i) {
            x.i("MicroMsg.BackupMoveServer", "summerbak local disconnect, backupMoveState:%d", Integer.valueOf(b.apy().aoS().kov));
            switch (b.apy().aoS().kov) {
                case DownloadResult.CODE_CONNECTION_TIMEOUT_EXCEPTION /*-23*/:
                case DownloadResult.CODE_URL_ERROR /*-21*/:
                case -5:
                    b.apy().apz().stop();
                    break;
                case -4:
                    an(true);
                    break;
                case 1:
                    b.apy().apz().stop();
                    b.apy().aoS().kov = -100;
                    mR(-100);
                    break;
                case 12:
                case 14:
                    an(true);
                    b.apy().apz().stop();
                    b.apy().aoS().kov = -4;
                    mR(-4);
                    g.pWK.a(485, 24, 1, false);
                    if (!(this.kro == null || this.kro.kpd == 0)) {
                        long bA = bi.bA(this.kro.kpd);
                        x.i("MicroMsg.BackupMoveServer", "onNotify backup transfer disconnect, backupDataSize:%d kb, backupCostTime:%d s", Long.valueOf(this.kro.apf()), Long.valueOf(bA / 1000));
                        break;
                    }
            }
        }
        if (i == 1) {
            v vVar = (v) com.tencent.mm.plugin.backup.a.g.a(new v(), bArr);
            if (vVar == null) {
                x.e("MicroMsg.BackupMoveServer", "authReq parseBuf failed:%d", Integer.valueOf(bi.bz(bArr)));
                b.apy().aoS().kov = -5;
                mR(-5);
                return;
            }
            if (bi.oN(b.apy().kon)) {
                b.apy().kon = vVar.ID;
            }
            if (vVar.ID.equals(b.apy().kon)) {
                x.i("MicroMsg.BackupMoveServer", "authReq info, id:%s, step:%d", vVar.ID, Integer.valueOf(vVar.kzx));
                if (vVar.kzx == 0) {
                    if (!b.apy().koo.equals(new String(k.a(vVar.kyn.oz, com.tencent.mm.plugin.backup.a.d.aoW())))) {
                        w wVar = new w();
                        wVar.kzx = 0;
                        wVar.ID = b.apy().kon;
                        wVar.kyY = 1;
                        x.e("MicroMsg.BackupMoveServer", "get authReq step 0, but hello failed");
                        try {
                            x.i("MicroMsg.BackupMoveServer", "summerbak send authFailResp.");
                            com.tencent.mm.plugin.backup.f.b.o(wVar.toByteArray(), 2, i2);
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.BackupMoveServer", e, "buf to PACKET_TYPE_AUTHENTICATE_RESPONSE err.", new Object[0]);
                        }
                        b.apy().aoS().kov = -5;
                        mR(-5);
                    }
                    if (vVar.kzy < com.tencent.mm.plugin.backup.a.c.kof) {
                        x.i("MicroMsg.BackupMoveServer", "summerbak old move, version:%d", Integer.valueOf(vVar.kzy));
                        g.pWK.a(485, 103, 1, false);
                        b.apy().aoS().kov = -12;
                        mR(-12);
                        return;
                    }
                    x.i("MicroMsg.BackupMoveServer", "summerbak start move");
                    this.krv = i2;
                    if (krt || kpU) {
                        if (krt && kpU && (vVar.kzA & com.tencent.mm.plugin.backup.a.c.kok) == 0 && (vVar.kzA & com.tencent.mm.plugin.backup.a.c.kol) == 0) {
                            b.apy().aoS().kov = -31;
                            mR(-31);
                            this.krw = 1;
                            return;
                        } else if (krt && (vVar.kzA & com.tencent.mm.plugin.backup.a.c.kok) == 0) {
                            b.apy().aoS().kov = -32;
                            mR(-32);
                            this.krw = 2;
                            return;
                        } else if (kpU && (vVar.kzA & com.tencent.mm.plugin.backup.a.c.kol) == 0) {
                            b.apy().aoS().kov = -33;
                            mR(-33);
                            this.krw = 3;
                            return;
                        }
                    }
                    dJ(false);
                    return;
                } else if (vVar.kzx == 1) {
                    if (!b.apy().kop.equals(new String(k.a(vVar.kyn.oz, com.tencent.mm.plugin.backup.a.d.aoW())))) {
                        x.e("MicroMsg.BackupMoveServer", "get authReq step 1 and validate ok failed");
                        b.apy().aoS().kov = -5;
                        mR(-5);
                    }
                    x.i("MicroMsg.BackupMoveServer", "get authReq step 1 and validate ok success");
                    b.apy().aoS().kov = 2;
                    mR(2);
                    return;
                } else {
                    return;
                }
            }
            x.e("MicroMsg.BackupMoveServer", "id not equel:self:%s, authReq.id:%s", b.apy().kon, vVar.ID);
            an(false);
            b.apy().aoS().kov = -5;
            mR(-5);
        } else if (i == 3) {
            this.kru = i2;
            if (b.apy().apC().kqt) {
                apN();
            } else {
                this.krr = true;
            }
        } else if (i == 9) {
            e eVar = (e) com.tencent.mm.plugin.backup.a.g.a(new e(), bArr);
            if (eVar == null) {
                x.e("MicroMsg.BackupMoveServer", "heartBeatRequest parseBuf failed:%d", Integer.valueOf(bi.bz(bArr)));
                return;
            }
            x.i("MicroMsg.BackupMoveServer", "summerbak receive heartbeatReq,req:%s ack:%d", eVar, Long.valueOf(eVar.kuT));
            f fVar = (f) com.tencent.mm.plugin.backup.a.g.a(new f(), bArr);
            fVar.kuT = eVar.kuT;
            try {
                x.i("MicroMsg.BackupMoveServer", "summerbak send heartbeatResp");
                com.tencent.mm.plugin.backup.f.b.o(fVar.toByteArray(), 10, i2);
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.BackupMoveServer", e2, "summerbak buf to BackupHeartBeatResponse err.", new Object[0]);
            }
        } else if (i == 10) {
            try {
                new f().aH(bArr);
            } catch (Throwable e22) {
                x.printErrStackTrace("MicroMsg.BackupMoveServer", e22, "summerbak heartbeatResp parse from buf error.", new Object[0]);
            }
        } else if (i == 5) {
            x.i("MicroMsg.BackupMoveServer", "summerbak receive command cancel");
            an(true);
            b.apy().aoS().kov = -100;
            mR(-100);
        } else if (i == 12) {
            j jVar = (j) com.tencent.mm.plugin.backup.a.g.a(new j(), bArr);
            if (jVar == null) {
                x.e("MicroMsg.BackupMoveServer", "requestSessionResp parseBuf failed:%d", Integer.valueOf(bi.bz(bArr)));
                b.apy().aoS().kov = -5;
                mR(-5);
                return;
            }
            int i3;
            LinkedList b = b(jVar.kyC, jVar.kyD);
            str2 = "MicroMsg.BackupMoveServer";
            String str3 = "summerbak backup receive requestsession response. backupSessionList:%d ";
            Object[] objArr2 = new Object[1];
            if (b == null) {
                i3 = -1;
            } else {
                i3 = b.size();
            }
            objArr2[0] = Integer.valueOf(i3);
            x.i(str2, str3, objArr2);
            if (b == null) {
                x.e("MicroMsg.BackupMoveServer", "requestSessionResp sessionName or timeInterval null or requestSessionResp number error.");
                apH();
                b.apy().aoS().kov = -21;
                mR(-21);
                return;
            }
            com.tencent.mm.plugin.backup.f.b.a(this.krh);
            com.tencent.mm.plugin.backup.f.b.aqq();
            this.kro = new com.tencent.mm.plugin.backup.b.c(b.apy(), 2, this);
            this.kro.dG(false);
            this.kro.a(b, b.apy().aoS().koy, kpU);
        }
    }

    public final void dJ(boolean z) {
        if (z) {
            switch (this.krw) {
                case 1:
                    krt = false;
                    kpU = false;
                    this.krp = 0;
                    this.krq = 0;
                    break;
                case 2:
                    krt = false;
                    this.krp = 0;
                    this.krq = 0;
                    break;
                case 3:
                    kpU = false;
                    break;
            }
        }
        w wVar = new w();
        wVar.kzx = 0;
        wVar.ID = b.apy().kon;
        wVar.kzy = com.tencent.mm.plugin.backup.a.c.kof;
        wVar.kyY = 0;
        wVar.kzz = this.krs;
        wVar.kyn = new com.tencent.mm.bp.b(k.b(b.apy().kop.getBytes(), com.tencent.mm.plugin.backup.a.d.aoW()));
        if (bi.getInt(com.tencent.mm.j.g.Af().getValue("ChattingRecordsKvstatDisable"), 0) == 0) {
            wVar.kzA |= com.tencent.mm.plugin.backup.a.c.koj;
        }
        wVar.kzA |= com.tencent.mm.plugin.backup.a.c.kok;
        wVar.kzA |= com.tencent.mm.plugin.backup.a.c.kol;
        try {
            x.i("MicroMsg.BackupMoveServer", "summerbak send authSuccessResp.");
            com.tencent.mm.plugin.backup.f.b.o(wVar.toByteArray(), 2, this.krv);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupMoveServer", e, "buf to PACKET_TYPE_AUTHENTICATE_RESPONSE err.", new Object[0]);
        }
    }

    public final void apN() {
        x.i("MicroMsg.BackupMoveServer", "startRequestNotify receive start request.");
        this.krr = false;
        b.apy().aoS().kov = 12;
        mR(12);
        com.tencent.mm.plugin.backup.g.d.aqL().aqO();
        if (this.krm != null) {
            long j;
            x.i("MicroMsg.BackupMoveServer", "transfer conversation size:%d", Integer.valueOf(this.krm.size()));
            o oVar = new o();
            oVar.ID = b.apy().kon;
            oVar.kyW = (long) this.krm.size();
            a apC = b.apy().apC();
            if (apC.apv() == null) {
                j = 0;
            } else {
                Iterator it = apC.apv().iterator();
                j = 0;
                while (it.hasNext()) {
                    j = ((com.tencent.mm.plugin.backup.a.f.b) it.next()).koE + j;
                }
            }
            oVar.kyX = j;
            oVar.kyY = 0;
            oVar.kyZ = this.kqQ ? com.tencent.mm.plugin.backup.a.c.koe : com.tencent.mm.plugin.backup.a.c.kod;
            if (kpU) {
                oVar.kyV = 3;
            }
            m mVar = new m();
            mVar.kyJ = q.yM();
            mVar.kyK = Build.MANUFACTURER;
            mVar.kyL = Build.MODEL;
            mVar.kyM = "Android";
            mVar.kyN = VERSION.RELEASE;
            mVar.kyO = com.tencent.mm.protocal.d.vHl;
            mVar.kyP = 0;
            x.i("MicroMsg.BackupMoveServer", "startRequestNotify generalinfo wechatversion:%s", Integer.valueOf(com.tencent.mm.protocal.d.vHl));
            oVar.kyT = mVar;
            try {
                com.tencent.mm.plugin.backup.f.b.o(oVar.toByteArray(), 4, this.kru);
                x.i("MicroMsg.BackupMoveServer", "backupSendRequestSession sessionName[%d], startTime[%d], endTime[%d]", Integer.valueOf(this.krm.size()), Long.valueOf(this.krp), Long.valueOf(this.krq));
                com.tencent.mm.plugin.backup.h.i iVar = new com.tencent.mm.plugin.backup.h.i();
                iVar.kyC = this.krm;
                iVar.kyD = new LinkedList();
                Iterator it2 = this.krm.iterator();
                while (it2.hasNext()) {
                    it2.next();
                    iVar.kyD.add(Long.valueOf(r0));
                    iVar.kyD.add(Long.valueOf(j));
                }
                try {
                    x.i("MicroMsg.BackupMoveServer", "backupSendRequestSession, chooseConvNames size:%d", Integer.valueOf(this.krm.size()));
                    com.tencent.mm.plugin.backup.f.b.G(iVar.toByteArray(), 11);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.BackupMoveServer", e, "backupSendRequestSession BackupRequestSession parse req failed.", new Object[0]);
                }
            } catch (Throwable e2) {
                x.e("MicroMsg.BackupMoveServer", "startRequestNotify prase startResp error!!");
                x.printErrStackTrace("MicroMsg.BackupMoveServer", e2, "", new Object[0]);
            }
        }
    }

    private static void apH() {
        com.tencent.mm.plugin.backup.h.a aVar = new com.tencent.mm.plugin.backup.h.a();
        aVar.ID = b.apy().kon;
        try {
            x.i("MicroMsg.BackupMoveServer", "backupSendCancelRequest.");
            com.tencent.mm.plugin.backup.f.b.G(aVar.toByteArray(), 5);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupMoveServer", e, "buf to BackupCancelRequest err.", new Object[0]);
        }
    }

    public static String apO() {
        return com.tencent.mm.plugin.backup.f.b.aqu();
    }

    public final void mR(final int i) {
        if (this.kpP != null) {
            ah.y(new Runnable() {
                public final void run() {
                    if (d.this.kpP != null) {
                        d.this.kpP.mR(i);
                    }
                }
            });
        }
    }

    public final void aoO() {
    }

    public final void aoP() {
        an(false);
    }

    private static LinkedList<com.tencent.mm.plugin.backup.a.f.a> b(LinkedList<String> linkedList, LinkedList<Long> linkedList2) {
        long j = 0;
        if (linkedList == null || linkedList2 == null || linkedList.isEmpty() || linkedList.size() * 2 != linkedList2.size()) {
            return null;
        }
        LinkedList<com.tencent.mm.plugin.backup.a.f.a> linkedList3 = new LinkedList();
        Iterator it = linkedList2.iterator();
        long j2 = 0;
        for (int i = 0; i < linkedList.size(); i++) {
            if (it.hasNext()) {
                j2 = ((Long) it.next()).longValue();
                if (it.hasNext()) {
                    j = ((Long) it.next()).longValue();
                }
            }
            linkedList3.add(new com.tencent.mm.plugin.backup.a.f.a(i, (String) linkedList.get(i), j2, j));
        }
        return linkedList3;
    }
}
