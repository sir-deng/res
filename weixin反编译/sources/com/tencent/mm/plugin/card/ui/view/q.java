package com.tencent.mm.plugin.card.ui.view;

import com.tencent.mm.plugin.card.b.c;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.c.oy;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.pb.common.c.g;

public final class q extends g {
    public String laS = "";

    public final boolean h(b bVar) {
        if (this.kOv == null) {
            x.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain mCardInfo is null！");
            return true;
        } else if (bVar == null) {
            x.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain false  newCardInfo null！");
            return false;
        } else {
            String str = this.kOv.auj().code;
            String str2 = bVar.auj().code;
            if (g.Bf(str) || g.Bf(str2) || str.equals(str2)) {
                oy oyVar = this.kOv.aui().vZq;
                oy oyVar2 = bVar.aui().vZq;
                if ((oyVar == null && oyVar2 != null) || (oyVar != null && oyVar2 == null)) {
                    x.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field  is diffrent！");
                    return true;
                } else if (oyVar != null && oyVar2 != null && oyVar.title != null && oyVar2.title != null && !oyVar.title.equals(oyVar2.title)) {
                    x.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field title is diffrent！");
                    return true;
                } else if (oyVar != null && oyVar2 != null && oyVar.kPC != null && oyVar2.kPC != null && !oyVar.kPC.equals(oyVar2.kPC)) {
                    x.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field aux_title  is diffrent！");
                    return true;
                } else if (!this.kOv.auc() || g.isNullOrEmpty(this.laS)) {
                    return false;
                } else {
                    x.i("MicroMsg.CardCodeView", "dynamicCode updated！");
                    return true;
                }
            }
            x.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain   code  is diffrent！");
            return true;
        }
    }

    public final String e(c cVar) {
        if (!g.isNullOrEmpty(this.kOv.auj().vYv)) {
            return this.kOv.auj().vYv;
        }
        if (!this.kOv.auc() || g.isNullOrEmpty(this.laS)) {
            return this.kOv.auj().code;
        }
        return this.laS;
    }

    public final ab axI() {
        return new s(this, this.kgL);
    }

    public final ab axJ() {
        return new p(this, this.kgL);
    }

    public final ab axK() {
        return new r(this, this.kgL);
    }
}
