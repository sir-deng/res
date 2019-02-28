package com.tencent.mm.bf;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.protocal.c.buk;
import com.tencent.mm.protocal.c.bul;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Set;

public final class c extends a implements k {
    String filename;
    private b gLB;
    e gLE;
    int hQL;
    boolean hYm;
    private long hZT;
    private boolean hZU;
    private int hZV;
    private String[] hZW;
    al hmy;
    int retCode;

    public final void US() {
        this.hYm = true;
    }

    public final String[] UT() {
        return this.hZW;
    }

    public final long UU() {
        return this.hZT;
    }

    public final Set<String> UV() {
        return null;
    }

    public c(String str, int i) {
        this.retCode = 0;
        this.hQL = 0;
        this.filename = null;
        this.hZT = -1;
        this.hZU = false;
        this.hYm = false;
        this.hZW = new String[0];
        this.hmy = new al(new a() {
            public final boolean uG() {
                long bN = (long) com.tencent.mm.a.e.bN(c.this.filename);
                x.d("MicroMsg.NetSceneVoiceAddr", g.zo() + " onTimerExpired: file:" + c.this.filename + " nowlen:" + bN + " oldoff:" + c.this.hQL + " isFin:" + c.this.hYm);
                if (bN - ((long) c.this.hQL) < 3300 && !c.this.hYm) {
                    return true;
                }
                if (c.this.a(c.this.hok, c.this.gLE) == -1) {
                    c.this.retCode = g.getLine() + 40000;
                    c.this.gLE.a(3, -1, "doScene failed", c.this);
                }
                return false;
            }
        }, true);
        this.hZT = bi.Wy();
        this.filename = str;
        this.hZV = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int i = 3960;
        this.gLE = eVar2;
        int bN = com.tencent.mm.a.e.bN(this.filename);
        x.d("MicroMsg.NetSceneVoiceAddr", g.zo() + " read file:" + this.filename + " filelen:" + bN + " oldoff:" + this.hQL + " isFin:" + this.hYm);
        if (bN <= 0) {
            x.e("MicroMsg.NetSceneVoiceAddr", "read failed :" + this.filename);
            this.retCode = g.getLine() + 40000;
            return -1;
        }
        int i2 = bN - this.hQL;
        if (i2 <= 3960) {
            if (i2 >= 3300 || this.hYm) {
                if (this.hYm) {
                    this.hZU = true;
                }
                i = i2;
            } else {
                x.e("MicroMsg.NetSceneVoiceAddr", g.zo() + " read failed :" + this.filename + "can read:" + i2 + " isfinish:" + this.hYm);
                this.retCode = g.getLine() + 40000;
                return -1;
            }
        }
        x.d("MicroMsg.NetSceneVoiceAddr", g.zo() + " read file:" + this.filename + " filelen:" + bN + " oldoff:" + this.hQL + " isFin:" + this.hYm + " endFlag:" + this.hZU);
        byte[] d = com.tencent.mm.a.e.d(this.filename, this.hQL, i);
        if (d == null) {
            x.e("MicroMsg.NetSceneVoiceAddr", g.zo() + " read failed :" + this.filename + " read:" + i);
            this.retCode = g.getLine() + 40000;
            return -1;
        }
        b.a aVar = new b.a();
        aVar.hnT = new buk();
        aVar.hnU = new bul();
        aVar.uri = "/cgi-bin/micromsg-bin/voiceaddr";
        aVar.hnS = com.tencent.mm.plugin.appbrand.jsapi.a.b.CTRL_INDEX;
        aVar.hnV = 94;
        aVar.hnW = 1000000094;
        this.gLB = aVar.Kf();
        buk buk = (buk) this.gLB.hnQ.hnY;
        buk.weD = new bes().bl(d);
        x.d("MicroMsg.NetSceneVoiceAddr", g.zo() + " read file:" + this.filename + " readlen:" + d.length + " datalen:" + buk.weD.wRm.toByteArray().length + " dataiLen:" + buk.weD.wRk + " md5:" + com.tencent.mm.a.g.s(d) + " datamd5:" + com.tencent.mm.a.g.s(buk.weD.wRm.toByteArray()));
        buk.kyG = (String) com.tencent.mm.kernel.g.Dq().Db().get(2, (Object) "");
        buk.vUN = this.hQL;
        buk.wZM = this.hZT;
        buk.vSa = this.hZU ? 1 : 0;
        buk.wZN = 0;
        buk.vPy = 0;
        buk.wZO = 0;
        buk.vPv = 0;
        buk.xbR = this.hZV;
        x.d("MicroMsg.NetSceneVoiceAddr", "clientId " + this.hZT);
        return a(eVar, this.gLB, this);
    }

    protected final int a(q qVar) {
        return b.hoz;
    }

    protected final int Bo() {
        return 20;
    }

    protected final void a(a aVar) {
        this.gLE.a(3, g.getLine() + 40000, "ecurityCheckError", this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneVoiceAddr", g.zo() + " onGYNetEnd file:" + this.filename + " errtype:" + i2 + " errCode:" + i3);
        buk buk = (buk) ((b) qVar).hnQ.hnY;
        bul bul = (bul) ((b) qVar).hnR.hnY;
        if (i2 == 0 && i3 == 0) {
            x.d("MicroMsg.NetSceneVoiceAddr", g.zo() + " onGYNetEnd  file:" + this.filename + " endflag:" + bul.vSa + " lst:" + bul.vSd);
            if (buk.vSa == 1) {
                this.hZW = new String[bul.vSd.size()];
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 < bul.vSd.size()) {
                        this.hZW[i5] = ((bet) bul.vSd.get(i5)).wRo;
                        i4 = i5 + 1;
                    } else {
                        this.gLE.a(i2, i3, str, this);
                        return;
                    }
                }
            }
            this.hQL = buk.weD.wRk + buk.vUN;
            long j = this.hYm ? 0 : 500;
            x.d("MicroMsg.NetSceneVoiceAddr", "onGYNetEnd file:" + this.filename + " delay:" + j);
            this.hmy.K(j, j);
            return;
        }
        x.e("MicroMsg.NetSceneVoiceAddr", g.zo() + " onGYNetEnd file:" + this.filename + " errType:" + i2 + " errCode:" + i3);
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.a.b.CTRL_INDEX;
    }
}
