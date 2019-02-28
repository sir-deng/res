package com.tencent.mm.plugin.downloader.intentservice;

import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.v4.app.z.d;
import com.tencent.mm.plugin.notification.b;

public class DownloadReceiver extends ResultReceiver {
    private static final String TAG = DownloadReceiver.class.getSimpleName();
    private d lxg;

    protected void onReceiveResult(int i, Bundle bundle) {
        super.onReceiveResult(i, bundle);
        if (i == 4657) {
            int i2 = bundle.getInt("progress");
            if (b.oZq != null) {
                if (i2 < 100) {
                    this.lxg.a(100, i2, false).b("Download in progress:" + i2);
                    b.oZq.notify(4657, this.lxg.build());
                    return;
                }
                this.lxg.a(0, 0, false).b("Download Complete");
                b.oZq.notify(4658, this.lxg.build());
            }
        }
    }
}
