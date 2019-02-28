package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.f.a.rp;
import com.tencent.mm.f.a.rq;
import com.tencent.mm.f.a.rr;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingTranslateView.a;
import com.tencent.mm.y.as;
import java.util.HashMap;

public final class ac {
    public p fhH;
    at yLl = new at(5, "msg-translate-update-worker");
    public HashMap<Long, a> yLm = new HashMap();
    public c yLn = new c<rr>() {
        {
            this.xmG = rr.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            rr rrVar = (rr) bVar;
            if (rrVar instanceof rr) {
                final String str = rrVar.fKq.id;
                final int i = rrVar.fKq.ret;
                new ag().postDelayed(new Runnable() {
                    public final void run() {
                        if (i == 0) {
                            ac.this.a(bi.Wp(str), a.Translated);
                            ac acVar = ac.this;
                            acVar.yLl.c(new AnonymousClass2(bi.Wp(str)));
                            return;
                        }
                        if (i == 3) {
                            h.bu(ac.this.fhH.cte().getContext(), ac.this.fhH.cte().getMMString(R.l.dTy));
                        } else if (i != 5) {
                            h.bu(ac.this.fhH.cte().getContext(), ac.this.fhH.cte().getMMString(R.l.dTt));
                        }
                        ac.this.a(bi.Wp(str), a.NoTranslate);
                        ac.this.fhH.cpZ();
                    }
                }, (long) (i == 5 ? MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN : 0));
            }
            return false;
        }
    };

    /* renamed from: com.tencent.mm.ui.chatting.b.ac$1 */
    class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ au hgB;
        final /* synthetic */ MenuItem xRU;

        public AnonymousClass1(au auVar, MenuItem menuItem) {
            this.hgB = auVar;
            this.xRU = menuItem;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            ac acVar = ac.this;
            au auVar = this.hgB;
            this.xRU.getGroupId();
            acVar.aV(auVar);
            dialogInterface.dismiss();
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.b.ac$2 */
    class AnonymousClass2 implements at.a {
        final /* synthetic */ long lxx;

        AnonymousClass2(long j) {
            this.lxx = j;
        }

        public final boolean JI() {
            return false;
        }

        public final boolean JH() {
            as.Hm();
            au dI = com.tencent.mm.y.c.Fh().dI(this.lxx);
            dI.ckm();
            com.tencent.mm.modelstat.b.hRo.a(dI, true);
            as.Hm();
            com.tencent.mm.y.c.Fh().a(this.lxx, dI);
            return false;
        }
    }

    public ac(p pVar) {
        this.fhH = pVar;
    }

    public final void a(long j, a aVar) {
        this.yLm.put(Long.valueOf(j), aVar);
    }

    public final a aU(au auVar) {
        a aVar = (a) this.yLm.get(Long.valueOf(auVar.field_msgId));
        if (aVar != null) {
            return aVar;
        }
        if (!auVar.ckg()) {
            b rqVar = new rq();
            rqVar.fKn.id = auVar.field_msgId;
            com.tencent.mm.sdk.b.a.xmy.m(rqVar);
            if (!rqVar.fKo.fKp) {
                return a.NoTranslate;
            }
            aVar = a.Translating;
            a(auVar.field_msgId, aVar);
            return aVar;
        } else if (auVar.ckl()) {
            return a.Translated;
        } else {
            return a.NoTranslate;
        }
    }

    public final void aV(au auVar) {
        if (auVar.ckg()) {
            if (auVar.ckl()) {
                if (auVar.ckg()) {
                    auVar.fc(auVar.gkC & -17);
                }
                a(auVar.field_msgId, a.NoTranslate);
                com.tencent.mm.modelstat.b.hRo.a(auVar, false);
            } else {
                auVar.ckm();
                a(auVar.field_msgId, a.Translated);
                com.tencent.mm.modelstat.b.hRo.a(auVar, true);
            }
            as.Hm();
            com.tencent.mm.y.c.Fh().a(auVar.field_msgId, auVar);
        } else if (aU(auVar) != a.Translating) {
            b rpVar = new rp();
            rpVar.fKk.fKm = false;
            rpVar.fKk.id = auVar.field_msgId;
            rpVar.fKk.fKl = auVar.field_content;
            if (!this.fhH.csR() || auVar.field_isSend == 1) {
                rpVar.fKk.type = 0;
            } else {
                rpVar.fKk.type = 1;
            }
            rpVar.fKk.bhd = this.fhH.csW().field_username;
            com.tencent.mm.sdk.b.a.xmy.m(rpVar);
            a(auVar.field_msgId, a.Translating);
        } else {
            return;
        }
        this.fhH.cpZ();
    }
}
