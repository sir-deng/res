package com.tencent.mm.console.a;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class j implements a {
    static {
        b.a(new j(), "//warpgate");
    }

    public static void init() {
    }

    public final boolean a(Context context, String[] strArr) {
        int i = 8888;
        if (x.getLogLevel() > 1) {
            return false;
        }
        if (strArr.length < 2) {
            return true;
        }
        String str = strArr[1];
        boolean z = true;
        switch (str.hashCode()) {
            case 3551:
                if (str.equals("on")) {
                    z = false;
                    break;
                }
                break;
            case 109935:
                if (str.equals("off")) {
                    z = true;
                    break;
                }
                break;
            case 3540994:
                if (str.equals("stop")) {
                    z = true;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                r.igC = true;
                r.igB = true;
                break;
            case true:
                r.igC = false;
                r.igB = false;
                break;
            case true:
                if (strArr.length >= 3) {
                    i = bi.getInt(strArr[2], 8888);
                }
                try {
                    Class.forName("com.tencent.mm.plugin.sl_warpgate.server.WarpGateHttpServer").getMethod("startServer", new Class[]{Integer.TYPE}).invoke(null, new Object[]{Integer.valueOf(i)});
                    Toast.makeText(ad.getContext(), "start server on " + i, 1).show();
                    break;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.WarpgateCommand", e, "", new Object[0]);
                    break;
                }
            case true:
                try {
                    Class.forName("com.tencent.mm.plugin.sl_warpgate.server.WarpGateHttpServer").getMethod("stopServer", new Class[0]).invoke(null, new Object[0]);
                    Toast.makeText(ad.getContext(), "stop server", 1).show();
                    break;
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.WarpgateCommand", e2, "", new Object[0]);
                    break;
                }
        }
        return true;
    }
}
