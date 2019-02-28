package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.f;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.task.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;

final class i extends a {
    private static long jEJ = 0;

    i() {
    }

    protected final boolean a(Context context, LaunchParcel launchParcel) {
        String str = launchParcel.appId;
        int i = launchParcel.iNi;
        if (bi.oN(str)) {
            str = f.acm().qZ(launchParcel.username);
        }
        if (!bi.oN(str) && i == 0 && d.uT(str)) {
            AppBrandInitConfig rb = f.acm().rb(str);
            if (rb != null && rb.iIZ == i) {
                rb.iRk = false;
                launchParcel.b(rb);
                k.a(context, rb, launchParcel.jEr);
                return true;
            }
        }
        if (Math.abs(System.currentTimeMillis() - jEJ) < 200) {
            x.w("MicroMsg.AppBrand.Precondition.MMLaunchEntry", "start in 200 ms, just return");
            return false;
        }
        jEJ = bi.Wy();
        x.v("MicroMsg.AppBrand.Precondition.MMLaunchEntry", "[applaunch] start entered %s %d", str, Integer.valueOf(i));
        String str2 = "Token@" + i.class.hashCode() + "#" + System.nanoTime();
        new e(context, str2).a(launchParcel);
        x.v("MicroMsg.AppBrand.Precondition.MMLaunchEntry", "start we app with username(%s) and appId(%s) and statObj(%s)", launchParcel.username, str, launchParcel.jEr);
        Intent intent = new Intent(context, AppBrandLaunchProxyUI.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        intent.putExtra("extra_from_mm", true);
        intent.putExtra("extra_entry_token", str2);
        context.startActivity(intent);
        return true;
    }
}
