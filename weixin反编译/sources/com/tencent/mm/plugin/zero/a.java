package com.tencent.mm.plugin.zero;

import com.tencent.mm.j.e;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public final class a implements c, com.tencent.mm.plugin.zero.b.a {
    private e vhe = new e();
    private com.tencent.mm.j.c vhf = new com.tencent.mm.j.c();

    public final e Af() {
        g.Dr();
        g.Do().CA();
        return this.vhe;
    }

    public final com.tencent.mm.j.c Ag() {
        g.Dr();
        g.Do().CA();
        return this.vhf;
    }

    public final void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        if (cVar.gSl) {
            com.tencent.mm.j.c cVar2 = this.vhf;
            File file = new File(com.tencent.mm.compatible.util.e.bnF + "configlist/");
            if (file.exists()) {
                File file2 = new File(com.tencent.mm.j.c.gJO);
                if (!file2.exists()) {
                    x.d("MicroMsg.ConfigListDecoder", "bugfix");
                    cVar2.b(file, file2);
                }
            }
        }
        this.vhe.kt();
        this.vhf.init();
    }

    public final void onAccountRelease() {
    }
}
