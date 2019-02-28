package com.tencent.mm.pluginsdk.d;

import com.tencent.mm.f.a.je;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;

public abstract class d implements a {
    public int vjx = 0;

    public abstract b CH(String str);

    public abstract j aRS();

    public final void abp() {
        if (this.vjx == 0) {
            j aRS = aRS();
            if (aRS != null) {
                aRS.c(this);
            }
        }
        this.vjx++;
    }

    public final void unregister() {
        if (this.vjx != 0) {
            this.vjx--;
            if (this.vjx == 0) {
                j aRS = aRS();
                if (aRS != null) {
                    aRS.j(this);
                }
            }
        }
    }

    public final void a(String str, l lVar) {
        b jeVar = new je();
        jeVar.fAC.fAD = CH(str);
        com.tencent.mm.sdk.b.a.xmy.m(jeVar);
    }
}
