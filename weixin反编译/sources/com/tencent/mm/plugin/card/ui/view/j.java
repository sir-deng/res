package com.tencent.mm.plugin.card.ui.view;

import com.tencent.mm.plugin.card.b.c;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.pb.common.c.g;

public final class j extends g {
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
                return false;
            }
            x.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain   code  is diffrent！");
            return true;
        }
    }

    public final String e(c cVar) {
        return this.kOv.auj().code;
    }

    public final ab axI() {
        return new v(this, this.kgL);
    }

    public final ab axJ() {
        return new f(this, this.kgL);
    }

    public final ab axK() {
        return new t(this, this.kgL);
    }
}
