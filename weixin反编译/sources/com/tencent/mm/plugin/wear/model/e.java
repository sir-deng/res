package com.tencent.mm.plugin.wear.model;

import android.app.KeyguardManager;
import android.os.Looper;
import android.os.PowerManager;
import com.tencent.mm.f.a.ke;
import com.tencent.mm.f.a.kl;
import com.tencent.mm.f.a.l;
import com.tencent.mm.f.a.ld;
import com.tencent.mm.f.a.ob;
import com.tencent.mm.f.a.ou;
import com.tencent.mm.f.a.sr;
import com.tencent.mm.f.a.tl;
import com.tencent.mm.f.a.to;
import com.tencent.mm.f.b.ak;
import com.tencent.mm.j.g;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.f.f;
import com.tencent.mm.plugin.wear.model.f.h;
import com.tencent.mm.plugin.wear.model.f.i;
import com.tencent.mm.plugin.wear.model.f.j;
import com.tencent.mm.plugin.wear.model.f.k;
import com.tencent.mm.protocal.c.bvy;
import com.tencent.mm.protocal.c.bzy;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.as;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public final class e {
    c gBo = new c<ob>() {
        {
            this.xmG = ob.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ob obVar = (ob) bVar;
            if (e.a(e.this)) {
                as.Hm();
                ak XF = com.tencent.mm.y.c.Fk().XF(obVar.fGN.fFE.field_talker);
                if (XF != null) {
                    int i = XF.field_unReadCount;
                    f Om = a.bPh().tom.Om(obVar.fGN.fFE.field_talker);
                    if (i - Om.toV > 0) {
                        e.n(obVar.fGN.fFE.field_talker, i, false);
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(Integer.valueOf(Om.id));
                        a.bPh().tor.a(new i(arrayList));
                    }
                }
            }
            return false;
        }
    };
    al ind = new al(Looper.getMainLooper(), new a() {
        public final boolean uG() {
            a.bPh().tor.a(new com.tencent.mm.plugin.wear.model.f.a());
            return true;
        }
    }, true);
    com.tencent.mm.plugin.messenger.foundation.a.a.c.a mfj = new com.tencent.mm.plugin.messenger.foundation.a.a.c.a() {
        public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.c cVar, com.tencent.mm.plugin.messenger.foundation.a.a.c.c cVar2) {
            if (cVar2 != null && cVar2.ouD > 0 && a.bPh().tok.toD.tpt.equals(cVar2.talker)) {
                a.bPh().tor.a(new com.tencent.mm.plugin.wear.model.f.c() {
                    protected final void send() {
                        try {
                            a.bPh();
                            r.a(20007, a.bPh().tok.toD.tpt.getBytes("utf8"), false);
                        } catch (UnsupportedEncodingException e) {
                        }
                    }

                    public final String getName() {
                        return "SendMsgSyncTask";
                    }
                });
            }
        }
    };
    c ojq = new c<tl>() {
        {
            this.xmG = tl.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            tl tlVar = (tl) bVar;
            switch (tlVar.fMJ.action) {
                case 2:
                    a.bPh().tor.a(new h(tlVar.fMK.fqB, tlVar.fMK.fMM, tlVar.fMK.fMN, tlVar.fMK.fMO));
                    break;
                case 4:
                    if (g.Af().getInt("WearPayBlock", 0) == 0) {
                        a.bPh().tor.a(new k(tlVar.fMJ.fML, tlVar.fMJ.content));
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    c rOm = new c<ke>() {
        {
            this.xmG = ke.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ke keVar = (ke) bVar;
            if (e.a(e.this) && !"gh_3dfda90e39d6".equals(keVar.fCq.talker)) {
                as.Hm();
                au Fd = com.tencent.mm.y.c.Fh().Fd(keVar.fCq.talker);
                boolean z = Fd != null ? g.Af().getInt("WearLuckyBlock", 0) == 0 && (Fd.cjM() || Fd.cjN()) : false;
                if (z) {
                    a.bPh().tor.a(new com.tencent.mm.plugin.wear.model.f.g(Fd));
                    if (keVar.fCq.fof > 1) {
                        e.n(keVar.fCq.talker, keVar.fCq.fof, false);
                    }
                } else {
                    e.n(keVar.fCq.talker, keVar.fCq.fof, true);
                }
            }
            return false;
        }
    };
    private PowerManager toF;
    private KeyguardManager toG;
    c toH = new c<l>() {
        {
            this.xmG = l.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (((l) bVar).foa.fob) {
                a.bPh().tor.a(new i());
            }
            return false;
        }
    };
    c toI = new c<ld>() {
        {
            this.xmG = ld.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            final ld ldVar = (ld) bVar;
            com.tencent.mm.blink.b.wv().f(new Runnable() {
                public final void run() {
                    a.bPh().tom.On(ldVar.fDo.talker);
                    f Om = a.bPh().tom.Om(ldVar.fDo.talker);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Integer.valueOf(Om.id));
                    a.bPh().tor.a(new i(arrayList));
                    if (ldVar.fDo.talker.equals("gh_43f2581f6fd6")) {
                        bzy bzy = a.bPh().tok.toC.tps;
                        if (bzy != null) {
                            Object obj = (bzy != null && a.bPh().ton.tov && b.Ol(bzy.xgu)) ? 1 : null;
                            if (obj != null) {
                                a.bPh();
                                b.a(bzy);
                                return;
                            }
                            a.bPh().ton.connect();
                        }
                    }
                }
            });
            return false;
        }
    };
    c toJ = new c<sr>() {
        {
            this.xmG = sr.class.getName().hashCode();
        }

        private static boolean a(sr srVar) {
            switch (srVar.fLl.fvG) {
                case 3:
                    Object obj = srVar.fLl.fLf;
                    if (obj != null && obj.length >= 10 && obj[0] == (byte) 1) {
                        bvy bvy;
                        Object obj2 = new byte[(obj.length - 1)];
                        System.arraycopy(obj, 1, obj2, 0, obj2.length);
                        try {
                            bvy = (bvy) new bvy().aH(obj2);
                        } catch (IOException e) {
                            bvy = null;
                        }
                        if (bvy != null) {
                            String str = bvy.xdp;
                            int i = bvy.xdh;
                            x.i("MicroMsg.Wear.WearLogic", "voip invite talker=%s | type=%s", str, Integer.valueOf(i));
                            a.bPh().tor.a(new com.tencent.mm.plugin.wear.model.f.l(20010, str));
                            break;
                        }
                    }
                    break;
            }
            return false;
        }
    };
    c toK = new c<to>() {
        {
            this.xmG = to.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            switch (((to) bVar).fMW.fql) {
                case 5:
                    a.bPh().tor.a(new com.tencent.mm.plugin.wear.model.f.l(20011, ""));
                    break;
                case 6:
                case 7:
                    a.bPh().tor.a(new com.tencent.mm.plugin.wear.model.f.l(20012, ""));
                    break;
            }
            return false;
        }
    };
    c toL = new c<kl>() {
        {
            this.xmG = kl.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            kl klVar = (kl) bVar;
            if (e.a(e.this)) {
                a.bPh().tor.a(new f(klVar.fCD.userName, klVar.fCD.bgo, klVar.fCD.type));
            }
            return false;
        }
    };
    c toM = new c<ou>() {
        {
            this.xmG = ou.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (e.a(e.this)) {
                a.bPh().tor.a(new com.tencent.mm.plugin.wear.model.f.e());
            }
            return false;
        }
    };

    static /* synthetic */ boolean a(e eVar) {
        return eVar.toG.inKeyguardRestrictedInputMode() || !eVar.toF.isScreenOn();
    }

    public e() {
        x.i("MicroMsg.Wear.WearLogic", "Create!");
        this.rOm.cfB();
        this.toH.cfB();
        this.toI.cfB();
        this.toJ.cfB();
        this.toK.cfB();
        this.toL.cfB();
        this.toM.cfB();
        this.gBo.cfB();
        this.ojq.cfB();
        this.ind.K(1800000, 1800000);
        this.toF = (PowerManager) ad.getContext().getSystemService("power");
        this.toG = (KeyguardManager) ad.getContext().getSystemService("keyguard");
        as.Hm();
        com.tencent.mm.y.c.Fh().a(this.mfj, null);
    }

    public static void n(String str, int i, boolean z) {
        a.bPh().tor.a(new j(str, i, z));
    }
}
