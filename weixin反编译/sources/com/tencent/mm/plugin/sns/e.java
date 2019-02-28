package com.tencent.mm.plugin.sns;

import com.tencent.mm.f.a.ht;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.u;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends c<ht> {
    public e() {
        this.xmG = ht.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ht htVar = (ht) bVar;
        if (htVar instanceof ht) {
            if (htVar.fyV.fvG == 0) {
                g.Dr();
                g.Dp().gRu.a(new u(1), 0);
            } else {
                g.Dr();
                g.Dp().gRu.a(new u(htVar.fyV.fvG), 0);
            }
            return true;
        }
        x.f("MicroMsg.GetSnsTagListListener", "mismatched event");
        return false;
    }
}
