package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.f;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bru;
import com.tencent.mm.protocal.c.brv;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Random;

public final class o extends k implements com.tencent.mm.network.k {
    private String fEE;
    public String filePath = null;
    private b gLB;
    private e gLE;
    private f hCU;
    private int hmZ = 0;
    private int hna = 0;

    public o(String str, String str2, f fVar) {
        this.filePath = str;
        this.fEE = str2 + "_" + System.nanoTime() + "_" + Math.abs(new Random().nextInt() / 2);
        this.hCU = fVar;
        x.i("MicroMsg.NetSceneUploadFie", "msgId: %s, filePath: %s", this.fEE, this.filePath);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, netId: %d, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            brv brv = (brv) ((b) qVar).hnR.hnY;
            String str2 = brv.vNF;
            x.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, clientId: %s, totalLen: %d, attachId: %s", brv.vNF, Integer.valueOf(brv.vPs), brv.wfk);
            if (str2.equals(this.fEE)) {
                this.hna = brv.vPt;
                if (this.hna < this.hmZ) {
                    x.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, startPos: %d, totalLen: %d, continue to upload", Integer.valueOf(this.hna), Integer.valueOf(this.hmZ));
                    if (a(this.hok, this.gLE) < 0) {
                        x.e("MicroMsg.NetSceneUploadFie", "continue to upload fail");
                        if (this.gLE != null) {
                            this.gLE.a(i2, i3, str, this);
                        }
                        if (this.hCU != null) {
                            this.hCU.a(this.hna, this.hmZ, this);
                            return;
                        }
                        return;
                    }
                }
                String str3 = brv.wfk;
                x.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, finish upload, startPos: %d, totalLen: %d, attachId: %s", Integer.valueOf(this.hna), Integer.valueOf(this.hmZ), str3);
                if (this.gLE != null) {
                    this.gLE.a(i2, i3, str, this);
                }
                if (this.hCU != null) {
                    this.hCU.a(this.hna, this.hmZ, this);
                }
            }
        } else if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }

    protected final int Bo() {
        return 640;
    }

    protected final int a(q qVar) {
        if (!bi.oN(this.filePath) && com.tencent.mm.a.e.bO(this.filePath)) {
            return b.hoz;
        }
        x.e("MicroMsg.NetSceneUploadFie", "securityVerificationChecked failed, file not exist");
        return b.hoA;
    }

    protected final void a(a aVar) {
    }

    public final int getType() {
        return 484;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        if (bi.oN(this.filePath)) {
            x.e("MicroMsg.NetSceneUploadFie", "doScene, filePath is null");
            return -1;
        } else if (com.tencent.mm.a.e.bO(this.filePath)) {
            if (this.hmZ == 0) {
                this.hmZ = com.tencent.mm.a.e.bN(this.filePath);
                x.i("MicroMsg.NetSceneUploadFie", "doScene, totalLen: %d", Integer.valueOf(this.hmZ));
            }
            int min = Math.min(this.hmZ - this.hna, WXMediaMessage.THUMB_LENGTH_LIMIT);
            x.i("MicroMsg.NetSceneUploadFie", "doScene, startPos: %d, dataLen: %d", Integer.valueOf(this.hna), Integer.valueOf(min));
            byte[] d = com.tencent.mm.a.e.d(this.filePath, this.hna, min);
            if (d == null) {
                x.e("MicroMsg.NetSceneUploadFie", "doScene, read file buf is null");
                return -1;
            }
            x.i("MicroMsg.NetSceneUploadFie", "doScene, buf.length: %d", Integer.valueOf(d.length));
            a aVar = new a();
            aVar.hnT = new bru();
            aVar.hnU = new brv();
            aVar.uri = "/cgi-bin/micromsg-bin/uploadfile";
            aVar.hnS = 484;
            aVar.hnV = 0;
            aVar.hnW = 0;
            this.gLB = aVar.Kf();
            bru bru = (bru) this.gLB.hnQ.hnY;
            bru.vNF = this.fEE;
            bru.vPs = this.hmZ;
            bru.vPt = this.hna;
            bru.vPu = min;
            bru.weD = n.N(d);
            x.i("MicroMsg.NetSceneUploadFie", "doScene, ret: %d", Integer.valueOf(a(eVar, this.gLB, this)));
            return a(eVar, this.gLB, this);
        } else {
            x.e("MicroMsg.NetSceneUploadFie", "doScene, file: %s not exist", this.filePath);
            return -1;
        }
    }

    public final brv bkT() {
        if (this.gLB != null) {
            return (brv) this.gLB.hnR.hnY;
        }
        return null;
    }
}
