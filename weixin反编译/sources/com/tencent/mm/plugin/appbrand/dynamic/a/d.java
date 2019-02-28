package com.tencent.mm.plugin.appbrand.dynamic.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.modelappbrand.h;
import com.tencent.mm.plugin.appbrand.appcache.d.a;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.b;
import com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetDebugUI;
import com.tencent.mm.plugin.appbrand.wxawidget.console.e;

public final class d implements h {
    boolean iVT;

    public final void b(Context context, Bundle bundle) {
        Intent intent = new Intent(context, WxaWidgetDebugUI.class);
        String bc = WxaWidgetInitializer.bc(bundle.getString("app_id"), bundle.getString("msg_id"));
        intent.putExtras(bundle);
        intent.putExtra(SlookAirButtonFrequentContactAdapter.ID, bc);
        context.startActivity(intent);
    }

    public final void bf(Context context) {
        e.cl(context);
    }

    public final boolean hi(int i) {
        return a.hi(i);
    }

    public final boolean a(String str, h.a aVar) {
        return b.c(str, aVar);
    }

    public final boolean b(String str, h.a aVar) {
        return b.d(str, aVar);
    }

    public final void bB(boolean z) {
        this.iVT = z;
    }

    public final boolean Jf() {
        return this.iVT;
    }

    public final boolean Jg() {
        return com.tencent.mm.sdk.a.b.cfx();
    }
}
