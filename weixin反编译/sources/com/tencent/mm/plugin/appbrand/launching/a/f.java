package com.tencent.mm.plugin.appbrand.launching.a;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.n.e;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class f implements e {
    private static final int[] jEm = new int[]{1025, 1031, 1032};
    private static final int[] jEn = new int[]{HardCoderJNI.FUNC_REG_PRELOAD_BOOT_RESOURCE, HardCoderJNI.FUNC_TERMINATE_APP, HardCoderJNI.FUNC_UNIFY_CPU_IO_THREAD_CORE, 1047, 1049, 1048, 1050};
    private final d jEo = new d();
    private final e jEp = new e();
    private final c jEq = new c();

    public final boolean tG(String str) {
        if (bi.oN(str)) {
            return false;
        }
        b bVar;
        x.i("MicroMsg.WeAppLinkOpener", "handle appLink = %s", str);
        for (b bVar2 : b.values()) {
            int i;
            if (bi.oN(str) || !str.startsWith(bVar2.hNW)) {
                boolean i2 = false;
            } else {
                i2 = 1;
            }
            if (i2 != 0) {
                bVar = bVar2;
                break;
            }
        }
        bVar = null;
        if (bVar == null) {
            return false;
        }
        Uri parse;
        try {
            parse = Uri.parse(str);
        } catch (Exception e) {
            x.e("MicroMsg.WeAppLinkOpener", "handle nativeLink = %s, exp = %s", str, e);
            parse = null;
        }
        if (parse == null) {
            return false;
        }
        String queryParameter = parse.getQueryParameter("username");
        String queryParameter2 = parse.getQueryParameter("path");
        if (bi.oN(queryParameter) || !com.tencent.mm.storage.x.fX(queryParameter)) {
            return false;
        }
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = bVar.scene;
        appBrandStatObject.foi = b.aiK();
        appBrandStatObject.fJn = b.aiL();
        appBrandStatObject.fJo = b.aiM();
        AppBrandLaunchProxyUI.a(null, queryParameter, queryParameter2, 0, -1, appBrandStatObject, null);
        return true;
    }

    public final boolean b(Context context, String str, int i, Bundle bundle) {
        if (a.b(jEm, i)) {
            if (a.jEd == this.jEo.a(context, str, i, bundle)) {
                return true;
            }
            return false;
        } else if (a.b(jEn, i)) {
            if (a.jEd != this.jEp.a(context, str, i, bundle)) {
                return false;
            }
            return true;
        } else if (1064 != i && 1078 != i) {
            x.e("MicroMsg.WeAppLinkOpener", "handleScanCodeLink, unhandled case link[ %s ], scene[ %d ]", str, Integer.valueOf(i));
            return false;
        } else if (a.jEd != this.jEq.a(context, str, i, bundle)) {
            return false;
        } else {
            return true;
        }
    }
}
