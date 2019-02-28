package com.tencent.mm.plugin.translate;

import android.os.Looper;
import android.util.SparseArray;
import com.tencent.mm.ad.e;
import com.tencent.mm.bx.h.d;
import com.tencent.mm.f.a.rp;
import com.tencent.mm.f.a.rq;
import com.tencent.mm.f.a.rr;
import com.tencent.mm.plugin.translate.a.c;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.as;
import java.util.HashMap;
import java.util.LinkedList;

public final class a implements ap {
    ag handler = new ag(Looper.getMainLooper());
    c slX = b.sml;
    at slY = new at(5, "ProcessTranslatedMessage", 1, Looper.getMainLooper());
    private com.tencent.mm.plugin.translate.a.c.a slZ = new com.tencent.mm.plugin.translate.a.c.a() {
        public final void a(final int i, SparseArray<c.c> sparseArray) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < sparseArray.size()) {
                    final c.c cVar = (c.c) sparseArray.valueAt(i3);
                    if (cVar != null) {
                        a.this.slY.c(new com.tencent.mm.sdk.platformtools.at.a() {
                            public final boolean JI() {
                                int i = i != 0 ? i : cVar.ret;
                                b rrVar = new rr();
                                rrVar.fKq.ret = i;
                                rrVar.fKq.fKl = cVar.fKl;
                                rrVar.fKq.id = cVar.id;
                                rrVar.fKq.fKr = cVar.fKr;
                                rrVar.fKq.type = cVar.type;
                                rrVar.fKq.bhd = cVar.bhd;
                                rrVar.fKq.fIQ = cVar.fIQ;
                                com.tencent.mm.sdk.b.a.xmy.m(rrVar);
                                return false;
                            }

                            public final boolean JH() {
                                x.d("MicroMsg.SubCoreTranslate", "finish translated, id: %s", cVar.id);
                                if (i != 0) {
                                    x.e("MicroMsg.SubCoreTranslate", "translate error");
                                } else if (cVar.ret != 0) {
                                    x.e("MicroMsg.SubCoreTranslate", "translate ret not ok : %s", Integer.valueOf(cVar.ret));
                                } else if (bi.oN(cVar.fKr)) {
                                    x.e("MicroMsg.SubCoreTranslate", "translate return null");
                                } else if (cVar.type == 0 || cVar.type == 1) {
                                    x.d("MicroMsg.SubCoreTranslate", "we recieved one translated message");
                                    String str = cVar.id;
                                    String str2 = cVar.bhd;
                                    String str3 = cVar.fKr;
                                    String str4 = cVar.fIQ;
                                    as.Hm();
                                    com.tencent.mm.y.c.Fh().a(bi.Wp(str), str2, str3, str4);
                                }
                                return true;
                            }
                        });
                    }
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    };
    private com.tencent.mm.sdk.b.c sma = new com.tencent.mm.sdk.b.c<rp>() {
        {
            this.xmG = rp.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            final rp rpVar = (rp) bVar;
            x.d("MicroMsg.SubCoreTranslate", "recieve one translate request");
            a.this.handler.post(new Runnable() {
                public final void run() {
                    c cVar = a.this.slX;
                    String str = rpVar.fKk.fKl;
                    String str2 = rpVar.fKk.id;
                    int i = rpVar.fKk.type;
                    String str3 = rpVar.fKk.bhd;
                    boolean z = rpVar.fKk.fKm;
                    x.d("MicroMsg.TranslateServiceManager", "doTranslate msgId : %s, type: %d", str2, Integer.valueOf(i));
                    if (cVar.Nc(str2)) {
                        x.d("MicroMsg.TranslateServiceManager", "doTranslate msgId %s is inQueue", str2);
                        return;
                    }
                    c.c cVar2 = new c.c(str, str2, i, str3);
                    if (z) {
                        ((LinkedList) cVar.smj).add(0, cVar2);
                    } else {
                        cVar.smj.add(cVar2);
                    }
                    cVar.smk.put(cVar2.id, Integer.valueOf(cVar2.smm));
                    x.d("MicroMsg.TranslateServiceManager", "requestCount : %s", Integer.valueOf(cVar.kOD));
                    cVar.bGk();
                }
            });
            return true;
        }
    };
    private com.tencent.mm.sdk.b.c smb = new com.tencent.mm.sdk.b.c<rq>() {
        {
            this.xmG = rq.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            rq rqVar = (rq) bVar;
            rqVar.fKo.fKp = a.this.slX.Nc(rqVar.fKn.id);
            return true;
        }
    };

    public final HashMap<Integer, d> Bu() {
        return null;
    }

    public final void ge(int i) {
    }

    public final void bs(boolean z) {
        c cVar = this.slX;
        com.tencent.mm.plugin.translate.a.c.a aVar = this.slZ;
        if (!(aVar == null || cVar.gNg.contains(aVar))) {
            cVar.gNg.add(aVar);
        }
        com.tencent.mm.sdk.b.a.xmy.b(this.sma);
        com.tencent.mm.sdk.b.a.xmy.b(this.smb);
    }

    public final void bt(boolean z) {
    }

    public final void onAccountRelease() {
        com.tencent.mm.sdk.b.a.xmy.c(this.sma);
        com.tencent.mm.sdk.b.a.xmy.c(this.smb);
        c cVar = this.slX;
        com.tencent.mm.plugin.translate.a.c.a aVar = this.slZ;
        if (aVar != null && cVar.gNg.contains(aVar)) {
            cVar.gNg.remove(aVar);
        }
        c cVar2 = this.slX;
        if (cVar2.smi != null) {
            for (e eVar : cVar2.smi) {
                if (eVar != null) {
                    as.CN().b(631, eVar);
                    if (eVar.smr != null) {
                        eVar.smt.TN();
                        as.CN().c(eVar.smr);
                    }
                    eVar.bGl();
                    eVar.smp = null;
                }
            }
        }
        cVar2.smk.clear();
        cVar2.smj.clear();
        cVar2.gNg.clear();
        cVar2.kOD = 0;
    }
}
