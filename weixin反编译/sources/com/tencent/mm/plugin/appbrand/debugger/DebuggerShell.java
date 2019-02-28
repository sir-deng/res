package com.tencent.mm.plugin.appbrand.debugger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.HashMap;
import java.util.Map;

public final class DebuggerShell extends BroadcastReceiver implements com.tencent.mm.kernel.c.a, b {
    private static boolean iTc = false;
    private final Map<String, a> iTb = new HashMap();

    public interface a {
        String name();

        void t(Intent intent);
    }

    public final void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("action");
        if (!bi.oN(stringExtra) && this.iTb.containsKey(stringExtra)) {
            ((a) this.iTb.get(stringExtra)).t(intent);
        }
    }

    public final void Ea() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.appbrand.debugger");
        ad.getContext().registerReceiver(this, intentFilter);
        a(new b());
        a(new c());
        a(new e());
    }

    public final void Eb() {
        ad.getContext().unregisterReceiver(this);
        this.iTb.clear();
    }

    private void a(a aVar) {
        if (!bi.oN(aVar.name())) {
            this.iTb.put(aVar.name(), aVar);
        }
    }

    public static boolean acx() {
        return iTc;
    }

    public static boolean acy() {
        return iTc || com.tencent.mm.sdk.a.b.cfx();
    }
}
