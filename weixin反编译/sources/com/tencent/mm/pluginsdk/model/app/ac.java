package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.b.o;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.auz;
import com.tencent.mm.protocal.c.yi;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class ac extends k implements com.tencent.mm.network.k {
    private static final String[] vlx = new String[]{"wxf109da3e26cf89f1", "wxc56bba830743541e", "wx41dd4f6ef137bd0b"};
    final String appId;
    private b gLB;
    private e gLE;
    private final int hPf = 3;

    public ac(String str) {
        this.appId = str;
        a aVar = new a();
        aVar.hnT = new yi();
        aVar.hnU = new yj();
        aVar.uri = "/cgi-bin/micromsg-bin/getappinfo";
        aVar.hnS = 231;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        if (this.appId == null || this.appId.length() == 0) {
            x.e("MicroMsg.NetSceneGetAppInfo", "doScene fail, appId is null");
            return -1;
        }
        yi yiVar = (yi) this.gLB.hnQ.hnY;
        yiVar.nkU = this.appId;
        yiVar.wiC = this.hPf;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetAppInfo", "errType = " + i2 + ", errCode = " + i3);
        if (i2 == 4 && i3 == -1011) {
            x.e("MicroMsg.NetSceneGetAppInfo", "errType = " + i2 + ", errCode = " + i3 + ", appinfo does not exist");
            com.tencent.mm.plugin.y.a.biT();
            c bZx = i.bZx();
            bZx.field_appId = this.appId;
            com.tencent.mm.plugin.y.a.biT().a(bZx);
            this.gLE.a(i2, i3, str, this);
        } else if (i2 == 0 && i3 == 0) {
            f fVar;
            yj yjVar = (yj) ((b) qVar).hnR.hnY;
            String str2 = yjVar.wpA.vMN;
            auz auz = yjVar.wpA;
            if (auz == null) {
                x.e("MicroMsg.NetSceneGetAppInfo", "convertToAppInfo : openAppInfo is null");
                fVar = null;
            } else {
                fVar = new f();
                fVar.field_appId = auz.nkU;
                fVar.field_appName = auz.noG;
                fVar.field_appDiscription = auz.wJB;
                fVar.field_appIconUrl = auz.vML;
                fVar.field_appStoreUrl = auz.nlq;
                fVar.field_appVersion = auz.vTR;
                fVar.field_appWatermarkUrl = auz.wJC;
                fVar.field_packageName = auz.vMN;
                fVar.field_signature = p.So(auz.vTQ);
                fVar.field_appName_en = auz.wJD;
                fVar.field_appName_tw = auz.wJF;
                fVar.field_appDiscription_en = auz.wJE;
                fVar.field_appDiscription_tw = auz.wJG;
                fVar.field_appInfoFlag = auz.nlb;
                x.d("MicroMsg.NetSceneGetAppInfo", "appid = %s, appInfoFlag = %s", fVar.field_appId, Integer.valueOf(fVar.field_appInfoFlag));
            }
            if (fVar == null) {
                x.e("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd : info is null");
                this.gLE.a(3, -1, str, this);
                return;
            }
            fVar.field_appType = yjVar.vPL;
            auz auz2 = yjVar.wpA;
            String str3 = auz2.vMN;
            String str4 = auz2.vTQ;
            Object obj = (str3 == null || str3.length() == 0 || str4 == null || str4.length() == 0) ? 1 : null;
            if (obj != null || fVar.YI()) {
                x.e("MicroMsg.NetSceneGetAppInfo", "no android app, packageName = " + str2);
                com.tencent.mm.pluginsdk.ui.tools.b.Tq(this.appId);
            }
            if (fVar.field_appId == null) {
                x.e("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd : info.appId is null");
                this.gLE.a(3, -1, str, this);
            } else if (fVar.field_appId.equals(this.appId)) {
                i biT = com.tencent.mm.plugin.y.a.biT();
                o Sk = biT.Sk(this.appId);
                if (Sk == null || Sk.field_appId == null || Sk.field_appId.length() == 0) {
                    fVar.field_status = obj != null ? 3 : 4;
                    fVar.field_modifyTime = System.currentTimeMillis();
                    if (fVar.field_appId != null) {
                        for (Object equals : vlx) {
                            if (fVar.field_appId.equals(equals)) {
                                fVar.field_status = -1;
                                break;
                            }
                        }
                    }
                    if (biT.l(fVar)) {
                        com.tencent.mm.plugin.y.a.biR().cS(this.appId, 1);
                        com.tencent.mm.plugin.y.a.biR().cS(this.appId, 2);
                        com.tencent.mm.plugin.y.a.biR().cS(this.appId, 3);
                        com.tencent.mm.plugin.y.a.biR().cS(this.appId, 4);
                        com.tencent.mm.plugin.y.a.biR().cS(this.appId, 5);
                    } else {
                        x.e("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd : insert fail");
                        this.gLE.a(3, -1, str, this);
                        return;
                    }
                }
                fVar.field_status = obj != null ? 3 : Sk.field_status;
                if (fVar.field_appId != null) {
                    for (Object equals2 : vlx) {
                        if (fVar.field_appId.equals(equals2)) {
                            fVar.field_status = -1;
                            break;
                        }
                    }
                }
                if (Sk == null) {
                    x.e("MicroMsg.NetSceneGetAppInfo", "merge failed, some appinfo is null");
                } else {
                    if (Sk.bZq()) {
                        if (!bi.oN(Sk.field_appIconUrl)) {
                            fVar.field_appIconUrl = Sk.field_appIconUrl;
                        }
                        if (!bi.oN(Sk.field_appName)) {
                            fVar.field_appName = Sk.field_appName;
                        }
                        if (!bi.oN(Sk.field_appName_en)) {
                            fVar.field_appName_en = Sk.field_appName_en;
                        }
                        if (!bi.oN(Sk.field_appName_tw)) {
                            fVar.field_appName_tw = Sk.field_appName_tw;
                        }
                        if (!bi.oN(Sk.field_appName_hk)) {
                            fVar.field_appName_hk = Sk.field_appName_hk;
                        }
                    }
                    if (bi.oN(fVar.field_appId) || bi.oN(Sk.field_appId)) {
                        x.e("MicroMsg.NetSceneGetAppInfo", "merge failed, some appid is null");
                    } else if (fVar.field_appId.equalsIgnoreCase(Sk.field_appId)) {
                        fVar.field_openId = Sk.field_openId;
                        fVar.field_authFlag = Sk.field_authFlag;
                        fVar.cM(Sk.fRv);
                        fVar.cN(Sk.fRw);
                        fVar.cO(Sk.fRx);
                    } else {
                        x.e("MicroMsg.NetSceneGetAppInfo", "merge failed, appis is different");
                    }
                }
                if (biT.a(fVar, new String[0])) {
                    if (Sk == null || Sk.field_appIconUrl == null || Sk.field_appIconUrl.length() == 0) {
                        obj = 1;
                    } else {
                        if (!bi.oN(fVar.fRP)) {
                            if (bi.oN(Sk.fRP)) {
                                obj = 1;
                            } else if (!Sk.fRP.equals(Sk.fRP)) {
                                obj = 1;
                            }
                        }
                        if (!bi.oN(fVar.fRQ)) {
                            if (bi.oN(Sk.fRQ)) {
                                obj = 1;
                            } else if (!Sk.fRQ.equals(Sk.fRQ)) {
                                obj = 1;
                            }
                        }
                        obj = (fVar.field_appIconUrl == null || fVar.field_appIconUrl.length() == 0) ? null : !Sk.field_appIconUrl.equals(fVar.field_appIconUrl) ? 1 : null;
                    }
                    if (obj != null) {
                        com.tencent.mm.plugin.y.a.biR().cS(this.appId, 1);
                        com.tencent.mm.plugin.y.a.biR().cS(this.appId, 2);
                        com.tencent.mm.plugin.y.a.biR().cS(this.appId, 3);
                        com.tencent.mm.plugin.y.a.biR().cS(this.appId, 4);
                        com.tencent.mm.plugin.y.a.biR().cS(this.appId, 5);
                    }
                } else {
                    x.e("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd : update fail");
                    this.gLE.a(3, -1, str, this);
                    return;
                }
                if (bi.oN(fVar.field_openId)) {
                    x.d("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd, openId is null, trigger getAppSetting, appId = " + fVar.field_appId);
                    com.tencent.mm.plugin.y.a.biV().Pm(fVar.field_appId);
                }
                this.gLE.a(i2, i3, str, this);
            } else {
                x.e("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd : appId is different");
                this.gLE.a(3, -1, str, this);
            }
        } else {
            x.e("MicroMsg.NetSceneGetAppInfo", "errType = " + i2 + ", errCode = " + i3);
            this.gLE.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 231;
    }

    protected final int a(q qVar) {
        return b.hoz;
    }
}
