package com.tencent.mm.plugin.ipcall.a.a;

import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;

public abstract class a implements e {
    protected int errCode = 0;
    protected int errType = 0;
    public c nIw;
    public a nJa;

    public interface a {
        void a(int i, Object obj, int i2, int i3);

        void b(int i, Object obj, int i2, int i3);
    }

    public abstract int LI();

    public abstract int[] aUq();

    public abstract void aUr();

    public abstract void b(c cVar);

    public abstract void onDestroy();

    public void init() {
        for (int a : aUq()) {
            as.CN().a(a, (e) this);
        }
        aUr();
    }

    public void destroy() {
        for (int b : aUq()) {
            as.CN().b(b, (e) this);
        }
        this.nJa = null;
        onDestroy();
    }

    public void a(c cVar) {
        x.d("MicroMsg.BaseIPCallService", "start service, type: %d", Integer.valueOf(LI()));
        this.nIw = cVar;
        b(this.nIw);
    }

    public void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.BaseIPCallService", "onSceneEnd, errType: %d, errCode: %d, scene.getType: %d, serviceType: %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(kVar.getType()), Integer.valueOf(LI()));
        this.errType = i;
        this.errCode = i2;
        if (i == 0 && i2 == 0) {
            if (this.nJa != null) {
                this.nJa.a(LI(), kVar, i, i2);
            }
        } else if (this.nJa != null) {
            this.nJa.b(LI(), kVar, i, i2);
        }
    }
}
