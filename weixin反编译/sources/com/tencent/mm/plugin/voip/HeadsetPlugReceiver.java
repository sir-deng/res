package com.tencent.mm.plugin.voip;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mm.sdk.platformtools.x;

public class HeadsetPlugReceiver extends BroadcastReceiver {
    private a soM = null;

    public interface a {
        void gc(boolean z);
    }

    public void onReceive(Context context, Intent intent) {
        x.d("MicroMsg.HeadsetPlugReceiver", "headset onReceive %s  %d", intent.getAction(), Integer.valueOf(intent.getIntExtra("state", 0)));
        if (intent.getAction() != null && intent.getAction().equals("android.intent.action.HEADSET_PLUG")) {
            if (intent.getIntExtra("state", 0) == 0) {
                if (this.soM != null) {
                    this.soM.gc(false);
                }
            } else if (intent.getIntExtra("state", 0) == 1 && this.soM != null) {
                this.soM.gc(true);
            }
        }
    }

    public final void a(Context context, a aVar) {
        this.soM = aVar;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        context.registerReceiver(this, intentFilter);
    }

    public final void dB(Context context) {
        try {
            context.unregisterReceiver(this);
        } catch (Exception e) {
            x.e("MicroMsg.HeadsetPlugReceiver", "unregisterReceiver(HeadsetPlugReceiver.this) error:%s", e.getMessage());
        }
        this.soM = null;
    }
}
