package com.tencent.mm.plugin.subapp.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ahw;
import com.tencent.mm.protocal.c.ahx;
import com.tencent.mm.protocal.c.bth;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.io.FileOutputStream;

public final class a extends k implements com.tencent.mm.network.k {
    final b gLB;
    private e gLE;
    private al hmy = new al(new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean uG() {
            if (a.this.sce < 0) {
                return false;
            }
            bth bth;
            ahx ahx = (ahx) a.this.gLB.hnR.hnY;
            try {
                bth = (bth) ahx.wwf.get(a.this.sce);
            } catch (Exception e) {
                x.e("MicroMsg.NetSceneGetVUserInfo", "get item :" + a.this.sce + " not Found");
                bth = null;
            }
            if (!(bth == null || bth.xbo == null || bth.xbn == null)) {
                x.d("MicroMsg.NetSceneGetVUserInfo", "onGYNetEnd ver:" + ahx.kzy + " idx:" + a.this.sce + " id:" + Integer.toHexString(bth.fgJ) + " size:" + bth.xbn.wRk + " hdsize:" + bth.xbo.wRk);
                a.a(bth.fgJ, true, bth.xbo.wRm.toByteArray());
                a.a(bth.fgJ, false, bth.xbn.wRm.toByteArray());
            }
            a aVar = a.this;
            aVar.sce--;
            return true;
        }
    }, true);
    int sce = 0;

    public a() {
        int i = 0;
        as.Hm();
        int e = bi.e((Integer) c.Db().get(66052, null));
        if (com.tencent.mm.y.ak.a.hhx.gR(e)) {
            as.Hm();
            i = bi.e((Integer) c.Db().get(66053, null));
        }
        StringBuilder append = new StringBuilder("init: allfileid:").append(Integer.toBinaryString(e)).append(" inver:");
        as.Hm();
        x.d("MicroMsg.NetSceneGetVUserInfo", append.append(bi.e((Integer) c.Db().get(66053, null))).append(" reqver:").append(i).toString());
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new ahw();
        aVar.hnU = new ahx();
        aVar.uri = "/cgi-bin/micromsg-bin/getvuserinfo";
        aVar.hnS = 167;
        aVar.hnV = 60;
        aVar.hnW = 1000000060;
        this.gLB = aVar.Kf();
        ((ahw) this.gLB.hnQ.hnY).kzy = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return 167;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            ahx ahx = (ahx) ((b) qVar).hnR.hnY;
            StringBuilder append = new StringBuilder("onGYNetEnd new version:").append(ahx.kzy).append(" old version:");
            as.Hm();
            x.d("MicroMsg.NetSceneGetVUserInfo", append.append(bi.e((Integer) c.Db().get(66053, null))).append(" Count:").append(ahx.wwf.size()).toString());
            as.Hm();
            c.Db().set(66053, Integer.valueOf(ahx.kzy));
            if (ahx.wwf.size() <= 0) {
                this.gLE.a(i2, i3, str, this);
                return;
            }
            int i4 = 0;
            int i5 = 0;
            while (true) {
                int i6 = i4;
                if (i6 < ahx.wwf.size()) {
                    i5 |= ((bth) ahx.wwf.get(i6)).fgJ;
                    i4 = i6 + 1;
                } else {
                    as.Hm();
                    c.Db().set(66052, Integer.valueOf(i5));
                    this.gLE.a(i2, i3, str, this);
                    this.sce = ahx.wwf.size() - 1;
                    this.hmy.K(50, 50);
                    return;
                }
            }
        }
        x.e("MicroMsg.NetSceneGetVUserInfo", "errType:" + i2 + " errCode:" + i3);
        this.gLE.a(i2, i3, str, this);
    }

    static boolean a(int i, boolean z, byte[] bArr) {
        Throwable e;
        Throwable th;
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(com.tencent.mm.y.ak.a.hhx.q(i, z));
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.close();
                try {
                    fileOutputStream.close();
                } catch (Exception e2) {
                }
                return true;
            } catch (Exception e3) {
                e = e3;
                try {
                    x.printErrStackTrace("MicroMsg.NetSceneGetVUserInfo", e, "", new Object[0]);
                    if (fileOutputStream != null) {
                        return false;
                    }
                    try {
                        fileOutputStream.close();
                        return false;
                    } catch (Exception e4) {
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e5) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e6) {
            e = e6;
            fileOutputStream = null;
            x.printErrStackTrace("MicroMsg.NetSceneGetVUserInfo", e, "", new Object[0]);
            if (fileOutputStream != null) {
                return false;
            }
            fileOutputStream.close();
            return false;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }
}
