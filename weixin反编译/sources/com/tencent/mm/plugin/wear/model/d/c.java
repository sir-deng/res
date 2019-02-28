package com.tencent.mm.plugin.wear.model.d;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.bry;
import com.tencent.mm.protocal.c.brz;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.util.UUID;

public final class c extends k implements com.tencent.mm.network.k {
    private String clientId;
    String filename = null;
    private b gLB;
    e gLE;
    public boolean hYm = false;
    private boolean hZU = false;
    private int hZY = 0;
    al hmy = new al(new a() {
        public final boolean uG() {
            long bN = ((long) com.tencent.mm.a.e.bN(c.this.filename)) - ((long) c.this.tpk);
            x.d("MicroMsg.Wear.NetSceneVoiceToText", "onTimerExpired: filename=%s | fileLength=%d | readOffset=%d | isRecordFinished=%b | canReadLength=%d", c.this.filename, Long.valueOf((long) com.tencent.mm.a.e.bN(c.this.filename)), Integer.valueOf(c.this.tpk), Boolean.valueOf(c.this.hYm), Long.valueOf(bN));
            if (bN < 3300 && !c.this.hYm) {
                return true;
            }
            if (c.this.hYm && bN <= 0) {
                return false;
            }
            if (c.this.a(c.this.hok, c.this.gLE) == -1) {
                c.this.gLE.a(3, -1, "doScene failed", c.this);
            }
            return false;
        }
    }, true);
    public int pYL;
    public String talker;
    int tpk = 0;
    public String tpl;
    public boolean tpm;

    public c(String str, String str2, int i) {
        this.pYL = i;
        this.talker = str2;
        this.filename = str;
        this.hZY = 0;
        this.clientId = UUID.randomUUID().toString();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        int bN = com.tencent.mm.a.e.bN(this.filename);
        if (bN <= 0) {
            x.e("MicroMsg.Wear.NetSceneVoiceToText", "doScene file length is zero: %s", this.filename);
            return -1;
        }
        int i = bN - this.tpk;
        if (i > 3960) {
            i = 3960;
        } else if (i < 3300 && !this.hYm) {
            x.e("MicroMsg.Wear.NetSceneVoiceToText", "try to send a buf less than MIN_SEND_BYTE_PER_PACK: canReadLen=%d | isRecordFinished=%b", Integer.valueOf(i), Boolean.valueOf(this.hYm));
            return -1;
        } else if (this.hYm) {
            this.hZU = true;
        }
        x.i("MicroMsg.Wear.NetSceneVoiceToText", "fileLength: %d | readOffset: %d | isRecordFinish=%b | endFlag=%b | filename=%s", Integer.valueOf(bN), Integer.valueOf(this.tpk), Boolean.valueOf(this.hYm), Boolean.valueOf(this.hZU), this.filename);
        byte[] d = com.tencent.mm.a.e.d(this.filename, this.tpk, i);
        if (d != null) {
            b.a aVar = new b.a();
            aVar.hnT = new bry();
            aVar.hnU = new brz();
            aVar.uri = "/cgi-bin/micromsg-bin/uploadinputvoice";
            aVar.hnS = 349;
            aVar.hnV = 158;
            aVar.hnW = 1000000158;
            this.gLB = aVar.Kf();
            bry bry = (bry) this.gLB.hnQ.hnY;
            as.Hm();
            bry.kyG = (String) com.tencent.mm.y.c.Db().get(2, (Object) "");
            bry.weD = new bes().bl(d);
            bry.vUN = this.tpk;
            bry.wZM = this.clientId;
            bry.vSa = this.hZU ? 1 : 0;
            bry.wZN = 0;
            bry.vPy = 0;
            bry.wZO = this.hZY;
            bry.vPv = 0;
            bN = a(eVar, this.gLB, this);
            this.tpk = bry.weD.wRk + bry.vUN;
            long j = this.hYm ? 0 : 500;
            x.i("MicroMsg.Wear.NetSceneVoiceToText", "doScene filename=%s | delay=%d | ret=%d", this.filename, Long.valueOf(j), Integer.valueOf(bN));
            this.hmy.K(j, j);
            return bN;
        } else if (this.hZU) {
            return 0;
        } else {
            x.e("MicroMsg.Wear.NetSceneVoiceToText", "Can not read file: canReadLen=%d | isRecordFinish=%b | endFlag=%b", Integer.valueOf(i), Boolean.valueOf(this.hYm), Boolean.valueOf(this.hZU));
            return -1;
        }
    }

    protected final int a(q qVar) {
        return b.hoz;
    }

    protected final int Bo() {
        return 20;
    }

    protected final void a(a aVar) {
        this.gLE.a(3, 0, "securityCheckError", this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.Wear.NetSceneVoiceToText", "onGYNetEnd errorType=%d | errorCode=%d |filename=%s", Integer.valueOf(i2), Integer.valueOf(i3), this.filename);
        brz brz = (brz) ((b) qVar).hnR.hnY;
        if (i2 == 0 && i3 == 0) {
            x.i("MicroMsg.Wear.NetSceneVoiceToText", "resp EndFlag=%d | Text=%s", Integer.valueOf(brz.vSa), d(brz.wZP));
            if (brz.vSa == 1) {
                this.tpm = true;
                String d = d(brz.wZP);
                if (d != null) {
                    this.tpl = d;
                }
                this.gLE.a(i2, i3, str, this);
                return;
            }
            return;
        }
        this.gLE.a(i2, i3, str, this);
    }

    private static String d(bes bes) {
        if (bes == null || bes.wRm == null) {
            return null;
        }
        return bes.wRm.cec();
    }

    public final int getType() {
        return 349;
    }
}
