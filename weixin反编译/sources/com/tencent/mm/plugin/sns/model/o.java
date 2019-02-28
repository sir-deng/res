package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.b.c;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.appbrand.jsapi.a.f;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.bky;
import com.tencent.mm.protocal.c.bkz;
import com.tencent.mm.sdk.platformtools.x;
import java.io.OutputStream;

public final class o extends k implements com.tencent.mm.network.k {
    private String filename;
    private b gLB;
    public e gLE;
    private OutputStream hnp = null;
    String mediaId = "";
    private String qZT;
    private int qZU = -1;
    int qZV = -1;
    private boolean qZW = true;
    private String qZX = null;
    private are qZY;

    public o(are are, String str, String str2, int i, boolean z, int i2, String str3) {
        this.mediaId = str;
        this.qZY = are;
        this.qZW = z;
        this.qZU = i;
        this.qZV = i2;
        this.qZX = str3;
        this.qZT = am.r(ae.getAccSnsPath(), str);
        a aVar = new a();
        aVar.hnT = new bky();
        aVar.hnU = new bkz();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsdownload";
        aVar.hnS = f.CTRL_INDEX;
        aVar.hnV = 96;
        aVar.hnW = 1000000096;
        this.gLB = aVar.Kf();
        bky bky = (bky) this.gLB.hnQ.hnY;
        q Mg = ae.bvU().Mg(str);
        if (Mg == null) {
            Mg = new q();
        }
        Mg.rvv = str;
        Mg.offset = 0;
        ae.bvU().a(str, Mg);
        if (z) {
            this.filename = i.n(are);
        } else {
            this.filename = i.m(are);
        }
        FileOp.ml(this.qZT);
        FileOp.deleteFile(am.r(ae.getAccSnsPath(), str) + this.filename);
        bky.wUJ = str2;
        bky.wUK = 0;
        bky.vPt = 0;
        bky.vPs = 0;
        bky.kzz = this.qZU;
        x.d("MicroMsg.NetSceneSnsDownload", "requestKey " + str3);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneSnsDownload", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        bkz bkz = (bkz) ((b) qVar).hnR.hnY;
        if (((c) qVar.Hv()).vIb != 0) {
            this.gLE.a(i2, i3, str, this);
            ae.bwa().KC(this.qZX);
            return;
        }
        q Mg = ae.bvU().Mg(this.mediaId);
        if (bkz.vPs <= 0) {
            x.e("MicroMsg.NetSceneSnsDownload", "error 1");
            onError();
        } else if (bkz.vQW == null) {
            x.e("MicroMsg.NetSceneSnsDownload", "error 2");
            onError();
        } else if (bkz.vPt < 0 || bkz.vPt + bkz.vQW.wRm.oz.length > bkz.vPs) {
            x.e("MicroMsg.NetSceneSnsDownload", "error 3");
            onError();
        } else if (bkz.vPt != Mg.offset) {
            x.e("MicroMsg.NetSceneSnsDownload", "error 4");
            onError();
        } else {
            int F = F(bkz.vQW.wRm.toByteArray());
            if (F < 0) {
                x.e("MicroMsg.NetSceneSnsDownload", "error 5");
                onError();
                return;
            }
            Mg.offset += F;
            Mg.rvr = bkz.vPs;
            x.d("MicroMsg.NetSceneSnsDownload", "byteLen " + F + "  totalLen " + bkz.vPs);
            ae.bvU().a(this.mediaId, Mg);
            Object obj = (Mg.offset != Mg.rvr || Mg.rvr == 0) ? null : 1;
            if (obj != null) {
                x.d("MicroMsg.NetSceneSnsDownload", "downLoad ok");
                String e = this.qZV == 1 ? i.e(this.qZY) : i.l(this.qZY);
                String r = am.r(ae.getAccSnsPath(), this.mediaId);
                FileOp.deleteFile(r + e);
                FileOp.g(r, this.filename, e);
                if (this.qZW) {
                    r.b(r, e, i.f(this.qZY), (float) ae.bwn());
                } else {
                    String e2 = i.e(this.qZY);
                    if (!FileOp.bO(r + e2)) {
                        r.a(r, e, e2, (float) ae.bwo());
                    }
                    e2 = i.f(this.qZY);
                    if (!FileOp.bO(r + e2)) {
                        r.b(r, e, e2, (float) ae.bwn());
                    }
                }
                ae.bwa().KC(this.qZX);
                this.gLE.a(i2, i3, str, this);
                return;
            }
            a(this.hok, this.gLE);
        }
    }

    private void onError() {
        ae.bwa().KC(this.qZX);
    }

    public final int getType() {
        return f.CTRL_INDEX;
    }

    protected final int a(com.tencent.mm.network.q qVar) {
        return b.hoz;
    }

    protected final int Bo() {
        return 100;
    }

    private int F(byte[] bArr) {
        if (!i.Ku(ae.FJ())) {
            return 0;
        }
        try {
            if (this.hnp == null) {
                FileOp.ml(this.qZT);
                this.hnp = FileOp.iH(this.qZT + this.filename);
            }
            x.d("MicroMsg.NetSceneSnsDownload", "appendBuf " + bArr.length);
            this.hnp.write(bArr);
            return bArr.length;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneSnsDownload", e, "appendBuf failed: " + this.filename, new Object[0]);
            return -1;
        } finally {
            JP();
        }
    }

    private void JP() {
        try {
            if (this.hnp != null) {
                this.hnp.flush();
                this.hnp.close();
                this.hnp = null;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneSnsDownload", e, "", new Object[0]);
        }
    }
}
