package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.sns.a.b.f;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.bkf;
import com.tencent.mm.protocal.c.bki;
import com.tencent.mm.protocal.c.bkn;
import com.tencent.mm.protocal.c.bku;
import com.tencent.mm.protocal.c.ble;
import com.tencent.mm.protocal.c.blf;
import com.tencent.mm.protocal.c.bli;
import com.tencent.mm.protocal.c.blj;
import com.tencent.mm.protocal.c.blk;
import com.tencent.mm.protocal.c.bll;
import com.tencent.mm.protocal.c.blm;
import com.tencent.mm.protocal.c.bls;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import java.util.Iterator;
import java.util.LinkedList;

public final class q extends k implements com.tencent.mm.network.k {
    private b gLB;
    public e gLE;
    private ag handler;
    public int qXb;
    private long qZZ;
    private bku raa;
    private Object rab;
    private int rac;
    public int type;

    public q(long j, int i) {
        this(j, i, null, null);
    }

    public q(long j, int i, Object obj) {
        this(j, i, null, obj);
    }

    public q(long j, int i, bku bku) {
        this(j, i, bku, null);
    }

    private q(long j, int i, bku bku, Object obj) {
        this.type = -1;
        this.qZZ = 0;
        this.qXb = -1;
        this.rac = 0;
        this.handler = new ag(Looper.getMainLooper());
        this.raa = bku;
        this.type = i;
        this.qZZ = j;
        this.rab = obj;
        x.i("MicroMsg.NetSceneSnsObjectOp", "snsId : " + j + "  op : " + i);
        if (bku != null) {
            x.i("MicroMsg.NetSceneSnsObjectOp", bku.wUn + " " + bku.wUq);
        }
        a aVar = new a();
        aVar.hnT = new bll();
        aVar.hnU = new blm();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsobjectop";
        aVar.hnS = 218;
        aVar.hnV = 104;
        aVar.hnW = 1000000104;
        this.gLB = aVar.Kf();
        bll bll = (bll) this.gLB.hnQ.hnY;
        m eS = ae.bwf().eS(j);
        if (eS != null) {
            this.qXb = eS.ruM;
        }
        bli a = a(j, i, this.raa, obj);
        LinkedList linkedList = new LinkedList();
        linkedList.add(a);
        bll.wVn = linkedList;
        bll.wVm = linkedList.size();
    }

    public q(long j, int i, int i2, String str) {
        this.type = -1;
        this.qZZ = 0;
        this.qXb = -1;
        this.rac = 0;
        this.handler = new ag(Looper.getMainLooper());
        this.raa = null;
        this.type = 9;
        this.qZZ = j;
        x.i("MicroMsg.NetSceneSnsObjectOp", "snsId : " + j + "  op : " + this.type);
        a aVar = new a();
        aVar.hnT = new bll();
        aVar.hnU = new blm();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsobjectop";
        aVar.hnS = 218;
        aVar.hnV = 104;
        aVar.hnW = 1000000104;
        this.gLB = aVar.Kf();
        bll bll = (bll) this.gLB.hnQ.hnY;
        m eS = ae.bwf().eS(j);
        if (eS != null) {
            this.qXb = eS.ruM;
        }
        bli x = x(j, this.type);
        blk blk = new blk();
        blk.sfa = i;
        blk.wVk = i2;
        blk.wVl = n.oK(str);
        try {
            x.wKx = new bes().bl(blk.toByteArray());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e, "", new Object[0]);
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(x);
        bll.wVn = linkedList;
        bll.wVm = linkedList.size();
    }

