package com.tencent.mm.plugin.shake.b;

import android.content.Context;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateBackgroundAudio;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.List;

public final class c extends b implements e {
    private Context context;
    float gAh = -85.0f;
    float gAi = -1000.0f;
    private a gAn = new a() {
        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            com.tencent.mm.modelstat.e.SZ().a(2002, i != 0, c.this.hry == null ? false : c.this.hry.hzA, f, f2, (int) d2);
            x.i("MicroMsg.ShakeFriendService", "getlocaion lat %f lng %f hasGetLbsInfo " + c.this.qey, Float.valueOf(f2), Float.valueOf(f));
            if (!z) {
                return true;
            }
            if (c.this.qtF && c.this.gAh == -85.0f && c.this.gAi == -1000.0f) {
                c.this.qtF = false;
                c.this.gAh = f2;
                c.this.gAi = f;
                c.this.qev = (int) d2;
                c.this.qeu = i;
                c.this.qey = true;
            }
            return false;
        }
    };
    com.tencent.mm.modelgeo.c hry;
    int qeu = 1;
    int qev = DownloadResult.CODE_UNDEFINED;
    boolean qey = false;
    boolean qtF = true;
    b qtG;
    a qtH;
    private int qtI = 0;
    ag qtJ = new ag();
    Runnable qtK = new Runnable() {
        public final void run() {
            if (!(c.this.qtJ == null || c.this.qtK == null)) {
                c.this.qtJ.removeCallbacks(c.this.qtK);
            }
            if (c.this.qtH != null) {
                as.CN().c(c.this.qtH);
            }
            if (!(c.this.qtG == null || c.this.qtG.fLf == null)) {
                c.this.qtH = new a(c.this.qtG.fLf);
            }
            if (c.this.qtH != null) {
                as.CN().a(c.this.qtH, 0);
            }
        }
    };

    public c(Context context, l.a aVar) {
        super(aVar);
        this.context = context;
    }

    public final void init() {
        as.CN().a((int) JsApiOperateBackgroundAudio.CTRL_INDEX, (e) this);
        as.CN().a(162, (e) this);
        as.CN().a(1251, (e) this);
        brY();
    }

    public final void start() {
        reset();
        init();
        this.qtG = new b(this.gAi, this.gAh, this.qev, this.qeu, "", "");
        as.CN().a(this.qtG, 0);
        if (!this.qey) {
            if (this.hry == null) {
                brY();
            }
            this.hry.b(this.gAn, true);
        }
        if (this.qtI <= 0) {
            this.qtI++;
        } else if (this.qtI <= 0 || this.qtI > 10) {
            this.qtI = 0;
        } else {
            this.qtI++;
            return;
        }
        x.i("MicroMsg.ShakeFriendService", "do doGetLbsCard");
        as.CN().a(new com.tencent.mm.plugin.shake.c.a.b(this.gAi, this.gAh), 0);
    }

    private void brY() {
        this.hry = com.tencent.mm.modelgeo.c.OV();
        this.qtF = true;
        this.hry.a(this.gAn, true);
    }

    public final void reset() {
        if (this.qtG != null) {
            as.CN().c(this.qtG);
        }
        if (this.qtH != null) {
            as.CN().c(this.qtH);
        }
        if (this.qtJ != null && this.qtK != null) {
            this.qtJ.removeCallbacks(this.qtK);
        }
    }

    public final void pause() {
        if (this.hry != null) {
            this.hry.c(this.gAn);
        }
    }

    public final void resume() {
        if (this.hry != null) {
            this.hry.a(this.gAn, true);
        }
    }

    public final void brZ() {
        super.brZ();
        as.CN().b((int) JsApiOperateBackgroundAudio.CTRL_INDEX, (e) this);
        as.CN().b(162, (e) this);
        as.CN().b(1251, (e) this);
        if (this.hry != null) {
            this.hry.c(this.gAn);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        switch (kVar.getType()) {
            case JsApiOperateBackgroundAudio.CTRL_INDEX /*161*/:
                b bVar = (b) kVar;
                if (bVar.brX() == 3 || bVar.brX() == 4) {
                    x.v("MicroMsg.ShakeFriendService", "onSceneEnd ignore location report response");
                    return;
                } else if (i2 == 0 && i == 0 && bVar.ret == 0) {
                    this.qtJ.postDelayed(this.qtK, 3000);
                    return;
                } else {
                    x.e("MicroMsg.ShakeFriendService", "onSceneEnd reprot failed");
                    this.qtT.d(null, 3);
                    return;
                }
            case 162:
                a aVar = (a) kVar;
                if (i2 == 0 && i == 0 && aVar.ret == 0) {
                    List list = aVar.qtD;
                    if (list.size() == 0) {
                        x.i("MicroMsg.ShakeFriendService", "empty shake get list");
                        this.qtT.d(null, 3);
                        return;
                    }
                    this.qtT.d(list, 1);
                    return;
                }
                this.qtT.d(null, 3);
                return;
            case 1251:
                com.tencent.mm.plugin.shake.c.a.b bVar2 = (com.tencent.mm.plugin.shake.c.a.b) kVar;
                if (i2 == 0 && i == 0) {
                    if (this.qtT != null) {
                        this.qtT.a(1251, bVar2.qun, 1);
                        return;
                    }
                    return;
                } else if (this.qtT != null) {
                    this.qtT.a(1251, null, 2);
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }
}
