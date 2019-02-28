package com.tencent.mm.plugin.subapp.b;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.map.j;
import com.tencent.mm.protocal.c.aen;
import com.tencent.mm.protocal.c.aeo;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class a extends k implements com.tencent.mm.network.k {
    private RandomAccessFile aBB = null;
    private String filePath = null;
    private e gLE;
    private int hmZ = 0;
    private int kGx = 0;
    String url;

    public a(String str) {
        this.url = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new aen();
        aVar.hnU = new aeo();
        aVar.uri = "/cgi-bin/micromsg-bin/getpsmimg";
        aVar.hnS = j.CTRL_INDEX;
        aVar.hnV = 29;
        aVar.hnW = 1000000029;
        q Kf = aVar.Kf();
        aen aen = (aen) Kf.hnQ.hnY;
        aen.URL = this.url;
        aen.vUN = this.kGx;
        x.v("MicroMsg.NetSceneGetPSMImg", "doscene url:[" + this.url + "] + offset:" + this.kGx + " totallen:" + this.hmZ);
        return a(eVar, Kf, this);
    }

    protected final int a(q qVar) {
        String str = ((aen) ((b) qVar).hnQ.hnY).URL;
        Object obj = str == null ? null : str.indexOf("weixin://") != 0 ? null : 1;
        if (obj == null) {
            x.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : url invalid:" + this.url);
            return b.hoA;
        } else if (this.kGx < 0 || this.hmZ < 0) {
            x.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.kGx + " total:" + this.hmZ);
            return b.hoA;
        } else {
            if (this.kGx == 0) {
                if (this.hmZ != 0) {
                    x.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.kGx + " total:" + this.hmZ);
                    return b.hoA;
                }
            } else if (this.kGx >= this.hmZ) {
                x.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.kGx + " total:" + this.hmZ);
                return b.hoA;
            }
            return b.hoz;
        }
    }

    protected final int Bo() {
        return 10;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            aeo aeo = (aeo) ((b) qVar).hnR.hnY;
            x.d("MicroMsg.NetSceneGetPSMImg", "onGYNetEnd url:[" + this.url + "] + offset:" + this.kGx + " Resp[ totallen:" + aeo.vUM + " bufSize:" + aeo.weD.wRk + " ]");
            if (aeo.vUM > 0) {
                this.hmZ = aeo.vUM;
            }
            if (d(this.url, aeo.weD.wRm.oz, this.kGx)) {
                this.kGx = aeo.weD.wRk + this.kGx;
                if (this.hmZ <= this.kGx) {
                    x.d("MicroMsg.NetSceneGetPSMImg", "down url:[" + this.url + "] final size: " + this.hmZ);
                    this.gLE.a(i2, i3, str, this);
                    return;
                } else if (a(this.hok, this.gLE) < 0) {
                    this.gLE.a(i2, i3, str, this);
                    return;
                } else {
                    return;
                }
            }
            this.gLE.a(3, -1, str, this);
            return;
        }
        x.e("MicroMsg.NetSceneGetPSMImg", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        this.gLE.a(i2, i3, str, this);
    }

    private boolean d(String str, byte[] bArr, int i) {
        if (i == 0) {
            if (this.aBB == null && this.filePath == null) {
                this.filePath = com.tencent.mm.pluginsdk.j.a.a.SG(str);
                if (this.filePath == null) {
                    x.e("MicroMsg.NetSceneGetPSMImg", "writeFile getPath From url failed:[" + str + "]");
                    return false;
                }
                try {
                    this.aBB = new RandomAccessFile(this.filePath, "rw");
                } catch (Exception e) {
                    x.e("MicroMsg.NetSceneGetPSMImg", "writeFile open file error [" + this.filePath + "] e:" + e.getMessage());
                    return false;
                }
            }
            x.e("MicroMsg.NetSceneGetPSMImg", "writeFile param error");
            return false;
        }
        try {
            this.aBB.seek((long) i);
            this.aBB.write(bArr, 0, bArr.length);
            return true;
        } catch (IOException e2) {
            x.e("MicroMsg.NetSceneGetPSMImg", "writeFile write file error [" + this.filePath + "]  e:" + e2.getMessage());
            return false;
        }
    }

    public final int getType() {
        return j.CTRL_INDEX;
    }
}
