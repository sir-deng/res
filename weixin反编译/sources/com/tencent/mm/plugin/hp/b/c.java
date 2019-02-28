package com.tencent.mm.plugin.hp.b;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.f.a.ig;
import com.tencent.mm.plugin.hp.d.a;
import com.tencent.mm.plugin.hp.tinker.d;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends com.tencent.mm.sdk.b.c<ig> implements com.tencent.mm.sdk.f.c {
    private static final String hGc = (e.hbv + "_temp.hp");
    private a nGl = null;

    public c() {
        com.tencent.mm.sdk.f.e.a((com.tencent.mm.sdk.f.c) this);
        this.xmG = ig.class.getName().hashCode();
    }

    public static void Db(String str) {
        x.w("Tinker.HotPatchApplyService", "hp_apply from file %s", str);
        d.Dc(str);
    }

    public final void z(Runnable runnable) {
        if (runnable == this.nGl) {
            x.d("Tinker.HotPatchApplyService", "hp_apply download url=%s, file=%s, failed=%b", this.nGl.url, this.nGl.ieO, Boolean.valueOf(this.nGl.hmT));
            if (this.nGl.hmT) {
                b.rB(1);
            } else {
                b.rA(1);
                Db(this.nGl.ieO);
            }
            this.nGl = null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(com.tencent.mm.f.a.ig r7) {
        /*
        r6 = this;
        r5 = 1;
        r4 = 0;
        r0 = r6.nGl;
        if (r0 == 0) goto L_0x0010;
    L_0x0006:
        r0 = "Tinker.HotPatchApplyService";
        r1 = "hp_apply processing busy, ignore new event";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
    L_0x000f:
        return r4;
    L_0x0010:
        r0 = r7.fzy;
        r0 = r0.fql;
        if (r5 != r0) goto L_0x001a;
    L_0x0016:
        com.tencent.mm.plugin.hp.tinker.d.aTl();
        goto L_0x000f;
    L_0x001a:
        r0 = r7.fzy;
        r0 = r0.fzD;
        if (r0 == 0) goto L_0x0028;
    L_0x0020:
        r0 = r7.fzy;
        r0 = r0.fzD;
        Db(r0);
        goto L_0x000f;
    L_0x0028:
        com.tencent.mm.plugin.hp.b.b.rz(r5);
        r0 = r7.fzy;
        r0 = r0.fzB;
        if (r0 == 0) goto L_0x0043;
    L_0x0031:
        r0 = r7.fzy;	 Catch:{ Error -> 0x009f }
        r0 = r0.fzB;	 Catch:{ Error -> 0x009f }
        r1 = 0;
        r0 = android.util.Base64.decode(r0, r1);	 Catch:{ Error -> 0x009f }
        r1 = r7.fzy;	 Catch:{ Error -> 0x009f }
        r2 = new java.lang.String;	 Catch:{ Error -> 0x009f }
        r2.<init>(r0);	 Catch:{ Error -> 0x009f }
        r1.fzB = r2;	 Catch:{ Error -> 0x009f }
    L_0x0043:
        r0 = r7.fzy;
        r0 = r0.fzB;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r0 != 0) goto L_0x0089;
    L_0x004d:
        r0 = r7.fzy;
        r0 = r0.fzC;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r0 != 0) goto L_0x0089;
    L_0x0057:
        r0 = "Tinker.HotPatchApplyService";
        r1 = "hp_apply request url=%s, signature=%s";
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r3 = r7.fzy;
        r3 = r3.fzB;
        r2[r4] = r3;
        r3 = r7.fzy;
        r3 = r3.fzC;
        r2[r5] = r3;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
        r0 = new com.tencent.mm.plugin.hp.d.a;
        r1 = r7.fzy;
        r1 = r1.fzB;
        r2 = hGc;
        r3 = r7.fzy;
        r3 = r3.fzC;
        r0.<init>(r1, r2, r3);
        r6.nGl = r0;
    L_0x0080:
        r0 = r6.nGl;
        r1 = "hp_apply_download";
        com.tencent.mm.sdk.f.e.post(r0, r1);
        goto L_0x000f;
    L_0x0089:
        r0 = r7.fzy;
        r0 = r0.fzz;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r0 != 0) goto L_0x000f;
    L_0x0093:
        r0 = r7.fzy;
        r0 = r0.fzA;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r0 == 0) goto L_0x0080;
    L_0x009d:
        goto L_0x000f;
    L_0x009f:
        r0 = move-exception;
        goto L_0x0043;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.hp.b.c.a(com.tencent.mm.f.a.ig):boolean");
    }
}
