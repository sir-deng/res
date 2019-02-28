package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.c.bzs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.y.q;
import java.io.IOException;

public final class e extends c {
    protected final void send() {
        int size = ((h) g.h(h.class)).aZO().aZV().size();
        bzs bzs = new bzs();
        bzs.npU = a.bPh().tom.Om(q.FY()).id;
        bzs.fpg = ad.getContext().getString(R.l.app_name);
        bzs.noL = ad.getContext().getString(R.l.eyH, new Object[]{Integer.valueOf(size)});
        try {
            a.bPh();
            r.a(20005, bzs.toByteArray(), true);
        } catch (IOException e) {
        }
    }

    public final String getName() {
        return "WearFailMsgCreateTask";
    }
}
