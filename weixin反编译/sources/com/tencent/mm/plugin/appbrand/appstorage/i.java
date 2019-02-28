package com.tencent.mm.plugin.appbrand.appstorage;

import android.os.Build.VERSION;
import android.system.Os;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

final class i {

    static final class a {
        a() {
        }
    }

    static boolean aS(String str, String str2) {
        if (VERSION.SDK_INT >= 21) {
            try {
                long Wy = bi.Wy();
                a aVar = new a();
                Os.rename(str, str2);
                x.d("MicroMsg.AppBrand.FileMove", "move, os rename works, cost = %d", Long.valueOf(bi.Wy() - Wy));
                return true;
            } catch (Throwable e) {
                x.e("MicroMsg.AppBrand.FileMove", "move, os rename exp = %s", bi.i(e));
            }
        }
        return new File(str).renameTo(new File(str2));
    }
}
