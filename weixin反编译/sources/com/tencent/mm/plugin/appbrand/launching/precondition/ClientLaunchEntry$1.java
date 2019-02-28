package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

class ClientLaunchEntry$1 extends ResultReceiver {
    final /* synthetic */ c jEB;
    final /* synthetic */ Context val$context;

    ClientLaunchEntry$1(c cVar, Handler handler, Context context) {
        this.jEB = cVar;
        this.val$context = context;
        super(handler);
    }

    protected void onReceiveResult(int i, Bundle bundle) {
        boolean z;
        boolean lj = j.lj(j.jEK);
        boolean z2 = i == -1;
        if ((this.val$context instanceof AppBrandUI) && ((AppBrandUI) this.val$context).jSz) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.AppBrand.Precondition.ClientLaunchEntry", "[appswitch] onReceiveResult, %s, proxyLaunchBack %b, pendingNewIntents %b, handlingNewIntent %b", this.val$context.getClass().getSimpleName(), Boolean.valueOf(z2), Boolean.valueOf(lj), Boolean.valueOf(z));
        if (z2 && !lj && !z) {
            ((MMActivity) this.val$context).moveTaskToBack(true);
        }
    }
}
