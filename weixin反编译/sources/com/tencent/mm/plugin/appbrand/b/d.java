package com.tencent.mm.plugin.appbrand.b;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

public abstract class d {
    private final WeakReference<Activity> iKr;
    public final BroadcastReceiver tP = new BroadcastReceiver() {
        final String iKs = "reason";
        final String iKt = "homekey";

        public final void onReceive(Context context, Intent intent) {
            if (intent != null && "android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(intent.getAction())) {
                String stringExtra = intent.getStringExtra("reason");
                if (stringExtra != null) {
                    x.i("MicroMsg.BaseAppBrandUIHomePressReceiver", "[home_pressed] action: %s, reason: %s", intent.getAction(), stringExtra);
                    if (stringExtra.equals("homekey")) {
                        d.this.aaM();
                    }
                }
            }
        }
    };

    public abstract void aaM();

    public d(Activity activity) {
        this.iKr = new WeakReference(activity);
    }
}
