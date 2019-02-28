package com.tencent.mm.plugin.wallet_core.c.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.awu;
import com.tencent.mm.protocal.c.awy;
import com.tencent.mm.protocal.c.axf;
import com.tencent.mm.protocal.c.axg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.l;
import java.util.ArrayList;
import java.util.Iterator;

public final class c extends l {
    private b gLB;
    private e gLE;
    public Orders sOZ;
    public int sPk = 0;

    public c(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        a aVar = new a();
        aVar.hnT = new axf();
        aVar.hnU = new axg();
        aVar.uri = "/cgi-bin/mmpay-bin/payibgjsgettransaction";
        aVar.hnS = 1565;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        axf axf = (axf) this.gLB.hnQ.hnY;
        axf.nlV = str;
        axf.wdl = str4;
        axf.wdk = str2;
        axf.wdm = str5;
        axf.wdn = str6;
        axf.vSO = str3;
        axf.wcy = str7;
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneIbgGetTransaction", "hy: get h5 transaction: errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        axg axg = (axg) ((b) qVar).hnR.hnY;
        if (i2 == 0 && i == 0) {
            i2 = axg.lUc;
            str = axg.lUd;
        }
        x.i("MicroMsg.NetSceneIbgGetTransaction", "resp.IsUseNewPage: %s", Integer.valueOf(axg.wLo));
        this.sPk = axg.wLo;
        this.sOZ = new Orders();
        this.sOZ.sOT = 1;
        if (axg == null || axg.wLl == null) {
            x.e("MicroMsg.NetSceneIbgGetTransaction", "hy: info not valid");
        } else {
            Iterator it;
            this.sOZ.pTQ = (double) axg.wLl.wLr;
            Commodity commodity = new Commodity();
            commodity.fvD = axg.wLl.pRd;
            commodity.desc = axg.wLl.hDV;
            commodity.loS = ((double) axg.wLl.wLr) / 100.0d;
            commodity.pfY = String.valueOf(axg.wLl.wLt);
            commodity.pfZ = axg.wLl.wLu;
            commodity.pgd = axg.wLl.wLq;
            commodity.pgb = axg.wLl.wLp;
            commodity.pgf = axg.wLl.pgf;
            commodity.pfU = axg.wLl.wLs;
            commodity.sUt = ((double) axg.wLl.wLv) / 100.0d;
            if (axg.wLm != null) {
                commodity.pgg = axg.wLm.vYJ;
                Promotions promotions = new Promotions();
                promotions.name = axg.wLm.wKX;
                promotions.pgg = axg.wLm.vYJ;
                commodity.sUu = axg.wLm.vYJ;
                promotions.pkG = axg.wLm.kPA;
                commodity.sTW = axg.wLm.wKV;
                if (!bi.oN(promotions.name)) {
                    commodity.sUB.add(promotions);
                }
                this.sOZ.sTW = axg.wLm.wKV;
            } else {
                x.i("MicroMsg.NetSceneIbgGetTransaction", "hy: no biz info");
                this.sOZ.sTW = 0;
            }
            if (axg.wLl.wLw != null && axg.wLl.wLw.size() > 0) {
                commodity.sUw = new ArrayList();
                it = axg.wLl.wLw.iterator();
                while (it.hasNext()) {
                    awy awy = (awy) it.next();
                    DiscountInfo discountInfo = new DiscountInfo();
                    discountInfo.pPL = awy.wKY;
                    commodity.sUw.add(discountInfo);
                }
            }
            if (axg.wLn != null && axg.wLn.size() > 0) {
                commodity.sUB = new ArrayList();
                it = axg.wLn.iterator();
                while (it.hasNext()) {
                    awu awu = (awu) it.next();
                    Promotions promotions2 = new Promotions();
                    promotions2.type = Orders.sUs;
                    promotions2.url = awu.url;
                    promotions2.name = awu.fzT;
                    promotions2.pkG = awu.fED;
                    promotions2.sTG = awu.taB;
                    promotions2.sUJ = bi.getInt(awu.type, 0);
                    promotions2.title = awu.title;
                    promotions2.sOB = awu.sUT;
                    promotions2.sUK = (int) awu.sUU;
                    promotions2.sUM = awu.sTH;
                    promotions2.sUL = (int) awu.sUV;
                    promotions2.sTD = awu.sUW;
                    promotions2.sTE = awu.sUX;
                    promotions2.sUN = awu.wKS;
                    promotions2.sUO = awu.wKT;
                    promotions2.sTF = awu.sUY;
                    promotions2.sUP = awu.wKU;
                    commodity.sUB.add(promotions2);
                }
            }
            this.sOZ.sUf = new ArrayList();
            this.sOZ.sUf.add(commodity);
            this.sOZ.sTY = axg.wLl.wLu;
            x.i("MicroMsg.NetSceneIbgGetTransaction", "formatOrders finish, mOrder.commoditys.size: %s, mOrder: %s", Integer.valueOf(this.sOZ.sUf.size()), this.sOZ);
        }
        if (bi.oN(str)) {
            str = ad.getContext().getString(i.uXI);
        }
        this.gLE.a(i, i2, str, this);
    }

    public final int getType() {
        return 1565;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