    private static bli a(long j, int i, bku bku, Object obj) {
        m mVar;
        String str;
        bli x = x(j, i);
        x.i("MicroMsg.NetSceneSnsObjectOp", "getSnsObjectOp " + i + " " + (obj == null ? "" : obj.toString()));
        String str2 = "";
        if (i == 8 || i == 10 || i == 7 || i == 8 || i == 6) {
            m byH;
            com.tencent.mm.plugin.sns.storage.e eL = ae.bwi().eL(j);
            if (eL != null) {
                byH = eL.byH();
            } else {
                byH = null;
            }
            if (byH == null || !byH.xD(32)) {
                mVar = byH;
            } else {
                com.tencent.mm.plugin.sns.storage.a byD = byH.byD();
                str = byD == null ? "" : byD.rfQ;
                x.i("MicroMsg.NetSceneSnsObjectOp", "aduxinfo " + str);
                str2 = str;
                mVar = byH;
            }
        } else {
            mVar = null;
        }
        if (i == 6) {
            if (bku == null || (bku.wUn == 0 && bku.wUq == 0)) {
                return x;
            }
            bkn bkn = new bkn();
            bkn.wUj = bku.wUq;
            bkn.wTZ = n.oK(bi.aD(str2, ""));
            try {
                x.wKx = new bes().bl(bkn.toByteArray());
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e, "", new Object[0]);
            }
        } else if (i == 7) {
            bkf bkf = new bkf();
            bkf.wTZ = n.oK(bi.aD(str2, ""));
            try {
                x.wKx = new bes().bl(bkf.toByteArray());
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e2, "", new Object[0]);
            }
        } else if (i == 8) {
            int i2 = (obj == null || !(obj instanceof com.tencent.mm.plugin.sns.storage.a.b.a)) ? 0 : 1;
            if (i2 != 0) {
                com.tencent.mm.plugin.sns.storage.a.b.a aVar = (com.tencent.mm.plugin.sns.storage.a.b.a) obj;
                str = bi.aD(str2, "") + ("&" + aVar.qWN + "|" + aVar.rkx);
            } else {
                str = str2;
            }
            bki bki = new bki();
            bki.wTZ = n.oK(bi.aD(str, ""));
            if (mVar != null) {
                bki.vON = mVar.bzm();
                mVar = ae.bwf().LQ(mVar.byG());
                if (mVar != null) {
                    str = f.a(mVar.byF());
                } else {
                    x.v("SnsAdExtUtil", "getSnsStatExtBySnsId snsInfo null, snsId %s", str);
                    str = "";
                }
                bki.wUb = n.oK(bi.aD(str, ""));
            }
            if (i2 == 0 || ((com.tencent.mm.plugin.sns.storage.a.b.a) obj).rkw != com.tencent.mm.plugin.sns.storage.a.b.a.rks) {
                ae.bwi().delete(j);
                ae.bwk().eN(j);
                if (i2 != 0) {
                    bki.wUc = ((com.tencent.mm.plugin.sns.storage.a.b.a) obj).rkw;
                }
            } else {
                bki.wUc = com.tencent.mm.plugin.sns.storage.a.b.a.rks;
            }
            try {
                x.wKx = new bes().bl(bki.toByteArray());
            } catch (Throwable e22) {
                x.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e22, "", new Object[0]);
            }
        } else if (i == 4) {
            if (bku == null || (bku.wUn == 0 && bku.wUq == 0)) {
                return x;
            }
            blj blj = new blj();
            blj.wUn = bku.wUn;
            try {
                x.wKx = new bes().bl(blj.toByteArray());
            } catch (Throwable e222) {
                x.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e222, "", new Object[0]);
            }
        } else if (i == 10) {
            bls bls = new bls();
            if (obj instanceof com.tencent.mm.bp.b) {
                com.tencent.mm.bp.b bVar = (com.tencent.mm.bp.b) obj;
                bls.wVF = n.N(bVar.oz);
                x.i("MicroMsg.NetSceneSnsObjectOp", "NetSceneSnsObjectOpticket " + bVar.oz.length);
            } else {
                x.e("MicroMsg.NetSceneSnsObjectOp", "error ticket");
            }
            try {
                byte[] toByteArray = bls.toByteArray();
                x.wKx = new bes().bl(toByteArray);
                x.i("MicroMsg.NetSceneSnsObjectOp", "opFree " + toByteArray.length);
            } catch (Throwable e2222) {
                x.e("MicroMsg.NetSceneSnsObjectOp", "error ticket " + e2222.getMessage());
                x.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e2222, "", new Object[0]);
            }
        } else if (i == 12) {
            if (obj instanceof ble) {
                ble ble = (ble) obj;
                try {
                    x.wKx = n.N(ble.toByteArray());
                    x.i("MicroMsg.NetSceneSnsObjectOp", "snsMetionBlockOp, switch:%d " + ble.wUM);
                } catch (Exception e3) {
                    x.e("MicroMsg.NetSceneSnsObjectOp", "error snsMetionBlockOp " + e3.getMessage());
                }
            } else {
                x.e("MicroMsg.NetSceneSnsObjectOp", "error snsMetionBlockOp");
            }
        }
        return x;
    }

    private static bli x(long j, int i) {
        bli bli = new bli();
        bli.wKx = new bes();
        bli.vWS = j;
        bli.nne = i;
        return bli;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return 218;
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneSnsObjectOp", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            m eS;
            blf blf;
            Iterator it;
            Object obj;
            switch (this.type) {
                case 1:
                    ae.bwe().eF(this.qZZ);
                    ae.bwf().delete(this.qZZ);
                    break;
                case 2:
                    eS = ae.bwf().eS(this.qZZ);
                    if (eS != null) {
                        eS.field_pravited = 1;
                        eS.byU();
                        ae.bwf().b(this.qZZ, eS);
                        break;
                    }
                    break;
                case 3:
                    eS = ae.bwf().eS(this.qZZ);
                    if (eS != null) {
                        eS.field_pravited = 0;
                        eS.field_localPrivate = 0;
                        eS.byX();
                        ae.bwf().b(this.qZZ, eS);
                        break;
                    }
                    break;
                case 4:
                    m eS2 = ae.bwf().eS(this.qZZ);
                    if (eS2 != null) {
                        try {
                            blf = (blf) new blf().aH(eS2.field_attrBuf);
                            it = blf.wUU.iterator();
                            while (it.hasNext()) {
                                obj = (bku) it.next();
                                if (this.raa != null && obj.wUn == this.raa.wUn) {
                                    if (obj != null) {
                                        blf.wUU.remove(obj);
                                    }
                                    eS2.aL(blf.toByteArray());
                                    ae.bwf().z(eS2);
                                    ae.bwk().d(eS2.field_snsId, (long) this.raa.wUn, this.raa.kzz);
                                    break;
                                }
                            }
                            obj = null;
                            if (obj != null) {
                                blf.wUU.remove(obj);
                            }
                            eS2.aL(blf.toByteArray());
                            ae.bwf().z(eS2);
                            ae.bwk().d(eS2.field_snsId, (long) this.raa.wUn, this.raa.kzz);
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e, "", new Object[0]);
                            break;
                        }
                    }
                    break;
                case 5:
                    ae.bwe().eH(this.qZZ);
                    break;
                case 6:
                    c eL = ae.bwi().eL(this.qZZ);
                    if (eL != null) {
                        try {
                            blf = (blf) new blf().aH(eL.field_attrBuf);
                            it = blf.wUU.iterator();
                            while (it.hasNext()) {
                                obj = (bku) it.next();
                                if (this.raa != null && obj.wUq == this.raa.wUq) {
                                    if (obj != null) {
                                        blf.wUU.remove(obj);
                                    }
                                    eL.aL(blf.toByteArray());
                                    ae.bwi().a(eL);
                                    ae.bwk().d(eL.field_snsId, this.raa.wUq, this.raa.kzz);
                                    break;
                                }
                            }
                            obj = null;
                            if (obj != null) {
                                blf.wUU.remove(obj);
                            }
                            eL.aL(blf.toByteArray());
                            ae.bwi().a(eL);
                            ae.bwk().d(eL.field_snsId, this.raa.wUq, this.raa.kzz);
                        } catch (Throwable e2) {
                            x.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e2, "", new Object[0]);
                            break;
                        }
                    }
                    break;
                case 7:
                    ae.bwe().eH(this.qZZ);
                    break;
                case 8:
                    if (!(this.rab != null && (this.rab instanceof com.tencent.mm.plugin.sns.storage.a.b.a) && ((com.tencent.mm.plugin.sns.storage.a.b.a) this.rab).rkw == com.tencent.mm.plugin.sns.storage.a.b.a.rks)) {
                        ae.bwi().delete(this.qZZ);
                        ae.bwk().eN(this.qZZ);
                        break;
                    }
                case 9:
                    eS = ae.bwf().eS(this.qZZ);
                    if (eS != null) {
                        eS.xE(2);
                        ae.bwf().b(this.qZZ, eS);
                        break;
                    }
                    break;
                case 11:
                    x.i("MicroMsg.NetSceneSnsObjectOp", "scene end switch " + this.rac);
                    if (this.rac == 0) {
                        g.Dr();
                        g.Dq().Db().a(w.a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYOPEN_BOOLEAN_SYNC, Boolean.valueOf(true));
                    } else if (this.rac == 1) {
                        g.Dr();
                        g.Dq().Db().a(w.a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYOPEN_BOOLEAN_SYNC, Boolean.valueOf(false));
                    }
                    g.Dr();
                    int intValue = ((Integer) g.Dq().Db().get(w.a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYCOUNT_INT_SYNC, Integer.valueOf(0))).intValue();
                    g.Dr();
                    g.Dq().Db().a(w.a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYCOUNT_INT_SYNC, Integer.valueOf(intValue + 1));
                    g.Dr();
                    intValue = ((Integer) g.Dq().Db().get(w.a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYCOUNT2_INT_SYNC, Integer.valueOf(0))).intValue();
                    int i4;
                    if (this.rac == 0) {
                        intValue++;
                        i4 = (intValue * 2) + bc.CTRL_INDEX;
                        if (i4 >= com.tencent.mm.plugin.appbrand.jsapi.media.f.CTRL_INDEX) {
                            i4 = com.tencent.mm.plugin.appbrand.jsapi.media.f.CTRL_INDEX;
                        }
                        if (i4 >= 200) {
                            com.tencent.mm.plugin.sns.lucky.a.b.qq(i4);
                        }
                        x.i("MicroMsg.NetSceneSnsObjectOp", "opcount open " + i4 + " " + intValue);
                    } else if (this.rac == 1) {
                        intValue++;
                        i4 = ((intValue * 2) + bc.CTRL_INDEX) + 1;
                        if (i4 >= com.tencent.mm.plugin.appbrand.jsapi.media.e.CTRL_INDEX) {
                            i4 = com.tencent.mm.plugin.appbrand.jsapi.media.e.CTRL_INDEX;
                        }
                        if (i4 >= 201) {
                            com.tencent.mm.plugin.sns.lucky.a.b.qq(i4);
                        }
                        x.i("MicroMsg.NetSceneSnsObjectOp", "opcount close " + i4 + " " + intValue);
                    }
                    g.Dr();
                    g.Dq().Db().a(w.a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYCOUNT2_INT_SYNC, Integer.valueOf(intValue));
                    break;
                case 12:
                    if (this.rab != null && (this.rab instanceof ble)) {
                        ae.bwk().q(this.qZZ, ((ble) this.rab).wUM == 1);
                        x.i("MicroMsg.NetSceneSnsObjectOp", "remind  update [snsId:%d] ->isSilence: %b", Long.valueOf(this.qZZ), Boolean.valueOf(r0));
                        break;
                    }
            }
            ae.bwe().bvG();
            this.gLE.a(i2, i3, str, this);
            return;
        }
        if (i2 == 4 && this.type == 1) {
            switch (this.type) {
                case 1:
                    ae.bwe().eF(this.qZZ);
                    break;
                case 5:
                case 7:
                    ae.bwe().eH(this.qZZ);
                    break;
            }
        }
        this.gLE.a(i2, i3, str, this);
    }
}
