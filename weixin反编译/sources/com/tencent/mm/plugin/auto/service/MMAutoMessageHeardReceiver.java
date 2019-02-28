package com.tencent.mm.plugin.auto.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public class MMAutoMessageHeardReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String j = t.j(intent, "key_username");
        if (j != null) {
            x.i("MicroMsg.auto.MMAutoMessageHeardReceiver", "username %s heard", j);
            as.getNotification().cancelNotification(j);
            as.Hm();
            c.Fk().XH(j);
        }
    }
}
