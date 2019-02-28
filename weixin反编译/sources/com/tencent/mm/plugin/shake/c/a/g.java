package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.shake.b.l;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;

public final class g extends b implements e {
    private static int quo = 0;
    private float gAh = -85.0f;
    private float gAi = -1000.0f;
    private a gAn = new a() {
        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            if (!z) {
                return true;
            }
            if (g.this.gAh == -85.0f && g.this.gAi == -1000.0f) {
                g.this.gAh = f2;
                g.this.gAi = f;
                m.bss().gAh = g.this.gAh;
                m.bss().gAi = g.this.gAi;
                if (g.this.quL) {
                    x.i("MicroMsg.ShakeCardService", "ShakeCardService do netscen from onGetLocation()");
                    g.this.bsw();
                }
            }
            return false;
        }
    };
    private c hry;
    public String jfO = "";
    public int kKY = 0;
    public int kRj;
    private ag mHandler = new ag();
    private boolean njJ = false;
    private c quJ;
    private e quK = new e();
    private boolean quL = false;
    private long qup = 0;

    public g(l.a aVar) {
        super(aVar);
    }

    public final void init() {
        quo = m.bss().quo;
        this.qup = m.bss().qup;
        this.gAh = m.bss().gAh;
        this.gAi = m.bss().gAi;
        as.CN().a(1250, (e) this);
        brY();
    }

    public final void reset() {
        if (this.quJ != null) {
            as.CN().c(this.quJ);
        }
    }

    public final void start() {
        init();
        reset();
        if (this.hry == null) {
            brY();
        }
        this.hry.b(this.gAn, true);
        d bss = m.bss();
        CharSequence charSequence = "key_shake_card_item";
        Object obj = (TextUtils.isEmpty(charSequence) || !bss.kOy.containsKey(charSequence)) ? null : bss.kOy.get(charSequence);
        long currentTimeMillis = (System.currentTimeMillis() / 1000) - this.qup;
        if (obj == null || !(obj instanceof e)) {
            boolean z;
            if (this.qup == 0) {
                z = true;
            } else if (currentTimeMillis >= 0) {
                z = true;
            } else {
                com.tencent.mm.plugin.report.service.g.pWK.h(11666, Integer.valueOf(this.kKY));
                this.mHandler.postDelayed(new Runnable() {
                    public final void run() {
                        g.this.quK.kRj = 3;
                        g.this.kRj = g.this.quK.kRj;
                        g.this.quK.quv = m.bss().quq;
                        if (g.this.qtT != null) {
                            g.this.qtT.a(1250, g.this.quK, 2);
                        }
                    }
                }, 3000);
                x.i("MicroMsg.ShakeCardService", "ShakeCardService do not doNetSceneShakeCard, because time is not expire");
                z = false;
            }
            if (!z) {
                return;
            }
            if (this.njJ) {
                x.i("MicroMsg.ShakeCardService", "ShakeCardService is doing netscene, return");
                return;
            } else if (this.gAh == -85.0f || this.gAi == -1000.0f) {
                this.quL = true;
                x.i("MicroMsg.ShakeCardService", "ShakeCardService location is not geted, wait 4 second");
                this.mHandler.postDelayed(new Runnable() {
                    public final void run() {
                        if (!g.this.njJ) {
                            g.this.bsw();
                        }
                    }
                }, 4000);
                return;
            } else {
                bsw();
                return;
            }
        }
        this.qtT.a(1250, (e) obj, 1);
        m.bss().putValue("key_shake_card_item", null);
        x.i("MicroMsg.ShakeCardService", "getlbscard return data is no empty, don't do doNetSceneShakeCard, return ok");
    }

    private void bsw() {
        if (this.njJ) {
            x.i("MicroMsg.ShakeCardService", "ShakeCardService is doing doNetSceneShakeCard, return");
            return;
        }
        this.njJ = true;
        this.quL = false;
        x.i("MicroMsg.ShakeCardService", "ShakeCardService do doNetSceneShakeCard");
        this.quJ = new c(this.gAi, this.gAh, this.kKY, this.jfO);
        as.CN().a(this.quJ, 0);
    }

    public final void pause() {
        atH();
    }

    public final void resume() {
        if (this.hry != null) {
            this.hry.a(this.gAn, true);
        }
    }

    public final void brZ() {
        as.CN().b(1250, (e) this);
        atH();
        super.brZ();
    }

    private void brY() {
        this.hry = c.OV();
        this.hry.a(this.gAn, true);
    }

    private void atH() {
        if (this.hry != null) {
            this.hry.c(this.gAn);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof c) {
            c cVar = (c) kVar;
            e eVar = this.quK;
            e eVar2 = cVar.qun;
            eVar.kRj = eVar2.kRj;
            eVar.kPy = eVar2.kPy;
            eVar.fHQ = eVar2.fHQ;
            eVar.title = eVar2.title;
            eVar.kPB = eVar2.kPB;
            eVar.kPC = eVar2.kPC;
            eVar.kQL = eVar2.kQL;
            eVar.kPA = eVar2.kPA;
            eVar.hdx = eVar2.hdx;
            eVar.quo = eVar2.quo;
            eVar.qur = eVar2.qur;
            eVar.qus = eVar2.qus;
            eVar.qut = eVar2.qut;
            eVar.quu = eVar2.quu;
            eVar.quv = eVar2.quv;
            eVar.ceA = eVar2.ceA;
            eVar.quw = eVar2.quw;
            eVar.qux = eVar2.qux;
            this.kRj = this.quK.kRj;
            x.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd()  action_type:" + this.kRj + "  frequency_level:" + quo + " control_flag:" + this.quK.qur);
            if (i == 0 && i2 == 0) {
                quo = this.quK.quo;
                x.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd is OK ");
                if (this.qtT != null) {
                    this.qtT.a(1250, this.quK, 1);
                }
                bsx();
            } else if (!(i == 5 && i2 == -1) && (i != 4 || i2 == 0)) {
                x.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd errType is " + i + " errCode is " + i2);
                if (this.qtT != null) {
                    this.qtT.a(1250, this.quK, 2);
                }
                bsx();
            } else {
                x.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd errType is " + i + " errCode is " + i2);
                if (this.qtT != null) {
                    this.qtT.a(1250, this.quK, 2);
                }
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                long wv = (long) com.tencent.mm.plugin.shake.c.c.a.wv(com.tencent.mm.plugin.shake.c.c.a.bsK());
                x.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd wait nextInterval is " + wv);
                this.qup = currentTimeMillis + wv;
            }
            m.bss().quo = quo;
            m.bss().qup = this.qup;
            this.njJ = false;
        }
    }

    private void bsx() {
        long wu;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (com.tencent.mm.plugin.shake.c.c.a.wt(quo)) {
            x.i("MicroMsg.ShakeCardService", "ShakeCardService frequency_level is valid");
            wu = (long) com.tencent.mm.plugin.shake.c.c.a.wu(quo);
        } else {
            x.i("MicroMsg.ShakeCardService", "ShakeCardService frequency_level is not valid");
            wu = (long) com.tencent.mm.plugin.shake.c.c.a.wv(com.tencent.mm.plugin.shake.c.c.a.bsK());
        }
        x.i("MicroMsg.ShakeCardService", "ShakeCardService updateWaitingTime wait nextInterval is " + wu);
        this.qup = wu + currentTimeMillis;
    }
}
