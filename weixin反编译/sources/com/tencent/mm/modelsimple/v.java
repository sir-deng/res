package com.tencent.mm.modelsimple;

import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mm.a.o;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.ji;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.plugin.zero.b.b;
import com.tencent.mm.protocal.c.aq;
import com.tencent.mm.protocal.c.aqq;
import com.tencent.mm.protocal.c.aqs;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.bjx;
import com.tencent.mm.protocal.c.bnq;
import com.tencent.mm.protocal.c.bqo;
import com.tencent.mm.protocal.c.byk;
import com.tencent.mm.protocal.c.cca;
import com.tencent.mm.protocal.c.ff;
import com.tencent.mm.protocal.i;
import com.tencent.mm.protocal.i.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ar;
import com.tencent.mm.y.at;
import com.tencent.mm.y.be;
import com.tencent.mm.y.y;
import java.util.Iterator;

public final class v extends k implements com.tencent.mm.network.k {
    private int errCode;
    private int errType;
    e gLE;
    public String hPj;
    private String hPk;
    private String hPl;
    private boolean hPm;
    private boolean hPn;
    private int hPo;
    private int hPp;
    public String hPq;
    private boolean hPr;
    private int hoC;
    public final q hoZ;

    public static class a {
        public String fsK;
        public String fzT;
        public String hPv;
        public Bundle hPw;
        public int type;
        public String username;

