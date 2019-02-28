package com.tencent.mm.plugin.sns;

import com.tencent.mm.f.a.qi;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.t;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class m extends c<qi> {
    public m() {
        this.xmG = qi.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (((qi) bVar) instanceof qi) {
            x.d("MicroMsg.SnsSyncListener", "NetSceneSnsSync");
            g.Dr();
            g.Dp().gRu.a(new t(), 0);
            return true;
        }
        x.f("MicroMsg.SnsSyncListener", "mismatched event");
        return false;
    }
}
