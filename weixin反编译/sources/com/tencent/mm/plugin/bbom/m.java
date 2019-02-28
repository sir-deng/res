package com.tencent.mm.plugin.bbom;

import android.content.SharedPreferences;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.modelsimple.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.y.aj;
import com.tencent.mm.y.as;

public final class m implements e {
    static m kBp;

    public final void a(int i, int i2, String str, k kVar) {
        if (i == 4 && !as.CN().foreground) {
            switch (i2) {
                case -999999:
                    new ag().post(new Runnable() {
                        public final void run() {
                            as.hold();
                            MMAppMgr.md(true);
                        }
                    });
                    return;
                case -311:
                case -310:
                case -205:
                case -72:
                case -9:
                case -6:
                case -4:
                case -3:
                    as.getNotification().er(ad.getContext().getString(R.l.euI));
                    as.hold();
                    return;
                case -140:
                    x.e("MicroMsg.NewSyncErrorProcessor", "alpha need whitelist : [%s]", str);
                    if (bi.oN(str)) {
                        as.getNotification().er(ad.getContext().getString(R.l.euI));
                    } else {
                        as.getNotification().er(str);
                    }
                    as.hold();
                    return;
                case -100:
                    as.getNotification().er(ad.getContext().getString(R.l.euH));
                    d.br(ad.getContext());
                    as.hold();
                    return;
                case -17:
                case -16:
                    SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("system_config_prefs", 0);
                    long j = sharedPreferences.getLong("recomended_update_ignore", -1);
                    if (j == -1 || bi.bz(j) >= 86400) {
                        int i3;
                        aj notification = as.getNotification();
                        if (i2 == -17) {
                            i3 = 2;
                        } else {
                            i3 = 1;
                        }
                        notification.fl(i3);
                        sharedPreferences.edit().putLong("recomended_update_ignore", bi.Wx()).commit();
                        g.pWK.a(405, 27, 1, true);
                        return;
                    }
                    x.d("MicroMsg.NewSyncErrorProcessor", "skip update notification, last check=" + j);
                    return;
                default:
                    return;
            }
        }
    }
}
