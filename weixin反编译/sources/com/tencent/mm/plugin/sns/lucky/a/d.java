package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.y.bt.a;
import java.util.Map;

public final class d implements a {
    public final void a(com.tencent.mm.ad.d.a aVar) {
        x.i("MicroMsg.NewYearSNSAmountLevelCtrl2016NotifyLsn", "receivemsg NewYearSNSAmountLevelCtrl2016NotifyLsn");
        b.qq(67);
        if (aVar == null || aVar.hoa == null) {
            x.e("MicroMsg.NewYearSNSAmountLevelCtrl2016NotifyLsn", "onPreAddMessage cmdAM is null");
            return;
        }
        e eVar = new e();
        Object a = n.a(aVar.hoa.vNO);
        eVar.ksI = new StringBuffer();
        Map y = bj.y(a, "sysmsg");
        eVar.level = 0;
        if (y == null) {
            x.i("MicroMsg.NewYearSnsAmountLevel", "errr for paser %s", a);
            b.qq(68);
        } else {
            eVar.level = bi.Wo((String) y.get(".sysmsg.NewYearSNSAmountLevelCtrl2016.Level"));
            x.i("MicroMsg.NewYearSnsAmountLevel", "get level %d", Integer.valueOf(eVar.level));
            if (eVar.level == 0) {
                b.qq(69);
            } else if (eVar.level == 1) {
                b.qq(70);
            } else if (eVar.level == 2) {
                b.qq(71);
            } else if (eVar.level == 3) {
                b.qq(72);
            } else if (eVar.level == 4) {
                b.qq(73);
            }
        }
        x.i("MicroMsg.NewYearSnsAmountLevel", "dump NewYearSnsAmountLevel " + eVar.ksI.toString());
        g.Dr();
        g.Dq().Db().a(w.a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_LEVELCTRL_STRING_SYNC, a);
        g.Dr();
        g.Dq().Db().lO(true);
    }
}
