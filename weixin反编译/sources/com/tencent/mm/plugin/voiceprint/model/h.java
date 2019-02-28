package com.tencent.mm.plugin.voiceprint.model;

import android.os.Handler;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.modelsimple.m;
import com.tencent.mm.modelvoice.g;
import com.tencent.mm.modelvoice.l;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.bun;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.ay.a;
import com.tencent.mm.y.ay.b;

public final class h extends k implements com.tencent.mm.network.k {
    private String filename;
    e gLE;
    private final q hoZ;
    public boolean smM = false;
    private boolean smN = false;
    private Handler smO = null;
    private int smP = 0;
    int smS = 0;
    String smV = "";
    private int wn = 0;

    public h(String str, int i, String str2) {
        x.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "resid %d vertifyTicket %s", Integer.valueOf(i), bi.aD(str2, ""));
        this.hoZ = new c();
        a aVar = (a) this.hoZ.Kh();
        this.filename = str;
        this.wn = 0;
        aVar.hia.wPL = i;
        aVar.hia.wwk = str2;
        this.smP = 0;
        aVar.hia.wPJ = 0;
        x.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "voiceRegist %d %d", Integer.valueOf(i), Integer.valueOf(0));
        this.smM = true;
        bGo();
    }

    protected final int a(q qVar) {
        return b.hoz;
    }

    protected final int Bo() {
        return 240;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.hoZ, this);
    }

    private int bGo() {
        a aVar = (a) this.hoZ.Kh();
        bun bun = new bun();
        g gVar = new g();
        aVar.hia.xbO = bun;
        l lVar = new l(m.aJ(this.filename, false));
        int bN = com.tencent.mm.a.e.bN(m.aJ(this.filename, false));
        if (bN - this.wn >= 6000) {
            gVar = lVar.bp(this.wn, 6000);
        } else {
            gVar = lVar.bp(this.wn, bN - this.wn);
        }
        x.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "read offset %d, ret %d , buf len %d, totallen %d finish %b", Integer.valueOf(this.wn), Integer.valueOf(gVar.ret), Integer.valueOf(gVar.flJ), Integer.valueOf(bN), Boolean.valueOf(this.smM));
        if (gVar.flJ == 0) {
            return -2;
        }
        if (gVar.ret < 0) {
            x.w("MicroMsg.NetSceneRsaVertifyVoicePrint", "readerror %d", Integer.valueOf(gVar.ret));
            return -1;
        } else if (this.wn >= 469000) {
            x.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "moffset > maxfile %d", Integer.valueOf(this.wn));
            return -1;
        } else {
            bun.xbY = new bes().bl(gVar.buf);
            bun.vPt = this.wn;
            bun.xbW = gVar.flJ;
            bun.xbX = 0;
            aVar.hia.wPJ = this.smP;
            if (this.smM && gVar.hXV >= com.tencent.mm.a.e.bN(m.aJ(this.filename, false))) {
                bun.xbX = 1;
                this.smN = true;
                x.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "the last one pack for uploading totallen %d", Integer.valueOf(bN));
            }
            this.wn = gVar.hXV;
            aVar.hia.xbO = bun;
            return 0;
        }
    }

    public final int getType() {
        return 617;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        b bVar = (b) qVar.Hv();
        if (i2 == 4 && i3 == -102) {
            final int i4 = qVar.Kh().vHZ.ver;
            x.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", Integer.valueOf(i4));
            as.Dt().F(new Runnable() {
                public final void run() {
                    new m().a(h.this.hok, new e() {
                        public final void a(int i, int i2, String str, k kVar) {
                            x.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "summerauth dkcert getcert type:%d ret [%d,%d]", Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
                            if (i == 0 && i2 == 0) {
                                h.this.a(h.this.hok, h.this.gLE);
                            } else {
                                h.this.gLE.a(i, i2, "", h.this);
                            }
                        }
                    });
                }
            });
        } else if (i2 == 0 || i3 == 0) {
            this.smP = bVar.hib.wPJ;
            this.smS = bVar.hib.wcX;
            this.smV = bVar.hib.xbP;
            String str2 = "MicroMsg.NetSceneRsaVertifyVoicePrint";
            String str3 = "voice VoiceTicket %d mResult %d mAuthPwd is null: %b, mAuthPwd.len: %d";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(bVar.hib.wPJ);
            objArr[1] = Integer.valueOf(this.smS);
            objArr[2] = Boolean.valueOf(bi.oN(this.smV));
            objArr[3] = Integer.valueOf(bi.oN(this.smV) ? 0 : this.smV.length());
            x.i(str2, str3, objArr);
            if (this.smN) {
                this.gLE.a(i2, i3, str, this);
                return;
            }
            x.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "tryDoScene ret %d", Integer.valueOf(bGo()));
            a(this.hok, this.gLE);
            x.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "loop doscene");
        } else {
            this.gLE.a(i2, i3, str, this);
        }
    }
}
