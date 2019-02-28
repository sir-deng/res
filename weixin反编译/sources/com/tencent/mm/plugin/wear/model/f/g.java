package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.R;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.c.caa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.x.g.a;
import com.tencent.mm.y.s;
import java.io.IOException;

public final class g extends b {
    private au fFE;

    public g(au auVar) {
        this.fFE = auVar;
    }

    protected final void send() {
        caa caa = new caa();
        String str = this.fFE.field_content;
        if (str != null) {
            a I = a.I(str, this.fFE.field_reserved);
            if (I == null || !I.hes.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao")) {
                x.i("MicroMsg.Wear.WearLuckyCreateTask", "biz c2c message, do not send to watch!");
                return;
            }
            caa.xgC = this.fFE.field_msgId;
            caa.xgB = this.fFE.field_talker;
            str = this.fFE.field_isSend == 1 ? I.hem : I.hel;
            caa.fpg = h.Or(this.fFE.field_talker);
            if (s.eX(this.fFE.field_talker)) {
                String d = b.d(this.fFE.field_talker, this.fFE);
                caa.noL = String.format(ad.getContext().getString(R.l.ezd), new Object[]{h.Or(d), Character.valueOf(8203), str});
            } else {
                caa.noL = str;
            }
            try {
                com.tencent.mm.plugin.wear.model.a.bPh();
                r.a(20014, caa.toByteArray(), true);
                com.tencent.mm.plugin.wear.model.c.a.ei(10, 0);
                com.tencent.mm.plugin.wear.model.c.a.zS(10);
                return;
            } catch (IOException e) {
                return;
            }
        }
        x.w("MicroMsg.Wear.WearLuckyCreateTask", "xml is null!");
    }

    public final String getName() {
        return "WearLuckyCreateTask";
    }
}
