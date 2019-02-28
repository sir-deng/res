package com.tencent.mm.plugin.topstory;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

public final class a implements com.tencent.mm.plugin.topstory.a.a {
    private com.tencent.mm.network.n.a lxb = new com.tencent.mm.network.n.a() {
        public final void eq(int i) {
            final int a = a.this.skk;
            a.this.skk = a.this.bGc();
            if (a.this.skk != a) {
                x.i("MicroMsg.WebSearch.TopStoryConfigImpl", "network change current:%d change:%d", Integer.valueOf(a), Integer.valueOf(a.this.skk));
                ah.y(new Runnable() {
                    public final void run() {
                        if (a.this.ski != null) {
                            a.this.ski.dR(a, a.this.skk);
                        }
                    }
                });
            }
        }
    };
    private boolean skf;
    private boolean skg;
    private int skh = 0;
    private b ski;
    private boolean skj;
    private int skk;

    public final void bFW() {
        this.skf = false;
        this.skk = bGc();
        g.Dp().a(this.lxb);
    }

    public final void ahB() {
        g.Dp().b(this.lxb);
        this.ski = null;
        this.skk = 0;
        this.skf = false;
        this.skg = false;
        this.skh = 0;
    }

    public final boolean aCJ() {
        return this.skk == 1;
    }

    public final boolean bFX() {
        return this.skk == 2;
    }

    public final boolean isConnected() {
        return this.skk != 0;
    }

    public final boolean bFY() {
        return this.skf;
    }

    public final void bFZ() {
        this.skf = true;
    }

    public final void jc(boolean z) {
        this.skg = z;
    }

    public final boolean bGa() {
        return this.skg;
    }

    public final void yG(int i) {
        this.skh = i;
    }

    public final int bGb() {
        return this.skh;
    }

    public final void a(b bVar) {
        this.ski = bVar;
    }

    public final void jd(boolean z) {
        this.skj = z;
        this.skk = bGc();
    }

    private int bGc() {
        if (!com.tinkerboots.sdk.b.a.isConnected(ad.getContext())) {
            return 0;
        }
        if (!com.tinkerboots.sdk.b.a.isWifi(ad.getContext()) || this.skj) {
            return 2;
        }
        return 1;
    }
}
