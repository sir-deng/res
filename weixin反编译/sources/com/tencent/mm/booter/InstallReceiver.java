package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
public class InstallReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (context != null && intent != null) {
            String action = intent.getAction();
            x.i("MicroMsg.InstallReceiver", "action:[%s]", action);
            if (bi.oN(action) || !action.equals("com.android.vending.INSTALL_REFERRER")) {
                x.e("MicroMsg.InstallReceiver", "action is null or nil, or not the installed action");
                return;
            }
            action = "";
            try {
                action = intent.getStringExtra("referrer");
            } catch (Throwable e) {
                x.e("MicroMsg.InstallReceiver", "%s", bi.i(e));
            }
            x.i("MicroMsg.InstallReceiver", "get referer:[%s]", action);
            if (bi.oN(action)) {
                x.e("MicroMsg.InstallReceiver", "get referer is null or nil");
                return;
            }
            x.d("MicroMsg.InstallReceiver", "[PREF] write installreferer = " + action);
            context.getSharedPreferences(ad.cgf(), 0).edit().putString("installreferer", action).commit();
        }
    }
}
