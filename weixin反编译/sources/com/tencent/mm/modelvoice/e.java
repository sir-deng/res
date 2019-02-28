package com.tencent.mm.modelvoice;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.k;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.rv;
import com.tencent.mm.protocal.c.rw;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.am;
import com.tencent.mm.y.s;
import com.tencent.wcdb.FileUtils;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class e extends k implements com.tencent.mm.network.k {
    private static am hYk = null;
    private static List<c> hYl = new ArrayList();
    private String fEx;
    public String fileName;
    private b gLB;
    private com.tencent.mm.ad.e gLE;
    private String hYj;
    private boolean hYm = false;
    private boolean hYn = false;
    private al hmy = new al(new a() {
        public final boolean uG() {
            if (e.this.a(e.this.hok, e.this.gLE) == -1) {
                e.this.gLE.a(3, -1, "doScene failed", e.this);
            }
            return false;
        }
    }, false);
    public int retCode = 0;

    public static void a(am amVar) {
        if (hYk == null) {
            hYk = amVar;
        }
    }

    public static void a(c cVar) {
        if (!hYl.contains(cVar)) {
            hYl.add(cVar);
        }
    }

    public static void b(c cVar) {
        hYl.remove(cVar);
    }

    private void doNotify() {
        final au of = q.of(this.fileName);
        if (of != null) {
            if (hYk != null) {
                hYk.a(of);
            }
            for (final c cVar : hYl) {
                ah.y(new Runnable() {
                    public final void run() {
                        cVar.A(of);
                    }
                });
            }
        }
    }

    public e(p pVar) {
        boolean z;
        Assert.assertTrue(pVar != null);
        this.fileName = pVar.fileName;
        if (this.fileName != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        this.hYj = pVar.hYj;
        this.fEx = pVar.fEx;
        x.i("MicroMsg.NetSceneDownloadVoice", "NetSceneDownloadVoice:  file[%s] voiceFormat[%s] user[%s]", this.fileName, this.hYj, this.fEx);
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ad.e eVar2) {
        this.gLE = eVar2;
        if (this.fileName == null) {
            x.e("MicroMsg.NetSceneDownloadVoice", "doScene:  filename null!");
            this.retCode = g.getLine() + 10000;
            return -1;
        }
        p og = q.og(this.fileName);
        if (og == null || !og.UN()) {
            x.e("MicroMsg.NetSceneDownloadVoice", "Get info Failed file:" + this.fileName);
            this.retCode = g.getLine() + 10000;
            return -1;
        }
        x.i("MicroMsg.NetSceneDownloadVoice", "doScene file:" + this.fileName + " netTimes:" + og.hXx);
        if (q.nW(this.fileName)) {
            int i = og.hWd - og.hXp;
            if (i > 0) {
                if (og.hmZ == og.hWd) {
                    this.hYm = true;
                }
                b.a aVar = new b.a();
                aVar.hnT = new rv();
                aVar.hnU = new rw();
                aVar.uri = "/cgi-bin/micromsg-bin/downloadvoice";
                aVar.hnS = FileUtils.S_IWUSR;
                aVar.hnV = 20;
                aVar.hnW = 1000000020;
                this.gLB = aVar.Kf();
                rv rvVar = (rv) this.gLB.hnQ.hnY;
                rvVar.vOL = og.clientId;
                rvVar.vNT = og.fGj;
                rvVar.wgA = i;
                rvVar.vUN = og.hXp;
                if (s.eX(this.fEx)) {
                    rvVar.wfN = this.fEx;
                    rvVar.wgB = og.hZr;
                }
                x.i("MicroMsg.NetSceneDownloadVoice", "doScene req.ClientMsgId:%s req.MsgId:%d req.NewMsgId:%d, req.Length:%d req.Offset:%d req.ChatRoomName:%s req.MasterBufId %d", rvVar.vOL, Integer.valueOf(rvVar.vNL), Long.valueOf(rvVar.vNT), Integer.valueOf(rvVar.wgA), Integer.valueOf(rvVar.vUN), rvVar.wfN, Long.valueOf(rvVar.wgB));
                return a(eVar, this.gLB, this);
            } else if (og.status == 5) {
                this.hYn = true;
                x.e("MicroMsg.NetSceneDownloadVoice", "doScene file:" + this.fileName + " Net:" + og.hWd + " Local:" + og.hXp);
                this.retCode = g.getLine() + 10000;
                return -1;
            } else {
                q.a(this.fileName, og.hXp, null);
                this.retCode = g.getLine() + 10000;
                return -1;
            }
        }
        x.e("MicroMsg.NetSceneDownloadVoice", "checkVoiceNetTimes Failed file:" + this.fileName);
        q.nC(this.fileName);
        this.retCode = g.getLine() + 10000;
        return -1;
    }

    protected final int a(q qVar) {
        rv rvVar = (rv) ((b) qVar).hnQ.hnY;
        if (rvVar.vNT != 0 && rvVar.vOL != null && rvVar.vOL.length() != 0 && rvVar.wgA > 0 && rvVar.vUN >= 0) {
            return b.hoz;
        }
        q.nC(this.fileName);
        return b.hoA;
    }

    protected final int Bo() {
        return 100;
    }

    protected final void a(a aVar) {
        com.tencent.mm.plugin.report.service.g.pWK.a(111, 233, 1, false);
        q.nC(this.fileName);
    }

    public final boolean Kk() {
        boolean Kk = super.Kk();
        if (Kk) {
            com.tencent.mm.plugin.report.service.g.pWK.a(111, 232, 1, false);
        }
        return Kk;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd file:" + this.fileName + " + id:" + i + " errtype:" + i2 + " errCode:" + i3);
        rw rwVar = (rw) ((b) qVar).hnR.hnY;
        if (rwVar.wgD == 1) {
            x.v("MicroMsg.NetSceneDownloadVoice", this.fileName + " cancelFlag = 1");
            q.ob(this.fileName);
        } else if (i3 == -22) {
            q.nC(this.fileName);
            this.gLE.a(i2, i3, str, this);
        } else if (i2 == 4 && i3 != 0) {
            com.tencent.mm.plugin.report.service.g.pWK.a(111, 231, 1, false);
            q.nC(this.fileName);
            this.gLE.a(i2, i3, str, this);
        } else if (i2 == 0 && i3 == 0) {
            x.d("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd file:" + this.fileName + " Recv:" + rwVar.weD.wRk + " fileOff:" + rwVar.vUN);
            if (rwVar.weD.wRm == null) {
                x.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd get recv Buffer null");
                q.nC(this.fileName);
                this.gLE.a(i2, i3, str, this);
                return;
            }
            byte[] toByteArray = rwVar.weD.wRm.toByteArray();
            if (toByteArray.length == 0) {
                x.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd Recv Buf ZERO length ");
                q.nC(this.fileName);
                this.gLE.a(i2, i3, str, this);
                return;
            }
            int write = q.ay(this.hYj, this.fileName).write(toByteArray, toByteArray.length, rwVar.vUN);
            if (write < 0) {
                x.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd Write Failed File:" + this.fileName + " ret:" + write);
                q.nC(this.fileName);
                this.gLE.a(i2, i3, str, this);
                return;
            }
            q.c(this.fileName, toByteArray, toByteArray.length);
            x.i("MicroMsg.NetSceneDownloadVoice", "OnRecvEnd : file:" + this.fileName + " filesize:" + write + " voiceFormat:" + this.hYj);
            write = q.a(this.fileName, write, null);
            if (write < 0) {
                com.tencent.mm.plugin.report.service.g.pWK.a(111, 229, 1, false);
                x.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd file:" + this.fileName + "updateAfterRecv Ret:" + write);
                this.gLE.a(i2, i3, str, this);
            } else if (write == 1) {
                doNotify();
                this.gLE.a(i2, i3, str, this);
            } else {
                long j = 1000;
                if (this.hYm) {
                    j = 0;
                }
                this.hmy.K(j, j);
            }
        } else {
            com.tencent.mm.plugin.report.service.g.pWK.a(111, 230, 1, false);
            x.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + " resp:" + qVar.Hv().vIb);
            this.gLE.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return FileUtils.S_IWUSR;
    }
}
