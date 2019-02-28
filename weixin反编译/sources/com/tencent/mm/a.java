package com.tencent.mm;

import android.content.Context;
import com.tencent.mm.api.j;
import com.tencent.mm.api.k;
import com.tencent.mm.api.m;
import com.tencent.mm.api.m.b;
import com.tencent.mm.api.m.c;
import com.tencent.mm.cache.ArtistCacheManager;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;

public final class a extends m {
    private com.tencent.mm.view.a bpM;
    private k bpN;

    public static class a implements b {
        public final m sV() {
            return new a();
        }
    }

    public final com.tencent.mm.api.b ai(Context context) {
        if (this.bpM == null) {
            if (this.fdS.fdU == c.fdZ) {
                this.bpM = new com.tencent.mm.view.c(context, this.fdS);
            } else if (this.fdS.fdU == c.fea) {
                this.bpM = new com.tencent.mm.view.b(context, this.fdS);
            }
        }
        return this.bpM;
    }

    public final void a(j jVar) {
        this.bpM.cBc().a(jVar, !sU().tg());
    }

    public final boolean sT() {
        return this.bpM.cBc().sT();
    }

    public final void a(com.tencent.mm.api.m.a aVar) {
        super.a(aVar);
        ArtistCacheManager xB = ArtistCacheManager.xB();
        String aD = bi.aD(this.fdS.path, "MicroMsg.MMPhotoEditorImpl");
        xB.gCY = aD;
        if (!ArtistCacheManager.gCW.containsKey(aD)) {
            ArtistCacheManager.gCW.put(aD, new a());
        }
    }

    public final void onDestroy() {
        if (!this.fdS.fdV) {
            ArtistCacheManager xB = ArtistCacheManager.xB();
            String aD = bi.aD(this.fdS.path, "MicroMsg.MMPhotoEditorImpl");
            xB.gCY = null;
            if (ArtistCacheManager.gCW.containsKey(aD)) {
                ((a) ArtistCacheManager.gCW.get(aD)).clearAll();
                ArtistCacheManager.gCW.remove(aD);
            }
            e.chE();
            e.post(new Runnable() {
                public final void run() {
                    com.tencent.mm.cb.a.aaW(com.tencent.mm.compatible.util.e.gJe);
                }
            }, "MicroMsg.ArtistCacheManager[clearAllCache]");
        }
        if (this.bpM != null) {
            this.bpM.cBc().onDestroy();
        }
    }

    public final k sU() {
        if (this.bpN == null) {
            this.bpN = new com.tencent.mm.bs.a(this.bpM.cBc());
        }
        return this.bpN;
    }
}
