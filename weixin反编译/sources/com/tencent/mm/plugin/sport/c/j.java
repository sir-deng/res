package com.tencent.mm.plugin.sport.c;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.booter.MMReceivers.a;
import com.tencent.mm.plugin.appbrand.jsapi.a.g;
import com.tencent.mm.sdk.platformtools.x;

public final class j implements a {
    public final void onReceive(Context context, Intent intent) {
        x.i("MicroMsg.Sport.SportRebootReceiverImpl", "onReceive, save rebootTime = %d %s", Long.valueOf(r0), n.bq(System.currentTimeMillis()));
        i.M(g.CTRL_INDEX, r0);
    }
}
