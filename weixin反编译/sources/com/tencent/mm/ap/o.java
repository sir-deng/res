package com.tencent.mm.ap;

import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.mm.a.e;
import com.tencent.mm.a.f;
import com.tencent.mm.ap.a.a;
import com.tencent.mm.ap.i.AnonymousClass6;
import com.tencent.mm.bx.h.d;
import com.tencent.mm.f.a.os;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.SFSContext;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.p;
import java.util.HashMap;

public class o implements ap {
    private static HashMap<Integer, d> gyG;
    private g hEi;
    private i hEj;
    private c hEk;
    private j hEl = new j();
    private d hEm = null;
    private h hEn = new h();
    private b hEo = null;
    private p hEp = null;
    private c hEq = new c<os>() {
        {
            this.xmG = os.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            cg cgVar = ((os) bVar).fHC.fou;
            i PA = o.PA();
            e bj = o.PC().bj(cgVar.field_msgId);
            bj.hM(0);
            o.PC().a(Long.valueOf(bj.hBA), bj);
            int i = bj.Pk() ? 1 : 0;
            String m = o.PC().m(bj.hBB, "", "");
            if (m == null || m.equals("") || !e.bO(m)) {
                x.e("MicroMsg.ImgService", "sendMsgImage: filePath is null or empty");
            } else {
                ah.y(new AnonymousClass6(bj, i));
            }
            return false;
        }
    };
    private a hEr = null;
    private SFSContext hEs = null;
    private SFSContext hEt = null;

    private static synchronized o Pz() {
        o oVar;
        synchronized (o.class) {
            oVar = (o) p.s(o.class);
        }
        return oVar;
    }

    public static i PA() {
        if (Pz().hEj == null) {
            Pz().hEj = new i();
        }
        return Pz().hEj;
    }

    public static c PB() {
        g.Do().CA();
        if (Pz().hEk == null) {
            Pz().hEk = new c();
        }
        return Pz().hEk;
    }

    public static g PC() {
        g.Do().CA();
        if (Pz().hEi == null) {
            Pz().hEi = new g(g.Dq().gRU);
        }
        return Pz().hEi;
    }

    public static d PD() {
        g.Do().CA();
        if (Pz().hEm == null) {
            Pz().hEm = new d();
        }
        return Pz().hEm;
    }

    public static b PE() {
        g.Do().CA();
        if (Pz().hEo == null) {
            Pz().hEo = new b(Looper.getMainLooper());
        }
        return Pz().hEo;
    }

    public static p PF() {
        g.Do().CA();
        if (Pz().hEp == null) {
            Pz().hEp = new p();
        }
        return Pz().hEp;
    }

    public static a PG() {
        g.Do().CA();
        if (Pz().hEr == null) {
            Pz().hEr = a.PN();
        }
        return Pz().hEr;
    }

    public static SFSContext PH() {
        return null;
    }

    public final void onAccountRelease() {
        o Pz = Pz();
        if (Pz.hEj != null) {
            com.tencent.mm.ad.e eVar = Pz.hEj;
            eVar.fmn = 0;
            g.Dp().gRu.b(110, eVar);
        }
        if (Pz.hEo != null) {
            d.a aVar = Pz.hEo;
            synchronized (aVar.hAW) {
                aVar.hAW.clear();
                aVar.hAX = 0;
                PD().a(aVar);
            }
            com.tencent.mm.sdk.b.a.xmy.c(aVar.hBi);
            com.tencent.mm.sdk.b.a.xmy.c(aVar.hBj);
        }
        if (Pz.hEm != null) {
            com.tencent.mm.ad.e eVar2 = Pz.hEm;
            x.i("ModelImage.DownloadImgService", "on detach");
            x.i("ModelImage.DownloadImgService", "cancel all net scene");
            eVar2.hBs = true;
            eVar2.b(eVar2.hBq);
            while (eVar2.hBo.size() > 0) {
                eVar2.b((b) eVar2.hBo.get(0));
            }
            eVar2.Pi();
            g.Dp().gRu.b(109, eVar2);
        }
        if (Pz.hEp != null) {
            p pVar = Pz.hEp;
            x.i("MicroMsg.UrlImageCacheService", "detach");
            pVar.hEv.clear();
            pVar.hEx = true;
        }
        PI();
        com.tencent.mm.ad.d.c.b(Integer.valueOf(3), this.hEn);
        com.tencent.mm.ad.d.c.b(Integer.valueOf(23), this.hEn);
        com.tencent.mm.cache.e.a.a("local_cdn_img_cache", null);
        com.tencent.mm.sdk.b.a.xmy.c(this.hEq);
        if (Pz.hEr != null) {
            Pz.hEr.detach();
            Pz.hEr = null;
        }
        if (Pz.hEs != null) {
            Pz.hEs.release();
            Pz.hEs = null;
        }
        if (Pz.hEt != null) {
            Pz.hEt.release();
            Pz.hEt = null;
        }
    }

    public static void PI() {
        g gVar = Pz().hEi;
        if (gVar != null) {
            x.i("MicroMsg.ImgInfoStorage", "clearCacheMap stack:%s", bi.chl());
            gVar.hCh.a(new f.a<String, Bitmap>() {
            });
        }
        a aVar = Pz().hEr;
        if (aVar != null) {
            aVar.detach();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        gyG = hashMap;
        hashMap.put(Integer.valueOf("IMGINFO_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return g.gLy;
            }
        });
    }

    public final HashMap<Integer, d> Bu() {
        return gyG;
    }

    public final void ge(int i) {
    }

    public final void bs(boolean z) {
        com.tencent.mm.ad.d.c.a(Integer.valueOf(3), this.hEn);
        com.tencent.mm.ad.d.c.a(Integer.valueOf(23), this.hEn);
        com.tencent.mm.cache.e.a.a("local_cdn_img_cache", this.hEl);
        com.tencent.mm.sdk.b.a.xmy.b(this.hEq);
    }

    public final void bt(boolean z) {
    }
}
