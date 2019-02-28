package com.tencent.mm.plugin.voiceprint.model;

import android.os.Handler;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.modelvoice.g;
import com.tencent.mm.modelvoice.l;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.bue;
import com.tencent.mm.protocal.c.buf;
import com.tencent.mm.protocal.c.bun;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends k implements com.tencent.mm.network.k {
    private String filename;
    private final b gLB;
    private e gLE;
    public boolean smM = false;
    private boolean smN = false;
    private Handler smO = null;
    private int smP = 0;
    int smS = 0;
    private String smV = "";
    private int wn = 0;

    public j(String str, int i) {
        x.d("MicroMsg.NetSceneVerifyVoicePrint", "resid %d", Integer.valueOf(i));
        a aVar = new a();
        aVar.hnT = new bue();
        aVar.hnU = new buf();
        aVar.uri = "/cgi-bin/micromsg-bin/verifyvoiceprint";
        aVar.hnS = 613;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        bue bue = (bue) this.gLB.hnQ.hnY;
        this.filename = str;
        this.wn = 0;
        bue.wPL = i;
        this.smP = 0;
        bue.wPJ = 0;
        x.i("MicroMsg.NetSceneVerifyVoicePrint", "voiceRegist %d %d", Integer.valueOf(i), Integer.valueOf(0));
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
        return a(eVar, this.gLB, this);
    }

    private int bGo() {
        bue bue = (bue) this.gLB.hnQ.hnY;
        bun bun = new bun();
        g gVar = new g();
        bue.xbO = bun;
        l lVar = new l(m.aJ(this.filename, false));
        int bN = com.tencent.mm.a.e.bN(m.aJ(this.filename, false));
        if (bN - this.wn >= 6000) {
            gVar = lVar.bp(this.wn, 6000);
        } else {
            gVar = lVar.bp(this.wn, bN - this.wn);
        }
        x.d("MicroMsg.NetSceneVerifyVoicePrint", "read offset %d, ret %d , buf len %d, totallen %d finish %b", Integer.valueOf(this.wn), Integer.valueOf(gVar.ret), Integer.valueOf(gVar.flJ), Integer.valueOf(bN), Boolean.valueOf(this.smM));
        if (gVar.flJ == 0) {
            return -2;
        }
        if (gVar.ret < 0) {
            x.w("MicroMsg.NetSceneVerifyVoicePrint", "readerror %d", Integer.valueOf(gVar.ret));
            return -1;
        } else if (this.wn >= 469000) {
            x.i("MicroMsg.NetSceneVerifyVoicePrint", "moffset > maxfile %d", Integer.valueOf(this.wn));
            return -1;
        } else {
            bun.xbY = new bes().bl(gVar.buf);
            bun.vPt = this.wn;
            bun.xbW = gVar.flJ;
            bun.xbX = 0;
            bue.wPJ = this.smP;
            if (this.smM && gVar.hXV >= com.tencent.mm.a.e.bN(m.aJ(this.filename, false))) {
                bun.xbX = 1;
                this.smN = true;
                x.i("MicroMsg.NetSceneVerifyVoicePrint", "the last one pack for uploading totallen %d", Integer.valueOf(bN));
            }
            this.wn = gVar.hXV;
            bue.xbO = bun;
            return 0;
        }
    }

    public final int getType() {
        return 613;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneVerifyVoicePrint", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        buf buf = (buf) ((b) qVar).hnR.hnY;
        if (i2 == 0 || i3 == 0) {
            this.smP = buf.wPJ;
            this.smS = buf.wcX;
            x.i("MicroMsg.NetSceneVerifyVoicePrint", "voice VoiceTicket %d mResult %d", Integer.valueOf(buf.wPJ), Integer.valueOf(this.smS));
            if (this.smN) {
                this.gLE.a(i2, i3, str, this);
                return;
            }
            x.i("MicroMsg.NetSceneVerifyVoicePrint", "tryDoScene ret %d", Integer.valueOf(bGo()));
            a(this.hok, this.gLE);
            x.i("MicroMsg.NetSceneVerifyVoicePrint", "loop doscene");
            return;
        }
        this.gLE.a(i2, i3, str, this);
    }
}
