package com.tencent.mm.plugin.hp;

import com.tencent.mm.app.MMApplicationLike;
import com.tencent.mm.f.a.bc;
import com.tencent.mm.f.a.be;
import com.tencent.mm.plugin.hp.b.c;
import com.tencent.mm.plugin.hp.tinker.d;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;

public final class a implements p {
    private c nGd = new c();
    private com.tencent.mm.sdk.b.c<be> nGe = new com.tencent.mm.sdk.b.c<be>() {
        {
            this.xmG = be.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            be beVar = (be) bVar;
            if (29 == beVar.fqo.fqg && beVar.fqo.fql == 0) {
                x.d("Tinker.HotPatchApplication", "hp_res received new hotpatch cache request");
                com.tencent.mm.plugin.hp.b.b.rz(0);
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c<bc> nGf = new com.tencent.mm.sdk.b.c<bc>() {
        {
            this.xmG = bc.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            bc bcVar = (bc) bVar;
            if (29 == bcVar.fqf.fqg && bcVar.fqf.fqj) {
                x.d("Tinker.HotPatchApplication", "hp_res received new/updated download resource, path=%s", bcVar.fqf.filePath);
                com.tencent.mm.plugin.hp.b.b.rA(0);
                c.Db(bcVar.fqf.filePath);
            }
            return false;
        }
    };

    public a() {
        d.aTk();
        d.a(MMApplicationLike.getTinkerApplicationLike());
        com.tencent.mm.sdk.b.a.xmy.b(this.nGd);
        com.tencent.mm.sdk.b.a.xmy.b(this.nGf);
        com.tencent.mm.sdk.b.a.xmy.b(this.nGe);
    }

    public final void a(n nVar) {
    }

    public final void a(m mVar) {
    }
}
