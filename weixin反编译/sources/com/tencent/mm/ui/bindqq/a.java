package com.tencent.mm.ui.bindqq;

import com.tencent.mm.f.a.ju;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

public final class a extends c<ju> implements com.tencent.mm.ui.bindqq.b.a {
    private ju yvq;

    public a() {
        this.xmG = ju.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ju juVar = (ju) bVar;
        if (juVar instanceof ju) {
            this.yvq = juVar;
            new b(this.yvq.fBy.fBA, this).crt();
        }
        return false;
    }

    public final boolean t(int i, int i2, String str) {
        if (this.yvq == null) {
            return false;
        }
        if (this.yvq.fBy.fBB == null) {
            this.yvq = null;
            return false;
        } else if (i == 0 && i2 == 0) {
            this.yvq.fBz.fqR = true;
            this.yvq.fBy.fBB.run();
            this.yvq = null;
            return true;
        } else {
            this.yvq.fBz.fqR = false;
            this.yvq.fBy.fBB.run();
            this.yvq = null;
            return false;
        }
    }

    public final void crs() {
        if (this.yvq != null && this.yvq.fBy.fBB != null) {
            this.yvq.fBz.fqR = false;
            this.yvq.fBy.fBB.run();
            this.yvq = null;
        }
    }
}
