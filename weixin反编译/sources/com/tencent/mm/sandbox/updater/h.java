package com.tencent.mm.sandbox.updater;

import com.tencent.mm.f.a.sh;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

public final class h extends c<sh> {
    public h() {
        this.xmG = sh.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        sh shVar = (sh) bVar;
        if (shVar instanceof sh) {
            Updater c = Updater.c(shVar.fKP.context, null);
            if (c != null) {
                c.ac(shVar.fKP.type, true);
            }
        }
        return false;
    }
}
