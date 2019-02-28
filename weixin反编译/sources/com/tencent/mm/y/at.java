package com.tencent.mm.y;

import android.content.SharedPreferences;
import com.tencent.mm.a.o;
import com.tencent.mm.ad.i;
import com.tencent.mm.network.q;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.c.aku;
import com.tencent.mm.protocal.c.akv;
import com.tencent.mm.protocal.c.aqq;
import com.tencent.mm.protocal.c.aqs;
import com.tencent.mm.protocal.c.atk;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.bqo;
import com.tencent.mm.protocal.c.byk;
import com.tencent.mm.protocal.c.cca;
import com.tencent.mm.protocal.c.dz;
import com.tencent.mm.protocal.c.ei;
import com.tencent.mm.protocal.c.ej;
import com.tencent.mm.protocal.c.el;
import com.tencent.mm.protocal.c.ff;
import com.tencent.mm.protocal.c.iq;
import com.tencent.mm.protocal.c.ir;
import com.tencent.mm.protocal.c.sc;
import com.tencent.mm.protocal.i.b;
import com.tencent.mm.protocal.i.c;
import com.tencent.mm.protocal.i.d;
import com.tencent.mm.protocal.i.e;
import com.tencent.mm.protocal.i.f;
import com.tencent.mm.protocal.i.g;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.s;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class at extends i implements c {
    private static a hhT = null;
    private final int hhQ;
    private final f hhR;
    private final g hhS;

    public interface a {
        void a(f fVar, g gVar);
    }

    public at(int i) {
        boolean z = i == 702 || i == 701;
        Assert.assertTrue(z);
        this.hhQ = i;
        if (i == 702) {
            this.hhR = new com.tencent.mm.protocal.i.a();
            this.hhS = new b();
            return;
        }
        this.hhR = new d();
        this.hhS = new e();
    }

    private q gU(int i) {
        x.i("MicroMsg.MMReqRespAuth", "summerauth autoAuthReq authReqFlag:%d, this:%d, stack:%s", Integer.valueOf(i), Integer.valueOf(hashCode()), bi.chl());
        f fVar = (f) Kh();
        g gVar = this.hhS;
        SharedPreferences Ht = au.Ht();
        x.d("MicroMsg.MMReqRespAuth", "summerauth updateVersion:%d, clientVersion:%d", Integer.valueOf(Ht.getInt("key_auth_update_version", 0)), Integer.valueOf(com.tencent.mm.protocal.d.vHl));
        if (Ht.getInt("key_auth_update_version", 0) < com.tencent.mm.protocal.d.vHl) {
            fVar.vHV = this.hhQ == 702 ? 12 : 16;
            com.tencent.mm.plugin.report.d.pVE.a(148, this.hhQ == 702 ? 14 : 13, 1, false);
        } else {
            fVar.vHV = this.hhQ == 702 ? 2 : 1;
        }
        ff ffVar = new ff();
        ffVar.vRL = i;
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
        if (com.tencent.mm.kernel.g.Do().CF()) {
            String oVar;
            byte[] bArr;
            com.tencent.mm.kernel.g.Dr();
            String oM = bi.oM((String) com.tencent.mm.kernel.g.Dq().Db().get(2, null));
            com.tencent.mm.kernel.g.Dr();
            o oVar2 = new o(bi.a((Integer) com.tencent.mm.kernel.g.Dq().Db().get(9, null), 0));
            if (bi.oN(oM)) {
                oVar = oVar2.toString();
            } else {
                oVar = oM;
            }
            com.tencent.mm.kernel.g.Dr();
            byte[] a = com.tencent.mm.kernel.g.Do().Cx().a(oVar2.longValue(), "", this.hhQ == 701);
            String str = "MicroMsg.MMReqRespAuth";
            String str2 = "summerauth loginbuf username:%s, qq:%s, len:%d, content:[%s]";
            Object[] objArr = new Object[4];
            objArr[0] = oVar;
            objArr[1] = oVar2;
            objArr[2] = Integer.valueOf(a == null ? -1 : a.length);
            objArr[3] = a == null ? "null" : bi.Wz(bi.bx(a));
            x.i(str, str2, objArr);
            bes bes = new bes();
            if (bi.by(a)) {
                bArr = new byte[0];
            } else {
                bArr = a;
            }
            ffVar.vRI = bes.bl(bArr);
            if (this.hhQ == 702) {
                com.tencent.mm.protocal.i.a aVar = (com.tencent.mm.protocal.i.a) fVar;
                b bVar = (b) gVar;
                ei eiVar = new ei();
                el elVar = new el();
                aVar.vHG.vQu = elVar;
                aVar.vHG.vQv = eiVar;
                bArr = bi.Wj(Ht.getString("_auth_key", ""));
                ej ejVar = new ej();
                if (bi.by(bArr)) {
                    com.tencent.mm.plugin.report.d.pVE.a(148, 16, 1, false);
                    eiVar.vPR = new bes().bl(new byte[0]);
                } else {
                    eiVar.vPR = new bes().bl(bArr);
                    try {
                        ejVar.aH(bArr);
                    } catch (Throwable e) {
                        com.tencent.mm.plugin.report.d.pVE.a(148, 15, 1, false);
                        x.printErrStackTrace("MicroMsg.MMReqRespAuth", e, "summerauthkey Failed parse autoauthkey buf", new Object[0]);
                    }
                }
                if (ejVar.vQs != null) {
                    elVar.vQw = ejVar.vQs;
                } else {
                    com.tencent.mm.plugin.report.d.pVE.a(148, 17, 1, false);
                    elVar.vQw = new bes().bl(new byte[0]);
                    x.w("MicroMsg.MMReqRespAuth", "summerauthkey AesEncryptKey null!");
                }
                eiVar.vQn = ffVar;
                aVar.username = oVar;
                bVar.ibj = oVar;
                return this;
            }
            d dVar = (d) fVar;
            aqs aqs = new aqs();
            aqq aqq = new aqq();
            dVar.vHI.wEj = aqs;
            dVar.vHI.wEk = aqq;
            aqq.wEi = 2;
            aqq.vQn = ffVar;
            aqs.kyG = oVar;
            com.tencent.mm.kernel.g.Dr();
            oM = bi.oM((String) com.tencent.mm.kernel.g.Dq().Db().get(3, null));
            com.tencent.mm.kernel.g.Dr();
            aqs.vTg = bi.oM((String) com.tencent.mm.kernel.g.Dq().Db().get(19, null));
            aqs.vTs = oM;
            return this;
        }
        x.e("MicroMsg.MMReqRespAuth", "autoAuthReq build autoauth Req  , failed  acc not ready");
        return null;
    }

    public final int Hs() {
        if (com.tencent.mm.kernel.g.Do().CF()) {
            com.tencent.mm.kernel.g.Dr();
            com.tencent.mm.kernel.g.Do();
            return com.tencent.mm.kernel.a.Cn();
        }
        x.e("MicroMsg.MMReqRespAuth", "dkwt acc NOT Ready , the fucking MMReqRespBase need the fucking uin ???  if u find this log , fuck dk. %s", bi.chl());
        return 0;
    }

    public final q aW(int i, int i2) {
        return new at(i).gU(i2);
    }

    public static void a(a aVar) {
        hhT = aVar;
    }

    public final void a(f fVar, g gVar, int i, int i2, String str) {
        if (com.tencent.mm.kernel.g.Do().CF()) {
            bqo bqo = gVar.vHL;
            if (bqo == null || bqo.wZl == null) {
                x.i("MicroMsg.MMReqRespAuth", "summerauth mmtls auto not set as ret:%s", Integer.valueOf(gVar.vIb));
            } else {
                int i3 = gVar.vHL.wZl.vQg;
                x.i("MicroMsg.MMReqRespAuth", "summerauth mmtls auto:%s", Integer.valueOf(i3));
                com.tencent.mm.kernel.g.Dr();
                com.tencent.mm.kernel.g.Dq().gRO.set(47, Integer.valueOf(i3));
                com.tencent.mm.network.e eVar = com.tencent.mm.kernel.g.Dp().gRu.hoF;
                if (eVar != null) {
                    eVar.bJ((i3 & 1) == 0);
                }
            }
            x.i("MicroMsg.MMReqRespAuth", "summerauth onAutoAuthEnd errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i == 0 && i2 == 0) {
                if (hhT != null) {
                    hhT.a(fVar, gVar);
                    return;
                }
                return;
            } else if (i == 4 && i2 == -301) {
                com.tencent.mm.plugin.report.d.pVE.a(148, 18, 1, false);
                x.d("MicroMsg.MMReqRespAuth", "dkidc onAutoAuthEnd RedirectIDC");
                if (bqo == null || bqo.wZn == null) {
                    x.w("MicroMsg.MMReqRespAuth", "dkidc onAutoAuthEnd RedirectIDC but NetworkSectResp is null");
                    return;
                } else {
                    a(true, gVar.vHL.wZn.vTi, gVar.vHL.wZn.vTj, gVar.vHL.wZn.vTh);
                    return;
                }
            } else {
                return;
            }
        }
        x.e("MicroMsg.MMReqRespAuth", "summerauth onAutoAuthEnd but account not ready");
    }

    public static void a(boolean z, ir irVar, atk atk, akv akv) {
        String str = "MicroMsg.MMReqRespAuth";
        String str2 = "dkidc updateMultiIDCInfo resetnewwork:%b iplist[l:%d s:%d] hostList[%d] noop[%d %d] typing[%d] port[%s] timeout[%s]";
        Object[] objArr = new Object[9];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(irVar == null ? -1 : irVar.vVx);
        objArr[2] = Integer.valueOf(irVar == null ? -1 : irVar.vVy);
        objArr[3] = Integer.valueOf(akv == null ? -1 : akv.kyA);
        objArr[4] = Integer.valueOf(atk == null ? -1 : atk.wHU);
        objArr[5] = Integer.valueOf(atk == null ? -1 : atk.wHV);
        objArr[6] = Integer.valueOf(atk == null ? -1 : atk.wHW);
        objArr[7] = atk == null ? "null" : atk.wHS;
        objArr[8] = atk == null ? "null" : atk.wHT;
        x.i(str, str2, objArr);
        if (akv == null || akv.kyB == null || akv.kyB.size() <= 0) {
            x.f("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo give empty host request! stack:[%s]", bi.chl());
        } else if (akv == null || akv.kyB == null || akv.kyB.size() <= 0) {
            x.f("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo give empty host request! stack:[%s]", bi.chl());
        } else {
            iq iqVar;
            com.tencent.mm.protocal.n.a fr;
            List linkedList = new LinkedList();
            linkedList.clear();
            if (irVar != null) {
                Iterator it = irVar.vVB.iterator();
                while (it.hasNext()) {
                    iqVar = (iq) it.next();
                    str = "";
                    if (iqVar.vVw != null) {
                        str = iqVar.vVw.cec();
                    }
                    linkedList.add(new n(iqVar.type, iqVar.vVv.cec(), iqVar.port, str));
                    x.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo short type:%d port:%d ip:%s", Integer.valueOf(iqVar.type), Integer.valueOf(iqVar.port), iqVar.vVv.cec());
                }
            }
            str2 = n.cA(linkedList);
            List linkedList2 = new LinkedList();
            if (irVar != null) {
                Iterator it2 = irVar.vVA.iterator();
                while (it2.hasNext()) {
                    iqVar = (iq) it2.next();
                    str = "";
                    if (iqVar.vVw != null) {
                        str = iqVar.vVw.cec();
                    }
                    linkedList2.add(new n(iqVar.type, iqVar.vVv.cec(), iqVar.port, str));
                    x.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo long type:%d port:%d ip:%s", Integer.valueOf(iqVar.type), Integer.valueOf(iqVar.port), iqVar.vVv.cec());
                }
            }
            String cA = n.cA(linkedList2);
            x.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo builtin ip long[%s] short[%s]", cA, str2);
            com.tencent.mm.kernel.g.Dr();
            com.tencent.mm.kernel.g.Dq().gRO.set(2, str2);
            SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("system_config_prefs", 0);
            sharedPreferences.edit().putString("builtin_short_ips", str2).commit();
            com.tencent.mm.kernel.g.Dr();
            com.tencent.mm.kernel.g.Dq().gRO.set(3, cA);
            if (atk != null) {
                com.tencent.mm.kernel.g.Dr();
                com.tencent.mm.kernel.g.Dq().gRO.set(6, atk.wHS);
                com.tencent.mm.kernel.g.Dr();
                com.tencent.mm.kernel.g.Dq().gRO.set(7, atk.wHT);
                if (atk.wHW != 0) {
                    int i;
                    com.tencent.mm.kernel.g.Dr();
                    s sVar = com.tencent.mm.kernel.g.Dq().gRO;
                    if (atk.wHW > 60) {
                        i = 60;
                    } else {
                        i = atk.wHW;
                    }
                    sVar.set(35, Integer.valueOf(i));
                }
                com.tencent.mm.network.ad.n((long) atk.wHU, (long) atk.wHX);
                fr = n.fr(atk.wHS, atk.wHT);
            } else {
                fr = null;
            }
            String str3 = "";
            String str4 = "";
            String[] strArr = new String[akv.kyB.size()];
            String[] strArr2 = new String[akv.kyB.size()];
            int[] iArr = new int[akv.kyB.size()];
            x.d("MicroMsg.MMReqRespAuth", "hostlist.Count=%d", Integer.valueOf(akv.kyA));
            Iterator it3 = akv.kyB.iterator();
            int i2 = 0;
            while (it3.hasNext()) {
                aku aku = (aku) it3.next();
                x.d("MicroMsg.MMReqRespAuth", "dkidc host org:%s sub:%s", aku.wyM, aku.wyN);
                strArr[i2] = aku.wyM;
                strArr2[i2] = aku.wyN;
                iArr[i2] = aku.wyO;
                i2++;
                if (!(bi.oN(aku.wyM) || bi.oN(aku.wyN))) {
                    if (aku.wyM.equals("short.weixin.qq.com")) {
                        com.tencent.mm.kernel.g.Dr();
                        com.tencent.mm.kernel.g.Dq().gRO.set(24, aku.wyN);
                        str4 = aku.wyN;
                    } else if (aku.wyM.equals("long.weixin.qq.com")) {
                        com.tencent.mm.kernel.g.Dr();
                        com.tencent.mm.kernel.g.Dq().gRO.set(25, aku.wyN);
                        str3 = aku.wyN;
                    } else if (aku.wyM.equals("support.weixin.qq.com") && !bi.oN(aku.wyN)) {
                        sharedPreferences.edit().putString("support.weixin.qq.com", aku.wyN).commit();
                    }
                }
            }
            com.tencent.mm.kernel.g.Dr();
            com.tencent.mm.network.e eVar = com.tencent.mm.kernel.g.Dp().gRu.hoF;
            if (strArr.length > 0 && eVar != null) {
                eVar.setHostInfo(strArr, strArr2, iArr);
            }
            if (!bi.oN(str3)) {
                com.tencent.mm.kernel.g.Dr();
                com.tencent.mm.kernel.g.Dq().gRO.set(25, str3);
            }
            if (!bi.oN(str4)) {
                com.tencent.mm.kernel.g.Dr();
                com.tencent.mm.kernel.g.Dq().gRO.set(24, str4);
            }
            if (eVar != null && fr != null) {
                eVar.a(z, str2, cA, fr.vIi, fr.vIj, fr.vIk, fr.vIl, str4, str3);
            }
        }
    }

    public static SharedPreferences Ht() {
        return au.Ht();
    }

    protected final k.d Hu() {
        return this.hhR;
    }

    public final k.e Hv() {
        return this.hhS;
    }

    public final int getType() {
        return this.hhR.Hx();
    }

    public final String getUri() {
        return this.hhR.getUri();
    }

    public static int b(q qVar) {
        g gVar = (g) qVar.Hv();
        x.i("MicroMsg.MMReqRespAuth", "summerauth decodeAndRetriveAccInfo type:%d, hashcode:%d, ret:%d, stack[%s]", Integer.valueOf(((f) qVar.Kh()).Hx()), Integer.valueOf(qVar.hashCode()), Integer.valueOf(gVar.vHN), bi.chl());
        if (gVar.vHN != 0) {
            x.d("MicroMsg.MMReqRespAuth", "summerauth decodeAndRetriveAccInfo resp just decoded and ret result:%d", Integer.valueOf(gVar.vHN));
            return gVar.vHN;
        }
        bqo bqo = gVar.vHL;
        int i = bqo.wZk;
        if ((i & 1) != 0) {
            dz dzVar = bqo.wZl;
            x.i("MicroMsg.MMReqRespAuth", "decodeAndRetriveAccInfo authResultFlag:%d UpdateFlag:%d ", Integer.valueOf(dzVar.vQf), Integer.valueOf(dzVar.vQe));
            sc scVar = dzVar.vPP;
            byte[] a = com.tencent.mm.platformtools.n.a(dzVar.vPQ);
            String str = "MicroMsg.MMReqRespAuth";
            String str2 = "summerauth svr ecdh key len:%d, nid:%d sessionKey len:%d, sessionKey：%s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(scVar.vQt.wRk);
            objArr[1] = Integer.valueOf(scVar.wgK);
            objArr[2] = Integer.valueOf(a == null ? -1 : a.length);
            objArr[3] = bi.Wz(bi.bx(a));
            x.d(str, str2, objArr);
            byte[] a2 = com.tencent.mm.platformtools.n.a(scVar.vQt);
            byte[] bArr = r0.vHK;
            if (bi.by(a2)) {
                com.tencent.mm.plugin.report.d.pVE.a(148, 24, 1, false);
                x.w("MicroMsg.MMReqRespAuth", "summerauth svr ecdh key is null!");
                a2 = null;
            } else {
                str2 = "MicroMsg.MMReqRespAuth";
                String str3 = "summerauth svrPubKey len:%d value:%s prikey len:%d, values:%s";
                Object[] objArr2 = new Object[4];
                objArr2[0] = Integer.valueOf(a2.length);
                objArr2[1] = bi.Wz(bi.bx(a2));
                objArr2[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
                objArr2[3] = bi.Wz(bi.bx(bArr));
                x.d(str2, str3, objArr2);
                PByteArray pByteArray = new PByteArray();
                int computerKeyWithAllStr = MMProtocalJni.computerKeyWithAllStr(scVar.wgK, a2, bArr, pByteArray, 0);
                a2 = pByteArray.value;
                str = "MicroMsg.MMReqRespAuth";
                str2 = "summerauth ComputerKeyWithAllStr ret:%d, agreedECDHKey len: %d, values:%s";
                objArr = new Object[3];
                objArr[0] = Integer.valueOf(computerKeyWithAllStr);
                objArr[1] = Integer.valueOf(a2 == null ? -1 : a2.length);
                objArr[2] = bi.Wz(bi.bx(a2));
                x.i(str, str2, objArr);
            }
            gVar.vHM = a2 != null ? a2 : new byte[0];
            if ((r12 & 4) != 0) {
                x.d("MicroMsg.MMReqRespAuth", "summerauth must decode session key");
                if (bi.by(a2)) {
                    com.tencent.mm.plugin.report.d.pVE.a(148, 26, 1, false);
                    x.d("MicroMsg.MMReqRespAuth", "summerauth decode session key failed as agreedECDHKey is null!");
                    gVar.bg(new byte[0]);
                    gVar.vHN = 2;
                } else {
                    a2 = MMProtocalJni.aesDecrypt(a, a2);
                    String str4 = "MicroMsg.MMReqRespAuth";
                    str = "summerauth aesDecrypt sessionKey len:%d, value:%s, session len:%d, value:%s";
                    Object[] objArr3 = new Object[4];
                    objArr3[0] = Integer.valueOf(a == null ? -1 : a.length);
                    objArr3[1] = bi.Wz(bi.bx(a));
                    objArr3[2] = Integer.valueOf(a2 == null ? -1 : a2.length);
                    objArr3[3] = bi.Wz(bi.bx(a2));
                    x.d(str4, str, objArr3);
                    if (bi.by(a2)) {
                        com.tencent.mm.plugin.report.d.pVE.a(148, 25, 1, false);
                        x.d("MicroMsg.MMReqRespAuth", "summerauth decode session key failed ret null!");
                        gVar.bg(new byte[0]);
                        gVar.vHN = 2;
                    } else {
                        x.d("MicroMsg.MMReqRespAuth", "summerauth decode session key succ session:%s", bi.Wz(bi.bx(a2)));
                        gVar.bg(a2);
                        gVar.vHN = 1;
                    }
                }
            } else {
                com.tencent.mm.plugin.report.d.pVE.a(148, 27, 1, false);
                x.d("MicroMsg.MMReqRespAuth", "summerauth not need decode session key");
                gVar.bg(a);
                gVar.vHN = 1;
            }
        } else {
            x.d("MicroMsg.MMReqRespAuth", "summerauth auth sect not set so ret failed");
            gVar.bg(new byte[0]);
            gVar.vHN = 2;
        }
        if ((i & 2) != 0) {
            gVar.ibj = bqo.wZm.kyG;
        } else {
            x.d("MicroMsg.MMReqRespAuth", "summerauth acct sect not set!");
        }
        return gVar.vHN;
    }
}
