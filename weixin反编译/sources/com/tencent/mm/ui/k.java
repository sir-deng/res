package com.tencent.mm.ui;

import android.app.Activity;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;

public final class k {
    public static void a(final Activity activity, final int i, final int i2, String str) {
        e.post(new Runnable() {
            public final void run() {
                Activity activity = activity;
                int i = i;
                int i2 = i2;
                x.i("MicroMsg.LauncherUI.HomeUtil", "clickFlowStat index:%d op:%d %s", Integer.valueOf(i2), Integer.valueOf(i), t.WB());
                if (i2 >= 0) {
                    String str = "MainUI";
                    if (i2 == 1) {
                        str = "AddressUI";
                    }
                    if (i2 == 2) {
                        str = "FindMoreFriendUI";
                    }
                    if (i2 == 3) {
                        str = "MoreTabUI";
                    }
                    d.b(i, str, ((activity.hashCode() / 16) * 16) + i2);
                }
            }
        }, str);
    }
}
