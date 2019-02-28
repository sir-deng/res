package com.tencent.mm.plugin.hp.tinker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;

public final class a {
    Handler handler = new Handler(Looper.getMainLooper());

    /* renamed from: com.tencent.mm.plugin.hp.tinker.a$2 */
    class AnonymousClass2 extends BroadcastReceiver {
        final /* synthetic */ Runnable jJe;
        final /* synthetic */ long nGM = 6000;

        AnonymousClass2(Runnable runnable, long j) {
            this.jJe = runnable;
        }

        public final void onReceive(Context context, Intent intent) {
            if ("android.intent.action.SCREEN_OFF".equals(intent == null ? "" : intent.getAction())) {
                com.tencent.tinker.lib.f.a.i("Tinker.ScreenOffRetryPatch", "ScreenOffRetryPatch screen off now, send message now", new Object[0]);
                a.this.handler.postDelayed(this.jJe, this.nGM);
                return;
            }
            com.tencent.tinker.lib.f.a.i("Tinker.ScreenOffRetryPatch", "ScreenOffRetryPatch screen on, remove pending runnable and receive", new Object[0]);
            a.this.handler.removeCallbacks(this.jJe);
            context.unregisterReceiver(this);
        }
    }

    public interface a {
        void aTi();
    }

    public a(Context context, final a aVar) {
        Boolean bm = bm(context);
        com.tencent.tinker.lib.f.a.i("Tinker.ScreenOffRetryPatch", "try post ScreenOffRetryPatch delay time: %d, screen: %b", Long.valueOf(6000), bm);
        IntentFilter intentFilter = new IntentFilter();
        Runnable anonymousClass1 = new Runnable() {
            public final void run() {
                if (aVar != null) {
                    com.tencent.tinker.lib.f.a.i("Tinker.ScreenOffRetryPatch", "ScreenOffRetryPatch runnable try to start", new Object[0]);
                    aVar.aTi();
                }
            }
        };
        if (bm == null || bm.booleanValue()) {
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.SCREEN_ON");
        } else {
            com.tencent.tinker.lib.f.a.i("Tinker.ScreenOffRetryPatch", "screen is just off now, we can send message directly", new Object[0]);
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            this.handler.postDelayed(anonymousClass1, 6000);
        }
        context.registerReceiver(new AnonymousClass2(anonymousClass1, 6000), intentFilter);
    }

    private static Boolean bm(Context context) {
        try {
            return (Boolean) PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager) context.getSystemService("power"), new Object[0]);
        } catch (Exception e) {
            return null;
        }
    }
}
