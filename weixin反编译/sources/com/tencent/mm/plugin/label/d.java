package com.tencent.mm.plugin.label;

import com.tencent.mm.f.a.lw;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;

public final class d extends c<lw> {
    public d() {
        this.xmG = lw.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        as.Hm();
        if (System.currentTimeMillis() - ((Long) com.tencent.mm.y.c.Db().get(209408, Long.valueOf(0))).longValue() > 86400000) {
            x.i("MicroMsg.Label.PostTaskGetContactLabelListener", "cpan[callback] get contact label list.");
            as.CN().a(new com.tencent.mm.plugin.label.b.c(), 0);
            as.Hm();
            com.tencent.mm.y.c.Db().set(209408, Long.valueOf((System.currentTimeMillis() - 86400000) + 1800000));
        }
        return false;
    }
}
