package com.tencent.mm.modelsimple;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.a.o;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.ax.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.protocal.c.bjx;
import com.tencent.mm.protocal.c.bnq;
import com.tencent.mm.protocal.y.a;
import com.tencent.mm.protocal.y.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.t;
import com.tencent.mm.y.ar;
import com.tencent.mm.y.at;
import com.tencent.mm.y.av;
import com.tencent.mm.y.be;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class y extends k implements com.tencent.mm.network.k {
    e gLE;
    private final String hPB;
    private final String hPC;
    private final String hPD;
    private final String hPE;
    private final String hPF;
    private final String hPG;
    private final int hPH;
    private final int hPI;
    private boolean hPJ = true;
    public boolean hPK = false;
    private int hoC = 2;
    public q hoZ;

    public y(String str, String str2, String str3, int i, String str4, String str5, String str6, int i2) {
        x.d("MicroMsg.NetSceneReg", "NetSceneReg: username = " + str + " nickname = " + str3);
        x.d("MicroMsg.NetSceneReg", "NetSceneReg: bindUin = " + i + "bindEmail = " + str4 + " bindMobile = " + str5);
        x.d("MicroMsg.NetSceneReg", "NetSceneReg: regMode = " + i2 + " ticket: " + str6);
        this.hPI = i2;
        this.hoZ = new av();
        a aVar = (a) this.hoZ.Kh();
        aVar.eE(0);
        aVar.vIE.kyG = str;
        aVar.vIE.vTg = bi.Wh(str2);
        if (i2 == 4) {
            aVar.vIE.vTg = str6;
            x.w("MicroMsg.NetSceneReg", "dkreg rand:" + str6 + " reqMd5:" + aVar.vIE.vTg);
        }
        aVar.vIE.kzN = str3;
        aVar.vIE.vMd = i;
        aVar.vIE.vMe = str4;
        aVar.vIE.vMf = str5;
        aVar.vIE.wgO = str6;
        aVar.vIE.wuW = i2;
        aVar.vIE.lTY = bi.che();
        aVar.vIE.wgM = com.tencent.mm.compatible.e.q.getSimCountryIso();
        aVar.vIE.lTZ = w.cfV();
        aVar.vIE.vQp = 0;
        aVar.vIE.wIi = 0;
        aVar.vIE.wIj = com.tencent.mm.compatible.e.q.getAndroidId();
        aVar.vIE.wjw = com.tencent.mm.compatible.e.q.yN();
        aVar.vIE.wIk = ad.getContext().getSharedPreferences(ad.cgf(), 0).getString("installreferer", "");
        aVar.vIE.wIl = d.oXY.up(2);
        aVar.vIE.wIm = ad.getContext().getSharedPreferences(ad.cgf() + "_google_aid", 4).getString("getgoogleaid", "");
        this.hPB = str;
        this.hPC = str2;
        this.hPD = str3;
        this.hPE = str4;
        this.hPF = str5;
        this.hPH = i;
        this.hPG = "";
        boolean z = (str6 == null || str6.length() <= 0) && str4.length() <= 0;
        this.hPJ = z;
        aVar.vIE.vQq = com.tencent.mm.kernel.a.CI();
    }

    public y(String str, String str2, String str3, int i, String str4, String str5, String str6, String str7, String str8, int i2, String str9, String str10, String str11, boolean z, boolean z2) {
        x.i("MicroMsg.NetSceneReg", "init: use:%s pwd:%s nick:%s bindqq:%d email:%s mobile:%s [%s,%s,%s] regmode:%d alias:%s [%s,%s] force:%b avatar:%b", str, bi.Wz(str2), str3, Integer.valueOf(i), str4, str5, str6, str7, str8, Integer.valueOf(i2), str9, str11, str10, Boolean.valueOf(z), Boolean.valueOf(z2));
        this.hPI = i2;
        this.hoZ = new av();
        a aVar = (a) this.hoZ.Kh();
        aVar.eE(0);
        aVar.vIE.kyG = str;
        aVar.vIE.vTg = bi.Wh(str2);
        if (i2 == 4) {
            aVar.vIE.vTg = str8;
            x.w("MicroMsg.NetSceneReg", "dkreg rand:" + str8 + " reqMd5:" + aVar.vIE.vTg);
        }
        aVar.vIE.kzN = str3;
        aVar.vIE.vMd = i;
        aVar.vIE.vMe = str4;
        aVar.vIE.vMf = str5;
        aVar.vIE.wgO = str8;
        aVar.vIE.wuW = i2;
        aVar.vIE.lTY = bi.che();
        aVar.vIE.wgM = com.tencent.mm.compatible.e.q.getSimCountryIso();
        aVar.vIE.lTZ = w.cfV();
        aVar.vIE.vQp = 0;
        aVar.vIE.hxj = str9;
        aVar.vIE.wuV = str11;
        aVar.vIE.wuU = str10;
        aVar.vIE.vSW = z ? 1 : 0;
        aVar.vIE.wIh = z2 ? 1 : 0;
        aVar.vIE.vQq = com.tencent.mm.kernel.a.CI();
        aVar.vIE.wIj = com.tencent.mm.compatible.e.q.getAndroidId();
        aVar.vIE.wjw = com.tencent.mm.compatible.e.q.yN();
        aVar.vIE.wIk = ad.getContext().getSharedPreferences(ad.cgf(), 0).getString("installreferer", "");
        aVar.vIE.wIl = d.oXY.up(2);
        aVar.vIE.wIm = ad.getContext().getSharedPreferences(ad.cgf() + "_google_aid", 4).getString("getgoogleaid", "");
        this.hPB = str;
        this.hPC = str2;
        this.hPD = str3;
        this.hPE = str4;
        this.hPF = str5;
        this.hPH = i;
        this.hPG = str9;
        boolean z3 = (str8 == null || str8.length() <= 0) && (str4 == null || str4.length() <= 0);
        this.hPJ = z3;
    }

    public final void iv(int i) {
        ((a) this.hoZ.Kh()).vIE.vTc = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.hoZ, this);
    }

    protected final int Bo() {
        return 3;
    }

    protected final int a(q qVar) {
        return b.hoz;
    }

    protected final void a(a aVar) {
    }

    public final void mB(String str) {
        if (!bi.oN(str)) {
            ((a) this.hoZ.Kh()).vIE.vTd = str;
        }
    }

    public final int getType() {
        return 126;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        int i4;
        final b bVar = (b) qVar.Hv();
        if (bVar.vIF != null) {
            i4 = bVar.vIF.vQg;
            x.i("MicroMsg.NetSceneReg", "summerauth mmtls reg:%s", Integer.valueOf(i4));
            g.Dr();
            g.Dq().gRO.set(47, Integer.valueOf(i4));
            com.tencent.mm.network.e eVar = g.Dp().gRu.hoF;
            if (eVar != null) {
                eVar.bJ((i4 & 1) == 0);
            }
        } else {
            x.i("MicroMsg.NetSceneReg", "summerauth mmtls reg not set as ret:%s", Integer.valueOf(bVar.vIb));
        }
        if (i2 == 4 && i3 == -301) {
            at.a(true, bVar.vIF.vTi, bVar.vIF.vTj, bVar.vIF.vTh);
            this.hoC--;
            if (this.hoC <= 0) {
                this.gLE.a(3, -1, "", this);
            } else {
                a(this.hok, this.gLE);
            }
        } else if (i2 == 4 && i3 == -240) {
            x.i("MicroMsg.NetSceneReg", "summerauth auth MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", Integer.valueOf(this.hoC));
            this.hoC--;
            if (this.hoC <= 0) {
                this.gLE.a(3, -1, "", this);
            } else {
                a(this.hok, this.gLE);
            }
        } else if (i2 == 4 && i3 == -102) {
            i4 = qVar.Kh().vHZ.ver;
            x.i("MicroMsg.NetSceneReg", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", Integer.valueOf(i4));
            g.Dt().F(new Runnable() {
                public final void run() {
                    new m().a(y.this.hok, new e() {
                        public final void a(int i, int i2, String str, k kVar) {
                            x.d("MicroMsg.NetSceneReg", "summerauth dkcert getcert type:%d ret [%d,%d]", Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
                            if (i == 0 && i2 == 0) {
                                y.this.a(y.this.hok, y.this.gLE);
                            } else {
                                y.this.gLE.a(i, i2, "", y.this);
                            }
                        }
                    });
                }
            });
        } else if (i2 == 0 && i3 == 0) {
            a aVar = (a) qVar.Kh();
            x.d("MicroMsg.NetSceneReg", "dkreg: pass:" + bVar.vIF.lTQ + " regtype:" + bVar.vIF.vMh + " mode:" + aVar.vIE.wuW);
            if (!(bVar.vIF.lTO == 0 || this.hPJ)) {
                g.Dr();
                g.gD(bVar.vIF.lTO);
                if (aVar.vIE.wuW == 4) {
                    g.Dq().Db().set(2, aVar.vIE.kyG);
                }
                g.Dq().Db().set(16, Integer.valueOf(1));
                g.Dq().Db().set(52, Integer.valueOf(bVar.vIF.vMh));
                g.Dq().Db().set(340240, Long.valueOf(System.currentTimeMillis()));
                g.Dq().Db().set(340241, Boolean.valueOf(true));
                if (!(this.hPB == null || this.hPB.length() <= 0 || this.hPI == 1)) {
                    bVar.vIF.kyG = this.hPB;
                }
                bVar.vIF.vMe = this.hPE;
                bVar.vIF.kyY = 0;
                if (!g.Do().CF() || g.Dq().Db() == null) {
                    r7 = new Object[3];
                    g.Do();
                    r7[1] = o.getString(com.tencent.mm.kernel.a.Cn());
                    r7[2] = g.Dq().Db();
                    x.e("MicroMsg.NetSceneReg", "dkwt ERR: updateProfile acc:%b uin:%s userConfigStg:%s", r7);
                } else {
                    String str2 = this.hPG;
                    int i5 = this.hPH;
                    String str3 = this.hPD;
                    String str4 = this.hPF;
                    String str5 = bVar.vIF.kyG;
                    String str6 = bVar.vIF.vMe;
                    int i6 = bVar.vIF.kyY;
                    String str7 = bVar.vIF.vMk;
                    String str8 = bVar.vIF.vMl;
                    int i7 = bVar.vIF.vMm;
                    int i8 = bVar.vIF.wIr;
                    String str9 = bVar.vIF.vKL;
                    String str10 = bVar.vIF.vMn;
                    String str11 = bVar.vIF.vPY;
                    String str12 = bVar.vIF.wIq;
                    x.i("MicroMsg.HandleAuthResponse", "dkwt updateProfile user:%s alias:%s qq:%s nick:%s email:%s mobile:%s status:%d offuser:%s offnick:%s pushmail:%d sendCard:%d session:%s fsurl:%s pluginFlag:%d atuhkey:%s a2:%s newa2:%s kisd:%s safedev:%d MicroBlog:%s emailpwd:%d", str5, str2, o.getString(i5), str3, str6, str4, Integer.valueOf(i6), str7, str8, Integer.valueOf(i7), Integer.valueOf(i8), bi.Wz(str9), str10, Integer.valueOf(0), bi.Wz(str11), bi.Wz(null), bi.Wz(null), bi.Wz(null), Integer.valueOf(-1), str12, Integer.valueOf(0));
                    t Db = g.Dq().Db();
                    ar.hhz.S("login_weixin_username", str5);
                    ar.hhz.S("last_login_nick_name", str3);
                    ar.hhz.c(str4, i5, str6);
                    Db.set(2, str5);
                    Db.set(42, str2);
                    Db.set(9, Integer.valueOf(i5));
                    Db.set(4, str3);
                    Db.set(5, str6);
                    Db.set(6, str4);
                    Db.set(7, Integer.valueOf(i6));
                    Db.set(21, str7);
                    Db.set(22, str8);
                    Db.set(57, Integer.valueOf(0));
                    Db.set(17, Integer.valueOf(i7));
                    Db.set(25, Integer.valueOf(i8));
                    Db.set(1, str9);
                    Db.set(29, str10);
                    Db.set(34, Integer.valueOf(0));
                    Db.set(256, Boolean.valueOf(false));
                    x.i("MicroMsg.HandleAuthResponse", "summerstatus USERINFO_FORCE_UPDATE_AUTH set false");
                    Db.set(-1535680990, str11);
                    Db.set(46, null);
                    Db.set(72, null);
                    Db.set(64, Integer.valueOf(-1));
                    Db.lO(true);
                    ((PluginAuth) g.k(PluginAuth.class)).getHandleAuthResponseCallbacks().a(bVar, this.hPG, this.hPH, this.hPD, this.hPF, 0);
                }
                at.a(false, bVar.vIF.vTi, bVar.vIF.vTj, bVar.vIF.vTh);
                g.Dq().Db().lO(true);
                g.CN().a(new be(new be.a() {
                    public final void a(com.tencent.mm.network.e eVar) {
                        if (eVar != null) {
                            eVar.KD().v(bVar.ibg, bVar.vIF.lTO);
                        }
                    }
                }), 0);
                x.d("MicroMsg.NetSceneReg", "resp return flag" + bVar.vIF.wIt);
                this.hPK = (bVar.vIF.wIt & 1) != 0;
            }
            List linkedList = new LinkedList();
            linkedList.add(new i.a(21, "android-" + VERSION.SDK_INT + "-" + Build.MODEL));
            ((h) g.h(h.class)).Fe().b(new i(linkedList));
            if (i2 == 0 && i3 == 0) {
                com.tencent.mm.plugin.c.b.jg(Om());
            }
            this.gLE.a(i2, i3, str, this);
        } else {
            this.gLE.a(i2, i3, str, this);
        }
    }

    public final byte[] Ou() {
        return n.a(((b) this.hoZ.Hv()).vIF.wuX, new byte[0]);
    }

    public final String Ov() {
        return ((b) this.hoZ.Hv()).vIF.wuU;
    }

    public final String So() {
        return ((b) this.hoZ.Hv()).vIF.wIx;
    }

    public final int Om() {
        bjx bjx = ((b) this.hoZ.Hv()).vIF.vQb;
        if (!(bjx == null || bjx.wTP == null || bjx.wTP.size() <= 0)) {
            Iterator it = bjx.wTP.iterator();
            while (it.hasNext()) {
                bnq bnq = (bnq) it.next();
                if (bnq.pWg == 1) {
                    return bi.getInt(bnq.wXD, 0);
                }
            }
        }
        return 0;
    }

    public final String Sp() {
        bjx bjx = ((b) this.hoZ.Hv()).vIF.vQb;
        String str = "";
        if (!(bjx == null || bjx.wTP == null || bjx.wTP.size() <= 0)) {
            Iterator it = bjx.wTP.iterator();
            while (it.hasNext()) {
                bnq bnq = (bnq) it.next();
                if (bnq.pWg == 2) {
                    return bnq.wXD;
                }
            }
        }
        return str;
    }

    public final int Sq() {
        bjx bjx = ((b) this.hoZ.Hv()).vIF.vQb;
        if (!(bjx == null || bjx.wTP == null || bjx.wTP.size() <= 0)) {
            Iterator it = bjx.wTP.iterator();
            while (it.hasNext()) {
                bnq bnq = (bnq) it.next();
                if (bnq.pWg == 3) {
                    return bi.getInt(bnq.wXD, 2);
                }
            }
        }
        return 2;
    }

    public final String Sr() {
        bjx bjx = ((b) this.hoZ.Hv()).vIF.vQb;
        if (!(bjx == null || bjx.wTP == null || bjx.wTP.size() <= 0)) {
            Iterator it = bjx.wTP.iterator();
            while (it.hasNext()) {
                bnq bnq = (bnq) it.next();
                if (bnq.pWg == 17) {
                    return bnq.wXD;
                }
            }
        }
        return null;
    }
}
