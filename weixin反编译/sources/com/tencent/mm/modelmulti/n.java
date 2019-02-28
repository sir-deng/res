package com.tencent.mm.modelmulti;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class n {
    Boolean hHX = null;

    public interface a {
        void bQ(boolean z);
    }

    /* renamed from: com.tencent.mm.modelmulti.n$1 */
    class AnonymousClass1 extends BroadcastReceiver {
        final /* synthetic */ a hHY;
        final /* synthetic */ boolean hHZ = false;

        AnonymousClass1(a aVar, boolean z) {
            this.hHY = aVar;
        }

        public final void onReceive(Context context, Intent intent) {
            x.i("MicroMsg.ScreenState", "ScreenReceiver action [%s] ", intent == null ? "" : intent.getAction());
            if ("android.intent.action.SCREEN_OFF".equals(intent == null ? "" : intent.getAction())) {
                n.this.hHX = Boolean.valueOf(false);
            } else {
                n.this.hHX = Boolean.valueOf(true);
            }
            if (this.hHY != null) {
                this.hHY.bQ(n.this.hHX.booleanValue());
            }
            if (this.hHZ) {
                context.unregisterReceiver(this);
            }
        }
    }

    public n(Context context, a aVar) {
        this.hHX = bm(context);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.registerReceiver(new AnonymousClass1(aVar, false), intentFilter);
    }

    private Boolean bm(Context context) {
        try {
            x.i("MicroMsg.ScreenState", "reflectScreenOn: byReflect:%s isScreenOn:%s", (Boolean) PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager) context.getSystemService("power"), new Object[0]), this.hHX);
            return (Boolean) PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager) context.getSystemService("power"), new Object[0]);
        } catch (Throwable e) {
            g.pWK.a(99, 154, 1, false);
            x.e("MicroMsg.ScreenState", "reflectScreenOn invoke ERROR use isScreenOn:%s e:%s", this.hHX, bi.i(e));
            return null;
        }
    }
}
