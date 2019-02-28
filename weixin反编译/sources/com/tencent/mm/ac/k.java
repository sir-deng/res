package com.tencent.mm.ac;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.acy;
import com.tencent.mm.protocal.c.acz;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.x;
import java.io.OutputStream;

final class k extends com.tencent.mm.ad.k implements com.tencent.mm.network.k {
    private e gLE;
    private String hmS;
    private int hmW;
    private String hmY;
    private int hno;
    private OutputStream hnp = null;
    private String hnq;
    private String username;

    public k(String str) {
        this.username = str;
        if (x.gB(str)) {
            this.username = x.Xk(str);
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneGetHDHeadImg", "init Headimage in_username:" + str + " out_username" + this.username);
        this.hmW = 480;
        this.hno = 480;
        this.hmY = "jpg";
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        boolean z = false;
        this.gLE = eVar2;
        if (this.username == null || this.username.length() == 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NetSceneGetHDHeadImg", "username is null");
            return -1;
        } else if (this.username.endsWith("@qqim")) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NetSceneGetHDHeadImg", "never try get qq user hd.");
            return -1;
        } else {
            g JX = n.JX();
            n.JF();
            this.hmS = d.x(this.username, true);
            if (FileOp.bO(this.hmS)) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneGetHDHeadImg", "The HDAvatar of " + this.username + " is already exists");
                return 0;
            }
            f fVar;
            this.hnq = this.hmS + ".tmp";
            f jn = JX.jn(this.username);
            if (jn == null) {
                FileOp.deleteFile(this.hnq);
                jn = new f();
                jn.username = this.username;
                jn.hmY = this.hmY;
                jn.hmW = this.hmW;
                jn.hmX = this.hno;
                jn.fEo = -1;
                JX.hiZ.insert("hdheadimginfo", "username", jn.vP());
                fVar = jn;
            } else {
                String str = this.hnq;
                if (jn != null && str != null && str.length() != 0 && jn.JK().equals(this.hmY) && jn.hmW == this.hmW && jn.hmX == this.hno && FileOp.mi(str) == ((long) jn.hna)) {
                    z = true;
                }
                if (!z) {
                    FileOp.deleteFile(this.hnq);
                    jn.reset();
                    jn.username = this.username;
                    jn.hmY = this.hmY;
                    jn.hmW = this.hmW;
                    jn.hmX = this.hno;
                    JX.a(this.username, jn);
                }
                fVar = jn;
            }
            a aVar = new a();
            aVar.hnT = new acy();
            aVar.hnU = new acz();
            aVar.uri = "/cgi-bin/micromsg-bin/gethdheadimg";
            aVar.hnS = 158;
            aVar.hnV = 47;
            aVar.hnW = 1000000047;
            q Kf = aVar.Kf();
            acy acy = (acy) Kf.hnQ.hnY;
            if (!x.gB(this.username)) {
                acy.kyG = this.username;
                acy.wss = 1;
            } else if (this.username.equals(com.tencent.mm.y.q.FY() + "@bottle")) {
                acy.kyG = com.tencent.mm.y.q.FY();
                acy.wss = 2;
            } else {
                acy.kyG = this.username;
                acy.wss = 2;
            }
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.NetSceneGetHDHeadImg", "inUser:" + this.username + " outUser:" + acy.kyG + " outType:" + acy.wss);
            acy.wsp = this.hmW;
            acy.wsq = this.hno;
            acy.wsr = this.hmY;
            acy.vPs = fVar.hmZ;
            acy.vPt = fVar.hna;
            return a(eVar, Kf, this);
        }
    }

    protected final int a(q qVar) {
        if (this.username == null || this.username.length() == 0) {
            return b.hoA;
        }
        return b.hoz;
    }

    protected final int Bo() {
        return 10;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        acz acz = (acz) ((b) qVar).hnR.hnY;
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.NetSceneGetHDHeadImg", "errType:" + i2 + " errCode:" + i3);
        if (i2 != 4 && i3 != 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NetSceneGetHDHeadImg", "errType:" + i2 + " errCode:" + i3);
            this.gLE.a(i2, i3, str, this);
            JP();
        } else if (i2 == 4 || i2 == 5) {
            this.gLE.a(i2, i3, str, this);
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NetSceneGetHDHeadImg", "ErrType:" + i2);
            JP();
        } else {
            Object obj;
            int i4 = qVar.Hv().vIb;
            if (i4 == -4 || i4 == -54 || i4 == -55) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NetSceneGetHDHeadImg", "retcode == " + i4);
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NetSceneGetHDHeadImg", "handleCertainError");
                this.gLE.a(i2, i3, str, this);
                JP();
                return;
            }
            i4 = -1;
            if (!(acz.weD == null || acz.weD.wRm == null)) {
                i4 = F(acz.weD.wRm.oz);
            }
            if (i4 < 0) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NetSceneGetHDHeadImg", "appendBuf fail");
                this.gLE.a(i2, i3, str, this);
                JP();
                return;
            }
            g JX = n.JX();
            f jn = JX.jn(this.username);
            jn.hna = i4 + acz.vPt;
            jn.hmZ = acz.vPs;
            JX.a(this.username, jn);
            if ((jn.hna >= jn.hmZ ? 1 : null) == null) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneGetHDHeadImg", "%d doScene again info[%s %d %d]", Integer.valueOf(hashCode()), this.username, Integer.valueOf(jn.hna), Integer.valueOf(jn.hmZ));
                if (a(this.hok, this.gLE) < 0) {
                    this.gLE.a(3, -1, "", this);
                    return;
                }
                return;
            }
            FileOp.at(this.hnq, this.hmS);
            ad(this.hmS, this.username);
            JP();
            this.gLE.a(i2, i3, str, this);
        }
    }

    public static void ad(String str, String str2) {
        n.JF().ac(str, str2);
    }

    protected final void cancel() {
        super.cancel();
        JP();
    }

    public final int getType() {
        return 158;
    }

    private int F(byte[] bArr) {
        try {
            if (this.hnp == null) {
                this.hnp = FileOp.iH(this.hnq);
            }
            this.hnp.write(bArr);
            return bArr.length;
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NetSceneGetHDHeadImg", "exception:%s", bi.i(e));
            return -1;
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
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NetSceneGetHDHeadImg", "exception:%s", bi.i(e));
        }
    }
}