        public final String toString() {
            return String.format("AuthBioInfo hash[%d], type[%d]. username[%s], ticket[%s], helpUrlp[%s], wording[%s], extra[%s]", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(this.type), this.username, bi.Wz(this.fsK), this.hPv, this.fzT, this.hPw});
        }
    }

    public v(int i, String str, String str2, String str3) {
        this("", "", i, str, str2, str3, 0, "", false, false);
    }

    public v(String str, String str2, String str3, int i) {
        this(str, str2, 0, "", "", "", i, str3, false, false);
    }

    public v(String str, String str2, String str3, String str4) {
        this(str2, str3, 0, "", "", "", 0, str4, true, false);
        this.hPq = str;
    }

    public v(String str, String str2, int i, String str3, String str4, String str5, int i2, String str6, boolean z, boolean z2) {
        this.hPk = "";
        this.hPl = "";
        this.hPm = false;
        this.hPn = false;
        this.errType = 0;
        this.errCode = 0;
        this.hoC = 3;
        this.hPo = 0;
        this.hPp = 0;
        this.hPr = false;
        x.d("MicroMsg.NetSceneManualAuth", "summerauth NetSceneManualAuth this: " + this + " account: " + str + " secCodetype: " + i + " secCode: " + str3 + " sid: " + str4 + " encryptKey: " + str5 + " inputType: " + i2 + " authTicket: " + str6 + " useRawPwd: " + z + " isMobileAutoLogin: " + z2 + " stack: " + bi.chl());
        this.hPn = z2;
        this.hPj = str;
        this.hoZ = new at(701);
        d dVar = (d) this.hoZ.Kh();
        int i3 = at.Ht().getInt("key_auth_update_version", 0);
        x.d("MicroMsg.NetSceneManualAuth", "summerauth updateVersion:%d, clientVersion:%d", Integer.valueOf(i3), Integer.valueOf(com.tencent.mm.protocal.d.vHl));
        if (i3 == 0) {
            dVar.vHV = 1;
            com.tencent.mm.plugin.report.d.pVE.a(148, 0, 1, false);
            dVar.vHJ = true;
        } else if (i3 < com.tencent.mm.protocal.d.vHl) {
            dVar.vHV = 16;
            com.tencent.mm.plugin.report.d.pVE.a(148, 1, 1, false);
        } else {
            dVar.vHV = 1;
        }
        dVar.eE(0);
        aqs aqs = new aqs();
        aqq aqq = new aqq();
        dVar.vHI.wEj = aqs;
        dVar.vHI.wEk = aqq;
        aqq.wEi = i2;
        ff ffVar = new ff();
        aqq.vQn = ffVar;
        ffVar.vQc = str6;
        ffVar.vRL = 0;
        ffVar.vPX = new bes().bl(new byte[0]);
        ffVar.vPW = new bes().bl(new byte[0]);
        byk byk = new byk();
        ffVar.vRJ = byk;
        byk.vTu = "";
        byk.vTt = "";
        byk.xfF = "";
        cca cca = new cca();
        ffVar.vRK = cca;
        cca.wuV = "";
        cca.wuU = "";
        if (i == 1) {
            byk.vTu = str3;
            byk.vTt = str4;
            byk.xfF = str5;
            cca.wuV = "";
            cca.wuU = "";
        } else if (i == 3) {
            byk.vTu = "";
            byk.vTt = "";
            byk.xfF = "";
            cca.wuV = str3;
            cca.wuU = str4;
        }
        if (bi.oN(str) && g.Do().CF()) {
            com.tencent.mm.plugin.report.d.pVE.a(148, 2, 1, false);
            this.hPk = (String) g.Dq().Db().get(3, null);
            this.hPl = (String) g.Dq().Db().get(19, null);
            i.e eVar = (i.e) this.hoZ.Hv();
            str = bi.oM((String) g.Dq().Db().get(2, null));
            if (bi.oN(str)) {
                str = new o(bi.a((Integer) g.Dq().Db().get(9, null), 0)).toString();
            } else {
                eVar.ibj = str;
            }
        } else if (z || z2) {
            this.hPk = str2;
            this.hPl = str2;
        } else {
            this.hPk = bi.Wh(bi.oM(str2));
            this.hPl = bi.Wi(bi.oM(str2));
        }
        aqs.kyG = str;
        byte[] bArr = null;
        if (!(i == 1 || i == 3)) {
            if (i == 2) {
                bArr = g.Do().Cx().c(bi.getLong(str, 0), str3);
            } else if (bi.VY(str)) {
                bArr = g.Do().Cx().a(bi.getLong(str, 0), this.hPl, true);
            }
        }
        String str7 = "MicroMsg.NetSceneManualAuth";
        String str8 = "summerauth loginbuf len:%d content:[%s]";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        objArr[1] = bi.Wz(bi.bx(bArr));
        x.i(str7, str8, objArr);
        bes bes = new bes();
        if (bi.by(bArr)) {
            bArr = new byte[0];
        }
        ffVar.vRI = bes.bl(bArr);
        aqs.vTg = this.hPl;
        aqs.vTs = this.hPk;
    }

    public final void mA(String str) {
        d dVar = (d) this.hoZ.Kh();
        dVar.vHI.wEj.vTg = str;
        dVar.vHI.wEj.vTs = str;
        dVar.vHI.wEk.vQn.vRI = new bes().bl(new byte[0]);
        this.hPk = str;
        this.hPl = str;
    }

    public final int getType() {
        return 701;
    }

    protected final int Bo() {
        return 5;
    }

    protected final int a(q qVar) {
        return b.hoz;
    }

    protected final void a(a aVar) {
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.hoZ, this);
    }

    public final v Se() {
        this.hPr = true;
        return this;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        int i4;
        d dVar = (d) qVar.Kh();
        final i.e eVar = (i.e) qVar.Hv();
        if (eVar.vHL == null || eVar.vHL.wZl == null) {
            x.i("MicroMsg.NetSceneManualAuth", "summerauth mmtls manual not set as ret:%s", Integer.valueOf(eVar.vIb));
        } else {
            i4 = eVar.vHL.wZl.vQg;
            x.i("MicroMsg.NetSceneManualAuth", "summerauth mmtls manual:%s", Integer.valueOf(i4));
            g.Dr();
            g.Dq().gRO.set(47, Integer.valueOf(i4));
            com.tencent.mm.network.e eVar2 = g.Dp().gRu.hoF;
            if (eVar2 != null) {
                eVar2.bJ((i4 & 1) == 0);
            }
        }
        this.errType = i2;
        this.errCode = i3;
        bqo bqo = eVar.vHL;
        if (bqo == null) {
            x.w("MicroMsg.NetSceneManualAuth", "summerauth error unifyAuthResp is null!");
            this.gLE.a(4, -1, "", this);
            com.tencent.mm.plugin.report.d.pVE.a(148, 3, 1, false);
            return;
        }
        x.i("MicroMsg.NetSceneManualAuth", "summerauth errType:%d, errCode:%d, errMsg:%s unifyAuthResp:%s, unifyFlag:%d, auth:%s, acct:%s, network:%s", Integer.valueOf(i2), Integer.valueOf(i3), str, bqo, Integer.valueOf(bqo.wZk), bqo.wZl, bqo.wZm, bqo.wZn);
        int i5;
        if (i2 == 0 && i3 == 0) {
            if ((i4 & 2) != 0) {
                aq aqVar = bqo.wZm;
                if (aqVar == null || bi.oN(aqVar.kyG)) {
                    x.w("MicroMsg.NetSceneManualAuth", "summerauth UserName is null and return false!");
                    this.gLE.a(4, -1, "", this);
                    return;
                } else if (at.b(qVar) == 2) {
                    com.tencent.mm.plugin.report.d.pVE.a(148, 7, 1, false);
                    x.d("MicroMsg.NetSceneManualAuth", "summerauth decode faild loginDecodeFailedTry:%d", Integer.valueOf(this.hPp));
                    this.hPp++;
                    if (this.hPp > 1) {
                        this.gLE.a(4, -1, "", this);
                        return;
                    }
                    ((d) this.hoq.Kh()).vHI.wEk.vQn.vRL = 1;
                    a(this.hok, this.gLE);
                    return;
                } else {
                    x.d("MicroMsg.NetSceneManualAuth", "summerauth decode succeed!");
                    g.Dt().tT();
                    x.d("MicroMsg.NetSceneManualAuth", "summerauth dkidc setAccUin Begin thread:[%s,%d]", Thread.currentThread().getName(), Integer.valueOf(Process.getThreadPriority(Process.myTid())));
                    y.a(eVar.vHL, false);
                    ((PluginAuth) g.k(PluginAuth.class)).getHandleAuthResponseCallbacks().a(dVar, eVar, false);
                    if (!bi.oN(this.hPj)) {
                        g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_LAST_LOGIN_USERNAME_STRING, this.hPj);
                        ar.hhz.S("login_user_name", this.hPj);
                    }
                    if (this.hPn) {
                        g.Dq().Db().set(2, dVar.vHI.wEj.kyG);
                    }
                    g.Dp().gRu.a(new be(new com.tencent.mm.y.be.a() {
                        public final void a(com.tencent.mm.network.e eVar) {
                            if (eVar == null || eVar.KD() == null || eVar.ibg == null || eVar.vHL == null || eVar.vHL.wZl == null) {
                                com.tencent.mm.plugin.report.d.pVE.a(148, 8, 1, false);
                                x.e("MicroMsg.NetSceneManualAuth", "[arthurdan.NetSceneManualAuthCrash] fatal error dispatcher == null || null == dispatcher.getAccInfo() || null == resp.getSession() || null == resp.rImpl || null == resp.rImpl.AuthSectResp !!!");
                                return;
                            }
                            x.d("MicroMsg.NetSceneManualAuth", "summerauth NetSceneLocalProxy setSessionInfo session:%s, uin:%d", bi.Wz(bi.bx(eVar.ibg)), Integer.valueOf(eVar.vHL.wZl.lTO));
                            eVar.KD().v(eVar.ibg, eVar.vHL.wZl.lTO);
                        }
                    }), 0);
                    if (bi.e((Integer) g.Dq().Db().get(15, null)) != 0) {
                        ((b) g.h(b.class)).Qj().ig(10);
                    }
                    if ((bqo.wZl.vQf & 8) == 0) {
                        Object FY = com.tencent.mm.y.q.FY();
                        if (!TextUtils.isEmpty(FY)) {
                            g.Dp().gRu.a(new r(FY), 0);
                        }
                    } else {
                        x.i("MicroMsg.NetSceneManualAuth", "summerauth not need getProfile authResultFlag:%d", Integer.valueOf(bqo.wZl.vQf));
                        com.tencent.mm.plugin.report.d.pVE.a(148, 9, 1, false);
                    }
                    int i6 = 4;
                    if (dVar.vHI.wEk.vQn.vRI != null && dVar.vHI.wEk.vQn.vRI.wRk > 0) {
                        i6 = 1;
                    } else if (dVar.vHI.wEk.wEi == 1) {
                        i6 = 2;
                    }
                    com.tencent.mm.plugin.report.b.d.n(1, i6, dVar.vHI.wEj.kyG);
                    if (i2 == 0 && i3 == 0) {
                        bjx bjx = ((i.e) this.hoZ.Hv()).vHL.wZl.vQb;
                        if (!(bjx == null || bjx.wTP == null || bjx.wTP.size() <= 0)) {
                            Iterator it = bjx.wTP.iterator();
                            while (it.hasNext()) {
                                bnq bnq = (bnq) it.next();
                                if (bnq.pWg == 1) {
                                    i5 = bi.getInt(bnq.wXD, 0);
                                    break;
                                }
                            }
                        }
                        i5 = 0;
                        com.tencent.mm.plugin.c.b.jg(i5);
                        x.i("MicroMsg.NetSceneManualAuth", "publishManualAuthEvent");
                        com.tencent.mm.sdk.b.b jiVar = new ji();
                        jiVar.fAE.foB = true;
                        com.tencent.mm.sdk.b.a.xmy.m(jiVar);
                    }
                    g.Dt().cgr();
                    this.gLE.a(i2, i3, str, this);
                    return;
                }
            }
            x.w("MicroMsg.NetSceneManualAuth", "summerauth acct resp is null and return false!");
            this.gLE.a(4, -1, "", this);
        } else if (i2 == 4 && i3 == -301) {
            x.d("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC");
            com.tencent.mm.plugin.report.d.pVE.a(148, 4, 1, false);
            if (bqo == null || bqo.wZn == null) {
                x.w("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC but NetworkSectResp is null");
            } else {
                at.a(true, bqo.wZn.vTi, bqo.wZn.vTj, bqo.wZn.vTh);
            }
            this.hoC--;
            if (this.hoC <= 0) {
                x.w("MicroMsg.NetSceneManualAuth", "summerauth err and return with no try!");
                this.gLE.a(3, -1, "", this);
                return;
            }
            x.i("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC do scene again redirectCount:%d", Integer.valueOf(this.hoC));
            a(this.hok, this.gLE);
        } else if (!this.hPr && i2 == 4 && i3 == -102) {
            com.tencent.mm.plugin.report.d.pVE.a(148, 5, 1, false);
            i5 = qVar.Kh().vHZ.ver;
            x.i("MicroMsg.NetSceneManualAuth", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", Integer.valueOf(i5));
            g.Dt().F(new Runnable() {
                public final void run() {
                    new m().a(v.this.hok, new e() {
                        public final void a(int i, int i2, String str, k kVar) {
                            x.d("MicroMsg.NetSceneManualAuth", "summerauth dkcert getcert type:%d ret [%d,%d]", Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
                            if (i == 0 && i2 == 0) {
                                v.this.a(v.this.hok, v.this.gLE);
                            } else {
                                v.this.gLE.a(i, i2, "", v.this);
                            }
                        }
                    });
                }

                public final String toString() {
                    return super.toString() + "|onGYNetEnd1";
                }
            });
        } else if (i2 == 4 && i3 == -217) {
            this.gLE.a(i2, i3, str, this);
            com.tencent.mm.plugin.report.d.pVE.a(148, 47, 1, false);
        } else if (i2 == 4 && i3 == -218) {
            this.gLE.a(i2, i3, str, this);
            com.tencent.mm.plugin.report.d.pVE.a(148, 53, 1, false);
        } else if (i2 == 4 && i3 == -240) {
            x.i("MicroMsg.NetSceneManualAuth", "summerauth auth MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", Integer.valueOf(this.hoC));
            this.hoC--;
            if (this.hoC <= 0) {
                this.gLE.a(3, -1, "", this);
                return;
            }
            com.tencent.mm.plugin.report.d.pVE.a(148, 57, 1, false);
            a(this.hok, this.gLE);
        } else {
            x.w("MicroMsg.NetSceneManualAuth", "summerauth Failed. callback and return now ! [%d ,%d ,%s]", Integer.valueOf(i3), Integer.valueOf(i2), str);
            this.gLE.a(i2, i3, str, this);
            com.tencent.mm.plugin.report.d.pVE.a(148, 6, 1, false);
        }
    }

    public final int Oi() {
        if (((i.e) this.hoZ.Hv()).vHL.wZl == null) {
            return 3;
        }
        int i;
        bjx bjx = ((i.e) this.hoZ.Hv()).vHL.wZl.vQb;
        if (!(bjx == null || bjx.wTP == null || bjx.wTP.size() <= 0)) {
            Iterator it = bjx.wTP.iterator();
            while (it.hasNext()) {
                bnq bnq = (bnq) it.next();
                if (bnq.pWg == 6) {
                    i = bi.getInt(bnq.wXD, 3);
                    break;
                }
            }
        }
        i = 3;
        return i;
    }

    public final String Sf() {
        return ((i.e) this.hoZ.Hv()).vHL.wZl == null ? "" : ((i.e) this.hoZ.Hv()).vHL.wZl.vQa;
    }

    public final String Ov() {
        if (((i.e) this.hoZ.Hv()).vHL.wZl == null) {
            return "";
        }
        int Sg = Sg();
        if (Sg == 3) {
            if (((i.e) this.hoZ.Hv()).vHL.wZl.vPV != null) {
                return bi.oM(((i.e) this.hoZ.Hv()).vHL.wZl.vPV.wuU);
            }
        } else if (Sg == 1 && ((i.e) this.hoZ.Hv()).vHL.wZl.vPU != null) {
            return bi.oM(((i.e) this.hoZ.Hv()).vHL.wZl.vPU.vTt);
        }
        return "";
    }

    public final byte[] Ou() {
        if (((i.e) this.hoZ.Hv()).vHL.wZl == null) {
            return new byte[0];
        }
        int Sg = Sg();
        if (Sg == 3) {
            if (((i.e) this.hoZ.Hv()).vHL.wZl.vPV != null) {
                return n.a(((i.e) this.hoZ.Hv()).vHL.wZl.vPV.wuX, new byte[0]);
            }
        } else if (Sg == 1) {
            if (((i.e) this.hoZ.Hv()).vHL.wZl.vPU != null) {
                return n.a(((i.e) this.hoZ.Hv()).vHL.wZl.vPU.vNQ, new byte[0]);
            }
        } else if (Sg == 2 && ((d) this.hoZ.Kh()).vHI.wEj != null) {
            g.Do().Cx().a(bi.getLong(((d) this.hoZ.Kh()).vHI.wEj.kyG, 0), n.a(((i.e) this.hoZ.Hv()).vHL.wZl.vPT));
            return g.Do().Cx().aQ(bi.getLong(((d) this.hoZ.Kh()).vHI.wEj.kyG, 0));
        }
        return new byte[0];
    }

    public final int Sg() {
        if (((i.e) this.hoZ.Hv()).vHL.wZl == null) {
            x.e("MicroMsg.NetSceneManualAuth", "getSecCodeType ERROR AuthSectResp or WxVerifyCodeRespInfo is null");
            return 0;
        } else if (this.errType != 4) {
            x.e("MicroMsg.NetSceneManualAuth", "getSecCodeType ERROR errType :%d", Integer.valueOf(this.errType));
            return 0;
        } else if (this.errCode == -311) {
            return 2;
        } else {
            if (this.errCode == -6) {
                return 1;
            }
            return this.errCode == -310 ? 3 : 0;
        }
    }

    public final String Sh() {
        if (((i.e) this.hoZ.Hv()).vHL.wZl == null) {
            return "";
        }
        if (Sg() != 1 || ((i.e) this.hoZ.Hv()).vHL.wZl.vPU == null) {
            return "";
        }
        return ((i.e) this.hoZ.Hv()).vHL.wZl.vPU.xfF != null ? ((i.e) this.hoZ.Hv()).vHL.wZl.vPU.xfF : null;
    }

    public final String Od() {
        return ((i.e) this.hoZ.Hv()).vHL.wZl.vQc;
    }

    public final String Si() {
        return ((i.e) this.hoZ.Hv()).vHL.wZm.vMf;
    }

    public final int Sj() {
        if (((i.e) this.hoZ.Hv()).vHL.wZl == null) {
            return 0;
        }
        int i;
        bjx bjx = ((i.e) this.hoZ.Hv()).vHL.wZl.vQb;
        if (!(bjx == null || bjx.wTP == null || bjx.wTP.size() <= 0)) {
            Iterator it = bjx.wTP.iterator();
            while (it.hasNext()) {
                bnq bnq = (bnq) it.next();
                if (bnq.pWg == 11) {
                    i = bi.getInt(bnq.wXD, 0);
                    break;
                }
            }
        }
        i = 0;
        return i;
    }

    public final BindWordingContent Sk() {
        if (((i.e) this.hoZ.Hv()).vHL.wZl == null) {
            return null;
        }
        String str;
        BindWordingContent mv;
        bjx bjx = ((i.e) this.hoZ.Hv()).vHL.wZl.vQb;
        if (!(bjx == null || bjx.wTP == null || bjx.wTP.size() <= 0)) {
            Iterator it = bjx.wTP.iterator();
            while (it.hasNext()) {
                bnq bnq = (bnq) it.next();
                if (bnq.pWg == 12) {
                    str = bnq.wXD;
                    break;
                }
            }
        }
        str = null;
        if (str != null) {
            a aVar = new a();
            try {
                mv = a.mv(str);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneManualAuth", e, "", new Object[0]);
                mv = null;
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.NetSceneManualAuth", e2, "", new Object[0]);
            }
            return mv;
        }
        mv = null;
        return mv;
    }

    public final String Sl() {
        if (((i.e) this.hoZ.Hv()).vHL.wZl == null) {
            return "";
        }
        bjx bjx = ((i.e) this.hoZ.Hv()).vHL.wZl.vQb;
        if (!(bjx == null || bjx.wTP == null || bjx.wTP.size() <= 0)) {
            Iterator it = bjx.wTP.iterator();
            while (it.hasNext()) {
                bnq bnq = (bnq) it.next();
                if (bnq.pWg == 16) {
                    return bnq.wXD;
                }
            }
        }
        return "";
    }

    public final int Sm() {
        if (((i.e) this.hoZ.Hv()).vHL.wZl == null) {
            return 0;
        }
        int i;
        bjx bjx = ((i.e) this.hoZ.Hv()).vHL.wZl.vQb;
        if (!(bjx == null || bjx.wTP == null || bjx.wTP.size() <= 0)) {
            Iterator it = bjx.wTP.iterator();
            while (it.hasNext()) {
                bnq bnq = (bnq) it.next();
                if (bnq.pWg == 13) {
                    i = bi.getInt(bnq.wXD, 0);
                    break;
                }
            }
        }
        i = 0;
        return i;
    }

    public final boolean Sn() {
        if (((i.e) this.hoZ.Hv()).vHL.wZl == null) {
            return true;
        }
        bjx bjx = ((i.e) this.hoZ.Hv()).vHL.wZl.vQb;
        if (!(bjx == null || bjx.wTP == null || bjx.wTP.size() <= 0)) {
            Iterator it = bjx.wTP.iterator();
            while (it.hasNext()) {
                bnq bnq = (bnq) it.next();
                if (bnq.pWg == 18) {
                    if (bi.getInt(bnq.wXD, 0) == 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
