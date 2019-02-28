package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.f.a.it;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;

public final class q {
    public p fhH;
    public String kBn = null;
    public f yJd;
    boolean yJe = false;
    public Runnable yJf = new Runnable() {
        public final void run() {
            q.this.yJd.cui();
        }
    };
    public Runnable yJg = new Runnable() {
        public final void run() {
            q.this.fhH.ctu();
            q.this.fhH.ctp().vwT = false;
            q.this.fhH.ctp().vwZ = false;
            q.this.fhH.ctp().ccb();
            ChatFooter ctp = q.this.fhH.ctp();
            if (ctp.vwJ != null) {
                ctp.vwJ.setVisibility(0);
            }
            ctp = q.this.fhH.ctp();
            if (ctp.vwG != null) {
                ctp.vwG.setVisibility(0);
            }
        }
    };
    public c yJh = new c<it>() {
        {
            this.xmG = it.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            it itVar = (it) bVar;
            if ((itVar instanceof it) && q.this.fhH.csZ() && (itVar.fAc.fAd == null || itVar.fAc.fAd.equals(q.this.fhH.vZ()))) {
                if (itVar.fAc.type == 1) {
                    ah.y(q.this.yJf);
                } else if (itVar.fAc.type == 2) {
                    q.this.fhH.mP(false);
                    ah.y(q.this.yJg);
                }
            }
            return false;
        }
    };

    public q(p pVar) {
        this.fhH = pVar;
    }
}
