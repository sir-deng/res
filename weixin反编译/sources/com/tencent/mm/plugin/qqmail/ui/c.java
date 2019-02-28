package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.os.Looper;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.ju;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.y.as;
import com.tencent.mm.y.be;

public final class c implements e {
    private static long pzA = 0;
    private Activity fBA;
    private a pzB;

    public static abstract class a {
        public abstract void blc();

        public abstract void bld();
    }

    static /* synthetic */ void a(c cVar) {
        if (System.currentTimeMillis() - pzA > 600000) {
            if (as.Hp()) {
                as.CN().a(new be(new com.tencent.mm.y.be.a() {
                    public final void a(com.tencent.mm.network.e eVar) {
                        if (eVar != null) {
                            eVar.KD().v(new byte[0], eVar.KD().Cn());
                            com.tencent.mm.plugin.qqmail.a.a.ihO.un();
                        }
                    }
                }), 0);
            }
        } else if (cVar.pzB != null) {
            cVar.pzB.bld();
        }
    }

    public c(Activity activity) {
        as.CN().a(138, (e) this);
        this.fBA = activity;
    }

    public final void a(a aVar) {
        this.pzB = aVar;
        final b juVar = new ju();
        juVar.fBy.fBA = this.fBA;
        juVar.fBy.fBB = new Runnable() {
            public final void run() {
                if (juVar.fBz.fqR) {
                    c.a(c.this);
                } else if (c.this.pzB != null) {
                    c.this.pzB.bld();
                }
            }
        };
        com.tencent.mm.sdk.b.a.xmy.a(juVar, Looper.myLooper());
    }

    public final void release() {
        as.CN().b(138, (e) this);
    }

    protected final void finalize() {
        release();
        super.finalize();
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            if (this.pzB != null) {
                this.pzB.blc();
                this.pzB = null;
            }
        } else if (this.pzB != null) {
            this.pzB.bld();
            this.pzB = null;
        }
        pzA = System.currentTimeMillis();
    }
}
