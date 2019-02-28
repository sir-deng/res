package com.tencent.mm.plugin.backup.c;

import android.os.Looper;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.ad.k;
import com.tencent.mm.lan_cs.Server;
import com.tencent.mm.lan_cs.Server.Java2C;
import com.tencent.mm.plugin.backup.a.g;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.et;
import com.tencent.mm.protocal.c.eu;
import com.tencent.mm.protocal.c.pd;
import com.tencent.mm.protocal.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.io.IOException;
import java.util.LinkedList;

public final class e {
    com.tencent.mm.plugin.backup.a.e koq;
    String krA;
    private String krB = "";
    private boolean krC = false;
    a krD;
    private al krE = new al(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean uG() {
            e.this.apP();
            return true;
        }
    }, true);
    final com.tencent.mm.ad.e krF = new com.tencent.mm.ad.e() {
        public final void a(int i, int i2, String str, k kVar) {
            b.b(704, e.this.krF);
            x.i("MicroMsg.CheckNetworkGenQrCodeHandler", "backup move receive createQrcode response.[%d,%d,%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.backup.d.b bVar = (com.tencent.mm.plugin.backup.d.b) kVar;
                eu euVar = (eu) bVar.gLB.hnR.hnY;
                b.apy().kon = "";
                b.apy().koo = euVar.vQP;
                b.apy().kop = euVar.vQQ;
                b.apy().kqA = euVar.vQK;
                euVar = (eu) bVar.gLB.hnR.hnY;
                byte[] bArr = euVar == null ? null : euVar.vQM == null ? null : euVar.vQM.wRm.oz;
                if (bArr != null) {
                    e.this.koq.kov = 51;
                    e.this.krD.k(51, bArr);
                    return;
                }
                return;
            }
            x.e("MicroMsg.CheckNetworkGenQrCodeHandler", "create qrcode failed, errMsg:" + str);
            x.i("MicroMsg.CheckNetworkGenQrCodeHandler", "err: %d, %d, %s", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i2 == -100) {
                as.CN().a(1000, e.this.krG);
                as.CN().a(new com.tencent.mm.plugin.backup.d.a(e.this.krz, e.this.krA, b.apy().kqA), 0);
                return;
            }
            e.this.koq.kov = -11;
            e.this.krD.k(-11, null);
        }
    };
    final com.tencent.mm.ad.e krG = new com.tencent.mm.ad.e() {
        public final void a(int i, int i2, String str, k kVar) {
            b.b(1000, e.this.krG);
            x.i("MicroMsg.CheckNetworkGenQrCodeHandler", "backup move receive createOffilineQrcode response.[%d,%d,%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i == 0 && i2 == 0) {
                et etVar = ((j.b) ((com.tencent.mm.plugin.backup.d.a) kVar).hoZ.Hv()).vHQ;
                String str2 = "MicroMsg.BackupCreateQRCodeOfflineScene";
                String str3 = "onGYNetEnd QRCodeUrl:%s";
                Object[] objArr = new Object[1];
                objArr[0] = etVar == null ? "null" : etVar.vQN;
                x.i(str2, str3, objArr);
                byte[] bArr = etVar == null ? null : etVar.vQM == null ? null : etVar.vQM.wRm.oz;
                if (bArr != null) {
                    e.this.koq.kov = 51;
                    e.this.krD.k(51, bArr);
                    return;
                }
                return;
            }
            x.e("MicroMsg.CheckNetworkGenQrCodeHandler", "create offline qrcode failed, errMsg:" + str);
            e.this.koq.kov = -11;
            e.this.krD.k(-11, null);
        }
    };
    LinkedList<pd> krz;

    public interface a {
        void k(int i, byte[] bArr);
    }

    public e(a aVar, com.tencent.mm.plugin.backup.a.e eVar) {
        this.krD = aVar;
        this.koq = eVar;
    }

    public final void start() {
        x.i("MicroMsg.CheckNetworkGenQrCodeHandler", "start check network and gen qrcode handler starting:%b stop:%b .%s %s", Boolean.valueOf(this.krC), Boolean.valueOf(this.krE.cgx()), this, bi.chl());
        if (!this.krC) {
            this.krC = true;
            if (apQ()) {
                this.krB = null;
                apP();
            } else {
                this.koq.kov = -4;
                this.krD.k(-4, null);
            }
            this.krE.K(500, 500);
        }
    }

    public final void stop() {
        x.i("MicroMsg.CheckNetworkGenQrCodeHandler", "stop check network and gen qrcode handler.");
        this.krC = false;
        as.CN().b(704, this.krF);
        as.CN().b(1000, this.krG);
        this.krE.TN();
    }

    final void apP() {
        String cm = g.cm(ad.getContext());
        x.i("MicroMsg.CheckNetworkGenQrCodeHandler", "checkNetStatus newWifiName:%s  preWifiName:%s acc:%b hold:%b", cm, this.krB, Boolean.valueOf(as.Hp()), Boolean.valueOf(as.Cz()));
        if (!cm.equals(this.krB) && as.Hp()) {
            this.krB = cm;
            if (apQ()) {
                this.krC = false;
                if (as.Cz()) {
                    x.i("MicroMsg.CheckNetworkGenQrCodeHandler", "begin to netscene create QRCode offline");
                    as.CN().a(1000, this.krG);
                    as.CN().a(new com.tencent.mm.plugin.backup.d.a(this.krz, this.krA, b.apy().kqA), 0);
                    return;
                }
                x.i("MicroMsg.CheckNetworkGenQrCodeHandler", "begin to netscene create QRCode online ");
                as.CN().a(704, this.krF);
                as.CN().a(new com.tencent.mm.plugin.backup.d.b(this.krz, this.krA), 0);
                return;
            }
            this.krC = false;
        }
    }

    private boolean apQ() {
        this.krz = new LinkedList();
        PString pString = new PString();
        PInt pInt = new PInt();
        this.krA = g.cm(ad.getContext());
        x.i("MicroMsg.CheckNetworkGenQrCodeHandler", "wifiName :%s", this.krA);
        if (bi.oN(this.krA)) {
            this.koq.kov = -4;
            this.krD.k(-4, null);
            this.krB = "";
            return false;
        }
        int i;
        com.tencent.mm.plugin.backup.b.a apz = b.apy().apz();
        apz.mode = 0;
        x.i("MicroMsg.BackupCEngine", "listen, before server.stop");
        Java2C.stop();
        x.i("MicroMsg.BackupCEngine", "listen, before server.start listener");
        Server.gVZ = new com.tencent.mm.lan_cs.Server.a() {
            public final void gI(int i) {
                if (a.this.mode == 1) {
                    b.nf(i);
                }
            }

            public final void onRecv(String str, int i, byte[] bArr) {
                a.this.koI = str;
                a.this.koJ = i;
                try {
                    a.a(a.this, bArr);
                } catch (IOException e) {
                    a.this.a(true, 0, 10006, ("server readErr:" + e.toString()).getBytes());
                }
            }

            public final void Eu() {
                a.this.a(true, 0, CdnLogic.kMediaTypeBeatificFile, "listen server onDisconnect".getBytes());
            }

            public final void onConnect(String str, int i) {
                a.this.koI = str;
                a.this.koJ = i;
            }
        };
        Object[] access$000 = Java2C.start();
        if (access$000 == null || access$000.length != 3) {
            x.e("MicroMsg.BackupCEngine", "listen error");
            i = 0;
        } else {
            x.i("MicroMsg.BackupCEngine", "listen, result[%d, %s, %d]", access$000[0], access$000[1], access$000[2]);
            if (((Integer) access$000[0]).intValue() != 1) {
                i = 0;
            } else {
                pString.value = (String) access$000[1];
                pInt.value = ((Integer) access$000[2]).intValue();
                apz.mode = 1;
                i = 1;
            }
        }
        if (i == 0) {
            this.koq.kov = -4;
            this.krD.k(-4, null);
            this.krB = "";
            return false;
        }
        x.i("MicroMsg.CheckNetworkGenQrCodeHandler", "server listen result: %s, %d", pString.value, Integer.valueOf(pInt.value));
        pd pdVar = new pd();
        pdVar.weK = pString.value;
        pdVar.weL = new LinkedList();
        pdVar.weL.add(Integer.valueOf(pInt.value));
        this.krz.add(pdVar);
        return true;
    }
}
