package com.tencent.mm.booter;

import com.tencent.mm.f.a.mw;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ac;
import com.tencent.mm.y.ad;
import java.util.ArrayList;
import java.util.List;

public class a implements ac {
    private static volatile a gzs;
    private ar gzq = new ar();
    private com.tencent.mm.sdk.platformtools.ar.a gzr = new com.tencent.mm.sdk.platformtools.ar.a() {
        public final void fj(int i) {
            switch (i) {
                case 0:
                    x.v("MicroMsg.BackgroundPlayer", "call end");
                    a.this.wH();
                    return;
                case 1:
                case 2:
                    x.v("MicroMsg.BackgroundPlayer", "call start");
                    a.this.wI();
                    return;
                default:
                    return;
            }
        }
    };
    private List<ad> gzt = new ArrayList();
    private c gzu;

    private a() {
        this.gzq.a(this.gzr);
        this.gzq.eW(com.tencent.mm.sdk.platformtools.ad.getContext());
        if (this.gzu == null) {
            this.gzu = new c<mw>() {
                {
                    this.xmG = mw.class.getName().hashCode();
                }

                public final /* synthetic */ boolean a(b bVar) {
                    switch (((mw) bVar).fFN.state) {
                        case 0:
                            x.d("MicroMsg.BackgroundPlayer", "jacks record resume event");
                            a.this.wI();
                            break;
                        case 1:
                            x.d("MicroMsg.BackgroundPlayer", "jacks record pause event");
                            a.this.wH();
                            break;
                    }
                    return false;
                }
            };
        }
        com.tencent.mm.sdk.b.a.xmy.b(this.gzu);
    }

    public static a wG() {
        if (gzs == null) {
            synchronized (a.class) {
                if (gzs == null) {
                    gzs = new a();
                }
            }
        }
        return gzs;
    }

    public final void a(ad adVar) {
        if (adVar != null) {
            x.d("MicroMsg.BackgroundPlayer", "add callback : %s", adVar.toString());
            this.gzt.add(adVar);
        }
    }

    public final void b(ad adVar) {
        if (adVar != null) {
            this.gzt.remove(adVar);
        }
    }

    public final void wH() {
        if (this.gzt != null) {
            for (ad GU : this.gzt) {
                GU.GU();
            }
        }
    }

    public final void wI() {
        if (this.gzt != null) {
            for (ad GV : this.gzt) {
                GV.GV();
            }
        }
    }
}
