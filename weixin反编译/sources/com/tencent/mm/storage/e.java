package com.tencent.mm.storage;

import com.tencent.mm.bx.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.y.bb.b;

public abstract class e {
    public static j xuM;
    protected c xuL;

    public abstract String WW(String str);

    protected boolean a(au auVar, b bVar) {
        return true;
    }

    public e(c cVar) {
        this.xuL = cVar;
    }

    public final h aZR() {
        return this.xuL.aZR();
    }

    protected final void a(h hVar, String str) {
        this.xuL.a(hVar, str);
    }

    protected final void a(c.b bVar) {
        this.xuL.a(bVar);
    }

    protected final String Fw(String str) {
        return this.xuL.Fw(str);
    }

    protected final void a(c.c cVar) {
        this.xuL.a(cVar);
    }

    protected final void fG(String str, String str2) {
        this.xuL.b(str, str2, null);
    }
}
