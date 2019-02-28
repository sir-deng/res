package com.tencent.mm.bd;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.protocal.c.bsc;
import com.tencent.mm.protocal.c.bsd;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends k implements com.tencent.mm.network.k {
    private String filemd5;
    String filename;
    private b gLB;
    e gLE;
    private String hQI;
    private int hQJ;
    private int hQK;
    int hQL;
    private int hQM;
    al hmy;
    private int sampleRate;

    public a(String str, int i, int i2, int i3, int i4) {
        this.hQI = null;
        this.filemd5 = null;
        this.filename = null;
        this.sampleRate = 0;
        this.hQJ = 0;
        this.hQK = 0;
        this.hQL = 0;
        this.hQM = 5;
        this.hmy = new al(new com.tencent.mm.sdk.platformtools.al.a() {
            public final boolean uG() {
                x.d("MicroMsg.NetSceneUploadMedia", g.zo() + " onTimerExpired: file:" + a.this.filename + " nowlen:" + ((long) com.tencent.mm.a.e.bN(a.this.filename)) + " oldoff:" + a.this.hQL);
                if (a.this.a(a.this.hok, a.this.gLE) == -1) {
                    a.this.gLE.a(3, -1, "doScene failed", a.this);
                }
                return false;
            }
        }, true);
        this.hQI = bi.Wy();
        this.filename = str;
        this.hQM = i;
        this.sampleRate = i2;
        this.hQJ = i3;
        this.hQK = i4;
        this.filemd5 = com.tencent.mm.a.g.s(com.tencent.mm.a.e.d(this.filename, 0, com.tencent.mm.a.e.bN(this.filename)));
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int i = 3960;
        this.gLE = eVar2;
        int bN = com.tencent.mm.a.e.bN(this.filename);
        x.d("MicroMsg.NetSceneUploadMedia", g.zo() + " read file:" + this.filename + " filelen:" + bN + " oldoff:" + this.hQL + "this.filemd5 " + this.filemd5);
        if (bN <= 0) {
            x.e("MicroMsg.NetSceneUploadMedia", "read failed :" + this.filename);
            return -1;
        }
        int i2 = bN - this.hQL;
        if (i2 <= 3960) {
            i = i2;
        }
        x.i("MicroMsg.NetSceneUploadMedia", g.zo() + " read file:" + this.filename + " filelen:" + bN + " oldoff:" + this.hQL + "  canReadLen " + i);
        byte[] d = com.tencent.mm.a.e.d(this.filename, this.hQL, i);
        if (d == null) {
            x.e("MicroMsg.NetSceneUploadMedia", "read data error");
            return -1;
        }
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new bsc();
        aVar.hnU = new bsd();
        aVar.uri = "/cgi-bin/micromsg-bin/mmuploadmedia";
        aVar.hnS = 240;
        aVar.hnV = 111;
        aVar.hnW = 1000000111;
        this.gLB = aVar.Kf();
        bsc bsc = (bsc) this.gLB.hnQ.hnY;
        bsc.wZT = new bet().Vf(this.hQI);
        bsc.weD = new bes().bl(d);
        bsc.vPu = d.length;
        bsc.wZU = new bet().Vf(this.filemd5);
        bsc.vPs = bN;
        bsc.vPt = this.hQL;
        bsc.nph = this.hQM;
        bsc.wZV = 1;
        bsc.wZW = this.sampleRate;
        bsc.wZX = this.hQJ;
        bsc.wZY = this.hQK;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return 240;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneUploadMedia", g.zo() + " onGYNetEnd file:" + this.filename + " errtype:" + i2 + " errCode:" + i3);
        bsc bsc = (bsc) ((b) qVar).hnQ.hnY;
        String str2 = ((bsd) ((b) qVar).hnR.hnY).wgu;
        x.i("MicroMsg.NetSceneUploadMedia", "fileName:%s, md5:%s, totalLen:%d, dataLen:%d, startPos:%d", this.filename, str2, Integer.valueOf(bsc.vPs), Integer.valueOf(bsc.vPu), Integer.valueOf(bsc.vPt));
        if (i2 != 0 || i3 != 0) {
            x.e("MicroMsg.NetSceneUploadMedia", g.zo() + " onGYNetEnd file:" + this.filename + " errType:" + i2 + " errCode:" + i3);
            this.gLE.a(i2, i3, str, this);
        } else if (bsc.vPs > bsc.vPu + bsc.vPt || str2 == null || str2.equals("0")) {
            this.hQL = bsc.weD.wRk + bsc.vPt;
            x.d("MicroMsg.NetSceneUploadMedia", "onGYNetEnd file:" + this.filename + " delay:500");
            this.hmy.K(500, 500);
        } else {
            this.gLE.a(i2, i3, str, this);
        }
    }

    protected final int a(q qVar) {
        return b.hoz;
    }

    protected final int Bo() {
        return 60;
    }
}
